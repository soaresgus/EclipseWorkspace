package me.ninjay.ninjapartylb.estruturas;


import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.ninjapartylb.utils.DisplayBoard;




public class SimplesScore extends BukkitRunnable implements Listener {

	private static HashMap<Player, DisplayBoard> scoreboards = new HashMap<>();

	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		setScore(p);
	}
	
	public static void ligar(JavaPlugin plugin) {
		SimplesScore simpleScore = new SimplesScore();
		simpleScore.runTaskTimerAsynchronously(plugin, 20, 20);
		Bukkit.getPluginManager().registerEvents(simpleScore, plugin);
		;
	}

	public static void setScore(Player p) {
		DisplayBoard scoreboard = new DisplayBoard("�6�lMEU SERVER", "�aLINHA1", "�aLinha2", "", "�aLinha4");
		scoreboard.apply(p);
		scoreboard.clear();
		scoreboard.getLines().clear();
		scoreboards.put(p, scoreboard);
	}

	@EventHandler
	public void aoSair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		scoreboards.remove(p);

	}

	public void run() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			atualizar(p);
		}
	}

	public static void atualizar(Player p) {

		DisplayBoard scoreboard = scoreboards.get(p);
		if (scoreboard == null)
			return;
		scoreboard.setDisplay("§6§lNinja Party");
		scoreboard.set(15, "§fGrupo: §6[Master]");
		scoreboard.set(14, "§fCash: §70");
		scoreboard.empty(13);
		scoreboard.set(12, "§fOnline: §7"+Bukkit.getOnlinePlayers().size());
		scoreboard.empty(11);
		scoreboard.set(10, "§eloja.ninjaparty.com");
		return;
	}

}
