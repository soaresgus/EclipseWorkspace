package me.ninjay.kustlogs.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kustlogs.comandos.ComandoLocalizar;
import me.ninjay.kustlogs.eventos.EventosRegistro;
import me.ninjay.kustlogs.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig playerComando;
	public static BukkitConfig playerChat;
	public static BukkitConfig playerBau;
	public static BukkitConfig playerGeral;
	public static BukkitConfig playerCheat;
	public static BukkitConfig staffGeral;
	public static BukkitConfig staffComando;
	public static BukkitConfig staffChat;
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventosRegistro(), this);
		getCommand("localizar").setExecutor(new ComandoLocalizar());
		
		playerComando = new BukkitConfig("playerComando.yml", this);
		playerComando.saveConfig();
		playerChat = new BukkitConfig("playerChat.yml", this);
		playerChat.saveConfig();
		playerBau = new BukkitConfig("playerBau.yml", this);
		playerBau.saveConfig();
		playerGeral = new BukkitConfig("playerGeral.yml", this);
		playerGeral.saveConfig();
		staffGeral = new BukkitConfig("staffGeral.yml", this);
		staffGeral.saveConfig();
		staffComando = new BukkitConfig("staffComando.yml", this);
		staffComando.saveConfig();
		staffChat = new BukkitConfig("staffChat.yml", this);
		staffChat.saveConfig();
		playerCheat = new BukkitConfig("playerAntiCheat.yml", this);
		playerCheat.saveConfig();
	}

}
