package me.ninjay.olympiclobby.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.olympiclobby.api.LoginAPI;



public class ComandoLogin implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length ==0 ) {
				return true;
			}else {
			LoginAPI.logar(p, args[0], ComandoRegister.config);
		}
		}
		return false;
	}

}


