package me.ninjay.safedrops.estruturas;

import java.util.EnumMap;
import java.util.Map;

import org.apache.commons.lang.mutable.MutableInt;
import org.bukkit.Chunk;
import org.bukkit.craftbukkit.v1_8_R3.CraftChunk;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import me.ninjay.safedrops.utils.Mine;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.TileEntity;
import net.minecraft.server.v1_8_R3.TileEntityMobSpawner;

public class DropsControler implements Listener{
	
	@SuppressWarnings("deprecation")
	public Map<EntityType, MutableInt> getSpawners(final Chunk chunk) {
	    final Map<EntityType, MutableInt> spawners = new EnumMap<>(EntityType.class);

	    TileEntity entity;

	    EntityType type;
	    MutableInt amount;

	    for (final Map.Entry<BlockPosition, TileEntity> entry : ((CraftChunk) chunk).getHandle().tileEntities.entrySet()) {
	        if ((entity = entry.getValue()) instanceof TileEntityMobSpawner) {
	            type = EntityType.fromName(((TileEntityMobSpawner) entity).getSpawner().getMobName());

	            if ((amount = spawners.get(type)) == null) {
	                spawners.put(type, new MutableInt(1));
	            } else {
	                amount.increment();
	            }
	        }
	    }
	    return spawners;
	}
	
	@EventHandler
	public void aoMatar(EntityDeathEvent e) {
		Player p = e.getEntity().getKiller();
		Entity morto = e.getEntity();
		
		Drops mob = DropsAPI.manager.getMobPorTipo(morto.getType());
		
	if(p instanceof Player) {
		if(!(morto instanceof Player)) {
		if(DropsAPI.manager.getDrops().contains(mob)) {
			if(!(p.getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS))) {
				final Map<EntityType, MutableInt> spawners = this.getSpawners(((Player) p).getLocation().getChunk());
				 for (final Map.Entry<EntityType, MutableInt> entry : spawners.entrySet()) {
								 for(ItemStack itens : mob.getDrops()) {
									 Integer item = itens.getAmount();
									 Integer spawnersq = Mine.toInt(entry.getValue().getValue());
									 Integer dropbonus = mob.getDropbonus();
									 
									 itens.setAmount(mob.getAmount());
									 itens.setAmount((item)+(spawnersq*dropbonus));
									 morto.getWorld().dropItem(morto.getLocation(), itens);
									 itens.setAmount(mob.getAmount());
								 }
								 if(Mine.getChance(mob.getChanceItemBonus())) {
									 morto.getWorld().dropItem(morto.getLocation(), mob.getItembonus());
								 }
				 }
				 e.getDrops().clear();
			}
			}
		}
	}
	}

}