package me.ninjay.picaretayoutuber.utils;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;


//@StorageAttributes(auto=false)
public class ItemStackStorable implements Storable {

	@Override
	public Object newInstance() {
		return new ItemStack(Material.STONE);
	}


	@SuppressWarnings("deprecation")
	@Override
	public void store(Map<String, Object> map, Object object) {
		if (object instanceof ItemStack) {
			ItemStack item = (ItemStack) object;
			map.remove("durability");
			map.remove("meta");
			map.remove("type");
			map.remove("handle");
			map.put("data", item.getDurability());
			map.put("amount", item.getAmount());
			map.put("name", Mine.getName(item));
			map.put("lore", Extra.toConfigMessages(Mine.getLore(item)));
			String enchants = "";
			if (item.getItemMeta().hasEnchants()) {
				StringBuilder str = new StringBuilder();
				int id = 0;
				for (Entry<Enchantment, Integer> entry : item.getEnchantments().entrySet()) {
					if (id > 0)
						str.append(", ");
					Enchantment enchantment = entry.getKey();
					id++;
				}
				enchants = str.toString();
			}
			map.put("enchants", enchants);
		}

	};

}
