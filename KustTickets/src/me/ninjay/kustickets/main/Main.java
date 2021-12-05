package me.ninjay.kustickets.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kustickets.comandos.ComandoCancelar;
import me.ninjay.kustickets.comandos.ComandoTickets;
import me.ninjay.kustickets.eventos.EventosGeral;
import me.ninjay.kustickets.utils.BukkitConfig;
import me.ninjay.kustickets.utils.DBManager;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin{
	
	public Connection connection;
	public String host, database, username, password, table;
	public int port;
	
	public static BukkitConfig config;
	
	public static DBManager sql = new DBManager("u665_dHV809n6Uq", "rvW5Xz8ekQJs+rRboZl=O@pt", "147.135.71.190", "s665_factions");
	
	@Override
	public void onEnable() {
		getCommand("ticket").setExecutor(new ComandoTickets());
		getCommand("cancelar").setExecutor(new ComandoCancelar());
		
		Bukkit.getPluginManager().registerEvents(new ComandoTickets(), this);
		
		config = new BukkitConfig("config.yml", this);
		config.saveDefault();
		
		mySqlSetup();
	}
	
	public void mySqlSetup() {
		//host = "localhost";
		//port = 3306;
		//database = "teste";
		//username = "root";
		//password = "null";
		try {
			
			synchronized (this) {
				if(getConnection() != null && !getConnection().isClosed()) {
					return;
				}
				
				Class.forName("com.mysql.jdbc.Driver");
				//setConnection(DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.username, this.password));
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
