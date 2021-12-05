package me.ninjay.tesourargeleia.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.ninjay.tesourargeleia.estruturas.Armardura;
import me.ninjay.tesourargeleia.estruturas.ItensAPI;
import me.ninjay.tesourargeleia.utils.Mine;


public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			Inventory menu = Mine.newInventory("Pegue o resto dos itens", 9*6);
			
			p.getInventory().addItem(ItensAPI.tesoura());
			for(Armardura todos : Armardura.values()) {
				p.getInventory().addItem(ItensAPI.create(todos, "CHAINMAIL", "Galinha"));
				p.getInventory().addItem(ItensAPI.create(todos, "CHAINMAIL", "Villager"));
				p.getInventory().addItem(ItensAPI.create(todos, "IRON", "Golem"));
				p.getInventory().addItem(ItensAPI.create(todos, "IRON", "Creeper"));
				p.getInventory().addItem(ItensAPI.create(todos, "CHAINMAIL", "Axolotl"));
				p.getInventory().addItem(ItensAPI.create(todos, "DIAMOND", "Cabra"));
				p.getInventory().addItem(ItensAPI.create(todos, "IRON", "Piglin Brute"));
				menu.addItem(ItensAPI.create(todos, "IRON", "Blaze"));
				menu.addItem(ItensAPI.create(todos, "CHAINMAIL", "Vaca"));
				menu.addItem(ItensAPI.create(todos, "CHAINMAIL", "Porco"));
				menu.addItem(ItensAPI.create(todos, "CHAINMAIL", "Ovelha"));
				menu.addItem(ItensAPI.create(todos, "IRON", "Zumbi"));
				menu.addItem(ItensAPI.create(todos, "IRON", "Aranha"));
				menu.addItem(ItensAPI.create(todos, "DIAMOND", "Enderman"));
				menu.addItem(ItensAPI.create(todos, "IRON", "Esqueleto"));
				menu.addItem(ItensAPI.create(todos, "NETHERITE", "Esqueleto Wither"));
			}
			
			p.openInventory(menu);
		}
		return false;
	}

}
