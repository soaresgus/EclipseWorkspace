package me.ninjay.dnamobs.utils;

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

	@Override
	public Object restore(Map<String, Object> map) {
		Material id = (Material) map.get("id");
		int amount = Extra.toInt(map.get("amount"));
		int data = Extra.toInt(map.get("data"));
		@SuppressWarnings("deprecation")
		ItemStack item = new ItemStack(id, amount, (short) data);
		String name = Extra.toChatMessage((String) map.get("name"));
		if (!name.isEmpty()) {
			Mine.setName(item, name);
		}
		@SuppressWarnings("unchecked")
		List<String> lore = Extra.toMessages((List<Object>) map.get("lore"));
		if (!lore.isEmpty()) {
			Mine.setLore(item, lore);
		}
		String enchants = (String) map.get("enchants");
		if (!enchants.isEmpty()) {
			if (enchants.contains(", ")) {
				String[] split = enchants.split(", ");
				for (String enchs : split) {
					String[] sub = enchs.split("-");
					@SuppressWarnings("deprecation")
					Integer level = Extra.toInt(sub[1]);

				}
			} else {
				String[] split = enchants.split("-");
				@SuppressWarnings("deprecation")
				Integer level = Extra.toInt(split[1]);

			}
		}
		return item;
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
			map.put("id", item.getType());
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
					str.append(enchantment.getKey() + "-" + entry.getValue());
					id++;
				}
				enchants = str.toString();
			}
			map.put("enchants", enchants);
		}

	};

}
