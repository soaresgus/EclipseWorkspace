package me.ninjay.kustmanutencao.comandos;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.kustcombatlog.eventos.EventosGeral;
import me.ninjay.kustmanutencao.main.Main;
import me.ninjay.kustmanutencao.utils.Mine;

public class ComandoReiniciar implements CommandExecutor{
	
	public static boolean ocorrendo = false;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(p.hasPermission("reiniciar.admin")) {
				if(args.length == 0) {
					p.sendMessage("§cUtilize: /reiniciar <tempo>.");
					return true;
				}
				
				if(StringUtils.isNumeric(args[0])) {
					if(Mine.toInt(args[0]) > 5) {
						if(ocorrendo == false) {
						ocorrendo = true;
						for(int i = 0; i < 100; i++) {
							Bukkit.broadcastMessage(" ");
						}
						Bukkit.broadcastMessage("§eO servidor será reiniciando em §e§l"+args[0]+" segundos!\n \n§eAlgumas funções foram desabilitadas durante o reinicio.\n ");
						new BukkitRunnable() {
							int i = Mine.toInt(args[0]);
							@Override
							public void run() {
								i--;
								EventosGeral.save.clear();
								Mine.sendTitle("§e§lReiniciando...", "§eReiniciando em "+i+" segundos", 1, 30, 1);
								if(i <= 5) {
									Bukkit.broadcastMessage("§eReiniciando o servidor em "+i);
								}
								
								if(i <= 0) {
									cancel();
									EventosGeral.save.clear();
									ocorrendo = false;
									Bukkit.shutdown();
									for(Player todos : Bukkit.getOnlinePlayers()) {
										todos.kickPlayer("§cServidor reiniciando, aguarde!");
									}
									Bukkit.setWhitelist(true);
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
						}else {
							p.sendMessage("§cReincialização ocorrendo.");
						}
					}else {
						p.sendMessage("§cTempo mínimo de 6 segundos ou mais.");
					}
				}else {
					p.sendMessage("§cApenas números.");
				}
			}
			
		}else {
			if(StringUtils.isNumeric(args[0])) {
				if(Mine.toInt(args[0]) > 5) {
					if(ocorrendo == false) {
					ocorrendo = true;
					for(int i = 0; i < 100; i++) {
						Bukkit.broadcastMessage(" ");
					}
					Bukkit.broadcastMessage("§eO servidor será reiniciando em §e§l"+args[0]+" segundos!\n \n§eAlgumas funções foram desabilitadas durante o reinicio.\n ");
					new BukkitRunnable() {
						int i = Mine.toInt(args[0]);
						@Override
						public void run() {
							i--;
							EventosGeral.save.clear();
							Mine.sendTitle("§e§lReiniciando...", "§eReiniciando em "+i+" segundos", 5, 30, 5);
							if(i <= 5) {
								Bukkit.broadcastMessage("§eReiniciando o servidor em "+i);
							}
							
							if(i <= 0) {
								cancel();
								EventosGeral.save.clear();
								ocorrendo = false;
								Bukkit.shutdown();
								for(Player todos : Bukkit.getOnlinePlayers()) {
									todos.kickPlayer("§cServidor reiniciando, aguarde!");
								}
								Bukkit.setWhitelist(true);
							}
						}
					}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}else {
						sender.sendMessage("§cReincialização ocorrendo.");
					}
				}else {
					sender.sendMessage("§cTempo mínimo de 6 segundos ou mais.");
				}
			}else {
				sender.sendMessage("§cApenas números.");
			}
		}
		return false;
	}

}
