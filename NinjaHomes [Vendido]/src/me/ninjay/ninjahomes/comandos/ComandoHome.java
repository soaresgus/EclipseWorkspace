package me.ninjay.ninjahomes.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.ninjahomes.estruturas.HomesAPI;
import me.ninjay.ninjahomes.main.Main;

public class ComandoHome implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length == 0) {
				p.sendMessage("§cUtilize: /home <nome>.\n§cou\n§cUtilize: /home <nome> <player>.");
				return true;
			}
			if(args.length == 1) {
				if(Main.homeconf.contains(p.getName()+".homes."+args[0])) {
					if(p.hasPermission("home.limite")) {
						new BukkitRunnable() {
							int i = Main.config.getInt("TempoVip");
							@Override
							public void run() {
								if(i >= i) {
									p.sendMessage("§eTeleportando em "+i+" segundos.");
								}
								i--;
								if(i <= 0) {
									HomesAPI.tpHome(p, args[0]);
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}else {
						new BukkitRunnable() {
							int i = Main.config.getInt("TempoMembro");
							@Override
							public void run() {
								if(i >= i) {
									p.sendMessage("§eTeleportando em "+i+" segundos.");
								}
								i--;
								if(i <= 0) {
									HomesAPI.tpHome(p, args[0]);
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
				}else {
					p.sendMessage("§cA home §c§l"+args[0]+" §cnão existe.");
					return true;
				}
			}else {
				if(Main.listar.contains(args[1]+".homes."+args[0])) {
					if(Main.listar.getBoolean(args[1]+".homes."+args[0]) == true) {
						if(p.hasPermission("home.limite")) {
							new BukkitRunnable() {
								int i = Main.config.getInt("TempoVip");
								@Override
								public void run() {
									if(i >= i) {
										p.sendMessage("§eTeleportando em "+i+" segundos.");
									}
									i--;
									if(i <= 0) {
										HomesAPI.tpHome(Bukkit.getPlayer(args[1]), args[0]);
										cancel();
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
						}else {
							new BukkitRunnable() {
								int i = Main.config.getInt("TempoMembro");
								@Override
								public void run() {
									if(i >= i) {
										p.sendMessage("§eTeleportando em "+i+" segundos.");
									}
									i--;
									if(i <= 0) {
										HomesAPI.tpHome(Bukkit.getPlayer(args[1]), args[0]);
										cancel();
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
						}
					}else {
					 p.sendMessage("§cA home §c§l"+args[0]+" §cdo jogador §c§l"+args[1]+" §cnão está pública.");
					 return true;
					}
				}else {
					p.sendMessage("§cA home §c§l"+args[0]+" §cdo jogador §c§l"+args[1]+" §cnão existe.");
					return true;
				}
			}
		}
		return false;
	}

}
