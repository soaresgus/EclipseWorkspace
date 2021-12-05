package me.ninjay.ninjacxc.estruturas;

import me.ninjay.ninjacxc.main.Main;
import me.ninjay.ninjacxc.utils.BukkitConfig;

public class GlobalAPI {
	
	public static BukkitConfig getConfigGlobal() {
		return Main.config;
	}
	
	public static BukkitConfig getConfigA1() {
		return Main.a1;
	}
	
	public static void reloadConfigs() {
		getConfigGlobal().reloadConfig();
		getConfigA1().reloadConfig();
		getConfigGlobal().saveConfig();
		getConfigA1().saveConfig();
	}

}