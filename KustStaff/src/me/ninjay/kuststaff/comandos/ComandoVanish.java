package me.ninjay.kuststaff.comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.ninjay.kuststaff.utils.Mine;

public class ComandoVanish implements CommandExecutor, Listener{
	
	public static ArrayList<Player> ativo = new ArrayList<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.hasPermission("vanish.admin")) {
			if(args.length == 0) {
				if(!ativo.contains(p)) {
					p.sendMessage("§aVanish ativado com sucesso.");
					for(Player todos : Bukkit.getOnlinePlayers()) {
						todos.hidePlayer(p);
					}
					ativo.add(p);
				}else {
					p.sendMessage("§cVanish desativado com sucesso.");
					Mine.sendActionBar(p, "§cModo vanish desativado!");
					for(Player todos : Bukkit.getOnlinePlayers()) {
						todos.showPlayer(p);
					}
					ativo.remove(p);
				}
			}else {
				Player j = Bukkit.getPlayer(args[0]);
				if(j != null) {
					if(!ativo.contains(j)) {
						p.sendMessage("§aVanish ativado para "+j.getName()+".");
						j.sendMessage("§aVanish ativado com sucesso.");
						for(Player todos : Bukkit.getOnlinePlayers()) {
							todos.hidePlayer(j);
						}
						ativo.add(j);
					}else {
						p.sendMessage("§cVanish desativado para "+j.getName()+".");
						j.sendMessage("§cVanish desativado com sucesso.");
						Mine.sendActionBar(j, "§cModo vanish desativado!");
						for(Player todos : Bukkit.getOnlinePlayers()) {
							todos.showPlayer(j);
						}
						ativo.remove(j);
					}
				}else {
					p.sendMessage("§cJogador offline.");
				}
			}
			}
			
		}
		return false;
	}
	
	@EventHandler
	public void aoDano(EntityDamageByEntityEvent e) { 

	if(e.getDamager().getType() == EntityType.PLAYER) {
		Player p = (Player) e.getDamager();
		if(ativo.contains(p)) {
			e.setCancelled(true);
		}
	}
	}

}
