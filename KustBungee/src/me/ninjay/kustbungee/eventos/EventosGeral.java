package me.ninjay.kustbungee.eventos;

import java.util.UUID;

import me.ninjay.kustbungee.main.Main;
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
		ping.setDescription("§b§lKust Network §7[1.8]\n§eNovidades em breve!");
		ServerPing.PlayerInfo[] sample = new ServerPing.PlayerInfo[] {
				new ServerPing.PlayerInfo("§b§lKust Network §7[1.8]", EMPTY_UUID)};
		ping.getPlayers().setSample(sample);
	}
	
}
