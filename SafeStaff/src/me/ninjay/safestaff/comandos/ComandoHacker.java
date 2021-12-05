package me.ninjay.safestaff.comandos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoHacker implements CommandExecutor{
	
	public static HashMap<Player, Player> denuncia = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length == 0 || args[0].equalsIgnoreCase(p.getName())) {
				p.sendMessage("§aDenúncia enviada! Um moderador logo deve vir.");
				denuncia.put(p, null);
				for(Player all : Bukkit.getOnlinePlayers()) {
					if(all.hasPermission("hacker.admin")) {
						all.sendMessage(" \n§aNova solicitação de moderador!\n \n  §aVítima: "+p.getName()+"\n  §aAcusado: §cNão informado.\n \n§aPara aceitar a solicitação digite /tph "+p.getName()+"\n ");
					}
				}
			}else {
				p.sendMessage("§aDenúncia enviada! Um moderador logo deve vir.");
				denuncia.put(p, null);
				for(Player all : Bukkit.getOnlinePlayers()) {
					if(all.hasPermission("hacker.admin")) {
						all.sendMessage(" \n§aNova solicitação de moderador!\n \n  §aVítima: "+p.getName()+"\n  §aAcusado: §a"+args[0]+"\n \n§aPara aceitar a solicitação digite /tph "+p.getName()+"\n ");
					}
				}
			}
		}
		return false;
	}

}
