package me.ninjay.curso.cash;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.curso.main.Main;

public class Loja implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			double cash = Main.cash.getDouble(p.getName());
			if(cash >= 5) {
				p.sendMessage("§eItem comprado");
				Main.cash.set(p.getName(), cash-5);
			}else {
				p.sendMessage("§eSem cash suficiente.");
			}
		}
		return false;
	}

}
