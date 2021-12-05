package me.ninjay.kustscoreboard.estruturas;

import java.text.DecimalFormat;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.nossr50.api.ExperienceAPI;
import com.massivecraft.factions.entity.BoardColl;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.factions.event.EventFactionsDisband;
import com.massivecraft.massivecore.ps.PS;

import me.ninjay.kustcash.estruturas.CashAPI;
import me.ninjay.kustcash.main.Main;
import me.ninjay.kustscoreboard.utils.DisplayBoard;
import me.ninjay.kustscoreboard.utils.Mine;
import me.ninjay.kustscoreboard.utils.VaultAPI;

public class SimplesScore extends BukkitRunnable implements Listener {

	private static HashMap<Player, DisplayBoard> scoreboards = new HashMap<>();
	private static HashMap<String, Integer> cash = new HashMap<>();
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		setScore(p);
		new BukkitRunnable() {
			
			@Override
			public void run() {
				cash.put(p.getName(), CashAPI.getCash(p.getName()));
			}
		}.runTaskLater(me.ninjay.kustscoreboard.main.Main.getPlugin(Main.class), 5*20);
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

	@EventHandler
	public void onDisband(EventFactionsDisband e) {
		MPlayer mp = e.getMPlayer();
		Player p = mp.getPlayer();
		
		setScore(p);
		atualizar(p);
	}
	
	public void run() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			atualizar(p);
		}
	}
	
	public static String getCash(Player p) {
		DecimalFormat df = new DecimalFormat("###,###,###");
		if(Main.sql.hasConnection()) {
			return df.format(cash.get(p.getName())).replace(",", ".");
		}else {
			return "0";
		}
	}

	public static void atualizar(Player p) {
		DecimalFormat df = new DecimalFormat("###,###,###");
		MPlayer mp = MPlayer.get(p);
		String money = df.format(VaultAPI.getEconomy().getBalance(p)).replace(",", ".");
		Location location = p.getLocation();
		PS ps = PS.valueOf(location);
		Faction fac = BoardColl.get().getFactionAt(ps);
		
	new BukkitRunnable() {
		
		@Override
		public void run() {
			DisplayBoard scoreboard = scoreboards.get(p);
			if (scoreboard == null)
				return;
		if(mp.hasFaction() == true) {
			scoreboard.setDisplay(fac.getName());
			scoreboard.empty(15);
			scoreboard.set(14, "  §fNível: §a"+ExperienceAPI.getPowerLevel(p)+"       ");
			scoreboard.set(13, "  §fPoder: §a"+Mine.toInt(mp.getPower())+"/"+Mine.toInt(mp.getPowerMax())+"       ");
			scoreboard.empty(12);
			scoreboard.set(11, "  §e"+mp.getFactionName()+"       ");
			scoreboard.set(10, "    §fOnline: §e"+mp.getFaction().getOnlinePlayers().size()+"/"+mp.getFaction().getMembersLimit()+"       ");
			scoreboard.set(9, "    §fPoder: §e"+Mine.toInt(mp.getFaction().getPower())+"/"+Mine.toInt(mp.getFaction().getPowerMax())+"       ");
			scoreboard.set(8, "    §fTerras: §e"+BoardColl.get().getChunks(mp.getFaction()).size()+"       ");
			scoreboard.empty(7);
			scoreboard.set(6, "  §fCoins: §a"+money+"       ");
			scoreboard.set(5, "  §fCash: §a"+getCash(p)+"       ");
			scoreboard.empty(4);
			scoreboard.set(3, "§ekustnetwork.net");
			return;
		}else {
			scoreboard.setDisplay(fac.getName());
			scoreboard.empty(15);
			scoreboard.set(14, "  §fNível: §a"+ExperienceAPI.getPowerLevel(p)+"       ");
			scoreboard.set(13, "  §fPoder: §a"+Mine.toInt(mp.getPower())+"/"+Mine.toInt(mp.getPowerMax())+"       ");
			scoreboard.empty(12);
			scoreboard.set(11, "  §7Sem facção");
			scoreboard.empty(10);
			scoreboard.set(9, "  §fCoins: §a"+money+"       ");
			scoreboard.set(8, "  §fCash: §a"+getCash(p)+"       ");
			scoreboard.empty(7);
			scoreboard.set(6, "§ekustnetwork.net");
			return;
		}
		}
	}.runTaskLaterAsynchronously(me.ninjay.kustscoreboard.main.Main.getPlugin(Main.class), 20);
	}

}
