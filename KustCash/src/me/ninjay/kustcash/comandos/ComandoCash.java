package me.ninjay.kustcash.comandos;

import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.kustcash.estruturas.CashAPI;
import me.ninjay.kustcash.main.Main;
import me.ninjay.kustcash.utils.Mine;

public class ComandoCash implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(args.length == 0) {
				p.sendMessage("§eCash: §f"+CashAPI.getCash(p.getName()));
				return true;
			}
			
			if(p.hasPermission("cash.admin")) {
				if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("ajuda")) {
					p.sendMessage("§6/cash §e» §7Consulta seu cash.\n§6/cash help §e» §7Mostra todos os comandos disponíveis.\n§6/cash get <nick> §e» §7Puxar o cash de um jogador.\n§6/cash add <nick> <quantidade> §e» §7Adiciona cash ao jogador.\n§6/cash remove <nick> <quantidade> §e» §7Remove cash do jogador.");
				}
				if(args[0].equalsIgnoreCase("get")) {
					if(args.length == 2) {
					if(Main.sql.contains("cash", "NICK='"+args[1]+"'")) {
						p.sendMessage("§eCash de "+args[1]+": §f"+CashAPI.getCash(args[1]));
					}else {
						p.sendMessage("§eCash de "+args[1]+": §f0 (Não encontrado no banco de dados)");
					}
					}else {
						p.sendMessage("§cUse: /cash get <nick>.");
					}
				}
				if(args[0].equalsIgnoreCase("add")) {
					if(args.length == 3) {
					if(StringUtils.isNumeric(args[2])) {
							int qntd = Mine.toInt(args[2]);
							CashAPI.addCash(args[1], qntd);
							p.sendMessage("§aFoi adicionado "+qntd+" para "+args[1]+".");
					}else {
						p.sendMessage("§cDigite um número na quantidade.");
					}
				}else {
					p.sendMessage("§cUse: /cash add <nick> <quantidade>.");
				}
				}
				if(args[0].equalsIgnoreCase("remove")) {
					if(args.length == 3) {
					if(StringUtils.isNumeric(args[2])) {
							int qntd = Mine.toInt(args[2]);
							CashAPI.removeCash(args[1], qntd);
							p.sendMessage("§aFoi removido "+qntd+" de "+args[1]+".");
					}else {
						p.sendMessage("§cDigite um número na quantidade.");
					}
				}else {
					p.sendMessage("§cUse: /cash remove <nick> <quantidade>.");
				}
				}
			}
		}
		return false;
	}

}
