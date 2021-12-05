package me.ninjay.safestaff.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nametagedit.plugin.NametagEdit;

import me.ninjay.safecore.estruturas.tags.Tags;
import me.ninjay.safecore.estruturas.tags.TagsAPI;
import me.ninjay.safecore.utils.VaultAPI;


public class ComandoS implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			
			if(p.hasPermission("staff.chat")) {
				if(args.length == 0) {
					p.sendMessage("§cUse: /s <mensagem>.");
					return true;
				}
				String msg = " ";
				for (int i = 0; i < args.length; i++) {
					msg = String.valueOf(msg) + args[i];
					msg = String.valueOf(msg) + " ";
				}
				Tags tag = TagsAPI.manager.getTagPorNome(VaultAPI.getPermission().getPrimaryGroup(p));
				for(Player all : Bukkit.getOnlinePlayers()) {
					if(all.hasPermission("staff.chat")) {
							if(all.hasPermission(tag.getPerm())) {
								all.sendMessage("§d[STAFF] "+NametagEdit.getApi().getNametag(p).getPrefix()+p.getName()+":"+msg);
						}
					}
				}
			}else {
				p.sendMessage("§cSem permissão.");
			}
			
		}
		return false;
	}

}
