package me.ninjay.upsoulth.cash;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.upsoulth.main.Main;
import net.eduard.api.lib.modules.VaultAPI;

public class EventosLoja implements Listener {

	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		ItemStack vinesm = Mine.newItem(Material.IRON_INGOT, "§2§lVines §emensal", 1, 0, "§fValor: §e5 Cash");
		ItemStack vinese = Mine.newItem(Material.IRON_BLOCK, "§2§lVines §eeterno", 1, 0, "§fValor: §e20 Cash");

		ItemStack soulthm = Mine.newItem(Material.GOLD_INGOT, "§6§lSoulth §emensal", 1, 0, "§fValor: §e10 Cash");
		ItemStack soulthe = Mine.newItem(Material.GOLD_BLOCK, "§6§lSoulth §eeterno", 1, 0, "§fValor: §e25 Cash");

		ItemStack junglem = Mine.newItem(Material.DIAMOND, "§b§lJungle §emensal", 1, 0, "§fValor: §e30 Cash");
		ItemStack junglee = Mine.newItem(Material.DIAMOND_BLOCK, "§b§lJungle §eeterno", 1, 0, "§fValor: §e50 Cash");

		ItemStack flowersm = Mine.newItem(Material.EMERALD, "§a§lFlowers §emensal", 1, 0, "§fValor: §e40 Cash");
		ItemStack flowerse = Mine.newItem(Material.EMERALD_BLOCK, "§a§lFlowers §eeterno", 1, 0, "§fValor: §e80 Cash");

		if (e.getInventory().getTitle().equals("Shop De Cash")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(vinesm)) {
				if (Main.cash.getDouble(p.getName()) >= 5.0) {
					VaultAPI.getPermission().playerAddGroup(p, "vines");
					p.getOpenInventory().close();
					Main.cash.set(p.getName(), Main.cash.getDouble(p.getName()) - 5.0);
					Main.cash.saveConfig();
					Mine.sendTitle(p, "§6" + p.getName(), "§eAdquiriu o vip §2[Vines]", 20, 100, 20);
					new BukkitRunnable() {
						int contagem = 2592000;

						@Override
						public void run() {
							contagem--;
							if (contagem == 0) {
								p.sendMessage("§eO tempo do seu vip acabou, compre outro em nosso site.");
								VaultAPI.getPermission().playerRemoveGroup(p, "vines");
							}
						}
					}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
				} else {
					p.sendMessage("§eVocê não tem cash suficiente.");
					return;
				}
			}

