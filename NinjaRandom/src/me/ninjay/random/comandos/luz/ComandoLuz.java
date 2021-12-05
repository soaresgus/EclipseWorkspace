package me.ninjay.random.comandos.luz;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ComandoLuz implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			ArrayList<Player> lista = new ArrayList<>();
			if(!lista.contains(p)) {
				lista.add(p);
				p.sendMessage("desativado");
				return true;
			}
			
			if(lista.contains(p)) {
				p.sendMessage("ativado");
				return true;
			}
		}
		return false;
	}

}
