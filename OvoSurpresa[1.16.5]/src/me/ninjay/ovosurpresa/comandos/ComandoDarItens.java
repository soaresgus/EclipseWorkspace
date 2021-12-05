package me.ninjay.ovosurpresa.comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ovosurpresa.utils.Mine;

public class ComandoDarItens implements CommandExecutor{

	public static ItemStack ovo = Mine.newItem(Material.ORANGE_CONCRETE, "§6§lOvo Surpresa", 1, 0 , "§7Ultra Raro IV", "§7Fortuna V", "§7Sortudo X", "§7Inquebrável", "§7Presente III", " ", "  §cAbra este ovo e ganhe diversas supresas especias!");
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ovo);
			
		}
		return false;
	}

}
