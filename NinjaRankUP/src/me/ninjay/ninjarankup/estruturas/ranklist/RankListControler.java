package me.ninjay.ninjarankup.estruturas.ranklist;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjarankup.main.Main;
import me.ninjay.ninjarankup.utils.Mine;

public class RankListControler implements CommandExecutor, Listener{
	
	public static ItemStack prox = Mine.newItem(Material.ARROW, "§aPróxima página");
	public static ItemStack ante = Mine.newItem(Material.ARROW, "§aPágina anterior");
	public static String erro(String local, String motivo) {
		return "§cConfiguração inválida detectada.\n§cLocal: "+local+"\n§cMotivo: "+motivo+"\n \n§cReporte essa falha a algum membro da equipe.";
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
		
			if(Main.config.getBoolean("menu.ativado") == true) {
				if(Main.config.getInt("menu.paginasSize") <= 6) {
				Inventory pag1 = Mine.newInventory("Página 1", 9*+Main.config.getInt("menu.paginasSize"));
					
				if(Main.config.getInt("menu.paginas") > 1) {
					if(Main.config.getInt("menu.proxPaginaSlot") <= 0) {
						pag1.setItem(0, prox);
					}else {
					if(Main.config.getInt("menu.proxPaginaSlot") <= 9*+Main.config.getInt("menu.paginasSize") && Main.config.getInt("menu.proxPaginaSlot") > 0) {
						pag1.setItem(Main.config.getInt("menu.proxPaginaSlot")-1, prox);
					}else {
						p.sendMessage(erro("config.yml", "'proxPaginaSlot' não pode ser maior do que "+9*+Main.config.getInt("menu.paginasSize")+"."));
					}
				}
			}
				for(RankList ranks : RankListAPI.manager.getRankList()) {
					if(ranks != null) {
						if(ranks.getPagina() == 1) {
							if(ranks.getSlot() <= 9*+Main.config.getInt("menu.paginasSize")) {
								pag1.setItem(ranks.getSlot()-1, ranks.getIcone());
							}else {
								p.sendMessage(erro("rankList.yml", "O slot do rank "+ranks.getIcone().getItemMeta().getDisplayName()+" §cnão pode ser maior do que "+9*+Main.config.getInt("menu.paginasSize")+"."));
							}
						}
					}else {
						p.sendMessage(erro("rankList.yml", "Nenhum rank foi encontrado."));
					}
				}
				
				p.openInventory(pag1);
				
				}else {
					p.sendMessage(erro("config.yml", "'paginasSize' não pode ser maior do que 6 linhas."));
				}
				
				
			}
			
			if(Main.config.getBoolean("texto.ativado") == true) {
				for(String texto : Main.config.getStringList("texto.mensagem")) {
					p.sendMessage(texto.replace("&", "§"));
				}
			}
			
		}
		return false;
	}
	
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		Integer pag = Mine.toInt(e.getView().getTitle().replace("Página ", ""));
		
		if(e.getView().getTitle().contains("Página")) {
			e.setCancelled(true);
		}
	if(e.getCurrentItem() != null) {
	if(pag+1 < Main.config.getInt("menu.paginas")) {
		if(e.getCurrentItem().isSimilar(prox)) {
			p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
			if(Main.config.getInt("menu.paginasSize") <= 6) {
				Inventory menu = Mine.newInventory("Página "+Mine.toInt(pag+1), 9*+Main.config.getInt("menu.paginasSize"));
				if(Main.config.getInt("menu.proxPaginaSlot") <= 0) {
					menu.setItem(0, prox);
				}else {
				if(Main.config.getInt("menu.proxPaginaSlot") <= 9*+Main.config.getInt("menu.paginasSize") && Main.config.getInt("menu.proxPaginaSlot") > 0) {
					menu.setItem(Main.config.getInt("menu.proxPaginaSlot")-1, prox);
				}else {
					p.sendMessage(erro("config.yml", "'proxPaginaSlot' não pode ser maior do que "+9*+Main.config.getInt("menu.paginasSize")+"."));
				}
				
				if(Main.config.getInt("menu.antePaginaSlot") <= 0) {
					menu.setItem(0, ante);
				}else {
				if(Main.config.getInt("menu.antePaginaSlot") <= 9*+Main.config.getInt("menu.paginasSize") && Main.config.getInt("menu.antePaginaSlot") > 0) {
					menu.setItem(Main.config.getInt("menu.antePaginaSlot")-1, ante);
				}else {
					p.sendMessage(erro("config.yml", "'antePaginaSlot' não pode ser maior do que "+9*+Main.config.getInt("menu.paginasSize")+"."));
				}
				}
			}
				for(RankList ranks : RankListAPI.manager.getRankList()) {
					if(ranks != null) {
						if(ranks.getPagina() == pag+1) {
							if(ranks.getSlot() <= 9*+Main.config.getInt("menu.paginasSize")) {
								menu.setItem(ranks.getSlot()-1, ranks.getIcone());
							}else {
								p.sendMessage(erro("rankList.yml", "O slot do rank "+ranks.getIcone().getItemMeta().getDisplayName()+" §cnão pode ser maior do que "+9*+Main.config.getInt("menu.paginasSize")+"."));
							}
						}
					}else {
						p.sendMessage(erro("rankList.yml", "Nenhum rank foi encontrado."));
					}
				}
				
				p.openInventory(menu);
				
			}else {
				p.sendMessage(erro("config.yml", "'paginasSize' não pode ser maior do que 6 linhas."));
			}
		}
		}else {
			if(e.getCurrentItem().isSimilar(prox)) {
				p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
				if(Main.config.getInt("menu.paginasSize") <= 6) {
					Inventory menu = Mine.newInventory("Página "+Mine.toInt(pag+1), 9*+Main.config.getInt("menu.paginasSize"));
					if(Main.config.getInt("menu.antePaginaSlot") <= 0) {
						menu.setItem(0, ante);
					}else {
					if(Main.config.getInt("menu.antePaginaSlot") <= 9*+Main.config.getInt("menu.paginasSize") && Main.config.getInt("menu.antePaginaSlot") > 0) {
						menu.setItem(Main.config.getInt("menu.antePaginaSlot")-1, ante);
					}else {
						p.sendMessage(erro("config.yml", "'antePaginaSlot' não pode ser maior do que "+9*+Main.config.getInt("menu.paginasSize")+"."));
					}
					}
					for(RankList ranks : RankListAPI.manager.getRankList()) {
						if(ranks != null) {
							if(ranks.getPagina() == pag+1) {
								if(ranks.getSlot() <= 9*+Main.config.getInt("menu.paginasSize")) {
									menu.setItem(ranks.getSlot()-1, ranks.getIcone());
								}else {
									p.sendMessage(erro("rankList.yml", "O slot do rank "+ranks.getIcone().getItemMeta().getDisplayName()+" §cnão pode ser maior do que "+9*+Main.config.getInt("menu.paginasSize")+"."));
								}
							}
						}else {
							p.sendMessage(erro("rankList.yml", "Nenhum rank foi encontrado."));
						}
					}
					
					p.openInventory(menu);
					
				}else {
					p.sendMessage(erro("config.yml", "'paginasSize' não pode ser maior do que 6 linhas."));
				}
			}
		}
	if(pag-1 > 1) {
		if(e.getCurrentItem().isSimilar(ante)) {
			p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
			if(Main.config.getInt("menu.paginasSize") <= 6) {
				Inventory menu = Mine.newInventory("Página "+Mine.toInt(pag-1), 9*+Main.config.getInt("menu.paginasSize"));
				if(Main.config.getInt("menu.proxPaginaSlot") <= 0) {
					menu.setItem(0, prox);
				}else {
				if(Main.config.getInt("menu.proxPaginaSlot") <= 9*+Main.config.getInt("menu.paginasSize") && Main.config.getInt("menu.proxPaginaSlot") > 0) {
					menu.setItem(Main.config.getInt("menu.proxPaginaSlot")-1, prox);
				}else {
					p.sendMessage(erro("config.yml", "'proxPaginaSlot' não pode ser maior do que "+9*+Main.config.getInt("menu.paginasSize")+"."));
				}
				
				if(Main.config.getInt("menu.antePaginaSlot") <= 0) {
					menu.setItem(0, prox);
				}else {
				if(Main.config.getInt("menu.antePaginaSlot") <= 9*+Main.config.getInt("menu.paginasSize") && Main.config.getInt("menu.antePaginaSlot") > 0) {
					menu.setItem(Main.config.getInt("menu.antePaginaSlot")-1, ante);
				}else {
					p.sendMessage(erro("config.yml", "'antePaginaSlot' não pode ser maior do que "+9*+Main.config.getInt("menu.paginasSize")+"."));
				}
				}
			}
				for(RankList ranks : RankListAPI.manager.getRankList()) {
					if(ranks != null) {
						if(ranks.getPagina() == pag-1) {
							if(ranks.getSlot() <= 9*+Main.config.getInt("menu.paginasSize")) {
								menu.setItem(ranks.getSlot()-1, ranks.getIcone());
							}else {
								p.sendMessage(erro("rankList.yml", "O slot do rank "+ranks.getIcone().getItemMeta().getDisplayName()+" §cnão pode ser maior do que "+9*+Main.config.getInt("menu.paginasSize")+"."));
							}
						}
					}else {
						p.sendMessage(erro("rankList.yml", "Nenhum rank foi encontrado."));
					}
				}
				
				p.openInventory(menu);
				
			}else {
				p.sendMessage(erro("config.yml", "'paginasSize' não pode ser maior do que 6 linhas."));
			}
		}
	}else {
		if(e.getCurrentItem().isSimilar(ante)) {
			p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
			if(Main.config.getInt("menu.paginasSize") <= 6) {
			Inventory pag1 = Mine.newInventory("Página 1", 9*+Main.config.getInt("menu.paginasSize"));
				
			if(Main.config.getInt("menu.paginas") > 1) {
				if(Main.config.getInt("menu.proxPaginaSlot") <= 0) {
					pag1.setItem(0, prox);
				}else {
				if(Main.config.getInt("menu.proxPaginaSlot") <= 9*+Main.config.getInt("menu.paginasSize") && Main.config.getInt("menu.proxPaginaSlot") > 0) {
					pag1.setItem(Main.config.getInt("menu.proxPaginaSlot")-1, prox);
				}else {
					p.sendMessage(erro("config.yml", "'proxPaginaSlot' não pode ser maior do que "+9*+Main.config.getInt("menu.paginasSize")+"."));
				}
			}
		}
			for(RankList ranks : RankListAPI.manager.getRankList()) {
				if(ranks != null) {
					if(ranks.getPagina() == 1) {
						if(ranks.getSlot() <= 9*+Main.config.getInt("menu.paginasSize")) {
							pag1.setItem(ranks.getSlot()-1, ranks.getIcone());
						}else {
							p.sendMessage(erro("rankList.yml", "O slot do rank "+ranks.getIcone().getItemMeta().getDisplayName()+" §cnão pode ser maior do que "+9*+Main.config.getInt("menu.paginasSize")+"."));
						}
					}
				}else {
					p.sendMessage(erro("rankList.yml", "Nenhum rank foi encontrado."));
				}
			}
			
			p.openInventory(pag1);
			
			}else {
				p.sendMessage(erro("config.yml", "'paginasSize' não pode ser maior do que 6 linhas."));
			}
		}
	}
	}
	}

}
