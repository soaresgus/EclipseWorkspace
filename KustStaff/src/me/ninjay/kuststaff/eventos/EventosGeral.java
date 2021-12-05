package me.ninjay.kuststaff.eventos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.kuststaff.comandos.ComandoVanish;
import me.ninjay.kuststaff.estruturas.DataAPI;
import me.ninjay.kuststaff.main.Main;
import me.ninjay.kuststaff.utils.Mine;
import me.ninjay.kusttags.estruturas.TagsAPI;
import me.ninjay.kusttags.estruturas.TagsControler;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class EventosGeral implements Listener{
	
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if(!Main.config.contains(p.getName()+".nick")) {
			Main.config.set(p.getName()+".nick", p.getName());
			Main.config.saveConfig();
		}
		new BukkitRunnable() {
			
			@Override
			public void run() {
				Main.config.set(p.getName()+".cargo", TagsControler.getTag(p));
				Main.config.saveConfig();
			}
		}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 5);
			Main.config.set(p.getName()+".ultimo", DataAPI.getCompostoDMA()+" "+DataAPI.getCompostoHMS());
			Main.config.saveConfig();
			if(!Main.config.contains(p.getName()+".primeiro")) {
				Main.config.set(p.getName()+".primeiro", DataAPI.getCompostoDMA()+" "+DataAPI.getCompostoHMS());
				Main.config.saveConfig();
			}
			Main.config.set(p.getName()+".ip", Mine.getIp(p));
			Main.config.saveConfig();
			List<String> nicksl = (List<String>)Main.getPlugin(Main.class).getConfig().get("ip."+Mine.toString(Mine.getIp(p)).replace(".", "-"));
		if(nicksl == null) {
			List<String> nicks = new ArrayList<>();
			nicks.add(p.getName());
			Main.getPlugin(Main.class).getConfig().set("ip."+Mine.toString(Mine.getIp(p)).replace(".", "-"), nicks);
			Main.getPlugin(Main.class).saveConfig();
			Main.getPlugin(Main.class).reloadConfig();
		}else if(!nicksl.contains(p.getName())){
			nicksl.add(p.getName());
			Main.getPlugin(Main.class).getConfig().set("ip."+Mine.toString(Mine.getIp(p)).replace(".", "-"), nicksl);
			Main.getPlugin(Main.class).saveConfig();
			Main.getPlugin(Main.class).reloadConfig();
		}
	}

	@EventHandler
	public void aoAndar(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(ComandoVanish.ativo.contains(p)) {
			Mine.sendActionBar(p, "§aVocê está no modo vanish!");
		}
	}
	
}
