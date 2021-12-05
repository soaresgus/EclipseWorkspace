package me.ninjay.axolotlcustom.eventos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Axolotl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import me.ninjay.axolotlcustom.estruturas.ItensAPI;
import me.ninjay.axolotlcustom.main.Main;
import me.ninjay.axolotlcustom.utils.Mine;

public class EventosGeral implements Listener{
	
	public static ArrayList<String> nametags = new ArrayList<>();
	
	public static HashMap<Player, Boolean> first = new HashMap<>();
	public static HashMap<Player, Boolean> doble = new HashMap<>();
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		
		if(e.getBlock().getType() == Material.PISTON) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BLOCK_ANVIL_PLACE, 1F, 1F);
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		
		if(e.getBlock().getType() == Material.PISTON) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
			e.setDropItems(false);
			e.getPlayer().getWorld().dropItemNaturally(e.getBlock().getLocation(), ItensAPI.pistao());
		}
	}
	
	private boolean piston = false;
	private boolean dano = false;
	
	@EventHandler
	public void onDano(EntityDamageEvent e) { 
		
		if(e.getEntity() != null) {
			if(e.getEntityType() == EntityType.PLAYER) {
				if(e.getCause() == DamageCause.FALL) {
					if(dano == true) {
						e.setCancelled(true);
						dano=false;
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();

		if(piston == true) {
			p.spawnParticle(Particle.VILLAGER_HAPPY, p.getLocation(), 10, 0.1, 0.1, 0.1, 0.1);
		}
		
		if(p.getWorld().getBlockAt(p.getLocation().subtract(0, 1, 0)).getType() == Material.PISTON) {
			p.playSound(p.getLocation(), Sound.BLOCK_PISTON_EXTEND, 1F, 1F);
			piston=true;
			dano = true;
			p.setVelocity(new Vector(p.getVelocity().getX(), 3, p.getVelocity().getZ()));
		}
	

	if(piston == true) {
		new BukkitRunnable() {
			@Override
			public void run() {
				piston=false;
			}
		}.runTaskLater(Main.getPlugin(Main.class), 20*4L);
		
	}
//		nametags.clear();
//		nametags.add("axobsidian");
//		nametags.add("axcobre");
//		nametags.add("axredstone");
//		nametags.add("axouro");
//		nametags.add("axdiamante");
		
//		for(Entity axo : p.getWorld().getNearbyEntities(BoundingBox.of(p.getLocation().add(-50, -50, -50), p.getLocation().add(50, 50, 50)))) {
//			axo.setCustomNameVisible(false);
//			if(axo != null) {
//				if(axo.getType() == EntityType.AXOLOTL) {
//					if(axo.getCustomName() == null) {
//				    axo.setCustomName("§8"+Mine.getRandom(nametags));
//					}
//				}
//			}
//		}
	}

	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		
		if(e.getDamager() != null) {
			if(e.getEntity() != null) {
				if(e.getDamager().getType() == EntityType.PLAYER) {
					Player p = (Player) e.getDamager();
					
					if(e.getEntityType() == EntityType.AXOLOTL) {
						if(e.getEntity().getCustomName() != null) {
							if(e.getEntity().getCustomName().contains("axobsidian")) {
								p.playSound(e.getEntity().getLocation(), Sound.ENTITY_CHICKEN_EGG, 1F, 1F);
								ArrayList<ItemStack> itens = new ArrayList<>();
								itens.clear();
								itens.add(ItensAPI.capaobsi());
								itens.add(ItensAPI.peitoobsi());
								itens.add(ItensAPI.calcaobsi());
								itens.add(ItensAPI.botaobsi());
								itens.add(ItensAPI.espadaobsi());
								itens.add(ItensAPI.machadobsi());
								itens.add(ItensAPI.picaretaobsi());
								p.getWorld().dropItemNaturally(e.getEntity().getLocation(), Mine.getRandomItem(itens)).setVelocity(new Vector(Mine.getRandomDouble(-0.2, 0.2), 0.45, Mine.getRandomDouble(-0.2, 0.2)));
							}
							if(e.getEntity().getCustomName().contains("axcobre")) {
								p.playSound(e.getEntity().getLocation(), Sound.ENTITY_CHICKEN_EGG, 1F, 1F);
								ArrayList<ItemStack> itens = new ArrayList<>();
								itens.clear();
								itens.add(ItensAPI.capacobre());
								itens.add(ItensAPI.peitocobre());
								itens.add(ItensAPI.calcacobre());
								itens.add(ItensAPI.botacobre());
								itens.add(ItensAPI.espadacobre());
								itens.add(ItensAPI.machadcobre());
								itens.add(ItensAPI.picaretacobre());
								p.getWorld().dropItemNaturally(e.getEntity().getLocation(), Mine.getRandomItem(itens)).setVelocity(new Vector(Mine.getRandomDouble(-0.2, 0.2), 0.45, Mine.getRandomDouble(-0.2, 0.2)));
							}
							if(e.getEntity().getCustomName().contains("axredstone")) {
								p.playSound(e.getEntity().getLocation(), Sound.ENTITY_CHICKEN_EGG, 1F, 1F);
								ArrayList<ItemStack> itens = new ArrayList<>();
								itens.clear();
								itens.add(ItensAPI.pistao());
								p.getWorld().dropItemNaturally(e.getEntity().getLocation(), Mine.getRandomItem(itens)).setVelocity(new Vector(Mine.getRandomDouble(-0.2, 0.2), 0.45, Mine.getRandomDouble(-0.2, 0.2)));
							}
							if(e.getEntity().getCustomName().contains("axouro")) {
								p.playSound(e.getEntity().getLocation(), Sound.ENTITY_CHICKEN_EGG, 1F, 1F);
								ArrayList<ItemStack> itens = new ArrayList<>();
								itens.clear();
								itens.add(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
								itens.add(new ItemStack(Material.ENDER_PEARL));
								itens.add(new ItemStack(Material.BLAZE_ROD));
								
								ItemStack pot2 = Mine.newItem(Material.POTION, "§fPoção de Força");
								PotionMeta meta2 = (PotionMeta) pot2.getItemMeta();
								meta2.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30*20, 1), true);
								pot2.setItemMeta(meta2);
								
								ItemStack pot3 = Mine.newItem(Material.POTION, "§fPoção de Velocidade");
								PotionMeta meta3 = (PotionMeta) pot3.getItemMeta();
								meta3.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 30*20, 1), true);
								meta3.setColor(Color.GRAY);
								pot3.setItemMeta(meta3);
								
								itens.add(pot2);
								itens.add(pot3);
								p.getWorld().dropItemNaturally(e.getEntity().getLocation(), Mine.getRandomItem(itens)).setVelocity(new Vector(Mine.getRandomDouble(-0.2, 0.2), 0.45, Mine.getRandomDouble(-0.2, 0.2)));
							}
							if(e.getEntity().getCustomName().contains("axdiamante")) {
								p.playSound(e.getEntity().getLocation(), Sound.ENTITY_CHICKEN_EGG, 1F, 1F);
								ArrayList<ItemStack> itens = new ArrayList<>();
								itens.clear();
								itens.add(ItensAPI.capadima());
								itens.add(ItensAPI.peitodima());
								itens.add(ItensAPI.calcadima());
								itens.add(ItensAPI.botadima());
								itens.add(ItensAPI.espadadima());
								itens.add(ItensAPI.machaddima());
								itens.add(ItensAPI.picaretadima());
								p.getWorld().dropItemNaturally(e.getEntity().getLocation(), Mine.getRandomItem(itens)).setVelocity(new Vector(Mine.getRandomDouble(-0.2, 0.2), 0.45, Mine.getRandomDouble(-0.2, 0.2)));
							}
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onClick(PlayerInteractAtEntityEvent e) {
		Player p = e.getPlayer();
		EquipmentSlot es = e.getHand();
		
		if(e.getRightClicked() != null) {
			if(e.getRightClicked().getType() == EntityType.AXOLOTL) {
						if(p.getInventory().getItemInMainHand() != null) {
							if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.obsidian)) {
								if(es.equals(EquipmentSlot.HAND)) {
								if(first.get(p) == null || first.get(p) == false) {
									doble.put(p, false);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getInventory().getItemInMainHand().setAmount(0);
										}
									}.runTaskLater(Main.getPlugin(Main.class), 2);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 4);
									p.playSound(p.getLocation(), Sound.ENTITY_COW_MILK, 1F, 1F);
								}
								if(doble.get(p) == false) {
									p.playSound(p.getLocation(), Sound.ENTITY_COW_MILK, 1F, 1F);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											e.getRightClicked().getWorld().spawnParticle(Particle.HEART, e.getRightClicked().getLocation().add(0, 0.5, 0), 15, 0.2, 0.2, 0.2, 0.2);
											Axolotl axo = p.getWorld().spawn(e.getRightClicked().getLocation().add(0.5, 0.5, 0.5), Axolotl.class);
											axo.setBaby();
											axo.setCustomName("§8axobsidian");
											e.getRightClicked().getWorld().spawnParticle(Particle.HEART, e.getRightClicked().getLocation().add(0, 0.5, 0), 15, 0.2, 0.2, 0.2, 0.2);
											Axolotl axo2 = p.getWorld().spawn(e.getRightClicked().getLocation().add(0.5, 0.5, 0.5), Axolotl.class);
											axo2.setBaby();
											axo2.setCustomName("§8axobsidian");
											doble.put(p, false);
											first.put(p, false);
											axo.setCustomNameVisible(false);
											axo2.setCustomNameVisible(false);
										}
									}.runTaskLater(Main.getPlugin(Main.class), 20*5L);
								}
							}
							}
						}
						if(p.getInventory().getItemInMainHand() != null) {
							if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.cobre)) {
								if(es.equals(EquipmentSlot.HAND)) {
								if(first.get(p) == null || first.get(p) == false) {
									doble.put(p, false);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getInventory().getItemInMainHand().setAmount(0);
										}
									}.runTaskLater(Main.getPlugin(Main.class), 2);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 4);
									p.playSound(p.getLocation(), Sound.ENTITY_COW_MILK, 1F, 1F);
								}
								if(doble.get(p) == false) {
									p.playSound(p.getLocation(), Sound.ENTITY_COW_MILK, 1F, 1F);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											e.getRightClicked().getWorld().spawnParticle(Particle.HEART, e.getRightClicked().getLocation().add(0, 0.5, 0), 15, 0.2, 0.2, 0.2, 0.2);
											Axolotl axo = p.getWorld().spawn(e.getRightClicked().getLocation().add(0.5, 0.5, 0.5), Axolotl.class);
											axo.setBaby();
											axo.setCustomName("§8axcobre");
											e.getRightClicked().getWorld().spawnParticle(Particle.HEART, e.getRightClicked().getLocation().add(0, 0.5, 0), 15, 0.2, 0.2, 0.2, 0.2);
											Axolotl axo2 = p.getWorld().spawn(e.getRightClicked().getLocation().add(0.5, 0.5, 0.5), Axolotl.class);
											axo2.setBaby();
											axo2.setCustomName("§8axcobre");
											doble.put(p, false);
											first.put(p, false);
											axo.setCustomNameVisible(false);
											axo2.setCustomNameVisible(false);
										}
									}.runTaskLater(Main.getPlugin(Main.class), 20*5L);
								}
							}
							}
						}
						if(p.getInventory().getItemInMainHand() != null) {
							if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.redstone)) {
								if(es.equals(EquipmentSlot.HAND)) {
								if(first.get(p) == null || first.get(p) == false) {
									doble.put(p, false);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getInventory().getItemInMainHand().setAmount(0);
										}
									}.runTaskLater(Main.getPlugin(Main.class), 2);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 4);
									p.playSound(p.getLocation(), Sound.ENTITY_COW_MILK, 1F, 1F);
								}
								if(doble.get(p) == false) {
									p.playSound(p.getLocation(), Sound.ENTITY_COW_MILK, 1F, 1F);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											e.getRightClicked().getWorld().spawnParticle(Particle.HEART, e.getRightClicked().getLocation().add(0, 0.5, 0), 15, 0.2, 0.2, 0.2, 0.2);
											Axolotl axo = p.getWorld().spawn(e.getRightClicked().getLocation().add(0.5, 0.5, 0.5), Axolotl.class);
											axo.setBaby();
											axo.setCustomName("§8axredstone");
											e.getRightClicked().getWorld().spawnParticle(Particle.HEART, e.getRightClicked().getLocation().add(0, 0.5, 0), 15, 0.2, 0.2, 0.2, 0.2);
											Axolotl axo2 = p.getWorld().spawn(e.getRightClicked().getLocation().add(0.5, 0.5, 0.5), Axolotl.class);
											axo2.setBaby();
											axo2.setCustomName("§8axredstone");
											doble.put(p, false);
											first.put(p, false);
											axo.setCustomNameVisible(false);
											axo2.setCustomNameVisible(false);
										}
									}.runTaskLater(Main.getPlugin(Main.class), 20*5L);
								}
							}
							}
						}
						if(p.getInventory().getItemInMainHand() != null) {
							if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.ouro)) {
								if(es.equals(EquipmentSlot.HAND)) {
								if(first.get(p) == null || first.get(p) == false) {
									doble.put(p, false);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getInventory().getItemInMainHand().setAmount(0);
										}
									}.runTaskLater(Main.getPlugin(Main.class), 2);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 4);
									p.playSound(p.getLocation(), Sound.ENTITY_COW_MILK, 1F, 1F);
								}
								if(doble.get(p) == false) {
									p.playSound(p.getLocation(), Sound.ENTITY_COW_MILK, 1F, 1F);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											e.getRightClicked().getWorld().spawnParticle(Particle.HEART, e.getRightClicked().getLocation().add(0, 0.5, 0), 15, 0.2, 0.2, 0.2, 0.2);
											Axolotl axo = p.getWorld().spawn(e.getRightClicked().getLocation().add(0.5, 0.5, 0.5), Axolotl.class);
											axo.setBaby();
											axo.setCustomName("§8axouro");
											e.getRightClicked().getWorld().spawnParticle(Particle.HEART, e.getRightClicked().getLocation().add(0, 0.5, 0), 15, 0.2, 0.2, 0.2, 0.2);
											Axolotl axo2 = p.getWorld().spawn(e.getRightClicked().getLocation().add(0.5, 0.5, 0.5), Axolotl.class);
											axo2.setBaby();
											axo2.setCustomName("§8axouro");
											doble.put(p, false);
											first.put(p, false);
											axo.setCustomNameVisible(false);
											axo2.setCustomNameVisible(false);
										}
									}.runTaskLater(Main.getPlugin(Main.class), 20*5L);
								}
							}
							}
						}
						if(p.getInventory().getItemInMainHand() != null) {
							if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.diamante)) {
								if(es.equals(EquipmentSlot.HAND)) {
								if(first.get(p) == null || first.get(p) == false) {
									doble.put(p, false);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getInventory().getItemInMainHand().setAmount(0);
										}
									}.runTaskLater(Main.getPlugin(Main.class), 2);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 4);
									p.playSound(p.getLocation(), Sound.ENTITY_COW_MILK, 1F, 1F);
								}
								if(doble.get(p) == false) {
									p.playSound(p.getLocation(), Sound.ENTITY_COW_MILK, 1F, 1F);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											e.getRightClicked().getWorld().spawnParticle(Particle.HEART, e.getRightClicked().getLocation().add(0, 0.5, 0), 15, 0.2, 0.2, 0.2, 0.2);
											Axolotl axo = p.getWorld().spawn(e.getRightClicked().getLocation().add(0.5, 0.5, 0.5), Axolotl.class);
											axo.setBaby();
											axo.setCustomName("§8axdiamante");
											e.getRightClicked().getWorld().spawnParticle(Particle.HEART, e.getRightClicked().getLocation().add(0, 0.5, 0), 15, 0.2, 0.2, 0.2, 0.2);
											Axolotl axo2 = p.getWorld().spawn(e.getRightClicked().getLocation().add(0.5, 0.5, 0.5), Axolotl.class);
											axo2.setBaby();
											axo2.setCustomName("§8axdiamante");
											doble.put(p, false);
											first.put(p, false);
											axo.setCustomNameVisible(false);
											axo2.setCustomNameVisible(false);
										}
									}.runTaskLater(Main.getPlugin(Main.class), 20*5L);
								}
							}
							}
						}
			}
		}
	}
}
