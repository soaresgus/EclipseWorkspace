package Zey.Lobby.Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener 
{
    @EventHandler
    public void modificarchat(AsyncPlayerChatEvent evento)
    {
    	Player jogador = evento.getPlayer();
    	
    	if (jogador.hasPermission("zey.lobby.falarcolorido"))
    	{
        	evento.setFormat(jogador.getDisplayName() +  " §7» " + evento.getMessage().replace("&", "§").replace("%", " Porcento(s)".replace("<3", "§4❤")));
    	} else {
    		evento.setFormat(jogador.getDisplayName() +  " §7» " + evento.getMessage());
    	}
    	if (jogador.hasPermission("zey.lobby.falarcoloridostaff"))
    	{
        	evento.setFormat(jogador.getDisplayName() +  " §6»§f " + evento.getMessage().replace("&", "§").replace("%", "Porcento(s)").replace("<3", "§4❤"));
    	}
    }
}
