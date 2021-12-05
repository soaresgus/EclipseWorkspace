package me.ninjay.oneperfil.eventos;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import me.ninjay.oneperfil.estruturas.BlocosAPI;
import me.ninjay.oneperfil.estruturas.DataAPI;
import me.ninjay.oneperfil.estruturas.StatsAPI;
import me.ninjay.oneperfil.main.Main;

public class EventosPerfil implements Listener {

	@EventHandler
	public void Blocos(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (e.getBlock().getType() == Material.LAPIS_ORE) {
			BlocosAPI.addBlocos(p, Main.blocos, (long) 1);
		}
		if (e.getBlock().getType() == Material.LAPIS_BLOCK) {
			BlocosAPI.addBlocos(p, Main.blocos, (long) 1);
		}
		if (e.getBlock().getType() == Material.REDSTONE_ORE) {
			BlocosAPI.addBlocos(p, Main.blocos, (long) 1);
		}
		if (e.getBlock().getType() == Material.REDSTONE_BLOCK) {
			BlocosAPI.addBlocos(p, Main.blocos, (long) 1);
		}
		if (e.getBlock().getType() == Material.DIAMOND_ORE) {
			BlocosAPI.addBlocos(p, Main.blocos, (long) 1);
		}
		if (e.getBlock().getType() == Material.REDSTONE_BLOCK) {
			BlocosAPI.addBlocos(p, Main.blocos, (long) 1);
		}
		if (e.getBlock().getType() == Material.EMERALD_ORE) {
			BlocosAPI.addBlocos(p, Main.blocos, (long) 1);
		}
		if (e.getBlock().getType() == Material.EMERALD_BLOCK) {
			BlocosAPI.addBlocos(p, Main.blocos, (long) 1);
		}
		if (e.getBlock().getType() == Material.IRON_ORE) {
			BlocosAPI.addBlocos(p, Main.blocos, (long) 1);
		}
		if (e.getBlock().getType() == Material.IRON_BLOCK) {
			BlocosAPI.addBlocos(p, Main.blocos, (long) 1);
		}
		if (e.getBlock().getType() == Material.GOLD_ORE) {
			BlocosAPI.addBlocos(p, Main.blocos, (long) 1);
		}
		if (e.getBlock().getType() == Material.GOLD_BLOCK) {
			BlocosAPI.addBlocos(p, Main.blocos, (long) 1);
		}
		if (e.getBlock().getType() == Material.COAL_ORE) {
			BlocosAPI.addBlocos(p, Main.blocos, (long) 1);
		}
		if (e.getBlock().getType() == Material.COAL_BLOCK) {
			BlocosAPI.addBlocos(p, Main.blocos, (long) 1);
		}
	}
	@EventHandler
	public void aoMorrer(PlayerDeathEvent e) {
		Player p = e.getEntity();
		StatsAPI.setMortes(p, Main.kdr, StatsAPI.getMortes(p, Main.kdr)+1);
	}
	@EventHandler
	public void aoMatar(PlayerDeathEvent e) {
		Player p = e.getEntity().getKiller();
		Player d = e.getEntity();
		if(p == null) {
			return;
		}else {
		if(d.getType() == EntityType.PLAYER) {
		StatsAPI.setKills(p, Main.kdr, StatsAPI.getKills(p, Main.kdr)+1);
	}
		}
	}
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		DataAPI.setTempoOnline(p, Main.data);
		DataAPI.getTempoOnline(p, Main.data);
		DataAPI.setUltimoLogin(p, Main.data);
		
	}
	@EventHandler
	public void BlockInv(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getTitle().equals("Perfil de "+p.getName() )) {
			e.setCancelled(true);
		}
	}
	

}