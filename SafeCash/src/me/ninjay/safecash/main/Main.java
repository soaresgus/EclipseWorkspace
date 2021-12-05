package me.ninjay.safecash.main;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.safecash.comandos.ComandoCash;
import me.ninjay.safecash.comandos.ComandoShop;
import me.ninjay.safecash.comandos.ComandoTempoVip;
import me.ninjay.safecash.estruturas.TimerAPI;
import me.ninjay.safecash.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig cash;
	public static BukkitConfig shop;
	public static BukkitConfig tempo;
	
	@Override
	public void onEnable() {
		getCommand("cash").setExecutor(new ComandoCash());
		getCommand("shop").setExecutor(new ComandoShop());
		getCommand("tempovip").setExecutor(new ComandoTempoVip());
		
		Bukkit.getPluginManager().registerEvents(new ComandoShop(), this);
		
		cash = new BukkitConfig("cash.yml", this);
		cash.saveConfig();
		
		shop = new BukkitConfig("shop.yml", this);
		shop.saveDefaultConfig();
		
		tempo = new BukkitConfig("tempovip.yml", this);
		tempo.saveConfig();
		
		for(OfflinePlayer player : Bukkit.getOfflinePlayers()) {
			if(TimerAPI.getTempo(tempo, player.getName()+".vip") > 0 || tempo.contains(player.getName()+".vip")) {
				TimerAPI.timer(TimerAPI.getTempoCorrendo(tempo, player.getName()+".vip"), tempo, this, player.getName()+".vip");
			}
			if(TimerAPI.getTempo(tempo, player.getName()+".mvp") > 0 || tempo.contains(player.getName()+".mvp")) {
				TimerAPI.timer(TimerAPI.getTempoCorrendo(tempo, player.getName()+".mvp"), tempo, this, player.getName()+".mvp");
			}
		}
		
	}
}
