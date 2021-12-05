package me.ninjay.simplev2;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoStaffChat implements CommandExecutor {

	

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equalsIgnoreCase("staffchat")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("§6§lApenas players podem utilizar.");
			} else {
				if (!sender.hasPermission("staffchat.use")) {
					return true;
				}
				if (args.length == 0) {
					sender.sendMessage("§6§lUtilize /sc <mensagem>.");
					return true;
				}
				Player p = (Player) sender;
				for (Player todos : Bukkit.getServer().getOnlinePlayers()) {

					String msg = "";
					for (int i = 0; i < args.length; i++) {
						msg = String.valueOf(msg) + args[i];
						msg = String.valueOf(msg) + " ";
					}
					if (todos.hasPermission("staffchat.use")) {
						todos.sendMessage("§b§l" + p.getName() + ": " + msg);
								
					}
				}
			}
		}

		return false;
	}
}
