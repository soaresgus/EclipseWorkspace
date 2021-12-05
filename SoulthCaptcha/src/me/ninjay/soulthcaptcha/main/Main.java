package me.ninjay.soulthcaptcha.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.soulthcaptcha.captcha.EventosCaptcha;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventosCaptcha(), this);
	}

}
