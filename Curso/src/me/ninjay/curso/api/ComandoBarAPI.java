package me.ninjay.curso.api;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.confuser.barapi.BarAPI;

public class ComandoBarAPI implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			BarAPI.setMessage(p, "aaa", 60);
			
		}
		return false;
	}

}
