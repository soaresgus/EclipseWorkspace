package me.ninjay.safecore.comandos.chat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoR implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage("§cUtilize: /r <mensagem>.");
				return true;
			}
			String msg = " ";
			for (int i = 0; i < args.length; i++) {
				msg = String.valueOf(msg) + args[i];
				msg = String.valueOf(msg) + " ";
			}
			if (ComandoTell.resposta.get(p) != null) {
				if (ComandoTell.resposta.containsKey(p)) {
					if (ComandoTell.resposta.containsValue(ComandoTell.resposta.get(p))) {
						p.sendMessage("§8[Mensagem para " + ComandoTell.resposta.get(p).getName() + "]:§6" + msg);
						ComandoTell.resposta.get(p).sendMessage("§8[Mensagem de " + p.getName() + "]:§6" + msg);
					}
				}
			} else {
				p.sendMessage("§cNão possui ninguém para ser respondido.");
			}
		}
		return false;
	}

}
