package me.ninjay.kustscoreboard.eventos;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.massivecraft.factions.entity.BoardColl;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.FactionColl;
import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.factions.entity.TemporaryBoard;
import com.massivecraft.massivecore.ps.PS;
import com.nametagedit.plugin.NametagEdit;

import me.ninjay.kustscoreboard.main.Main;
import me.ninjay.kusttags.estruturas.TagsAPI;
import me.ninjay.kusttags.estruturas.TagsControler;

public class EventosScore implements Listener{
	
	@EventHandler
	public void aoQueda(EntityDamageEvent e) {
		if(e.getEntityType() == EntityType.PLAYER) {
			PS ps = PS.valueOf(e.getEntity().getLocation());
			Faction fac = BoardColl.get().getFactionAt(ps);
			Faction zonapro = FactionColl.get().getSafezone();
			Faction zonague = FactionColl.get().getWarzone();
			
			if(fac == zonapro || fac == zonague) {
				if(e.getCause() == DamageCause.FALL) {
					e.setCancelled(true);
				}
			}
		}
	}
	
	
	@EventHandler
	public void aoAbrirVillager(PlayerInteractAtEntityEvent e) {
		if(e.getRightClicked() != null) {
			if(e.getRightClicked().getType() == EntityType.VILLAGER) {
				e.getPlayer().getOpenInventory().close();
				e.setCancelled(true);
			}
		}
	}
	@EventHandler
	public void onCommando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		
		if(e.getMessage().equalsIgnoreCase("/f info znp")) {
			e.setCancelled(true);
			p.sendMessage("§cNenhuma facção encontrada com a tag 'ZNP'");
		}
		if(e.getMessage().equalsIgnoreCase("/f info zng")) {
			e.setCancelled(true);
			p.sendMessage("§cNenhuma facção encontrada com a tag 'ZNG'");
		}
	}
	
	@EventHandler
	public void onSpawn(EntitySpawnEvent e) {
		if(e.getEntityType() != EntityType.PLAYER) {
			if(e.getEntityType() != EntityType.DROPPED_ITEM) {
				PS ps = PS.valueOf(e.getEntity().getLocation());
				Faction fac = BoardColl.get().getFactionAt(ps);
				Faction zonapro = FactionColl.get().getSafezone();
				Faction zonague = FactionColl.get().getWarzone();
				
				if(fac == zonapro || fac == zonague) {
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onBau(PlayerInteractEvent e) {
		PS ps = PS.valueOf(e.getPlayer().getLocation());
		Faction fac = BoardColl.get().getFactionAt(ps);
		Faction zonapro = FactionColl.get().getSafezone();
		Faction zonague = FactionColl.get().getWarzone();
			
		if(fac == zonapro || fac == zonague) {
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(e.getClickedBlock().getType() == Material.CHEST || e.getClickedBlock().getType() == Material.TRAPPED_CHEST) {
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		
		if(p.getWorld().getName().equalsIgnoreCase("vipmundo") || p.getWorld().getName().equalsIgnoreCase("vip") || p.getWorld().getName().equalsIgnoreCase("mundovip")) {
			if(e.getMessage().contains("/tpaccept") || e.getMessage().contains("/tpaceitar")) {
				e.setCancelled(true);
				p.chat("/tpdeny");
			}
		}
	}
}
