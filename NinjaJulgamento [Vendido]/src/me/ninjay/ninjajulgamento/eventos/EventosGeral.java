package me.ninjay.ninjajulgamento.eventos;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.ninjay.ninjajulgamento.main.Main;



public class EventosGeral implements Listener{
	
	@EventHandler
	public void aoHitar(EntityDamageByEntityEvent e) {
		Player p = (Player) e.getDamager();
		LivingEntity c = (LivingEntity) e.getEntity();
		if(e.getEntity().getType() == EntityType.CREEPER) {
			if(e.getDamager() instanceof Player) {
			    if(p.getItemInHand().getEnchantmentLevel(Enchantment.DAMAGE_UNDEAD) == 1) {
			    	if(c.getHealth() >= Main.config.getInt("1")) {
			    	c.setHealth(c.getHealth()-Main.config.getInt("1"));
			    	}else {
			    		c.setHealth(0);
			    	}
			    }
			    if(p.getItemInHand().getEnchantmentLevel(Enchantment.DAMAGE_UNDEAD) == 2) {
			    	if(c.getHealth() >= Main.config.getInt("2")) {
			    	c.setHealth(c.getHealth()-Main.config.getInt("2"));
			    	}else {
			    		c.setHealth(0);
			    	}
			    }
			    if(p.getItemInHand().getEnchantmentLevel(Enchantment.DAMAGE_UNDEAD) == 3) {
			    	if(c.getHealth() >= Main.config.getInt("3")) {
			    	c.setHealth(c.getHealth()-Main.config.getInt("3"));
			    	}else {
			    		c.setHealth(0);
			    	}
			    }
			    if(p.getItemInHand().getEnchantmentLevel(Enchantment.DAMAGE_UNDEAD) == 4) {
			    	if(c.getHealth() >= Main.config.getInt("4")) {
			    	c.setHealth(c.getHealth()-Main.config.getInt("4"));
			    	}else {
			    		c.setHealth(0);
			    	}
			    }
			    if(p.getItemInHand().getEnchantmentLevel(Enchantment.DAMAGE_UNDEAD) == 5) {
			    	if(c.getHealth() >= Main.config.getInt("5")) {
			    	c.setHealth(c.getHealth()-Main.config.getInt("5"));
			    	}else {
			    		c.setHealth(0);
			    	}
			    }
			    
			}
		}
	}

}
