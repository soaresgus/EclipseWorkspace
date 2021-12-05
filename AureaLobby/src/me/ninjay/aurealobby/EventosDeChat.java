package me.ninjay.aurealobby;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class EventosDeChat implements Listener {

	@EventHandler
	public void chat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();

		if (p.hasPermission("master.tag") || p.hasPermission("gerente.tag") || p.hasPermission("admin.tag")
				|| p.hasPermission("moderador.tag") || p.hasPermission("ajudante.tag")
				|| p.hasPermission("construtor.tag") || p.hasPermission("youtuber.tag") || p.hasPermission("galaxy.tag")
				|| p.hasPermission("meteor.tag") || p.hasPermission("moon.tag")) {
			e.setFormat("§e"+p.getName()+" §b§l» §7" + e.getMessage());
		return;
		
		
	}
	


if(p.hasPermission("membro.tag")) {
	p.sendMessage("§ePara poder utilizar o chat é necessário você ser vip\n \n§eAdquira já seu vip em nossa loja\n§bhttps://loja.redeaurea.com");
	e.setCancelled(true);
	
}
}
}

	