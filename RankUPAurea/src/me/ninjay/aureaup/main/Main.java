package me.ninjay.aureaup.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.aureaup.comandos.ComandoLogin;
import me.ninjay.aureaup.comandos.ComandoRegister;
import me.ninjay.aureaup.comandos.ComandoTrocarSenha;
import me.ninjay.aureaup.estruturas.ClassesAPI;
import me.ninjay.aureaup.estruturas.LoginAPI;
import me.ninjay.aureaup.eventos.EventosGlobal;
import me.ninjay.aureaup.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig senhas;
	public static BukkitConfig classes;
	
	@Override
	public void onEnable() {
		senhas = new BukkitConfig("senhas.yml", this);
		senhas.saveConfig();
		
		classes = new BukkitConfig("classes.yml", this);
		classes.saveConfig();
		
		Bukkit.getPluginManager().registerEvents(new EventosGlobal(), this);
		Bukkit.getPluginManager().registerEvents(new ClassesAPI(), this);
		Bukkit.getPluginManager().registerEvents(new LoginAPI(), this);
		
		getCommand("login").setExecutor(new ComandoLogin());
		getCommand("register").setExecutor(new ComandoRegister());
		getCommand("trocarsenha").setExecutor(new ComandoTrocarSenha());
	}

}
