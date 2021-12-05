package me.ninjay.soulthbloco.bloco;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.ninjay.ninjaapi.utils.Mine;
import net.eduard.api.lib.modules.VaultAPI;

public class EventosBreakMoney implements Listener {

	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Material b = e.getBlock().getType();
		
		if(p.hasPermission("cold3.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 0.50);
			Mine.sendActionBar(p, "§e§l+0.50 Coins");
			return;
		}
		if(p.hasPermission("cold3.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 2.00);
			Mine.sendActionBar(p, "§e§l+2.00 Coins");
			return;
		}
		if(p.hasPermission("cold3.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 1.50);
			Mine.sendActionBar(p, "§e§l+1.50 Coins");
			return;
		}
		if(p.hasPermission("cold3.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 5.00);
			Mine.sendActionBar(p, "§e§l+5.00 Coins");
			return;
		}
		if(p.hasPermission("cold2.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 1.00);
			Mine.sendActionBar(p, "§e§l+1.00 Coins");
			return;
		}
		if(p.hasPermission("cold2.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 2.50);
			Mine.sendActionBar(p, "§e§l+2.50 Coins");
			return;
		}
		if(p.hasPermission("cold2.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 2.00);
			Mine.sendActionBar(p, "§e§l+2.00 Coins");
			return;
		}
		if(p.hasPermission("cold2.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 5.50);
			Mine.sendActionBar(p, "§e§l+5.50 Coins");
			return;
		}
		if(p.hasPermission("cold1.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 1.50);
			Mine.sendActionBar(p, "§e§l+1.50 Coins");
			return;
		}
		if(p.hasPermission("cold1.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 3.00);
			Mine.sendActionBar(p, "§e§l+3.00 Coins");
			return;
		}
		if(p.hasPermission("cold1.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 2.50);
			Mine.sendActionBar(p, "§e§l+2.50 Coins");
			return;
		}
		if(p.hasPermission("cold1.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 6.00);
			Mine.sendActionBar(p, "§e§l+6.00 Coins");
			return;
		}
		if(p.hasPermission("dark3.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 2.00);
			Mine.sendActionBar(p, "§e§l+2.00 Coins");
			return;
		}
		if(p.hasPermission("dark3.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 3.50);
			Mine.sendActionBar(p, "§e§l+3.50 Coins");
			return;
		}
		if(p.hasPermission("dark3.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 3.00);
			Mine.sendActionBar(p, "§e§l+3.00 Coins");
			return;
		}
		if(p.hasPermission("dark3.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 6.50);
			Mine.sendActionBar(p, "§e§l+6.50 Coins");
			return;
		}
		if(p.hasPermission("dark2.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 2.50);
			Mine.sendActionBar(p, "§e§l+2.50 Coins");
			return;
		}
		if(p.hasPermission("dark2.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 4.00);
			Mine.sendActionBar(p, "§e§l+4.00 Coins");
			return;
		}
		if(p.hasPermission("dark2.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 3.50);
			Mine.sendActionBar(p, "§e§l+3.50 Coins");
			return;
		}
		if(p.hasPermission("dark2.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 7.00);
			Mine.sendActionBar(p, "§e§l+7.00 Coins");
			return;
		}
		if(p.hasPermission("dark1.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 3.00);
			Mine.sendActionBar(p, "§e§l+3.00 Coins");
			return;
		}
		if(p.hasPermission("dark1.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 4.50);
			Mine.sendActionBar(p, "§e§l+4.50 Coins");
			return;
		}
		if(p.hasPermission("dark1.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 4.00);
			Mine.sendActionBar(p, "§e§l+4.00 Coins");
			return;
		}
		if(p.hasPermission("dark1.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 7.50);
			Mine.sendActionBar(p, "§e§l+7.50 Coins");
			return;
		}
		if(p.hasPermission("flight3.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 3.50);
			Mine.sendActionBar(p, "§e§l+3.50 Coins");
			return;
		}
		if(p.hasPermission("flight3.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 5.00);
			Mine.sendActionBar(p, "§e§l+5.00 Coins");
			return;
		}
		if(p.hasPermission("flight3.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 4.50);
			Mine.sendActionBar(p, "§e§l+4.50 Coins");
			return;
		}
		if(p.hasPermission("flight3.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 8.00);
			Mine.sendActionBar(p, "§e§l+8.00 Coins");
			return;
		}
		if(p.hasPermission("flight2.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 4.00);
			Mine.sendActionBar(p, "§e§l+4.00 Coins");
			return;
		}
		if(p.hasPermission("flight2.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 5.50);
			Mine.sendActionBar(p, "§e§l+5.50 Coins");
			return;
		}
		if(p.hasPermission("flight2.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 5.00);
			Mine.sendActionBar(p, "§e§l+5.00 Coins");
			return;
		}
		if(p.hasPermission("flight2.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 8.50);
			Mine.sendActionBar(p, "§e§l+8.50 Coins");
			return;
		}
		if(p.hasPermission("flight1.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 4.50);
			Mine.sendActionBar(p, "§e§l+4.50 Coins");
			return;
		}
		if(p.hasPermission("flight1.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 6.00);
			Mine.sendActionBar(p, "§e§l+6.00 Coins");
			return;
		}
		if(p.hasPermission("flight1.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 5.50);
			Mine.sendActionBar(p, "§e§l+5.50 Coins");
			return;
		}
		if(p.hasPermission("flight1.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 9.00);
			Mine.sendActionBar(p, "§e§l+9.00 Coins");
			return;
		}
		if(p.hasPermission("souls3.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 5.00);
			Mine.sendActionBar(p, "§e§l+5.00 Coins");
			return;
		}
		if(p.hasPermission("souls3.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 6.50);
			Mine.sendActionBar(p, "§e§l+6.50 Coins");
			return;
		}
		if(p.hasPermission("souls3.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 6.00);
			Mine.sendActionBar(p, "§e§l+6.00 Coins");
			return;
		}
		if(p.hasPermission("souls3.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 9.50);
			Mine.sendActionBar(p, "§e§l+9.50 Coins");
			return;
		}
		if(p.hasPermission("souls2.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 5.50);
			Mine.sendActionBar(p, "§e§l+5.50 Coins");
			return;
		}
		if(p.hasPermission("souls2.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 7.00);
			Mine.sendActionBar(p, "§e§l+7.00 Coins");
			return;
		}
		if(p.hasPermission("souls2.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 6.50);
			Mine.sendActionBar(p, "§e§l+6.50 Coins");
			return;
		}
		if(p.hasPermission("souls2.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 10.00);
			Mine.sendActionBar(p, "§e§l+10.00 Coins");
			return;
		}
		if(p.hasPermission("souls1.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 6.00);
			Mine.sendActionBar(p, "§e§l+6.00 Coins");
			return;
		}
		if(p.hasPermission("souls1.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 7.50);
			Mine.sendActionBar(p, "§e§l+7.50 Coins");
			return;
		}
		if(p.hasPermission("souls1.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 7.00);
			Mine.sendActionBar(p, "§e§l+7.00 Coins");
			return;
		}
		if(p.hasPermission("souls1.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 10.50);
			Mine.sendActionBar(p, "§e§l+10.50 Coins");
			return;
		}
		if(p.hasPermission("killer3.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 6.50);
			Mine.sendActionBar(p, "§e§l+6.50 Coins");
			return;
		}
		if(p.hasPermission("killer3.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 8.00);
			Mine.sendActionBar(p, "§e§l+8.00 Coins");
			return;
		}
		if(p.hasPermission("killer3.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 7.50);
			Mine.sendActionBar(p, "§e§l+7.50 Coins");
			return;
		}
		if(p.hasPermission("killer3.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 11.00);
			Mine.sendActionBar(p, "§e§l+11.00 Coins");
			return;
		}
		if(p.hasPermission("killer2.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 7.00);
			Mine.sendActionBar(p, "§e§l+7.00 Coins");
			return;
		}
		if(p.hasPermission("killer2.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 8.50);
			Mine.sendActionBar(p, "§e§l+8.50 Coins");
			return;
		}
		if(p.hasPermission("killer2.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 8.00);
			Mine.sendActionBar(p, "§e§l+8.00 Coins");
			return;
		}
		if(p.hasPermission("killer2.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 11.50);
			Mine.sendActionBar(p, "§e§l+11.50 Coins");
			return;
		}
		if(p.hasPermission("killer1.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 7.50);
			Mine.sendActionBar(p, "§e§l+7.50 Coins");
			return;
		}
		if(p.hasPermission("killer1.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 9.00);
			Mine.sendActionBar(p, "§e§l+9.00 Coins");
			return;
		}
		if(p.hasPermission("killer1.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 8.50);
			Mine.sendActionBar(p, "§e§l+8.50 Coins");
			return;
		}
		if(p.hasPermission("killer1.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 12.00);
			Mine.sendActionBar(p, "§e§l+12.00 Coins");
			return;
		}
		if(p.hasPermission("demo3.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 8.00);
			Mine.sendActionBar(p, "§e§l+8.00 Coins");
			return;
		}
		if(p.hasPermission("demo3.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 9.50);
			Mine.sendActionBar(p, "§e§l+9.50 Coins");
			return;
		}
		if(p.hasPermission("demo3.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 9.00);
			Mine.sendActionBar(p, "§e§l+9.00 Coins");
			return;
		}
		if(p.hasPermission("demo3.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 12.50);
			Mine.sendActionBar(p, "§e§l+12.50 Coins");
			return;
		}
		if(p.hasPermission("demo2.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 8.50);
			Mine.sendActionBar(p, "§e§l+8.50 Coins");
			return;
		}
		if(p.hasPermission("demo2.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 10.00);
			Mine.sendActionBar(p, "§e§l+10.00 Coins");
			return;
		}
		if(p.hasPermission("demo2.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 9.50);
			Mine.sendActionBar(p, "§e§l+9.50 Coins");
			return;
		}
		if(p.hasPermission("demo2.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 13.00);
			Mine.sendActionBar(p, "§e§l+13.00 Coins");
			return;
		}
		if(p.hasPermission("demo1.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 9.00);
			Mine.sendActionBar(p, "§e§l+9.00 Coins");
			return;
		}
		if(p.hasPermission("demo1.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 10.50);
			Mine.sendActionBar(p, "§e§l+10.50 Coins");
			return;
		}
		if(p.hasPermission("demo1.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 10.00);
			Mine.sendActionBar(p, "§e§l+10.00 Coins");
			return;
		}
		if(p.hasPermission("demo1.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 13.50);
			Mine.sendActionBar(p, "§e§l+13.50 Coins");
			return;
		}
		if(p.hasPermission("dingy3.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 9.50);
			Mine.sendActionBar(p, "§e§l+9.50 Coins");
			return;
		}
		if(p.hasPermission("dingy3.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 11.00);
			Mine.sendActionBar(p, "§e§l+11.00 Coins");
			return;
		}
		if(p.hasPermission("dingy3.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 10.50);
			Mine.sendActionBar(p, "§e§l+10.50 Coins");
			return;
		}
		if(p.hasPermission("dingy3.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 14.00);
			Mine.sendActionBar(p, "§e§l+14.00 Coins");
			return;
		}
		if(p.hasPermission("dingy2.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 10.00);
			Mine.sendActionBar(p, "§e§l+10.00 Coins");
			return;
		}
		if(p.hasPermission("dingy2.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 11.50);
			Mine.sendActionBar(p, "§e§l+11.50 Coins");
			return;
		}
		if(p.hasPermission("dingy2.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 11.00);
			Mine.sendActionBar(p, "§e§l+11.00 Coins");
			return;
		}
		if(p.hasPermission("dingy2.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 14.50);
			Mine.sendActionBar(p, "§e§l+14.50 Coins");
			return;
		}
		if(p.hasPermission("dingy1.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 10.50);
			Mine.sendActionBar(p, "§e§l+10.50 Coins");
			return;
		}
		if(p.hasPermission("dingy1.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 12.00);
			Mine.sendActionBar(p, "§e§l+12.00 Coins");
			return;
		}
		if(p.hasPermission("dingy1.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 11.50);
			Mine.sendActionBar(p, "§e§l+11.50 Coins");
			return;
		}
		if(p.hasPermission("dingy1.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 15.00);
			Mine.sendActionBar(p, "§e§l+15.00 Coins");
			return;
		}
		if(p.hasPermission("omega3.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 11.00);
			Mine.sendActionBar(p, "§e§l+11.00 Coins");
			return;
		}
		if(p.hasPermission("omega3.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 12.50);
			Mine.sendActionBar(p, "§e§l+12.50 Coins");
			return;
		}
		if(p.hasPermission("omega3.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 12.00);
			Mine.sendActionBar(p, "§e§l+12.00 Coins");
			return;
		}
		if(p.hasPermission("omega3.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 15.50);
			Mine.sendActionBar(p, "§e§l+15.50 Coins");
			return;
		}
		if(p.hasPermission("omega2.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 11.50);
			Mine.sendActionBar(p, "§e§l+11.50 Coins");
			return;
		}
		if(p.hasPermission("omega2.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 13.00);
			Mine.sendActionBar(p, "§e§l+13.00 Coins");
			return;
		}
		if(p.hasPermission("omega2.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 12.50);
			Mine.sendActionBar(p, "§e§l+12.50 Coins");
			return;
		}
		if(p.hasPermission("omega2.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 16.00);
			Mine.sendActionBar(p, "§e§l+16.00 Coins");
			return;
		}
		if(p.hasPermission("omega1.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 12.00);
			Mine.sendActionBar(p, "§e§l+12.00 Coins");
			return;
		}
		if(p.hasPermission("omega1.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 13.50);
			Mine.sendActionBar(p, "§e§l+13.50 Coins");
			return;
		}
		if(p.hasPermission("omega1.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 13.00);
			Mine.sendActionBar(p, "§e§l+ Coins");
			return;
		}
		if(p.hasPermission("omega1.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 16.50);
			return;
		}
		
		
	
		
		
	}

	// Cold/Dark/Flight/Souls/Killer/Demo/Dingy/Ômega - ranks

	// III 12.5k - cold3.rank
	// II 21.87k - cold2.rank
	// I 38.28k - cold1.rank
	// Outro rank

	// 3 66.99k - dark3.rank
	// 2 117.20k - dark2.rank
	// 1 205.10k - dark1.rank
	// Outro rank

	// 3 359k - flight3.rank
	// 2 628.20k - flight2.rank
	// 1 1.099M - flight1.rank
	// Outro rank

	// 3 1.924M - souls3.rank
	// 2 3.367M - souls2.rank
	// 1 5.892M - souls1.rank
	// Outro rank

	// 3 10.310M - killer3.rank
	// 2 18.040M - killer2.rank
	// 1 31.570M - killer1.rank
	// Outro rank

	// 3 46.890M - demo3.rank
	// 2 70.384M - demo2.rank
	// 1 129.289M - demo1.rank
	// Outro rank

	// 3 194.284M - dingy3.rank
	// 2 285.393M - dingy2.rank
	// 1 495.948M - dingy1.rank
	// Outro rank

	// 3 658.958M - ômega3.rank
	// 2 893.838M - ômega2.rank
	// 1 1.383B - ômega1.rank
	// Outro rank
}
