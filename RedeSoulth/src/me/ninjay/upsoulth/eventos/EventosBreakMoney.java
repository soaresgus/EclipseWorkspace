package me.ninjay.upsoulth.eventos;


import org.bukkit.Material;
import org.bukkit.block.Block;
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
		Block be = e.getBlock();

		if (p.hasPermission("cold3.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 1000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a1k ");
			be.breakNaturally(null);
            
			return;
		}
		if (p.hasPermission("cold3.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 2000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a2k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("cold3.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 2000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a2k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("cold3.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 3000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a3k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("cold2.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 2000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a2k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("cold2.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 3000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a3k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("cold2.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 3000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a3k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("cold2.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 4000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a4k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("cold1.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 3000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a3k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("cold1.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 4000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a4k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("cold1.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 4000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a4k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("cold1.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 5000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a5k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dark3.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 4000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a4k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dark3.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 5000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a5k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dark3.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 5000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a5k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dark3.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 6000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a6k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dark2.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 5000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a5k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dark2.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 6000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a6k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dark2.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 6000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a6k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dark2.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 7000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a7k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dark1.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 6000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a6k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dark1.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 7000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a7k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dark1.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 7000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a7k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dark1.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 8000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a8k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("flight3.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 7000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a7k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("flight3.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 8000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a8k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("flight3.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 8000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a8k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("flight3.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 9000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a9k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("flight2.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 8000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a8k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("flight2.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 9000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a9k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("flight2.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 9000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a9k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("flight2.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 10000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a10k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("flight1.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 9000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a9k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("flight1.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 10000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a10k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("flight1.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 10000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a10k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("flight1.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 11000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a11k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("souls3.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 10000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a10k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("souls3.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 11000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a11k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("souls3.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 11000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a11k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("souls3.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 12000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a12k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("souls2.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 11000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a11k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("souls2.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 12000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a12k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("souls2.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 12000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a12k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("souls2.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 13000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a13k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("souls1.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 12000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a12k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("souls1.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 13000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a13k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("souls1.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 13000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a13k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("souls1.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 14000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a14k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("killer3.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 13000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a13k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("killer3.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 14000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a14k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("killer3.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 14000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a14k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("killer3.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 15000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a15k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("killer2.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 14000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a14k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("killer2.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 15000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a15k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("killer2.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 15000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a15k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("killer2.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 16000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a16k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("killer1.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 15000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a15k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("killer1.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 16000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a16k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("killer1.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 16000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a16k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("killer1.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 17000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a17k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("demo3.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 16000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a16k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("demo3.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 17000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a17k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("demo3.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 17000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a17k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("demo3.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 18000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a18k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("demo2.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 17000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a17k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("demo2.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 18000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a18k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("demo2.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 18000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a18k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("demo2.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 19000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a19k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("demo1.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 18000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a18k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("demo1.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 19000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a19k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("demo1.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 19000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a19k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("demo1.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 20000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a20k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dingy3.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 19000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a19k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dingy3.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 20000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a20k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dingy3.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 20000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a20k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dingy3.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 21000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a21k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dingy2.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 20000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a20k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dingy2.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 21000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a21k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dingy2.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 21000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a21k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dingy2.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 22000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a22k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dingy1.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 21000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a21k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dingy1.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 22000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a22k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dingy1.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 22000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a22k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("dingy1.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 23000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a23k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("omega3.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 22000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a22k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("omega3.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 23000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a23k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("omega3.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 23000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a23k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("omega3.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 24000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a24k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("omega2.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 23000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a23k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("omega2.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 24000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a24k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("omega2.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 24000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a24k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("omega2.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 25000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a25k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("omega1.rank") && b == Material.LAPIS_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 24000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a24k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("omega1.rank") && b == Material.IRON_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 25000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a25k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("omega1.rank") && b == Material.REDSTONE_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 25000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a25k ");
			be.breakNaturally(null);
			return;
		}
		if (p.hasPermission("omega1.rank") && b == Material.DIAMOND_ORE) {
			VaultAPI.getEconomy().depositPlayer(p, 26000);
			Mine.sendActionBar(p, "§a§lMINERAR! §fVocê recebeu §2$§a26k ");
			be.breakNaturally(null);
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
