package me.ninjay.ninjahomes.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjahomes.estruturas.HomesAPI;
import me.ninjay.ninjahomes.main.Main;

public class ComandoParticular implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length == 0) {
				p.sendMessage("§cUtilize: /particular <nome>.");
				return true;
			}
			if(Main.listar.contains(p.getName()+".homes."+args[0])) {
				if(Main.listar.getBoolean(p.getName()+".homes."+args[0]) == true) {
			HomesAPI.setarParticular(p, args[0]);
				}else {
					p.sendMessage("§cA home §c§l"+args[0]+" §cjá é particular.");
				}
			}else {
				p.sendMessage("§cA home §c§l"+args[0]+" §cnão existe.");
			}
		}
		return false;
	}

}
