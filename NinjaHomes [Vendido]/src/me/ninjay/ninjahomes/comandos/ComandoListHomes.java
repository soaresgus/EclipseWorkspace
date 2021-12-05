package me.ninjay.ninjahomes.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjahomes.main.Main;

public class ComandoListHomes implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			StringBuilder sb = new StringBuilder();
		      for (String homes : Main.listar.getConfig().getConfigurationSection(p.getName()+".homes.").getKeys(false))
		      {
		        sb.append("§f" + homes);
		        sb.append("§f, ");
		      }
		      if(Main.homeconf.getInt(p.getName()+".homes.quantidade") == 0) {
		    	  p.sendMessage("§cVocê não possui nenhuma home setada.");
		      }else {
		         p.sendMessage("§eHomes: " + sb.toString());
		      	}
		     }
		
		return false;
	}

}
