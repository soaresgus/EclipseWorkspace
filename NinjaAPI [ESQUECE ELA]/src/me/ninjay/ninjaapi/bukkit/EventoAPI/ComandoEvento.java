package me.ninjay.ninjaapi.bukkit.EventoAPI;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjaapi.utils.Mine;

public class ComandoEvento implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!p.hasPermission("evento.admin")) {
				p.sendMessage("§cVocê não tem permissão para utilizar esse comando :(");
				return true;
			}
			if(p.hasPermission("evento.admin")) {
				if(args.length == 0) {
					p.sendMessage("§cUtilize: /evento <iniciar, set ou setwin>");
					return true;
				}
			}
			if (p.hasPermission("evento.admin")) {
				if (args[0].equalsIgnoreCase("iniciar")) {
					if (args.length <= 1) {
						p.sendMessage("§cUtilize: /evento iniciar <número>");
						return true;
					} else {
						int n = Mine.toInt(args[1]);
						Evento evento = EventoAPI.manager.geteventoint(n);
						if (evento == null) {
							p.sendMessage("§cO evento de número " + n + " não foi econtrado no banco de dados.");
							return true;
						} else {
							if (args[0].equalsIgnoreCase("iniciar")) {
								EventoManager.iniciar(p, evento);
								return true;
							}

						}

					}
				}
				if (p.hasPermission("evento.admin")) {
					if (args[0].equalsIgnoreCase("set")) {
						if (args.length <= 1) {
							p.sendMessage("§cUtilize: /evento set <spawn/pre/jogo/morte>");
							return true;
						} else {
							if (args[1].equalsIgnoreCase("spawn")) {
								EventoManager.setSpawn(p);
							}
							if (args[1].equalsIgnoreCase("pre")) {
								EventoManager.setPre(p);
							}
							if (args[1].equalsIgnoreCase("jogo")) {
								EventoManager.setJogo(p);
							}
							if (args[1].equalsIgnoreCase("morte")) {
								EventoManager.setMorte(p);
							}
						}
					}
				}
			}
			if (p.hasPermission("evento.admin")) {
				if (args[0].equalsIgnoreCase("setwin")) {
					if (args.length <= 3) {
						p.sendMessage("§cUtilize: /evento setwin <Player> <Tag> <Clan>");
						return true;
					} else {
						Player j = Bukkit.getPlayer(args[1]);
						if (j == null) {
							p.sendMessage("§cJogador Offline");
							return true;
						}
						EventoManager.ganhar(p, args[2], args[3], j);
						return true;
					}
				}
			}
		}

		return false;
	}

}