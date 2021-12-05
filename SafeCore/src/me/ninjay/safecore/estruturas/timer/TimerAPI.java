package me.ninjay.safecore.estruturas.timer;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.safecore.utils.BukkitConfig;

public class TimerAPI {

	public static long getTempo(BukkitConfig config, String nome) {
		return config.getLong(nome);
	}

	public static void timer(Long tempo, BukkitConfig config, JavaPlugin main, String nome) {
		if (!config.contains(nome)) {
			new BukkitRunnable() {
				long i = tempo;

				@Override
				public void run() {
					i++;
					config.set(nome, i);
					config.saveConfig();
				}
			}.runTaskTimer(JavaPlugin.getPlugin(main.getClass()), 20, 20);
		} else {
			new BukkitRunnable() {
				long i = config.getLong(nome);

				@Override
				public void run() {
					i++;
					config.set(nome, i);
					config.saveConfig();
				}
			}.runTaskTimer(JavaPlugin.getPlugin(main.getClass()), 20, 20);
		}
	}

	public static void setTempo(BukkitConfig config, String nome, Long tempo) {
		config.set(nome, tempo);
		config.saveConfig();
	}

	public static Long getTempoCorrendo(BukkitConfig config, String nome) {
		return config.getLong(nome);
	}

}
