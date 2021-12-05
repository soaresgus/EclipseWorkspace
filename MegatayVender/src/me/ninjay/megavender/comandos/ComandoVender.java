package me.ninjay.megavender.comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.megavender.main.Main;
import me.ninjay.megavender.utils.Mine;

public class ComandoVender implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("vender.perm")) {
				 if(!Main.pdrops.contains(p.getName()+"Shift") && !Main.pdrops.contains(p.getName()+"Auto")) {
				    	Main.pdrops.set(p.getName()+"Shift", "desativado");
				    	Main.pdrops.set(p.getName()+"Auto", "desativado");
				    	Main.pdrops.saveConfig();
				    	Main.pdrops.reloadConfig();
				 }
			Inventory menu = Mine.newInventory("Vender /drops", 9*3);
			ItemStack vender = Mine.newItem(Material.NETHER_STAR, "§eVenda seus drops", 1, 0, " ", "§e * Venda seus drops do /drops");
			ItemStack dados = Mine.newItem(Material.FEATHER, " ", 1, 0, " "," §eTotal de drops no /drops: "+Main.pdrops.getInt(p.getName()+"Total"), " §eTotal de drops de máquinas: ?"," ");
		    ItemStack shift = Mine.newItem(Material.ARROW, "§eVender com shift", 1, 0," ", "§e * A cada 2 segundos pressione shift para vender.", "§e * "+Main.pdrops.getString(p.getName()+"Shift").toUpperCase());
		    ItemStack auto = Mine.newItem(Material.EMERALD, "§eVender automático", 1, 0, " ", "§e * A cada 1.5 os drops serão vendidos.","§e * "+Main.pdrops.getString(p.getName()+"Auto").toUpperCase());
		    
		   
		    menu.setItem(Mine.getPosition(2, 5), vender);
		    menu.setItem(Mine.getPosition(1, 9), dados);
		    menu.setItem(Mine.getPosition(2, 3), shift);
		    menu.setItem(Mine.getPosition(2, 7), auto);
		    
		    p.openInventory(menu);
		    
		}else {
			p.sendMessage("§cSem permissão.");
			return true;
		}
		}
		return false;
	}

}
