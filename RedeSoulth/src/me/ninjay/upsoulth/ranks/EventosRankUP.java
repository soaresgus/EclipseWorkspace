package me.ninjay.upsoulth.ranks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.upsoulth.main.Main;
import net.eduard.api.lib.modules.VaultAPI;

public class EventosRankUP implements Listener {
	@EventHandler
	public void ConfirmarCold3(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Cold III")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 30000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 12500) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Cold II !");
						Main.bloco.set(p.getName(), 00);
						Main.bloco.saveConfig();
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aCold II");
						VaultAPI.getEconomy().withdrawPlayer(p, 12500);
						VaultAPI.getPermission().playerAdd(p, "cold2.rank");
						VaultAPI.getPermission().playerAdd(p, "cold3.rank");
						VaultAPI.getPermission().playerAddGroup(p, "ColdII");
						VaultAPI.getPermission().playerAddGroup(p, "ColdIII");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 30000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 12500) {
					if ((Main.bloco.getDouble(p.getName()) < 30000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 12500) {
						if ((Main.bloco.getDouble(p.getName()) >= 30000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 12500) {
						if (Main.bloco.getDouble(p.getName()) < 30000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void NegarCold3(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Cold III")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmarcold2(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Cold II")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 35000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 21870) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Cold I !");
						Main.bloco.set(p.getName(), 00);
						Main.bloco.saveConfig();
						VaultAPI.getEconomy().withdrawPlayer(p, 21870);
						VaultAPI.getPermission().playerRemove(p, "cold2.rank");
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aCold I");
						VaultAPI.getPermission().playerAdd(p, "cold1.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "ColdII");
						VaultAPI.getPermission().playerAddGroup(p, "ColdI");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 35000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 21870) {
					if ((Main.bloco.getDouble(p.getName()) < 35000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 21870) {
						if ((Main.bloco.getDouble(p.getName()) >= 35000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 21870) {
						if (Main.bloco.getDouble(p.getName()) < 35000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negarcold2(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Cold II")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmarcold1(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Cold I")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 40000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 38280) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Dark III !");
						Main.bloco.set(p.getName(), 00);
						Main.bloco.saveConfig();
						VaultAPI.getEconomy().withdrawPlayer(p, 38280);
						VaultAPI.getPermission().playerRemove(p, "cold1.rank");
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aDark III");
						VaultAPI.getPermission().playerAdd(p, "dark3.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "ColdI");
						VaultAPI.getPermission().playerAddGroup(p, "DarkIII");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 40000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 38280) {
					if ((Main.bloco.getDouble(p.getName()) < 40000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 38280) {
						if ((Main.bloco.getDouble(p.getName()) >= 40000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 38280) {
						if (Main.bloco.getDouble(p.getName()) < 40000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negarcold1(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Cold I")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmardark3(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Dark III")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 45000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 66990) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Dark II !");
						Main.bloco.set(p.getName(), 00);
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aDark II");
						Main.bloco.saveConfig();
						VaultAPI.getEconomy().withdrawPlayer(p, 66990);
						VaultAPI.getPermission().playerRemove(p, "dark3.rank");
						VaultAPI.getPermission().playerAdd(p, "dark2.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "DarkIII");
						VaultAPI.getPermission().playerAddGroup(p, "DarkII");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 45000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 66990) {
					if ((Main.bloco.getDouble(p.getName()) < 45000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 66990) {
						if ((Main.bloco.getDouble(p.getName()) >= 45000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 66990) {
						if (Main.bloco.getDouble(p.getName()) < 45000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negardark3(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Dark III")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmardark2(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Dark II")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 50000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 117200) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Dark I !");
						Main.bloco.set(p.getName(), 00);
						Main.bloco.saveConfig();
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aDark I");
						VaultAPI.getEconomy().withdrawPlayer(p, 117200);
						VaultAPI.getPermission().playerRemove(p, "dark2.rank");
						VaultAPI.getPermission().playerAdd(p, "dark1.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "DarkII");
						VaultAPI.getPermission().playerAddGroup(p, "DarkI");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 50000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 117200) {
					if ((Main.bloco.getDouble(p.getName()) < 50000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 117200) {
						if ((Main.bloco.getDouble(p.getName()) >= 50000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 117200) {
						if (Main.bloco.getDouble(p.getName()) < 50000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negardark2(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Dark II")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmardark1(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Dark I")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 55000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 205100) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Flight III !");
						Main.bloco.set(p.getName(), 00);
						Main.bloco.saveConfig();
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aFlight III");
						VaultAPI.getEconomy().withdrawPlayer(p, 205100);
						VaultAPI.getPermission().playerRemove(p, "dark1.rank");
						VaultAPI.getPermission().playerAdd(p, "flight3.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "DarkI");
						VaultAPI.getPermission().playerAddGroup(p, "FlightIII");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 55000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 205100) {
					if ((Main.bloco.getDouble(p.getName()) < 55000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 205100) {
						if ((Main.bloco.getDouble(p.getName()) >= 55000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 205100) {
						if (Main.bloco.getDouble(p.getName()) < 55000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negardark1(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Dark I")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmarflight3(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Flight III")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 60000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 359000) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Flight II !");
						Main.bloco.set(p.getName(), 00);
						Main.bloco.saveConfig();
						VaultAPI.getEconomy().withdrawPlayer(p, 359000);
						VaultAPI.getPermission().playerRemove(p, "flight3.rank");
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aFlight II");
						VaultAPI.getPermission().playerAdd(p, "flight2.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "FlightIII");
						VaultAPI.getPermission().playerAddGroup(p, "FlightII");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 60000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 359000) {
					if ((Main.bloco.getDouble(p.getName()) < 60000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 359000) {
						if ((Main.bloco.getDouble(p.getName()) >= 60000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 359000) {
						if (Main.bloco.getDouble(p.getName()) < 60000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negarflight3(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Flight III")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmarflight2(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Flight II")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 65000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 628200) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Flight I !");
						Main.bloco.set(p.getName(), 00);
						Main.bloco.saveConfig();
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aFlight I");
						VaultAPI.getEconomy().withdrawPlayer(p, 628200);
						VaultAPI.getPermission().playerRemove(p, "flight2.rank");
						VaultAPI.getPermission().playerAdd(p, "flight1.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "FlightII");
						VaultAPI.getPermission().playerAddGroup(p, "FlightI");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 65000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 628200) {
					if ((Main.bloco.getDouble(p.getName()) < 65000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 628200) {
						if ((Main.bloco.getDouble(p.getName()) >= 65000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 628200) {
						if (Main.bloco.getDouble(p.getName()) < 65000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negarflight2(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Flight II")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmarflight1(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Flight I")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 70000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 1099000) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Souls III !");
						Main.bloco.set(p.getName(), 00);
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aSouls III");
						Main.bloco.saveConfig();
						VaultAPI.getEconomy().withdrawPlayer(p, 1099000);
						VaultAPI.getPermission().playerRemove(p, "flight1.rank");
						VaultAPI.getPermission().playerAdd(p, "souls3.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "FlightI");
						VaultAPI.getPermission().playerAddGroup(p, "SoulsIII");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 70000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 1099000) {
					if ((Main.bloco.getDouble(p.getName()) < 70000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 1099000) {
						if ((Main.bloco.getDouble(p.getName()) >= 70000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 1099000) {
						if (Main.bloco.getDouble(p.getName()) < 70000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negarflight1(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Flight I")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmarsouls3(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Souls III")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 75000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 1924000) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Souls II !");
						Main.bloco.set(p.getName(), 00);
						Main.bloco.saveConfig();
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aSouls II");
						VaultAPI.getEconomy().withdrawPlayer(p, 1924000);
						VaultAPI.getPermission().playerRemove(p, "souls3.rank");
						VaultAPI.getPermission().playerAdd(p, "souls2.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "SoulsIII");
						VaultAPI.getPermission().playerAddGroup(p, "SoulsII");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 75000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 1924000) {
					if ((Main.bloco.getDouble(p.getName()) < 75000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 1924000) {
						if ((Main.bloco.getDouble(p.getName()) >= 75000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 1924000) {
						if (Main.bloco.getDouble(p.getName()) < 75000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negarsouls3(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Souls III")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmarsouls2(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Souls II")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 80000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 3367000) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Souls I !");
						Main.bloco.set(p.getName(), 00);
						Main.bloco.saveConfig();
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aSouls I");
						VaultAPI.getEconomy().withdrawPlayer(p, 3367000);
						VaultAPI.getPermission().playerRemove(p, "souls2.rank");
						VaultAPI.getPermission().playerAdd(p, "souls1.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "SoulsII");
						VaultAPI.getPermission().playerAddGroup(p, "SoulsI");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 80000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 3367000) {
					if ((Main.bloco.getDouble(p.getName()) < 80000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 3367000) {
						if ((Main.bloco.getDouble(p.getName()) >= 80000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 3367000) {
						if (Main.bloco.getDouble(p.getName()) < 80000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negarsouls2(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Souls II")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmarsouls1(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Souls I")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 85000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 5892000) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Killer III !");
						Main.bloco.set(p.getName(), 00);
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aKiller III");
						Main.bloco.saveConfig();
						VaultAPI.getEconomy().withdrawPlayer(p, 5892000);
						VaultAPI.getPermission().playerRemove(p, "souls1.rank");
						VaultAPI.getPermission().playerAdd(p, "killer3.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "SoulsI");
						VaultAPI.getPermission().playerAddGroup(p, "KillerIII");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 85000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 5892000) {
					if ((Main.bloco.getDouble(p.getName()) < 85000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 5892000) {
						if ((Main.bloco.getDouble(p.getName()) >= 85000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 5892000) {
						if (Main.bloco.getDouble(p.getName()) < 85000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negarsouls1(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Souls I")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmarkiller3(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Killer III")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 90000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 10310000) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Killer II !");
						Main.bloco.set(p.getName(), 00);
						Main.bloco.saveConfig();
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aKiller II");
						VaultAPI.getEconomy().withdrawPlayer(p, 10310000);
						VaultAPI.getPermission().playerRemove(p, "killer3.rank");
						VaultAPI.getPermission().playerAdd(p, "killer2.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "KillerIII");
						VaultAPI.getPermission().playerAddGroup(p, "KillerII");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 90000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 10310000) {
					if ((Main.bloco.getDouble(p.getName()) < 90000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 10310000) {
						if ((Main.bloco.getDouble(p.getName()) >= 90000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 10310000) {
						if (Main.bloco.getDouble(p.getName()) < 90000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negarkiller3(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Killer III")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmarkiller2(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Killer II")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 95000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 18040000) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Killer I !");
						Main.bloco.set(p.getName(), 00);
						Main.bloco.saveConfig();
						VaultAPI.getEconomy().withdrawPlayer(p, 18040000);
						VaultAPI.getPermission().playerRemove(p, "killer2.rank");
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aKiller I");
						VaultAPI.getPermission().playerAdd(p, "killer1.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "KillerII");
						VaultAPI.getPermission().playerAddGroup(p, "KillerI");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 95000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 18040000) {
					if ((Main.bloco.getDouble(p.getName()) < 95000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 18040000) {
						if ((Main.bloco.getDouble(p.getName()) >= 95000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 18040000) {
						if (Main.bloco.getDouble(p.getName()) < 95000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negarkiller2(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Killer II")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmarkiller1(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Killer I")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 100000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 31570000) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Demo III !");
						Main.bloco.set(p.getName(), 00);
						Main.bloco.saveConfig();
						
						VaultAPI.getEconomy().withdrawPlayer(p, 31570000);
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aDemo III");
						VaultAPI.getPermission().playerRemove(p, "killer1.rank");
						VaultAPI.getPermission().playerAdd(p, "demo3.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "KillerI");
						VaultAPI.getPermission().playerAddGroup(p, "DemoIII");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 100000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 31570000) {
					if ((Main.bloco.getDouble(p.getName()) < 100000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 31570000) {
						if ((Main.bloco.getDouble(p.getName()) >= 100000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 31570000) {
						if (Main.bloco.getDouble(p.getName()) < 100000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negarkiller1(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Killer I")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmardemo3(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Demo III")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 105000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 46890000) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Demo II !");
						Main.bloco.set(p.getName(), 00);
						Main.bloco.saveConfig();
						
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aDemo II");
						VaultAPI.getEconomy().withdrawPlayer(p, 46890000);
						VaultAPI.getPermission().playerRemove(p, "demo3.rank");
						VaultAPI.getPermission().playerAdd(p, "demo2.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "DemoIII");
						VaultAPI.getPermission().playerAddGroup(p, "DemoII");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 105000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 46890000) {
					if ((Main.bloco.getDouble(p.getName()) < 105000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 46890000) {
						if ((Main.bloco.getDouble(p.getName()) >= 105000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 46890000) {
						if (Main.bloco.getDouble(p.getName()) < 105000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negardemo3(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Demo III")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmardemo2(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Demo II")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 110000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 70384000) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Demo I !");
						Main.bloco.set(p.getName(), 00);
						Main.bloco.saveConfig();
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aDemo I");
						VaultAPI.getEconomy().withdrawPlayer(p, 70384000);
						VaultAPI.getPermission().playerRemove(p, "demo2.rank");
						VaultAPI.getPermission().playerAdd(p, "demo1.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "DemoII");
						VaultAPI.getPermission().playerAddGroup(p, "DemoI");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 110000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 70384000) {
					if ((Main.bloco.getDouble(p.getName()) < 110000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 70384000) {
						if ((Main.bloco.getDouble(p.getName()) >= 110000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 70384000) {
						if (Main.bloco.getDouble(p.getName()) < 110000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negardemo2(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Demo II")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmardemo1(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Demo I")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 115000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 129289000) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Dingy III !");
						Main.bloco.set(p.getName(), 00);
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aDingy III");
						Main.bloco.saveConfig();
						VaultAPI.getEconomy().withdrawPlayer(p, 129289000);
						VaultAPI.getPermission().playerRemove(p, "demo1.rank");
						VaultAPI.getPermission().playerAdd(p, "dingy3.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "DemoI");
						VaultAPI.getPermission().playerAddGroup(p, "DingyIII");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 115000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 129289000) {
					if ((Main.bloco.getDouble(p.getName()) < 115000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 129289000) {
						if ((Main.bloco.getDouble(p.getName()) >= 115000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 129289000) {
						if (Main.bloco.getDouble(p.getName()) < 115000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negardemo1(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Demo I")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmardingy3(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Dingy III")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 120000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 194284000) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Dingy II !");
						Main.bloco.set(p.getName(), 00);
						Main.bloco.saveConfig();
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aDingy II");
						VaultAPI.getEconomy().withdrawPlayer(p, 194284000);
						VaultAPI.getPermission().playerRemove(p, "dingy3.rank");
						VaultAPI.getPermission().playerAdd(p, "dingy2.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "DingyIII");
						VaultAPI.getPermission().playerAddGroup(p, "DingyII");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 120000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 194284000) {
					if ((Main.bloco.getDouble(p.getName()) < 120000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 194284000) {
						if ((Main.bloco.getDouble(p.getName()) >= 120000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 194284000) {
						if (Main.bloco.getDouble(p.getName()) < 120000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negardingy3(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Dingy III")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmardingy2(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Dingy II")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 125000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 285393000) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Dingy I !");
						Main.bloco.set(p.getName(), 00);
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aDingy I");
						Main.bloco.saveConfig();
						VaultAPI.getEconomy().withdrawPlayer(p, 285393000);
						VaultAPI.getPermission().playerRemove(p, "dingy2.rank");
						VaultAPI.getPermission().playerAdd(p, "dingy1.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "DingyII");
						VaultAPI.getPermission().playerAddGroup(p, "DingyI");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 125000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 285393000) {
					if ((Main.bloco.getDouble(p.getName()) < 125000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 285393000) {
						if ((Main.bloco.getDouble(p.getName()) >= 125000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 285393000) {
						if (Main.bloco.getDouble(p.getName()) < 125000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negardingy2(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Dingy II")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmardingy1(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Dingy I")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 130000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 495948000) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Ômega III !");
						Main.bloco.set(p.getName(), 00);
						Main.bloco.saveConfig();
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aÔmega III");
						VaultAPI.getEconomy().withdrawPlayer(p, 495948000);
						VaultAPI.getPermission().playerRemove(p, "dingy1.rank");
						VaultAPI.getPermission().playerAdd(p, "omega3.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "DingyI");
						VaultAPI.getPermission().playerAddGroup(p, "ÔmegaIII");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 130000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 495948000) {
					if ((Main.bloco.getDouble(p.getName()) < 130000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 495948000) {
						if ((Main.bloco.getDouble(p.getName()) >= 130000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 495948000) {
						if (Main.bloco.getDouble(p.getName()) < 130000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negardingy1(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Dingy I")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmaromega3(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Ômega III")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 135000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 658958000) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Ômega II !");
						Main.bloco.set(p.getName(), 00);
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aÔmega II");
						Main.bloco.saveConfig();
						VaultAPI.getEconomy().withdrawPlayer(p, 658958000);
						VaultAPI.getPermission().playerRemove(p, "omega3.rank");
						VaultAPI.getPermission().playerAdd(p, "omega2.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "ÔmegaIII");
						VaultAPI.getPermission().playerAddGroup(p, "ÔmegaII");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 135000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 658958000) {
					if ((Main.bloco.getDouble(p.getName()) < 135000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 658958000) {
						if ((Main.bloco.getDouble(p.getName()) >= 135000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 658958000) {
						if (Main.bloco.getDouble(p.getName()) < 135000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negaromega3(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Ômega III")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}
	@EventHandler
	public void Confirmaromega2(InventoryClickEvent e) {
		ItemStack confirmar = Mine.newItem(Material.WOOL, "§aConfirmar", 1, 5);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Ômega II")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(confirmar)) {
				if (Main.bloco.getDouble(p.getName()) >= 140000) {
					if (VaultAPI.getEconomy().getBalance(p) >= 893838000) {
						p.getOpenInventory().close();
						Bukkit.broadcastMessage(
								"§e§l[Soulth Rank] §eO jogador " + p.getName() + " upou para o rank Ômega I !");
						Main.bloco.set(p.getName(), 00);
						Mine.sendActionBar("§a§lYEAH! §fO jogador §a"+p.getName()+" §fevoluiu para §aÔmega I");
						Main.bloco.saveConfig();
						VaultAPI.getEconomy().withdrawPlayer(p, 893838000);
						VaultAPI.getPermission().playerRemove(p, "omega2.rank");
						VaultAPI.getPermission().playerAdd(p, "omega1.rank");
						VaultAPI.getPermission().playerRemoveGroup(p, "ÔmegaII");
						VaultAPI.getPermission().playerAddGroup(p, "ÔmegaI");
						return;
					}
					
						if (Main.bloco.getDouble(p.getName()) < 140000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem os blocos quebrados suficientes para upar de rank !");
							return;
						}
						

					}
				if (VaultAPI.getEconomy().getBalance(p) >= 893838000) {
					if ((Main.bloco.getDouble(p.getName()) < 140000)) {
						p.getOpenInventory().close();
						p.sendMessage("§cVocê §c§lNÃO §ctem blocos quebrados suficientes para upar de rank !");
						return;
					}
			}
					if (VaultAPI.getEconomy().getBalance(p) < 893838000) {
						if ((Main.bloco.getDouble(p.getName()) >= 140000)) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem o dinheiro suficiente para upar de rank !");
							return;
						}
				}
					if (VaultAPI.getEconomy().getBalance(p) < 893838000) {
						if (Main.bloco.getDouble(p.getName()) < 140000) {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê §c§lNÃO §ctem dinheiro e nem blocos quebrados suficientes para upar de rank !");
							return;
						}
				}
					if(!e.getCurrentItem().isSimilar(confirmar)) {
						return;
					}
						
				}
			}
		}
		

	@EventHandler
	public void Negaromega2(InventoryClickEvent e) {
		ItemStack negar = Mine.newItem(Material.WOOL, "§cCancelar", 1, 14);
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Ômega II")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(negar)) {
				p.getOpenInventory().close();
				p.sendMessage("§cOperação §c§lNEGADA §cpelo jogador.");
				return;
			}else {
				return;
			
			}
		}
	}

		}
		


