package me.ninjay.axolotlcustom.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Axolotl;
import org.bukkit.entity.Player;

import me.ninjay.axolotlcustom.estruturas.ItensAPI;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ItensAPI.obsidian);
			p.getInventory().addItem(ItensAPI.cobre);
			p.getInventory().addItem(ItensAPI.redstone);
			p.getInventory().addItem(ItensAPI.ouro);
			p.getInventory().addItem(ItensAPI.diamante);
			
			p.getInventory().addItem(ItensAPI.capaobsi());
			p.getInventory().addItem(ItensAPI.peitoobsi());
			p.getInventory().addItem(ItensAPI.calcaobsi());
			p.getInventory().addItem(ItensAPI.botaobsi());
			p.getInventory().addItem(ItensAPI.espadaobsi());
			p.getInventory().addItem(ItensAPI.picaretaobsi());
			p.getInventory().addItem(ItensAPI.machadobsi());
			
			p.getInventory().addItem(ItensAPI.capacobre());
			p.getInventory().addItem(ItensAPI.peitocobre());
			p.getInventory().addItem(ItensAPI.calcacobre());
			p.getInventory().addItem(ItensAPI.botacobre());
			p.getInventory().addItem(ItensAPI.espadacobre());
			p.getInventory().addItem(ItensAPI.picaretacobre());
			p.getInventory().addItem(ItensAPI.machadcobre());
			
			p.getInventory().addItem(ItensAPI.pistao());
			
		}
		return false;
	}

}
