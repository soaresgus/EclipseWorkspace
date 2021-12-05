package me.ninjay.safeclubbungee.comandos;

import java.util.concurrent.TimeUnit;

import me.ninjay.safeclubbungee.main.BungeeMain;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ComandoRunnable extends Command{

	private BungeeMain plugin;
	
	public ComandoRunnable(BungeeMain plugin) {
		super("run");
		this.plugin = plugin;
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxyServer.getInstance().getScheduler().schedule(plugin, new Runnable() {
			
			@Override
			public void run() {
				ProxyServer.getInstance().getScheduler().schedule(plugin, new Runnable() {
					
					@Override
					public void run() {
						for(ProxiedPlayer todos : BungeeCord.getInstance().getPlayers()) {
							if(BungeeMain.temp.getLong(todos.getName()+".tempo") > 0) {
							BungeeMain.temp.set(todos.getName()+".tempo", BungeeMain.temp.getLong(todos.getName()+".tempo")-1);
					        BungeeMain.temp.saveConfig();
					        todos.sendMessage(new TextComponent(""+BungeeMain.temp.getLong(todos.getName()+".tempo")));
						return;
							}
							if(BungeeMain.temp.getLong(todos.getName()+".tempo") == 0) {
								BungeeMain.temp.remove(todos.getName() + ".tipo");
								BungeeMain.temp.remove(todos.getName() + ".tempo");
								BungeeMain.temp.remove(todos.getName() + ".motivo");
								BungeeMain.temp.remove(todos.getName() + ".autor");
								BungeeMain.temp.saveConfig();
							return;
						}
						}
					}
				}, 5, 1, TimeUnit.SECONDS);
			}
		}, 3, TimeUnit.SECONDS);
	
	}

}
