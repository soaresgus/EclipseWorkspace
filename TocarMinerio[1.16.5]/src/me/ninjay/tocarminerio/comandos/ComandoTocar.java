package me.ninjay.tocarminerio.comandos;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoTocar implements CommandExecutor{
	
	public static HashMap<Player, Material> save = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(args.length == 0) {
				p.sendMessage("§cUtilize: /tocar [ferro/ouro/diamante].");
				return true;
			}
			
			if(args[0].equalsIgnoreCase("ferro")) {
				save.remove(p);
				save.put(p, Material.IRON_ORE);
				p.sendMessage("§aModo ferro habilitado!");
			}
			
			if(args[0].equalsIgnoreCase("ouro")) {
				save.remove(p);
				save.put(p, Material.GOLD_ORE);
				p.sendMessage("§aModo ouro habilitado!");
			}
			
			if(args[0].equalsIgnoreCase("diamante")) {
				save.remove(p);
				save.put(p, Material.DIAMOND_ORE);
				p.sendMessage("§aModo diamante habilitado!");
			}
		}
		return false;
	}

}
