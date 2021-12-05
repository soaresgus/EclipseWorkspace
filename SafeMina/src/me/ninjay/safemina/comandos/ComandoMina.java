package me.ninjay.safemina.comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.safemina.eventos.EventosGeral;
import me.ninjay.safemina.main.Main;
import me.ninjay.safemina.utils.Mine;

public class ComandoMina implements CommandExecutor {

	public static void createMina(Location loc, Material type) {
		loc.clone().add(0, -2, 0).getBlock().setType(type, true);
		loc.clone().add(0, -2, +1).getBlock().setType(type, true);
		loc.clone().add(0, -2, +2).getBlock().setType(type, true);
		loc.clone().add(0, -2, +3).getBlock().setType(type, true);
		loc.clone().add(0, -2, +4).getBlock().setType(type, true);

		loc.clone().add(0, -2, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -2, 0).getBlock().setType(type, true);
		loc.clone().add(+2, -2, 0).getBlock().setType(type, true);
		loc.clone().add(+3, -2, 0).getBlock().setType(type, true);
		loc.clone().add(+4, -2, 0).getBlock().setType(type, true);

		loc.clone().add(0, -2, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -2, +1).getBlock().setType(type, true);
		loc.clone().add(+2, -2, +1).getBlock().setType(type, true);
		loc.clone().add(+3, -2, +1).getBlock().setType(type, true);
		loc.clone().add(+4, -2, +1).getBlock().setType(type, true);

		loc.clone().add(0, -2, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -2, +2).getBlock().setType(type, true);
		loc.clone().add(+2, -2, +2).getBlock().setType(type, true);
		loc.clone().add(+3, -2, +2).getBlock().setType(type, true);
		loc.clone().add(+4, -2, +2).getBlock().setType(type, true);

		loc.clone().add(0, -2, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -2, +3).getBlock().setType(type, true);
		loc.clone().add(+2, -2, +3).getBlock().setType(type, true);
		loc.clone().add(+3, -2, +3).getBlock().setType(type, true);
		loc.clone().add(+4, -2, +3).getBlock().setType(type, true);

		loc.clone().add(0, -2, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -2, +4).getBlock().setType(type, true);
		loc.clone().add(+2, -2, +4).getBlock().setType(type, true);
		loc.clone().add(+3, -2, +4).getBlock().setType(type, true);
		loc.clone().add(+4, -2, +4).getBlock().setType(type, true);

		//

		loc.clone().add(0, -3, 0).getBlock().setType(type, true);
		loc.clone().add(0, -3, +1).getBlock().setType(type, true);
		loc.clone().add(0, -3, +2).getBlock().setType(type, true);
		loc.clone().add(0, -3, +3).getBlock().setType(type, true);
		loc.clone().add(0, -3, +4).getBlock().setType(type, true);

		loc.clone().add(0, -3, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -3, 0).getBlock().setType(type, true);
		loc.clone().add(+2, -3, 0).getBlock().setType(type, true);
		loc.clone().add(+3, -3, 0).getBlock().setType(type, true);
		loc.clone().add(+4, -3, 0).getBlock().setType(type, true);

		loc.clone().add(0, -3, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -3, +1).getBlock().setType(type, true);
		loc.clone().add(+2, -3, +1).getBlock().setType(type, true);
		loc.clone().add(+3, -3, +1).getBlock().setType(type, true);
		loc.clone().add(+4, -3, +1).getBlock().setType(type, true);

		loc.clone().add(0, -3, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -3, +2).getBlock().setType(type, true);
		loc.clone().add(+2, -3, +2).getBlock().setType(type, true);
		loc.clone().add(+3, -3, +2).getBlock().setType(type, true);
		loc.clone().add(+4, -3, +2).getBlock().setType(type, true);

		loc.clone().add(0, -3, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -3, +3).getBlock().setType(type, true);
		loc.clone().add(+2, -3, +3).getBlock().setType(type, true);
		loc.clone().add(+3, -3, +3).getBlock().setType(type, true);
		loc.clone().add(+4, -3, +3).getBlock().setType(type, true);

		loc.clone().add(0, -3, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -3, +4).getBlock().setType(type, true);
		loc.clone().add(+2, -3, +4).getBlock().setType(type, true);
		loc.clone().add(+3, -3, +4).getBlock().setType(type, true);
		loc.clone().add(+4, -3, +4).getBlock().setType(type, true);

		//

		loc.clone().add(0, -4, 0).getBlock().setType(type, true);
		loc.clone().add(0, -4, +1).getBlock().setType(type, true);
		loc.clone().add(0, -4, +2).getBlock().setType(type, true);
		loc.clone().add(0, -4, +3).getBlock().setType(type, true);
		loc.clone().add(0, -4, +4).getBlock().setType(type, true);

		loc.clone().add(0, -4, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -4, 0).getBlock().setType(type, true);
		loc.clone().add(+2, -4, 0).getBlock().setType(type, true);
		loc.clone().add(+3, -4, 0).getBlock().setType(type, true);
		loc.clone().add(+4, -4, 0).getBlock().setType(type, true);

		loc.clone().add(0, -4, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -4, +1).getBlock().setType(type, true);
		loc.clone().add(+2, -4, +1).getBlock().setType(type, true);
		loc.clone().add(+3, -4, +1).getBlock().setType(type, true);
		loc.clone().add(+4, -4, +1).getBlock().setType(type, true);

		loc.clone().add(0, -4, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -4, +2).getBlock().setType(type, true);
		loc.clone().add(+2, -4, +2).getBlock().setType(type, true);
		loc.clone().add(+3, -4, +2).getBlock().setType(type, true);
		loc.clone().add(+4, -4, +2).getBlock().setType(type, true);

		loc.clone().add(0, -4, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -4, +3).getBlock().setType(type, true);
		loc.clone().add(+2, -4, +3).getBlock().setType(type, true);
		loc.clone().add(+3, -4, +3).getBlock().setType(type, true);
		loc.clone().add(+4, -4, +3).getBlock().setType(type, true);

		loc.clone().add(0, -4, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -4, +4).getBlock().setType(type, true);
		loc.clone().add(+2, -4, +4).getBlock().setType(type, true);
		loc.clone().add(+3, -4, +4).getBlock().setType(type, true);
		loc.clone().add(+4, -4, +4).getBlock().setType(type, true);

		//

		loc.clone().add(0, -5, 0).getBlock().setType(type, true);
		loc.clone().add(0, -5, +1).getBlock().setType(type, true);
		loc.clone().add(0, -5, +2).getBlock().setType(type, true);
		loc.clone().add(0, -5, +3).getBlock().setType(type, true);
		loc.clone().add(0, -5, +4).getBlock().setType(type, true);

		loc.clone().add(0, -5, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -5, 0).getBlock().setType(type, true);
		loc.clone().add(+2, -5, 0).getBlock().setType(type, true);
		loc.clone().add(+3, -5, 0).getBlock().setType(type, true);
		loc.clone().add(+4, -5, 0).getBlock().setType(type, true);

		loc.clone().add(0, -5, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -5, +1).getBlock().setType(type, true);
		loc.clone().add(+2, -5, +1).getBlock().setType(type, true);
		loc.clone().add(+3, -5, +1).getBlock().setType(type, true);
		loc.clone().add(+4, -5, +1).getBlock().setType(type, true);

		loc.clone().add(0, -5, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -5, +2).getBlock().setType(type, true);
		loc.clone().add(+2, -5, +2).getBlock().setType(type, true);
		loc.clone().add(+3, -5, +2).getBlock().setType(type, true);
		loc.clone().add(+4, -5, +2).getBlock().setType(type, true);

		loc.clone().add(0, -5, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -5, +3).getBlock().setType(type, true);
		loc.clone().add(+2, -5, +3).getBlock().setType(type, true);
		loc.clone().add(+3, -5, +3).getBlock().setType(type, true);
		loc.clone().add(+4, -5, +3).getBlock().setType(type, true);

		loc.clone().add(0, -5, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -5, +4).getBlock().setType(type, true);
		loc.clone().add(+2, -5, +4).getBlock().setType(type, true);
		loc.clone().add(+3, -5, +4).getBlock().setType(type, true);
		loc.clone().add(+4, -5, +4).getBlock().setType(type, true);

		//

		loc.clone().add(0, -6, 0).getBlock().setType(type, true);
		loc.clone().add(0, -6, +1).getBlock().setType(type, true);
		loc.clone().add(0, -6, +2).getBlock().setType(type, true);
		loc.clone().add(0, -6, +3).getBlock().setType(type, true);
		loc.clone().add(0, -6, +4).getBlock().setType(type, true);

		loc.clone().add(0, -6, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -6, 0).getBlock().setType(type, true);
		loc.clone().add(+2, -6, 0).getBlock().setType(type, true);
		loc.clone().add(+3, -6, 0).getBlock().setType(type, true);
		loc.clone().add(+4, -6, 0).getBlock().setType(type, true);

		loc.clone().add(0, -6, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -6, +1).getBlock().setType(type, true);
		loc.clone().add(+2, -6, +1).getBlock().setType(type, true);
		loc.clone().add(+3, -6, +1).getBlock().setType(type, true);
		loc.clone().add(+4, -6, +1).getBlock().setType(type, true);

		loc.clone().add(0, -6, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -6, +2).getBlock().setType(type, true);
		loc.clone().add(+2, -6, +2).getBlock().setType(type, true);
		loc.clone().add(+3, -6, +2).getBlock().setType(type, true);
		loc.clone().add(+4, -6, +2).getBlock().setType(type, true);

		loc.clone().add(0, -6, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -6, +3).getBlock().setType(type, true);
		loc.clone().add(+2, -6, +3).getBlock().setType(type, true);
		loc.clone().add(+3, -6, +3).getBlock().setType(type, true);
		loc.clone().add(+4, -6, +3).getBlock().setType(type, true);

		loc.clone().add(0, -6, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -6, +4).getBlock().setType(type, true);
		loc.clone().add(+2, -6, +4).getBlock().setType(type, true);
		loc.clone().add(+3, -6, +4).getBlock().setType(type, true);
		loc.clone().add(+4, -6, +4).getBlock().setType(type, true);
	}

