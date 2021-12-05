package me.ninjay.oneperfil.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.oneperfil.estruturas.EstruturaJogador;



public class ComandoPerfil implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				Inventory perfil = Mine.newInventory("Perfil de "+p.getName() , 9*3);
				EstruturaJogador.perfil(p, perfil);
				return true;
			}
			
			Player j = Bukkit.getPlayer(args[0]);
			if (j == null) {
				p.sendMessage("§cJogador offline.");
			} else {
				Inventory perfil = Mine.newInventory("Perfil de "+j.getName() , 9*3);
				EstruturaJogador.perfilOther(j, p, perfil);
				return true;
			}
		}
		return false;
	}
}
