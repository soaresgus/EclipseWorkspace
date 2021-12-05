package me.ninjay.curso.tempo;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.ninjay.curso.main.Main;
import net.eduard.api.lib.Mine;

public class ComandoCooldown2 implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(Main.config.contains("Cooldown."+p.getName())) {
				long tempo = Main.config.getLong("Cooldown."+p.getName());
				long resultado = Mine.getCooldown(tempo, 2592000);
				
				if(Mine.inCooldown(tempo, 2592000)) {
					
					p.sendMessage("§aVocê tem que esperar "+Mine.formatTime(resultado));
					return true;
				}
			}
			//p.sendmessage("vc entrou no cooldown");
			p.getInventory().addItem(new ItemStack(Material.DIAMOND_AXE));
			Main.config.set("Cooldown."+p.getName(), System.currentTimeMillis());
			Main.config.saveConfig();
		}
		return false;
	}

}
