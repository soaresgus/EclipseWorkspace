package me.ninjay.mineriosyoutubers.comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.mineriosyoutubers.estruturas.ItensAPI;
import me.ninjay.mineriosyoutubers.utils.Mine;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ItensAPI.minguadoore);
			p.getInventory().addItem(ItensAPI.bunnyore);
			p.getInventory().addItem(ItensAPI.luaore);
			p.getInventory().addItem(ItensAPI.jeredyore);
			
			p.getInventory().addItem(ItensAPI.minguadodrop);
			p.getInventory().addItem(ItensAPI.bunnydrop);
			p.getInventory().addItem(ItensAPI.luadrop);
			p.getInventory().addItem(ItensAPI.jeredydrop);
			
			p.getInventory().addItem(ItensAPI.minguadocapacete);
			p.getInventory().addItem(ItensAPI.minguadopeitoral);
			p.getInventory().addItem(ItensAPI.minguadocalca);
			p.getInventory().addItem(ItensAPI.minguadobota);
			p.getInventory().addItem(ItensAPI.minguadoespada);
			
			p.getInventory().addItem(ItensAPI.bunnycapacete);
			p.getInventory().addItem(ItensAPI.bunnypeitoral);
			p.getInventory().addItem(ItensAPI.bunnycalca);
			p.getInventory().addItem(ItensAPI.bunnybota);
			p.getInventory().addItem(ItensAPI.bunnypa);
			
			p.getInventory().addItem(ItensAPI.luacapacete);
			p.getInventory().addItem(ItensAPI.luapeitoral);
			p.getInventory().addItem(ItensAPI.luacalca);
			p.getInventory().addItem(ItensAPI.luabota);
			p.getInventory().addItem(ItensAPI.luapicareta);
			
			p.getInventory().addItem(ItensAPI.jeredycapacete);
			p.getInventory().addItem(ItensAPI.jeredypeitoral);
			p.getInventory().addItem(ItensAPI.jeredycalca);
			p.getInventory().addItem(ItensAPI.jeredybota);
			p.getInventory().addItem(ItensAPI.jeredymachado);
		}
		return false;
	}

}
