package me.ninjay.safeclub.comandos.recompensa;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.safeclub.estruturas.api.recompensa.RecompensaAPI;
import me.ninjay.safeclub.main.Main;

public class ComandoRecompensa implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			RecompensaAPI.abrir(p, Main.cooldowns);
				
		}
		return false;
	}

}
