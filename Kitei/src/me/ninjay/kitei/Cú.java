package me.ninjay.kitei;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Cú implements Listener{
	
	@EventHandler
	public void quebrar(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();
		
		if(b.getType() == Material.ENDER_STONE) {
			p.sendMessage("oi");
		}
	}

}
