package me.ninjay.kustgerenciador.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.kustgerenciador.main.Main;

public class ComandoArena implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length == 0) {
				if(Main.config.contains("arena_loc")) {
					p.sendMessage("§aTeleportado com sucesso!");
					p.teleport(Main.config.getLocation("arena_loc"));
				}else {
					p.sendMessage("§cArena não definida.");
				}
			}else {
			if(p.hasPermission("arena.admin")) {
				if(args[0].equalsIgnoreCase("set")) {
					p.sendMessage("§aArena setada!");
					Main.config.set("arena_loc", p.getLocation());
					Main.config.saveConfig();
				}
			}
			}
			
		}
		
		return false;
	}

}
