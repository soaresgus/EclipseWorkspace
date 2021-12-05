package me.ninjay.safecash.comandos;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.ninjay.safecash.estruturas.CashAPI;
import me.ninjay.safecash.main.Main;
import me.ninjay.safecash.utils.BukkitConfig;
import me.ninjay.safecash.utils.Mine;

public class ComandoCash implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			BukkitConfig config = Main.cash;
			
			if(!p.hasPermission("cash.admin")) {
				p.sendMessage("§cSem permissão.");
			}
			if(p.hasPermission("cash.admin")) {
				if(args.length <= 1) {
					p.sendMessage("§cUse: /cash <get/set/add/remove> <player> <quantia>.");
					return true;
				}
				OfflinePlayer player = Bukkit.getOfflinePlayer(args[1]);
				if(args[0].equalsIgnoreCase("get")) {
					p.sendMessage("§eCash de "+player.getName()+": "+CashAPI.get(player, config));
				}
				if(args[0].equalsIgnoreCase("set")) {
					if(StringUtils.isNumeric(args[2])) {
					CashAPI.set(player, config, Mine.toInt(args[2]));
					p.sendMessage("§eSetado "+args[2]+" para "+player.getName()+".");
					}else {
						p.sendMessage("§cDigite apenas números.");
					}
				}
				if(args[0].equalsIgnoreCase("add")) {
					if(StringUtils.isNumeric(args[2])) {
						CashAPI.add(player, config, Mine.toInt(args[2]));
						p.sendMessage("§eAdicionado "+args[2]+" para "+player.getName()+" restando um total de "+CashAPI.get(player, config)+".");
					}else {
						p.sendMessage("§cDigite apenas números.");
					}
				}
				if(args[0].equalsIgnoreCase("remove")) {
					if(StringUtils.isNumeric(args[2])) {
						CashAPI.remove(player, config, Mine.toInt(args[2]));
						p.sendMessage("§eRemovido "+args[2]+" de "+player.getName()+" restando um total de "+CashAPI.get(player, config)+".");
					}else {
						p.sendMessage("§cDigite apenas números.");
					}
				}
			}
			
		}
		return false;
	}
	

}
