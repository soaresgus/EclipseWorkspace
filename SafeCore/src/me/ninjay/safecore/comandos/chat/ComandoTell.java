package me.ninjay.safecore.comandos.chat;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoTell implements CommandExecutor {

	public static HashMap<Player, Player> resposta = new HashMap<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length <= 1) {
				p.sendMessage("§cUtilize: /tell <jogador> <mensagem>.");
				return true;
			}
			Player j = Bukkit.getPlayer(args[0]);
			String msg = " ";
			for (int i = 1; i < args.length; i++) {
				msg = String.valueOf(msg) + args[i];
				msg = String.valueOf(msg) + " ";
			}
			if (j == null) {
				p.sendMessage("§cO jogador está offline.");
				return true;
			}
			if (j != p) {
				j.sendMessage("§8[Mensagem de " + p.getName() + "]:§6" + msg);
				p.sendMessage("§8[Mensagem para " + j.getName() + "]:§6" + msg);
				resposta.put(p, j);
				resposta.put(j, p);
			} else {
				p.sendMessage("§cVocê não pode enviar tell para si mesmo.");
			}
		}
		return false;
	}

}