	public static ArrayList<Player> proc = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;

			boolean isEmpty = true;
			for (ItemStack item : p.getInventory().getContents()) {
				if (item != null) {
					isEmpty = false;
					break;
				}
			}
			if (isEmpty) {
				p.sendMessage(
						"§6§l                     Mundo de mineração                     \n \n§e  - A cada bloco quebrado você encontra um minério.\n  - Minérios encontrados são vendidos automáticamente.\n  - Apenas nesse mundo a mineração pode ser evoluida.\n  - Apenas nesse mundo os poderes da mineração funcionam.\n ");
				Integer x = Mine.getRandomInt(0, 4500);
				Integer y = Mine.getRandomInt(10, 230);
				Integer z = Mine.getRandomInt(0, 4500);
				Location loc = new Location(Bukkit.getWorld(Main.config.getString("MundoMina")), x, y, z);
				Location loc2 = new Location(Bukkit.getWorld(Main.config.getString("MundoMina")), x+2.5, y, z+2.5);
				EventosGeral.loc.put(p, loc);
				createMina(loc, Material.STONE);
				p.teleport(loc2);
				Mine.sendTitle(p, "§a§lMineração", "§aMina gerada com sucesso", 10, 50, 10);
				p.getInventory().addItem(Mine.newItem(Material.DIAMOND_PICKAXE, null));
			} else {
				p.sendMessage("§cEsvazie o inventário para teleportar.");
			}
		}
		return false;
	}
}
