package me.ninjay.safemensagens.comandos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.safecore.comandos.chat.ComandoLocal;
import me.ninjay.safemensagens.main.Main;
import me.ninjay.safemensagens.utils.Mine;


public class ComandoNovidade implements CommandExecutor, Listener{
	
	private static ArrayList<Player> id = new ArrayList<>();
	private static ArrayList<Player> titulo = new ArrayList<>();
	private static HashMap<Player, String> idcriando = new HashMap<>();
	private static ArrayList<Player> novidade = new ArrayList<>();
	private static ArrayList<String> novidades = new ArrayList<>();
	private static Inventory menu = Mine.newInventory("Novidades", 9*3);
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(!p.hasPermission("novidade.admin")) {
				if(Main.novidade.contains("novidade.4")) {
					menu.setItem(Mine.getPosition(2, 5), Main.novidade.getItemStack("novidade.4.item"));
				}
				if(Main.novidade.contains("novidade.1")) {
					menu.setItem(Mine.getPosition(2, 2), Main.novidade.getItemStack("novidade.1.item"));
				}
				if(Main.novidade.contains("novidade.2")) {
					menu.setItem(Mine.getPosition(2, 3), Main.novidade.getItemStack("novidade.2.item"));
				}
				if(Main.novidade.contains("novidade.3")) {
					menu.setItem(Mine.getPosition(2, 4), Main.novidade.getItemStack("novidade.3.item"));
				}
				if(Main.novidade.contains("novidade.5")) {
					menu.setItem(Mine.getPosition(2, 6), Main.novidade.getItemStack("novidade.5.item"));
				}
				if(Main.novidade.contains("novidade.6")) {
					menu.setItem(Mine.getPosition(2, 7), Main.novidade.getItemStack("novidade.6.item"));
				}
				if(Main.novidade.contains("novidade.7")) {
					menu.setItem(Mine.getPosition(2, 8), Main.novidade.getItemStack("novidade.7.item"));
				}
				p.openInventory(menu);
			}else {
				if(args.length == 0) {
					if(Main.novidade.contains("novidade.4")) {
						menu.setItem(Mine.getPosition(2, 5), Main.novidade.getItemStack("novidade.4.item"));
					}
					if(Main.novidade.contains("novidade.1")) {
						menu.setItem(Mine.getPosition(2, 2), Main.novidade.getItemStack("novidade.1.item"));
					}
					if(Main.novidade.contains("novidade.2")) {
						menu.setItem(Mine.getPosition(2, 3), Main.novidade.getItemStack("novidade.2.item"));
					}
					if(Main.novidade.contains("novidade.3")) {
						menu.setItem(Mine.getPosition(2, 4), Main.novidade.getItemStack("novidade.3.item"));
					}
					if(Main.novidade.contains("novidade.5")) {
						menu.setItem(Mine.getPosition(2, 6), Main.novidade.getItemStack("novidade.5.item"));
					}
					if(Main.novidade.contains("novidade.6")) {
						menu.setItem(Mine.getPosition(2, 7), Main.novidade.getItemStack("novidade.6.item"));
					}
					if(Main.novidade.contains("novidade.7")) {
						menu.setItem(Mine.getPosition(2, 8), Main.novidade.getItemStack("novidade.7.item"));
					}
					p.openInventory(menu);
				}else if(args[0].equalsIgnoreCase("criar")) {
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
					LocalDateTime now = LocalDateTime.now();  
					//System.out.println(dtf.format(now));
					ComandoLocal.localoff.add(p);
					p.sendMessage(" \n§e§lCriação de novidade iniciada.\n \n§7A data foi definida como: "+dtf.format(now)+".\n ");
					new BukkitRunnable() {
						
						@Override
						public void run() {
							p.sendMessage(" \n§e§lDigite o ID da novidade. \n \n§7Caso seja a primeira novidade digite '1', e assim em diante.\n ");
							id.add(p);
						}
					}.runTaskLater(Main.getPlugin(Main.class), 15);
				}
			}
		}
		return false;
	}
	
	@EventHandler
	public void aoFalar(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		if(id.contains(p)) {
			if(StringUtils.isNumeric(e.getMessage())) {
				p.sendMessage(" \n§7ID definido como: #"+e.getMessage()+"\n ");
				Main.novidade.set("novidade."+e.getMessage(), "#"+e.getMessage());
				Main.novidade.saveConfig();
				idcriando.put(p, e.getMessage());
				id.remove(p);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
				LocalDateTime now = LocalDateTime.now();  
				Main.novidade.set("novidade."+idcriando.get(p)+".data", dtf.format(now));
				Main.novidade.saveConfig();
				new BukkitRunnable() {
					
					@Override
					public void run() {
						titulo.add(p);
						p.sendMessage(" \n§e§lDigite o título da novidade. \n \n§7Exemplo: 'Essas são as novidades de hoje:'\n ");
					}
				}.runTaskLater(Main.getPlugin(Main.class), 15);
			}else {
				e.setCancelled(true);
				p.sendMessage("§cDigite apenas números.");
			}
		}
		if(titulo.contains(p)) {
			p.sendMessage(" \n§7Título da novidade definido.\n ");
			Main.novidade.set("novidade."+idcriando.get(p)+".titulo", e.getMessage());
			Main.novidade.saveConfig();
			titulo.remove(p);
			new BukkitRunnable() {
				
				@Override
				public void run() {
					novidade.add(p);
					p.sendMessage(" \n§e§lDigite a novidade\n \n§7Quando quiser parar digite §7'§7§lparar§7'.\n ");
				}
			}.runTaskLater(Main.getPlugin(Main.class), 15);
		}
		
		if(novidade.contains(p)) {
			if(e.getMessage().contains("parar")) {
				p.sendMessage(" \n§e§lCriação encerrada, novidade criada.\n ");
				ComandoLocal.localoff.remove(p);
				for(String all : novidades) {
					Main.novidade.set("novidade."+idcriando.get(p)+".novidades."+novidades.size(), all);
					Main.novidade.saveConfig();
				}
				ItemStack papel = Mine.newItem(Material.PAPER, "§eNovidades do dia "+Main.novidade.getString("novidade."+idcriando.get(p)+".data"), 1, 0, "§8ID: #"+idcriando.get(p)," ","  §7Clique para ver as novidades.");
				Main.novidade.set("novidade."+idcriando.get(p)+".item", papel);
				Main.novidade.saveConfig();
				Main.novidade.set("novidade."+idcriando.get(p)+".quantia", novidades.size());
				Main.novidade.saveConfig();
				id.remove(p);
				titulo.remove(p);
				idcriando.remove(p);
				novidade.remove(p);
				novidades.clear();
			}else {
				novidades.add(e.getMessage());
				for(String all : novidades) {
					Main.novidade.set("novidade."+idcriando.get(p)+".novidades."+novidades.size(), all);
					Main.novidade.saveConfig();
				}
				p.sendMessage(" \n§eNovidade adicionada, caso queira parar digite '§e§lparar§e'.\n ");
			}
 		}
	}

	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().contains("Novidades")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getItemMeta() != null) {
				if(e.getCurrentItem().getItemMeta().getLore().contains("§8ID: #1")) {
					p.getOpenInventory().close();
					p.sendMessage(" \n§a"+Main.novidade.getString("novidade.1.titulo")+"\n ");
					
					for(int i = 1; i < Main.novidade.getInt("novidade.1.quantia")+1; i++) {
						p.sendMessage(" §e> "+Main.novidade.getString("novidade.1.novidades."+i));
					}
					
					p.sendMessage(" \n§aNovidades do dia "+Main.novidade.getString("novidade.1.data")+"\n ");
				}
				 if(e.getCurrentItem().getItemMeta().getLore().contains("§8ID: #2")) {
						p.getOpenInventory().close();
						p.sendMessage(" \n§a"+Main.novidade.getString("novidade.2.titulo")+"\n ");
						
						for(int i = 1; i < Main.novidade.getInt("novidade.2.quantia")+1; i++) {
							p.sendMessage(" §e> "+Main.novidade.getString("novidade.2.novidades."+i));
						}
						
						p.sendMessage(" \n§aNovidades do dia "+Main.novidade.getString("novidade.2.data")+"\n ");
					}
				 if(e.getCurrentItem().getItemMeta().getLore().contains("§8ID: #3")) {
						p.getOpenInventory().close();
						p.sendMessage(" \n§a"+Main.novidade.getString("novidade.3.titulo")+"\n ");
						
						for(int i = 1; i < Main.novidade.getInt("novidade.3.quantia")+1; i++) {
							p.sendMessage(" §e> "+Main.novidade.getString("novidade.3.novidades."+i));
						}
						
						p.sendMessage(" \n§aNovidades do dia "+Main.novidade.getString("novidade.3.data")+"\n ");
					}
				   if(e.getCurrentItem().getItemMeta().getLore().contains("§8ID: #4")) {
						p.getOpenInventory().close();
						p.sendMessage(" \n§a"+Main.novidade.getString("novidade.4.titulo")+"\n ");
						
						for(int i = 1; i < Main.novidade.getInt("novidade.4.quantia")+1; i++) {
							p.sendMessage(" §e> "+Main.novidade.getString("novidade.4.novidades."+i));
						}
						
						p.sendMessage(" \n§aNovidades do dia "+Main.novidade.getString("novidade.4.data")+"\n ");
					}
				   if(e.getCurrentItem().getItemMeta().getLore().contains("§8ID: #5")) {
						p.getOpenInventory().close();
						p.sendMessage(" \n§a"+Main.novidade.getString("novidade.5.titulo")+"\n ");
						
						for(int i = 1; i < Main.novidade.getInt("novidade.5.quantia")+1; i++) {
							p.sendMessage(" §e> "+Main.novidade.getString("novidade.5.novidades."+i));
						}
						
						p.sendMessage(" \n§aNovidades do dia "+Main.novidade.getString("novidade.5.data")+"\n ");
					}
				   if(e.getCurrentItem().getItemMeta().getLore().contains("§8ID: #6")) {
						p.getOpenInventory().close();
						p.sendMessage(" \n§a"+Main.novidade.getString("novidade.6.titulo")+"\n ");
						
						for(int i = 1; i < Main.novidade.getInt("novidade.6.quantia")+1; i++) {
							p.sendMessage(" §e> "+Main.novidade.getString("novidade.6.novidades."+i));
						}
						
						p.sendMessage(" \n§aNovidades do dia "+Main.novidade.getString("novidade.6.data")+"\n ");
					}
				   if(e.getCurrentItem().getItemMeta().getLore().contains("§8ID: #7")) {
						p.getOpenInventory().close();
						p.sendMessage(" \n§a"+Main.novidade.getString("novidade.7.titulo")+"\n ");
						
						for(int i = 1; i < Main.novidade.getInt("novidade.7.quantia")+1; i++) {
							p.sendMessage(" §e> "+Main.novidade.getString("novidade.7.novidades."+i));
						}
						
						p.sendMessage(" \n§aNovidades do dia "+Main.novidade.getString("novidade.7.data")+"\n ");
					}
			}
		}
		}
	}
	
}
