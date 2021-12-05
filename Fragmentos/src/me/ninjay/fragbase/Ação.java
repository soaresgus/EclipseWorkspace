package me.ninjay.fragbase;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Ação implements Listener{
	
	@EventHandler
	public void quebrar(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		ItemStack f = new ItemStack(Material.QUARTZ);
		ItemMeta fmeta = f.getItemMeta();
		fmeta.setDisplayName("§eFragmento");
		fmeta.setLore(Arrays.asList("§7Utilize esse item para trocar por outros itens no spawn."));
		fmeta.addEnchant(Enchantment.DURABILITY, 1, false);
		f.setItemMeta(fmeta);
		
		if(b.getType() == Material.ENDER_STONE) {
			p.getInventory().addItem(f);
			p.getWorld().playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
		}
		
	}

}
