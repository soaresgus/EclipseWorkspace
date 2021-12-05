package me.ninjay.safecore.eventos;

import java.util.HashMap;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.safecore.comandos.chat.ComandoGlobal;
import me.ninjay.safecore.comandos.chat.ComandoLocal;
import me.ninjay.safecore.estruturas.timer.TimerAPI;
import me.ninjay.safecore.main.Main;
import me.ninjay.safecore.utils.BukkitConfig;
import me.ninjay.safecore.utils.Mine;

public class EventosGeral implements Listener {

	public static BukkitConfig config = new BukkitConfig("online.yml", Main.getInstance());
	public static HashMap<Location, Integer> tempos = new HashMap<>();
	private static Integer ei;
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		Mine.setTabList(p,
				"\n §6§lSAFE CLUB\n§f    safeclub.com\n \n§e§lNOVIDADE: §e" + Main.config.getString("novidade") + "\n ",
				"\n §eFórum: §f" + Main.config.getString("forum") + "\n§eTwitter: §f" + Main.config.getString("twitter")
						+ "\n§eDiscord: §f" + Main.config.getString("discord")
						+ "\n \n§6  Adquira vip e ajude o servidor acessando: §f" + Main.config.getString("loja")
						+ "  \n ");
		ComandoGlobal.rep.put(p, "null");
		ComandoLocal.rep.put(p, "null");
		
		p.teleport(Main.config.getLocation("spawn"));

		TimerAPI.timer(0L, config, Main.getInstance(), p.getName());
	}
	
	@EventHandler
	public void aoRenascer(PlayerRespawnEvent e) {
		new BukkitRunnable() {
			
			@Override
			public void run() {
				e.getPlayer().teleport(Main.config.getLocation("spawn"));
			}
		}.runTaskLaterAsynchronously(Main.getInstance(), 2);
	}
	
	@EventHandler
	public void aoQuebrarS(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(e.getBlock().getType() == Material.MOB_SPAWNER) {
			if(tempos.containsKey(e.getBlock().getLocation())) {
				if(tempos.get(e.getBlock().getLocation()) > 0) {
					e.setCancelled(true);
					p.sendMessage("§cEsse spawner está bloqueado! Aguarde: "+Mine.formatarTempoMS(ei));
				}
			}
		}
	}
	
}
