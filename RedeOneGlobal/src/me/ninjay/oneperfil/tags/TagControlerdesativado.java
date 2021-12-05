package me.ninjay.oneperfil.tags;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.eduard.api.lib.modules.VaultAPI;
import net.sacredlabyrinth.phaed.simpleclans.ClanPlayer;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;

public class TagControlerdesativado implements Listener {

	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		SimpleClans sc = SimpleClans.getInstance();
		ClanPlayer scp = sc.getClanManager().getClanPlayer(p);
		if (VaultAPI.getPermission().playerInGroup(p, "diretor")) {
			if (scp != null) {
				TagAPIdesativado.setTag(p, "§6[Diretor] §7", " §7[" + scp.getTag().toUpperCase().toUpperCase() + "]");
				return;
			}
		}
		if (VaultAPI.getPermission().playerInGroup(p, "gerente")) {
			if (scp != null) {
				TagAPIdesativado.setTag(p, "§4[Gerente] §7", " §7[" + scp.getTag().toUpperCase() + "]");
				return;
			}
		}
		if (p.hasPermission("programador.tag")) {
			if (scp != null) {
				TagAPIdesativado.setTag(p, "§9[Dev] §7", " §7[" + scp.getTag().toUpperCase() + "]");
				return;
			}
		}
		if (p.hasPermission("moderador.tag")) {
			if (scp != null) {
				TagAPIdesativado.setTag(p, "§2[Mod] §7", " §7[" + scp.getTag().toUpperCase() + "]");
				return;
			}
		}
		if (p.hasPermission("builder.tag")) {
			if (scp != null) {
				TagAPIdesativado.setTag(p, "§d[Builder] §7", " §7[" + scp.getTag().toUpperCase() + "]");
				return;
			}
		}
		if (p.hasPermission("ajudante.tag")) {
			if (scp != null) {
				TagAPIdesativado.setTag(p, "§e[Ajudante] §7", " §7[" + scp.getTag().toUpperCase() + "]");
				return;
			}
		}
		if (p.hasPermission("youtuber.tag")) {
			if (scp != null) {
				TagAPIdesativado.setTag(p, "§c[YT] §7", " §7[" + scp.getTag().toUpperCase() + "]");
				return;
			}
		}
		if (p.hasPermission("titan.tag")) {
			if (scp != null) {
				TagAPIdesativado.setTag(p, "§4[Titan] §7", " §7[" + scp.getTag().toUpperCase() + "]");
				return;
			}
		}
		if (p.hasPermission("gladiador.tag")) {
			if (scp != null) {
				TagAPIdesativado.setTag(p, "§5[Gladiador] §7", " §7[" + scp.getTag().toUpperCase() + "]");
				return;
			}
		}
		if (p.hasPermission("guerreiro.tag")) {
			if (scp != null) {
				TagAPIdesativado.setTag(p, "§3[Guerreiro] §7", " §7[" + scp.getTag().toUpperCase() + "]");
				return;
			}
		}
		if (p.hasPermission("diretor.tag")) {
			if (scp == null) {
				TagAPIdesativado.setTag(p, "§6[Diretor] §7", " §7[Sem Clan]");
				return;
			}
		}
		if (p.hasPermission("gerente.tag")) {
			if (scp == null) {
				TagAPIdesativado.setTag(p, "§4[Gerente] §7", " §7[Sem Clan]");
				return;
			}
		}
		if (p.hasPermission("programador.tag")) {
			if (scp == null) {
				TagAPIdesativado.setTag(p, "§9[Dev] §7", " §7[Sem Clan]");
				return;
			}
		}
		if (p.hasPermission("moderador.tag")) {
			if (scp == null) {
				TagAPIdesativado.setTag(p, "§2[Mod] §7", " §7[Sem Clan]");
				return;
			}
		}
		if (p.hasPermission("builder.tag")) {
			if (scp == null) {
				TagAPIdesativado.setTag(p, "§d[Builder] §7", " §7[Sem Clan]");
				return;
			}
		}
		if (p.hasPermission("ajudante.tag")) {
			if (scp == null) {
				TagAPIdesativado.setTag(p, "§e[Ajudante] §7", " §7[Sem Clan]");
				return;
			}
		}
		if (p.hasPermission("youtuber.tag")) {
			if (scp == null) {
				TagAPIdesativado.setTag(p, "§c[YT] §7", " §7[Sem Clan]");
				return;
			}
		}
		if (p.hasPermission("titan.tag")) {
			if (scp == null) {
				TagAPIdesativado.setTag(p, "§4[Titan] §7", " §7[Sem Clan]");
				return;
			}
		}
		if (p.hasPermission("gladiador.tag")) {
			if (scp == null) {
				TagAPIdesativado.setTag(p, "§5[Gladiador] §7", " §7[Sem Clan]");
				return;
			}
		}
		if (p.hasPermission("guerreiro.tag")) {
			if (scp == null) {
				TagAPIdesativado.setTag(p, "§3[Guerreiro] §7", " §7[Sem Clan]");
				return;
			}
		}

	}

}
