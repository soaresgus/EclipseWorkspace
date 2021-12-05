package me.ninjay.comerciante.comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.ninjay.comerciante.estruturas.ItensAPI;
import me.ninjay.comerciante.estruturas.ItensManager;
import me.ninjay.comerciante.estruturas.TimerAPI;
import me.ninjay.utils.utils.Mine;


public class ComandoComerciante implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			
			ItensManager manager = ItensAPI.manager;
			
			Inventory menu = Mine.newInventory("Comerciante", 9*6);
			Mine.rodarInventario(menu, Mine.newItem(Material.STAINED_GLASS_PANE, "", 1, 7));
			menu.setItem(Mine.getPosition(1, 5), Mine.newItem(Material.BONE, "§e§lLimite de compras: §a§l"+ItensAPI.info.getInt(p.getName()+".limite"), 1, 0,"§8  O seu limite reseta de tempos em tempos."));
			menu.setItem(Mine.getPosition(6, 5), Mine.newItem(Material.EYE_OF_ENDER, "§e§lO limite irá resetar em: §a§l"+TimerAPI.formatarTempoHMS(TimerAPI.getTempoCorrendo(ItensAPI.info, "timer"))));
			
			if(manager.getItens().contains(manager.getItemPorId(1))) {
			if(manager.getItemPorId(1).getAtivado() == true) {
				menu.setItem(Mine.getPosition(3, 3), manager.getItemPorId(1).getIcone());
				}else {
					return true;
				}
			}
			if(manager.getItens().contains(manager.getItemPorId(2))) {
			if(manager.getItemPorId(2).getAtivado() == true) {
				menu.setItem(Mine.getPosition(3, 4), manager.getItemPorId(2).getIcone());
			}else {
				return true;
			}
			}
			if(manager.getItens().contains(manager.getItemPorId(3))) {
			if(manager.getItemPorId(3).getAtivado() == true) {
				menu.setItem(Mine.getPosition(3, 5), manager.getItemPorId(3).getIcone());
			}else {
				return true;
			}
			}
			if(manager.getItens().contains(manager.getItemPorId(4))) {
			if(manager.getItemPorId(4).getAtivado() == true) {
				menu.setItem(Mine.getPosition(3, 6), manager.getItemPorId(4).getIcone());
			}else {
				return true;
			}
			}
			if(manager.getItens().contains(manager.getItemPorId(5))) {
			if(manager.getItemPorId(5).getAtivado() == true) {
				menu.setItem(Mine.getPosition(3, 7), manager.getItemPorId(5).getIcone());
			}else {
				return true;
			}
			}
			if(manager.getItens().contains(manager.getItemPorId(6))) {
			if(manager.getItemPorId(6).getAtivado() == true) {
				menu.setItem(Mine.getPosition(4, 3), manager.getItemPorId(6).getIcone());
			}else {
				return true;
			}
			}
			if(manager.getItens().contains(manager.getItemPorId(7))) {
			if(manager.getItemPorId(7).getAtivado() == true) {
				menu.setItem(Mine.getPosition(4, 4), manager.getItemPorId(7).getIcone());
			}else {
				return true;
			}
			}
			if(manager.getItens().contains(manager.getItemPorId(8))) {
			if(manager.getItemPorId(8).getAtivado() == true) {
				menu.setItem(Mine.getPosition(4, 5), manager.getItemPorId(8).getIcone());
			}else {
				return true;
			}
			}
			if(manager.getItens().contains(manager.getItemPorId(9))) {
			if(manager.getItemPorId(9).getAtivado() == true) {
				menu.setItem(Mine.getPosition(4, 6), manager.getItemPorId(9).getIcone());
			}else {
				return true;
			}
			}
			if(manager.getItens().contains(manager.getItemPorId(10))) {
			if(manager.getItemPorId(10).getAtivado() == true) {
				menu.setItem(Mine.getPosition(4, 7), manager.getItemPorId(10).getIcone());
			}else {
				return true;
			}
			}
			p.openInventory(menu);
		}
		return false;
	}

}
