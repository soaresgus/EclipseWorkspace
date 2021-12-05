package me.ninjay.gravetoscustom.comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.gravetoscustom.estruturas.ItensAPI;
import me.ninjay.gravetoscustom.utils.Mine;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			/*p.getInventory().addItem(ItensAPI.bigorna);*/
			p.getInventory().addItem(ItensAPI.carne());
			p.getInventory().addItem(ItensAPI.ferro());
			p.getInventory().addItem(ItensAPI.ouro());
			p.getInventory().addItem(ItensAPI.dima());
			p.getInventory().addItem(ItensAPI.explo());
			p.getInventory().addItem(ItensAPI.ender());
			p.getInventory().addItem(ItensAPI.bau());
			p.getInventory().addItem(ItensAPI.fogo());
			p.getInventory().addItem(ItensAPI.strong());
		}
		return false;
	}

}
