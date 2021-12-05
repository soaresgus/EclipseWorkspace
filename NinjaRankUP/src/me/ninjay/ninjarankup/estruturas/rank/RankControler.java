package me.ninjay.ninjarankup.estruturas.rank;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import br.com.devpaulo.legendchat.api.events.ChatMessageEvent;
import me.ninjay.ninjarankup.estruturas.ranklist.RankListControler;
import me.ninjay.ninjarankup.main.Main;
import me.ninjay.ninjarankup.utils.Mine;
import me.ninjay.ninjarankup.utils.VaultAPI;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.HoverEvent.Action;

public class RankControler implements CommandExecutor, Listener{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
		if(Main.config.getBoolean("confirmar.ativado") == false) {
			upar(p);
		}
		
		if(Main.config.getBoolean("confirmar.ativado") == true) {
			if(Main.config.getBoolean("confirmar.menu") == true) {
				Integer prox = Main.playerRank.getInt(p.getUniqueId().toString())+1;
				Rank proxRank = RankAPI.manager.getRankById(prox);
				Rank atualRank = RankAPI.manager.getRankById(Main.playerRank.getInt(p.getUniqueId().toString()));
				if(proxRank != null) {
				if(Main.config.getInt("confirmar.menuSize") <= 6 && Main.config.get("confirmar.menuSize") != null) {
					Inventory menu = Mine.newInventory("Confirmação", 9*Main.config.getInt("confirmar.menuSize"));
					if(Main.config.get("confirmar.simIcone") != null) {
						ItemStack sim = Mine.newItem(Main.config.getInt("confirmar.simIcone.id"), Main.config.getString("confirmar.simIcone.name").replace("&", "§"), Main.config.getInt("confirmar.simIcone.amount"), Main.config.getInt("confirmar.simIcone.data"), Main.config.getStringList("confirmar.simIcone.lore"));
						if(Main.config.get("confirmar.simSlot") != null && Main.config.getInt("confirmar.simSlot") <= 0) {
							menu.setItem(0, sim);
						}
						if(Main.config.get("confirmar.simSlot") != null && Main.config.getInt("confirmar.simSlot") <= 9*Main.config.getInt("confirmar.menuSize")) {
							menu.setItem(Main.config.getInt("confirmar.simSlot")-1, sim);
						}else {
							RankListControler.erro("config.yml", "O valor 'confirmar.simSlot' não pode ser maior que "+9*Main.config.getInt("confirmar.menuSize")+".");
						}
					}else {
						RankListControler.erro("config.yml", "O icone de 'confirmar.simIcone' não foi encontrado.");
					}
					if(Main.config.get("confirmar.naoIcone") != null) {
						ItemStack nao = Mine.newItem(Main.config.getInt("confirmar.naoIcone.id"), Main.config.getString("confirmar.naoIcone.name").replace("&", "§"), Main.config.getInt("confirmar.naoIcone.amount"), Main.config.getInt("confirmar.naoIcone.data"), Main.config.getStringList("confirmar.naoIcone.lore"));
						if(Main.config.get("confirmar.naoSlot") != null && Main.config.getInt("confirmar.naoSlot") <= 0) {
							menu.setItem(0, nao);
						}
						if(Main.config.get("confirmar.naoSlot") != null && Main.config.getInt("confirmar.naoSlot") <= 9*Main.config.getInt("confirmar.menuSize")) {
							menu.setItem(Main.config.getInt("confirmar.naoSlot")-1, nao);
						}else {
							RankListControler.erro("config.yml", "O valor 'confirmar.naoSlot' não pode ser maior que "+9*Main.config.getInt("confirmar.menuSize")+".");
						}
					}else {
						RankListControler.erro("config.yml", "O icone de 'confirmar.naoIcone' não foi encontrado.");
					}
					if(Main.config.get("confirmar.rankIconeSlot") != null && Main.config.getInt("confirmar.rankIconeSlot") <= 9*Main.config.getInt("confirmar.menuSize")) {
						if(Main.config.getInt("confirmar.rankIconeSlot") <= 0) {
							menu.setItem(0, proxRank.getIcone());
						}else {
							menu.setItem(Main.config.getInt("confirmar.rankIconeSlot")-1, proxRank.getIcone());
						}
						
						p.openInventory(menu);
						
					}else {
						RankListControler.erro("config.yml", "O valor 'confirmar.rankIconeSlot' não pode ser maior que "+9*Main.config.getInt("confirmar.menuSize")+".");
					}
				}else {
					RankListControler.erro("config.yml", "'confirmar.menuSize' não pode ser maior que 6 linhas.");
				}
				
				}else {
					if(Main.config.getString("ultimoRank") != null) {
						p.sendMessage(Main.config.getString("ultimoRank").replace("%nick%", p.getName()).replace("%atual%", atualRank.getNome()).replace("%linha%", "\n").replace("\n", "\n").replace("&", "§"));
					}else {
						p.sendMessage("§eVocê atingiu o último rank!");
					}
				}
				
			}
			
			if(Main.config.getBoolean("confirmar.texto.ativado") == true) {
			}
		}
		
		}		
		return false;
	}

	public static void upar(Player p) {
		Integer prox = Main.playerRank.getInt(p.getUniqueId().toString())+1;
		Rank proxRank = RankAPI.manager.getRankById(prox);
		Rank atualRank = RankAPI.manager.getRankById(Main.playerRank.getInt(p.getUniqueId().toString()));
		
		if(proxRank != null) {
				if(VaultAPI.getEconomy().has(p, proxRank.getValor())) {
					Main.playerRank.set(p.getUniqueId().toString(), prox);
					Main.playerRank.saveConfig();
					VaultAPI.getEconomy().withdrawPlayer(p, proxRank.getValor());
					
					if(proxRank.getPerm() != null) {
						VaultAPI.getPermission().playerAdd(p, proxRank.getPerm());
					}
					
					if(proxRank.getGrupo() != null) {
						VaultAPI.getPermission().playerAddGroup(p, proxRank.getGrupo());
					}
					
					if(proxRank.getComando() != null) {
						for(String comando : proxRank.getComando()) {
							p.getServer().dispatchCommand(Bukkit.getConsoleSender(), comando);
						}
					}
					
					if(proxRank.getItens() != null) {
						if(Mine.getEmptySlotsAmount(p.getInventory()) >= proxRank.getItens().size()) {
						for(ItemStack itens : proxRank.getItens()) {
							p.getInventory().addItem(itens);
						}
						}else {
							p.sendMessage("\n \n§cPor falta de espaço no inventário\nos itens do rank foi dropado no chão!\n ");
							for(ItemStack itens : proxRank.getItens()) {
								p.getWorld().dropItem(p.getLocation().add(0, 0.5, 0), itens);
							}
						}
					}
					
					if(Main.config.getBoolean("title.global.ativado") == true) {
						Mine.sendTitle(Main.config.getString("title.global.title").replace("%nick%", p.getName()).replace("%rank%", proxRank.getNome()).replace("%atual%", atualRank.getNome()).replace("%linha%", "\n").replace("\n", "\n").replace("&", "§"), Main.config.getString("title.global.subTitle").replace("%nick%", p.getName()).replace("%rank%", proxRank.getNome()).replace("%atual%", atualRank.getNome()).replace("%linha%", "\n").replace("\n", "\n").replace("&", "§"), 5, 40, 5);
					}
					if(Main.config.getBoolean("title.privado.ativado") == true) {
						Mine.sendTitle(p, Main.config.getString("title.privado.title").replace("%nick%", p.getName()).replace("%rank%", proxRank.getNome()).replace("%atual%", atualRank.getNome()).replace("%linha%", "\n").replace("\n", "\n").replace("&", "§"), Main.config.getString("title.privado.subTitle").replace("%nick%", p.getName()).replace("%rank%", proxRank.getNome()).replace("%atual%", atualRank.getNome()).replace("%linha%", "\n").replace("\n", "\n").replace("&", "§"), 5, 40, 5);
					}
					
					if(Main.config.getBoolean("mensagem.global.ativado") == true) {
						for(String msg : Main.config.getStringList("mensagem.global.mensagem")) {
							Bukkit.broadcastMessage(msg.replace("%nick%", p.getName()).replace("%rank%", proxRank.getNome()).replace("%atual%", atualRank.getNome()).replace("%linha%", "\n").replace("\n", "\n").replace("&", "§"));
						}
					}
					
					if(Main.config.getBoolean("mensagem.privado.ativado") == true) {
						for(String msg : Main.config.getStringList("mensagem.privado.mensagem")) {
							p.sendMessage(msg.replace("%nick%", p.getName()).replace("%rank%", proxRank.getNome()).replace("%atual%", atualRank.getNome()).replace("%linha%", "\n").replace("\n", "\n").replace("&", "§"));
						}
					}
					
					if(Main.config.getBoolean("actionBar.global.ativado") == true) {
						Mine.sendActionBar(Main.config.getString("actionBar.global.mensagem").replace("%nick%", p.getName()).replace("%rank%", proxRank.getNome()).replace("%atual%", atualRank.getNome()).replace("%linha%", "\n").replace("\n", "\n").replace("&", "§"));
					}
					
					if(Main.config.getBoolean("actionBar.privado.ativado") == true) {
						Mine.sendActionBar(p, Main.config.getString("actionBar.privado.mensagem").replace("%nick%", p.getName()).replace("%rank%", proxRank.getNome()).replace("%atual%", atualRank.getNome()).replace("%linha%", "\n").replace("\n", "\n").replace("&", "§"));
					}
					
					if(Main.config.getBoolean("som.global.ativado") == true) {
						for(Player todos : Bukkit.getOnlinePlayers()) {
							todos.playSound(todos.getLocation(), Sound.valueOf(Sound.class, Main.config.getString("som.global.som")), 1F, 1F);
						}
					}
					
					if(Main.config.getBoolean("som.privado.ativado") == true) {
						p.playSound(p.getLocation(), Sound.valueOf(Sound.class, Main.config.getString("som.privado.som")), 1F, 1F);
					}
					
				}else {
					if(Main.config.getString("semDinheiro") != null) {
						p.sendMessage(Main.config.getString("semDinheiro").replace("%nick%", p.getName()).replace("%rank%", proxRank.getNome()).replace("%atual%", atualRank.getNome()).replace("%linha%", "\n").replace("\n", "\n").replace("&", "§"));
					}else {
						p.sendMessage("§eVocê não possuí dinheiro suficiente.");
					}
				}
			}else {
				if(Main.config.getString("ultimoRank") != null) {
					p.sendMessage(Main.config.getString("ultimoRank").replace("%nick%", p.getName()).replace("%atual%", atualRank.getNome()).replace("%linha%", "\n").replace("\n", "\n").replace("&", "§"));
				}else {
					p.sendMessage("§eVocê atingiu o último rank!");
				}
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if(!Main.playerRank.contains(p.getUniqueId().toString())) {
			Main.playerRank.set(p.getUniqueId().toString(), 1);
			Main.playerRank.saveConfig();
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void legendChatHook(ChatMessageEvent e) {
		if(e.isCancelled()) {
			return;
		}
		
		Player p = e.getSender();
		Rank rank = RankAPI.manager.getRankById(Main.playerRank.getInt(p.getUniqueId().toString()));
		if(p != null) {
			if(rank != null) {
			e.setTagValue("rank", rank.getTag().replace("&", "§"));
			}
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equalsIgnoreCase("Confirmação")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(Main.config.get("confirmar.simIcone") != null) {
					ItemStack sim = Mine.newItem(Main.config.getInt("confirmar.simIcone.id"), Main.config.getString("confirmar.simIcone.name").replace("&", "§"), Main.config.getInt("confirmar.simIcone.amount"), Main.config.getInt("confirmar.simIcone.data"), Main.config.getStringList("confirmar.simIcone.lore"));
					if(e.getCurrentItem().isSimilar(sim)) {
						p.getOpenInventory().close();
						if(Main.config.getString("confirmar.simMensagem") != null) {
							p.sendMessage(Main.config.getString("confirmar.simMensagem").replace("&", "§"));
						}
						upar(p);
					}
				}
				
				if(Main.config.get("confirmar.naoIcone") != null) {
					ItemStack nao = Mine.newItem(Main.config.getInt("confirmar.naoIcone.id"), Main.config.getString("confirmar.naoIcone.name").replace("&", "§"), Main.config.getInt("confirmar.naoIcone.amount"), Main.config.getInt("confirmar.naoIcone.data"), Main.config.getStringList("confirmar.naoIcone.lore"));
					if(e.getCurrentItem().isSimilar(nao)) {
						p.getOpenInventory().close();
						if(Main.config.getString("confirmar.naoMensagem") != null) {
							p.sendMessage(Main.config.getString("confirmar.naoMensagem").replace("&", "§"));
						}
					}
				}
			}
		}
	}
	
}
