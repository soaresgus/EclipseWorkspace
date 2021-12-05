package me.ninjay.galaxy.kits;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.ninjaapi.utils.Mine;

public class ComandoKit implements Listener, CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String a, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			Inventory menu = Mine.newInventory("Kits", 9 * 3);
			ItemStack basico = Mine.newItem(Material.WOOD_PICKAXE, "�eKits B�sicos");
			ItemStack vip = Mine.newItem(Material.GOLDEN_APPLE, "�eKits Vips");
			ItemStack maquina = Mine.newItem(Material.ANVIL, "�eM�quinas");
			ItemStack especial = Mine.newItem(Material.QUARTZ, "�eItens Especiais");
			ItemStack caixas = Mine.newItem(Material.ENDER_CHEST, "�eCaixas Misteriosas");

			menu.setItem(Mine.getPosition(2, 2), basico);
			menu.setItem(Mine.getPosition(2, 3), vip);
			menu.setItem(Mine.getPosition(2, 5), maquina);
			menu.setItem(Mine.getPosition(2, 7), especial);
			menu.setItem(Mine.getPosition(2, 8), caixas);
			if (p.hasPermission("kit.menu")) {
				p.openInventory(menu);
				return true;
			}
		}
		return false;
	}

	@EventHandler
	public void aoClicarNoIncio(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		ItemStack basico = Mine.newItem(Material.WOOD_PICKAXE, "�eKits B�sicos");
		ItemStack vip = Mine.newItem(Material.GOLDEN_APPLE, "�eKits Vips");
		ItemStack maquina = Mine.newItem(Material.ANVIL, "�eM�quinas");
		ItemStack especial = Mine.newItem(Material.QUARTZ, "�eItens Especiais");
		ItemStack caixas = Mine.newItem(Material.ENDER_CHEST, "�eCaixas Misteriosas");

		Inventory basicom = Mine.newInventory("Kits B�sicos", 9 * 7);
		Inventory vipm = Mine.newInventory("Kits Vips", 9 * 5);
		Inventory maquinam = Mine.newInventory("M�quinas", 9 * 3);
		Inventory especialm = Mine.newInventory("Itens Especiais", 9 * 3);
		Inventory caixasm = Mine.newInventory("Caixas Misteriosas", 9 * 3);

		ItemStack basicok = Mine.newItem(Material.WOOD, "�eMembro B�sico");
	    ItemMeta basicokmeta = basicok.getItemMeta();
	    basicokmeta.setLore(Arrays.asList(" ","�fBot�o Esquerdo �6� �7Coletar o kit","�fBot�o Direito �6� �7Ver conte�do"));
	    basicok.setItemMeta(basicokmeta);
		
		ItemStack galaxyk = Mine.newItem(Material.DIAMOND_ORE, "�eGalaxy B�sico");
		 ItemMeta galaxykmeta = galaxyk.getItemMeta();
		    galaxykmeta.setLore(Arrays.asList(" ","�fBot�o Esquerdo �6� �7Coletar o kit","�fBot�o Direito �6� �7Ver conte�do"));
		    galaxyk.setItemMeta(galaxykmeta);
		
		ItemStack meteork = Mine.newItem(Material.GOLD_ORE, "�eMeteor B�sico");
		 ItemMeta meteorkmeta = meteork.getItemMeta();
		    meteorkmeta.setLore(Arrays.asList(" ","�fBot�o Esquerdo �6� �7Coletar o kit","�fBot�o Direito �6� �7Ver conte�do"));
		    meteork.setItemMeta(meteorkmeta);
		
		ItemStack moonk = Mine.newItem(Material.IRON_ORE, "�eMoon B�sico");
		ItemMeta moonkmeta = moonk.getItemMeta();
	    moonkmeta.setLore(Arrays.asList(" ","�fBot�o Esquerdo �6� �7Coletar o kit","�fBot�o Direito �6� �7Ver conte�do"));
	    moonk.setItemMeta(moonkmeta);

		ItemStack moondk = Mine.newItem(Material.IRON_INGOT, "�eMoon Di�rio");
		ItemMeta moondkmeta = moondk.getItemMeta();
	    moondkmeta.setLore(Arrays.asList(" ","�fBot�o Esquerdo �6� �7Coletar o kit","�fBot�o Direito �6� �7Ver conte�do"));
	    moondk.setItemMeta(moondkmeta);
		
		ItemStack moonsk = Mine.newItem(Material.IRON_ORE, "�eMoon Semanal");
		ItemMeta moonskmeta = moonsk.getItemMeta();
	    moonskmeta.setLore(Arrays.asList(" ","�fBot�o Esquerdo �6� �7Coletar o kit","�fBot�o Direito �6� �7Ver conte�do"));
	    moonsk.setItemMeta(moonskmeta);
		
		ItemStack moonmk = Mine.newItem(Material.IRON_BLOCK, "�eMoon Mensal");
		ItemMeta moonmkmeta = moonmk.getItemMeta();
	    moonmkmeta.setLore(Arrays.asList(" ","�fBot�o Esquerdo �6� �7Coletar o kit","�fBot�o Direito �6� �7Ver conte�do"));
	    moonmk.setItemMeta(moonmkmeta);
		
		ItemStack meteordk = Mine.newItem(Material.GOLD_INGOT, "�eMeteor Di�rio");
		ItemMeta meteordkmeta = meteordk.getItemMeta();
	    meteordkmeta.setLore(Arrays.asList(" ","�fBot�o Esquerdo �6� �7Coletar o kit","�fBot�o Direito �6� �7Ver conte�do"));
	    meteordk.setItemMeta(meteordkmeta);
		
		ItemStack meteorsk = Mine.newItem(Material.GOLD_ORE, "�eMeteor Semanal");
		ItemMeta meteorskmeta = meteorsk.getItemMeta();
	    meteorskmeta.setLore(Arrays.asList(" ","�fBot�o Esquerdo �6� �7Coletar o kit","�fBot�o Direito �6� �7Ver conte�do"));
	    meteorsk.setItemMeta(meteorskmeta);
		
		ItemStack meteormk = Mine.newItem(Material.GOLD_BLOCK, "�eMeteor Mensal");
		ItemMeta meteormkmeta = meteormk.getItemMeta();
	    meteormkmeta.setLore(Arrays.asList(" ","�fBot�o Esquerdo �6� �7Coletar o kit","�fBot�o Direito �6� �7Ver conte�do"));
	    meteormk.setItemMeta(meteormkmeta);
		
		ItemStack galaxydk = Mine.newItem(Material.DIAMOND, "�eGalaxy Di�rio");
		ItemMeta galaxydkmeta = galaxydk.getItemMeta();
	    galaxydkmeta.setLore(Arrays.asList(" ","�fBot�o Esquerdo �6� �7Coletar o kit","�fBot�o Direito �6� �7Ver conte�do"));
	    galaxydk.setItemMeta(galaxydkmeta);
		
		ItemStack galaxysk = Mine.newItem(Material.DIAMOND_ORE, "�eGalaxy Semanal");
		ItemMeta galaxyskmeta = galaxysk.getItemMeta();
	    galaxyskmeta.setLore(Arrays.asList(" ","�fBot�o Esquerdo �6� �7Coletar o kit","�fBot�o Direito �6� �7Ver conte�do"));
	    galaxysk.setItemMeta(galaxyskmeta);
		
		ItemStack galaxymk = Mine.newItem(Material.DIAMOND_BLOCK, "�eGalaxy Mensal");
		ItemMeta galaxymkmeta = galaxymk.getItemMeta();
	    galaxymkmeta.setLore(Arrays.asList(" ","�fBot�o Esquerdo �6� �7Coletar o kit","�fBot�o Direito �6� �7Ver conte�do"));
	    galaxymk.setItemMeta(galaxymkmeta);
	    
	    
	    
		if (e.getInventory().getTitle().equals("Kits")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(basico)) {
				basicom.setItem(Mine.getPosition(2, 2), basicok);
				basicom.setItem(Mine.getPosition(2, 4), moonk);
				basicom.setItem(Mine.getPosition(2, 6), meteork);
				basicom.setItem(Mine.getPosition(2, 8), galaxyk);
				p.openInventory(basicom);
				return;
			}
			if (e.getInventory().getTitle().equals("Kits")) {
				if (e.getCurrentItem().isSimilar(vip)) {
					vipm.setItem(Mine.getPosition(2, 3), moondk);
					vipm.setItem(Mine.getPosition(3, 3), moonsk);
					vipm.setItem(Mine.getPosition(4, 3), moonmk);
					
					vipm.setItem(Mine.getPosition(2, 5), meteordk);
					vipm.setItem(Mine.getPosition(3, 5), meteorsk);
					vipm.setItem(Mine.getPosition(4, 5), meteormk);
					
					vipm.setItem(Mine.getPosition(2, 7), galaxydk);
					vipm.setItem(Mine.getPosition(3, 7), galaxysk);
					vipm.setItem(Mine.getPosition(4, 7), galaxymk);
					p.openInventory(vipm);
					return;
  
				}
				if(e.getInventory().getTitle().equals("Kits")) {
					if(e.getCurrentItem().isSimilar(maquina)) {
						
					}
				}
			}
		}
	}
}
