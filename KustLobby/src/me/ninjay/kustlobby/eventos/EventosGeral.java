package me.ninjay.kustlobby.eventos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.WorldEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.nickuc.login.api.nLoginAPI;
import com.nickuc.login.api.events.AsyncAuthenticateEvent;

import me.ninjay.kustlobby.main.Main;
import me.ninjay.kustlobby.utils.Mine;
import me.ninjay.kusttags.estruturas.TagsControler;

public class EventosGeral implements Listener{
public static ArrayList<Player> chat = new ArrayList<>();
	
	public static ItemStack compass = Mine.newItem(Material.COMPASS, "§aEscolha o servidor", 1, 0, "");
	public static ItemStack pon = Mine.newItem(Material.INK_SACK, "§aEsconder jogadores", 1, 10, "");
	public static ItemStack poff = Mine.newItem(Material.INK_SACK, "§cMostrar jogadores", 1, 8, "");
	
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		
		p.setMaxHealth(2);
		p.setHealth(2);
		
		Mine.setTabList(p, "\n§b                §lKUST NETWORK              \n§e"+Main.config.getString("site")+"\n ", "\n§fDiscord: §e"+Main.config.getString("discord")+"\n§fTwitter: §e"+Main.config.getString("twitter")+"\n§fLoja: §e"+Main.config.getString("loja")+"\n ");
		
		p.setGameMode(GameMode.ADVENTURE);
		
		p.getServer().dispatchCommand(p.getServer().getConsoleSender(), "time set day");
		
	}
	
	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e){
	  e.setCancelled(e.toWeatherState());
	}
	
	@EventHandler
	public void canPickup(PlayerPickupItemEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void noUproot(PlayerInteractEvent event)
	{
	    if(event.getAction() == Action.PHYSICAL && event.getClickedBlock().getType() == Material.SOIL)
	        event.setCancelled(true);
	}
	
	@EventHandler
	public void aoLogar(AsyncAuthenticateEvent e) {
		Player p = e.getPlayer();
		new BukkitRunnable() {
			
			@Override
			public void run() {
					Mine.sendTitle(p, "§b§lKUST NETWORK", "§fBem vindo, "+p.getName()+"!", 10, 100, 10);
					Mine.clearInventory(p);
					p.getInventory().setItem(Mine.getPosition(1, 4), compass); 
					p.getInventory().setItem(Mine.getPosition(1, 6), pon); 
					if(p.hasPermission("lobby.anuncio")) {
						Bukkit.broadcastMessage(TagsControler.getTag(p)+p.getName()+" §6entrou nesse lobby!");
					}
			}
		}.runTaskLater(Main.getPlugin(Main.class), 5);
	}

	@EventHandler
	public void Fome (FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void aoDano(EntityDamageEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void chat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		e.setCancelled(true);
	
		//if(nLoginAPI.getApi().isAuthenticated(p) == true) {
			//if(!chat.contains(p)) {
			//	Bukkit.broadcastMessage("§7"+p.getName()+"§8 ⋙ "+"§f"+e.getMessage());
				//chat.add(p);
				//new BukkitRunnable() {
					
				//	@Override
				//	public void run() {
				//		chat.remove(p);
				//	}
			//	}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 10*20);
		//	}else {
		//		p.sendMessage("§cAguarde para digitar novamente.");
		//	}
		//}
	}
	
	@EventHandler
	public void aoDropar(PlayerDropItemEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		e.setCancelled(true);
		
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().contains("Escolha um servidor")) {
			if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eFactions")) {
						p.closeInventory();
						p.chat("/conectar factions");
					}
				}
			}
		}
	}
	
	@EventHandler
	public void aoColocar(BlockPlaceEvent e) {
		if(!e.getPlayer().hasPermission("build.perm")) {
			e.setCancelled(true);
		}else {
			e.setCancelled(false);
		}
	}
	
	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		if(!e.getPlayer().hasPermission("build.perm")) {
		e.setCancelled(true);
	}else {
		e.setCancelled(false);
	}
	}
	
	@EventHandler
	public void aoInteragir(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(p.getItemInHand().getItemMeta() != null) {
			if(p.getItemInHand().isSimilar(pon)) {
			new BukkitRunnable() {
				
				@Override
				public void run() {
					p.getInventory().setItem(Mine.getPosition(1, 6), poff);
					p.updateInventory();
					p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
					
					for(Player todos : Bukkit.getOnlinePlayers()) {
						p.hidePlayer(todos);
					}
				}
			}.runTaskLater(Main.getPlugin(Main.class), 3);
			}
			if(p.getItemInHand().isSimilar(poff)) { 
				new BukkitRunnable() {
					
					@Override
					public void run() {
						p.getInventory().setItem(Mine.getPosition(1, 6), pon);
						p.updateInventory();
						p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
						
						for(Player todos : Bukkit.getOnlinePlayers()) {
							p.showPlayer(todos);
						}
					}
				}.runTaskLater(Main.getPlugin(Main.class), 3);
			}
			if(p.getItemInHand().isSimilar(compass)) {
				Inventory menu = Mine.newInventory("Escolha um servidor", 9*3);
				ItemStack fac = Mine.newHead("§eFactions Kust", "MHF_TNT2", 1, " ", "  §7◆ Novidades em breve");
				
				menu.setItem(Mine.getPosition(2, 5), fac);
				
				p.openInventory(menu);
			}
		}
		
	}
	
	@EventHandler
	public void aoNpc(PlayerInteractEntityEvent e) {
		if(e.getRightClicked().getName().contains("Factions Kust")) {
			e.getPlayer().chat("/conectar factions");
		}
	}
	
	@EventHandler
	public void aoVoid(PlayerMoveEvent e) {
		if(e.getPlayer().getLocation().getY() <= -1) {
			e.getPlayer().teleport(nLoginAPI.getApi().getSpawnLocation());
		}
	}
	
	@EventHandler
	public void launchPad(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SLIME_BLOCK) {
			new BukkitRunnable() {
				
				@Override
				public void run() {
					p.setVelocity(new Vector(-3, 1, p.getVelocity().getZ()));
				}
			}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 1);
		}
	}
	
	@EventHandler
	 public void onCommandPreProcess(PlayerCommandPreprocessEvent f) {
	  
		if(f.getPlayer().isOp() == false) {
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
	        f.setCancelled(true);
	      }
	    }
	  }
	 }
}
