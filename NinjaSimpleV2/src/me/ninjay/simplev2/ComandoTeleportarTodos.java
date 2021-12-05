package me.ninjay.simplev2;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoTeleportarTodos implements CommandExecutor{
	
public final Main instance = Main.getmain();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 if(command.getName().equalsIgnoreCase("teleportartodos")) {
			 if(!(sender instanceof Player)) {
				 sender.sendMessage("§6§lApenas players podem utilizar.");
			 }else {
				 Player p = (Player)sender;
				 if(!p.hasPermission("tpall.use")) {
					 return true;

}
				 if(p.hasPermission("tpall.use")) {
					 for(Player todos : Bukkit.getServer().getOnlinePlayers()) {
						todos.teleport(p);
						todos.sendMessage("§aTodos os jogadores foram teleportados para " + p.getName());
						todos.getWorld().playSound(todos.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);
					 }
					 
					 
				 }
			 }
		 }
		return false;

	}
}

