package me.ninjay.sla;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Bloco implements Listener,CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    if(cmd.getName().equalsIgnoreCase("darbloco")) {
	    	if(!(sender instanceof Player)) {
	    		sender.sendMessage("§6§lApenas Players");
	    	}else {
	    		Player p = (Player)sender;
	    		if(!p.hasPermission("darbloco.use")) {
	    			p.sendMessage("§6§lSem permissão");
	    			return true;
	    		}
	    		if(p.hasPermission("darbloco.use")) {
	    			ItemStack b = new ItemStack(Material.IRON_BLOCK);
	    			ItemMeta bm = b.getItemMeta();
	    			bm.setDisplayName("§eGerador de trovão");
	    			bm.setLore(Arrays.asList("§7Utilize esse item para gerar trovões"));
	    			bm.addEnchant(Enchantment.DURABILITY, 1, false);
	    		    b.setItemMeta(bm);
	    		    p.getInventory().addItem(b);
	    		    p.sendMessage("§eGerador de trovão recebido !");
	    		    return true;
	    		}
	    	}
	    }
 		return false;
	}
@EventHandler
public void bloco(BlockPlaceEvent e) {
	Player p = e.getPlayer();
	org.bukkit.block.Block b2 = e.getBlock();

	
	
	
	if(b2.getType() == Material.IRON_BLOCK ) {
		p.getWorld().strikeLightningEffect(p.getLocation());
		return;
		
	}
	
}
	
}
