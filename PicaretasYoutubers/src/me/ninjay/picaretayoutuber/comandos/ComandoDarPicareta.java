package me.ninjay.picaretayoutuber.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.picaretayoutuber.estruturas.ItensAPI;

public class ComandoDarPicareta implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ItensAPI.minguado);
			p.getInventory().addItem(ItensAPI.moon);
			p.getInventory().addItem(ItensAPI.lua);
			p.getInventory().addItem(ItensAPI.jeredy);
			p.getInventory().addItem(ItensAPI.robin);
			p.getInventory().addItem(ItensAPI.tazer);
			
			p.getInventory().addItem(ItensAPI.minguadoh);
			p.getInventory().addItem(ItensAPI.moonh);
			p.getInventory().addItem(ItensAPI.luah);
			p.getInventory().addItem(ItensAPI.jeredyh);
			p.getInventory().addItem(ItensAPI.robinh);
			p.getInventory().addItem(ItensAPI.patwh);
			p.getInventory().addItem(ItensAPI.mikeh);
			
			p.getInventory().addItem(ItensAPI.tnt);
			p.getInventory().addItem(ItensAPI.lapis);
			p.getInventory().addItem(ItensAPI.pedra);
			p.getInventory().addItem(ItensAPI.ouro);
		}
		return false;
	}

}
