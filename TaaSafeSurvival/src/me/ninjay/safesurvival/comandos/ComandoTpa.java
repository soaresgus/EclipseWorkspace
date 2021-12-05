package me.ninjay.safesurvival.comandos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.safesurvival.main.Main;

public class ComandoTpa implements CommandExecutor{
	
	public static HashMap<String, String> pedido = new HashMap<>();
		
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length == 0) {
				p.sendMessage("§cUtilize: /tpa <nick>.");
				return true;
			}
			Player j = Bukkit.getPlayer(args[0]);
			if(j == null) {
				p.sendMessage("§cO jogador §c§l"+args[0]+" §cnão existe ou está offline.");
				return true;
			}else {
				if(j != p) {
				p.sendMessage("§ePedido de teleporte enviado para §6§l"+args[0]+"§e.");
				j.sendMessage("§6§l"+p.getName()+" §eenviou um pedido de teletransporte.\n \n§ePara aceitar utilize: §6/tpaccept "+p.getName()+"\n \n§eEm §620 segundos §eesse pedido irá ser cancelado.");
				pedido.put(p.getName(), j.getName());
				new BukkitRunnable() {
					int i = 20;
					@Override
					public void run() {
						i--;
						if(i == 0) {
							if(pedido.containsKey(p.getName())) {
							j.sendMessage("§eO pedido de teletransporte de §6§l"+p.getName()+" §efoi cancelado.");
							p.sendMessage("§eO pedido de teletransporte para §6§l"+j.getName()+" §enão foi aceito.");
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
				p.sendMessage("§cVocê não pode solicitar teletransporte para si mesmo.");
			}
			}
		}
		return false;
	}

}
