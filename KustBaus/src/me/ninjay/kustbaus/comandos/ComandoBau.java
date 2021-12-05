package me.ninjay.kustbaus.comandos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.kustbaus.main.Main;
import me.ninjay.kustbaus.utils.Mine;
import me.ninjay.kustcash.estruturas.CashAPI;
import me.ninjay.kustlogs.estruturas.LogsAPI;

public class ComandoBau implements CommandExecutor, Listener{
	
	public static void bau(Player p, String id, Inventory menu, Integer slot) {
	String bau = "bau"+id;

	if(Main.pchest.getBoolean(p.getName()+"."+bau+".ativo") == true) {
		if(Main.pchest.getBoolean(p.getName()+"."+bau+".extendido") == true) {
			if(Main.pchest.getItemStack(p.getName()+"."+bau+".icone") != null) {
				menu.setItem(slot, Mine.newItem(Material.CHEST, "§aBau #"+id, 1, 0, "§e/bau "+id, " ", "§7Baú extendido!", " ", "§7Botão esqurdo: §fAbrir baú", "§7Botão direito: §fOpções"));
			}else {
				menu.setItem(slot, Mine.newItem(Material.CHEST, "§aBau #"+id, 1, 0, "§e/bau "+id, " ", "§7Baú extendido!", " ", "§7Botão esqurdo: §fAbrir baú", "§7Botão direito: §fOpções"));
			}
		}else {
			menu.setItem(slot, Mine.newItem(Material.CHEST, "§aBau #"+id, 1, 0, "§e/bau "+id, " ", "§7Baú básico!", " ", "§7Botão esqurdo: §fAbrir baú", "§7Botão direito: §fOpções"));
		}
	}else {
		return;
	}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;

			Inventory inicial = Mine.newInventory("Baús de "+p.getName(), 9*3);
			ItemStack echest = Mine.newItem(Material.ENDER_CHEST, "§eEnder Chest", 1, 0, " ", "§7Clique para abrir seu enderchest.");
			ItemStack comprar = Mine.newItem(Material.CHEST, "§eComprar baús", 1, 0, " ", " §fCusto: §a1.000 Cash");
			
			if(args.length == 0) {
				bau(p, "1", inicial, Mine.getPosition(2, 3));
				bau(p, "2", inicial, Mine.getPosition(2, 4));
				bau(p, "3", inicial, Mine.getPosition(2, 5));
				bau(p, "4", inicial, Mine.getPosition(2, 6));
				bau(p, "5", inicial, Mine.getPosition(2, 7));
				inicial.setItem(Mine.getPosition(3, 4), echest);
				inicial.setItem(Mine.getPosition(3, 6), comprar);
				p.openInventory(inicial);
				return true;
			}
			if(args[0].equalsIgnoreCase("1")) {
				if(Main.pchest.getBoolean(p.getName()+".bau1.ativo") == true) {
				if(Main.pchest.getBoolean(p.getName()+".bau1.extendido") == false) {
					Inventory bau1 = Mine.newInventory("Baú 1", 9*3);
					if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau1") != null) {
						List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau1.itens");
						List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau1.slots");
					if(itens != null && slots != null) {
						int i = 0;
						for(ItemStack item : itens) {
							if(item != null) {
								bau1.setItem(slots.get(i), item);
							}
							i++;
						}
					}
					}
					p.openInventory(bau1);
				}else {
					Inventory bau1 = Mine.newInventory("Baú 1", 9*6);
					if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau1") != null) {
						List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau1.itens");
						List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau1.slots");
					if(itens != null && slots != null) {
						int i = 0;
						for(ItemStack item : itens) {
							if(item != null) {
								bau1.setItem(slots.get(i), item);
							}
							i++;
						}
					}
					}
					p.openInventory(bau1);
				}
				}else {
					p.sendMessage("§cVocê não possuí o baú 1.");
				}
			}
			if(args[0].equalsIgnoreCase("2")) {
				if(Main.pchest.getBoolean(p.getName()+".bau2.ativo") == true) {
				if(Main.pchest.getBoolean(p.getName()+".bau2.extendido") == false) {
					Inventory bau2 = Mine.newInventory("Baú 2", 9*3);
					if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau2") != null) {
						List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau2.itens");
						List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau2.slots");
					if(itens != null && slots != null) {
						int i = 0;
						for(ItemStack item : itens) {
							if(item != null) {
								bau2.setItem(slots.get(i), item);
							}
							i++;
						}
					}
					}
					p.openInventory(bau2);
				}else {
					Inventory bau2 = Mine.newInventory("Baú 2", 9*6);
					if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau2") != null) {
						List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau2.itens");
						List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau2.slots");
					if(itens != null && slots != null) {
						int i = 0;
						for(ItemStack item : itens) {
							if(item != null) {
								bau2.setItem(slots.get(i), item);
							}
							i++;
						}
					}
					}
					p.openInventory(bau2);
				}
				}else {
					p.sendMessage("§cVocê não possuí o baú 2.");
				}
			}
			if(args[0].equalsIgnoreCase("3")) {
				if(Main.pchest.getBoolean(p.getName()+".bau3.ativo") == true) {
				if(Main.pchest.getBoolean(p.getName()+".bau3.extendido") == false) {
					Inventory bau3 = Mine.newInventory("Baú 3", 9*3);
					if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau3") != null) {
						List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau3.itens");
						List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau3.slots");
					if(itens != null && slots != null) {
						int i = 0;
						for(ItemStack item : itens) {
							if(item != null) {
								bau3.setItem(slots.get(i), item);
							}
							i++;
						}
					}
					}
					p.openInventory(bau3);
				}else {
					Inventory bau3 = Mine.newInventory("Baú 3", 9*6);
					if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau3") != null) {
						List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau3.itens");
						List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau3.slots");
					if(itens != null && slots != null) {
						int i = 0;
						for(ItemStack item : itens) {
							if(item != null) {
								bau3.setItem(slots.get(i), item);
							}
							i++;
						}
					}
					}
					p.openInventory(bau3);
				}
				}else {
					p.sendMessage("§cVocê não possuí o baú 3.");
				}
			}
			if(args[0].equalsIgnoreCase("4")) {
				if(Main.pchest.getBoolean(p.getName()+".bau4.ativo") == true) {
				if(Main.pchest.getBoolean(p.getName()+".bau4.extendido") == false) {
					Inventory bau4 = Mine.newInventory("Baú 4", 9*3);
					if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau4") != null) {
						List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau4.itens");
						List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau4.slots");
					if(itens != null && slots != null) {
						int i = 0;
						for(ItemStack item : itens) {
							if(item != null) {
								bau4.setItem(slots.get(i), item);
							}
							i++;
						}
					}
					}
					p.openInventory(bau4);
				}else {
					Inventory bau4 = Mine.newInventory("Baú 4", 9*6);
					if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau4") != null) {
						List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau4.itens");
						List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau4.slots");
					if(itens != null && slots != null) {
						int i = 0;
						for(ItemStack item : itens) {
							if(item != null) {
								bau4.setItem(slots.get(i), item);
							}
							i++;
						}
					}
					}
					p.openInventory(bau4);
				}
				}else {
					p.sendMessage("§cVocê não possuí o baú 4.");
				}
			}
			if(args[0].equalsIgnoreCase("5")) {
				if(Main.pchest.getBoolean(p.getName()+".bau5.ativo") == true) {
				if(Main.pchest.getBoolean(p.getName()+".bau5.extendido") == false) {
					Inventory bau5 = Mine.newInventory("Baú 5", 9*3);
					if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau5") != null) {
						List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau5.itens");
						List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau5.slots");
					if(itens != null && slots != null) {
						int i = 0;
						for(ItemStack item : itens) {
							if(item != null) {
								bau5.setItem(slots.get(i), item);
							}
							i++;
						}
					}
					}
					p.openInventory(bau5);
				}else {
					Inventory bau5 = Mine.newInventory("Baú 5", 9*6);
					if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau5") != null) {
						List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau5.itens");
						List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau5.slots");
					if(itens != null && slots != null) {
						int i = 0;
						for(ItemStack item : itens) {
							if(item != null) {
								bau5.setItem(slots.get(i), item);
							}
							i++;
						}
					}
					}
					p.openInventory(bau5);
				}
			}else {
				p.sendMessage("§cVocê não possuí o baú 5.");
			}
			}
		}
		return false;
	}
	
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equals("Baús de "+p.getName())) {
			e.setCancelled(true);
		if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getItemMeta() != null) {
			if(e.getCurrentItem().getItemMeta().getLore().contains("§e/bau 1")) {
				if(e.getClick() == ClickType.LEFT) {
					if(Main.pchest.getBoolean(p.getName()+".bau1.extendido") == false) {
						Inventory bau1 = Mine.newInventory("Baú 1", 9*3);
						if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau1") != null) {
							List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau1.itens");
							List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau1.slots");
						if(itens != null && slots != null) {
							int i = 0;
							for(ItemStack item : itens) {
								if(item != null) {
									bau1.setItem(slots.get(i), item);
								}
								i++;
							}
						}
						}
						p.openInventory(bau1);
					}else {
						Inventory bau1 = Mine.newInventory("Baú 1", 9*6);
						if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau1") != null) {
							List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau1.itens");
							List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau1.slots");
						if(itens != null && slots != null) {
							int i = 0;
							for(ItemStack item : itens) {
								if(item != null) {
									bau1.setItem(slots.get(i), item);
								}
								i++;
							}
						}
						}
						p.openInventory(bau1);
					}
				}else {
					if(e.getClick() == ClickType.RIGHT) {
						Inventory menu = Mine.newInventory("Opções do baú", 9*3);
						ItemStack expandir = Mine.newItem(Material.ENDER_CHEST, "§eExpandir #1", 1, 0, "§7Baú completo!", " ", "§7Clique para comprar a expansão do baú", " ", "§7Custo: §a1.000 Cash");
						ItemStack expandirf = Mine.newItem(Material.ENDER_CHEST, "§eExpandir #1", 1, 0, "§7Baú completo!", " ", "§7Clique para comprar a expansão do baú", " ", "§7Custo: §a1.000 Cash", " ", "§cVocê não tem saldo suficiente.");
						
						if(Main.pchest.getBoolean(p.getName()+".bau1.extendido") == false) {
						if(CashAPI.hasCash(p.getName(), 1000)) {
							menu.setItem(Mine.getPosition(2, 5), expandir);
						}else {
							menu.setItem(Mine.getPosition(2, 5), expandirf);
						}
					}else {
						menu.setItem(Mine.getPosition(2, 5), Mine.newItem(Material.WEB, "§cEsse baú já está expandido."));
					}
						p.openInventory(menu);
					}
				}
			}

			if(e.getCurrentItem().getItemMeta().getLore().contains("§e/bau 2")) {
				if(e.getClick() == ClickType.LEFT) {
					if(Main.pchest.getBoolean(p.getName()+".bau2.extendido") == false) {
						Inventory bau2 = Mine.newInventory("Baú 2", 9*3);
						if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau2") != null) {
							List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau2.itens");
							List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau2.slots");
						if(itens != null && slots != null) {
							int i = 0;
							for(ItemStack item : itens) {
								if(item != null) {
									bau2.setItem(slots.get(i), item);
								}
								i++;
							}
						}
						}
						p.openInventory(bau2);
					}else {
						Inventory bau2 = Mine.newInventory("Baú 2", 9*6);
						if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau2") != null) {
							List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau2.itens");
							List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau2.slots");
						if(itens != null && slots != null) {
							int i = 0;
							for(ItemStack item : itens) {
								if(item != null) {
									bau2.setItem(slots.get(i), item);
								}
								i++;
							}
						}
						}
						p.openInventory(bau2);
					}
				}else {
					if(e.getClick() == ClickType.RIGHT) {
						Inventory menu = Mine.newInventory("Opções do baú", 9*3);
						ItemStack expandir = Mine.newItem(Material.ENDER_CHEST, "§eExpandir #2", 1, 0, "§7Baú completo!", " ", "§7Clique para comprar a expansão do baú", " ", "§7Custo: §a1.000 Cash");
						ItemStack expandirf = Mine.newItem(Material.ENDER_CHEST, "§eExpandir #2", 1, 0, "§7Baú completo!", " ", "§7Clique para comprar a expansão do baú", " ", "§7Custo: §a1.000 Cash", " ", "§cVocê não tem saldo suficiente.");
						
						if(Main.pchest.getBoolean(p.getName()+".bau2.extendido") == false) {
						if(CashAPI.hasCash(p.getName(), 1000)) {
							menu.setItem(Mine.getPosition(2, 5), expandir);
						}else {
							menu.setItem(Mine.getPosition(2, 5), expandirf);
						}
					}else {
						menu.setItem(Mine.getPosition(2, 5), Mine.newItem(Material.WEB, "§cEsse baú já está expandido."));
					}
						p.openInventory(menu);
					}
				}
			}

			if(e.getCurrentItem().getItemMeta().getLore().contains("§e/bau 3")) {
				if(e.getClick() == ClickType.LEFT) {
					if(Main.pchest.getBoolean(p.getName()+".bau3.extendido") == false) {
						Inventory bau3 = Mine.newInventory("Baú 3", 9*3);
						if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau3") != null) {
							List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau3.itens");
							List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau3.slots");
						if(itens != null && slots != null) {
							int i = 0;
							for(ItemStack item : itens) {
								if(item != null) {
									bau3.setItem(slots.get(i), item);
								}
								i++;
							}
						}
						}
						p.openInventory(bau3);
					}else {
						Inventory bau3 = Mine.newInventory("Baú 3", 9*6);
						if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau3") != null) {
							List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau3.itens");
							List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau3.slots");
						if(itens != null && slots != null) {
							int i = 0;
							for(ItemStack item : itens) {
								if(item != null) {
									bau3.setItem(slots.get(i), item);
								}
								i++;
							}
						}
						}
						p.openInventory(bau3);
					}
				}else {
					if(e.getClick() == ClickType.RIGHT) {
						Inventory menu = Mine.newInventory("Opções do baú", 9*3);
						ItemStack expandir = Mine.newItem(Material.ENDER_CHEST, "§eExpandir #3", 1, 0, "§7Baú completo!", " ", "§7Clique para comprar a expansão do baú", " ", "§7Custo: §a1.000 Cash");
						ItemStack expandirf = Mine.newItem(Material.ENDER_CHEST, "§eExpandir #3", 1, 0, "§7Baú completo!", " ", "§7Clique para comprar a expansão do baú", " ", "§7Custo: §a1.000 Cash", " ", "§cVocê não tem saldo suficiente.");
						
						if(Main.pchest.getBoolean(p.getName()+".bau3.extendido") == false) {
						if(CashAPI.hasCash(p.getName(), 1000)) {
							menu.setItem(Mine.getPosition(2, 5), expandir);
						}else {
							menu.setItem(Mine.getPosition(2, 5), expandirf);
						}
					}else {
						menu.setItem(Mine.getPosition(2, 5), Mine.newItem(Material.WEB, "§cEsse baú já está expandido."));
					}
						p.openInventory(menu);
					}
				}
			}

			if(e.getCurrentItem().getItemMeta().getLore().contains("§e/bau 4")) {
				if(e.getClick() == ClickType.LEFT) {
					if(Main.pchest.getBoolean(p.getName()+".bau4.extendido") == false) {
						Inventory bau4 = Mine.newInventory("Baú 4", 9*3);
						if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau4") != null) {
							List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau4.itens");
							List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau4.slots");
						if(itens != null && slots != null) {
							int i = 0;
							for(ItemStack item : itens) {
								if(item != null) {
									bau4.setItem(slots.get(i), item);
								}
								i++;
							}
						}
						}
						p.openInventory(bau4);
					}else {
						Inventory bau4 = Mine.newInventory("Baú 4", 9*6);
						if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau4") != null) {
							List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau4.itens");
							List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau4.slots");
						if(itens != null && slots != null) {
							int i = 0;
							for(ItemStack item : itens) {
								if(item != null) {
									bau4.setItem(slots.get(i), item);
								}
								i++;
							}
						}
						}
						p.openInventory(bau4);
					}
				}else {
					if(e.getClick() == ClickType.RIGHT) {
						Inventory menu = Mine.newInventory("Opções do baú", 9*3);
						ItemStack expandir = Mine.newItem(Material.ENDER_CHEST, "§eExpandir #4", 1, 0, "§7Baú completo!", " ", "§7Clique para comprar a expansão do baú", " ", "§7Custo: §a1.000 Cash");
						ItemStack expandirf = Mine.newItem(Material.ENDER_CHEST, "§eExpandir #4", 1, 0, "§7Baú completo!", " ", "§7Clique para comprar a expansão do baú", " ", "§7Custo: §a1.000 Cash", " ", "§cVocê não tem saldo suficiente.");
						
						if(Main.pchest.getBoolean(p.getName()+".bau4.extendido") == false) {
						if(CashAPI.hasCash(p.getName(), 1000)) {
							menu.setItem(Mine.getPosition(2, 5), expandir);
						}else {
							menu.setItem(Mine.getPosition(2, 5), expandirf);
						}
					}else {
						menu.setItem(Mine.getPosition(2, 5), Mine.newItem(Material.WEB, "§cEsse baú já está expandido."));
					}
						p.openInventory(menu);
					}
				}
			}

			if(e.getCurrentItem().getItemMeta().getLore().contains("§e/bau 5")) {
				if(e.getClick() == ClickType.LEFT) {
					if(Main.pchest.getBoolean(p.getName()+".bau5.extendido") == false) {
						Inventory bau5 = Mine.newInventory("Baú 5", 9*3);
						if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau5") != null) {
							List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau5.itens");
							List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau5.slots");
						if(itens != null && slots != null) {
							int i = 0;
							for(ItemStack item : itens) {
								if(item != null) {
									bau5.setItem(slots.get(i), item);
								}
								i++;
							}
						}
						}
						p.openInventory(bau5);
					}else {
						Inventory bau5 = Mine.newInventory("Baú 5", 9*6);
						if(Main.getPlugin(Main.class).getConfig().getString(p.getName()+".bau5") != null) {
							List<ItemStack> itens = (List<ItemStack>)Main.getPlugin(Main.class).getConfig().get(p.getName()+".bau5.itens");
							List<Integer> slots = Main.getPlugin(Main.class).getConfig().getIntegerList(p.getName()+".bau5.slots");
						if(itens != null && slots != null) {
							int i = 0;
							for(ItemStack item : itens) {
								if(item != null) {
									bau5.setItem(slots.get(i), item);
								}
								i++;
							}
						}
						}
						p.openInventory(bau5);
					}
				}else {
					if(e.getClick() == ClickType.RIGHT) {
						Inventory menu = Mine.newInventory("Opções do baú", 9*3);
						ItemStack expandir = Mine.newItem(Material.ENDER_CHEST, "§eExpandir #5", 1, 0, "§7Baú completo!", " ", "§7Clique para comprar a expansão do baú", " ", "§7Custo: §a1.000 Cash");
						ItemStack expandirf = Mine.newItem(Material.ENDER_CHEST, "§eExpandir #5", 1, 0, "§7Baú completo!", " ", "§7Clique para comprar a expansão do baú", " ", "§7Custo: §a1.000 Cash", " ", "§cVocê não tem saldo suficiente.");
						
					if(Main.pchest.getBoolean(p.getName()+".bau5.extendido") == false) {
						if(CashAPI.hasCash(p.getName(), 1000)) {
							menu.setItem(Mine.getPosition(2, 5), expandir);
						}else {
							menu.setItem(Mine.getPosition(2, 5), expandirf);
						}
					}else {
						menu.setItem(Mine.getPosition(2, 5), Mine.newItem(Material.WEB, "§cEsse baú já está expandido."));
					}
					p.openInventory(menu);
					}
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eEnder Chest")) {
				p.getOpenInventory().close();
				p.chat("/echest");
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eComprar baús")) {
				if(CashAPI.hasCash(p.getName(), 1000)) {
					if(Main.pchest.getBoolean(p.getName()+".bau1.ativo") == false) {
						p.getOpenInventory().close();
						CashAPI.removeCash(p.getName(), 1000);
						p.sendMessage("§aBaú 1 adquirido.");
						LogsAPI.register(p.getName(), p.getName()+" comprou o baú 1", me.ninjay.kustlogs.main.Main.playerGeral);
						Main.pchest.set(p.getName()+".bau1.ativo", true);
						Main.pchest.saveConfig();
						return;
					}else {
						if(Main.pchest.getBoolean(p.getName()+".bau2.ativo") == false) {
							p.getOpenInventory().close();
							CashAPI.removeCash(p.getName(), 1000);
							p.sendMessage("§aBaú 2 adquirido.");
							LogsAPI.register(p.getName(), p.getName()+" comprou o baú 2", me.ninjay.kustlogs.main.Main.playerGeral);
							Main.pchest.set(p.getName()+".bau2.ativo", true);
							Main.pchest.saveConfig();
							return;
						}else {
							if(Main.pchest.getBoolean(p.getName()+".bau3.ativo") == false) {
								p.getOpenInventory().close();
								CashAPI.removeCash(p.getName(), 1000);
								p.sendMessage("§aBaú 3 adquirido.");
								LogsAPI.register(p.getName(), p.getName()+" comprou o baú 3", me.ninjay.kustlogs.main.Main.playerGeral);
								Main.pchest.set(p.getName()+".bau3.ativo", true);
								Main.pchest.saveConfig();
								return;
							}else {
								if(Main.pchest.getBoolean(p.getName()+".bau4.ativo") == false) {
									p.getOpenInventory().close();
									CashAPI.removeCash(p.getName(), 1000);
									p.sendMessage("§aBaú 4 adquirido.");
									LogsAPI.register(p.getName(), p.getName()+" comprou o baú 4", me.ninjay.kustlogs.main.Main.playerGeral);
									Main.pchest.set(p.getName()+".bau4.ativo", true);
									Main.pchest.saveConfig();
									return;
								}else {
									if(Main.pchest.getBoolean(p.getName()+".bau5.ativo") == false) {
										p.getOpenInventory().close();
										CashAPI.removeCash(p.getName(), 1000);
										p.sendMessage("§aBaú 5 adquirido.");
										LogsAPI.register(p.getName(), p.getName()+" comprou o baú 5", me.ninjay.kustlogs.main.Main.playerGeral);
										Main.pchest.set(p.getName()+".bau5.ativo", true);
										Main.pchest.saveConfig();
										return;
									}else {
										p.getOpenInventory().close();
										p.sendMessage("§cVocê atingiu o número máximo de baús.");
									}
								}
							}
						}
					}
					
				}else {
					p.getOpenInventory().close();
					p.sendMessage("§cVocê não possuí saldo suficiente.");
				}
			}
			}
		}
		}
		if(e.getInventory().getTitle().equalsIgnoreCase("Opções do baú")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eExpandir #1")) {
						if(CashAPI.hasCash(p.getName(), 1000)) {
							p.getOpenInventory().close();
							p.sendMessage("§aBaú 1 foi expandido.");
							LogsAPI.register(p.getName(), p.getName()+" expandiu o baú 1", me.ninjay.kustlogs.main.Main.playerGeral);
							CashAPI.removeCash(p.getName(), 1000);
							Main.pchest.set(p.getName()+".bau1.extendido", true);
							Main.pchest.saveConfig();
						}else {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê não possuí saldo suficiente.");
						}
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eExpandir #2")) {
						if(CashAPI.hasCash(p.getName(), 1000)) {
							p.getOpenInventory().close();
							p.sendMessage("§aBaú 2 foi expandido.");
							LogsAPI.register(p.getName(), p.getName()+" expandiu o baú 2", me.ninjay.kustlogs.main.Main.playerGeral);
							CashAPI.removeCash(p.getName(), 1000);
							Main.pchest.set(p.getName()+".bau2.extendido", true);
							Main.pchest.saveConfig();
						}else {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê não possuí saldo suficiente.");
						}
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eExpandir #3")) {
						if(CashAPI.hasCash(p.getName(), 1000)) {
							p.getOpenInventory().close();
							p.sendMessage("§aBaú 3 foi expandido.");
							LogsAPI.register(p.getName(), p.getName()+" expandiu o baú 3", me.ninjay.kustlogs.main.Main.playerGeral);
							CashAPI.removeCash(p.getName(), 1000);
							Main.pchest.set(p.getName()+".bau3.extendido", true);
							Main.pchest.saveConfig();
						}else {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê não possuí saldo suficiente.");
						}
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eExpandir #4")) {
						if(CashAPI.hasCash(p.getName(), 1000)) {
							p.getOpenInventory().close();
							p.sendMessage("§aBaú 4 foi expandido.");
							LogsAPI.register(p.getName(), p.getName()+" expandiu o baú 4", me.ninjay.kustlogs.main.Main.playerGeral);
							CashAPI.removeCash(p.getName(), 1000);
							Main.pchest.set(p.getName()+".bau4.extendido", true);
							Main.pchest.saveConfig();
						}else {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê não possuí saldo suficiente.");
						}
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eExpandir #5")) {
						if(CashAPI.hasCash(p.getName(), 1000)) {
							p.getOpenInventory().close();
							p.sendMessage("§aBaú 5 foi expandido.");
							LogsAPI.register(p.getName(), p.getName()+" expandiu o baú 5", me.ninjay.kustlogs.main.Main.playerGeral);
							CashAPI.removeCash(p.getName(), 1000);
							Main.pchest.set(p.getName()+".bau5.extendido", true);
							Main.pchest.saveConfig();
						}else {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê não possuí saldo suficiente.");
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void aoFechar(InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer();
		
		if(e.getInventory().getTitle().equals("Baú 1")) {
			
			List<ItemStack> itens = new ArrayList<>();
			List<Integer> slots = new ArrayList<>();
			int i = 0;
			
			for(ItemStack item : e.getInventory().getContents()) {
				if(item != null) {
					itens.add(item);
					slots.add(i);
				}
				i++;
			}
			
			Main.getPlugin(Main.class).getConfig().set(p.getName()+".bau1.itens", itens);
			Main.getPlugin(Main.class).getConfig().set(p.getName()+".bau1.slots", slots);
			Main.getPlugin(Main.class).saveConfig();
			Main.getPlugin(Main.class).reloadConfig();
		}
		if(e.getInventory().getTitle().equals("Baú 2")) {
			
			List<ItemStack> itens = new ArrayList<>();
			List<Integer> slots = new ArrayList<>();
			int i = 0;
			
			for(ItemStack item : e.getInventory().getContents()) {
				if(item != null) {
					itens.add(item);
					slots.add(i);
				}
				i++;
			}
			
			Main.getPlugin(Main.class).getConfig().set(p.getName()+".bau2.itens", itens);
			Main.getPlugin(Main.class).getConfig().set(p.getName()+".bau2.slots", slots);
			Main.getPlugin(Main.class).saveConfig();
			Main.getPlugin(Main.class).reloadConfig();
		}
		if(e.getInventory().getTitle().equals("Baú 3")) {
			
			List<ItemStack> itens = new ArrayList<>();
			List<Integer> slots = new ArrayList<>();
			int i = 0;
			
			for(ItemStack item : e.getInventory().getContents()) {
				if(item != null) {
					itens.add(item);
					slots.add(i);
				}
				i++;
			}
			
			Main.getPlugin(Main.class).getConfig().set(p.getName()+".bau3.itens", itens);
			Main.getPlugin(Main.class).getConfig().set(p.getName()+".bau3.slots", slots);
			Main.getPlugin(Main.class).saveConfig();
			Main.getPlugin(Main.class).reloadConfig();
		}
		if(e.getInventory().getTitle().equals("Baú 4")) {
			
			List<ItemStack> itens = new ArrayList<>();
			List<Integer> slots = new ArrayList<>();
			int i = 0;
			
			for(ItemStack item : e.getInventory().getContents()) {
				if(item != null) {
					itens.add(item);
					slots.add(i);
				}
				i++;
			}
			
			Main.getPlugin(Main.class).getConfig().set(p.getName()+".bau4.itens", itens);
			Main.getPlugin(Main.class).getConfig().set(p.getName()+".bau4.slots", slots);
			Main.getPlugin(Main.class).saveConfig();
			Main.getPlugin(Main.class).reloadConfig();
		}
		if(e.getInventory().getTitle().equals("Baú 5")) {
			
			List<ItemStack> itens = new ArrayList<>();
			List<Integer> slots = new ArrayList<>();
			int i = 0;
			
			for(ItemStack item : e.getInventory().getContents()) {
				if(item != null) {
					itens.add(item);
					slots.add(i);
				}
				i++;
			}
			
			Main.getPlugin(Main.class).getConfig().set(p.getName()+".bau5.itens", itens);
			Main.getPlugin(Main.class).getConfig().set(p.getName()+".bau5.slots", slots);
			Main.getPlugin(Main.class).saveConfig();
			Main.getPlugin(Main.class).reloadConfig();
		}
	}
	
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if(p.hasPermission("bau.join")) {
			if(Main.pchest.getBoolean(p.getName()+".bau1.ativo") == false) {
				p.sendMessage("§aBaú 1 adquirido devido ao seu VIP.");
				Main.pchest.set(p.getName()+".bau1.ativo", true);
				Main.pchest.saveConfig();
				return;
			}
		}
	}

}
