package me.ninjay.onecash.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjaapi.bukkit.CashAPI.CashAPI;
import me.ninjay.onecash.main.Main;
import net.eduard.api.lib.BukkitConfig;

public class ComandoCash implements CommandExecutor{
	
	public static BukkitConfig config = new BukkitConfig("cash.yml", Main.getPlugin(Main.class));
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length <= 2) {
				p.sendMessage("§6Cash: §e"+CashAPI.get(p, config));
				return true;
			}
			if(p.hasPermission("cash.admin")) {
				if(args.length <= 2) {
					
				}
			}
		}
		return false;
	}

}
