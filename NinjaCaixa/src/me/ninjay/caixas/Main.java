package me.ninjay.caixas;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.eduard.api.lib.storage.StorageAPI;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
	StorageAPI.register(Caixa.class);
	StorageAPI.register(CaixaManager.class);
	CaixaAPI.reload();
	getCommand("darcaixa").setExecutor(new ComandoDarCaixa());
	Bukkit.getPluginManager().registerEvents(new CaixaControler(), this);

	}
}
