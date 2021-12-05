package br.beta.eletron.rankup;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import br.beta.eletron.rankup.api.ConfigAPI;
import br.beta.eletron.rankup.api.StorageAPI;
import br.beta.eletron.rankup.command.RankUPCommand;
import br.beta.eletron.rankup.manager.RankUP;
import br.beta.eletron.rankup.manager.RankUPAPI;
import br.beta.eletron.rankup.manager.RankUPManager;

public class Main extends JavaPlugin {

	public static Main instance;

	@Override
	public void onEnable() {
		instance = this;
		StorageAPI.register(RankUP.class);
		StorageAPI.register(RankUPManager.class);
		getCommand("rankup").setExecutor(new RankUPCommand());
		getCommand("ranks").setExecutor(new RankUPCommand());
		RankUPAPI.reload();
		new BukkitRunnable() {
			
			@Override
			public void run() {
				RankUPAPI.save();
			}
		}.runTaskTimerAsynchronously(this, 20*5, 20*5);
	}

	@Override
	public void onDisable() {
		RankUPAPI.save();
	}

}
