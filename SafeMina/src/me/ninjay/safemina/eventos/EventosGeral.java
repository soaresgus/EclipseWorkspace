package me.ninjay.safemina.eventos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.safemina.main.Main;
import me.ninjay.safemina.utils.Mine;
import me.ninjay.safemina.utils.VaultAPI;

public class EventosGeral implements Listener {

	public static ArrayList<Block> quebrados = new ArrayList<>();
	public static HashMap<Player, Location> loc = new HashMap<>();
	private static ArrayList<Player> dano = new ArrayList<>();
	
	@EventHandler
	public void aoDano(EntityDamageEvent e) {
		if (e.getEntity().getWorld().getName().equals(Main.config.getString("MundoEscavar"))
				|| e.getEntity().getWorld().getName().equals(Main.config.getString("MundoMina"))) {
			e.setCancelled(true);
		}
		if(dano.contains(e.getEntity())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void aoColocar(BlockPlaceEvent e) {
		if (e.getPlayer().getWorld().getName().equals(Main.config.getString("MundoEscavar"))
				|| e.getPlayer().getWorld().getName().equals(Main.config.getString("MundoMina"))) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		if (e.getPlayer().isOp() == false) {
			if (e.getPlayer().getWorld().getName().equals(Main.config.getString("MundoEscavar"))
					|| e.getPlayer().getWorld().getName().equals(Main.config.getString("MundoMina"))) {
				if (!(e.getMessage().contains("/spawn") || e.getMessage().contains("/vip")
						|| e.getMessage().contains("/l") || e.getMessage().contains("/g"))) {
					e.getPlayer().sendMessage("§cApenas comandos básicos liberados nesse mundo.");
					e.setCancelled(true);
					return;
				} else {
					e.setCancelled(false);
					return;
				}
			}
		} else {
			return;
		}
	}

	@EventHandler
	public void aoSair(PlayerTeleportEvent e) {
		if (e.getPlayer().getWorld().getName().equals(Main.config.getString("MundoEscavar"))
				|| e.getPlayer().getWorld().getName().equals(Main.config.getString("MundoMina"))) {
			e.getPlayer().getInventory().clear();
			dano.add(e.getPlayer());
			new BukkitRunnable() {
				
				@Override
				public void run() {
					dano.remove(e.getPlayer());
				}
			}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 10);
		}
	}
	

	public static Double formatarDouble(Double valor, String formatacao) {
		DecimalFormat df = new DecimalFormat(formatacao);
		return Mine.toDouble(df.format(valor));
	}

	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		if (e.getPlayer().getWorld().getName().equals(Main.config.getString("MundoEscavar"))) {
			if (e.getBlock().getType() == Material.SAND) {
				quebrados.add(e.getBlock());

				Double v = Mine.getRandomDouble(Main.config.getDouble("EscavarMin"),
						Main.config.getDouble("EscavarMax"));

				VaultAPI.getEconomy().depositPlayer(e.getPlayer(), v);
				Mine.sendTitle(e.getPlayer(), " ", "§a+" + formatarDouble(v, "#.##"), 0, 15, 0);
			}
		}
	}

	@EventHandler
	public void aoQuebrarMina(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (e.getPlayer().getWorld().getName().equals(Main.config.getString("MundoMina"))) {
			if (e.getBlock().getType() == Material.STONE) {
				e.getBlock().getDrops().clear();
				Double v = Mine.getRandomDouble(Main.config.getDouble("MinaMin"), Main.config.getDouble("MinaMax"));

				VaultAPI.getEconomy().depositPlayer(e.getPlayer(), v);
				Mine.sendTitle(e.getPlayer(), " ", "§a+" + formatarDouble(v, "#.##"), 0, 15, 0);

			}
		}
	}

	@EventHandler
	public void aoTeleport(PlayerTeleportEvent e) {
		Player p = e.getPlayer();
		if(loc.containsKey(p)) {
		if (e.getPlayer().getWorld().getName().equals(Main.config.getString("MundoMina"))) {
			Bukkit.getWorld(Main.config.getString("MundoMina")).createExplosion(loc.get(p), 80F);
		}
		}
	}
	
	@EventHandler
	public void aoDisconect(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (e.getPlayer().getWorld().getName().equals(Main.config.getString("MundoMina"))) {
			Bukkit.getWorld(Main.config.getString("MundoMina")).createExplosion(loc.get(p), 80F);
		}
	}

}
