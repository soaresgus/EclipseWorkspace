package me.ninjay.kustpunir.comandos;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.kustpunir.estruturas.PunirControler;
import me.ninjay.kustpunir.main.Main;

public class ComandoRevogar implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.hasPermission("revogar.admin")) {
				if(args.length == 0) {
					p.sendMessage("§cUse: /revogar <nick>.");
					return true;
				}
				OfflinePlayer player = Bukkit.getOfflinePlayer(args[0]);
				
				if(PunirControler.config.contains(player.getName()+".ativo")) {
					PunirControler.config.remove(player.getName()+".status");
					PunirControler.config.remove(player.getName()+".punido");
					PunirControler.config.remove(player.getName()+".punido");
					PunirControler.config.remove(player.getName()+".ativo");
					new BukkitRunnable() {
						
						@Override
						public void run() {
							PunirControler.config.remove(player.getName()+".tempo");
							PunirControler.config.saveConfig();
						}
					}.runTaskLater(Main.getPlugin(Main.class), 5*20);
					PunirControler.config.saveConfig();
					p.sendMessage("§aPunição ativa revogada.");
				}else {
					p.sendMessage("§cEsse jogador não possui punições ativas.");
				}
			}else {
				p.sendMessage("§cSem permissão.");
			}
			
		}else {
			if(args.length == 0) {
				sender.sendMessage("§cUse: /revogar <nick>.");
				return true;
			}
			OfflinePlayer player = Bukkit.getOfflinePlayer(args[0]);
			
			if(PunirControler.config.contains(player.getName()+".ativo")) {
				PunirControler.config.remove(player.getName()+".status");
				PunirControler.config.remove(player.getName()+".punido");
				PunirControler.config.remove(player.getName()+".punido");
				PunirControler.config.remove(player.getName()+".ativo");
				new BukkitRunnable() {
					
					@Override
					public void run() {
						PunirControler.config.remove(player.getName()+".tempo");
						PunirControler.config.saveConfig();
					}
				}.runTaskLater(Main.getPlugin(Main.class), 5*20);
				PunirControler.config.saveConfig();
				sender.sendMessage("§aPunição ativa revogada.");
			}else {
				sender.sendMessage("§cEsse jogador não possui punições ativas.");
			}
			
		}
		return false;
	}

}
