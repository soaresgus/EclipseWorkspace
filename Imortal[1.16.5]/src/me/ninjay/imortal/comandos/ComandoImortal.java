package me.ninjay.imortal.comandos;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.imortal.main.Main;

public class ComandoImortal implements CommandExecutor{
	
	public static ArrayList<Player> usando = new ArrayList<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(!usando.contains(p)) {
				p.sendMessage("§aImortal ativado!");
				new BukkitRunnable() {
					
					@Override
					public void run() {
						usando.add(p);
					}
				}.runTaskLater(Main.getPlugin(Main.class), 2);
			}else {
				p.sendMessage("§cImortal desativado!");
				new BukkitRunnable() {
					
					@Override
					public void run() {
						usando.remove(p);
					}
				}.runTaskLater(Main.getPlugin(Main.class), 2);
			}
			
		}
		return false;
	}

}
