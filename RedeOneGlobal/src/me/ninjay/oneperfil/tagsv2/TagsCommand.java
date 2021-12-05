package me.ninjay.oneperfil.tagsv2;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TagsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("cargo.admin")) {
				if (args.length <= 2) {
					p.sendMessage(
							"§6§lCargos do servidor: §6[Diretor] §4[Gerente] §c[Admin] §9[Dev] §2[Moderador] §d[Builder] §e[Ajudante] §c[YT] §4[Titan] §5[Gladiador] §3[Guerreiro]");
					return true;
				}
			}else {
			   return true;
			}
			Player j = Bukkit.getPlayer(args[0]);
			String sub = args[1];
			Tags tag = TagsAPI.manager.getTag(args[2]);
			if (tag == null) {
               p.sendMessage("§cA tag "+args[2]+" não foi encontrada no banco de dados.");
               return true;
			}else {
				if(sub.equalsIgnoreCase("setar")) {
					TagsAPI.manager.setar(p, j, tag);
					return true;
				}
			}
			
		}
		return false;
	}

}
