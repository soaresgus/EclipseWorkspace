package me.ninjay.galaxy.essentials;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.ninjay.galaxy.main.Main;
import me.ninjay.ninjaapi.utils.Mine;

public class EventosEntrar implements Listener {

	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		Mine.setTabList(p,
				" \n§6§lREDE AUREA\n§f  jogar.rede-aurea.com\n \n§fJogadores online: §e"
						+ Bukkit.getOnlinePlayers().size() + "\n ",
				"\n §fSite: §eredeaurea.com\n§fFórum: §eEm breve\n§fTwitter: §e@RedeAurea\n ");
		p.teleport(Main.locais.getLocation("spawn"));
		p.setMaxHealth(20);
		p.setHealth(20);
		p.sendMessage("§aSeja bem vindo " + p.getName()
				+ " !\n \nSe você é novo no servidor utilize o comando /ajuda e aprenda tudo sobre o servidor !");
        e.setJoinMessage(null);
        SimplesScore.setScore(p);
        if (p.hasPermission("master.tag") || p.hasPermission("gerente.tag") || p.hasPermission("admin.tag")
				|| p.hasPermission("moderador.tag") || p.hasPermission("ajudante.tag")
				|| p.hasPermission("construtor.tag") || p.hasPermission("youtuber.tag") || p.hasPermission("galaxy.tag")
				|| p.hasPermission("meteor.tag") || p.hasPermission("moon.tag")) {
        	Bukkit.broadcastMessage("§e[VIP] " + p.getName() + " §6entrou no servidor");
        }

}
}
