package me.ninjay.template.utils;

import org.bukkit.enchantments.Enchantment;


public class EnchantmentStorable implements Storable{


		@SuppressWarnings("deprecation")
		@Override
		public Object store(Object object) {
			if (object instanceof Enchantment) {
				Enchantment enchantment = (Enchantment) object;
				return enchantment.getKey();

			}
			return null;
		}

		@SuppressWarnings("deprecation")
		@Override
		public Object restore(Object object) {
			if (object instanceof String) {
				String string = (String) object;
				return null;

			}
			return null;
		}

}
