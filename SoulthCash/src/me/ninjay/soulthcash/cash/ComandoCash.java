package me.ninjay.soulthcash.cash;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.soulthcash.main.Main;

public class ComandoCash implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String a, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
           
			
			if(args.length == 0 ) {
				p.sendMessage("§e§lCash: §e"+Main.cash.getDouble(p.getName()));
				return true;
				
			}
			if(args[0].equalsIgnoreCase("ajuda") && p.hasPermission("cash.admin")) {
				p.sendMessage("§e§lCash Comandos\n \n§e§l/cash §eOlha seu saldo de cash.\n \n§e§l/cash ajuda §eOlha os comandos.\n \n§e§l/cash setar <jogador> <quantidade> §eSeta a quantidade final de cash do jogador, ignorando a quantidade que o mesmo já possui.\n \n§e§l/cash adicionar <jogador> <quantidade> §eAdiciona uma quantidade de cash para o jogador + a quantidade que o mesmo já possui.\n \n§e§l/cash saldo <jogador> §eOlha o saldo de cash de cash de algum jogador.\n \n§e§l/cash remover <jogador> <quantidade> §eRemove a quantidade de cash do jogador - a quantia que o mesmo já possui.");
			return true;
			}
			if(args[0].equalsIgnoreCase("ajuda") && !p.hasPermission("cash.admin")) {
				p.sendMessage("§e§lCash Comandos\n \n§e§l/cash §eOlha seu saldo de cash.\n \n§e§l/cash ajuda §eOlha os comandos.");
			return true;
			}
			if(args[0].equalsIgnoreCase("setar") && p.hasPermission("cash.admin")) {
				if(args.length <= 2) {
					p.sendMessage("§e§lUtilize §e/cash setar <jogador> <quantidade>");
					return true;
				}else {
					
					String jogador = args[1];
					String quantia = args[2];
					Double quanto = Mine.toDouble(quantia);
					if(quanto < 0) {
						p.sendMessage("§eQuantia inválida, tente um número maior ou igual a 0.");
					return true;
					}

					p.sendMessage("§eVocê setou "+quanto+" para "+jogador);
					Main.cash.set(jogador, quanto);
					Main.cash.saveConfig();
					
					return true;
				}
				
			}
			if(args[0].equalsIgnoreCase("adicionar") && p.hasPermission("cash.admin")) {
				if(args.length <= 2) {
					p.sendMessage("§e§lUtilize §e/cash adicionar <jogador> <quantidade>");
					return true;
				}else {
					String jogador = args[1];
					String quantia = args[2];
					Double quanto = Mine.toDouble(quantia);
					Double cash = Main.cash.getDouble(jogador);
					if(quanto < 0) {
						p.sendMessage("§eQuantia inválida, tente um número maior ou igual a 0.");
						return true;
					}
					p.sendMessage("§eVocê adicionou "+quanto+" para "+jogador);
					Main.cash.set(jogador, cash+quanto);
					Main.cash.saveConfig();
					return true;
				}
				
			}
			if(args[0].equalsIgnoreCase("saldo") && p.hasPermission("cash.admin")) {
				if(args.length <= 1) {
					p.sendMessage("§e§lUtilize §e/cash saldo <jogador>");
					return true;
				}else {
					String jogador = args[1];
					Double cash = Main.cash.getDouble(jogador);
					p.sendMessage("§e§lCash de "+jogador+": §e"+cash);
					return true;
				}
			}
			if(args[0].equalsIgnoreCase("remover") && p.hasPermission("cash.admin")) {
				if(args.length <= 2) {
					p.sendMessage("§e§lUtilize §e/cash remover <jogador> <quantidade>");
					return true;
				}else {
					String jogador = args[1];
					String quantia = args[2];
					Double cash = Main.cash.getDouble(jogador);
					Double quanto = Mine.toDouble(quantia);
					if(quanto > cash) {
						p.sendMessage("§eQuantia inválida, tente um número menor ou igual ao saldo do jogador.");
						return true;
					}
					if(quantia.contains("-")) {
						p.sendMessage("§eQuantia inválida, tente um número positivo apenas.");
						return true;
					}
					if(quanto <= cash) {
						Main.cash.set(jogador, cash-quanto);
						Main.cash.saveConfig();
						p.sendMessage("§eVocê removeu "+quanto+" de "+jogador);
						return true;
					}
				}
			}
			
		}
		return false;
	}
}
			
					
			

