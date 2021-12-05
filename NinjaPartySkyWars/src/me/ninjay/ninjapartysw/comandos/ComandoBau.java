package me.ninjay.ninjapartysw.comandos;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjapartysw.utils.Mine;

public class ComandoBau implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			Location bl = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
		
			bl.getBlock().setType(Material.CHEST);
			Chest bau = (Chest) bl.getBlock().getState();
			
			Inventory simulador = Mine.newInventory("Menu", 9*3);
			ItemStack ovo = Mine.newItem(Material.EGG, null, 5);
			ItemStack espada = Mine.newItem(Material.IRON_SWORD, null);
			ItemStack capa = Mine.newItem(Material.DIAMOND_HELMET, null);
			ItemStack peito = Mine.newItem(Material.DIAMOND_CHESTPLATE, null);
			ItemStack calca = Mine.newItem(Material.DIAMOND_LEGGINGS, null);
			ItemStack bota = Mine.newItem(Material.DIAMOND_BOOTS, null);
			ItemStack food = Mine.newItem(Material.COOKED_BEEF, null, 64);
			ItemStack bloco = Mine.newItem(Material.STONE, null, 64);
			ItemStack arco = Mine.newItem(Material.BOW, null);
			simulador.setItem(Mine.getPosition(1, Mine.getRandomInt(1, 3)), ovo);
			simulador.setItem(Mine.getPosition(2, Mine.getRandomInt(1, 3)), capa);
			simulador.setItem(Mine.getPosition(3, Mine.getRandomInt(1, 3)), espada);
			simulador.setItem(Mine.getPosition(1, Mine.getRandomInt(4, 6)), peito);
			simulador.setItem(Mine.getPosition(2, Mine.getRandomInt(4, 6)), calca);
			simulador.setItem(Mine.getPosition(3, Mine.getRandomInt(4, 6)), bota);
			simulador.setItem(Mine.getPosition(1, Mine.getRandomInt(7, 9)), food);
			simulador.setItem(Mine.getPosition(2, Mine.getRandomInt(7, 9)), bloco);
			simulador.setItem(Mine.getPosition(3, Mine.getRandomInt(7, 9)), arco);
			ItemStack[] invB = simulador.getContents();
			ItemStack[] invC = new ItemStack[invB.length];
			
			for(int i = 0; i < simulador.getSize(); i++) {
				invC[i] = invB[i]; 
			}
			for(int i = 0; i < simulador.getSize(); i++) {
				if(invC[i] != null) {
					bau.getInventory().setItem(i, invC[i]);
				}
			}
		return true;
		
		}
		return false;
	}

}
