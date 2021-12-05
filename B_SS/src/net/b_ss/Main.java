package net.b_ss;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public static Main instance;

	@Override
	public void onEnable() {
		instance = this;
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable() {

	}
	public ArrayList<String> jogadoresSS = new ArrayList<>();
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (command.getName().equalsIgnoreCase("ss")) {
				if (!p.hasPermission("b_ss.usar")) {
					p.sendMessage("§cVocê não tem permissão para usar o ss!");
					return true;
				}
				if (args.length == 0) {
					p.sendMessage("§cUse /ss <jogador>.");
					return true;
				}
				if (args.length == 1) {
					Player alvo = Bukkit.getPlayer(args[0]);
					if (alvo == null) {
						p.sendMessage("§cEste jogador não se encontra online!");
						return true;
					}
					if(jogadoresSS.contains(p.getName())) {
						p.sendMessage("§cEste jogador já está no SS!");
						return true;
					}
					p.sendMessage("§eVocê puxou um jogador ao ss!");
					Bukkit.getOnlinePlayers().forEach(a -> {
						a.sendMessage("§a[SS] §f" + alvo.getName() + " §7foi puxado ao SS!");
					});
					alvo.teleport(p);
					jogadoresSS.add(alvo.getName());
					return true;
				}
			}
			if (command.getName().equalsIgnoreCase("ssliberar")) {
				if (!p.hasPermission("b_ssliberar.usar")) {
					p.sendMessage("§cVocê não tem permissão para usar o ssliberar!");
					return true;
				}
				if (args.length == 0) {
					p.sendMessage("§cUse /ssliberar <jogador>.");
					return true;
				}
				if (args.length == 1) {
					Player alvo = Bukkit.getPlayer(args[0]);
					if (alvo == null) {
						p.sendMessage("§cEste jogador não se encontra online!");
						return true;
					}
					if(!jogadoresSS.contains(p.getName())) {
						p.sendMessage("§cEste jogador não está no SS!");
						return true;
					}
					p.sendMessage("§eVocê liberou um jogador ao ss!");
					Bukkit.getOnlinePlayers().forEach(a -> {
						a.sendMessage("§a[SS] §f" + alvo.getName() + " §7foi liberado do SS!");
					});
					alvo.teleport(p);
					jogadoresSS.remove(alvo.getName());
					return true;
				}
			}
		}
		return true;
	}
	
	@EventHandler
	public void blockCommand(PlayerTeleportEvent e) {
		if(jogadoresSS.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void blockCommand(PlayerCommandPreprocessEvent e) {
		if(jogadoresSS.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void quit(PlayerQuitEvent e) {
		if(jogadoresSS.contains(e.getPlayer().getName())) {
			Bukkit.getOnlinePlayers().forEach(a -> {
				a.sendMessage("§a[SS] §f" + e.getPlayer().getName() + " §7deslogou do servidor enquanto estava no SS!");
			});
			jogadoresSS.remove(e.getPlayer().getName());
		}
		
	}

}
