package me.ninjay.ninjarankup.main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.ninjarankup.comandos.ComandoRank;
import me.ninjay.ninjarankup.comandos.ComandoRankAdmin;
import me.ninjay.ninjarankup.estruturas.rank.Rank;
import me.ninjay.ninjarankup.estruturas.rank.RankAPI;
import me.ninjay.ninjarankup.estruturas.rank.RankControler;
import me.ninjay.ninjarankup.estruturas.rank.RankManager;
import me.ninjay.ninjarankup.estruturas.ranklist.RankList;
import me.ninjay.ninjarankup.estruturas.ranklist.RankListAPI;
import me.ninjay.ninjarankup.estruturas.ranklist.RankListControler;
import me.ninjay.ninjarankup.estruturas.ranklist.RankListManager;
import me.ninjay.ninjarankup.utils.BukkitConfig;
import me.ninjay.ninjarankup.utils.BukkitStorables;
import me.ninjay.ninjarankup.utils.StorageAPI;


public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	public static BukkitConfig playerRank;
	
	@Override
	public void onEnable() {
		BukkitStorables.load();
		
		getCommand("rank").setExecutor(new ComandoRank());
		
		getCommand("rankadmin").setExecutor(new ComandoRankAdmin());
		
		getCommand("ranks").setExecutor(new RankListControler());
		Bukkit.getPluginManager().registerEvents(new RankListControler(), this);
		
		getCommand("rankup").setExecutor(new RankControler());
		Bukkit.getPluginManager().registerEvents(new RankControler(), this);
		
		config = new BukkitConfig("config.yml", this);
		config.saveDefaultConfig();
		
		playerRank = new BukkitConfig("playerRank.yml", this);
		playerRank.saveConfig();
		
		StorageAPI.register(RankListManager.class);
		StorageAPI.register(RankList.class);
		StorageAPI.register(RankManager.class);
		StorageAPI.register(Rank.class);
		
		RankAPI.reload();
		RankListAPI.reload();
		
		Bukkit.getConsoleSender().sendMessage("§a\n \n $$\\   $$\\ $$$$$$\\ $$\\   $$\\    $$$$$\\  $$$$$$\\ \n $$$\\  $$ |\\_$$  _|$$$\\  $$ |   \\__$$ |$$  __$$\\ \n $$$$\\ $$ |  $$ |  $$$$\\ $$ |      $$ |$$ /  $$ |\r\n" + 
				" $$ $$\\$$ |  $$ |  $$ $$\\$$ |      $$ |$$$$$$$$ | \n $$ \\$$$$ |  $$ |  $$ \\$$$$ |$$\\   $$ |$$  __$$ | \n $$ |\\$$$ |  $$ |  $$ |\\$$$ |$$ |  $$ |$$ |  $$ | \n $$ | \\$$ |$$$$$$\\ $$ | \\$$ |\\$$$$$$  |$$ |  $$ | \n \\__|  \\__|\\______|\\__|  \\__| \\______/ \\__|  \\__| \n \n §b$$$$$$$\\   $$$$$$\\  $$\\   $$\\ $$\\   $$\\ $$\\   $$\\ $$$$$$$\\ \n $$  __$$\\ $$  __$$\\ $$$\\  $$ |$$ | $$  |$$ |  $$ |$$  __$$\\ \n $$ |  $$ |$$ /  $$ |$$$$\\ $$ |$$ |$$  / $$ |  $$ |$$ |  $$ | \n $$$$$$$  |$$$$$$$$ |$$ $$\\$$ |$$$$$  /  $$ |  $$ |$$$$$$$  | \n $$  __$$< $$  __$$ |$$ \\$$$$ |$$  $$<   $$ |  $$ |$$  ____/ \n $$ |  $$ |$$ |  $$ |$$ |\\$$$ |$$ |\\$$\\  $$ |  $$ |$$ | \n $$ |  $$ |$$ |  $$ |$$ | \\$$ |$$ | \\$$\\ \\$$$$$$  |$$ | \n \\__|  \\__|\\__|  \\__|\\__|  \\__|\\__|  \\__| \\______/ \\__| \n ");
		
	}
}
