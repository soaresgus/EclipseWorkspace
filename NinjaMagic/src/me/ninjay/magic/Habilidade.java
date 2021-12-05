package me.ninjay.magic;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Habilidade implements Listener{
	
	public void clicar(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		
		ItemStack item = new ItemStack(Material.BLAZE_ROD);
		ItemMeta imeta = item.getItemMeta();
		imeta.setDisplayName("§eCajado de mago");
		imeta.setLore(Arrays.asList("§7Clique esquerdo para mudar a magia","§7Clique direito para usar a magia"," ", "§cAtenção o cajado só pode ser utilizado §c§luma §cvez."));
		imeta.addEnchant(Enchantment.DURABILITY, 1, false);
		item.setItemMeta(imeta);
		if(p.getItemInHand().isSimilar(item) && a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK && !p.hasPermission("thunder.use")) {
			p.sendMessage("§aHabilidade do cajado trocada para §a§lTrovão§a.");
		}
		if(!p.getItemInHand().isSimilar(item)) {
			
		
		return;
	}
	

}
}