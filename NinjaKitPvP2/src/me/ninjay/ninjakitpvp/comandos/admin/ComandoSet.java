package me.ninjay.ninjakitpvp.comandos.admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjakitpvp.estruturas.LocationsAPI;

public class ComandoSet implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(p.hasPermission("set.admin")) {
				if(args.length == 0) {
					p.sendMessage("§cUse /set <arena(1 a 5)/spawn/lava/1v1/fps/sumo/ss>");
					return true;
				}
				if(args[0].equalsIgnoreCase("arena1")) {
					LocationsAPI.setLocation(p, "arena1");
				}
				if(args[0].equalsIgnoreCase("arena2")) {
					LocationsAPI.setLocation(p, "arena2");
				}
				if(args[0].equalsIgnoreCase("arena3")) {
					LocationsAPI.setLocation(p, "arena3");
				}
				if(args[0].equalsIgnoreCase("arena4")) {
					LocationsAPI.setLocation(p, "arena4");
				}
				if(args[0].equalsIgnoreCase("arena5")) {
					LocationsAPI.setLocation(p, "arena5");
				}
				if(args[0].equalsIgnoreCase("spawn")) {
					LocationsAPI.setLocation(p, "spawn");
				}
				if(args[0].equalsIgnoreCase("lava")) {
					LocationsAPI.setLocation(p, "lava");
				}
				if(args[0].equalsIgnoreCase("1v1")) {
					LocationsAPI.setLocation(p, "1v1");
				}
				if(args[0].equalsIgnoreCase("fps")) {
					LocationsAPI.setLocation(p, "fps");
				}
				if(args[0].equalsIgnoreCase("sumo")) {
					LocationsAPI.setLocation(p, "sumo");
				}
				if(args[0].equalsIgnoreCase("ss")) {
					LocationsAPI.setLocation(p, "ss");
				}
			}
		}
		return false;
	}

}
