package me.ninjay.geleiarepeat.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.geleiarepeat.main.Main;

public class ComandoCentro implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(args.length == 0) {
				p.sendMessage("§cUtilize: /centro [1/2].");
				return true;
			}
			
			if(args[0].equalsIgnoreCase("1")) {
				p.sendMessage("§aCentro do local 1 setado!");
				Main.getPlugin(Main.class).getConfig().set("1", p.getLocation());
				Main.getPlugin(Main.class).saveConfig();
			}
			
			if(args[0].equalsIgnoreCase("2")) {
				p.sendMessage("§aCentro do local 2 setado!");
				Main.getPlugin(Main.class).getConfig().set("2", p.getLocation());
				Main.getPlugin(Main.class).saveConfig();
			}
		}
		return false;
	}

}
