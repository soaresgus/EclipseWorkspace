package me.ninjay.ninjacall.comandos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.ninjacall.main.Main;
import me.ninjay.ninjacall.utils.VaultAPI;

public class ComandoCall implements CommandExecutor{
	
	public static HashMap<String, String> pedido = new HashMap<>();
		
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length == 0) {
				p.sendMessage("§cUtilize: /call <nick>.");
				return true;
			}
			Player j = Bukkit.getPlayer(args[0]);
			if(j == null) {
				p.sendMessage("§cO jogador §c§l"+args[0]+" §cnão existe ou está offline.");
				return true;
			}else {
				if(VaultAPI.getEconomy().has(p, 5000)) {
				p.sendMessage("§ePedido de teleporte enviado para §e§l"+args[0]+"§e.");
				j.sendMessage("§e§l"+p.getName()+" §eenviou um pedido de teletransporte.\n \n§ePara aceitar utilize: /bring "+p.getName()+"\n \n§eEm 20 segundos esse pedido irá ser cancelado.");
				pedido.put(p.getName(), j.getName());
				new BukkitRunnable() {
					int i = 20;
					@Override
					public void run() {
						i--;
						if(i == 0) {
							if(pedido.containsKey(p.getName())) {
							j.sendMessage("§eO pedido de teletransporte de §e§l"+p.getName()+" §efoi cancelado.");
							p.sendMessage("§eO pedido de teletransporte para §e§l"+j.getName()+" §enão foi aceito.");
							pedido.remove(p.getName());
							cancel();
						}else {
							cancel();
							return;
						}
						}
					}
				}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
			}else {
				p.sendMessage("§cPara usar o /call você precisa ter no minímo §c§l5000 §ccoins.");
			}
			}
				
		}
		return false;
	}

}
