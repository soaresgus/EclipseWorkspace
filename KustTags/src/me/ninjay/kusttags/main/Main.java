package me.ninjay.kusttags.main;

import java.sql.Connection;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kusttags.comandos.ComandoCargos;
import me.ninjay.kusttags.estruturas.Tags;
import me.ninjay.kusttags.estruturas.TagsAPI;
import me.ninjay.kusttags.estruturas.TagsControler;
import me.ninjay.kusttags.estruturas.TagsManager;
import me.ninjay.kusttags.utils.DBManager;
import me.ninjay.utils.utils.StorageAPI;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin{
	
	public Connection connection;
	public static DBManager sql = new DBManager("u665_dHV809n6Uq", "rvW5Xz8ekQJs+rRboZl=O@pt", "147.135.71.190", "s665_factions");
	
	@Override
	public void onEnable() {
		mySqlSetup();
		getCommand("cargo").setExecutor(new ComandoCargos());
		Bukkit.getPluginManager().registerEvents(new TagsControler(), this);
		StorageAPI.register(Tags.class);
		StorageAPI.register(TagsManager.class);
		TagsAPI.reload();
	}

	public void mySqlSetup() {
		try {
			
			synchronized (this) {
				if(getConnection() != null && !getConnection().isClosed()) {
					return;
				}
				
				Class.forName("com.mysql.jdbc.Driver");
				sql.connect();
				sql.connectBase();
				sql.openConnection();
				
				Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "MySQL Conectado com sucesso");
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
