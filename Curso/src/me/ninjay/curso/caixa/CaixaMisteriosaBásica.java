package me.ninjay.curso.caixa;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.curso.main.Main;
import net.eduard.api.lib.Mine;

public class CaixaMisteriosaBásica implements Listener {
	public static void abrir(Player p) {
		Inventory caixa = Bukkit.createInventory(null, 9 * 3, "Caixa básica");
		ArrayList<ItemStack> list = new ArrayList<>();

		ItemStack espada = Mine.newItem(Material.DIAMOND_SWORD, "§eEspada");
		ItemStack peitoral = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§ePeitoral");
		ItemStack maca = Mine.newItem(Material.APPLE, "§eNada =)");
		ItemStack seu = Mine.newItem(Material.IRON_FENCE, "§eSeu item");

		
		list.add(peitoral);
		list.add(peitoral);
		list.add(peitoral);
		list.add(espada);
		list.add(espada);
		list.add(maca);
		new BukkitRunnable() {
			int id = 30;

			@Override
			public void run() {
				id--;
				
				for (int d = 0; d < 27; d++) {
					ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
					ItemMeta vidrom = vidro.getItemMeta();
					vidrom.setDisplayName("§eCaixa Básica");
					vidro.setDurability((short) Mine.getRandomInt(1, 15));
					vidro.setItemMeta(vidrom);
					caixa.setItem(d, vidro);
				}
				caixa.setItem(Mine.getPosition(2, 5), Mine.getRandomItem(list));
				caixa.setItem(Mine.getPosition(3, 5), seu);
				caixa.setItem(Mine.getPosition(1, 5), seu);
				if (id == 0) {
					cancel();
					ItemStack item = caixa.getItem(Mine.getPosition(2, 5));
					p.getInventory().addItem(item);
				}

			}
		}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 5, 5);
		p.openInventory(caixa);
	}

	@EventHandler
	public void caixabásica(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack caixa = Mine.newItem(Material.ENDER_CHEST, "§eCaixa Básica");

		if (p.getItemInHand().isSimilar(caixa)) {
			abrir(p);
			p.getInventory().remove(caixa);
		}

	}

	@EventHandler
	public void evento(InventoryClickEvent e) {

		if (e.getInventory().getTitle().equals("Caixa básica")) {
			e.setCancelled(true);

		}
	}

	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		ItemStack caixa = Mine.newItem(Material.ENDER_CHEST, "§eCaixa Básica");

		e.setJoinMessage(null);
		p.getInventory().addItem(caixa);
	}
}
