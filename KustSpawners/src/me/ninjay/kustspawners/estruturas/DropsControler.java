package me.ninjay.kustspawners.estruturas;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import me.ninjay.kustspawners.main.Main;
import me.ninjay.kustspawners.utils.Mine;

public class DropsControler implements Listener{
	
	@EventHandler
	public void aoMatar(EntityDeathEvent e) {
		Player p = e.getEntity().getKiller();
		Entity m = e.getEntity();

		Drops drop = DropsAPI.manager.getEntity(e.getEntityType());
		
		if(m.getType() != EntityType.PLAYER) {
			if(drop != null) {
				e.getDrops().clear();
				String name = e.getEntity().getCustomName().replace("&e", "").replace("x "+drop.getName(), "").replace("§e", "");
				Integer quantos = Mine.toInt(name);
				ItemStack drop1 = new ItemStack(drop.getDrop1());
				ItemStack drop2 = new ItemStack(drop.getDrop2());

				if (p.isSneaking() == false) {
					if (!p.getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)) {
						if(Mine.getChance(drop.getChance1())) {
							drop1.setAmount(drop.getLot0Drop1() * quantos);
							if(drop.getDrop1() != Material.AIR) {
							m.getWorld().dropItem(m.getLocation(), drop1);
							}
						}
						if(Mine.getChance(drop.getChance2())) {
							drop2.setAmount(drop.getLot0Drop2() * quantos);
							if(drop.getDrop2() != Material.AIR) {
							m.getWorld().dropItem(m.getLocation(), drop2);
							}
						}
					}
					if (p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) == 1) {
						if(Mine.getChance(drop.getChance1())) {
							drop1.setAmount(drop.getLot1Drop1() * quantos);
							if(drop.getDrop1() != Material.AIR) {
								m.getWorld().dropItem(m.getLocation(), drop1);
								}
						}
						if(Mine.getChance(drop.getChance2())) {
							drop2.setAmount(drop.getLot1Drop2() * quantos);
							if(drop.getDrop2() != Material.AIR) {
								m.getWorld().dropItem(m.getLocation(), drop2);
								}
						}
					}
					if (p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) == 2) {
						if(Mine.getChance(drop.getChance1())) {
							drop1.setAmount(drop.getLot2Drop1() * quantos);
							if(drop.getDrop1() != Material.AIR) {
								m.getWorld().dropItem(m.getLocation(), drop1);
								}
						}
						if(Mine.getChance(drop.getChance2())) {
							drop2.setAmount(drop.getLot2Drop2() * quantos);
							if(drop.getDrop2() != Material.AIR) {
								m.getWorld().dropItem(m.getLocation(), drop2);
								}
						}
					}
					if (p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) == 3) {
						if(Mine.getChance(drop.getChance1())) {
							drop1.setAmount(drop.getLot3Drop1() * quantos);
							if(drop.getDrop1() != Material.AIR) {
								m.getWorld().dropItem(m.getLocation(), drop1);
								}
						}
						if(Mine.getChance(drop.getChance2())) {
							drop2.setAmount(drop.getLot3Drop2() * quantos);
							if(drop.getDrop2() != Material.AIR) {
								m.getWorld().dropItem(m.getLocation(), drop2);
								}
						}
					}

				} else {
					if (!p.getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)) {
						if(Mine.getChance(drop.getChance1())) {
							drop1.setAmount(drop.getLot0Drop1());
							if(drop.getDrop1() != Material.AIR) {
								m.getWorld().dropItem(m.getLocation(), drop1);
								}
						}
						if(Mine.getChance(drop.getChance2())) {
							drop2.setAmount(drop.getLot0Drop2());
							if(drop.getDrop2() != Material.AIR) {
								m.getWorld().dropItem(m.getLocation(), drop2);
								}
						}
					}
					if (p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) == 1) {
						if(Mine.getChance(drop.getChance1())) {
							drop1.setAmount(drop.getLot1Drop1());
							if(drop.getDrop1() != Material.AIR) {
								m.getWorld().dropItem(m.getLocation(), drop1);
								}
						}
						if(Mine.getChance(drop.getChance2())) {
							drop2.setAmount(drop.getLot1Drop2());
							if(drop.getDrop2() != Material.AIR) {
								m.getWorld().dropItem(m.getLocation(), drop2);
								}
						}
					}
					if (p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) == 2) {
						if(Mine.getChance(drop.getChance1())) {
							drop1.setAmount(drop.getLot2Drop1());
							if(drop.getDrop1() != Material.AIR) {
								m.getWorld().dropItem(m.getLocation(), drop1);
								}
						}
						if(Mine.getChance(drop.getChance2())) {
							drop2.setAmount(drop.getLot2Drop2());
							if(drop.getDrop2() != Material.AIR) {
								m.getWorld().dropItem(m.getLocation(), drop2);
								}
						}
					}
					if (p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) == 3) {
						if(Mine.getChance(drop.getChance1())) {
							drop1.setAmount(drop.getLot3Drop1());
							if(drop.getDrop1() != Material.AIR) {
								m.getWorld().dropItem(m.getLocation(), drop1);
								}
						}
						if(Mine.getChance(drop.getChance2())) {
							drop2.setAmount(drop.getLot3Drop2());
							if(drop.getDrop2() != Material.AIR) {
								m.getWorld().dropItem(m.getLocation(), drop2);
								}
						}
						
					}
				}
			}
		}
	}

}
