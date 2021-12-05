package me.ninjay.kustespeciais.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import me.ninjay.kustcash.estruturas.CashAPI;
import me.ninjay.kustespeciais.estruturas.ItensAPI;
import me.ninjay.kustespeciais.main.Main;
import me.ninjay.kustespeciais.utils.Mine;
import me.ninjay.kustlogs.estruturas.LogsAPI;

public class ComandoShop implements CommandExecutor, Listener{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			Inventory menu = Mine.newInventory("Itens especiais", 9*3);
			
			menu.setItem(Mine.getPosition(2, 2), ItensAPI.boostershop);
			menu.setItem(Mine.getPosition(2, 4), ItensAPI.instantaneoshop);
			menu.setItem(Mine.getPosition(2, 6), ItensAPI.kdrshop);
			menu.setItem(Mine.getPosition(2, 8), ItensAPI.raioshop());
			
			p.openInventory(menu);
		}
		return false;
	}

	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equalsIgnoreCase("Itens especiais")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().isSimilar(ItensAPI.boostershop)) {
						if(CashAPI.hasCash(p.getName(), Main.config.getInt("booster"))) {
							if(!Mine.isFull(p.getInventory())) {
						p.getOpenInventory().close();
						CashAPI.removeCash(p.getName(), Main.config.getInt("booster"));
						p.getServer().dispatchCommand(p.getServer().getConsoleSender(), "giveespeciais "+p.getName()+" booster 1");
						LogsAPI.register(p.getName(), p.getName()+" comprou um booster.", me.ninjay.kustlogs.main.Main.playerGeral);
						p.sendMessage("§aItem comprado com sucesso.");
							}else {
								p.getOpenInventory().close();
								p.sendMessage("§cEsvazie seu inventário para comprar.");
							}
						}else {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê não possuí cash suficiente.");
						}
					}
					if(e.getCurrentItem().isSimilar(ItensAPI.instantaneoshop)) {
						if(CashAPI.hasCash(p.getName(), Main.config.getInt("instantaneo.valor"))) {
							if(!Mine.isFull(p.getInventory())) {
						p.getOpenInventory().close();
						CashAPI.removeCash(p.getName(), Main.config.getInt("instantaneo.valor"));
						p.getServer().dispatchCommand(p.getServer().getConsoleSender(), "giveespeciais "+p.getName()+" poderi 1");
						LogsAPI.register(p.getName(), p.getName()+" comprou um poder instantâneo.", me.ninjay.kustlogs.main.Main.playerGeral);
						p.sendMessage("§aItem comprado com sucesso.");
							}else {
								p.getOpenInventory().close();
								p.sendMessage("§cEsvazie seu inventário para comprar.");
							}
						}else {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê não possuí cash suficiente.");
						}
					}
					if(e.getCurrentItem().isSimilar(ItensAPI.kdrshop)) {
						if(CashAPI.hasCash(p.getName(), Main.config.getInt("reset"))) {
							if(!Mine.isFull(p.getInventory())) {
						p.getOpenInventory().close();
						CashAPI.removeCash(p.getName(), Main.config.getInt("reset"));
						p.getServer().dispatchCommand(p.getServer().getConsoleSender(), "giveespeciais "+p.getName()+" reset 1");
						LogsAPI.register(p.getName(), p.getName()+" comprou um reset kdr.", me.ninjay.kustlogs.main.Main.playerGeral);
						p.sendMessage("§aItem comprado com sucesso.");
							}else {
								p.getOpenInventory().close();
								p.sendMessage("§cEsvazie seu inventário para comprar.");
							}
						}else {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê não possuí cash suficiente.");
						}
					}
					if(e.getCurrentItem().isSimilar(ItensAPI.raioshop())) {
						if(CashAPI.hasCash(p.getName(), Main.config.getInt("raio"))) {
							if(!Mine.isFull(p.getInventory())) {
						p.getOpenInventory().close();
						CashAPI.removeCash(p.getName(), Main.config.getInt("raio"));
						p.getServer().dispatchCommand(p.getServer().getConsoleSender(), "giveespeciais "+p.getName()+" raio 1");
						LogsAPI.register(p.getName(), p.getName()+" comprou um raio mestre.", me.ninjay.kustlogs.main.Main.playerGeral);
						p.sendMessage("§aItem comprado com sucesso.");
							}else {
								p.getOpenInventory().close();
								p.sendMessage("§cEsvazie seu inventário para comprar.");
							}
						}else {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê não possuí cash suficiente.");
						}
					}
				}
			}
		}
	}
	
}
