package me.ninjay.safemina.comandos;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.safemina.main.Main;
import me.ninjay.safemina.utils.Mine;

public class ComandoEscavar implements CommandExecutor {

	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;

			 boolean isEmpty = true;
		        for (ItemStack item : p.getInventory().getContents()) {
		            if(item != null) {
		                isEmpty = false;
		                break;
		            }
		        }  
		        if(isEmpty) {
						p.sendMessage("§6§l                     Mundo de escavação                     \n \n§e  - A cada bloco quebrado você encontra um minério.\n  - Minérios encontrados são vendidos automáticamente.\n  - Apenas nesse mundo a escavação pode ser evoluida.\n  - Apenas nesse mundo os poderes da escavação funcionam.\n ");
						Location loc = new Location(Bukkit.getWorld(Main.config.getString("MundoEscavar")), Mine.getRandomInt(0, 4500), 107, Mine.getRandomInt(0, 4500));
						p.teleport(loc);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								if(p.getWorld().getName().equals(Main.config.getString("MundoEscavar"))) {
								p.getInventory().addItem(Mine.newItem(Material.DIAMOND_SPADE, null));
								}
							}
						}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 5);
		        } else {
						p.sendMessage("§cEsvazie o inventário para teleportar.");
		        }
		}
		return false;
	}
}
