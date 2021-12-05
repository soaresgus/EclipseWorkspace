package me.ninjay.curso.spawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.curso.main.Main;

public class ComandoSpawn implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	   if(sender instanceof Player) {
		   
		Player p = (Player) sender;
		if(Main.config.contains("spawn")) {
		p.teleport(Main.config.getLocation("spawn"));
		p.sendMessage("Teleportado !");
	}else {
		p.sendMessage("Spawn não setado");
	}
	}
	return false;

}
}