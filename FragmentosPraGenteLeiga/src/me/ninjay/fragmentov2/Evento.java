package me.ninjay.fragmentov2;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Evento implements Listener{
	
	@EventHandler
	public void frag(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		if(b.getType() == Material.ENDER_STONE) {
			p.sendMessage("oi");
			return;
		}
	}

}
