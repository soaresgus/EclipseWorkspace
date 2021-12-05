package me.ninjay.kustlobby.comandos;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.kustlobby.main.Main;


public class ComandoConnect implements CommandExecutor{
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(args.length == 0) {
				p.sendMessage("§c/conectar <server>");
				return true;
			}
		if(args[0].equalsIgnoreCase("factions")) {
			 Bukkit.getMessenger().registerOutgoingPluginChannel(Main.getPlugin(Main.class), "BungeeCord");
			 
			 ByteArrayOutputStream b = new ByteArrayOutputStream();
			 DataOutputStream out = new DataOutputStream(b);
			 try {
			 out.writeUTF("Connect");
			 out.writeUTF("factions");
			 } catch (IOException ex) {
			  
			 }
			 p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", b.toByteArray());
		}else {
			p.sendMessage("§cServidor não encontrado.");
		}
		}
		return false;
	}

}
