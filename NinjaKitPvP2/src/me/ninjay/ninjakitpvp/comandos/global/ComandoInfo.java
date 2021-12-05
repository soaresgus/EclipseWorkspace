package me.ninjay.ninjakitpvp.comandos.global;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjakitpvp.estruturas.InfoAPI;

public class ComandoInfo implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			InfoAPI.enviar(p);
		}
		return false;
	}

}
