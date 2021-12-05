package me.ninjay.safestaff.comandos;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.safecore.main.Main;

public class ComandoTph implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(!p.hasPermission("tph.perm")) {
				p.sendMessage("§cSem permissão.");
			}
			if(p.hasPermission("tph.perm")) {
				if(args.length == 0) {
					p.sendMessage("§cUse: /tph <nick>.");
					return true;
				}
				if(ComandoHacker.denuncia.get(Bukkit.getPlayer(args[0])) == null) {
					if(ComandoHacker.denuncia.containsKey(Bukkit.getPlayer(args[0]))) {
						if(p.getGameMode() == GameMode.SPECTATOR) {
						ComandoHacker.denuncia.put(Bukkit.getPlayer(args[0]), p);
						p.sendMessage("§aSolicitação aceita, você terá 5 minutos para encontar alguma coisa no acusado.");
						p.teleport(Bukkit.getPlayer(args[0]));
						p.sendMessage("§aTeleportado!");
						new BukkitRunnable() {
							int i = 5*60;
							@Override
							public void run() {
								i--;
								if(i <= 0) {
									cancel();
									p.sendMessage("§aSeu tempo para espectar o jogador "+args[0]+" foi encerrado.");
									p.teleport(Main.config.getLocation("spawn"));
									ComandoHacker.denuncia.remove(Bukkit.getPlayer(args[0]));
								}
							}
						}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
					}else {
						p.sendMessage("§cVocê precisa estar no modo espectador para teleportar.");
					}
					}else {
						p.sendMessage("§cEsse jogador não solicitou um moderador.");
					}
				}else {
					p.sendMessage("§cEsse jogador já está sendo atendido.");
				}
			}
		}
		return false;
	}

}
