package me.ninjay.safeclubbungee.main;

import me.ninjay.safeclubbungee.comandos.ComandoPunir;
import me.ninjay.safeclubbungee.comandos.ComandoRunnable;
import me.ninjay.safeclubbungee.eventos.BungeeEventos;
import me.ninjay.safeclubbungee.utils.BungeeConfig;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeMain extends Plugin{

	public static BungeeConfig perm;
	public static BungeeConfig temp;
	public static BungeeConfig pperm;
	
	
	@Override
	public void onEnable() {
		BungeeCord.getInstance().getPluginManager().registerListener(this, new BungeeEventos());
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new ComandoPunir());
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new ComandoRunnable(this));
		
		perm = new BungeeConfig("perms.yml", this);
		perm.saveConfig();
		
		temp = new BungeeConfig("temp.yml", this);
		temp.saveConfig();
		
		pperm = new BungeeConfig("permp.yml", this);
		pperm.saveConfig();
	}
	@Override
	public void onDisable() {
		
	}
	
}
