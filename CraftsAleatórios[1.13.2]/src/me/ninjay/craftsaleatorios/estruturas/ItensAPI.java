package me.ninjay.craftsaleatorios.estruturas;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.ninjay.craftsaleatorios.main.Main;
import me.ninjay.craftsaleatorios.utils.Mine;

public class ItensAPI implements Listener{
	
	private Plugin plugin = Main.getPlugin(Main.class);
	
	public static ItemStack escudo = Mine.newItem(Material.SHIELD, "§eEscudo de Espadas", 1, 0, " ", "  §7Dê dano a monstros que chegarem perto.");
	public static ItemStack macadiamante = Mine.newItem(Material.ENCHANTED_GOLDEN_APPLE, "§eMaca de Diamante", 1, 0, " ", "  §7Receba diversos efeitos.");
	public static ItemStack picfim = Mine.newItem(Material.DIAMOND_PICKAXE, "§ePicareta do Fim", 1, 0, " ", "  §7Teleporte para onde estiver olhando.");
	public static ItemStack piceme = Mine.newItem(Material.GOLDEN_PICKAXE, "§ePicareta de Esmeralda", 1, 0, " ", "  §7Receba efeito de Agilidade II ao usar ela.");
	public static ItemStack espadaeme = Mine.newItem(Material.DIAMOND_SWORD, "§eEspada de Esmeralda", 1, 0);
	public static ItemStack espadaceno = Mine.newItem(Material.COOKED_BEEF, "§eEspada de Cenoura", 1, 0);
	public static ItemStack espadapao = Mine.newItem(Material.COOKED_CHICKEN, "§eEspada de Pao", 1, 0);
	public static ItemStack capamadeira = Mine.newItem(Material.CHAINMAIL_HELMET, "§eCapacete de Madeira", 1, 0);
	public static ItemStack peitomadeira = Mine.newItem(Material.CHAINMAIL_CHESTPLATE, "§ePeitoral de Madeira", 1, 0);
	public static ItemStack calcamadeira = Mine.newItem(Material.CHAINMAIL_LEGGINGS, "§eCalca de Madeira", 1, 0);
	public static ItemStack botamadeira = Mine.newItem(Material.CHAINMAIL_BOOTS, "§eBotas de Madeira", 1, 0);
	public static ItemStack capaforna = Mine.newItem(Material.GOLDEN_HELMET, "§eCapacete de Fornalha", 1, 0, " ", "  §7Com a armadura completa os minério virão assados.");
	public static ItemStack peitoforna = Mine.newItem(Material.GOLDEN_CHESTPLATE, "§ePeitoral de Fornalha", 1, 0, " ", "  §7Com a armadura completa os minério virão assados.");
	public static ItemStack calcaforna = Mine.newItem(Material.GOLDEN_LEGGINGS, "§eCalca de Fornalha", 1, 0, " ", "  §7Com a armadura completa os minério virão assados.");
	public static ItemStack botaforna = Mine.newItem(Material.GOLDEN_BOOTS, "§eBotas de Fornalha", 1, 0, " ", "  §7Com a armadura completa os minério virão assados.");
	public static ItemStack capamaca = Mine.newItem(Material.DIAMOND_HELMET, "§eCapacete de Maca", 1, 0, " ", "  §7Receba 1 linha extra de corações.");
	public static ItemStack peitomaca = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§ePeitoral de Maca", 1, 0, " ", "  §7Receba efeito de resistência II.");
	public static ItemStack calcamaca = Mine.newItem(Material.DIAMOND_LEGGINGS, "§eCalca de Maca", 1, 0, " ", "  §7Receba efeito de velocidade II.");
	public static ItemStack botamaca = Mine.newItem(Material.DIAMOND_BOOTS, "§eBotas de Maca", 1, 0, " ", "  §7Receba efeito de super pulo II.");
	public static ItemStack capaobsi = Mine.newItem(Material.IRON_HELMET, "§eCapacete de Obsidian", 1, 0, " ", "  §7Com a armadura completa receba resistência X.");
	public static ItemStack peitoobsi = Mine.newItem(Material.IRON_CHESTPLATE, "§ePeitoral de Obsidian", 1, 0, " ", "  §7Com a armadura completa receba resistência X.");
	public static ItemStack calcaobsi = Mine.newItem(Material.IRON_LEGGINGS, "§eCalca de Obsidian", 1, 0, " ", "  §7Com a armadura completa receba resistência X.");
	public static ItemStack botaobsi = Mine.newItem(Material.IRON_BOOTS, "§eBotas de Obsidian", 1, 0, " ", "  §7Com a armadura completa receba resistência X.");
	public static ItemStack capamagma = Mine.newItem(Material.LEATHER_HELMET, "§eCapacete de Magma", 1, 0, " ", "  §7Com a armadura completa queime tudo por onde passa.");
	public static ItemStack peitomagma = Mine.newItem(Material.LEATHER_CHESTPLATE, "§ePeitoral de Magma", 1, 0, " ", "  §7Com a armadura completa queime tudo por onde passa.");
	public static ItemStack calcamagma = Mine.newItem(Material.LEATHER_LEGGINGS, "§eCalca de Magma", 1, 0, " ", "  §7Com a armadura completa queime tudo por onde passa.");
	public static ItemStack botamagma = Mine.newItem(Material.LEATHER_BOOTS, "§eBotas de Magma", 1, 0, " ", "  §7Com a armadura completa queime tudo por onde passa.");
	public static ItemStack capadisp = Mine.newItem(Material.TURTLE_HELMET, "§eCapacete de Dispenser", 1, 0, " ", "  §7Atire flechas pela cabeça.");
	public static ItemStack espadaquartz() {
		ItemStack item = Mine.newItem(Material.WOODEN_SWORD, "§eEspada de Quartzo", 1, 0, " ",  "  §7Possui encantamento de repulsão II.");
		Mine.addEnchant(item, Enchantment.KNOCKBACK, 2);
		return item;
	}
	public static ItemStack machacarne = Mine.newItem(Material.STONE_AXE, "§eMachado de Carne", 1, 0);
	public static ItemStack perolavidro = Mine.newItem(Material.ENDER_EYE, "§ePerola de Vidro", 1, 0, " ", "  §7Transforme os blocos de uma área em vidro,","  §7possibilitando enxergar minérios.");
	public static ItemStack baudima = Mine.newItem(Material.TRAPPED_CHEST, "§eBaú de Diamante", 1, 0, " ", "  §7Não pode ser explodido.");
	public static ItemStack picastick() {
		ItemStack item = Mine.newItem(Material.IRON_PICKAXE, "§ePicareta de Graveto", 1, 0);
		Mine.addEnchant(item, Enchantment.LOOT_BONUS_BLOCKS, 3);
		Mine.addEnchant(item, Enchantment.DURABILITY, 3);
		Mine.addEnchant(item, Enchantment.DIG_SPEED, 4);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		return item;
	}
	public static ItemStack cercared = Mine.newItem(Material.ACACIA_FENCE, "§eCerca de Redstone", 1, 0, " ", "  §7Mata todos os mobs em que nela encostar.");
	public static ItemStack tocha = Mine.newItem(Material.REDSTONE_TORCH, "§eTocha de Polvora", 1, 0, " ", "  §7Ao colocar no chão causará uma explosão.");
	
