package me.ninjay.ninjacall.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjacall.utils.VaultAPI;

public class ComandoBring implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length == 0) {
				p.sendMessage("§cUtilize: /bring <nick>.");
				return true;
			}
			Player j = Bukkit.getPlayer(args[0]);
			if(j == null) {
				p.sendMessage("§cO jogador §c§l"+args[0]+" §cnão existe ou está offline.");
				return true;
			}else {
				if(ComandoCall.pedido.get(j.getName()) == p.getName()) {
					p.sendMessage("§ePedido de teletransporte de §e§l"+j.getName()+" §efoi aceito.");
					j.sendMessage("§ePedido de teletransporte para §e§l"+p.getName()+" §efoi aceito e foi retirado 5 coins de sua conta.");
					j.teleport(p.getLocation());
					VaultAPI.getEconomy().withdrawPlayer(j, 5.0);
					ComandoCall.pedido.remove(j.getName());
				}else {
					p.sendMessage("§cO jogador §c§l"+args[0]+" §cnão te enviou pedido de teletransporte.");
				}
			}
			
		}
		return false;
	}

}
