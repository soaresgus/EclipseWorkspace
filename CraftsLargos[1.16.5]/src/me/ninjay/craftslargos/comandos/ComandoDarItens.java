package me.ninjay.craftslargos.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.craftslargos.estruturas.ItensAPI;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ItensAPI.craft());
			p.getInventory().addItem(ItensAPI.beef());
			p.getInventory().addItem(ItensAPI.bacon());
			p.getInventory().addItem(ItensAPI.escudo());
			p.getInventory().addItem(ItensAPI.olho());
			p.getInventory().addItem(ItensAPI.peitoral1());
			p.getInventory().addItem(ItensAPI.peitoral2());
			p.getInventory().addItem(ItensAPI.peitoral3());
			p.getInventory().addItem(ItensAPI.peitoral4());
			p.getInventory().addItem(ItensAPI.espada1());
			p.getInventory().addItem(ItensAPI.espada2());
			p.getInventory().addItem(ItensAPI.espada3());
			p.getInventory().addItem(ItensAPI.espada4());
			p.getInventory().addItem(ItensAPI.espada5());
			p.getInventory().addItem(ItensAPI.picareta1());
			p.getInventory().addItem(ItensAPI.picareta2());
			p.getInventory().addItem(ItensAPI.picareta3());
			p.getInventory().addItem(ItensAPI.picareta4());
			p.getInventory().addItem(ItensAPI.picareta5());
			p.getInventory().addItem(ItensAPI.machado1());
			p.getInventory().addItem(ItensAPI.machado2());
			p.getInventory().addItem(ItensAPI.machado3());
			p.getInventory().addItem(ItensAPI.machado4());
			p.getInventory().addItem(ItensAPI.machado5());
			p.getInventory().addItem(ItensAPI.pa1());
			p.getInventory().addItem(ItensAPI.pa2());
			p.getInventory().addItem(ItensAPI.pa3());
			p.getInventory().addItem(ItensAPI.pa4());
			p.getInventory().addItem(ItensAPI.pa5());
			p.getInventory().addItem(ItensAPI.isqueiro());
			p.getInventory().addItem(ItensAPI.maca());
		}
		return false;
	}

}
