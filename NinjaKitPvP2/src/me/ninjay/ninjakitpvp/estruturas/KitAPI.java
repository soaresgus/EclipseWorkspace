package me.ninjay.ninjakitpvp.estruturas;

import java.util.ArrayList;
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

	public static HashMap<Player, String> kitp1 = new HashMap<>();
	public static HashMap<Player, String> kitp2 = new HashMap<>();
	
	public static ArrayList<Player> kit1list = new ArrayList<>();

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
	
	public static void setKitPvPGlobal(Player p) {
		setItensPadrao(p);
		ItemStack espada = new ItemStack(Material.STONE_SWORD);
		Mine.addEnchant(espada, Enchantment.DAMAGE_ALL, 1);
		p.getInventory().setItem(Mine.getPosition(1, 1), espada);
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

	public static void setKitPvP1(Player p) {
		kitp1.put(p, "PvP");
		p.getOpenInventory().close();
		p.sendMessage("§aKit PvP selecionado como kit 1!");
		kit1list.add(p);
	}
	
	public static void setKitPvP2(Player p) {
		if(kit1list.contains(p)) {
		kitp2.put(p, "PvP");
		tpArenas(p);
		setKitPvPGlobal(p);
		p.getOpenInventory().close();
		p.sendMessage("§aKit PvP selecionado como kit 2!");
		kit1list.remove(p);
		return;
	}else {
		p.getOpenInventory().close();
		p.sendMessage("§cEscolha primeiro o kit 1!");
	}
	}

	public static void abrirSeletor1(Player p) {
		Inventory sinv1 = Mine.newInventory("Kit 1", 9 * 6);

		for (int d = 0; d < 54; d++) {
			sinv1.setItem(d, ItemAPI.svidro);
			
		}
		sinv1.setItem(Mine.getPosition(2, 2), spvp);
		p.openInventory(sinv1);
	}
	
	public static void abrirSeletor2(Player p) {
		Inventory sinv2 = Mine.newInventory("Kit 2", 9 * 6);

		for (int d = 0; d < 54; d++) {
			sinv2.setItem(d, ItemAPI.svidro);
			
		}
		sinv2.setItem(Mine.getPosition(2, 2), spvp);
		p.openInventory(sinv2);
	}

	@EventHandler
	public void aoAbrir1(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if (p.getItemInHand().isSimilar(ItemAPI.seletor1)) {
			abrirSeletor1(p);
		}
	}
	
	@EventHandler
	public void aoAbrir2(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if (p.getItemInHand().isSimilar(ItemAPI.seletor2)) {
			abrirSeletor2(p);
		}
	}


	@EventHandler
	public void aoClicar1(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equals("Kit 1")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(spvp)) {
				if (p.hasPermission("pvp.kit")) {
					setKitPvP1(p);
				}else {
					p.getOpenInventory().close();
					p.sendMessage("§cVocê não tem permissão para pegar esse kit.");
				}
				
			}
		}
	}
	@EventHandler
	public void aoClicar2(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equals("Kit 2")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(spvp)) {
				if (p.hasPermission("pvp.kit")) {
					setKitPvP2(p);
				}else {
					p.getOpenInventory().close();
					p.sendMessage("§cVocê não tem permissão para pegar esse kit.");
				}
				
			}
		}
	}

}
