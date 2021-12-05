package me.ninjay.kustbaus.comandos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.kustbaus.main.Main;
import me.ninjay.kustbaus.utils.Mine;

public class ComandoBauF implements CommandExecutor, Listener{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			Inventory menu = Mine.newInventory(p.getName(), 9*3);
			
			if(Main.getPlugin(Main.class).getConfig().getString(p.getName()) != null) {
				List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".itens");
				List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".slots");
			if(itens != null && slots != null) {
				int i = 0;
				for(ItemStack item : itens) {
					if(item != null) {
						menu.setItem(slots.get(i), item);
					}
					i++;
				}
			}
			}
			p.openInventory(menu);
			
		}
		return false;
	}
	
	@EventHandler
	public void aoFechar(InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer();
		
		if(e.getInventory().getTitle().equals(p.getName())) {
			
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
			
			Main.getPlugin(Main.class).getConfig().set(p.getName()+".itens", itens);
			Main.getPlugin(Main.class).getConfig().set(p.getName()+".slots", slots);
			Main.getPlugin(Main.class).saveConfig();
			Main.getPlugin(Main.class).reloadConfig();
		}
	}

}
