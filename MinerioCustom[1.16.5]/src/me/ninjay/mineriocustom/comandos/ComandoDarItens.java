package me.ninjay.mineriocustom.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.ninjay.mineriocustom.estruturas.Minerio;
import me.ninjay.mineriocustom.estruturas.MinerioAPI;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			for(Minerio minerio : MinerioAPI.manager.getMinerios()) {
				p.getWorld().dropItem(p.getLocation().add(0, 0.5, 0), new ItemStack(minerio.getTipo()));
			}
		}
		return false;
	}

}
