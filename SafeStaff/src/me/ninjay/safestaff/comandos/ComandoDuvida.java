package me.ninjay.safestaff.comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoDuvida implements CommandExecutor{
	
	public static ArrayList<Player> solicit = new ArrayList<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage("§cUtilize: /duvida <dúvida>.");
				return true;
			}
			String msg = " ";
			for (int i = 0; i < args.length; i++) {
				msg = String.valueOf(msg) + args[i];
				msg = String.valueOf(msg) + " ";
			}
			p.sendMessage("§aDúvida enviada! Um membro da equipe disponível logo irá responder.");
			solicit.add(p);
			for(Player all : Bukkit.getOnlinePlayers()) {
				if(all.hasPermission("duvida.admin")) {
					all.sendMessage("§aO jogador "+p.getName()+" está com uma dúvida!\n \nDúvida:§f"+msg+"\n \n§aPara responder utilize: /responder <nick> <resposta>.\n ");
				}
			}
		}
		return false;
	}

}
