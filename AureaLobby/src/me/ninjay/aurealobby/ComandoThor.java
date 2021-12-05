package me.ninjay.aurealobby;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjaapi.utils.Mine;


public class ComandoThor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			
			Player p = (Player) sender;
			Location raiox = p.getLocation();
			Location raiox2 = p.getLocation();
			Location raioy = p.getLocation();
			Location raioy2 = p.getLocation();
			if (Main.config.contains("Cooldown." + p.getName())) {
				long tempo = Main.config.getLong("Cooldown." + p.getName());
				long resultado = Mine.getCooldown(tempo, 15);
              
				if (Mine.inCooldown(tempo, 15)) {

					p.sendMessage("§cO gadget thor está em cooldown, aguarde:§a " + Mine.formatTime(resultado)+" §cpara utilizar novamente");
					return true;
					
				} else {
					Main.config.remove("Cooldown." + p.getName());
					
					raiox.setX(p.getLocation().getX() + 5);
					raiox2.setX(p.getLocation().getX() - 5);
					raioy.setZ(p.getLocation().getZ() + 5);
					raioy2.setZ(p.getLocation().getZ() - 5);

					p.getWorld().strikeLightningEffect(raiox);
					p.getWorld().strikeLightningEffect(raiox2);
					p.getWorld().strikeLightningEffect(raioy);
					p.getWorld().strikeLightningEffect(raioy2);
					if(tempo == 0) {
						p.sendMessage("§aO gadget thor está pronto para ser utilizado novamente.");
						return true;
				}
				
				}
			}

			Main.config.set("Cooldown." + p.getName(), System.currentTimeMillis());
			p.getWorld().strikeLightningEffect(raiox);
			p.getWorld().strikeLightningEffect(raiox2);
			p.getWorld().strikeLightningEffect(raioy);
			p.getWorld().strikeLightningEffect(raioy2);
		}
		return false;
	}

}
