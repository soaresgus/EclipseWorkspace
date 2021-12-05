package net.b_loginstaff;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public static Main instance;

	@Override
	public void onEnable() {
		instance = this;
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}

	public ArrayList<String> ls = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (command.getName().equalsIgnoreCase("loginstaff")) {
				if (!p.hasPermission("b_loginstaff.usar")) {
					p.sendMessage("§cVocê não tem permissão para se logar como 1 staffer!");
					return true;
				}
				if (!ls.contains(p.getName())) {
					p.sendMessage("§cVocê já se autenticou como staff.");
					return true;
				}
				if (args.length == 0) {
					p.sendMessage("§cUse /loginstaff <senha>.");
					return true;
				}
				if (args.length == 1) {
					String senha = args[0];
					if (!senha.equalsIgnoreCase("290823982938")) {
						p.sendMessage("§cSenha incorreta.");
						return true;
					}
					p.sendMessage("§aVocê se logou como staff com sucesso.");
					ls.remove(p.getName());
					return true;
				}
			}
		}
		return true;
	}

	@EventHandler
	public void comando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("b_loginstaff.usar")) {
			if (ls.contains(p.getName())) {
				if (e.getMessage().toLowerCase().startsWith("/login")
						|| e.getMessage().toLowerCase().startsWith("/register")) {
					e.setCancelled(false);
					return;
				}
				e.setCancelled(true);
				p.sendMessage("§cVocê deve se autenticar como staffer para digitar comandos.");
			}
		}
	}

	@EventHandler
	public void interacao(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("b_loginstaff.usar")) {
			if (ls.contains(p.getName())) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void join(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("b_loginstaff.usar")) {
			ls.add(p.getName());
		}
	}

	@EventHandler
	public void sair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (ls.contains(p.getName())) {
			ls.remove(p.getName());
		}
	}

}
