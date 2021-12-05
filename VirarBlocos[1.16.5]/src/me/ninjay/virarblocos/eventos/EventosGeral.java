package me.ninjay.virarblocos.eventos;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentOffer;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Endermite;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Silverfish;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.InventoryView.Property;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BoundingBox;

import me.ninjay.virarblocos.estruturas.ItensAPI;
import me.ninjay.virarblocos.main.Main;
import me.ninjay.virarblocos.utils.Mine;
import net.minecraft.server.v1_16_R3.BlockPosition;
import net.minecraft.server.v1_16_R3.PacketPlayOutBlockBreakAnimation;

public class EventosGeral implements Listener{
	
	private static HashMap<Player, Entity> bloco = new HashMap<>();
	private static HashMap<String, Boolean> usando = new HashMap<>();
	private static HashMap<String, Material> save = new HashMap<>();
	
	private static HashMap<Block, Integer> savee = new HashMap<>();
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(usando.get(p.getName()) != null) {
			if(usando.get(p.getName()) == true) {
		//	Location loc = p.getLocation();  
		//	Location skeleLoc = bloco.get(p).getLocation();
		//	skeleLoc = loc.clone().add(0, 0.5, 0); 
				
		//	bloco.get(p).setVelocity(skeleLoc.toVector().subtract(bloco.get(p).getLocation().toVector()).multiply(0.5));
			p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10*20, 5, false, false));
			}else {
			p.removePotionEffect(PotionEffectType.INVISIBILITY);
		}
		}
		
	}
	
