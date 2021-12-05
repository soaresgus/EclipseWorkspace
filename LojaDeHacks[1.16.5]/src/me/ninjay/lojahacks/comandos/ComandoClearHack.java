package me.ninjay.lojahacks.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import me.ninjay.lojahacks.eventos.EventosGeral;

public class ComandoClearHack implements CommandExecutor{ 

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length <= 0) {
				p.sendMessage("§cUtilize: /clearhack [jogador].");
				return true;
			}
			
			Player j = Bukkit.getPlayer(args[0]);
			
			if(j != null) {
				EventosGeral.hack.remove(j);
				EventosGeral.usando = false;
				EventosGeral.fanta.remove(j);
			    for (PotionEffect effect : j.getActivePotionEffects()) {
			        j.removePotionEffect(effect.getType());
			    }
				p.sendMessage("§aHacks de "+j.getName()+" retirados.");
			}else {
				p.sendMessage("§cJogador não encontrado");
			}
			
		}
		return false;
	}

}
