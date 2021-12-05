package me.ninjay.oneperfil.mvp.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.oneperfil.main.Main;
import me.ninjay.oneperfil.mvp.estruturas.EstruturaJogador;
import net.eduard.api.lib.modules.VaultAPI;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand.EnumClientCommand;

public class EventosMvP implements Listener {

	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if (Main.dentro.contains(p)) {
			e.setCancelled(true);
			p.sendMessage("§cNão é permitido utilizar comandos no evento.");
		} else {
			return;
		}
	}

	@EventHandler
	public void aoSair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (Main.dentro.contains(p)) {
			Main.dentro.remove(p);
			Main.fora2.add(p);
			VaultAPI.getPermission().playerRemove(p, "mvp.jogando");
		}
	}

	@EventHandler
	public void autoRespawn(PlayerDeathEvent e) {
		Player p = e.getEntity();

		PacketPlayInClientCommand pacote = new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN);
		CraftPlayer c = (CraftPlayer) p;
		new BukkitRunnable() {

			@Override
			public void run() {

				c.getHandle().playerConnection.a(pacote);

			}
		}.runTaskLater(Main.getPlugin(Main.class), 1);
	}

	@EventHandler
	public void aoMorrer(PlayerDeathEvent e) {
		Player p = e.getEntity();

		if (Main.dentro.contains(p)) {
			EstruturaJogador.morrer(p);
			Main.fora.add(p);
			Main.dentro.remove(p);
			VaultAPI.getPermission().playerRemove(p, "mvp.jogando");
		}

	}

	@EventHandler
	public void aoMatar(EntityDeathEvent e) {
		Entity d = e.getEntity();
		Player k = e.getEntity().getKiller();
		if (Main.dentro.contains(k)) {
			if (d.getType() == EntityType.SKELETON) {
				k.sendMessage("§e+10 Coins");
				Mine.sendActionBar(k, "§e+10 Coins");
				VaultAPI.getEconomy().depositPlayer(k, 10);
			}
		}
		if (Main.dentro.contains(k)) {
			if (d.getType() == EntityType.WOLF) {
				k.sendMessage("§e+10 Coins");
				Mine.sendActionBar(k, "§e+10 Coins");
				VaultAPI.getEconomy().depositPlayer(k, 10);

			}
		}
		if(Main.dentro.contains(k)) {
			if(d.getType() == EntityType.GIANT) {
				k.sendMessage("§eVocê conseguiu matar o gigante final !");
				
				k.getWorld().dropItem(d.getLocation(), Mine.newItem(Material.GOLDEN_CARROT, "hmm"));
				k.getWorld().dropItem(d.getLocation(), Mine.newItem(Material.STONE, "hmm"));
				k.getWorld().dropItem(d.getLocation(), Mine.newItem(Material.DIRT, "hmm"));
				k.getWorld().dropItem(d.getLocation(), Mine.newItem(Material.BRICK, "hmm"));
				k.getWorld().dropItem(d.getLocation(), Mine.newItem(Material.IRON_ORE, "hmm"));
				k.getWorld().dropItem(d.getLocation(), Mine.newItem(Material.EMERALD, "hmm"));
				k.getWorld().dropItem(d.getLocation(), Mine.newItem(Material.GOLD_HOE, "hmm"));
				k.getWorld().dropItem(d.getLocation(), Mine.newItem(Material.CHEST, "hmm"));
				k.getWorld().dropItem(d.getLocation(), Mine.newItem(Material.BOAT, "hmm"));
				k.getWorld().dropItem(d.getLocation(), Mine.newItem(Material.BONE, "hmm"));
				k.getWorld().dropItem(d.getLocation(), Mine.newItem(Material.CLAY, "hmm"));
				k.getWorld().dropItem(d.getLocation(), Mine.newItem(Material.DIAMOND_HOE, "hmm"));
				k.getWorld().dropItem(d.getLocation(), Mine.newItem(Material.GOLD_ORE, "hmm"));
				k.getWorld().dropItem(d.getLocation(), Mine.newItem(Material.DIAMOND, "hmm"));
				k.getWorld().dropItem(d.getLocation(), Mine.newItem(Material.BEACON, "hmm"));
				
				k.getWorld().playSound(k.getLocation(), Sound.ENDERDRAGON_DEATH, 1F, 1F);
				Bukkit.broadcastMessage("§e§lEvento - Mobs Vs Players\n \n§e["+k.getName()+"] Matou o gigante no evento MvP !\n \nPvP ativo durante 10 minutos até o final do evento, boa sorte !\n ");
				Main.wins.set(k.getName()+"_mvp", Main.wins.getLong(k.getName()+"_mvp"+1));
				Main.wins.saveConfig();
				new BukkitRunnable() {
					int i = 600;
					@Override
					public void run() {
						i--;
						if(i==599) {
							for(Player todos2 : Bukkit.getOnlinePlayers()) {
								if(todos2.hasPermission("mvp.pvp")) {
									todos2.getWorld().setPVP(true);
								}
							}
						}
						if(i==0) {
							cancel();
							Bukkit.broadcastMessage("§6§lEvento - Mobs Vs Players\n \n§6Evento finalizado.");
							for(Player todos : Bukkit.getOnlinePlayers()) {
								if(todos.hasPermission("mvp.jogando")) {
								
								VaultAPI.getPermission().playerRemove(todos, "mvp.jogando");
								Main.dentro.remove(todos);
								Main.fora.remove(todos);
								Main.tempo = null;
								VaultAPI.getPermission().playerRemove(todos, "mvp.pvp");
								todos.teleport(Main.mvp.getLocation("morte_mvp"));
						}
							}
						}
						
					}
				}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
				
		

}
		}
	}
	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		if(Main.dentro.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void aoColocar(BlockPlaceEvent e) {
		if(Main.dentro.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}
}
