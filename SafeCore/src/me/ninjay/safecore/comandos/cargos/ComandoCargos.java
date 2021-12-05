package me.ninjay.safecore.comandos.cargos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.safecore.estruturas.tags.TagsControler;

public class ComandoCargos implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("cargos.perm")) {
			if (args.length <= 2) {
				p.sendMessage("§cUtilize: /cargo setar <nick> <cargo>.");
				return true;
			}
				if (args[0].equalsIgnoreCase("setar")) {
					Player j = Bukkit.getPlayer(args[1]);
					if (j != null) {
						p.sendMessage("§aCargo §a§l" + args[2] + " §asetado para §a§l" + j.getName() + "§a.");
						TagsControler.setarTag(j, args[2]);
				}
			}
			}else {
				p.sendMessage("§cSem permissão.");
				return true;
			}
		}
		return false;
	}

}
