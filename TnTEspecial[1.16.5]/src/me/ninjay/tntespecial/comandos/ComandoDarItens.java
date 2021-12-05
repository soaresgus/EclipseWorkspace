package me.ninjay.tntespecial.comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.ninjay.tntespecial.estruturas.ItensAPI;
import me.ninjay.tntespecial.utils.Mine;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;

			p.getInventory().addItem(ItensAPI.esticada);
			p.getInventory().addItem(ItensAPI.abelha);
			p.getInventory().addItem(ItensAPI.esmagadora);
			p.getInventory().addItem(ItensAPI.espelhada);
			p.getInventory().addItem(ItensAPI.meteoro);
			p.getInventory().addItem(ItensAPI.gravidade);
			p.getInventory().addItem(ItensAPI.sorte);
			p.getInventory().addItem(ItensAPI.bedrock);
			p.getInventory().addItem(ItensAPI.espiral);
		}
		return false;
	}

}
