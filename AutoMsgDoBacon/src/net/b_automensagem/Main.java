package net.b_automensagem;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin {

	String[] mensagens = { "§aMENSAGEM 1", "§bMENSAGEM 2", "§cMENSAGEM 3" };

	@Override
	public void onEnable() {
		new BukkitRunnable() {
			
			@Override
			public void run() {
				Bukkit.broadcastMessage(Arrays.asList(mensagens).get(new Random().nextInt(mensagens.length)));
			}
		}.runTaskTimer(Main.getPlugin(Main.class), 0L, 20L * 30L);
	}

}
