package me.ninjay.onelogin.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoVerSenha implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("login.admin")) {
				if(args.length == 0) {
					p.sendMessage("§cUtilize /versenha <nick>.");
				}else {
					 p.sendMessage("§aA senha de "+args[0]+" é: "+ComandoLogar.config.getString(args[0]));
				}
			}
		}
		return false;
	}

}
