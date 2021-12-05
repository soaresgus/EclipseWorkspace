package me.ninjay.comerciante.estruturas;

import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import me.ninjay.utils.utils.Mine;
import me.ninjay.utils.utils.VaultAPI;


public class ComercianteControler implements Listener{
	
	@EventHandler
	public static void aoBater(EntityDamageByEntityEvent e) {
		Entity m = e.getEntity();
		
		if(m instanceof Enderman) {
			if(m.getCustomName().contains("§e§lComerciante")) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public static void aoInteragir(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		
		if(e.getRightClicked() instanceof Enderman) {
			if(e.getRightClicked().getCustomName().equals("§e§lComerciante")) {
				p.closeInventory();
				p.chat("/comerciante");
			}
		}
	}
	
	@EventHandler
	public static void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getName().equals("Comerciante")) {
			e.setCancelled(true);
			if(e.getCurrentItem() == null) {
				e.setCancelled(true);
			}else {
				for(Itens item : ItensAPI.manager.getItens()) {
					if(e.getCurrentItem().isSimilar(item.getIcone())) {
						if(VaultAPI.getEconomy().has(p, item.getValor())) {
							if(ItensAPI.info.getInt(p.getName()+".limite") >= 1) {
								if(!Mine.isFull(p.getInventory())) {
									p.getOpenInventory().close();
									p.sendMessage("\n §aItem comprado com sucesso!\n ");
									VaultAPI.getEconomy().withdrawPlayer(p, item.getValor());
									ItensAPI.info.set(p.getName()+".limite", ItensAPI.info.getInt(p.getName()+".limite")-1);
									p.getInventory().addItem(item.getItem());
								}else {
									p.getOpenInventory().close();
									p.sendMessage("§cEsvazie seu inventário antes de comprar.");
								}
							}else {
								p.getOpenInventory().close();
								p.sendMessage("§cVocê atingiu seu limite de compras.");
							}
						}else {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê não tem o saldo suficiente.");
						}
					}else {
						return;
					}
				}
			}
		}
	}
	
	
	@EventHandler
	public static void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(!ItensAPI.info.contains(p.getName()+".limite")) {
			ItensAPI.info.set(p.getName()+".limite", ItensAPI.configp.getInt("LimitePorJogador"));
			ItensAPI.info.saveConfig();
		}else {
			return;
		}
	}
}
	
