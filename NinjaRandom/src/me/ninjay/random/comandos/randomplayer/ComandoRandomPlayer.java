package me.ninjay.random.comandos.randomplayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.random.main.Main;

public class ComandoRandomPlayer implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String a, String[] args) {
		if(sender instanceof Player ) {
			
			Player p = (Player) sender;
			if(!p.hasPermission("random.usar")) {
				return true;
			}
			Mine.sendTitle("§e§lEscolhendo...", "§f§kAAAAAAAAAAAAAA", 5, 120, 5);
				new BukkitRunnable() {
					int cont = 30;
					
					@Override
					public void run() {
						if(p.hasPermission("random.usar")) {
							cont--;
							
								
							}
	                       					
							if(cont == 0) {
								cancel();
								Mine.sendTitle("§e§lEscolhido !", "§f"+Mine.getRandomPlayer().getName()+" foi o jogador escolhido", 5, 120, 5);
							}
						}						
				}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 5, 5);
		}
		return false;


	}
}
