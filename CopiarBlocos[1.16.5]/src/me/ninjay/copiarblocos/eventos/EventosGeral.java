package me.ninjay.copiarblocos.eventos;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.Container;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.copiarblocos.main.Main;

public class EventosGeral implements Listener{
	
	public static HashMap<Player, Block> bloco = new HashMap<>();
	public static HashMap<Player, ItemStack[]> itens = new HashMap<>();
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§d§lCopiadora")) {
						if(e.getAction() == Action.LEFT_CLICK_BLOCK) {
							if(e.getClickedBlock().getType() != Material.CHEST) {
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							p.sendMessage("§aBloco copiado com sucesso, use o botão direito para colar.");
							bloco.remove(p);
							bloco.put(p, e.getClickedBlock());
							}else {
								Container bau = (Chest) e.getClickedBlock().getState();
								ItemStack[] toAdd = bau.getInventory().getContents();
								
								itens.remove(p);
								itens.put(p, toAdd);
								p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
								p.sendMessage("§aBloco copiado com sucesso, use o botão direito para colar.");
								bloco.remove(p);
								bloco.put(p, e.getClickedBlock());
							}
						}
						if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
							new BukkitRunnable() {
								
								@Override
								public void run() {
									
							if(bloco.get(p) != null) {
								if(e.getHand() == EquipmentSlot.HAND) {
								Block loc = e.getClickedBlock();
								Block loca = p.getWorld().getBlockAt(loc.getLocation().add(0, 1, 0));
									if(bloco.get(p).getType() != Material.CHEST) {
								p.sendMessage("§aBloco colado com sucesso, qual será o próximo alvo?");
								loca.setBlockData(bloco.get(p).getBlockData());
								loca.setType(bloco.get(p).getType());
								return;
									}else {
										p.sendMessage("§aBloco colado com sucesso, qual será o próximo alvo?");
										p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
										loca.setBlockData(bloco.get(p).getBlockData());
										loca.setType(bloco.get(p).getType());
										((Chest) loca.getState()).getInventory().setContents(itens.get(p));
									}
								}
							}
						}
					}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(e.getAction() == Action.RIGHT_CLICK_AIR) {
							new BukkitRunnable() {
								
								@Override
								public void run() {
									
							if(bloco.get(p) != null) {
							Block loc = p.getTargetBlock(null, 10);
							if(bloco.get(p).getType() != Material.CHEST) {
							p.sendMessage("§aBloco colado com sucesso, qual será o próximo alvo?");
							loc.setBlockData(bloco.get(p).getBlockData());
							loc.setType(bloco.get(p).getType());
							return;
								}else {
									p.sendMessage("§aBloco colado com sucesso, qual será o próximo alvo?");
									loc.setBlockData(bloco.get(p).getBlockData());
									loc.setType(bloco.get(p).getType());
									((Chest) loc.getState()).getInventory().setContents(itens.get(p));
								}
							}
						}
					}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
					}
				}
			}
		}
	}

}
