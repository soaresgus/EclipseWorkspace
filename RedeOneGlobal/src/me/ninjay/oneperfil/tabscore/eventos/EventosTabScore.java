package me.ninjay.oneperfil.tabscore.eventos;

import org.black_ixx.playerpoints.PlayerPoints;
import org.black_ixx.playerpoints.PlayerPointsAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.onewarps.main.Main;

public class EventosTabScore implements Listener {

	public static PlayerPointsAPI ppapi = null;
	public static PlayerPoints play = null;

	static {
		Plugin plugin = Main.getPlugin(Main.class).getServer().getPluginManager().getPlugin("PlayerPoints");
		play = PlayerPoints.class.cast(plugin);
		ppapi = new PlayerPointsAPI(play);

	}

	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		SimplesScore.setScore(p);
		Mine.setTabList(p, "\n §6§lREDE ONE\n§ejogar.rede-one.com\n ",
				"\n§6Discord: §ediscord.me/redeone\n§6Twitter: §etwitter.com/ServidoresOne\n \n     §6Adquira §evip §6e §ecash §6em nossa loja: §erede-one.com     \n ");

		new BukkitRunnable() {

			@Override
			public void run() {
				for (int d = 0; d < 150; d++) {
					p.sendMessage(" ");
				}
				p.sendMessage("§6Bem vindo ao servidor §e" + p.getName() + "§6 !");
				p.teleport(Main.locais.getLocation("spawn"));
			}
		}.runTaskLater(Main.getPlugin(Main.class), 5);

	}
	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if(e.getMessage().contains("/clan")) {
			SimplesScore.atualizar(p);
			new BukkitRunnable() {
				
				@Override
				public void run() {
					SimplesScore.atualizar(p);
					SimplesScore.setScore(p);
				}
			}.runTaskLater(Main.getPlugin(Main.class), 3);
		}
	}

}
