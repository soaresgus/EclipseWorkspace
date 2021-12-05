package me.ninjay.nuncafiz.BigornaKibada;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.nuncafiz.main.Main;
import me.ninjay.nuncafiz.utils.Mine;

public class EventosBigorna implements Listener {

	@EventHandler
	public void aoAbrir(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getClickedBlock().getType() == Material.ANVIL) {
				new BukkitRunnable() {

					@Override
					public void run() {
						e.getPlayer().getOpenInventory().close();
					}
				}.runTaskLater(Main.getPlugin(Main.class), 1 / 2);
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void aoClicar(PlayerInteractEvent e) {
		Player p = e.getPlayer();

			if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
				if (e.getClickedBlock().getType() == Material.ANVIL) {
				if (p.getItemInHand().getData().getItemTypeId() >= 276
						|| p.getItemInHand().getData().getItemTypeId() >= 310
						|| p.getItemInHand().getData().getItemTypeId() == 293) {
					if (p.getItemInHand().getData().getItemTypeId() <= 279
							|| p.getItemInHand().getData().getItemTypeId() <= 313) {
						if (p.getInventory().contains(Material.DIAMOND)) {
							if (p.getItemInHand().getDurability() != 0) {
								p.getItemInHand().setDurability((short) (p.getItemInHand().getDurability() - 100));
								Mine.remove(p.getInventory(), Material.DIAMOND, 1);
							} else {
								p.sendMessage("§cO item já está reparado !");
								p.getWorld().playSound(p.getLocation(), Sound.VILLAGER_NO, 1F, 1F);
							}
						} else {
							p.sendMessage("§cVocê não possui diamantes !");
							p.getWorld().playSound(p.getLocation(), Sound.VILLAGER_NO, 1F, 1F);
						}
					} else {
						p.sendMessage("§cÉ possível reparar apenas itens de diamante.");
						p.getWorld().playSound(p.getLocation(), Sound.VILLAGER_NO, 1F, 1F);
					}
				}
			}else {
				return;
			}
		} 
	}

}
