package me.ninjay.onelogin.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoTrocarSenha implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage("§cUtilize /trocarsenha <senha>.");
				return true;
			}
			if(ComandoLogar.config.contains(p.getName())) {
				p.sendMessage("§aSua senha foi alterada com sucesso !");
				ComandoLogar.config.set(p.getName(), args[0]);
				ComandoLogar.config.saveConfig();
			}
		}
		return false;
	}

}
