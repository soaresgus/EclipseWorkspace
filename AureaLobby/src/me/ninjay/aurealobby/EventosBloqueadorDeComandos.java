package me.ninjay.aurealobby;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class EventosBloqueadorDeComandos
  implements Listener
{
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onCommandPreProcess(PlayerCommandPreprocessEvent f)
  {
    String[] msg = f.getMessage().split(" ");
    List<String> pl = new ArrayList<String>();
    pl.add("pl");
    pl.add("plugin");
    pl.add("ver" + msg);
    pl.add("ver");
    pl.add("help");
    pl.add("?");
    pl.add("me");
    pl.add("msg");
    pl.add("minecraft:tell");
    pl.add("bukkit:msg");
    pl.add("bukkit:op");
    pl.add("bukkit:help");
    pl.add("plugins");
    pl.add("bukkit:pl");
    pl.add("bukkit:plugins");
    pl.add("version");
    pl.add("bukkit:w");
    pl.add("w");
    pl.add("bukkit:version");
    pl.add("plugins");
    pl.add("bukkit:plugin");
    pl.add("icanhasbukkit");
    pl.add("bukkit:?");
    pl.add("bukkit:help" + msg);
    pl.add("bukkit:?" + msg);
    pl.add("bukkit:ver");
    pl.add("bukkit:ver" + msg);
    for (String Loop : pl) {
      if (msg[0].equalsIgnoreCase("/" + Loop))
      {
        Player p = f.getPlayer();
        
        p.sendMessage("§cComando bloqueado.");
        
        f.setCancelled(true);
      }
    }
  }
}