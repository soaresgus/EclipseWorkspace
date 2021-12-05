package me.ninjay.kustlogs.eventos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.kustlogs.estruturas.DataAPI;
import me.ninjay.kustlogs.estruturas.LogsAPI;
import me.ninjay.kustlogs.main.Main;
import me.ninjay.kustlogs.utils.Mine;

public class EventosRegistro implements Listener{

	private static HashMap<Player, Location> save = new HashMap<>();
	
	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		
		if(!p.hasPermission("logs.staff")) {
			if(!e.getMessage().startsWith("/g ")) {
				if(!e.getMessage().startsWith("/l ")) {
					LogsAPI.register(p.getName(), e.getMessage(), Main.playerComando);
				}else {
					LogsAPI.register(p.getName(), "[l] "+e.getMessage(), Main.playerChat);
				}
			}else {
				LogsAPI.register(p.getName(), "[g] "+e.getMessage(), Main.playerChat);
			}
		}else {
			if(!e.getMessage().startsWith("/g ")) {
				if(!e.getMessage().startsWith("/l ")) {
					LogsAPI.register(p.getName(), e.getMessage(), Main.staffComando);
				}else {
					LogsAPI.register(p.getName(), "[l] "+e.getMessage(), Main.staffChat);
				}
			}else {
				LogsAPI.register(p.getName(), "[g] "+e.getMessage(), Main.staffChat);
			}
		}
	}
	
	@EventHandler
	public void aoFalar(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
	if(!e.getMessage().startsWith("/g ")) {
		if(!p.hasPermission("logs.staff")) {
			LogsAPI.register(p.getName(), "[l] "+e.getMessage(), Main.playerChat);
		}else {
			LogsAPI.register(p.getName(), "[l] "+e.getMessage(), Main.staffChat);
		}
	}
	}
	
	@EventHandler
	public void aoAbrir(InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer();

	if(save.containsKey(p)) {
			for(ItemStack itens : e.getInventory().getContents()) {
			if(itens != null) {
				if(itens.getType() != Material.AIR) {
					LogsAPI.register(p.getName(), p.getName()+" x: "+Mine.toInt(p.getLocation().getX())+" y: "+Mine.toInt(p.getLocation().getY())+" z: "+Mine.toInt(p.getLocation().getZ())+" item: "+itens.getType()+" "+itens.getItemMeta().getDisplayName()+" "+itens.getAmount()+"x", Main.playerBau);
					save.remove(p);
				}
			}
			}
		}
	}
	
	@EventHandler
	public void aoBau(PlayerInteractEvent e) {
		Player p = (Player) e.getPlayer();
		
	if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
		if(e.getClickedBlock().getType() == Material.CHEST || e.getClickedBlock().getType() == Material.TRAPPED_CHEST || e.getClickedBlock().getType() == Material.ENDER_CHEST) {
			save.remove(p);
			save.put(p, p.getLocation());
		}
	}
	}
	
	@EventHandler
	public void aoMorrer(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player k = e.getEntity().getKiller();
		
		LogsAPI.register(p.getName(), p.getName()+" foi morto por "+k.getName(), Main.playerGeral);
		LogsAPI.register(k.getName(), k.getName()+" matou "+p.getName(), Main.playerGeral);
	}
	
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		LogsAPI.register(p.getName(), p.getName()+" entrou no servidor.", Main.playerGeral);
	}
	
	@EventHandler
	public void aoSair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		LogsAPI.register(p.getName(), p.getName()+" saiu do servidor.", Main.playerGeral);
	}
	
}
