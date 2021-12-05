package me.ninjay.ninjapartylb.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjapartylb.estruturas.ItemAPI;
import me.ninjay.ninjapartylb.utils.Mine;

public class EventosLobby implements Listener{
	
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		ItemStack perfil = Mine.newHead("§eSeu perfil", p.getName(), 1, "");
		
		e.setJoinMessage(null);
		Mine.setTabList(p, "\n \n§6§lNinja Party\n§fninjaparty.net\n \n§fCompre vip e cash e ajude o servidor\n ", "\n \n§eDiscord: §fEm breve\n§eTwitter: §f@NinjaParty\n§eSite: §fwww.ninjaparty.net\n ");
		p.getInventory().setItem(Mine.getPosition(1, 5), ItemAPI.bussola);
		p.getInventory().setItem(Mine.getPosition(1, 2), ItemAPI.gadgets);
		p.getInventory().setItem(Mine.getPosition(1, 8), perfil);
		Mine.sendTitle(p, "§6§lNinja Party", "§fServidor de minigames", 10, 50, 10);
		p.sendMessage("§a§l > Mensagens <\n \n§6§l \n ");
	}

}
