package me.ninjay.aurealobby;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class EventosAntiBugs implements Listener{
	
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		for(Player todos : Bukkit.getOnlinePlayers()) {
			if(todos.hasPermission("master.tag")) {
				TagAPI.setTag(todos, "§6§lMASTER §6","");
				return;
			}
			if(todos.hasPermission("gerente.tag")) {
				TagAPI.setTag(todos, "§4§lGERENTE §4","");
				return;
			}
			if(todos.hasPermission("admin.tag")) {
				TagAPI.setTag(todos, "§c§lADMIN §c","");
				return;
				
			}
			if(todos.hasPermission("moderador.tag")) {
				TagAPI.setTag(todos, "§2§lMODERADOR §2","");
				return;
				
			}
			if(todos.hasPermission("ajudante.tag")) {
				TagAPI.setTag(todos, "§e§lAJUDANTE §e","");
				return;
			}
			if(todos.hasPermission("construtor.tag")) {
				TagAPI.setTag(todos, "§a§lCONSTRUTOR §a","");
				return;
			}
			if(todos.hasPermission("youtuber.tag")) {
				TagAPI.setTag(todos, "§c§lYOUTUBER §c","");
				return;
			}
			if(todos.hasPermission("galaxy.tag")) {
				TagAPI.setTag(todos, "§5§lGALAXY §5","");
				return;
			}
			if(todos.hasPermission("meteor.tag")) {
				TagAPI.setTag(todos, "§d§lMETEOR §d","");
				return;
			}
			if(todos.hasPermission("moon.tag")) {
				TagAPI.setTag(todos, "§b§lMOON §b","");
				return;
			}
			if(todos.hasPermission("membro.tag")) {
				TagAPI.setTag(todos, "§7§lMEMBRO §7","");
				return;
			}
			
	}
	}
			
		
	}


