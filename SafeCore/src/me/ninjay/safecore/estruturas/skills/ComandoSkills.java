package me.ninjay.safecore.estruturas.skills;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.safecore.utils.Mine;

public class ComandoSkills implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;

			Inventory inv = Mine.newInventory("Escolha uma categoria", 9 * 3);
			ItemStack head = Mine.newHead("§eSuas habilidades", p.getName(), 1, " ",
					" §7Consulte suas próprias habilidades.");
			ItemStack head2 = Mine.newHead("§eHabilidades de outros jogadores", "MHF_Question", 1, " ",
					" §7Consulte habilidades de outros jogadores.");

			for (int i = 0; i < 9 * 3; i++) {
				inv.setItem(i, Mine.newItem(Material.STAINED_GLASS_PANE, " ", 1, 0));
			}
			inv.setItem(Mine.getPosition(2, 4), head);
			inv.setItem(Mine.getPosition(2, 6), head2);

			p.openInventory(inv);

		}
		return false;
	}

}
