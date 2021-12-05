package me.ninjay.circles_testes.comandos;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.circles_testes.estruturas.Tags;
import me.ninjay.circles_testes.estruturas.TagsAPI;
import me.ninjay.circles_testes.estruturas.TagsControler;


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
					Tags tag = TagsAPI.manager.getTagPorNome(args[2]);
					if (j != null) {
						if(tag != null) {
						p.sendMessage("§aCargo §a§l" + tag.getName() + " §asetado para §a§l" + j.getName() + "§a.");
						TagsControler.setarTag(j, tag.getName());
						}else {
							p.sendMessage("§cCargo não encontrado.");
							p.sendMessage("§eLista de cargos disponíveis:\n ");
							for(Tags tags : TagsAPI.manager.getTags()) {
								p.sendMessage(tags.getName());
							}
						}
				}else {
					p.sendMessage("§cJogador offline.");
				}
			}
			}else {
				return true;
			}
		}else {
			if (args.length <= 2) {
				sender.sendMessage("§cUtilize: /cargo setar <nick> <cargo>.");
				return true;
			}
				if (args[0].equalsIgnoreCase("setar")) {
					Player j = Bukkit.getPlayer(args[1]);
					Tags tag = TagsAPI.manager.getTagPorNome(args[2]);
					if (j != null) {
						if(tag != null) {
						sender.sendMessage("§aCargo §a§l" + tag.getName() + " §asetado para §a§l" + j.getName() + "§a.");
						TagsControler.setarTag(j, tag.getName());
						}else {
							sender.sendMessage("§cCargo não encontrado.");
							sender.sendMessage("§eLista de cargos disponíveis:\n ");
							for(Tags tags : TagsAPI.manager.getTags()) {
								sender.sendMessage(tags.getName());
							}
						}
				}else {
					sender.sendMessage("§cJogador offline.");
				}
			}
			}
		return false;
	}

}
