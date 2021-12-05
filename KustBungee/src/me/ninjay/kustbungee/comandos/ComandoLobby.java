package me.ninjay.kustbungee.comandos;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ComandoLobby extends Command{

	public ComandoLobby() {
		super("lobby");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		
		p.connect(ProxyServer.getInstance().getServerInfo("lobby"));
	}
	
	

}
