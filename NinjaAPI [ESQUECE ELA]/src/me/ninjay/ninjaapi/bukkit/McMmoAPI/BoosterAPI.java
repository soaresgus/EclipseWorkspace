package me.ninjay.ninjaapi.bukkit.McMmoAPI;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.nossr50.datatypes.skills.SkillType;
import com.gmail.nossr50.events.experience.McMMOPlayerXpGainEvent;

import me.ninjay.ninjaapi.main.Main;
import me.ninjay.ninjaapi.utils.BukkitConfig;
import me.ninjay.ninjaapi.utils.Mine;

public class BoosterAPI implements Listener{
	
	public static BukkitConfig config = new BukkitConfig("booster.yml", Main.getPlugin(Main.class));
	public static ItemStack item = Mine.newItem(Material.EXP_BOTTLE, "§eBooster de Experiência", 1, 0, " "," §7* Te concede 2x de xp nas habilidades");
	
	public static void giveBooster(Player p) {
		p.getInventory().addItem(item);
	}
	
	
	@EventHandler
	public static void aoGanharXp(McMMOPlayerXpGainEvent e) {
		
	}
	
	@EventHandler
	public static void aoInteragir(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.getItemInHand().isSimilar(item)) {
			e.setCancelled(true);
		}
	}

}
