package me.ninjay.kustwatchdog.eventos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.kustlogs.estruturas.LogsAPI;
import me.ninjay.kustwatchdog.comandos.ComandoAutoClick;
import me.ninjay.kustwatchdog.main.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class EventosGeral implements Listener{
	
	private static HashMap<Player, Integer> clicks = new HashMap<>();
	private static ArrayList<Player> use = new ArrayList<>();
	private static HashMap<Player, Integer> blocos = new HashMap<>();
	private static HashMap<Player, Integer> blocosmine = new HashMap<>();
	private static HashMap<Player, Integer> velo = new HashMap<>();
	
	@EventHandler
	public void aoClicar(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(ComandoAutoClick.usando.containsKey(p)) {
			if(e.getAction() == Action.LEFT_CLICK_AIR) {
				if(!clicks.containsKey(p)) {
					clicks.put(p, 0);
					use.add(p);
					new BukkitRunnable() {
						int i = 11;
						@Override
						public void run() {
							i--;
							if(i <= 0) {
								cancel();
								use.remove(p);
								ComandoAutoClick.usando.get(p).sendMessage("§c§lRelatório - AutoClick\n \n§cO jogador "+p.getName()+" executou um total de\n§c§l"+clicks.get(p)/2+" clicks §cem 10 segundos §c§l("+clicks.get(p)/20+" CPS)§c.\n ");
								ComandoAutoClick.usando.remove(p);
								clicks.remove(p);
							}
						}
					}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
				}else {
				if(use.contains(p)) {
					clicks.put(p, clicks.get(p)+1);
				}
				}
				
			}
		}
		
		if(e.getAction() == Action.LEFT_CLICK_AIR) {
			if(!clicks.containsKey(p)) {
				clicks.put(p, 0);
				use.add(p);
				new BukkitRunnable() {
					int i = 11;
					@Override
					public void run() {
						i--;
						if(i <= 0) {
							cancel();
							use.remove(p);
							if(clicks.get(p) >= 80) {
								LogsAPI.register(p.getName(), "Suspeita de AutoClick", me.ninjay.kustlogs.main.Main.playerGeral);
								for(Player todos : Bukkit.getOnlinePlayers()) {
									if(todos.hasPermission("watchdog.perm")) {
										TextComponent texto = new TextComponent(TextComponent.fromLegacyText("§c§l"+p.getName()+"§c§l - Auto-Click"));
										texto.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cNick: §f"+p.getName()+"\n§cMotivo: §fExecutado "+clicks.get(p)+" clicks em 10 segundos ("+clicks.get(p)/10+" CPS)\n \n§cClique para se teleportar.").create()));
										texto.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tp "+p.getName()));
										todos.spigot().sendMessage(texto);
									}
								}
							}
							clicks.remove(p);
						}
					}
				}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
			}else {
			if(use.contains(p)) {
				clicks.put(p, clicks.get(p)+1);
			}
			}
			
		}
	}
	
	@EventHandler
	public void fastPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		
		if(!blocos.containsKey(p)) {
			blocos.put(p, 0);
			use.add(p);
			new BukkitRunnable() {
				int i = 11;
				@Override
				public void run() {
					i--;
					if(i <= 0) {
						cancel();
						use.remove(p);
						if(blocos.get(p) >= 60) {
							LogsAPI.register(p.getName(), "Suspeita de FastPlace", me.ninjay.kustlogs.main.Main.playerGeral);
							for(Player todos : Bukkit.getOnlinePlayers()) {
								if(todos.hasPermission("watchdog.perm")) {
									TextComponent texto = new TextComponent(TextComponent.fromLegacyText("§c§l"+p.getName()+"§c§l - FastPlace"));
									texto.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cNick: §f"+p.getName()+"\n§cMotivo: §fExecutado "+blocos.get(p)+" blocos em 10 segundos \n \n§cClique para se teleportar.").create()));
									texto.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tp "+p.getName()));
									todos.spigot().sendMessage(texto);
								}
							}
						}
						blocos.remove(p);
					}
				}
			}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
		}else {
		if(use.contains(p)) {
			blocos.put(p, blocos.get(p)+1);
		}
		}
	}
	
	@EventHandler
	public void speedMine(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(!blocosmine.containsKey(p)) {
			blocosmine.put(p, 0);
			use.add(p);
			new BukkitRunnable() {
				int i = 11;
				@Override
				public void run() {
					i--;
					if(i <= 0) {
						cancel();
						use.remove(p);
						if(blocosmine.get(p) >= 28) {
							LogsAPI.register(p.getName(), "Suspeita de SpeedMine", me.ninjay.kustlogs.main.Main.playerGeral);
							for(Player todos : Bukkit.getOnlinePlayers()) {
								if(todos.hasPermission("watchdog.perm")) {
									TextComponent texto = new TextComponent(TextComponent.fromLegacyText("§c§l"+p.getName()+"§c§l - SpeedMine"));
									texto.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cNick: §f"+p.getName()+"\n§cMotivo: §fExecutado "+blocosmine.get(p)+" blocos em 10 segundos \n \n§cClique para se teleportar.").create()));
									texto.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tp "+p.getName()));
									todos.spigot().sendMessage(texto);
								}
							}
						}
						blocosmine.remove(p);
					}
				}
			}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
		}else {
		if(use.contains(p)) {
			if(e.getBlock().getType() == Material.STONE) {
				if(!p.hasPotionEffect(PotionEffectType.FAST_DIGGING)) {
					blocosmine.put(p, blocosmine.get(p)+1);
				}
			}
		}
		}
	}
}
