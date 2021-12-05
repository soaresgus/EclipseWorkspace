package me.ninjay.minguadocriativo.eventos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import me.ninjay.minguadocriativo.utils.Mine;

public class EventosMercado implements Listener{

	private static HashMap<Player, Material> item = new HashMap<>();
	
	private static ItemStack ante() {
		  ItemStack head = Mine.newItem(Material.PLAYER_HEAD, "§ePágina Anterior");

	        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
	        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

	        profile.getProperties().put("textures", new Property("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmIwZjZlOGFmNDZhYzZmYWY4ODkxNDE5MWFiNjZmMjYxZDY3MjZhNzk5OWM2MzdjZjJlNDE1OWZlMWZjNDc3In19fQ=="));

	        try {
	            Method mtd = skullMeta.getClass().getDeclaredMethod("setProfile", GameProfile.class);
	            mtd.setAccessible(true);
	            mtd.invoke(skullMeta, profile);
	        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
	            ((Throwable) ex).printStackTrace();
	        }

	        head.setItemMeta(skullMeta);
	        return head;
	}
	
	private static ItemStack prox() {
		  ItemStack head = Mine.newItem(Material.PLAYER_HEAD, "§ePróxima Página");

	        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
	        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

	        profile.getProperties().put("textures", new Property("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjJmM2EyZGZjZTBjM2RhYjdlZTEwZGIzODVlNTIyOWYxYTM5NTM0YThiYTI2NDYxNzhlMzdjNGZhOTNiIn19fQ=="));

	        try {
	            Method mtd = skullMeta.getClass().getDeclaredMethod("setProfile", GameProfile.class);
	            mtd.setAccessible(true);
	            mtd.invoke(skullMeta, profile);
	        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
	            ((Throwable) ex).printStackTrace();
	        }

	        head.setItemMeta(skullMeta);
	        return head;
	}
	
	@EventHandler
	public void onShift(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		
		if(e.isSneaking() == false) {
			if(p.getInventory().getItemInMainHand() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
						if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Picareta")) {
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							
							Inventory menu = Mine.newInventory("Menu Criativo - 1", 9*6);
							
							for(int i = 0; i<= 53; i++) {
								menu.setItem(i, Mine.newItem(Material.BLACK_STAINED_GLASS_PANE, " "));
							}
							
							
							menu.setItem(Mine.getPosition(2, 2), new ItemStack(Material.STONE));
							menu.setItem(Mine.getPosition(2, 3), new ItemStack(Material.GRANITE));
							menu.setItem(Mine.getPosition(2, 4), new ItemStack(Material.POLISHED_GRANITE));
							menu.setItem(Mine.getPosition(2, 5), new ItemStack(Material.DIORITE));
							menu.setItem(Mine.getPosition(2, 6), new ItemStack(Material.POLISHED_DIORITE));
							menu.setItem(Mine.getPosition(2, 7), new ItemStack(Material.ANDESITE));
							menu.setItem(Mine.getPosition(2, 8), new ItemStack(Material.POLISHED_ANDESITE));
							menu.setItem(Mine.getPosition(3, 2), new ItemStack(Material.DEEPSLATE));
							menu.setItem(Mine.getPosition(3, 3), new ItemStack(Material.COBBLED_DEEPSLATE));
							menu.setItem(Mine.getPosition(3, 4), new ItemStack(Material.CALCITE));
							menu.setItem(Mine.getPosition(3, 5), new ItemStack(Material.GRASS_BLOCK));
							menu.setItem(Mine.getPosition(3, 6), new ItemStack(Material.DIRT));
							menu.setItem(Mine.getPosition(3, 7), new ItemStack(Material.ROOTED_DIRT));
							menu.setItem(Mine.getPosition(3, 8), new ItemStack(Material.CRIMSON_NYLIUM));
							menu.setItem(Mine.getPosition(4, 2), new ItemStack(Material.WARPED_NYLIUM));
							menu.setItem(Mine.getPosition(4, 3), new ItemStack(Material.OAK_PLANKS));
							menu.setItem(Mine.getPosition(4, 4), new ItemStack(Material.BIRCH_PLANKS));
							menu.setItem(Mine.getPosition(4, 5), new ItemStack(Material.WARPED_PLANKS));
							menu.setItem(Mine.getPosition(4, 6), new ItemStack(Material.BEDROCK));
							menu.setItem(Mine.getPosition(4, 7), new ItemStack(Material.SAND));
							menu.setItem(Mine.getPosition(4, 8), new ItemStack(Material.RED_SAND));
							
							menu.setItem(Mine.getPosition(5, 8), prox());
							
							p.openInventory(menu);
							
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getView().getTitle().contains("Criativo")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getType() != Material.PLAYER_HEAD && e.getCurrentItem().getType() != Material.BLACK_STAINED_GLASS_PANE) {
				p.getOpenInventory().close();
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
				p.sendMessage(" \n  §aAgora todos blocos que forem quebrados\n  §aserão transformados no escolhido!\n ");
				item.remove(p);
				item.put(p, e.getCurrentItem().getType());
				}
			}
		}
		
