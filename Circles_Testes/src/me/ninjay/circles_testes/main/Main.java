package me.ninjay.circles_testes.main;

import java.sql.Connection;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.circles_testes.comandos.ComandoCargos;
import me.ninjay.circles_testes.estruturas.Tags;
import me.ninjay.circles_testes.estruturas.TagsAPI;
import me.ninjay.circles_testes.estruturas.TagsControler;
import me.ninjay.circles_testes.estruturas.TagsManager;
import me.ninjay.circles_testes.utils.BukkitStorables;
import me.ninjay.circles_testes.utils.StorageAPI;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin{
	
	
	@Override
	public void onEnable() {
		getCommand("cargo").setExecutor(new ComandoCargos());
		Bukkit.getPluginManager().registerEvents(new TagsControler(), this);
		StorageAPI.register(Tags.class);
		StorageAPI.register(TagsManager.class);
		TagsAPI.reload();
		
		BukkitStorables.load();
	}



}
