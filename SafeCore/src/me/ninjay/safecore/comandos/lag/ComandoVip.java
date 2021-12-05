package me.ninjay.safecore.comandos.lag;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.safecore.main.Main;

public class ComandoVip implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			p.sendMessage("§aTeleportado a vip.");
			p.teleport(Main.config.getLocation("vip"));
			
		}
		return false;
	}

}
