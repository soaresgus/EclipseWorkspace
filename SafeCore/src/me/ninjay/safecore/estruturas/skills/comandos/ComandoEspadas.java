package me.ninjay.safecore.estruturas.skills.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoEspadas implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			p.sendMessage("§a§l              Habilidades - Espadas              ");
			p.sendMessage(" ");
			p.sendMessage("§8Como evoluir?");
			p.sendMessage(" ");
			p.sendMessage("  §7A cada hit em jogadores uma quantia de XP é aplicada.");
			p.sendMessage(" ");
			p.sendMessage("§8Especial - Nível 50");
			p.sendMessage(" ");
			p.sendMessage("  §7Desbloqueada a habilidade de sangramento\n  └Quando ativada deixe seus inimigos sangrando.");
			p.sendMessage(" ");
			p.sendMessage("§8Especial - Nível 100");
			p.sendMessage(" ");
			p.sendMessage("  §7Desbloqueada a habilidade de contra-ataque\n  └Com o shift precionado devolva o dano ao seu inimigo.");
			p.sendMessage(" ");
		}
		return false;
	}

}
