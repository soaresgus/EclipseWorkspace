package me.ninjay.curso.cash;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.curso.main.Main;
import net.eduard.api.lib.Mine;

public class ComandoCash implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage("§eSeu cash: "+Main.cash.getDouble(p.getName()));
				
				
				return true;
			}else {
				String sub = args[0];
				if(sub.equalsIgnoreCase("set")) {
					
					if(args.length < 3) {
						p.sendMessage("§eCash - Help\n \n§eUtilize /cash set <player> <quantia>");
					}else {
						Double quantidade = Mine.toDouble(args[2]);
						String jogador = args[1];
						Main.cash.set(jogador, quantidade);
						Main.cash.saveConfig();
					}
					
				}
				if(sub.equalsIgnoreCase("add")) {
					if(args.length < 3) {
						p.sendMessage("§eCash - Help\n \n§eUtilize /cash add <player> <quantia>");
					}else {
						Double quantidade = Mine.toDouble(args[2]);
						String jogador = args[1];
						Double cash = Main.cash.getDouble(p.getName());
						Main.cash.set(jogador, quantidade+cash);
						Main.cash.saveConfig();
					}
				}
				if(sub.equalsIgnoreCase("remove")) {
					if(args.length < 3) {
						p.sendMessage("§eCash - Help\n \n§eUtilize /cash remove <player> <quantia>");
					}else {
						Double quantidade = Mine.toDouble(args[2]);
						String jogador = args[1];
						Double cash = Main.cash.getDouble(p.getName());
						Main.cash.set(jogador, quantidade-cash);
						Main.cash.saveConfig();
					}
				}
			}
		}
		return false;
	}

}
