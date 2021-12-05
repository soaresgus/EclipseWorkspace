package me.ninjay.imortal.estruturas;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import me.ninjay.imortal.utils.Mine;


public class ItensAPI {
	
	public static ItemStack pot() {
		ItemStack a = Mine.newItem(Material.POTION, "§b§lPocao dos Deuses", 1, 0, " ", "  §7Nunca vi nada mais poderoso!");
		PotionMeta am = (PotionMeta) a.getItemMeta();
		am.setColor(Color.AQUA);
		am.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, (15*60)*20, 40), true);
		//am.addCustomEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, (15*60)*20, 255), true);
		am.addCustomEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, (15*60)*20, 255), true);
		am.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (15*60)*20, 255), true);
		//am.addCustomEffect(new PotionEffect(PotionEffectType.JUMP, (15*60)*20, 10), true);
		am.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, (15*60)*20, 10), true);
		am.addCustomEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, (15*60)*20, 10), true);
		am.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, (15*60)*20, 10), true);
		am.addCustomEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, (15*60)*20, 10), true);
		am.addCustomEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, (15*60)*20, 10), true);
		//am.addCustomEffect(new PotionEffect(PotionEffectType.ABSORPTION, (15*60)*20, 255), true);
		am.addCustomEffect(new PotionEffect(PotionEffectType.SATURATION, (15*60)*20, 10), true);
		am.addCustomEffect(new PotionEffect(PotionEffectType.LUCK, (15*60)*20, 10), true);
		am.addCustomEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER, (15*60)*20, 10), true);
		am.addCustomEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, (15*60)*20, 10), true);
		am.addCustomEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, (15*60)*20, 10), true);
		am.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		a.setItemMeta(am);
		
		return a;
	}

}
