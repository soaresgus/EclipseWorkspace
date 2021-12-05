package me.ninjay.oneperfil.tagsv2;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import com.nametagedit.plugin.NametagEdit;

import net.eduard.api.lib.modules.VaultAPI;
import net.eduard.api.lib.storage.Storable;
import net.sacredlabyrinth.phaed.simpleclans.ClanPlayer;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;

public class TagsManager implements Storable {

	public Tags getTag(String nome) {
		for (Tags tag : tags) {
			if (tag.getNome().equalsIgnoreCase(nome)) {
				return tag;
			}
		}

		return null;

	}

	private ArrayList<Tags> tags = new ArrayList<>();
    private ArrayList<String> cargos = new ArrayList<>();
	
	public ArrayList<Tags> getTags() {
		return tags;
	}

	public void setTags(ArrayList<Tags> tags) {
		this.tags = tags;
	}

	public void setar(Player enviou, Player recebeu, Tags tag) {
	    SimpleClans sc = SimpleClans.getInstance();
        ClanPlayer scp = sc.getClanManager().getClanPlayer(recebeu);
		enviou.sendMessage("§6Você setou a tag " + tag.getPrefix() + "§6para " + recebeu.getName() + "§6.");
        recebeu.sendMessage("§6Você recebeu a tag "+tag.getPrefix()+"§6de "+enviou.getName()+"§6.");
        VaultAPI.getPermission().playerRemoveGroup(recebeu, "diretor");
        VaultAPI.getPermission().playerRemoveGroup(recebeu, "gerente");
        VaultAPI.getPermission().playerRemoveGroup(recebeu, "admin");
        VaultAPI.getPermission().playerRemoveGroup(recebeu, "programador");
        VaultAPI.getPermission().playerRemoveGroup(recebeu, "Moderador");
        VaultAPI.getPermission().playerRemoveGroup(recebeu, "builder");
        VaultAPI.getPermission().playerRemoveGroup(recebeu, "ajudante");
        VaultAPI.getPermission().playerRemoveGroup(recebeu, "youtuber");
        VaultAPI.getPermission().playerAddGroup(recebeu, tag.getCargo());
        if(scp == null) {
        	NametagEdit.getApi().setPrefix(recebeu, tag.getPrefix());
        	NametagEdit.getApi().setSuffix(recebeu, "");
        	return;
        }
        if(scp != null) {
        	NametagEdit.getApi().setPrefix(recebeu, tag.getPrefix());
        	NametagEdit.getApi().setSuffix(recebeu, " §7["+scp.getTag().toUpperCase()+"]");
        	return;
        }
	}

	public ArrayList<String> getCargos() {
		return cargos;
	}

	public void setCargos(ArrayList<String> cargos) {
		this.cargos = cargos;
	}
}
