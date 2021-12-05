package me.ninjay.safeeventos.estruturas;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.massivecraft.factions.entity.FactionColl;

import me.ninjay.safecore.comandos.chat.ComandoLocal;
import me.ninjay.safeeventos.main.Main;
import me.ninjay.safeeventos.utils.BukkitConfig;
import me.ninjay.safeeventos.utils.Mine;

public class GuerraManager implements Listener {

	public static BukkitConfig config = BPManager.config;
	public static ArrayList<Player> conf = new ArrayList<>();
	public static HashMap<Player, String> definindo = new HashMap<>();
	public static HashMap<String, String> duelomap = new HashMap<>();
	
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().contains("Eventos") || e.getInventory().getTitle().contains("Guerra")) {
			e.setCancelled(true);
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().getItemMeta() != null) {
					if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eGuerra")) {
						Inventory menu = Mine.newInventory("Guerra", 9 * 4);

						ItemStack facs = Mine.newItem(Material.ARROW, "§eDefinir número de facções");
						ItemStack clas = Mine.newItem(Material.GOLD_ORE, "§eClassificar uma facção");
						ItemStack arena = Mine.newItem(Material.GRASS, "§eDefinir arenas");
						ItemStack duelo = Mine.newItem(Material.DIAMOND_SWORD, "§eDefinir duelos");
						ItemStack mclas = Mine.newItem(Material.GOLD_BLOCK, "§eMostrar classificados");
						ItemStack mduelo = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§eMostrar duelos");
						ItemStack anuncio = Mine.newItem(Material.DISPENSER, "§eAnunciar jogadores");
						ItemStack iniciar = Mine.newItem(Material.EMERALD, "§eIniciar evento");
						ItemStack pausar = Mine.newItem(Material.WATCH, "§ePausar evento");
						
						menu.setItem(Mine.getPosition(2, 2), facs);
						menu.setItem(Mine.getPosition(2, 3), clas);
						menu.setItem(Mine.getPosition(2, 6), pausar);
						menu.setItem(Mine.getPosition(2, 5), duelo);
						menu.setItem(Mine.getPosition(2, 4), arena);
						menu.setItem(Mine.getPosition(3, 2), mclas);
						menu.setItem(Mine.getPosition(3, 3), mduelo);
						menu.setItem(Mine.getPosition(3, 4), anuncio);
						menu.setItem(Mine.getPosition(2, 8), iniciar);

						p.openInventory(menu);
					}
				}
			}
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().getItemMeta() != null) {
					if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDefinir número de facções")) {
						definindo.put(p, "guerra_facs");
						p.getOpenInventory().close();
						ComandoLocal.localoff.add(p);
						p.sendMessage("§e§lDigite o número de facções\n \n  §7Caso queira cancelar digite 'cancelar'");
					}
				}
			}
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().getItemMeta() != null) {
					if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eClassificar uma facção")) {
						definindo.put(p, "guerra_clas");
						ComandoLocal.localoff.add(p);
						p.getOpenInventory().close();
						p.sendMessage("§e§lDigite a tag da facção\n \n  §7Caso queira cancelar digite 'cancelar'");
					}
				}
			}
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().getItemMeta() != null) {
					if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDefinir arenas")) {
						definindo.put(p, "guerra_arena");
						p.getOpenInventory().close();
						ComandoLocal.localoff.add(p);
						p.sendMessage("§e§lDigite o número da arena\n \n  §7Caso queira cancelar digite 'cancelar'");
					}
				}
			}
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().getItemMeta() != null) {
					if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDefinir duelos")) {
						definindo.put(p, "guerra_duelos1");
						p.getOpenInventory().close();
						ComandoLocal.localoff.add(p);
						p.sendMessage("§e§lDigite a tag da primeira facção\n \n  §7Caso queira cancelar digite 'cancelar'");
					}
				}
			}
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().getItemMeta() != null) {
					if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eIniciar evento")) {
						p.getOpenInventory().close();
						if(conf.contains(p)) {
							if(config.getBoolean("guerra.ocorrendo") == false) {
							config.set("guerra.ocorrendo", true);
							config.set("guerra.aberta", true);
							config.saveConfig();
							for(int i = 0; i < 100; i++) {
								Bukkit.broadcastMessage(" ");
							}
							p.sendMessage("§eEvento iniciado!");
							Bukkit.broadcastMessage("\n \n§e§lEvento - Guerra\n \n§eO evento guerra foi iniciado!\n \nPara participar digite §6/guerra\n \n§eO evento será fechado em 5 minutos\n ");
							new BukkitRunnable() {
								int i = 5;
								@Override
								public void run() {
									i--;
									if(i == 4) {
										Bukkit.broadcastMessage("\n \n§e§lEvento - Guerra\n \n§eO evento guerra foi iniciado!\n \nPara participar digite §6/guerra\n \n§eO evento será fechado em 4 minutos\n ");
									}
									if(i == 3) {
										Bukkit.broadcastMessage("\n \n§e§lEvento - Guerra\n \n§eO evento guerra foi iniciado!\n \nPara participar digite §6/guerra\n \n§eO evento será fechado em 3 minutos\n ");
									}
									if(i == 2) {
										Bukkit.broadcastMessage("\n \n§e§lEvento - Guerra\n \n§eO evento guerra foi iniciado!\n \nPara participar digite §6/guerra\n \n§eO evento será fechado em 2 minutos\n ");
									}
									if(i == 1) {
										Bukkit.broadcastMessage("\n \n§e§lEvento - Guerra\n \n§eO evento guerra foi iniciado!\n \nPara participar digite §6/guerra\n \n§eO evento será fechado em 1 minuto\n ");
									}
									if(i <= 0) {
										cancel();
										Bukkit.broadcastMessage("\n \n§e§lEvento - Guerra\n \n§eO evento guerra foi fechado!\n ");
										config.set("guerra.aberta", false);
										config.saveConfig();
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 20*60, 20*60);
							
							}else {
								p.sendMessage("§cO evento guerra já está ocorrendo.");
							}
						}else {
							p.getOpenInventory().close();
							p.sendMessage(" \n§c§lATENÇÃO - GUERRA\n \n§cAtenção! Esse é um evento grande.\nCaso realmente queira iniciar clique novamente.\n ");
							new BukkitRunnable() {
								
								@Override
								public void run() {
									conf.add(p);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 2);
						}
					}
				}
			}
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().getItemMeta() != null) {
					if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eMostrar classificados")) {
						p.getOpenInventory().close();
						p.sendMessage("§eLista de classificados: §6"+config.getString("guerra.faccoes"));
					}
				}
			}
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().getItemMeta() != null) {
					if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eMostrar duelos")) {
						p.getOpenInventory().close();
						p.sendMessage("§e§lLista de duelos\n ");
						for(int i = 1; i <= config.getInt("guerra.facs")/2; i++) {
							if(config.getString("guerra.duelos."+i) != null) {
							p.sendMessage("§e§lDuelo "+i+":\n \n  Fac 1: §6"+config.getString("guerra.duelos."+i+".fac1")+"\n  §e§lFac 2: §6"+config.getString("guerra.duelos."+i+".fac2")+"\n  §e§lArena: §6"+config.getString("guerra.duelos."+i+".arena")+"\n ");
						}else {
							return;
						}
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void aoFalar(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();

		if (definindo.get(p) != null) {
			if (definindo.get(p).contains("guerra_facs")) {
				if (ComandoLocal.localoff.contains(p)) {
					if(!e.getMessage().equalsIgnoreCase("cancelar")) {
					if (StringUtils.isNumeric(e.getMessage())) {
						config.set("guerra.facs", Mine.toInt(e.getMessage()));
						config.saveConfig();
						config.set("guerra.facsm", Mine.toInt(e.getMessage()));
						config.saveConfig();
						p.sendMessage("§eNúmero de facções definido.");
						new BukkitRunnable() {

							@Override
							public void run() {
								ComandoLocal.localoff.remove(p);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 2);
					} else {
						p.sendMessage("§cApenas números");
					}
				}else {
					p.sendMessage("§cAção cancelada.");
					ComandoLocal.localoff.remove(p);
				}
				}
			}
		} // **
		if (definindo.get(p) != null) {
			if (definindo.get(p).contains("guerra_clas")) {
				if (ComandoLocal.localoff.contains(p)) {
					if(!e.getMessage().equalsIgnoreCase("cancelar")) {
						if(config.getString("guerra.faccoes") == null || (!(config.getString("guerra.faccoes").contains(e.getMessage())))) {
					if(FactionColl.get().getByTag(e.getMessage()) != null) {
						if(config.getInt("guerra.facsm") >= 1) {
					config.set("guerra.facsm", config.getInt("guerra.facsm")-1);
					config.saveConfig();
					
					config.set("guerra.classificados."+Mine.toString((config.getInt("guerra.facs")-(config.getInt("guerra.facsm")))), e.getMessage());
					config.saveConfig();
					
					if(config.getString("guerra.faccoes") != null) {
					config.set("guerra.faccoes", config.getString("guerra.faccoes")+e.getMessage()+" | ");
					config.saveConfig();
					}else {
						config.set("guerra.faccoes", e.getMessage()+" | ");
						config.saveConfig();
					}
					p.sendMessage("§eFacção "+FactionColl.get().getByTag(e.getMessage()).getTag()+" de número "+(config.getInt("guerra.facs")-(config.getInt("guerra.facsm")))+" classificada.");
					
					new BukkitRunnable() {

						@Override
						public void run() {
							ComandoLocal.localoff.remove(p);
						}
					}.runTaskLater(Main.getPlugin(Main.class), 2);
				}else {
					p.sendMessage("§cPara classificar mais facções aumente o número de facções.");
				}
					}else {
						p.sendMessage("§cEssa facção não existe.");
					}
			}else {
				p.sendMessage("§cEssa facção já foi classificada.");
			}
					}else {
						p.sendMessage("§cAção cancelada.");
						ComandoLocal.localoff.remove(p);
					}
				}
			}
		} // **
		if (definindo.get(p) != null) {
			if (definindo.get(p).contains("guerra_arena")) {
				if (ComandoLocal.localoff.contains(p)) {
					if(!e.getMessage().equalsIgnoreCase("cancelar")) {
					if (StringUtils.isNumeric(e.getMessage())) {
						if(Mine.toInt(e.getMessage()) <= config.getInt("guerra.facs")/2) {
						p.sendMessage("§eArena de número "+e.getMessage()+" definida.");
						config.set("guerra.arenas."+e.getMessage(), p.getLocation());
						config.saveConfig();
						new BukkitRunnable() {

							@Override
							public void run() {
								ComandoLocal.localoff.remove(p);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 2);
					} else {
						p.sendMessage("§cDigite um número menor ou igual à "+Mine.toString(config.getInt("guerra.facs")/2)+".");
					}
				}else {
					p.sendMessage("§cApenas números.");
				}
					}else {
						p.sendMessage("§cAção cancelada.");
						ComandoLocal.localoff.remove(p);
					}
				}
			}
		} // **
		if (definindo.get(p) != null) {
			if (definindo.get(p).contains("guerra_duelos1")) {
				if (ComandoLocal.localoff.contains(p)) {
					if(!e.getMessage().equalsIgnoreCase("cancelar")) {
					if(FactionColl.get().getByTag(e.getMessage()) != null) {
						p.sendMessage("§eFacção "+FactionColl.get().getByTag(e.getMessage()).getTag()+" setada como primeira facção do duelo.");
						duelomap.put("fac_1", FactionColl.get().getByTag(e.getMessage()).getTag());
						new BukkitRunnable() {
						@Override
						public void run() {
							definindo.put(p, "guerra_duelos2");
							p.sendMessage("§e§lDigite a tag da segunda facção\n \n  §7Caso queira cancelar digite 'cancelar'");
						}
					}.runTaskLater(Main.getPlugin(Main.class), 2);
					}else {
						p.sendMessage("§cEssa facção não existe.");
					}
					}else {
						p.sendMessage("§cAção cancelada.");
						ComandoLocal.localoff.remove(p);
					}
				}
			}
		}
		if (definindo.get(p) != null) {
			if (definindo.get(p).contains("guerra_duelos2")) {
				if (ComandoLocal.localoff.contains(p)) {
					if(!e.getMessage().equalsIgnoreCase("cancelar")) {
					if(FactionColl.get().getByTag(e.getMessage()) != null) {
						p.sendMessage("§eFacção "+FactionColl.get().getByTag(e.getMessage()).getTag()+" setada como segunda facção do duelo.");
						duelomap.put("fac_2", FactionColl.get().getByTag(e.getMessage()).getTag());
						new BukkitRunnable() {
						@Override
						public void run() {
							definindo.put(p, "guerra_duelosa");
							p.sendMessage("§e§lDigite a arena que irá ocorrer\n \n  §7Caso queira cancelar digite 'cancelar'");
						}
					}.runTaskLater(Main.getPlugin(Main.class), 2);
					return;
				}else {
					p.sendMessage("§cEssa facção não existe.");
				}
					}else {
						p.sendMessage("§cAção cancelada.");
						ComandoLocal.localoff.remove(p);
					}
				}
			}
			}
		if (definindo.get(p) != null) {
			if (definindo.get(p).contains("guerra_duelosa")) {
				if (ComandoLocal.localoff.contains(p)) {
					if(!e.getMessage().equalsIgnoreCase("cancelar")) {
						if(StringUtils.isNumeric(e.getMessage())) {
						p.sendMessage("§eArena de número "+e.getMessage()+" definida para o duelo.");
						duelomap.put("arena", e.getMessage());
						new BukkitRunnable() {
						@Override
						public void run() {
							ComandoLocal.localoff.remove(p);
							definindo.remove(p);
							p.sendMessage("§eDuelo criado. "+duelomap.get("fac_1")+" x "+duelomap.get("fac_2")+" - Arena "+duelomap.get("arena"));
						}
					}.runTaskLater(Main.getPlugin(Main.class), 2);
					config.set("guerra.duelos."+duelomap.get("arena")+".fac1", duelomap.get("fac_1"));
					config.set("guerra.duelos."+duelomap.get("arena")+".fac2", duelomap.get("fac_2"));
					config.set("guerra.duelos."+duelomap.get("arena")+".arena", duelomap.get("arena"));
					config.saveConfig();
						}else {
					p.sendMessage("§cApenas números.");
				}
					}else {
						p.sendMessage("§cAção cancelada.");
						ComandoLocal.localoff.remove(p);
				}
				}
			}
	}
	}

}
