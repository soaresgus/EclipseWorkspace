package me.ninjay.random.holo;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjaapi.utils.Mine;

public class ComandoHolograma implements CommandExecutor{
		
		
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
            Mine.newHologram(p.getLocation(), "§6§lFACTIONS FIRE","§f✦ Borda do mapa 15.000 x 15.000","✦ Sistema de encantamento por feiticeiro","✦ Gravidade dos blocos ativado","✦ Spawners padrão","✦ Factions puxado para o vannila","✦ TAF Domina e foda-se");
		}
		return false;
	}
}
