package me.ninjay.soulthranks.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.soulthranks.bloco.EventosBlocos;
import me.ninjay.soulthranks.bloco.EventosBreakMoney;
import me.ninjay.soulthranks.ranks.ComandoRank;
import me.ninjay.soulthranks.ranks.ComandoRankUp;
import me.ninjay.soulthranks.ranks.EventosRankUP;
import me.ninjay.soulthranks.ranks.EventosRanks;
import net.eduard.api.lib.BukkitConfig;


public class Main extends JavaPlugin{
	public static BukkitConfig bloco;
	@Override
	public void onEnable() {
		bloco = new BukkitConfig("blocos.yml", this);
		bloco.saveConfig();
		Bukkit.getPluginManager().registerEvents(new EventosBlocos(), this);
		Bukkit.getPluginManager().registerEvents(new EventosBreakMoney(), this);
		Bukkit.getPluginManager().registerEvents(new EventosRanks(), this);
		Bukkit.getPluginManager().registerEvents(new EventosRankUP(), this);
		getCommand("ranks").setExecutor(new ComandoRank());
		getCommand("rankup").setExecutor(new ComandoRankUp());
	}

}
