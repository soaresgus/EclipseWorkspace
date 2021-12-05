package me.ninjay.ninjaapi.bungee.BungeeCashAPI;
import me.ninjay.ninjaapi.utils.BungeeConfig;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class BungeeCashAPI {
	
	public static int get(ProxiedPlayer p, BungeeConfig config) {
		return config.getInt(p.getName());
	}

	public static void set(ProxiedPlayer p, BungeeConfig config, int cash) {
		config.set(p.getName(), cash);
		config.saveConfig();
	}

	public static void add(ProxiedPlayer p, BungeeConfig config, int cash) {
        config.set(p.getName(), get(p, config)+cash);
        config.saveConfig();
	}
	
	public static void remove(ProxiedPlayer p, BungeeConfig config, int cash) {
		config.set(p.getName(), get(p, config)-cash);
		config.saveConfig();
		
	}
	
	public static boolean has(ProxiedPlayer p, BungeeConfig config, int cash) {
		return get(p, config)==cash;
		
	}

}
