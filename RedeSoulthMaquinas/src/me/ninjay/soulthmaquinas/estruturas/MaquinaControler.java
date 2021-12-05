package me.ninjay.soulthmaquinas.estruturas;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.ninjay.soulthmaquinas.main.Main;
import net.eduard.api.lib.modules.VaultAPI;


public class MaquinaControler implements Listener{
	
	@EventHandler
	public void abrir(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		for( Maquina maquina: MaquinaAPI.manager.getMaquinas()) {
			if(maquina.getIcone().isSimilar(p.getItemInHand())) {
				e.setCancelled(true);
				MaquinaAPI.manager.abrir(p, maquina);
			
			}
		}
	}
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getTitle().equals("Maquina")) {
			e.setCancelled(true);
			for(Maquina maquina : MaquinaAPI.manager.getMaquinas()) {
				if(e.getCurrentItem().isSimilar(maquina.getDrop())) {
					if(Main.drop.getDouble(maquina.getNome()+"_drop_"+p.getName()) >= 64) {
						p.getOpenInventory().close();
						p.sendMessage("§eVocê vendeu todos os drops da sua máquina !");
						VaultAPI.getEconomy().depositPlayer(p, maquina.getValordrop()*Main.drop.getDouble(maquina.getNome()+"_drop_"+p.getName()));
						Main.drop.set(maquina.getNome()+"_drop_"+p.getName(), Main.drop.getDouble(maquina.getNome()+"_drop_"+p.getName())-Main.drop.getDouble(maquina.getNome()+"_drop_"+p.getName()));
					    Main.drop.saveConfig();  
					}else {
						p.sendMessage("§cVocê não tem drops suficiente.");
					}
						
						
					}
				}
			}
			
		}
	}

