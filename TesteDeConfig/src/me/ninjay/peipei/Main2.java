package me.ninjay.peipei;

import net.milkbowl.vault.economy.Economy;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main2 extends JavaPlugin {

    private static Main2 main;
    private static SimpleClans simpleClans;
    private static Economy economy;

    @Override
    public void onEnable() {
        main = this;
        if ((simpleClans = hookSimpleClans()) == null || (economy = hookEconomy()) == null) {
            getServer().getConsoleSender().sendMessage("§cSimpleClans ou Vault(Economia) não encontrado!");
            return;
        }
        getServer().getConsoleSender().sendMessage("§aSimpleClans e Vault(Economia) conectado com sucesso!");

        getServer().getPluginManager().registerEvents(new Eventos(), this);
        getCommand("gladiador").setExecutor(new Comandos());
        
        saveDefaultConfig();
        Gladiador.setupLocation();
    }

    @Override
    public void onDisable() {
    	Gladiador.saveLocations();
    	
        HandlerList.unregisterAll(this);
    }

    private SimpleClans hookSimpleClans() {
        Plugin p = getServer().getPluginManager().getPlugin("SimpleClans");
        if (p == null || !(p instanceof SimpleClans)) {
            return null;
        }

        return (SimpleClans) p;
    }

    private Economy hookEconomy() {
        if (!getServer().getPluginManager().isPluginEnabled("Vault")) return null;
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) return null;

        return rsp.getProvider();
    }

    public static SimpleClans getSimpleClans() {
        return simpleClans;
    }

    public static Main getMain() {
        return main;
    }

    public static Economy getEconomy() {
        return economy;
    }

}