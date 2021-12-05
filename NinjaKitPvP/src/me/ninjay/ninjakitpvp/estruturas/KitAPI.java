package me.ninjay.ninjakitpvp.estruturas;

import java.util.HashMap;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjakitpvp.eventos.EventosGlobal;
import me.ninjay.ninjakitpvp.main.Main;
import me.ninjay.ninjakitpvp.utils.Mine;

public class KitAPI implements Listener {

	public static HashMap<Player, String> kitp = new HashMap<>();

	public static ItemStack spvp = Mine.newItem(Material.STONE_SWORD, "§eKit PvP", 1, 0, " ", " §7Kit pvp básico.");

	public static void setItensPadrao(Player p) {
		Mine.clearInventory(p);
		Mine.fill(p.getInventory(), new ItemStack(Material.MUSHROOM_SOUP));
		p.getInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.STONE_SWORD));
		p.getInventory().setItem(Mine.getPosition(2, 5), Mine.newItem(Material.BOWL, null, 64));
		p.getInventory().setItem(Mine.getPosition(2, 6), Mine.newItem(Material.BROWN_MUSHROOM, null, 64));
		p.getInventory().setItem(Mine.getPosition(2, 7), Mine.newItem(Material.RED_MUSHROOM, null, 64));
		EventosGlobal.spawn.remove(p);
		p.updateInventory();
	}

	public static void tpArenas(Player p) {
		if (Main.locations.contains("arena1")) {
			p.teleport(Main.locations.getLocation("arena" + Mine.getRandomInt(1, 5)));
			p.setAllowFlight(false);
			p.setGameMode(GameMode.SURVIVAL);
		} else {
			p.sendMessage("§cNenhuma arena foi setada.");
		}
	}

	public static void setKitPvP(Player p) {
		setItensPadrao(p);
		ItemStack espada = new ItemStack(Material.STONE_SWORD);
		Mine.addEnchant(espada, Enchantment.DAMAGE_ALL, 1);
		p.getInventory().setItem(Mine.getPosition(1, 1), espada);
		p.updateInventory();
		kitp.put(p, "PvP");
		p.getOpenInventory().close();
		tpArenas(p);
	}

	public static void abrirSeletor(Player p) {
		Inventory sinv = Mine.newInventory("Kits", 9 * 6);

		for (int d = 0; d < 54; d++) {
			sinv.setItem(d, ItemAPI.svidro);
		}
		sinv.setItem(Mine.getPosition(2, 2), spvp);
		p.openInventory(sinv);
	}

	@EventHandler
	public void aoAbrir(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if (p.getItemInHand().isSimilar(ItemAPI.seletor)) {
			abrirSeletor(p);
		}
	}

	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equals("Kits")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(spvp)) {
				if (p.hasPermission("pvp.kit")) {
					setKitPvP(p);

				}else {
					p.getOpenInventory().close();
					p.sendMessage("§cVocê não tem permissão para pegar esse kit.");
				}
				
			}
		}
	}

}
