package net.b_staffonline;

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

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(command.getName().equalsIgnoreCase("staffonline")) {
				p.sendMessage("§aStaffers online:");
				Bukkit.getOnlinePlayers().stream().filter(a -> a.hasPermission("b_staffonline.staff"))
				.forEach(a -> {
					if(a != null) {
						p.sendMessage("§7- §f" + a .getName());
					}
				});
			}
		}
		return true;
		
	}

}
