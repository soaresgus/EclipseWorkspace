package me.ninjay.ninjakitpvp.comandos.admin;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoBuild implements CommandExecutor {

	public static ArrayList<Player> build = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("build.admin")) {
				if (args.length == 0) {
					p.sendMessage("§cUse /build <on/off>");
					return true;
				}
				if (args[0].equalsIgnoreCase("on")) {
					if (!build.contains(p)) {
						p.sendMessage("§aConstrução ativada !");
						build.add(p);
					} else {
						p.sendMessage("§cSua construção ja está ativada !");
						return true;
					}
				}
				if(args[0].equalsIgnoreCase("off")) {
					if(build.contains(p)) {
						p.sendMessage("§aConstrução desativada !");
						build.remove(p);
					}else {
						p.sendMessage("§cSua construção já está desativada !");
					}
				}

			}
		}
		return false;
	}

}
