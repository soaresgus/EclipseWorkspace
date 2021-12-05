package me.ninjay.curso.nms;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.curso.main.Main;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand.EnumClientCommand;

public class EventosMorrer implements Listener {

	@EventHandler
	public void aoMorrer(EntityDeathEvent e) {
		Player p = (Player) e.getEntity();
     
		PacketPlayInClientCommand pacote = new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN);
		CraftPlayer c = (CraftPlayer)p;
		new BukkitRunnable() {
			
			@Override
			public void run() {
				c.getHandle().playerConnection.a(pacote);
			}
		}.runTaskLater(Main.getmain(), 1);
	}

}