		if(e.getView().getTitle().contains("Menu Criativo - 1")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem() != null) {
					if(e.getCurrentItem().getItemMeta() != null) {
						if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
							if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§ePróxima")) {
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
								
								Inventory menu = Mine.newInventory("Menu Criativo - 2", 9*6);
								
								for(int i = 0; i<= 53; i++) {
									menu.setItem(i, Mine.newItem(Material.BLACK_STAINED_GLASS_PANE, " "));
								}
								
								
								menu.setItem(Mine.getPosition(2, 2), new ItemStack(Material.COAL_ORE));
								menu.setItem(Mine.getPosition(2, 3), new ItemStack(Material.IRON_ORE));
								menu.setItem(Mine.getPosition(2, 4), new ItemStack(Material.COPPER_ORE));
								menu.setItem(Mine.getPosition(2, 5), new ItemStack(Material.GOLD_ORE));
								menu.setItem(Mine.getPosition(2, 6), new ItemStack(Material.REDSTONE_ORE));
								menu.setItem(Mine.getPosition(2, 7), new ItemStack(Material.EMERALD_ORE));
								menu.setItem(Mine.getPosition(2, 8), new ItemStack(Material.LAPIS_ORE));
								menu.setItem(Mine.getPosition(3, 2), new ItemStack(Material.DIAMOND_ORE));
								menu.setItem(Mine.getPosition(3, 3), new ItemStack(Material.NETHER_QUARTZ_ORE));
								menu.setItem(Mine.getPosition(3, 4), new ItemStack(Material.OAK_LEAVES));
								menu.setItem(Mine.getPosition(3, 5), new ItemStack(Material.SPRUCE_LEAVES));
								menu.setItem(Mine.getPosition(3, 6), new ItemStack(Material.BIRCH_LEAVES));
								menu.setItem(Mine.getPosition(3, 7), new ItemStack(Material.JUNGLE_LEAVES));
								menu.setItem(Mine.getPosition(3, 8), new ItemStack(Material.ACACIA_LEAVES));
								menu.setItem(Mine.getPosition(4, 2), new ItemStack(Material.DARK_OAK_LEAVES));
								menu.setItem(Mine.getPosition(4, 3), new ItemStack(Material.AZALEA_LEAVES));
								menu.setItem(Mine.getPosition(4, 4), new ItemStack(Material.FLOWERING_AZALEA_LEAVES));
								menu.setItem(Mine.getPosition(4, 5), new ItemStack(Material.OAK_SAPLING));
								menu.setItem(Mine.getPosition(4, 6), new ItemStack(Material.SPRUCE_SAPLING));
								menu.setItem(Mine.getPosition(4, 7), new ItemStack(Material.BIRCH_SAPLING));
								menu.setItem(Mine.getPosition(4, 8), new ItemStack(Material.JUNGLE_SAPLING));
								
								menu.setItem(Mine.getPosition(5, 8), prox());
								menu.setItem(Mine.getPosition(5, 2), ante());
								
								p.openInventory(menu);
							}
						}
					}
				}
			}
		}
		
		if(e.getView().getTitle().contains("Menu Criativo - 2")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem() != null) {
					if(e.getCurrentItem().getItemMeta() != null) {
						if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
							if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§ePágina Anterior")) {
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
								
								Inventory menu = Mine.newInventory("Menu Criativo - 1", 9*6);
								
								for(int i = 0; i<= 53; i++) {
									menu.setItem(i, Mine.newItem(Material.BLACK_STAINED_GLASS_PANE, " "));
								}
								
								
								menu.setItem(Mine.getPosition(2, 2), new ItemStack(Material.STONE));
								menu.setItem(Mine.getPosition(2, 3), new ItemStack(Material.GRANITE));
								menu.setItem(Mine.getPosition(2, 4), new ItemStack(Material.POLISHED_GRANITE));
								menu.setItem(Mine.getPosition(2, 5), new ItemStack(Material.DIORITE));
								menu.setItem(Mine.getPosition(2, 6), new ItemStack(Material.POLISHED_DIORITE));
								menu.setItem(Mine.getPosition(2, 7), new ItemStack(Material.ANDESITE));
								menu.setItem(Mine.getPosition(2, 8), new ItemStack(Material.POLISHED_ANDESITE));
								menu.setItem(Mine.getPosition(3, 2), new ItemStack(Material.DEEPSLATE));
								menu.setItem(Mine.getPosition(3, 3), new ItemStack(Material.COBBLED_DEEPSLATE));
								menu.setItem(Mine.getPosition(3, 4), new ItemStack(Material.CALCITE));
								menu.setItem(Mine.getPosition(3, 5), new ItemStack(Material.GRASS_BLOCK));
								menu.setItem(Mine.getPosition(3, 6), new ItemStack(Material.DIRT));
								menu.setItem(Mine.getPosition(3, 7), new ItemStack(Material.ROOTED_DIRT));
								menu.setItem(Mine.getPosition(3, 8), new ItemStack(Material.CRIMSON_NYLIUM));
								menu.setItem(Mine.getPosition(4, 2), new ItemStack(Material.WARPED_NYLIUM));
								menu.setItem(Mine.getPosition(4, 3), new ItemStack(Material.OAK_PLANKS));
								menu.setItem(Mine.getPosition(4, 4), new ItemStack(Material.BIRCH_PLANKS));
								menu.setItem(Mine.getPosition(4, 5), new ItemStack(Material.WARPED_PLANKS));
								menu.setItem(Mine.getPosition(4, 6), new ItemStack(Material.BEDROCK));
								menu.setItem(Mine.getPosition(4, 7), new ItemStack(Material.SAND));
								menu.setItem(Mine.getPosition(4, 8), new ItemStack(Material.RED_SAND));
								
								menu.setItem(Mine.getPosition(5, 8), prox());
								
								p.openInventory(menu);
							}
						}
					}
				}
			}
		}
		
		if(e.getView().getTitle().contains("Menu Criativo - 2")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem() != null) {
					if(e.getCurrentItem().getItemMeta() != null) {
						if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
							if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§ePróxima")) {
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
								
								Inventory menu = Mine.newInventory("Menu Criativo - 3", 9*6);
								
								for(int i = 0; i<= 53; i++) {
									menu.setItem(i, Mine.newItem(Material.BLACK_STAINED_GLASS_PANE, " "));
								}
								
								
								menu.setItem(Mine.getPosition(2, 2), new ItemStack(Material.WHITE_BED));
								menu.setItem(Mine.getPosition(2, 3), new ItemStack(Material.ORANGE_BED));
								menu.setItem(Mine.getPosition(2, 4), new ItemStack(Material.MAGENTA_BED));
								menu.setItem(Mine.getPosition(2, 5), new ItemStack(Material.LIGHT_BLUE_BED));
								menu.setItem(Mine.getPosition(2, 6), new ItemStack(Material.YELLOW_BED));
								menu.setItem(Mine.getPosition(2, 7), new ItemStack(Material.GREEN_BED));
								menu.setItem(Mine.getPosition(2, 8), new ItemStack(Material.PINK_BED));
								menu.setItem(Mine.getPosition(3, 2), new ItemStack(Material.GRAY_BED));
								menu.setItem(Mine.getPosition(3, 3), new ItemStack(Material.LIGHT_GRAY_BED));
								menu.setItem(Mine.getPosition(3, 4), new ItemStack(Material.CYAN_BED));
								menu.setItem(Mine.getPosition(3, 5), new ItemStack(Material.PURPLE_BED));
								menu.setItem(Mine.getPosition(3, 6), new ItemStack(Material.BLUE_BED));
								menu.setItem(Mine.getPosition(3, 7), new ItemStack(Material.BROWN_BED));
								menu.setItem(Mine.getPosition(3, 8), new ItemStack(Material.GREEN_BED));
								menu.setItem(Mine.getPosition(4, 2), new ItemStack(Material.GOLDEN_APPLE));
								menu.setItem(Mine.getPosition(4, 3), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
								menu.setItem(Mine.getPosition(4, 4), new ItemStack(Material.COOKED_BEEF));
								menu.setItem(Mine.getPosition(4, 5), new ItemStack(Material.COOKED_PORKCHOP));
								menu.setItem(Mine.getPosition(4, 6), new ItemStack(Material.COOKED_CHICKEN));
								menu.setItem(Mine.getPosition(4, 7), new ItemStack(Material.MELON_SLICE));
								menu.setItem(Mine.getPosition(4, 8), new ItemStack(Material.APPLE));
								
								menu.setItem(Mine.getPosition(5, 8), prox());
								menu.setItem(Mine.getPosition(5, 2), ante());
								
								p.openInventory(menu);
							}
						}
					}
				}
			}
		}
		
		if(e.getView().getTitle().contains("Menu Criativo - 3")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem() != null) {
					if(e.getCurrentItem().getItemMeta() != null) {
						if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
							if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§ePágina Anterior")) {
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
								
								Inventory menu = Mine.newInventory("Menu Criativo - 2", 9*6);
								
								for(int i = 0; i<= 53; i++) {
									menu.setItem(i, Mine.newItem(Material.BLACK_STAINED_GLASS_PANE, " "));
								}
								
								
								menu.setItem(Mine.getPosition(2, 2), new ItemStack(Material.COAL_ORE));
								menu.setItem(Mine.getPosition(2, 3), new ItemStack(Material.IRON_ORE));
								menu.setItem(Mine.getPosition(2, 4), new ItemStack(Material.COPPER_ORE));
								menu.setItem(Mine.getPosition(2, 5), new ItemStack(Material.GOLD_ORE));
								menu.setItem(Mine.getPosition(2, 6), new ItemStack(Material.REDSTONE_ORE));
								menu.setItem(Mine.getPosition(2, 7), new ItemStack(Material.EMERALD_ORE));
								menu.setItem(Mine.getPosition(2, 8), new ItemStack(Material.LAPIS_ORE));
								menu.setItem(Mine.getPosition(3, 2), new ItemStack(Material.DIAMOND_ORE));
								menu.setItem(Mine.getPosition(3, 3), new ItemStack(Material.NETHER_QUARTZ_ORE));
								menu.setItem(Mine.getPosition(3, 4), new ItemStack(Material.OAK_LEAVES));
								menu.setItem(Mine.getPosition(3, 5), new ItemStack(Material.SPRUCE_LEAVES));
								menu.setItem(Mine.getPosition(3, 6), new ItemStack(Material.BIRCH_LEAVES));
								menu.setItem(Mine.getPosition(3, 7), new ItemStack(Material.JUNGLE_LEAVES));
								menu.setItem(Mine.getPosition(3, 8), new ItemStack(Material.ACACIA_LEAVES));
								menu.setItem(Mine.getPosition(4, 2), new ItemStack(Material.DARK_OAK_LEAVES));
								menu.setItem(Mine.getPosition(4, 3), new ItemStack(Material.AZALEA_LEAVES));
								menu.setItem(Mine.getPosition(4, 4), new ItemStack(Material.FLOWERING_AZALEA_LEAVES));
								menu.setItem(Mine.getPosition(4, 5), new ItemStack(Material.OAK_SAPLING));
								menu.setItem(Mine.getPosition(4, 6), new ItemStack(Material.SPRUCE_SAPLING));
								menu.setItem(Mine.getPosition(4, 7), new ItemStack(Material.BIRCH_SAPLING));
								menu.setItem(Mine.getPosition(4, 8), new ItemStack(Material.JUNGLE_SAPLING));
								
								menu.setItem(Mine.getPosition(5, 8), prox());
								menu.setItem(Mine.getPosition(5, 2), ante());
								
								p.openInventory(menu);
							}
						}
					}
				}
			}
		}
		
		if(e.getView().getTitle().contains("Menu Criativo - 3")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem() != null) {
					if(e.getCurrentItem().getItemMeta() != null) {
						if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
							if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§ePróxima")) {
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
								
								Inventory menu = Mine.newInventory("Menu Criativo - 4", 9*6);
								
								for(int i = 0; i<= 53; i++) {
									menu.setItem(i, Mine.newItem(Material.BLACK_STAINED_GLASS_PANE, " "));
								}
								
								
								menu.setItem(Mine.getPosition(2, 2), new ItemStack(Material.AXOLOTL_SPAWN_EGG));
								menu.setItem(Mine.getPosition(2, 3), new ItemStack(Material.BLAZE_SPAWN_EGG));
								menu.setItem(Mine.getPosition(2, 4), new ItemStack(Material.SPIDER_SPAWN_EGG));
								menu.setItem(Mine.getPosition(2, 5), new ItemStack(Material.CHICKEN_SPAWN_EGG));
								menu.setItem(Mine.getPosition(2, 6), new ItemStack(Material.ENDERMAN_SPAWN_EGG));
								menu.setItem(Mine.getPosition(2, 7), new ItemStack(Material.CREEPER_SPAWN_EGG));
								menu.setItem(Mine.getPosition(2, 8), new ItemStack(Material.GLOW_SQUID_SPAWN_EGG));
								menu.setItem(Mine.getPosition(3, 2), new ItemStack(Material.HOGLIN_SPAWN_EGG));
								menu.setItem(Mine.getPosition(3, 3), new ItemStack(Material.LLAMA_SPAWN_EGG));
								menu.setItem(Mine.getPosition(3, 4), new ItemStack(Material.MAGMA_CUBE_SPAWN_EGG));
								menu.setItem(Mine.getPosition(3, 5), new ItemStack(Material.MOOSHROOM_SPAWN_EGG));
								menu.setItem(Mine.getPosition(3, 6), new ItemStack(Material.PANDA_SPAWN_EGG));
								menu.setItem(Mine.getPosition(3, 7), new ItemStack(Material.PIG_SPAWN_EGG));
								menu.setItem(Mine.getPosition(3, 8), new ItemStack(Material.PIGLIN_SPAWN_EGG));
								menu.setItem(Mine.getPosition(4, 2), new ItemStack(Material.SALMON_SPAWN_EGG));
								menu.setItem(Mine.getPosition(4, 3), new ItemStack(Material.SHEEP_SPAWN_EGG));
								menu.setItem(Mine.getPosition(4, 4), new ItemStack(Material.SKELETON_SPAWN_EGG));
								menu.setItem(Mine.getPosition(4, 5), new ItemStack(Material.SQUID_SPAWN_EGG));
								menu.setItem(Mine.getPosition(4, 6), new ItemStack(Material.TURTLE_SPAWN_EGG));
								menu.setItem(Mine.getPosition(4, 7), new ItemStack(Material.ZOGLIN_SPAWN_EGG));
								menu.setItem(Mine.getPosition(4, 8), new ItemStack(Material.ZOMBIE_SPAWN_EGG));
								
								menu.setItem(Mine.getPosition(5, 8), prox());
								menu.setItem(Mine.getPosition(5, 2), ante());
								
								p.openInventory(menu);
							}
						}
					}
				}
			}
		}
		
		if(e.getView().getTitle().contains("Menu Criativo - 4")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem() != null) {
					if(e.getCurrentItem().getItemMeta() != null) {
						if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
							if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§ePágina Anterior")) {
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
								
								Inventory menu = Mine.newInventory("Menu Criativo - 3", 9*6);
								
								for(int i = 0; i<= 53; i++) {
									menu.setItem(i, Mine.newItem(Material.BLACK_STAINED_GLASS_PANE, " "));
								}
								
								
								menu.setItem(Mine.getPosition(2, 2), new ItemStack(Material.WHITE_BED));
								menu.setItem(Mine.getPosition(2, 3), new ItemStack(Material.ORANGE_BED));
								menu.setItem(Mine.getPosition(2, 4), new ItemStack(Material.MAGENTA_BED));
								menu.setItem(Mine.getPosition(2, 5), new ItemStack(Material.LIGHT_BLUE_BED));
								menu.setItem(Mine.getPosition(2, 6), new ItemStack(Material.YELLOW_BED));
								menu.setItem(Mine.getPosition(2, 7), new ItemStack(Material.GREEN_BED));
								menu.setItem(Mine.getPosition(2, 8), new ItemStack(Material.PINK_BED));
								menu.setItem(Mine.getPosition(3, 2), new ItemStack(Material.GRAY_BED));
								menu.setItem(Mine.getPosition(3, 3), new ItemStack(Material.LIGHT_GRAY_BED));
								menu.setItem(Mine.getPosition(3, 4), new ItemStack(Material.CYAN_BED));
								menu.setItem(Mine.getPosition(3, 5), new ItemStack(Material.PURPLE_BED));
								menu.setItem(Mine.getPosition(3, 6), new ItemStack(Material.BLUE_BED));
								menu.setItem(Mine.getPosition(3, 7), new ItemStack(Material.BROWN_BED));
								menu.setItem(Mine.getPosition(3, 8), new ItemStack(Material.GREEN_BED));
								menu.setItem(Mine.getPosition(4, 2), new ItemStack(Material.GOLDEN_APPLE));
								menu.setItem(Mine.getPosition(4, 3), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
								menu.setItem(Mine.getPosition(4, 4), new ItemStack(Material.COOKED_BEEF));
								menu.setItem(Mine.getPosition(4, 5), new ItemStack(Material.COOKED_PORKCHOP));
								menu.setItem(Mine.getPosition(4, 6), new ItemStack(Material.COOKED_CHICKEN));
								menu.setItem(Mine.getPosition(4, 7), new ItemStack(Material.MELON_SLICE));
								menu.setItem(Mine.getPosition(4, 8), new ItemStack(Material.APPLE));
								
								menu.setItem(Mine.getPosition(5, 8), prox());
								menu.setItem(Mine.getPosition(5, 2), ante());
								
								p.openInventory(menu);
							}
						}
					}
				}
			}
		}
		
		if(e.getView().getTitle().contains("Menu Criativo - 4")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem() != null) {
					if(e.getCurrentItem().getItemMeta() != null) {
						if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
							if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§ePróxima")) {
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
								
								Inventory menu = Mine.newInventory("Menu Criativo - 5", 9*6);
								
								for(int i = 0; i<= 53; i++) {
									menu.setItem(i, Mine.newItem(Material.BLACK_STAINED_GLASS_PANE, " "));
								}
								
								
								menu.setItem(Mine.getPosition(2, 2), new ItemStack(Material.NETHERITE_HELMET));
								menu.setItem(Mine.getPosition(2, 3), new ItemStack(Material.NETHERITE_CHESTPLATE));
								menu.setItem(Mine.getPosition(2, 4), new ItemStack(Material.NETHERITE_LEGGINGS));
								menu.setItem(Mine.getPosition(2, 5), new ItemStack(Material.NETHERITE_BOOTS));
								menu.setItem(Mine.getPosition(2, 6), new ItemStack(Material.NETHERITE_SWORD));
								menu.setItem(Mine.getPosition(2, 7), new ItemStack(Material.NETHERITE_PICKAXE));
								menu.setItem(Mine.getPosition(2, 8), new ItemStack(Material.NETHERITE_AXE));
								menu.setItem(Mine.getPosition(3, 2), new ItemStack(Material.DIAMOND_HELMET));
								menu.setItem(Mine.getPosition(3, 3), new ItemStack(Material.DIAMOND_CHESTPLATE));
								menu.setItem(Mine.getPosition(3, 4), new ItemStack(Material.DIAMOND_LEGGINGS));
								menu.setItem(Mine.getPosition(3, 5), new ItemStack(Material.DIAMOND_BOOTS));
								menu.setItem(Mine.getPosition(3, 6), new ItemStack(Material.DIAMOND_SWORD));
								menu.setItem(Mine.getPosition(3, 7), new ItemStack(Material.DIAMOND_PICKAXE));
								menu.setItem(Mine.getPosition(3, 8), new ItemStack(Material.DIAMOND_AXE));
								menu.setItem(Mine.getPosition(4, 2), new ItemStack(Material.GOLDEN_HELMET));
								menu.setItem(Mine.getPosition(4, 3), new ItemStack(Material.GOLDEN_CHESTPLATE));
								menu.setItem(Mine.getPosition(4, 4), new ItemStack(Material.GOLDEN_LEGGINGS));
								menu.setItem(Mine.getPosition(4, 5), new ItemStack(Material.GOLDEN_BOOTS));
								menu.setItem(Mine.getPosition(4, 6), new ItemStack(Material.GOLDEN_SWORD));
								menu.setItem(Mine.getPosition(4, 7), new ItemStack(Material.GOLDEN_PICKAXE));
								menu.setItem(Mine.getPosition(4, 8), new ItemStack(Material.GOLDEN_AXE));
								
								menu.setItem(Mine.getPosition(5, 2), ante());
								
								p.openInventory(menu);
							}
						}
					}
				}
			}
		}
		
		if(e.getView().getTitle().contains("Menu Criativo - 5")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem() != null) {
					if(e.getCurrentItem().getItemMeta() != null) {
						if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
							if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§ePágina Anterior")) {
								p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
								
Inventory menu = Mine.newInventory("Menu Criativo - 4", 9*6);
								
								for(int i = 0; i<= 53; i++) {
									menu.setItem(i, Mine.newItem(Material.BLACK_STAINED_GLASS_PANE, " "));
								}
								
								
								menu.setItem(Mine.getPosition(2, 2), new ItemStack(Material.AXOLOTL_SPAWN_EGG));
								menu.setItem(Mine.getPosition(2, 3), new ItemStack(Material.BLAZE_SPAWN_EGG));
								menu.setItem(Mine.getPosition(2, 4), new ItemStack(Material.SPIDER_SPAWN_EGG));
								menu.setItem(Mine.getPosition(2, 5), new ItemStack(Material.CHICKEN_SPAWN_EGG));
								menu.setItem(Mine.getPosition(2, 6), new ItemStack(Material.ENDERMAN_SPAWN_EGG));
								menu.setItem(Mine.getPosition(2, 7), new ItemStack(Material.CREEPER_SPAWN_EGG));
								menu.setItem(Mine.getPosition(2, 8), new ItemStack(Material.GLOW_SQUID_SPAWN_EGG));
								menu.setItem(Mine.getPosition(3, 2), new ItemStack(Material.HOGLIN_SPAWN_EGG));
								menu.setItem(Mine.getPosition(3, 3), new ItemStack(Material.LLAMA_SPAWN_EGG));
								menu.setItem(Mine.getPosition(3, 4), new ItemStack(Material.MAGMA_CUBE_SPAWN_EGG));
								menu.setItem(Mine.getPosition(3, 5), new ItemStack(Material.MOOSHROOM_SPAWN_EGG));
								menu.setItem(Mine.getPosition(3, 6), new ItemStack(Material.PANDA_SPAWN_EGG));
								menu.setItem(Mine.getPosition(3, 7), new ItemStack(Material.PIG_SPAWN_EGG));
								menu.setItem(Mine.getPosition(3, 8), new ItemStack(Material.PIGLIN_SPAWN_EGG));
								menu.setItem(Mine.getPosition(4, 2), new ItemStack(Material.SALMON_SPAWN_EGG));
								menu.setItem(Mine.getPosition(4, 3), new ItemStack(Material.SHEEP_SPAWN_EGG));
								menu.setItem(Mine.getPosition(4, 4), new ItemStack(Material.SKELETON_SPAWN_EGG));
								menu.setItem(Mine.getPosition(4, 5), new ItemStack(Material.SQUID_SPAWN_EGG));
								menu.setItem(Mine.getPosition(4, 6), new ItemStack(Material.TURTLE_SPAWN_EGG));
								menu.setItem(Mine.getPosition(4, 7), new ItemStack(Material.ZOGLIN_SPAWN_EGG));
								menu.setItem(Mine.getPosition(4, 8), new ItemStack(Material.ZOMBIE_SPAWN_EGG));
								
								menu.setItem(Mine.getPosition(5, 8), prox());
								menu.setItem(Mine.getPosition(5, 2), ante());
								
								p.openInventory(menu);
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
		
		if(item.get(p) != null) {
			if(p.getInventory().getItemInMainHand() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
						if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Picareta")) {
							e.setDropItems(false);
							p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(item.get(p)));
						}
					}
				}
			}
		}
	}

}
