package me.ninjay.ninjarankup.utils;

import org.bukkit.event.inventory.InventoryClickEvent;
/**
 * Efeito quando clicar
 * @author Eduard
 *
 */
public interface ClickEffect {
	public void onClick(InventoryClickEvent event, int page);
}
