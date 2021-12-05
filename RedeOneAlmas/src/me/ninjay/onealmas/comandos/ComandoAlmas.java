package me.ninjay.onealmas.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.onealmas.estruturas.EstruturaAdmin;
import me.ninjay.onealmas.estruturas.EstruturaJogador;
import me.ninjay.onealmas.main.Main;

public class ComandoAlmas implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				EstruturaJogador.almasGet(p, Main.almas);
				return true;
			}
			String sub = args[0];
			if (sub.equalsIgnoreCase("ajuda")) {
				if (!p.hasPermission("almas.admin")) {
					EstruturaJogador.almasHelp(p);
					return true;
				}
			}
			if (sub.equalsIgnoreCase("ajuda")) {
				if (p.hasPermission("almas.admin")) {
					EstruturaAdmin.almasHelp(p);
					return true;
				}
			}
			if (sub.equalsIgnoreCase("saldo")) {
				if (args.length == 1) {
					p.sendMessage("§cUtilize /almas saldo <nick>.");
					return true;
				} else {
					Player j = Bukkit.getPlayer(args[1]);
					if (j == null) {
						p.sendMessage("§cJogador offline.");
						return true;
					}
					EstruturaJogador.almasOtherPlayer(j, Main.almas);
				}
			}
			if (sub.equalsIgnoreCase("mercado")) {
				if(!Main.almas.contains("almas_spawn")) {
					p.sendMessage("§cO mercado não foi setado ainda.");
					return true;
				}
				p.teleport(Main.almas.getLocation("almas_spawn"));
				p.sendMessage("§6Você foi teleportado para o NPC do mercado de almas.");
				return true;
			}
			if (sub.equalsIgnoreCase("set")) {
				if (p.hasPermission("almas.admin")) {
					if (args.length <= 2) {
						p.sendMessage("§cUtilize /almas set <nick> <quantidade>.");
						return true;
					} else {
						Player j = Bukkit.getPlayer(args[1]);
						if (j == null) {
							p.sendMessage("§cJogador offline.");
							return true;
						}
						String quantia = args[2];
						Long quantidade = Mine.toLong(quantia);
						EstruturaAdmin.almasAdmSet(p, j, quantidade, Main.almas);
						return true;
					}
				}

			}
			if (sub.equalsIgnoreCase("add")) {
				if (p.hasPermission("almas.admin")) {
					if (args.length <= 2) {
						p.sendMessage("§cUtilize /almas add <nick> <quantidade>.");
						return true;
					} else {
						Player j = Bukkit.getPlayer(args[1]);
						if (j == null) {
							p.sendMessage("§cJogador offline.");
							return true;
						}
						String quantia = args[2];
						Long quantidade = Mine.toLong(quantia);
						EstruturaAdmin.almasAdmAdd(p, j, quantidade, Main.almas);
						return true;
					}
				}

			}
			if (sub.equalsIgnoreCase("remove")) {
				if (p.hasPermission("almas.admin")) {
					if (args.length <= 2) {
						p.sendMessage("§cUtilize /almas remove <nick> <quantidade>.");
						return true;
					} else {
						Player j = Bukkit.getPlayer(args[1]);
						if (j == null) {
							p.sendMessage("§cJogador offline.");
							return true;
						}
						String quantia = args[2];
						Long quantidade = Mine.toLong(quantia);
						EstruturaAdmin.almasAdmRemove(p, j, quantidade, Main.almas);
						return true;
					}
				}

			}
			if (sub.equalsIgnoreCase("setmercado")) {
				if (p.hasPermission("almas.admin")) {
					EstruturaAdmin.setMercadoNPC(p);
				}
			}
			if(sub.equalsIgnoreCase("setmercadospawn")) {
				if(p.hasPermission("almas.admin")) {
					EstruturaAdmin.setMercadoSpawn(p, Main.almas);
				}
			}
			if(sub.equalsIgnoreCase("matarnpc")) {
				if(p.hasPermission("almas.admin")) {
					EstruturaAdmin.matarNPC(p);
				}
			}

		}
		return false;
	}

}
