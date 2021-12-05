package me.ninjay.hereos;

import java.util.Arrays;


import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Pegar implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("givecabine")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("§6§lApenas players podem usar.");
			} else {
				Player p = (Player) sender;
				if (!p.hasPermission("givecabine.use")) {
				
					return true;

				}
				if (p.hasPermission("givecabine.use")) {
					ItemStack cab = new ItemStack(Material.IRON_DOOR);
					ItemMeta cabm = cab.getItemMeta();
					cabm.setDisplayName("§eCabine Policial");
					cabm.addEnchant(Enchantment.DURABILITY, 1, false);
					cabm.setLore(Arrays.asList(" ", "§6§lCabine Policial", " §7Utilize esse item para virar",
							" §7algum super-herói e ganhar seu super-poder"));
					cab.setItemMeta(cabm);
					
					ItemStack armor = new ItemStack(p.getInventory().getHelmet().getType());
					ItemMeta armorm = armor.getItemMeta();
					armorm.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
					armor.setItemMeta(armorm);
					
					p.getInventory().setHelmet(armor);

				}
			}
		}

		return false;
	}

}
