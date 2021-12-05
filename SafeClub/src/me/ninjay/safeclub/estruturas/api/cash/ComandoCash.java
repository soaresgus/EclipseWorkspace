package me.ninjay.safeclub.estruturas.api.cash;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.safeclub.main.Main;
import me.ninjay.safeclub.utils.Mine;


public class ComandoCash implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length == 0) {
				p.sendMessage("§eCash: "+CashAPI.get(p, Main.cash));
				return true;
			}
			if(!p.hasPermission("cash.admin")) {
				return true;
			}
			if(p.hasPermission("cash.admin")) {
				if(args[0].equalsIgnoreCase("get")) {
					if(args.length <= 1) {
						p.sendMessage("§cUtilize: /cash get <Jogador>");
						return true;
					}else {
						Player j = Bukkit.getPlayer(args[1]);
						if(j == null) {
							p.sendMessage("§cJogador offline.");
							return true;
						}else {
							p.sendMessage("§eCash de "+j.getName()+": "+CashAPI.get(j, Main.cash));
						}
					}
				}
			}
			if(p.hasPermission("cash.admin")) {
				if(args[0].equalsIgnoreCase("set")) {
					if(args.length <= 2) {
						p.sendMessage("§cUtilize: /cash set <Jogador> <Quantia>");
						return true;
					}else {
						Player j = Bukkit.getPlayer(args[1]);
						int i = Mine.toInt(args[2]);
						if(j == null) {
							p.sendMessage("§cJogador offline.");
							return true;
						}else {
						p.sendMessage("§eFoi setado "+i+" cash(s) para "+j.getName());
						CashAPI.set(j, Main.cash, i);
					}
				  }
				}
			}
			if(p.hasPermission("cash.admin")) {
				if(args[0].equalsIgnoreCase("add")) {
					if(args.length <= 2) {
						p.sendMessage("§cUtilize: /cash add <Jogador> <Quantia>");
						return true;
					}else {
						Player j = Bukkit.getPlayer(args[1]);
						int i = Mine.toInt(args[2]);
						
					    if(j == null) {
					    	p.sendMessage("§cJogador offline.");
					    	return true;
					    }else {
					    	p.sendMessage("§eFoi adicionado "+i+" cash(s) para "+j.getName());
					    	CashAPI.add(j, Main.cash, i);
					    }
					}
				}
			}
			if(p.hasPermission("cash.admin")) {
				if(args[0].equalsIgnoreCase("remove")) {
					if(args.length <= 2) {
						p.sendMessage("§cUtilize: /cash remove <Jogador> <Quantia>");
						return true;
					}else {
						Player j = Bukkit.getPlayer(args[1]);
						int i = Mine.toInt(args[2]);
						
						if(j == null) {
							p.sendMessage("§cJogador offline");
							return true;
						}else {
							p.sendMessage("§eFoi removido "+i+" cash(s) de "+j.getName());
							CashAPI.remove(p, Main.cash, i);
						}
					}
				}
			}
		}
		return false;
	}

}
