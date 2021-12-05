package me.ninjay.gravetoscustom.eventos;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.StructureType;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.gravetoscustom.estruturas.ItensAPI;
import me.ninjay.gravetoscustom.main.Main;
import me.ninjay.gravetoscustom.utils.Mine;

public class EventosGeral implements Listener{
	
	private static ArrayList<Player> dano = new ArrayList<>();
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.ferro())) {
			e.setDropItems(false);
			p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.IRON_INGOT, Mine.getRandomInt(1, 5)));
		}
		
		if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.ouro())) {
			e.setDropItems(false);
			p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.GOLD_INGOT, Mine.getRandomInt(1, 5)));
		}
		
		if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.dima())) {
			e.setDropItems(false);
			p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.DIAMOND, 1));
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
	if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.explo())) {
		if(e.getAction() == Action.LEFT_CLICK_BLOCK) {
			p.getWorld().createExplosion(e.getClickedBlock().getLocation(), 10F);
			dano.add(p);
			new BukkitRunnable() {
				
				@Override
				public void run() {
					dano.remove(p);
				}
			}.runTaskLater(Main.getPlugin(Main.class), 2*20);
		}
	}
	
	if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.ender())) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			p.playSound(p.getLocation(), Sound.ENTITY_ENDER_PEARL_THROW, 1F, 1F);
			p.launchProjectile(EnderPearl.class);
		}
	}
	
	if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.fogo())) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			p.playSound(p.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1F, 1F);
			p.launchProjectile(Fireball.class);
		}
	}
	
	if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.bau())) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F, 1F);
			p.openInventory(p.getEnderChest());
			
		}
	}
	
	if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.strong())) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 1F, 1F);
			Location loc = p.getWorld().locateNearestStructure(p.getLocation(), StructureType.STRONGHOLD, 500000, true);
			p.sendMessage(" \n§a  O portal do fim foi localizado!\n \n§e    X: "+loc.getBlockX()+"\n    Z: "+loc.getBlockZ()+"\n ");
		}
	}
	
	}
	
	@EventHandler
	public void onDano(EntityDamageEvent e) {
		
		if(e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			
			if(dano != null && dano.contains(p)) {
				if(e.getCause() == DamageCause.ENTITY_EXPLOSION || e.getCause() == DamageCause.BLOCK_EXPLOSION) {
					e.setCancelled(true);
				}
			}
		}
	}

}
