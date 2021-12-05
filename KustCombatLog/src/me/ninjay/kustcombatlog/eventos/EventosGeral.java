package me.ninjay.kustcombatlog.eventos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.massivecraft.factions.entity.BoardColl;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.FactionColl;
import com.massivecraft.massivecore.ps.PS;

import me.ninjay.kustcombatlog.main.Main;
import me.ninjay.kustcombatlog.utils.Mine;

public class EventosGeral implements Listener{
	
	public static HashMap<Player, Integer> save = new HashMap<>();
	public static ArrayList<Player> combate = new ArrayList<>();
	public static HashMap<Player, Boolean> savedano = new HashMap<>();
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onDano(EntityDamageEvent e) {
		
		if(e.getEntity().getType() == EntityType.PLAYER) {
			if(e.getCause() != DamageCause.FALL) {
				Player p = (Player) e.getEntity();
				if(e.isCancelled() == true) {
					savedano.put(p, false);
				}else {
					savedano.put(p, true);
				}
			}
		}
	}
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {

	if(e.getEntity().getType() == EntityType.PLAYER) {
		if(e.getDamager().getType() == EntityType.PLAYER) {
			Player p = (Player) e.getEntity();
			Player j = (Player) e.getDamager();
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(savedano.get(p) == true) {
			PS ps = PS.valueOf(e.getEntity().getLocation());
			Faction fac = BoardColl.get().getFactionAt(ps);
			Faction zonapro = FactionColl.get().getSafezone();
			if(fac != zonapro) {
			save.remove(p);
			save.remove(j);
			save.put(j, 15);
			save.put(p, 15);
			p.getOpenInventory().close();
			j.getOpenInventory().close();
		if(!combate.contains(p)) {
			p.sendMessage("§cVocê entrou em combate com §7"+j.getName()+"§c, não deslogue!");
		}
		if(!combate.contains(j)) {
			j.sendMessage("§cVocê entrou em combate com §7"+p.getName()+"§c, não deslogue!");
		}
			
		if(!combate.contains(p)) {
			combate.add(p);
			new BukkitRunnable() {
				int i = save.get(p);
				@Override
				public void run() {
				if(save.get(p) != null) {
					i = save.get(p);
				}else {
					cancel();
					save.remove(p);
				}
					i--;
					save.put(p, i);
					Mine.sendActionBar(p, "§cVocê está em combate por mais "+i+" segundos!");
					if(save.get(p) <= 0) {
						cancel();
						save.remove(p);
						combate.remove(p);
						p.sendMessage("§aVocê saiu de combate.");
					}
				}
			}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
		}else {
			save.remove(p);
			save.put(p, 15);
		}
		if(!combate.contains(j)) {
			combate.add(j);
			new BukkitRunnable() {
				int i = save.get(j);
				@Override
				public void run() {
					if(save.get(j) != null) {
						i = save.get(j);
					}else {
						cancel();
						save.remove(j);
					}
					i--;
					save.put(j, i);
					Mine.sendActionBar(j, "§cVocê está em combate por mais "+i+" segundos!");
					if(save.get(j) <= 0) {
						cancel();
						save.remove(j);
						combate.remove(j);
						j.sendMessage("§aVocê saiu de combate.");
					}
				}
			}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
		}else {
			save.remove(j);
			save.put(j, 15);
		}
		}
					}
		}
	}.runTaskLater(Main.getPlugin(Main.class), 1);
		}
		}
	}
	
	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		
	if(save.get(p) != null) {
		if(save.containsKey(p)) {
			if(!p.hasPermission("combate.bypass")) { 
			e.setCancelled(true);
			p.sendMessage("§cVocê não pode usar comandos em combate.");
			}
		}
	}
	}
	
	@EventHandler
	public void onTeleport(PlayerTeleportEvent e) {
		Player p = e.getPlayer();
		
	if(save.containsKey(p)) {
		if(e.getCause().equals(TeleportCause.ENDER_PEARL)) {
			if(!p.hasPermission("combate.bypass")) {
			e.setCancelled(true);
			p.sendMessage("§cVocê não pode se teleportar em combate.");
			}
		}
	}
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void aoSair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		if(save.containsKey(p)) {
			for(ItemStack itens : p.getInventory().getContents()) {
				if(itens != null) {
					if(itens.getType() != Material.AIR) {
						p.getWorld().dropItem(p.getLocation(), itens);
					}
				}
			}
			for(ItemStack armor : p.getInventory().getArmorContents()) {
				if(armor != null) {
					if(armor.getType() != Material.AIR) {
						p.getWorld().dropItem(p.getLocation(), armor);
					}
				}
			}
			Mine.clearInventory(p);
			Bukkit.broadcastMessage("§c"+p.getName()+" desconectou em combate, que pena...");
			
		}
	}

}
