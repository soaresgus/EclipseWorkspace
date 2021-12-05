package me.ninjay.salvavidas.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.ninjay.salvavidas.utils.Mine;

public class ComandoGive implements CommandExecutor{
	
	public static ItemStack salvavidas = Mine.newSkull("§f(§a5§f) §cSalva-vida", "MHF_TNT");
	public static ItemStack salvavidas4 = Mine.newSkull("§f(§a4§f) §cSalva-vida", "MHF_TNT");
	public static ItemStack salvavidas3 = Mine.newSkull("§f(§a3§f) §cSalva-vida", "MHF_TNT");
	public static ItemStack salvavidas2 = Mine.newSkull("§f(§a2§f) §cSalva-vida", "MHF_TNT");
	public static ItemStack salvavidas1 = Mine.newSkull("§f(§a1§f) §cSalva-vida", "MHF_TNT");
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
		    Player p = (Player)sender;
		    Mine.setLore(salvavidas4, " ","§7Nenhuma explosão lhe dará dano","§7e ao ser atacado uma explosão","§7ocorrerá.");
			Mine.setLore(salvavidas3, " ","§7Nenhuma explosão lhe dará dano","§7e ao ser atacado uma explosão","§7ocorrerá.");
			Mine.setLore(salvavidas2, " ","§7Nenhuma explosão lhe dará dano","§7e ao ser atacado uma explosão","§7ocorrerá.");
			Mine.setLore(salvavidas1, " ","§7Nenhuma explosão lhe dará dano","§7e ao ser atacado uma explosão","§7ocorrerá.");
		    if(args.length == 0) {
		    	p.sendMessage("§cUtilize /givesv <quantidade>.");
		    	return true;
		    }
		    if(p.hasPermission("salvavidas.admin")) {
		    	Mine.setLore(salvavidas, " ","§7Nenhuma explosão lhe dará dano","§7e ao ser atacado uma explosão","§7ocorrerá.");
		    	salvavidas.setAmount(Mine.toInt(args[0]));
		    	p.getInventory().addItem(salvavidas);
		    }
		}
		return false;
	}
	
}
