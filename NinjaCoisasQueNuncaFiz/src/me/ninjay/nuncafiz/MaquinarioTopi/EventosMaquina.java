package me.ninjay.nuncafiz.MaquinarioTopi;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.nuncafiz.main.Main;
import me.ninjay.nuncafiz.utils.BukkitConfig;
import me.ninjay.nuncafiz.utils.Mine;

public class EventosMaquina implements Listener {

	public static BukkitConfig maquina = new BukkitConfig("maquina.yml", Main.getPlugin(Main.class));
    
	
	@EventHandler
	public static void aoColocar(BlockPlaceEvent e) {
		if (e.getItemInHand().isSimilar(ComandoDarMaquina.maquina)) {
			e.getPlayer().sendMessage("§cVocê posicionou a máquina nas cordenadas " + e.getBlock().getX() + " / "
					+ e.getBlock().getY() + " / " + e.getBlock().getZ());
			maquina.set(e.getPlayer().getName(), e.getBlock().getLocation());
			maquina.saveConfig();
			double x = e.getBlock().getX()+0.5;
			double y = e.getBlock().getY()-0.5;
			double z = e.getBlock().getZ()+0.5;
			Location l = new Location(e.getPlayer().getWorld(), x, y, z);
			Mine.newHologram(l, "§eMáquina de §6"+e.getPlayer().getName());
		}
	}

	@EventHandler
	public static void aoClicar(PlayerInteractEvent e) {
		Player p = e.getPlayer();  
        new BukkitRunnable() {

			@Override
			public void run() {
				if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					if (e.getClickedBlock().getX() == maquina.getLocation(p.getName()).getX()) {
						if (e.getClickedBlock().getY() == maquina.getLocation(p.getName()).getY()) {
							if (e.getClickedBlock().getZ() == maquina.getLocation(p.getName()).getZ()) {
								p.sendMessage("§cMenu em manutenção");
							}
						}
					}
				}
			}
		}.runTaskLater(Main.getPlugin(Main.class), 1);
	}
	
	@EventHandler
	public static void aoRemover(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(e.getBlock().getLocation().getX() == maquina.getLocation(p.getName()).getX()) {
			if(e.getBlock().getLocation().getY() == maquina.getLocation(p.getName()).getY()) {
				if(e.getBlock().getLocation().getZ() == maquina.getLocation(p.getName()).getZ()) {
					e.setCancelled(true);
					e.getBlock().setType(Material.AIR);
					for(ArmorStand holo : p.getWorld().getEntitiesByClass(ArmorStand.class)) {
						if(holo.getCustomName().contains(p.getName())) {
							holo.remove();
							break;
						}
					}
					p.getWorld().dropItem(e.getBlock().getLocation(), ComandoDarMaquina.maquina);
					p.sendMessage("§cMáquina removida !");
					Location l = new Location(p.getWorld(), e.getBlock().getLocation().getX(), e.getBlock().getLocation().getY()+3000, e.getBlock().getLocation().getZ());
				    maquina.set(p.getName(), l);
				    maquina.saveConfig();
				}else {
					return;
				}
			}else {
				return;
			}
		}else {
			return;
		}
	}
}
