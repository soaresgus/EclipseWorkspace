package me.ninjay.kusttags.eventos;

import java.util.UUID;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;



public class EventosTemplate implements Listener{
	
	private static final UUID EMPTY_UUID = new UUID(0, 0);
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void motd(ProxyPingEvent e) {
		ServerPing ping = e.getResponse();
		ping.setDescription("MOTD TOP");
		ServerPing.PlayerInfo[] sample = new ServerPing.PlayerInfo[] {
				new ServerPing.PlayerInfo("MENSAGEM NO PING TOP", EMPTY_UUID)};
		ping.getPlayers().setSample(sample);
	}
}
