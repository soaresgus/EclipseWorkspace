package me.ninjay.safecore.estruturas.skills.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoAcrobacia implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			p.sendMessage("§a§l              Habilidades - Acrobacia              ");
			p.sendMessage(" ");
			p.sendMessage("§8Como evoluir?");
			p.sendMessage(" ");
			p.sendMessage("  §7A cada queda que leve dano uma quantia de XP é aplicada.");
			p.sendMessage(" ");
			p.sendMessage("§8Especial - Nível 50");
			p.sendMessage(" ");
			p.sendMessage("  §7Desbloqueada a habilidade de rolamento\n  └A cair tenha uma chance de receber menos dano.");
			p.sendMessage(" ");
			p.sendMessage("§8Especial - Nível 100");
			p.sendMessage(" ");
			p.sendMessage("  §7Desbloqueada a habilidade de sabedoria de rolamento\n  └A cair tenha uma chance maior de receber menos dano.");
			p.sendMessage(" ");
		}
		return false;
	}

}
