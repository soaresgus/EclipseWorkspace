package me.ninjay.aurealobby;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ComandoFly implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			new BukkitRunnable() {
				int contagem = 2;
				@Override
				public void run() {
					contagem--;
					
					if(contagem==1) {
						player.teleport(Main.config.getLocation("spawn"));
					}
					if(contagem==0) {
						player.setAllowFlight(false);
						player.sendMessage("§aFly desativado !\n \nPara ativar clique no item novamente.");
						Main.permission.playerRemove(player, "fly.on");
					}
					
				}
			}
			.runTaskTimer(Main.getmain(), 2, 2);
			
		}
		return false;
	}

}
