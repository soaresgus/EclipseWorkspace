package me.ninjay.ninjakitpvp.comandos.global;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.ninjakitpvp.estruturas.LocationsAPI;
import me.ninjay.ninjakitpvp.eventos.EventosGlobal;
import me.ninjay.ninjakitpvp.main.Main;
import me.ninjay.ninjakitpvp.utils.Mine;

public class ComandoSpawn implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
	    if(sender instanceof Player) {
			Player p = (Player) sender;
			new BukkitRunnable() {
				int i = 4;
				@Override
				public void run() {
					if(i == 3);
					i--;
					Mine.sendTitle(p, "§e§lTeleportando em "+i, "§eTeleporatando para o spawn...", 0, 25, 25);
				if(i == 0) {
					cancel();
					LocationsAPI.tpLocation(p, "spawn");
					EventosGlobal.darItens(p);
					EventosGlobal.spawn.add(p);
					Mine.sendTitle(p, "", "§e§lTeleportado !", 0, 10, 10);
				}
				}
			}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
			
	    }
		
		
		return false;
	}

}
