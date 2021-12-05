package me.ninjay.geleiashop.eventos;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import me.ninjay.geleiashop.main.Main;
import me.ninjay.geleiashop.utils.Mine;

public class EventosGeral implements Listener{
	
	private static ItemStack dinheiro(Player p) {
		DecimalFormat df = new DecimalFormat("###,###,###");
		if(Main.config.get(p.getName()) != null) {
			ItemStack item = Mine.newItem(Material.BOWL, "§eSeu dinheiro: §f$"+df.format(Main.config.get(p.getName())).replace(",", "."));
			return item;
		}else {
			ItemStack item = Mine.newItem(Material.BOWL, "§eSeu dinheiro: §f$0");
			return item;
		}
	}
	private static ItemStack voltar = Mine.newItem(Material.ARROW, "§eVoltar página");
	private static ItemStack prox = Mine.newItem(Material.ARROW, "§ePróxima página");
	
	@EventHandler
	public void onConquista(PlayerAdvancementDoneEvent e) {
		Player p = e.getPlayer();
		
	if(!e.getAdvancement().getKey().getKey().contains("recipes")) {
		if(Main.config.get(p.getName()+"-adv") == null) {
			Main.config.set(p.getName()+"-adv", 1);
			Main.config.saveConfig();
			Bukkit.broadcastMessage(" \n§a"+p.getName()+" completou a conquista de número §a§l#"+Main.config.getInt(p.getName()+"-adv")+"§a!\nCom isso ele recebeu §a§l+5 §acoins!\n ");
			Main.config.set(p.getName(), Main.config.getInt(p.getName())+(Main.config.getInt(p.getName()+"-adv")*5));
			Main.config.saveConfig();
			p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
		}else {
			Main.config.set(p.getName()+"-adv", Main.config.getInt(p.getName()+"-adv")+1);
			Main.config.saveConfig();
			Bukkit.broadcastMessage(" \n§a"+p.getName()+" completou a conquista de número §a§l#"+Main.config.getInt(p.getName()+"-adv")+"§a!\nCom isso ele recebeu §a§l+"+(Main.config.getInt(p.getName()+"-adv")*5)+" §acoins!\n ");
			Main.config.set(p.getName(), Main.config.getInt(p.getName())+(Main.config.getInt(p.getName()+"-adv")*5));
			Main.config.saveConfig();
			p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
		}
	}
	}
	
