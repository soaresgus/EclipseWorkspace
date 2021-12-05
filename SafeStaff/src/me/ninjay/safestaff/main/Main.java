package me.ninjay.safestaff.main;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.safestaff.comandos.ComandoDuvida;
import me.ninjay.safestaff.comandos.ComandoHacker;
import me.ninjay.safestaff.comandos.ComandoResponder;
import me.ninjay.safestaff.comandos.ComandoS;
import me.ninjay.safestaff.comandos.ComandoTph;
import me.ninjay.safestaff.comandos.ComandoTpm;
import me.ninjay.safestaff.comandos.ComandoV;
import me.ninjay.safestaff.estruturas.Punir;
import me.ninjay.safestaff.estruturas.PunirAPI;
import me.ninjay.safestaff.estruturas.PunirControler;
import me.ninjay.safestaff.estruturas.PunirManager;
import me.ninjay.safestaff.estruturas.TimerAPI;
import me.ninjay.safestaff.utils.Mine;
import me.ninjay.utils.utils.StorageAPI;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("s").setExecutor(new ComandoS());
		getCommand("tpm").setExecutor(new ComandoTpm());
		getCommand("v").setExecutor(new ComandoV());
		getCommand("hacker").setExecutor(new ComandoHacker());
		getCommand("tph").setExecutor(new ComandoTph());
		getCommand("punir").setExecutor(new PunirControler());
		getCommand("duvida").setExecutor(new ComandoDuvida());
		getCommand("responder").setExecutor(new ComandoResponder());
		
		StorageAPI.register(Punir.class);
		StorageAPI.register(PunirManager.class);
		
		PunirAPI.reload();
		
		for(OfflinePlayer player : Bukkit.getOfflinePlayers()) {
			if(TimerAPI.getTempo(PunirControler.config, player.getName()+".tempo") > 0 || PunirControler.config.contains(player.getName()+".tempo")) {
				TimerAPI.timer(Mine.toInt(TimerAPI.getTempo(PunirControler.config, player.getName()+".tempo")), PunirControler.config, this, player.getName()+".tempo");
				if(TimerAPI.getTempoCorrendo(PunirControler.config, player.getName()+".tempo") <= 0) {
					PunirControler.config.remove(player.getName()+".status");
					PunirControler.config.remove(player.getName()+".punido");
					PunirControler.config.remove(player.getName()+".tempo");
					for(Punir punirs : PunirAPI.manager.getPunirs()) {
						PunirControler.config.remove(player.getName()+"."+punirs.getName()+".avisado");
						PunirControler.config.saveConfig();
					}
				}
			}
		}
		
		Bukkit.getPluginManager().registerEvents(new ComandoV(), this);
		Bukkit.getPluginManager().registerEvents(new PunirControler(), this);
	}

}
