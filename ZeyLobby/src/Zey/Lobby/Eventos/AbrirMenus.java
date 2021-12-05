package Zey.Lobby.Eventos;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import Zey.Lobby.Menus.MenuServidores;

public class AbrirMenus implements Listener
{
    @EventHandler
    public void AbrirMenuServidores(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR 
        		|| e.getAction() == Action.RIGHT_CLICK_BLOCK) 
        		&& e.getPlayer().getItemInHand().getType() == Material.COMPASS 
        		&& p.getItemInHand().hasItemMeta() 
        		&& p.getItemInHand().getItemMeta().hasDisplayName() 
        		&& p.getItemInHand().getItemMeta().getDisplayName().equals("§eServidores")) {
            e.setCancelled(true);
            p.playSound(p.getLocation(), Sound.DOOR_OPEN, 5.0f, 5.0f);
            MenuServidores.Menu(p);
        }
    }
}