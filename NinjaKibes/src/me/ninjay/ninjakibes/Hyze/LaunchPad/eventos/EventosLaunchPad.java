package me.ninjay.ninjakibes.Hyze.LaunchPad.eventos;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.ninjakibes.estruturas.ItemAPI;
import me.ninjay.ninjakibes.main.Main;

public class EventosLaunchPad implements Listener {

	public static HashMap<Player, Location> hash = new HashMap<>();
	@EventHandler
	public static void aoAndar(PlayerMoveEvent e) {
		Player p = e.getPlayer();
          if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SLIME_BLOCK) {
        	  new BukkitRunnable() {
				
				@Override
				public void run() {
					p.setVelocity(p.getLocation().getDirection().multiply(5));
				}
			}.runTaskLater(Main.getPlugin(Main.class), 1);
			
		}

	}
	
	@EventHandler
	public static void aoColocar(BlockPlaceEvent e) {
		if(e.getPlayer().getItemInHand().isSimilar(ItemAPI.teste)) {
			e.getPlayer().sendMessage("teste com similar");
		    hash.put(e.getPlayer(), e.getBlock().getLocation());
		}
	}
	
	@EventHandler
	public static void aoClicar(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getClickedBlock().getLocation() == hash.get(e.getPlayer())) {
				e.getPlayer().sendMessage("tae GARAIU");
			}
		}
	}
}
