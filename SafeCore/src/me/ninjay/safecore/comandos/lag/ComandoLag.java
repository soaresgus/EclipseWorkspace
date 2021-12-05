package me.ninjay.safecore.comandos.lag;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.safecore.main.Main;
import me.ninjay.safecore.utils.Mine;

public class ComandoLag implements CommandExecutor, Listener {

	public static ItemStack cd = Mine.newItem(Material.LAVA_BUCKET, "§eLimpar drops do mundo");
	public static ItemStack cm = Mine.newItem(Material.DIAMOND_SWORD, "§eLimpar mobs do mundo");
	public static ItemStack cda = Mine.newItem(Material.ENDER_PEARL, "§eAtivar ClearDrops");
	public static ItemStack cdd = Mine.newItem(Material.ENDER_PEARL, "§eDesativar ClearDrops");
	public static ItemStack rn = Mine.newItem(Material.EMERALD, "§eReiniciar servidor", 1, 0, " ",
			"§7Clique com o §7§lbotão esquerdo §7para um reinicio temporizado.",
			"§7Clique com o §7§lbotão direito §7para um reinicio instantâneo");
	public static boolean ClearDrops = false;
	public static ArrayList<Player> list = new ArrayList<>();
	public static boolean reiniciando = false;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			Inventory inv = Mine.newInventory("Anti Lag", 9 * 3);

			inv.setItem(Mine.getPosition(2, 2), cd);
			inv.setItem(Mine.getPosition(2, 4), cm);
			inv.setItem(Mine.getPosition(2, 8), rn);
			if (ClearDrops == true) {
				inv.setItem(Mine.getPosition(2, 6), cdd);
			} else {
				inv.setItem(Mine.getPosition(2, 6), cda);
			}
			if (p.hasPermission("lag.perm")) {
				p.openInventory(inv);
			}else {
				p.sendMessage("§cSem permissão.");
			}
		}
		return false;
	}

	public static void ativarClearDrops(Player p) {
		new BukkitRunnable() {
			int i = Main.config.getInt("TempoClearDrops");

			@Override
			public void run() {
				if (ClearDrops == true) {
					i--;
					if (i == 0) {
						i = Main.config.getInt("TempoClearDrops");
						for (Item drops : p.getWorld().getEntitiesByClass(Item.class)) {
							drops.remove();
						}
					}
				} else if (ClearDrops == false) {
					cancel();
					i = Main.config.getInt("TempoClearDrops");
				}
			}
		}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
	}

	@EventHandler
	public static void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equalsIgnoreCase("Anti Lag")) {
			e.setCancelled(true);
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().isSimilar(cd)) {
					p.getOpenInventory().close();
					p.sendMessage("§eDrops do mundo excluidos.");
					for (Item drops : p.getWorld().getEntitiesByClass(Item.class)) {
						drops.remove();
					}
				}
				if (e.getCurrentItem().isSimilar(cm)) {
					p.getOpenInventory().close();
					p.sendMessage("§eMobs do mundo excluidos.");
					for (LivingEntity mobs : p.getWorld().getLivingEntities()) {
						if (!(mobs instanceof Player)) {
							mobs.remove();
						}
					}
				}
				if (e.getCurrentItem().isSimilar(cda)) {
					p.getOpenInventory().close();
					p.sendMessage(
							"§eDigite o tempo que você deseja no ClearDrops.\n \n§7Caso queira cancelar digite 'cancelar'");
					list.add(p);
				}
				if (e.getCurrentItem().isSimilar(cdd)) {
					p.getOpenInventory().close();
					p.sendMessage("§eClearDrops desativado.");
					ClearDrops = false;
				}
				if (e.getCurrentItem().isSimilar(rn)) {
					if (e.getClick() == ClickType.LEFT) {
						p.getOpenInventory().close();
						p.sendMessage("§eReinicio iniciado.");
						reiniciando = true;
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.teleport(Main.config.getLocation("spawn"));
						}
						for (int i = 0; i < 100; i++) {
							Bukkit.broadcastMessage(" ");
						}
						Bukkit.broadcastMessage(
								"§e§lO servidor será reiniciado em 30 segundos.\n \n§eAlgumas funções foram desativadas durante o reincio.");
						p.getWorld().save();
						for (LivingEntity mobs : p.getWorld().getLivingEntities()) {
							if (!(mobs instanceof Player)) {
								mobs.remove();
							}
							for (Item drops : p.getWorld().getEntitiesByClass(Item.class)) {
								drops.remove();
							}
						}
						new BukkitRunnable() {
							int i = 30;

							@Override
							public void run() {
								i--;
								Mine.sendTitle("§e§lREINICIANDO", "§eReiniciando o servidor em " + i + " segundos", 1,
										20, 1);
								if (i == 0) {
									cancel();
									for (Player todos : Bukkit.getOnlinePlayers()) {
										todos.kickPlayer("§c§lSAFE CLUB\n \n§c    Servidor reiniciando...");
									}
									Bukkit.getServer().reload();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					if (e.getClick() == ClickType.RIGHT) {
						p.getOpenInventory().close();
						p.sendMessage("§eReinicio iniciado.");
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.teleport(Main.config.getLocation("spawn"));
						}
						reiniciando = true;
						for (int i = 0; i < 100; i++) {
							Bukkit.broadcastMessage(" ");
						}
						Bukkit.broadcastMessage(
								"§e§lO servidor será reiniciado em 5 segundos.\n \n§eAlgumas funções foram desativadas durante o reincio.");
						p.getWorld().save();
						for (LivingEntity mobs : p.getWorld().getLivingEntities()) {
							if (!(mobs instanceof Player)) {
								mobs.remove();
							}
							for (Item drops : p.getWorld().getEntitiesByClass(Item.class)) {
								drops.remove();
							}
						}
						new BukkitRunnable() {
							int i = 5;

							@Override
							public void run() {
								i--;
								Mine.sendTitle("§e§lREINICIANDO", "§eReiniciando o servidor em " + i + " segundos", 1,
										20, 1);
								if (i == 0) {
									cancel();
									for (Player todos : Bukkit.getOnlinePlayers()) {
										todos.kickPlayer("§c§lSAFE CLUB\n \n§c    Servidor reiniciando...");
									}
									Bukkit.getServer().reload();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
				}
			}
		}
	}

	@EventHandler
	public static void aoConectar(PlayerLoginEvent e) {
		if (reiniciando == true) {
			e.getPlayer().kickPlayer("§c§lSAFE CLUB\n \n§c    Servidor reiniciando...");
		}
	}

	@EventHandler
	public static void aoInterarir(PlayerInteractEvent e) {
		if (reiniciando == true) {
			e.setCancelled(true);
			e.getPlayer().sendMessage("§cAções desativadas durante o reinício.");
		}
	}

	@EventHandler
	public static void aoFalar(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();

		if (list.contains(p)) {
			e.setCancelled(true);
			if (StringUtils.isNumeric(e.getMessage())) {
				p.sendMessage("\n \n§eTempo do ClearDrops defindo para §a§l" + e.getMessage() + "§e.");
				ClearDrops = true;
				Main.config.set("TempoClearDrops", Mine.toInt(e.getMessage()));
				Main.config.saveConfig();
				list.remove(p);
				ativarClearDrops(p);
			} else {
				p.sendMessage("§cApenas números são permitidos, caso queira cancelar a ação digite 'cancelar'.");
			}
			if (e.getMessage().equalsIgnoreCase("cancelar")) {
				list.remove(p);
				p.sendMessage("\n \n§cAção cancelada.");
			}
		}
	}
}
