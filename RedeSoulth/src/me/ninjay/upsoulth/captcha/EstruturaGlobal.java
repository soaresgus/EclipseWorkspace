package me.ninjay.upsoulth.captcha;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.upsoulth.main.Main;

public class EstruturaGlobal {
	
	public static void abrir(Player p, Inventory menu) {
		ItemStack bau = Mine.newItem(Material.CHEST, "§eClique no correto");
		ItemStack dima = Mine.newItem(Material.DIAMOND, "§eClique no correto");
		ItemStack craft = Mine.newItem(Material.WORKBENCH, "§eClique no correto");
		ItemStack abobora = Mine.newItem(Material.JACK_O_LANTERN, "§eClique no correto");
		menu.setItem(Mine.getPosition(2, 2), bau);
		menu.setItem(Mine.getPosition(2, 4), dima);
		menu.setItem(Mine.getPosition(2, 6), craft);
		menu.setItem(Mine.getPosition(2, 8), abobora);
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				p.getOpenInventory().close();
				p.openInventory(menu);
			}
		}.runTaskLater(Main.getPlugin(Main.class), 1);
		
	}
	public static void abrir2(Player p, Inventory menu) {
		ItemStack bau = Mine.newItem(Material.CHEST, "§eClique no correto",1,0,"");
		ItemStack dima = Mine.newItem(Material.DIAMOND, "§eClique no correto",1,0,"");
		ItemStack craft = Mine.newItem(Material.WORKBENCH, "§eClique no correto",1,0,"");
		ItemStack abobora = Mine.newItem(Material.JACK_O_LANTERN, "§eClique no correto",1,0,"");
		menu.setItem(Mine.getPosition(2, 2), bau);
		menu.setItem(Mine.getPosition(2, 4), dima);
		menu.setItem(Mine.getPosition(2, 8), craft);
		menu.setItem(Mine.getPosition(2, 6), abobora);
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				p.getOpenInventory().close();
				p.openInventory(menu);
			}
		}.runTaskLater(Main.getPlugin(Main.class), 1);
		
	}
	public static void abrirapido(Player p, Inventory menu) {
		ItemStack bau = Mine.newItem(Material.CHEST, "§eClique no correto",1,0,"");
		ItemStack dima = Mine.newItem(Material.DIAMOND, "§eClique no correto",1,0,"");
		ItemStack craft = Mine.newItem(Material.WORKBENCH, "§eClique no correto",1,0,"");
		ItemStack abobora = Mine.newItem(Material.JACK_O_LANTERN, "§eClique no correto",1,0,"");
		menu.setItem(Mine.getPosition(2, 2), bau);
		menu.setItem(Mine.getPosition(2, 4), dima);
		menu.setItem(Mine.getPosition(2, 8), craft);
		menu.setItem(Mine.getPosition(2, 6), abobora);
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				p.getOpenInventory().close();
				p.openInventory(menu);
			}
		}.runTaskLater(Main.getPlugin(Main.class), 1);
		
	}
	public static void abrir2rapido(Player p, Inventory menu) {
		ItemStack bau = Mine.newItem(Material.CHEST, "§eClique no correto",1,0,"");
		ItemStack dima = Mine.newItem(Material.DIAMOND, "§eClique no correto",1,0,"");
		ItemStack craft = Mine.newItem(Material.WORKBENCH, "§eClique no correto",1,0,"");
		ItemStack abobora = Mine.newItem(Material.JACK_O_LANTERN, "§eClique no correto",1,0,"");
		menu.setItem(Mine.getPosition(2, 2), bau);
		menu.setItem(Mine.getPosition(2, 4), dima);
		menu.setItem(Mine.getPosition(2, 8), craft);
		menu.setItem(Mine.getPosition(2, 6), abobora);
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				p.getOpenInventory().close();
				p.openInventory(menu);
			}
		}.runTaskLater(Main.getPlugin(Main.class),1);
		
	}
	

}
