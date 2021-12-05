package me.ninjay.saferankup.comandos;

import org.bukkit.Color;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.saferankup.estruturas.Rank;
import me.ninjay.saferankup.estruturas.RankAPI;
import me.ninjay.saferankup.estruturas.SimplesScore;
import me.ninjay.saferankup.main.Main;
import me.ninjay.saferankup.utils.BukkitConfig;
import me.ninjay.saferankup.utils.Mine;
import me.ninjay.saferankup.utils.VaultAPI;

public class ComandoRankUP implements CommandExecutor, Listener {

	public static BukkitConfig config = new BukkitConfig("playerRanks.yml", Main.getPlugin(Main.class));

	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (!config.contains(p.getName())) {
			config.set(p.getName(), 1);
			config.saveConfig();
		} else {
			return;
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;

			Rank proxRank = RankAPI.manager.getRankPorId(config.getInt(p.getName()) + 1);

			Inventory menu = Mine.newInventory("Confirmar ação", 9 * 3);

			ItemStack sim = Mine.newItem(Material.WOOL, "§aConfirmar ação", 1, 5);
			ItemStack nao = Mine.newItem(Material.WOOL, "§cCancelar ação", 1, 14);

		if(proxRank != null) {
			menu.setItem(Mine.getPosition(2, 5), proxRank.getIcon());
			menu.setItem(Mine.getPosition(2, 3), sim);
			menu.setItem(Mine.getPosition(2, 7), nao);

			p.openInventory(menu);
		}else {
			p.sendMessage("§cVocê atingiu o último rank!");
		}
		}
		return false;
	}

	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		ItemStack sim = Mine.newItem(Material.WOOL, "§aConfirmar ação", 1, 5);
		ItemStack nao = Mine.newItem(Material.WOOL, "§cCancelar ação", 1, 14);
		
		if(e.getInventory().getTitle().contains("Confirmar ação")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().isSimilar(nao)) {
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().isSimilar(sim)) {
						Rank proxRank = RankAPI.manager.getRankPorId(config.getInt(p.getName()) + 1);
						if(VaultAPI.getEconomy().has(p, proxRank.getValor())) {
						VaultAPI.getEconomy().withdrawPlayer(p, proxRank.getValor());
						p.getOpenInventory().close();
						p.sendMessage("§aSeu rank foi evoluido para §e"+proxRank.getName());
						Location loc = p.getLocation();
						loc.setY(p.getLocation().getY()-1);
						Mine.newFirework(loc, 0, Color.RED, Color.ORANGE, false, false, Type.BALL_LARGE);
						Mine.sendActionBar("§a"+p.getName()+" evoluiu para o rank §e"+proxRank.getName());
						config.set(p.getName(), proxRank.getId());
						config.saveConfig();
						SimplesScore.atualizar(p);
						SimplesScore.setScore(p);
					}else {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê não tem o valor necessário.");
					}
					}
				}
			}
		}
	}
	
}
