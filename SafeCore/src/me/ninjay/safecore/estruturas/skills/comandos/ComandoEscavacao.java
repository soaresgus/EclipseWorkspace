package me.ninjay.safecore.estruturas.skills.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoEscavacao implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			p.sendMessage("§a§l              Habilidades - Escavação              ");
			p.sendMessage(" ");
			p.sendMessage("§8Como evoluir?");
			p.sendMessage(" ");
			p.sendMessage("  §7A cada bloco quebrado no /escavar uma quantia de XP é aplicada.");
			p.sendMessage(" ");
			p.sendMessage("§8Especial - Nível 50");
			p.sendMessage(" ");
			p.sendMessage("  §7Desbloqueada a habilidade especialista\n  └Receba uma chance de dropar fungo no /escavar");
			p.sendMessage(" ");
			p.sendMessage("§8Especial - Nível 100");
			p.sendMessage(" ");
			p.sendMessage("  §7Desbloqueada a habilidade de garimpeiro\n  └Receba uma chance de vender esmeraldas no /escavar.");
			p.sendMessage(" ");
			p.sendMessage("§8Mundo de escavação (/escavar)");
			p.sendMessage(" ");
			p.sendMessage("  §7Mundo feito para escavar, a cada areia quebrada uma quantia de money é aplicada.");
			p.sendMessage(" ");
		}
		return false;
	}

}
