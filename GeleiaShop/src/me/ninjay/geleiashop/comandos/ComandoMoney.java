package me.ninjay.geleiashop.comandos;

import java.text.DecimalFormat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.org.apache.commons.lang3.StringUtils;
import org.bukkit.entity.Player;

import me.ninjay.geleiashop.main.Main;
import me.ninjay.geleiashop.utils.BukkitConfig;
import me.ninjay.geleiashop.utils.Mine;

public class ComandoMoney implements CommandExecutor{
	
	public static BukkitConfig c() {
		return Main.config;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			DecimalFormat df = new DecimalFormat("###,###,###");
			if(args.length == 0) {
			if(c().get(p.getName()) != null) {
				p.sendMessage("§eSeu dinheiro: §f$"+df.format(c().get(p.getName())).replace(",", "."));
			}else {
				p.sendMessage("§eSeu dinheiro: §f$0");
			}
				return true;
			}
			
			if(args[0].equalsIgnoreCase("get")) {
			if(args.length > 1) {
				Player j = Bukkit.getPlayer(args[1]);
				if(j != null) {
					if(c().get(j.getName()) != null) {
						p.sendMessage("§eDinheiro de "+j.getName()+": §f$"+df.format(c().get(p.getName())).replace(",", "."));
					}else {
						p.sendMessage("§eDinheiro de "+j.getName()+": §f$0");
					}
				}else {
					p.sendMessage("§cJogador não encontrado.");
				}
				}else {
					p.sendMessage("§cUtilize: /money get <jogador>.");
				}
			}
			
			if(args[0].equalsIgnoreCase("set")) {
			if(args.length > 2) {
				Player j = Bukkit.getPlayer(args[1]);
				if(j != null) {
					if(StringUtils.isNumeric(args[2])) {
					p.sendMessage("§aSetado "+args[2]+" para "+j.getName()+".");
					c().set(j.getName(), Mine.toInt(args[2]));
					c().saveConfig();
				}else {
					p.sendMessage("§cApenas números.");
				}
				}else {
					p.sendMessage("§cJogador não encontrado.");
				}
			}else {
				p.sendMessage("§cUtilize: /money set <jogador> <quantidade>.");
			}
			}
			
			if(args[0].equalsIgnoreCase("help")) {
				p.sendMessage("§e/money - Ver seu dinheiro no chat.\n§e/money get <jogador> - Ver o dinheiro de um jogador\n/money set <jogador> <quantidade> - Setar uma quantidade de dinheiro a um jogador");
			}
			
		}
		return false;
	}

}
