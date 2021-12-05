package me.ninjay.ninjakitpvp.estruturas;


import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.ninjakitpvp.main.Main;
import me.ninjay.ninjakitpvp.utils.DisplayBoard;



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
		scoreboard.setDisplay("§b§l"+Main.global.getString("nomeDoServidor"));
		scoreboard.empty(15);
		scoreboard.set(14, "  §fKills: §7"+InfoAPI.getKills(p));
		scoreboard.set(13, "  §fMortes: §7"+InfoAPI.getMortes(p));
		scoreboard.empty(12);
		scoreboard.set(11, "  §fCoins: §7"+CoinsAPI.get(p, Main.cash));
		scoreboard.empty(10);
		scoreboard.set(9, "§aloja.ninjamc.com");
		return;
	}

}
