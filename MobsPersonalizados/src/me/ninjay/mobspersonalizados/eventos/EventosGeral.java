package me.ninjay.mobspersonalizados.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.ninjay.mobspersonalizados.utils.Mine;
import me.ninjay.mobspersonalizados.utils.ParticleType;

public class EventosGeral implements Listener{
	
	public static ItemStack ovo () {
		ItemStack ovoo = Mine.newItem(Material.EGG, "§6Ovo de Ouro");
		ItemMeta meta = ovoo.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ovoo.setItemMeta(meta);
		return ovoo;
	}
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		
		if(e.getDamager().getType() == EntityType.PLAYER) {
			Player p = (Player) e.getDamager();
			if(e.getEntity().getType() == EntityType.PIG) {
				e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.BLOCK_BASALT_BREAK, 1F, 1F);
			}
			if(e.getEntity().getType() == EntityType.SHEEP) {
				e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.BLOCK_BASALT_BREAK, 1F, 1F);
			}
			if(e.getEntity().getType() == EntityType.COW) {
				e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.BLOCK_BASALT_BREAK, 1F, 1F);
			}
			if(e.getEntity().getType() == EntityType.CHICKEN) {
				e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.BLOCK_BASALT_BREAK, 1F, 1F);
			}
		}
	}

	@EventHandler
	public void aoMatar(EntityDeathEvent e) {
		
		if(e.getEntity().getType() == EntityType.PIG) {
			e.getDrops().clear();
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.DIAMOND, 64));
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.DIAMOND, 64));
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.DIAMOND, 64));
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.DIAMOND, 64));
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.DIAMOND, 64));
		}
		
		if(e.getEntity().getType() == EntityType.SHEEP) {
			e.getDrops().clear();
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.NETHERITE_INGOT, Mine.randomInt(28, 32)));
		}
		
		if(e.getEntity().getType() == EntityType.COW) {
			e.getDrops().clear();
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.EMERALD, 64));
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.EMERALD, 64));
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.EMERALD, 64));
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.EMERALD, 64));
		}
		
		if(e.getEntity().getType() == EntityType.CHICKEN) {
			e.getDrops().clear();
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.GOLD_INGOT, 64));
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.GOLD_INGOT, 64));
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.GOLD_INGOT, 64));
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.GOLD_INGOT, 64));
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.GOLD_INGOT, 64));
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.GOLD_INGOT, 64));
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.GOLD_INGOT, 64));
		}
	}

	@EventHandler
	public void aoDropar(EntityDropItemEvent e) {
		if(e.getEntity().getType() == EntityType.SHEEP) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void aoTirarLa(PlayerShearEntityEvent e) {
		
		if(e.getEntity().getType() == EntityType.SHEEP) {
			Location loc = new Location(e.getEntity().getWorld(), e.getEntity().getLocation().getX(), e.getEntity().getLocation().getY()+1, e.getEntity().getLocation().getZ());
			e.getEntity().getWorld().dropItem(loc, new ItemStack(Material.NETHERITE_INGOT, Mine.getRandomInt(1, 3)));
		}
	}
	
	@EventHandler
	public void aoJogar(PlayerEggThrowEvent e) {
		Player p = e.getPlayer();

        //e.getEgg().getWorld().spawnParticle(Particle.FIREWORKS_SPARK, e.getEgg().getLocation(), 1, 0.01, 0.01, 0.01);
	    Particle.DustOptions dust = new Particle.DustOptions(Color.fromRGB(255, 255, 0), 2);
	    
	    for(int x = 0; x < 3; x++) {
	    	for(int z = 0; z < 3; z++) {
	    		Location loc1 = new Location(e.getEgg().getWorld(), e.getEgg().getLocation().getX()+x, e.getEgg().getLocation().getY(), e.getEgg().getLocation().getZ()+z);
	    		Location loc2 = new Location(e.getEgg().getWorld(), e.getEgg().getLocation().getX()-x, e.getEgg().getLocation().getY(), e.getEgg().getLocation().getZ()-z);
	    		Location loc3 = new Location(e.getEgg().getWorld(), e.getEgg().getLocation().getX()+x, e.getEgg().getLocation().getY(), e.getEgg().getLocation().getZ()-z);
	    		Location loc4 = new Location(e.getEgg().getWorld(), e.getEgg().getLocation().getX()-x, e.getEgg().getLocation().getY(), e.getEgg().getLocation().getZ()+z);
	    		e.getEgg().getWorld().spawnParticle(Particle.REDSTONE, loc1, 1, 0.1, 0.1, 0.1, dust);
	    		e.getEgg().getWorld().spawnParticle(Particle.REDSTONE, loc2, 1, 0.1, 0.1, 0.1, dust);
	    		e.getEgg().getWorld().spawnParticle(Particle.REDSTONE, loc3, 1, 0.1, 0.1, 0.1, dust);
	    		e.getEgg().getWorld().spawnParticle(Particle.REDSTONE, loc4, 1, 0.1, 0.1, 0.1, dust);
	    	}
	    }
	    e.getEgg().getWorld().spawn(e.getEgg().getLocation(), Chicken.class);
	    
	   
	}	
	
}
