package me.ninjay.geleiagolden.eventos;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.geleiagolden.estruturas.ItensAPI;

public class EventosBigorna implements Listener{
	
	
	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		
		if(e.getBlock().getType() == Material.ANVIL) {
			e.getBlock().setType(Material.AIR);
			e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), ItensAPI.bigorna);
		}
	}
	
	
	
	@EventHandler
	public void aoColocar(BlockPlaceEvent e) {
		
		Particle.DustOptions dust = new Particle.DustOptions(Color.fromRGB(255, 255, 0), 2);
		if(e.getBlock().getType() == Material.ANVIL) {
			e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1F, 1F);
			for(int x = 0; x < 3; x++) {
		    	for(int z = 0; z < 3; z++) {
		    		Location loc1 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
		    		Location loc2 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
		    		Location loc3 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
		    		Location loc4 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
		    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc1, 5, 0.1, 0.1, 0.1, dust);
		    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc2, 5, 0.1, 0.1, 0.1, dust);
		    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc3, 5, 0.1, 0.1, 0.1, dust);
		    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc4, 5, 0.1, 0.1, 0.1, dust);
		    		e.getBlock().getWorld().strikeLightningEffect(e.getBlock().getLocation());
		    	}
		    }
		}
	}
	
	
	@EventHandler
	public void cajadoCraft(PrepareAnvilEvent e) {
		 AnvilInventory anvilInv = e.getInventory();
         if (anvilInv.getItem(0) != null) {
        	if(anvilInv.getItem(1) != null){
        		if(anvilInv.getItem(0).getType() == Material.BLAZE_ROD) {
        			if(anvilInv.getItem(1).getType() == Material.ENDER_PEARL) {
        				e.setResult(ItensAPI.cajado);
        			}
        		}
        	} 
        }
	}
	
	@EventHandler
	public void cajadoCraftClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getType() == InventoryType.ANVIL) {
			if(e.getCurrentItem() != null) {
				if(e.getSlot() == 2) {
					if(e.getInventory().getItem(2) != null) {
					if(e.getInventory().getItem(2).getItemMeta() != null) {
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("§5Cajado")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.cajado);
					}
					}
				}
				}
			}
			
		}
	}
	
	@EventHandler
	public void espadaretaCraft(PrepareAnvilEvent e) {
		 AnvilInventory anvilInv = e.getInventory();
         if (anvilInv.getItem(0) != null) {
        	if(anvilInv.getItem(1) != null){
        		if(anvilInv.getItem(0).getType() == Material.DIAMOND_SWORD) {
        			if(anvilInv.getItem(1).getType() == Material.DIAMOND_PICKAXE) {
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
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("§5Espada")) {
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
	public void capaceteCraft(PrepareAnvilEvent e) {
		 AnvilInventory anvilInv = e.getInventory();
         if (anvilInv.getItem(0) != null) {
        	if(anvilInv.getItem(1) != null){
        		if(anvilInv.getItem(0).getType() == Material.DIAMOND_HELMET) {
        			if(anvilInv.getItem(1).getType() == Material.FEATHER) {
        				e.setResult(ItensAPI.capacete);
        			}
        		}
        	} 
        }
	}
	
	@EventHandler
	public void capaClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getType() == InventoryType.ANVIL) {
			if(e.getCurrentItem() != null) {
				if(e.getSlot() == 2) {
					if(e.getInventory().getItem(2) != null) {
					if(e.getInventory().getItem(2).getItemMeta() != null) {
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("§6Capacete")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.capacete);
					}
					}
				}
				}
			}
			
		}
	}
	
	@EventHandler
	public void peitoCraft(PrepareAnvilEvent e) {
		 AnvilInventory anvilInv = e.getInventory();
         if (anvilInv.getItem(0) != null) {
        	if(anvilInv.getItem(1) != null){
        		if(anvilInv.getItem(0).getType() == Material.DIAMOND_CHESTPLATE) {
        			if(anvilInv.getItem(1).getType() == Material.GOLDEN_APPLE) {
        				e.setResult(ItensAPI.peitoral);
        			}
        		}
        	} 
        }
	}
	
	@EventHandler
	public void peitoClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getType() == InventoryType.ANVIL) {
			if(e.getCurrentItem() != null) {
				if(e.getSlot() == 2) {
					if(e.getInventory().getItem(2) != null) {
					if(e.getInventory().getItem(2).getItemMeta() != null) {
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("§6Peitoral")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.peitoral);
					}
					}
				}
				}
			}
			
		}
	}
	
	@EventHandler
	public void calcaCraft(PrepareAnvilEvent e) {
		 AnvilInventory anvilInv = e.getInventory();
         if (anvilInv.getItem(0) != null) {
        	if(anvilInv.getItem(1) != null){
        		if(anvilInv.getItem(0).getType() == Material.DIAMOND_LEGGINGS) {
        			if(anvilInv.getItem(1).getType() == Material.FLINT_AND_STEEL) {
        				e.setResult(ItensAPI.calcas);
        			}
        		}
        	} 
        }
	}
	
	@EventHandler
	public void calcaClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getType() == InventoryType.ANVIL) {
			if(e.getCurrentItem() != null) {
				if(e.getSlot() == 2) {
					if(e.getInventory().getItem(2) != null) {
					if(e.getInventory().getItem(2).getItemMeta() != null) {
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("§6Calça")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.calcas);
					}
					}
				}
				}
			}
			
		}
	}
	
	@EventHandler
	public void botaCraft(PrepareAnvilEvent e) {
		 AnvilInventory anvilInv = e.getInventory();
         if (anvilInv.getItem(0) != null) {
        	if(anvilInv.getItem(1) != null){
        		if(anvilInv.getItem(0).getType() == Material.DIAMOND_BOOTS) {
        			if(anvilInv.getItem(1).getType() == Material.LADDER) {
        				e.setResult(ItensAPI.botas);
        			}
        		}
        	} 
        }
	}
	
	@EventHandler
	public void botaClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getType() == InventoryType.ANVIL) {
			if(e.getCurrentItem() != null) {
				if(e.getSlot() == 2) {
					if(e.getInventory().getItem(2) != null) {
					if(e.getInventory().getItem(2).getItemMeta() != null) {
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("§6Botas")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.botas);
					}
					}
				}
				}
			}
			
		}
	}
	
	@EventHandler
	public void shurikenCraft(PrepareAnvilEvent e) {
		 AnvilInventory anvilInv = e.getInventory();
         if (anvilInv.getItem(0) != null) {
        	if(anvilInv.getItem(1) != null){
        		if(anvilInv.getItem(0).getType() == Material.DIAMOND_SWORD) {
        			if(anvilInv.getItem(1).getType() == Material.IRON_SWORD) {
        				e.setResult(ItensAPI.shuriken());
        			}
        		}
        	} 
        }
	}
	
	@EventHandler
	public void shurikenClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getType() == InventoryType.ANVIL) {
			if(e.getCurrentItem() != null) {
				if(e.getSlot() == 2) {
					if(e.getInventory().getItem(2) != null) {
					if(e.getInventory().getItem(2).getItemMeta() != null) {
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("§9Shuriken")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.shuriken());
					}
					}
				}
				}
			}
			
		}
	}
	
	@EventHandler
	public void chuvaCraft(PrepareAnvilEvent e) {
		 AnvilInventory anvilInv = e.getInventory();
         if (anvilInv.getItem(0) != null) {
        	if(anvilInv.getItem(1) != null){
        		if(anvilInv.getItem(0).getType() == Material.ARROW) {
        			if(anvilInv.getItem(1).getType() == Material.DIAMOND) {
        				e.setResult(ItensAPI.chuva);
        			}
        		}
        	} 
        }
	}
	
	@EventHandler
	public void chuvaClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getType() == InventoryType.ANVIL) {
			if(e.getCurrentItem() != null) {
				if(e.getSlot() == 2) {
					if(e.getInventory().getItem(2) != null) {
					if(e.getInventory().getItem(2).getItemMeta() != null) {
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("§9Chuva")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.chuva);
					}
					}
				}
				}
			}
			
		}
	}
	
	@EventHandler
	public void correnteCraft(PrepareAnvilEvent e) {
		 AnvilInventory anvilInv = e.getInventory();
         if (anvilInv.getItem(0) != null) {
        	if(anvilInv.getItem(1) != null){
        		if(anvilInv.getItem(0).getType() == Material.MAGENTA_DYE) {
        			if(anvilInv.getItem(1).getType() == Material.CACTUS) {
        				e.setResult(ItensAPI.corrente);
        			}
        		}
        	} 
        }
	}
	
	@EventHandler
	public void correnteClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getType() == InventoryType.ANVIL) {
			if(e.getCurrentItem() != null) {
				if(e.getSlot() == 2) {
					if(e.getInventory().getItem(2) != null) {
					if(e.getInventory().getItem(2).getItemMeta() != null) {
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("§aCorrente")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.corrente);
					}
					}
				}
				}
			}
			
		}
	}
	
	@EventHandler
	public void picaretaCraft(PrepareAnvilEvent e) {
		 AnvilInventory anvilInv = e.getInventory();
         if (anvilInv.getItem(0) != null) {
        	if(anvilInv.getItem(1) != null){
        		if(anvilInv.getItem(0).getType() == Material.DIAMOND_PICKAXE) {
        			if(anvilInv.getItem(1).getType() == Material.TOTEM_OF_UNDYING) {
        				e.setResult(ItensAPI.picareta());
        			}
        		}
        	} 
        }
	}
	
	@EventHandler
	public void picaretaClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getType() == InventoryType.ANVIL) {
			if(e.getCurrentItem() != null) {
				if(e.getSlot() == 2) {
					if(e.getInventory().getItem(2) != null) {
					if(e.getInventory().getItem(2).getItemMeta() != null) {
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("§6Picareta")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.picareta());
					}
					}
				}
				}
			}
			
		}
	}
	
	@EventHandler
	public void machadoCraft(PrepareAnvilEvent e) {
		 AnvilInventory anvilInv = e.getInventory();
         if (anvilInv.getItem(0) != null) {
        	if(anvilInv.getItem(1) != null){
        		if(anvilInv.getItem(0).getType() == Material.DIAMOND_AXE) {
        			if(anvilInv.getItem(1).getType() == Material.GUNPOWDER) {
        				e.setResult(ItensAPI.machado);
        			}
        		}
        	} 
        }
	}
	
	@EventHandler
	public void machadoClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getType() == InventoryType.ANVIL) {
			if(e.getCurrentItem() != null) {
				if(e.getSlot() == 2) {
					if(e.getInventory().getItem(2) != null) {
					if(e.getInventory().getItem(2).getItemMeta() != null) {
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("§6Machado")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.machado);
					}
					}
				}
				}
			}
			
		}
	}
}
