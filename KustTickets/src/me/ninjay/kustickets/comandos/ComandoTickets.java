package me.ninjay.kustickets.comandos;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.kustickets.estruturas.DataAPI;
import me.ninjay.kustickets.main.Main;
import me.ninjay.kustickets.utils.Mine;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ClickEvent.Action;

public class ComandoTickets implements CommandExecutor, Listener{
	
	public static HashMap<String, String> value = new HashMap<>();
	public static HashMap<String, String> save = new HashMap<>();
	public static ArrayList<Player> delay = new ArrayList<>();
	public static HashMap<String, String> saveres = new HashMap<>();
	public static ItemStack avancar = Mine.newItem(Material.ARROW, "§aPróximo");
	public static ItemStack voltar = Mine.newItem(Material.ARROW, "§aAnterior");
	public static HashMap<Player, Integer> saveint = new HashMap<>(); 
	public static ItemStack vazio = Mine.newItem(Material.WEB, "§cNenhum registro encontrado", 1, 0, " ", "§7Retorne ao ticket anterior...");
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;

			//INSERT INTO `youtuber` (`NICK`, `DATA`, `NOME`, `LINK`, `ID`) VALUES ('Ninjay', '30/03/2021', 'Matheus', 'youtube.com', NULL)
			
			//Main.sql.update("INSERT INTO `youtuber` (`NICK`, `DATA`, `NOME`, `LINK`, `ID`) VALUES ('"+p.getName()+"', '08/04/2021', 'teste', 'youtube.com/c/luizh222', NULL)");
		
			//p.sendMessage(Main.sql.getString("youtuber", "LINK", "ID=3"));
		
			Inventory principal = Mine.newInventory("Tickets", 9*3);
			
			ItemStack antigos = Mine.newHead("§eÚltimo ticket", p.getName(), 1);
			ItemStack abrir = Mine.newHead("§eAbrir ticket", "Lime", 1);
			ItemStack chamar = Mine.newHead("§eChamar um membro da equipe", "Addelburgh", 1);
			ItemStack armazem = Mine.newHead("§eResponder tickets enviados", "ElMarcosFTW", 1);
			
			principal.setItem(Mine.getPosition(2, 3), antigos);
			principal.setItem(Mine.getPosition(2, 7), abrir);
			principal.setItem(Mine.getPosition(2, 5), chamar);
			
			p.sendMessage("§aVocê abriu a área de tickets!");
			
