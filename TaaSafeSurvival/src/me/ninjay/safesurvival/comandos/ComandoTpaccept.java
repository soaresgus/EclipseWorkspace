package me.ninjay.safesurvival.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ComandoTpaccept implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length == 0) {
				p.sendMessage("§cUtilize: /tpaccept <nick>.");
				return true;
			}
			Player j = Bukkit.getPlayer(args[0]);
			if(j == null) {
				p.sendMessage("§cO jogador §c§l"+args[0]+" §cnão existe ou está offline.");
				return true;
			}else {
				if(j != p) {
				if(ComandoTpa.pedido.get(j.getName()) == p.getName()) {
					p.sendMessage("§ePedido de teletransporte de §6§l"+j.getName()+" §efoi aceito.");
					j.sendMessage("§ePedido de teletransporte para §6§l"+p.getName()+" §efoi aceito.");
					j.teleport(p.getLocation());
					ComandoTpa.pedido.remove(j.getName());
				}else {
					p.sendMessage("§cO jogador §c§l"+args[0]+" §cnão te enviou pedido de teletransporte.");
				}
				}else {
					p.sendMessage("§cVocê não pode aceitar teletransporte para si mesmo.");
				}
			}
			
		}
		return false;
	}

}
