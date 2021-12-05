package me.ninjay.onewarps.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.onewarps.main.Main;

public class ComandoSetLoja implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("warps.admin")) {
			p.sendMessage("§6Loja setada.");
			Main.locais.set("loja", p.getLocation());
			Main.locais.saveConfig();
		}
		}
		return false;
	}

}
