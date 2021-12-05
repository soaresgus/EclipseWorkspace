package me.ninjay.safecore.comandos.lag;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.safecore.utils.Mine;

public class ComandoPing implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			p.sendMessage("§6§lSeu ping: §a" + Mine.getPing(p));
		}
		return false;
	}

}
