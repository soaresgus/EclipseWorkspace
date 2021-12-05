package me.ninjay.poo.eventos;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClasseDeEnchant implements Listener{
	
	@SuppressWarnings("deprecation")
    @EventHandler
    public void click(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getClickedInventory().equals(player.getInventory())) {
            ItemStack cursor = event.getCursor();
            ItemStack item = event.getCurrentItem();
            if (cursor != null) {
                if (cursor.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
                    if (item != null) {
                        if (item.getType() != Material.AIR) {
                            if (!item.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
                            	item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
                                event.setCancelled(true);
                                event.setCursor(null);
                                player.sendMessage("§aEncantamento aplicado com sucesso.");
                            } else {
                                player.sendMessage("§cVocê já tem este encantamento aplicado a este item.");
                            }
                        }
                    }
                }
            }
        }
    }

}
