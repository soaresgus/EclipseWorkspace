package me.ninjay.onelogin.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoRegistrar implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage("§cUtilize /register <senha>.");
				return true;
			}
			if(!ComandoLogar.config.contains(p.getName())) {
				ComandoLogar.config.set(p.getName(), args[0]);
				ComandoLogar.config.saveConfig();
				p.sendMessage("§aVocê foi registrado com §a§lsucesso§a !");
				ComandoLogar.logou.add(p);
				ComandoLogar.captcha(p);
			}else {
				p.sendMessage("§cVocê já está registrado, utilize /login <senha> para logar.");
			}
		}
		return false;
	}

}
