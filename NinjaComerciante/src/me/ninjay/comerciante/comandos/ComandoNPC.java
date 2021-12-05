package me.ninjay.comerciante.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import me.ninjay.utils.utils.Mine;



public class ComandoNPC implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.hasPermission("comerciante.admin")) {
				for(Enderman entity : p.getWorld().getEntitiesByClass(Enderman.class)) {
					if(entity.getName().equals("§e§lComerciante")) {
						entity.remove();
					}
				}
				Enderman npc = p.getWorld().spawn(p.getLocation(), Enderman.class);
				npc.setCustomName("§e§lComerciante");
				npc.setCustomNameVisible(true);
				Mine.disableAI(npc);
			}
				}
		return false;
	}

}
