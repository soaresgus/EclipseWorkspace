package me.ninjay.megavender.comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.megavender.main.Main;
import me.ninjay.megavender.utils.Mine;

public class ComandoDrops implements CommandExecutor{
	
	public static Inventory drops = Mine.newInventory("Drops", 9*6);
	public static ItemStack info = Mine.newItem(Material.BOOK, "§eO que é isso ?", 1, 0, " "," §e* Nesse menu vai estar listado todos seus drops", "  §e  minérios, drops de mobs, e drops de farms.");
	public static ItemStack info2 = Mine.newItem(Material.BOOK, "§eOnde está os drops de máquinas ?", 1, 0, " "," §e* Para vender seus drops de máquinas ","  §e  use o comando §6/maquina drops.");
	public static ItemStack vender = Mine.newItem(Material.NETHER_STAR, "§eMenu de venda", 1, 0, " ", " §e* Clique aqui para abrir o menu de venda.");
	public static ItemStack mover = Mine.newItem(Material.REDSTONE_BLOCK, "§eTransferir itens", 1, 0, " ", " §e* Caso tenha algum drop em seu iventário"," §e  clique aqui para transferir para o /drops.");
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(p.hasPermission("drops.perm")) {
			ItemStack lapisb = Mine.newItem(Material.LAPIS_BLOCK, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".lapisb"));
			ItemStack lapism = Mine.newItem(Material.INK_SACK, null, 1, 4, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".lapism"));
			ItemStack redsb = Mine.newItem(Material.REDSTONE_BLOCK, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".redstoneb"));
			ItemStack redsm = Mine.newItem(Material.REDSTONE, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".redstonem"));
			ItemStack coalb = Mine.newItem(Material.COAL_BLOCK, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".carvaob"));
			ItemStack coalm = Mine.newItem(Material.COAL, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".carvaom"));
			ItemStack dimab = Mine.newItem(Material.DIAMOND_BLOCK, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".diamanteb"));
			ItemStack dimam = Mine.newItem(Material.DIAMOND, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".diamantem"));
			ItemStack esmeraldab = Mine.newItem(Material.EMERALD_BLOCK, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".esmeraldab"));
			ItemStack esmeraldam = Mine.newItem(Material.EMERALD, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".esmeraldam"));
			ItemStack ferro = Mine.newItem(Material.IRON_INGOT, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".ferro"));
			ItemStack magma = Mine.newItem(Material.MAGMA_CREAM, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".magma"));
			ItemStack blaze = Mine.newItem(Material.BLAZE_ROD, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".blaze"));
			ItemStack polvora = Mine.newItem(Material.SULPHUR, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".polvora"));
			ItemStack linha = Mine.newItem(Material.STRING, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".linha"));
			ItemStack trigo = Mine.newItem(Material.WHEAT, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".trigo"));
			ItemStack cacau = Mine.newItem(Material.COCOA, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".cacau"));
			ItemStack melancia = Mine.newItem(Material.MELON, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".melancia"));
			ItemStack abobora = Mine.newItem(Material.PUMPKIN, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".abobora"));
			ItemStack cana = Mine.newItem(Material.SUGAR_CANE, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".cana"));
			ItemStack fungo = Mine.newItem(Material.NETHER_WARTS, null, 1, 0, " "," §e* Quantidade: "+Main.pdrops.getInt(p.getName()+".fungo"));
			
			ItemStack limite = Mine.newItem(Material.FEATHER, " ", 1, 0, " "," §eTotal de drops: "+Main.pdrops.getInt(p.getName()+"Total"), " §eLimite de drops: "+Main.global.getInt("LimiteDeDrops")," ");
			drops.clear();
			drops.setItem(Mine.getPosition(6, 4), info);
			drops.setItem(Mine.getPosition(6, 6), info2);
			drops.setItem(Mine.getPosition(6, 5), vender);
			drops.setItem(Mine.getPosition(6, 2), limite);
			drops.setItem(Mine.getPosition(6, 8), mover);
			drops.addItem(lapisb);
			drops.addItem(lapism);
			drops.addItem(redsb);
			drops.addItem(redsm);
			drops.addItem(coalb);
			drops.addItem(coalm);
			drops.addItem(dimab);
			drops.addItem(dimam);
			drops.addItem(esmeraldab);
			drops.addItem(esmeraldam);
			drops.addItem(ferro);
			drops.addItem(magma);
			drops.addItem(blaze);
			drops.addItem(polvora);
			drops.addItem(linha);
			drops.addItem(trigo);
			drops.addItem(cacau);
			drops.addItem(melancia);
			drops.addItem(abobora);
			drops.addItem(cana);
			drops.addItem(fungo);
			
			
			p.openInventory(drops);
			Main.global.reloadConfig();
			Main.pdrops.reloadConfig();
		}else {
			p.sendMessage("§cSem permissão.");
			return true;
		}
		}
		return false;
	}

}
