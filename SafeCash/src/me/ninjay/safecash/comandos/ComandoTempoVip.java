package me.ninjay.safecash.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.safecash.main.Main;

public class ComandoTempoVip implements CommandExecutor{
	
	public static String formatarTempoDHMS(int tempo) {
		 return String.format("%02d dias %02d horas %02d minutos %02d segundos", tempo / 86400, (tempo % 86400) / 3600, (tempo % 3600) / 60, tempo % 60);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			
			p.sendMessage("§6Tempo dos produtos: \n \n§b[VIP]§7: "+formatarTempoDHMS(Main.tempo.getInt(p.getName()+".vip"))+"\n§a[MVP]§7: "+formatarTempoDHMS(Main.tempo.getInt(p.getName()+".mvp"))+"\n ");
		}
		return false;
	}

}
