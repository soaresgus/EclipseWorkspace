package me.ninjay.tutorial;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("Escreva aqui sua mensagem.");
		getCommand("comando").setExecutor(new Comando());
	}

}
