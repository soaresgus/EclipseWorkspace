package me.ninjay.upsoulth.ranks;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;

public class EventosRanks implements Listener{
	
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack frente = Mine.newItem(Material.ARROW, "ßaPrÛxima p·gina");
        ItemStack tras = Mine.newItem(Material.ARROW, "ßaP·gina anterior");
        Inventory ranks2 = Mine.newInventory("Ranks 02", 9*5);
    	ItemStack demo3 = Mine.newItem("ßeDemo III", Material.IRON_INGOT, 1, 0, "ßfValor: ßa$46.891M","ßfBlocos: 105.000");
		ItemStack demo2 = Mine.newItem("ßeDemo II", Material.IRON_INGOT, 2, 0, "ßfValor: ßa$71.384M","ßfBlocos: 110.000");
		ItemStack demo1 = Mine.newItem("ßeDemo I", Material.IRON_INGOT, 3, 0, "ßfValor: ßa$129.289M","ßfBlocos: 115.000");
		
		ItemStack dingy3 = Mine.newItem("ßeDingy III", Material.APPLE, 1, 0, "ßfValor: ßa$194.284M","ßfBlocos: 120.000");
		ItemStack dingy2 = Mine.newItem("ßeDingy II", Material.APPLE, 2, 0, "ßfValor: ßa$285.393M","ßfBlocos: 125.000");
		ItemStack dingy1 = Mine.newItem("ßeDingy I", Material.APPLE, 3, 0, "ßfValor: ßa$495.948M","ßfBlocos: 130.000");
		
		ItemStack omega3 = Mine.newItem("ße‘mega III", Material.NETHER_STAR, 1, 0, "ßfValor: ßa$658.958M","ßfBlocos: 135.000");
		ItemStack omega2 = Mine.newItem("ße‘mega II", Material.NETHER_STAR, 2, 0, "ßfValor: ßa$893.838M","ßfBlocos: 140.000");
		ItemStack omega1 = Mine.newItem("ße‘mega I", Material.NETHER_STAR, 3, 0, "ßfValor: ßa$1.383B","ßfBlocos: 145.000");
        ranks2.setItem(Mine.getPosition(2, 3), demo3);
		ranks2.setItem(Mine.getPosition(3, 3), demo2);
		ranks2.setItem(Mine.getPosition(4, 3), demo1);

		ranks2.setItem(Mine.getPosition(2, 4), dingy3);
		ranks2.setItem(Mine.getPosition(3, 4), dingy2);
		ranks2.setItem(Mine.getPosition(4, 4), dingy1);
		
		ranks2.setItem(Mine.getPosition(2, 5), omega3);
		ranks2.setItem(Mine.getPosition(3, 5), omega2);
		ranks2.setItem(Mine.getPosition(4, 5), omega1);
		
		ranks2.setItem(Mine.getPosition(3, 2), tras);
		if(e.getInventory().getTitle().equals("Ranks 01")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(frente)) {
				p.openInventory(ranks2);
			}
		}
		ItemStack cold3 = Mine.newItem("ßeCold III", Material.COAL, 1, 0, "ßfValor: ßa$12.5K","ßfBlocos: 30.000");
		ItemStack cold2 = Mine.newItem("ßeCold II", Material.COAL, 2, 0, "ßfValor: ßa$21.87K","ßfBlocos: 35.000");
		ItemStack cold1 = Mine.newItem("ßeCold I", Material.COAL, 3, 0, "ßfValor: ßa$38.28K","ßfBlocos: 40.000");
		
		ItemStack dark3 = Mine.newItem("ßeDark III", Material.RED_MUSHROOM, 1, 0, "ßfValor: ßa$66.99K","ßfBlocos: 45.000");
		ItemStack dark2 = Mine.newItem("ßeDark II", Material.RED_MUSHROOM, 2, 0, "ßfValor: ßa$117.21K","ßfBlocos: 50.000");
		ItemStack dark1 = Mine.newItem("ßeDark I", Material.RED_MUSHROOM, 3, 0, "ßfValor: ßa$215.11K","ßfBlocos: 55.000");
		
		ItemStack flight3 = Mine.newItem("ßeFlight III", Material.SUGAR, 1, 0, "ßfValor: ßa$359K","ßfBlocos: 60.000");
		ItemStack flight2 = Mine.newItem("ßeFlight II", Material.SUGAR, 2, 0, "ßfValor: ßa$628.21K","ßfBlocos: 65.000");
		ItemStack flight1 = Mine.newItem("ßeFlight I", Material.SUGAR, 3, 0, "ßfValor: ßa$1.199M","ßfBlocos: 70.000");
		
		ItemStack souls3 = Mine.newItem("ßeSouls III", Material.GOLD_NUGGET, 1, 0, "ßfValor: ßa$1.924M","ßfBlocos: 75.000");
		ItemStack souls2 = Mine.newItem("ßeSouls II", Material.GOLD_NUGGET, 2, 0, "ßfValor: ßa$3.367M","ßfBlocos: 80.000");
		ItemStack souls1 = Mine.newItem("ßeSouls I", Material.GOLD_NUGGET, 3, 0, "ßfValor: ßa$5.892M","ßfBlocos: 85.000");
		
		ItemStack killer3 = Mine.newItem("ßeKiller III", Material.BLAZE_POWDER, 1, 0, "ßfValor: ßa$11.311M","ßfBlocos: 90.000");
		ItemStack killer2 = Mine.newItem("ßeKiller II", Material.BLAZE_POWDER, 2, 0, "ßfValor: ßa$18.141M","ßfBlocos: 95.000");
		ItemStack killer1 = Mine.newItem("ßeKiller I", Material.BLAZE_POWDER, 3, 0, "ßfValor: ßa$31.571M","ßfBlocos: 100.000");
		
		Inventory ranks = Mine.newInventory("Ranks 01", 9*5);
		
		ranks.setItem(Mine.getPosition(2, 3), cold3);
		ranks.setItem(Mine.getPosition(3, 3), cold2);
		ranks.setItem(Mine.getPosition(4, 3), cold1);
		
		ranks.setItem(Mine.getPosition(2, 4), dark3);
		ranks.setItem(Mine.getPosition(3, 4), dark2);
		ranks.setItem(Mine.getPosition(4, 4), dark1);
		
		ranks.setItem(Mine.getPosition(2, 5), flight3);
		ranks.setItem(Mine.getPosition(3, 5), flight2);
		ranks.setItem(Mine.getPosition(4, 5), flight1);
		
		ranks.setItem(Mine.getPosition(2, 6), souls3);
		ranks.setItem(Mine.getPosition(3, 6), souls2);
		ranks.setItem(Mine.getPosition(4, 6), souls1);
		
		ranks.setItem(Mine.getPosition(2, 7), killer3);
		ranks.setItem(Mine.getPosition(3, 7), killer2);
		ranks.setItem(Mine.getPosition(4, 7), killer1);
		
		ranks.setItem(Mine.getPosition(3, 8), frente);
		
		if(e.getInventory().getTitle().equals("Ranks 02")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(tras)) {
				p.openInventory(ranks);
				
			}
		}
	}

}
