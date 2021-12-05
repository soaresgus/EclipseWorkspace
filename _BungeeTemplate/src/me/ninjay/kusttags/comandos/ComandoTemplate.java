package me.ninjay.kusttags.comandos;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ComandoTemplate extends Command{

	public ComandoTemplate() {
		super("template");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
	}
	
	

}
