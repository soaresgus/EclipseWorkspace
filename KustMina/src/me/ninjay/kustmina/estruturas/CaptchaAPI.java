package me.ninjay.kustmina.estruturas;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.kustmina.main.Main;
import me.ninjay.kustmina.utils.Mine;

public class CaptchaAPI implements Listener{
	
	public static HashMap<Player, String> save = new HashMap<>();
	private static HashMap<Player, Integer> saveint = new HashMap<>();
	
	public static void start(Player player, String world, JavaPlugin main) {
			String palavra = Main.config.getString(Mine.toString(Mine.getRandomInt(1, Main.config.getInt("palavras"))));
		if(player.getWorld().getName().equals(world)) {
			if(!saveint.containsKey(player)) {
				saveint.put(player, 300);
			}
			new BukkitRunnable() {
				int i = saveint.get(player);
				@Override
				public void run() {
					if(player.getWorld().getName().equals(world)) {
					i--;
					saveint.put(player, i);
					if(saveint.get(player) <= 0) {
						i = 300;
						saveint.put(player, 300);
						save.remove(player);
						save.put(player, palavra);
						player.sendMessage(" \n§aPara continuar minerando digite a palavra\n \n§a§l"+save.get(player)+"\n \n§aA mineração será liberada quando for digitado em seu chat.");
						}
					}else {
						cancel();
						
					}
				}
				}.runTaskTimerAsynchronously(main, 20, 20);
		}
	}
	
	@EventHandler
	public void aoFalar(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		if(p.getWorld().getName().equals(Main.config.getLocation("membro").getWorld().getName()) || p.getWorld().getName().equals(Main.config.getString("vip"))) {
			if(save.containsKey(p)) {
				if(save.get(p).equals(e.getMessage())) {
					save.remove(p);
					p.sendMessage("§aCaptcha concluido.");
				}else {
					p.sendMessage("§cPalavra incorreta.");
					p.sendMessage(" \n§aPara continuar minerando digite a palavra\n \n§a§l"+save.get(p)+"\n \n§aA mineração será liberada quando for digitado em seu chat.");
				}
			}
		}
	}
	
	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(p.getWorld().getName().equals(Main.config.getLocation("membro").getWorld().getName()) || p.getWorld().getName().equals(Main.config.getString("vip"))) {
			if(save.containsKey(p)) {
				e.setCancelled(true);
			}else {
				e.setCancelled(false);
			}
		}
	}

}
