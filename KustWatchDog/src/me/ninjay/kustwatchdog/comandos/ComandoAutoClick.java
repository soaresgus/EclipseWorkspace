package me.ninjay.kustwatchdog.comandos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoAutoClick implements CommandExecutor{
	
	public static HashMap<Player, Player> usando = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.hasPermission("watchdog.perm")) {
				if(args.length <= 0) {
					p.sendMessage("§cUse: /autoclick <player>.");
					return true;
				}
				
				Player j = Bukkit.getPlayer(args[0]);
				if(j != null) {
					p.sendMessage("§cRelatório sendo executado...");
					usando.put(j, p);
				}else {
					p.sendMessage("§cJogador offline.");
				}
			}
		}
		return false;
	}

}
