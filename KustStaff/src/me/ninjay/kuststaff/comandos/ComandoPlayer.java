package me.ninjay.kuststaff.comandos;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.kuststaff.main.Main;
import me.ninjay.kuststaff.utils.Mine;

public class ComandoPlayer implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(p.hasPermission("player.admin")) {
				if(args.length <= 0) {
					p.sendMessage("§cUse: /player <nick>.");
					return true;
				}
			if(Main.config.contains(args[0]+".nick")) {
				p.sendMessage("§eInformações do jogador\n§fNick: §e"+Main.config.getString(args[0]+".nick")+"\n§fGrupo: §e"+Main.config.getString(args[0]+".cargo")+"\n§fÚltimo acesso: §e"+Main.config.getString(args[0]+".ultimo")+"\n§fPrimeiro acesso: §e"+Main.config.getString(args[0]+".primeiro")+"\n§fIP: §e"+Main.config.getString(args[0]+".ip"));
				List<String> nicksl = (List<String>)Main.getPlugin(Main.class).getConfig().get("ip."+Main.config.getString(args[0]+".ip").replace(".", "-"));
				p.sendMessage("§fContas associadas: ");
				for(String contas : nicksl) {
					if(contas != null) {
						p.sendMessage("§e - "+contas);
					}
				}
			}else {
				p.sendMessage("§cJogador não encontrado.");
			}
				
			}
			
		}
		return false;
	}
	

}
