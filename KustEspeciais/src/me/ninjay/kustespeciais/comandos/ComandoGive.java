package me.ninjay.kustespeciais.comandos;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.massivecraft.factions.entity.MPlayer;

import me.ninjay.kustespeciais.estruturas.ItensAPI;
import me.ninjay.kustespeciais.main.Main;
import me.ninjay.kustespeciais.utils.Mine;

public class ComandoGive implements CommandExecutor, Listener{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(p.hasPermission("especiais.admin")) {
				if(args.length == 0) {
					p.sendMessage("§cUse: /giveespeciais <nick> <item> <quantidade>.");
					return true;
				}
				Player j = Bukkit.getPlayer(args[0]);
				if(j != null) {
					if(args.length == 1) {
						p.sendMessage("§6Lista de itens especiais: \n §e- Creeper\n §e- PoderM\n §e- Booster\n §e- Reset\n §e- PoderI\n §e- Raio");
						return true;
					}else {
					if(args.length > 2) {
						if(StringUtils.isNumeric(args[2])) {
						if(args[1].equalsIgnoreCase("creeper")) {
							p.sendMessage("§aCreeper enviado para "+j.getName());
							for(int i = 1; i <= Mine.toInt(args[2]); i++) {
							j.getInventory().addItem(ItensAPI.crepper);
							}
						}
						if(args[1].equalsIgnoreCase("poderm")) {
							p.sendMessage("§aPoder máximo enviado para "+j.getName());
							for(int i = 1; i <= Mine.toInt(args[2]); i++) {
								j.getInventory().addItem(ItensAPI.poder);
								}
						}
						if(args[1].equalsIgnoreCase("booster")) {
							p.sendMessage("§aBooster enviado para "+j.getName());
							for(int i = 1; i <= Mine.toInt(args[2]); i++) {
							p.getServer().dispatchCommand(p.getServer().getConsoleSender(), "darbooster "+j.getName());
							}
						}
						if(args[1].equalsIgnoreCase("reset")) {
							p.sendMessage("§aReset KDR enviado para "+j.getName());
							for(int i = 1; i <= Mine.toInt(args[2]); i++) {
							j.getInventory().addItem(ItensAPI.kdr);
							}
						}
						if(args[1].equalsIgnoreCase("poderi")) {
							p.sendMessage("§aPoder Instantâneo enviado para "+j.getName());
							for(int i = 1; i <= Mine.toInt(args[2]); i++) {
							j.getInventory().addItem(ItensAPI.instantaneo);
							}
						}
						if(args[1].equalsIgnoreCase("raio")) {
							p.sendMessage("§aRaio mestre enviado para "+j.getName());
							for(int i = 1; i <= Mine.toInt(args[2]); i++) {
							j.getInventory().addItem(ItensAPI.raio());
							}
						}
						}else {
							p.sendMessage("§cApenas números.");
						}
					}else {
						p.sendMessage("§cUse: /giveespeciais <nick> <item> <quantidade>.");
					}
					}
				}else {
					p.sendMessage("§cJogador offline.");
				}
			}
			
		}else {
			if(args.length == 0) {
				sender.sendMessage("§cUse: /giveespeciais <nick> <item>.");
				return true;
			}
			Player j = Bukkit.getPlayer(args[0]);
			if(j != null) {
				if(args.length == 1) {
					sender.sendMessage("§6Lista de itens especiais: \n §e- Creeper\n §e- PoderM\n §e- Booster\n §e- Reset\n §e- PoderI\n §e- Raio");
					return true;
				}else {
				if(args.length > 2) {
					if(StringUtils.isNumeric(args[2])) {
					if(args[1].equalsIgnoreCase("creeper")) {
						sender.sendMessage("§aCreeper enviado para "+j.getName());
						for(int i = 1; i <= Mine.toInt(args[2]); i++) {
						j.getInventory().addItem(ItensAPI.crepper);
						}
					}
					if(args[1].equalsIgnoreCase("poderm")) {
						sender.sendMessage("§aPoder máximo enviado para "+j.getName());
						for(int i = 1; i <= Mine.toInt(args[2]); i++) {
							j.getInventory().addItem(ItensAPI.poder);
							}
					}
					if(args[1].equalsIgnoreCase("booster")) {
						sender.sendMessage("§aBooster enviado para "+j.getName());
						for(int i = 1; i <= Mine.toInt(args[2]); i++) {
						sender.getServer().dispatchCommand(sender.getServer().getConsoleSender(), "darbooster "+j.getName());
						}
					}
					if(args[1].equalsIgnoreCase("reset")) {
						sender.sendMessage("§aReset KDR enviado para "+j.getName());
						for(int i = 1; i <= Mine.toInt(args[2]); i++) {
						j.getInventory().addItem(ItensAPI.kdr);
						}
					}
					if(args[1].equalsIgnoreCase("poderi")) {
						sender.sendMessage("§aPoder Instantâneo enviado para "+j.getName());
						for(int i = 1; i <= Mine.toInt(args[2]); i++) {
						j.getInventory().addItem(ItensAPI.instantaneo);
						}
					}
					if(args[1].equalsIgnoreCase("raio")) {
						sender.sendMessage("§aRaio mestre enviado para "+j.getName());
						for(int i = 1; i <= Mine.toInt(args[2]); i++) {
						j.getInventory().addItem(ItensAPI.raio());
						}
					}
					}else {
						sender.sendMessage("§cApenas números.");
					}
				}else {
					sender.sendMessage("§cUse: /giveespeciais <nick> <item> <quantidade>.");
				}
				}
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
			if(p.getItemInHand().isSimilar(ItensAPI.poder)) {
				e.setCancelled(true);
			    MPlayer mp = MPlayer.get(p);
			    Double maximo = mp.getPowerBoost()+10;
			    if(maximo >= Main.config.getInt("poder")) {
			    	p.sendMessage("§cVocê já possuí o máximo de poder.");
			    	return;
			    }
			    Mine.remove(p.getInventory(), p.getItemInHand(), 1);
			    mp.setPowerBoost(mp.getPowerBoost()+1.0D);
			    p.sendMessage("§aPoder máximo aumentado em +1.");
			    Mine.newFirework(p.getLocation(), 0, Color.YELLOW, Color.RED, true, true);
			}
			if(p.getItemInHand().isSimilar(ItensAPI.instantaneo)) {
				e.setCancelled(true);
				MPlayer mp = MPlayer.get(p);
				int atual = mp.getPowerRounded();
				if(atual >= mp.getPowerMax()) {
					p.sendMessage("§cVocê já está com o máximo de poder.");
					return;
				}
				Mine.remove(p.getInventory(), p.getItemInHand(), 1);
			if(!Mine.getChance(Main.config.getDouble("instantaneo.chance")/100)) {
				mp.setPower(atual+1.0D);
				p.sendMessage("§aPoder atual aumentado em +1.");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
			}else {
				p.sendMessage("§cA ativação do poder falhou :(.");
				p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1F, 1F);
			}
			}
			if(p.getItemInHand().isSimilar(ItensAPI.kdr)) {
				e.setCancelled(true);
				MPlayer mp = MPlayer.get(p);
				if(mp.getKills() <= 0 && mp.getDeaths() <= 0) {
					p.sendMessage("§cSeu KDR já está zerado.");
					return;
				}
				Mine.remove(p.getInventory(), p.getItemInHand(), 1);
				mp.setKills(0);
				mp.setDeaths(0);
				p.sendMessage("§aSeu KDR foi resetado.");
			}
			if(p.getItemInHand().isSimilar(ItensAPI.raio())) {
				e.setCancelled(true);
				if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					Mine.remove(p.getInventory(), p.getItemInHand(), 1);
					p.getWorld().strikeLightning(e.getClickedBlock().getLocation());
				}
			}
		}
	}
	
}
