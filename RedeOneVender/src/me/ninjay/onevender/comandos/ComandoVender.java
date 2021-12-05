package me.ninjay.onevender.comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.onevender.estruturas.Itens;
import net.eduard.api.lib.modules.VaultAPI;

public class ComandoVender implements CommandExecutor, Listener {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("vender")) {
				if (p.hasPermission("vender.use")) {
					if (args.length == 0) {
						int amount = 0;
						double valor = 0;
						for (int i = 0; i < p.getInventory().getSize(); i++) {
							ItemStack is = p.getInventory().getItem(i);
							for (Itens itens : Itens.values()) {
								if (p.getInventory().contains(itens.getMaterial())) {
									if (is != null && is.getType() == itens.getMaterial()) {
										amount += is.getAmount();
										valor += (itens.getValor() * is.getAmount());
										VaultAPI.getEconomy().depositPlayer(p, valor);
										p.getInventory().removeItem(is);
										return true;
									}

								}
							}
						}
						if (amount == 0) {
							p.sendMessage(
									"§cVocê não tem nenhum item para vender. Utilize /vender itens para ver os itens que estão na lista de venda.");
							return true;
						}
						p.sendMessage("§6Você vendeu §e" + amount + " §6item(s) por §e" + valor + " §6coin(s).");
					}
				}
			}
			if (args[0].equalsIgnoreCase("itens")) {
				Inventory inv = Mine.newInventory("Lista de venda", 9 * 4);
				ItemStack carne = Mine.newItem(Material.ROTTEN_FLESH, "§6Carne Podre");
				ItemStack osso = Mine.newItem(Material.BONE, "§6Osso");
				ItemStack blaze = Mine.newItem(Material.BLAZE_ROD, "§6Vara de Blaze");
				ItemStack iron = Mine.newItem(Material.IRON_INGOT, "§6Minério de Ferro");
				ItemStack melon = Mine.newItem(Material.MELON, "§6Melancia");
				ItemStack melonb = Mine.newItem(Material.MELON_BLOCK, "§6Bloco de Melancia");
				ItemStack fungo = Mine.newItem(Material.NETHER_STALK, "§6Fungo");
				ItemStack slime = Mine.newItem(Material.SLIME_BALL, "§6Bola de Slime");
				ItemStack lapis = Mine.newItem(Material.LAPIS_ORE, "§6Minério de Lapis");
				ItemStack lapisb = Mine.newItem(Material.LAPIS_BLOCK, "§6Bloco de Lapis");
				ItemStack dima = Mine.newItem(Material.DIAMOND, "§6Minério de Diamante");
				ItemStack dimab = Mine.newItem(Material.DIAMOND_BLOCK, "§6Bloco de Diamante");
				ItemStack emb = Mine.newItem(Material.EMPTY_MAP, "§6Em breve novidades...");
				inv.setItem(Mine.getPosition(2, 2), carne);
				inv.setItem(Mine.getPosition(2, 3), osso);
				inv.setItem(Mine.getPosition(3, 2), blaze);
				inv.setItem(Mine.getPosition(3, 3), slime);
				inv.setItem(Mine.getPosition(3, 8), iron);
				inv.setItem(Mine.getPosition(2, 7), melonb);
				inv.setItem(Mine.getPosition(2, 8), fungo);
				inv.setItem(Mine.getPosition(3, 7), melon);
				inv.setItem(Mine.getPosition(2, 4), lapis);
				inv.setItem(Mine.getPosition(3, 4), lapisb);
				inv.setItem(Mine.getPosition(2, 6), dima);
				inv.setItem(Mine.getPosition(3, 6), dimab);
				inv.setItem(Mine.getPosition(2, 5), emb);
				inv.setItem(Mine.getPosition(3, 5), emb);
				p.openInventory(inv);
			}
		}
		return true;
	}

	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		if(e.getInventory().getTitle().equals("Lista de venda")) {
			e.setCancelled(true);
		}

	}
}
