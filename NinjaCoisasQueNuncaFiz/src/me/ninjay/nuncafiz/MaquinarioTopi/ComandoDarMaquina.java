package me.ninjay.nuncafiz.MaquinarioTopi;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.ninjay.nuncafiz.utils.Mine;

public class ComandoDarMaquina implements CommandExecutor{
	
	public static ItemStack maquina = Mine.newItem(Material.COAL_BLOCK, "Maquininha");
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			p.getInventory().addItem(maquina);
		}
		
		return false;
	}

}
