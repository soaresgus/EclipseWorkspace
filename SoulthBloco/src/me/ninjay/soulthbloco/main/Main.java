package me.ninjay.soulthbloco.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.soulthbloco.bloco.EventosBlocos;
import me.ninjay.soulthbloco.bloco.EventosBreakMoney;
import net.eduard.api.lib.BukkitConfig;


public class Main extends JavaPlugin{
	public static BukkitConfig bloco;
	@Override
	public void onEnable() {
		bloco = new BukkitConfig("blocos.yml", this);
		bloco.saveConfig();
		Bukkit.getPluginManager().registerEvents(new EventosBlocos(), this);
		Bukkit.getPluginManager().registerEvents(new EventosBreakMoney(), this);
	}

}
