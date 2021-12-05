package me.ninjay.saferankup.comandos;

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

import me.ninjay.saferankup.estruturas.Rank;
import me.ninjay.saferankup.estruturas.RankAPI;
import me.ninjay.saferankup.utils.Mine;

public class ComandoRanks implements CommandExecutor, Listener{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			Rank rank1 = RankAPI.manager.getRankPorId(1);
			
			Inventory menu = Mine.newInventory("Ranks", 9*rank1.getFileirasInvRanks());
			
			Rank rankAtual = RankAPI.manager.getRankPorId(ComandoRankUP.config.getInt(p.getName()));
			
			ItemStack atual = Mine.newItem(Material.BOOK, "§eRank Atual", 1, 0, " ", " §7"+rankAtual.getName());
			
			for(Rank ranks : RankAPI.manager.getRanks()) {
				menu.setItem(Mine.getPosition(ranks.getFileiraRanks(), ranks.getSlotRanks()), ranks.getIconRanks());
			}
			
			menu.setItem(Mine.getPosition(rank1.getFileirasInvRanks(), 9), atual);
			p.openInventory(menu);
			
		}
		return false;
	}

	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		if(e.getInventory().getTitle().contains("Ranks")) {
			e.setCancelled(true);
			for(Rank ranks : RankAPI.manager.getRanks()) {
			if(e.getInventory().getTitle().contains(ranks.getName())) {
	}
		}
		}
	}
	
}
