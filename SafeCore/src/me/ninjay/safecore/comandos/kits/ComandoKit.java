package me.ninjay.safecore.comandos.kits;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.safecore.estruturas.kits.Kits;
import me.ninjay.safecore.estruturas.kits.KitsAPI;
import me.ninjay.safecore.main.Main;
import me.ninjay.safecore.utils.BukkitConfig;
import me.ninjay.safecore.utils.Mine;

public class ComandoKit implements CommandExecutor, Listener {

	public static BukkitConfig config = new BukkitConfig("cooldown.yml", Main.getPlugin(Main.class));

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			Inventory inv = Mine.newInventory("Kits", 9 * 3);
			if (args.length == 0) {
				
				if(KitsAPI.manager.getKitPorId(1).getIcone() != null) {
					ItemStack item1 = KitsAPI.manager.getKitPorId(1).getIcone();
				inv.setItem(Mine.getPosition(2, KitsAPI.manager.getKitPorId(1).getSlotIcone()), item1);
				}else {
					return true;
				}
				if(KitsAPI.manager.getKitPorId(2).getIcone() != null) {
					ItemStack item2 = KitsAPI.manager.getKitPorId(2).getIcone();
				inv.setItem(Mine.getPosition(2, KitsAPI.manager.getKitPorId(2).getSlotIcone()), item2);
				}else {
					return true;
				}
				if(KitsAPI.manager.getKitPorId(3).getIcone() != null) {
					ItemStack item3 = KitsAPI.manager.getKitPorId(3).getIcone();
				inv.setItem(Mine.getPosition(2, KitsAPI.manager.getKitPorId(3).getSlotIcone()), item3);
				}else {
					return true;
				}
				if(KitsAPI.manager.getKitPorId(4).getIcone() != null) {
					ItemStack item4 = KitsAPI.manager.getKitPorId(4).getIcone();
				inv.setItem(Mine.getPosition(2, KitsAPI.manager.getKitPorId(4).getSlotIcone()), item4);
				}else {
					return true;
				}
				p.openInventory(inv);
				return true;
			}
			for (Kits kit : KitsAPI.manager.getKits()) {
				if (kit.getName().equalsIgnoreCase(args[0])) {
					if (kit != null) {
						if (p.hasPermission(kit.getPerm())) {
							if (config.contains("Cooldown" + kit.getName() + "." + p.getName())) {
								long tempo = config.getLong("Cooldown" + kit.getName() + "." + p.getName());
								long resultado = Mine.getCooldown(tempo, kit.getCooldown());

								if (Mine.inCooldown(tempo, kit.getCooldown())) {

									p.sendMessage(
											"§cAguarde " + Mine.formatTime(resultado) + " §cpara coletar seu kit.");
									return true;
								}
							}
							// p.sendmessage("vc entrou no cooldown");
							for (ItemStack itens : kit.getItens()) {
								p.getInventory().addItem(itens);
							}
							p.sendMessage("§aKit " + kit.getName() + " coletado.");
							config.set("Cooldown" + kit.getName() + "." + p.getName(), System.currentTimeMillis());
							config.saveConfig();
							return true;
						} else {
							p.sendMessage("§cSem permissão.");
						}
					}
				}
			}
		}
		return false;
	}

	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equalsIgnoreCase("Kits")) {
			e.setCancelled(true);
			for (Kits kit : KitsAPI.manager.getKits()) {
				if (e.getCurrentItem().isSimilar(kit.getIcone())) {
					if (e.getClick() == ClickType.LEFT) {
						p.getOpenInventory().close();
						p.chat("/kit " + kit.getName());
						return;
					}
					if (e.getClick() == ClickType.RIGHT) {
						Inventory inv = Mine.newInventory("Kit " + kit.getName(), 9 * 6);
						Mine.rodarInventario(inv, Mine.newItem(" ", Material.STAINED_GLASS_PANE, 8));
						for (ItemStack itens : kit.getItens()) {
							inv.addItem(itens);
							p.getOpenInventory().close();
							p.openInventory(inv);
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void aoClicar2(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		for (Kits kit : KitsAPI.manager.getKits()) {
			if (e.getInventory().getTitle().contains(kit.getName())) {
				e.setCancelled(true);
			}
		}
	}

}
