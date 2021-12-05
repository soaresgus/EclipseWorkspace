package me.ninjay.kusteventos.estruturas;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.kusteventos.comandos.ComandoBolao;
import me.ninjay.kusteventos.comandos.ComandoSorteio;
import me.ninjay.kusteventos.main.Main;
import me.ninjay.kusteventos.utils.Mine;
import me.ninjay.kusteventos.utils.VaultAPI;

public class EventosManager implements CommandExecutor, Listener{

	public static HashMap<Player, String> definindo = new HashMap<>();
	public static HashMap<String, String> definicoes = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(p.hasPermission("evento.admin")) {
				Inventory menu = Mine.newInventory("Eventos", 9*3);
				
				ItemStack bp = Mine.newHead("§eBase perdida", "MFH_Beacon", 1, " ","  §7Clique para gerenciar");
				ItemStack guerra = Mine.newHead("§eGuerra", "Titan", 1, " ","  §7Clique para gerenciar");
				ItemStack loteria = Mine.newHead("§eLoteria", "MFH_Skin", 1, " ","  §7Clique para gerenciar");
				ItemStack bolao = Mine.newHead("§eBolão", "MFH_Skin", 1, " ","  §7Clique para gerenciar");
				ItemStack palavra = Mine.newHead("§ePalavra", "MFH_Skin", 1, " ","  §7Clique para gerenciar");
				ItemStack sorteio = Mine.newHead("§eSorteio", "MFH_Skin", 1, " ","  §7Clique para gerenciar");
			
				menu.setItem(Mine.getPosition(2, 2), bp);
				menu.setItem(Mine.getPosition(2, 3), guerra);
				menu.setItem(Mine.getPosition(2, 5), loteria);
				menu.setItem(Mine.getPosition(2, 6), bolao);
				menu.setItem(Mine.getPosition(2, 7), palavra);
				menu.setItem(Mine.getPosition(2, 8), sorteio);
				
				p.openInventory(menu);
			}
		}
		return false;
	}
	
	@EventHandler
	public void aoFalar(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(definindo.containsKey(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void aoClicarLoteria(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().contains("Eventos") || e.getInventory().getTitle().contains("Loteria")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getItemMeta() != null) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eLoteria")) {
					Inventory menu = Mine.newInventory("Loteria", 9*3);
					ItemStack valor = Mine.newItem(Material.DOUBLE_PLANT, "§eDefinir valor");
					ItemStack numero = Mine.newItem(Material.SULPHUR, "§eDefinir número");
					ItemStack iniciar = Mine.newItem(Material.EMERALD, "§eIniciar evento");
					
					menu.setItem(Mine.getPosition(2, 5), valor);
					menu.setItem(Mine.getPosition(2, 3), iniciar);
					menu.setItem(Mine.getPosition(2, 7), numero);
					
					p.openInventory(menu);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDefinir valor")) {
					
					definindo.put(p, "loteria_valor");
					p.getOpenInventory().close();
					p.sendMessage("§e§lDigite um valor para o evento.\n \n  §7Caso queira cancelar digite 'cancelar'.");
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDefinir número")) {
					
					definindo.put(p, "loteria_numero");
					p.getOpenInventory().close();
					p.sendMessage("§e§lDigite um número entre 1 e 300 para o evento.\n \n  §7Caso queira cancelar digite 'cancelar'.");
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eIniciar evento")) {
					if(definicoes.get("loteria_valor") != null) {
						if(definicoes.get("loteria_numero") != null) {
							if((!definicoes.containsKey("loteria_on")) || definicoes.get("loteria_on").equalsIgnoreCase("false")) {
					p.sendMessage("§aEvento iniciado!");
					p.getOpenInventory().close();
					definicoes.put("loteria_on", "true");
					new BukkitRunnable() {
						int i = 120;
						@Override
						public void run() {
							i--;
							if(i == 119) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									if(!definicoes.containsValue(all.getName())) {
									all.sendMessage(" \n§e§lEvento - Loteria\n \n§ePremiação: §6§l"+definicoes.get("loteria_valor")+"\n§ePara participar utilize §6/loteria <1 à 300>\n \n§eChamadas restantes: 6");
									}else {
										cancel();
										all.sendMessage(" \n§e§lEvento - Loteria\n \n§eO jogador §6§l"+definicoes.get("loteria_ganhador")+" §efoi o vencedor do evento!\n§eO número correto era §6§l"+EventosManager.definicoes.get("loteria_numero"));
										EventosManager.definicoes.remove("loteria_numero");
										EventosManager.definicoes.remove("loteria_ganhador");
										EventosManager.definicoes.remove("loteria_valor");
									}
									}
							}
							if(i == 100) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									if(!definicoes.containsValue(all.getName())) {
									all.sendMessage(" \n§e§lEvento - Loteria\n \n§ePremiação: §6§l"+definicoes.get("loteria_valor")+"\n§ePara participar utilize §6/loteria <1 à 300>\n \n§eChamadas restantes: 5");
								}else {
									cancel();
									all.sendMessage(" \n§e§lEvento - Loteria\n \n§eO jogador §6§l"+definicoes.get("loteria_ganhador")+" §efoi o vencedor do evento!\n§eO número correto era §6§l"+EventosManager.definicoes.get("loteria_numero"));
									EventosManager.definicoes.remove("loteria_numero");
									EventosManager.definicoes.remove("loteria_ganhador");
									EventosManager.definicoes.remove("loteria_valor");
								}
							}
								}
							if(i == 80) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									if(!definicoes.containsValue(all.getName())) {
									all.sendMessage(" \n§e§lEvento - Loteria\n \n§ePremiação: §6§l"+definicoes.get("loteria_valor")+"\n§ePara participar utilize §6/loteria <1 à 300>\n \n§eChamadas restantes: 4");
								}else {
									cancel();
									all.sendMessage(" \n§e§lEvento - Loteria\n \n§eO jogador §6§l"+definicoes.get("loteria_ganhador")+" §efoi o vencedor do evento!\n§eO número correto era §6§l"+EventosManager.definicoes.get("loteria_numero"));
									EventosManager.definicoes.remove("loteria_numero");
									EventosManager.definicoes.remove("loteria_ganhador");
									EventosManager.definicoes.remove("loteria_valor");
								}
									}
							}
							if(i == 60) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									if(!definicoes.containsValue(all.getName())) {
									all.sendMessage(" \n§e§lEvento - Loteria\n \n§ePremiação: §6§l"+definicoes.get("loteria_valor")+"\n§ePara participar utilize §6/loteria <1 à 300>\n \n§eChamadas restantes: 3");
								}else {
									cancel();
									all.sendMessage(" \n§e§lEvento - Loteria\n \n§eO jogador §6§l"+definicoes.get("loteria_ganhador")+" §efoi o vencedor do evento!\n§eO número correto era §6§l"+EventosManager.definicoes.get("loteria_numero"));
									EventosManager.definicoes.remove("loteria_numero");
									EventosManager.definicoes.remove("loteria_ganhador");
									EventosManager.definicoes.remove("loteria_valor");
								}
									}
							}
							if(i == 40) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									if(!definicoes.containsValue(all.getName())) {
									all.sendMessage(" \n§e§lEvento - Loteria\n \n§ePremiação: §6§l"+definicoes.get("loteria_valor")+"\n§ePara participar utilize §6/loteria <1 à 300>\n \n§eChamadas restantes: 2");
								}else {
									cancel();
									all.sendMessage(" \n§e§lEvento - Loteria\n \n§eO jogador §6§l"+definicoes.get("loteria_ganhador")+" §efoi o vencedor do evento!\n§eO número correto era §6§l"+EventosManager.definicoes.get("loteria_numero"));
									EventosManager.definicoes.remove("loteria_numero");
									EventosManager.definicoes.remove("loteria_ganhador");
									EventosManager.definicoes.remove("loteria_valor");
								}
									}
							}
							if(i == 20) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									if(!definicoes.containsValue(all.getName())) {
									all.sendMessage(" \n§e§lEvento - Loteria\n \n§ePremiação: §6§l"+definicoes.get("loteria_valor")+"\n§ePara participar utilize §6/loteria <1 à 300>\n \n§eChamadas restantes: 1");
								}else {
									cancel();
									all.sendMessage(" \n§e§lEvento - Loteria\n \n§eO jogador §6§l"+definicoes.get("loteria_ganhador")+" §efoi o vencedor do evento!\n§eO número correto era §6§l"+EventosManager.definicoes.get("loteria_numero"));
									EventosManager.definicoes.remove("loteria_numero");
									EventosManager.definicoes.remove("loteria_ganhador");
									EventosManager.definicoes.remove("loteria_valor");
								}
									}
							}
							if(i == 0) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									if(!definicoes.containsValue(all.getName())) {
										all.sendMessage(" \n§e§lEvento - Loteria\n \n§eEvento encerrado, ninguém adivinhou o número.\n ");
										}
								}
								cancel();
								definicoes.put("loteria_on", "false");
							}
						}
					}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
				}else {
					p.sendMessage("§cO evento já está ocorrendo");
					p.getOpenInventory().close();
				}
			}else {
				p.sendMessage("§cDefina o número da premiação.");
				p.getOpenInventory().close();
			}
					}else {
						p.sendMessage("§cDefina o valor da premiação.");
						p.getOpenInventory().close();
					}
				}
		}
			}
		}
	}

	@EventHandler
	public void aoFalarLoteria(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();

	if(definindo.containsKey(p)) {
		if(definindo.get(p).equals("loteria_valor")) {
			if(StringUtils.isNumeric(e.getMessage())) {
				e.setCancelled(true);
				p.sendMessage("§eValor da loteria definido!");
				definindo.remove(p);
				definicoes.put("loteria_valor", e.getMessage());
				
			}else {
				p.sendMessage("§cApenas números.");
			}
			if(e.getMessage().equalsIgnoreCase("cancelar")) {
				e.setCancelled(true);
				definindo.remove(p);
				p.sendMessage("§cAção cancelada!");
			}
		
		}
		}
			if(definindo.containsKey(p)) {
		if(definindo.get(p).equals("loteria_numero")) {
			if(StringUtils.isNumeric(e.getMessage())) {
				definindo.remove(p);
				p.sendMessage("§eNúmero da loteria definido!");
				definicoes.put("loteria_numero", e.getMessage());
			}else {
				p.sendMessage("§cApenas números.");
			}
			if(e.getMessage().equalsIgnoreCase("cancelar")) {
				definindo.remove(p);
				p.sendMessage("§cAção cancelada!");
			}
		}
		}
		}
		
	@EventHandler
	public void aoClicarBolao(InventoryClickEvent e) {
	Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().contains("Eventos") || e.getInventory().getTitle().contains("Bolão")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getItemMeta() != null) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eBolão")) {
					Inventory menu = Mine.newInventory("Bolão", 9*3);
					ItemStack valor = Mine.newItem(Material.DOUBLE_PLANT, "§eDefinir valor");
					ItemStack iniciar = Mine.newItem(Material.EMERALD, "§eIniciar evento");
					
					menu.setItem(Mine.getPosition(2, 4), valor);
					menu.setItem(Mine.getPosition(2, 6), iniciar);
					
					p.openInventory(menu);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDefinir valor")) {
					
					definindo.put(p, "bolao_valor");
					p.getOpenInventory().close();
					p.sendMessage("§e§lDigite um valor para o evento.\n \n  §7Caso queira cancelar digite 'cancelar'.");
					definindo.put(p, "bolao_valor");
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eIniciar evento")) {
				if((!definicoes.containsKey("bolao_on")) || definicoes.get("bolao_on").equalsIgnoreCase("false")) {
					if(definicoes.get("bolao_valor") != null) {
					p.sendMessage("§aEvento iniciado!");
					p.getOpenInventory().close();
					definicoes.put("bolao_on", "true");
					if(definicoes.get("bolao_acumulado") == null) {
						definicoes.put("bolao_acumulado", "0");
					}
					new BukkitRunnable() {
						int i = 120;
						@Override
						public void run() {
							i--;
							if(i == 119) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.sendMessage(" \n§e§lEvento - Bolão\n \n§ePremiação: §6§l"+definicoes.get("bolao_acumulado")+"\n§eValor de participação: §6§l"+definicoes.get("bolao_valor")+"\n§ePara participar utilize §6/bolao\n \n§eChamadas restantes: 6");
									}
							}
							if(i == 100) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.sendMessage(" \n§e§lEvento - Bolão\n \n§ePremiação: §6§l"+definicoes.get("bolao_acumulado")+"\n§eValor de participação: §6§l"+definicoes.get("bolao_valor")+"\n§ePara participar utilize §6/bolao\n \n§eChamadas restantes: 5");
									}
							}
							if(i == 80) {
								for(Player all : Bukkit.getOnlinePlayers()) {
										all.sendMessage(" \n§e§lEvento - Bolão\n \n§ePremiação: §6§l"+definicoes.get("bolao_acumulado")+"\n§eValor de participação: §6§l"+definicoes.get("bolao_valor")+"\n§ePara participar utilize §6/bolao\n \n§eChamadas restantes: 4");
										}
							}
							if(i == 60) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.sendMessage(" \n§e§lEvento - Bolão\n \n§ePremiação: §6§l"+definicoes.get("bolao_acumulado")+"\n§eValor de participação: §6§l"+definicoes.get("bolao_valor")+"\n§ePara participar utilize §6/bolao\n \n§eChamadas restantes: 3");
									}
							}
							if(i == 40) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.sendMessage(" \n§e§lEvento - Bolão\n \n§ePremiação: §6§l"+definicoes.get("bolao_acumulado")+"\n§eValor de participação: §6§l"+definicoes.get("bolao_valor")+"\n§ePara participar utilize §6/bolao\n \n§eChamadas restantes: 2");
									}
							}
							if(i == 20) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.sendMessage(" \n§e§lEvento - Bolão\n \n§ePremiação: §6§l"+definicoes.get("bolao_acumulado")+"\n§eValor de participação: §6§l"+definicoes.get("bolao_valor")+"\n§ePara participar utilize §6/bolao\n \n§eChamadas restantes: 1");
									}
							}
							if(i == 0) {
								cancel();
								if(ComandoBolao.part.size() > 0) {
								Player ganhador = Mine.getRandomPlayer(ComandoBolao.part);
								
								new BukkitRunnable() {
									int i2 = 5;
									@Override
									public void run() {
										i2--;
										if(i2 <= 5) {
										Mine.sendTitle("§2§lSorteando...", "§a§kAAAAAAAAAAAAAAAAAAA", 0, 30, 0);
									}
										if(i2 == 0) {
											Mine.sendTitle("§2§lBolão - Vencedor", "§a"+ganhador.getName(), 5, 100, 5);
											VaultAPI.getEconomy().depositPlayer(ganhador, Mine.toInt(definicoes.get("bolao_acumulado")));
											ganhador.sendMessage("§aPremiação entregue! (+$"+definicoes.get("bolao_acumulado")+")");
											definicoes.remove("bolao_valor");
											definicoes.remove("bolao_acumulado");
											ComandoBolao.part.clear();
											cancel();
										}
									}
								}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
								definicoes.put("bolao_on", "false");
							}else {
								cancel();
								definicoes.remove("bolao_valor");
								definicoes.remove("bolao_acumulado");
								definicoes.put("bolao_on", "false");
								ComandoBolao.part.clear();
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.sendMessage(" \n§e§lEvento - Bolão\n \n§eNenhum jogador participou, evento cancelado.\n ");
									}
							}
							}
						}
					}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
			}else {
				p.getOpenInventory().close();
				p.sendMessage("§cDefina o valor do bolão.");
			}
			}else {
				p.getOpenInventory().close();
				p.sendMessage("§cO evento já está ocorrendo.");
			}
						}
		}
			}
					}
}

	@EventHandler
	public void aoFalarBolao(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(definindo.containsKey(p)) {
		if(definindo.get(p).equals("bolao_valor")) {
			if(StringUtils.isNumeric(e.getMessage())) {
				e.setCancelled(true);
				p.sendMessage("§eValor do bolão definido!");
				definindo.remove(p);
				definicoes.put("bolao_valor", e.getMessage());
			}else {
				p.sendMessage("§cApenas números.");
			}
			if(e.getMessage().equalsIgnoreCase("cancelar")) {
				e.setCancelled(true);
				definindo.remove(p);
				p.sendMessage("§cAção cancelada!");
			}
		}
		}
}
	
	@EventHandler
	public void aoClicarPalavra(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().contains("Eventos") || e.getInventory().getTitle().contains("Palavra")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getItemMeta() != null) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§ePalavra")) {
					Inventory menu = Mine.newInventory("Palavra", 9*3);
					ItemStack palavra = Mine.newItem(Material.PAPER, "§eDefinir palavra");
					ItemStack premio = Mine.newItem(Material.DOUBLE_PLANT, "§eDefinir valor");
					ItemStack iniciar = Mine.newItem(Material.EMERALD, "§eIniciar evento");
					
					menu.setItem(Mine.getPosition(2, 3), premio);
					menu.setItem(Mine.getPosition(2, 5), palavra);
					menu.setItem(Mine.getPosition(2, 7), iniciar);
					
					p.openInventory(menu);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDefinir palavra")) {
					
					definindo.put(p, "palavra_palavra");
					p.getOpenInventory().close();
					p.sendMessage("§eDigite uma palavra de no máximo §6§l50 caracteres §ee §6§lSem espaçamentos §epara o evento.\n \n  §7Caso queira cancelar digite 'cancelar'.");
					definindo.put(p, "palavra_palavra");
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDefinir valor")) {
					
					definindo.put(p, "palavra_valor");
					p.getOpenInventory().close();
					p.sendMessage("§e§lDigite o valor para o evento.\n \n  §7Caso queira cancelar digite 'cancelar'.");
					definindo.put(p, "palavra_valor");
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eIniciar evento")) {
					if((!definicoes.containsKey("palavra_on")) || definicoes.get("palavra_on").equalsIgnoreCase("false")) {
					if(definicoes.get("palavra_palavra") != null) {
						if(definicoes.get("palavra_valor") != null) {
					p.sendMessage("§aEvento iniciado!");
					p.getOpenInventory().close();
					definicoes.put("palavra_on", "true");
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.sendMessage("§e§lEvento - Palavra\n \n§eEm §6§l30 segundos §eirá iniciar um evento §6§lpalavra§e!\n \n§eSerá apresentada uma palavra no chat, e o primeiro jogador\nque digitar §6§l/palavra <Palavra apresentada> §eserá o vencedor do evento.\n \nPremiação: §6§l"+definicoes.get("palavra_valor"));
						new BukkitRunnable() {
							
							@Override
							public void run() {
								all.sendMessage("§e§lEvento - Palavra\n \n§eA palavra da vez é:\n \n§6"+definicoes.get("palavra_palavra")+"\n \n§ePara participar utilize: /palavra <Palavra apresentada>.");
							}
						}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 30*20);
					}
						}else {
							p.getOpenInventory().close();
							p.sendMessage("§cDefina o valor do evento.");
						}
					}else {
						p.getOpenInventory().close();
						p.sendMessage("§cDefina a palavra do evento.");
					}
					}else {
						p.getOpenInventory().close();
						p.sendMessage("§cO evento já está ocorrendo.");
					}
				}
			}
			}
		}
	}

	@EventHandler
	public void aoFalarPalavra(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(definindo.containsKey(p)) {
		if(definindo.get(p).equals("palavra_palavra")) {
			if(!(e.getMessage().equalsIgnoreCase("cancelar"))) {
			if(StringUtils.length(e.getMessage()) <= 50) {
				if(!(StringUtils.containsAny(e.getMessage(), " "))) {
					e.setCancelled(true);
				definindo.remove(p);
				p.sendMessage("§ePalavra do evento palavra definido!");
				definicoes.put("palavra_palavra", e.getMessage());
			}else {
				p.sendMessage("§cA palavra não pode ter espaçamentos.");
			}
			}else {
				p.sendMessage("§cA palavra precisa possuir 50 caracteres ou menos.");
			}
			}
		}
			if(e.getMessage().equalsIgnoreCase("cancelar")) {
				e.setCancelled(true);
				definindo.remove(p);
				p.sendMessage("§cAção cancelada!");
			}
		}
		if(definindo.containsKey(p)) {
	if(definindo.get(p).equals("palavra_valor")) {
		if(StringUtils.isNumeric(e.getMessage())) {
		definindo.remove(p);
		p.sendMessage("§eValor do evento palavra definido!");
		definicoes.put("palavra_valor", e.getMessage());
	}else {
		p.sendMessage("§cApenas números.");
		}
	}else {
		return;
	}
	}
	}

	@EventHandler 
	public void aoClicarSorteio(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().contains("Eventos") || e.getInventory().getTitle().contains("Sorteio")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getItemMeta() != null) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eSorteio")) {
					Inventory menu = Mine.newInventory("Sorteio", 9*3);
					ItemStack valor = Mine.newItem(Material.DOUBLE_PLANT, "§eDefinir prêmio");
					ItemStack iniciar = Mine.newItem(Material.EMERALD, "§eIniciar evento");
					
					menu.setItem(Mine.getPosition(2, 4), valor);
					menu.setItem(Mine.getPosition(2, 6), iniciar);
					
					p.openInventory(menu);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDefinir prêmio")) {
					
					definindo.put(p, "sorteio_premio");
					p.getOpenInventory().close();
					p.sendMessage("§e§lDigite o prêmio para o evento.\n \n  §7Caso queira cancelar digite 'cancelar'.");
					definindo.put(p, "sorteio_premio");
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eIniciar evento")) {
					if((!definicoes.containsKey("sorteio_on")) || definicoes.get("sorteio_on").equalsIgnoreCase("false")) {
					if(definicoes.get("sorteio_premio") != null) {
					p.sendMessage("§aEvento iniciado!");
					p.getOpenInventory().close();
					definicoes.put("sorteio_on", "true");
					new BukkitRunnable() {
						int i = 120;
						@Override
						public void run() {
							i--;
							if(i == 119) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.sendMessage("§e§lEvento - Sorteio\n \n§ePremiação: §6"+definicoes.get("sorteio_premio")+"\n \n§ePara participar utilize §6§l/sorteio\n \n§eChamadas restantes: 6");
									}
							}
							if(i == 100) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.sendMessage("§e§lEvento - Sorteio\n \n§ePremiação: §6"+definicoes.get("sorteio_premio")+"\n \n§ePara participar utilize §6§l/sorteio\n \n§eChamadas restantes: 5");
									}
							}
							if(i == 80) {
								for(Player all : Bukkit.getOnlinePlayers()) {
										all.sendMessage("§e§lEvento - Sorteio\n \n§ePremiação: §6"+definicoes.get("sorteio_premio")+"\n \n§ePara participar utilize §6§l/sorteio\n \n§eChamadas restantes: 4");
										}
							}
							if(i == 60) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.sendMessage("§e§lEvento - Sorteio\n \n§ePremiação: §6"+definicoes.get("sorteio_premio")+"\n \n§ePara participar utilize §6§l/sorteio\n \n§eChamadas restantes: 3");
									}
							}
							if(i == 40) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.sendMessage("§e§lEvento - Sorteio\n \n§ePremiação: §6"+definicoes.get("sorteio_premio")+"\n \n§ePara participar utilize §6§l/sorteio\n \n§eChamadas restantes: 2");
									}
							}
							if(i == 20) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.sendMessage("§e§lEvento - Sorteio\n \n§ePremiação: §6"+definicoes.get("sorteio_premio")+"\n \n§ePara participar utilize §6§l/sorteio\n \n§eChamadas restantes: 1");
									}
							}
							if(i == 0) {
								cancel();
								if(ComandoSorteio.part.size() > 0) {
								Player ganhador = Mine.getRandomPlayer(ComandoSorteio.part);
								new BukkitRunnable() {
									int i2 = 5;
									@Override
									public void run() {
										i2--;
										if(i2 <= 5) {
										Mine.sendTitle("§2§lSorteando...", "§a§kAAAAAAAAAAAAAAAAAAA", 0, 30, 0);
										}
										if(i2 == 0) {
											Mine.sendTitle("§2§lSorteio - Vencedor", "§a"+ganhador.getName(), 5, 100, 5);
											ComandoSorteio.part.clear();
											definicoes.remove("sorteio_premio");
											cancel();
										}
									}
								}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
								definicoes.put("sorteio_on", "false");
							}else {
								ComandoSorteio.part.clear();
								definicoes.remove("sorteio_premio");
								definicoes.put("sorteio_on", "false");
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.sendMessage("§e§lEvento - Sorteio\n \n§eNenhum jogador participou, evento cancelado.\n ");
									}
							}
							}
						}
					}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
			}else {
				p.getOpenInventory().close();
				p.sendMessage("§cDefina o prêmio do sorteio.");
			}
			}else {
				p.getOpenInventory().close();
				p.sendMessage("§cO evento já está ocorrendo.");
			}
						}
		}
			}
					}
	}

	@EventHandler
	public void aoFalarSorteio(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(definindo.containsKey(p)) {
		if(definindo.get(p).equals("sorteio_premio")) {
				e.setCancelled(true);
				p.sendMessage("§ePrêmio do sorteio definido!");
				definindo.remove(p);
				definicoes.put("sorteio_premio", e.getMessage());
			if(e.getMessage().equalsIgnoreCase("cancelar")) {
				e.setCancelled(true);
				definindo.remove(p);
				p.sendMessage("§cAção cancelada!");
			}
		}
		}
	}
}
