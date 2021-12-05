package me.ninjay.ninjaexplosion.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

import me.ninjay.ninjaexplosion.utils.ApiCommand;
import me.ninjay.ninjaexplosion.utils.BukkitBungeeAPI;
import me.ninjay.ninjaexplosion.utils.BukkitController;
import me.ninjay.ninjaexplosion.utils.BukkitReplacers;
import me.ninjay.ninjaexplosion.utils.BukkitStorables;
import me.ninjay.ninjaexplosion.utils.BungeeAPI;
import me.ninjay.ninjaexplosion.utils.Config;
import me.ninjay.ninjaexplosion.utils.ConfigCommand;
import me.ninjay.ninjaexplosion.utils.DBManager;
import me.ninjay.ninjaexplosion.utils.DropManager;
import me.ninjay.ninjaexplosion.utils.EduardPlugin;
import me.ninjay.ninjaexplosion.utils.EnchantCommand;
import me.ninjay.ninjaexplosion.utils.EssentialsEvents;
import me.ninjay.ninjaexplosion.utils.GotoCommand;
import me.ninjay.ninjaexplosion.utils.InfoGenerator;
import me.ninjay.ninjaexplosion.utils.MapCommand;
import me.ninjay.ninjaexplosion.utils.Mine;
import me.ninjay.ninjaexplosion.utils.PlayersManager;
import me.ninjay.ninjaexplosion.utils.PluginValor;
import me.ninjay.ninjaexplosion.utils.SoundCommand;
import me.ninjay.ninjaexplosion.utils.StorageAPI;


public class EduardAPI extends EduardPlugin{
	
	private static EduardAPI plugin;

	public static EduardAPI getInstance() {
		return plugin;
	}

	public Config getMessages() {
		return messages;
	}
	public Config getConfigs() {
		return config;
	}

	public void onLoad() {

	}

	public void onEnable() {
		plugin = this;
		setFree(true);
		// BukkitControl.register(this);
		// BukkitAPI.register(this);
		config = new Config(this, "config.yml");
		messages = new Config(this, "messages.yml");
		BukkitBungeeAPI.requestCurrentServer();
		BukkitController bukkit = BungeeAPI.getBukkit();
		bukkit.setPlugin(plugin);
		bukkit.register();
		StorageAPI.setDebug(config.getBoolean("debug-storage"));
		DBManager.setDebug(config.getBoolean("debug-db"));

		StorageAPI.registerPackage(getClass(), "net.eduard.api.lib.game");
		StorageAPI.registerPackage(getClass(), "net.eduard.api.lib.menu");
		StorageAPI.registerPackage(getClass(), "net.eduard.api.lib.manager");
		StorageAPI.registerPackage(getClass(), "net.eduard.api.command");
		StorageAPI.registerPackage(getClass(), "net.eduard.api.server");
		StorageAPI.registerClasses(Mine.class);

		BukkitStorables.load();
		Mine.resetScoreboards();
		BukkitReplacers.registerRplacers();
		asyncTimer(new Runnable() {

			@Override
			public void run() {
				Mine.updateTargets();
			}
		}, 20, 20);
		new ApiCommand().register();
		new MapCommand().register();
		new ConfigCommand().register();
		new EnchantCommand().register();
		new GotoCommand().register();
		new SoundCommand().register();
		new EssentialsEvents().register(this);
		InfoGenerator.saveObjects(this);
		new DropManager().register(this);

		Mine.loadMaps();

		config.saveConfig();
		Mine.OPT_AUTO_RESPAWN = config.getBoolean("auto-respawn");
		Mine.OPT_NO_JOIN_MESSAGE = config.getBoolean("no-join-message");
		Mine.OPT_NO_QUIT_MESSAGE = config.getBoolean("no-quit-message");
		Mine.OPT_NO_DEATH_MESSAGE = config.getBoolean("no-death-message");

		Mine.MSG_ON_JOIN = config.message("on-join-message");
		Mine.MSG_ON_QUIT = config.message("on-quit-message");
		if (config.getBoolean("auto-rejoin")) {
			for (Player p : Mine.getPlayers()) {
				Mine.callEvent(new PlayerJoinEvent(p, null));
			}
		}

		Mine.setPlayerManager(new PlayersManager());
		Mine.getPlayerManager().register(this);

		PluginValor.register();
		Mine.console("§6[NinjaUtils] §aUtils ativada com sucesso!");
	}

	@Override
	public void onDisable() {
		Mine.saveMaps();
		BungeeAPI.getController().unregister();
	}



}