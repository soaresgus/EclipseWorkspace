package net.b_voar;

import org.bukkit.Sound;
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

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(command.getName().equalsIgnoreCase("voar")) {
				if(!p.hasPermission("b_voar.usar")) {
					p.sendMessage("§cVocê não tem permissão para voar!");
					return true;
				}
				if(p.getAllowFlight()) {
					p.setAllowFlight(false);
					p.sendMessage("§cModo voar desativado com sucesso.");
					p.playSound(p.getLocation(), Sound.CAT_MEOW, 1.0F, 0.5F);
				}else {
					p.setAllowFlight(true);
					p.sendMessage("§aModo voar desativado com sucesso.");
					p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 0.5F);
				}
			}
		}
		return true;
	}

}
