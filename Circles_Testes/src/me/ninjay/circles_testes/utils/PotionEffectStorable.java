package me.ninjay.circles_testes.utils;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class PotionEffectStorable implements Storable {
	@Override
	public Object newInstance() {
		return new PotionEffect(PotionEffectType.ABSORPTION, 20, 0);
	}
}
