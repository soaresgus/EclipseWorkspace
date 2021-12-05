package me.ninjay.safeclublobby.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.safeclublobby.comandos.ComandoConnect;
import me.ninjay.safeclublobby.comandos.ComandoLogin;
import me.ninjay.safeclublobby.comandos.ComandoRegister;
import me.ninjay.safeclublobby.comandos.ComandoSetSpawn;
import me.ninjay.safeclublobby.comandos.ComandoTrocarSenha;
import me.ninjay.safeclublobby.estruturas.SimplesScore;
import me.ninjay.safeclublobby.eventos.EventosLobby;
import me.ninjay.safeclublobby.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventosLobby(), this);
	    Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		SimplesScore.ligar(this);
		Bukkit.getPluginManager().registerEvents(new SimplesScore(), this);
		getCommand("login").setExecutor(new ComandoLogin());
		getCommand("register").setExecutor(new ComandoRegister());
		getCommand("trocarsenha").setExecutor(new ComandoTrocarSenha());
		getCommand("conectar").setExecutor(new ComandoConnect());
		getCommand("setspawn").setExecutor(new ComandoSetSpawn());
		config = new BukkitConfig("locais.yml", this);
		config.saveConfig();
	}
	 
}