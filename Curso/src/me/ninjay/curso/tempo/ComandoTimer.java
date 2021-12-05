package me.ninjay.curso.tempo;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.curso.main.Main;

public class ComandoTimer implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			new BukkitRunnable() {
				int contagem = 500;
				@Override
				public void run() {
					contagem--;
					Bukkit.broadcastMessage("§aA contagem está em "+contagem);
					if(contagem==0) {
						cancel();
						Bukkit.broadcastMessage("§aO timer se encerrou.");
						
					}
				
				}
			}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
		}
		return false;
	}
}
