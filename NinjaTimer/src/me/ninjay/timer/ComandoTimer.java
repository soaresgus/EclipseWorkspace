package me.ninjay.timer;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;



public class ComandoTimer implements CommandExecutor{

	public final Main instance = Main.getmain();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			new BukkitRunnable() {
				int contagem = 30;
				@Override
				public void run() {
					contagem--;
				Bukkit.broadcastMessage("§aContagem encerra em "+contagem);
					if(contagem==0) {
						cancel();
						Bukkit.broadcastMessage("§aContagem finalizada");
					}
							
					}
			}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
		}
		return false;
	}
}
			
	


	



