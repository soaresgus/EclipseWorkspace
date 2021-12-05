package me.ninjay.oneperfil.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.oneperfil.almas.comandos.ComandoAlmas;
import me.ninjay.oneperfil.almas.eventos.EventosAlmas;
import me.ninjay.oneperfil.comandos.ComandoPerfil;
import me.ninjay.oneperfil.comandos.EventosPerfilDnv;
import me.ninjay.oneperfil.eventos.EventosPerfil;
import me.ninjay.oneperfil.glad.comandos.ComandoGlad;
import me.ninjay.oneperfil.glad.estruturas.EstruturaTempo3;
import me.ninjay.oneperfil.glad.eventos.EventosGlad;
import me.ninjay.oneperfil.mvp.comandos.ComandoMvP;
import me.ninjay.oneperfil.mvp.estruturas.EstruturaTempo;
import me.ninjay.oneperfil.mvp.eventos.EventosMvP;
import me.ninjay.oneperfil.ranks.ComandoRanks;
import me.ninjay.oneperfil.ranks.EventosRanks;
import me.ninjay.oneperfil.rankspoo.command.RankUPCommand;
import me.ninjay.oneperfil.rankspoo.manager.RankUP;
import me.ninjay.oneperfil.rankspoo.manager.RankUPAPI;
import me.ninjay.oneperfil.rankspoo.manager.RankUPManager;
import me.ninjay.oneperfil.tabscore.eventos.EventosTabScore;
import me.ninjay.oneperfil.tabscore.eventos.SimplesScore;
import me.ninjay.oneperfil.tagsv2.Tags;
import me.ninjay.oneperfil.tagsv2.TagsAPI;
import me.ninjay.oneperfil.tagsv2.TagsCommand;
import me.ninjay.oneperfil.tagsv2.TagsControler;
import me.ninjay.oneperfil.tagsv2.TagsManager;
import me.ninjay.oneperfil.tct.comandos.ComandoTcT;
import me.ninjay.oneperfil.tct.estruturas.EstruturaTempo2;
import me.ninjay.oneperfil.tct.eventos.EventosTcT;
import net.eduard.api.lib.BukkitConfig;
import net.eduard.api.lib.storage.StorageAPI;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;

public class Main extends JavaPlugin{
	//INFO----------
	
	public static BukkitConfig blocos;
	public static BukkitConfig data;
	public static BukkitConfig kdr;
	public static BukkitConfig wins;
	public static SimpleClans clan;
	
	//INFO--------
	
	
	// ALMAS ----------
	
	public static BukkitConfig almas;
	
	//almas ---------
	
	//GLAD-----------
	
	public static BukkitConfig glad; // CONFIG GLOBAL
	public static EstruturaTempo3 tempo3; // ESTRUTURAS DE STATS
	public static ArrayList<Player> dentro3 = new ArrayList<>(); // LISTA DE QUEM ESTÁ JOGANDO
	public static ArrayList<Player> fora3 = new ArrayList<>(); // LISTA DE QUEM MORREU
	  
	
	//MVP-------------
	
	public static BukkitConfig mvp; // CONFIG GLOBAL
	public static EstruturaTempo tempo; // ESTRUTURAS DE STATS
	public static ArrayList<Player> dentro = new ArrayList<>(); // LISTA DE QUEM ESTÁ JOGANDO
	public static ArrayList<Player> fora = new ArrayList<>(); // LISTA DE QUEM MORREU
    
	
	//MVP-------------
	
	//TCT-----------
	
	public static EstruturaTempo2 tempo2; // Estrutura de tempo :3
	public static ArrayList<Player> dentro2 = new ArrayList<>(); //Detectar quem está dentro do evento
	public static ArrayList<Player> fora2 = new ArrayList<>(); //Detectar quem já morreu
	public static BukkitConfig tct; // Config principal
	
	//TCT--------------------
	
	@Override
	public void onEnable() {
		blocos =  new BukkitConfig("blocos.yml", this);
		blocos.saveConfig();
		mvp = new BukkitConfig("mvp.yml", this);
		mvp.saveConfig();
		tct = new BukkitConfig("tct.yml", this);
		tct.saveConfig();
		wins = new BukkitConfig("wins.yml", this);
        wins.saveConfig();
        data = new BukkitConfig("data.yml", this);
        data.saveConfig();
        kdr = new BukkitConfig("kdr.yml", this);
        kdr.saveConfig();
        glad = new BukkitConfig("glad.yml", this);
        glad.saveConfig();
        almas = new BukkitConfig("almas.yml", this);
		almas.saveConfig();
		getCommand("alma").setExecutor(new ComandoAlmas());
		Bukkit.getPluginManager().registerEvents(new EventosAlmas(), this);
        Bukkit.getPluginManager().registerEvents(new EventosTcT(), this);
        Bukkit.getPluginManager().registerEvents(new EventosMvP(), this);
		getCommand("perfil").setExecutor(new ComandoPerfil());
		getCommand("tct").setExecutor(new ComandoTcT());
        getCommand("mvp").setExecutor(new ComandoMvP());
        getCommand("gladiator").setExecutor(new ComandoGlad());
        getCommand("cargo").setExecutor(new TagsCommand());
        getCommand("ranks").setExecutor(new ComandoRanks());
        Bukkit.getPluginManager().registerEvents(new EventosGlad(), this);
		Bukkit.getPluginManager().registerEvents(new EventosPerfil(), this);
		Bukkit.getPluginManager().registerEvents(new EventosRanks(), this);
		StorageAPI.register(RankUP.class);
		StorageAPI.register(RankUPManager.class);
		RankUPAPI.reload();
		getCommand("rankup").setExecutor(new RankUPCommand());
		SimplesScore.ligar(this);
		StorageAPI.register(Tags.class);
		StorageAPI.register(TagsManager.class);
		TagsAPI.reload();
		Bukkit.getPluginManager().registerEvents(new TagsControler(), this);
		Bukkit.getPluginManager().registerEvents(new EventosTabScore(), this);
		Bukkit.getPluginManager().registerEvents(new EventosPerfilDnv(), this);
		new BukkitRunnable() {
			
			@Override
			public void run() {
				RankUPAPI.save();
				TagsAPI.save();
			}
		};
		
	}
	@Override
	public void onDisable() {
		RankUPAPI.save();
		TagsAPI.save();
	}

}
