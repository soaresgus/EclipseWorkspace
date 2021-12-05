package me.ninjay.safeeventos.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.safeeventos.estruturas.BPManager;

public class ComandoBasePerdida implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(BPManager.config.getBoolean("bp.ocorrendo") == true) {
			p.sendMessage("§aTeleportado!");
			p.teleport(BPManager.config.getLocation("bp.spawn"));
			}else {
				p.sendMessage("§cA base perdida ainda não foi encontrada...");
			}
		}
		return false;
	}

}
