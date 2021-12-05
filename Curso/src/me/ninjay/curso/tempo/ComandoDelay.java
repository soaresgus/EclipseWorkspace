package me.ninjay.curso.tempo;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.curso.main.Main;

public class ComandoDelay implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			p.sendMessage("§aDelay iniciado.");
			new BukkitRunnable() {
				
				@Override
				public void run() {
				p.sendMessage("§aDelay finalizado.");
					
				}
			}.runTaskLater(Main.getPlugin(Main.class), 40);
		}
		return false;
	}

}
