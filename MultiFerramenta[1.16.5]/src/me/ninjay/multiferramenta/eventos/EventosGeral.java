package me.ninjay.multiferramenta.eventos;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.multiferramenta.estruturas.ItensAPI;

public class EventosGeral implements Listener{
	
	@EventHandler
	public void espadaretaCraft(PrepareAnvilEvent e) {
		 AnvilInventory anvilInv = e.getInventory();
         if (anvilInv.getItem(0) != null) {
        	if(anvilInv.getItem(1) != null){
        		if(anvilInv.getItem(0).getType() == Material.STONE_SWORD) {
        			if(anvilInv.getItem(1).getType() == Material.STONE_PICKAXE) {
        				e.setResult(ItensAPI.espadareta());
        			}
        		}
        	} 
        }
	}
	
	@EventHandler
	public void espadaretaClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getType() == InventoryType.ANVIL) {
			if(e.getCurrentItem() != null) {
				if(e.getSlot() == 2) {
					if(e.getInventory().getItem(2) != null) {
					if(e.getInventory().getItem(2).getItemMeta() != null) {
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("§6EspadaReta")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.espadareta());
					}
					}
				}
				}
			}
			
		}
	}
	
	@EventHandler
	public void pachadoCraft(PrepareAnvilEvent e) {
		 AnvilInventory anvilInv = e.getInventory();
         if (anvilInv.getItem(0) != null) {
        	if(anvilInv.getItem(1) != null){
        		if(anvilInv.getItem(0).getType() == Material.STONE_SHOVEL) {
        			if(anvilInv.getItem(1).getType() == Material.STONE_AXE) {
        				e.setResult(ItensAPI.pachado());
        			}
        		}
        	} 
        }
	}
	
	@EventHandler
	public void pachadoClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getType() == InventoryType.ANVIL) {
			if(e.getCurrentItem() != null) {
				if(e.getSlot() == 2) {
					if(e.getInventory().getItem(2) != null) {
					if(e.getInventory().getItem(2).getItemMeta() != null) {
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("§6PaChado")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.pachado());
					}
					}
				}
				}
			}
			
		}
	}
	
	@EventHandler
	public void basicoCraft(PrepareAnvilEvent e) {
		 AnvilInventory anvilInv = e.getInventory();
         if (anvilInv.getItem(0) != null) {
        	if(anvilInv.getItem(1) != null){
        		if(anvilInv.getItem(0).getItemMeta() != null) {
        			if(anvilInv.getItem(0).getItemMeta().getDisplayName() != null) {
        				if(anvilInv.getItem(0).getItemMeta().getDisplayName().contains("§6PaChado")) {
        					if(anvilInv.getItem(1).getItemMeta() != null) {
        	        			if(anvilInv.getItem(1).getItemMeta().getDisplayName() != null) {
        	        				if(anvilInv.getItem(1).getItemMeta().getDisplayName().contains("§6EspadaReta")) {
        	        					e.setResult(ItensAPI.multibasico());
        			}
        	        			}
        					}
        			}
        			}
        		}
        	} 
        }
	}
	
	@EventHandler
	public void basicoClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getType() == InventoryType.ANVIL) {
			if(e.getCurrentItem() != null) {
				if(e.getSlot() == 2) {
					if(e.getInventory().getItem(2) != null) {
					if(e.getInventory().getItem(2).getItemMeta() != null) {
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("§6Basico")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.multibasico());
					}
					}
				}
				}
			}
			
		}
	}
	
	@EventHandler
	public void quebrarRapido(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
	if(p.getInventory().getItemInMainHand() != null) {
		if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§6PaChado")) {
					if(e.getAction() == Action.LEFT_CLICK_BLOCK) {
						if(e.getClickedBlock().getType().toString().contains("PLANKS") || e.getClickedBlock().getType().toString().contains("WOOD") || e.getClickedBlock().getType().toString().contains("LOG") || e.getClickedBlock().getType().toString().contains("LEAVES")) {
							p.getInventory().getItemInMainHand().setType(Material.STONE_AXE);
						}
						if(e.getClickedBlock().getType().toString().contains("DIRT") || e.getClickedBlock().getType().toString().contains("GRASS") || e.getClickedBlock().getType().toString().contains("SAND")  || e.getClickedBlock().getType().toString().contains("GRAVEL")  || e.getClickedBlock().getType().toString().contains("CLAY")  || e.getClickedBlock().getType().toString().contains("SNOW")) {
							p.getInventory().getItemInMainHand().setType(Material.STONE_SHOVEL);
						}
					}
				}
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Basico")) {
					if(e.getAction() == Action.LEFT_CLICK_BLOCK) {
						if(e.getClickedBlock().getType().toString().contains("PLANKS") || e.getClickedBlock().getType().toString().contains("WOOD") || e.getClickedBlock().getType().toString().contains("LOG") || e.getClickedBlock().getType().toString().contains("LEAVES")) {
							p.getInventory().getItemInMainHand().setType(Material.STONE_AXE);
						}
						if(e.getClickedBlock().getType().toString().contains("DIRT") || e.getClickedBlock().getType().toString().contains("GRASS") || e.getClickedBlock().getType().toString().contains("SAND")  || e.getClickedBlock().getType().toString().contains("GRAVEL")  || e.getClickedBlock().getType().toString().contains("CLAY")  || e.getClickedBlock().getType().toString().contains("SNOW")) {
							p.getInventory().getItemInMainHand().setType(Material.STONE_SHOVEL);
						}
						if(e.getClickedBlock().getType().toString().contains("STONE") || e.getClickedBlock().getType().toString().contains("ORE") || e.getClickedBlock().getType().toString().contains("GRANITE")  || e.getClickedBlock().getType().toString().contains("DIORITE")  || e.getClickedBlock().getType().toString().contains("ANDESITE")  || e.getClickedBlock().getType().toString().contains("OBSIDIAN")) {
							p.getInventory().getItemInMainHand().setType(Material.STONE_PICKAXE);
						}
					}
				}
				
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Iniciante") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Intermediario")) {
					if(e.getAction() == Action.LEFT_CLICK_BLOCK) {
						if(e.getClickedBlock().getType().toString().contains("PLANKS") || e.getClickedBlock().getType().toString().contains("WOOD") || e.getClickedBlock().getType().toString().contains("LOG") || e.getClickedBlock().getType().toString().contains("LEAVES")) {
							p.getInventory().getItemInMainHand().setType(Material.IRON_AXE);
						}
						if(e.getClickedBlock().getType().toString().contains("DIRT") || e.getClickedBlock().getType().toString().contains("GRASS") || e.getClickedBlock().getType().toString().contains("SAND")  || e.getClickedBlock().getType().toString().contains("GRAVEL")  || e.getClickedBlock().getType().toString().contains("CLAY")  || e.getClickedBlock().getType().toString().contains("SNOW")) {
							p.getInventory().getItemInMainHand().setType(Material.IRON_SHOVEL);
						}
						if(e.getClickedBlock().getType().toString().contains("STONE") || e.getClickedBlock().getType().toString().contains("ORE") || e.getClickedBlock().getType().toString().contains("GRANITE")  || e.getClickedBlock().getType().toString().contains("DIORITE")  || e.getClickedBlock().getType().toString().contains("ANDESITE")  || e.getClickedBlock().getType().toString().contains("OBSIDIAN")) {
							p.getInventory().getItemInMainHand().setType(Material.IRON_PICKAXE);
						}
					}
				}
				
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Avancado") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Profissional")) {
					if(e.getAction() == Action.LEFT_CLICK_BLOCK) {
						if(e.getClickedBlock().getType().toString().contains("PLANKS") || e.getClickedBlock().getType().toString().contains("WOOD") || e.getClickedBlock().getType().toString().contains("LOG") || e.getClickedBlock().getType().toString().contains("LEAVES")) {
							p.getInventory().getItemInMainHand().setType(Material.DIAMOND_AXE);
						}
						if(e.getClickedBlock().getType().toString().contains("DIRT") || e.getClickedBlock().getType().toString().contains("GRASS") || e.getClickedBlock().getType().toString().contains("SAND")  || e.getClickedBlock().getType().toString().contains("GRAVEL")  || e.getClickedBlock().getType().toString().contains("CLAY")  || e.getClickedBlock().getType().toString().contains("SNOW")) {
							p.getInventory().getItemInMainHand().setType(Material.DIAMOND_SHOVEL);
						}
						if(e.getClickedBlock().getType().toString().contains("STONE") || e.getClickedBlock().getType().toString().contains("ORE") || e.getClickedBlock().getType().toString().contains("GRANITE")  || e.getClickedBlock().getType().toString().contains("DIORITE")  || e.getClickedBlock().getType().toString().contains("ANDESITE")  || e.getClickedBlock().getType().toString().contains("OBSIDIAN")) {
							p.getInventory().getItemInMainHand().setType(Material.DIAMOND_PICKAXE);
						}
					}
				}
				
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Especialista") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Elite") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Notch") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Deus")) {
					if(e.getAction() == Action.LEFT_CLICK_BLOCK) {
						if(e.getClickedBlock().getType().toString().contains("PLANKS") || e.getClickedBlock().getType().toString().contains("WOOD") || e.getClickedBlock().getType().toString().contains("LOG") || e.getClickedBlock().getType().toString().contains("LEAVES")) {
							p.getInventory().getItemInMainHand().setType(Material.NETHERITE_AXE);
						}
						if(e.getClickedBlock().getType().toString().contains("DIRT") || e.getClickedBlock().getType().toString().contains("GRASS") || e.getClickedBlock().getType().toString().contains("SAND")  || e.getClickedBlock().getType().toString().contains("GRAVEL")  || e.getClickedBlock().getType().toString().contains("CLAY")  || e.getClickedBlock().getType().toString().contains("SNOW")) {
							p.getInventory().getItemInMainHand().setType(Material.NETHERITE_SHOVEL);
						}
						if(e.getClickedBlock().getType().toString().contains("STONE") || e.getClickedBlock().getType().toString().contains("ORE") || e.getClickedBlock().getType().toString().contains("GRANITE")  || e.getClickedBlock().getType().toString().contains("DIORITE")  || e.getClickedBlock().getType().toString().contains("ANDESITE")  || e.getClickedBlock().getType().toString().contains("OBSIDIAN")) {
							p.getInventory().getItemInMainHand().setType(Material.NETHERITE_PICKAXE);
						}
					}
				}
			}
		}
	}
	}

}