//	@EventHandler
//	public void onForm(EntityChangeBlockEvent event) {
//	    if(event.getEntity().getType() == EntityType.FALLING_BLOCK) {
//	    	event.setCancelled(true);
//	    	for(Player todos : Bukkit.getOnlinePlayers()) {
//	    		if(usando.containsKey(todos.getName())) {
//	    			FallingBlock blocoo = event.getBlock().getWorld().spawnFallingBlock(todos.getLocation(), save.get(todos.getName()).createBlockData());
//	    			blocoo.setGravity(false);
//	    			blocoo.setDropItem(false);
//	    			blocoo.setHurtEntities(false);
//	    			blocoo.setInvulnerable(true);
//	    			blocoo.setPersistent(true);
//	    			bloco.put(todos, blocoo);
//	    		}
//	    	}
//	}
//	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Alma")) {
						e.setCancelled(true);
					}
					if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.bigorna())) {
						if(usando.get(p.getName()) == null || usando.get(p.getName()) == false) {
							save.put(p.getName(), Material.ANVIL);
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							p.sendMessage(" \n §aVocê virou o bloco de bigorna!\n ");
							
							p.getInventory().setItemInOffHand(Mine.newItem(Material.ORANGE_CONCRETE, " "));
							
							//FallingBlock blocoo = p.getWorld().spawnFallingBlock(p.getLocation(), save.get(p.getName()).createBlockData());
							//blocoo.setGravity(false);
							//blocoo.setDropItem(false);
							//blocoo.setHurtEntities(false);
							//blocoo.setInvulnerable(true);
							//blocoo.setPersistent(true);
							//Silverfish fish = p.getWorld().spawn(p.getLocation(), Silverfish.class);
							//fish.setInvisible(true);
							//fish.setPersistent(false);
							//fish.setCollidable(false);
							//fish.setAware(false);
							//fish.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999, 255, false ,false));
							//fish.setInvulnerable(true);
							//fish.setSilent(true);
							//fish.setRemoveWhenFarAway(false);
							//fish.setTarget(null);
							//fish.setPassenger(blocoo);
							//bloco.put(p, fish);
							//bloco.put(p, blocoo);
							
							p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10*20, 5, false, false));
							
							new BukkitRunnable() {
								
								@Override
								public void run() {
									usando.put(p.getName(), true);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(usando.get(p.getName()) != null && usando.get(p.getName()) == true) {
							save.remove(p.getName());
							p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
							p.sendMessage(" \n §cVocê saiu do modo de bloco!\n ");
							p.getInventory().getItemInOffHand().setAmount(0);
							
							new BukkitRunnable() {
								
								@Override
								public void run() {
									usando.put(p.getName(), false);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
					}
					if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.obsidian())) {
						if(usando.get(p.getName()) == null || usando.get(p.getName()) == false) {
							save.put(p.getName(), Material.OBSIDIAN);
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							p.sendMessage(" \n §aVocê virou o bloco de obsidian!\n ");
							
							p.getInventory().setItemInOffHand(Mine.newItem(Material.LIME_CONCRETE, " "));
							
							//FallingBlock blocoo = p.getWorld().spawnFallingBlock(p.getLocation(), save.get(p.getName()).createBlockData());
							//blocoo.setGravity(false);
							//blocoo.setDropItem(false);
							//blocoo.setHurtEntities(false);
							//blocoo.setInvulnerable(true);
							//blocoo.setPersistent(true);
							//bloco.put(p, blocoo);
							
							p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10*20, 5, false, false));
							
							new BukkitRunnable() {
								
								@Override
								public void run() {
									usando.put(p.getName(), true);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(usando.get(p.getName()) != null && usando.get(p.getName()) == true) {
							save.remove(p.getName());
							p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
							p.sendMessage(" \n §cVocê saiu do modo de bloco!\n ");
							p.getInventory().getItemInOffHand().setAmount(0);
							
							new BukkitRunnable() {
								
								@Override
								public void run() {
									usando.put(p.getName(), false);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
					}
					if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.fornalha())) {
						if(usando.get(p.getName()) == null || usando.get(p.getName()) == false) {
							save.put(p.getName(), Material.FURNACE);
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							p.sendMessage(" \n §aVocê virou o bloco de fornalha!\n ");
							
							p.getInventory().setItemInOffHand(Mine.newItem(Material.YELLOW_CONCRETE, " "));
							
							//FallingBlock blocoo = p.getWorld().spawnFallingBlock(p.getLocation(), save.get(p.getName()).createBlockData());
							//blocoo.setGravity(false);
							//blocoo.setDropItem(false);
							//blocoo.setHurtEntities(false);
							//blocoo.setInvulnerable(true);
							//blocoo.setPersistent(true);
							//bloco.put(p, blocoo);
							
							p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10*20, 5, false, false));
							
							new BukkitRunnable() {
								
								@Override
								public void run() {
									usando.put(p.getName(), true);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(usando.get(p.getName()) != null && usando.get(p.getName()) == true) {
							save.remove(p.getName());
							p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
							p.sendMessage(" \n §cVocê saiu do modo de bloco!\n ");
							p.getInventory().getItemInOffHand().setAmount(0);
							
							new BukkitRunnable() {
								
								@Override
								public void run() {
									usando.put(p.getName(), false);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
					}
					if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.craft())) {
						if(usando.get(p.getName()) == null || usando.get(p.getName()) == false) {
							save.put(p.getName(), Material.CRAFTING_TABLE);
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							p.sendMessage(" \n §aVocê virou o bloco de crafting table!\n ");
							
							p.getInventory().setItemInOffHand(Mine.newItem(Material.BLUE_CONCRETE, " "));
							
							//FallingBlock blocoo = p.getWorld().spawnFallingBlock(p.getLocation(), save.get(p.getName()).createBlockData());
						//	blocoo.setGravity(false);
						//	blocoo.setDropItem(false);
						//	blocoo.setHurtEntities(false);
						//	blocoo.setInvulnerable(true);
						//	blocoo.setPersistent(true);
						//	bloco.put(p, blocoo);
							
							p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10*20, 5, false, false));
							
							new BukkitRunnable() {
								
								@Override
								public void run() {
									usando.put(p.getName(), true);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(usando.get(p.getName()) != null && usando.get(p.getName()) == true) {
							save.remove(p.getName());
							p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
							p.sendMessage(" \n §cVocê saiu do modo de bloco!\n ");
							p.getInventory().getItemInOffHand().setAmount(0);
							
							new BukkitRunnable() {
								
								@Override
								public void run() {
									usando.put(p.getName(), false);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
					}
					if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.bau())) {
						if(usando.get(p.getName()) == null || usando.get(p.getName()) == false) {
							save.put(p.getName(), Material.BROWN_CONCRETE);
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							p.sendMessage(" \n §aVocê virou o bloco de baú!\n ");
							
							p.getInventory().setItemInOffHand(Mine.newItem(Material.GREEN_CONCRETE, " "));
							
						//	FallingBlock blocoo = p.getWorld().spawnFallingBlock(p.getLocation(), save.get(p.getName()).createBlockData());
						//	blocoo.setGravity(false);
						//	blocoo.setDropItem(false);
						//	blocoo.setHurtEntities(false);
						//	blocoo.setInvulnerable(true);
						//	blocoo.setPersistent(true);
						//	bloco.put(p, blocoo);
							
							p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10*20, 5, false, false));
							
							new BukkitRunnable() {
								
								@Override
								public void run() {
									usando.put(p.getName(), true);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(usando.get(p.getName()) != null && usando.get(p.getName()) == true) {
							save.remove(p.getName());
							p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
							p.sendMessage(" \n §cVocê saiu do modo de bloco!\n ");
							p.getInventory().getItemInOffHand().setAmount(0);
							
							new BukkitRunnable() {
								
								@Override
								public void run() {
									usando.put(p.getName(), false);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
					}
					if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.tnt())) {
						if(usando.get(p.getName()) == null || usando.get(p.getName()) == false) {
							save.put(p.getName(), Material.TNT);
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							p.sendMessage(" \n §aVocê virou o bloco de tnt!\n ");
							
							p.getInventory().setItemInOffHand(Mine.newItem(Material.CYAN_CONCRETE, " "));
							
							//FallingBlock blocoo = p.getWorld().spawnFallingBlock(p.getLocation(), save.get(p.getName()).createBlockData());
						//	blocoo.setGravity(false);
						//	blocoo.setDropItem(false);
							//blocoo.setHurtEntities(false);
						//	blocoo.setInvulnerable(true);
						//	blocoo.setPersistent(true);
							//bloco.put(p, blocoo);
							
							p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10*20, 5, false, false));
							
							new BukkitRunnable() {
								
								@Override
								public void run() {
									usando.put(p.getName(), true);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(usando.get(p.getName()) != null && usando.get(p.getName()) == true) {
							save.remove(p.getName());
							p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
							p.sendMessage(" \n §cVocê saiu do modo de bloco!\n ");
							p.getInventory().getItemInOffHand().setAmount(0);
							
							new BukkitRunnable() {
								
								@Override
								public void run() {
									usando.put(p.getName(), false);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
					}
					if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.enchant())) {
						if(usando.get(p.getName()) == null || usando.get(p.getName()) == false) {
							save.put(p.getName(), Material.ENCHANTING_TABLE);
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							p.sendMessage(" \n §aVocê virou o bloco de mesa de encantamento!\n ");
							
							p.getInventory().setItemInOffHand(Mine.newItem(Material.RED_CONCRETE, " "));
							
							//FallingBlock blocoo = p.getWorld().spawnFallingBlock(p.getLocation(), save.get(p.getName()).createBlockData());
						//	blocoo.setGravity(false);
						//	blocoo.setDropItem(false);
						//	blocoo.setHurtEntities(false);
						//	blocoo.setInvulnerable(true);
						//	blocoo.setPersistent(true);
						//	bloco.put(p, blocoo);
							
							p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10*20, 5, false, false));
							
							new BukkitRunnable() {
								
								@Override
								public void run() {
									usando.put(p.getName(), true);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(usando.get(p.getName()) != null && usando.get(p.getName()) == true) {
							save.remove(p.getName());
							p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
							p.sendMessage(" \n §cVocê saiu do modo de bloco!\n ");
							p.getInventory().getItemInOffHand().setAmount(0);
							p.setLevel(0);
							
							new BukkitRunnable() {
								
								@Override
								public void run() {
									usando.put(p.getName(), false);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
					}
				}
			}
		}
	}

//	@EventHandler
//	public void silverFish(EntityDamageByEntityEvent e) {
//		
//		if(e.getEntity() != null) {
//			if(e.getDamager() != null) {
//				if(e.getDamager().getType() == EntityType.SILVERFISH) {
//					e.setCancelled(true);
//				}
//			}
//		}
//	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if(e.getEntity() != null) {
			if(e.getEntity().getType() == EntityType.PLAYER) {
				Player p = (Player) e.getEntity();
			if(usando.get(p.getName()) != null) {
					if(usando.get(p.getName()) == true) {
						if(save.get(p.getName()) == Material.ANVIL) {
							if(e.getCause() == DamageCause.FALL) {
							e.setCancelled(true);
							p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1F, 1F);
							for(int x = (int)-3; x <= 3; x++) {
								for(int z = (int) -3; z <= 3; z++) {
									net.minecraft.server.v1_16_R3.PacketPlayOutBlockBreakAnimation packet = new net.minecraft.server.v1_16_R3.PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new net.minecraft.server.v1_16_R3.BlockPosition(p.getLocation().add(x, -1, z).getX(), p.getLocation().add(x, -1, z).getY(), p.getLocation().add(x, -1, z).getZ()), 5);
				    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
				    		    	p.spawnParticle(Particle.CLOUD, p.getLocation().add(x, 0, z), 50, 0.1, 0.1, 0.1);
								}
							}
							for(Entity mobs : p.getWorld().getNearbyEntities(BoundingBox.of(p.getLocation().add(3, 5, 3), p.getLocation().add(-3, -5, -3)))) {
								if(mobs != null) {
									if(mobs != p) {
										if(mobs instanceof LivingEntity) {
											((LivingEntity)mobs).damage(((LivingEntity) mobs).getMaxHealth());
										}
									}
								}
							}
						}
					}
						if(save.get(p.getName()) == Material.OBSIDIAN) {
							e.setCancelled(true);
						}
						if(save.get(p.getName()) == Material.TNT) {
							if(e.getCause() == DamageCause.ENTITY_EXPLOSION || e.getCause() == DamageCause.BLOCK_EXPLOSION) {
								e.setCancelled(true);
							}
						}
				}
			}
		}
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlock().getType() == Material.TNT) {
			if(p.getInventory().getItemInMainHand() != null) {
				if(p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SWORD || p.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD || p.getInventory().getItemInMainHand().getType() == Material.IRON_SWORD || p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_SWORD || p.getInventory().getItemInMainHand().getType() == Material.STONE_SWORD || p.getInventory().getItemInMainHand().getType() == Material.WOODEN_SWORD) {
					e.setCancelled(true);
				}
			}
		}
		
		if(usando.get(p.getName()) != null) {
			if(save.get(p.getName()) != null) {
				if(usando.get(p.getName()) == true) {
					if(save.get(p.getName()) == Material.FURNACE) {
						if(e.getBlock().getType() == Material.IRON_ORE) {
							e.setDropItems(false);
							p.getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.IRON_INGOT));
						}
						if(e.getBlock().getType() == Material.GOLD_ORE) {
							e.setDropItems(false);
							p.getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.GOLD_INGOT));
						}
					}
					
				}
			}
		}
	}
	
	@EventHandler
	public void onSneak(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		
		if(usando.get(p.getName()) != null) {
			if(save.get(p.getName()) != null) {
				if(usando.get(p.getName()) == true) {
					if(save.get(p.getName()) == Material.CRAFTING_TABLE) {
						p.openWorkbench(null, true);
					}
					if(save.get(p.getName()) == Material.BROWN_CONCRETE) {
						p.openInventory(p.getEnderChest());
						p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F, 1F);
					}
					if(save.get(p.getName()) == Material.TNT) {
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
					if(save.get(p.getName()) == Material.ENCHANTING_TABLE) {
						Location loc = new Location(p.getWorld(), 200, 10, 200);
						p.getWorld().getBlockAt(loc).setType(Material.ENCHANTING_TABLE);
						
						p.getWorld().getBlockAt(new Location(p.getWorld(), 199, 10, 199)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 200, 10, 199)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 201, 10, 199)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 201, 10, 200)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 201, 10, 201)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 200, 10, 201)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 199, 10, 201)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 199, 10, 200)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 202, 10, 200)).setType(Material.BOOKSHELF);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 202, 10, 201)).setType(Material.BOOKSHELF);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 202, 10, 202)).setType(Material.BOOKSHELF);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 201, 10, 202)).setType(Material.BOOKSHELF);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 200, 10, 202)).setType(Material.BOOKSHELF);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 199, 10, 202)).setType(Material.BOOKSHELF);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 198, 10, 202)).setType(Material.BOOKSHELF);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 198, 10, 201)).setType(Material.BOOKSHELF);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 198, 10, 200)).setType(Material.BOOKSHELF);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 198, 10, 199)).setType(Material.BOOKSHELF);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 198, 10, 198)).setType(Material.BOOKSHELF);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 199, 10, 198)).setType(Material.BOOKSHELF);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 200, 10, 198)).setType(Material.BOOKSHELF);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 199, 10, 198)).setType(Material.BOOKSHELF);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 198, 10, 198)).setType(Material.BOOKSHELF);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 198, 10, 199)).setType(Material.BOOKSHELF);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 201, 10, 198)).setType(Material.BOOKSHELF);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 202, 10, 198)).setType(Material.BOOKSHELF);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 202, 10, 199)).setType(Material.BOOKSHELF);
						
						p.getWorld().getBlockAt(new Location(p.getWorld(), 199, 11, 199)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 200, 11, 199)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 201, 11, 199)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 201, 11, 200)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 201, 11, 201)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 200, 11, 201)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 199, 11, 201)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 199, 11, 200)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 202, 11, 200)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 202, 11, 201)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 202, 11, 202)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 201, 11, 202)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 200, 11, 202)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 199, 11, 202)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 198, 11, 202)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 198, 11, 201)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 198, 11, 200)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 198, 11, 199)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 198, 11, 198)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 199, 11, 198)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 200, 11, 198)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 199, 11, 198)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 198, 11, 198)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 198, 11, 199)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 201, 11, 198)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 202, 11, 198)).setType(Material.AIR);
						p.getWorld().getBlockAt(new Location(p.getWorld(), 202, 11, 199)).setType(Material.AIR);
						
						p.openEnchanting(new Location(p.getWorld(), 200, 10, 200), true);
						
						p.setLevel(999999999);
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
	  Player p = e.getPlayer();
		
		if(e.getAction() == Action.LEFT_CLICK_BLOCK) {
	    	
			//
			
			if(e.getClickedBlock().getType() == Material.ANVIL) {
	    			if(savee.get(e.getClickedBlock()) == null) {
	    				savee.put(e.getClickedBlock(), 1);
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 0);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 2);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 2) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 1);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 3);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 3) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 2);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 4);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 4) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 3);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 5);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 5) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 4);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 6);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 6) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 5);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 7);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 7) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 6);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 8);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 8) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 7);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 9);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 9) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 8);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.remove(e.getClickedBlock());
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						e.getClickedBlock().setType(Material.AIR);
						p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_DEATH, 1F, 1F);
						p.getWorld().dropItem(e.getClickedBlock().getLocation(), ItensAPI.bigorna());
	    			}
	    		}
	    		
	    		//
			
