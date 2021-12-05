package me.ninjay.onelogin.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.onelogin.comandos.ComandoLogar;
import me.ninjay.onelogin.comandos.ComandoRegistrar;
import me.ninjay.onelogin.comandos.ComandoRemoverSenha;
import me.ninjay.onelogin.comandos.ComandoTrocarSenha;
import me.ninjay.onelogin.comandos.ComandoVerSenha;
import me.ninjay.onelogin.eventos.EventosLogar;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("login").setExecutor(new ComandoLogar());
		Bukkit.getPluginManager().registerEvents(new EventosLogar(), this);
		getCommand("register").setExecutor(new ComandoRegistrar());
		getCommand("versenha").setExecutor(new ComandoVerSenha());
		getCommand("removersenha").setExecutor(new ComandoRemoverSenha());
		getCommand("trocarsenha").setExecutor(new ComandoTrocarSenha());
	}

}
