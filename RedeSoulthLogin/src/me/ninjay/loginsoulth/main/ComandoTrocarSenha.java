package me.ninjay.loginsoulth.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjaapi.utils.Mine;


public class ComandoTrocarSenha implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage("§cUtilize /trocarsenha <nova senha>");
				Mine.sendActionBar(p, "§cUtilize /trocarsenha <nova senha>");
				return true;
			}
			Main.senhas.set(p.getName(), args[0]);
			Main.senhas.saveConfig();
			p.sendMessage("§aSenha §a§lTROCADA §acom sucesso.");
			Mine.sendActionBar(p,"§aSenha §a§lTROCADA §acom sucesso.");
		}
		return false;
	}

}
