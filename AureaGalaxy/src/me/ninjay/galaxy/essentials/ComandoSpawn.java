package me.ninjay.galaxy.essentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.galaxy.main.Main;


public class ComandoSpawn implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String a, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(!Main.locais.contains("spawn")) {
				p.sendMessage("§eSpawn não setado ainda.");
				return true;
			}
			  if (p.hasPermission("master.tag") || p.hasPermission("gerente.tag") || p.hasPermission("admin.tag")
						|| p.hasPermission("moderador.tag") || p.hasPermission("ajudante.tag")
						|| p.hasPermission("construtor.tag") || p.hasPermission("youtuber.tag") || p.hasPermission("galaxy.tag")
						|| p.hasPermission("meteor.tag") || p.hasPermission("moon.tag") && Main.locais.contains("spawn")) {
				  p.sendMessage("§eTeleportado !");
					p.teleport(Main.locais.getLocation("spawn"));
					return true;
			  }
				if(p.hasPermission("membro.tag") && Main.locais.contains("spawn")) {
			p.sendMessage("§eSendo teleportado em 3 segundos.");
			new BukkitRunnable() {
				
				@Override
				public void run() {
					Player p = (Player) sender;
					p.sendMessage("§eTeleportado !");
					p.teleport(Main.locais.getLocation("spawn"));
				}
			}.runTaskLater(Main.getPlugin(Main.class), 60);
			
		}
	}
		return false;

}
}
