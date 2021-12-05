package me.ninjay.kustspawners.comandos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.kustspawners.utils.Mine;


public class ComandoSetarMob implements CommandExecutor, Listener {

	public static HashMap<EntityType, Location> locmob = new HashMap<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			Inventory menu = Mine.newInventory("Escolha um mob", 9 * 4);

			ItemStack galinha = Mine.newHead("§eGalinha", "MHF_Chicken", 1, " ",
					"  §7Clique para setar o spawn do mob.");
			ItemStack ovelha = Mine.newHead("§eOvelha", "MHF_Sheep", 1, " ", "  §7Clique para setar o spawn do mob.");
			ItemStack cave = Mine.newHead("§eAranha da caverna", "MHF_CaveSpider", 1, " ",
					"  §7Clique para setar o spawn do mob.");
			ItemStack slime = Mine.newHead("§eSlime", "MHF_Slime", 1, " ", "  §7Clique para setar o spawn do mob.");
			ItemStack magma = Mine.newHead("§eCubo de magma", "MHF_LavaSlime", 1, " ",
					"  §7Clique para setar o spawn do mob.");
			ItemStack pigman = Mine.newHead("§ePorco-Zumbi", "MHF_PigZombie", 1, " ",
					"  §7Clique para setar o spawn do mob.");
			ItemStack enderman = Mine.newHead("§eEnderman", "MHF_Enderman", 1, " ",
					"  §7Clique para setar o spawn do mob.");
			ItemStack wither = Mine.newHead("§eWither", "MHF_WSkeleton", 1, " ",
					"  §7Clique para setar o spawn do mob.");

			menu.setItem(Mine.getPosition(2, 2), galinha);
			menu.setItem(Mine.getPosition(2, 4), ovelha);
			menu.setItem(Mine.getPosition(2, 6), cave);
			menu.setItem(Mine.getPosition(2, 8), slime);
			menu.setItem(Mine.getPosition(3, 2), magma);
			menu.setItem(Mine.getPosition(3, 4), pigman);
			menu.setItem(Mine.getPosition(3, 6), enderman);
			menu.setItem(Mine.getPosition(3, 8), wither);

			p.openInventory(menu);
		}
		return false;
	}

	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equalsIgnoreCase("Escolha um mob")) {
			e.setCancelled(true);
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().getItemMeta() != null) {
					if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Galinha")) {
						p.getOpenInventory().close();
						p.sendMessage("§aLocalização de spawn setado!");
						locmob.put(EntityType.CHICKEN, p.getLocation());
					}
					if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Ovelha")) {
						p.getOpenInventory().close();
						p.sendMessage("§aLocalização de spawn setado!");
						locmob.put(EntityType.SHEEP, p.getLocation());
					}
					if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Aranha")) {
						p.getOpenInventory().close();
						p.sendMessage("§aLocalização de spawn setado!");
						locmob.put(EntityType.CAVE_SPIDER, p.getLocation());
					}
					if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Slime")) {
						p.getOpenInventory().close();
						p.sendMessage("§aLocalização de spawn setado!");
						locmob.put(EntityType.SLIME, p.getLocation());
					}
					if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Cubo")) {
						p.getOpenInventory().close();
						p.sendMessage("§aLocalização de spawn setado!");
						locmob.put(EntityType.MAGMA_CUBE, p.getLocation());
					}
					if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Porco")) {
						p.getOpenInventory().close();
						p.sendMessage("§aLocalização de spawn setado!");
						locmob.put(EntityType.PIG_ZOMBIE, p.getLocation());
					}
					if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Enderman")) {
						p.getOpenInventory().close();
						p.sendMessage("§aLocalização de spawn setado!");
						locmob.put(EntityType.ENDERMAN, p.getLocation());
					}
					if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Wither")) {
						p.getOpenInventory().close();
						p.sendMessage("§aLocalização de spawn setado!");
						locmob.put(EntityType.WITHER, p.getLocation());
					}
				}
			}
		}
	}

	@EventHandler
	public void aoSpawnar(SpawnerSpawnEvent e) {
		
		if(locmob.containsKey(EntityType.CHICKEN)) {
			if (e.getEntity().getType() == EntityType.CHICKEN) {
				if (e.getSpawner().getLocation().getChunk() == locmob.get(EntityType.CHICKEN).getChunk()) {
				e.getEntity().teleport(locmob.get(EntityType.CHICKEN));
			}
			}
		}
		if(locmob.containsKey(EntityType.SHEEP)) {
			if (e.getEntity().getType() == EntityType.SHEEP) {
				if (e.getSpawner().getLocation().getChunk() == locmob.get(EntityType.SHEEP).getChunk()) {
				e.getEntity().teleport(locmob.get(EntityType.SHEEP));
			}
			}
		}
		if(locmob.containsKey(EntityType.CAVE_SPIDER)) {
			if (e.getEntity().getType() == EntityType.CAVE_SPIDER) {
				if (e.getSpawner().getLocation().getChunk() == locmob.get(EntityType.CAVE_SPIDER).getChunk()) {
				e.getEntity().teleport(locmob.get(EntityType.CAVE_SPIDER));
			}
			}
		}
		if(locmob.containsKey(EntityType.SLIME)) {
			if (e.getEntity().getType() == EntityType.SLIME) {
				if (e.getSpawner().getLocation().getChunk() == locmob.get(EntityType.SLIME).getChunk()) {
				e.getEntity().teleport(locmob.get(EntityType.SLIME));
			}
		}
		}
		if(locmob.containsKey(EntityType.MAGMA_CUBE)) {
			if (e.getEntity().getType() == EntityType.MAGMA_CUBE) {
				if (e.getSpawner().getLocation().getChunk() == locmob.get(EntityType.MAGMA_CUBE).getChunk()) {
				e.getEntity().teleport(locmob.get(EntityType.MAGMA_CUBE));
			}
		}
		}
		if(locmob.containsKey(EntityType.PIG_ZOMBIE)) {
			if (e.getEntity().getType() == EntityType.PIG_ZOMBIE) {
				if (e.getSpawner().getLocation().getChunk() == locmob.get(EntityType.PIG_ZOMBIE).getChunk()) {
				e.getEntity().teleport(locmob.get(EntityType.PIG_ZOMBIE));
			}
			}
		}
		if(locmob.containsKey(EntityType.ENDERMAN)) {
			if (e.getEntity().getType() == EntityType.ENDERMAN) {
				if (e.getSpawner().getLocation().getChunk() == locmob.get(EntityType.ENDERMAN).getChunk()) {
				e.getEntity().teleport(locmob.get(EntityType.ENDERMAN));
			}
			}
		}
		if(locmob.containsKey(EntityType.WITHER)) {
			if (e.getEntity().getType() == EntityType.WITHER) {
				if (e.getSpawner().getLocation().getChunk() == locmob.get(EntityType.WITHER).getChunk()) {
				e.getEntity().teleport(locmob.get(EntityType.WITHER));
			}
		}
		}
		
	}
	
	@EventHandler
	public void seguir(EntityTargetEvent e) {
		if(e.getEntityType() != EntityType.PLAYER) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void slimePequeno(CreatureSpawnEvent e) {
		if(e.getEntityType() == EntityType.SLIME) {
			Slime slime = (Slime) e.getEntity();
			slime.setSize(1);
		}
	}
	
}
