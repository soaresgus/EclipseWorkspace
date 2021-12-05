package me.ninjay.bungee.main;

import me.ninjay.bungee.BungeeTop;
import me.ninjay.bungee.ComandoPing;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeMain extends Plugin{

	@Override
	public void onEnable() {
		BungeeCord.getInstance().getPluginManager().registerListener(this, new BungeeTop());
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new ComandoPing());
		getLogger().info("oi oi");
	}
	@Override
	public void onDisable() {
		
	}
	
}