			if (e.getInventory().getTitle().equals("Shop De Cash")) {
				e.setCancelled(true);
				if (e.getCurrentItem().isSimilar(vinese)) {
					if (Main.cash.getDouble(p.getName()) >= 20.0) {
						VaultAPI.getPermission().playerAddGroup(p, "vines");
						p.getOpenInventory().close();
						Main.cash.set(p.getName(), Main.cash.getDouble(p.getName()) - 20.0);
						Main.cash.saveConfig();
						Mine.sendTitle(p, "§6" + p.getName(), "§eAdquiriu o vip §2[Vines]", 20, 100, 20);
						new BukkitRunnable() {
							int contagem = 999999999*999999999;

							@Override
							public void run() {
								contagem--;
								if (contagem == 0) {
									p.sendMessage(
											"§eO tempo do seu vip acabou, compre outro em nosso site.");
									VaultAPI.getPermission().playerRemoveGroup(p, "flowers");
								}
							}
						}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);					
					} else {
						p.sendMessage("§eVocê não tem cash suficiente.");
						return;
					}
				}
				if (e.getInventory().getTitle().equals("Shop De Cash")) {
					e.setCancelled(true);
					if (e.getCurrentItem().isSimilar(soulthm)) {
						if (Main.cash.getDouble(p.getName()) >= 10.0) {
							VaultAPI.getPermission().playerAddGroup(p, "soulth");
							p.getOpenInventory().close();
							Main.cash.set(p.getName(), Main.cash.getDouble(p.getName()) - 20.0);
							Main.cash.saveConfig();
							Mine.sendTitle(p, "§6" + p.getName(), "§eAdquiriu o vip §6[Soulth]", 20, 100, 20);
							new BukkitRunnable() {
								int contagem = 2592000;

								@Override
								public void run() {
									contagem--;
									if (contagem == 0) {
										p.sendMessage("§eO tempo do seu vip acabou, compre outro em nosso site.");
										VaultAPI.getPermission().playerRemoveGroup(p, "soulth");
									}
								}
							}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
						} else {
							p.sendMessage("§eVocê não tem cash suficiente.");
							return;
						}
					}
					if (e.getInventory().getTitle().equals("Shop De Cash")) {
						e.setCancelled(true);
						if (e.getCurrentItem().isSimilar(soulthe)) {
							if (Main.cash.getDouble(p.getName()) >= 25.0) {
								VaultAPI.getPermission().playerAddGroup(p, "soulth");
								p.getOpenInventory().close();
								Main.cash.set(p.getName(), Main.cash.getDouble(p.getName()) - 25.0);
								Main.cash.saveConfig();
								Mine.sendTitle(p, "§6" + p.getName(), "§eAdquiriu o vip §6[Soulth]", 20, 100, 20);
								new BukkitRunnable() {
									int contagem = 999999999*999999999;

									@Override
									public void run() {
										contagem--;
										if (contagem == 0) {
											p.sendMessage(
													"§eO tempo do seu vip acabou, compre outro em nosso site.");
											VaultAPI.getPermission().playerRemoveGroup(p, "flowers");
										}
									}
								}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
							} else {
								p.sendMessage("§eVocê não tem cash suficiente.");
								return;
							}
						}
						if (e.getInventory().getTitle().equals("Shop De Cash")) {
							e.setCancelled(true);
							if (e.getCurrentItem().isSimilar(junglem)) {
								if (Main.cash.getDouble(p.getName()) >= 30.0) {
									VaultAPI.getPermission().playerAddGroup(p, "jungle");
									p.getOpenInventory().close();
									Main.cash.set(p.getName(), Main.cash.getDouble(p.getName()) - 30.0);
									Main.cash.saveConfig();
									Mine.sendTitle(p, "§6" + p.getName(), "§eAdquiriu o vip §b[Jungle]", 20, 100, 20);
									new BukkitRunnable() {
										int contagem = 2592000;

										@Override
										public void run() {
											contagem--;
											if (contagem == 0) {
												p.sendMessage(
														"§eO tempo do seu vip acabou, compre outro em nosso site.");
												VaultAPI.getPermission().playerRemoveGroup(p, "jungle");
											}
										}
									}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
								} else {
									p.sendMessage("§eVocê não tem cash suficiente.");
									return;
								}
							}
							if (e.getInventory().getTitle().equals("Shop De Cash")) {
								e.setCancelled(true);
								if (e.getCurrentItem().isSimilar(junglee)) {
									if (Main.cash.getDouble(p.getName()) >= 30.0) {

										VaultAPI.getPermission().playerAddGroup(p, "jungle");
										p.getOpenInventory().close();
										Main.cash.set(p.getName(), Main.cash.getDouble(p.getName()) - 50.0);
										Main.cash.saveConfig();
										Mine.sendTitle(p, "§6" + p.getName(), "§eAdquiriu o vip §b[Jungle]", 20, 100,
												20);
										new BukkitRunnable() {
											int contagem = 999999999*999999999;

											@Override
											public void run() {
												contagem--;
												if (contagem == 0) {
													p.sendMessage(
															"§eO tempo do seu vip acabou, compre outro em nosso site.");
													VaultAPI.getPermission().playerRemoveGroup(p, "flowers");
												}
											}
										}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
									} else {
										p.sendMessage("§eVocê não tem cash suficiente.");
										return;

									}

								}
							}
						}
						if (e.getInventory().getTitle().equals("Shop De Cash")) {
							e.setCancelled(true);
							if (e.getCurrentItem().isSimilar(flowersm)) {
								if (Main.cash.getDouble(p.getName()) >= 40.0) {
									VaultAPI.getPermission().playerAddGroup(p, "flowers");
									p.getOpenInventory().close();
									Main.cash.set(p.getName(), Main.cash.getDouble(p.getName()) - 5.0);
									Main.cash.saveConfig();
									Mine.sendTitle(p, "§6" + p.getName(), "§eAdquiriu o vip §a[Flowers]", 20, 100, 20);
									new BukkitRunnable() {
										int contagem = 2592000;

										@Override
										public void run() {
											contagem--;
											if (contagem == 0) {
												p.sendMessage(
														"§eO tempo do seu vip acabou, compre outro em nosso site.");
												VaultAPI.getPermission().playerRemoveGroup(p, "flowers");
											}
										}
									}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
								} else {
									p.sendMessage("§eVocê não tem cash suficiente.");
									return;
								}
							}

							if (e.getInventory().getTitle().equals("Shop De Cash")) {
								e.setCancelled(true);
								if (e.getCurrentItem().isSimilar(flowerse)) {
									if (Main.cash.getDouble(p.getName()) >= 80.0) {
										VaultAPI.getPermission().playerAddGroup(p, "flowers");
										p.getOpenInventory().close();
										Main.cash.set(p.getName(), Main.cash.getDouble(p.getName()) - 80.0);
										Main.cash.saveConfig();
										Mine.sendTitle(p, "§6" + p.getName(), "§eAdquiriu o vip §a[Flowers]", 20, 100, 20);
										new BukkitRunnable() {
											int contagem = 999999999*999999999;

											@Override
											public void run() {
												contagem--;
												if (contagem == 0) {
													p.sendMessage(
															"§eO tempo do seu vip acabou, compre outro em nosso site.");
													VaultAPI.getPermission().playerRemoveGroup(p, "flowers");
												}
											}
										}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
									} else {
										p.sendMessage("§eVocê não tem cash suficiente.");
										return;
									}
								}

							}

						}

					}

				}
			}
		}
	}
}
