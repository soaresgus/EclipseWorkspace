package me.ninjay.kustkits.estruturas;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.nossr50.mcMMO;
import com.gmail.nossr50.api.ExperienceAPI;
import com.gmail.nossr50.datatypes.player.McMMOPlayer;
import com.gmail.nossr50.datatypes.skills.SkillType;

import me.ninjay.kustkits.main.Main;
import me.ninjay.kustkits.utils.Mine;
import me.ninjay.kustkits.utils.VaultAPI;
import me.ninjay.kustlogs.estruturas.LogsAPI;

public class KitControler implements CommandExecutor, Listener{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			Inventory menu = Mine.newInventory("Kits", 9*3);
			ItemStack basico = Mine.newItem(Material.LOG, "§eKits básicos", 1, 0, "§7Kits básicos do servidor", " ", "§eClique direito para abrir");
			ItemStack vip = Mine.newItem(Material.DIAMOND_BLOCK, "§eKits VIPs", 1, 0, "§7Kits VIPs do servidor", " ", "§eClique direito para abrir");
			ItemStack caixa = Mine.newItem(Material.ENDER_CHEST, "§eCaixas misteriosas", 1, 0, "§7Caixas misteriosas do servidor", " ", "§eClique direito para abrir");
			ItemStack especial = Mine.newItem(Material.NETHER_STAR, "§eItens especiais", 1, 0, "§7Itens especiais do servidor", " ", "§eClique direito para abrir");
	
			menu.setItem(Mine.getPosition(2, 2), basico);
			menu.setItem(Mine.getPosition(2, 4), vip);
			menu.setItem(Mine.getPosition(2, 6), caixa);
			menu.setItem(Mine.getPosition(2, 8), especial);
			
