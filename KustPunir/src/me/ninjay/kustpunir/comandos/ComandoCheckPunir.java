package me.ninjay.kustpunir.comandos;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.kustpunir.estruturas.Punir;
import me.ninjay.kustpunir.estruturas.PunirAPI;
import me.ninjay.kustpunir.estruturas.PunirControler;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.HoverEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;

public class ComandoCheckPunir implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.hasPermission("check.punir")) {
				if(args.length == 0) {
					p.sendMessage("§cUse: /checkpunir <nick>.");
					return true;
				}
				OfflinePlayer check = Bukkit.getOfflinePlayer(args[0]);
				p.sendMessage(" ");
				p.sendMessage("§ePunições de "+check.getName()+":");
				for(Punir punirs : PunirAPI.manager.getPunirs()) {
					if(PunirControler.config.contains(check.getName()+"."+punirs.getName()+".ban1")) {
						if(!PunirControler.config.contains(check.getName()+".ativo") || !PunirControler.config.getString(check.getName()+".ativo").equalsIgnoreCase(punirs.getName())) {
							TextComponent texto = new TextComponent(TextComponent.fromLegacyText("§c["+punirs.getNome()+"]"));
							texto.setHoverEvent(new HoverEvent(Action.SHOW_TEXT, new ComponentBuilder("§7Nick: §f"+check.getName()+"\n§7Motivo: §f"+punirs.getNome()+"\n§7Prova: §f"+PunirControler.config.getString(check.getName()+"."+punirs.getName()+".prova")).create()));
							texto.setClickEvent(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.SUGGEST_COMMAND, PunirControler.config.getString(check.getName()+"."+punirs.getName()+".prova")));
							p.spigot().sendMessage(texto);
						}
							if(PunirControler.config.contains(check.getName()+".ativo") && PunirControler.config.getString(check.getName()+".ativo").equalsIgnoreCase(punirs.getName())) {
								TextComponent texto = new TextComponent(TextComponent.fromLegacyText("§a["+punirs.getNome()+"] §f[Revogar]"));
								texto.setHoverEvent(new HoverEvent(Action.SHOW_TEXT, new ComponentBuilder("§7Nick: §f"+check.getName()+"\n§7Motivo: §f"+punirs.getNome()+"\n§7Prova: §f"+PunirControler.config.getString(check.getName()+"."+punirs.getName()+".prova")).create()));
								texto.setClickEvent(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.SUGGEST_COMMAND, "/revogar "+check.getName()));
								p.spigot().sendMessage(texto);
						}
					}
				}
				p.sendMessage(" ");
			}else {
				p.sendMessage("§cSem permissão.");
			}
		}
		return false;
	}

}
