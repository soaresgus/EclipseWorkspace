package me.ninjay.dropsmob.estruturas;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;


public class DropsControler implements Listener{
	
	@EventHandler
	public static void aoMatar(EntityDeathEvent e) {
		Entity morto = e.getEntity();
		Player p = e.getEntity().getKiller();
		Drops mob = DropsAPI.manager.getMobPorEntity(e.getEntity().getType());
		if(DropsAPI.manager.getDrops().contains(mob)) {
			if(p instanceof Player) {
				if(!p.getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)) {
			ItemStack item = mob.getDrop();
			item.setAmount(mob.getNormal());
			p.getWorld().dropItem(morto.getLocation(), item);
			e.getDrops().clear();
			}
				if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) == 1) {
					ItemStack item = mob.getDrop();
					item.setAmount(mob.getLot1());
					p.getWorld().dropItem(morto.getLocation(), item);
					e.getDrops().clear();
					}
				if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) == 2) {
					ItemStack item = mob.getDrop();
					item.setAmount(mob.getLot2());
					p.getWorld().dropItem(morto.getLocation(), item);
					e.getDrops().clear();
					}
				if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) == 3) {
					ItemStack item = mob.getDrop();
					item.setAmount(mob.getLot3());
					p.getWorld().dropItem(morto.getLocation(), item);
					e.getDrops().clear();
					}
				if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) == 4) {
					ItemStack item = mob.getDrop();
					item.setAmount(mob.getLot4());
					p.getWorld().dropItem(morto.getLocation(), item);
					e.getDrops().clear();
					}
				if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) == 5) {
					ItemStack item = mob.getDrop();
					item.setAmount(mob.getLot5());
					p.getWorld().dropItem(morto.getLocation(), item);
					e.getDrops().clear();
					}
				if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) == 6) {
					ItemStack item = mob.getDrop();
					item.setAmount(mob.getLot6());
					p.getWorld().dropItem(morto.getLocation(), item);
					e.getDrops().clear();
					}
				if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) == 7) {
					ItemStack item = mob.getDrop();
					item.setAmount(mob.getLot7());
					p.getWorld().dropItem(morto.getLocation(), item);
					e.getDrops().clear();
					}
				if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) == 8) {
					ItemStack item = mob.getDrop();
					item.setAmount(mob.getLot8());
					p.getWorld().dropItem(morto.getLocation(), item);
					e.getDrops().clear();
					}
				if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) == 9) {
					ItemStack item = mob.getDrop();
					item.setAmount(mob.getLot9());
					p.getWorld().dropItem(morto.getLocation(), item);
					e.getDrops().clear();
					}
				if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) == 10) {
					ItemStack item = mob.getDrop();
					item.setAmount(mob.getLot10());
					p.getWorld().dropItem(morto.getLocation(), item);
					e.getDrops().clear();
					}
				
		}
		}else {
			if(p instanceof Player) {
				return;
		}
		}
		
	}

}
