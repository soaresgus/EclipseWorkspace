package me.ninjay.safecash.comandos;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.safecash.estruturas.CashAPI;
import me.ninjay.safecash.estruturas.TimerAPI;
import me.ninjay.safecash.main.Main;
import me.ninjay.safecash.utils.Mine;
import me.ninjay.safecash.utils.VaultAPI;
import me.ninjay.safecore.estruturas.tags.TagsControler;

public class ComandoShop implements CommandExecutor, Listener{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			Inventory menu = Mine.newInventory("Shop", 9*4);
			
			ItemStack vip = Mine.newItem(Material.DIAMOND_BLOCK, "§b[VIP] §7- §f30 dias");
			ItemStack mvp = Mine.newItem(Material.EMERALD_BLOCK, "§a[MVP] §7- §f30 dias");
			
			ArrayList<String> lorevip = new ArrayList<>();
			ArrayList<String> loremvp = new ArrayList<>();
			
			lorevip.add(" ");
			loremvp.add(" ");
			
			for(int i = 1; i < Main.shop.getInt("vip.vamount")+1; i++) {
				lorevip.add("  §f• "+Main.shop.getString("vip.vantagens."+i));
			}
			for(int i = 1; i < Main.shop.getInt("mvp.vamount")+1; i++) {
				loremvp.add("  §f• "+Main.shop.getString("mvp.vantagens."+i));
			}
			
			lorevip.add(" ");
			loremvp.add(" ");
			
			lorevip.add("§6§lValor: §7De: "+(Main.shop.getInt("vip.valor")*2)+" Cash §ePor: "+Main.shop.getInt("vip.valor")+" Cash §e§l(-50%)");
			loremvp.add("§6§lValor: §7De: "+(Main.shop.getInt("mvp.valor")*2)+" Cash §ePor: "+Main.shop.getInt("mvp.valor")+" Cash §e§l(-50%)");
			
			Mine.setLore(vip, lorevip);
			Mine.setLore(mvp, loremvp);
			
			menu.setItem(Mine.getPosition(2, 2), vip);
			menu.setItem(Mine.getPosition(3, 2), mvp);
			
			p.openInventory(menu);
		}
		return false;
	}
	
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().contains("Shop")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§b[VIP]")) {
						if(CashAPI.has(p, Main.cash, Main.shop.getInt("vip.valor"))) {
						TagsControler.setarTag(p, "vip");
						//30 dias = 86400*30
						TimerAPI.timer(TimerAPI.getTempoCorrendo(Main.tempo, p.getName()+".vip")+86400*30, Main.tempo, Main.getPlugin(Main.class), p.getName()+".vip");
						CashAPI.remove(p, Main.cash, Main.shop.getInt("vip.valor"));
						Mine.sendTitle("§b"+p.getName(), "§fAtivou um §b[VIP] §fde 30 dias!", 10, 50, 10);
						p.getOpenInventory().close();
						p.sendMessage("§aProduto ativado!");
						}else {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê não tem o valor de cash suficiente.");
					}
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§a[MVP]")) {
						if(CashAPI.has(p, Main.cash, Main.shop.getInt("mvp.valor"))) {
						TagsControler.setarTag(p, "mvp");
						CashAPI.remove(p, Main.cash, Main.shop.getInt("mvp.valor"));
						TimerAPI.timer(TimerAPI.getTempoCorrendo(Main.tempo, p.getName()+".mvp")+86400*30, Main.tempo, Main.getPlugin(Main.class), p.getName()+".mvp");
						Mine.sendTitle("§a"+p.getName(), "§fAtivou um §a[MVP] §fde 30 dias!", 10, 50, 10);
						p.getOpenInventory().close();
						p.sendMessage("§aProduto ativado!");
						}else {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê não tem o valor de cash suficiente.");
					}
					}
				}
				}
			}
		}
	
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if(TimerAPI.getTempoCorrendo(Main.tempo, p.getName()+".vip") <= 0) {
			if(p.hasPermission("tag.vip")) {
			p.sendMessage("§cSeu produto foi expirado!");
			VaultAPI.getPermission().playerRemoveGroup(p, "vip");
			VaultAPI.getPermission().playerRemove(p, "tag.vip");
			Main.tempo.remove(p.getName()+".vip");
			Main.tempo.remove(p.getName());
			Main.tempo.saveConfig();
			}
		}
		if(TimerAPI.getTempoCorrendo(Main.tempo, p.getName()+".mvp") <= 0) {
			if(p.hasPermission("tag.mvp")) {
			p.sendMessage("§cSeu produto foi expirado!");
			VaultAPI.getPermission().playerRemoveGroup(p, "mvp");
			VaultAPI.getPermission().playerRemove(p, "tag.mvp");
			Main.tempo.remove(p.getName()+".mvp");
			Main.tempo.remove(p.getName());
			Main.tempo.saveConfig();
			}
		}
	}
	}
