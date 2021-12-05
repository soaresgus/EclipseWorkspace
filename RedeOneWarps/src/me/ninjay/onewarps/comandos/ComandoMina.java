package me.ninjay.onewarps.comandos;

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

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.onewarps.main.Main;

public class ComandoMina implements CommandExecutor, Listener{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
		    Inventory menu = Mine.newInventory("Escolha uma mina", 9*3);
		    ItemStack mina = Mine.newItem(Material.LAPIS_ORE, "§6Mina Pública");
		    ItemStack pvp = Mine.newItem(Material.REDSTONE_ORE, "§6Mina PvP");
		    ItemStack vip = Mine.newItem(Material.DIAMOND_ORE, "§6Mina Vip");
		    menu.setItem(Mine.getPosition(2, 2), mina);
		    menu.setItem(Mine.getPosition(2, 5), pvp);
		    menu.setItem(Mine.getPosition(2, 8), vip);
		    p.openInventory(menu);
		}
		return false;
	}
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		 ItemStack mina = Mine.newItem(Material.LAPIS_ORE, "§6Mina Pública");
		 ItemStack pvp = Mine.newItem(Material.REDSTONE_ORE, "§6Mina PvP");
		 ItemStack vip = Mine.newItem(Material.DIAMOND_ORE, "§6Mina Vip");
		if(e.getInventory().getTitle().equals("Escolha uma mina")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(mina)) {
				p.getOpenInventory().close();
				p.sendMessage("§6Teleportado.");
				p.teleport(Main.locais.getLocation("mina_pb"));
				return;
			}
		}
		if(e.getInventory().getTitle().equals("Escolha uma mina")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(pvp)) {
				p.getOpenInventory().close();
				p.sendMessage("§6Teleportado.");
				p.teleport(Main.locais.getLocation("mina_pvp"));
				return;
			}
		}
		if(e.getInventory().getTitle().equals("Escolha uma mina")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(vip)) {
				if(p.hasPermission("warps.minavip")) {
				p.getOpenInventory().close();
				p.sendMessage("§6Teleportado.");
				p.teleport(Main.locais.getLocation("mina_vip"));
			}else {
				p.getOpenInventory().close();
				p.sendMessage("§cVocê não tem permissão para ir para esse local.");
				return;
			}
			}
		}
		
	}
	

}
