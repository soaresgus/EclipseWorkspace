package me.ninjay.aureaup.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.aureaup.estruturas.LoginAPI;
import me.ninjay.aureaup.main.Main;

public class ComandoTrocarSenha implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length == 0) {
				p.sendMessage("§cUse /trocarsenha <senha>.");
				return true;
			}else {
				LoginAPI.trocarSenha(p, args[0], Main.senhas);
			}
		}
		return false;
	}

}
