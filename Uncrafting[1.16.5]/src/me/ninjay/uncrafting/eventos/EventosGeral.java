package me.ninjay.uncrafting.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.ninjay.uncrafting.main.Main;
import me.ninjay.uncrafting.utils.Mine;

public class EventosGeral implements Listener {

	public static ItemStack mesa = Mine.newItem(Material.CYAN_CONCRETE, "§dUncrafting Table", 1, 0, " ",
			"  §7Se você não descrafta não venha", "  §7descraftar os descraftadores!");
	public static Inventory menu = Bukkit.createInventory(null, InventoryType.SHULKER_BOX, "Uncrafting Table");

	public static void customCraft() {
		ShapedRecipe rrr = new ShapedRecipe(mesa);

		rrr.shape("@@@", "@#@", "@@@");

		rrr.setIngredient('@', Material.COBBLESTONE);
		rrr.setIngredient('#', Material.CRAFTING_TABLE);
		Main.getPlugin(Main.class).getServer().addRecipe(rrr);
	}

	@EventHandler
	public void onBreak(BlockBreakEvent e) {

		if (e.getBlock().getType() == Material.CYAN_CONCRETE) {
			e.setDropItems(false);
			e.getBlock().getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), mesa);
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if (e.getClickedBlock() != null) {
			if (e.getClickedBlock().getType() == Material.CYAN_CONCRETE) {
				if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					p.openInventory(menu);
					p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F, 1F);
				}
			}
		}
	}

	public static void use(Player player, Inventory menu, ItemStack base, ItemStack a, ItemStack b, ItemStack c,
			ItemStack d, ItemStack e, ItemStack f, ItemStack g, ItemStack h, ItemStack i) {
		if (menu.getItem(Mine.getPosition(2, 2)) != null) {
			if (menu.getItem(Mine.getPosition(2, 2)).getType() == base.getType()) {
				player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
				menu.setItem(Mine.getPosition(1, 6), a);
				menu.setItem(Mine.getPosition(1, 7), b);
				menu.setItem(Mine.getPosition(1, 8), c);
				menu.setItem(Mine.getPosition(2, 6), d);
				menu.setItem(Mine.getPosition(2, 7), e);
				menu.setItem(Mine.getPosition(2, 8), f);
				menu.setItem(Mine.getPosition(3, 6), g);
				menu.setItem(Mine.getPosition(3, 7), h);
				menu.setItem(Mine.getPosition(3, 8), i);
				menu.setItem(Mine.getPosition(2, 2), new ItemStack(Material.AIR));
				player.openInventory(menu);
			}
		}
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getView().getTitle().contains("Uncrafting")) {
			if (e.getCurrentItem() == null) {
				use(p, menu, new ItemStack(Material.ENCHANTED_GOLDEN_APPLE), new ItemStack(Material.GOLDEN_APPLE, 64),
						new ItemStack(Material.GOLDEN_APPLE, 64), new ItemStack(Material.GOLDEN_APPLE, 64),
						new ItemStack(Material.NETHERITE_SWORD), new ItemStack(Material.ELYTRA),
						new ItemStack(Material.NETHERITE_PICKAXE), new ItemStack(Material.GOLDEN_APPLE, 64),
						new ItemStack(Material.GOLDEN_APPLE, 64), new ItemStack(Material.GOLDEN_APPLE, 64));
				
				
				use(p, menu, new ItemStack(Material.FLINT_AND_STEEL), new ItemStack(Material.TNT),
						new ItemStack(Material.TNT), new ItemStack(Material.TNT),
						new ItemStack(Material.TNT), new ItemStack(Material.GRAVEL),
						new ItemStack(Material.TNT), new ItemStack(Material.TNT),
						new ItemStack(Material.TNT), new ItemStack(Material.TNT));
				
				use(p, menu, new ItemStack(Material.WOODEN_PICKAXE), new ItemStack(Material.OAK_PLANKS),
						new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS),
						new ItemStack(Material.AIR), new ItemStack(Material.STICK),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.STICK), new ItemStack(Material.AIR));
				
				
				use(p, menu, new ItemStack(Material.CRAFTING_TABLE), new ItemStack(Material.OAK_PLANKS),
						new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS),
						new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.AIR),
						new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS),
						new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS));
				
				use(p, menu, new ItemStack(Material.BREAD), new ItemStack(Material.WHEAT),
						new ItemStack(Material.WHEAT), new ItemStack(Material.WHEAT),
						new ItemStack(Material.BEEF), new ItemStack(Material.MILK_BUCKET),
						new ItemStack(Material.BEEF), new ItemStack(Material.WHEAT),
						new ItemStack(Material.WHEAT), new ItemStack(Material.WHEAT));
				
				use(p, menu, new ItemStack(Material.OAK_PLANKS, 4), new ItemStack(Material.AIR),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.AIR), new ItemStack(Material.OAK_WOOD),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR));
				
				use(p, menu, new ItemStack(Material.TNT), new ItemStack(Material.GUNPOWDER),
						new ItemStack(Material.SAND), new ItemStack(Material.GUNPOWDER),
						new ItemStack(Material.SAND), new ItemStack(Material.GUNPOWDER),
						new ItemStack(Material.SAND), new ItemStack(Material.GUNPOWDER),
						new ItemStack(Material.BONE), new ItemStack(Material.GUNPOWDER));
				
				use(p, menu, new ItemStack(Material.OBSIDIAN), new ItemStack(Material.COBBLESTONE),
						new ItemStack(Material.COBBLESTONE), new ItemStack(Material.DIAMOND),
						new ItemStack(Material.BONE), new ItemStack(Material.COBBLESTONE),
						new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE),
						new ItemStack(Material.SKELETON_SKULL), new ItemStack(Material.COBBLESTONE));
				
				use(p, menu, new ItemStack(Material.FURNACE), new ItemStack(Material.COBBLESTONE),
						new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE),
						new ItemStack(Material.COBBLESTONE), new ItemStack(Material.AIR),
						new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE),
						new ItemStack(Material.FLINT_AND_STEEL), new ItemStack(Material.COBBLESTONE));
				
				use(p, menu, new ItemStack(Material.CHEST), new ItemStack(Material.OAK_PLANKS),
						new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS),
						new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.AIR),
						new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS),
						new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS));
				
				ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
				addBookEnchantment(book, Enchantment.DAMAGE_ALL, 5);
				
				use(p, menu, new ItemStack(Material.ENCHANTING_TABLE), new ItemStack(Material.AIR),
						book, new ItemStack(Material.AIR),
						new ItemStack(Material.DIAMOND), new ItemStack(Material.OBSIDIAN),
						new ItemStack(Material.DIAMOND), new ItemStack(Material.OBSIDIAN),
						new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN));
				
				use(p, menu, new ItemStack(Material.HAY_BLOCK), new ItemStack(Material.WHEAT),
						new ItemStack(Material.WHEAT), new ItemStack(Material.WHEAT),
						new ItemStack(Material.WHEAT), new ItemStack(Material.EMERALD),
						new ItemStack(Material.WHEAT), new ItemStack(Material.WHEAT),
						new ItemStack(Material.WHEAT), new ItemStack(Material.WHEAT));
				
				use(p, menu, new ItemStack(Material.ANVIL), new ItemStack(Material.IRON_BLOCK),
						new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.IRON_BLOCK),
						new ItemStack(Material.AIR), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.AIR), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT));
				
				ItemStack shield = Mine.newItem(Material.SHIELD, null);
				Mine.addEnchant(shield, Enchantment.DURABILITY, 3);
				ItemStack pic = Mine.newItem(Material.WOODEN_PICKAXE, null);
				Mine.addEnchant(pic, Enchantment.DURABILITY, 3);
				ItemStack vara = Mine.newItem(Material.FISHING_ROD, null);
				Mine.addEnchant(vara, Enchantment.DURABILITY, 3);
				ItemStack axe = Mine.newItem(Material.WOODEN_AXE, null);
				Mine.addEnchant(axe, Enchantment.DURABILITY, 3);
				ItemStack sword = Mine.newItem(Material.WOODEN_SWORD, null);
				Mine.addEnchant(sword, Enchantment.DURABILITY, 3);
				ItemStack pa = Mine.newItem(Material.WOODEN_SHOVEL, null);
				Mine.addEnchant(pa, Enchantment.DURABILITY, 3);
				
				use(p, menu, new ItemStack(Material.WHITE_BED), shield,
						pic, vara,
						new ItemStack(Material.COBWEB), new ItemStack(Material.OAK_PLANKS),
						new ItemStack(Material.COBWEB), axe,
						sword, pa);
				
				use(p, menu, new ItemStack(Material.CHEST_MINECART), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.CHEST),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT));
				
				use(p, menu, new ItemStack(Material.TORCH), new ItemStack(Material.GUNPOWDER),
						new ItemStack(Material.GUNPOWDER), new ItemStack(Material.GUNPOWDER),
						new ItemStack(Material.GUNPOWDER), new ItemStack(Material.STICK),
						new ItemStack(Material.GUNPOWDER), new ItemStack(Material.GUNPOWDER),
						new ItemStack(Material.GUNPOWDER), new ItemStack(Material.GUNPOWDER));
				
				use(p, menu, new ItemStack(Material.BOW), new ItemStack(Material.BAMBOO),
						new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.AIR),
						new ItemStack(Material.BAMBOO), new ItemStack(Material.STICK),
						new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.BAMBOO),
						new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.AIR));
				
				use(p, menu, new ItemStack(Material.RAIL), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.AIR), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.STICK),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.AIR), new ItemStack(Material.IRON_INGOT));
				
				ItemStack peito = Mine.newItem(Material.IRON_CHESTPLATE, null);
				Mine.addEnchant(peito, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				
				use(p, menu, new ItemStack(Material.SHIELD), peito,
						new ItemStack(Material.IRON_INGOT), peito,
						peito, peito,
						peito, new ItemStack(Material.AIR),
						peito, new ItemStack(Material.AIR));
				
				use(p, menu, new ItemStack(Material.FLINT), new ItemStack(Material.TNT),
						new ItemStack(Material.TNT), new ItemStack(Material.TNT),
						new ItemStack(Material.TNT), new ItemStack(Material.GRAVEL),
						new ItemStack(Material.TNT), new ItemStack(Material.TNT),
						new ItemStack(Material.TNT), new ItemStack(Material.TNT));
				
				use(p, menu, new ItemStack(Material.BLAZE_ROD), new ItemStack(Material.BLAZE_POWDER),
						new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.BLAZE_POWDER),
						new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.BLAZE_SPAWN_EGG),
						new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.BLAZE_POWDER),
						new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.BLAZE_POWDER));
				
				use(p, menu, new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.GOLD_BLOCK),
						new ItemStack(Material.GOLD_BLOCK), new ItemStack(Material.GOLD_BLOCK),
						new ItemStack(Material.GOLD_BLOCK), new ItemStack(Material.APPLE),
						new ItemStack(Material.GOLD_BLOCK), new ItemStack(Material.GOLD_BLOCK),
						new ItemStack(Material.GOLD_BLOCK), new ItemStack(Material.GOLD_BLOCK));
				
				ItemStack peitoo = Mine.newItem(Material.NETHERITE_CHESTPLATE, null);
				Mine.addEnchant(peitoo, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				
				use(p, menu, new ItemStack(Material.LAVA_BUCKET), peitoo,
						new ItemStack(Material.ENCHANTED_GOLDEN_APPLE), peitoo,
						peitoo, new ItemStack(Material.BUCKET),
						peitoo, peitoo,
						peitoo, peitoo);
				
				ItemStack capa = Mine.newItem(Material.NETHERITE_HELMET, null);
				Mine.addEnchant(capa, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				
				use(p, menu, new ItemStack(Material.MAGMA_BLOCK), capa,
						new ItemStack(Material.DIAMOND), capa,
						capa, new ItemStack(Material.BUCKET),
						capa, capa,
						capa, capa);
				
				ItemStack calca = Mine.newItem(Material.NETHERITE_LEGGINGS, null);
				Mine.addEnchant(calca, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				
				use(p, menu, new ItemStack(Material.NETHERRACK), calca,
						new ItemStack(Material.BONE), calca,
						calca, new ItemStack(Material.AIR),
						calca, calca,
						calca, new ItemStack(Material.BONE));
				
				ItemStack bota = Mine.newItem(Material.NETHERITE_BOOTS, null);
				Mine.addEnchant(bota, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				
				use(p, menu, new ItemStack(Material.NETHER_BRICKS), bota,
						bota, new ItemStack(Material.BONE),
						bota, new ItemStack(Material.QUARTZ),
						bota, bota,
						bota, bota);
				
				use(p, menu, new ItemStack(Material.GRASS_BLOCK), new ItemStack(Material.DIRT),
						new ItemStack(Material.DIRT), new ItemStack(Material.DIRT),
						new ItemStack(Material.DIRT), new ItemStack(Material.ROTTEN_FLESH),
						new ItemStack(Material.DIRT), new ItemStack(Material.DIRT),
						new ItemStack(Material.DIRT), new ItemStack(Material.DIRT));
				
				use(p, menu, new ItemStack(Material.WOODEN_SWORD), new ItemStack(Material.AIR),
						new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.AIR),
						new ItemStack(Material.AIR), new ItemStack(Material.OAK_PLANKS),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.STICK), new ItemStack(Material.AIR));
				
				use(p, menu, new ItemStack(Material.WOODEN_AXE), new ItemStack(Material.OAK_PLANKS),
						new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.AIR),
						new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.STICK),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.STICK), new ItemStack(Material.AIR));
				
				use(p, menu, new ItemStack(Material.STONE_SWORD), new ItemStack(Material.AIR),
						new ItemStack(Material.COBBLESTONE), new ItemStack(Material.AIR),
						new ItemStack(Material.AIR), new ItemStack(Material.COBBLESTONE),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.AIR));
				
				use(p, menu, new ItemStack(Material.STONE_AXE), new ItemStack(Material.COBBLESTONE),
						new ItemStack(Material.COBBLESTONE), new ItemStack(Material.AIR),
						new ItemStack(Material.COBBLESTONE), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.AIR));
				
				use(p, menu, new ItemStack(Material.STONE_PICKAXE), new ItemStack(Material.COBBLESTONE),
						new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE),
						new ItemStack(Material.AIR), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.AIR));

				use(p, menu, new ItemStack(Material.IRON_SWORD), new ItemStack(Material.AIR),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.AIR),
						new ItemStack(Material.AIR), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.BAMBOO), new ItemStack(Material.AIR));
				
				use(p, menu, new ItemStack(Material.IRON_AXE), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.AIR),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.BAMBOO),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.BAMBOO), new ItemStack(Material.AIR));
				
				use(p, menu, new ItemStack(Material.IRON_PICKAXE), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.AIR), new ItemStack(Material.BAMBOO),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.BAMBOO), new ItemStack(Material.AIR));

				use(p, menu, new ItemStack(Material.GOLDEN_SWORD), new ItemStack(Material.GOLD_INGOT),
						new ItemStack(Material.GOLDEN_CARROT), new ItemStack(Material.GOLD_INGOT),
						new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.GOLDEN_APPLE),
						new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.GOLD_INGOT),
						new ItemStack(Material.GOLDEN_HORSE_ARMOR), new ItemStack(Material.GOLD_INGOT));

				ItemStack pot = Mine.newItem(Material.POTION, null);
				PotionMeta meta = (PotionMeta) pot.getItemMeta();
				meta.addCustomEffect(new PotionEffect(PotionEffectType.LUCK, 30*20, 1), true);
				meta.setColor(Color.GREEN);
				pot.setItemMeta(meta);
				
				use(p, menu, new ItemStack(Material.GOLDEN_PICKAXE), new ItemStack(Material.GOLD_INGOT),
						new ItemStack(Material.GOLDEN_CARROT), new ItemStack(Material.GOLD_INGOT),
						new ItemStack(Material.GOLD_INGOT), pot,
						new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.GOLD_INGOT),
						new ItemStack(Material.GOLDEN_HORSE_ARMOR), new ItemStack(Material.GOLD_INGOT));

				use(p, menu, new ItemStack(Material.DIAMOND_SWORD), new ItemStack(Material.AIR),
						new ItemStack(Material.DIAMOND), new ItemStack(Material.AIR),
						new ItemStack(Material.AIR), new ItemStack(Material.DIAMOND),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.NETHER_STAR), new ItemStack(Material.AIR));
				
				use(p, menu, new ItemStack(Material.DIAMOND_PICKAXE), new ItemStack(Material.DIAMOND),
						new ItemStack(Material.ELYTRA), new ItemStack(Material.DIAMOND),
						new ItemStack(Material.AIR), new ItemStack(Material.STICK),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.STICK), new ItemStack(Material.AIR));

				use(p, menu, new ItemStack(Material.DIAMOND_AXE), new ItemStack(Material.DIAMOND),
						new ItemStack(Material.DIAMOND), new ItemStack(Material.AIR),
						new ItemStack(Material.DIAMOND), new ItemStack(Material.BAMBOO),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.BAMBOO), new ItemStack(Material.AIR));
				
				ItemStack pot2 = Mine.newItem(Material.POTION, null);
				PotionMeta meta2 = (PotionMeta) pot2.getItemMeta();
				meta2.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30*20, 1), true);
				pot2.setItemMeta(meta2);
				
				use(p, menu, new ItemStack(Material.NETHERITE_SWORD), pot2,
						new ItemStack(Material.NETHERITE_INGOT), pot2,
						pot2, new ItemStack(Material.NETHERITE_INGOT),
						pot2, pot2,
						new ItemStack(Material.DIAMOND), pot2);

				ItemStack pot3 = Mine.newItem(Material.POTION, null);
				PotionMeta meta3 = (PotionMeta) pot3.getItemMeta();
				meta3.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 30*20, 1), true);
				meta3.setColor(Color.GRAY);
				pot3.setItemMeta(meta3);
				
				use(p, menu, new ItemStack(Material.NETHERITE_PICKAXE), new ItemStack(Material.NETHERITE_INGOT),
						new ItemStack(Material.NETHERITE_INGOT), new ItemStack(Material.NETHERITE_INGOT),
						pot3, new ItemStack(Material.DIAMOND),
						pot3, pot3,
						new ItemStack(Material.DIAMOND), pot3);
				
				use(p, menu, new ItemStack(Material.IRON_HELMET), new ItemStack(Material.AIR),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.FLINT_AND_STEEL), new ItemStack(Material.IRON_INGOT));
				
				use(p, menu, new ItemStack(Material.IRON_CHESTPLATE), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.AIR), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.FLINT_AND_STEEL),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT));
				
				use(p, menu, new ItemStack(Material.IRON_LEGGINGS), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.FLINT_AND_STEEL), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.AIR),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.AIR), new ItemStack(Material.IRON_INGOT));
				
				use(p, menu, new ItemStack(Material.IRON_BOOTS), new ItemStack(Material.AIR),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.AIR),
						new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT),
						new ItemStack(Material.AIR), new ItemStack(Material.IRON_INGOT));
				
				use(p, menu, new ItemStack(Material.GOLDEN_HELMET), new ItemStack(Material.AIR),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.GOLD_INGOT),
						new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.GOLD_INGOT),
						new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.GOLD_INGOT));
				
				use(p, menu, new ItemStack(Material.GOLDEN_CHESTPLATE), new ItemStack(Material.GOLD_INGOT),
						new ItemStack(Material.AIR), new ItemStack(Material.GOLD_INGOT),
						new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.GOLDEN_APPLE),
						new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.GOLD_INGOT),
						new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.GOLD_INGOT));
				
				use(p, menu, new ItemStack(Material.GOLDEN_LEGGINGS), new ItemStack(Material.GOLD_INGOT),
						new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.GOLD_INGOT),
						new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.AIR),
						new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.GOLD_INGOT),
						new ItemStack(Material.AIR), new ItemStack(Material.GOLD_INGOT));
				
				use(p, menu, new ItemStack(Material.GOLDEN_BOOTS), new ItemStack(Material.AIR),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.AIR),
						new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.GOLD_INGOT),
						new ItemStack(Material.AIR), new ItemStack(Material.GOLD_INGOT));

				use(p, menu, new ItemStack(Material.DIAMOND_HELMET), new ItemStack(Material.AIR),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.DIAMOND), new ItemStack(Material.DIAMOND),
						new ItemStack(Material.DIAMOND), new ItemStack(Material.DIAMOND),
						new ItemStack(Material.TNT), new ItemStack(Material.DIAMOND));
				
				use(p, menu, new ItemStack(Material.DIAMOND_CHESTPLATE), new ItemStack(Material.DIAMOND),
						new ItemStack(Material.AIR), new ItemStack(Material.DIAMOND),
						new ItemStack(Material.DIAMOND), new ItemStack(Material.TNT),
						new ItemStack(Material.DIAMOND), new ItemStack(Material.DIAMOND),
						new ItemStack(Material.DIAMOND), new ItemStack(Material.DIAMOND));
				
				use(p, menu, new ItemStack(Material.DIAMOND_LEGGINGS), new ItemStack(Material.DIAMOND),
						new ItemStack(Material.TNT), new ItemStack(Material.DIAMOND),
						new ItemStack(Material.DIAMOND), new ItemStack(Material.AIR),
						new ItemStack(Material.DIAMOND), new ItemStack(Material.DIAMOND),
						new ItemStack(Material.AIR), new ItemStack(Material.DIAMOND));
				
				use(p, menu, new ItemStack(Material.DIAMOND_BOOTS), new ItemStack(Material.AIR),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.DIAMOND), new ItemStack(Material.AIR),
						new ItemStack(Material.DIAMOND), new ItemStack(Material.DIAMOND),
						new ItemStack(Material.AIR), new ItemStack(Material.DIAMOND));
				
				use(p, menu, new ItemStack(Material.NETHERITE_HELMET), new ItemStack(Material.AIR),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.NETHERITE_INGOT), new ItemStack(Material.NETHERITE_INGOT),
						new ItemStack(Material.NETHERITE_INGOT), new ItemStack(Material.NETHERITE_INGOT),
						new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.NETHERITE_INGOT));
				
				use(p, menu, new ItemStack(Material.NETHERITE_CHESTPLATE), new ItemStack(Material.NETHERITE_INGOT),
						new ItemStack(Material.AIR), new ItemStack(Material.NETHERITE_INGOT),
						new ItemStack(Material.NETHERITE_INGOT), new ItemStack(Material.ENDER_PEARL),
						new ItemStack(Material.NETHERITE_INGOT), new ItemStack(Material.NETHERITE_INGOT),
						new ItemStack(Material.NETHERITE_INGOT), new ItemStack(Material.NETHERITE_INGOT));
				
				use(p, menu, new ItemStack(Material.NETHERITE_LEGGINGS), new ItemStack(Material.NETHERITE_INGOT),
						new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.NETHERITE_INGOT),
						new ItemStack(Material.NETHERITE_INGOT), new ItemStack(Material.AIR),
						new ItemStack(Material.NETHERITE_INGOT), new ItemStack(Material.NETHERITE_INGOT),
						new ItemStack(Material.AIR), new ItemStack(Material.NETHERITE_INGOT));
				
				use(p, menu, new ItemStack(Material.NETHERITE_BOOTS), new ItemStack(Material.AIR),
						new ItemStack(Material.AIR), new ItemStack(Material.AIR),
						new ItemStack(Material.NETHERITE_INGOT), new ItemStack(Material.AIR),
						new ItemStack(Material.NETHERITE_INGOT), new ItemStack(Material.NETHERITE_INGOT),
						new ItemStack(Material.AIR), new ItemStack(Material.NETHERITE_INGOT));
				
			}
		}
	}
	
	public ItemStack addBookEnchantment(ItemStack item, Enchantment enchantment, int level){
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
        meta.addStoredEnchant(enchantment, level, true);
        item.setItemMeta(meta);
        return item;
    }

}
