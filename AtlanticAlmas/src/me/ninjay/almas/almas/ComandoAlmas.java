package me.ninjay.almas.almas;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.almas.main.Main;
import me.ninjay.ninjaapi.utils.Mine;

public class ComandoAlmas implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage("§e§lSuas Almas: " + Main.almas.getDouble(p.getName()));
				return true;
			}
			if (!p.hasPermission("almas.admin")) {
				p.sendMessage("§c§lSem permissão.");
				return true;
			}
			String sub = args[0];
			if (sub.equalsIgnoreCase("setar") && p.hasPermission("almas.admin")) {
				if (args.length < 3) {
					p.sendMessage("§e§l/almas setar <jogador> <quantidade>");
				} else {
					String jogador = args[1];
					Double quantidade = Mine.toDouble(args[2]);
					Main.almas.set(jogador, quantidade);
					Main.almas.saveConfig();
					p.sendMessage("§e§lFoi setado " + quantidade + " alma(s) para " + jogador);

					return true;
				}
			}
			if (sub.equalsIgnoreCase("adicionar") && p.hasPermission("almas.admin")) {
				if (args.length < 3) {
					p.sendMessage("§e§l/almas adicionar <jogador> <quantidade>");
				} else {
					String jogador = args[1];
					Double quantidade = Mine.toDouble(args[2]);
					Double almas = Main.almas.getDouble(jogador);
					Main.almas.set(jogador, quantidade + almas);
					Main.almas.saveConfig();
					p.sendMessage("§e§lFoi adicionado " + quantidade + " alma(s) para " + jogador);
					return true;
				}
			}
			if (sub.equalsIgnoreCase("remover") && p.hasPermission("almas.admin")) {
				if (args.length < 3) {
					p.sendMessage(
							"§e§l/almas remover <jogador> <quantidade> §eApenas retire um número menor ou igual ao número atual de almas do jogador.");
				} else {
					String jogador = args[1];
					Double quantidade = Mine.toDouble(args[2]);
					Double almas = Main.almas.getDouble(jogador);
					Main.almas.set(jogador, almas - quantidade);
					Main.almas.saveConfig();
					p.sendMessage("§e§lFoi removido " + quantidade + " alma(s) para " + jogador);
					return true;

				}
			}

		

			if (args[0].equalsIgnoreCase("ajuda") && p.hasPermission("almas.admin")) {
				p.sendMessage(
						"§e§lAlmas Comandos - Jogadores\n \n/almas §eMostra suas almas que você possui\n \n§e§l/almas saldo <jogador> §eMostra o saldo de almas de outro jogador\n \n§e§lAlmas Comandos - Admin\n \n/almas setar <jogador> <quantidade> §eSeta a quantidade de almas do jogador independente de quantas almas o mesmo tiver\n \n§e§l/almas adicionar <jogador> <quantidade> §eAdiciona a quantidade de almas + as almas que o jogador já possui\n \n§e§l/almas remover <jogador> <quantidade> §eRemove a quantidade de almas - as almas que o jogador possui");
				return true;
			}
			if (args[0].equalsIgnoreCase("ajuda")) {
				p.sendMessage(
						"§e§lAlmas Comandos - Jogadores\n \n/almas §eMostra suas almas que você possui\n \n§e§l/almas saldo <jogador> §eMostra o saldo de almas de outro jogador");
				return true;
			}
			if (args[0].equalsIgnoreCase("saldo") && p.hasPermission("almas.admin")
					|| p.hasPermission("almas.player")) {
				if (args.length < 2) {
					p.sendMessage("§e§l/almas saldo <jogador>");

				} else {
					String jogador = args[1];
					p.sendMessage("§e§lAlmas de " + jogador + ": " + Main.almas.getDouble(jogador));
					return true;
				}
			}

		
	}
		return false;
}
}
