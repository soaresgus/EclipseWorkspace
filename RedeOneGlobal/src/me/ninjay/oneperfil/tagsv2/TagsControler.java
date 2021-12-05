package me.ninjay.oneperfil.tagsv2;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.nametagedit.plugin.NametagEdit;

import net.eduard.api.lib.modules.VaultAPI;
import net.sacredlabyrinth.phaed.simpleclans.ClanPlayer;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;


public class TagsControler implements Listener{
	
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		SimpleClans sc = SimpleClans.getInstance();
        ClanPlayer scp = sc.getClanManager().getClanPlayer(e.getPlayer());
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "diretor")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§6[Diretor] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§6[Diretor] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "gerente")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§4[Gerente] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§4[Gerente] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "admin")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§c[Admin] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§c[Admin] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "programador")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§9[Dev] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§9[Dev] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "Moderador")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§2[Moderador] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§2[Moderador] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "builder")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§d[Builder] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§d[Builder] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "ajudante")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§e[Ajudante] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§e[Ajudante] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "youtuber")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§c[YT] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§c[YT] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "viptitan")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§4[Titan] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§4[Titan] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "vipgladiador")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§5[Gladiador] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§5[Gladiador] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "vipguerreiro")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§3[Guerreiro] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§3[Guerreiro] ");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "0")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "1")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "2")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "3")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "4")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "5")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "6")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "7")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "8")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "9")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
		if(VaultAPI.getPermission().playerInGroup(e.getPlayer(), "10")) {
			if(scp == null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), "");
	        	return;
	        }
	        if(scp != null) {
	        	NametagEdit.getApi().setPrefix(e.getPlayer(), "§7");
	        	NametagEdit.getApi().setSuffix(e.getPlayer(), " §7["+scp.getTag().toUpperCase()+"]");
	        	return;
	        }
		}
	}
}
	

