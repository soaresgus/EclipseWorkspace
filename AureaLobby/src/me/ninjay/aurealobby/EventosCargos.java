package me.ninjay.aurealobby;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventosCargos implements Listener{
	
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		if(p.hasPermission("master.tag")) {
			TagAPI.setTag(p, "§6§lMASTER §6","");
			return;
		}
		if(p.hasPermission("gerente.tag")) {
			TagAPI.setTag(p, "§4§lGERENTE §4","");
			return;
		}
		if(p.hasPermission("admin.tag")) {
			TagAPI.setTag(p, "§c§lADMIN §c","");
			return;
			
		}
		if(p.hasPermission("moderador.tag")) {
			TagAPI.setTag(p, "§2§lMODERADOR §2","");
			return;
			
		}
		if(p.hasPermission("ajudante.tag")) {
			TagAPI.setTag(p, "§e§lAJUDANTE §e","");
			return;
		}
		if(p.hasPermission("construtor.tag")) {
			TagAPI.setTag(p, "§a§lCONSTRUTOR §a","");
			return;
		}
		if(p.hasPermission("youtuber.tag")) {
			TagAPI.setTag(p, "§c§lYOUTUBER §c","");
			return;
		}
		if(p.hasPermission("galaxy.tag")) {
			TagAPI.setTag(p, "§5§lGALAXY §5","");
			return;
		}
		if(p.hasPermission("meteor.tag")) {
			TagAPI.setTag(p, "§d§lMETEOR §d","");
			return;
		}
		if(p.hasPermission("moon.tag")) {
			TagAPI.setTag(p, "§b§lMOON §b","");
			return;
		}
		if(p.hasPermission("membro.tag")) {
			TagAPI.setTag(p, "§7§lMEMBRO §7","");
			return;
		}
		
}
}