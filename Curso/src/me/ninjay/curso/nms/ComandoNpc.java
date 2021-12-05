package me.ninjay.curso.nms;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoNpc implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p3 = (Player) sender;
			
			NPC npc = new NPC(p3.getLocation(), "NPC-1", "f7483371-33bf-474b-9ab4-cd13ebbe343c"
, "textures");
      npc.show(p3);
			
		}
		return false;
	}
}