//
			
			if(e.getClickedBlock().getType() == Material.OBSIDIAN) {
	    			if(savee.get(e.getClickedBlock()) == null) {
	    				savee.put(e.getClickedBlock(), 1);
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 0);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 2);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 2) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 1);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 3);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 3) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 2);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 4);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 4) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 3);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 5);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 5) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 4);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 6);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 6) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 5);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 7);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 7) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 6);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 8);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 8) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 7);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 9);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 9) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 8);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.remove(e.getClickedBlock());
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						e.getClickedBlock().setType(Material.AIR);
						p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_DEATH, 1F, 1F);
						p.getWorld().dropItem(e.getClickedBlock().getLocation(), ItensAPI.obsidian());
	    			}
	    		}
	    		
	    		//
			
//
			
			if(e.getClickedBlock().getType() == Material.FURNACE) {
	    			if(savee.get(e.getClickedBlock()) == null) {
	    				savee.put(e.getClickedBlock(), 1);
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 0);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 2);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 2) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 1);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 3);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 3) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 2);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 4);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 4) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 3);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 5);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 5) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 4);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 6);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 6) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 5);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 7);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 7) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 6);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 8);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 8) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 7);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 9);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 9) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 8);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.remove(e.getClickedBlock());
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						e.getClickedBlock().setType(Material.AIR);
						p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_DEATH, 1F, 1F);
						p.getWorld().dropItem(e.getClickedBlock().getLocation(), ItensAPI.fornalha());
	    			}
	    		}
	    		
	    		//
			
