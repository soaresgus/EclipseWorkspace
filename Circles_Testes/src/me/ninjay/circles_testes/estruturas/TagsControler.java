package me.ninjay.circles_testes.estruturas;

import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.nametagedit.plugin.NametagEdit;

import me.ninjay.circles_testes.utils.VaultAPI;


public class TagsControler implements Listener {

	public static void setarTag(Player p, String name) {
		for (Tags tag : TagsAPI.manager.getTags()) {
		for(World worlds : p.getServer().getWorlds()) {
			VaultAPI.getPermission().playerRemove(worlds.getName(), p, tag.getPerm());
			VaultAPI.getPermission().playerRemoveGroup(worlds.getName(), p, tag.getName());
		}
			if (tag != null) {
				if (tag.getName().equalsIgnoreCase(name)) {
					NametagEdit.getApi().clearNametag(p);
				for(World worlds : p.getServer().getWorlds()) {
					VaultAPI.getPermission().playerAdd(worlds.getName(), p, tag.getPerm());
					VaultAPI.getPermission().playerAddGroup(worlds.getName(), p, tag.getName());
				}
					NametagEdit.getApi().reloadNametag(p);
				}
			}

		}
	}
	
	public static void setarTagOff(OfflinePlayer p, String name) {
		for (Tags tag : TagsAPI.manager.getTags()) {
			VaultAPI.getPermission().playerRemove((Player) p, tag.getPerm());
			VaultAPI.getPermission().playerRemoveGroup((Player) p, tag.getName());
			if (tag != null) {
				if (tag.getName().equalsIgnoreCase(name)) {
					NametagEdit.getApi().clearNametag((Player) p);
					VaultAPI.getPermission().playerAdd((Player) p, tag.getPerm());
					VaultAPI.getPermission().playerAddGroup((Player) p, tag.getName());
					NametagEdit.getApi().reloadNametag((Player) p);
				}
			}

		}
	}

	public static String getTag(Player p) {
		for (Tags tag : TagsAPI.manager.getTags()) {
			if (tag != null) {
				if (VaultAPI.getPermission().has(p, tag.getPerm())) {
				}
			}
		}
		return NametagEdit.getApi().getNametag(p).getPrefix();
	}
	
	@EventHandler
	public static void aoEntar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		setarTag(p, TagsControler.getTag(p));
	}
}
