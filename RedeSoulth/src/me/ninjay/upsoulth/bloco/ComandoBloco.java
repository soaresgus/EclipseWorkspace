package me.ninjay.upsoulth.bloco;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.upsoulth.main.Main;


public class ComandoBloco implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			p.sendMessage("�a�lYEAH! �fVoc� possui �6"+Main.bloco.getDouble(p.getName())+" �fquebrados.");
		}
		return false;
	}

}
