package me.ninjay.saferankup.estruturas;


import java.text.NumberFormat;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.safecash.estruturas.CashAPI;
import me.ninjay.safecore.estruturas.skills.SkillsAPI;
import me.ninjay.saferankup.comandos.ComandoRankUP;
import me.ninjay.saferankup.main.Main;
import me.ninjay.saferankup.utils.DisplayBoard;
import me.ninjay.saferankup.utils.VaultAPI;


public class SimplesScore extends BukkitRunnable implements Listener {

	private static HashMap<Player, DisplayBoard> scoreboards = new HashMap<>();

	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		setScore(p);
	}
	
	@EventHandler
	public void aoTeleport(PlayerTeleportEvent e) {
		Player p = e.getPlayer();
		setScore(p);
		atualizar(p);
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
		OfflinePlayer player = p;
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String dinheiro = formatter.format(VaultAPI.getEconomy().getBalance(p));
		String cash = formatter.format(CashAPI.get(player, me.ninjay.safecash.main.Main.cash));
		
		DisplayBoard scoreboard = scoreboards.get(p);
		if (scoreboard == null)
			return;
		scoreboard.setDisplay("§6§lRANK UP");
		scoreboard.empty(15);
		scoreboard.set(14, "§fNível: §a"+SkillsAPI.getNvlTotal(p));
		scoreboard.set(13, "§fCoins: §a"+dinheiro);
		scoreboard.set(12, "§fCash: §e"+cash);
		scoreboard.empty(11);
		scoreboard.set(10, "§fRank atual: §a"+RankAPI.manager.getRankPorId(ComandoRankUP.config.getInt(p.getName())).getName());
		scoreboard.empty(9);
		scoreboard.set(8, "§7safeclub.gg");
		return;
	}

}
