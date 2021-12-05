package me.ninjay.aureaup.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.ninjay.aureaup.estruturas.ClassesAPI;
import me.ninjay.aureaup.estruturas.LoginAPI;
import me.ninjay.aureaup.main.Main;
import me.ninjay.aureaup.utils.Mine;

public class EventosGlobal implements Listener{
	
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		Mine.sendTitle(p, "§5§lAurea", "§fServidor de RankUP", 5, 50, 5);
		LoginAPI.entrar(p, Main.senhas);
			
	}

}
