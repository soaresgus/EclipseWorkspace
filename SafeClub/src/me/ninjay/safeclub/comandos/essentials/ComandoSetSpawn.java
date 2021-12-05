package me.ninjay.safeclub.comandos.essentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.safeclub.main.Main;
import me.ninjay.safeclub.utils.BukkitConfig;

public class ComandoSetSpawn implements CommandExecutor {

	public static BukkitConfig locais = new BukkitConfig("locais.yml", Main.getPlugin(Main.class));
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("spawn.admin")) {
				p.sendMessage("§eSetado");
				locais.set("spawn", p.getLocation());
				locais.saveConfig();
				
			}
    
		}
		return false;
	}

}
