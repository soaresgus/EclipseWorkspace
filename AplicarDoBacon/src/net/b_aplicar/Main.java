package net.b_aplicar;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Main instance;

	@Override
	public void onEnable() {
		instance = this;

	}

	public String getMensagem(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < args.length; i++) {
			sb.append(args[i] + " ");
		}
		return sb.toString();
	}
	public ArrayList<String> jogadores = new ArrayList<>();
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (command.getName().equalsIgnoreCase("aplicar")) {
				if (args.length == 0) {
					p.sendMessage("§cUse /aplicar <sua descrição> para tentar se aplicar a staff.");
					return true;
				}
				if (args.length >= 1) {
					if(jogadores.contains(p.getName())) {
						p.sendMessage("§cVocê já se aplicou a staff! Aguarda que um membro da staff veja sua aplicação.");
						return true;
					}
					String mensagem = getMensagem(args);
					Bukkit.getOnlinePlayers().stream().filter(a -> a.hasPermission("aplicar.ver")).forEach(a -> {
						a.sendMessage(" ");
						a.sendMessage("§aAplicação de §f" + p.getName() + "§a:");
						a.sendMessage("§f" + mensagem);
						a.sendMessage(" ");
					});
					jogadores.add(p.getName());
					return true;
				}
			}
		}
		return true;
	}

}
