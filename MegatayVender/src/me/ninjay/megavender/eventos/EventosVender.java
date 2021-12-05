package me.ninjay.megavender.eventos;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.megavender.main.Main;
import me.ninjay.megavender.utils.Mine;
import me.ninjay.megavender.utils.VaultAPI;

public class EventosVender implements Listener{
	public static ArrayList<Player> lista = new ArrayList<>();
	public static ArrayList<Player> dentro = new ArrayList<>();
	public static void money (Player p, String c) {
		int i = Main.pdrops.getInt(p.getName()+"."+c)*Main.global.getInt(c);
		VaultAPI.getEconomy().depositPlayer(p, i);
		Main.pdrops.set(p.getName()+"ValorTotal", i+Main.pdrops.getInt(p.getName()+"ValorTotal"));
		Main.pdrops.set(p.getName()+"."+c, 0);
		Main.pdrops.set(p.getName()+"Total", 0);
		Main.pdrops.saveConfig();
	}
 	
	@EventHandler
	public void aoClicarVender(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack vender = Mine.newItem(Material.NETHER_STAR, "§eVenda seus drops", 1, 0, " ", "§e * Venda seus drops do /drops");
	    if(e.getInventory().getTitle().equals("Vender /drops")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().isSimilar(vender)) {
					if(Main.pdrops.getInt(p.getName()+"Total") == 0) {
						p.sendMessage("§cNenhum drop para ser vendido.");
						p.getOpenInventory().close();
						return;
					}else {
					money(p, "lapisb");
					money(p, "lapism");
					money(p, "redstoneb");
					money(p, "redstonem");
					money(p, "carvaob");
					money(p, "carvaom");
					money(p, "diamanteb");
					money(p, "diamantem");
					money(p, "esmeraldab");
					money(p, "esmeraldam");
					money(p, "ferro");
					money(p, "magma");
					money(p, "blaze");
					money(p, "polvora");
					money(p, "string");
					money(p, "trigo");
					money(p, "cacau");
					money(p, "melancia");
					money(p, "abobora");
					money(p, "cana");
					money(p, "fungo");
					p.sendMessage("§aSeus drops foram vendidos por: $"+Main.pdrops.getInt(p.getName()+"ValorTotal"));
					p.getOpenInventory().close();
					Main.pdrops.set(p.getName()+"ValorTotal", 0);
					Main.pdrops.saveConfig();
			}
		}
			}
	    }
	}
	
	@EventHandler
	public void aoClicarAuto(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		   ItemStack auto = Mine.newItem(Material.EMERALD, "§eVender automático", 1, 0, " ", "§e * A cada 1.5 os drops serão vendidos.","§e * "+Main.pdrops.getString(p.getName()+"Auto").toUpperCase());
	       if(e.getInventory().getTitle().equals("Vender /drops")) {
	    	   e.setCancelled(true);
	    	   if(e.getCurrentItem() != null) {
	    		   if(e.getCurrentItem().isSimilar(auto)) {
	    			   if(p.hasPermission("auto.perm")) {
	    			   if(Main.pdrops.getString(p.getName()+"Auto").contains("desativado")) {
	    				   p.getOpenInventory().close();
	    				   p.sendMessage("§aAuto vender ativado !");
	    				   Main.pdrops.set(p.getName()+"Auto", "ativado");
	    				   Main.pdrops.saveConfig();
	    			   }else {
	    				   p.getOpenInventory().close();
	    				   p.sendMessage("§aAuto vender desativado !");
	    				   Main.pdrops.set(p.getName()+"Auto", "desativado");
	    				   Main.pdrops.saveConfig();
	    			   }
	    		   }else {
	    			   p.getOpenInventory().close();
	    			   p.sendMessage("§cSem permissão.");
	    		   }
	    			   
	    		   }
	    	   }
	       }
	}
	@EventHandler
	public void aoSair(PlayerQuitEvent e) {
		dentro.remove(e.getPlayer());
	}
	
	@EventHandler
	public void atualizador(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		dentro.add(p);
		if(dentro.contains(p)) {
		new BukkitRunnable() {
			
			@Override
			public void run() {
					if(Main.pdrops.getInt(p.getName()+"Total") == 0) {
						if(Main.pdrops.getString(p.getName()+"Auto").equalsIgnoreCase("ativado")) {
						p.sendMessage("§cNenhum drop para ser auto vendido.");
						return;
					}
					}else {
						if(Main.pdrops.getString(p.getName()+"Auto").equalsIgnoreCase("ativado")) {
				money(p, "lapisb");
				money(p, "lapism");
				money(p, "redstoneb");
				money(p, "redstonem");
				money(p, "carvaob");
				money(p, "carvaom");
				money(p, "diamanteb");
				money(p, "diamantem");
				money(p, "esmeraldab");
				money(p, "esmeraldam");
				money(p, "ferro");
				money(p, "magma");
				money(p, "blaze");
				money(p, "polvora");
				money(p, "string");
				money(p, "trigo");
				money(p, "cacau");
				money(p, "melancia");
				money(p, "abobora");
				money(p, "cana");
				money(p, "fungo");
				p.sendMessage("§aSeus drops foram auto vendidos por: $"+Main.pdrops.getInt(p.getName()+"ValorTotal"));
				Main.pdrops.set(p.getName()+"ValorTotal", 0);
				Main.pdrops.saveConfig();
				}
					}
			}		
		}.runTaskTimer(Main.getPlugin(Main.class), Main.global.getInt("TempoDoAutoVenderEmSegundos")*20, Main.global.getInt("TempoDoAutoVenderEmSegundos")*20);
	}else {
		return;
	}
	}
	
	@EventHandler
	public void aoClicarShift(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		 ItemStack shift = Mine.newItem(Material.ARROW, "§eVender com shift", 1, 0," ", "§e * A cada 2 segundos pressione shift para vender.", "§e * "+Main.pdrops.getString(p.getName()+"Shift").toUpperCase());
		 if(e.getInventory().getTitle().equals("Vender /drops")) {
	    	   e.setCancelled(true);
	    	   if(e.getCurrentItem() != null) {
	    		   if(e.getCurrentItem().isSimilar(shift)) {
	    			   if(p.hasPermission("shift.perm")) {
	    			   if(Main.pdrops.getString(p.getName()+"Shift").contains("desativado")) {
	    				   p.getOpenInventory().close();
	    				   p.sendMessage("§aVender com shift ativado !");
	    				   Main.pdrops.set(p.getName()+"Shift", "ativado");
	    				   Main.pdrops.saveConfig();
	    			   }else {
	    				   p.getOpenInventory().close();
	    				   p.sendMessage("§aVender com shift desativado !");
	    				   Main.pdrops.set(p.getName()+"Shift", "desativado");
	    				   Main.pdrops.saveConfig();
	    			   }
	    		   }else {
	    			   p.getOpenInventory().close();
	    			   p.sendMessage("§cSem permissão.");
	    		   }
	    		   }
	    	   }
	       }
	}
	
	@EventHandler
	public void venderShift(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		
		
		if(lista.contains(p)) {
			p.sendMessage("§cAguarde para usar novamente.");
			return;
		}
		if(Main.pdrops.getString(p.getName()+"Shift").equalsIgnoreCase("ativado")) {
			if(e.isSneaking() == true) {
					if(Main.pdrops.getInt(p.getName()+"Total") == 0) {
						if(Main.pdrops.getString(p.getName()+"Shift").equalsIgnoreCase("ativado")) {
						p.sendMessage("§cNenhum drop para ser vendido.");
						lista.add(p);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								lista.remove(p);
								p.sendMessage("§aVocê pode usar o venda com shift novamente !");
							}
						}.runTaskLater(Main.getPlugin(Main.class), Main.global.getInt("TempoParaVenderShiftEmSegundos")*20);
						return;
					}
					}else {
					lista.add(p);
					money(p, "lapisb");
					money(p, "lapism");
					money(p, "redstoneb");
					money(p, "redstonem");
					money(p, "carvaob");
					money(p, "carvaom");
					money(p, "diamanteb");
					money(p, "diamantem");
					money(p, "esmeraldab");
					money(p, "esmeraldam");
					money(p, "ferro");
					money(p, "magma");
					money(p, "blaze");
					money(p, "polvora");
					money(p, "string");
					money(p, "trigo");
					money(p, "cacau");
					money(p, "melancia");
					money(p, "abobora");
					money(p, "cana");
					money(p, "fungo");
					p.sendMessage("§aSeus drops foram vendidos por: $"+Main.pdrops.getInt(p.getName()+"ValorTotal"));
					p.getOpenInventory().close();
					Main.pdrops.set(p.getName()+"ValorTotal", 0);
					Main.pdrops.saveConfig();
					new BukkitRunnable() {
						
						@Override
						public void run() {
							lista.remove(p);
							p.sendMessage("§aVocê pode usar o venda com shift novamente !");
						}
						
					}.runTaskLater(Main.getPlugin(Main.class), Main.global.getInt("TempoParaVenderShiftEmSegundos")*20);
}
	}
		}
	}
		}
		

