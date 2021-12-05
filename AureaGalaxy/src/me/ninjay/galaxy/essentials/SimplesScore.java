package me.ninjay.galaxy.essentials;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.galaxy.main.Main;
import net.eduard.api.lib.game.DisplayBoard;

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
		DisplayBoard scoreboard = new DisplayBoard("§6§lMEU SERVER", "§aLINHA1", "§aLinha2", "", "§aLinha4");
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
		if (p.hasPermission("master.tag")) {
			scoreboard.setDisplay("§5§lRANKUP GALAXY");
			scoreboard.set(15, "             §fBem vindo!");
			scoreboard.empty(14);
			scoreboard.set(13, "§a» §fCargo: §6Master");
			scoreboard.set(12, "§a» §fNick: §6" + p.getName());
			scoreboard.empty(11);
			scoreboard.set(10, "§a» §fCoins: §6$"+Main.economy.getBalance(p));
			scoreboard.set(9, "§a» §fCash: §6"+Main.cash.getDouble(p.getName()));
			scoreboard.empty(8);
			scoreboard.set(7, "         §fredeaurea.com");
			return;
		}
		if (p.hasPermission("gerente.tag")) {
			scoreboard.setDisplay("§5§lRANKUP GALAXY");
			scoreboard.set(15, "             §fBem vindo!");
			scoreboard.empty(14);
			scoreboard.set(13, "§a» §fCargo: §4Gerente");
			scoreboard.set(12, "§a» §fNick: §6" + p.getName());
			scoreboard.empty(11);
			scoreboard.set(10, "§a» §fCoins: §6$"+Main.economy.getBalance(p));
			scoreboard.set(9, "§a» §fCash: §6"+Main.cash.getDouble(p.getName()));
			scoreboard.empty(8);
			scoreboard.set(7, "         §fredeaurea.com");
			return;
		}
		if (p.hasPermission("admin.tag")) {
			scoreboard.setDisplay("§5§lRANKUP GALAXY");
			scoreboard.set(15, "             §fBem vindo!");
			scoreboard.empty(14);
			scoreboard.set(13, "§a» §fCargo: §cAdmin");
			scoreboard.set(12, "§a» §fNick: §6" + p.getName());
			scoreboard.empty(11);
			scoreboard.set(10, "§a» §fCoins: §6$"+Main.economy.getBalance(p));
			scoreboard.set(9, "§a» §fCash: §6"+Main.cash.getDouble(p.getName()));
			scoreboard.empty(8);
			scoreboard.set(7, "         §fredeaurea.com");
			return;
		}
		if (p.hasPermission("moderador.tag")) {
			scoreboard.setDisplay("§5§lRANKUP GALAXY");
			scoreboard.set(15, "             §fBem vindo!");
			scoreboard.empty(14);
			scoreboard.set(13, "§a» §fCargo: §2Moderador");
			scoreboard.set(12, "§a» §fNick: §6" + p.getName());
			scoreboard.empty(11);
			scoreboard.set(10, "§a» §fCoins: §6$"+Main.economy.getBalance(p));
			scoreboard.set(9, "§a» §fCash: §6"+Main.cash.getDouble(p.getName()));
			scoreboard.empty(8);
			scoreboard.set(7, "         §fredeaurea.com");
			return;
		}
		if (p.hasPermission("ajudante.tag")) {
			scoreboard.setDisplay("§5§lRANKUP GALAXY");
			scoreboard.set(15, "             §fBem vindo!");
			scoreboard.empty(14);
			scoreboard.set(13, "§a» §fCargo: §eAjudante");
			scoreboard.set(12, "§a» §fNick: §6" + p.getName());
			scoreboard.empty(11);
			scoreboard.set(10, "§a» §fCoins: §6$"+Main.economy.getBalance(p));
			scoreboard.set(9, "§a» §fCash: §6"+Main.cash.getDouble(p.getName()));
			scoreboard.empty(8);
			scoreboard.set(7, "         §fredeaurea.com");
			return;
		}
		if (p.hasPermission("construtor.tag")) {
			scoreboard.setDisplay("§5§lRANKUP GALAXY");
			scoreboard.set(15, "             §fBem vindo!");
			scoreboard.empty(14);
			scoreboard.set(13, "§a» §fCargo: §aConstrutor");
			scoreboard.set(12, "§a» §fNick: §6" + p.getName());
			scoreboard.empty(11);
			scoreboard.set(10, "§a» §fCoins: §6$"+Main.economy.getBalance(p));
			scoreboard.set(9, "§a» §fCash: §6"+Main.cash.getDouble(p.getName()));
			scoreboard.empty(8);
			scoreboard.set(7, "         §fredeaurea.com");
			return;
		}
		if (p.hasPermission("youtuber.tag")) {
			scoreboard.setDisplay("§5§lRANKUP GALAXY");
			scoreboard.set(15, "             §fBem vindo!");
			scoreboard.empty(14);
			scoreboard.set(13, "§a» §fCargo: §cYoutuber");
			scoreboard.set(12, "§a» §fNick: §6" + p.getName());
			scoreboard.empty(11);
			scoreboard.set(10, "§a» §fCoins: §6$"+Main.economy.getBalance(p));
			scoreboard.set(9, "§a» §fCash: §6"+Main.cash.getDouble(p.getName()));
			scoreboard.empty(8);
			scoreboard.set(7, "         §fredeaurea.com");
			return;
		}
		if (p.hasPermission("galaxy.tag")) {
			scoreboard.setDisplay("§5§lRANKUP GALAXY");
			scoreboard.set(15, "             §fBem vindo!");
			scoreboard.empty(14);
			scoreboard.set(13, "§a» §fCargo: §5Galaxy");
			scoreboard.set(12, "§a» §fNick: §6" + p.getName());
			scoreboard.empty(11);
			scoreboard.set(10, "§a» §fCoins: §6$"+Main.economy.getBalance(p));
			scoreboard.set(9, "§a» §fCash: §6"+Main.cash.getDouble(p.getName()));
			scoreboard.empty(8);
			scoreboard.set(7, "         §fredeaurea.com");
			return;
		}
		if (p.hasPermission("meteor.tag")) {
			scoreboard.setDisplay("§5§lRANKUP GALAXY");
			scoreboard.set(15, "             §fBem vindo!");
			scoreboard.empty(14);
			scoreboard.set(13, "§a» §fCargo: §dMeteor");
			scoreboard.set(12, "§a» §fNick: §6" + p.getName());
			scoreboard.empty(11);
			scoreboard.set(10, "§a» §fCoins: §6$"+Main.economy.getBalance(p));
			scoreboard.set(9, "§a» §fCash: §6"+Main.cash.getDouble(p.getName()));
			scoreboard.empty(8);
			scoreboard.set(7, "         §fredeaurea.com");
			return;
		}
		if (p.hasPermission("moon.tag")) {
			scoreboard.setDisplay("§5§lRANKUP GALAXY");
			scoreboard.set(15, "             §fBem vindo!");
			scoreboard.empty(14);
			scoreboard.set(13, "§a» §fCargo: §bMoon");
			scoreboard.set(12, "§a» §fNick: §6" + p.getName());
			scoreboard.empty(11);
			scoreboard.set(10, "§a» §fCoins: §6$"+Main.economy.getBalance(p));
			scoreboard.set(9, "§a» §fCash: §6"+Main.cash.getDouble(p.getName()));
			scoreboard.empty(8);
			scoreboard.set(7, "         §fredeaurea.com");
			return;
		}
		if (p.hasPermission("membro.tag")) {
			scoreboard.setDisplay("§5§lRANKUP GALAXY");
			scoreboard.set(15, "             §fBem vindo!");
			scoreboard.empty(14);
			scoreboard.set(13, "§a» §fCargo: §7Membro");
			scoreboard.set(12, "§a» §fNick: §6" + p.getName());
			scoreboard.empty(11);
			scoreboard.set(10, "§a» §fCoins: §6$"+Main.economy.getBalance(p));
			scoreboard.set(9, "§a» §fCash: §6"+Main.cash.getDouble(p.getName()));
			scoreboard.empty(8);
			scoreboard.set(7, "         §fredeaurea.com");
			return;
		}

	}

}