			p.openInventory(menu);
	
		}
		return false;
	}
	
	public static String formatarTempoDHMS(int tempo) {
		 return String.format("%02d dias %02d horas %02d minutos %02d segundos", tempo / 86400, (tempo % 86400) / 3600, (tempo % 3600) / 60, tempo % 60);
	}
	
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equalsIgnoreCase("Kits")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKits básicos")) {
						
						Inventory menu = Mine.newInventory("Kits básicos", 9*3);
						
						for(Kit kits : KitAPI.manager.getKits()) {
							if(kits.isVip() == false) {
								menu.setItem(kits.getSlot()-1, kits.getIcone());
							}
						}
						
						p.openInventory(menu);
						
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKits VIPs")) {
						
						Inventory menu = Mine.newInventory("Kits VIPs", 9*5);
						
						for(Kit kits : KitAPI.manager.getKits()) {
							if(kits.isVip() == true) {
								menu.setItem(kits.getSlot()-1, kits.getIcone());
							}
						}
						
						p.openInventory(menu);
						
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eCaixas misteriosas")) {
						p.chat("/caixashop");
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eItens especiais")) {
						p.chat("/shop");
					}
				}
			}
		}
		if(e.getInventory().getTitle().equalsIgnoreCase("Kits básicos")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					Kit kit = KitAPI.manager.getKitPorIcone(e.getCurrentItem());
					if(kit != null) {
					if(e.getClick() == ClickType.LEFT) {
						if(p.hasPermission(kit.getPerm())) {
						if(!Main.playerKits.contains(p.getName()+"."+kit.getName()) || Main.playerKits.getLong(p.getName()+"."+kit.getName()) <= 0) {
							if(kit.isIniciante() == false) {	
							if(Mine.getEmptySlotsAmount(p.getInventory()) >= 27) {
							p.getOpenInventory().close();
							Main.playerKits.remove(p.getName()+"."+kit.getName());
							p.sendMessage("§aKit "+kit.getNome()+" recebido com sucesso.");
							LogsAPI.register(p.getName(), p.getName()+" pegou o kit "+kit.getNome(), me.ninjay.kustlogs.main.Main.playerGeral);
							for(ItemStack itens : kit.getItens()) {
								p.getInventory().addItem(itens);
							}
							TimerAPI.timer(kit.getCooldown()*60, Main.playerKits, Main.getPlugin(Main.class), p.getName()+"."+kit.getName());
							}else {
								p.getOpenInventory().close();
								p.sendMessage("§cEsvazie seu inventário para receber o kit.");
							}
							}else {
								if(ExperienceAPI.getLevel(p, SkillType.MINING.getName()) >= 5) {
									if(VaultAPI.getEconomy().has(p, 1000)) {
										if(Mine.getEmptySlotsAmount(p.getInventory()) >= 27) {
											p.getOpenInventory().close();
											Main.playerKits.remove(p.getName()+"."+kit.getName());
											p.sendMessage("§aKit "+kit.getNome()+" recebido com sucesso.");
											LogsAPI.register(p.getName(), p.getName()+" pegou o kit "+kit.getNome(), me.ninjay.kustlogs.main.Main.playerGeral);
											for(ItemStack itens : kit.getItens()) {
												p.getInventory().addItem(itens);
											}
											TimerAPI.timer(kit.getCooldown()*60, Main.playerKits, Main.getPlugin(Main.class), p.getName()+"."+kit.getName());
											}else {
												p.getOpenInventory().close();
												p.sendMessage("§cEsvazie seu inventário para receber o kit.");
											}
									}else {
										p.getOpenInventory().close();
										p.sendMessage("§cVocê precisa ter no minímo 1.000 coins.");
									}
								}else {
									p.getOpenInventory().close();
									p.sendMessage("§cVocê precisa ter no minímo nível 5 de mineração.");
								}
							}
						}else {
							p.getOpenInventory().close();
							p.sendMessage("§cAguarde "+formatarTempoDHMS(TimerAPI.getTempoCorrendo(Main.playerKits, p.getName()+"."+kit.getName()))+" §cpara receber o kit novamente.");
						}
					}else {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê não possuí permissão para resgatar esse kit.");
					}
						}
					}
				}
			}
		}
		if(e.getInventory().getTitle().equalsIgnoreCase("Kits VIPs")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				Kit kit = KitAPI.manager.getKitPorIcone(e.getCurrentItem());
				if(e.getCurrentItem().getItemMeta() != null) {
					if(kit != null) {
						if(e.getClick() == ClickType.LEFT) {
							if(p.hasPermission(kit.getPerm())) {
						if(!Main.playerKits.contains(p.getName()+"."+kit.getName()) || Main.playerKits.getLong(p.getName()+"."+kit.getName()) <= 0) {
							if(kit.isIniciante() == false) {	
							if(Mine.getEmptySlotsAmount(p.getInventory()) >= 27) {
							p.getOpenInventory().close();
							Main.playerKits.remove(p.getName()+"."+kit.getName());
							p.sendMessage("§aKit "+kit.getNome()+" recebido com sucesso.");
							LogsAPI.register(p.getName(), p.getName()+" pegou o kit "+kit.getNome(), me.ninjay.kustlogs.main.Main.playerGeral);
							for(ItemStack itens : kit.getItens()) {
								p.getInventory().addItem(itens);
							}
							TimerAPI.timer(kit.getCooldown()*60, Main.playerKits, Main.getPlugin(Main.class), p.getName()+"."+kit.getName());
							}else {
								p.getOpenInventory().close();
								p.sendMessage("§cEsvazie seu inventário para receber o kit.");
							}
							}else {
								if(ExperienceAPI.getLevel(p, SkillType.MINING.getName()) >= 5) {
									if(VaultAPI.getEconomy().has(p, 1000)) {
										if(Mine.getEmptySlotsAmount(p.getInventory()) >= 27) {
											p.getOpenInventory().close();
											Main.playerKits.remove(p.getName()+"."+kit.getName());
											p.sendMessage("§aKit "+kit.getNome()+" recebido com sucesso.");
											LogsAPI.register(p.getName(), p.getName()+" pegou o kit "+kit.getNome(), me.ninjay.kustlogs.main.Main.playerGeral);
											for(ItemStack itens : kit.getItens()) {
												p.getInventory().addItem(itens);
											}
											TimerAPI.timer(kit.getCooldown()*60, Main.playerKits, Main.getPlugin(Main.class), p.getName()+"."+kit.getName());
											}else {
												p.getOpenInventory().close();
												p.sendMessage("§cEsvazie seu inventário para receber o kit.");
											}
									}else {
										p.getOpenInventory().close();
										p.sendMessage("§cVocê precisa ter no minímo 1.000 coins.");
									}
								}else {
									p.getOpenInventory().close();
									p.sendMessage("§cVocê precisa ter no minímo nível 5 de mineração.");
								}
							}
						}else {
							p.getOpenInventory().close();
							p.sendMessage("§cAguarde "+formatarTempoDHMS(TimerAPI.getTempoCorrendo(Main.playerKits, p.getName()+"."+kit.getName()))+" §cpara receber o kit novamente.");
						}
					}else {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê não possuí permissão para resgatar esse kit.");
					}
					}
					}
				}
			}
		}
		if(e.getInventory().getTitle().equalsIgnoreCase("Kits básicos") || e.getInventory().getTitle().equalsIgnoreCase("Kits VIPs")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					Kit kit = KitAPI.manager.getKitPorIcone(e.getCurrentItem());
					if(kit != null) {
						if(e.getClick() == ClickType.RIGHT) {
							Inventory visu = Mine.newInventory(kit.getNome(), 9*6);
							Mine.rodarInventario(visu, Mine.newItem(Material.STAINED_GLASS_PANE, null, 1, 7));
							for(ItemStack itens : kit.getItens()) {
								visu.addItem(itens);
							}
							
							p.openInventory(visu);
						}
					}
				}
			}
		}
		for(Kit kits : KitAPI.manager.getKits()) {
			if(e.getInventory().getTitle().equalsIgnoreCase(kits.getNome())) {
				e.setCancelled(true);
			}
		}
		
	}

}
