package me.ninjay.kustmanutencao.estruturas;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.ninjay.kustmanutencao.comandos.ComandoReiniciar;

public class EventosGeral implements Listener{
	
	@EventHandler
	public void onDano(EntityDamageEvent e) {
		if(ComandoReiniciar.ocorrendo == true) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDanoPlayer(EntityDamageByEntityEvent e) {
		if(ComandoReiniciar.ocorrendo == true) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBloco(BlockPlaceEvent e) {
		if(ComandoReiniciar.ocorrendo == true) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void aoBootar(BlockBreakEvent e) {
		if(ComandoReiniciar.ocorrendo == true) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(ComandoReiniciar.ocorrendo == true) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void aoNascer(EntitySpawnEvent e) {
		if(e.getEntityType() != EntityType.PLAYER) {
			if(e.getEntityType() != EntityType.DROPPED_ITEM) {
				if(ComandoReiniciar.ocorrendo == true) {
					e.setCancelled(true);
				}
			}
		}
	}

}
