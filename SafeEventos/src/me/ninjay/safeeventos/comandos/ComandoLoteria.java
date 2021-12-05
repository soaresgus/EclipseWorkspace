package me.ninjay.safeeventos.comandos;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.safeeventos.estruturas.EventosManager;
import me.ninjay.safeeventos.utils.Mine;
import me.ninjay.safeeventos.utils.VaultAPI;

public class ComandoLoteria implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(EventosManager.definicoes.get("loteria_on") == null || EventosManager.definicoes.get("loteria_on").contains("false")) {
				p.sendMessage("§cA loteria não está ocorrendo.");
				return true;
		}
			if(EventosManager.definicoes.get("loteria_on").equalsIgnoreCase("true")) {
				if(args.length == 0) {
					p.sendMessage("§cUtilize: /loteria <Número 1 à 300>.");
				}
				if(StringUtils.isNumeric(args[0])) {
					if(args[0].equalsIgnoreCase(EventosManager.definicoes.get("loteria_numero"))) {
						EventosManager.definicoes.put("loteria_ganhador", p.getName());
						EventosManager.definicoes.put("loteria_on", "false");
						p.sendMessage("§aVocê acertou o número!");
						p.sendMessage("§aPremiação entregue! (+$"+EventosManager.definicoes.get("loteria_valor")+")");
						VaultAPI.getEconomy().depositPlayer(p, Mine.toInt(EventosManager.definicoes.get("loteria_valor")));
					}else {
						p.sendMessage("§cNúmero errado :(, tente novamente!");
					}
				}else {
					p.sendMessage("§cApenas números.");
				}
				return true;
			}
		}
		return false;
	}

}
