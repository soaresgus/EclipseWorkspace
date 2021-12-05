package me.ninjay.kustbungee.main;

import me.ninjay.kustbungee.comandos.ComandoLobby;
import me.ninjay.kustbungee.eventos.EventosGeral;
import me.ninjay.kustbungee.utils.BungeeConfig;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin{
	
	public static BungeeConfig tickets;
	
	@Override
	public void onEnable() {
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new ComandoLobby());
	    BungeeCord.getInstance().getPluginManager().registerListener(this, new EventosGeral());
	    
	   tickets = new BungeeConfig("tickets.yml", this);
	   tickets.saveConfig();
	}
	
	public static Main getInstance() {
		return Main.getInstance();
	}

}
