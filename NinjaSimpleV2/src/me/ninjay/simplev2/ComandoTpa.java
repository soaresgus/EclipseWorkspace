package me.ninjay.simplev2;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoTpa implements CommandExecutor{
	
	public final Main instance = Main.getmain();
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("tpa")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("§6§lApenas players podem utilizar.");
			}else {
			    Player p = (Player)sender;
			    if(!p.hasPermission("tpa.use")) {
			    	return true;
			    }
			    if(args.length == 0) {
			    	p.sendMessage("§6§lUtilize /tpa <nick>");
			    	return true;
			    }
			    if(args.length == 1) {
			    	p.sendMessage("§6§lUtilize /tpa <nick> <enviar;aceitar;cancelar;negar>");
			    }
			    
			    
			    Player p2 = Bukkit.getPlayer(args[0]);
			    if(p2 == null) {
			    	p.sendMessage("§cJogador offline.");
			    	return true;
			    }
			    if(p.hasPermission("tpa.use") && (args[1].equalsIgnoreCase("enviar"))) {
			    	p.sendMessage("§ePedido enviado para §e§l" + p2.getName() + " §eUtilize §e§l/tpa " + p2.getName() + " cancelar §epara cancelar o pedido.");
			    	p2.sendMessage(" \n§e" + p.getName() + " enviou um pedido de teletransporte.\n \nUtilize §a/tpa " + p.getName() + " aceitar §epara aceitar ou §c/tpa " + p.getName() + " deny §epara negar.\n ");
			    	
			    	return true;
			    }
			    if(args[1].equalsIgnoreCase("cancelar") && (p.hasPermission("tpa.use"))) {
			    	p.sendMessage("§ePedido para " + p2.getName() + " §ecancelado");
			    	
			    }
			}
		}
		return false;
	}

}
