package me.ninjay.geleiabedrock.eventos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.geleiabedrock.estruturas.ItensAPI;
import me.ninjay.geleiabedrock.main.Main;
import me.ninjay.geleiabedrock.utils.Mine;
import net.minecraft.server.v1_12_R1.BlockPosition;
import net.minecraft.server.v1_12_R1.PacketPlayOutBlockBreakAnimation;

public class EventosGeral implements Listener{
	
	private static HashMap<Block, Integer> save = new HashMap<>();
	
	@EventHandler
	public void onBreakItem(PlayerItemDamageEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Bedrock") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("bedrock")) {
					e.setCancelled(true);
				}
				}
			}
		}
		for(ItemStack armor : p.getInventory().getArmorContents()) {
			if(armor != null) {
				if(armor.getItemMeta() != null) {
					if(armor.getItemMeta().getDisplayName() != null) {
						if(armor.getItemMeta().getDisplayName().contains("Bedrock")) {
							e.setCancelled(true);
						}
					}
				}
			}
		}
	}
	
	  @EventHandler
	  public void onBreakInteract(PlayerInteractEvent e) {
	    Player p = e.getPlayer();
	    
	    if(e.getAction() == Action.LEFT_CLICK_BLOCK) {
	    	if(p.getInventory().getItemInMainHand().getType() == Material.IRON_PICKAXE) {
	    		if(e.getClickedBlock().getType() == Material.BEDROCK) {
	    			if(save.get(e.getClickedBlock()) == null) {
	    				save.put(e.getClickedBlock(), 1);
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 0);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								save.put(e.getClickedBlock(), 2);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(save.get(e.getClickedBlock()) == 2) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 1);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								save.put(e.getClickedBlock(), 3);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(save.get(e.getClickedBlock()) == 3) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 2);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								save.put(e.getClickedBlock(), 4);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(save.get(e.getClickedBlock()) == 4) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 3);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								save.put(e.getClickedBlock(), 5);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(save.get(e.getClickedBlock()) == 5) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 4);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								save.put(e.getClickedBlock(), 6);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(save.get(e.getClickedBlock()) == 6) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 5);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								save.put(e.getClickedBlock(), 7);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(save.get(e.getClickedBlock()) == 7) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 6);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								save.put(e.getClickedBlock(), 8);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(save.get(e.getClickedBlock()) == 8) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 7);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								save.put(e.getClickedBlock(), 9);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
	    			}
	    			if(save.get(e.getClickedBlock()) == 9) {
	    				PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(new Random().nextInt(2000), new BlockPosition(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ()), 8);
	    		    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	    		    	new BukkitRunnable() {
							
							@Override
							public void run() {
								save.remove(e.getClickedBlock());
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
						e.getClickedBlock().setType(Material.AIR);
						p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
						p.getWorld().spawnParticle(Particle.BLOCK_CRACK, e.getClickedBlock().getLocation(), 100, 0.3, 0.5, 0.3, 0.3, new MaterialData(Material.BEDROCK));
						p.getWorld().dropItem(e.getClickedBlock().getLocation(), ItensAPI.fragmento());
	    			}
	    		}
	    	}
	    }
	  }

	@EventHandler
	public void onFornalha(FurnaceSmeltEvent e) {
		if(e.getResult().getType() == Material.CLAY_BRICK) {
			e.setResult(ItensAPI.barras());
		}
	}
	
	@EventHandler
	public void craftBlock(PrepareItemCraftEvent e) {
		
	if(e.getRecipe() != null) {
		if(e.getRecipe().getResult().getType() == Material.FLOWER_POT_ITEM) {
			e.getInventory().setResult(new ItemStack(Material.AIR));
		}
	}
	}

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§dPicareta de Bedrock")) {
					for(int x = (int)-8; x < 8; x++) {
						for(int y = (int)-8; y < 8; y++) {
							for(int z = (int)-8; z < 8; z++) {
								Location loc1 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()+y, e.getBlock().getZ()+z);
								Location loc2 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()+y, e.getBlock().getZ()-z);
								Location loc3 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()+y, e.getBlock().getZ()-z);
								Location loc4 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()+y, e.getBlock().getZ()+z);
								Location loc5 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()-y, e.getBlock().getZ()+z);
								Location loc6 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()-y, e.getBlock().getZ()-z);
								Location loc7 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()-y, e.getBlock().getZ()-z);
								Location loc8 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()-y, e.getBlock().getZ()+z);
								p.getWorld().getBlockAt(loc1).breakNaturally();
								p.getWorld().getBlockAt(loc2).breakNaturally();
								p.getWorld().getBlockAt(loc3).breakNaturally();
								p.getWorld().getBlockAt(loc4).breakNaturally();
								p.getWorld().getBlockAt(loc5).breakNaturally();
								p.getWorld().getBlockAt(loc6).breakNaturally();
								p.getWorld().getBlockAt(loc7).breakNaturally();
								p.getWorld().getBlockAt(loc8).breakNaturally();
							}
						}
					}
				}
				}
			}
		}
		
	}

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§dMachado de Bedrock")) {
					for(int x = (int)-3; x < 3; x++) {
						for(int y = (int)-3; y < 3; y++) {
							for(int z = (int)-3; z < 3; z++) {
								if(p.getWorld().getBlockAt(new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+y, p.getLocation().getZ()+z)).getType().toString().contains("LOG")) {
									p.getWorld().getBlockAt(new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+y, p.getLocation().getZ()+z)).breakNaturally();
								}
							}
						}
					}
				}
				}
			}
		}
		if(p.hasPotionEffect(PotionEffectType.LUCK)) {
			Location loc = new Location(p.getWorld(), Mine.getRandomDouble(p.getLocation().getX()-5, p.getLocation().getX()+5), Mine.getRandomDouble(p.getLocation().getY(), p.getLocation().getY()+3), Mine.getRandomDouble(p.getLocation().getZ()-5, p.getLocation().getZ()+5));
			ArrayList<ItemStack> items = new ArrayList<>();
			items.clear();
			items.add(new ItemStack(Material.DIAMOND));
			items.add(new ItemStack(Material.GOLD_INGOT));
			items.add(new ItemStack(Material.EMERALD));
			items.add(new ItemStack(Material.NETHER_STAR));
			items.add(Mine.newItem(Material.SKULL_ITEM, null, 1, 1));
			p.getWorld().dropItem(loc, Mine.getRandomItem(items));
		}
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equals("§dCapacete de Bedrock")) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 999999));
				}else {
					if(!p.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
					p.removePotionEffect(PotionEffectType.REGENERATION);
					}
				}
			}
			}
		}else {
			if(!p.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
			p.removePotionEffect(PotionEffectType.REGENERATION);
			}
		}
		if(p.getInventory().getChestplate() != null) {
			if(p.getInventory().getChestplate().getItemMeta() != null) {
				if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
				if(p.getInventory().getChestplate().getItemMeta().getDisplayName().equals("§dPeitoral de Bedrock")) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999, 999999999));
				}else {
					p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
				}
			}
			}
		}else {
			p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
		}
		if(p.getInventory().getLeggings() != null) {
			if(p.getInventory().getLeggings().getItemMeta() != null) {
				if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
				if(p.getInventory().getLeggings().getItemMeta().getDisplayName().equals("§dCalcas de Bedrock")) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 2));
				}else {
					p.removePotionEffect(PotionEffectType.SPEED);
				}
				}
			}
		}else {
			p.removePotionEffect(PotionEffectType.SPEED);
		}
	}
	
	@EventHandler
	public void onBow(EntityShootBowEvent e) {
		
		if(e.getEntity() != null) {
			if(e.getEntityType() == EntityType.PLAYER) {
				Player p = (Player) e.getEntity();
				p.launchProjectile(Arrow.class);
				p.launchProjectile(Arrow.class);
				p.launchProjectile(Arrow.class);
				p.launchProjectile(Arrow.class);
				p.launchProjectile(Arrow.class);
				p.launchProjectile(Arrow.class);
			}
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§dEnderpearl de Bedrock")) {
					if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							p.getInventory().setItemInMainHand(ItensAPI.ender());
						}
					}.runTaskLater(Main.getPlugin(Main.class), 3);
				}
				}
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§dSpawn Bedrock Golem")) {
					if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
						e.setCancelled(true);
						if(e.getClickedBlock() != null) {
					for(int i = 0; i < 10; i++) {
						p.getWorld().spawn(e.getClickedBlock().getLocation().add(Mine.getRandomDouble(-1, 1), 1, Mine.getRandomDouble(-1, -1)), IronGolem.class);
					}
						}
					}
				}
			}
			}
		}
	}

	@EventHandler
	public void aoExplodir(EntityExplodeEvent e) {
        if (e.getEntity().getType() == EntityType.PRIMED_TNT) {
      String list = "STONE";
      List destroyed = e.blockList();
      Iterator it = destroyed.iterator();
      while (it.hasNext()) {
        Block block = (Block)it.next();
        String name = block.getType().toString();
        if (list.contains(name))
          it.remove();
          block.setType(Material.BEDROCK);
      }
    }
	}

	@EventHandler
	public void onConsume(PlayerItemConsumeEvent e) {
		Player p = e.getPlayer();
		
		if(e.getItem().getType() == Material.MILK_BUCKET) {
			if(e.getItem().getItemMeta() != null) {
				if(e.getItem().getItemMeta().getDisplayName() != null) {
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dBalde de Bedrock")) {
				new BukkitRunnable() {
					
					@Override
					public void run() {
						p.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 31*20, 0, true, true));
					}
				}.runTaskLater(Main.getPlugin(Main.class), 3);
			}
			}
			}
		}
	}
	
	@EventHandler
	public void onSneak(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getBoots() != null) {
			if(p.getInventory().getBoots().getItemMeta() != null) {
				if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
				if(p.getInventory().getBoots().getItemMeta().getDisplayName().equals("§dBotas de Bedrock")) {
					if(p.isSneaking() == false) {
						p.spawnParticle(Particle.EXPLOSION_LARGE, p.getLocation().add(0, 1.5, 0), 50, 0.5, 0.5, 0.5, 0.5);
						p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 3F, 3F);
						for(Entity mobs : p.getWorld().getNearbyEntities(p.getLocation(), 8, 8, 8)) {
								if(mobs != null) {
								if(mobs != p) {
									if(mobs.getType() != EntityType.ENDER_DRAGON) {
									if(mobs instanceof LivingEntity) {
										LivingEntity l = (LivingEntity) mobs;
										l.damage(l.getMaxHealth());
									}
									}
									}
								}
						}
					}
				}
			}
			}
		}
	}
}