	public void customRecipe() {
		ShapedRecipe escudor = new ShapedRecipe(escudo);
		
		escudor.shape(" ! ", " @ ", " ! ");
		
		escudor.setIngredient('!', Material.DIAMOND);
		escudor.setIngredient('@', Material.SHIELD);
		
		plugin.getServer().addRecipe(escudor);
		
		ShapedRecipe macadimar = new ShapedRecipe(macadiamante);
		
		macadimar.shape("!!!", "!@!", "!!!");
		
		macadimar.setIngredient('!', Material.DIAMOND);
		macadimar.setIngredient('@', Material.GOLDEN_APPLE);
		
		plugin.getServer().addRecipe(macadimar);
		
		ShapedRecipe picaretafimr = new ShapedRecipe(picfim);
		
		picaretafimr.shape("@@@", " ! ", " ! ");
		
		picaretafimr.setIngredient('!', Material.STICK);
		picaretafimr.setIngredient('@', Material.ENDER_PEARL);
		
		plugin.getServer().addRecipe(picaretafimr);
		
		ShapedRecipe picaretaemer = new ShapedRecipe(piceme);
		
		picaretaemer.shape("!!!", " @ ", " @ ");
		
		picaretaemer.setIngredient('!', Material.EMERALD);
		picaretaemer.setIngredient('@', Material.STICK);
		
		plugin.getServer().addRecipe(picaretaemer);
		
		ShapedRecipe espadaemer = new ShapedRecipe(espadaeme);
		
		espadaemer.shape(" ! ", " ! ", " @ ");
		
		espadaemer.setIngredient('!', Material.EMERALD);
		espadaemer.setIngredient('@', Material.STICK);
		
		plugin.getServer().addRecipe(espadaemer);
		
		ShapedRecipe cenourar = new ShapedRecipe(espadaceno);
		
		cenourar.shape(" ! ", " ! ", " @ ");
		
		cenourar.setIngredient('!', Material.CARROT);
		cenourar.setIngredient('@', Material.STICK);
		
		plugin.getServer().addRecipe(cenourar);
		
		ShapedRecipe paor = new ShapedRecipe(espadapao);
		
		paor.shape(" ! ", " ! ", " @ ");
		
		paor.setIngredient('!', Material.BREAD);
		paor.setIngredient('@', Material.STICK);
		
		plugin.getServer().addRecipe(paor);
		
		ShapedRecipe capamadeirar = new ShapedRecipe(capamadeira);
		
		capamadeirar.shape("!!!", "! !");
		
		capamadeirar.setIngredient('!', Material.OAK_LOG);
		
		plugin.getServer().addRecipe(capamadeirar);
		
		ShapedRecipe peitomadeirar = new ShapedRecipe(peitomadeira);
		
		peitomadeirar.shape("! !", "!!!", "!!!");
		
		peitomadeirar.setIngredient('!', Material.OAK_LOG);
		
		plugin.getServer().addRecipe(peitomadeirar);
		
		ShapedRecipe calcar = new ShapedRecipe(calcamadeira);
		
		calcar.shape("!!!", "! !", "! !");
		
		calcar.setIngredient('!', Material.OAK_LOG);
		
		plugin.getServer().addRecipe(calcar);
		
		ShapedRecipe botamadeirar = new ShapedRecipe(botamadeira);
		
		botamadeirar.shape("! !", "! !");
		
		botamadeirar.setIngredient('!', Material.OAK_LOG);
		
		plugin.getServer().addRecipe(botamadeirar);
		
		ShapedRecipe capafornar = new ShapedRecipe(capaforna);
		
		capafornar.shape("!!!", "! !");
		
		capafornar.setIngredient('!', Material.FURNACE);
		
		plugin.getServer().addRecipe(capafornar);
		
		ShapedRecipe peitofornar = new ShapedRecipe(peitoforna);
		
		peitofornar.shape("! !", "!!!", "!!!");
		
		peitofornar.setIngredient('!', Material.FURNACE);
		
		plugin.getServer().addRecipe(peitofornar);
		
		ShapedRecipe calcafornar = new ShapedRecipe(calcaforna);
		
		calcafornar.shape("!!!", "! !", "! !");
		
		calcafornar.setIngredient('!', Material.FURNACE);
		
		plugin.getServer().addRecipe(calcafornar);
		
		ShapedRecipe botafornar = new ShapedRecipe(botaforna);
		
		botafornar.shape("! !", "! !");
		
		botafornar.setIngredient('!', Material.FURNACE);
		
		plugin.getServer().addRecipe(botafornar);
		
		  
		ShapedRecipe capamacar = new ShapedRecipe(capamaca);
				
		capamacar.shape("!!!", "! !");
				
		capamacar.setIngredient('!', Material.GOLDEN_APPLE);
				
		plugin.getServer().addRecipe(capamacar);
				
		ShapedRecipe peitomacar = new ShapedRecipe(peitomaca);
				
		peitomacar.shape("! !", "!!!", "!!!");
				
		peitomacar.setIngredient('!', Material.GOLDEN_APPLE);
				
		plugin.getServer().addRecipe(peitomacar);
				
		ShapedRecipe calcamacar = new ShapedRecipe(calcamaca);
				
		calcamacar.shape("!!!", "! !", "! !");
				
		calcamacar.setIngredient('!', Material.GOLDEN_APPLE);
				
		plugin.getServer().addRecipe(calcamacar);
				
		ShapedRecipe botamacar = new ShapedRecipe(botamaca);
				
		botamacar.shape("! !", "! !");
				
		botamacar.setIngredient('!', Material.GOLDEN_APPLE);
				
		plugin.getServer().addRecipe(botamacar);
		
		ShapedRecipe capaobsir = new ShapedRecipe(capaobsi);
		
		capaobsir.shape("!!!", "! !");
				
		capaobsir.setIngredient('!', Material.OBSIDIAN);
				
		plugin.getServer().addRecipe(capaobsir);
				
		ShapedRecipe peitoobsir = new ShapedRecipe(peitoobsi);
				
		peitoobsir.shape("! !", "!!!", "!!!");
				
		peitoobsir.setIngredient('!', Material.OBSIDIAN);
				
		plugin.getServer().addRecipe(peitoobsir);
				
		ShapedRecipe calcaobsir = new ShapedRecipe(calcaobsi);
				
		calcaobsir.shape("!!!", "! !", "! !");
				
		calcaobsir.setIngredient('!', Material.OBSIDIAN);
				
		plugin.getServer().addRecipe(calcaobsir);
				
		ShapedRecipe botaobsir = new ShapedRecipe(botaobsi);
				
		botaobsir.shape("! !", "! !");
				
		botaobsir.setIngredient('!', Material.OBSIDIAN);
				
		plugin.getServer().addRecipe(botaobsir);
		
  		ShapedRecipe capamagmar = new ShapedRecipe(capamagma);
		
		capamagmar.shape("!!!", "! !");
				
		capamagmar.setIngredient('!', Material.MAGMA_BLOCK);
				
		plugin.getServer().addRecipe(capamagmar);
				
		ShapedRecipe peitomagmar = new ShapedRecipe(peitomagma);
				
		peitomagmar.shape("! !", "!!!", "!!!");
				
		peitomagmar.setIngredient('!', Material.MAGMA_BLOCK);
				
		plugin.getServer().addRecipe(peitomagmar);
				
		ShapedRecipe calcamagmar = new ShapedRecipe(calcamagma);
				
		calcamagmar.shape("!!!", "! !", "! !");
				
		calcamagmar.setIngredient('!', Material.MAGMA_BLOCK);
				
		plugin.getServer().addRecipe(calcamagmar);
				
		ShapedRecipe botamagmar = new ShapedRecipe(botamagma);
				
		botamagmar.shape("! !", "! !");
				
		botamagmar.setIngredient('!', Material.MAGMA_BLOCK);
				
		plugin.getServer().addRecipe(botamagmar);
		
		ShapedRecipe capadispr = new ShapedRecipe(capadisp);
		
		capadispr.shape("!!!", "!@!");
				
		capadispr.setIngredient('!', Material.DISPENSER);
		capadispr.setIngredient('@', Material.ARROW);
				
		plugin.getServer().addRecipe(capadispr);
		
		ShapedRecipe espadaquartzr = new ShapedRecipe(espadaquartz());
		
		espadaquartzr.shape(" ! ", " ! ", " @ ");
		
		espadaquartzr.setIngredient('!', Material.QUARTZ);
		espadaquartzr.setIngredient('@', Material.STICK);
		
		plugin.getServer().addRecipe(espadaquartzr);
		
		ShapedRecipe machacarner = new ShapedRecipe(machacarne);
		
		machacarner.shape("!! ", "!@ ", " @ ");
		
		machacarner.setIngredient('!', Material.BEEF);
		machacarner.setIngredient('@', Material.STICK);
		
		plugin.getServer().addRecipe(machacarner);
		
		ShapedRecipe perolar = new ShapedRecipe(perolavidro);
		
		perolar.shape("!!!", "!@!", "!!!");
		
		perolar.setIngredient('!', Material.GLASS);
		perolar.setIngredient('@', Material.ENDER_PEARL);
		
		plugin.getServer().addRecipe(perolar);
		
		ShapedRecipe baudimar = new ShapedRecipe(baudima);
		
		baudimar.shape("!!!", "!@!", "!!!");
		
		baudimar.setIngredient('!', Material.DIAMOND);
		baudimar.setIngredient('@', Material.CHEST);
		
		plugin.getServer().addRecipe(baudimar);
		
		ShapedRecipe picastickr = new ShapedRecipe(picastick());
		
		picastickr.shape("!!!", " ! ", " ! ");
		
		picastickr.setIngredient('!', Material.STICK);
		
		plugin.getServer().addRecipe(picastickr);
		
		ShapedRecipe cercaredr = new ShapedRecipe(cercared);
		
		cercaredr.shape("@!@", "@!@");
		
		cercaredr.setIngredient('!', Material.REDSTONE);
		cercaredr.setIngredient('@', Material.REDSTONE_BLOCK);
		
		plugin.getServer().addRecipe(cercaredr);
		
		ShapedRecipe tochar = new ShapedRecipe(tocha);
		
		tochar.shape("!", "@");
		
		tochar.setIngredient('!', Material.GUNPOWDER);
		tochar.setIngredient('@', Material.STICK);
		
		plugin.getServer().addRecipe(tochar);
	}
}
