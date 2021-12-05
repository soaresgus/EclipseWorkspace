package me.ninjay.curso.spawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.curso.main.Main;

public class ComandoSetSpawn implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			Main.config.set("spawn", p.getLocation());
			Main.config.saveConfig();
			p.sendMessage("Spawn setado.");
			
		}
			
		
	
		return false;
}
}

