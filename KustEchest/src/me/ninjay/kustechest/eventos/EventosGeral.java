package me.ninjay.kustechest.eventos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.kustechest.comandos.ComandoEchest;
import me.ninjay.kustechest.main.Main;
import me.ninjay.kustechest.utils.Mine;


public class EventosGeral implements Listener{
	
	@EventHandler
	public void aoFechar(InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer();
		
		if(e.getInventory().getTitle().equals("Ender Chest")) {
			
			List<ItemStack> itens = new ArrayList<>();
			List<Integer> slots = new ArrayList<>();
			int i = 0;
			
			for(ItemStack item : e.getInventory().getContents()) {
				if(item != null) {
					itens.add(item);
					slots.add(i);
				}
				i++;
			}
			
			Main.getPlugin(Main.class).getConfig().set(p.getName()+".echest.itens", itens);
			Main.getPlugin(Main.class).getConfig().set(p.getName()+".echest.slots", slots);
			Main.getPlugin(Main.class).saveConfig();
			Main.getPlugin(Main.class).reloadConfig();
		}
	}
	
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(e.getClickedBlock() != null) {
			if(e.getClickedBlock().getType() == Material.ENDER_CHEST) {
				e.setCancelled(true);
				if(!ComandoEchest.delay.contains(p)) {
					new BukkitRunnable() {
						int i = 30;
						@Override
						public void run() {
							i--;
							if(i <= 0) {
								cancel();
								ComandoEchest.delay.remove(p);
							}
						}
					}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
					if(p.hasPermission("echest.3")) {
						Inventory echest = Mine.newInventory("Ender Chest", 9*3);
						if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".echest") != null) {
							List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".echest.itens");
							List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".echest.slots");
						if(itens != null && slots != null) {
							int i = 0;
							for(ItemStack item : itens) {
								if(item != null) {
									echest.setItem(slots.get(i), item);
								}
								i++;
							}
						}
						}
						p.openInventory(echest);
					}
					if(p.hasPermission("echest.4")) {
						Inventory echest = Mine.newInventory("Ender Chest", 9*4);
						if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".echest") != null) {
							List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".echest.itens");
							List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".echest.slots");
						if(itens != null && slots != null) {
							int i = 0;
							for(ItemStack item : itens) {
								if(item != null) {
									echest.setItem(slots.get(i), item);
								}
								i++;
							}
						}
						}
						p.openInventory(echest);
					}
					if(p.hasPermission("echest.5")) {
						Inventory echest = Mine.newInventory("Ender Chest", 9*5);
						if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".echest") != null) {
							List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".echest.itens");
							List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".echest.slots");
						if(itens != null && slots != null) {
							int i = 0;
							for(ItemStack item : itens) {
								if(item != null) {
									echest.setItem(slots.get(i), item);
								}
								i++;
							}
						}
						}
						p.openInventory(echest);
					}
					if(p.hasPermission("echest.6")) {
						Inventory echest = Mine.newInventory("Ender Chest", 9*6);
						if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".echest") != null) {
							List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".echest.itens");
							List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".echest.slots");
						if(itens != null && slots != null) {
							int i = 0;
							for(ItemStack item : itens) {
								if(item != null) {
									echest.setItem(slots.get(i), item);
								}
								i++;
							}
						}
						}
						p.openInventory(echest);
					}
				}else {
					p.sendMessage("§cAguarde para abrir seu enderchest novamente.");
				}
			}
		}
	}

}
