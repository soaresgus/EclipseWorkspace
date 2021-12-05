package me.ninjay.imortal.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.imortal.comandos.ComandoDarItens;
import me.ninjay.imortal.comandos.ComandoImortal;
import me.ninjay.imortal.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("imortal").setExecutor(new ComandoImortal());
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				for(Player todos : Bukkit.getOnlinePlayers()) {
					//todos.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 255, false, false), false);
				}
			}
		}.runTaskTimer(this, 0L, 5L);
	}
	
}
