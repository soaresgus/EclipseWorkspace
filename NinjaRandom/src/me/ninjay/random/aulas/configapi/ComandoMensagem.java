package me.ninjay.random.aulas.configapi;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.random.main.Main;

public class ComandoMensagem implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		p.sendMessage(Main.mensagem.getString("Site"));
		p.sendMessage("delay iniciado.");
        new BukkitRunnable() {
			
			@Override
			public void run() {
				p.sendMessage("delay finalizado");
				
			}
		}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
		return false;

	}
}
