package me.ninjay.random.comandos.encantar;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.random.main.Main;

public class ComandoEncantar implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			Inventory enchant = Mine.newInventory("Feiticeiro", 9*5);
			
			ItemStack xp = Mine.newItem(Material.STORAGE_MINECART, "§eSua experiência", 1, 0, "§fXP atual: "+Main.xp.getDouble(p.getName()));
			
			ItemStack pot1 = Mine.newItem(Material.EXP_BOTTLE, "§eFrasco de Experiência", 1, 0, "§fCusto: §a500 XP"," ","§7Você receberá um frasco de","§7experiência com §n500 XP");
			ItemStack pot2 = Mine.newItem(Material.EXP_BOTTLE, "§eFrasco de Experiência", 1, 0, "§fCusto: §a1.000 XP"," ","§7Você receberá um frasco de","§7experiência com §n1.000 XP");
			ItemStack pot3 = Mine.newItem(Material.EXP_BOTTLE, "§eFrasco de Experiência", 1, 0, "§fCusto: §a5.000 XP"," ","§7Você receberá um frasco de","§7experiência com §n5.000 XP");
			ItemStack pot4 = Mine.newItem(Material.EXP_BOTTLE, "§eFrasco de Experiência", 1, 0, "§fCusto: §a10.000 XP"," ","§7Você receberá um frasco de","§7experiência com §n10.000 XP");
		
            ItemStack livro1 = Mine.newItem(Material.BOOK, "§eLivro de encantamentos", 1, 0, "§7Tipo: §fSimples"," ","§7Clique com o §fbotão direito","§7para ver os encantamentos básicos."," ","§fCusto: §a1.000 XP");		
            ItemStack livro2 = Mine.newItem(Material.BOOK, "§eLivro de encantamentos", 1, 0, "§7Tipo: §fNormal"," ","§7Clique com o §fbotão direito ","§7para ver os encantamentos básicos."," ","§fCusto: §a2.000 XP");	
            ItemStack livro3 = Mine.newItem(Material.BOOK, "§eLivro de encantamentos", 1, 0, "§7Tipo: §fAvançado"," ","§7Clique com o §fbotão direito", "§7para ver os encantamentos básicos."," ","§fCusto: §a3.500 XP");	
            
            enchant.setItem(Mine.getPosition(2, 5), xp);
            enchant.setItem(Mine.getPosition(3, 2), pot1);
            enchant.setItem(Mine.getPosition(3, 3), pot2);
            enchant.setItem(Mine.getPosition(4, 2), pot3);
            enchant.setItem(Mine.getPosition(4, 3), pot4);
            enchant.setItem(Mine.getPosition(3, 7), livro1);
            enchant.setItem(Mine.getPosition(3, 8), livro2);
            enchant.setItem(Mine.getPosition(4, 7), livro3);
            
            p.openInventory(enchant);
		
		}
		return false;
	}

}
