package me.ninjay.upsoulth.comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;

public class ComandoSetarMina implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String a, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(!p.hasPermission("setmina.usar")) {
				p.sendMessage("§eVocê não tem permissão para utilizar esse comando.");
				return true;
			}
			ItemStack publica = Mine.newItem(Material.STONE_PICKAXE, "§9§lMina Ranks", 1, 0, "§fLiberada para §bTODOS"," ", "§fClique para setar.");
			ItemStack pvp = Mine.newItem(Material.STONE_SWORD, "§c§lMina PvP", 1, 0, "§fLiberada para §bTODOS"," ", "§fClique para setar.");
			ItemStack vip = Mine.newItem(Material.DIAMOND_PICKAXE, "§a§lMina Vip", 1, 0, "§fLiberada para §bVIPS"," ", "§fClique para setar.");
			Inventory set = Mine.newInventory("Escolha uma mina para setar", 9*3);
			set.setItem(Mine.getPosition(2, 2), publica);
			set.setItem(Mine.getPosition(2, 5), pvp);
			set.setItem(Mine.getPosition(2, 8), vip);
			if(p.hasPermission("setmina.usar")) {
				p.openInventory(set);
				return true;
			}
			
		}
		return false;
	}
	

}
