package me.ninjay.safestaff.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoTpm implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(!p.hasPermission("tpm.perm")) {
				p.sendMessage("§cSem permissão.");
			}
			if(args.length == 0) {
				p.sendMessage("§cUse: /tpm <nick>.");
				return true;
			}
			if(p.hasPermission("tpm.perm")) {
				Player tp = Bukkit.getPlayer(args[0]);
				if(tp == null) {
					p.sendMessage("§cEsse jogador está offline.");
				}
				if(tp != null) {
					if(tp.getWorld().getName().equalsIgnoreCase("mina")) {
						p.sendMessage("§aTeleportado até "+tp.getName()+".");
						p.teleport(tp);
					}else {
						for(Player all : Bukkit.getOnlinePlayers()) {
							if(all.getWorld().getName().equalsIgnoreCase("mina")) {
								p.sendMessage("§c- "+all.getName());
							}
						}
						p.sendMessage(" \n§cJogador não está na mina. Veja quem está na mina.");
					}
				}
			}
		}
		return false;
	}

}
