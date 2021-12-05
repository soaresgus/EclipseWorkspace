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

public class ComandoSetMina implements CommandExecutor, Listener {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("warps.admin")) {
			Inventory menu = Mine.newInventory("Escolha uma mina para setar", 9 * 3);
			ItemStack mina = Mine.newItem(Material.LAPIS_ORE, "§6Mina Pública",1,0," ");
			ItemStack pvp = Mine.newItem(Material.REDSTONE_ORE, "§6Mina PvP",1,0," ");
			ItemStack vip = Mine.newItem(Material.DIAMOND_ORE, "§6Mina Vip",1,0," ");
			menu.setItem(Mine.getPosition(2, 2), mina);
			menu.setItem(Mine.getPosition(2, 5), pvp);
			menu.setItem(Mine.getPosition(2, 8), vip);
			p.openInventory(menu);
		}
		}
		return false;
	}
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack mina = Mine.newItem(Material.LAPIS_ORE, "§6Mina Pública",1,0," ");
		ItemStack pvp = Mine.newItem(Material.REDSTONE_ORE, "§6Mina PvP",1,0," ");
		ItemStack vip = Mine.newItem(Material.DIAMOND_ORE, "§6Mina Vip",1,0," ");
		if(e.getInventory().getTitle().equals("Escolha uma mina para setar")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(mina)) {
				p.getOpenInventory().close();
				p.sendMessage("§6Mina pública setada.");
				Main.locais.set("mina_pb", p.getLocation());
				Main.locais.saveConfig();
				return;
			}
		}
		if(e.getInventory().getTitle().equals("Escolha uma mina para setar")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(pvp)) {
				p.getOpenInventory().close();
				p.sendMessage("§6Mina pvp setada.");
				Main.locais.set("mina_pvp", p.getLocation());
				Main.locais.saveConfig();
				return;
			}
		}
		if(e.getInventory().getTitle().equals("Escolha uma mina para setar")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(vip)) {
				p.getOpenInventory().close();
				p.sendMessage("§6Mina vip setada.");
				Main.locais.set("mina_vip", p.getLocation());
				Main.locais.saveConfig();
			    return;
		}
		}
		
	}
	

}
