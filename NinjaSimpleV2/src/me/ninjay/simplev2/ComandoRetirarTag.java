package me.ninjay.simplev2;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoRetirarTag implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("retirartag")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("§6§lApenas players podem utilizar.");
				
				
			}else {
				Player p = (Player)sender;
				if(!p.hasPermission("retirartag.use")) {
					return true;
				}
				if(args.length == 0) {
					p.sendMessage("§6§lUtilize /retirartag <nick>");
					return true;
				}
				Player p2 = Bukkit.getPlayer(args[0]);
				if(p2 == null) {
					p.sendMessage("§c§lJogador offline");
					return true;
				}
				
				if(p.hasPermission("retirartag.use")) {
					p2.setCustomName(p2.getName());
					p2.setDisplayName(p2.getName());
					p2.setPlayerListName(p2.getName());
					p.sendMessage("§6§lTag de " +p2.getName()+ " §6§lretirada.");
					return true;
				}
			}
		}
		return false;
	}

}
