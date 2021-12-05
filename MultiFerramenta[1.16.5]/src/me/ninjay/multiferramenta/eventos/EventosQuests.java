package me.ninjay.multiferramenta.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.multiferramenta.estruturas.ItensAPI;
import me.ninjay.multiferramenta.main.Main;
import me.ninjay.multiferramenta.utils.Mine;

public class EventosQuests implements Listener{

	public static HashMap<String, Integer> save = new HashMap<>();
	
	private static ArrayList<Block> blocos = new ArrayList<>();
	
	@EventHandler
	public void onKill(EntityDeathEvent e) {
		
		if(e.getEntity() != null) {
			if(e.getEntity().getKiller() != null) {
				if(e.getEntity().getType() != EntityType.PLAYER) {
					if(e.getEntity().getKiller().getType() == EntityType.PLAYER) {
						Player p = e.getEntity().getKiller();
						if(e.getEntityType() == EntityType.ZOMBIE) {
							if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
								if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Basico")) {
										if(save.get("basico1") != null) {
											if(save.get("basico1") < 4) {
											save.put("basico1", save.get("basico1")+1);
											Bukkit.broadcastMessage(" \n  §aUm zumbi foi morto usando a Multi Ferramenta Nivel Basico!\n  §aPara completar a quest mate mais "+(5-save.get("basico1"))+"!\n ");
											p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

											for(Player todos : Bukkit.getOnlinePlayers()) {
												if(todos != null) {
												for(ItemStack item : todos.getInventory().getContents()) {
													if(item != null) {
														if(item.getItemMeta().getDisplayName().contains("Basico")) {
															Mine.setLore(item, "§fTodas as ferramentas de pedra","§fem uma!", " ", "§eEVOLUIR PARA NÍVEL INICIANTE:", " §fMatar §c5 Zumbis §e("+save.get("basico1")+"/5)", " ", "§eHABILIDADE DE NÍVEL BÁSICO:"," §fO dano de uma §cespada §fde pedra!"," §fA velocidade de uma §cpicareta, machado, e pá §fde pedra!");
														}
													}
													}
												}
											}
											}else {
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Basico")) {
																item.setAmount(0);
																todos.getInventory().addItem(ItensAPI.multiiniciante());
																todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
																todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
															}
														}
														}
													}
												}
												}
											
											}else {
												save.put("basico1", 1);
												Bukkit.broadcastMessage(" \n  §aUm zumbi foi morto usando a Multi Ferramenta Nivel Basico!\n  §aPara completar a quest mate mais "+(5-save.get("basico1"))+"!\n ");
												p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
											
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Basico")) {
																Mine.setLore(item, "§fTodas as ferramentas de pedra","§fem uma!", " ", "§eEVOLUIR PARA NÍVEL INICIANTE:", " §fMatar §c5 Zumbis §e("+save.get("basico1")+"/5)", " ", "§eHABILIDADE DE NÍVEL BÁSICO:"," §fO dano de uma §cespada §fde pedra!"," §fA velocidade de uma §cpicareta, machado, e pá §fde pedra!");
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
						if(e.getEntityType() == EntityType.SKELETON) {
							if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
								if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Iniciante")) {
										if(save.get("iniciante1") != null) {
											if(save.get("iniciante1") <= 4) {
											save.put("iniciante1", save.get("iniciante1")+1);
											Bukkit.broadcastMessage(" \n  §aUm esqueleto foi morto usando a Multi Ferramenta Nivel Iniciante!\n  §aPara completar a quest mate mais "+(5-save.get("iniciante1"))+"!\n ");
											p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

											for(Player todos : Bukkit.getOnlinePlayers()) {
												if(todos != null) {
												for(ItemStack item : todos.getInventory().getContents()) {
													if(item != null) {
														if(item.getItemMeta().getDisplayName().contains("Iniciante")) {
															if(save.get("iniciante1") != null) {
																if(save.get("iniciante2") != null) {
															Mine.setLore(item,  "§fTodas as ferramentas de ferro","§fem uma!", " ", "§eEVOLUIR PARA NÍVEL INTERMEDIÁRIO:", " §fMatar §c5 Esqueletos §e("+save.get("iniciante1")+"/5)", " §fMinerar §c10 Ouros §e("+save.get("iniciante2")+"/10)", " ", "§eHABILIDADE DE NÍVEL INICIANTE:"," §cTodas §fas habilidades anteriores!"," §fQuebra em uma área de §c3x3x3!");
																}else {
																	Mine.setLore(item,  "§fTodas as ferramentas de ferro","§fem uma!", " ", "§eEVOLUIR PARA NÍVEL INTERMEDIÁRIO:", " §fMatar §c5 Esqueletos §e("+save.get("iniciante1")+"/5)", " §fMinerar §c10 Ouros §e(0/10)", " ", "§eHABILIDADE DE NÍVEL INICIANTE:"," §cTodas §fas habilidades anteriores!"," §fQuebra em uma área de §c3x3x3!");
																}
															}
														}
													}
													}
												}
											}
											}
											if(save.get("iniciante1") != null) {
									if(save.get("iniciante1") >= 5) {
										if(save.get("iniciante2") != null) {
											if(save.get("iniciante2") >= 10) {
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Iniciante")) {
																item.setAmount(0);
																todos.getInventory().addItem(ItensAPI.multiintermediario());
																todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
																todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
															}
														}
													}
														}
													}
												}
												}
											}
										}
											}else {
												save.put("iniciante1", 1);
												Bukkit.broadcastMessage(" \n  §aUm esqueleto foi morto usando a Multi Ferramenta Nivel Iniciante!\n  §aPara completar a quest mate mais "+(5-save.get("iniciante1"))+"!\n ");
												p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
											
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Iniciante")) {
																if(save.get("iniciante1") != null) {
																	if(save.get("iniciante2") != null) {
																Mine.setLore(item,  "§fTodas as ferramentas de ferro","§fem uma!", " ", "§eEVOLUIR PARA NÍVEL INTERMEDIÁRIO:", " §fMatar §c5 Esqueletos §e("+save.get("iniciante1")+"/5)", " §fMinerar §c10 Ouros §e("+save.get("iniciante2")+"/10)", " ", "§eHABILIDADE DE NÍVEL INICIANTE:"," §cTodas §fas habilidades anteriores!"," §fQuebra em uma área de §c3x3x3!");
																	}else {
																		Mine.setLore(item,  "§fTodas as ferramentas de ferro","§fem uma!", " ", "§eEVOLUIR PARA NÍVEL INTERMEDIÁRIO:", " §fMatar §c5 Esqueletos §e("+save.get("iniciante1")+"/5)", " §fMinerar §c10 Ouros §e(0/10)", " ", "§eHABILIDADE DE NÍVEL INICIANTE:"," §cTodas §fas habilidades anteriores!"," §fQuebra em uma área de §c3x3x3!");
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
								}
							}
						if(e.getEntityType() == EntityType.SPIDER) {
							if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
								if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Intermediario")) {
										if(save.get("intermediario1") != null) {
											if(save.get("intermediario1") <= 4) {
											save.put("intermediario1", save.get("intermediario1")+1);
											Bukkit.broadcastMessage(" \n  §aUma aranha foi morto usando a Multi Ferramenta Nivel Intermediario!\n  §aPara completar a quest mate mais "+(5-save.get("intermediario1"))+"!\n ");
											p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

											for(Player todos : Bukkit.getOnlinePlayers()) {
												if(todos != null) {
												for(ItemStack item : todos.getInventory().getContents()) {
													if(item != null) {
														if(item.getItemMeta().getDisplayName().contains("Intermediario")) {
															List<String> lore = new ArrayList<String>();
															lore.addAll(item.getItemMeta().getLore());
															lore.set(4, " §fMatar §c5 Aranhas §e("+save.get("intermediario1")+"/5)");
															Mine.setLore(item, lore);
														}
													}
													}
												}
											}
											}
											if(save.get("intermediario1") != null) {
									if(save.get("intermediario1") >= 5) {
										if(save.get("intermediario2") != null) {
											if(save.get("intermediario2") >= 10) {
												if(save.get("intermediario3") != null) {
													if(save.get("intermediario3") >= 5) {
														if(save.get("intermediario4") != null) {
															if(save.get("intermediario4") >= 20) {
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Intermediario")) {
																item.setAmount(0);
																todos.getInventory().addItem(ItensAPI.multiavancado());
																todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
																todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
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
												}
											}
										}
											}else {
												save.put("intermediario1", 1);
												Bukkit.broadcastMessage(" \n  §aUma aranha foi morto usando a Multi Ferramenta Nivel Intermediario!\n  §aPara completar a quest mate mais "+(5-save.get("intermediario1"))+"!\n ");
												p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
											
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Intermediario")) {
																List<String> lore = new ArrayList<String>();
																lore.addAll(item.getItemMeta().getLore());
																lore.set(4, " §fMatar §c5 Aranhas §e("+save.get("intermediario1")+"/5)");
																Mine.setLore(item, lore);
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
						if(e.getEntityType() == EntityType.ZOMBIE) {
							if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
								if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Intermediario")) {
										if(save.get("intermediario2") != null) {
											if(save.get("intermediario2") <= 9) {
											save.put("intermediario2", save.get("intermediario2")+1);
											Bukkit.broadcastMessage(" \n  §aUm zumbi foi morto usando a Multi Ferramenta Nivel Intermediario!\n  §aPara completar a quest mate mais "+(10-save.get("intermediario2"))+"!\n ");
											p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

											for(Player todos : Bukkit.getOnlinePlayers()) {
												if(todos != null) {
												for(ItemStack item : todos.getInventory().getContents()) {
													if(item != null) {
														if(item.getItemMeta().getDisplayName().contains("Intermediario")) {
															List<String> lore = new ArrayList<String>();
															lore.addAll(item.getItemMeta().getLore());
															lore.set(5, " §fMatar §c10 Zumbis §e("+save.get("intermediario2")+"/10)");
															Mine.setLore(item, lore);
														}
													}
													}
												}
											}
											}
									if(save.get("intermediario1") >= 5) {
										if(save.get("intermediario2") != null) {
											if(save.get("intermediario2") >= 10) {
												if(save.get("intermediario3") != null) {
													if(save.get("intermediario3") >= 5) {
														if(save.get("intermediario4") != null) {
															if(save.get("intermediario4") >= 20) {
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Intermediario")) {
																item.setAmount(0);
																todos.getInventory().addItem(ItensAPI.multiavancado());
																todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
																todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
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
											}
										}
											}else {
												save.put("intermediario2", 1);
												Bukkit.broadcastMessage(" \n  §aUm zumbi foi morto usando a Multi Ferramenta Nivel Intermediario!\n  §aPara completar a quest mate mais "+(10-save.get("intermediario2"))+"!\n ");
												p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
											
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Intermediario")) {
																List<String> lore = new ArrayList<String>();
																lore.addAll(item.getItemMeta().getLore());
																lore.set(5, " §fMatar §c10 Zumbis §e("+save.get("intermediario2")+"/10)");
																Mine.setLore(item, lore);
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
						if(e.getEntityType() == EntityType.PIG) {
							if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
								if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Avancado")) {
										if(save.get("avancado1") != null) {
											if(save.get("avancado1") <= 9) {
											save.put("avancado1", save.get("avancado1")+1);
											Bukkit.broadcastMessage(" \n  §aUm porco foi morto usando a Multi Ferramenta Nivel Avancado!\n  §aPara completar a quest mate mais "+(10-save.get("avancado1"))+"!\n ");
											p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

											for(Player todos : Bukkit.getOnlinePlayers()) {
												if(todos != null) {
												for(ItemStack item : todos.getInventory().getContents()) {
													if(item != null) {
														if(item.getItemMeta().getDisplayName().contains("Avancado")) {
															List<String> lore = new ArrayList<String>();
															lore.addAll(item.getItemMeta().getLore());
															lore.set(4, " §fMatar §c10 Porcos §e("+save.get("avancado1")+"/10)");
															Mine.setLore(item, lore);
														}
													}
													}
												}
											}
											}
											if(save.get("avancado1") != null) {
									if(save.get("avancado1") >= 5) {
										if(save.get("avancado2") != null) {
											if(save.get("avancado2") >= 10) {
												if(save.get("avancado3") != null) {
													if(save.get("avancado3") >= 10) {
														if(save.get("avancado4") != null) {
															if(save.get("avancado4") >= 50) {
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Avancado")) {
																item.setAmount(0);
																todos.getInventory().addItem(ItensAPI.multiprofissional());
																todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
																todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
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
												}
											}
										}
											}else {
												save.put("avancado1", 1);
												Bukkit.broadcastMessage(" \n  §aUm porco foi morto usando a Multi Ferramenta Nivel Avancado!\n  §aPara completar a quest mate mais "+(10-save.get("avancado1"))+"!\n ");
												p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
											
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Avancado")) {
																List<String> lore = new ArrayList<String>();
																lore.addAll(item.getItemMeta().getLore());
																lore.set(4, " §fMatar §c10 Porcos §e("+save.get("avancado1")+"/10)");;
																Mine.setLore(item, lore);
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
						if(e.getEntityType() == EntityType.SHEEP) {
							if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
								if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Avancado")) {
										if(save.get("avancado2") != null) {
											if(save.get("avancado2") <= 9) {
											save.put("avancado2", save.get("avancado2")+1);
											Bukkit.broadcastMessage(" \n  §aUma ovelha foi morto usando a Multi Ferramenta Nivel Avancado!\n  §aPara completar a quest mate mais "+(10-save.get("avancado2"))+"!\n ");
											p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

											for(Player todos : Bukkit.getOnlinePlayers()) {
												if(todos != null) {
												for(ItemStack item : todos.getInventory().getContents()) {
													if(item != null) {
														if(item.getItemMeta().getDisplayName().contains("Avancado")) {
															List<String> lore = new ArrayList<String>();
															lore.addAll(item.getItemMeta().getLore());
															lore.set(5, " §fMatar §c10 Ovelhas §e("+save.get("avancado2")+"/10)");
															Mine.setLore(item, lore);
														}
													}
													}
												}
											}
											}
											if(save.get("avancado1") != null) {
									if(save.get("avancado1") >= 5) {
										if(save.get("avancado2") != null) {
											if(save.get("avancado2") >= 10) {
												if(save.get("avancado3") != null) {
													if(save.get("avancado3") >= 10) {
														if(save.get("avancado4") != null) {
															if(save.get("avancado4") >= 50) {
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Avancado")) {
																item.setAmount(0);
																todos.getInventory().addItem(ItensAPI.multiprofissional());
																todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
																todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
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
												}
											}
										}
											}else {
												save.put("avancado2", 1);
												Bukkit.broadcastMessage(" \n  §aUma ovelha foi morto usando a Multi Ferramenta Nivel Avancado!\n  §aPara completar a quest mate mais "+(10-save.get("avancado2"))+"!\n ");
												p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
											
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Avancado")) {
																List<String> lore = new ArrayList<String>();
																lore.addAll(item.getItemMeta().getLore());
																lore.set(5, " §fMatar §c10 Ovelhas §e("+save.get("avancado2")+"/10)");
																Mine.setLore(item, lore);
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
						if(e.getEntityType() == EntityType.HORSE) {
							if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
								if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Avancado")) {
										if(save.get("avancado3") != null) {
											if(save.get("avancado3") <= 9) {
											save.put("avancado3", save.get("avancado3")+1);
											Bukkit.broadcastMessage(" \n  §aUm cavalo foi morto usando a Multi Ferramenta Nivel Avancado!\n  §aPara completar a quest mate mais "+(10-save.get("avancado3"))+"!\n ");
											p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

											for(Player todos : Bukkit.getOnlinePlayers()) {
												if(todos != null) {
												for(ItemStack item : todos.getInventory().getContents()) {
													if(item != null) {
														if(item.getItemMeta().getDisplayName().contains("Avancado")) {
															List<String> lore = new ArrayList<String>();
															lore.addAll(item.getItemMeta().getLore());
															lore.set(6, " §fMatar §c10 Cavalos §e("+save.get("avancado3")+"/10)");
															Mine.setLore(item, lore);
														}
													}
													}
												}
											}
											}
											if(save.get("avancado1") != null) {
									if(save.get("avancado1") >= 5) {
										if(save.get("avancado2") != null) {
											if(save.get("avancado2") >= 10) {
												if(save.get("avancado3") != null) {
													if(save.get("avancado3") >= 10) {
														if(save.get("avancado4") != null) {
															if(save.get("avancado4") >= 50) {
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Avancado")) {
																item.setAmount(0);
																todos.getInventory().addItem(ItensAPI.multiprofissional());
																todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
																todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
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
												}
											}
										}
											}else {
												save.put("avancado3", 1);
												Bukkit.broadcastMessage(" \n  §aUm cavalo foi morto usando a Multi Ferramenta Nivel Avancado!\n  §aPara completar a quest mate mais "+(10-save.get("avancado3"))+"!\n ");
												p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
											
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Avancado")) {
																List<String> lore = new ArrayList<String>();
																lore.addAll(item.getItemMeta().getLore());
																lore.set(6, " §fMatar §c10 Cavalos §e("+save.get("avancado3")+"/10)");
																Mine.setLore(item, lore);
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
						if(e.getEntityType() == EntityType.WITHER_SKELETON) {
							if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
								if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Especialista")) {
										if(save.get("especialista1") != null) {
											if(save.get("especialista1") <= 9) {
											save.put("especialista1", save.get("especialista1")+1);
											Bukkit.broadcastMessage(" \n  §aUm esqueleto wither foi morto usando a Multi Ferramenta Nivel Especialista!\n  §aPara completar a quest mate mais "+(10-save.get("especialista1"))+"!\n ");
											p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

											for(Player todos : Bukkit.getOnlinePlayers()) {
												if(todos != null) {
												for(ItemStack item : todos.getInventory().getContents()) {
													if(item != null) {
														if(item.getItemMeta().getDisplayName().contains("Especialista")) {
															List<String> lore = new ArrayList<String>();
															lore.addAll(item.getItemMeta().getLore());
															lore.set(7, " §fMatar §c10 Esqueletos Wither §e("+save.get("especialista1")+"/10)");
															Mine.setLore(item, lore);
														}
													}
													}
												}
											}
											}
											if(save.get("especialista1") != null) {
									if(save.get("especialista1") >= 10) {
										if(save.get("especialista2") != null) {
											if(save.get("especialista2") >= 10) {
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Especialista")) {
																item.setAmount(0);
																todos.getInventory().addItem(ItensAPI.multielite());
																todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
																todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
															}
														}
													}
														}
													}
												}
												}
											}
										}
											}else {
												save.put("especialista1", 1);
												Bukkit.broadcastMessage(" \n  §aUm esqueleto wither foi morto usando a Multi Ferramenta Nivel Especialista!\n  §aPara completar a quest mate mais "+(5-save.get("especialista1"))+"!\n ");
												p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
											
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Especialista")) {
																List<String> lore = new ArrayList<String>();
																lore.addAll(item.getItemMeta().getLore());
																lore.set(7, " §fMatar §c10 Esqueletos Wither §e("+save.get("especialista1")+"/10)");
																Mine.setLore(item, lore);
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
						if(e.getEntityType() == EntityType.BLAZE) {
							if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
								if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Especialista")) {
										if(save.get("especialista2") != null) {
											if(save.get("especialista2") <= 9) {
											save.put("especialista2", save.get("especialista2")+1);
											Bukkit.broadcastMessage(" \n  §aUm blaze foi morto usando a Multi Ferramenta Nivel Especialista!\n  §aPara completar a quest mate mais "+(10-save.get("especialista2"))+"!\n ");
											p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

											for(Player todos : Bukkit.getOnlinePlayers()) {
												if(todos != null) {
												for(ItemStack item : todos.getInventory().getContents()) {
													if(item != null) {
														if(item.getItemMeta().getDisplayName().contains("Especialista")) {
															List<String> lore = new ArrayList<String>();
															lore.addAll(item.getItemMeta().getLore());
															lore.set(8, " §fMatar §c10 Blazes §e("+save.get("especialista2")+"/10)");
															Mine.setLore(item, lore);
														}
													}
													}
												}
											}
											}
											if(save.get("especialista1") != null) {
									if(save.get("especialista1") >= 10) {
										if(save.get("especialista2") != null) {
											if(save.get("especialista2") >= 10) {
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Especialista")) {
																item.setAmount(0);
																todos.getInventory().addItem(ItensAPI.multielite());
																todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
																todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
															}
														}
													}
														}
													}
												}
												}
											}
										}
											}else {
												save.put("especialista2", 1);
												Bukkit.broadcastMessage(" \n  §aUm blaze foi morto usando a Multi Ferramenta Nivel Especialista!\n  §aPara completar a quest mate mais "+(10-save.get("especialista2"))+"!\n ");
												p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
											
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Especialista")) {
																List<String> lore = new ArrayList<String>();
																lore.addAll(item.getItemMeta().getLore());
																lore.set(8, " §fMatar §c10 Blazes §e("+save.get("especialista2")+"/10)");
																Mine.setLore(item, lore);
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
						if(e.getEntityType() == EntityType.PIGLIN) {
							if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
								if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Elite")) {
										if(save.get("elite1") != null) {
											if(save.get("elite1") <= 19) {
											save.put("elite1", save.get("elite1")+1);
											Bukkit.broadcastMessage(" \n  §aUm piglin foi morto usando a Multi Ferramenta Nivel Elite!\n  §aPara completar a quest mate mais "+(20-save.get("elite1"))+"!\n ");
											p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

											for(Player todos : Bukkit.getOnlinePlayers()) {
												if(todos != null) {
												for(ItemStack item : todos.getInventory().getContents()) {
													if(item != null) {
														if(item.getItemMeta().getDisplayName().contains("Elite")) {
															List<String> lore = new ArrayList<String>();
															lore.addAll(item.getItemMeta().getLore());
															lore.set(7, " §fMatar §c20 Piglins §e("+save.get("elite1")+"/20)");
															Mine.setLore(item, lore);
														}
													}
													}
												}
											}
											}
											if(save.get("elite1") != null) {
									if(save.get("elite1") >= 20) {
										if(save.get("elite2") != null) {
											if(save.get("elite2") >= 1) {
												if(save.get("elite3") != null) {
													if(save.get("elite3") >= 10) {
														if(save.get("elite4") != null) {
															if(save.get("elite4") >= 50) {
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Elite")) {
																item.setAmount(0);
																todos.getInventory().addItem(ItensAPI.multinotch());
																todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
																todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
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
												}
											}
										}
											}else {
												save.put("elite1", 1);
												Bukkit.broadcastMessage(" \n  §aUm piglin foi morto usando a Multi Ferramenta Nivel Elite!\n  §aPara completar a quest mate mais "+(20-save.get("elite1"))+"!\n ");
												p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
											
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Elite")) {
																List<String> lore = new ArrayList<String>();
																lore.addAll(item.getItemMeta().getLore());
																lore.set(7, " §fMatar §c20 Piglins §e("+save.get("elite1")+"/20)");
																Mine.setLore(item, lore);
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
						if(e.getEntityType() == EntityType.GHAST) {
							if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
								if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Elite")) {
										if(save.get("elite2") == null) {
												save.put("elite2", 1);
												Bukkit.broadcastMessage(" \n  §aUm ghast foi morto usando a Multi Ferramenta Nivel Elite!\n  §aQuest Completada!\n ");
												p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
											
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Elite")) {
																List<String> lore = new ArrayList<String>();
																lore.addAll(item.getItemMeta().getLore());
																lore.set(8, " §fMatar §c1 Ghast §e("+save.get("elite2")+"/1)");
																Mine.setLore(item, lore);
															}
														}
														}
													}
												}
												}
												if(save.get("elite1") != null) {
										if(save.get("elite1") >= 20) {
											if(save.get("elite2") != null) {
												if(save.get("elite2") >= 1) {
													if(save.get("elite3") != null) {
														if(save.get("elite3") >= 10) {
															if(save.get("elite4") != null) {
																if(save.get("elite4") >= 50) {
													for(Player todos : Bukkit.getOnlinePlayers()) {
														if(todos != null) {
														for(ItemStack item : todos.getInventory().getContents()) {
															if(item != null) {
																if(item.getItemMeta().getDisplayName().contains("Elite")) {
																	item.setAmount(0);
																	todos.getInventory().addItem(ItensAPI.multinotch());
																	todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
																	todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
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
												}
											}
												
											}
										}
									
									}
								}
							}
					if(e.getEntityType() == EntityType.BLAZE) {
						if(p.getInventory().getItemInMainHand() != null) {
							if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
								if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Notch")) {
										if(save.get("notch1") != null) {
											if(save.get("notch1") <= 19) {
											save.put("notch1", save.get("notch1")+1);
											Bukkit.broadcastMessage(" \n  §aUm blaze foi morto usando a Multi Ferramenta Nivel Notch!\n  §aPara completar a quest mate mais "+(20-save.get("notch1"))+"!\n ");
											p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

											for(Player todos : Bukkit.getOnlinePlayers()) {
												if(todos != null) {
												for(ItemStack item : todos.getInventory().getContents()) {
													if(item != null) {
														if(item.getItemMeta().getDisplayName().contains("Notch")) {
															List<String> lore = new ArrayList<String>();
															lore.addAll(item.getItemMeta().getLore());
															lore.set(7, " §fMater §c20 Blazes §e("+save.get("notch1")+"/20)");
															Mine.setLore(item, lore);
														}
													}
													}
												}
											}
											}
								if(save.get("notch1") != null) {
									if(save.get("notch1") >= 20) {
										if(save.get("notch2") != null) {
											if(save.get("notch2") >= 50) {
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Notch")) {
																item.setAmount(0);
																todos.getInventory().addItem(ItensAPI.multideus());
																todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
																todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
															}
														}
													}
													}
													}
												}
												}
											}
										}
											}else {
												save.put("notch1", 1);
												Bukkit.broadcastMessage(" \n  §aUm blaze foi morto usando a Multi Ferramenta Nivel Notch!\n  §aPara completar a quest mate mais "+(20-save.get("notch1"))+"!\n ");
												p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
											
												for(Player todos : Bukkit.getOnlinePlayers()) {
													if(todos != null) {
													for(ItemStack item : todos.getInventory().getContents()) {
														if(item != null) {
															if(item.getItemMeta().getDisplayName().contains("Notch")) {
																List<String> lore = new ArrayList<String>();
																lore.addAll(item.getItemMeta().getLore());
																lore.set(7, " §fMater §c20 Blazes §e("+save.get("notch1")+"/20)");
																Mine.setLore(item, lore);
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
						}
						}
					}
				}
			}
		}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Iniciante")) {
						if(e.getBlock().getType() == Material.GOLD_ORE) {
							if(save.get("iniciante2") != null) {
								if(save.get("iniciante2") <= 9) {
									for(int x = (int)-1.5; x < 1.5; x++) {
										for(int y = (int)-1.5; y < 1.5; y++) {
											for(int z = (int)-1.5; z < 1.5; z++) {
												if(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.GOLD_ORE) {
													blocos.add(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)));
													new BukkitRunnable() {
														
														@Override
														public void run() {
															blocos.clear();
														}
													}.runTaskLater(Main.getPlugin(Main.class), 1);
												}
											}
										}
									}
								save.put("iniciante2", save.get("iniciante2")+blocos.size());
								Bukkit.broadcastMessage(" \n  §aUm minério de ouro foi quebrado usando a Multi Ferramenta Nivel Iniciante!\n  §aPara completar a quest quebre mais "+(10-save.get("iniciante2"))+"!\n ");
								p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

								for(Player todos : Bukkit.getOnlinePlayers()) {
									if(todos != null) {
									for(ItemStack item : todos.getInventory().getContents()) {
										if(item != null) {
											if(item.getItemMeta().getDisplayName().contains("Iniciante")) {
												if(save.get("iniciante1") != null) {
													if(save.get("iniciante2") != null) {
												Mine.setLore(item,  "§fTodas as ferramentas de ferro","§fem uma!", " ", "§eEVOLUIR PARA NÍVEL INTERMEDIÁRIO:", " §fMatar §c5 Esqueletos §e("+save.get("iniciante1")+"/5)", " §fMinerar §c10 Ouros §e("+save.get("iniciante2")+"/10)", " ", "§eHABILIDADE DE NÍVEL INICIANTE:"," §cTodas §fas habilidades anteriores!"," §fQuebra em uma área de §c3x3x3!");
													}
												}else {
													Mine.setLore(item,  "§fTodas as ferramentas de ferro","§fem uma!", " ", "§eEVOLUIR PARA NÍVEL INTERMEDIÁRIO:", " §fMatar §c5 Esqueletos §e(0/5)", " §fMinerar §c10 Ouros §e("+save.get("iniciante2")+"/10)", " ", "§eHABILIDADE DE NÍVEL INICIANTE:"," §cTodas §fas habilidades anteriores!"," §fQuebra em uma área de §c3x3x3!");
												}
											}
										}
										}
									}
								}
								}
								if(save.get("iniciante2") != null) {
						if(save.get("iniciante2") >= 10) {
							if(save.get("iniciante1") != null) {
								if(save.get("iniciante1") >= 5) {
									for(Player todos : Bukkit.getOnlinePlayers()) {
										if(todos != null) {
										for(ItemStack item : todos.getInventory().getContents()) {
											if(item != null) {
												if(item.getItemMeta().getDisplayName().contains("Iniciante")) {
													item.setAmount(0);
													todos.getInventory().addItem(ItensAPI.multiintermediario());
													todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
													todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
												}
											}
											}
										}
										}
									}
								}
									}
								}
								}else {
									save.put("iniciante2", 1);
									Bukkit.broadcastMessage(" \n  §aUm minério de ouro foi quebrado usando a Multi Ferramenta Nivel Iniciante!\n  §aPara completar a quest quebre mais "+(10-save.get("iniciante2"))+"!\n ");
									p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
								
									for(Player todos : Bukkit.getOnlinePlayers()) {
										if(todos != null) {
										for(ItemStack item : todos.getInventory().getContents()) {
											if(item != null) {
												if(item.getItemMeta().getDisplayName().contains("Iniciante")) {
													if(save.get("iniciante1") != null) {
														if(save.get("iniciante2") != null) {
													Mine.setLore(item,  "§fTodas as ferramentas de ferro","§fem uma!", " ", "§eEVOLUIR PARA NÍVEL INTERMEDIÁRIO:", " §fMatar §c5 Esqueletos §e("+save.get("iniciante1")+"/5)", " §fMinerar §c10 Ouros §e("+save.get("iniciante2")+"/10)", " ", "§eHABILIDADE DE NÍVEL INICIANTE:"," §cTodas §fas habilidades anteriores!"," §fQuebra em uma área de §c3x3x3!");
														}
													}else {
														Mine.setLore(item,  "§fTodas as ferramentas de ferro","§fem uma!", " ", "§eEVOLUIR PARA NÍVEL INTERMEDIÁRIO:", " §fMatar §c5 Esqueletos §e(0/5)", " §fMinerar §c10 Ouros §e("+save.get("iniciante2")+"/10)", " ", "§eHABILIDADE DE NÍVEL INICIANTE:"," §cTodas §fas habilidades anteriores!"," §fQuebra em uma área de §c3x3x3!");
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
			}
		}
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Intermediario")) {
						if(e.getBlock().getType() == Material.DIAMOND_ORE) {
						if(save.get("intermediario3") != null) {
							if(save.get("intermediario3") <= 4) {
								for(int x = (int)-1.5; x < 1.5; x++) {
									for(int y = (int)-1.5; y < 1.5; y++) {
										for(int z = (int)-1.5; z < 1.5; z++) {
											if(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.DIAMOND_ORE) {
												blocos.add(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)));
												new BukkitRunnable() {
													
													@Override
													public void run() {
														blocos.clear();
													}
												}.runTaskLater(Main.getPlugin(Main.class), 1);
											}
										}
									}
								}
							save.put("iniciante3", save.get("iniciante3")+blocos.size());
							Bukkit.broadcastMessage(" \n  §aUm diamante foi quebrado usando a Multi Ferramenta Nivel Intermediario!\n  §aPara completar a quest quebre mais "+(5-save.get("intermediario3"))+"!\n ");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

							for(Player todos : Bukkit.getOnlinePlayers()) {
								if(todos != null) {
								for(ItemStack item : todos.getInventory().getContents()) {
									if(item != null) {
										if(item.getItemMeta().getDisplayName().contains("Intermediario")) {
											List<String> lore = new ArrayList<String>();
											lore.addAll(item.getItemMeta().getLore());
											lore.set(6, " §fMinerar §c5 Diamantes §e("+save.get("intermediario3")+"/5)");
											Mine.setLore(item, lore);
										}
									}
									}
								}
							}
							}
							if(save.get("intermediario1") != null) {
					if(save.get("intermediario1") >= 5) {
						if(save.get("intermediario2") != null) {
							if(save.get("intermediario2") >= 10) {
								if(save.get("intermediario3") != null) {
									if(save.get("intermediario3") >= 5) {
										if(save.get("intermediario4") != null) {
											if(save.get("intermediario4") >= 20) {
								for(Player todos : Bukkit.getOnlinePlayers()) {
									if(todos != null) {
									for(ItemStack item : todos.getInventory().getContents()) {
										if(item != null) {
											if(item.getItemMeta().getDisplayName().contains("Intermediario")) {
												item.setAmount(0);
												todos.getInventory().addItem(ItensAPI.multiavancado());
												todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
												todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
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
								}
							}
						}
							}else {
								save.put("intermediario3", 1);
								Bukkit.broadcastMessage(" \n  §aUm diamante foi quebrado usando a Multi Ferramenta Nivel Intermediario!\n  §aPara completar a quest quebre mais "+(5-save.get("intermediario3"))+"!\n ");
								p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							
								for(Player todos : Bukkit.getOnlinePlayers()) {
									if(todos != null) {
									for(ItemStack item : todos.getInventory().getContents()) {
										if(item != null) {
											if(item.getItemMeta().getDisplayName().contains("Intermediario")) {
												List<String> lore = new ArrayList<String>();
												lore.addAll(item.getItemMeta().getLore());
												lore.set(6, " §fMinerar §c5 Diamantes §e("+save.get("intermediario3")+"/5)");
												Mine.setLore(item, lore);
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
		}
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Intermediario")) {
						if(e.getBlock().getType() == Material.OBSIDIAN) {
						if(save.get("intermediario4") != null) {
							if(save.get("intermediario4") <= 19) {
								for(int x = (int)-1.5; x < 1.5; x++) {
									for(int y = (int)-1.5; y < 1.5; y++) {
										for(int z = (int)-1.5; z < 1.5; z++) {
											if(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.OBSIDIAN) {
												blocos.add(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)));
												new BukkitRunnable() {
													
													@Override
													public void run() {
														blocos.clear();
													}
												}.runTaskLater(Main.getPlugin(Main.class), 1);
											}
										}
									}
								}
							save.put("intermediario4", save.get("intermediario4")+blocos.size());
							Bukkit.broadcastMessage(" \n  §aUma obsidian foi quebrado usando a Multi Ferramenta Nivel Intermediario!\n  §aPara completar a quest quebra mais "+(20-save.get("intermediario4"))+"!\n ");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

							for(Player todos : Bukkit.getOnlinePlayers()) {
								if(todos != null) {
								for(ItemStack item : todos.getInventory().getContents()) {
									if(item != null) {
										if(item.getItemMeta().getDisplayName().contains("Intermediario")) {
											List<String> lore = new ArrayList<String>();
											lore.addAll(item.getItemMeta().getLore());
											lore.set(7, " §fQuebrar §c20 Obsidians §e("+save.get("intermediario4")+"/20)");
											Mine.setLore(item, lore);
										}
									}
									}
								}
							}
							}
							if(save.get("intermediario1") != null) {
					if(save.get("intermediario1") >= 5) {
						if(save.get("intermediario2") != null) {
							if(save.get("intermediario2") >= 10) {
								if(save.get("intermediario3") != null) {
									if(save.get("intermediario3") >= 5) {
										if(save.get("intermediario4") != null) {
											if(save.get("intermediario4") >= 20) {
								for(Player todos : Bukkit.getOnlinePlayers()) {
									if(todos != null) {
									for(ItemStack item : todos.getInventory().getContents()) {
										if(item != null) {
											if(item.getItemMeta().getDisplayName().contains("Intermediario")) {
												item.setAmount(0);
												todos.getInventory().addItem(ItensAPI.multiavancado());
												todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
												todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
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
								}
							}
						}
							}else {
								save.put("intermediario4", 1);
								Bukkit.broadcastMessage(" \n  §aUma obsidian foi quebrado usando a Multi Ferramenta Nivel Intermediario!\n  §aPara completar a quest quebra mais "+(20-save.get("intermediario4"))+"!\n ");
								p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							
								for(Player todos : Bukkit.getOnlinePlayers()) {
									if(todos != null) {
									for(ItemStack item : todos.getInventory().getContents()) {
										if(item != null) {
											if(item.getItemMeta().getDisplayName().contains("Intermediario")) {
												List<String> lore = new ArrayList<String>();
												lore.addAll(item.getItemMeta().getLore());
												lore.set(7, " §fQuebrar §c20 Obsidians §e("+save.get("intermediario4")+"/20)");
												Mine.setLore(item, lore);
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
		}
		
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Avancado")) {
						if(e.getBlock().getType() == Material.SAND) {
						if(save.get("avancado4") != null) {
							if(save.get("avancado4") <= 49) {
								for(int x = (int)-1.5; x < 1.5; x++) {
									for(int y = (int)-1.5; y < 1.5; y++) {
										for(int z = (int)-1.5; z < 1.5; z++) {
											if(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.SAND) {
												blocos.add(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)));
												new BukkitRunnable() {
													
													@Override
													public void run() {
														blocos.clear();
													}
												}.runTaskLater(Main.getPlugin(Main.class), 1);
											}
										}
									}
								}
							save.put("avancado4", save.get("avancado4")+blocos.size());
							Bukkit.broadcastMessage(" \n  §aUma areia foi quebrado usando a Multi Ferramenta Nivel Avancado!\n  §aPara completar a quest quebre mais "+(50-save.get("avancado4"))+"!\n ");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

							for(Player todos : Bukkit.getOnlinePlayers()) {
								if(todos != null) {
								for(ItemStack item : todos.getInventory().getContents()) {
									if(item != null) {
										if(item.getItemMeta().getDisplayName().contains("Avancado")) {
											List<String> lore = new ArrayList<String>();
											lore.addAll(item.getItemMeta().getLore());
											lore.set(7, " §fQuebrar §c50 Areias §e("+save.get("avancado4")+"/50)");
											Mine.setLore(item, lore);
										}
									}
									}
								}
							}
							}
							if(save.get("avancado1") != null) {
					if(save.get("avancado1") >= 5) {
						if(save.get("avancado2") != null) {
							if(save.get("avancado2") >= 10) {
								if(save.get("avancado3") != null) {
									if(save.get("avancado3") >= 10) {
										if(save.get("avancado4") != null) {
											if(save.get("avancado4") >= 50) {
								for(Player todos : Bukkit.getOnlinePlayers()) {
									if(todos != null) {
									for(ItemStack item : todos.getInventory().getContents()) {
										if(item != null) {
											if(item.getItemMeta().getDisplayName().contains("Avancado")) {
												item.setAmount(0);
												todos.getInventory().addItem(ItensAPI.multiprofissional());
												todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
												todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
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
								}
							}
						}
							}else {
								save.put("avancado4", 1);
								Bukkit.broadcastMessage(" \n  §aUma areia foi quebrado usando a Multi Ferramenta Nivel Avancado!\n  §aPara completar a quest quebre mais "+(50-save.get("avancado4"))+"!\n ");
								p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							
								for(Player todos : Bukkit.getOnlinePlayers()) {
									if(todos != null) {
									for(ItemStack item : todos.getInventory().getContents()) {
										if(item != null) {
											if(item.getItemMeta().getDisplayName().contains("Avancado")) {
												List<String> lore = new ArrayList<String>();
												lore.addAll(item.getItemMeta().getLore());
												lore.set(7, " §fQuebrar §c50 Areias §e("+save.get("avancado4")+"/50)");
												Mine.setLore(item, lore);
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
			
			if(p.getInventory().getItemInMainHand() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
						if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Profissional")) {
							if(e.getBlock().getType() == Material.IRON_ORE) {
							if(save.get("profissional1") != null) {
								if(save.get("profissional1") <= 29) {
									for(int x = (int)-1.5; x < 1.5; x++) {
										for(int y = (int)-1.5; y < 1.5; y++) {
											for(int z = (int)-1.5; z < 1.5; z++) {
												if(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.IRON_ORE) {
													blocos.add(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)));
													new BukkitRunnable() {
														
														@Override
														public void run() {
															blocos.clear();
														}
													}.runTaskLater(Main.getPlugin(Main.class), 1);
												}
											}
										}
									}
								save.put("profissional1", save.get("profissional1")+blocos.size());
								Bukkit.broadcastMessage(" \n  §aUm ferro foi quebrado usando a Multi Ferramenta Nivel Profissional!\n  §aPara completar a quest quebre mais "+(30-save.get("profissional1"))+"!\n ");
								p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

								for(Player todos : Bukkit.getOnlinePlayers()) {
									if(todos != null) {
									for(ItemStack item : todos.getInventory().getContents()) {
										if(item != null) {
											if(item.getItemMeta().getDisplayName().contains("Profissional")) {
												List<String> lore = new ArrayList<String>();
												lore.addAll(item.getItemMeta().getLore());
												lore.set(7, " §fMinerar §c30 Ferros §e("+save.get("profissional1")+"/30)");
												Mine.setLore(item, lore);
											}
										}
										}
									}
								}
								}
					if(save.get("profissional1") != null) {
						if(save.get("profissional1") >= 30) {
							if(save.get("profissional2") != null) {
								if(save.get("profissional2") >= 50) {
									if(save.get("profissional3") != null) {
										if(save.get("profissional3") >= 5) {
									for(Player todos : Bukkit.getOnlinePlayers()) {
										if(todos != null) {
										for(ItemStack item : todos.getInventory().getContents()) {
											if(item != null) {
												if(item.getItemMeta().getDisplayName().contains("Profissional")) {
													item.setAmount(0);
													todos.getInventory().addItem(ItensAPI.multiespecialista());
													todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
													todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
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
							}
								}else {
									save.put("profissional1", 1);
									Bukkit.broadcastMessage(" \n  §aUm ferro foi quebrado usando a Multi Ferramenta Nivel Profissional!\n  §aPara completar a quest quebre mais "+(30-save.get("profissional1"))+"!\n ");
									p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
								
									for(Player todos : Bukkit.getOnlinePlayers()) {
										if(todos != null) {
										for(ItemStack item : todos.getInventory().getContents()) {
											if(item != null) {
												if(item.getItemMeta().getDisplayName().contains("Profissional")) {
													List<String> lore = new ArrayList<String>();
													lore.addAll(item.getItemMeta().getLore());
													lore.set(7, " §fMinerar §c30 Ferros §e("+save.get("profissional1")+"/30)");
													Mine.setLore(item, lore);
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
			}
			
			if(p.getInventory().getItemInMainHand() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
						if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Profissional")) {
							if(e.getBlock().getType() == Material.COAL_ORE) {
							if(save.get("profissional2") != null) {
								if(save.get("profissional2") <= 49) {
									for(int x = (int)-1.5; x < 1.5; x++) {
										for(int y = (int)-1.5; y < 1.5; y++) {
											for(int z = (int)-1.5; z < 1.5; z++) {
												if(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.COAL_ORE) {
													blocos.add(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)));
													new BukkitRunnable() {
														
														@Override
														public void run() {
															blocos.clear();
														}
													}.runTaskLater(Main.getPlugin(Main.class), 1);
												}
											}
										}
									}
								save.put("profissional2", save.get("profissional2")+blocos.size());
								Bukkit.broadcastMessage(" \n  §aUm carvão foi quebrado usando a Multi Ferramenta Nivel Profissional!\n  §aPara completar a quest quebre mais "+(50-save.get("profissional2"))+"!\n ");
								p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

								for(Player todos : Bukkit.getOnlinePlayers()) {
									if(todos != null) {
									for(ItemStack item : todos.getInventory().getContents()) {
										if(item != null) {
											if(item.getItemMeta().getDisplayName().contains("Profissional")) {
												List<String> lore = new ArrayList<String>();
												lore.addAll(item.getItemMeta().getLore());
												lore.set(8, " §fMinerar §c50 Carvões §e("+save.get("profissional2")+"/50)");
												Mine.setLore(item, lore);
											}
										}
										}
									}
								}
								}
					if(save.get("profissional1") != null) {
						if(save.get("profissional1") >= 30) {
							if(save.get("profissional2") != null) {
								if(save.get("profissional2") >= 50) {
									if(save.get("profissional3") != null) {
										if(save.get("profissional3") >= 5) {
									for(Player todos : Bukkit.getOnlinePlayers()) {
										if(todos != null) {
										for(ItemStack item : todos.getInventory().getContents()) {
											if(item != null) {
												if(item.getItemMeta().getDisplayName().contains("Profissional")) {
													item.setAmount(0);
													todos.getInventory().addItem(ItensAPI.multiespecialista());
													todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
													todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
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
							}
								}else {
									save.put("profissional2", 1);
									Bukkit.broadcastMessage(" \n  §aUm carvão foi quebrado usando a Multi Ferramenta Nivel Profissional!\n  §aPara completar a quest quebre mais "+(50-save.get("profissional2"))+"!\n ");
									p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
								
									for(Player todos : Bukkit.getOnlinePlayers()) {
										if(todos != null) {
										for(ItemStack item : todos.getInventory().getContents()) {
											if(item != null) {
												if(item.getItemMeta().getDisplayName().contains("Profissional")) {
													List<String> lore = new ArrayList<String>();
													lore.addAll(item.getItemMeta().getLore());
													lore.set(8, " §fMinerar §c50 Carvões §e("+save.get("profissional2")+"/50)");
													Mine.setLore(item, lore);
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
			}
			
			if(p.getInventory().getItemInMainHand() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
						if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Profissional")) {
							if(e.getBlock().getType() == Material.LAPIS_ORE) {
							if(save.get("profissional3") != null) {
								if(save.get("profissional3") <= 4) {
									for(int x = (int)-1.5; x < 1.5; x++) {
										for(int y = (int)-1.5; y < 1.5; y++) {
											for(int z = (int)-1.5; z < 1.5; z++) {
												if(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.LAPIS_ORE) {
													blocos.add(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)));
													new BukkitRunnable() {
														
														@Override
														public void run() {
															blocos.clear();
														}
													}.runTaskLater(Main.getPlugin(Main.class), 1);
												}
											}
										}
									}
								save.put("profissional3", save.get("profissional3")+blocos.size());
								Bukkit.broadcastMessage(" \n  §aUm lapis foi quebrado usando a Multi Ferramenta Nivel Profissional!\n  §aPara completar a quest quebre mais "+(5-save.get("profissional3"))+"!\n ");
								p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

								for(Player todos : Bukkit.getOnlinePlayers()) {
									if(todos != null) {
									for(ItemStack item : todos.getInventory().getContents()) {
										if(item != null) {
											if(item.getItemMeta().getDisplayName().contains("Profissional")) {
												List<String> lore = new ArrayList<String>();
												lore.addAll(item.getItemMeta().getLore());
												lore.set(9, " §fMinerar §c5 Lapis Lazuli §e("+save.get("profissional3")+"/5)");
												Mine.setLore(item, lore);
											}
										}
										}
									}
								}
								}
					if(save.get("profissional1") != null) {
						if(save.get("profissional1") >= 30) {
							if(save.get("profissional2") != null) {
								if(save.get("profissional2") >= 50) {
									if(save.get("profissional3") != null) {
										if(save.get("profissional3") >= 5) {
									for(Player todos : Bukkit.getOnlinePlayers()) {
										if(todos != null) {
										for(ItemStack item : todos.getInventory().getContents()) {
											if(item != null) {
												if(item.getItemMeta().getDisplayName().contains("Profissional")) {
													item.setAmount(0);
													todos.getInventory().addItem(ItensAPI.multiespecialista());
													todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
													todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
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
							}
								}else {
									save.put("profissional3", 1);
									Bukkit.broadcastMessage(" \n  §aUm lapis foi quebrado usando a Multi Ferramenta Nivel Profissional!\n  §aPara completar a quest quebre mais "+(5-save.get("profissional3"))+"!\n ");
									p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
								
									for(Player todos : Bukkit.getOnlinePlayers()) {
										if(todos != null) {
										for(ItemStack item : todos.getInventory().getContents()) {
											if(item != null) {
												if(item.getItemMeta().getDisplayName().contains("Profissional")) {
													List<String> lore = new ArrayList<String>();
													lore.addAll(item.getItemMeta().getLore());
													lore.set(9, " §fMinerar §c5 Lapis Lazuli §e("+save.get("profissional3")+"/5)");
													Mine.setLore(item, lore);
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
			}
			
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Elite")) {
						if(e.getBlock().getType() == Material.SOUL_SAND) {
						if(save.get("elite4") != null) {
							if(save.get("elite4") <= 49) {
								for(int x = (int)-1.5; x < 1.5; x++) {
									for(int y = (int)-1.5; y < 1.5; y++) {
										for(int z = (int)-1.5; z < 1.5; z++) {
											if(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.SOUL_SAND) {
												blocos.add(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)));
												new BukkitRunnable() {
													
													@Override
													public void run() {
														blocos.clear();
													}
												}.runTaskLater(Main.getPlugin(Main.class), 1);
											}
										}
									}
								}
							save.put("elite4", save.get("elite4")+blocos.size());
							Bukkit.broadcastMessage(" \n  §aUma areia das almas foi quebrado usando a Multi Ferramenta Nivel Elite!\n  §aPara completar a quest quebre mais "+(50-save.get("elite4"))+"!\n ");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

							for(Player todos : Bukkit.getOnlinePlayers()) {
								if(todos != null) {
								for(ItemStack item : todos.getInventory().getContents()) {
									if(item != null) {
										if(item.getItemMeta().getDisplayName().contains("Elite")) {
											List<String> lore = new ArrayList<String>();
											lore.addAll(item.getItemMeta().getLore());
											lore.set(10, " §fQuebrar §c50 Areias §e("+save.get("elite4")+"/50)");
											Mine.setLore(item, lore);
										}
									}
									}
								}
							}
							}
							if(save.get("elite1") != null) {
					if(save.get("elite1") >= 20) {
						if(save.get("elite2") != null) {
							if(save.get("elite2") >= 1) {
								if(save.get("elite3") != null) {
									if(save.get("elite3") >= 10) {
										if(save.get("elite4") != null) {
											if(save.get("elite4") >= 50) {
								for(Player todos : Bukkit.getOnlinePlayers()) {
									if(todos != null) {
									for(ItemStack item : todos.getInventory().getContents()) {
										if(item != null) {
											if(item.getItemMeta().getDisplayName().contains("Elite")) {
												item.setAmount(0);
												todos.getInventory().addItem(ItensAPI.multinotch());
												todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
												todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
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
								}
							}
						}
							}else {
								save.put("elite4", 1);
								Bukkit.broadcastMessage(" \n  §aUma areia das almas foi quebrado usando a Multi Ferramenta Nivel Elite!\n  §aPara completar a quest quebre mais "+(50-save.get("elite4"))+"!\n ");
								p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							
								for(Player todos : Bukkit.getOnlinePlayers()) {
									if(todos != null) {
									for(ItemStack item : todos.getInventory().getContents()) {
										if(item != null) {
											if(item.getItemMeta().getDisplayName().contains("Elite")) {
												List<String> lore = new ArrayList<String>();
												lore.addAll(item.getItemMeta().getLore());
												lore.set(10, " §fQuebrar §c50 Areias §e("+save.get("elite4")+"/50)");
												Mine.setLore(item, lore);
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
			
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Elite")) {
						if(e.getBlock().getType() == Material.NETHER_QUARTZ_ORE) {
						if(save.get("elite3") != null) {
							if(save.get("elite3") <= 9) {
								for(int x = (int)-1.5; x < 1.5; x++) {
									for(int y = (int)-1.5; y < 1.5; y++) {
										for(int z = (int)-1.5; z < 1.5; z++) {
											if(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.NETHER_QUARTZ_ORE) {
												blocos.add(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)));
												new BukkitRunnable() {
													
													@Override
													public void run() {
														blocos.clear();
													}
												}.runTaskLater(Main.getPlugin(Main.class), 1);
											}
										}
									}
								}
							save.put("elite3", save.get("elite3")+blocos.size());
							Bukkit.broadcastMessage(" \n  §aUm minério de quartzo foi quebrado usando a Multi Ferramenta Nivel Elite!\n  §aPara completar a quest quebre mais "+(10-save.get("elite3"))+"!\n ");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

							for(Player todos : Bukkit.getOnlinePlayers()) {
								if(todos != null) {
								for(ItemStack item : todos.getInventory().getContents()) {
									if(item != null) {
										if(item.getItemMeta().getDisplayName().contains("Elite")) {
											List<String> lore = new ArrayList<String>();
											lore.addAll(item.getItemMeta().getLore());
											lore.set(9, " §fQuebrar §c10 Minérios de Quartzo §e("+save.get("elite3")+"/10)");
											Mine.setLore(item, lore);
										}
									}
									}
								}
							}
							}
							if(save.get("elite1") != null) {
					if(save.get("elite1") >= 20) {
						if(save.get("elite2") != null) {
							if(save.get("elite2") >= 1) {
								if(save.get("elite3") != null) {
									if(save.get("elite3") >= 10) {
										if(save.get("elite4") != null) {
											if(save.get("elite4") >= 50) {
								for(Player todos : Bukkit.getOnlinePlayers()) {
									if(todos != null) {
									for(ItemStack item : todos.getInventory().getContents()) {
										if(item != null) {
											if(item.getItemMeta().getDisplayName().contains("Elite")) {
												item.setAmount(0);
												todos.getInventory().addItem(ItensAPI.multinotch());
												todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
												todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
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
								}
							}
						}
							}else {
								save.put("elite3", 1);
								Bukkit.broadcastMessage(" \n  §aUm minério de quartzo foi quebrado usando a Multi Ferramenta Nivel Elite!\n  §aPara completar a quest quebre mais "+(10-save.get("elite3"))+"!\n ");
								p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							
								for(Player todos : Bukkit.getOnlinePlayers()) {
									if(todos != null) {
									for(ItemStack item : todos.getInventory().getContents()) {
										if(item != null) {
											if(item.getItemMeta().getDisplayName().contains("Elite")) {
												List<String> lore = new ArrayList<String>();
												lore.addAll(item.getItemMeta().getLore());
												lore.set(9, " §fQuebrar §c10 Minérios de Quartzo §e("+save.get("elite3")+"/10)");
												Mine.setLore(item, lore);
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
			
			if(p.getInventory().getItemInMainHand() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
						if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Notch")) {
							if(e.getBlock().getType().toString().contains("LEAVES")) {
							if(save.get("notch2") != null) {
								if(save.get("notch2") <= 49) {
									for(int x = (int)-1.5; x < 1.5; x++) {
										for(int y = (int)-1.5; y < 1.5; y++) {
											for(int z = (int)-1.5; z < 1.5; z++) {
												if(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.ACACIA_LEAVES || p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.BIRCH_LEAVES || p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.DARK_OAK_LEAVES || p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.JUNGLE_LEAVES || p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.OAK_LEAVES || p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.SPRUCE_LEAVES) {
													blocos.add(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)));
													new BukkitRunnable() {
														
														@Override
														public void run() {
															blocos.clear();
														}
													}.runTaskLater(Main.getPlugin(Main.class), 1);
												}
											}
										}
									}
								save.put("notch2", save.get("notch2")+blocos.size());
								Bukkit.broadcastMessage(" \n  §aUma folha foi quebrada usando a Multi Ferramenta Nivel Notch!\n  §aPara completar a quest quebre mais "+(50-save.get("notch2"))+"!\n ");
								p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);

								for(Player todos : Bukkit.getOnlinePlayers()) {
									if(todos != null) {
									for(ItemStack item : todos.getInventory().getContents()) {
										if(item != null) {
											if(item.getItemMeta().getDisplayName().contains("Notch")) {
												List<String> lore = new ArrayList<String>();
												lore.addAll(item.getItemMeta().getLore());
												lore.set(8, " §fQuebrar §c50 Folhas de árvores §e("+save.get("notch2")+"/50)");
												Mine.setLore(item, lore);
											}
										}
										}
									}
								}
								}
					if(save.get("notch1") != null) {
						if(save.get("notch1") >= 20) {
							if(save.get("notch2") != null) {
								if(save.get("notch2") >= 50) {
									for(Player todos : Bukkit.getOnlinePlayers()) {
										if(todos != null) {
										for(ItemStack item : todos.getInventory().getContents()) {
											if(item != null) {
												if(item.getItemMeta().getDisplayName().contains("Notch")) {
													item.setAmount(0);
													todos.getInventory().addItem(ItensAPI.multideus());
													todos.sendMessage(" \n  §aA Multi Ferramenta foi evoluída!\n ");
													todos.playSound(todos.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
												}
											}
										}
										}
										}
									}
									}
								}
							}
								}else {
									save.put("notch2", 1);
									Bukkit.broadcastMessage(" \n  §aUma folha foi quebrada usando a Multi Ferramenta Nivel Notch!\n  §aPara completar a quest quebre mais "+(50-save.get("notch2"))+"!\n ");
									p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
								
									for(Player todos : Bukkit.getOnlinePlayers()) {
										if(todos != null) {
										for(ItemStack item : todos.getInventory().getContents()) {
											if(item != null) {
												if(item.getItemMeta().getDisplayName().contains("Notch")) {
													List<String> lore = new ArrayList<String>();
													lore.addAll(item.getItemMeta().getLore());
													lore.set(8, " §fQuebrar §c50 Folhas de árvores §e("+save.get("notch2")+"/50)");
													Mine.setLore(item, lore);
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
			}
		
	}
	
	}
	
