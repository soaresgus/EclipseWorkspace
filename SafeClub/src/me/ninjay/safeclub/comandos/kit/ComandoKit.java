package me.ninjay.safeclub.comandos.kit;


import java.net.Socket;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.safeclub.estruturas.api.kit.KitAPI;

public class ComandoKit implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			KitAPI.openGUI(p);
			
		}
		return false;
	}

}
