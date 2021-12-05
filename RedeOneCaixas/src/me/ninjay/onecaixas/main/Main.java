package me.ninjay.onecaixas.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.onecaixas.comandos.ComprarCaixa;
import me.ninjay.onecaixas.estruturas.Caixa;
import me.ninjay.onecaixas.estruturas.CaixaAPI;
import me.ninjay.onecaixas.estruturas.CaixaControler;
import me.ninjay.onecaixas.estruturas.CaixaManager;
import me.ninjay.utils.utils.StorageAPI;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("comprarcaixa").setExecutor(new ComprarCaixa());
		Bukkit.getPluginManager().registerEvents(new CaixaControler(), this);
		StorageAPI.register(Caixa.class);
		StorageAPI.register(CaixaManager.class);
		CaixaAPI.reload();
	}

}