		if(p.hasPermission("ticket.admin")) {
			principal.setItem(Mine.getPosition(3, 9), armazem);
			p.openInventory(principal);
		}else {
			p.openInventory(principal);
		}
			
		}
		return false;
	}
	
	@EventHandler
	public static void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().contains("Tickets") || e.getInventory().getTitle().contains("Qual o motivo do ticket?")) {
			e.setCancelled(true);
		if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eChamar um membro")) {
						if(!delay.contains(p)) {
						p.closeInventory();
						p.sendMessage("§aVocê chamou um membro da equipe! Aguarde ser atendido.");
						delay.add(p);
						
						for(Player todos : Bukkit.getOnlinePlayers()) {
							if(todos.hasPermission("ticket.request")) {
								TextComponent request = new TextComponent(TextComponent.fromLegacyText(" \n§aUm membro da equipe foi solicitado!\n \n§aJogador: "+p.getName()+"\n \n§e§lCLIQUE AQUI §apara se teleportar até o mesmo.\n "));
								request.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/tp "+p.getName()));
						        todos.spigot().sendMessage(request);
							}
							
						}
						
						new BukkitRunnable() {
							
							@Override
							public void run() {
								delay.remove(p);
							}
						}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 60*20);
					}else {
						p.getOpenInventory().close();
						p.sendMessage("§cAguarde para usar novamente.");
					}
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eAbrir ticket")) {
						Inventory menu = Mine.newInventory("Qual o motivo do ticket?", 9*3);
						
						ItemStack duvida = Mine.newHead("§eDúvida", "MHF_Question", 1, " ", " §7Retire suas dúvidas.");
						ItemStack youtuber = Mine.newHead("§eTag Youtuber", "MHF_Youtube", 1, " ", " §7Solicite sua tag youtuber.");
						ItemStack denuncia = Mine.newHead("§eDenúncia", "MHF_ArrowDown", 1, " ", " §7Denuncie um jogador suspeito.");
						ItemStack revisao = Mine.newHead("§eRevisão", "Olaf_C", 1, " ", " §7Solicite a revisão de uma punição.");
						ItemStack erro = Mine.newHead("§eErros", "Earth", 1, " ", " §7Denuncie problemas e falhas do servidor.");
					
						menu.setItem(Mine.getPosition(2, 3), duvida);
						menu.setItem(Mine.getPosition(2, 4), youtuber);
						menu.setItem(Mine.getPosition(2, 5), erro);
						menu.setItem(Mine.getPosition(2, 6), denuncia);
						menu.setItem(Mine.getPosition(2, 7), revisao);
						
						p.getOpenInventory().close();
						p.openInventory(menu);
						
					}
					
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eResponder tickets enviados")) {
						//select last_insert_id() from erros
						//SELECT min(ID) FROM erros
							
						Inventory menu = Mine.newInventory("Escolha uma categoria", 9*3);

						ItemStack duvida = Mine.newHead("§eDúvida", "MHF_Question", 1, " ", " §cNenhum ticket pendente", " §7Cargo: §e[Ajudante]");
						ItemStack youtuber = Mine.newHead("§eTag Youtuber", "MHF_Youtube", 1, " ", " §cNenhum ticket pendente", " §7Cargo: §4[Coordenador]");
						ItemStack denuncia = Mine.newHead("§eDenúncia", "MHF_ArrowDown", 1, " ", " §cNenhum ticket pendente", " §7Cargo: §2[Moderador]");
						ItemStack revisao = Mine.newHead("§eRevisão", "Olaf_C", 1, " ", " §cNenhum ticket pendente",  " §7Cargo: §4[Coordenador]");
						ItemStack erro = Mine.newHead("§eErros", "Earth", 1, " ", " §cNenhum ticket pendente",  " §7Cargo: §4[Coordenador]");
						
						ItemStack duvida1 = Mine.newHead("§eDúvida", "MHF_Question", 1, " ", " §eExistem tickets pendentes", " §7Cargo: §e[Ajudante]");
						ItemStack youtuber1 = Mine.newHead("§eTag Youtuber", "MHF_Youtube", 1, " ", " §eExistem tickets pendentes", " §7Cargo: §4[Coordenador]");
						ItemStack denuncia1 = Mine.newHead("§eDenúncia", "MHF_ArrowDown", 1, " ", " §eExistem tickets pendentes", " §7Cargo: §2[Moderador]");
						ItemStack revisao1 = Mine.newHead("§eRevisão", "Olaf_C", 1, " ", " §eExistem tickets pendentes",  " §7Cargo: §4[Coordenador]");
						ItemStack erro1 = Mine.newHead("§eErros", "Earth", 1, " ", " §eExistem tickets pendentes",  " §7Cargo: §4[Coordenador]");
					
					if(Main.sql.contains("duvida", "ID='1'")) {
						menu.setItem(Mine.getPosition(2, 3), duvida1);
					}else {
						menu.setItem(Mine.getPosition(2, 3), duvida);
					}
					
					if(Main.sql.contains("youtuber", "ID='1'")) {
						menu.setItem(Mine.getPosition(2, 4), youtuber1);
					}else {
						menu.setItem(Mine.getPosition(2, 4), youtuber);
					}
					
					if(Main.sql.contains("erros", "ID='1'")) {
						menu.setItem(Mine.getPosition(2, 5), erro1);
					}else {
						menu.setItem(Mine.getPosition(2, 5), erro);
					}
					
					if(Main.sql.contains("denuncia", "ID='1'")) {
						menu.setItem(Mine.getPosition(2, 6), denuncia1);
					}else {
						menu.setItem(Mine.getPosition(2, 6), denuncia);
					}
					if(Main.sql.contains("revisao", "ID='1'")) {
						menu.setItem(Mine.getPosition(2, 7), revisao1);
					}else {
						menu.setItem(Mine.getPosition(2, 7), revisao);
					}
						
						p.getOpenInventory().close();
						
						if(!saveint.containsKey(p)) {
							saveint.put(p, 1);
						}
						
						p.openInventory(menu);
					}
					
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eÚltimo ticket")) {
						if(Main.sql.contains("denuncia", "NICK='"+p.getName()+"'")) {
							if(Main.sql.getString("denuncia", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false")) {
								p.getOpenInventory().close();
								p.sendMessage("§cSeu ticket ainda não foi respondido, você será alertado quando isso ocorrer.");
							}
						}
						if(Main.sql.contains("duvida", "NICK='"+p.getName()+"'")) {
							if(Main.sql.getString("duvida", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false")) {
								p.getOpenInventory().close();
								p.sendMessage("§cSeu ticket ainda não foi respondido, você será alertado quando isso ocorrer.");
							}
						}
						if(Main.sql.contains("erros", "NICK='"+p.getName()+"'")) {
							if(Main.sql.getString("erros", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false")) {
								p.getOpenInventory().close();
								p.sendMessage("§cSeu ticket ainda não foi respondido, você será alertado quando isso ocorrer.");
							}
						}
						if(Main.sql.contains("revisao", "NICK='"+p.getName()+"'")) {
							if(Main.sql.getString("revisao", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false")) {
								p.getOpenInventory().close();
								p.sendMessage("§cSeu ticket ainda não foi respondido, você será alertado quando isso ocorrer.");
							}
						}
						if(Main.sql.contains("youtuber", "NICK='"+p.getName()+"'")) {
							if(Main.sql.getString("youtuber", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false")) {
								p.getOpenInventory().close();
								p.sendMessage("§cSeu ticket ainda não foi respondido, você será alertado quando isso ocorrer.");
							}
						}
						if(!Main.sql.contains("denuncia", "NICK='"+p.getName()+"'") && !Main.sql.contains("duvida", "NICK='"+p.getName()+"'") && !Main.sql.contains("erros", "NICK='"+p.getName()+"'") && !Main.sql.contains("revisao", "NICK='"+p.getName()+"'") && !Main.sql.contains("youtuber", "NICK='"+p.getName()+"'")) {
							if(!Main.sql.contains("respostas", "NICK='"+p.getName()+"'")) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê não possuí tickets pendentes.");
							}else {
								p.getOpenInventory().close();
								p.sendMessage("§a§lResposta para seu ticket:\n \n§e"+Main.sql.getString("respostas", "RESPOSTA", "NICK='"+p.getName()+"'")+"\n ");
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
								Main.sql.delete("respostas", "NICK='"+p.getName()+"'", "RESPOSTA");
							}
						}
						
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDúvida")) {
						if(!Main.sql.contains("duvida", "NICK='"+p.getName()+"'")) {
							if(!Main.sql.contains("denuncia", "NICK='"+p.getName()+"'")) {
								if(!Main.sql.contains("erros", "NICK='"+p.getName()+"'")) {
									if(!Main.sql.contains("revisao", "NICK='"+p.getName()+"'")) {
										if(!Main.sql.contains("youtuber", "NICK='"+p.getName()+"'")) {
											if(!Main.sql.contains("respostas", "NICK='"+p.getName()+"'")) {
						p.getOpenInventory().close();
						
						TextComponent texto = new TextComponent(TextComponent.fromLegacyText("§eDigite a área da sua dúvida ou §c§lCLIQUE AQUI §epara cancelar o §eenvio.\n \n§7Exemplo: Factions"));
						texto.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
						p.spigot().sendMessage(texto);
						value.put(p.getName(), "duvida1");
											}else {
												if(Main.sql.contains("respostas", "NICK='"+p.getName()+"'")) {
													p.getOpenInventory().close();
													p.sendMessage("§cVocê pode criar apenas um ticket por vez, leia a resposta do seu último ticket em 'Último ticket' para liberar a criação.");
												}
											}
											}
						}
						}
						}
						}
						if(Main.sql.contains("duvida", "NICK='"+p.getName()+"'") || Main.sql.contains("denuncia", "NICK='"+p.getName()+"'") || Main.sql.contains("erros", "NICK='"+p.getName()+"'") || Main.sql.contains("revisao", "NICK='"+p.getName()+"'") || Main.sql.contains("youtuber", "NICK='"+p.getName()+"'")) {
							if(Main.sql.getString("duvida", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("denuncia", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("erros", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("revisao", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("youtuber", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false")) {
								p.getOpenInventory().close();
								p.sendMessage("§cVocê pode criar apenas um ticket por vez, aguarde a resposta do seu último ticket para criar outro.");
							} 
						}
						
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eTag Youtuber")) {
						if(!Main.sql.contains("duvida", "NICK='"+p.getName()+"'")) {
							if(!Main.sql.contains("denuncia", "NICK='"+p.getName()+"'")) {
								if(!Main.sql.contains("erros", "NICK='"+p.getName()+"'")) {
									if(!Main.sql.contains("revisao", "NICK='"+p.getName()+"'")) {
										if(!Main.sql.contains("youtuber", "NICK='"+p.getName()+"'")) {
											if(!Main.sql.contains("respostas", "NICK='"+p.getName()+"'")) {
						p.getOpenInventory().close();
						
						TextComponent texto = new TextComponent(TextComponent.fromLegacyText("§eDigite o nome do canal ou §c§lCLIQUE AQUI §epara cancelar o §eenvio."));
						texto.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
						p.spigot().sendMessage(texto);
						value.put(p.getName(), "youtuber1");
											}else {
													p.getOpenInventory().close();
													p.sendMessage("§cVocê pode criar apenas um ticket por vez, leia a resposta do seu último ticket em 'Último ticket' para liberar a criação.");
											}
					}
									}
								}
							}
						}
						if(Main.sql.contains("duvida", "NICK='"+p.getName()+"'") || Main.sql.contains("denuncia", "NICK='"+p.getName()+"'") || Main.sql.contains("erros", "NICK='"+p.getName()+"'") || Main.sql.contains("revisao", "NICK='"+p.getName()+"'") || Main.sql.contains("youtuber", "NICK='"+p.getName()+"'")) {
							if(Main.sql.getString("duvida", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("denuncia", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("erros", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("revisao", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("youtuber", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false")) {
								p.getOpenInventory().close();
								p.sendMessage("§cVocê pode criar apenas um ticket por vez, aguarde a resposta do seu último ticket para criar outro.");
							} 
						}
						
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eErros")) {
						if(!Main.sql.contains("duvida", "NICK='"+p.getName()+"'")) {
							if(!Main.sql.contains("denuncia", "NICK='"+p.getName()+"'")) {
								if(!Main.sql.contains("erros", "NICK='"+p.getName()+"'")) {
									if(!Main.sql.contains("revisao", "NICK='"+p.getName()+"'")) {
										if(!Main.sql.contains("youtuber", "NICK='"+p.getName()+"'")) {
											if(!Main.sql.contains("respostas", "NICK='"+p.getName()+"'")) {
						p.getOpenInventory().close();
						
						TextComponent texto = new TextComponent(TextComponent.fromLegacyText(ChatColor.YELLOW + "§eDigite a área que ocorre a falha ou §c§lCLIQUE AQUI"+ ChatColor.YELLOW+ "§e para cancelar o §eenvio.\n \n§7Exemplo: Factions"));
						texto.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
						p.spigot().sendMessage(texto);
						value.put(p.getName(), "erros1");
					}else {
						if(Main.sql.contains("respostas", "NICK='"+p.getName()+"'")) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê pode criar apenas um ticket por vez, leia a resposta do seu último ticket em 'Último ticket' para liberar a criação.");
						}
					}
										}
									}
								}
							}
						}
						if(Main.sql.contains("duvida", "NICK='"+p.getName()+"'") || Main.sql.contains("denuncia", "NICK='"+p.getName()+"'") || Main.sql.contains("erros", "NICK='"+p.getName()+"'") || Main.sql.contains("revisao", "NICK='"+p.getName()+"'") || Main.sql.contains("youtuber", "NICK='"+p.getName()+"'")) {
							if(Main.sql.getString("duvida", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("denuncia", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("erros", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("revisao", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("youtuber", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false")) {
								p.getOpenInventory().close();
								p.sendMessage("§cVocê pode criar apenas um ticket por vez, aguarde a resposta do seu último ticket para criar outro.");
							} 
							if(Main.sql.contains("respostas", "NICK='"+p.getName()+"'")) {
								p.getOpenInventory().close();
								p.sendMessage("§cVocê pode criar apenas um ticket por vez, leia a resposta do seu último ticket em 'Último ticket' para liberar a criação.");
							}
						}
						
					}
					
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDenúncia")) {
						if(!Main.sql.contains("duvida", "NICK='"+p.getName()+"'")) {
							if(!Main.sql.contains("denuncia", "NICK='"+p.getName()+"'")) {
								if(!Main.sql.contains("erros", "NICK='"+p.getName()+"'")) {
									if(!Main.sql.contains("revisao", "NICK='"+p.getName()+"'")) {
										if(!Main.sql.contains("youtuber", "NICK='"+p.getName()+"'")) {
											if(!Main.sql.contains("respostas", "NICK='"+p.getName()+"'")) {
						p.getOpenInventory().close();
						
						TextComponent texto = new TextComponent(TextComponent.fromLegacyText(ChatColor.YELLOW + "§eDigite o nickname do acuasdo ou §c§lCLIQUE AQUI"+ ChatColor.YELLOW+ "§e para cancelar o §eenvio."));
						texto.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
						p.spigot().sendMessage(texto);
						value.put(p.getName(), "denuncia1");
											}else {
												if(Main.sql.contains("respostas", "NICK='"+p.getName()+"'")) {
													p.getOpenInventory().close();
													p.sendMessage("§cVocê pode criar apenas um ticket por vez, leia a resposta do seu último ticket em 'Último ticket' para liberar a criação.");
												}
											}
					}
									}
								}
							}
						}
						if(Main.sql.contains("duvida", "NICK='"+p.getName()+"'") || Main.sql.contains("denuncia", "NICK='"+p.getName()+"'") || Main.sql.contains("erros", "NICK='"+p.getName()+"'") || Main.sql.contains("revisao", "NICK='"+p.getName()+"'") || Main.sql.contains("youtuber", "NICK='"+p.getName()+"'")) {
							if(Main.sql.getString("duvida", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("denuncia", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("erros", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("revisao", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("youtuber", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false")) {
								p.getOpenInventory().close();
								p.sendMessage("§cVocê pode criar apenas um ticket por vez, aguarde a resposta do seu último ticket para criar outro.");
							} 
							if(Main.sql.contains("respostas", "NICK='"+p.getName()+"'")) {
								p.getOpenInventory().close();
								p.sendMessage("§cVocê pode criar apenas um ticket por vez, leia a resposta do seu último ticket em 'Último ticket' para liberar a criação.");
							}
						}
						
					}
					
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eRevisão")) {
						if(!Main.sql.contains("duvida", "NICK='"+p.getName()+"'")) {
							if(!Main.sql.contains("denuncia", "NICK='"+p.getName()+"'")) {
								if(!Main.sql.contains("erros", "NICK='"+p.getName()+"'")) {
									if(!Main.sql.contains("revisao", "NICK='"+p.getName()+"'")) {
										if(!Main.sql.contains("youtuber", "NICK='"+p.getName()+"'")) {
											if(!Main.sql.contains("respostas", "NICK='"+p.getName()+"'")) {
						p.getOpenInventory().close();
						
						TextComponent texto = new TextComponent(TextComponent.fromLegacyText(ChatColor.YELLOW + "§eDigite o nickname do jogador banido ou §c§lCLIQUE AQUI"+ ChatColor.YELLOW+ "§e para cancelar o §eenvio."));
						texto.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
						p.spigot().sendMessage(texto);
						value.put(p.getName(), "revisao1");
											}else {
												if(Main.sql.contains("respostas", "NICK='"+p.getName()+"'")) {
													p.getOpenInventory().close();
													p.sendMessage("§cVocê pode criar apenas um ticket por vez, leia a resposta do seu último ticket em 'Último ticket' para liberar a criação.");
												}
											}
					}
									}
								}
							}
						}
						if(Main.sql.contains("duvida", "NICK='"+p.getName()+"'") || Main.sql.contains("denuncia", "NICK='"+p.getName()+"'") || Main.sql.contains("erros", "NICK='"+p.getName()+"'") || Main.sql.contains("revisao", "NICK='"+p.getName()+"'") || Main.sql.contains("youtuber", "NICK='"+p.getName()+"'")) {
							if(Main.sql.getString("duvida", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("denuncia", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("erros", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("revisao", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false") || Main.sql.getString("youtuber", "LIDO", "NICK='"+p.getName()+"'").equalsIgnoreCase("false")) {
								p.getOpenInventory().close();
								p.sendMessage("§cVocê pode criar apenas um ticket por vez, aguarde a resposta do seu último ticket para criar outro.");
							} 
							if(Main.sql.contains("respostas", "NICK='"+p.getName()+"'")) {
								p.getOpenInventory().close();
								p.sendMessage("§cVocê pode criar apenas um ticket por vez, leia a resposta do seu último ticket em 'Último ticket' para liberar a criação.");
							}
						}
						
					}
				}
			}
		}
		Inventory duvidas = Mine.newInventory("Dúvidas enviadas", 9*3);
		if(e.getInventory().getTitle().equalsIgnoreCase("Escolha uma categoria")) {
			e.setCancelled(true);
			p.updateInventory();
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDúvida")) {
				
				duvidas.setItem(Mine.getPosition(2, 3), voltar);
				duvidas.setItem(Mine.getPosition(2, 7), avancar);
				
			if(Main.sql.contains("duvida", "NICK='"+getDuvidaNick(p)+"'")) {
				ItemStack head = Mine.newHead("§eTicket de "+getDuvidaNick(p), getDuvidaNick(p), 1, " ", " §7Área: §e"+getDuvidaArea(p), " ", " §7Dúvida: §e"+getDuvidaDuvida(p), " ", "§7Clique para gerar uma resposta");
				duvidas.setItem(Mine.getPosition(2, 5), head);
			}else {
				duvidas.setItem(Mine.getPosition(2, 5), vazio);
			}
			
			if(p.hasPermission("ticket.duvida")) {
				p.openInventory(duvidas);
			}
			}
				}
			}
		}
		
	if(e.getInventory().getTitle().contains("Dúvidas enviadas")) {
		if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getItemMeta() != null) {
				if(e.getCurrentItem().isSimilar(voltar)) {
					if(!saveint.containsKey(p) || saveint.get(p) <= 1) {
						saveint.put(p, 1);
						p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
						duvidas.setItem(Mine.getPosition(2, 3), voltar);
						duvidas.setItem(Mine.getPosition(2, 7), avancar);
						
					}else {
						saveint.put(p, saveint.get(p)-1);
						p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
						duvidas.setItem(Mine.getPosition(2, 3), voltar);
						duvidas.setItem(Mine.getPosition(2, 7), avancar);
					}
					
					if(Main.sql.contains("duvida", "NICK='"+getDuvidaNick(p)+"'")) {
						ItemStack head = Mine.newHead("§eTicket de "+getDuvidaNick(p), getDuvidaNick(p), 1, " ", " §7Área: §e"+getDuvidaArea(p), " ", " §7Dúvida: §e"+getDuvidaDuvida(p), " ", "§7Clique para gerar uma resposta");
						duvidas.setItem(Mine.getPosition(2, 5), head);
					}else {
						duvidas.setItem(Mine.getPosition(2, 5), vazio);
					}
					if(p.hasPermission("ticket.duvida")) {
					p.openInventory(duvidas);
					}
				}
			}
		}
	}

	if(e.getInventory().getTitle().contains("Dúvidas enviadas")) {
		if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getItemMeta() != null) {
				if(e.getCurrentItem().isSimilar(avancar)) {
					if(!saveint.containsKey(p)) {
						saveint.put(p, 2);
						p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
						duvidas.setItem(Mine.getPosition(2, 3), voltar);
						duvidas.setItem(Mine.getPosition(2, 7), avancar);
					
					}else {
						saveint.put(p, saveint.get(p)+1);
						p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
						duvidas.setItem(Mine.getPosition(2, 3), voltar);
						duvidas.setItem(Mine.getPosition(2, 7), avancar);
						
					}
					if(Main.sql.contains("duvida", "NICK='"+getDuvidaNick(p)+"'")) {
						ItemStack head = Mine.newHead("§eTicket de "+getDuvidaNick(p), getDuvidaNick(p), 1, " ", " §7Área: §e"+getDuvidaArea(p), " ", " §7Dúvida: §e"+getDuvidaDuvida(p), " ", "§7Clique para gerar uma resposta");
						duvidas.setItem(Mine.getPosition(2, 5), head);
					}else {
						duvidas.setItem(Mine.getPosition(2, 5), vazio);
					}
					if(p.hasPermission("ticket.duvida")) {
					p.openInventory(duvidas);
					}
				}
			}
		}
	}
	
	if(e.getInventory().getTitle().equalsIgnoreCase("Dúvidas enviadas")) {
		e.setCancelled(true);
		if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getItemMeta() != null) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eTicket de ")) {
					p.getOpenInventory().close();
					p.sendMessage("§a§lDigite a resposta para o ticket.\n \n§aCategoria: §eDúvidas\n§aNick: §e"+getDuvidaNick(p)+"\n§aÁrea: §e"+getDuvidaArea(p)+"\n \n§aDúvida: §e"+getDuvidaDuvida(p)+"\n ");
					TextComponent cancelar = new TextComponent(TextComponent.fromLegacyText("§c§lCLIQUE AQUI §apara cancelar a ação."));
					cancelar.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
					p.spigot().sendMessage(cancelar);
					saveres.put(p.getName(), "duvidas");
				}
			}
		}
	}
	Inventory youtuber = Mine.newInventory("Youtuber enviados", 9*3);
	if(e.getInventory().getTitle().equalsIgnoreCase("Escolha uma categoria")) {
		e.setCancelled(true);
		p.updateInventory();
		if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getItemMeta() != null) {
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eTag Youtuber")) {
			
			youtuber.setItem(Mine.getPosition(2, 3), voltar);
			youtuber.setItem(Mine.getPosition(2, 7), avancar);
			
		if(Main.sql.contains("youtuber", "NICK='"+getYoutuberNick(p)+"'")) {
			ItemStack head = Mine.newHead("§eTicket de "+getYoutuberNick(p), getYoutuberNick(p), 1, " ", " §7Nome do canal: §e"+getYoutuberNome(p), " ", " §7Discord: §e"+getYoutuberDiscord(p), " ", " §7Link do canal: §e"+getYoutuberLink(p), " ",  "§7Clique para gerar uma resposta");
			youtuber.setItem(Mine.getPosition(2, 5), head);
		}else {
			youtuber.setItem(Mine.getPosition(2, 5), vazio);
		}
		if(p.hasPermission("ticket.youtuber")) {
			p.openInventory(youtuber);
		}
		}
			}
		}
	}
	
		if(e.getInventory().getTitle().contains("Youtuber enviados")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().isSimilar(voltar)) {
						if(!saveint.containsKey(p) || saveint.get(p) <= 1) {
							saveint.put(p, 1);
							p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
							youtuber.setItem(Mine.getPosition(2, 3), voltar);
							youtuber.setItem(Mine.getPosition(2, 7), avancar);
							
						}else {
							saveint.put(p, saveint.get(p)-1);
							p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
							youtuber.setItem(Mine.getPosition(2, 3), voltar);
							youtuber.setItem(Mine.getPosition(2, 7), avancar);
						}
						
						if(Main.sql.contains("youtuber", "NICK='"+getYoutuberNick(p)+"'")) {
							ItemStack head = Mine.newHead("§eTicket de "+getYoutuberNick(p), getYoutuberNick(p), 1, " ", " §7Nome do canal: §e"+getYoutuberNome(p), " ", " §7Discord: §e"+getYoutuberDiscord(p), " ", " §7Link do canal: §e"+getYoutuberLink(p), " ",  "§7Clique para gerar uma resposta");
							youtuber.setItem(Mine.getPosition(2, 5), head);
						}else {
							youtuber.setItem(Mine.getPosition(2, 5), vazio);
						}
						if(p.hasPermission("ticket.youtuber")) {
						p.openInventory(youtuber);
						}
					}
				}
			}
		}
		
		if(e.getInventory().getTitle().contains("Youtuber enviados")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().isSimilar(avancar)) {
						if(!saveint.containsKey(p)) {
							saveint.put(p, 2);
							p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
							youtuber.setItem(Mine.getPosition(2, 3), voltar);
							youtuber.setItem(Mine.getPosition(2, 7), avancar);
						
						}else {
							saveint.put(p, saveint.get(p)+1);
							p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
							youtuber.setItem(Mine.getPosition(2, 3), voltar);
							youtuber.setItem(Mine.getPosition(2, 7), avancar);
							
						}
						if(Main.sql.contains("youtuber", "NICK='"+getYoutuberNick(p)+"'")) {
							ItemStack head = Mine.newHead("§eTicket de "+getYoutuberNick(p), getYoutuberNick(p), 1, " ", " §7Nome do canal: §e"+getYoutuberNome(p), " ", " §7Discord: §e"+getYoutuberDiscord(p), " ", " §7Link do canal: §e"+getYoutuberLink(p), " ",  "§7Clique para gerar uma resposta");
							youtuber.setItem(Mine.getPosition(2, 5), head);
						}else {
							youtuber.setItem(Mine.getPosition(2, 5), vazio);
						}
						if(p.hasPermission("ticket.youtuber")) {
						p.openInventory(youtuber);
						}
					}
				}
			}
		}
		
		if(e.getInventory().getTitle().equalsIgnoreCase("Youtuber enviados")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eTicket de ")) {
						p.getOpenInventory().close();
						p.sendMessage("§a§lDigite a resposta para o ticket.\n \n§aCategoria: §eTag Youtuber\n§aNick: §e"+getYoutuberNick(p)+"\n§aNome do canal: §e"+getYoutuberNome(p)+"\n§aDiscord: §e"+getYoutuberDiscord(p)+"\n \n§aLink: §e"+getYoutuberLink(p)+"\n ");
						TextComponent cancelar = new TextComponent(TextComponent.fromLegacyText("§c§lCLIQUE AQUI §apara cancelar a ação."));
						cancelar.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
						p.spigot().sendMessage(cancelar);
						saveres.put(p.getName(), "youtuber");
					}
				}
			}
		}

	Inventory erros = Mine.newInventory("Erros enviados", 9*3);
		if(e.getInventory().getTitle().equalsIgnoreCase("Escolha uma categoria")) {
			e.setCancelled(true);
			p.updateInventory();
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eErros")) {
				
				erros.setItem(Mine.getPosition(2, 3), voltar);
				erros.setItem(Mine.getPosition(2, 7), avancar);
				
			if(Main.sql.contains("erros", "NICK='"+getById(p, "erros", "NICK")+"'")) {
				ItemStack head = Mine.newHead("§eTicket de "+getById(p, "erros", "NICK"), getById(p, "erros", "NICK"), 1, " ", " §7Área: §e"+getById(p, "erros", "AREA"), " ", " §7Descrição: §e"+getById(p, "erros", "MOTIVO"), " ", " §7Anexos: §e"+getById(p, "erros", "ANEXOS"), " ",  "§7Clique para gerar uma resposta");
				erros.setItem(Mine.getPosition(2, 5), head);
			}else {
				erros.setItem(Mine.getPosition(2, 5), vazio);
			}
			if(p.hasPermission("ticket.erros")) {
				p.openInventory(erros);
			}
			}
				}
			}
		}
		
		if(e.getInventory().getTitle().contains("Erros enviados")) {
		if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getItemMeta() != null) {
				if(e.getCurrentItem().isSimilar(voltar)) {
					if(!saveint.containsKey(p) || saveint.get(p) <= 1) {
						saveint.put(p, 1);
						p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
						erros.setItem(Mine.getPosition(2, 3), voltar);
						erros.setItem(Mine.getPosition(2, 7), avancar);
						
					}else {
						saveint.put(p, saveint.get(p)-1);
						p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
						erros.setItem(Mine.getPosition(2, 3), voltar);
						erros.setItem(Mine.getPosition(2, 7), avancar);
					}
					
					if(Main.sql.contains("erros", "NICK='"+getById(p, "erros", "NICK")+"'")) {
						ItemStack head = Mine.newHead("§eTicket de "+getById(p, "erros", "NICK"), getById(p, "erros", "NICK"), 1, " ", " §7Área: §e"+getById(p, "erros", "AREA"), " ", " §7Descrição: §e"+getById(p, "erros", "MOTIVO"), " ", " §7Anexos: §e"+getById(p, "erros", "ANEXOS"), " ",  "§7Clique para gerar uma resposta");
						erros.setItem(Mine.getPosition(2, 5), head);
					}else {
						erros.setItem(Mine.getPosition(2, 5), vazio);
					}
					if(p.hasPermission("ticket.erros")) {
					p.openInventory(erros);
					}
				}
			}
		}
		}
		
		if(e.getInventory().getTitle().contains("Erros enviados")) {
		if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getItemMeta() != null) {
				if(e.getCurrentItem().isSimilar(avancar)) {
					if(!saveint.containsKey(p)) {
						saveint.put(p, 2);
						p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
						erros.setItem(Mine.getPosition(2, 3), voltar);
						erros.setItem(Mine.getPosition(2, 7), avancar);
					
					}else {
						saveint.put(p, saveint.get(p)+1);
						p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
						erros.setItem(Mine.getPosition(2, 3), voltar);
						erros.setItem(Mine.getPosition(2, 7), avancar);
						
					}
					if(Main.sql.contains("erros", "NICK='"+getById(p, "erros", "NICK")+"'")) {
						ItemStack head = Mine.newHead("§eTicket de "+getById(p, "erros", "NICK"), getById(p, "erros", "NICK"), 1, " ", " §7Área: §e"+getById(p, "erros", "AREA"), " ", " §7Descrição: §e"+getById(p, "erros", "MOTIVO"), " ", " §7Anexos: §e"+getById(p, "erros", "ANEXOS"), " ",  "§7Clique para gerar uma resposta");
						erros.setItem(Mine.getPosition(2, 5), head);
					}else {
						erros.setItem(Mine.getPosition(2, 5), vazio);
					}
					if(p.hasPermission("ticket.erros")) {
					p.openInventory(erros);
					}
				}
			}
		}
}

		if(e.getInventory().getTitle().equalsIgnoreCase("Erros enviados")) {
		e.setCancelled(true);
		if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getItemMeta() != null) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eTicket de ")) {
					p.getOpenInventory().close();
					p.sendMessage("§a§lDigite a resposta para o ticket.\n \n§aCategoria: §eErros\n§aNick: §e"+getById(p, "erros", "NICK")+"\n§aÁrea: §e"+getById(p, "erros", "AREA")+"\n§aDescrição: §e"+getById(p, "erros", "MOTIVO")+"\n \n§aAnexos: §e"+getById(p, "erros", "ANEXOS")+"\n ");
					TextComponent cancelar = new TextComponent(TextComponent.fromLegacyText("§c§lCLIQUE AQUI §apara cancelar a ação."));
					cancelar.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
					p.spigot().sendMessage(cancelar);
					saveres.put(p.getName(), "erros");
				}
			}
		}
	}
		

		Inventory denuncia = Mine.newInventory("Denúncias enviadas", 9*3);
			if(e.getInventory().getTitle().equalsIgnoreCase("Escolha uma categoria")) {
				e.setCancelled(true);
				p.updateInventory();
				if(e.getCurrentItem() != null) {
					if(e.getCurrentItem().getItemMeta() != null) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDenúncia")) {
					
					denuncia.setItem(Mine.getPosition(2, 3), voltar);
					denuncia.setItem(Mine.getPosition(2, 7), avancar);
					
				if(Main.sql.contains("denuncia", "NICK='"+getById(p, "denuncia", "NICK")+"'")) {
					ItemStack head = Mine.newHead("§eTicket de "+getById(p, "denuncia", "NICK"), getById(p, "denuncia", "NICK"), 1, " ", " §7Acusado: §e"+getById(p, "denuncia", "ACUSADO"), " ", " §7Motivo: §e"+getById(p, "denuncia", "MOTIVO"), " ", " §7Provas: §e"+getById(p, "denuncia", "PROVA"), " ",  "§7Clique para gerar uma resposta");
					denuncia.setItem(Mine.getPosition(2, 5), head);
				}else {
					denuncia.setItem(Mine.getPosition(2, 5), vazio);
				}
				if(p.hasPermission("ticket.denuncia")) {
					p.openInventory(denuncia);
				}
				}
					}
				}
			}
			
			if(e.getInventory().getTitle().contains("Denúncias enviadas")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().isSimilar(voltar)) {
						if(!saveint.containsKey(p) || saveint.get(p) <= 1) {
							saveint.put(p, 1);
							p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
							denuncia.setItem(Mine.getPosition(2, 3), voltar);
							denuncia.setItem(Mine.getPosition(2, 7), avancar);
							
						}else {
							saveint.put(p, saveint.get(p)-1);
							p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
							denuncia.setItem(Mine.getPosition(2, 3), voltar);
							denuncia.setItem(Mine.getPosition(2, 7), avancar);
						}
						
						if(Main.sql.contains("denuncia", "NICK='"+getById(p, "denuncia", "NICK")+"'")) {
							ItemStack head = Mine.newHead("§eTicket de "+getById(p, "denuncia", "NICK"), getById(p, "denuncia", "NICK"), 1, " ", " §7Acusado: §e"+getById(p, "denuncia", "ACUSADO"), " ", " §7Motivo: §e"+getById(p, "denuncia", "MOTIVO"), " ", " §7Provas: §e"+getById(p, "denuncia", "PROVA"), " ",  "§7Clique para gerar uma resposta");
							denuncia.setItem(Mine.getPosition(2, 5), head);
						}else {
							denuncia.setItem(Mine.getPosition(2, 5), vazio);
						}
						if(p.hasPermission("ticket.denuncia")) {
						p.openInventory(denuncia);
						}
					}
				}
			}
			}
			
			if(e.getInventory().getTitle().contains("Denúncias enviadas")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().isSimilar(avancar)) {
						if(!saveint.containsKey(p)) {
							saveint.put(p, 2);
							p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
							denuncia.setItem(Mine.getPosition(2, 3), voltar);
							denuncia.setItem(Mine.getPosition(2, 7), avancar);
						
						}else {
							saveint.put(p, saveint.get(p)+1);
							p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
							denuncia.setItem(Mine.getPosition(2, 3), voltar);
							denuncia.setItem(Mine.getPosition(2, 7), avancar);
							
						}
						if(Main.sql.contains("denuncia", "NICK='"+getById(p, "denuncia", "NICK")+"'")) {
							ItemStack head = Mine.newHead("§eTicket de "+getById(p, "denuncia", "NICK"), getById(p, "denuncia", "NICK"), 1, " ", " §7Acusado: §e"+getById(p, "denuncia", "ACUSADO"), " ", " §7Motivo: §e"+getById(p, "denuncia", "MOTIVO"), " ", " §7Provas: §e"+getById(p, "denuncia", "PROVA"), " ",  "§7Clique para gerar uma resposta");
							denuncia.setItem(Mine.getPosition(2, 5), head);
						}else {
							denuncia.setItem(Mine.getPosition(2, 5), vazio);
						}
						if(p.hasPermission("ticket.denuncia")) {
						p.openInventory(denuncia);
						}
					}
				}
			}
	}

			if(e.getInventory().getTitle().equalsIgnoreCase("Denúncias enviadas")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eTicket de ")) {
						p.getOpenInventory().close();
						p.sendMessage("§a§lDigite a resposta para o ticket.\n \n§aCategoria: §eDenúncia\n§aNick: §e"+getById(p, "denuncia", "NICK")+"\n§aAcusado: §e"+getById(p, "denuncia", "ACUSADO")+"\n§aMotivo: §e"+getById(p, "denuncia", "MOTIVO")+"\n \n§aProva: §e"+getById(p, "denuncia", "PROVA")+"\n ");
						TextComponent cancelar = new TextComponent(TextComponent.fromLegacyText("§c§lCLIQUE AQUI §apara cancelar a ação."));
						cancelar.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
						p.spigot().sendMessage(cancelar);
						saveres.put(p.getName(), "denuncia");
					}
				}
			}
		}
			Inventory revisao = Mine.newInventory("Revisões enviadas", 9*3);
			if(e.getInventory().getTitle().equalsIgnoreCase("Escolha uma categoria")) {
				e.setCancelled(true);
				p.updateInventory();
				if(e.getCurrentItem() != null) {
					if(e.getCurrentItem().getItemMeta() != null) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eRevisão")) {
					
					revisao.setItem(Mine.getPosition(2, 3), voltar);
					revisao.setItem(Mine.getPosition(2, 7), avancar);
					
				if(Main.sql.contains("revisao", "NICK='"+getById(p, "revisao", "NICK")+"'")) {
					ItemStack head = Mine.newHead("§eTicket de "+getById(p, "revisao", "NICK"), getById(p, "revisao", "NICK"), 1, " ", " §7Banido: §e"+getById(p, "revisao", "BANIDO"), " ", " §7Motivo: §e"+getById(p, "revisao", "MOTIVO"), " ", " §7Provas: §e"+getById(p, "revisao", "PROVA"), " ",  "§7Clique para gerar uma resposta");
					revisao.setItem(Mine.getPosition(2, 5), head);
				}else {
					revisao.setItem(Mine.getPosition(2, 5), vazio);
				}
				if(p.hasPermission("ticket.revisao")) {
					p.openInventory(revisao);
				}
				}
					}
				}
			}
			
			if(e.getInventory().getTitle().contains("Revisões enviadas")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().isSimilar(voltar)) {
						if(!saveint.containsKey(p) || saveint.get(p) <= 1) {
							saveint.put(p, 1);
							p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
							revisao.setItem(Mine.getPosition(2, 3), voltar);
							revisao.setItem(Mine.getPosition(2, 7), avancar);
							
						}else {
							saveint.put(p, saveint.get(p)-1);
							p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
							revisao.setItem(Mine.getPosition(2, 3), voltar);
							revisao.setItem(Mine.getPosition(2, 7), avancar);
						}
						
						if(Main.sql.contains("revisao", "NICK='"+getById(p, "revisao", "NICK")+"'")) {
							ItemStack head = Mine.newHead("§eTicket de "+getById(p, "revisao", "NICK"), getById(p, "revisao", "NICK"), 1, " ", " §7Banido: §e"+getById(p, "revisao", "BANIDO"), " ", " §7Motivo: §e"+getById(p, "revisao", "MOTIVO"), " ", " §7Provas: §e"+getById(p, "revisao", "PROVA"), " ",  "§7Clique para gerar uma resposta");
							revisao.setItem(Mine.getPosition(2, 5), head);
						}else {
							revisao.setItem(Mine.getPosition(2, 5), vazio);
						}
						if(p.hasPermission("ticket.revisao")) {
						p.openInventory(revisao);
						}
					}
				}
			}
			}
			
			if(e.getInventory().getTitle().contains("Revisões enviadas")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().isSimilar(avancar)) {
						if(!saveint.containsKey(p)) {
							saveint.put(p, 2);
							p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
							revisao.setItem(Mine.getPosition(2, 3), voltar);
							revisao.setItem(Mine.getPosition(2, 7), avancar);
						
						}else {
							saveint.put(p, saveint.get(p)+1);
							p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
							revisao.setItem(Mine.getPosition(2, 3), voltar);
							revisao.setItem(Mine.getPosition(2, 7), avancar);
							
						}
						if(Main.sql.contains("revisao", "NICK='"+getById(p, "revisao", "NICK")+"'")) {
							ItemStack head = Mine.newHead("§eTicket de "+getById(p, "revisao", "NICK"), getById(p, "revisao", "NICK"), 1, " ", " §7Banido: §e"+getById(p, "revisao", "BANIDO"), " ", " §7Motivo: §e"+getById(p, "revisao", "MOTIVO"), " ", " §7Provas: §e"+getById(p, "revisao", "PROVA"), " ",  "§7Clique para gerar uma resposta");
							revisao.setItem(Mine.getPosition(2, 5), head);
						}else {
							revisao.setItem(Mine.getPosition(2, 5), vazio);
						}
						if(p.hasPermission("ticket.revisao")) {
						p.openInventory(revisao);
						}
					}
				}
			}
	}

			if(e.getInventory().getTitle().equalsIgnoreCase("Revisões enviadas")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eTicket de ")) {
						p.getOpenInventory().close();
						p.sendMessage("§a§lDigite a resposta para o ticket.\n \n§aCategoria: §eRevisão\n§aNick: §e"+getById(p, "revisao", "NICK")+"\n§aBanido: §e"+getById(p, "revisao", "BANIDO")+"\n§aMotivo: §e"+getById(p, "revisao", "MOTIVO")+"\n \n§aProva: §e"+getById(p, "revisao", "PROVA")+"\n ");
						TextComponent cancelar = new TextComponent(TextComponent.fromLegacyText("§c§lCLIQUE AQUI §apara cancelar a ação."));
						cancelar.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
						p.spigot().sendMessage(cancelar);
						saveres.put(p.getName(), "revisao");
					}
				}
			}
		}
}
	
	@EventHandler
	public void aoFalar(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		if(value.containsKey(p.getName())) {
			e.setCancelled(true);
		}
		
		if(save.containsKey(p.getName())) {
			e.setCancelled(true);
		}
		
		if(value.containsKey(p.getName())) {
			if(value.get(p.getName()).equalsIgnoreCase("duvida1")) {
				e.setCancelled(true);
				p.sendMessage("§aÁrea definida como §e"+e.getMessage()+"\n ");
				save.put(p.getName()+".duvida.area", e.getMessage());
				value.remove(p.getName(), "duvida1");
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						value.put(p.getName(), "duvida2");
						TextComponent texto = new TextComponent(TextComponent.fromLegacyText("§eDigite sua dúvida ou §c§lCLIQUE AQUI §epara cancelar o envio."));
						texto.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
						p.spigot().sendMessage(texto);
					}
				}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 5);
			}
		if(value.containsKey(p.getName())) {
			if(value.get(p.getName()).equalsIgnoreCase("duvida2")) {
				e.setCancelled(true);
				p.sendMessage("§aTicket enviado, quando respondido estará no botão 'Último ticket'");
				
				
				
				save.put(p.getName()+".duvida.duvida", e.getMessage());
				
				Main.sql.alter("duvida", "AUTO_INCREMENT = 1");
				Main.sql.update("INSERT INTO `duvida` (`NICK`, `AREA`, `DUVIDA`, `LIDO`, `DATA`, `RESPOSTA`, `ID`) VALUES ('"+p.getName()+"', '"+save.get(p.getName()+".duvida.area")+"', '"+save.get(p.getName()+".duvida.duvida")+"', 'false', '"+DataAPI.getCompostoDMA()+"', 'Aguardando resposta.', null)");
			
				save.remove(p.getName());
				value.remove(p.getName());
			}
		}
		}
		
		if(value.containsKey(p.getName())) {
			if(value.get(p.getName()).equalsIgnoreCase("youtuber1")) {
				e.setCancelled(true);
				p.sendMessage("§aNome do canal definido como §e"+e.getMessage());
				save.put(p.getName()+".youtuber.nome", e.getMessage());
				value.remove(p.getName(), "youtuber1");
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						value.put(p.getName(), "youtuber2");
						TextComponent texto = new TextComponent(TextComponent.fromLegacyText("§eDigite o link do canal ou §c§lCLIQUE AQUI §epara cancelar o envio."));
						texto.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
						p.spigot().sendMessage(texto);
					}
				}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 5);
			}
		}
		
		if(value.containsKey(p.getName())) {
			if(value.get(p.getName()).equalsIgnoreCase("youtuber1")) {
				e.setCancelled(true);
				p.sendMessage("§aNome do canal definido como §e"+e.getMessage());
				save.put(p.getName()+".youtuber.nome", e.getMessage());
				value.remove(p.getName(), "youtuber1");
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						value.put(p.getName(), "youtuber2");
						TextComponent texto = new TextComponent(TextComponent.fromLegacyText("§eDigite o link do canal ou §c§lCLIQUE AQUI §epara cancelar o envio."));
						texto.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
						p.spigot().sendMessage(texto);
					}
				}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 5);
			}
		}
		if(value.containsKey(p.getName())) {
			if(value.get(p.getName()).equalsIgnoreCase("youtuber2")) {
				e.setCancelled(true);
				p.sendMessage("§aLink do canal definido.");
				save.put(p.getName()+".youtuber.link", e.getMessage());
				value.remove(p.getName(), "youtuber2");
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						value.put(p.getName(), "youtuber3");
						TextComponent texto = new TextComponent(TextComponent.fromLegacyText("§eDigite o seu discord ou §c§lCLIQUE AQUI §epara cancelar o envio.\n \n§7Exemplo: João#7542"));
						texto.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
						p.spigot().sendMessage(texto);
					}
				}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 5);
			}
		}
		if(value.containsKey(p.getName())) {
			if(value.get(p.getName()).equalsIgnoreCase("youtuber3")) {
				e.setCancelled(true);
				p.sendMessage("§aTicket enviado, quando respondido estará no botão 'Último ticket'");
				save.put(p.getName()+".youtuber.discord", e.getMessage());
				
				Main.sql.alter("youtuber", "AUTO_INCREMENT = 1");
				Main.sql.update("INSERT INTO `youtuber` (`NICK`, `NOME`, `LINK`, `LIDO`, `DATA`, `RESPOSTA`, `ID`, `DISCORD`) VALUES ('"+p.getName()+"', '"+save.get(p.getName()+".youtuber.nome")+"', '"+save.get(p.getName()+".youtuber.link")+"', 'false', '"+DataAPI.getCompostoDMA()+"', 'Aguardando resposta.', null, '"+save.get(p.getName()+".youtuber.discord")+"')");
			
						save.remove(p.getName());
						value.remove(p.getName());
			}
		}
		
		if(value.containsKey(p.getName())) {
			if(value.get(p.getName()).equalsIgnoreCase("erros1")) {
				e.setCancelled(true);
				p.sendMessage("§aÁrea definida como §e"+e.getMessage());
				save.put(p.getName()+".erros.area", e.getMessage());
				value.remove(p.getName(), "erros1");
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						value.put(p.getName(), "erros2");
						TextComponent texto = new TextComponent(TextComponent.fromLegacyText("§eDigite a explicação do erro ou §c§lCLIQUE AQUI §epara cancelar o envio."));
						texto.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
						p.spigot().sendMessage(texto);
					}
				}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 5);
			}
		}
		if(value.containsKey(p.getName())) {
			if(value.get(p.getName()).equalsIgnoreCase("erros2")) {
				e.setCancelled(true);
				p.sendMessage("§aExplicação do erro definida.");
				save.put(p.getName()+".erros.erro", e.getMessage());
				value.remove(p.getName(), "erros2");
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						value.put(p.getName(), "erros3");
						TextComponent texto = new TextComponent(TextComponent.fromLegacyText("§eDigite alguma prova da falha, caso não queira digite 'Sem prova' ou §c§lCLIQUE AQUI §epara cancelar o envio."));
						texto.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
						p.spigot().sendMessage(texto);
					}
				}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 5);
			}
		}
		if(value.containsKey(p.getName())) {
			if(value.get(p.getName()).equalsIgnoreCase("erros3")) {
				e.setCancelled(true);
				p.sendMessage("§aTicket enviado, quando respondido estará no botão 'Último ticket'");
				save.put(p.getName()+".erros.prova", e.getMessage());
				
				Main.sql.alter("erros", "AUTO_INCREMENT = 1");
				Main.sql.update("INSERT INTO `erros` (`NICK`, `AREA`, `MOTIVO`, `LIDO`, `DATA`, `RESPOSTA`, `ID`, `ANEXOS`) VALUES ('"+p.getName()+"', '"+save.get(p.getName()+".erros.area")+"', '"+save.get(p.getName()+".erros.erro")+"', 'false', '"+DataAPI.getCompostoDMA()+"', 'Aguardando resposta.', null, '"+save.get(p.getName()+".erros.prova")+"')");
			
						save.remove(p.getName());
						value.remove(p.getName());
			}
		}
		
		if(value.containsKey(p.getName())) {
			if(value.get(p.getName()).equalsIgnoreCase("denuncia1")) {
				e.setCancelled(true);
				p.sendMessage("§aAcusado definido como §e"+e.getMessage());
				save.put(p.getName()+".denuncia.acusado", e.getMessage());
				value.remove(p.getName(), "denuncia1");
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						value.put(p.getName(), "denuncia2");
						TextComponent texto = new TextComponent(TextComponent.fromLegacyText("§eDigite o motivo da denúncia ou §c§lCLIQUE AQUI §epara cancelar o envio.\n \n§7Exemplo: Fly"));
						texto.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
						p.spigot().sendMessage(texto);
					}
				}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 5);
			}
		}
		if(value.containsKey(p.getName())) {
			if(value.get(p.getName()).equalsIgnoreCase("denuncia2")) {
				e.setCancelled(true);
				p.sendMessage("§aMotivo da denúncia definido.");
				save.put(p.getName()+".denuncia.motivo", e.getMessage());
				value.remove(p.getName(), "denuncia2");
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						value.put(p.getName(), "denuncia3");
						TextComponent texto = new TextComponent(TextComponent.fromLegacyText("§eDigite a prova da denúncia, caso não queira digite 'Sem prova' ou §c§lCLIQUE AQUI §epara cancelar o envio."));
						texto.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
						p.spigot().sendMessage(texto);
					}
				}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 5);
			}
		}
		if(value.containsKey(p.getName())) {
			if(value.get(p.getName()).equalsIgnoreCase("denuncia3")) {
				e.setCancelled(true);
				p.sendMessage("§aTicket enviado, quando respondido estará no botão 'Último ticket'");
				save.put(p.getName()+".denuncia.prova", e.getMessage());
				
				Main.sql.alter("denuncia", "AUTO_INCREMENT = 1");
				Main.sql.update("INSERT INTO `denuncia` (`NICK`, `ACUSADO`, `MOTIVO`, `LIDO`, `DATA`, `RESPOSTA`, `ID`, `PROVA`) VALUES ('"+p.getName()+"', '"+save.get(p.getName()+".denuncia.acusado")+"', '"+save.get(p.getName()+".denuncia.motivo")+"', 'false', '"+DataAPI.getCompostoDMA()+"', 'Aguardando resposta.', null, '"+save.get(p.getName()+".denuncia.prova")+"')");
			
						save.remove(p.getName());
						value.remove(p.getName());
			}
		}
		
		if(value.containsKey(p.getName())) {
			if(value.get(p.getName()).equalsIgnoreCase("revisao1")) {
				e.setCancelled(true);
				p.sendMessage("§aNickname do banido definido como §e"+e.getMessage());
				save.put(p.getName()+".revisao.banido", e.getMessage());
				value.remove(p.getName(), "revisao1");
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						value.put(p.getName(), "revisao2");
						TextComponent texto = new TextComponent(TextComponent.fromLegacyText("§eDigite o motivo da revisão ou §c§lCLIQUE AQUI §epara cancelar o envio.\n \n§7Exemplo: Punição injusta."));
						texto.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
						p.spigot().sendMessage(texto);
					}
				}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 5);
			}
		}
		if(value.containsKey(p.getName())) {
			if(value.get(p.getName()).equalsIgnoreCase("revisao2")) {
				e.setCancelled(true);
				p.sendMessage("§aMotivo da revisão definido.");
				save.put(p.getName()+".revisao.motivo", e.getMessage());
				value.remove(p.getName(), "revisao2");
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						value.put(p.getName(), "revisao3");
						TextComponent texto = new TextComponent(TextComponent.fromLegacyText("§eDigite a prova para que a punição seja revogada, caso não tenha digite 'Sem prova' ou §c§lCLIQUE AQUI §epara cancelar o envio."));
						texto.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/cancelar"));
						p.spigot().sendMessage(texto);
					}
				}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 5);
			}
		}
		if(value.containsKey(p.getName())) {
			if(value.get(p.getName()).equalsIgnoreCase("revisao3")) {
				e.setCancelled(true);
				p.sendMessage("§aTicket enviado, quando respondido estará no botão 'Último ticket'");
				save.put(p.getName()+".revisao.prova", e.getMessage());
				
				Main.sql.alter("revisao", "AUTO_INCREMENT = 1");
				Main.sql.update("INSERT INTO `revisao` (`NICK`, `MOTIVO`, `BANIDO`, `LIDO`, `DATA`, `RESPOSTA`, `ID`, `PROVA`) VALUES ('"+p.getName()+"', '"+save.get(p.getName()+".revisao.motivo")+"', '"+save.get(p.getName()+".revisao.banido")+"', 'false', '"+DataAPI.getCompostoDMA()+"', 'Aguardando resposta.', null, '"+save.get(p.getName()+".revisao.prova")+"')");
			
						save.remove(p.getName());
						value.remove(p.getName());
			}
		}
		
		if(saveres.containsKey(p.getName())) {
			if(saveres.get(p.getName()).equalsIgnoreCase("duvidas")) {
				p.sendMessage(" \n§aResposta envida para §e"+getDuvidaNick(p));
				
					Bukkit.getMessenger().registerOutgoingPluginChannel(Main.getPlugin(Main.class), "BungeeCord");
					 
					 ByteArrayOutputStream b = new ByteArrayOutputStream();
					 DataOutputStream out = new DataOutputStream(b);
					 try {
						 out.writeUTF("Message");
						 out.writeUTF(getDuvidaNick(p));
						 out.writeUTF(" \n§eSeu último ticket foi respondido!\n§eLeia a resposta na área §e§l'Último ticket' §eem /ticket\n ");
					 } catch (IOException ex) {
					 }
					 p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", b.toByteArray());
				
				Main.sql.update("INSERT INTO `respostas` (`NICK`, `RESPOSTA`) VALUES ('"+getDuvidaNick(p)+"', '"+e.getMessage()+"')");
				Main.sql.delete("duvida", saveint.get(p));
				Main.sql.alter("duvida", "AUTO_INCREMENT = 1");
				
				saveres.remove(p.getName());
				saveint.remove(p);
			}
		}
		if(saveres.containsKey(p.getName())) {
			if(saveres.get(p.getName()).equalsIgnoreCase("youtuber")) {
				p.sendMessage(" \n§aResposta envida para §e"+getYoutuberNick(p));
				
				Player respondido = Bukkit.getPlayer(getYoutuberNick(p));
				
				Bukkit.getMessenger().registerOutgoingPluginChannel(Main.getPlugin(Main.class), "BungeeCord");
				 
				 ByteArrayOutputStream b = new ByteArrayOutputStream();
				 DataOutputStream out = new DataOutputStream(b);
				 try {
					 out.writeUTF("Message");
					 out.writeUTF(getYoutuberNick(p));
					 out.writeUTF(" \n§eSeu último ticket foi respondido!\n§eLeia a resposta na área §e§l'Último ticket' §eem /ticket\n ");
				 } catch (IOException ex) {
				 }
				 p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", b.toByteArray());

				Main.sql.update("INSERT INTO `respostas` (`NICK`, `RESPOSTA`) VALUES ('"+getYoutuberNick(p)+"', '"+e.getMessage()+"')");
				Main.sql.delete("youtuber", saveint.get(p));
				Main.sql.alter("youtuber", "AUTO_INCREMENT = 1");
				
				
				saveres.remove(p.getName());
				saveint.remove(p);
			}
		}
		
		if(saveres.containsKey(p.getName())) {
			if(saveres.get(p.getName()).equalsIgnoreCase("erros")) {
				p.sendMessage(" \n§aResposta envida para §e"+getById(p, "erros", "NICK"));
				Player respondido = Bukkit.getPlayer(getById(p, "erros", "NICK"));
				
				Bukkit.getMessenger().registerOutgoingPluginChannel(Main.getPlugin(Main.class), "BungeeCord");
				 
				 ByteArrayOutputStream b = new ByteArrayOutputStream();
				 DataOutputStream out = new DataOutputStream(b);
				 try {
					 out.writeUTF("Message");
					 out.writeUTF(getById(p, "erros", "NICK"));
					 out.writeUTF(" \n§eSeu último ticket foi respondido!\n§eLeia a resposta na área §e§l'Último ticket' §eem /ticket\n ");
				 } catch (IOException ex) {
				 }
				 p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", b.toByteArray());
				
				Main.sql.update("INSERT INTO `respostas` (`NICK`, `RESPOSTA`) VALUES ('"+getById(p, "erros", "NICK")+"', '"+e.getMessage()+"')");
				Main.sql.delete("erros", saveint.get(p));
				Main.sql.alter("erros", "AUTO_INCREMENT = 1");
				
				
				saveres.remove(p.getName());
				saveint.remove(p);
			}
		}
		
		if(saveres.containsKey(p.getName())) {
			if(saveres.get(p.getName()).equalsIgnoreCase("denuncia")) {
				p.sendMessage(" \n§aResposta envida para §e"+getById(p, "denuncia", "NICK"));
				Player respondido = Bukkit.getPlayer(getById(p, "denuncia", "NICK"));
				
				Bukkit.getMessenger().registerOutgoingPluginChannel(Main.getPlugin(Main.class), "BungeeCord");
				 
				 ByteArrayOutputStream b = new ByteArrayOutputStream();
				 DataOutputStream out = new DataOutputStream(b);
				 try {
					 out.writeUTF("Message");
					 out.writeUTF(getById(p, "denuncia", "NICK"));
					 out.writeUTF(" \n§eSeu último ticket foi respondido!\n§eLeia a resposta na área §e§l'Último ticket' §eem /ticket\n ");
				 } catch (IOException ex) {
				 }
				 p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", b.toByteArray());
				
				Main.sql.update("INSERT INTO `respostas` (`NICK`, `RESPOSTA`) VALUES ('"+getById(p, "denuncia", "NICK")+"', '"+e.getMessage()+"')");
				Main.sql.delete("denuncia", saveint.get(p));
				Main.sql.alter("denuncia", "AUTO_INCREMENT = 1");
				
				
				saveres.remove(p.getName());
				saveint.remove(p);
			}
		}
		
		if(saveres.containsKey(p.getName())) {
			if(saveres.get(p.getName()).equalsIgnoreCase("revisao")) {
				p.sendMessage(" \n§aResposta envida para §e"+getById(p, "revisao", "NICK"));
				Player respondido = Bukkit.getPlayer(getById(p, "revisao", "NICK"));
				
				Bukkit.getMessenger().registerOutgoingPluginChannel(Main.getPlugin(Main.class), "BungeeCord");
				 
				 ByteArrayOutputStream b = new ByteArrayOutputStream();
				 DataOutputStream out = new DataOutputStream(b);
				 try {
					 out.writeUTF("Message");
					 out.writeUTF(getById(p, "revisao", "NICK"));
					 out.writeUTF(" \n§eSeu último ticket foi respondido!\n§eLeia a resposta na área §e§l'Último ticket' §eem /ticket\n ");
				 } catch (IOException ex) {
				 }
				 p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", b.toByteArray());
				
				Main.sql.update("INSERT INTO `respostas` (`NICK`, `RESPOSTA`) VALUES ('"+getById(p, "revisao", "NICK")+"', '"+e.getMessage()+"')");
				Main.sql.delete("revisao", saveint.get(p));
				Main.sql.alter("revisao", "AUTO_INCREMENT = 1");
				
				
				saveres.remove(p.getName());
				saveint.remove(p);
			}
		}
		
	}
	
	@EventHandler
	public static void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if(Main.sql.contains("respostas", "NICK='"+p.getName()+"'")) {
			p.sendMessage(" \n§eSeu último ticket foi respondido!\n§eLeia a resposta na área §e§l'Último ticket' §eem /ticket\n ");
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
		}
	}
	
	public static String getDuvidaNick(Player p) {
		return Main.sql.getString("duvida", "NICK", "ID='"+saveint.get(p)+"'");
	}
	
	public static String getDuvidaArea(Player p) {
		return Main.sql.getString("duvida", "AREA", "ID='"+saveint.get(p)+"'");
	}
	
	public static String getDuvidaDuvida(Player p) {
		return Main.sql.getString("duvida", "DUVIDA", "ID='"+saveint.get(p)+"'");
	}
	
	public static String getYoutuberNick(Player p) {
		return Main.sql.getString("youtuber", "NICK", "ID='"+saveint.get(p)+"'");
	}
	
	public static String getYoutuberNome(Player p) {
		return Main.sql.getString("youtuber", "NOME", "ID='"+saveint.get(p)+"'");
	}
	
	public static String getYoutuberLink(Player p) {
		return Main.sql.getString("youtuber", "LINK", "ID='"+saveint.get(p)+"'");
	}
	
	public static String getYoutuberDiscord(Player p) {
		return Main.sql.getString("youtuber", "DISCORD", "ID='"+saveint.get(p)+"'");
	}
	
	public static String getById(Player p, String table, String column) {
		return Main.sql.getString(table, column, "ID='"+saveint.get(p)+"'");
	}
	
}


