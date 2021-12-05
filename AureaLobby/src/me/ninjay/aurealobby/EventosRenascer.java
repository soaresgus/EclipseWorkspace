package me.ninjay.aurealobby;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EventosRenascer implements Listener {

	@EventHandler
	public void renascer(PlayerRespawnEvent e) {
		ItemStack bus = new ItemStack(Material.COMPASS);
		ItemMeta busm = bus.getItemMeta();
		busm.setDisplayName("§eServidores");
		busm.setLore(Arrays.asList(" ", "§e§lBússola de navegação",
				" §7Utilize essa bússola para entrar em nossos servidores"));
		bus.setItemMeta(busm);
		
		ItemStack sem = new ItemStack(Material.INK_SACK, 1, (short) 1);
		ItemMeta semm = sem.getItemMeta();
		semm.setDisplayName("§cNenhum gadget selecionado");
		semm.setLore(Arrays.asList(" ","§cPara selecionar um gadget clique no item §eGadgets"));
		sem.setItemMeta(semm);
		
		ItemStack menu = new ItemStack(Material.NAME_TAG);
		ItemMeta menum = menu.getItemMeta();
		menum.setDisplayName("§eGadgets");
		menum.setLore(Arrays.asList(" ","§7Utilize para se divertir dentro do lobby"));
		menu.setItemMeta(menum);

		Player p = e.getPlayer();
		Main.permission.playerAdd(p, "anti.drop");
	

		p.getInventory().clear();

		p.updateInventory();
		p.getInventory().setItem(4, bus);
		p.getInventory().setItem(2, sem);
		p.getInventory().setItem(6, menu);
		p.setFoodLevel(999999999);

        p.teleport(Main.config.getLocation("spawn"));
		p.setMaxHealth(20);
	}

}
