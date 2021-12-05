package me.ninjay.aureascore;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class Score implements Listener{
	
	@EventHandler
	public void entrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();	
		

	ScoreboardManager scoreboardManager = Main.getmain().getServer().getScoreboardManager();
	Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
	Objective objective = scoreboard.registerNewObjective("§e§lREDE AUREA", "Dummy");
	objective.setDisplaySlot(DisplaySlot.SIDEBAR);
    Team health = scoreboard.registerNewTeam("health");
    health.addEntry("abc");
    health.setSuffix("");
    health.setPrefix("");
    objective.getScore("§fjogar.rede-aurea.com").setScore(6);
    objective.getScore("§f").setScore(5);
    objective.getScore("§fGrupo: §7Em Breve").setScore(4);
    objective.getScore("§f").setScore(3);
    objective.getScore("§fCash: §7Em breve").setScore(2);;
    objective.getScore("§f").setScore(1);
    objective.getScore("§fwww.rede-aurea.com").setScore(0);
    String title = "§e§lAUREA";
    char[] split = title.toCharArray();
    
    

  
	p.setScoreboard(scoreboard);
}
}






