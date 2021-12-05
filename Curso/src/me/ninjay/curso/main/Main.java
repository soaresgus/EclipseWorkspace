package me.ninjay.curso.main;


import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


import me.ninjay.curso.api.ComandoBarAPI;
import me.ninjay.curso.apipersonalizada.SimplesConfig;
import me.ninjay.curso.caixa.Caixa;
import me.ninjay.curso.caixa.CaixaAPI;
import me.ninjay.curso.caixa.CaixaControler;
import me.ninjay.curso.caixa.CaixaManager;
import me.ninjay.curso.caixa.CaixaMisteriosaBásica;
import me.ninjay.curso.caixa.ComandoDarCaixa;
import me.ninjay.curso.cash.ComandoCash;
import me.ninjay.curso.cash.Loja;
import me.ninjay.curso.licenca.Licence;
import me.ninjay.curso.nms.ComandoNpc;
import me.ninjay.curso.nms.EventosMorrer;
import me.ninjay.curso.outros.EventoJoin;
import me.ninjay.curso.scoreboard.EventosScore;
import me.ninjay.curso.scoreboard.SimplesScore;
import me.ninjay.curso.spawn.ComandoSetSpawn;
import me.ninjay.curso.spawn.ComandoSpawn;
import me.ninjay.curso.tempo.ComandoCooldown;
import me.ninjay.curso.tempo.ComandoCooldown2;
import me.ninjay.curso.tempo.ComandoDelay;
import me.ninjay.curso.tempo.ComandoTimer;
import net.eduard.api.lib.BukkitConfig;
import net.eduard.api.lib.storage.StorageAPI;

public class Main extends JavaPlugin implements Listener{
	public static BukkitConfig config;
	public static BukkitConfig cash;
	public static SimplesConfig teste;
	public static BukkitConfig score;
	public static Main getmain() {
		return (Main) Bukkit.getPluginManager().getPlugin("Curso");
	}
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§6Curso ativado com sucesso !");
		config = new BukkitConfig("config.yml",this);
		cash = new BukkitConfig("cash.yml", this);
		cash.saveConfig();
		config.saveConfig();
		teste = new SimplesConfig("teste.yml", this);
		teste.saveConfig();
		score = new BukkitConfig("score.yml", this);
		score.saveConfig();
		getCommand("setspawn").setExecutor(new ComandoSetSpawn());
		getCommand("spawn").setExecutor(new ComandoSpawn());
		getCommand("delay").setExecutor(new ComandoDelay());
		getCommand("cooldown").setExecutor(new ComandoCooldown());
		getCommand("cooldown2").setExecutor(new ComandoCooldown2());
		getCommand("timer").setExecutor(new ComandoTimer());
		Bukkit.getPluginManager().registerEvents(new CaixaMisteriosaBásica(), this);
		SimplesScore.ligar(this);
		Bukkit.getPluginManager().registerEvents(new EventosScore(), this);
		StorageAPI.register(Caixa.class);
		StorageAPI.register(CaixaManager.class);
		CaixaAPI.reload();
		Bukkit.getPluginManager().registerEvents(new CaixaControler(), this);
		Bukkit.getPluginManager().registerEvents(new EventoJoin(), this);
		getCommand("givecaixa").setExecutor(new ComandoDarCaixa());
		getCommand("cash").setExecutor(new ComandoCash());
		getCommand("loja").setExecutor(new Loja());
		getCommand("barapicmd").setExecutor(new ComandoBarAPI());
		Bukkit.getPluginManager().registerEvents(new EventosMorrer(), this);
		getCommand("npc").setExecutor(new ComandoNpc());
        Bukkit.getPluginManager().registerEvents(this, this);
        Licence.BukkitTester.test(this, new Runnable() {
        
			@Override
			public void run() {
				Bukkit.getConsoleSender().sendMessage("§eTanto faz");
				
			}
		});

	}
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§6Curso desativado com sucesso !");
	}

}
