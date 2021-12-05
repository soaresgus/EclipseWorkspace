package me.ninjay.safestaff.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoResponder implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.hasPermission("duvida.admin")) {
				if(args.length <= 1) {
					p.sendMessage("§cUtilize: /responder <nick> <resposta>.");
				}else {
					if(ComandoDuvida.solicit.contains(Bukkit.getPlayer(args[0]))) {
						String msg = " ";
						for (int i = 1; i < args.length; i++) {
							msg = String.valueOf(msg) + args[i];
							msg = String.valueOf(msg) + " ";
						}
						p.sendMessage("§aDúvida respondida! Resposta enviada.");
						Bukkit.getPlayer(args[0]).sendMessage("§aSua dúvida foi respondida!\n \nResposta:§f"+msg+"\n ");
						ComandoDuvida.solicit.remove(Bukkit.getPlayer(args[0]));
					}else {
						p.sendMessage("§cEsse jogador não está com dúvidas.");
					}
				}
			}else {
				p.sendMessage("§cSem permissão.");
			}
		}
		return false;
	}

}
