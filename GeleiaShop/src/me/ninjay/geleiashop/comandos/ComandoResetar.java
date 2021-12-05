package me.ninjay.geleiashop.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.geleiashop.main.Main;

public class ComandoResetar implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length > 0) {
				Player j = Bukkit.getPlayer(args[0]);
				if(j != null) {
					Main.config.set(j.getName()+"-adv", 0);
					Main.config.saveConfig();
					p.getServer().dispatchCommand(p.getServer().getConsoleSender(), "advancement revoke "+j.getName()+" everything");
					p.sendMessage("§aConquistas de "+j.getName()+" no jogo e no servidor resetadas.");
				}else {
					p.sendMessage("§cJogador não encontrado.");
				}
			}else {
				p.sendMessage("§cUtilize: /resetar <jogador>.");
			}
		}
		return false;
	}

}
