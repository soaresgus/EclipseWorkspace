package me.ninjay.ossosmobs.eventos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.ossosmobs.estruturas.ItensAPI;
import me.ninjay.ossosmobs.main.Main;
import me.ninjay.ossosmobs.utils.Mine;

public class EventosGeral implements Listener{
	
	public static boolean usando = false;
	
	public static HashMap<String, Player> save = new HashMap<>();
	
	public static HashMap<Player, Integer> ossos = new HashMap<>();
	
	public static HashMap<Player, Boolean> aranha = new HashMap<>();
	public static HashMap<Player, Boolean> zumbi = new HashMap<>();
	public static HashMap<Player, Boolean> wither = new HashMap<>();
	public static HashMap<Player, Boolean> villger = new HashMap<>();
	public static HashMap<Player, Boolean> vaca = new HashMap<>();
	public static HashMap<Player, Boolean> porco = new HashMap<>();
	public static HashMap<Player, Boolean> ovelha = new HashMap<>();
	public static HashMap<Player, Boolean> galinha = new HashMap<>();
	public static HashMap<Player, Boolean> esqueleto = new HashMap<>();
	public static HashMap<Player, Boolean> creeper = new HashMap<>();
	
	public static Inventory menu = Bukkit.createInventory(null, InventoryType.SHULKER_BOX, " ");
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlock().getType() == Material.RED_CONCRETE) {
			if(usando == false) {
			usando=true;
			save.put("user", p);
			e.setCancelled(true);
			p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1F, 1F);
			new BukkitRunnable() {
				
				@Override
				public void run() {
					p.getInventory().remove(Material.RED_CONCRETE);
					p.getWorld().getBlockAt(e.getBlock().getLocation()).setType(Material.WHITE_STAINED_GLASS);
					p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, 1, 0)).setType(Material.WHITE_STAINED_GLASS);
					p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, 2, 0)).setType(Material.SMOOTH_STONE_SLAB);
				}
			}.runTaskLater(Main.getPlugin(Main.class), 2);
			p.teleport(e.getBlock().getLocation().add(0.5, 0, 0.5));
			
			}else {
				e.setCancelled(true);
				p.sendMessage("§c"+save.get("user").getName()+" está utilizando o scanner.");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
			}
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(ovelha.get(p) != null) {
			if(ovelha.get(p) == true) {
				p.setFoodLevel(20);
			}
		}
		
		if(e.getBlock().getType() == Material.WHITE_STAINED_GLASS || e.getBlock().getType() == Material.SMOOTH_STONE_SLAB) {
			if(usando == true) {
				usando=false;
				save.clear();
				e.setDropItems(false);
				p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
				e.getBlock().getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), ItensAPI.raiox);
				Bukkit.broadcastMessage("§cScanner de Raio-X retirado!");
				for(int y = (int)-3; y <= 3; y++) {
					if(p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, y, 0)).getType() == Material.WHITE_STAINED_GLASS || p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, y, 0)).getType() == Material.SMOOTH_STONE_SLAB) {
						p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, y, 0)).setType(Material.AIR);
					}
				}
			}
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(esqueleto.get(p) != null) {
			if(esqueleto.get(p) == true) {
				if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
					p.launchProjectile(Arrow.class);
				}
			}
		}
		
		if(usando == true) {
			if(e.getClickedBlock() != null) {
			if(e.getClickedBlock().getType() == Material.WHITE_STAINED_GLASS || e.getClickedBlock().getType() == Material.SMOOTH_STONE_SLAB) {
				if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					if(ossos.get(p) == null) {
					ossos.put(p, 10);
					menu.setItem(Mine.getPosition(2, 5), Mine.newHead("§6Raio-X de "+p.getName(), p.getName(), 1));
					menu.setItem(Mine.getPosition(2, 1), ItensAPI.patela);
					menu.setItem(Mine.getPosition(2, 3), ItensAPI.tarso);
					menu.setItem(Mine.getPosition(3, 1), ItensAPI.tibia);
					menu.setItem(Mine.getPosition(3, 2), ItensAPI.fibula);
					menu.setItem(Mine.getPosition(3, 3), ItensAPI.femur);
					menu.setItem(Mine.getPosition(1, 7), ItensAPI.umero);
					menu.setItem(Mine.getPosition(1, 8), ItensAPI.escapula);
					menu.setItem(Mine.getPosition(1, 9), ItensAPI.coluna);
					menu.setItem(Mine.getPosition(2, 7), ItensAPI.costela);
					menu.setItem(Mine.getPosition(2, 9), ItensAPI.clavicula);
					p.openInventory(menu);
				}else {
					if(ossos.get(p) == 10) {
						menu.setItem(Mine.getPosition(2, 5), Mine.newHead("§6Raio-X de "+p.getName(), p.getName(), 1));
						menu.setItem(Mine.getPosition(2, 1), ItensAPI.patela);
						menu.setItem(Mine.getPosition(2, 3), ItensAPI.tarso);
						menu.setItem(Mine.getPosition(3, 1), ItensAPI.tibia);
						menu.setItem(Mine.getPosition(3, 2), ItensAPI.fibula);
						menu.setItem(Mine.getPosition(3, 3), ItensAPI.femur);
						menu.setItem(Mine.getPosition(1, 7), ItensAPI.umero);
						menu.setItem(Mine.getPosition(1, 8), ItensAPI.escapula);
						menu.setItem(Mine.getPosition(1, 9), ItensAPI.coluna);
						menu.setItem(Mine.getPosition(2, 7), ItensAPI.costela);
						menu.setItem(Mine.getPosition(2, 9), ItensAPI.clavicula);
						p.openInventory(menu);
					}
					if(ossos.get(p) == 9) {
						menu.setItem(Mine.getPosition(2, 5), Mine.newHead("§6Raio-X de "+p.getName(), p.getName(), 1));
					if(menu.getItem(Mine.getPosition(2, 1)) != null) {
					if(!menu.getItem(Mine.getPosition(2, 1)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
					}
					}
						menu.setItem(Mine.getPosition(2, 3), ItensAPI.tarso);
						menu.setItem(Mine.getPosition(3, 1), ItensAPI.tibia);
						menu.setItem(Mine.getPosition(3, 2), ItensAPI.fibula);
						menu.setItem(Mine.getPosition(3, 3), ItensAPI.femur);
						menu.setItem(Mine.getPosition(1, 7), ItensAPI.umero);
						menu.setItem(Mine.getPosition(1, 8), ItensAPI.escapula);
						menu.setItem(Mine.getPosition(1, 9), ItensAPI.coluna);
						menu.setItem(Mine.getPosition(2, 7), ItensAPI.costela);
						menu.setItem(Mine.getPosition(2, 9), ItensAPI.clavicula);
						p.openInventory(menu);
					}
					if(ossos.get(p) == 8) {
						menu.setItem(Mine.getPosition(2, 5), Mine.newHead("§6Raio-X de "+p.getName(), p.getName(), 1));
						if(menu.getItem(Mine.getPosition(2, 1)) != null) {
						if(!menu.getItem(Mine.getPosition(2, 1)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
						}
						}
						if(menu.getItem(Mine.getPosition(2, 3)) != null) {
						if(!menu.getItem(Mine.getPosition(2, 3)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
						}
						}
						menu.setItem(Mine.getPosition(3, 1), ItensAPI.tibia);
						menu.setItem(Mine.getPosition(3, 2), ItensAPI.fibula);
						menu.setItem(Mine.getPosition(3, 3), ItensAPI.femur);
						menu.setItem(Mine.getPosition(1, 7), ItensAPI.umero);
						menu.setItem(Mine.getPosition(1, 8), ItensAPI.escapula);
						menu.setItem(Mine.getPosition(1, 9), ItensAPI.coluna);
						menu.setItem(Mine.getPosition(2, 7), ItensAPI.costela);
						menu.setItem(Mine.getPosition(2, 9), ItensAPI.clavicula);
						p.openInventory(menu);
					}
					if(ossos.get(p) == 7) {
						menu.setItem(Mine.getPosition(2, 5), Mine.newHead("§6Raio-X de "+p.getName(), p.getName(), 1));
						if(menu.getItem(Mine.getPosition(2, 1)) != null) {
						if(!menu.getItem(Mine.getPosition(2, 1)).getItemMeta().getDisplayName().contains("Osso")) {
							menu.setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(2, 3)) != null) {
							if(!menu.getItem(Mine.getPosition(2, 3)).getItemMeta().getDisplayName().contains("Osso")) {
							menu.setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 1)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 1)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
							}
						}
						menu.setItem(Mine.getPosition(3, 2), ItensAPI.fibula);
						menu.setItem(Mine.getPosition(3, 3), ItensAPI.femur);
						menu.setItem(Mine.getPosition(1, 7), ItensAPI.umero);
						menu.setItem(Mine.getPosition(1, 8), ItensAPI.escapula);
						menu.setItem(Mine.getPosition(1, 9), ItensAPI.coluna);
						menu.setItem(Mine.getPosition(2, 7), ItensAPI.costela);
						menu.setItem(Mine.getPosition(2, 9), ItensAPI.clavicula);
						p.openInventory(menu);
					}
					if(ossos.get(p) == 6) {
						menu.setItem(Mine.getPosition(2, 5), Mine.newHead("§6Raio-X de "+p.getName(), p.getName(), 1));
						if(menu.getItem(Mine.getPosition(2, 1)) != null) {
						if(!menu.getItem(Mine.getPosition(2, 1)).getItemMeta().getDisplayName().contains("Osso")) {
							menu.setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(2, 3)) != null) {
							if(!menu.getItem(Mine.getPosition(2, 3)).getItemMeta().getDisplayName().contains("Osso")) {
							menu.setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 1)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 1)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 2)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 2)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 2), new ItemStack(Material.AIR));
							}
						}
						menu.setItem(Mine.getPosition(3, 3), ItensAPI.femur);
						menu.setItem(Mine.getPosition(1, 7), ItensAPI.umero);
						menu.setItem(Mine.getPosition(1, 8), ItensAPI.escapula);
						menu.setItem(Mine.getPosition(1, 9), ItensAPI.coluna);
						menu.setItem(Mine.getPosition(2, 7), ItensAPI.costela);
						menu.setItem(Mine.getPosition(2, 9), ItensAPI.clavicula);
						p.openInventory(menu);
					}
					if(ossos.get(p) == 5) {
						menu.setItem(Mine.getPosition(2, 5), Mine.newHead("§6Raio-X de "+p.getName(), p.getName(), 1));
						if(menu.getItem(Mine.getPosition(2, 1)) != null) {
						if(!menu.getItem(Mine.getPosition(2, 1)).getItemMeta().getDisplayName().contains("Osso")) {
							menu.setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(2, 3)) != null) {
							if(!menu.getItem(Mine.getPosition(2, 3)).getItemMeta().getDisplayName().contains("Osso")) {
							menu.setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 1)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 1)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 2)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 2)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 2), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 3)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 3)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 3), new ItemStack(Material.AIR));
							}
						}
						menu.setItem(Mine.getPosition(1, 7), ItensAPI.umero);
						menu.setItem(Mine.getPosition(1, 8), ItensAPI.escapula);
						menu.setItem(Mine.getPosition(1, 9), ItensAPI.coluna);
						menu.setItem(Mine.getPosition(2, 7), ItensAPI.costela);
						menu.setItem(Mine.getPosition(2, 9), ItensAPI.clavicula);
						p.openInventory(menu);
					}
					if(ossos.get(p) == 4) {
						menu.setItem(Mine.getPosition(2, 5), Mine.newHead("§6Raio-X de "+p.getName(), p.getName(), 1));
						if(menu.getItem(Mine.getPosition(2, 1)) != null) {
						if(!menu.getItem(Mine.getPosition(2, 1)).getItemMeta().getDisplayName().contains("Osso")) {
							menu.setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(2, 3)) != null) {
							if(!menu.getItem(Mine.getPosition(2, 3)).getItemMeta().getDisplayName().contains("Osso")) {
							menu.setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 1)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 1)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 2)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 2)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 2), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 3)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 3)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 3), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(1, 7)) != null) {
							if(!menu.getItem(Mine.getPosition(1, 7)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(1, 7), new ItemStack(Material.AIR));
							}
						}
						menu.setItem(Mine.getPosition(1, 8), ItensAPI.escapula);
						menu.setItem(Mine.getPosition(1, 9), ItensAPI.coluna);
						menu.setItem(Mine.getPosition(2, 7), ItensAPI.costela);
						menu.setItem(Mine.getPosition(2, 9), ItensAPI.clavicula);
						p.openInventory(menu);
					}
					if(ossos.get(p) == 3) {
						menu.setItem(Mine.getPosition(2, 5), Mine.newHead("§6Raio-X de "+p.getName(), p.getName(), 1));
						if(menu.getItem(Mine.getPosition(2, 1)) != null) {
						if(!menu.getItem(Mine.getPosition(2, 1)).getItemMeta().getDisplayName().contains("Osso")) {
							menu.setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(2, 3)) != null) {
							if(!menu.getItem(Mine.getPosition(2, 3)).getItemMeta().getDisplayName().contains("Osso")) {
							menu.setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 1)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 1)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 2)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 2)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 2), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 3)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 3)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 3), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(1, 7)) != null) {
							if(!menu.getItem(Mine.getPosition(1, 7)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(1, 7), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(1, 8)) != null) {
							if(!menu.getItem(Mine.getPosition(1, 8)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(1, 8), new ItemStack(Material.AIR));
							}
						}
						menu.setItem(Mine.getPosition(1, 9), ItensAPI.coluna);
						menu.setItem(Mine.getPosition(2, 7), ItensAPI.costela);
						menu.setItem(Mine.getPosition(2, 9), ItensAPI.clavicula);
						p.openInventory(menu);
					}
					if(ossos.get(p) == 2) {
						menu.setItem(Mine.getPosition(2, 5), Mine.newHead("§6Raio-X de "+p.getName(), p.getName(), 1));
						if(menu.getItem(Mine.getPosition(2, 1)) != null) {
						if(!menu.getItem(Mine.getPosition(2, 1)).getItemMeta().getDisplayName().contains("Osso")) {
							menu.setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(2, 3)) != null) {
							if(!menu.getItem(Mine.getPosition(2, 3)).getItemMeta().getDisplayName().contains("Osso")) {
							menu.setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 1)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 1)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 2)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 2)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 2), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 3)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 3)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 3), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(1, 7)) != null) {
							if(!menu.getItem(Mine.getPosition(1, 7)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(1, 7), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(1, 8)) != null) {
							if(!menu.getItem(Mine.getPosition(1, 8)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(1, 8), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(1, 9)) != null) {
							if(!menu.getItem(Mine.getPosition(1, 9)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(1, 9), new ItemStack(Material.AIR));
							}
						}
						menu.setItem(Mine.getPosition(2, 7), ItensAPI.costela);
						menu.setItem(Mine.getPosition(2, 9), ItensAPI.clavicula);
						p.openInventory(menu);
					}
					if(ossos.get(p) == 1) {
						menu.setItem(Mine.getPosition(2, 5), Mine.newHead("§6Raio-X de "+p.getName(), p.getName(), 1));
						if(menu.getItem(Mine.getPosition(2, 1)) != null) {
						if(!menu.getItem(Mine.getPosition(2, 1)).getItemMeta().getDisplayName().contains("Osso")) {
							menu.setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(2, 3)) != null) {
							if(!menu.getItem(Mine.getPosition(2, 3)).getItemMeta().getDisplayName().contains("Osso")) {
							menu.setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 1)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 1)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 2)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 2)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 2), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 3)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 3)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 3), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(1, 7)) != null) {
							if(!menu.getItem(Mine.getPosition(1, 7)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(1, 7), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(1, 8)) != null) {
							if(!menu.getItem(Mine.getPosition(1, 8)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(1, 8), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(1, 9)) != null) {
							if(!menu.getItem(Mine.getPosition(1, 9)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(1, 9), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(2, 7)) != null) {
							if(!menu.getItem(Mine.getPosition(2, 7)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(2, 7), new ItemStack(Material.AIR));
							}
						}
						menu.setItem(Mine.getPosition(2, 9), ItensAPI.clavicula);
						p.openInventory(menu);
					}
					if(ossos.get(p) == 0) {
						if(menu.getItem(Mine.getPosition(2, 1)) != null) {
						if(!menu.getItem(Mine.getPosition(2, 1)).getItemMeta().getDisplayName().contains("Osso")) {
							menu.setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(2, 3)) != null) {
							if(!menu.getItem(Mine.getPosition(2, 3)).getItemMeta().getDisplayName().contains("Osso")) {
							menu.setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 1)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 1)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 2)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 2)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 2), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(3, 3)) != null) {
							if(!menu.getItem(Mine.getPosition(3, 3)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(3, 3), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(1, 7)) != null) {
							if(!menu.getItem(Mine.getPosition(1, 7)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(1, 7), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(1, 8)) != null) {
							if(!menu.getItem(Mine.getPosition(1, 8)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(1, 8), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(1, 9)) != null) {
							if(!menu.getItem(Mine.getPosition(1, 9)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(1, 9), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(2, 7)) != null) {
							if(!menu.getItem(Mine.getPosition(2, 7)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(2, 7), new ItemStack(Material.AIR));
							}
						}
						if(menu.getItem(Mine.getPosition(2, 9)) != null) {
							if(!menu.getItem(Mine.getPosition(2, 9)).getItemMeta().getDisplayName().contains("Osso")) {
						menu.setItem(Mine.getPosition(2, 9), new ItemStack(Material.AIR));
							}
						}
						menu.setItem(Mine.getPosition(2, 5), Mine.newHead("§6Raio-X de "+p.getName(), p.getName(), 1));
						ossos.remove(p);
						p.openInventory(menu);
					}
				}
				}
			}
			}
		}
	}
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		
		if(e.getEntity() != null) {
			if(e.getEntity().getType() == EntityType.PLAYER) {
				Player p = (Player) e.getEntity();
				if(ossos.get(p) == null) {
					ossos.put(p, 10);
					ossos.put(p, ossos.get(p)-1);
					p.getWorld().dropItem(p.getLocation().add(0, 0.3, 0), ItensAPI.ossoq);
					if(ossos.get(p) == 9) {
						p.sendMessage(" \n§aVocê quebrou um osso!\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 30*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
				}else {
					ossos.put(p, ossos.get(p)-1);
					p.getWorld().dropItem(p.getLocation().add(0, 0.3, 0), ItensAPI.ossoq);
					if(ossos.get(p) == 9) {
						p.sendMessage(" \n§aVocê quebrou um osso!\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 30*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if(ossos.get(p) == 8) {
						p.sendMessage(" \n§aAcho que foi uma fratura exposta!\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 30*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 30*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if(ossos.get(p) == 7) {
						p.sendMessage(" \n§aIh rapaz...\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 30*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 30*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if(ossos.get(p) == 6) {
						p.sendMessage(" \n§aNo céu tem pão?\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 10*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if(ossos.get(p) == 5) {
						p.sendMessage(" \n§aCacete de agulha!\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 10*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if(ossos.get(p) == 4) {
						p.sendMessage(" \n§aBixo, tu vai morrer!\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 10*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if(ossos.get(p) == 3) {
						p.sendMessage(" \n§aVivendo perigosamente!\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 10*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if(ossos.get(p) == 2) {
						p.sendMessage(" \n§aSangrando...\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 10*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if(ossos.get(p) == 1) {
						p.sendMessage(" \n§aSangrando...\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 10*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if(ossos.get(p) == 0) {
						p.sendMessage(" \n§aNo céu tem pão? E morreu...\n ");
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.damage(p.getMaxHealth());
							}
						}.runTaskLater(Main.getPlugin(Main.class), 10);
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onFall(EntityDamageEvent e) {
		
		if(e.getEntity() != null) {
			if(e.getEntity().getType() == EntityType.PLAYER) {
				Player p = (Player) e.getEntity();
				if(creeper.get(p) != null) {
					if(creeper.get(p) == true) {
						if(e.getCause() == DamageCause.ENTITY_EXPLOSION || e.getCause() == DamageCause.BLOCK_EXPLOSION) {
							e.setCancelled(true);
						}
					}
				}
			}
		}
		
		if(e.getEntity() != null) {
			if(e.getEntity().getType() == EntityType.PLAYER) {
				Player p = (Player) e.getEntity();
				if(e.getCause() == DamageCause.FALL) {
				if(ossos.get(p) == null) {
					ossos.put(p, 10);
					ossos.put(p, ossos.get(p)-1);
					p.getWorld().dropItem(p.getLocation().add(0, 0.3, 0), ItensAPI.ossoq);
					if(ossos.get(p) == 9) {
						p.sendMessage(" \n§aVocê quebrou um osso!\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 30*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
				}else {
					ossos.put(p, ossos.get(p)-1);
					p.getWorld().dropItem(p.getLocation().add(0, 0.3, 0), ItensAPI.ossoq);
					if(ossos.get(p) == 9) {
						p.sendMessage(" \n§aVocê quebrou um osso!\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 30*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if(ossos.get(p) == 8) {
						p.sendMessage(" \n§aAcho que foi uma fratura exposta!\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 30*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 30*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if(ossos.get(p) == 7) {
						p.sendMessage(" \n§aIh rapaz...\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 30*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 30*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if(ossos.get(p) == 6) {
						p.sendMessage(" \n§aNo céu tem pão?\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 10*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if(ossos.get(p) == 5) {
						p.sendMessage(" \n§aCacete de agulha!\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 10*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if(ossos.get(p) == 4) {
						p.sendMessage(" \n§aBixo, tu vai morrer!\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 10*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if(ossos.get(p) == 3) {
						p.sendMessage(" \n§aVivendo perigosamente!\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 10*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if(ossos.get(p) == 2) {
						p.sendMessage(" \n§aSangrando...\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 10*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if(ossos.get(p) == 1) {
						p.sendMessage(" \n§aSangrando...\n ");
						p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 10*20, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 10*20, 0));
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						new BukkitRunnable() {
							int i = 6;
							@Override
							public void run() {
								i--;
								p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().add(0, 1, 0), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.REDSTONE_BLOCK));
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if(ossos.get(p) == 0) {
						p.sendMessage(" \n§aNo céu tem pão? E morreu...\n ");
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.damage(p.getMaxHealth());
							}
						}.runTaskLater(Main.getPlugin(Main.class), 10);
					}
				}
			}
			}
		}
	}
	
	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		
		if(e.getEntity() != null) {
			if(e.getEntityType() == EntityType.SPIDER) {
				e.getEntity().getWorld().dropItem(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.ossoaranha);
			}
			if(e.getEntityType() == EntityType.ZOMBIE) {
				e.getEntity().getWorld().dropItem(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.ossozumbi);
			}
			if(e.getEntityType() == EntityType.WITHER_SKELETON) {
				e.getEntity().getWorld().dropItem(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.ossowither);
			}
			if(e.getEntityType() == EntityType.VILLAGER) {
				e.getEntity().getWorld().dropItem(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.ossovillager);
			}
			if(e.getEntityType() == EntityType.COW) {
				e.getEntity().getWorld().dropItem(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.ossovaca);
			}
			if(e.getEntityType() == EntityType.PIG) {
				e.getEntity().getWorld().dropItem(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.ossoporco);
			}
			if(e.getEntityType() == EntityType.SHEEP) {
				e.getEntity().getWorld().dropItem(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.ossoovelha);
			}
			if(e.getEntityType() == EntityType.CHICKEN) {
				e.getEntity().getWorld().dropItem(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.ossogalinha);
			}
			if(e.getEntityType() == EntityType.SKELETON) {
				e.getEntity().getWorld().dropItem(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.ossoesqueleto);
			}
			if(e.getEntityType() == EntityType.CREEPER) {
				e.getEntity().getWorld().dropItem(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.ossocreeper);
			}
		}
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if(e.getView().getTitle().equals(" ")) {
			if(e.getCurrentItem() != null) {
				if(!e.getCurrentItem().getItemMeta().getDisplayName().contains("Osso")) {
					e.setCancelled(true);
				}
					for(int i = 0; i <= 26; i++) {
						if(e.getRawSlot() == i) {
							if(e.getCurrentItem().isSimilar(ItensAPI.ossozumbi)) {
							p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_DEATH, 1F, 1F);
							zumbi.put(p, false);
							p.removePotionEffect(PotionEffectType.HUNGER);
							Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §c- Removido osso de zumbi!\n ");
							p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
							}
							if(e.getCurrentItem().isSimilar(ItensAPI.ossocreeper)) {
								p.playSound(p.getLocation(), Sound.ENTITY_CREEPER_DEATH, 1F, 1F);
								creeper.put(p, false);
								Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §c- Removido osso de creeper!\n ");
								p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
								}
							if(e.getCurrentItem().isSimilar(ItensAPI.ossoaranha)) {
								p.playSound(p.getLocation(), Sound.ENTITY_SPIDER_DEATH, 1F, 1F);
								aranha.put(p, false);
								p.removePotionEffect(PotionEffectType.SPEED);
								Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §c- Removido osso de aranha!\n ");
								p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
								}
							if(e.getCurrentItem().isSimilar(ItensAPI.ossoesqueleto)) {
								p.playSound(p.getLocation(), Sound.ENTITY_SKELETON_DEATH, 1F, 1F);
								esqueleto.put(p, false);
								Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §c- Removido osso de esqueleto!\n ");
								p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
								}
							if(e.getCurrentItem().isSimilar(ItensAPI.ossowither)) {
								p.playSound(p.getLocation(), Sound.ENTITY_WITHER_SKELETON_DEATH, 1F, 1F);
								wither.put(p, false);
								p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
								Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §c- Removido osso de esqueleto wither!\n ");
								p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
								}
							if(e.getCurrentItem().isSimilar(ItensAPI.ossovillager)) {
								p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_DEATH, 1F, 1F);
								villger.put(p, false);
								Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §c- Removido osso de villager!\n ");
								p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
								}
							if(e.getCurrentItem().isSimilar(ItensAPI.ossoovelha)) {
								p.playSound(p.getLocation(), Sound.ENTITY_SHEEP_DEATH, 1F, 1F);
								ovelha.put(p, false);
								Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §c- Removido osso de ovelha!\n ");
								p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
								}
							if(e.getCurrentItem().isSimilar(ItensAPI.ossogalinha)) {
								p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_DEATH, 1F, 1F);
								galinha.put(p, false);
								Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §c- Removido osso de galinha!\n ");
								p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
								}
							if(e.getCurrentItem().isSimilar(ItensAPI.ossovaca)) {
								p.playSound(p.getLocation(), Sound.ENTITY_COW_DEATH, 1F, 1F);
								vaca.put(p, false);
								Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §c- Removido osso de vaca!\n ");
								p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
								}
							if(e.getCurrentItem().isSimilar(ItensAPI.ossoporco)) {
								p.playSound(p.getLocation(), Sound.ENTITY_PIG_DEATH, 1F, 1F);
								porco.put(p, false);
								p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
								Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §c- Removido osso de porco!\n ");
								p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
								}
					}
				}
			}
			if(e.getCurrentItem() == null) {
				for(int i = 0; i <= 26; i++) {
					if(e.getRawSlot() == i) {
						if(p.getItemOnCursor().isSimilar(ItensAPI.ossozumbi)) {
							p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_AMBIENT, 1F, 1F);
							zumbi.put(p, true);
							p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 999999, 2));
							Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §e+ Adicionado osso de zumbi!\n ");
							p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
						}
						if(p.getItemOnCursor().isSimilar(ItensAPI.ossocreeper)) {
							p.playSound(p.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1F, 1F);
							creeper.put(p, true);
							Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §e+ Adicionado osso de creeper!\n ");
							p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
						}
						if(p.getItemOnCursor().isSimilar(ItensAPI.ossoaranha)) {
							p.playSound(p.getLocation(), Sound.ENTITY_SPIDER_AMBIENT, 1F, 1F);
							aranha.put(p, true);
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 1));
							new BukkitRunnable() {
								
								@Override
								public void run() {
									if(aranha.get(p) == false) {
										cancel();
									}
									p.getWorld().getBlockAt(p.getLocation().add(Mine.getRandomDouble(1, 5), Mine.getRandomDouble(-5, 5), Mine.getRandomDouble(-5, 5))).setType(Material.COBWEB);
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 0L, 20*5L);
							Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §e+ Adicionado osso de aranha!\n ");
							p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
						}
						if(p.getItemOnCursor().isSimilar(ItensAPI.ossoesqueleto)) {
							p.playSound(p.getLocation(), Sound.ENTITY_SKELETON_SHOOT, 1F, 1F);
							esqueleto.put(p, true);
							Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §e+ Adicionado osso de esqueleto!\n ");
							p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
						}
						if(p.getItemOnCursor().isSimilar(ItensAPI.ossowither)) {
							p.playSound(p.getLocation(), Sound.ENTITY_WITHER_SKELETON_AMBIENT, 1F, 1F);
							wither.put(p, true);
							p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999, 1));
							Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §e+ Adicionado osso de esqueleto wither!\n ");
							p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
						}
						if(p.getItemOnCursor().isSimilar(ItensAPI.ossovillager)) {
							p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_CELEBRATE, 1F, 1F);
							villger.put(p, true);
							Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §e+ Adicionado osso de villager!\n ");
							p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
						}
						if(p.getItemOnCursor().isSimilar(ItensAPI.ossoovelha)) {
							p.playSound(p.getLocation(), Sound.ENTITY_SHEEP_AMBIENT, 1F, 1F);
							ovelha.put(p, true);
							Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §e+ Adicionado osso de ovelha!\n ");
							p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
						}
						if(p.getItemOnCursor().isSimilar(ItensAPI.ossogalinha)) {
							p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_AMBIENT, 1F, 1F);
							galinha.put(p, true);
							Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §e+ Adicionado osso de galinha!\n ");
							p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
							new BukkitRunnable() {
								
								@Override
								public void run() {
									if(galinha.get(p) == false) {
										cancel();
									}
									p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1F, 1F);
									p.getWorld().dropItem(p.getLocation().add(0, 0.3, 0), new ItemStack(Material.EGG));
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 0L, 20*5L);
						}
						if(p.getItemOnCursor().isSimilar(ItensAPI.ossovaca)) {
							p.playSound(p.getLocation(), Sound.ENTITY_COW_AMBIENT, 1F, 1F);
							vaca.put(p, true);
							Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §e+ Adicionado osso de vaca!\n ");
							p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
						}
						if(p.getItemOnCursor().isSimilar(ItensAPI.ossoporco)) {
							p.playSound(p.getLocation(), Sound.ENTITY_PIG_AMBIENT, 1F, 1F);
							porco.put(p, true);
							p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999, 4));
							Bukkit.broadcastMessage(" \n§aO esqueleto de "+p.getName()+" foi modificado!\n \n §e+ Adicionado osso de porco!\n ");
							p.spawnParticle(Particle.ITEM_CRACK, p.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void seguir(EntityTargetEvent e) {
		if(e.getEntityType() != EntityType.PLAYER) {
			if(e.getTarget() != null) {
			if(e.getTarget().getType() == EntityType.PLAYER) {
				if(e.getEntityType() == EntityType.ZOMBIE) {
				Player j = (Player) e.getTarget();
				if(zumbi.get(j) != null) {
				if(zumbi.get(j) == true) {
					e.setCancelled(true);
				}
				}
			}
				if(e.getEntityType() == EntityType.CREEPER) {
					Player j = (Player) e.getTarget();
					if(creeper.get(j) != null) {
					if(creeper.get(j) == true) {
						e.setCancelled(true);
					}
					}
				}
				if(e.getEntityType() == EntityType.SPIDER) {
					Player j = (Player) e.getTarget();
					if(aranha.get(j) != null) {
					if(aranha.get(j) == true) {
						e.setCancelled(true);
					}
					}
				}
				if(e.getEntityType() == EntityType.SKELETON) {
					Player j = (Player) e.getTarget();
					if(esqueleto.get(j) != null) {
					if(esqueleto.get(j) == true) {
						e.setCancelled(true);
					}
					}
				}
				if(e.getEntityType() == EntityType.WITHER_SKELETON) {
					Player j = (Player) e.getTarget();
					if(wither.get(j) != null) {
					if(wither.get(j) == true) {
						e.setCancelled(true);
					}
					}
				}
			}
			}
		}
	}

	@EventHandler
	public void onShift(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		if(creeper.get(p) != null) {
			if(creeper.get(p) == true) {
		if(e.isSneaking() == true) {
			p.playSound(p.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1F, 1F);
			new BukkitRunnable() {
				
				@Override
				public void run() {
					p.getWorld().createExplosion(p.getLocation(), 5F);
				}
			}.runTaskLater(Main.getPlugin(Main.class), 3*20);
		}
	}
		}
	}

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();

		if(villger.get(p) != null) {
			if(villger.get(p) == true) {
				for(int x = (int)-7; x<= 7; x++) {
					for(int y = (int)-7; y<= 7; y++) {
						for(int z = (int)-7; z<= 7; z++) {
							if(p.getWorld().getBlockAt(p.getLocation().add(x, y, z)).getType() == Material.COAL_ORE) {
								p.getWorld().getBlockAt(p.getLocation().add(x, y, z)).setType(Material.EMERALD_ORE);
							}
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void aoLeite(PlayerInteractAtEntityEvent e) {
		Player p = e.getPlayer();
		EquipmentSlot es = e.getHand();
		if(e.getRightClicked() != null) {
			if(e.getRightClicked().getType() == EntityType.PLAYER) {
				Player j = (Player) e.getRightClicked();
			if(vaca.get(j) != null) {
				if(vaca.get(j) == true) {
					if(p.getInventory().getItemInMainHand().getType() == Material.BUCKET) {
						if(es.equals(EquipmentSlot.HAND)) {
						p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
						p.getInventory().addItem(Mine.newItem(Material.MILK_BUCKET, null));
						p.playSound(p.getLocation(), Sound.ENTITY_COW_MILK, 1F, 1F);
					}
					}
				}
			}
			}
		}
	}
}
