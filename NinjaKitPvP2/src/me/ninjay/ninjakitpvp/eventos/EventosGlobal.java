package me.ninjay.ninjakitpvp.eventos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.ninjakitpvp.comandos.admin.ComandoBuild;
import me.ninjay.ninjakitpvp.estruturas.CoinsAPI;
import me.ninjay.ninjakitpvp.estruturas.InfoAPI;
import me.ninjay.ninjakitpvp.estruturas.ItemAPI;
import me.ninjay.ninjakitpvp.estruturas.LocationsAPI;
import me.ninjay.ninjakitpvp.main.Main;
import me.ninjay.ninjakitpvp.utils.Mine;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand.EnumClientCommand;

public class EventosGlobal implements Listener {

	public static ArrayList<Player> spawn = new ArrayList<>();

	@EventHandler
	public void sopa(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (p.getItemInHand().getType() == Material.MUSHROOM_SOUP) {
				if (p.getHealth() != p.getMaxHealth()) {
					if (p.getHealth() >= p.getMaxHealth() - Main.global.getDouble("vidaSopa")) {
						p.setHealth(p.getMaxHealth());
						p.getItemInHand().setType(Material.BOWL);
					} else if (p.getHealth() < p.getMaxHealth() - Main.global.getDouble("vidaSopa")) {
						p.setHealth(p.getHealth() + Main.global.getDouble("vidaSopa"));
						p.getItemInHand().setType(Material.BOWL);
					}
				}
			}
		}
	}

	public static void darItens(Player p) {
		Mine.clearInventory(p);
		p.getInventory().setItem(Mine.getPosition(1, 4), ItemAPI.seletor1);
		p.getInventory().setItem(Mine.getPosition(1, 6), ItemAPI.seletor2);
		p.getInventory().setItem(Mine.getPosition(1, 8), ItemAPI.loja);
		p.getInventory().setItem(Mine.getPosition(1, 9), ItemAPI.lojakits);
		p.getInventory().setItem(Mine.getPosition(1, 2), ItemAPI.info);
		p.getInventory().setItem(Mine.getPosition(1, 1), ItemAPI.warps);
		p.updateInventory();
	}

	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(Main.global.getString("mensagemAoEntrar").replace("%nick%", p.getName()).replace("&", "§"));
		darItens(p); 
		spawn.add(p);
		p.setGameMode(GameMode.SURVIVAL);
		p.setAllowFlight(false);
		LocationsAPI.tpLocation(p, "spawn");
		if(Main.global.getBoolean("title") == true) {
			Mine.sendTitle(p, Main.global.getString("titlePrincipal").replace("&", "§"), Main.global.getString("titleSecundario").replace("&", "§"), 5, 100, 5);
		}else if(Main.global.getBoolean("title") == false) {
			return;
		}

	}

	@EventHandler
	public void aoSair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(Main.global.getString("mensagemAoSair").replace("%nick%", p.getName()).replace("&", "§"));
		spawn.remove(p);
	}

	@EventHandler
	public void bussola(PlayerInteractEvent event) {

		Player p = event.getPlayer();
		if (p.getItemInHand().getType() == Material.COMPASS) {

			Boolean found = Boolean.valueOf(false);
			for (int i = 0; i < 1000; i++) {

				List<?> entities = p.getNearbyEntities(i, 2000, i);
				for (Object e : entities) {
					if ((((Entity) e).getType().equals(EntityType.PLAYER))) {

						p.setCompassTarget(((Entity) e).getLocation());
						p.sendMessage("§aBússola apontando para " + ((Player) e).getName() + ".");
						found = Boolean.valueOf(true);
						break;
					}
				}
				if (found.booleanValue()) {
					break;
				}
			}
			if (!found.booleanValue()) {

				p.sendMessage("§cNenhum jogador foi encontrado.");
			}
		}
	}

	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		if (!ComandoBuild.build.contains(e.getPlayer())) {
			e.setCancelled(true);
		}else {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void aoColocar(BlockPlaceEvent e) {
		if (!ComandoBuild.build.contains(e.getPlayer())) {
			e.setCancelled(true);
		}else {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void aoMorrer(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player j = p.getKiller();
		e.setDeathMessage(null);
		PacketPlayInClientCommand pacote = new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN);
		CraftPlayer c = (CraftPlayer) p;
		if(p instanceof Player) {
			if(j instanceof Player) {
		InfoAPI.addKill(j);
		CoinsAPI.add(j, Main.cash, 1);
		InfoAPI.addMorte(p);
			}
		}
		new BukkitRunnable() {

			@Override
			public void run() {
				darItens(p);
				e.setDeathMessage(null);
				spawn.add(p);
				c.getHandle().playerConnection.a(pacote);
				if (LocationsAPI.getConfig().contains("spawn")) {
					LocationsAPI.tpLocation(p, "spawn");
					return;
					
				} else {
					p.sendMessage("§cO spawn não foi setado ainda.");
				}
			}
		}.runTaskLater(Main.getPlugin(Main.class), 2);
		new BukkitRunnable() {

			@Override
			public void run() {
				for (Item drops : p.getWorld().getEntitiesByClass(Item.class)) {
					drops.remove();
				}
			}
		}.runTaskLater(Main.getPlugin(Main.class), 60);

	}

	@EventHandler
	public void aoDano(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			if (spawn.contains(e.getEntity())) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void aoDropar(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if (spawn.contains(p)) {
			e.setCancelled(true);
			return;
		} else {
			e.setCancelled(false);
			new BukkitRunnable() {

				@Override
				public void run() {
					for (Item drops : p.getWorld().getEntitiesByClass(Item.class)) {
						drops.remove();
					}
				}
			}.runTaskLater(Main.getPlugin(Main.class), 60);

		}
	}
}