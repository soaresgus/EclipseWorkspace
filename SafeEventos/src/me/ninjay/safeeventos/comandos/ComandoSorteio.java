package me.ninjay.safeeventos.comandos;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.safeeventos.estruturas.EventosManager;

public class ComandoSorteio implements CommandExecutor{
	
	public static ArrayList<Player> part = new ArrayList<>();	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(EventosManager.definicoes.get("sorteio_on") == null || EventosManager.definicoes.get("sorteio_on").contains("false")) {
				p.sendMessage("§cO sorteio não está ocorrendo.");
				return true;
		}
			if(EventosManager.definicoes.get("sorteio_on").equalsIgnoreCase("true")) {
				if(!part.contains(p)) {
				part.add(p);
				p.sendMessage("§aParticipação confirmada!");
				return true;
			}else {
				p.sendMessage("§cVocê já está participando do sorteio!");
			}
			}
		}
		return false;
	}

}
