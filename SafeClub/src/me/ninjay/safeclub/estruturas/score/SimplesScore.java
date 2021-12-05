package me.ninjay.safeclub.estruturas.score;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.safeclub.utils.DisplayBoard;
import me.ninjay.safeclub.utils.VaultAPI;
import net.sacredlabyrinth.phaed.simpleclans.ClanPlayer;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;

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
		SimpleClans sc = SimpleClans.getInstance();
		ClanPlayer sp = sc.getClanManager().getClanPlayer(p);
		if (sp != null) {
			scoreboard.setDisplay("  §6§lSafe Club  ");
			scoreboard.empty(15);
			scoreboard.set(14, "  §fServidor: §aP4 Free");
			scoreboard.set(13, "  §fJogadores: §a" + Bukkit.getOnlinePlayers().size());
			scoreboard.empty(12);
			scoreboard.set(11, "  §a["+sp.getClan().getTag()+"] "+sp.getClan().getName());
			scoreboard.set(10, "   §fMembros: §a"+sc.getClanManager().getClanPlayer(p).getClan().getOnlineMembers().size()+"/"+sc.getClanManager().getClanPlayer(p).getClan().getAllMembers().size());
			scoreboard.set(9, "   §fKDR: §a"+sp.getClan().getTotalKDR());
			scoreboard.empty(8);
			scoreboard.set(7, "  §fMoney: §a"+VaultAPI.getEconomy().getBalance(p));
			scoreboard.set(6, "  §fCash: §a0");
			scoreboard.empty(5);
			scoreboard.set(4, "§6loja.safeclub.com");

		}
		if(sp == null) {
			scoreboard.setDisplay("  §6§lSafe Club  ");
			scoreboard.empty(15);
			scoreboard.set(14, "  §fServidor: §aP4 Free");
			scoreboard.set(13, "  §fJogadores: §a" + Bukkit.getOnlinePlayers().size());
			scoreboard.empty(12);
			scoreboard.set(11, "  §fMoney: §a"+VaultAPI.getEconomy().getBalance(p));
			scoreboard.set(10, "  §fCash: §a0");
			scoreboard.empty(9);
			scoreboard.set(8, "§6loja.safeclub.com");
		}
	}

}
