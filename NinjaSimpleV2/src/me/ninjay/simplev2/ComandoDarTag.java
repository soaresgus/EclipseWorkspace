package me.ninjay.simplev2;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoDarTag implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("dartag")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("§6§lApenas player podem utilizar");
				
			}else {
				Player p = (Player)sender;
				if(!p.hasPermission("dartag.use")) {
					return true;
				}
				
			
			if(args.length == 0) {
				p.sendMessage("§6§lUtilize /dartag <nick> <tag>");
				return true;

			}
				Player p2 = Bukkit.getPlayer(args[0]);
				if(p2 == null) {
					p.sendMessage("§c§lJogador offline");
					return true;
				}
				if(args.length == 1) {
					p.sendMessage("§6§lUtilize /dartag <nick> <tag>");
					return true;
				}
				String msg = "";
				for (int i = 1; i < args.length; i++) {
					msg = String.valueOf(msg) + args[i];
					msg = String.valueOf(msg) + " ";
				if(p.hasPermission("dartag.use")) {
					p2.setCustomName(msg + "" + p2.getName());
					p2.setDisplayName(msg + "" + p2.getName());
					p2.setPlayerListName(msg + "" + p2.getName());
					p.sendMessage("§6§lTag " + msg + "§6§lentregue para " + p2.getName());
				}
			}
		}
		
	
		return false;

}
		return false;
	}
	
}

