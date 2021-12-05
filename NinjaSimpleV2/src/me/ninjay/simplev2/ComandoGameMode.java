package me.ninjay.simplev2;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoGameMode implements CommandExecutor{
	
	public final Main instance = Main.getmain();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 if(command.getName().equalsIgnoreCase("gamemode")) {
			 if(!(sender instanceof Player)) {
				 sender.sendMessage("§6§lApenas players podem utilizar.");
			 }else {
				 Player p = (Player)sender;
				 if(!p.hasPermission("gm.use")) {
					 return true;
				 }
				 if(args.length == 0) {
					 p.sendMessage("§6§lUtilize /gm <0 1 3>.");
					 return true;
				 }
				 if(p.hasPermission("gm.use") && (args[0].equalsIgnoreCase("1"))) {
					 p.sendMessage("§aModo de jogo alterado para CRIATIVO");
					 p.setGameMode(GameMode.CREATIVE);
					 return true;
				 }
				 if(p.hasPermission("gm.use") && (args[0].equalsIgnoreCase("0"))) {
					 p.sendMessage("§aModo de jogo alterado para SOBREVIVÊNCIA");
					 p.setGameMode(GameMode.SURVIVAL);
					 return true;
				 }
				 if(p.hasPermission("gm.use") && (args[0].equalsIgnoreCase("3"))) {
					 p.sendMessage("§aModo de jogo alterado para ESPECTADOR");
					 p.setGameMode(GameMode.SPECTATOR);
					 return true;
				 }
			 }
		 }
		return false;
	}

}
