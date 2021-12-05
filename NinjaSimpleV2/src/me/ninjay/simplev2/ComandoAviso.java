package me.ninjay.simplev2;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoAviso implements CommandExecutor{
	
	public final Main instance = Main.getmain();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("aviso")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("§6§lApenas players podem utilizar.");
				
			}else {
				Player p = (Player)sender;
				if(!p.hasPermission("aviso.use")) {
					return true;
				}
				if(args.length == 0) {
					p.sendMessage("§6§lUtilize /aviso <mensagem>.");
					return true;
				}
				String msg = "";
				for (int i = 0; i < args.length; i++) {
					msg = String.valueOf(msg) + args[i];
					msg = String.valueOf(msg) + " ";
				}
				if(p.hasPermission("aviso.use")) {
					Bukkit.broadcastMessage("§4§lAVISO >>> §c" + msg);
				}
			}
		}
		return false;
	}

}
