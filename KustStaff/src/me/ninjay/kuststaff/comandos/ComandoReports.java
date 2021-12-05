package me.ninjay.kuststaff.comandos;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.kuststaff.main.Main;
import me.ninjay.kuststaff.utils.Mine;

public class ComandoReports implements CommandExecutor, Listener{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.hasPermission("report.admin")) {
				Inventory menu = Mine.newInventory("Denúncias enviadas", 9*6);
				
				for(int i = 1; i <= Main.reports.getInt("reports"); i++) {
					ItemStack item = Mine.newHead("§c"+i, Main.reports.getString(i+".acusado"), 1, "§f  Acusado: §c"+Main.reports.getString(i+".acusado"),"§f  Motivo: §c"+Main.reports.getString(i+".motivo"), "§f  Vítima: §c"+Main.reports.getString(i+".vitima"), " ", "§cClique para aceitar.");
					menu.setItem(i-1, item);
				}
				p.openInventory(menu);
			}
			
		}
		return false;
	}

	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equalsIgnoreCase("Denúncias enviadas")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(ComandoVanish.ativo.contains(p)) {
					Integer number = Mine.toInt(e.getCurrentItem().getItemMeta().getDisplayName().replace("§c", ""));
					p.getOpenInventory().close();
					p.teleport(Bukkit.getPlayer(Main.reports.getString(number+".acusado")));
					p.setGameMode(GameMode.SPECTATOR);
					p.sendMessage("§aTeleportado para "+Main.reports.getString(number+".acusado"));
					p.setGameMode(GameMode.SPECTATOR);
					for(int i = (number+1)-1; i <= Main.reports.getInt("reports"); i++) {
						Main.reports.set(i+".acusado", Main.reports.get((i+1)+".acusado"));
						Main.reports.set(i+".motivo", Main.reports.get((i+1)+".motivo"));
						Main.reports.set(i+".vitima", Main.reports.get((i+1)+".vitima"));
						Main.reports.saveConfig();
					}
					
					Main.reports.remove(Main.reports.getInt("reports")+".acusado");
					Main.reports.remove(Main.reports.getInt("reports")+".motivo");
					Main.reports.remove(Main.reports.getInt("reports")+".vitima");
					Main.reports.set("reports", Main.reports.getInt("reports")-1);
					Main.reports.saveConfig();
					
					}else {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê precisa estar no modo VANISH (/v) para aceitar a denúncia.");
					}
				}
			}
		}
	}
	
}
