package me.ninjay.factags.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.massivecraft.factions.entity.MPlayer;

import me.ninjay.factags.estruturas.TagAPI;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class EventosGerais implements Listener {

	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		MPlayer mp = MPlayer.get(p);
		PermissionUser pu = PermissionsEx.getUser(p.getName());
		if(mp.hasFaction() == true) {
		TagAPI.get().sendNameTag(p, pu.getGroups()[0].getPrefix().replace("&", "§"), " §7["+mp.getFactionTag()+"]");	
		}else {
			TagAPI.get().sendNameTag(p, pu.getGroups()[0].getPrefix().replace("&", "§"), null);	
		}
	}
}
