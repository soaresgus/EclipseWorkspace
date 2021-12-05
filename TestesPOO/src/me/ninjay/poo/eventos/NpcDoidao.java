package me.ninjay.poo.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class NpcDoidao implements Listener{
	
	@EventHandler
    public void interactor(PlayerInteractEntityEvent event) {
        if(event.getRightClicked() instanceof Player) {
            Player player = (Player) event.getRightClicked();
            if(player.getName().equalsIgnoreCase("§f")) {
                event.setCancelled(true);
            }
        }
    }

}
