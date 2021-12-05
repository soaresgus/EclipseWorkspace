package me.ninjay.kustcaixas.comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.kustcaixas.estruturas.Caixa;
import me.ninjay.kustcaixas.estruturas.CaixaAPI;
import me.ninjay.kustcaixas.main.Main;
import me.ninjay.kustcaixas.utils.Mine;
import me.ninjay.kustcash.estruturas.CashAPI;
import me.ninjay.kustlogs.estruturas.LogsAPI;

public class ComandoCaixaShop implements CommandExecutor, Listener{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			Inventory menu = Mine.newInventory("Comprar caixas", 9*6);
			
			for(Caixa caixas : CaixaAPI.manager.getCaixas()) {
				menu.setItem(caixas.getSlotLoja(), caixas.getIconeLoja1());
				menu.setItem(caixas.getSlotLoja()+9, caixas.getIconeLoja5());
				menu.setItem(caixas.getSlotLoja()+9*2, caixas.getIconeLoja10());
				menu.setItem(caixas.getSlotLoja()+9*3, caixas.getIconeLoja25());
			}
			
			p.openInventory(menu);
			
		}
		return false;
	}
	
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().contains("Comprar caixas")) {
			e.setCancelled(true);
			Caixa caixa1 = CaixaAPI.manager.getCaixaByIcone1(e.getCurrentItem());
			if(caixa1 != null) {
				if(e.getClick() == ClickType.LEFT) {
				if(CashAPI.hasCash(p.getName(), caixa1.getPreco1())) {
					if(Mine.isFull(p.getInventory()) == false) {
					p.getOpenInventory().close();
					CashAPI.removeCash(p.getName(), caixa1.getPreco1());
					p.sendMessage("§aCompra realizada.");
					LogsAPI.register(p.getName(), p.getName()+" comprou "+caixa1.getIconeLoja1().getAmount()+"x caixa "+caixa1.getName(), me.ninjay.kustlogs.main.Main.playerGeral);
					ItemStack caixa = caixa1.getIcone();
					caixa.setAmount(1);
					p.getInventory().addItem(caixa);
					}else {
						p.getOpenInventory().close();
						p.sendMessage("§cEsvazie seu inventário para realizar a comprar.");
					}
				}else {
					p.getOpenInventory().close();
					p.sendMessage("§cVocê não possuí cash suficiente.");
				}
				}else if(e.getClick() == ClickType.RIGHT) {
					Inventory visu = Mine.newInventory(caixa1.getNome(), 9*6);
					Mine.rodarInventario(visu, Mine.newItem(Material.STAINED_GLASS_PANE, " ", 1, 7));
					for(int i = 1; i <= Main.config.getInt("ItensTotal"); i++) {
						if(Main.itens.getString("Itens."+i+".caixa").equalsIgnoreCase(caixa1.getName())) {
						ItemStack item = Mine.newItem(Main.itens.getInt("Itens."+i+".id"), Main.itens.getString("Itens."+i+".nome").replace("&", "§"), Main.itens.getInt("Itens."+i+".amount"), Main.itens.getInt("Itens."+i+".data"));
						for(int ie = 0; ie <= 51; ie++) {
						if(Main.itens.contains("Itens.Enchants."+i+"."+ie)) {
							if(Main.itens.getInt("Itens.Enchants."+i+"."+ie) > 0) {
								Mine.addEnchant(item, Enchantment.getById(ie), Main.itens.getInt("Itens.Enchants."+i+"."+ie));
							}
						}
					}
						visu.addItem(item);
						p.openInventory(visu);
						}
					}
				}
			}
			Caixa caixa5 = CaixaAPI.manager.getCaixaByIcone5(e.getCurrentItem());
			if(caixa5 != null) {
				if(e.getClick() == ClickType.LEFT) {
				if(CashAPI.hasCash(p.getName(), caixa5.getPreco5())) {
					if(Mine.isFull(p.getInventory()) == false) {
					p.getOpenInventory().close();
					CashAPI.removeCash(p.getName(), caixa5.getPreco5());
					p.sendMessage("§aCompra realizada.");
					LogsAPI.register(p.getName(), p.getName()+" comprou "+caixa5.getIconeLoja5().getAmount()+"x caixa "+caixa5.getName(), me.ninjay.kustlogs.main.Main.playerGeral);
					ItemStack caixa = caixa5.getIcone();
					caixa.setAmount(5);
					p.getInventory().addItem(caixa);
					}else {
						p.getOpenInventory().close();
						p.sendMessage("§cEsvazie seu inventário para realizar a comprar.");
					}
				}else {
					p.getOpenInventory().close();
					p.sendMessage("§cVocê não possuí cash suficiente.");
				}
				}else if(e.getClick() == ClickType.RIGHT) {
					Inventory visu = Mine.newInventory(caixa5.getNome(), 9*6);
					Mine.rodarInventario(visu, Mine.newItem(Material.STAINED_GLASS_PANE, " ", 1, 7));
					for(int i = 1; i <= Main.config.getInt("ItensTotal"); i++) {
						if(Main.itens.getString("Itens."+i+".caixa").equalsIgnoreCase(caixa5.getName())) {
						ItemStack item = Mine.newItem(Main.itens.getInt("Itens."+i+".id"), Main.itens.getString("Itens."+i+".nome").replace("&", "§"), Main.itens.getInt("Itens."+i+".amount"), Main.itens.getInt("Itens."+i+".data"));
						for(int ie = 0; ie <= 51; ie++) {
						if(Main.itens.contains("Itens.Enchants."+i+"."+ie)) {
							if(Main.itens.getInt("Itens.Enchants."+i+"."+ie) > 0) {
								Mine.addEnchant(item, Enchantment.getById(ie), Main.itens.getInt("Itens.Enchants."+i+"."+ie));
							}
						}
					}
						visu.addItem(item);
						p.openInventory(visu);
						}
					}
				}
			}
			Caixa caixa10 = CaixaAPI.manager.getCaixaByIcone10(e.getCurrentItem());
			if(caixa10 != null) {
				if(e.getClick() == ClickType.LEFT) {
				if(CashAPI.hasCash(p.getName(), caixa10.getPreco10())) {
					if(Mine.isFull(p.getInventory()) == false) {
					p.getOpenInventory().close();
					CashAPI.removeCash(p.getName(), caixa10.getPreco10());
					p.sendMessage("§aCompra realizada.");
					LogsAPI.register(p.getName(), p.getName()+" comprou "+caixa10.getIconeLoja10().getAmount()+"x caixa "+caixa10.getName(), me.ninjay.kustlogs.main.Main.playerGeral);
					ItemStack caixa = caixa10.getIcone();
					caixa.setAmount(10);
					p.getInventory().addItem(caixa);
					}else {
						p.getOpenInventory().close();
						p.sendMessage("§cEsvazie seu inventário para realizar a comprar.");
					}
				}else {
					p.getOpenInventory().close();
					p.sendMessage("§cVocê não possuí cash suficiente.");
				}
				}else if(e.getClick() == ClickType.RIGHT) {
					Inventory visu = Mine.newInventory(caixa10.getNome(), 9*6);
					Mine.rodarInventario(visu, Mine.newItem(Material.STAINED_GLASS_PANE, " ", 1, 7));
					for(int i = 1; i <= Main.config.getInt("ItensTotal"); i++) {
						if(Main.itens.getString("Itens."+i+".caixa").equalsIgnoreCase(caixa10.getName())) {
						ItemStack item = Mine.newItem(Main.itens.getInt("Itens."+i+".id"), Main.itens.getString("Itens."+i+".nome").replace("&", "§"), Main.itens.getInt("Itens."+i+".amount"), Main.itens.getInt("Itens."+i+".data"));
						for(int ie = 0; ie <= 51; ie++) {
						if(Main.itens.contains("Itens.Enchants."+i+"."+ie)) {
							if(Main.itens.getInt("Itens.Enchants."+i+"."+ie) > 0) {
								Mine.addEnchant(item, Enchantment.getById(ie), Main.itens.getInt("Itens.Enchants."+i+"."+ie));
							}
						}
					}
						visu.addItem(item);
						p.openInventory(visu);
						}
					}
				}
			}
			Caixa caixa25 = CaixaAPI.manager.getCaixaByIcone25(e.getCurrentItem());
			if(caixa25 != null) {
				if(e.getClick() == ClickType.LEFT) {
				if(CashAPI.hasCash(p.getName(), caixa25.getPreco25())) {
					if(Mine.isFull(p.getInventory()) == false) {
					p.getOpenInventory().close();
					CashAPI.removeCash(p.getName(), caixa25.getPreco25());
					p.sendMessage("§aCompra realizada.");
					LogsAPI.register(p.getName(), p.getName()+" comprou "+caixa25.getIconeLoja25().getAmount()+"x caixa "+caixa25.getName(), me.ninjay.kustlogs.main.Main.playerGeral);
					ItemStack caixa = caixa25.getIcone();
					caixa.setAmount(25);
					p.getInventory().addItem(caixa);
					}else {
						p.getOpenInventory().close();
						p.sendMessage("§cEsvazie seu inventário para realizar a comprar.");
					}
				}else {
					p.getOpenInventory().close();
					p.sendMessage("§cVocê não possuí cash suficiente.");
				}
				}else if(e.getClick() == ClickType.RIGHT) {
					Inventory visu = Mine.newInventory(caixa25.getNome(), 9*6);
					Mine.rodarInventario(visu, Mine.newItem(Material.STAINED_GLASS_PANE, " ", 1, 7));
					for(int i = 1; i <= Main.config.getInt("ItensTotal"); i++) {
						if(Main.itens.getString("Itens."+i+".caixa").equalsIgnoreCase(caixa25.getName())) {
						ItemStack item = Mine.newItem(Main.itens.getInt("Itens."+i+".id"), Main.itens.getString("Itens."+i+".nome").replace("&", "§"), Main.itens.getInt("Itens."+i+".amount"), Main.itens.getInt("Itens."+i+".data"));
						for(int ie = 0; ie <= 51; ie++) {
						if(Main.itens.contains("Itens.Enchants."+i+"."+ie)) {
							if(Main.itens.getInt("Itens.Enchants."+i+"."+ie) > 0) {
								Mine.addEnchant(item, Enchantment.getById(ie), Main.itens.getInt("Itens.Enchants."+i+"."+ie));
							}
						}
					}
						visu.addItem(item);
						p.openInventory(visu);
						}
					}
				}
			}
		}
	}
	

}
