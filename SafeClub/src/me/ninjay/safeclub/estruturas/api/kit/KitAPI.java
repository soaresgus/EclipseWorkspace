package me.ninjay.safeclub.estruturas.api.kit;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;


import me.ninjay.safeclub.estruturas.api.caixa.CaixaAPI;
import me.ninjay.safeclub.utils.BukkitConfig;
import me.ninjay.safeclub.utils.Mine;

public class KitAPI {

	public static ItemStack p4 = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§eSets");

	public static ItemStack vip = Mine.newItem(Material.EMERALD, "§eKits Vips");

	public static ItemStack caixas = Mine.newItem(Material.STORAGE_MINECART, "§eCaixas Misteriosas");

	public static ItemStack ninja = Mine.newItem(Material.EMERALD_BLOCK, "§eKit §5[Ninja] §esemanal");
	
	public static ItemStack safe = Mine.newItem(Material.DIAMOND_BLOCK, "§eKit §6[Safe] §esemanal");
	
	public static ItemStack tres = CaixaAPI.manager.getCaixaInt(3).getIcone();
	
	public static ItemStack quatro = CaixaAPI.manager.getCaixaInt(4).getIcone();
	
	public static void openGUI(Player p) {
		Inventory inv = Mine.newInventory("Kits", 9 * 3);
		Mine.addEnchant(p4, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		Mine.addEnchant(vip, Enchantment.DURABILITY, 3);
		Mine.addEnchant(caixas, Enchantment.DURABILITY, 3);
		inv.setItem(Mine.getPosition(2, 2), p4);
		inv.setItem(Mine.getPosition(2, 5), vip);
		inv.setItem(Mine.getPosition(2, 8), caixas);

		p.openInventory(inv);

	}

	public static void openP4(Player p) {
		Inventory sets = Mine.newInventory("Sets", 9 * 4);

		ItemStack capa = Mine.newItem(Material.DIAMOND_HELMET, "§eCapacete Free");
		Mine.addEnchant(capa, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		Mine.addEnchant(capa, Enchantment.DURABILITY, 3);

		ItemStack peito = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§ePeitoral Free");
		Mine.addEnchant(peito, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		Mine.addEnchant(peito, Enchantment.DURABILITY, 3);

		ItemStack calc = Mine.newItem(Material.DIAMOND_LEGGINGS, "§eCalça Free");
		Mine.addEnchant(calc, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		Mine.addEnchant(calc, Enchantment.DURABILITY, 3);

		ItemStack bota = Mine.newItem(Material.DIAMOND_BOOTS, "§eBota Free");
		Mine.addEnchant(bota, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		Mine.addEnchant(bota, Enchantment.DURABILITY, 3);

		ItemStack esps = Mine.newItem(Material.DIAMOND_SWORD, "§eEspada Sem KB");
		Mine.addEnchant(esps, Enchantment.DAMAGE_ALL, 5);
		Mine.addEnchant(esps, Enchantment.DURABILITY, 3);
		Mine.addEnchant(esps, Enchantment.FIRE_ASPECT, 2);

		ItemStack espkb = Mine.newItem(Material.DIAMOND_SWORD, "§eEspada Com KB");
		Mine.addEnchant(espkb, Enchantment.DAMAGE_ALL, 5);
		Mine.addEnchant(espkb, Enchantment.DURABILITY, 3);
		Mine.addEnchant(espkb, Enchantment.FIRE_ASPECT, 2);
		Mine.addEnchant(espkb, Enchantment.KNOCKBACK, 2);

		ItemStack cap = Mine.newItem(Material.GOLDEN_APPLE, "§eMaça Dourada", 64, 1, "");

		Potion potf = new Potion(PotionType.STRENGTH, 2, false);
		ItemStack forc = potf.toItemStack(32);

		Potion pots = new Potion(PotionType.SPEED, 2, false);
		ItemStack sped = pots.toItemStack(32);

		sets.setItem(Mine.getPosition(2, 2), capa);
		sets.setItem(Mine.getPosition(2, 3), peito);
		sets.setItem(Mine.getPosition(3, 2), calc);
		sets.setItem(Mine.getPosition(3, 3), bota);
		sets.setItem(Mine.getPosition(2, 5), esps);
		sets.setItem(Mine.getPosition(3, 5), espkb);
		sets.setItem(Mine.getPosition(2, 7), forc);
		sets.setItem(Mine.getPosition(3, 7), sped);
		sets.setItem(Mine.getPosition(2, 8), cap);

		p.openInventory(sets);

	}

	public static void openCaixa(Player p) {
		Inventory caixas = Mine.newInventory("Caixas", 9 * 3);

		ItemMeta tresm = tres.getItemMeta();
		tresm.setLore(Arrays.asList(" ","§e * Valor: 1 Cash"));
		
		ItemMeta quatrom = quatro.getItemMeta();
		quatrom.setLore(Arrays.asList(" ","§e * Valor: 1 Cash"));

		caixas.setItem(Mine.getPosition(2, 3), tres);
		caixas.setItem(Mine.getPosition(2, 7), quatro);

		p.openInventory(caixas);

	}

	public static void openVip(Player p) {
		Inventory vip = Mine.newInventory("Kits Vip", 9 * 3);

		vip.setItem(Mine.getPosition(2, 3), safe);
		vip.setItem(Mine.getPosition(2, 7), ninja);
		
		p.openInventory(vip);
	}

	public static void coletarSafe(Player p, BukkitConfig config) {
		if (config.contains("Cooldown.Safe." + p.getName())) {
			long tempo = config.getLong("Cooldown.Safe." + p.getName());
			long resultado = Mine.getCooldown(tempo, 604800);

			if (Mine.inCooldown(tempo, 604800)) {
				p.sendMessage("§cAguarde " + Mine.formatTime(resultado) + " para pegar seu kit novamente.");
				p.getOpenInventory().close();
				return;
			}
		}
		// p.sendmessage("vc entrou no cooldown");
		p.getOpenInventory().close();
		config.set("Cooldown.Safe." + p.getName(), System.currentTimeMillis());
		config.saveConfig();
		ItemStack um = CaixaAPI.manager.getCaixaInt(3).getIcone();
		um.setAmount(5);
		ItemStack dois = CaixaAPI.manager.getCaixaInt(4).getIcone();
		dois.setAmount(3);
		p.getInventory().addItem(um);
		p.getInventory().addItem(dois);
	}

	public static void coletarNinja(Player p, BukkitConfig config) {
		if (config.contains("Cooldown.Ninja." + p.getName())) {
			long tempo = config.getLong("Cooldown.Ninja." + p.getName());
			long resultado = Mine.getCooldown(tempo, 604800);

			if (Mine.inCooldown(tempo, 604800)) {
				p.sendMessage("§cAguarde " + Mine.formatTime(resultado) + " para pegar seu kit novamente.");
				p.getOpenInventory().close();
				return;
			}
		}
		// p.sendmessage("vc entrou no cooldown");
		p.getOpenInventory().close();
		config.set("Cooldown.Ninja." + p.getName(), System.currentTimeMillis());
		config.saveConfig();
		ItemStack um = CaixaAPI.manager.getCaixaInt(3).getIcone();
		um.setAmount(10);
		ItemStack dois = CaixaAPI.manager.getCaixaInt(4).getIcone();
		dois.setAmount(6);
		p.getInventory().addItem(um);
		p.getInventory().addItem(dois);
	}

}
