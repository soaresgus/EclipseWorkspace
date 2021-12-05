package me.ninjay.blocoscustom.comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.blocoscustom.estruturas.ItensAPI;
import me.ninjay.blocoscustom.utils.Mine;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ItensAPI.terra());
			p.getInventory().addItem(ItensAPI.pedra());
			p.getInventory().addItem(ItensAPI.areia());
			p.getInventory().addItem(ItensAPI.obsidian());
			p.getInventory().addItem(ItensAPI.netherack());
			p.getInventory().addItem(ItensAPI.tnt());
			p.getInventory().addItem(ItensAPI.feno());
			p.getInventory().addItem(ItensAPI.pao());
			p.getInventory().addItem(ItensAPI.golden());
			p.getInventory().addItem(ItensAPI.cenoura());
			p.getInventory().addItem(ItensAPI.lava());
			p.getInventory().addItem(ItensAPI.agua());
			p.getInventory().addItem(ItensAPI.espada());
			p.getInventory().addItem(ItensAPI.arco());
			p.getInventory().addItem(ItensAPI.carvao());
			p.getInventory().addItem(ItensAPI.ferro());
			p.getInventory().addItem(ItensAPI.ouro());
			p.getInventory().addItem(ItensAPI.diamante());
		}
		return false;
	}

}
