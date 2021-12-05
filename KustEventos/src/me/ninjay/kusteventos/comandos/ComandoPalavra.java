package me.ninjay.kusteventos.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.kusteventos.estruturas.EventosManager;
import me.ninjay.kusteventos.utils.Mine;
import me.ninjay.kusteventos.utils.VaultAPI;

public class ComandoPalavra implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(EventosManager.definicoes.get("palavra_on") == null || EventosManager.definicoes.get("palavra_on").contains("false")) {
				p.sendMessage("§cO evento palavra não está ocorrendo.");
				return true;
		}
			if(EventosManager.definicoes.get("palavra_on").equalsIgnoreCase("true")) {
				if(args.length == 0) {
					p.sendMessage("§cUtilize: /palavra <Palavra determinada>.");
					return true;
				}
					if(args[0].equals(EventosManager.definicoes.get("palavra_palavra"))) {
						EventosManager.definicoes.put("palavra_ganhador", p.getName());
						EventosManager.definicoes.put("palavra_on", "false");
						p.sendMessage("§aVocê acertou a palavra!");
						p.sendMessage("§aPremiação entregue! (+$"+EventosManager.definicoes.get("palavra_valor")+")");
						VaultAPI.getEconomy().depositPlayer(p, Mine.toInt(EventosManager.definicoes.get("palavra_valor")));
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.sendMessage("§e§lEvento - Palavra\n \n§eO jogador §6§l"+p.getName()+" §efoi o mais rápido e venceu o evento!\n ");
						}
					}else {
						p.sendMessage("§cVocê errou a palavra :(, tente novamente.");
				}
				return true;
			}
		}
		return false;
	}

}
