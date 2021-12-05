package me.ninjay.tocarminerio.eventos;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.block.Container;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.ninjay.tocarminerio.comandos.ComandoTocar;

public class EventosGeral implements Listener{
	
	public static HashMap<Player, ItemStack[]> itens = new HashMap<>();
	
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
	if(ComandoTocar.save.get(p) != null) {
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getClickedBlock() != null) {
				if(e.getClickedBlock().getType() == Material.CHEST || e.getClickedBlock().getType() == Material.TRAPPED_CHEST) {
					Container bau = (Chest) e.getClickedBlock().getState();
					ItemStack[] toAdd = bau.getInventory().getContents();
					
					itens.remove(p);
					itens.put(p, toAdd);
					
					e.getClickedBlock().setBlockData(e.getClickedBlock().getBlockData());
					e.getClickedBlock().setType(Material.TRAPPED_CHEST);
					((Chest) e.getClickedBlock().getState()).getInventory().setContents(itens.get(p));
				}else {
					if(e.getClickedBlock().getType() == Material.COAL_ORE || e.getClickedBlock().getType() == Material.IRON_ORE || e.getClickedBlock().getType() == Material.GOLD_ORE || e.getClickedBlock().getType() == Material.DIAMOND_ORE || e.getClickedBlock().getType() == Material.REDSTONE_ORE || e.getClickedBlock().getType() == Material.LAPIS_ORE || e.getClickedBlock().getType() == Material.EMERALD_ORE) {
						if(ComandoTocar.save.get(p).equals(Material.IRON_ORE)) {
							e.getClickedBlock().setType(Material.PINK_CONCRETE);
						}
						if(ComandoTocar.save.get(p).equals(Material.GOLD_ORE)) {
							e.getClickedBlock().setType(Material.ORANGE_CONCRETE);
						}
						if(ComandoTocar.save.get(p).equals(Material.DIAMOND_ORE)) {
							e.getClickedBlock().setType(Material.YELLOW_CONCRETE);
						}
					}else if(!e.getClickedBlock().getType().toString().contains("CONCRETE")){
						if(ComandoTocar.save.get(p).equals(Material.IRON_ORE)) {
							e.getClickedBlock().setType(Material.IRON_BLOCK);
						}
						if(ComandoTocar.save.get(p).equals(Material.GOLD_ORE)) {
							e.getClickedBlock().setType(Material.GOLD_BLOCK);
						}
						if(ComandoTocar.save.get(p).equals(Material.DIAMOND_ORE)) {
							e.getClickedBlock().setType(Material.DIAMOND_BLOCK);
						}
					}
				}
			}
		}
	}
	}

	@EventHandler
	public void onMob(PlayerInteractAtEntityEvent e) {
		Player p = e.getPlayer();
		
		if(e.getRightClicked() != null) {
			if(ComandoTocar.save.get(p) != null) {
				if(ComandoTocar.save.get(p).equals(Material.IRON_ORE)) {
					e.getRightClicked().setCustomName("§8"+e.getRightClicked().getType().toString().toLowerCase()+"_ferro");
				}
				if(ComandoTocar.save.get(p).equals(Material.GOLD_ORE)) {
					e.getRightClicked().setCustomName("§8"+e.getRightClicked().getType().toString().toLowerCase()+"_ouro");
				}
				if(ComandoTocar.save.get(p).equals(Material.DIAMOND_ORE)) {
					e.getRightClicked().setCustomName("§8"+e.getRightClicked().getType().toString().toLowerCase()+"_dima");
				}
			}
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlock().getType() == Material.PINK_CONCRETE) {
			e.setDropItems(false);
			p.getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.IRON_INGOT));
		}
		
		if(e.getBlock().getType() == Material.ORANGE_CONCRETE) {
			e.setDropItems(false);
			p.getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.GOLD_INGOT));
		}
		
		if(e.getBlock().getType() == Material.YELLOW_CONCRETE) {
			e.setDropItems(false);
			p.getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.DIAMOND));
		}
	}
	
}
