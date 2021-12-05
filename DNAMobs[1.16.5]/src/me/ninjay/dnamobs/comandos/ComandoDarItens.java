package me.ninjay.dnamobs.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.dnamobs.estruturas.ItensAPI;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ItensAPI.enderman);
			p.getInventory().addItem(ItensAPI.guardian);
			p.getInventory().addItem(ItensAPI.porco);
			p.getInventory().addItem(ItensAPI.aranha);
			p.getInventory().addItem(ItensAPI.blaze);
			p.getInventory().addItem(ItensAPI.esqueleto);
			p.getInventory().addItem(ItensAPI.creeper);
			p.getInventory().addItem(ItensAPI.hoglin);
			
			p.getInventory().addItem(ItensAPI.endermanguardianegg);
			p.getInventory().addItem(ItensAPI.porcoaranhaegg);
			p.getInventory().addItem(ItensAPI.blazeesqueletoegg);
			p.getInventory().addItem(ItensAPI.creeperhoglinegg);
			
			p.getInventory().addItem(ItensAPI.endermanguardian);
			p.getInventory().addItem(ItensAPI.porcoaranha);
			p.getInventory().addItem(ItensAPI.blazeesqueleto);
			p.getInventory().addItem(ItensAPI.creeperhoglin);
			
			p.getInventory().addItem(ItensAPI.eggfinal);
		}
		return false;
	}

}
