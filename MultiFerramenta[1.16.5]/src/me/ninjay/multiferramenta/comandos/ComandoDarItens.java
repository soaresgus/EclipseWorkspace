package me.ninjay.multiferramenta.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.multiferramenta.estruturas.ItensAPI;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ItensAPI.espadareta());
			p.getInventory().addItem(ItensAPI.pachado());
			p.getInventory().addItem(ItensAPI.multibasico());
			p.getInventory().addItem(ItensAPI.multiiniciante());
			p.getInventory().addItem(ItensAPI.multiintermediario());
			p.getInventory().addItem(ItensAPI.multiavancado());
			p.getInventory().addItem(ItensAPI.multiprofissional());
			p.getInventory().addItem(ItensAPI.multiespecialista());
			p.getInventory().addItem(ItensAPI.multielite());
			p.getInventory().addItem(ItensAPI.multinotch());
			p.getInventory().addItem(ItensAPI.multideus());
		}
		return false;
	}

}
