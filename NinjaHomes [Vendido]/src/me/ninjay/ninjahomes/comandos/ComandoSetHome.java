package me.ninjay.ninjahomes.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjahomes.estruturas.HomesAPI;


public class ComandoSetHome implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(args.length == 0) {
				p.sendMessage("§cUtilize: /sethome <nome>.");
				return true;
			}
			if(!p.hasPermission("home.limite")) {
				if(HomesAPI.getInt(p) < HomesAPI.getLimiteDefault()) {
					HomesAPI.setarHome(p, args[0]);
					return true;
				}else if(HomesAPI.getInt(p) == HomesAPI.getLimiteDefault()) {
					p.sendMessage("§cVocê atingiu o limite de homes.");
					return true;
				}
			}else if(p.hasPermission("home.limite")) {
				if(HomesAPI.getInt(p) < HomesAPI.getLimiteVip()) {
					HomesAPI.setarHome(p, args[0]);
					return true;
				}else if(HomesAPI.getInt(p) == HomesAPI.getLimiteVip()) {
					p.sendMessage("§cVocê atingiu o limite de homes.");
					return true;
				}
			}
		}
		return false;
	}

}
