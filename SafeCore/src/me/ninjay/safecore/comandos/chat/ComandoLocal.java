package me.ninjay.safecore.comandos.chat;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;


import me.ninjay.safecore.comandos.lag.ComandoLag;
import me.ninjay.safecore.estruturas.tags.TagsControler;
import me.ninjay.safecore.main.Main;
import me.ninjay.safecore.utils.Mine;
import net.md_5.bungee.api.ChatColor;

public class ComandoLocal implements CommandExecutor, Listener {

	public static HashMap<Player, String> rep = new HashMap<>();
	public static ArrayList<Player> timer = new ArrayList<>();
	public static ArrayList<Player> localoff = new ArrayList<>();
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
				p.sendMessage("§cUtilize: /l <mensagem>.");
				return true;
			}
			if (ComandoLag.reiniciando == false) {
				if (!ComandoLag.list.contains(p)) {
					if (!localoff.contains(p)) {
							if (!rep.get(p).contains(msg)) {
								if (!timer.contains(p)) {
									for (LivingEntity perto : Mine.getNearbyEntities(p, 20, 20, 20,
											EntityType.PLAYER)) {
										perto.sendMessage("§e[l] " + TagsControler.getTag(p) + p.getName() + ":§e" + msg);
									}
									p.sendMessage("§e[l] " + TagsControler.getTag(p) + p.getName() + ":§e" + msg);
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
									p.sendMessage("§cAguarde " + a + " segundos para usar o local novamente.");
								}
							} else {
								p.sendMessage("§cVocê não pode enviar a mesma mensagem.");
							}
					} else {
						return true;
					}
				}
			} else {
				p.sendMessage("§cO chat local está desativado durante o reinício.");
			}
		}
		return false;
	}

	@EventHandler
	public void aoFalar(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		e.setCancelled(true);
		String msg = " ";
		for (int i = 0; i < e.getMessage().length(); i++) {
			msg = String.valueOf(msg) + e.getMessage().toCharArray()[i];
			msg = String.valueOf(msg);
			msg = ChatColor.translateAlternateColorCodes('&', msg);
		}
		if (ComandoLag.reiniciando == false) {
			if (!ComandoLag.list.contains(p)) {
				if (!localoff.contains(p)) {
						if (!rep.get(p).contains(msg)) {
							if (!timer.contains(p)) {
								for (LivingEntity perto : Mine.getNearbyEntities(p, 20, 20, 20,
										EntityType.PLAYER)) {
									perto.sendMessage("§e[l] " + TagsControler.getTag(p) + p.getName() + ":§e" + msg);
								}
								p.sendMessage("§e[l] " + TagsControler.getTag(p) + p.getName() + ":§e" + msg);
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
								p.sendMessage("§cAguarde " + a + " segundos para usar o local novamente.");
							}
						} else {
							p.sendMessage("§cVocê não pode enviar a mesma mensagem.");
						}
				} else {
					return;
				}
			}
		} else {
			p.sendMessage("§cO chat local está desativado durante o reinício.");
		}
		
	}

}
