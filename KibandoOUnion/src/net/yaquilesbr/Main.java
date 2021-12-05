package net.yaquilesbr;

import com.gmail.nossr50.api.ExperienceAPI;
import com.massivecraft.factions.entity.BoardColl;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.massivecore.ps.PS;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import net.milkbowl.vault.economy.Economy;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import org.black_ixx.playerpoints.PlayerPoints;
import org.black_ixx.playerpoints.PlayerPointsAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

@SuppressWarnings("unused")
public class Main
  extends JavaPlugin
  implements Listener
{
  Map<Player, Integer> poder;
  public PlayerPoints playerPoints;
  public Economy economy;
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
public Main()
  {
    this.poder = new HashMap();
  }
  
  private boolean hookPlayerPoints()
  {
    Plugin plugin = getServer().getPluginManager().getPlugin("PlayerPoints");
    this.playerPoints = ((PlayerPoints)PlayerPoints.class.cast(plugin));
    return this.playerPoints != null;
  }
  
  private PlayerPoints getPlayerPoints()
  {
    return this.playerPoints;
  }
  NumberFormat nf = new DecimalFormat("#,##0.0", new DecimalFormatSymbols(new Locale("pt", "BR")));
private Object coins;
  
  @EventHandler
  public void onTeleport(PlayerTeleportEvent e)
  {
    Player p = e.getPlayer();
    MPlayer mplayer = MPlayer.get(p);
    int powerplayer = (int)mplayer.getPower();
    if (!this.poder.containsKey(p))
    {
      this.poder.put(p, Integer.valueOf(powerplayer));
      atualizarScore(p, null);
    }
    else if (((Integer)this.poder.get(p)).intValue() != powerplayer)
    {
      atualizarScore(p, null);
    }
    Location to = e.getTo();
    Faction zonatof = BoardColl.get().getFactionAt(PS.valueOf(to));
    String zonatos = zonatof.getName();
    Location from = e.getFrom();
    Faction zonafromf = BoardColl.get().getFactionAt(PS.valueOf(from));
    String zonafroms = zonafromf.getName();
    if (!zonafroms.equalsIgnoreCase(zonatos)) {
      atualizarScore(e.getPlayer(), to);
    }
  }
  
  
  private boolean setupEconomy()
  {
    RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
    if (economyProvider != null) {
      this.economy = ((Economy)economyProvider.getProvider());
    }
    return this.economy != null;
  }
  
  @SuppressWarnings("rawtypes")
@EventHandler
  public void onCommandEvent(PlayerCommandPreprocessEvent e)
  {
    @SuppressWarnings("unchecked")
	ArrayList<Player> players = new ArrayList();
    if ((e.getMessage().contains("/points me")) || (e.getMessage().contains("/money")) || (e.getMessage().contains("/spawn")))
    {
      e.setCancelled(true);
      e.getPlayer().performCommand(e.getMessage().replaceFirst("/", ""));
      atualizarScore(e.getPlayer(), null);
      for (Player loop : Bukkit.getOnlinePlayers()) {
        if (e.getMessage().contains(loop.getName())) {
          atualizarScore(loop, null);
        }
      }
    }
    else if (e.getMessage().contains("/f"))
    {
      String[] m = e.getMessage().split(" ");
      if (m[0].equalsIgnoreCase("/f"))
      {
        Faction facloopa;
        for (Player loopplayer : Bukkit.getOnlinePlayers())
        {
          MPlayer mplayerloop = MPlayer.get(loopplayer);
          facloopa = mplayerloop.getFaction();
          MPlayer mpcommanda = MPlayer.get(e.getPlayer());
          Faction faccommanda = mpcommanda.getFaction();
          if (facloopa == faccommanda)
          {
            players.add(loopplayer);
            atualizarScore(loopplayer, null);
          }
        }
        e.setCancelled(true);
        e.getPlayer().performCommand(e.getMessage().replaceFirst("/", ""));
        for (Player loopplayerd : Bukkit.getOnlinePlayers()) {
          if (players.contains(loopplayerd)) {
            atualizarScore(loopplayerd, null);
          }
        }
        MPlayer mpcommand = MPlayer.get(e.getPlayer());
        Faction faccommand = mpcommand.getFaction();
        if (mpcommand.hasFaction()) {
          for (Player jogador : Bukkit.getOnlinePlayers())
          {
            MPlayer mploop = MPlayer.get(jogador);
            Faction facloop = mploop.getFaction();
            if (faccommand == facloop) {
              atualizarScore(jogador, null);
            }
          }
        } else {
          for (Player jogador : Bukkit.getOnlinePlayers())
          {
            MPlayer mploop = MPlayer.get(jogador);
            Faction facloop = mploop.getFaction();
            if (faccommand == facloop) {
              atualizarScore(jogador, null);
            }
          }
        }
        atualizarScore(e.getPlayer(), null);
      }
    }
  }
  
  @EventHandler
  public void onJoin(PlayerJoinEvent e)
  {
    if (e.getPlayer().hasMetadata("Saiu")) {
      e.getPlayer().removeMetadata("Saiu", this);
    }
    atualizarScore(e.getPlayer(), null);
    Player p = e.getPlayer();
    MPlayer mp = MPlayer.get(p);
    if (mp.hasFaction())
    {
      Faction facmp = mp.getFaction();
      for (Player player : Bukkit.getOnlinePlayers())
      {
        MPlayer mplayer = MPlayer.get(player);
        Faction factionmp = mplayer.getFaction();
        if (facmp == factionmp) {
          atualizarScore(player, null);
        }
      }
    }
  }
  
  @EventHandler
  public void onLeft(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    p.setMetadata("Saiu", new FixedMetadataValue(this, null));
    MPlayer mp = MPlayer.get(p);
    if (mp.hasFaction())
    {
      Faction facmp = mp.getFaction();
      for (Player player : Bukkit.getOnlinePlayers())
      {
        MPlayer mplayer = MPlayer.get(player);
        Faction factionmp = mplayer.getFaction();
        if (facmp == factionmp) {
          atualizarScore(player, null);
        }
      }
    }
  }
  
  public void onEnable()
  {
    ConsoleCommandSender inicio = Bukkit.getConsoleSender();
    inicio.sendMessage("§aPlugin iniciado");
    inicio.sendMessage("");
    getServer().getPluginManager().registerEvents(this, this);
    setupEconomy();
    hookPlayerPoints();
  }
  
  public void onDisable()
  {
    Bukkit.getConsoleSender().sendMessage("§c[UnionScore] Desabilitado");
  }
  
  @EventHandler
  public void onMove(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    MPlayer mplayer = MPlayer.get(p);
    Faction f = mplayer.getFaction();
    int powerplayer = (int)mplayer.getPower();
    if (!this.poder.containsKey(p))
    {
      this.poder.put(p, Integer.valueOf(powerplayer));
      if (mplayer.hasFaction()) {
        for (Player loop : Bukkit.getOnlinePlayers())
        {
          MPlayer mploop = MPlayer.get(loop);
          Faction floop = mploop.getFaction();
          if (f == floop) {
            atualizarScore(loop, null);
          }
        }
      }
      atualizarScore(p, null);
    }
    else if (((Integer)this.poder.get(p)).intValue() != powerplayer)
    {
      this.poder.remove(p);
      this.poder.put(p, Integer.valueOf(powerplayer));
      atualizarScore(p, null);
      e.isAsynchronous();
    }
    Location to = e.getTo();
    Faction zonatof = BoardColl.get().getFactionAt(PS.valueOf(to));
    String zonatos = zonatof.getName();
    Location from = e.getFrom();
    Faction zonafromf = BoardColl.get().getFactionAt(PS.valueOf(from));
    String zonafroms = zonafromf.getName();
    if (!zonafroms.equalsIgnoreCase(zonatos)) {
      atualizarScore(e.getPlayer(), to);
    }
  }
  
  @SuppressWarnings("deprecation")
public void atualizarScore(Player p, @Nullable Location to)
  {
    if (to == null) {
      to = p.getLocation();
    }
    Faction faczona = BoardColl.get().getFactionAt(PS.valueOf(to));
    String zonafac = faczona.getName();
    MPlayer mplayer = MPlayer.get(p);
    Faction faction = mplayer.getFaction();
    String factionnome = faction.getName();
    int powerplayer = (int)mplayer.getPower();
    int powermaxplayer = (int)mplayer.getPowerMax();
    int power = (int)faction.getPower();
    int terras = faction.getLandCount();
    int powermax = (int)faction.getPowerMax();
    int faconline = 0;
    int skill = ExperienceAPI.getPowerLevelOffline(p.getUniqueId());
    int pontos = playerPoints.getAPI().look(p.getPlayer().getName());
    for (Player jogador : Bukkit.getOnlinePlayers())
    {
      MPlayer mjogador = MPlayer.get(jogador);
      Faction fjogador = mjogador.getFaction();
      if ((fjogador == faction) && (!jogador.hasMetadata("Saiu"))) {
        faconline++;
      }
    }
    int faconlinemax = faction.getMPlayers().size();
    int money = (int)this.economy.getBalance(p.getName());
    int balance = this.playerPoints.getAPI().look(p.getPlayer().getName());
    if (mplayer.hasFaction())
    {
      Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
      Objective objetivo = score.registerNewObjective("teste", "dummy");
      objetivo.setDisplaySlot(DisplaySlot.SIDEBAR);
      objetivo.setDisplayName("      §f§lFACTIONS ASTRAL  ");
      objetivo.getScore(Bukkit.getOfflinePlayer("       §7" + zonafac + "  ")).setScore(12);
      objetivo.getScore(Bukkit.getOfflinePlayer("§a")).setScore(11);
      objetivo.getScore(Bukkit.getOfflinePlayer("  §fKDR: §70.0")).setScore(10);
      objetivo.getScore(Bukkit.getOfflinePlayer("§e")).setScore(9);
      objetivo.getScore(Bukkit.getOfflinePlayer(" §7" + factionnome)).setScore(8);
      objetivo.getScore(Bukkit.getOfflinePlayer("   §fMembros: §7" + faconline + "/" + faconlinemax)).setScore(7);
      objetivo.getScore(Bukkit.getOfflinePlayer("   §fPoder: §7" + power + "/" + powermax)).setScore(6);
      objetivo.getScore(Bukkit.getOfflinePlayer("   §fTerras: §7" + terras)).setScore(5);
      objetivo.getScore(Bukkit.getOfflinePlayer("§6§l")).setScore(4);
      objetivo.getScore(Bukkit.getOfflinePlayer("  §fMoedas: §e" + this.nf.format(money))).setScore(3);
      objetivo.getScore(Bukkit.getOfflinePlayer("  §fCash: §6" + this.nf.format(pontos))).setScore(2);
      objetivo.getScore(Bukkit.getOfflinePlayer("§5")).setScore(1);
      objetivo.getScore(Bukkit.getOfflinePlayer(" §6rede-union.com ")).setScore(0);
      p.setScoreboard(score);
    }
    else
    {
      Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
      Objective objetivo = score.registerNewObjective("teste", "dummy");
      objetivo.setDisplaySlot(DisplaySlot.SIDEBAR);
      objetivo.setDisplayName("      §f§lFACTIONS ASTRAL  ");
      objetivo.getScore(Bukkit.getOfflinePlayer("       §7" + zonafac + "  ")).setScore(9);
      objetivo.getScore(Bukkit.getOfflinePlayer("§a")).setScore(8);
      objetivo.getScore(Bukkit.getOfflinePlayer("  §fKDR: §70.0")).setScore(7);
      objetivo.getScore(Bukkit.getOfflinePlayer("§e")).setScore(6);
      objetivo.getScore(Bukkit.getOfflinePlayer("  §7Sem Facção")).setScore(5);
      objetivo.getScore(Bukkit.getOfflinePlayer("§6§l")).setScore(4);
      objetivo.getScore(Bukkit.getOfflinePlayer("  §fMoedas: §e" + this.nf.format(money))).setScore(3);
      objetivo.getScore(Bukkit.getOfflinePlayer("  §fCash: §6" + this.nf.format(pontos))).setScore(2);
      objetivo.getScore(Bukkit.getOfflinePlayer("§6")).setScore(1);
      objetivo.getScore(Bukkit.getOfflinePlayer(" §6rede-union.com ")).setScore(0);
      p.setScoreboard(score);
    }
  }
}
