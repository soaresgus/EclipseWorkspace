package me.ninjay.curso.tempo;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.curso.main.Main;

public class ComandoCooldown implements CommandExecutor {
	public static ArrayList<Player> jogadores = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (jogadores.contains(p)) {
				p.sendMessage("§aVocê está em cooldown.");
				return true;
			}
			jogadores.add(p);
			p.sendMessage("§aVocê entrou no cooldown.");
			new BukkitRunnable() {

				@Override
				public void run() {
					p.sendMessage("§aVocê saiu do cooldown.");
					jogadores.remove(p);

				}
			}.runTaskLater(Main.getPlugin(Main.class), 500); //500 = TICKS | 20 TICKS = 1 SEGUNDO | 500 TICKS = 25 SEGUNDOS

		}
		return false;
	}

}
