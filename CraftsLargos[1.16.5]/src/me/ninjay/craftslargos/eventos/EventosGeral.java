package me.ninjay.craftslargos.eventos;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.StructureType;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BoundingBox;

import me.ninjay.craftslargos.estruturas.ItensAPI;
import me.ninjay.craftslargos.main.Main;
import me.ninjay.craftslargos.utils.Mine;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class EventosGeral implements Listener{

	private static ArrayList<Player> fome = new ArrayList<>();
	
	@EventHandler
	public void onEscudo(EntityDamageByEntityEvent e) {
		
		if(e.getEntity() != null) {
			if(e.getDamager() != null) {
				if(e.getEntityType() == EntityType.PLAYER) {
					Player p = (Player) e.getEntity();
					if(p.isBlocking() == true) {
						if(e.getEntity() instanceof LivingEntity) {
							LivingEntity entity = (LivingEntity) e.getDamager();
							entity.damage(200);
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§5Olho")) {
						e.setCancelled(true);
						p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
						p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1F, 1F);
						Location loc = p.getWorld().locateNearestStructure(p.getLocation(), StructureType.STRONGHOLD, 500000, true);
						p.sendMessage(" \n§a  O portal do fim foi localizado!\n \n§e    X: "+loc.getBlockX()+"\n    Z: "+loc.getBlockZ()+"§a\n \n  Boa sorte em seu speedrun!\n ");
					}
					
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§5Espada Larga I")) {
						if(e.getAction() == Action.LEFT_CLICK_AIR) {
							for(Entity entity : p.getWorld().getNearbyEntities(BoundingBox.of(p.getLocation().add(-5, -5, -5), p.getLocation().add(5, 5, 5)))) {
								if(entity.getType() != EntityType.PLAYER) {
								if(entity instanceof LivingEntity) {
									LivingEntity l = (LivingEntity) entity;
									l.damage(5);
								}
								}
							}
						}
					}
					
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§5Espada Larga II")) {
						if(e.getAction() == Action.LEFT_CLICK_AIR) {
							for(Entity entity : p.getWorld().getNearbyEntities(BoundingBox.of(p.getLocation().add(-7, -7, -7), p.getLocation().add(7, 7, 7)))) {
								if(entity.getType() != EntityType.PLAYER) {
								if(entity instanceof LivingEntity) {
									LivingEntity l = (LivingEntity) entity;
									l.damage(7.5);
								}
							}
							}
						}
					}
					
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§5Espada Larga III")) {
						if(e.getAction() == Action.LEFT_CLICK_AIR) {
							for(Entity entity : p.getWorld().getNearbyEntities(BoundingBox.of(p.getLocation().add(-8, -8, -8), p.getLocation().add(8, 8, 8)))) {
								if(entity.getType() != EntityType.PLAYER) {
								if(entity instanceof LivingEntity) {
									LivingEntity l = (LivingEntity) entity;
									l.damage(6);
								}
							}
							}
						}
					}
					
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§5Espada Larga IV")) {
						if(e.getAction() == Action.LEFT_CLICK_AIR) {
							for(Entity entity : p.getWorld().getNearbyEntities(BoundingBox.of(p.getLocation().add(-10, -10, -10), p.getLocation().add(10, 10, 10)))) {
								if(entity.getType() != EntityType.PLAYER) {
								if(entity instanceof LivingEntity) {
									LivingEntity l = (LivingEntity) entity;
									l.damage(10);
								}
							}
							}
						}
					}
					
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Espada Larga V")) {
						if(e.getAction() == Action.LEFT_CLICK_AIR) {
							for(Entity entity : p.getWorld().getNearbyEntities(BoundingBox.of(p.getLocation().add(-15, -15, -15), p.getLocation().add(15, 15, 15)))) {
								if(entity.getType() != EntityType.PLAYER) {
								if(entity instanceof LivingEntity) {
									LivingEntity l = (LivingEntity) entity;
									l.damage(11);
								}
								}
							}
						}
					}
					
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§5Isqueiro")) {
						if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
							if(e.getClickedBlock() != null) {
								for(int x = (int)-1.5; x <= 1.5; x++) {
									for(int z = (int)-1.5; z <= 1.5; z++) {
										if(p.getWorld().getBlockAt(e.getClickedBlock().getLocation().add(x, 0, z)).getType() != Material.AIR) {
											if(p.getWorld().getBlockAt(e.getClickedBlock().getLocation().add(x, 1, z)).getType() == Material.AIR) {
											p.getWorld().getBlockAt(e.getClickedBlock().getLocation().add(x, 1, z)).setType(Material.FIRE);
											}
										}
									}
								}
							}
						}
						if(e.getAction() == Action.RIGHT_CLICK_AIR) {
							Block bloco = p.getTargetBlock(null, 50);
							p.playSound(p.getLocation(), Sound.ITEM_FLINTANDSTEEL_USE, 1F, 1F);
							for(int x = (int)-1.5; x <= 1.5; x++) {
									for(int z = (int)-1.5; z <= 1.5; z++) {
										if(p.getWorld().getBlockAt(bloco.getLocation().add(x, 0, z)).getType() != Material.AIR) {
											if(p.getWorld().getBlockAt(bloco.getLocation().add(x, 1, z)).getType() == Material.AIR) {
											p.getWorld().getBlockAt(bloco.getLocation().add(x, 1, z)).setType(Material.FIRE);
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
	
	@EventHandler
	public void onConsume(PlayerItemConsumeEvent e) {

		if(e.getItem().isSimilar(ItensAPI.maca())) {
			new BukkitRunnable() {
				
				@Override
				public void run() {
					e.getPlayer().removePotionEffect(PotionEffectType.REGENERATION);
					e.getPlayer().removePotionEffect(PotionEffectType.ABSORPTION);
					e.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
					e.getPlayer().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
					e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60*20, 4));
					e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60*20, 4));
					e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 60*20, 1));
					e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 60*20, 1));
					e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 60*20, 14));
				}
			}.runTaskLater(Main.getPlugin(Main.class), 3);
		}
		
		if(e.getItem().isSimilar(ItensAPI.beef()) || e.getItem().isSimilar(ItensAPI.bacon())) {
			fome.remove(e.getPlayer());
			e.getPlayer().setFoodLevel(20);
			if(!fome.contains(e.getPlayer())) {
				new BukkitRunnable() {
					int i = 5*60;
					@Override
					public void run() {
						i--;
						e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§aVocê não perderá fome por "+Mine.formatarTempoMS(i)+"!"));
						if(i <= 0) {
						cancel();
						fome.remove(e.getPlayer());
						e.getPlayer().sendMessage(" \n  §cVocê perdeu o efeito de não ficar com fome!\n ");
						}
						}
				}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
			}
			fome.add(e.getPlayer());
			e.getPlayer().sendMessage(" \n  §aVocê não irá perder fome por 5 minutos!\n ");
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
			
		}
	}
	
	@EventHandler
	public void onFome(FoodLevelChangeEvent e) {
		if(e.getEntity() != null) {
			if(e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity();
				if(fome.contains(p)) {
					e.setCancelled(true);
				}
			}
		}
	}
	
	public static ItemStack capa4() {
		ItemStack item = Mine.newItem(Material.NETHERITE_HELMET, "§5Capacete Largo IV", 1, 0, "§7Proteção Infinity", "§7Inquebrável Infinity");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 999999, true);
		meta.addEnchant(Enchantment.DURABILITY, 999999, true);
		
		meta.setUnbreakable(true);
		
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack calca4() {
		ItemStack item = Mine.newItem(Material.NETHERITE_LEGGINGS, "§5Calca Larga IV", 1, 0, "§7Proteção Infinity", "§7Inquebrável Infinity");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 999999, true);
		meta.addEnchant(Enchantment.DURABILITY, 999999, true);
		
		meta.setUnbreakable(true);
		
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack bota4() {
		ItemStack item = Mine.newItem(Material.NETHERITE_BOOTS, "§5Botas Larga IV", 1, 0, "§7Proteção Infinity", "§7Inquebrável Infinity");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 999999, true);
		meta.addEnchant(Enchantment.DURABILITY, 999999, true);
		
		meta.setUnbreakable(true);
		
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		item.setItemMeta(meta);
		return item;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getItemMeta() != null) {
				if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
					if(e.getSlotType() == SlotType.ARMOR) {
						if(p.getInventory().getChestplate() != null) {
							if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§5Peitoral Largo")) {
								p.getInventory().setHelmet(new ItemStack(Material.AIR));
								p.getInventory().setLeggings(new ItemStack(Material.AIR));
								p.getInventory().setBoots(new ItemStack(Material.AIR));
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
		
		if(p.getInventory().getChestplate() != null) {
			if(p.getInventory().getChestplate().getItemMeta() != null) {
				if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("§5Peitoral Largo I")) {
				ItemStack capa = Mine.newItem(Material.IRON_HELMET, "§5Capacete Largo I");
				ItemStack calca = Mine.newItem(Material.IRON_LEGGINGS, "§5Calca Larga I");
				ItemStack bota = Mine.newItem(Material.IRON_BOOTS, "§5Bota Larga I");
				Mine.addEnchant(capa, Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				Mine.addEnchant(capa, Enchantment.DURABILITY, 3);
				Mine.addEnchant(calca, Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				Mine.addEnchant(calca, Enchantment.DURABILITY, 3);
				Mine.addEnchant(bota, Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				Mine.addEnchant(bota, Enchantment.DURABILITY, 3);
				p.getInventory().setHelmet(capa);
				p.getInventory().setLeggings(calca);
				p.getInventory().setBoots(bota);
			}
					if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("§5Peitoral Largo II")) {
						ItemStack capa = Mine.newItem(Material.GOLDEN_HELMET, "§5Capacete Largo II");
						ItemStack calca = Mine.newItem(Material.GOLDEN_LEGGINGS, "§5Calca Larga II");
						ItemStack bota = Mine.newItem(Material.GOLDEN_BOOTS, "§5Bota Larga II");
						Mine.addEnchant(capa, Enchantment.PROTECTION_ENVIRONMENTAL, 5);
						Mine.addEnchant(capa, Enchantment.DURABILITY, 5);
						Mine.addEnchant(calca, Enchantment.PROTECTION_ENVIRONMENTAL, 5);
						Mine.addEnchant(calca, Enchantment.DURABILITY, 5);
						Mine.addEnchant(bota, Enchantment.PROTECTION_ENVIRONMENTAL, 5);
						Mine.addEnchant(bota, Enchantment.DURABILITY, 5);
						p.getInventory().setHelmet(capa);
						p.getInventory().setLeggings(calca);
						p.getInventory().setBoots(bota);
					}
					if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("§5Peitoral Largo III")) {
						ItemStack capa = Mine.newItem(Material.DIAMOND_HELMET, "§5Capacete Largo III");
						ItemStack calca = Mine.newItem(Material.DIAMOND_LEGGINGS, "§5Calca Larga III");
						ItemStack bota = Mine.newItem(Material.DIAMOND_BOOTS, "§5Bota Larga III");
						Mine.addEnchant(capa, Enchantment.PROTECTION_ENVIRONMENTAL, 10);
						Mine.addEnchant(capa, Enchantment.DURABILITY, 10);
						Mine.addEnchant(calca, Enchantment.PROTECTION_ENVIRONMENTAL, 10);
						Mine.addEnchant(calca, Enchantment.DURABILITY, 10);
						Mine.addEnchant(bota, Enchantment.PROTECTION_ENVIRONMENTAL, 10);
						Mine.addEnchant(bota, Enchantment.DURABILITY, 10);
						p.getInventory().setHelmet(capa);
						p.getInventory().setLeggings(calca);
						p.getInventory().setBoots(bota);
					}
					if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("§5Peitoral Largo IV")) {
						p.getInventory().setHelmet(capa4());
						p.getInventory().setLeggings(calca4());
						p.getInventory().setBoots(bota4());
					}
			}
			}
		}else {
			p.getInventory().setHelmet(new ItemStack(Material.AIR));
			p.getInventory().setLeggings(new ItemStack(Material.AIR));
			p.getInventory().setBoots(new ItemStack(Material.AIR));
		}
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§5Picareta Larga III")) {
						for(int x = (int)-8; x <= 8; x++) {
							for(int y = (int)-8; y <= 8; y++) {
								for(int z = (int)-8; z <= 8; z++) {
									if(p.getWorld().getBlockAt(p.getLocation().add(x, y, z)).getType() == Material.COAL_ORE) {
										p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aTodos os carvões da sua região foram transformados em OURO!"));
										p.getWorld().getBlockAt(p.getLocation().add(x, y, z)).setType(Material.GOLD_ORE);
									}
								}
							}
						}
					}
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§5Picareta Larga IV")) {
						for(int x = (int)-8; x <= 8; x++) {
							for(int y = (int)-8; y <= 8; y++) {
								for(int z = (int)-8; z <= 8; z++) {
									if(p.getWorld().getBlockAt(p.getLocation().add(x, y, z)).getType() == Material.COAL_ORE) {
										p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aTodos os carvões da sua região foram transformados em DIAMANTE!"));
										p.getWorld().getBlockAt(p.getLocation().add(x, y, z)).setType(Material.DIAMOND_ORE);
									}
								}
							}
						}
					}
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§6Picareta Larga V")) {
						for(int x = (int)-8; x <= 8; x++) {
							for(int y = (int)-8; y <= 8; y++) {
								for(int z = (int)-8; z <= 8; z++) {
									if(p.getWorld().getBlockAt(p.getLocation().add(x, y, z)).getType() == Material.GOLD_ORE) {
										p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aTodos os ouros da sua região foram transformados em DIAMANTE!"));
										p.getWorld().getBlockAt(p.getLocation().add(x, y, z)).setType(Material.DIAMOND_ORE);
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
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§5Picareta Larga I")) {
						for(int x = (int)-1.5; x <= 1.5; x++) {
							for(int y = (int)-1.5; y <= 1.5; y++) {
								for(int z = (int)-1.5; z <= 1.5; z++) {
									if(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.STONE) {
										if(!p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType().toString().contains("ORE")) {
											p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).breakNaturally();
										}
									}
								}
							}
						}
					}
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§5Picareta Larga II") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§5Picareta Larga III") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§5Picareta Larga IV")) {
						for(int x = (int)-2.5; x <= 2.5; x++) {
							for(int y = (int)-2.5; y <= 2.5; y++) {
								for(int z = (int)-2.5; z <= 2.5; z++) {
									if(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.STONE) {
										if(!p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType().toString().contains("ORE")) {
											p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).breakNaturally();
										}
									}
								}
							}
						}
					}
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§6Picareta Larga V")) {
						for(int x = (int)-10; x <= 10; x++) {
							for(int y = (int)-10; y <= 10; y++) {
								for(int z = (int)-10; z <= 10; z++) {
									if(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.STONE) {
										if(!p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType().toString().contains("ORE")) {
											p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).breakNaturally();
										}
									}
								}
							}
						}
					}
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Machado Largo")) {
						for(int x = (int)-1.5; x <= 1.5; x++) {
							for(int y = (int)-30; y <= 30; y++) {
								for(int z = (int)-1.5; z <= 1.5; z++) {
									if(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType().toString().contains("LOG")) {
										p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).breakNaturally();
									}
								}
							}
						}
					}
					
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§5Machado Largo II")) {
						if(e.getBlock().getType().toString().contains("LEAVES")) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.APPLE));
						}
					}
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§5Machado Largo III")) {
						if(e.getBlock().getType().toString().contains("LEAVES")) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.GOLDEN_APPLE));
						}
					}
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§5Machado Largo IV")) {
						if(e.getBlock().getType().toString().contains("LEAVES")) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
						}
					}
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§6Machado Largo V")) {
						if(e.getBlock().getType().toString().contains("LEAVES")) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.GOLDEN_APPLE));
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.APPLE));
						}
					}
					
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§5Pa Larga I")) {
						if(e.getBlock().getType() == Material.SAND) {
							if(Mine.getChance(0.10)) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.IRON_INGOT));
							}
							}
					}
					
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§5Pa Larga II")) {
						if(e.getBlock().getType() == Material.SAND) {
							if(Mine.getChance(0.10)) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.GOLD_INGOT));
							}
							}
					}
					
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§5Pa Larga III")) {
						if(e.getBlock().getType() == Material.SAND) {
							if(Mine.getChance(0.05)) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.DIAMOND));
							}
							}
					}
					
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§5Pa Larga IV")) {
						if(e.getBlock().getType() == Material.SAND) {
							if(Mine.getChance(0.05)) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.DIAMOND));
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.GOLD_INGOT));
							}
							}
					}
					
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§6Pa Larga V")) {
						if(e.getBlock().getType() == Material.SAND) {
							if(Mine.getChance(0.05)) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.NETHERITE_INGOT));
							}
							}
					}
				}
			}
		}
	}


}
