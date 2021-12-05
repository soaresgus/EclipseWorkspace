package me.ninjay.oneperfil.almas.estruturas;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.BukkitConfig;

public class EstruturaJogador {

	public static void almasGet(Player p, BukkitConfig config) {
		if (AlmasAPI.getAlmas(p, config) == 1) {
			p.sendMessage("§6Você possui §e" + AlmasAPI.getAlmas(p, config) + " §6alma.");
			return;
		}
		if (AlmasAPI.getAlmas(p, config) == 0) {
			p.sendMessage("§6Você possui §e" + AlmasAPI.getAlmas(p, config) + " §6almas.");
			return;
		}
		if (AlmasAPI.getAlmas(p, config) >= 2) {
			p.sendMessage("§6Você possui §e" + AlmasAPI.getAlmas(p, config) + " §6almas.");
			return;
		}
	}

	public static void almasOtherPlayer(Player p, BukkitConfig config) {
		if (AlmasAPI.getAlmas(p, config) == 1) {
			p.sendMessage("§6" + p.getName() + " possui §e" + AlmasAPI.getAlmas(p, config) + " §6alma.");
			return;
		}
		if (AlmasAPI.getAlmas(p, config) == 0) {
			p.sendMessage("§6" + p.getName() + " possui §e" + AlmasAPI.getAlmas(p, config) + " §6almas.");
			return;
		}
		if (AlmasAPI.getAlmas(p, config) >= 2) {
			p.sendMessage("§6" + p.getName() + " possui §e" + AlmasAPI.getAlmas(p, config) + " §6almas.");
			return;
		}
	}
	public static void almasHelp(Player p) {
		p.sendMessage("§6§lAlmas - Comandos\n \n§6/almas §eVeja o seu saldo de almas.\n§6/almas saldo <nick> §eVeja o saldo de almas de outro jogador.\n§6/almas mercado §eCompre itens com suas almas.\n ");
	}
	public static void mercadoNegro(Player p, Inventory menu, ItemStack item1,int slotItem1, ItemStack item2,int slotItem2, ItemStack item3,int slotItem3, ItemStack item4,int slotItem4, ItemStack item5,int slotItem5,ItemStack item6,int slotItem6) {
		menu.setItem(slotItem1, item1);
		menu.setItem(slotItem2, item2);
		menu.setItem(slotItem3, item3);
		menu.setItem(slotItem4, item4);
		menu.setItem(slotItem5, item5);
		menu.setItem(slotItem6, item6);
		p.openInventory(menu);
		
	}

}
