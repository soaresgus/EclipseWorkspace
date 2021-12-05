package me.ninjay.olympicbungee.main;

import me.ninjay.olympicbungee.eventos.EventosGeral;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeMain extends Plugin{
	
	@Override
	public void onEnable() {
	    BungeeCord.getInstance().getPluginManager().registerListener(this, new EventosGeral());
	}

}
