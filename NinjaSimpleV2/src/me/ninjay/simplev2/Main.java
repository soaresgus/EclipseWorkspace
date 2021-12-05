package me.ninjay.simplev2;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin{
	

	
	@Override
	public void onEnable() {
		setupPermissions();
		setupChat();
		setupEconomy();
      
		Bukkit.getConsoleSender().sendMessage("§c§lNinja Simple ativado.");
		getCommand("staffchat").setExecutor(new ComandoStaffChat());
		getCommand("aviso").setExecutor(new ComandoAviso());
		getCommand("gamemode").setExecutor(new ComandoGameMode());
		getCommand("spawn").setExecutor(new ComandoSpawn());
		getCommand("teleportartodos").setExecutor(new ComandoTeleportarTodos());
		getCommand("dartag").setExecutor(new ComandoDarTag());
		getCommand("retirartag").setExecutor(new ComandoRetirarTag());

	
	}

	public static Main getmain() {
		return (Main) Bukkit.getPluginManager().getPlugin("NinjaSimple");
	}
	 public static Permission permission = null;
	    public static Economy economy = null;
	    public static Chat chat = null;

	    private boolean setupPermissions()
	    {
	        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
	        if (permissionProvider != null) {
	            permission = permissionProvider.getProvider();
	        }
	        return (permission != null);
	    }

	    private boolean setupChat()
	    {
	        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
	        if (chatProvider != null) {
	            chat = chatProvider.getProvider();
	        }

	        return (chat != null);
	    }

	    private boolean setupEconomy()
	    {
	        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
	        if (economyProvider != null) {
	            economy = economyProvider.getProvider();
	        }

	        return (economy != null);
	    }
}
