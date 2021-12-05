package me.ninjay.kustmina.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.kustmina.main.Main;

public class ComandoSetMina implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.hasPermission("mina.admin")) {
				if(args.length == 0) {
					p.sendMessage("§cUse: /setmina <membro/vip>.");
					return true;
				}
				if(args[0].equalsIgnoreCase("membro")) {
					p.sendMessage("§aMina de membros setada.");
					Main.config.set("membro", p.getLocation());
					Main.config.saveConfig();
				}
				if(args[0].equalsIgnoreCase("vip")) {
					p.sendMessage("§aMina de vips setada.");
					Main.config.set("vip", p.getLocation().getWorld().getName());
					Main.config.saveConfig();
				}
			}
		}
		return false;
	}

}
