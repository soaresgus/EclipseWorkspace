package me.ninjay.megataymaquinas.estruturas;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.megataymaquinas.main.Main;
import net.eduard.api.lib.Mine;

public class MaquinaControler implements Listener {

	public static void iniciarMaquina(Player p, Location loco, Maquina maquina) {
		p.getWorld().playSound(loco, Sound.ANVIL_USE, 1F, 1F);
		p.sendMessage("§aVocê colocou uma máquina !");
		Double x = loco.getX() + 0.5;
		Double y = loco.getY() - 0.5;
		Double z = loco.getZ() + 0.5;

		Location loca = new Location(p.getWorld(), x, y, z);

		Mine.newHologram(loca, maquina.getIcone().getItemMeta().getDisplayName() + " §6| " + p.getName());
	}

	public static void removerMaquina(Player p, Location loco, Maquina maquina) {
		p.getWorld().playSound(loco, Sound.ANVIL_LAND, 1F, 1F);
		p.sendMessage("§cVocê retirou uma máquina !");
		Double x = loco.getX() + 0.5;
		Double y = loco.getY() - 0.5;
		Double z = loco.getZ() + 0.5;
		Location loca = new Location(p.getWorld(), x, y, z);
		for (ArmorStand armor : p.getWorld().getEntitiesByClass(ArmorStand.class)) {
			if (armor.getLocation().equals(loca)) {
				armor.remove();
			}
		}
	}

	@EventHandler
	public void aoColocar(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		String nome = p.getItemInHand().getItemMeta().getDisplayName();
		Maquina maquina = MaquinaAPI.manager.getMaquinaPorNomeDoItem(nome);

		p.getInventory().addItem(RefinariaAPI.manager.getRefinariaPorNumero(1).getCombustivel());

		if (maquina != null) {
			List<Location> allMaquinas = Main.getPlugin(Main.class).Maquinas.get(p);
			if (allMaquinas != null) {
				allMaquinas.add(e.getBlockPlaced().getLocation());
				Main.getPlugin(Main.class).Maquinas.put(p, allMaquinas);
				Main.getPlugin(Main.class).saveMaquinas();
				Main.locations.saveConfig();
				iniciarMaquina(p, e.getBlockPlaced().getLocation(), maquina);
			} else {
				List<Location> allMaquinas2 = new ArrayList<>();
				allMaquinas2.add(e.getBlockPlaced().getLocation());
				Main.getPlugin(Main.class).Maquinas.put(p, allMaquinas2);
				Main.getPlugin(Main.class).saveMaquinas();
				Main.locations.saveConfig();
				iniciarMaquina(p, e.getBlockPlaced().getLocation(), maquina);
			}
		} else {
			return;
		}
	}

	@EventHandler
	public void aoRemover(BlockBreakEvent e) {
		Player p = e.getPlayer();
		List<Location> allMaquinas = Main.getPlugin(Main.class).Maquinas.get(p);
		Material item = e.getBlock().getType();
		Maquina maquina = MaquinaAPI.manager.getMaquinaPorTipo(item);

		if (allMaquinas != null) {
			for (Location loc : allMaquinas) {
				if (e.getBlock().getLocation().equals(loc)) {
					if (maquina != null) {
						e.getBlock().setType(Material.AIR);
						new BukkitRunnable() {

							@Override
							public void run() {
								ItemStack maquinaitem = maquina.getIcone();
								maquinaitem.setAmount(1);
								p.getWorld().dropItem(e.getBlock().getLocation(), maquinaitem);
								allMaquinas.remove(e.getBlock().getLocation());
								Main.getPlugin(Main.class).Maquinas.put(p, allMaquinas);
								Main.getPlugin(Main.class).saveMaquinas();
								Main.locations.saveConfig();
								removerMaquina(p, e.getBlock().getLocation(), maquina);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 1);

					}
				}
			}
		}

	}

	@EventHandler
	public void aoClicar(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		List<Location> allMaquinas = Main.getPlugin(Main.class).Maquinas.get(p);
		ItemStack item = p.getItemInHand();

		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (allMaquinas != null) {
				for (Location loc : allMaquinas) {
					if (e.getClickedBlock().getLocation().equals(loc)) {
						if (item.getItemMeta().getDisplayName().equals(RefinariaAPI.manager.getRefinariaPorNumero(1)
								.getCombustivel().getItemMeta().getDisplayName())) {
							p.sendMessage("+1 combustivel");
						}
					}

				}
			}
		}
	}
}
