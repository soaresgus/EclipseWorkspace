package me.ninjay.upsoulth.main;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.upsoulth.bloco.ComandoBloco;
import me.ninjay.upsoulth.bloco.EventosBlocos;
import me.ninjay.upsoulth.captcha.EventosCaptcha;
import me.ninjay.upsoulth.cash.ComandoCash;
import me.ninjay.upsoulth.cash.EventosLoja;
import me.ninjay.upsoulth.comandos.ComandoMina;
import me.ninjay.upsoulth.comandos.ComandoSetarMina;
import me.ninjay.upsoulth.comandos.Soulth;
import me.ninjay.upsoulth.eventos.EventosBreakMoney;
import me.ninjay.upsoulth.eventos.EventosClearDrops;
import me.ninjay.upsoulth.eventos.EventosMina;
import me.ninjay.upsoulth.eventos.EventosSetarMina;
import me.ninjay.upsoulth.ranks.ComandoRank;
import me.ninjay.upsoulth.ranks.ComandoRankUp;
import me.ninjay.upsoulth.ranks.EventosRankUP;
import me.ninjay.upsoulth.ranks.EventosRanks;
import me.ninjay.upsoulth.tab.EventosTab;
import net.eduard.api.lib.BukkitConfig;

public class Main extends JavaPlugin{
	public static BukkitConfig locais;
	public static BukkitConfig cash;
	public static BukkitConfig bloco;
	public static BukkitConfig senhas;
	
	@Override
	public void onEnable() {
		senhas = new BukkitConfig("senhas.yml", this);
		senhas.saveConfig();
		locais = new BukkitConfig("locais.yml", this);
		locais.saveConfig();
		cash = new BukkitConfig("cash.yml", this);
		cash.saveConfig();
		bloco = new BukkitConfig("blocos.yml", this);
		bloco.saveConfig();
		getCommand("ranks").setExecutor(new ComandoRank());
		getCommand("soulth").setExecutor(new Soulth());
		Bukkit.getPluginManager().registerEvents(new EventosRanks(), this);
		Bukkit.getPluginManager().registerEvents(new EventosTab(), this);
		getCommand("setarmina").setExecutor(new ComandoSetarMina());
		getCommand("mina").setExecutor(new ComandoMina());
		getCommand("cash").setExecutor(new ComandoCash());
		getCommand("rankup").setExecutor(new ComandoRankUp());
		Bukkit.getPluginManager().registerEvents(new EventosLoja(), this);
		Bukkit.getConsoleSender().sendMessage("§6[Rede Soulth] §bPlugin Ativado");
		Bukkit.getPluginManager().registerEvents(new EventosSetarMina(), this);
		Bukkit.getPluginManager().registerEvents(new EventosMina(), this);
		Bukkit.getPluginManager().registerEvents(new EventosClearDrops(), this);
		Bukkit.getPluginManager().registerEvents(new EventosBreakMoney(), this);
		Bukkit.getPluginManager().registerEvents(new EventosBreakMoney(), this);
		Bukkit.getPluginManager().registerEvents(new EventosCaptcha(), this);
		Bukkit.getPluginManager().registerEvents(new EventosRankUP(), this);
		Bukkit.getPluginManager().registerEvents(new EventosBlocos(), this);
		getCommand("bloco").setExecutor(new ComandoBloco());
	}
    @Override
    public void onDisable() {
    	Bukkit.getConsoleSender().sendMessage("§6[Rede Soulth] §bPlugin Desativado");
    	cash.saveConfig();
    	locais.saveConfig();
    	bloco.saveConfig();
    }
}
