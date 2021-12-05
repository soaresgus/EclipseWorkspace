package me.ninjay.kustechest.comandos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.kustechest.main.Main;
import me.ninjay.kustechest.utils.Mine;

public class ComandoEchest implements CommandExecutor{
	
	public static ArrayList<Player> delay = new ArrayList<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(p.hasPermission("echest.use")) {
				if(!delay.contains(p)) {
					new BukkitRunnable() {
						int i = 30;
						@Override
						public void run() {
							i--;
							if(i <= 0) {
								cancel();
								delay.remove(p);
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
		return false;
	}

}
