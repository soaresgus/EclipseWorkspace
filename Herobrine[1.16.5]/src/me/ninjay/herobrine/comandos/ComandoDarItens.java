package me.ninjay.herobrine.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.herobrine.estruturas.ItensAPI;
import me.ninjay.herobrine.utils.Mine;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			Mine.clearHotBar(p);
			p.getInventory().setItem(0, ItensAPI.a);
			p.getInventory().setItem(1, ItensAPI.b);
			p.getInventory().setItem(2, ItensAPI.c);
			p.getInventory().setItem(3, ItensAPI.d);
			p.getInventory().setItem(4, ItensAPI.e);
			p.getInventory().setItem(5, ItensAPI.f);
			p.getInventory().setItem(6, ItensAPI.g);
			p.getInventory().setItem(7, ItensAPI.h);
			p.getInventory().setItem(8, ItensAPI.i);
		}
		return false;
	}

}
