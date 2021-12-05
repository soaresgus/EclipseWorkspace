package me.ninjay.aurealobby;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import net.eduard.api.lib.Mine;




public class ComandoPvP implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			p.getInventory().clear();
			p.updateInventory();
			p.sendMessage("§aSendo teleportado em 5 segundos.");
			new BukkitRunnable() {
				
				@Override
				public void run() {
					Main.permission.playerRemove(p, "anti.drop");
					p.teleport(Main.config.getLocation("arena"));
					p.sendMessage("§aTeleportado para a arena !");
					ItemStack sopa = Mine.newItem(Material.MUSHROOM_SOUP, "§eSopa");
					ItemStack espada = Mine.newItem(Material.STONE_SWORD, "§eEspada");
					
					        p.setAllowFlight(false);
					        p.setGameMode(GameMode.SURVIVAL);
							p.getInventory().setItem(0, espada);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							p.getInventory().addItem(sopa);
							
						return;
						}
				}.runTaskLater(Main.getmain(), 100);
		}
		return false;
	}
}
	




