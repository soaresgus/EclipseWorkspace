package me.ninjay.safeclub.estruturas.api.eventos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoGladiator implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			Evento evento = EventoAPI.manager.geteventocomando(cmd.getName());
			
			EventoManager.entrar(p, evento);
			
		}
		return false;
	}

}
