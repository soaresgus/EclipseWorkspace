package me.ninjay.galaxy.essentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.ninjay.galaxy.main.Main;
import me.ninjay.ninjaapi.utils.Mine;

public class ComandoCash implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (args.length == 0) {
				p.sendMessage("§e§lCash: §e" + Main.cash.getDouble(p.getName()));
				return true;
			}

			String sub = args[0];
			if (sub.equalsIgnoreCase("ajuda") && p.hasPermission("cash.admin")) {
				if(args.length == 0) {
					p.sendMessage("§e§lUtilize §e/cash ajuda");
				}
				p.sendMessage(
						"§e§lCash Comandos\n \n§e§l/cash §eOlha seu saldo de cash.\n \n§e§l/cash ajuda §eOlha os comandos.\n \n§e§l/cash setar <jogador> <quantidade> §eSeta a quantidade final de cash do jogador, ignorando a quantidade que o mesmo já possui.\n \n§e§l/cash adicionar <jogador> <quantidade> §eAdiciona uma quantidade de cash para o jogador + a quantidade que o mesmo já possui.\n \n§e§l/cash saldo <jogador> §eOlha o saldo de cash de cash de algum jogador.\n \n§e§l/cash remover <jogador> <quantidade> §eRemove a quantidade de cash do jogador - a quantia que o mesmo já possui.");
				return true;
			}
			if (sub.equalsIgnoreCase("ajuda") && p.hasPermission("cash.player")) {
				if (args.length == 0) {
					p.sendMessage("§e§lUtilize §e/cash ajuda");
					return true;
				}
				p.sendMessage(
						"§e§lCash Comandos\n \n§e§l/cash §eOlha seu saldo de cash.\n \n§e§l/cash ajuda §eOlha os comandos.");
				return true;
			}
			if (!p.hasPermission("cash.admin")) {
				return true;
			}
			if (sub.equalsIgnoreCase("saldo")) {

				if (args.length <= 1) {
					p.sendMessage("§e§lUtilize §e/cash saldo <jogador>");
					return true;
				}else {
				String jogador = args[1];
				p.sendMessage("§e§lCash de " + jogador + ": §e" + Main.cash.getDouble(jogador));
				return true;
			}
			}
			
			if(sub.equalsIgnoreCase("setar")) {
				if(args.length <= 2) {
					p.sendMessage("§e§lUtilize §e/cash setar <jogador> <quantidade>");
					return true;
				}else {
					String jogador = args[1];
					String quantidade = args[2];
					Double quantia = Mine.toDouble(quantidade);
					p.sendMessage("§eVocê setou §e§l"+quantia+" §ede cash para §e§l"+jogador);
					Main.cash.set(jogador, quantia);
					Main.cash.saveConfig();
					return true;
				}
			}
			if(sub.equalsIgnoreCase("adicionar")) {
				if(args.length <= 2) {
					p.sendMessage("§e§lUtilize §e/cash adicionar <jogador> <quantidade>");
                    return true;
				}else {
					String jogador = args[1];
					String quantidade = args[2];
					Double quantia = Mine.toDouble(quantidade);
					Double cash = Main.cash.getDouble(jogador);
					p.sendMessage("§eVocê adicionou §e§l"+quantia+" §ede cash para §e§l"+jogador);
					Main.cash.set(jogador, cash+quantia);
					Main.cash.saveConfig();
					return true;
				}
			}
			if(sub.equalsIgnoreCase("remover")) {
				if(args.length <= 2) {
					p.sendMessage("§e§lUtilize §e/cash remover <jogador> <quantidade>");
					return true;
				}else {
					String jogador = args[1];
					String quantidade = args[2];
					Double quantia = Mine.toDouble(quantidade);
					if(quantia <= 0) {
						p.sendMessage("§eQuantia inválida, tente remover um número de §e§l1 em diante !");
						return true;
					}else {
					Double cash = Main.cash.getDouble(jogador);
					p.sendMessage("§eVocê removeu §e§l"+quantia+" §ede cash de §e§l"+jogador);
					Main.cash.set(jogador, cash-quantia);
					Main.cash.saveConfig();
					return true;
				}
			}
			}
		
			
		}
		return false;
	}

}

