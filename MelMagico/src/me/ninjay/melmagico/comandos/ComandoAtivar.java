package me.ninjay.melmagico.comandos;

import java.util.HashMap;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoAtivar implements CommandExecutor{
	
	public static HashMap<Player, Boolean> ativado = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			ativado.put(p, true);
			p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
			p.sendMessage(" \n  §aMagia de troca de local ativada!\n ");
		}
		return false;
	}

}