	@EventHandler
	public void onUse(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(e.getClickedBlock() != null) {
			if(e.getClickedBlock().getType() == Material.OBSERVER) {
				if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					e.setCancelled(true);
					Inventory bloco = Mine.newInventory("Blocos", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.GRASS_BLOCK, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack b = Mine.newItem(Material.STONE, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack c = Mine.newItem(Material.COBBLESTONE, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack d = Mine.newItem(Material.POLISHED_GRANITE, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack ee = Mine.newItem(Material.POLISHED_ANDESITE, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack f = Mine.newItem(Material.OAK_LOG, null, 1, 0, " ", "  §fValor: §a$2");
					ItemStack g = Mine.newItem(Material.OBSIDIAN, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack h = Mine.newItem(Material.SMOOTH_QUARTZ, null, 1, 0, " ", "  §fValor: §a$3");
					ItemStack i = Mine.newItem(Material.GLASS, null, 1, 0, " ", "  §fValor: §a$2");
					ItemStack j = Mine.newItem(Material.BOOKSHELF, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack k = Mine.newItem(Material.MAGMA_BLOCK, null, 1, 0, " ", "  §fValor: §a$3");
					ItemStack l = Mine.newItem(Material.SEA_LANTERN, null, 1, 0, " ", "  §fValor: §a$3");
					ItemStack m = Mine.newItem(Material.BONE_BLOCK, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack n = Mine.newItem(Material.HAY_BLOCK, null, 1, 0, " ", "  §fValor: §a$3");
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					
					p.openInventory(bloco);
				}
			}
		}
	}
	
	@EventHandler
	public void buyEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getView().getTitle().equalsIgnoreCase("Blocos") || e.getView().getTitle().equalsIgnoreCase("Decoração") || e.getView().getTitle().equalsIgnoreCase("Redstone") || e.getView().getTitle().equalsIgnoreCase("Noob") || e.getView().getTitle().equalsIgnoreCase("Pro") || e.getView().getTitle().equalsIgnoreCase("Expert") || e.getView().getTitle().equalsIgnoreCase("Ferramentas") || e.getView().getTitle().equalsIgnoreCase("Potions") || e.getView().getTitle().equalsIgnoreCase("Comida") || e.getView().getTitle().equals("Encantamentos") || e.getView().getTitle().equalsIgnoreCase("Especial") || e.getView().getTitle().equals("EncantamentoS")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getItemMeta() != null) {
				if(e.getCurrentItem().getItemMeta().getLore() != null) {
				if(e.getCurrentItem().getItemMeta().getLore().get(1).contains("Valor")) {
					Integer valor = Mine.toInt(e.getCurrentItem().getItemMeta().getLore().get(1).replace("  §fValor: §a$", ""));
					if(Main.config.getInt(p.getName()) >= valor) {
						if(Mine.getEmptySlotsAmount(p.getInventory()) >= 9) {
						
						ItemStack b1 = Mine.newItem(Material.ENCHANTED_GOLDEN_APPLE, null);
						ItemStack b2 = Mine.newItem(Material.DIAMOND, null, 3);
						ItemStack b3 = Mine.newItem(Material.EMERALD, null, 3);
						ItemStack b4 = Mine.newItem(Material.NETHERITE_INGOT, null, 3);
						ItemStack b5 = Mine.newItem(Material.DIAMOND_PICKAXE, null);
						Mine.addEnchant(b5, Enchantment.LOOT_BONUS_BLOCKS, 3);
						ItemStack b6 = Mine.newItem(Material.DIAMOND_AXE, null);
						Mine.addEnchant(b6, Enchantment.DAMAGE_ALL, 5);
						ItemStack b7 = Mine.newItem(Material.BOW, null);
						Mine.addEnchant(b7, Enchantment.ARROW_INFINITE, 1);
						Mine.addEnchant(b7, Enchantment.ARROW_KNOCKBACK, 1);
						ItemStack b8 = Mine.newItem(Material.TOTEM_OF_UNDYING, null);
						ItemStack b9 = Mine.newHead("§eCabeça de GeleiaPlays", "GeleiaPlays", 1);
						ItemStack b10 = Mine.newHead("§eCabeça de Dream", "Dream", 1);
						ItemStack b11 = Mine.newItem(Material.BARRIER, null);
						
						ArrayList<ItemStack> especiais = new ArrayList<>();
						especiais.clear();
						especiais.add(b1);
						especiais.add(b2);
						especiais.add(b3);
						especiais.add(b4);
						especiais.add(b5);
						especiais.add(b6);
						especiais.add(b7);
						especiais.add(b8);
						especiais.add(b9);
						especiais.add(b10);
						especiais.add(b11);	
						
						Main.config.set(p.getName(), Main.config.getInt(p.getName())-valor);
						Main.config.saveConfig();
						p.sendMessage("§aVocê comprou "+e.getCurrentItem().getAmount()+"x "+e.getCurrentItem().getType().toString().replace("_", " ")+" (-$"+valor+")");
						p.getInventory().addItem(e.getCurrentItem());
						
						if(Mine.getChance(0.10)) {
							p.sendMessage(" \n§aCom essa compra você recebeu um item bonus!\n ");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							p.getInventory().addItem(Mine.getRandomItem(especiais));
						}
						
						}else {
							p.getOpenInventory().close();
							p.sendMessage("§cEsvazie seu inventário para comprar.");
						}
					}else {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê não possui dinheiro suficiente!");
					}
				}
			}
			}
			}
		}
	}
	
	public void customRecipe() {
		ItemStack craft = Mine.newItem(Material.OBSERVER, "§6Mesa de trabalho dourada");
		ShapedRecipe craftr = new ShapedRecipe(craft);
		
		craftr.shape("!!!", "!@!", "!!!");
		
		craftr.setIngredient('!', Material.GOLD_INGOT);
		craftr.setIngredient('@', Material.CRAFTING_TABLE);
		
		Main.getPlugin(Main.class).getServer().addRecipe(craftr);
	}

	@EventHandler
	public void paginas(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getView().getTitle().equalsIgnoreCase("Blocos")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().isSimilar(prox)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Decoração", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.OAK_SAPLING, null, 1, 0, " ", "  §fValor: §a$8");
					ItemStack b = Mine.newItem(Material.BIRCH_LEAVES, null, 1, 0, " ", "  §fValor: §a$2");
					ItemStack c = Mine.newItem(Material.POPPY, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack d = Mine.newItem(Material.RED_MUSHROOM, null, 1, 0, " ", "  §fValor: §a$3");
					ItemStack ee = Mine.newItem(Material.BROWN_MUSHROOM, null, 1, 0, " ", "  §fValor: §a$3");
					ItemStack f = Mine.newItem(Material.WEEPING_VINES, null, 1, 0, " ", "  §fValor: §a$3");
					ItemStack g = Mine.newItem(Material.KELP, null, 1, 0, " ", "  §fValor: §a$4");
					ItemStack h = Mine.newItem(Material.SUGAR_CANE, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack i = Mine.newItem(Material.VINE, null, 1, 0, " ", "  §fValor: §a$3");
					ItemStack j = Mine.newItem(Material.LILAC, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack k = Mine.newItem(Material.SUNFLOWER, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack l = Mine.newItem(Material.PEONY, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack m = Mine.newItem(Material.ROSE_BUSH, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack n = Mine.newItem(Material.CACTUS, null, 1, 0, " ", "  §fValor: §a$3");
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
			}
		}
		if(e.getView().getTitle().equalsIgnoreCase("Decoração")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().isSimilar(voltar)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Blocos", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.GRASS_BLOCK, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack b = Mine.newItem(Material.STONE, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack c = Mine.newItem(Material.COBBLESTONE, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack d = Mine.newItem(Material.POLISHED_GRANITE, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack ee = Mine.newItem(Material.POLISHED_ANDESITE, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack f = Mine.newItem(Material.OAK_LOG, null, 1, 0, " ", "  §fValor: §a$2");
					ItemStack g = Mine.newItem(Material.OBSIDIAN, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack h = Mine.newItem(Material.SMOOTH_QUARTZ, null, 1, 0, " ", "  §fValor: §a$3");
					ItemStack i = Mine.newItem(Material.GLASS, null, 1, 0, " ", "  §fValor: §a$2");
					ItemStack j = Mine.newItem(Material.BOOKSHELF, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack k = Mine.newItem(Material.MAGMA_BLOCK, null, 1, 0, " ", "  §fValor: §a$3");
					ItemStack l = Mine.newItem(Material.SEA_LANTERN, null, 1, 0, " ", "  §fValor: §a$3");
					ItemStack m = Mine.newItem(Material.BONE_BLOCK, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack n = Mine.newItem(Material.HAY_BLOCK, null, 1, 0, " ", "  §fValor: §a$3");
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					
					p.openInventory(bloco);
				}
				if(e.getCurrentItem().isSimilar(prox)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Redstone", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.DISPENSER, null, 1, 0, " ", "  §fValor: §a$6");
					ItemStack b = Mine.newItem(Material.TNT, null, 1, 0, " ", "  §fValor: §a$10");
					ItemStack c = Mine.newItem(Material.REDSTONE_TORCH, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack d = Mine.newItem(Material.STICKY_PISTON, null, 1, 0, " ", "  §fValor: §a$10");
					ItemStack ee = Mine.newItem(Material.PISTON, null, 1, 0, " ", "  §fValor: §a$8");
					ItemStack f = Mine.newItem(Material.REDSTONE_LAMP, null, 1, 0, " ", "  §fValor: §a$8");
					ItemStack g = Mine.newItem(Material.HOPPER, null, 1, 0, " ", "  §fValor: §a$15");
					ItemStack h = Mine.newItem(Material.REDSTONE, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack i = Mine.newItem(Material.REPEATER, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack j = Mine.newItem(Material.COMPARATOR, null, 1, 0, " ", "  §fValor: §a$8");
					ItemStack k = Mine.newItem(Material.TARGET, null, 1, 0, " ", "  §fValor: §a$20");
					ItemStack l = Mine.newItem(Material.OAK_PRESSURE_PLATE, null, 1, 0, " ", "  §fValor: §a$2");
					ItemStack m = Mine.newItem(Material.STONE_PRESSURE_PLATE, null, 1, 0, " ", "  §fValor: §a$2");
					ItemStack n = Mine.newItem(Material.DAYLIGHT_DETECTOR, null, 1, 0, " ", "  §fValor: §a$8");
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
			}
		}
		if(e.getView().getTitle().equalsIgnoreCase("Redstone")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().isSimilar(voltar)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Decoração", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.OAK_SAPLING, null, 1, 0, " ", "  §fValor: §a$8");
					ItemStack b = Mine.newItem(Material.BIRCH_LEAVES, null, 1, 0, " ", "  §fValor: §a$2");
					ItemStack c = Mine.newItem(Material.POPPY, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack d = Mine.newItem(Material.RED_MUSHROOM, null, 1, 0, " ", "  §fValor: §a$3");
					ItemStack ee = Mine.newItem(Material.BROWN_MUSHROOM, null, 1, 0, " ", "  §fValor: §a$3");
					ItemStack f = Mine.newItem(Material.WEEPING_VINES, null, 1, 0, " ", "  §fValor: §a$3");
					ItemStack g = Mine.newItem(Material.KELP, null, 1, 0, " ", "  §fValor: §a$4");
					ItemStack h = Mine.newItem(Material.SUGAR_CANE, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack i = Mine.newItem(Material.VINE, null, 1, 0, " ", "  §fValor: §a$3");
					ItemStack j = Mine.newItem(Material.LILAC, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack k = Mine.newItem(Material.SUNFLOWER, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack l = Mine.newItem(Material.PEONY, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack m = Mine.newItem(Material.ROSE_BUSH, null, 1, 0, " ", "  §fValor: §a$1");
					ItemStack n = Mine.newItem(Material.CACTUS, null, 1, 0, " ", "  §fValor: §a$3");
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
				if(e.getCurrentItem().isSimilar(prox)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Noob", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.LEATHER_HELMET, null, 1, 0, " ", "  §fValor: §a$15");
					ItemStack b = Mine.newItem(Material.LEATHER_CHESTPLATE, null, 1, 0, " ", "  §fValor: §a$24");
					ItemStack c = Mine.newItem(Material.LEATHER_LEGGINGS, null, 1, 0, " ", "  §fValor: §a$21");
					ItemStack d = Mine.newItem(Material.LEATHER_BOOTS, null, 1, 0, " ", "  §fValor: §a$12");
					ItemStack ee = Mine.newItem(Material.WOODEN_SWORD, null, 1, 0, " ", "  §fValor: §a$4");
					ItemStack f = Mine.newItem(Material.BOW, null, 1, 0, " ", "  §fValor: §a$10");
					ItemStack g = Mine.newItem(Material.SHIELD, null, 1, 0, " ", "  §fValor: §a$12");
					ItemStack h = Mine.newItem(Material.IRON_HELMET, null, 1, 0, " ", "  §fValor: §a$25");
					ItemStack i = Mine.newItem(Material.IRON_CHESTPLATE, null, 1, 0, " ", "  §fValor: §a$40");
					ItemStack j = Mine.newItem(Material.IRON_LEGGINGS, null, 1, 0, " ", "  §fValor: §a$35");
					ItemStack k = Mine.newItem(Material.IRON_BOOTS, null, 1, 0, " ", "  §fValor: §a$20");
					ItemStack l = Mine.newItem(Material.IRON_SWORD, null, 1, 0, " ", "  §fValor: §a$12");
					ItemStack m = Mine.newItem(Material.ARROW, null, 32, 0, " ", "  §fValor: §a$64");
					ItemStack n = Mine.newItem(Material.TORCH, null, 32, 0, " ", "  §fValor: §a$70");
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
			}
		}
		if(e.getView().getTitle().equalsIgnoreCase("Noob")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().isSimilar(voltar)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Redstone", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.DISPENSER, null, 1, 0, " ", "  §fValor: §a$6");
					ItemStack b = Mine.newItem(Material.TNT, null, 1, 0, " ", "  §fValor: §a$10");
					ItemStack c = Mine.newItem(Material.REDSTONE_TORCH, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack d = Mine.newItem(Material.STICKY_PISTON, null, 1, 0, " ", "  §fValor: §a$10");
					ItemStack ee = Mine.newItem(Material.PISTON, null, 1, 0, " ", "  §fValor: §a$8");
					ItemStack f = Mine.newItem(Material.REDSTONE_LAMP, null, 1, 0, " ", "  §fValor: §a$8");
					ItemStack g = Mine.newItem(Material.HOPPER, null, 1, 0, " ", "  §fValor: §a$15");
					ItemStack h = Mine.newItem(Material.REDSTONE, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack i = Mine.newItem(Material.REPEATER, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack j = Mine.newItem(Material.COMPARATOR, null, 1, 0, " ", "  §fValor: §a$8");
					ItemStack k = Mine.newItem(Material.TARGET, null, 1, 0, " ", "  §fValor: §a$20");
					ItemStack l = Mine.newItem(Material.OAK_PRESSURE_PLATE, null, 1, 0, " ", "  §fValor: §a$2");
					ItemStack m = Mine.newItem(Material.STONE_PRESSURE_PLATE, null, 1, 0, " ", "  §fValor: §a$2");
					ItemStack n = Mine.newItem(Material.DAYLIGHT_DETECTOR, null, 1, 0, " ", "  §fValor: §a$8");
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
				if(e.getCurrentItem().isSimilar(prox)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Pro", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.GOLDEN_HELMET, null, 1, 0, " ", "  §fValor: §a$40");
					ItemStack b = Mine.newItem(Material.GOLDEN_CHESTPLATE, null, 1, 0, " ", "  §fValor: §a$64");
					ItemStack c = Mine.newItem(Material.GOLDEN_LEGGINGS, null, 1, 0, " ", "  §fValor: §a$56");
					ItemStack d = Mine.newItem(Material.GOLDEN_BOOTS, null, 1, 0, " ", "  §fValor: §a$32");
					ItemStack ee = Mine.newItem(Material.GOLDEN_SWORD, null, 1, 0, " ", "  §fValor: §a$18");
					ItemStack f = Mine.newItem(Material.COMPASS, null, 1, 0, " ", "  §fValor: §a$22");
					ItemStack g = Mine.newItem(Material.FLINT_AND_STEEL, null, 1, 0, " ", "  §fValor: §a$6");
					ItemStack h = Mine.newItem(Material.DIAMOND_HELMET, null, 1, 0, " ", "  §fValor: §a$50");
					ItemStack i = Mine.newItem(Material.DIAMOND_CHESTPLATE, null, 1, 0, " ", "  §fValor: §a$80");
					ItemStack j = Mine.newItem(Material.DIAMOND_LEGGINGS, null, 1, 0, " ", "  §fValor: §a$70");
					ItemStack k = Mine.newItem(Material.DIAMOND_BOOTS, null, 1, 0, " ", "  §fValor: §a$40");
					ItemStack l = Mine.newItem(Material.DIAMOND_SWORD, null, 1, 0, " ", "  §fValor: §a$22");
					ItemStack m = Mine.newItem(Material.TRIDENT, null, 1, 0, " ", "  §fValor: §a$30");
					ItemStack n = Mine.newItem(Material.FISHING_ROD, null, 1, 0, " ", "  §fValor: §a$12");
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
			}
		}
		if(e.getView().getTitle().equalsIgnoreCase("Pro")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().isSimilar(voltar)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Noob", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.LEATHER_HELMET, null, 1, 0, " ", "  §fValor: §a$15");
					ItemStack b = Mine.newItem(Material.LEATHER_CHESTPLATE, null, 1, 0, " ", "  §fValor: §a$24");
					ItemStack c = Mine.newItem(Material.LEATHER_LEGGINGS, null, 1, 0, " ", "  §fValor: §a$21");
					ItemStack d = Mine.newItem(Material.LEATHER_BOOTS, null, 1, 0, " ", "  §fValor: §a$12");
					ItemStack ee = Mine.newItem(Material.WOODEN_SWORD, null, 1, 0, " ", "  §fValor: §a$4");
					ItemStack f = Mine.newItem(Material.BOW, null, 1, 0, " ", "  §fValor: §a$10");
					ItemStack g = Mine.newItem(Material.SHIELD, null, 1, 0, " ", "  §fValor: §a$12");
					ItemStack h = Mine.newItem(Material.IRON_HELMET, null, 1, 0, " ", "  §fValor: §a$25");
					ItemStack i = Mine.newItem(Material.IRON_CHESTPLATE, null, 1, 0, " ", "  §fValor: §a$40");
					ItemStack j = Mine.newItem(Material.IRON_LEGGINGS, null, 1, 0, " ", "  §fValor: §a$35");
					ItemStack k = Mine.newItem(Material.IRON_BOOTS, null, 1, 0, " ", "  §fValor: §a$20");
					ItemStack l = Mine.newItem(Material.IRON_SWORD, null, 1, 0, " ", "  §fValor: §a$12");
					ItemStack m = Mine.newItem(Material.ARROW, null, 32, 0, " ", "  §fValor: §a$64");
					ItemStack n = Mine.newItem(Material.TORCH, null, 32, 0, " ", "  §fValor: §a$70");
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
				if(e.getCurrentItem().isSimilar(prox)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Expert", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.NETHERITE_HELMET, null, 1, 0, " ", "  §fValor: §a$60");
					ItemStack b = Mine.newItem(Material.NETHERITE_CHESTPLATE, null, 1, 0, " ", "  §fValor: §a$90");
					ItemStack c = Mine.newItem(Material.NETHERITE_LEGGINGS, null, 1, 0, " ", "  §fValor: §a$80");
					ItemStack d = Mine.newItem(Material.NETHERITE_BOOTS, null, 1, 0, " ", "  §fValor: §a$50");
					ItemStack ee = Mine.newItem(Material.NETHER_STAR, null, 1, 0, " ", "  §fValor: §a$80");
					ItemStack f = Mine.newItem(Material.ELYTRA, null, 1, 0, " ", "  §fValor: §a$300");
					ItemStack g = Mine.newItem(Material.TOTEM_OF_UNDYING, null, 1, 0, " ", "  §fValor: §a$500");
					ItemStack h = Mine.newItem(Material.NETHERITE_SWORD, null, 1, 0, " ", "  §fValor: §a$32");
					ItemStack i = Mine.newItem(Material.NETHERITE_SHOVEL, null, 1, 0, " ", "  §fValor: §a$18");
					ItemStack j = Mine.newItem(Material.NETHERITE_PICKAXE, null, 1, 0, " ", "  §fValor: §a$48");
					ItemStack k = Mine.newItem(Material.NETHERITE_AXE, null, 1, 0, " ", "  §fValor: §a$52");
					ItemStack l = Mine.newItem(Material.NETHERITE_HOE, null, 1, 0, " ", "  §fValor: §a$30");
					ItemStack m = Mine.newItem(Material.ENCHANTED_GOLDEN_APPLE, null, 1, 0, " ", "  §fValor: §a$350");
					ItemStack n = Mine.newItem(Material.CROSSBOW, null, 1, 0, " ", "  §fValor: §a$30");
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
			}
		}
		if(e.getView().getTitle().equalsIgnoreCase("Expert")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().isSimilar(voltar)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Pro", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.GOLDEN_HELMET, null, 1, 0, " ", "  §fValor: §a$40");
					ItemStack b = Mine.newItem(Material.GOLDEN_CHESTPLATE, null, 1, 0, " ", "  §fValor: §a$64");
					ItemStack c = Mine.newItem(Material.GOLDEN_LEGGINGS, null, 1, 0, " ", "  §fValor: §a$56");
					ItemStack d = Mine.newItem(Material.GOLDEN_BOOTS, null, 1, 0, " ", "  §fValor: §a$32");
					ItemStack ee = Mine.newItem(Material.GOLDEN_SWORD, null, 1, 0, " ", "  §fValor: §a$18");
					ItemStack f = Mine.newItem(Material.COMPASS, null, 1, 0, " ", "  §fValor: §a$22");
					ItemStack g = Mine.newItem(Material.FLINT_AND_STEEL, null, 1, 0, " ", "  §fValor: §a$6");
					ItemStack h = Mine.newItem(Material.DIAMOND_HELMET, null, 1, 0, " ", "  §fValor: §a$50");
					ItemStack i = Mine.newItem(Material.DIAMOND_CHESTPLATE, null, 1, 0, " ", "  §fValor: §a$80");
					ItemStack j = Mine.newItem(Material.DIAMOND_LEGGINGS, null, 1, 0, " ", "  §fValor: §a$70");
					ItemStack k = Mine.newItem(Material.DIAMOND_BOOTS, null, 1, 0, " ", "  §fValor: §a$40");
					ItemStack l = Mine.newItem(Material.DIAMOND_SWORD, null, 1, 0, " ", "  §fValor: §a$22");
					ItemStack m = Mine.newItem(Material.TRIDENT, null, 1, 0, " ", "  §fValor: §a$30");
					ItemStack n = Mine.newItem(Material.FISHING_ROD, null, 1, 0, " ", "  §fValor: §a$12");
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
				if(e.getCurrentItem().isSimilar(prox)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Ferramentas", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.WOODEN_PICKAXE, null, 1, 0, " ", "  §fValor: §a$4");
					ItemStack b = Mine.newItem(Material.STONE_PICKAXE, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack c = Mine.newItem(Material.IRON_PICKAXE, null, 1, 0, " ", "  §fValor: §a$18");
					ItemStack d = Mine.newItem(Material.GOLDEN_PICKAXE, null, 1, 0, " ", "  §fValor: §a$26");
					ItemStack ee = Mine.newItem(Material.DIAMOND_PICKAXE, null, 1, 0, " ", "  §fValor: §a$32");
					ItemStack h = Mine.newItem(Material.WOODEN_AXE, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack i = Mine.newItem(Material.STONE_AXE, null, 1, 0, " ", "  §fValor: §a$6");
					ItemStack j = Mine.newItem(Material.IRON_AXE, null, 1, 0, " ", "  §fValor: §a$20");
					ItemStack k = Mine.newItem(Material.GOLDEN_AXE, null, 1, 0, " ", "  §fValor: §a$28");
					ItemStack l = Mine.newItem(Material.DIAMOND_AXE, null, 1, 0, " ", "  §fValor: §a$35");
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
			}
		}
		if(e.getView().getTitle().equalsIgnoreCase("Ferramentas")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().isSimilar(voltar)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Expert", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.NETHERITE_HELMET, null, 1, 0, " ", "  §fValor: §a$60");
					ItemStack b = Mine.newItem(Material.NETHERITE_CHESTPLATE, null, 1, 0, " ", "  §fValor: §a$90");
					ItemStack c = Mine.newItem(Material.NETHERITE_LEGGINGS, null, 1, 0, " ", "  §fValor: §a$80");
					ItemStack d = Mine.newItem(Material.NETHERITE_BOOTS, null, 1, 0, " ", "  §fValor: §a$50");
					ItemStack ee = Mine.newItem(Material.NETHER_STAR, null, 1, 0, " ", "  §fValor: §a$80");
					ItemStack f = Mine.newItem(Material.ELYTRA, null, 1, 0, " ", "  §fValor: §a$300");
					ItemStack g = Mine.newItem(Material.TOTEM_OF_UNDYING, null, 1, 0, " ", "  §fValor: §a$500");
					ItemStack h = Mine.newItem(Material.NETHERITE_SWORD, null, 1, 0, " ", "  §fValor: §a$32");
					ItemStack i = Mine.newItem(Material.NETHERITE_SHOVEL, null, 1, 0, " ", "  §fValor: §a$18");
					ItemStack j = Mine.newItem(Material.NETHERITE_PICKAXE, null, 1, 0, " ", "  §fValor: §a$48");
					ItemStack k = Mine.newItem(Material.NETHERITE_AXE, null, 1, 0, " ", "  §fValor: §a$52");
					ItemStack l = Mine.newItem(Material.NETHERITE_HOE, null, 1, 0, " ", "  §fValor: §a$30");
					ItemStack m = Mine.newItem(Material.ENCHANTED_GOLDEN_APPLE, null, 1, 0, " ", "  §fValor: §a$350");
					ItemStack n = Mine.newItem(Material.CROSSBOW, null, 1, 0, " ", "  §fValor: §a$30");
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
				if(e.getCurrentItem().isSimilar(prox)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Potions", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$15");
					PotionMeta am = (PotionMeta) a.getItemMeta();
					am.setBasePotionData(new PotionData(PotionType.INVISIBILITY, false, false));
					a.setItemMeta(am);
					ItemStack b = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$20");
					PotionMeta bm = (PotionMeta) b.getItemMeta();
					bm.setBasePotionData(new PotionData(PotionType.INVISIBILITY, true, false));
					b.setItemMeta(bm);
					ItemStack c = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$20");
					PotionMeta cm = (PotionMeta) c.getItemMeta();
					cm.setBasePotionData(new PotionData(PotionType.JUMP, false, false));
					c.setItemMeta(cm);
					ItemStack d = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$25");
					PotionMeta dm = (PotionMeta) d.getItemMeta();
					dm.setBasePotionData(new PotionData(PotionType.JUMP, false, true));
					d.setItemMeta(dm);
					ItemStack ee = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$20");
					PotionMeta em = (PotionMeta) ee.getItemMeta();
					em.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE, false, false));
					ee.setItemMeta(em);
					ItemStack f = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$25");
					PotionMeta fm = (PotionMeta) f.getItemMeta();
					fm.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE, true, false));
					f.setItemMeta(fm);
					ItemStack g = Mine.newItem(Material.DRAGON_BREATH, null, 1, 0, " ", "  §fValor: §a$50");
					ItemStack h = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$20");
					PotionMeta hm = (PotionMeta) h.getItemMeta();
					hm.setBasePotionData(new PotionData(PotionType.REGEN, false, false));
					h.setItemMeta(hm);
					ItemStack i = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$25");
					PotionMeta im = (PotionMeta) i.getItemMeta();
					im.setBasePotionData(new PotionData(PotionType.REGEN, false, true));
					i.setItemMeta(im);
					ItemStack j = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$20");
					PotionMeta jm = (PotionMeta) j.getItemMeta();
					jm.setBasePotionData(new PotionData(PotionType.SPEED, false, false));
					j.setItemMeta(jm);
					ItemStack k = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$25");
					PotionMeta km = (PotionMeta) k.getItemMeta();
					km.setBasePotionData(new PotionData(PotionType.SPEED, false, true));
					k.setItemMeta(km);
					ItemStack l = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$25");
					PotionMeta lm = (PotionMeta) l.getItemMeta();
					lm.setBasePotionData(new PotionData(PotionType.STRENGTH, false, false));
					l.setItemMeta(lm);
					ItemStack m = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$30");
					PotionMeta mm = (PotionMeta) m.getItemMeta();
					mm.setBasePotionData(new PotionData(PotionType.STRENGTH, false, true));
					m.setItemMeta(mm);
					ItemStack n = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$25");
					PotionMeta nm = (PotionMeta) n.getItemMeta();
					nm.setBasePotionData(new PotionData(PotionType.LUCK, false, false));
					n.setItemMeta(nm);
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
			}
		}
		if(e.getView().getTitle().equalsIgnoreCase("Potions")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().isSimilar(voltar)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Ferramentas", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.WOODEN_PICKAXE, null, 1, 0, " ", "  §fValor: §a$4");
					ItemStack b = Mine.newItem(Material.STONE_PICKAXE, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack c = Mine.newItem(Material.IRON_PICKAXE, null, 1, 0, " ", "  §fValor: §a$18");
					ItemStack d = Mine.newItem(Material.GOLDEN_PICKAXE, null, 1, 0, " ", "  §fValor: §a$26");
					ItemStack ee = Mine.newItem(Material.DIAMOND_PICKAXE, null, 1, 0, " ", "  §fValor: §a$32");
					ItemStack h = Mine.newItem(Material.WOODEN_AXE, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack i = Mine.newItem(Material.STONE_AXE, null, 1, 0, " ", "  §fValor: §a$6");
					ItemStack j = Mine.newItem(Material.IRON_AXE, null, 1, 0, " ", "  §fValor: §a$20");
					ItemStack k = Mine.newItem(Material.GOLDEN_AXE, null, 1, 0, " ", "  §fValor: §a$28");
					ItemStack l = Mine.newItem(Material.DIAMOND_AXE, null, 1, 0, " ", "  §fValor: §a$35");
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
				if(e.getCurrentItem().isSimilar(prox)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Comida", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.SWEET_BERRIES, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack b = Mine.newItem(Material.BREAD, null, 1, 0, " ", "  §fValor: §a$15");
					ItemStack c = Mine.newItem(Material.CARROT, null, 1, 0, " ", "  §fValor: §a$10");
					ItemStack d = Mine.newItem(Material.BAKED_POTATO, null, 1, 0, " ", "  §fValor: §a$20");
					ItemStack ee = Mine.newItem(Material.TROPICAL_FISH, null, 1, 0, " ", "  §fValor: §a$10");
					ItemStack f = Mine.newItem(Material.COOKED_MUTTON, null, 1, 0, " ", "  §fValor: §a$25");
					ItemStack g = Mine.newItem(Material.COOKED_RABBIT, null, 1, 0, " ", "  §fValor: §a$25");
					ItemStack h = Mine.newItem(Material.COOKED_PORKCHOP, null, 1, 0, " ", "  §fValor: §a$25");
					ItemStack i = Mine.newItem(Material.COOKED_BEEF, null, 1, 0, " ", "  §fValor: §a$25");
					ItemStack j = Mine.newItem(Material.MELON_SLICE, null, 1, 0, " ", "  §fValor: §a$15");
					ItemStack k = Mine.newItem(Material.COOKIE, null, 1, 0, " ", "  §fValor: §a$10");
					ItemStack l = Mine.newItem(Material.GOLDEN_APPLE, null, 1, 0, " ", "  §fValor: §a$30");
					ItemStack m = Mine.newItem(Material.PUMPKIN_PIE, null, 1, 0, " ", "  §fValor: §a$15");
					ItemStack n = Mine.newItem(Material.CAKE, null, 1, 0, " ", "  §fValor: §a$20");
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
			}
		}
		if(e.getView().getTitle().equalsIgnoreCase("Comida")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().isSimilar(voltar)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Potions", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$15");
					PotionMeta am = (PotionMeta) a.getItemMeta();
					am.setBasePotionData(new PotionData(PotionType.INVISIBILITY, false, false));
					a.setItemMeta(am);
					ItemStack b = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$20");
					PotionMeta bm = (PotionMeta) b.getItemMeta();
					bm.setBasePotionData(new PotionData(PotionType.INVISIBILITY, true, false));
					b.setItemMeta(bm);
					ItemStack c = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$20");
					PotionMeta cm = (PotionMeta) c.getItemMeta();
					cm.setBasePotionData(new PotionData(PotionType.JUMP, false, false));
					c.setItemMeta(cm);
					ItemStack d = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$25");
					PotionMeta dm = (PotionMeta) d.getItemMeta();
					dm.setBasePotionData(new PotionData(PotionType.JUMP, false, true));
					d.setItemMeta(dm);
					ItemStack ee = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$20");
					PotionMeta em = (PotionMeta) ee.getItemMeta();
					em.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE, false, false));
					ee.setItemMeta(em);
					ItemStack f = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$25");
					PotionMeta fm = (PotionMeta) f.getItemMeta();
					fm.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE, true, false));
					f.setItemMeta(fm);
					ItemStack g = Mine.newItem(Material.DRAGON_BREATH, null, 1, 0, " ", "  §fValor: §a$50");
					ItemStack h = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$20");
					PotionMeta hm = (PotionMeta) h.getItemMeta();
					hm.setBasePotionData(new PotionData(PotionType.REGEN, false, false));
					h.setItemMeta(hm);
					ItemStack i = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$25");
					PotionMeta im = (PotionMeta) i.getItemMeta();
					im.setBasePotionData(new PotionData(PotionType.REGEN, false, true));
					i.setItemMeta(im);
					ItemStack j = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$20");
					PotionMeta jm = (PotionMeta) j.getItemMeta();
					jm.setBasePotionData(new PotionData(PotionType.SPEED, false, false));
					j.setItemMeta(jm);
					ItemStack k = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$25");
					PotionMeta km = (PotionMeta) k.getItemMeta();
					km.setBasePotionData(new PotionData(PotionType.SPEED, false, true));
					k.setItemMeta(km);
					ItemStack l = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$25");
					PotionMeta lm = (PotionMeta) l.getItemMeta();
					lm.setBasePotionData(new PotionData(PotionType.STRENGTH, false, false));
					l.setItemMeta(lm);
					ItemStack m = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$30");
					PotionMeta mm = (PotionMeta) m.getItemMeta();
					mm.setBasePotionData(new PotionData(PotionType.STRENGTH, false, true));
					m.setItemMeta(mm);
					ItemStack n = Mine.newItem(Material.POTION, null, 1, 0, " ", "  §fValor: §a$25");
					PotionMeta nm = (PotionMeta) n.getItemMeta();
					nm.setBasePotionData(new PotionData(PotionType.LUCK, false, false));
					n.setItemMeta(nm);
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
				if(e.getCurrentItem().isSimilar(prox)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Encantamentos", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.ENCHANTING_TABLE, null, 1, 0, " ", "  §fValor: §a$50");
					ItemStack b = Mine.newItem(Material.BOOKSHELF, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack c = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$40");
					EnchantmentStorageMeta cm = (EnchantmentStorageMeta) c.getItemMeta();
					cm.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, false);
					c.setItemMeta(cm);
					ItemStack d = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta dm = (EnchantmentStorageMeta) d.getItemMeta();
					dm.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 2, false);
					d.setItemMeta(dm);
					ItemStack ee = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$60");
					EnchantmentStorageMeta em = (EnchantmentStorageMeta) ee.getItemMeta();
					em.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, false);
					ee.setItemMeta(em);
					ItemStack f = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$40");
					EnchantmentStorageMeta fm = (EnchantmentStorageMeta) f.getItemMeta();
					fm.addEnchant(Enchantment.DIG_SPEED, 1, false);
					f.setItemMeta(fm);
					ItemStack g = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta gm = (EnchantmentStorageMeta) g.getItemMeta();
					gm.addEnchant(Enchantment.DIG_SPEED, 3, false);
					g.setItemMeta(gm);
					ItemStack h = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$60");
					EnchantmentStorageMeta hm = (EnchantmentStorageMeta) h.getItemMeta();
					hm.addEnchant(Enchantment.DIG_SPEED, 5, false);
					h.setItemMeta(hm);
					ItemStack i = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$40");
					EnchantmentStorageMeta im = (EnchantmentStorageMeta) i.getItemMeta();
					im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
					i.setItemMeta(im);
					ItemStack j = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta jm = (EnchantmentStorageMeta) j.getItemMeta();
					jm.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false);
					j.setItemMeta(jm);
					ItemStack k = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$40");
					EnchantmentStorageMeta km = (EnchantmentStorageMeta) k.getItemMeta();
					km.addEnchant(Enchantment.PROTECTION_FALL, 1, false);
					k.setItemMeta(km);
					ItemStack l = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta lm = (EnchantmentStorageMeta) l.getItemMeta();
					lm.addEnchant(Enchantment.PROTECTION_FALL, 3, false);
					l.setItemMeta(lm);
					ItemStack m = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$40");
					EnchantmentStorageMeta mm = (EnchantmentStorageMeta) m.getItemMeta();
					mm.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
					m.setItemMeta(mm);
					ItemStack n = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta nm = (EnchantmentStorageMeta) n.getItemMeta();
					nm.addEnchant(Enchantment.DAMAGE_ALL, 3, false);
					n.setItemMeta(nm);
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
			}
		}
		if(e.getView().getTitle().equals("Encantamentos")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().isSimilar(voltar)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Comida", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.SWEET_BERRIES, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack b = Mine.newItem(Material.BREAD, null, 1, 0, " ", "  §fValor: §a$15");
					ItemStack c = Mine.newItem(Material.CARROT, null, 1, 0, " ", "  §fValor: §a$10");
					ItemStack d = Mine.newItem(Material.BAKED_POTATO, null, 1, 0, " ", "  §fValor: §a$20");
					ItemStack ee = Mine.newItem(Material.TROPICAL_FISH, null, 1, 0, " ", "  §fValor: §a$10");
					ItemStack f = Mine.newItem(Material.COOKED_MUTTON, null, 1, 0, " ", "  §fValor: §a$25");
					ItemStack g = Mine.newItem(Material.COOKED_RABBIT, null, 1, 0, " ", "  §fValor: §a$25");
					ItemStack h = Mine.newItem(Material.COOKED_PORKCHOP, null, 1, 0, " ", "  §fValor: §a$25");
					ItemStack i = Mine.newItem(Material.COOKED_BEEF, null, 1, 0, " ", "  §fValor: §a$25");
					ItemStack j = Mine.newItem(Material.MELON_SLICE, null, 1, 0, " ", "  §fValor: §a$15");
					ItemStack k = Mine.newItem(Material.COOKIE, null, 1, 0, " ", "  §fValor: §a$10");
					ItemStack l = Mine.newItem(Material.GOLDEN_APPLE, null, 1, 0, " ", "  §fValor: §a$30");
					ItemStack m = Mine.newItem(Material.PUMPKIN_PIE, null, 1, 0, " ", "  §fValor: §a$15");
					ItemStack n = Mine.newItem(Material.CAKE, null, 1, 0, " ", "  §fValor: §a$20");
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
				if(e.getCurrentItem().isSimilar(prox)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("EncantamentoS", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$60");
					EnchantmentStorageMeta am = (EnchantmentStorageMeta) a.getItemMeta();
					am.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
					a.setItemMeta(am);
					ItemStack b = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$40");
					EnchantmentStorageMeta bm = (EnchantmentStorageMeta) b.getItemMeta();
					bm.addEnchant(Enchantment.LOOT_BONUS_MOBS, 1, false);
					b.setItemMeta(bm);
					ItemStack c = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta cm = (EnchantmentStorageMeta) c.getItemMeta();
					cm.addEnchant(Enchantment.LOOT_BONUS_MOBS, 2, false);
					c.setItemMeta(cm);
					ItemStack d = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$60");
					EnchantmentStorageMeta dm = (EnchantmentStorageMeta) d.getItemMeta();
					dm.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, false);
					d.setItemMeta(dm);
					ItemStack ee = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$60");
					EnchantmentStorageMeta em = (EnchantmentStorageMeta) ee.getItemMeta();
					em.addEnchant(Enchantment.MENDING, 1, false);
					ee.setItemMeta(em);
					ItemStack f = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$40");
					EnchantmentStorageMeta fm = (EnchantmentStorageMeta) f.getItemMeta();
					fm.addEnchant(Enchantment.ARROW_FIRE, 1, false);
					f.setItemMeta(fm);
					ItemStack g = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$60");
					EnchantmentStorageMeta gm = (EnchantmentStorageMeta) g.getItemMeta();
					gm.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
					g.setItemMeta(gm);
					ItemStack h = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta hm = (EnchantmentStorageMeta) h.getItemMeta();
					hm.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, false);
					h.setItemMeta(hm);
					ItemStack i = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$40");
					EnchantmentStorageMeta im = (EnchantmentStorageMeta) i.getItemMeta();
					im.addEnchant(Enchantment.OXYGEN, 1, false);
					i.setItemMeta(im);
					ItemStack j = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta jm = (EnchantmentStorageMeta) j.getItemMeta();
					jm.addEnchant(Enchantment.OXYGEN, 2, false);
					j.setItemMeta(jm);
					ItemStack k = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$60");
					EnchantmentStorageMeta km = (EnchantmentStorageMeta) k.getItemMeta();
					km.addEnchant(Enchantment.OXYGEN, 3, false);
					k.setItemMeta(km);
					ItemStack l = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta lm = (EnchantmentStorageMeta) l.getItemMeta();
					lm.addEnchant(Enchantment.THORNS, 1, false);
					l.setItemMeta(lm);
					ItemStack m = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$60");
					EnchantmentStorageMeta mm = (EnchantmentStorageMeta) m.getItemMeta();
					mm.addEnchant(Enchantment.THORNS, 2, false);
					m.setItemMeta(mm);
					ItemStack n = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta nm = (EnchantmentStorageMeta) n.getItemMeta();
					nm.addEnchant(Enchantment.WATER_WORKER, 1, false);
					n.setItemMeta(nm);
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
			}
		}
		if(e.getView().getTitle().equals("EncantamentoS")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().isSimilar(voltar)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Encantamentos", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.ENCHANTING_TABLE, null, 1, 0, " ", "  §fValor: §a$50");
					ItemStack b = Mine.newItem(Material.BOOKSHELF, null, 1, 0, " ", "  §fValor: §a$5");
					ItemStack c = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$40");
					EnchantmentStorageMeta cm = (EnchantmentStorageMeta) c.getItemMeta();
					cm.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, false);
					c.setItemMeta(cm);
					ItemStack d = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta dm = (EnchantmentStorageMeta) d.getItemMeta();
					dm.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 2, false);
					d.setItemMeta(dm);
					ItemStack ee = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$60");
					EnchantmentStorageMeta em = (EnchantmentStorageMeta) ee.getItemMeta();
					em.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, false);
					ee.setItemMeta(em);
					ItemStack f = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$40");
					EnchantmentStorageMeta fm = (EnchantmentStorageMeta) f.getItemMeta();
					fm.addEnchant(Enchantment.DIG_SPEED, 1, false);
					f.setItemMeta(fm);
					ItemStack g = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta gm = (EnchantmentStorageMeta) g.getItemMeta();
					gm.addEnchant(Enchantment.DIG_SPEED, 3, false);
					g.setItemMeta(gm);
					ItemStack h = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$60");
					EnchantmentStorageMeta hm = (EnchantmentStorageMeta) h.getItemMeta();
					hm.addEnchant(Enchantment.DIG_SPEED, 5, false);
					h.setItemMeta(hm);
					ItemStack i = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$40");
					EnchantmentStorageMeta im = (EnchantmentStorageMeta) i.getItemMeta();
					im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
					i.setItemMeta(im);
					ItemStack j = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta jm = (EnchantmentStorageMeta) j.getItemMeta();
					jm.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false);
					j.setItemMeta(jm);
					ItemStack k = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$40");
					EnchantmentStorageMeta km = (EnchantmentStorageMeta) k.getItemMeta();
					km.addEnchant(Enchantment.PROTECTION_FALL, 1, false);
					k.setItemMeta(km);
					ItemStack l = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta lm = (EnchantmentStorageMeta) l.getItemMeta();
					lm.addEnchant(Enchantment.PROTECTION_FALL, 3, false);
					l.setItemMeta(lm);
					ItemStack m = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$40");
					EnchantmentStorageMeta mm = (EnchantmentStorageMeta) m.getItemMeta();
					mm.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
					m.setItemMeta(mm);
					ItemStack n = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta nm = (EnchantmentStorageMeta) n.getItemMeta();
					nm.addEnchant(Enchantment.DAMAGE_ALL, 3, false);
					n.setItemMeta(nm);
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
				if(e.getCurrentItem().isSimilar(prox)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					Inventory bloco = Mine.newInventory("Especial", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.BEACON, null, 1, 0, " ", "  §fValor: §a$95");
					ItemStack b = Mine.newItem(Material.END_PORTAL_FRAME, null, 1, 0, " ", "  §fValor: §a$300");
					ItemStack c = Mine.newItem(Material.ANVIL, null, 1, 0, " ", "  §fValor: §a$140");
					ItemStack d = Mine.newItem(Material.ENDER_EYE, null, 1, 0, " ", "  §fValor: §a$80");
					ItemStack ee = Mine.newItem(Material.DRAGON_HEAD, null, 1, 0, " ", "  §fValor: §a$60");
					ItemStack f = Mine.newItem(Material.END_CRYSTAL, null, 1, 0, " ", "  §fValor: §a$88");
					ItemStack g = Mine.newItem(Material.ENDER_PEARL, null, 1, 0, " ", "  §fValor: §a$35");
					ItemStack h = Mine.newItem(Material.ZOMBIE_SPAWN_EGG, null, 1, 0, " ", "  §fValor: §a$80");
					ItemStack i = Mine.newItem(Material.CREEPER_SPAWN_EGG, null, 1, 0, " ", "  §fValor: §a$80");
					ItemStack j = Mine.newItem(Material.SKELETON_SPAWN_EGG, null, 1, 0, " ", "  §fValor: §a$80");
					ItemStack k = Mine.newItem(Material.CAVE_SPIDER_SPAWN_EGG, null, 1, 0, " ", "  §fValor: §a$80");
					ItemStack l = Mine.newItem(Material.BLAZE_SPAWN_EGG, null, 1, 0, " ", "  §fValor: §a$80");
					ItemStack m = Mine.newItem(Material.GHAST_SPAWN_EGG, null, 1, 0, " ", "  §fValor: §a$80");
					ItemStack n = Mine.newItem(Material.WITHER_SKELETON_SPAWN_EGG, null, 1, 0, " ", "  §fValor: §a$80");
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
			}
		}
		if(e.getView().getTitle().equals("Especial")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().isSimilar(voltar)) {
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
Inventory bloco = Mine.newInventory("EncantamentoS", 9*6);
					
					for(int i = 0; i<9*6; i++) {
						bloco.setItem(i, Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
					}
					
					ItemStack a = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$60");
					EnchantmentStorageMeta am = (EnchantmentStorageMeta) a.getItemMeta();
					am.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
					a.setItemMeta(am);
					ItemStack b = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$40");
					EnchantmentStorageMeta bm = (EnchantmentStorageMeta) b.getItemMeta();
					bm.addEnchant(Enchantment.LOOT_BONUS_MOBS, 1, false);
					b.setItemMeta(bm);
					ItemStack c = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta cm = (EnchantmentStorageMeta) c.getItemMeta();
					cm.addEnchant(Enchantment.LOOT_BONUS_MOBS, 2, false);
					c.setItemMeta(cm);
					ItemStack d = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$60");
					EnchantmentStorageMeta dm = (EnchantmentStorageMeta) d.getItemMeta();
					dm.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, false);
					d.setItemMeta(dm);
					ItemStack ee = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$60");
					EnchantmentStorageMeta em = (EnchantmentStorageMeta) ee.getItemMeta();
					em.addEnchant(Enchantment.MENDING, 1, false);
					ee.setItemMeta(em);
					ItemStack f = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$40");
					EnchantmentStorageMeta fm = (EnchantmentStorageMeta) f.getItemMeta();
					fm.addEnchant(Enchantment.ARROW_FIRE, 1, false);
					f.setItemMeta(fm);
					ItemStack g = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$60");
					EnchantmentStorageMeta gm = (EnchantmentStorageMeta) g.getItemMeta();
					gm.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
					g.setItemMeta(gm);
					ItemStack h = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta hm = (EnchantmentStorageMeta) h.getItemMeta();
					hm.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, false);
					h.setItemMeta(hm);
					ItemStack i = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$40");
					EnchantmentStorageMeta im = (EnchantmentStorageMeta) i.getItemMeta();
					im.addEnchant(Enchantment.OXYGEN, 1, false);
					i.setItemMeta(im);
					ItemStack j = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta jm = (EnchantmentStorageMeta) j.getItemMeta();
					jm.addEnchant(Enchantment.OXYGEN, 2, false);
					j.setItemMeta(jm);
					ItemStack k = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$60");
					EnchantmentStorageMeta km = (EnchantmentStorageMeta) k.getItemMeta();
					km.addEnchant(Enchantment.OXYGEN, 3, false);
					k.setItemMeta(km);
					ItemStack l = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta lm = (EnchantmentStorageMeta) l.getItemMeta();
					lm.addEnchant(Enchantment.THORNS, 1, false);
					l.setItemMeta(lm);
					ItemStack m = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$60");
					EnchantmentStorageMeta mm = (EnchantmentStorageMeta) m.getItemMeta();
					mm.addEnchant(Enchantment.THORNS, 2, false);
					m.setItemMeta(mm);
					ItemStack n = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0, " ", "  §fValor: §a$50");
					EnchantmentStorageMeta nm = (EnchantmentStorageMeta) n.getItemMeta();
					nm.addEnchant(Enchantment.WATER_WORKER, 1, false);
					n.setItemMeta(nm);
					
					bloco.setItem(Mine.getPosition(2, 2), a);
					bloco.setItem(Mine.getPosition(2, 3), b);
					bloco.setItem(Mine.getPosition(2, 4), c);
					bloco.setItem(Mine.getPosition(2, 5), d);
					bloco.setItem(Mine.getPosition(2, 6), ee);
					bloco.setItem(Mine.getPosition(2, 7), f);
					bloco.setItem(Mine.getPosition(2, 8), g);
					bloco.setItem(Mine.getPosition(3, 2), h);
					bloco.setItem(Mine.getPosition(3, 3), i);
					bloco.setItem(Mine.getPosition(3, 4), j);
					bloco.setItem(Mine.getPosition(3, 5), k);
					bloco.setItem(Mine.getPosition(3, 6), l);
					bloco.setItem(Mine.getPosition(3, 7), m);
					bloco.setItem(Mine.getPosition(3, 8), n);
					
					bloco.setItem(Mine.getPosition(5, 5), dinheiro(p));
					
					bloco.setItem(Mine.getPosition(5, 8), prox);
					bloco.setItem(Mine.getPosition(5, 2), voltar);
					
					p.openInventory(bloco);
				}
			}
		}
	}
}
