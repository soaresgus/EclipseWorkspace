package me.ninjay.safecore.estruturas.tags;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.nametagedit.plugin.NametagEdit;

import me.ninjay.safecore.utils.VaultAPI;

public class TagsControler implements Listener {

	public static void setarTag(Player p, String name) {
		for (Tags tag : TagsAPI.manager.getTags()) {
			VaultAPI.getPermission().playerRemove(p, tag.getPerm());
			VaultAPI.getPermission().playerRemoveGroup(p, tag.getName());
			if (tag != null) {
				if (tag.getName().equalsIgnoreCase(name)) {
					NametagEdit.getApi().clearNametag(p);
					VaultAPI.getPermission().playerAdd(p, tag.getPerm());
					VaultAPI.getPermission().playerAddGroup(p, tag.getName());
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
}