//
			
			if(e.getClickedBlock().getType() == Material.CRAFTING_TABLE) {
	    			if(savee.get(e.getClickedBlock()) == null) {
	    				savee.put(e.getClickedBlock(), 1);
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 0);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 2);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 2) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 1);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 3);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 3) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 2);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 4);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 4) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 3);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 5);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 5) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 4);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 6);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 6) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 5);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 7);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 7) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 6);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 8);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 8) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 7);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 9);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 9) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 8);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.remove(e.getClickedBlock());
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						e.getClickedBlock().setType(Material.AIR);
						p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_DEATH, 1F, 1F);
						p.getWorld().dropItem(e.getClickedBlock().getLocation(), ItensAPI.craft());
	    			}
	    		}
	    		
	    		//
			
//
			
			if(e.getClickedBlock().getType() == Material.CHEST) {
	    			if(savee.get(e.getClickedBlock()) == null) {
	    				savee.put(e.getClickedBlock(), 1);
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 0);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 2);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 2) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 1);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 3);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 3) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 2);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 4);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 4) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 3);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 5);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 5) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 4);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 6);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 6) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 5);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 7);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 7) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 6);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 8);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 8) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 7);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 9);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 9) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 8);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.remove(e.getClickedBlock());
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						e.getClickedBlock().setType(Material.AIR);
						p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_DEATH, 1F, 1F);
						p.getWorld().dropItem(e.getClickedBlock().getLocation(), ItensAPI.bau());
	    			}
	    		}
	    		
	    		//
			
