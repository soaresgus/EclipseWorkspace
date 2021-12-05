package me.ninjay.olhodedeus.comandos;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ComandoDarOlho implements CommandExecutor{
	
	public static ItemStack olho = new ItemStack(Material.EYE_OF_ENDER, 1);
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			ItemMeta olhom = olho.getItemMeta();
			olhom.setDisplayName("§cOlho de Deus");
			olhom.setLore(Arrays.asList(" ","§7Nada pode se esconder do Olho de Deus","§7Duração: 10s."," ","§e* Utilizado para invasões"));
			olhom.addEnchant(Enchantment.DURABILITY, 1, false);
			olho.setItemMeta(olhom);
			p.getInventory().addItem(olho);
		}
		return false;
	}

}
