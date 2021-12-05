package me.ninjay.kustlogs.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.kustlogs.main.Main;

public class ComandoLocalizar implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.hasPermission("logs.admin")) {
				if(args.length <= 4) {
					p.sendMessage("§cUse: /localizar [staff/player] [chat/comando/geral/bau] [nick] [dia] [hora]");
					return true;
				}
				if(args[0].equalsIgnoreCase("staff")) {
					if(args[1].equalsIgnoreCase("comando")) {
						String hora = args[4].replace(":", "-");
						for(int i = 0; i <= 100; i++) {
							p.sendMessage(" ");
						}
					p.sendMessage("§eRegistros encontrados:");
						for(int i = 0; i <= Main.staffComando.getInt(args[3]+"."+args[2]); i++) {
							if(Main.staffComando.getString(args[3]+"."+hora+"."+args[2]+"."+i) != null) {
								p.sendMessage("§f- "+Main.staffComando.getString(args[3]+"."+hora+"."+args[2]+"."+i));
							}
						}
								
					}
					if(args[1].equalsIgnoreCase("chat")) {
						String hora = args[4].replace(":", "-");
						for(int i = 0; i <= 100; i++) {
							p.sendMessage(" ");
						}
					p.sendMessage("§eRegistros encontrados:");
						for(int i = 0; i <= Main.staffChat.getInt(args[3]+"."+args[2]); i++) {
							if(Main.staffChat.getString(args[3]+"."+hora+"."+args[2]+"."+i) != null) {
								p.sendMessage("§f- "+Main.staffChat.getString(args[3]+"."+hora+"."+args[2]+"."+i));
							}
						}
								
					}
					if(args[1].equalsIgnoreCase("geral")) {
						String hora = args[4].replace(":", "-");
						for(int i = 0; i <= 100; i++) {
							p.sendMessage(" ");
						}
					p.sendMessage("§eRegistros encontrados:");
						for(int i = 0; i <= Main.staffGeral.getInt(args[3]+"."+args[2]); i++) {
							if(Main.staffGeral.getString(args[3]+"."+hora+"."+args[2]+"."+i) != null) {
								p.sendMessage("§f- "+Main.staffGeral.getString(args[3]+"."+hora+"."+args[2]+"."+i));
							}
						}
								
					}
				}
				if(args[0].equalsIgnoreCase("player")) {
					if(args[1].equalsIgnoreCase("comando")) {
						String hora = args[4].replace(":", "-");
						for(int i = 0; i <= 100; i++) {
							p.sendMessage(" ");
						}
					p.sendMessage("§eRegistros encontrados:");
						for(int i = 0; i <= Main.playerComando.getInt(args[3]+"."+args[2]); i++) {
							if(Main.playerComando.getString(args[3]+"."+hora+"."+args[2]+"."+i) != null) {
								p.sendMessage("§f- "+Main.playerComando.getString(args[3]+"."+hora+"."+args[2]+"."+i));
							}
						}
								
					}
					if(args[1].equalsIgnoreCase("chat")) {
						String hora = args[4].replace(":", "-");
						for(int i = 0; i <= 100; i++) {
							p.sendMessage(" ");
						}
					p.sendMessage("§eRegistros encontrados:");
						for(int i = 0; i <= Main.playerChat.getInt(args[3]+"."+args[2]); i++) {
							if(Main.playerChat.getString(args[3]+"."+hora+"."+args[2]+"."+i) != null) {
								p.sendMessage("§f- "+Main.playerChat.getString(args[3]+"."+hora+"."+args[2]+"."+i));
							}
						}
					}
					if(args[1].equalsIgnoreCase("bau")) {
						String hora = args[4].replace(":", "-");
						for(int i = 0; i <= 100; i++) {
							p.sendMessage(" ");
						}
					p.sendMessage("§eRegistros encontrados:");
						for(int i = 0; i <= Main.playerBau.getInt(args[3]+"."+args[2]); i++) {
							if(Main.playerBau.getString(args[3]+"."+hora+"."+args[2]+"."+i) != null) {
								p.sendMessage("§f- "+Main.playerBau.getString(args[3]+"."+hora+"."+args[2]+"."+i));
							}
						}
								
					}
					if(args[1].equalsIgnoreCase("geral")) {
						String hora = args[4].replace(":", "-");
						for(int i = 0; i <= 100; i++) {
							p.sendMessage(" ");
						}
					p.sendMessage("§eRegistros encontrados:");
						for(int i = 0; i <= Main.playerGeral.getInt(args[3]+"."+args[2]); i++) {
							if(Main.playerGeral.getString(args[3]+"."+hora+"."+args[2]+"."+i) != null) {
								p.sendMessage("§f- "+Main.playerGeral.getString(args[3]+"."+hora+"."+args[2]+"."+i));
							}
						}
								
					}
				}
				
			}
		}
		
		return false;
	}

}
