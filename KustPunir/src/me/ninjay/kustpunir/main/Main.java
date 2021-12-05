package me.ninjay.kustpunir.main;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.kustpunir.comandos.ComandoCheckPunir;
import me.ninjay.kustpunir.comandos.ComandoRevogar;
import me.ninjay.kustpunir.estruturas.Punir;
import me.ninjay.kustpunir.estruturas.PunirAPI;
import me.ninjay.kustpunir.estruturas.PunirControler;
import me.ninjay.kustpunir.estruturas.PunirManager;
import me.ninjay.kustpunir.estruturas.TimerAPI;
import me.ninjay.kustpunir.utils.Mine;
import me.ninjay.utils.utils.StorageAPI;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("punir").setExecutor(new PunirControler());
		getCommand("checkpunir").setExecutor(new ComandoCheckPunir());
		getCommand("revogar").setExecutor(new ComandoRevogar());
		StorageAPI.register(Punir.class);
		StorageAPI.register(PunirManager.class);
		
		PunirAPI.reload();
		
		for(OfflinePlayer player : Bukkit.getOfflinePlayers()) {
			if(PunirControler.config.contains(player.getName()+".tempo") && TimerAPI.getTempo(PunirControler.config, player.getName()+".tempo") > 0 ) {
				TimerAPI.timer(Mine.toInt(TimerAPI.getTempo(PunirControler.config, player.getName()+".tempo")), PunirControler.config, this, player.getName()+".tempo", player);
			}
				if(PunirControler.config.contains(player.getName()+".tempo") && TimerAPI.getTempoCorrendo(PunirControler.config, player.getName()+".tempo") <= 0 || PunirControler.config.getInt(player.getName()+".tempo") <= -1) {
					PunirControler.config.remove(player.getName()+".status");
					PunirControler.config.remove(player.getName()+".punido");
					PunirControler.config.remove(player.getName()+".tempo");
					for(Punir punirs : PunirAPI.manager.getPunirs()) {
						PunirControler.config.remove(player.getName()+"."+punirs.getName()+".avisado");
						PunirControler.config.saveConfig();
					}
				}
				
				if(!PunirControler.config.contains(player.getName()+".tempo")) {
					PunirControler.config.remove(player.getName()+".ativo");
					PunirControler.config.saveConfig();
				}
		}
		
		Bukkit.getPluginManager().registerEvents(new PunirControler(), this);
		
		new BukkitRunnable() {
			int i = 60;
			@Override
			public void run() {
				i--;
				if(i <= 0) {
					i = 60;
				for(OfflinePlayer player : Bukkit.getOfflinePlayers()) {
					if(PunirControler.config.contains(player.getName()+".tempo") && TimerAPI.getTempoCorrendo(PunirControler.config, player.getName()+".tempo") <= 0) {
						PunirControler.config.remove(player.getName()+".status");
						PunirControler.config.remove(player.getName()+".punido");
						PunirControler.config.remove(player.getName()+".tempo");
						for(Punir punirs : PunirAPI.manager.getPunirs()) {
							PunirControler.config.remove(player.getName()+"."+punirs.getName()+".avisado");
							PunirControler.config.saveConfig();
						}
						}
					if(!PunirControler.config.contains(player.getName()+".tempo")) {
						PunirControler.config.remove(player.getName()+".ativo");
						PunirControler.config.saveConfig();
					}
					}
				}
			}
		}.runTaskTimer(this, 20, 20);
		
	}

}
