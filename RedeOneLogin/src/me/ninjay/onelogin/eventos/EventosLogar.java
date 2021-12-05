package me.ninjay.onelogin.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.onelogin.comandos.ComandoLogar;

public class EventosLogar implements Listener {

	@EventHandler
	public static void aoFalar(AsyncPlayerChatEvent e) {
		String c = e.getMessage();
		if (!ComandoLogar.logado.contains(e.getPlayer())) {
			if (c.contains("/login") || c.contains("/register")) {
				e.setCancelled(false);
			} else {
				e.setCancelled(true);
				e.getPlayer().sendMessage("§cVocê precisa estar autentificado para falar no chat.");
			}
		}

	}
	@EventHandler
	public static void aoBussula(PlayerInteractEvent e) {
		if(!ComandoLogar.logado.contains(e.getPlayer())) {
			e.setCancelled(true);
		}else {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public static void aoEntrar(PlayerJoinEvent e) {
		ComandoLogar.logado.remove(e.getPlayer());
		ComandoLogar.tentativas.set(e.getPlayer().getName(),
				ComandoLogar.tentativas.getInt(e.getPlayer().getName()) == 0);
		ComandoLogar.captcha.set(e.getPlayer().getName(), Mine.getRandomInt(1, 1000));
		ComandoLogar.captcha.saveConfig();
		ComandoLogar.tentativas.saveConfig();
	}

	@EventHandler
	public static void aoCaptcha(AsyncPlayerChatEvent e) {

		if (!ComandoLogar.logado.contains(e.getPlayer())) {
			if (ComandoLogar.logou.contains(e.getPlayer())) {
				if (e.getMessage().contains(Mine.toString(ComandoLogar.captcha.getInt(e.getPlayer().getName())))) {
					e.setCancelled(true);
					ComandoLogar.logado.add(e.getPlayer());
					ComandoLogar.tentativas.set(e.getPlayer().getName(), 0);
					ComandoLogar.tentativas.saveConfig();
					for (int d = 0; d < 100; d++) {
						e.getPlayer().sendMessage(" ");
					}
					e.getPlayer().sendMessage("§aCaptcha confirmado com sucesso, tenha um bom jogo !");
				}
			} else if (e.getMessage().contains(Mine.toString(ComandoLogar.captcha.getInt(e.getPlayer().getName())))) {
				e.getPlayer().sendMessage("§cVocê precisa estar autentificado para poder confirmar o captcha.");
			}

		}
	}

	@EventHandler
	public static void aoComando(PlayerCommandPreprocessEvent e) {
		String c = e.getMessage();
		if (!ComandoLogar.logado.contains(e.getPlayer())) {
			if (c.contains("/login") || c.contains("/register")) {
				e.setCancelled(false);

			} else {
				e.setCancelled(true);
				e.getPlayer().sendMessage("§cVocê precisa estar autenticado para utilizar comandos.");

			}
		}
		
	}

	@EventHandler
    public static void aoAndar(PlayerMoveEvent e) {
        Player p = e.getPlayer();
		if (!ComandoLogar.logado.contains(p)) {
			p.teleport(p.getLocation());
		} else {
			e.setCancelled(false);
		}

	}
}