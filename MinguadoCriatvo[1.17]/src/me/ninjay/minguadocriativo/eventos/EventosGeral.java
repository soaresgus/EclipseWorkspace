package me.ninjay.minguadocriativo.eventos;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.minguadocriativo.estruturas.ItensAPI;
import me.ninjay.minguadocriativo.utils.Mine;

public class EventosGeral implements Listener{
	
	private static HashMap<Player, Integer> multiplicador = new HashMap<>();
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlock().getType() == Material.YELLOW_CONCRETE) {
			e.setCancelled(true);
		}
		
		if(e.getBlock().getType() == Material.ORANGE_CONCRETE) {
			p.getWorld().strikeLightningEffect(e.getBlock().getLocation().add(0.3, 0, 0.3));
			p.spawnParticle(Particle.CLOUD, e.getBlock().getLocation().add(0.3, 0.3, 0.3), 200, 0.1, 0.1, 0.1);
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) { 
		
		if(e.getBlock().getType() == Material.ORANGE_CONCRETE) {
			e.getPlayer().playSound(e.getBlock().getLocation(), Sound.BLOCK_ANVIL_PLACE, 1F, 1F);
			e.setDropItems(false);
			e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), ItensAPI.mesa());
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getClickedBlock().getType() == Material.ORANGE_CONCRETE) {
				p.openWorkbench(p.getLocation(), true);
			}
		}
	}
	
	@EventHandler
	public void onShift(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		
		if(e.isSneaking() == false) {
			if(p.getInventory().getItemInMainHand() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
						if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Espada")) {
							Inventory menu = Mine.newInventory("Escolha o multiplicador", 9*3);
							
							for(int i = 0; i<= 26; i++) {
								menu.setItem(i, Mine.newItem(Material.BLACK_STAINED_GLASS_PANE, " "));
							}
							
							ItemStack a = Mine.newItem(Material.BARRIER, "§e1x §7(Clique para ativar)", 1, 0, " ", "  §7Clique para multiplicar os drops de", "  §7todos os mobs em 1x!");
							ItemStack b = Mine.newItem(Material.BARRIER, "§e16x §7(Clique para ativar)", 1, 0, " ", "  §7Clique para multiplicar os drops de", "  §7todos os mobs em 16x!");
							ItemStack c = Mine.newItem(Material.BARRIER, "§e64x §7(Clique para ativar)", 1, 0, " ", "  §7Clique para multiplicar os drops de", "  §7todos os mobs em 64x!");
							ItemStack d = Mine.newItem(Material.BARRIER, "§e256x §7(Clique para ativar)", 1, 0, " ", "  §7Clique para multiplicar os drops de", "  §7todos os mobs em 256x!");
						
							menu.setItem(Mine.getPosition(2, 2), a);
							menu.setItem(Mine.getPosition(2, 4), b);
							menu.setItem(Mine.getPosition(2, 6), c);
							menu.setItem(Mine.getPosition(2, 8), d);
							
							p.openInventory(menu);
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getView().getTitle().contains("Escolha o multiplicador")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§e1x")) {
						p.getOpenInventory().close();
						p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
						p.sendMessage(" \n  §aO multiplicador de drops foi ativado em 1x!\n  Todos os mobs que foram mortos irão dropa 1x mais!\n ");
						multiplicador.remove(p);
						multiplicador.put(p, 1);
					}
					
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§e16x")) {
						p.getOpenInventory().close();
						p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
						p.sendMessage(" \n  §aO multiplicador de drops foi ativado em 16x!\n  Todos os mobs que foram mortos irão dropa 16x mais!\n ");
						multiplicador.remove(p);
						multiplicador.put(p, 16);
					}
					
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§e64x")) {
						p.getOpenInventory().close();
						p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
						p.sendMessage(" \n  §aO multiplicador de drops foi ativado em 64x!\n  Todos os mobs que foram mortos irão dropa 64x mais!\n ");
						multiplicador.remove(p);
						multiplicador.put(p, 64);
					}
					
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§e256x")) {
						p.getOpenInventory().close();
						p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
						p.sendMessage(" \n  §aO multiplicador de drops foi ativado em 256x!\n  Todos os mobs que foram mortos irão dropa 256x mais!\n ");
						multiplicador.remove(p);
						multiplicador.put(p, 256);
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onKill(EntityDeathEvent e) {
		
		if(e.getEntity() != null) {
			if(e.getEntityType() != EntityType.PLAYER) {
				if(e.getEntity().getKiller().getType() == EntityType.PLAYER) {
					Player p = e.getEntity().getKiller();
					
					if(multiplicador.get(p) != null) {
						for(ItemStack drops : e.getDrops()) {
							if(drops != null) {
								for(int i = 1; i <= multiplicador.get(p); i++) {
									ItemStack item = drops;
									e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), item);
								}
							}
						}
					}
				}
			}
		}
	}

}
