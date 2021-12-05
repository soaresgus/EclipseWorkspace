package me.ninjay.nuncafiz.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.nuncafiz.BigornaKibada.EventosBigorna;
import me.ninjay.nuncafiz.MaquinarioTopi.ComandoDarMaquina;
import me.ninjay.nuncafiz.MaquinarioTopi.EventosMaquina;
import me.ninjay.nuncafiz.StaffQueUmDoidoMePediu.ComandoS;
import me.ninjay.nuncafiz.StaffQueUmDoidoMePediu.ComandoStaff;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventosBigorna(), this);
	    Bukkit.getPluginManager().registerEvents(new EventosMaquina(), this);
		getCommand("darmaquina").setExecutor(new ComandoDarMaquina());
	    getCommand("staff").setExecutor(new ComandoStaff());
	    getCommand("s").setExecutor(new ComandoS());
	}

}
