package me.ninjay.onecaixas.comandos;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.onecaixas.estruturas.CaixaAPI;

public class ComprarCaixa implements CommandExecutor {
   
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
            p.getInventory().addItem(CaixaAPI.manager.getCaixa("basica").getIcone().clone());
			
		}
		return false;
	}

}
