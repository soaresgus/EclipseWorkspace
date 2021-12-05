package me.ninjay.comerciante.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.comerciante.estruturas.ItensAPI;

public class ComandoReloadConfig implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("comerciante.admin")) {
				ItensAPI.configp.reloadConfig();
				ItensAPI.configp.saveConfig();
				ItensAPI.info.reloadConfig();
				ItensAPI.info.saveConfig();
				ItensAPI.config.reloadConfig();
				ItensAPI.config.saveConfig();
				
				p.sendMessage("§aConfigs reiniciadas e salvas.");
			}
		}
		return false;
	}

}
