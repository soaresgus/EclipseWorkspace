package me.ninjay.onealmas.eventos;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.onealmas.estruturas.AlmasAPI;
import me.ninjay.onealmas.estruturas.EstruturaJogador;
import me.ninjay.onealmas.main.Main;

public class EventosAlmas implements Listener {

	@EventHandler
	public void aoClicar(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		if (e.getRightClicked() instanceof Villager) {
			Villager vil = (Villager) e.getRightClicked();
			e.setCancelled(true);
			if (vil.getCustomName().contains("§eMercado de Almas")) {
				Inventory inv = Mine.newInventory("Mercado de Almas", 9 * 3);
				ItemStack item1 = Mine.newItem(Material.GRASS, "hm");
				ItemStack item2 = Mine.newItem(Material.STONE, "hm");
				ItemStack item3 = Mine.newItem(Material.MOB_SPAWNER, "hm");
				ItemStack item4 = Mine.newItem(Material.BEACON, "hm");
				ItemStack item5 = Mine.newItem(Material.FIREWORK, "hm");
				EstruturaJogador.mercadoNegro(p, inv, item1, Mine.getPosition(2, 2), item2, Mine.getPosition(2, 3),
						item3, Mine.getPosition(2, 4), item4, Mine.getPosition(2, 5), item5, Mine.getPosition(2, 6));
			}
		}
	}

	@EventHandler
	public void aoMatar(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Villager) {
			Villager vil = (Villager) e.getEntity();
			if (vil.getCustomName().contains("§eMercado de Almas")) {
				if (e.getDamager() instanceof Player) {
					Player p = (Player) e.getDamager();
					ItemStack vara = Mine.newItem(Material.CARROT_STICK, "§eMatar NPC", 1, 0, " ", "§e§lMatar NPC",
							"§e Hite o NPC com a varinha para mata-lo.");
					ItemMeta varam = vara.getItemMeta();
					varam.addEnchant(Enchantment.DURABILITY, 5, false);
					vara.setItemMeta(varam);
					if (p.hasPermission("almas.admin") && p.getItemInHand().isSimilar(vara)) {
						vil.setHealth(0.0);
					} else {
						e.setCancelled(true);
					}
				}
			}
		}
	}

	@EventHandler
	public void aoMatarPlayer(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player d = (Player) e.getEntity().getKiller();

		if (p instanceof Player) {
			if (d instanceof Player) {
				AlmasAPI.addAlmas(d, Main.almas, (long) 1);
				AlmasAPI.removeAlmas(p, Main.almas, (long) 1);

			}
		}
	}

}
