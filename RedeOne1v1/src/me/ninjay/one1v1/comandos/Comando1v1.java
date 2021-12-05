package me.ninjay.one1v1.comandos;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Comando1v1 implements CommandExecutor {
	public static ArrayList<Player> jogando = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;

		}
		return false;
	}

}
