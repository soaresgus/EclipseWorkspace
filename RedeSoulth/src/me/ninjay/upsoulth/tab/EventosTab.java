package me.ninjay.upsoulth.tab;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.ninjay.ninjaapi.utils.Mine;

public class EventosTab implements Listener{
	
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Mine.setTabList(p, " \n§b§lSoulthNetwork\n§fjogar.redesoulth.tk\n ", " \n§bTwitter: §f@RedeSoulth\n§bDiscord: §fhttps://discord.gg/BGMD3tR\n \n  §bAdquira VIP e CASH acessando §floja.redenetwork.com  \n ");
	}

}
