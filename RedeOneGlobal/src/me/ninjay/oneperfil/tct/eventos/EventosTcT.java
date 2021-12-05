package me.ninjay.oneperfil.tct.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.oneperfil.main.Main;
import me.ninjay.oneperfil.tct.estruturas.EstruturaJogador;
import net.eduard.api.lib.modules.VaultAPI;

public class EventosTcT implements Listener {
	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if (Main.dentro2.contains(p)) {
			e.setCancelled(true);
			p.sendMessage("§cNão é permitido utilizar comandos no evento.");
		} else {
			return;
		}
	}

	@EventHandler
	public void aoSair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (Main.dentro2.contains(p)) {
			Main.dentro2.remove(p);
			Main.fora2.add(p);
			p.setHealth(0);
			VaultAPI.getPermission().playerRemove(p, "tct.jogando");
		}
	}

	@EventHandler
	public void aoMorrer(PlayerDeathEvent e) {
		Player p = e.getEntity();

		new BukkitRunnable() {
			@Override
			public void run() {
				if (Main.dentro2.contains(p)) {
					Main.dentro2.remove(p);
					EstruturaJogador.morrer(p);
					Main.fora2.add(p);
					VaultAPI.getPermission().playerRemove(p, "tct.jogando");
				}
			}
		}.runTask(Main.getPlugin(Main.class));

	}
	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		if(Main.dentro2.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void aoColocar(BlockPlaceEvent e) {
		if(Main.dentro2.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}
}
