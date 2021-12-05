package me.ninjay.ninjakitpvp.estruturas;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjakitpvp.main.Main;
import me.ninjay.ninjakitpvp.utils.Mine;


public class ComandoCoins implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage("§eCoins: "+CoinsAPI.get(p, Main.cash));
				return true;
			}
			if(!p.hasPermission("cash.admin")) {
				return true;
			}
			if(p.hasPermission("cash.admin")) {
				if(args[0].equalsIgnoreCase("get")) {
					if(args.length <= 1) {
						p.sendMessage("§cUtilize: /coins get <Jogador>");
						return true;
					}else {
						Player j = Bukkit.getPlayer(args[1]);
						if(j == null) {
							p.sendMessage("§cJogador offline.");
							return true;
						}else {
							p.sendMessage("§eCoins de "+j.getName()+": "+CoinsAPI.get(j, Main.cash));
						}
					}
				}
			}
			if(p.hasPermission("cash.admin")) {
				if(args[0].equalsIgnoreCase("set")) {
					if(args.length <= 2) {
						p.sendMessage("§cUtilize: /coins set <Jogador> <Quantia>");
						return true;
					}else {
						Player j = Bukkit.getPlayer(args[1]);
						int i = Mine.toInt(args[2]);
						if(j == null) {
							p.sendMessage("§cJogador offline.");
							return true;
						}else {
						p.sendMessage("§eFoi setado "+i+" coin(s) para "+j.getName());
						CoinsAPI.set(j, Main.cash, i);
					}
				  }
				}
			}
			if(p.hasPermission("cash.admin")) {
				if(args[0].equalsIgnoreCase("add")) {
					if(args.length <= 2) {
						p.sendMessage("§cUtilize: /coins add <Jogador> <Quantia>");
						return true;
					}else {
						Player j = Bukkit.getPlayer(args[1]);
						int i = Mine.toInt(args[2]);
						
					    if(j == null) {
					    	p.sendMessage("§cJogador offline.");
					    	return true;
					    }else {
					    	p.sendMessage("§eFoi adicionado "+i+" coin(s) para "+j.getName());
					    	CoinsAPI.add(j, Main.cash, i);
					    }
					}
				}
			}
			if(p.hasPermission("cash.admin")) {
				if(args[0].equalsIgnoreCase("remove")) {
					if(args.length <= 2) {
						p.sendMessage("§cUtilize: /coins remove <Jogador> <Quantia>");
						return true;
					}else {
						Player j = Bukkit.getPlayer(args[1]);
						int i = Mine.toInt(args[2]);
						
						if(j == null) {
							p.sendMessage("§cJogador offline");
							return true;
						}else {
							p.sendMessage("§eFoi removido "+i+" coin(s) de "+j.getName());
							CoinsAPI.remove(p, Main.cash, i);
						}
					}
				}
			}
		}
		return false;
	}

}
