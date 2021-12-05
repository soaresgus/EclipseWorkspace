package me.ninjay.safecore.comandos.lag;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.safecore.main.Main;

public class ComandoSetSpawn implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.isOp() == true) {
				if(args.length == 0) {
					p.sendMessage("§cUtilize: /setspawn (normal/vip).");
					return true;
				}
				if(args[0].equalsIgnoreCase("normal")) {
					Main.config.set("spawn", p.getLocation());
					Main.config.saveConfig();
					p.sendMessage("§aSpawn §enormal §asetado.");
				}
				if(args[0].equalsIgnoreCase("vip")) {
					Main.config.set("vip", p.getLocation());
					Main.config.saveConfig();
					p.sendMessage("§aSpawn §evip §asetado.");
				}
			}
		}
		return false;
	}

}
