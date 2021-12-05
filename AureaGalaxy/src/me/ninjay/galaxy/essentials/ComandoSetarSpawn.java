package me.ninjay.galaxy.essentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.galaxy.main.Main;

public class ComandoSetarSpawn implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("admin.galaxy")) {
				p.sendMessage("§6§l[AUREA] §eSpawn setado com sucesso !");
				Main.locais.set("spawn", p.getLocation());
				Main.locais.saveConfig();
				return true;
			}
		}
		return false;
	}

}
