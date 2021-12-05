package me.ninjay.loginsoulth.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.eduard.api.lib.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig senhas;
	public static BukkitConfig locais;
	
	@Override
	public void onEnable() {
		senhas = new BukkitConfig("senhas.yml", this);
		senhas.saveConfig();
		locais = new BukkitConfig("locais.yml", this);
		locais.saveConfig();
		getCommand("login").setExecutor(new ComandoLogin());
		getCommand("trocarsenha").setExecutor(new ComandoTrocarSenha());
		Bukkit.getPluginManager().registerEvents(new ComandoLogin(), this);
		getCommand("register").setExecutor(new ComandoRegister());
		getCommand("setloginspawn").setExecutor(new ComandoLoginSpawn());
	}

}
