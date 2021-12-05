package me.ninjay.kustspawners.eventos;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.massivecraft.factions.entity.BoardColl;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.FactionColl;
import com.massivecraft.factions.entity.TemporaryBoard;
import com.massivecraft.massivecore.ps.PS;

import me.ninjay.kustspawners.main.Main;
import me.ninjay.kustspawners.utils.Mine;

public class EventosGeral implements Listener {

	public static HashMap<Location, Integer> tempo = new HashMap<>();
	
	@EventHandler
	public void protection(BlockPlaceEvent e) {
		Player p = e.getPlayer();

		if (e.getBlock().getType() == Material.MOB_SPAWNER) {
			if (e.getBlock().getRelative(BlockFace.NORTH).getType() == Material.OBSIDIAN
					|| e.getBlock().getRelative(BlockFace.NORTH).getType() == Material.ENDER_STONE
					|| e.getBlock().getRelative(BlockFace.NORTH).getType() == Material.BEDROCK) {
				e.setCancelled(true);
				p.sendMessage("§cVocê não pode colocar spawners ao lado de blocos de proteção.");
			}
			if (e.getBlock().getRelative(BlockFace.SOUTH).getType() == Material.OBSIDIAN
					|| e.getBlock().getRelative(BlockFace.SOUTH).getType() == Material.ENDER_STONE
					|| e.getBlock().getRelative(BlockFace.SOUTH).getType() == Material.BEDROCK) {
				e.setCancelled(true);
				p.sendMessage("§cVocê não pode colocar spawners ao lado de blocos de proteção.");
			}
			if (e.getBlock().getRelative(BlockFace.EAST).getType() == Material.OBSIDIAN
					|| e.getBlock().getRelative(BlockFace.EAST).getType() == Material.ENDER_STONE
					|| e.getBlock().getRelative(BlockFace.EAST).getType() == Material.BEDROCK) {
				e.setCancelled(true);
				p.sendMessage("§cVocê não pode colocar spawners ao lado de blocos de proteção.");
			}
			if (e.getBlock().getRelative(BlockFace.WEST).getType() == Material.OBSIDIAN
					|| e.getBlock().getRelative(BlockFace.WEST).getType() == Material.ENDER_STONE
					|| e.getBlock().getRelative(BlockFace.WEST).getType() == Material.BEDROCK) {
				e.setCancelled(true);
				p.sendMessage("§cVocê não pode colocar spawners ao lado de blocos de proteção.");
			}
		}
		if (e.getBlock().getType() == Material.OBSIDIAN || e.getBlock().getType() == Material.BEDROCK
				|| e.getBlock().getType() == Material.ENDER_STONE) {
			if (e.getBlock().getRelative(BlockFace.NORTH).getType() == Material.MOB_SPAWNER) {
				e.setCancelled(true);
				p.sendMessage("§cVocê não pode colocar blocos de proteção ao lado de spawners.");
			}
			if (e.getBlock().getRelative(BlockFace.SOUTH).getType() == Material.MOB_SPAWNER) {
				e.setCancelled(true);
				p.sendMessage("§cVocê não pode colocar blocos de proteção ao lado de spawners.");
			}
			if (e.getBlock().getRelative(BlockFace.EAST).getType() == Material.MOB_SPAWNER) {
				e.setCancelled(true);
				p.sendMessage("§cVocê não pode colocar blocos de proteção ao lado de spawners.");
			}
			if (e.getBlock().getRelative(BlockFace.WEST).getType() == Material.MOB_SPAWNER) {
				e.setCancelled(true);
				p.sendMessage("§cVocê não pode colocar blocos de proteção ao lado de spawners.");
			}
		}
	}

	@EventHandler
	public void terreno(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		PS ps = PS.valueOf(p.getLocation());
		boolean temporario = TemporaryBoard.get().isTemporary(ps);
		Faction fac = BoardColl.get().getFactionAt(ps);
		Faction zonalivre = FactionColl.get().getNone();

		if (e.getBlock().getType() == Material.MOB_SPAWNER) {
			if (temporario == true) {
				e.setCancelled(true);
				p.sendMessage("§cVocê não pode colocar spawners em terrenos temporários.");
			}
			if (fac == zonalivre) {
				e.setCancelled(true);
				p.sendMessage("§cVocê não pode colocar spawners na Zona Livre.");
			}

		}

	}
	
	@EventHandler
	public void aoNascer(SpawnerSpawnEvent e) {
		Entity et = e.getEntity();
		PS ps = PS.valueOf(et.getLocation());
		Faction fac = BoardColl.get().getFactionAt(ps);
		Faction zonalivre = FactionColl.get().getNone();
		boolean temporario = TemporaryBoard.get().isTemporary(ps);
		
		if(fac == zonalivre || temporario == true) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void delayPor(BlockPlaceEvent e) {
		if(e.getBlock().getType() == Material.MOB_SPAWNER) {
			tempo.remove(e.getBlock().getLocation());
			tempo.put(e.getBlock().getLocation(), 60);
			new BukkitRunnable() {
				int i = tempo.get(e.getBlock().getLocation());
				@Override
				public void run() {
					i--;
					tempo.put(e.getBlock().getLocation(), i);
					if(tempo.get(e.getBlock().getLocation()) <= 0) {
						cancel();
						tempo.remove(e.getBlock().getLocation());
					}
				}
			}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
		}
	}
	
	@EventHandler
	public void delayTirar(BlockBreakEvent e) {
		if(e.getBlock().getType() == Material.MOB_SPAWNER) {
			if(tempo.containsKey(e.getBlock().getLocation())) {
				e.setCancelled(true);
				e.getPlayer().sendMessage("§cAguarde "+tempo.get(e.getBlock().getLocation())+" segundos para retirar esse spawner.");
			}
		}
	}
	
	@EventHandler
	public void onComando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		
		if(e.getMessage().equalsIgnoreCase("/f setspawn")) {
			e.setCancelled(true);
			p.chat("/setmob");
		}
	}
	
}
