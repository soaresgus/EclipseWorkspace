package me.ninjay.onelogin.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoRemoverSenha implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("login.admin")) {
				if(args.length == 0) {
					p.sendMessage("§cUtilize /removersenha <nick>.");
					return true;
				}else {
					if(!ComandoLogar.config.contains(args[0])) {
						p.sendMessage("§cEsse jogador não está registrado no servidor.");
					}else {
						p.sendMessage("§aSenha de "+args[0]+" foi removida com sucesso !");
						ComandoLogar.config.set(args[0], null);
						ComandoLogar.config.saveConfig();
					}
				}
			}
				
		}
		return false;
	}

}