//
			
			if(e.getClickedBlock().getType() == Material.TNT) {
	    			if(savee.get(e.getClickedBlock()) == null) {
	    				savee.put(e.getClickedBlock(), 1);
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 0);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 2);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 2) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 1);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 3);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 3) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 2);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 4);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 4) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 3);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 5);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 5) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 4);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 6);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 6) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 5);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 7);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 7) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 6);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 8);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 8) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 7);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 9);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 9) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 8);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.remove(e.getClickedBlock());
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						e.getClickedBlock().setType(Material.AIR);
						p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_DEATH, 1F, 1F);
						p.getWorld().dropItem(e.getClickedBlock().getLocation(), ItensAPI.tnt());
	    			}
	    		}
	    		
	    		//
			
//
			
			if(e.getClickedBlock().getType() == Material.ENCHANTING_TABLE) {
	    			if(savee.get(e.getClickedBlock()) == null) {
	    				savee.put(e.getClickedBlock(), 1);
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 0);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 2);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 2) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 1);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 3);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 3) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 2);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 4);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 4) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 3);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 5);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 5) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 4);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 6);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 6) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 5);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 7);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 7) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 6);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 8);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 8) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 7);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.put(e.getClickedBlock(), 9);
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(savee.get(e.getClickedBlock()) == 9) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 8);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								savee.remove(e.getClickedBlock());
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						e.getClickedBlock().setType(Material.AIR);
						p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_DEATH, 1F, 1F);
						p.getWorld().dropItem(e.getClickedBlock().getLocation(), ItensAPI.enchant());
	    			}
	    		}
	    		
	    		//
	    }
	}
	
}
