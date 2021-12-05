package me.ninjay.luckyblocksyt.eventos;


import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Bed;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Giant;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.SkeletonHorse;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import me.ninjay.luckyblocksyt.main.Main;
import me.ninjay.luckyblocksyt.utils.Mine;

public class EventosGeral implements Listener{
	
	private static boolean flecha = false;
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlock() != null) {
			if(e.getBlock().getType() == Material.WHITE_CONCRETE) {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				for(int x = 0; x < 3; x++) {
			    	for(int z = 0; z < 3; z++) {
			    		Location loc1 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY(), e.getBlock().getLocation().getZ()+z);
			    		Location loc2 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY(), e.getBlock().getLocation().getZ()-z);
			    		Location loc3 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY(), e.getBlock().getLocation().getZ()-z);
			    		Location loc4 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY(), e.getBlock().getLocation().getZ()+z);
			    		e.getBlock().getWorld().spawnParticle(Particle.VILLAGER_ANGRY, loc1, 1, 0.1, 0.1, 0.1);
			    		e.getBlock().getWorld().spawnParticle(Particle.VILLAGER_ANGRY, loc2, 1, 0.1, 0.1, 0.1);
			    		e.getBlock().getWorld().spawnParticle(Particle.VILLAGER_ANGRY, loc3, 1, 0.1, 0.1, 0.1);
			    		e.getBlock().getWorld().spawnParticle(Particle.VILLAGER_ANGRY, loc4, 1, 0.1, 0.1, 0.1);
			    	}
			    }
			}
			if(e.getBlock().getType() == Material.GREEN_CONCRETE) {
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
				for(int x = 0; x < 3; x++) {
			    	for(int z = 0; z < 3; z++) {
			    		Location loc1 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		Location loc2 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc3 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc4 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		e.getBlock().getWorld().spawnParticle(Particle.VILLAGER_HAPPY, loc1, 5, 0.1, 0.1, 0.1);
			    		e.getBlock().getWorld().spawnParticle(Particle.VILLAGER_HAPPY, loc2, 5, 0.1, 0.1, 0.1);
			    		e.getBlock().getWorld().spawnParticle(Particle.VILLAGER_HAPPY, loc3, 5, 0.1, 0.1, 0.1);
			    		e.getBlock().getWorld().spawnParticle(Particle.VILLAGER_HAPPY, loc4, 5, 0.1, 0.1, 0.1);
			    	}
			    }
			}
			if(e.getBlock().getType() == Material.BLUE_CONCRETE) {
				p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 1F);
				for(int x = 0; x < 3; x++) {
			    	for(int z = 0; z < 3; z++) {
			    		Location loc1 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		Location loc2 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc3 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc4 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		e.getBlock().getWorld().spawnParticle(Particle.PORTAL, loc1, 15, 0.1, 0.1, 0.1);
			    		e.getBlock().getWorld().spawnParticle(Particle.PORTAL, loc2, 15, 0.1, 0.1, 0.1);
			    		e.getBlock().getWorld().spawnParticle(Particle.PORTAL, loc3, 15, 0.1, 0.1, 0.1);
			    		e.getBlock().getWorld().spawnParticle(Particle.PORTAL, loc4, 15, 0.1, 0.1, 0.1);
			    	}
			    }
			}
			if(e.getBlock().getType() == Material.LIME_CONCRETE) {
				p.playSound(p.getLocation(), Sound.ENTITY_PIG_AMBIENT, 1F, 1F);
				for(int x = 0; x < 3; x++) {
			    	for(int z = 0; z < 3; z++) {
			    		Location loc1 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		Location loc2 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc3 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc4 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		e.getBlock().getWorld().spawnParticle(Particle.ITEM_CRACK, loc1, 5, 0.1, 0.1, 0.1, 0.1, new ItemStack(Material.PORKCHOP));
			    		e.getBlock().getWorld().spawnParticle(Particle.ITEM_CRACK, loc2, 5, 0.1, 0.1, 0.1, 0.1, new ItemStack(Material.PORKCHOP));
			    		e.getBlock().getWorld().spawnParticle(Particle.ITEM_CRACK, loc3, 5, 0.1, 0.1, 0.1, 0.1, new ItemStack(Material.PORKCHOP));
			    		e.getBlock().getWorld().spawnParticle(Particle.ITEM_CRACK, loc4, 5, 0.1, 0.1, 0.1, 0.1, new ItemStack(Material.PORKCHOP));
			    	}
			    }
			}
			if(e.getBlock().getType() == Material.RED_CONCRETE) {
				p.playSound(p.getLocation(), Sound.ENTITY_GHAST_AMBIENT, 1F, 1F);
				for(int x = 0; x < 3; x++) {
			    	for(int z = 0; z < 3; z++) {
			    		Location loc1 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		Location loc2 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc3 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc4 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		e.getBlock().getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, loc1, 1, 0.1, 0.1, 0.1, 0.1);
			    		e.getBlock().getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, loc2, 1, 0.1, 0.1, 0.1, 0.1);
			    		e.getBlock().getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, loc3, 1, 0.1, 0.1, 0.1, 0.1);
			    		e.getBlock().getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, loc4, 1, 0.1, 0.1, 0.1, 0.1);
			    	}
			    }
			}
			if(e.getBlock().getType() == Material.MAGENTA_CONCRETE) {
				p.playSound(p.getLocation(), Sound.ENTITY_SHEEP_AMBIENT, 1F, 1F);
				for(int x = 0; x < 3; x++) {
			    	for(int z = 0; z < 3; z++) {
			    		Location loc1 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		Location loc2 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc3 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc4 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		e.getBlock().getWorld().spawnParticle(Particle.HEART, loc1, 1, 0.1, 0.1, 0.1, 0.1);
			    		e.getBlock().getWorld().spawnParticle(Particle.HEART, loc2, 1, 0.1, 0.1, 0.1, 0.1);
			    		e.getBlock().getWorld().spawnParticle(Particle.HEART, loc3, 1, 0.1, 0.1, 0.1, 0.1);
			    		e.getBlock().getWorld().spawnParticle(Particle.HEART, loc4, 1, 0.1, 0.1, 0.1, 0.1);
			    	}
			    }
			}
			if(e.getBlock().getType() == Material.LIGHT_BLUE_CONCRETE) {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_YES, 1F, 1F);
				for(int x = 0; x < 3; x++) {
			    	for(int z = 0; z < 3; z++) {
			    		Location loc1 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		Location loc2 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc3 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc4 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		e.getBlock().getWorld().spawnParticle(Particle.FLAME, loc1, 1, 0.1, 0.1, 0.1, 0.1);
			    		e.getBlock().getWorld().spawnParticle(Particle.FLAME, loc2, 1, 0.1, 0.1, 0.1, 0.1);
			    		e.getBlock().getWorld().spawnParticle(Particle.FLAME, loc3, 1, 0.1, 0.1, 0.1, 0.1);
			    		e.getBlock().getWorld().spawnParticle(Particle.FLAME, loc4, 1, 0.1, 0.1, 0.1, 0.1);
			    	}
			    }
			}
		}
	}

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§6Picareta")) {
						String coment1 = " \n §f§lNinjaCraft2007 §7há 7 horas\n  §fquem curtiu meu comentario sera abençoaddo!\n ";
						String coment2 = " \n §f§lLuz Radioativa §7há 3 dias\n  §fNunca vi um vídeo melhor! Like like like :DDDDDDD\n ";
						String coment3 = " \n §f§lDeecoyCraft §7há 1 hora (editado)\n  §facho o minguado o melhor de todos\n ";
						String coment4 = " \n §f§lKofEdu §7há 3 horas\n  §fUm dia vou conhecer meu idolo ^^\n ";
						String coment5 = " \n §f§llovesuco §7agora pouco\n  §fMinguado é mó engraçado kkkkk\n ";
						String coment6 = " \n §f§lMarcelinhoD12 §7há 3 semanas\n  §fAMEEEI ESSE VIDEO E MINHA FAMILIA TBM\n ";
						
						ArrayList<String> coments = new ArrayList<>();
						
						coments.clear();
						coments.add(coment1);
						coments.add(coment2);
						coments.add(coment3);
						coments.add(coment4);
						coments.add(coment5);
						coments.add(coment6);
						
						Bukkit.broadcastMessage(Mine.getRandom(coments));
					}
				}
			}
		}
		
		if(e.getBlock() != null) {
			if(e.getBlock().getType() == Material.WHITE_CONCRETE) {
				if(Mine.getChance(0.50)) {
					ItemStack click = Mine.newItem(Material.BREAD, "§5Poção de ClickBait");
					ItemMeta meta = click.getItemMeta();
					meta.addEnchant(Enchantment.DURABILITY, 1, true);
					meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
					click.setItemMeta(meta);
					b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), click);
				}else {
					eventosGerais(p, e.getBlock());
				}
			}
			
			if(e.getBlock().getType() == Material.GREEN_CONCRETE) {
				if(Mine.getChance(0.50)) {
					if(Mine.getChance(0.50)) {
						new BukkitRunnable() {
							int i = 10;
							@Override
							public void run() {
								i--;
								for(int iz = 1; iz <= 5; iz++) {
									p.getWorld().dropItem(p.getLocation().add(Mine.getRandomDouble(-2, 2), 5, Mine.getRandomDouble(-2, 2)), Mine.newItem(Material.ARROW, null, 64));
									p.getWorld().dropItem(p.getLocation().add(Mine.getRandomDouble(-2, 2), 5, Mine.getRandomDouble(-2, 2)), Mine.newItem(Material.BOW, null, 1));
								}
								if(i <= 0) {
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 10, 10);
					}else {
						p.getWorld().spawn(b.getLocation(), Giant.class);
					}
				}else {
					eventosGerais(p, e.getBlock());
				}
			}
			
			if(e.getBlock().getType() == Material.BLUE_CONCRETE) {
				if(Mine.getChance(0.50)) {
					for(int i = 1; i <= 6; i++) {
						p.getWorld().spawn(b.getLocation().add(Mine.getRandomDouble(-2, 2), 0, Mine.getRandomDouble(-2, 2)), Enderman.class);
					}
				}else {
					eventosGerais(p, e.getBlock());
				}
			}
			
			if(e.getBlock().getType() == Material.LIME_CONCRETE) {
				if(Mine.getChance(0.50)) {
					Pig porco = p.getWorld().spawn(b.getLocation(), Pig.class);
					Pig porco2 = p.getWorld().spawn(b.getLocation(), Pig.class);
					Pig porco3 = p.getWorld().spawn(b.getLocation(), Pig.class);
					porco.setPassenger(porco2);
					porco2.setPassenger(porco3);
				}else {
					eventosGerais(p, e.getBlock());
				}
			}
			
			if(e.getBlock().getType() == Material.RED_CONCRETE) {
				if(Mine.getChance(0.50)) {
					if(Mine.getChance(0.50)) {
						for(int i = 1; i <= 6; i++) {
							p.getWorld().spawn(b.getLocation().add(Mine.getRandomDouble(-2, 2), 0, Mine.getRandomDouble(-2, 2)), Ghast.class);
						}
					}else {
						if(Mine.getChance(0.50)) {
							p.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.DIAMOND_SWORD, "§6Espada em ALTA"));
						}else {
							ItemStack click = Mine.newItem(Material.BREAD, "§5Poção de ClickBait");
							ItemMeta meta = click.getItemMeta();
							meta.addEnchant(Enchantment.DURABILITY, 1, true);
							meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
							click.setItemMeta(meta);
							b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), click);
						}
					}
					
				}else {
					eventosGerais(p, e.getBlock());
				}
			}
			
			if(e.getBlock().getType() == Material.MAGENTA_CONCRETE) {
				if(Mine.getChance(0.50)) {
					for(int i = 1; i <= 6; i++) {
						Sheep sheep = p.getWorld().spawn(b.getLocation().add(Mine.getRandomDouble(-2, 2), 0, Mine.getRandomDouble(-2, 2)), Sheep.class);
						sheep.setColor(DyeColor.getByWoolData((byte) Mine.getRandomInt(1, 14)));
					}
				}else {
					eventosGerais(p, e.getBlock());
				}
			}
			
			if(e.getBlock().getType() == Material.LIGHT_BLUE_CONCRETE) {
				if(Mine.getChance(0.70)) {
					if(Mine.getChance(0.40)) {
						b.getWorld().dropItem(b.getLocation(), Mine.newItem(Material.DIAMOND_PICKAXE, "§6Picareta dos comentarios"));
					}else {
						for(int x = (int)-4; x<=4; x++) {
							for(int z = (int)-4; z<=4; z++) {
								Location loc = new Location(b.getWorld(), b.getX()+x, b.getY(), b.getZ()+z);
								if(Mine.getChance(0.50)) {
									setBed(p.getWorld().getBlockAt(loc), BlockFace.NORTH, Material.LIGHT_BLUE_BED);
								}
							}
						}
					}
				}else {
					eventosGerais(p, e.getBlock());
				}
			}
			
			if(e.getBlock().getType() == Material.LIGHT_BLUE_CONCRETE || e.getBlock().getType() == Material.WHITE_CONCRETE || e.getBlock().getType() == Material.LIME_CONCRETE || e.getBlock().getType() == Material.MAGENTA_CONCRETE || e.getBlock().getType() == Material.RED_CONCRETE || e.getBlock().getType() == Material.BLUE_CONCRETE || e.getBlock().getType() == Material.GREEN_CONCRETE) {
			e.setDropItems(false);
			}
		}
	}
	
	public void setBed(Block start, BlockFace facing, Material material) {
	    for (Bed.Part part : Bed.Part.values()) {
	       final Bed bedData = (Bed) Bukkit.createBlockData(material, (data) -> {
	           ((Bed) data).setPart(part);
	           ((Bed) data).setFacing(facing);
	        });
	        start.setBlockData(bedData);
	        start = start.getRelative(facing.getOppositeFace());
	    }
	}
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		
		if(e.getEntity() != null) {
			if(e.getDamager() != null) {
				if(e.getDamager().getType() == EntityType.PLAYER) {
					Player p = (Player) e.getDamager();
				if(p.getInventory().getItemInMainHand() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
						if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
							if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§6Espada")) {
								p.playSound(p.getLocation(), Sound.ENTITY_PHANTOM_DEATH, 1F, 1F);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									if(e.getEntity() instanceof LivingEntity) {
										LivingEntity l = (LivingEntity) e.getEntity();
										l.setVelocity(new Vector(l.getVelocity().getX(), 2, l.getVelocity().getZ()));
									}
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
								p.sendMessage(" \n  §aSeu alvo está em ALTA :D\n ");
							}
						}
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onConsume(PlayerItemConsumeEvent e) {
		Player p = e.getPlayer();
		
		if(e.getItem() != null) {
			if(e.getItem().getType() == Material.BREAD) {
				new BukkitRunnable() {
					int i = 10;
					@Override
					public void run() {
						i--;
						for(int iz = 1; iz <= 5; iz++) {
							p.getWorld().dropItem(p.getLocation().add(Mine.getRandomDouble(-2, 2), 5, Mine.getRandomDouble(-2, 2)), Mine.newItem(Material.PAPER, "§aDinheiro", 64));
						}
						if(i <= 0) {
							cancel();
						}
					}
				}.runTaskTimer(Main.getPlugin(Main.class), 10, 10);
			}
		}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getBoots() != null) {
			if(p.getInventory().getBoots().getItemMeta() != null) {
				if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("§6Botas")) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10*20, 3));
				}
				if(p.getInventory().getBoots().getItemMeta().getDisplayName().equals("§aBotas de Slime")) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10*20, 2));
				}
			}
		}else {
			p.removePotionEffect(PotionEffectType.JUMP);
		}
	}
	
	public static void eventosGerais(Player p, Block b) {
		Integer inte = Mine.getRandomInt(1, 32);
		
		if(inte == 1) {
			for(int x = (int)-2.5; x <= 2.5; x++) {
				for(int z = (int)-2.5; z <= 2.5; z++) {
					if(Mine.getChance(0.30)) {
						p.getWorld().spawn(p.getLocation().add(x, 25, z), TNTPrimed.class);
					}
				}
			}
		}
		
		if(inte == 2) {
			new BukkitRunnable() {
				int i = 10;
				@Override
				public void run() {
					i--;
					for(int iz = 1; iz <= 5; iz++) {
						p.getWorld().dropItem(p.getLocation().add(Mine.getRandomDouble(-2, 2), 5, Mine.getRandomDouble(-2, 2)), new ItemStack(Material.DIAMOND, 5));
						p.getWorld().dropItem(p.getLocation().add(Mine.getRandomDouble(-2, 2), 5, Mine.getRandomDouble(-2, 2)), new ItemStack(Material.DIAMOND_BLOCK, 5));
					}
					if(i <= 0) {
						cancel();
					}
				}
			}.runTaskTimer(Main.getPlugin(Main.class), 10, 10);
		}
		
		if(inte == 3) {
			p.playSound(p.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 1F, 1F);
			for(int x = (int)-2.5; x < 2.5; x++) {
				for(int z = (int)-2.5; z <2.5; z++) {
					Location loc1 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+8, p.getLocation().getZ()+z, p.getLocation().getYaw(), 90F);
					for(int iz = 1; iz <= 5; iz++) {
						p.getWorld().spawnArrow(loc1, new Vector(0, 0, 0), 1F, 1F);
					}
				if(flecha == false) {
					flecha = true;
					new BukkitRunnable() {
						
						@Override
						public void run() {
							for(Arrow flecha : p.getWorld().getEntitiesByClass(Arrow.class)) {
								flecha.remove();
							}
							flecha = false;
						}
					}.runTaskLater(Main.getPlugin(Main.class), 3*20);
				}
				}
			}
		}
		
		if(inte == 4) {
			b.getWorld().createExplosion(b.getLocation(), 5);
		}
		
		if(inte == 5) {
			Location loc1 = new Location(p.getWorld(), b.getX()+5, b.getY()+5, b.getZ()+5);
			Location loc2 = new Location(p.getWorld(), b.getX()-5, b.getY()-5, b.getZ()-5);
			for(Entity e : b.getWorld().getNearbyEntities(BoundingBox.of(loc1, loc2))) {
				if(e != null) {
					if(e.getType() == EntityType.PLAYER) {
						Player j = (Player) e;
						e.setVelocity(new Vector(0, 10, 0));
						j.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));
					}
				}
			}
		}
		
		if(inte == 6) {
			Mine.newFirework(b.getLocation().add(Mine.getRandomDouble(-1, 1), 1, Mine.getRandomDouble(-1, 1)), 0, Color.GREEN, Color.WHITE, true, true, Type.BALL_LARGE);
			Mine.newFirework(b.getLocation().add(Mine.getRandomDouble(-1, 1), 1, Mine.getRandomDouble(-1, 1)), 0, Color.BLUE, Color.WHITE, true, true, Type.BALL_LARGE);
			Mine.newFirework(b.getLocation().add(Mine.getRandomDouble(-1, 1), 1, Mine.getRandomDouble(-1, 1)), 0, Color.PURPLE, Color.WHITE, true, true, Type.BALL_LARGE);
			Mine.newFirework(b.getLocation().add(Mine.getRandomDouble(-1, 1), 1, Mine.getRandomDouble(-1, 1)), 0, Color.ORANGE, Color.WHITE, true, true, Type.BALL_LARGE);
			Mine.newFirework(b.getLocation().add(Mine.getRandomDouble(-1, 1), 1, Mine.getRandomDouble(-1, 1)), 0, Color.WHITE, Color.WHITE, true, true, Type.BALL_LARGE);
			Mine.newFirework(b.getLocation().add(Mine.getRandomDouble(-1, 1), 1, Mine.getRandomDouble(-1, 1)), 0, Color.LIME, Color.WHITE, true, true, Type.BALL_LARGE);
		
			ItemStack pot1 = Mine.newItem(Material.SPLASH_POTION, "§5Poção de Super Força", 1, 16398, "§9Força X (0:10)");
			PotionMeta pot1meta = (PotionMeta) pot1.getItemMeta();
			pot1meta.setColor(Color.RED);
			pot1meta.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10*20, 10), true);
			pot1meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			pot1.setItemMeta(pot1meta);
			
			ItemStack pot2 = Mine.newItem(Material.SPLASH_POTION, "§5Poção de Super Velocidade", 1, 16398, "§9Velocidade X (0:10)");
			PotionMeta pot2meta = (PotionMeta) pot2.getItemMeta();
			pot2meta.setColor(Color.GRAY);
			pot2meta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 10*20, 10), true);
			pot2meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			pot2.setItemMeta(pot2meta);
			
			ItemStack pot3 = Mine.newItem(Material.SPLASH_POTION, "§5Poção de Super Agilidade", 1, 16398, "§9Agilidade X (0:10)");
			PotionMeta pot3meta = (PotionMeta) pot3.getItemMeta();
			pot3meta.setColor(Color.YELLOW);
			pot3meta.addCustomEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 10*20, 10), true);
			pot3meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			pot3.setItemMeta(pot3meta);
			
			
			b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), pot1);
			b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), pot2);
			b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), pot3);
		}
		
		if(inte == 7) {
			for(int x = (int)-1.5; x <= 1.5; x++) {
				for(int z = (int)-1.5; z <= 1.5; z++) {
					p.getWorld().getBlockAt(p.getLocation().subtract(0, 1, 0)).setType(Material.STONE_BRICKS);
					p.getWorld().getBlockAt(p.getLocation().add(x, -1, z)).setType(Material.STONE_BRICKS);
				}
			}
			
			for(int y = 0; y <= 3; y++) {
				p.getWorld().getBlockAt(p.getLocation().add(0, y, 1)).setType(Material.IRON_BARS);
				p.getWorld().getBlockAt(p.getLocation().add(1, y, 1)).setType(Material.IRON_BARS);
				p.getWorld().getBlockAt(p.getLocation().add(-1, y, 1)).setType(Material.IRON_BARS);
				
				p.getWorld().getBlockAt(p.getLocation().add(0, y, -1)).setType(Material.IRON_BARS);
				p.getWorld().getBlockAt(p.getLocation().add(1, y, -1)).setType(Material.IRON_BARS);
				p.getWorld().getBlockAt(p.getLocation().add(-1, y, -1)).setType(Material.IRON_BARS);
				
				p.getWorld().getBlockAt(p.getLocation().add(1, y, 0)).setType(Material.IRON_BARS);
				p.getWorld().getBlockAt(p.getLocation().add(1, y, 0)).setType(Material.IRON_BARS);
				
				p.getWorld().getBlockAt(p.getLocation().add(-1, y, 0)).setType(Material.IRON_BARS);
				p.getWorld().getBlockAt(p.getLocation().add(-1, y, 0)).setType(Material.IRON_BARS);
				
			}
			
			for(int y = 10; y<= 13; y++) {
				p.getWorld().getBlockAt(p.getLocation().add(0, y, 0)).setType(Material.ANVIL);
			}
		}
		
		if(inte == 8) {
			p.getWorld().getBlockAt(p.getLocation().add(0, 0, 1)).setType(Material.COBWEB);
			p.getWorld().getBlockAt(p.getLocation().add(1, 0, 1)).setType(Material.COBWEB);
			p.getWorld().getBlockAt(p.getLocation().add(-1, 0, 1)).setType(Material.COBWEB);
			
			p.getWorld().getBlockAt(p.getLocation().add(0, 0, -1)).setType(Material.COBWEB);
			p.getWorld().getBlockAt(p.getLocation().add(1, 0, -1)).setType(Material.COBWEB);
			p.getWorld().getBlockAt(p.getLocation().add(-1, 0, -1)).setType(Material.COBWEB);
			
			p.getWorld().getBlockAt(p.getLocation().add(1, 0, 0)).setType(Material.COBWEB);
			p.getWorld().getBlockAt(p.getLocation().add(1, 0, 0)).setType(Material.COBWEB);
			
			p.getWorld().getBlockAt(p.getLocation().add(-1, 0, 0)).setType(Material.COBWEB);
			p.getWorld().getBlockAt(p.getLocation().add(-1, 0, 0)).setType(Material.COBWEB);
			for(int y = 10; y<= 13; y++) {
				p.getWorld().getBlockAt(p.getLocation().add(0, y, 0)).setType(Material.ANVIL);
			}
		}
		
		if(inte == 9) {
			for(int x = (int)-2.5; x <= 2.5; x++) {
				for(int z = (int)-2.5; z <= 2.5; z++) {
					if(p.getWorld().getBlockAt(p.getLocation().add(x, 0, z)) != null) {
						if(Mine.getChance(0.50)) {
						p.getWorld().getBlockAt(p.getLocation().add(x, 0, z)).setType(Material.POPPY);
						}
						if(Mine.getChance(0.50)) {
						p.getWorld().getBlockAt(p.getLocation().add(x, 0, z)).setType(Material.DANDELION);
						}
						if(Mine.getChance(0.50)) {
						p.getWorld().getBlockAt(p.getLocation().add(x, 0, z)).setType(Material.OXEYE_DAISY);
						}
					}
				}
			}
		}
		
		if(inte == 10) {
			b.getWorld().getBlockAt(b.getLocation().add(2, 0 , 2)).setType(b.getType());
			b.getWorld().getBlockAt(b.getLocation().add(-2, 0 , -2)).setType(b.getType());
			b.getWorld().getBlockAt(b.getLocation().add(2, 0 , -2)).setType(b.getType());
			b.getWorld().getBlockAt(b.getLocation().add(-2, 0 , 2)).setType(b.getType());
		}
		
		if(inte == 11) {
			for(int i = 1; i<=3; i++) {
				SkeletonHorse cavalo = p.getWorld().spawn(b.getLocation(), SkeletonHorse.class);
				Skeleton ske = p.getWorld().spawn(b.getLocation(), Skeleton.class);
				ske.setFireTicks(0);
				ske.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 4));
				ske.setTarget(p);
				cavalo.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 20));
				cavalo.setPassenger(ske);
				cavalo.getWorld().strikeLightningEffect(cavalo.getLocation());
			}
		}
		
		if(inte == 12) {
			b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.BEACON, null));
		}
		
		if(inte == 13) {
			for(int i = 1; i <= 128; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.QUARTZ, null));
			}
		}
		
		if(inte == 14) {
			for(int i = 1; i <= 10; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.WATER_BUCKET, null));
			}
			for(int i = 1; i <= 10; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.LAVA_BUCKET, null));
			}
			for(int i = 1; i <= 10; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.MILK_BUCKET, null));
			}
			for(int i = 1; i <= 10; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.BUCKET, null));
			}
		}
		
		if(inte == 15) {
			ItemStack bow = Mine.newItem(Material.BOW, null);
			ItemMeta meta = bow.getItemMeta();
			meta.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
			meta.addEnchant(Enchantment.ARROW_FIRE, 2, true);
			meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
			bow.setItemMeta(meta);
			b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), bow);
		}
		
		if(inte == 16) {
			ItemStack pot1 = Mine.newItem(Material.SPLASH_POTION, "§5Poção de Super Força", 1, 16398, "§9Força X (0:10)");
			PotionMeta pot1meta = (PotionMeta) pot1.getItemMeta();
			pot1meta.setColor(Color.RED);
			pot1meta.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10*20, 10), true);
			pot1meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			pot1.setItemMeta(pot1meta);
			
			ItemStack pot2 = Mine.newItem(Material.SPLASH_POTION, "§5Poção de Super Velocidade", 1, 16398, "§9Velocidade X (0:10)");
			PotionMeta pot2meta = (PotionMeta) pot2.getItemMeta();
			pot2meta.setColor(Color.GRAY);
			pot2meta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 10*20, 10), true);
			pot2meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			pot2.setItemMeta(pot2meta);
			
			ItemStack pot3 = Mine.newItem(Material.SPLASH_POTION, "§5Poção de Super Agilidade", 1, 16398, "§9Agilidade X (0:10)");
			PotionMeta pot3meta = (PotionMeta) pot3.getItemMeta();
			pot3meta.setColor(Color.YELLOW);
			pot3meta.addCustomEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 10*20, 10), true);
			pot3meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			pot3.setItemMeta(pot3meta);
			
			
			b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), pot1);
			b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), pot2);
			b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), pot3);
		}
		
		if(inte == 17) {
			for(int i = 1; i <= 32; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.DIAMOND_BLOCK, null));
			}
		}
		
		if(inte == 18) {
			for(int i = 1; i <= 32; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.EMERALD_BLOCK, null));
			}
		}
		
		if(inte == 19) {
			for(int i = 1; i <= 32; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.IRON_BLOCK, null));
			}
		}
		
		if(inte == 20) {
			for(int i = 1; i <= 32; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.COAL_BLOCK, null));
			}
		}
		
		if(inte == 21) {
			for(int i = 1; i <= 32; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.GOLD_BLOCK, null));
			}
		}
		
		if(inte == 22) {
			for(int i = 1; i <= 32; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.GOLDEN_APPLE, null));
			}
		}
		
		if(inte == 23) {
			for(int i = 1; i <= 10; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.GOLDEN_CARROT, null));
			}
			for(int i = 1; i <= 10; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.APPLE, null));
			}
			for(int i = 1; i <= 10; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.COOKED_BEEF, null));
			}
			for(int i = 1; i <= 10; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.CARROT, null));
			}
			for(int i = 1; i <= 10; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.ROTTEN_FLESH, null));
			}
			for(int i = 1; i <= 10; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.COOKIE, null));
			}
			for(int i = 1; i <= 10; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.PUFFERFISH, null));
			}
		}
		
		if(inte == 24) {
			b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.DIAMOND_BOOTS, "§6Botas de Super Pulo"));
		}
		
		if(inte == 25) {
			for(int i = 1; i <= 16; i++) {
				b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.ENDER_PEARL, null));
			}
		}
		
		if(inte == 26) {
			ItemStack set = Mine.newItem(Material.DIAMOND_HELMET, null);
			ItemMeta meta = set.getItemMeta();
			meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4, true);
			meta.addEnchant(Enchantment.DURABILITY, 3, true);
			set.setItemMeta(meta);
			b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), set);
		}
		
		if(inte == 27) {
			ItemStack set = Mine.newItem(Material.DIAMOND_CHESTPLATE, null);
			ItemMeta meta = set.getItemMeta();
			meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4, true);
			meta.addEnchant(Enchantment.DURABILITY, 3, true);
			set.setItemMeta(meta);
			b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), set);
		}
		
		if(inte == 28) {
			ItemStack set = Mine.newItem(Material.DIAMOND_LEGGINGS, null);
			ItemMeta meta = set.getItemMeta();
			meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4, true);
			meta.addEnchant(Enchantment.DURABILITY, 3, true);
			set.setItemMeta(meta);
			b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), set);
		}
		
		if(inte == 29) {
			ItemStack set = Mine.newItem(Material.DIAMOND_BOOTS, null);
			ItemMeta meta = set.getItemMeta();
			meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4, true);
			meta.addEnchant(Enchantment.DURABILITY, 3, true);
			set.setItemMeta(meta);
			b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), set);
		}
		
		if(inte == 30) {
			ItemStack set = Mine.newItem(Material.DIAMOND_PICKAXE, null);
			ItemMeta meta = set.getItemMeta();
			meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
			meta.addEnchant(Enchantment.DURABILITY, 3, true);
			meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
			set.setItemMeta(meta);
			b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), set);
		}
		
		if(inte == 31) {
			ItemStack set = Mine.newItem(Material.DIAMOND_SWORD, null);
			ItemMeta meta = set.getItemMeta();
			meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
			meta.addEnchant(Enchantment.DURABILITY, 3, true);
			set.setItemMeta(meta);
			b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), set);
		}
		
		if(inte == 32) {
			b.getWorld().dropItem(b.getLocation().add(0, 0.3, 0), Mine.newItem(Material.DIAMOND_BOOTS, "§aBotas de Slime"));
		}
	}
}
