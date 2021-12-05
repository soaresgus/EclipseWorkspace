package me.ninjay.aureaup.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.aureaup.estruturas.ClassesAPI;
import me.ninjay.aureaup.estruturas.LoginAPI;
import me.ninjay.aureaup.main.Main;

public class ComandoRegister implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length == 0) {
				p.sendMessage("§cUse /register <senha>.");
				return true;
			}else {
				LoginAPI.registrar(p, args[0], Main.senhas);
				if(LoginAPI.hasLogando(p) == false) {
					ClassesAPI.aoEntrar(p);
				}
			}
		}
		return false;
	}

}
