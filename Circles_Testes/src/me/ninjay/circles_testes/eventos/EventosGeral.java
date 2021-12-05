package me.ninjay.circles_testes.eventos;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class EventosGeral implements Listener{
	
	@EventHandler
	public void onChuva(WeatherChangeEvent e) {
		e.setCancelled(true);
	}

}
