package Zey.Lobby.Eventos;

import Zey.Lobby.Main.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;
import net.minecraft.server.v1_7_R4.*;
import org.bukkit.event.server.*;
import org.bukkit.event.*;
import org.bukkit.*;
import org.bukkit.Material;

import java.util.*;
import org.bukkit.command.*;
import org.bukkit.event.weather.*;
import org.bukkit.event.player.*;
import org.bukkit.event.entity.*;
import org.bukkit.help.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.block.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.entity.*;
import org.bukkit.entity.Entity;

@SuppressWarnings("unused")
public class Geral implements Listener
{	
	
	  @EventHandler
	  public void onPlayerColor(SignChangeEvent e)
	  {
	    if (e.getLine(0).contains("&")) {
	      e.setLine(0, e.getLine(0).replace("&", "§"));
	    }
	    if (e.getLine(1).contains("&")) {
	      e.setLine(1, e.getLine(1).replace("&", "§"));
	    }
	    if (e.getLine(2).contains("&")) {
	      e.setLine(2, e.getLine(2).replace("&", "§"));
	    }
	    if (e.getLine(3).contains("&")) {
	      e.setLine(3, e.getLine(3).replace("&", "§"));
	    }
	  }
	
    @EventHandler
    public void onMe(final PlayerCommandPreprocessEvent event) {
        final Player p = event.getPlayer();
        if (event.getMessage().toLowerCase().startsWith("/me") 
        		|| event.getMessage().toLowerCase().startsWith("//calc") 
        		|| event.getMessage().toLowerCase().startsWith("/pl")
        		|| event.getMessage().toLowerCase().startsWith("/plugins")
        		|| event.getMessage().toLowerCase().startsWith("/ver")
        		|| event.getMessage().toLowerCase().startsWith("/bukkit")
        		|| event.getMessage().toLowerCase().startsWith("/help")
        		|| event.getMessage().toLowerCase().startsWith("/version")
        		|| event.getMessage().toLowerCase().startsWith("/about")
        		|| event.getMessage().toLowerCase().startsWith("/?")) {
            event.setCancelled(true);
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §cComando não listado");
        }
    }
        @EventHandler
        public void onEntityDamage(final EntityDamageEvent e) {
            e.setCancelled(true);
        }
        
        @EventHandler
        public void onMove(final PlayerMoveEvent e) {
            final Player p = e.getPlayer();
            final Location l = p.getLocation();
            if (l.getBlockY() <= 0) {
                p.teleport(p.getWorld().getSpawnLocation());
                p.playSound(l, Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
            }
        }
        
    @EventHandler
    public void onCreeperSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Creeper) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onSkeletonSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Skeleton) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onSpiderSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Spider) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onWitherSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Wither) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onZombieSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Zombie) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void aoPing(final ServerListPingEvent e) {
        e.setMotd(Main.motd);
        if (Bukkit.hasWhitelist()) {
            e.setMotd(Main.motd2);
        }
    }
    
    @EventHandler
    public void onCheio(final PlayerLoginEvent event) {
        final Player p = event.getPlayer();
        if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            if (p.hasPermission("zey.lobby.slotvip")) {
                event.setResult(PlayerLoginEvent.Result.ALLOWED);
            }
            else {
                event.setKickMessage("§cDesculpe, o servidor está lotado.");
            }
        }
        else if (event.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
            event.setKickMessage("\n \n §cEstamos em manutenção, para sua melhor jogabilidade, retorne em breve!");
        }
    }
    
    @EventHandler
    public void onSlimeSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Slime) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onGhastSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Ghast) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onPigZombieSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof PigZombie) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onEndermanSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Enderman) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onCaveSpiderSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof CaveSpider) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onSheepSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Sheep) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onCowSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Cow) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onChickenSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Chicken) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onSquidSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Squid) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    void chuva(final WeatherChangeEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler
    public void onPickup(final PlayerPickupItemEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler
    public void onDrop(final PlayerDropItemEvent e) {
        e.setCancelled(true);
        if (e.getItemDrop().getItemStack().getType() == Material.COMPASS) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void dropar(final ItemSpawnEvent e) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                e.getEntity().remove();
            }
        }, 50L);
    }
    
    @EventHandler
    public void achivments(final PlayerAchievementAwardedEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler
    public void nohunger(final FoodLevelChangeEvent event) {
        event.setCancelled(true);
        event.setFoodLevel(20);
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onCreeperExplosion(final EntityExplodeEvent event) {
        event.setCancelled(true);
    }
    
    @EventHandler
    public void onUnknown(final PlayerCommandPreprocessEvent event) {
        if (event.isCancelled()) {
            return;
        }
        final Player p = event.getPlayer();
        final String msg = event.getMessage().split(" ")[0];
        final HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
        if (topic == null) {
            event.setCancelled(true);
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §cComando não listado");
        }
    }
   
}
