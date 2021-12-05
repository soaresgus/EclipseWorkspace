package me.ninjay.minahack.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.minahack.main.Main;
import me.ninjay.minahack.utils.BukkitConfig;

public class ComandoSetMina implements CommandExecutor{
	
	public static BukkitConfig config = new BukkitConfig("location.yml", Main.getPlugin(Main.class));
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(!p.hasPermission("minahack.admin")) {
				p.sendMessage("§cVocê não tem permissão para utilizar esse comando.");
				return true;
			}else {
				config.set("mina", p.getLocation());
				config.saveConfig();
				p.sendMessage("§aLocal setado com sucesso!");
			}
		}
		return false;
	}

}
