package me.ninjay.safeclub.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.nametagedit.plugin.NametagEdit;

import me.ninjay.safeclub.comandos.essentials.ComandoLobby;
import me.ninjay.safeclub.comandos.essentials.ComandoSetSpawn;
import me.ninjay.safeclub.comandos.essentials.ComandoSpawn;
import me.ninjay.safeclub.comandos.kit.ComandoKit;
import me.ninjay.safeclub.comandos.kit.EventosKit;
import me.ninjay.safeclub.comandos.recompensa.ComandoRecompensa;
import me.ninjay.safeclub.estruturas.api.caixa.Caixa;
import me.ninjay.safeclub.estruturas.api.caixa.CaixaAPI;
import me.ninjay.safeclub.estruturas.api.caixa.CaixaControler;
import me.ninjay.safeclub.estruturas.api.caixa.CaixaManager;
import me.ninjay.safeclub.estruturas.api.caixa.ComandoDarCaixa;
import me.ninjay.safeclub.estruturas.api.cash.ComandoCash;
import me.ninjay.safeclub.estruturas.api.eventos.ComandoEvento;
import me.ninjay.safeclub.estruturas.api.eventos.ComandoGladiator;
import me.ninjay.safeclub.estruturas.api.eventos.Evento;
import me.ninjay.safeclub.estruturas.api.eventos.EventoAPI;
import me.ninjay.safeclub.estruturas.api.eventos.EventoManager;
import me.ninjay.safeclub.estruturas.api.eventos.EventosEvento;

import me.ninjay.safeclub.estruturas.score.SimplesScore;
import me.ninjay.safeclub.eventos.geral.EventosGeral;
import me.ninjay.safeclub.utils.BukkitConfig;
import me.ninjay.safeclub.utils.StorageAPI;
import me.ninjay.safeclub.utils.VaultAPI;

public class Main extends JavaPlugin{

	public static BukkitConfig cooldowns;
	public static BukkitConfig locais;
	public static BukkitConfig config;
	public static BukkitConfig cash;
	
	@Override
	public void onEnable() {
		// EVENTOS
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		Bukkit.getPluginManager().registerEvents(new SimplesScore(), this);
		// EVENTO
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		SimplesScore.ligar(this);

		// RECOMPENSAS
		getCommand("recompensa").setExecutor(new ComandoRecompensa());
		cooldowns = new BukkitConfig("cooldowns.yml", this);
		cooldowns.saveConfig();
		// RECOMPENSAS

		// ESSENTIALS
		getCommand("lobby").setExecutor(new ComandoLobby());
		getCommand("setspawn").setExecutor(new ComandoSetSpawn());
		getCommand("spawn").setExecutor(new ComandoSpawn());
		// ESSENTIALS

		// EVENTOS API
		StorageAPI.register(Evento.class);
		StorageAPI.register(EventoManager.class);
		EventoAPI.reload();
		getCommand("evento").setExecutor(new ComandoEvento());
		getCommand("gladiator").setExecutor(new ComandoGladiator());
		Bukkit.getPluginManager().registerEvents(new EventosEvento(), this);
		locais = new BukkitConfig("locais.yml", this);
		locais.saveConfig();
		// EVENTOS API

		// CAIXA API
		StorageAPI.register(Caixa.class);
		StorageAPI.register(CaixaManager.class);
		CaixaAPI.reload();
		Bukkit.getPluginManager().registerEvents(new CaixaControler(), this);
		getCommand("darcaixa").setExecutor(new ComandoDarCaixa());
		// CAIXA API

		// KIT API
		getCommand("kit").setExecutor(new ComandoKit());
		Bukkit.getPluginManager().registerEvents(new EventosKit(), this);
		config = new BukkitConfig("kitc.yml", Main.getPlugin(Main.class));
		config.saveConfig();
		// KIT API
		
		// CASH API
		cash = new BukkitConfig("cash.yml", this);
		cash.saveConfig();
		getCommand("cash").setExecutor(new ComandoCash());
		// CASH API
		
		new BukkitRunnable() {

			@Override
			public void run() {
				for (Player todos : Bukkit.getOnlinePlayers()) {
					if (VaultAPI.getPermission().playerInGroup(todos, "vipninja")) {
						NametagEdit.getApi().setPrefix(todos, "§5[Ninja] ");
						return;

					}else {
						NametagEdit.getApi().setPrefix(todos, "");
					}
					if (VaultAPI.getPermission().playerInGroup(todos, "vipsafe")) {
						NametagEdit.getApi().setPrefix(todos, "§6[Safe] ");
						return;
					}else {
						NametagEdit.getApi().setPrefix(todos, "");
					}
					
				}
			}
		}.runTaskTimerAsynchronously(this, 20 * 10, 20 * 10);
	}

}
