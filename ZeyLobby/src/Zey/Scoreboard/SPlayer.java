package Zey.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;

import Zey.Lobby.Account.Grupos;
import Zey.Lobby.Config.ZeyCoins;

public class SPlayer
{
    private String player;
    private ScoreB sb;
    
    public SPlayer(final String player) {
        this.player = player;
        (this.sb = new ScoreB()).setSlot(DisplaySlot.SIDEBAR);
        this.sb.setName("  §6§lZey§f§lNetwork  ");
        this.sb.addLine(15, "  §c ");
        this.sb.addLine(14, "  §fGrupo: ");
        this.sb.addLine(13, "  §fZeyCoins: §a0");
        this.sb.addLine(12, "  §c ");
        this.sb.addLine(11, "  §fJogadores: §7");
        this.sb.addLine(10, "  §c ");
        this.sb.addLine(9, "§e      zeynetwork.tk  ");
    }
    
    @SuppressWarnings("deprecation")
	public synchronized void updateScoreboard() {
        if (!this.sb.hasBoard(this.getPlayer())) {
            this.sb.setForPlayer(this.getPlayer());
            
        }
        final Player p = Bukkit.getPlayer(player);
		this.sb.updateLine(14, "  §fGrupo: " + Grupos.getGrupos(p));
		this.sb.updateLine(13, "  §fZeyCoins: §a" + ZeyCoins.getPlayerMoney(p) + "  ");
        this.sb.updateLine(11, "  §fJogadores: §7" + Bukkit.getOnlinePlayers().length + "§f/§7150  ");
    }
    
    public Player getPlayer() {
        return Bukkit.getPlayer(this.player);
    }
}
