package me.ninjay.kustbaus.comandos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.ninjay.kustbaus.main.Main;
import me.ninjay.kustbaus.utils.Mine;
import me.ninjay.kustlogs.estruturas.LogsAPI;

public class ComandoGiveBau implements CommandExecutor, Listener{
	
	public static ItemStack bau = Mine.newItem(Material.CHEST, "§6Baú Extra", 1, 0, "§7Utilize este item para receber","§71 (um) baú virtual extra.");
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(p.hasPermission("bau.admin")) {
				if(args.length == 0) {
					p.sendMessage("§cUse /givebau <nick>.");
					return true;
				}
				Player j = Bukkit.getPlayer(args[0]);
				if(j != null) {
					j.getInventory().addItem(bau);
					p.sendMessage("§aBaú extra enviado para "+j.getName());
				}else {
					p.sendMessage("§cJogador offline.");
				}
			}
		}else {
				if(args.length == 0) {
					sender.sendMessage("§cUse /givebau <nick>.");
					return true;
				}
				Player j = Bukkit.getPlayer(args[0]);
				if(j != null) {
					j.getInventory().addItem(bau);
					sender.sendMessage("§aBaú extra enviado para "+j.getName());
				}else {
					sender.sendMessage("§cJogador offline.");
				}
		}
		return false;
	}
	
	@EventHandler
	public void aoClicar(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(p.getItemInHand() != null) {
			if(p.getItemInHand().getItemMeta() != null) {
				if(p.getItemInHand().isSimilar(bau)) {
					if(Main.pchest.getBoolean(p.getName()+".bau1.ativo") == false) {
						Mine.remove(p.getInventory(), p.getItemInHand(), 1);
						p.sendMessage("§aBaú de número 1 ativo.");
						LogsAPI.register(p.getName(), p.getName()+" ativou o baú 1 no baú extra", me.ninjay.kustlogs.main.Main.playerGeral);
						Main.pchest.set(p.getName()+".bau1.ativo", true);
						Main.pchest.saveConfig();
						return;
					}else {
						if(Main.pchest.getBoolean(p.getName()+".bau2.ativo") == false) {
							Mine.remove(p.getInventory(), p.getItemInHand(), 1);
							p.sendMessage("§aBaú de número 2 ativo.");
							LogsAPI.register(p.getName(), p.getName()+" ativou o baú 2 no baú extra", me.ninjay.kustlogs.main.Main.playerGeral);
							Main.pchest.set(p.getName()+".bau2.ativo", true);
							Main.pchest.saveConfig();
							return;
						}else {
							if(Main.pchest.getBoolean(p.getName()+".bau3.ativo") == false) {
								Mine.remove(p.getInventory(), p.getItemInHand(), 1);
								p.sendMessage("§aBaú de número 3 ativo.");
								LogsAPI.register(p.getName(), p.getName()+" ativou o baú 3 no baú extra", me.ninjay.kustlogs.main.Main.playerGeral);
								Main.pchest.set(p.getName()+".bau3.ativo", true);
								Main.pchest.saveConfig();
								return;
							}else {
								if(Main.pchest.getBoolean(p.getName()+".bau4.ativo") == false) {
									Mine.remove(p.getInventory(), p.getItemInHand(), 1);
									p.sendMessage("§aBaú de número 4 ativo.");
									LogsAPI.register(p.getName(), p.getName()+" ativou o baú 4 no baú extra", me.ninjay.kustlogs.main.Main.playerGeral);
									Main.pchest.set(p.getName()+".bau4.ativo", true);
									Main.pchest.saveConfig();
									return;
								}else {
									if(Main.pchest.getBoolean(p.getName()+".bau5.ativo") == false) {
										Mine.remove(p.getInventory(), p.getItemInHand(), 1);
										p.sendMessage("§aBaú de número 5 ativo.");
										LogsAPI.register(p.getName(), p.getName()+" ativou o baú 5 no baú extra", me.ninjay.kustlogs.main.Main.playerGeral);
										Main.pchest.set(p.getName()+".bau5.ativo", true);
										Main.pchest.saveConfig();
										return;
									}else {
										p.sendMessage("§cVocê atingiu o número máximo de baús.");
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
