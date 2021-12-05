package me.ninjay.oneperfil.ranks;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;

public class ComandoRanks implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			Inventory ranks = Mine.newInventory("Ranks", 9 * 5);
			ItemStack um = Mine.newItem("§6Rank [1]", Material.COAL, 1, 0, "§6Requisitos: §e[10.000 Blocos]");
			ItemStack dois = Mine.newItem("§6Rank [2]", Material.COAL_ORE, 1, 0, "§6Requisitos: §e[300.000 Coins]");
			ItemStack tres = Mine.newItem("§6Rank [3]", Material.COAL_BLOCK, 1, 0, "§6Requisitos: §e[12 Horas online]");
			ItemStack quatro = Mine.newItem("§6Rank [4]", Material.IRON_INGOT, 1, 0, "§6Requisitos: §e[150 Almas]");
			ItemStack cinco = Mine.newItem("§6Rank [5]", Material.IRON_ORE, 1, 0, "§6Requisitos: §e[20 Horas online]");
			ItemStack seis = Mine.newItem("§6Rank [6]", Material.IRON_BLOCK, 1, 0, "§6Requisitos: §e[250 Almas]");
			ItemStack sete = Mine.newItem("§6Rank [7]", Material.GOLD_INGOT, 1, 0, "§6Requisitos: §e[1.000.000 Coins]");
			ItemStack oito = Mine.newItem("§6Rank [8]", Material.GOLD_ORE, 1, 0, "§6Requisitos: §e[50 Horas online]");
			ItemStack nove = Mine.newItem("§6Rank [9]", Material.GOLD_BLOCK, 1, 0, "§6Requisitos: §e[500 Almas]");
			ItemStack dez = Mine.newItem("§6Rank [10]", Material.DIAMOND, 1, 0,
					"§6Requisitos: §e[Ter 5 vitórias totais em eventos]");
			ItemStack mais = Mine.newHead("§6Em breve novos ranks...", "Ninjay_", 1);

			ranks.setItem(Mine.getPosition(2, 2), um);
			ranks.setItem(Mine.getPosition(2, 3), dois);
			ranks.setItem(Mine.getPosition(2, 4), tres);
			ranks.setItem(Mine.getPosition(2, 5), quatro);
			ranks.setItem(Mine.getPosition(2, 6), cinco);
			ranks.setItem(Mine.getPosition(2, 7), seis);
			ranks.setItem(Mine.getPosition(2, 8), sete);
			ranks.setItem(Mine.getPosition(3, 4), oito);
			ranks.setItem(Mine.getPosition(3, 5), nove);
			ranks.setItem(Mine.getPosition(3, 6), dez);
            ranks.setItem(Mine.getPosition(4, 5), mais);
			
			p.openInventory(ranks);

		}
		return false;
	}

}