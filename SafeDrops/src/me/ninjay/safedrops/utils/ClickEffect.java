package me.ninjay.safedrops.utils;

import org.bukkit.event.inventory.InventoryClickEvent;
/**
 * Efeito quando clicar
 * @author Eduard
 *
 */
public interface ClickEffect {
	public void onClick(InventoryClickEvent event, int page);
}
