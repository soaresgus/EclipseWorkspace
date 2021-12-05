package me.ninjay.upsoulth.bloco;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.ninjay.upsoulth.main.Main;

public class EventosBlocos implements Listener{
	
	@EventHandler
	public void aoQubrar(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		Main.bloco.set(p.getName(), Main.bloco.getDouble(p.getName())+1.0);
		Main.bloco.saveConfig();
		return;
	}

}
