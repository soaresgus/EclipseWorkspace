package me.ninjay.onemvp.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.onemvp.comandos.ComandoMvP;
import me.ninjay.onemvp.estruturas.EstruturaTempo;
import me.ninjay.onemvp.eventos.EventosMvP;
import net.eduard.api.lib.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig mvp; // CONFIG GLOBAL
	public static EstruturaTempo tempo; // ESTRUTURAS DE STATS
	public static ArrayList<Player> dentro = new ArrayList<>(); // LISTA DE QUEM ESTÁ JOGANDO
	public static ArrayList<Player> fora = new ArrayList<>(); // LISTA DE QUEM MORREU
	
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§b[MvP] §eEvento MvP ativado !");
		mvp = new BukkitConfig("mvp.yml", this);
		mvp.saveConfig();
		getCommand("mvp").setExecutor(new ComandoMvP());
		Bukkit.getPluginManager().registerEvents(new EventosMvP(), this);
	}

}
