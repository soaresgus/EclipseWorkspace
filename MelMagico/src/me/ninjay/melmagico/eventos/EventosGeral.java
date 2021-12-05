package me.ninjay.melmagico.eventos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BoundingBox;

import me.ninjay.melmagico.comandos.ComandoAtivar;
import me.ninjay.melmagico.estruturas.ItensAPI;
import me.ninjay.melmagico.main.Main;
import me.ninjay.melmagico.utils.Mine;

public class EventosGeral implements Listener {

	private static HashMap<Player, Location> locsave = new HashMap<>();
	private static ArrayList<Player> usou = new ArrayList<>();
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {

		if (e.getEntity() != null) {
			if (e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity();
				if (ComandoAtivar.ativado.get(p) != null && ComandoAtivar.ativado.get(p) == true) {
					List<LivingEntity> list = Mine.getNearbyEntities(p, 30, EntityType.PLAYER);
					list.remove(p);
					if(list.size() > 0) {
						if(!usou.contains(p)) {
							LivingEntity jp = list.get(0);
							if(jp instanceof Player) {
							usou.add(p);
							locsave.remove(p);
							locsave.put(p, p.getLocation());
							
							p.sendMessage(" \n  §eVocê trocou de local com §a" + jp.getName() + "§e!\n ");
							
							for(int x = (int)-1.5; x <= 1.5; x++) {
								for(int y = (int)-1.5; y <= 1.5; y++) {
									for(int z = (int)-1.5; z <= 1.5; z++) {
										p.spawnParticle(Particle.PORTAL, p.getLocation().add(x, y, z), 50, 0.1, 0.1, 0.1);
									}
								}
							}
							
							p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 1F);
							p.teleport(jp.getLocation());
							
							jp.sendMessage(" \n  §a" + p.getName() + " §etrocou de local com você!\n ");
							
							for(int x = (int)-1.5; x <= 1.5; x++) {
								for(int y = (int)-1.5; y <= 1.5; y++) {
									for(int z = (int)-1.5; z <= 1.5; z++) {
										jp.getWorld().spawnParticle(Particle.PORTAL, jp.getLocation().add(x, y, z), 50, 0.1, 0.1, 0.1);
									}
								}
							}
							
							jp.getWorld().playSound(jp.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 1F);
							jp.teleport(locsave.get(p));
							locsave.remove(p);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									usou.remove(p);
								}
							}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
							}
						}
					}else {
						p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
						p.sendMessage("§cNenhum jogador encontrado em um raio de 30 blocos!");
					}
				}
			}
		}

	}

	@EventHandler
	public void onEat(PlayerItemConsumeEvent e) {
		Player p = e.getPlayer();
		
		if(e.getItem().isSimilar(ItensAPI.mel_magico)) {
			if(ComandoAtivar.ativado.get(p) != null && ComandoAtivar.ativado.get(p) == true) {
			new BukkitRunnable() {
					
					@Override
					public void run() {
						ComandoAtivar.ativado.remove(p);
						Mine.removeEffects(p);
						p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
						p.sendMessage("§cMagia de troca de local desativada!");
					}
				}.runTaskLater(Main.getPlugin(Main.class), 1);
			}else {
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				p.sendMessage("§cVocê não está com a magia ativada!");
			}
			}
	}
	
	
}
