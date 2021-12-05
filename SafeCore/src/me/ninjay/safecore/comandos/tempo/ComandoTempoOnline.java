package me.ninjay.safecore.comandos.tempo;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.safecore.estruturas.timer.TimerAPI;
import me.ninjay.safecore.eventos.EventosGeral;
import me.ninjay.utils.utils.Mine;

public class ComandoTempoOnline implements CommandExecutor {

	public static String formatarTempoMSDHMS(Long tempo) {
		return String.format("%02d meses %02d semanas %02d dias %02d horas %02d minutos %02d segundos", tempo / 2592000,
				(tempo % 2592000) / 604800, (tempo % 604800) / 86400, (tempo % 86400) / 3600, (tempo % 3600) / 60,
				tempo % 60);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage("§6§lSeu tempo online: §a"
						+ formatarTempoMSDHMS(TimerAPI.getTempoCorrendo(EventosGeral.config, p.getName())));
			} else if (args[0].equalsIgnoreCase("setar")) {
				if (p.hasPermission("tempo.perm")) {
					if (StringUtils.isNumeric(args[2])) {
						p.sendMessage("§aTempo de " + Bukkit.getPlayer(args[1]).getName() + " setado para "
								+ formatarTempoMSDHMS(Mine.toLong(args[2])));
						EventosGeral.config.remove(p.getName());
						EventosGeral.config.saveConfig();
						TimerAPI.setTempo(EventosGeral.config, p.getName(), Mine.toLong(args[2]));
					}

				}else {
					p.sendMessage("§cSem permissão.");
				}
			}

		}
		return false;
	}

}
