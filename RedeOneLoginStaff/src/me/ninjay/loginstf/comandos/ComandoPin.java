package me.ninjay.loginstf.comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.loginstf.main.Main;

public class ComandoPin implements CommandExecutor{
	public static ArrayList<Player> lista = new ArrayList<>();
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(p.hasPermission("login.admin")) {
				if(args.length == 0) {
					p.sendMessage("§cUtilize /pin <código>.");
					return true;
				}
				if(p.hasPermission("login.admin")) {
					if(args[0].equals(Main.pin.getString("admin"))) {
						lista.remove(p);
						p.sendMessage("§aPin confirmado, tenha um bom jogo !");
						return true;
					}else {
						p.sendMessage("§cPin errado, tente novamente.");
						Bukkit.getConsoleSender().sendMessage("§4ATENÇÃO - §cO staff "+p.getName()+" errou seu pin, melhor verificar se realmente é ele.");
					}
				}
			}
			if(p.hasPermission("login.mod")) {
				if(args[0].equals(Main.pin.getString("mod"))) {
					lista.remove(p);
					p.sendMessage("§aPin confirmado, tenha um bom jogo !");
					return true;
				}else {
					p.sendMessage("§cPin errado, tente novamente.");
					Bukkit.getConsoleSender().sendMessage("§4ATENÇÃO - §cO staff "+p.getName()+" errou seu pin, melhor verificar se realmente é ele.");
				}
			}
		}
		return false;
	}

}
