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
		ItemStack frente = Mine.newItem(Material.ARROW, "�aPr�xima p�gina");
        ItemStack tras = Mine.newItem(Material.ARROW, "�aP�gina anterior");
        Inventory ranks2 = Mine.newInventory("Ranks 02", 9*5);
    	ItemStack demo3 = Mine.newItem("�eDemo III", Material.IRON_INGOT, 1, 0, "�fValor: �a$46.891M","�fBlocos: 105.000");
		ItemStack demo2 = Mine.newItem("�eDemo II", Material.IRON_INGOT, 2, 0, "�fValor: �a$71.384M","�fBlocos: 110.000");
		ItemStack demo1 = Mine.newItem("�eDemo I", Material.IRON_INGOT, 3, 0, "�fValor: �a$129.289M","�fBlocos: 115.000");
		
		ItemStack dingy3 = Mine.newItem("�eDingy III", Material.APPLE, 1, 0, "�fValor: �a$194.284M","�fBlocos: 120.000");
		ItemStack dingy2 = Mine.newItem("�eDingy II", Material.APPLE, 2, 0, "�fValor: �a$285.393M","�fBlocos: 125.000");
		ItemStack dingy1 = Mine.newItem("�eDingy I", Material.APPLE, 3, 0, "�fValor: �a$495.948M","�fBlocos: 130.000");
		
		ItemStack omega3 = Mine.newItem("�e�mega III", Material.NETHER_STAR, 1, 0, "�fValor: �a$658.958M","�fBlocos: 135.000");
		ItemStack omega2 = Mine.newItem("�e�mega II", Material.NETHER_STAR, 2, 0, "�fValor: �a$893.838M","�fBlocos: 140.000");
		ItemStack omega1 = Mine.newItem("�e�mega I", Material.NETHER_STAR, 3, 0, "�fValor: �a$1.383B","�fBlocos: 145.000");
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
		ItemStack cold3 = Mine.newItem("�eCold III", Material.COAL, 1, 0, "�fValor: �a$12.5K","�fBlocos: 30.000");
		ItemStack cold2 = Mine.newItem("�eCold II", Material.COAL, 2, 0, "�fValor: �a$21.87K","�fBlocos: 35.000");
		ItemStack cold1 = Mine.newItem("�eCold I", Material.COAL, 3, 0, "�fValor: �a$38.28K","�fBlocos: 40.000");
		
		ItemStack dark3 = Mine.newItem("�eDark III", Material.RED_MUSHROOM, 1, 0, "�fValor: �a$66.99K","�fBlocos: 45.000");
		ItemStack dark2 = Mine.newItem("�eDark II", Material.RED_MUSHROOM, 2, 0, "�fValor: �a$117.21K","�fBlocos: 50.000");
		ItemStack dark1 = Mine.newItem("�eDark I", Material.RED_MUSHROOM, 3, 0, "�fValor: �a$215.11K","�fBlocos: 55.000");
		
		ItemStack flight3 = Mine.newItem("�eFlight III", Material.SUGAR, 1, 0, "�fValor: �a$359K","�fBlocos: 60.000");
		ItemStack flight2 = Mine.newItem("�eFlight II", Material.SUGAR, 2, 0, "�fValor: �a$628.21K","�fBlocos: 65.000");
		ItemStack flight1 = Mine.newItem("�eFlight I", Material.SUGAR, 3, 0, "�fValor: �a$1.199M","�fBlocos: 70.000");
		
		ItemStack souls3 = Mine.newItem("�eSouls III", Material.GOLD_NUGGET, 1, 0, "�fValor: �a$1.924M","�fBlocos: 75.000");
		ItemStack souls2 = Mine.newItem("�eSouls II", Material.GOLD_NUGGET, 2, 0, "�fValor: �a$3.367M","�fBlocos: 80.000");
		ItemStack souls1 = Mine.newItem("�eSouls I", Material.GOLD_NUGGET, 3, 0, "�fValor: �a$5.892M","�fBlocos: 85.000");
		
		ItemStack killer3 = Mine.newItem("�eKiller III", Material.BLAZE_POWDER, 1, 0, "�fValor: �a$11.311M","�fBlocos: 90.000");
		ItemStack killer2 = Mine.newItem("�eKiller II", Material.BLAZE_POWDER, 2, 0, "�fValor: �a$18.141M","�fBlocos: 95.000");
		ItemStack killer1 = Mine.newItem("�eKiller I", Material.BLAZE_POWDER, 3, 0, "�fValor: �a$31.571M","�fBlocos: 100.000");
		
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
