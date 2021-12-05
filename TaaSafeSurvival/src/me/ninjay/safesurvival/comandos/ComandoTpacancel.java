package me.ninjay.safesurvival.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoTpacancel implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(ComandoTpa.pedido.containsKey(p.getName())) {
				Bukkit.getPlayer(ComandoTpa.pedido.get(p.getName())).sendMessage("§cO pedido de teletransporte de §c§l"+p.getName()+" §cfoi cancelado.");
				p.sendMessage("§cO pedido de teletransporte para §c§l"+Bukkit.getPlayer(ComandoTpa.pedido.get(p.getName())).getName()+" §cfoi cancelado");
				ComandoTpa.pedido.remove(p.getName());
			}else {
				p.sendMessage("§cVocê não possui algum pedido pendente.");
			}
		}
		return false;
	}

}
