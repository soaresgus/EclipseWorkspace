package me.ninjay.utils.utils;

import org.bukkit.Location;
import org.bukkit.World;

import me.ninjay.utils.main.Main;


public class TestLocationStorable {

	public static void test() {
		World wordlVasio = Mine.newEmptyWorld("mundovasio");
		
		BukkitConfig c = new BukkitConfig("testloc.yml", Main.getInstance());
		c.set("loc", new Location(wordlVasio,0,5,0));
		c.saveConfig();
		
		c.reloadConfig();
		System.out.println(c.get("loc"));
		
	}
	public static void init() {
//		Mine.TIME.timer(20, ()->test());
	
	}
}
