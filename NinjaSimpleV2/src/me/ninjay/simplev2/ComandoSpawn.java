package me.ninjay.simplev2;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoSpawn implements CommandExecutor{
	
public final Main instance = Main.getmain();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 if(command.getName().equalsIgnoreCase("spawn")) {
			 if(!(sender instanceof Player)) {
				 sender.sendMessage("§6§lApenas players podem utilizar.");
			 }else {
				 Player p = (Player)sender;
				 if(!p.hasPermission("spawn.use")) {
					 return true;

}
				 if(p.hasPermission("spawn.use")) {
					 p.sendMessage("§aTeleportado");
					 p.teleport(p.getWorld().getSpawnLocation());
					 p.getWorld().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);
					 return true;
				 }
			 }
			 
		 }
		return false;
	}
}
