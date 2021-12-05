package me.ninjay.random.comandos.encantar;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.random.main.Main;

public class ComandoXp implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage("§e§lSeu xp: "+Main.xp.getDouble(p.getName()));
				return true;
			}
			String valor = args[0];
			Double valord = Mine.toDouble(valor);
			
			Main.xp.set(p.getName(), valord);
			Main.xp.saveConfig();
			p.sendMessage("§eVocê setou "+valor+" de xp !");
			
					
			
		}
		return false;
	}

}
