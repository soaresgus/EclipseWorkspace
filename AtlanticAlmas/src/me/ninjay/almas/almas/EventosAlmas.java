package me.ninjay.almas.almas;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.ninjay.almas.main.Main;
import me.ninjay.ninjaapi.utils.Mine;

public class EventosAlmas implements Listener{
	
	@EventHandler
	public void aoMatar(PlayerDeathEvent e) {
		
		Player k = e.getEntity().getKiller();
		if(k == null) {
			return;
			}
		if(!(k instanceof Player)) {
			return;
		}
		if(k instanceof Player) {
		Player p = e.getEntity();
		double almas = Main.almas.getDouble(k.getName());
		e.setDeathMessage(null);
		k.sendMessage("§aVocê matou "+p.getName()+" e recebeu 5 almas !");
		Mine.sendActionBar(k, "§e+5 Almas");
		Main.almas.set(k.getName(), almas+5.0d);
		return;
		}
	}
	@EventHandler
	public void aoMatarMob(EntityDeathEvent e) {
		Player k = e.getEntity().getKiller();
		EntityType m = e.getEntityType();
		if(!(k instanceof Player)) {
			return;
		}
if(k instanceof Player) {
		if(m == EntityType.BLAZE || m == EntityType.COW || m == EntityType.CHICKEN || m == EntityType.WITCH || m == EntityType.WITHER || m == EntityType.CREEPER || m == EntityType.ZOMBIE || m == EntityType.SKELETON || m == EntityType.PIG_ZOMBIE || m == EntityType.IRON_GOLEM || m == EntityType.VILLAGER || m == EntityType.SPIDER || m == EntityType.MAGMA_CUBE || m == EntityType.ENDERMAN || m == EntityType.SLIME || m == EntityType.WOLF) {
			k.sendMessage("§aVocê matou um mob e recebeu 3 almas !");
			Mine.sendActionBar(k, "§e+3 Almas");
			double almas = Main.almas.getDouble(k.getName());
			Main.almas.set(k.getName(), almas+3.0d);
			return;
		}
		
		}


}
}

