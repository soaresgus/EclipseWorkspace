package me.ninjay.comerciante.estruturas;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.comerciante.main.Main;
import me.ninjay.utils.utils.BukkitConfig;

public class TimerAPI {
	
	public static long getTempo(BukkitConfig config, String nome) {
		return config.getLong(nome);
	}
	
	public static void timer(int tempo, BukkitConfig config, JavaPlugin main, String nome) {
	if(config.getInt(nome) == 0) {
		new BukkitRunnable() {
			long i = tempo;
			@Override
			public void run() {
				i--;
				config.set(nome, i);
				config.saveConfig();
				if(config.getInt(nome) <= 0) {
					i = tempo;
					config.set(nome, tempo);
					config.saveConfig();
						Bukkit.broadcastMessage("\n §aO limite de compras do comerciante foi §a§lRESETADO\n ");
						for(OfflinePlayer offp : Bukkit.getOfflinePlayers()) {
							ItensAPI.info.set(offp.getName()+".limite", ItensAPI.configp.getInt("LimitePorJogador"));
						}
						for(Player onp : Bukkit.getOnlinePlayers()) {
							ItensAPI.info.set(onp.getName()+".limite", ItensAPI.configp.getInt("LimitePorJogador"));
						}
						ItensAPI.info.saveConfig();
				}
			}
		}.runTaskTimer(JavaPlugin.getPlugin(main.getClass()), 20, 20);
	}else{
		
		new BukkitRunnable() {
			@Override
			public void run() {
				new BukkitRunnable() {
					long i = config.getInt(nome);
					@Override
					public void run() {
						i--;
						config.set(nome, i);
						config.saveConfig();
						if(config.getInt(nome) <= 0) {
							i = tempo;
							config.set(nome, tempo);
							config.saveConfig();
							Bukkit.broadcastMessage("\n §aO limite de compras do comerciante foi §a§lRESETADO\n ");
							for(OfflinePlayer offp : Bukkit.getOfflinePlayers()) {
								ItensAPI.info.set(offp.getName()+".limite", ItensAPI.configp.getInt("LimitePorJogador"));
							}
							for(Player onp : Bukkit.getOnlinePlayers()) {
								ItensAPI.info.set(onp.getName()+".limite", ItensAPI.configp.getInt("LimitePorJogador"));
							}
							ItensAPI.info.saveConfig();
					}
					}
				}.runTaskTimer(JavaPlugin.getPlugin(main.getClass()), 20, 20);
			}
		}.runTaskLater(JavaPlugin.getPlugin(Main.class), 5);
	}
}

	public static int getTempoCorrendo(BukkitConfig config, String nome) {
		return config.getInt(nome);
	}
	
	public static String formatarTempoHMS(int tempo) {
		 return String.format("%02d:%02d:%02d", tempo / 3600, (tempo % 3600) / 60, tempo % 60);
	}
	
}
