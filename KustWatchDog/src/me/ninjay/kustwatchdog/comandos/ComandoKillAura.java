package me.ninjay.kustwatchdog.comandos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.kustlogs.estruturas.LogsAPI;
import me.ninjay.kustwatchdog.main.Main;
import me.ninjay.kustwatchdog.utils.Mine;

public class ComandoKillAura implements CommandExecutor, Listener{
	
	private static HashMap<Player, Player> save = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(p.hasPermission("watchdog.perm")) {
				if(args.length <= 0) {
					p.sendMessage("§cUse: /killaura <player>.");
					return true;
				}
				
				Player j = Bukkit.getPlayer(args[0]);
				if(j != null) {
					save.put(j, p);
					double rotation = j.getLocation().getYaw() - 180;
			        if (rotation < 0) {
			            rotation += 360.0;
			        }
			        if (0 <= rotation && rotation < 22.5) {
			        	Location loc = new Location(j.getWorld(), j.getLocation().getX(), j.getLocation().getY()+0.3, j.getLocation().getZ()+0.5);
			        	Zombie zomb = (Zombie) j.getWorld().spawn(loc, Zombie.class);
						zomb.setBaby(true);
						zomb.setCustomName(".");
						zomb.setCustomNameVisible(false);
						Mine.disableAI(zomb);
						zomb.setHealth(1);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								zomb.remove();
							}
						}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
			        }
			        if (22.5 <= rotation && rotation < 67.5) {
			        	Location loc = new Location(j.getWorld(), j.getLocation().getX()-0.5, j.getLocation().getY()+0.3, j.getLocation().getZ());
			        	Zombie zomb = (Zombie) j.getWorld().spawn(loc, Zombie.class);
						zomb.setBaby(true);
						zomb.setCustomName(".");
						zomb.setCustomNameVisible(false);
						Mine.disableAI(zomb);
						zomb.setHealth(1);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								zomb.remove();
							}
						}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
			        }
			        if (67.5 <= rotation && rotation < 112.5) {
			        	Location loc = new Location(j.getWorld(), j.getLocation().getX()-0.5, j.getLocation().getY()+0.3, j.getLocation().getZ());
			        	Zombie zomb = (Zombie) j.getWorld().spawn(loc, Zombie.class);
						zomb.setBaby(true);
						zomb.setCustomName(".");
						zomb.setCustomNameVisible(false);
						Mine.disableAI(zomb);
						zomb.setHealth(1);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								zomb.remove();
							}
						}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
			        }
			        if (157.5 <= rotation && rotation < 202.5) {
			        	Location loc = new Location(j.getWorld(), j.getLocation().getX(), j.getLocation().getY()+0.3, j.getLocation().getZ()-0.5);
			        	Zombie zomb = (Zombie) j.getWorld().spawn(loc, Zombie.class);
						zomb.setBaby(true);
						zomb.setCustomName(".");
						zomb.setCustomNameVisible(false);
						Mine.disableAI(zomb);
						zomb.setHealth(1);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								zomb.remove();
							}
						}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
			        }

			        if (247.5 <= rotation && rotation < 292.5) {
			        	Location loc = new Location(j.getWorld(), j.getLocation().getX()+0.5, j.getLocation().getY()+0.3, j.getLocation().getZ());
			        	Zombie zomb = (Zombie) j.getWorld().spawn(loc, Zombie.class);
						zomb.setBaby(true);
						zomb.setCustomName(".");
						zomb.setCustomNameVisible(false);
						Mine.disableAI(zomb);
						zomb.setHealth(1);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								zomb.remove();
							}
						}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
			        }
			        
			        if (112.5 <= rotation && rotation < 157.5) {
			        	Location loc = new Location(j.getWorld(), j.getLocation().getX(), j.getLocation().getY()+0.3, j.getLocation().getZ()-0.5);
			        	Zombie zomb = (Zombie) j.getWorld().spawn(loc, Zombie.class);
						zomb.setBaby(true);
						zomb.setCustomName(".");
						zomb.setCustomNameVisible(false);
						Mine.disableAI(zomb);
						zomb.setHealth(1);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								zomb.remove();
							}
						}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
			        }
			        if (202.5 <= rotation && rotation < 247.5) {
			        	Location loc = new Location(j.getWorld(), j.getLocation().getX()+0.5, j.getLocation().getY()+0.3, j.getLocation().getZ());
			        	Zombie zomb = (Zombie) j.getWorld().spawn(loc, Zombie.class);
						zomb.setBaby(true);
						zomb.setCustomName(".");
						zomb.setCustomNameVisible(false);
						Mine.disableAI(zomb);
						zomb.setHealth(1);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								zomb.remove();
							}
						}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
			        }
			        
			        if (292.5 <= rotation && rotation < 337.5) {
			        	Location loc = new Location(j.getWorld(), j.getLocation().getX(), j.getLocation().getY()+0.3, j.getLocation().getZ()+0.5);
			        	Zombie zomb = (Zombie) j.getWorld().spawn(loc, Zombie.class);
						zomb.setBaby(true);
						zomb.setCustomName(".");
						zomb.setCustomNameVisible(false);
						Mine.disableAI(zomb);
						zomb.setHealth(1);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								zomb.remove();
							}
						}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
			        }
			        
			        if (337.5 <= rotation && rotation <= 360) {
			        	Location loc = new Location(j.getWorld(), j.getLocation().getX(), j.getLocation().getY()+0.3, j.getLocation().getZ()+0.5);
			        	Zombie zomb = (Zombie) j.getWorld().spawn(loc, Zombie.class);
						zomb.setBaby(true);
						zomb.setCustomName(".");
						zomb.setCustomNameVisible(false);
						Mine.disableAI(zomb);
						zomb.setHealth(1);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								zomb.remove();
							}
						}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
			        }
				}else {
					p.sendMessage("§cJogador offline.");
				}
			}
			
		}
		return false;
	}
	
	@EventHandler
	public void aoMatar(EntityDeathEvent e) {
		
		if(e.getEntity().getKiller().getType() == EntityType.PLAYER) {
			if(e.getEntity().getCustomName() != null) {
			if(e.getEntity().getCustomName().equalsIgnoreCase(".")) {
				e.getDrops().clear();
			if(save.get(e.getEntity().getKiller()) != null) {
				LogsAPI.register(e.getEntity().getKiller().getName(), "KillAura de MOBS", me.ninjay.kustlogs.main.Main.playerGeral);
				save.get(e.getEntity().getKiller()).sendMessage("§c§lRelátorio - Kill Aura\n \n§cO jogador §c§l"+e.getEntity().getKiller().getName()+" §cretornou §c§lpositvo\n§cpara kill aura de §c§lMOBS§c.\n ");
				save.remove(e.getEntity().getKiller());
			}
			}else {
				return;
			}
			}
		}
	}

}
