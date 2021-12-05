package me.ninjay.kuststaff.comandos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.kuststaff.main.Main;

public class ComandoReport implements CommandExecutor{
	
	private static HashMap<String, String> report = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length == 0) {
				p.sendMessage("§cUse: /report <nick> <motivo>.");
				return true;
			}
			Player j = Bukkit.getPlayer(args[0]);
		if(j != null) {
	if(report.get(p.getName()) == null || !report.get(p.getName()).contains(j.getName())) {
		if(!args[0].equalsIgnoreCase(p.getName())) {
			if(args.length == 1) {
				p.sendMessage("§aDenúncia enviada.");
				report.put(p.getName(), j.getName());
				Main.reports.set("reports", Main.reports.getInt("reports")+1);
				Main.reports.set(Main.reports.getInt("reports")+".acusado", j.getName());
				Main.reports.set(Main.reports.getInt("reports")+".motivo", "Não informado.");
				Main.reports.set(Main.reports.getInt("reports")+".vitima", p.getName());
				Main.reports.saveConfig();
				for(Player todos : Bukkit.getOnlinePlayers()) {
					if(todos.hasPermission("report.admin")) {
						todos.sendMessage(" \n§aUma nova denúncia foi enviada.\n ");
						todos.playSound(todos.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					}
				}
			}else {
				p.sendMessage("§aDenúncia enviada.");
				report.put(p.getName(), j.getName());
				Main.reports.set("reports", Main.reports.getInt("reports")+1);
				Main.reports.set(Main.reports.getInt("reports")+".acusado", j.getName());
				Main.reports.set(Main.reports.getInt("reports")+".motivo", args[1]);
				Main.reports.set(Main.reports.getInt("reports")+".vitima", p.getName());
				Main.reports.saveConfig();
				for(Player todos : Bukkit.getOnlinePlayers()) {
					if(todos.hasPermission("report.admin")) {
						todos.sendMessage(" \n§aUma nova denúncia foi enviada.\n ");
						todos.playSound(todos.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					}
				}
			}
			
		}else {
			p.sendMessage("§cVocê não pode denunciar você mesmo.");
		}
			}else {
				p.sendMessage("§cVocê já denúnciou esse mesmo jogador.");
			}
		}else {
			p.sendMessage("§cJogador offline.");
		}
		}
		return false;
	}

}
