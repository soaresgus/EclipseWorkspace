package me.ninjay.bungee;

import java.util.UUID;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class BungeeTop implements Listener {

	private static final UUID EMPTY_UUID = new UUID(0, 0);

	@SuppressWarnings("deprecation")
	@EventHandler
	public void info(ProxyPingEvent e) {
		ServerPing ping = e.getResponse();
		ping.setDescription("§6§lYOUR NETWORK §7(1.8.*)\n§eNovo §5§lFactions Fantasy §eaberto em beta vip !");
		ServerPing.PlayerInfo[] sample = new ServerPing.PlayerInfo[] {
				new ServerPing.PlayerInfo(" \n§6§lYour Network\n \n§eTemporada 6\n \n§e* HG Reformulado\n§e* Novos Mapas\n§e* Novo Lobby\n \n§6§ldiscord.gg/YourNetwork\n§6§l@YourNetwork\n§6§lloja.yournetwork.com\n ", EMPTY_UUID) };
		ping.getPlayers().setSample(sample);
	}
	@EventHandler
	public static void entrar(PostLoginEvent e) {
		ProxiedPlayer p = (ProxiedPlayer) e.getPlayer();
		p.sendMessage(new TextComponent("§ayeaaaaaaaaaah"));
	}
	
	@EventHandler
	public static void sair(PlayerDisconnectEvent e) {
		
	}

}
