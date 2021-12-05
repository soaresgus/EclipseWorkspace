package me.ninjay.aureascore;


import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class Scoreboard
  implements Listener
{
	@EventHandler
  public static void ScoreBoard(Player p)
  {
    Collection<? extends Player> online = Bukkit.getOnlinePlayers();
    
    SimpleScoreboard scoreboard = new SimpleScoreboard("§e§l");
    scoreboard.add("");
    scoreboard.add("§7§m-=-=-=-=-=-=-=-=-=-=-");
    scoreboard.blankLine();
    scoreboard.add("   §6Jogador " + p.getName());
    scoreboard.add("    §aServidor §aLobby");
    scoreboard.blankLine();
    scoreboard.add("     ");
    scoreboard.blankLine();
    scoreboard.add(" " );
    scoreboard.add("  ");
    scoreboard.add("      ");
    scoreboard.blankLine();
    scoreboard.add("");
    scoreboard.build();
    scoreboard.send(new Player[] { p });
    
    p.setScoreboard((org.bukkit.scoreboard.Scoreboard) scoreboard);
  }
}
