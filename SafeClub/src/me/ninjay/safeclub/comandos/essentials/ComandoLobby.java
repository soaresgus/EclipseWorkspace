package me.ninjay.safeclub.comandos.essentials;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.safeclub.main.Main;

public class ComandoLobby implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			ByteArrayOutputStream b = new ByteArrayOutputStream();
		      DataOutputStream out = new DataOutputStream(b);
		      try {
		        out.writeUTF("Connect");
		        out.writeUTF("HUB");
		      } catch (IOException e) {
		        e.printStackTrace();
		      }
		      p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", b.toByteArray());
		}
		return false;
	}

}
