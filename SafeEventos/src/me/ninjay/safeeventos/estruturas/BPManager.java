package me.ninjay.safeeventos.estruturas;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.safeeventos.main.Main;
import me.ninjay.safeeventos.utils.BukkitConfig;
import me.ninjay.safeeventos.utils.Mine;


public class BPManager implements Listener{
	
	public static BukkitConfig config = new BukkitConfig("eventos.yml", Main.getPlugin(Main.class));
	public static ArrayList<Player> conf = new ArrayList<>();
	
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().contains("Eventos") || e.getInventory().getTitle().contains("Base perdida")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eBase perdida")) {
						Inventory menu = Mine.newInventory("Base perdida", 9*3);
						
						ItemStack spawn = Mine.newItem(Material.GRASS, "§eDefinir spawn");
						ItemStack iniciar = Mine.newItem(Material.EMERALD, "§eIniciar evento");
						
						menu.setItem(Mine.getPosition(2, 4), spawn);
						menu.setItem(Mine.getPosition(2, 6), iniciar);
						
						p.openInventory(menu);
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDefinir spawn")) {
						p.getOpenInventory().close();
						p.sendMessage("§eSpawn do evento definido.");
						config.set("bp.spawn", p.getLocation());
						config.saveConfig();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eIniciar evento")) {
						if(config.contains("bp.spawn")) {
							if(config.getBoolean("bp.ocorrendo") == false) {
							if(!conf.contains(p)) {
								p.getOpenInventory().close();
								p.sendMessage(" \n§c§lATENÇÃO - BASE PERDIDA\n \n§cAtenção! Esse é um evento grande.\nCaso realmente queira iniciar clique novamente.\n ");
								new BukkitRunnable() {
									
									@Override
									public void run() {
										conf.add(p);
									}
								}.runTaskLater(Main.getPlugin(Main.class), 2);
						}
						if(conf.contains(p)) {
							config.set("bp.ocorrendo", true);
							config.saveConfig();
							p.getOpenInventory().close();
							p.sendMessage("§aEvento iniciado!");
							for(int i = 0; i < 100; i++) {
								Bukkit.broadcastMessage(" ");
							}
							Bukkit.broadcastMessage(" \n§e§lEvento - Base Perdida\n \n§eFoi iniciado um evento §6Base Perdida§e!\n \n§ePara participar utilize §6/baseperdida §eou §6/bp\n \n§eO evento é de entrada gratuita e livre\n §eO evento logo será iniciado!\n ");
								}
							}else {
								p.getOpenInventory().close();
								p.sendMessage("§cEsse evento já está ocorrendo.");
							}
						}
					}
				}
			}
		}
	}
	
	
}
