package me.ninjay.olympiclobby.eventos;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.olympiclobby.api.LoginAPI;
import me.ninjay.olympiclobby.comandos.ComandoRegister;
import me.ninjay.olympiclobby.main.Main;
import me.ninjay.olympiclobby.utils.Mine;


public class EventosGlobal implements Listener{
	
	public static ItemStack bus = Mine.newItem(Material.COMPASS, "§eServidores");

	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		LoginAPI.entrar(p, ComandoRegister.config);
		Mine.sendTitle(p, "§b§lOLYMPIC", "§f>> Rede de servidores <<", 20, 100, 20);
		Mine.setTabList(p, "\n§b§lOLYMPIC\n§f      Ajude o servidor comprando vip ou cash.\n ", "\n \n§6Discord: §eEm Breve\n§6Loja: §eEm Breve\n§6Twitter: §eEm Breve\n ");
        e.setJoinMessage(null);
        p.setFoodLevel(999999999);
        if(Main.config.contains("spawn")) {
        p.teleport(Main.config.getLocation("spawn"));
	}else {
		return;
	}
	}
	@EventHandler
	public void aoPegar(PlayerPickupItemEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void aoDano(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
		e.setCancelled(true);
		}else {
			e.setCancelled(false);
		}
	}
	
	@EventHandler
	public void aoSair(PlayerQuitEvent e) {
		e.setQuitMessage(null);
	}
	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if(LoginAPI.logando.contains(p)) {
			if(e.getMessage().contains("/login") || e.getMessage().contains("/register")) {
				e.setCancelled(false);
				return;
			}else {
				e.setCancelled(true);
				p.sendMessage("§cVocê não pode usar comandos enquanto loga");
			}
		}
		
		
	}
	@EventHandler
	public void aoAndar(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(LoginAPI.logando.contains(p)) {
			e.setCancelled(true);
			return;
		}else {
			e.setCancelled(false);
		}
	}
	
	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void aoColocar(BlockPlaceEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void aoFalar(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		if(LoginAPI.logando.contains(p)) {
			e.setCancelled(true);
			p.sendMessage("§cVocê não pode falar enquanto loga.");
			return;
		}else {
			e.setCancelled(false);
			e.setFormat("§a"+p.getName()+" >> §7"+e.getMessage());
		}
	}
	
	@EventHandler
	public void aoDropar(PlayerDropItemEvent e) {
		e.setCancelled(true);
	}
	@EventHandler
	public void aoClicarBus(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(p.getItemInHand() == null) {
			return;
		}
		if(!p.getItemInHand().isSimilar(bus)) {
			return;
		}
		if(p.getItemInHand().isSimilar(bus)) {
			Inventory inv = Mine.newInventory("Servidores", 9*3);
			ItemStack p4 = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§eRankUP", 1, 0, " "," §7* Servidor revolucionário"," ");
			ItemStack nan = Mine.newItem(Material.BARRIER, "§eEm Breve");
			
			inv.setItem(Mine.getPosition(2, 5), p4);
			inv.setItem(Mine.getPosition(2, 2), nan);
			inv.setItem(Mine.getPosition(2, 8), nan);
			
			p.openInventory(inv);
		}
				
	}
	@EventHandler
	public void aoClicarInvBus(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack p4 = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§eRankUP", 1, 0, " "," §7* Servidor revolucionário"," ");
		
		if(e.getInventory().getTitle().equals("Servidores")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(p4)) {
				p.chat("/conectar");
			}else {
				return;
			}
		}
	}
	
}
