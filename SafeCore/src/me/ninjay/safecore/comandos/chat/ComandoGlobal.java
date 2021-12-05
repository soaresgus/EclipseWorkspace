package me.ninjay.safecore.comandos.chat;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


import me.ninjay.safecore.comandos.lag.ComandoLag;
import me.ninjay.safecore.estruturas.tags.TagsControler;
import me.ninjay.safecore.main.Main;
import net.md_5.bungee.api.ChatColor;

public class ComandoGlobal implements CommandExecutor {

	public static HashMap<Player, String> rep = new HashMap<>();
	public static ArrayList<Player> timer = new ArrayList<>();
	private static int a = 5;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			String msg = " ";
			for (int i = 0; i < args.length; i++) {
				msg = String.valueOf(msg) + args[i];
				msg = String.valueOf(msg) + " ";
				msg = ChatColor.translateAlternateColorCodes('&', msg);
			}
			if (args.length == 0) {
				p.sendMessage("§cUtilize: /g <mensagem>.");
				return true;
			}
			if (ComandoLag.reiniciando == false) {
				if (ComandoToggleGlobal.global == true) {
						if (!rep.get(p).contains(msg)) {
							if (!timer.contains(p)) {
								Bukkit.broadcastMessage("§7[g] "+TagsControler.getTag(p)+p.getName() + ":§7" + msg);
								rep.put(p, msg);
								timer.add(p);
								a = 5;
								new BukkitRunnable() {
									@Override
									public void run() {
										a--;
										if (a == 0) {
											cancel();
											timer.remove(p);
										}
									}
								}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
							} else {
								p.sendMessage("§cAguarde " + a + " segundos para usar o global novamente.");
							}
						} else {
							p.sendMessage("§cVocê não pode enviar a mesma mensagem.");
						}
				} else {
					p.sendMessage("§cO chat global está temporariamente desativado.");
					return true;
				}
			} else {
				p.sendMessage("§cO chat global está desativado durante o reinício.");
			}
		}
		return false;
	}

}
