package me.ninjay.aureapi;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	public Manager Manager;

	@Override

	public void onEnable() {
		Manager = new Manager();
       
	}
}
