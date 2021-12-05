package me.ninjay.hologramas.comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjaapi.utils.Mine;

public class ComandoHolograma implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length == 0) {
				p.sendMessage("§cUtilize /holograma <texto>.");
				return true;
			}
			if(p.hasPermission("holograma.admin")) {
				String msg = " ";
				for (int i = 0; i < args.length; i++) {
					msg = String.valueOf(msg) + args[i];
					msg = String.valueOf(msg) + " ";
				}
				Mine.newHologram(p.getLocation(), ChatColor.translateAlternateColorCodes('&', msg));
			}
		}
		return false;
	}

}
