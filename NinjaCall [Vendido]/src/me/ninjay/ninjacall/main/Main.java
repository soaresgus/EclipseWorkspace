package me.ninjay.ninjacall.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.ninjacall.comandos.ComandoBring;
import me.ninjay.ninjacall.comandos.ComandoCall;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("call").setExecutor(new ComandoCall());
		getCommand("bring").setExecutor(new ComandoBring());
		Bukkit.getConsoleSender().sendMessage("§6[NinjaCall] §aPlugin ativado com sucesso!");
	}

}
