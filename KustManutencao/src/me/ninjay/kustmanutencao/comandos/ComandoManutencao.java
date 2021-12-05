package me.ninjay.kustmanutencao.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoManutencao implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.hasPermission("menutencao.admin")) {
				if(Bukkit.hasWhitelist() == false) {
					p.sendMessage("§aManutenção ligada!");
					Bukkit.setWhitelist(true);
				}else {
					Bukkit.setWhitelist(false);
					p.sendMessage("§aManutenção desligada!");
				}
			}
			
		}else {
			if(Bukkit.hasWhitelist() == false) {
				sender.sendMessage("§aManutenção ligada!");
				Bukkit.setWhitelist(true);
			}else {
				Bukkit.setWhitelist(false);
				sender.sendMessage("§aManutenção desligada!");
			}
		}
		return false;
	}

}
