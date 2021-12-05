package me.ninjay.ninjahomes.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjahomes.estruturas.HomesAPI;
import me.ninjay.ninjahomes.main.Main;

public class ComandoDelHome implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length == 0) {
				p.sendMessage("§cUtilize: /delhome <home>.");
				return true;
			}
			if(!Main.homeconf.contains(p.getName()+".homes."+args[0])) {
				p.sendMessage("§cA home §c§l"+args[0]+" §cnão existe.");
				return true;
			}else {
				HomesAPI.removerHome(p, args[0]);
			}
		}
		return false;
	}

}
