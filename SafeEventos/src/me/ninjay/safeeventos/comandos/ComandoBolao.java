package me.ninjay.safeeventos.comandos;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.safeeventos.estruturas.EventosManager;
import me.ninjay.safeeventos.utils.Mine;
import me.ninjay.safeeventos.utils.VaultAPI;

public class ComandoBolao implements CommandExecutor{
	
	public static ArrayList<Player> part = new ArrayList<>();	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(EventosManager.definicoes.get("bolao_on") == null || EventosManager.definicoes.get("bolao_on").contains("false")) {
				p.sendMessage("§cO bolão não está ocorrendo.");
				return true;
		}
			if(EventosManager.definicoes.get("bolao_on").equalsIgnoreCase("true")) {
				if(!part.contains(p)) {
				VaultAPI.getEconomy().withdrawPlayer(p, Mine.toInt(EventosManager.definicoes.get("bolao_valor")));
				EventosManager.definicoes.put("bolao_acumulado", EventosManager.definicoes.get("bolao_valor"));
				part.add(p);
				p.sendMessage("§aParticipação confirmada!");
				return true;
			}else {
				p.sendMessage("§cVocê já está participando do bolão!");
			}
			}
		}
		return false;
	}

}
