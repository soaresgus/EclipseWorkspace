package me.ninjay.safeclubbungee.eventos;

import java.util.UUID;

import me.ninjay.safeclubbungee.main.BungeeMain;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class BungeeEventos implements Listener {

	private static final UUID EMPTY_UUID = new UUID(0, 0);
    public static boolean estado = false;
	@SuppressWarnings("unused")
	private BungeeMain plugin;
	

	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void info(ProxyPingEvent e) {
		ServerPing ping = e.getResponse();
		ping.setDescription("§6§lSafe Club §7(1.8.*)\n§eNovo servidor de §6§lP4 Free §eem breve !");
		ServerPing.PlayerInfo[] sample = new ServerPing.PlayerInfo[] {
				new ServerPing.PlayerInfo(" \n§6§lSafe Club\n \n§e* Novidades estão por vir...\n \n§6Discord: §eEm Breve.\n§6Loja: §eEm Breve.\n§6Twitter: §eEm Breve.\n ", EMPTY_UUID) };
		ping.getPlayers().setSample(sample);
	}
	
	@EventHandler
	public void aoEntar(PostLoginEvent e) {
		if(estado ==false) {
			estado = true;
			e.getPlayer().chat("/run");
		}else {
			return;
		}
	}
	
	
}