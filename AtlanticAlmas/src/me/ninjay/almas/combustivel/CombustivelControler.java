package me.ninjay.almas.combustivel;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.ninjay.almas.main.Main;

public class CombustivelControler implements Listener{
	
	@EventHandler
	public void aoQuerar(BlockBreakEvent e) {
		Player p = e.getPlayer();
		double blocos = Main.blocos.getDouble(p.getName());
		Main.blocos.set(p.getName(), blocos+1.0d);
		Main.blocos.saveConfig();
	for(Combustivel combustivel : CombustivelAPI.manager.getCombustiveis()) {
				if(blocos == 1) {
					p.sendMessage("aaa");
					Main.blocos.set(p.getName(), blocos-blocos);
					Main.blocos.saveConfig();
					return;
			}
					if(blocos == 1) {
						p.sendMessage("aab");
						Main.blocos.set(p.getName(), blocos-blocos);
						Main.blocos.saveConfig();
						return;
		}
}
	}
}