package me.ninjay.poo.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Porra implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		Player p = (Player)sender;
		
		ComandoProbabilidade.config.set("caixa", p.getLocation());
		ComandoProbabilidade.config.saveConfig();
		
		return false;
	}

}
