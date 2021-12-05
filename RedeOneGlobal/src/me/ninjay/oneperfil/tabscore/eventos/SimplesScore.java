package me.ninjay.oneperfil.tabscore.eventos;

import java.text.NumberFormat;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.oneperfil.rankspoo.manager.RankUPAPI;
import net.eduard.api.lib.game.DisplayBoard;
import net.eduard.api.lib.modules.VaultAPI;
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
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String dinheiro = formatter.format(VaultAPI.getEconomy().getBalance(p));
		NumberFormat formatador = NumberFormat.getNumberInstance();
		String cash = formatador.format(EventosTabScore.ppapi.look(p.getUniqueId()));
		if(sc.getClanManager().getClanPlayer(p) != null) {
		scoreboard.setDisplay("§6§lREDE ONE");
		scoreboard.empty(15);
		scoreboard.set(14, "§6Nick: §e"+p.getName());
		scoreboard.set(13, "§6Rank: §e"+RankUPAPI.getManager().getRank(p).getPrefix());
		scoreboard.empty(12);
		scoreboard.set(11, "§e["+sc.getClanManager().getClanPlayer(p).getTag().toUpperCase()+"] §e"+sc.getClanManager().getClanPlayer(p).getClan().getName());
		scoreboard.set(10, " §6Membros: §e"+sc.getClanManager().getClanPlayer(p).getClan().getOnlineMembers().size()+"/"+sc.getClanManager().getClanPlayer(p).getClan().getAllMembers().size());
		scoreboard.set(9, " §6KDR: §e"+sc.getClanManager().getClanPlayer(p).getClan().getTotalKDR());
		scoreboard.empty(8);
		scoreboard.set(7, "§6Coins: §e"+dinheiro.replace(",", "."));
		scoreboard.set(6, "§6Cash: §e"+cash.replace(",", "."));
		scoreboard.empty(5);
		scoreboard.set(4, "§6rede-one.com");
 		
		}else {
			scoreboard.setDisplay("§6§lREDE ONE");
			scoreboard.empty(15);
			scoreboard.set(14, "§6Nick: §e"+p.getName());
			scoreboard.set(13, "§6Rank: §e"+RankUPAPI.getManager().getRank(p).getPrefix());
			scoreboard.empty(12);
			scoreboard.set(11, "§7Você não possui um clan");
			scoreboard.empty(10);
			scoreboard.set(9, "§6Coins: §e"+dinheiro.replace(",", "."));
			scoreboard.set(8, "§6Cash: §e"+cash.replace(",", "."));
			scoreboard.empty(7);
			scoreboard.set(6, "§6rede-one.com");
		}
		
	

	}

}