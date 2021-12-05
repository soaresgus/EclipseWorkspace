package me.ninjay.safecore.estruturas.skills.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoMineracao implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			p.sendMessage("§a§l              Habilidades - Mineração              ");
			p.sendMessage(" ");
			p.sendMessage("§8Como evoluir?");
			p.sendMessage(" ");
			p.sendMessage("  §7A cada bloco quebrado no /mina uma quantia de XP é aplicada.");
			p.sendMessage(" ");
			p.sendMessage("§8Especial - Nível 50");
			p.sendMessage(" ");
			p.sendMessage("  §7Desbloqueada a habilidade money duplo\n  └Receba uma chance de ganhar dinheiro em dobro no /mina.");
			p.sendMessage(" ");
			p.sendMessage("§8Especial - Nível 100");
			p.sendMessage(" ");
			p.sendMessage("  §7Desbloqueada a habilidade de fortuna\n  └Receba uma chance de vender esmeraldas no /mina.");
			p.sendMessage(" ");
			p.sendMessage("§8Mundo de mineração (/mina)");
			p.sendMessage(" ");
			p.sendMessage("  §7Mundo feito para minerar, a cada pedra quebrada uma quantia de money é aplicada.");
			p.sendMessage(" ");
		}
		return false;
	}

}
