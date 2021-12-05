package me.ninjay.safeclublobby.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.safeclublobby.api.LoginAPI.LoginAPI;
import me.ninjay.safeclublobby.main.Main;
import me.ninjay.safeclublobby.utils.BukkitConfig;

public class ComandoRegister implements CommandExecutor{

	public static BukkitConfig config = new BukkitConfig("senhas.yml", Main.getPlugin(Main.class));
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				return true;
			}else {
			LoginAPI.registrar(p, args[0], config);
		}
		}
		return false;
	}

}
