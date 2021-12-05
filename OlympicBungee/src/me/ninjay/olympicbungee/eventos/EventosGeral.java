package me.ninjay.olympicbungee.eventos;

import java.util.UUID;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class EventosGeral implements Listener{
	
	private static final UUID EMPTY_UUID = new UUID(0, 0);
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void motd(ProxyPingEvent e) {
		ServerPing ping = e.getResponse();
		ping.setDescription("§b§lOLYMPIC §7(1.8.*)\n§cEm desenvolvimento.");
		ServerPing.PlayerInfo[] sample = new ServerPing.PlayerInfo[] {
				new ServerPing.PlayerInfo("§b§lOLYMPIC §7(1.8.*)\n \n§eNovidades estão por vir\n \n§bloja.olympicmc.com.br", EMPTY_UUID)};
		ping.getPlayers().setSample(sample);
	}
}
