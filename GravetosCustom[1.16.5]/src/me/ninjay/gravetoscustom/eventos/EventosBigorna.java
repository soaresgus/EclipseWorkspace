package me.ninjay.gravetoscustom.eventos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.gravetoscustom.estruturas.ItensAPI;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.Containers;
import net.minecraft.server.v1_16_R3.PacketPlayOutOpenWindow;

public class EventosBigorna implements Listener{
	/*
	public static ArrayList<Location> bigornas = new ArrayList<>();
	
	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		
		if(e.getBlock().getType() == Material.ANVIL) {
			if(bigornas != null && bigornas.contains(e.getBlock().getLocation())) {
			e.getBlock().setType(Material.AIR);
			e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), ItensAPI.bigorna);
			bigornas.remove(e.getBlock().getLocation());
		}
		}
	}
	
	@EventHandler
	public void onfall(BlockPhysicsEvent e) {
		if(e.getBlock().getType() == Material.ANVIL || e.getChangedType() == Material.ANVIL || e.getSourceBlock().getType() == Material.ANVIL) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void aoColocar(BlockPlaceEvent e) {
		
	if(e.getPlayer().getInventory().getItemInMainHand().isSimilar(ItensAPI.bigorna)) {
		Particle.DustOptions dust = new Particle.DustOptions(Color.fromRGB(255, 255, 0), 2);
		if(e.getBlock().getType() == Material.ANVIL) {
			bigornas.add(e.getBlock().getLocation());
			e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1F, 1F);
			e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.BLOCK_ANVIL_PLACE, 1F, 1F);
			e.getBlock().getWorld().getBlockAt(1000, 10, 1000).setType(Material.ANVIL);
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
	}
	
	@EventHandler
	public void cajadoCraft(PrepareAnvilEvent e) {
		 AnvilInventory anvilInv = e.getInventory();
         if (anvilInv.getItem(0) != null) {
        	if(anvilInv.getItem(1) != null){
        		if(anvilInv.getItem(0).getType() == Material.STICK) {
        			if(anvilInv.getItem(1).getType() == Material.PORKCHOP || anvilInv.getItem(1).getType() == Material.CHICKEN || anvilInv.getItem(1).getType() == Material.BEEF || anvilInv.getItem(1).getType() == Material.RABBIT || anvilInv.getItem(1).getType() == Material.MUTTON) {
        				e.setResult(ItensAPI.carne());
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
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("Carne")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.carne());
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
        		if(anvilInv.getItem(0).getType() == Material.STICK) {
        			if(anvilInv.getItem(1).getType() == Material.IRON_INGOT) {
        				e.setResult(ItensAPI.ferro());
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
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("Ferro")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.ferro());
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
        		if(anvilInv.getItem(0).getType() == Material.STICK) {
        			if(anvilInv.getItem(1).getType() == Material.GOLD_INGOT) {
        				e.setResult(ItensAPI.ouro());
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
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("Ouro")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.ouro());
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
        		if(anvilInv.getItem(0).getType() == Material.STICK) {
        			if(anvilInv.getItem(1).getType() == Material.DIAMOND) {
        				e.setResult(ItensAPI.dima());
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
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("Diamante")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.dima());
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
        		if(anvilInv.getItem(0).getType() == Material.STICK) {
        			if(anvilInv.getItem(1).getType() == Material.GUNPOWDER) {
        				e.setResult(ItensAPI.explo());
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
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("Explosivo")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.explo());
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
        		if(anvilInv.getItem(0).getType() == Material.STICK) {
        			if(anvilInv.getItem(1).getType() == Material.ENDER_PEARL) {
        				e.setResult(ItensAPI.ender());
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
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("Ender")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.ender());
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
        		if(anvilInv.getItem(0).getType() == Material.STICK) {
        			if(anvilInv.getItem(1).getType() == Material.BLAZE_ROD) {
        				e.setResult(ItensAPI.fogo());
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
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("Fogo")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.fogo());
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
        		if(anvilInv.getItem(0).getType() == Material.STICK) {
        			if(anvilInv.getItem(1).getType() == Material.CHEST) {
        				e.setResult(ItensAPI.bau());
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
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("Bau")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.bau());
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
        		if(anvilInv.getItem(0).getType() == Material.STICK) {
        			if(anvilInv.getItem(1).getType() == Material.ENDER_EYE) {
        				e.setResult(ItensAPI.strong());
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
						if(e.getInventory().getItem(2).getItemMeta().getDisplayName().contains("Strong")) {
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
						e.getInventory().setItem(0, new ItemStack(Material.AIR));
						e.getInventory().setItem(1, new ItemStack(Material.AIR));
						e.getInventory().setItem(2, new ItemStack(Material.AIR));
						p.setItemOnCursor(ItensAPI.strong());
					}
					}
				}
				}
			}
			
		}
	}
	
*/
}
