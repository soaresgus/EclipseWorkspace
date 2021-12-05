package me.ninjay.kusttags.main;

import me.ninjay.kusttags.comandos.ComandoTemplate;
import me.ninjay.kusttags.eventos.EventosTemplate;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin{
	
	@Override
	public void onEnable() {
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new ComandoTemplate());
	    BungeeCord.getInstance().getPluginManager().registerListener(this, new EventosTemplate());
	}

}
