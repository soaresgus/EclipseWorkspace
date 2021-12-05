package me.ninjay.mobspersonalizados.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Pig;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.mobspersonalizados.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		new BukkitRunnable() {
			int i = 20;
			@Override
			public void run() {
				i--;
				if(i <= 0) {
					i=20;
					for(Pig porco : Bukkit.getWorld("world").getEntitiesByClass(Pig.class)) {
						porco.getWorld().dropItem(porco.getLocation(), new ItemStack(Material.DIAMOND, 1));
						porco.getWorld().playSound(porco.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					}
					for(Cow vaca : Bukkit.getWorld("world").getEntitiesByClass(Cow.class)) {
						vaca.getWorld().dropItem(vaca.getLocation(), new ItemStack(Material.EMERALD, 1));
						vaca.getWorld().playSound(vaca.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					}
					for(Chicken galinha : Bukkit.getWorld("world").getEntitiesByClass(Chicken.class)) {
						galinha.getWorld().dropItem(galinha.getLocation(), EventosGeral.ovo());
						galinha.getWorld().playSound(galinha.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
					}
				}
			}
		}.runTaskTimer(this, 20, 20);
	}

}
