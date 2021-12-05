package me.ninjay.olympiclobby.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.olympiclobby.comandos.ComandoConnect;
import me.ninjay.olympiclobby.comandos.ComandoLogin;
import me.ninjay.olympiclobby.comandos.ComandoRegister;
import me.ninjay.olympiclobby.comandos.ComandoSetSpawn;
import me.ninjay.olympiclobby.comandos.ComandoTrocarSenha;
import me.ninjay.olympiclobby.estruturas.SimplesScore;
import me.ninjay.olympiclobby.eventos.EventosGlobal;
import me.ninjay.olympiclobby.utils.BukkitConfig;


public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	
	@Override
	public void onEnable() {
		getCommand("login").setExecutor(new ComandoLogin());
		getCommand("register").setExecutor(new ComandoRegister());
		getCommand("trocarsenha").setExecutor(new ComandoTrocarSenha());
		getCommand("conectar").setExecutor(new ComandoConnect());
		getCommand("setspawn").setExecutor(new ComandoSetSpawn());
		Bukkit.getPluginManager().registerEvents(new EventosGlobal(), this);
		config = new BukkitConfig("locais.yml", this);
		config.saveConfig();
	    Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		SimplesScore.ligar(this);
		Bukkit.getPluginManager().registerEvents(new SimplesScore(), this);
	}

}
