package me.ninjay.random.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.random.aulas.configapi.ComandoMensagem;
import me.ninjay.random.comandos.bolao.ComandoBolao;
import me.ninjay.random.comandos.encantar.ComandoEncantar;
import me.ninjay.random.comandos.encantar.ComandoXp;
import me.ninjay.random.comandos.luz.ComandoLuz;
import me.ninjay.random.comandos.randomplayer.ComandoRandomPlayer;
import me.ninjay.random.eventos.encantar.EventosEncantar;
import me.ninjay.random.holo.ComandoHolograma;
import me.ninjay.random.score.ComandoScore;
import me.ninjay.random.spawnar.ComandoZombie;
import net.eduard.api.lib.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig xp;
	public static BukkitConfig config;
	public static BukkitConfig mensagem;
	@Override
	public void onEnable() {
		xp = new BukkitConfig("xp.yml", this);
		xp.saveConfig();
		config = new BukkitConfig("config.yml", this);
		config.saveConfig();
		mensagem = new BukkitConfig("mensagem.yml", this);
		mensagem.saveConfig();
		getCommand("mensagem").setExecutor(new ComandoMensagem());
		getCommand("sorteio").setExecutor(new ComandoRandomPlayer());
		getCommand("bolao").setExecutor(new ComandoBolao());
		getCommand("xp").setExecutor(new ComandoXp());
		getCommand("encantar").setExecutor(new ComandoEncantar());
		Bukkit.getPluginManager().registerEvents(new EventosEncantar(), this);
		getCommand("holograma").setExecutor(new ComandoHolograma());
		getCommand("score").setExecutor(new ComandoScore());
		getCommand("zombie").setExecutor(new ComandoZombie());
		getCommand("luz").setExecutor(new ComandoLuz());
	}

}
