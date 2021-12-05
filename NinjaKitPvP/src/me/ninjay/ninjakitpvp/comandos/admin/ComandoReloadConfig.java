package me.ninjay.ninjakitpvp.comandos.admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjakitpvp.main.Main;

public class ComandoReloadConfig implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("reload.admin")) {
				Main.locations.reloadConfig();
				Main.global.reloadConfig();
				p.sendMessage("§aConfigs atualizadas !");
			}
 		}
		return false;
	}

}
