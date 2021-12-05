package me.ninjay.megataymaquinas.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.ninjay.megataymaquinas.estruturas.Maquina;
import me.ninjay.megataymaquinas.estruturas.MaquinaAPI;
import net.eduard.api.lib.Mine;

public class ComandoMaquina implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
	    if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage("§cUse: /maquina drops.");
				return true;
			}
			if(p.hasPermission("maquina.admin")) {
				if(args[0].equalsIgnoreCase("give")) {
				   if(!(args.length <= 2)) {
					String nome = args[1];
					int i = Mine.toInt(args[2]);
					Maquina maquina = MaquinaAPI.manager.getMaquinaPorNome(nome);
					if(maquina != null) {
						if(i > 0) {
							ItemStack maquinai = maquina.getIcone();
							maquinai.setAmount(i);
							p.sendMessage("§aMáquina recebida.");
							p.getInventory().addItem(maquinai);
						}else {
							p.sendMessage("§cUse um número que seja positivo ou maior do que 0.");
							return true;
						}
					}else {
						p.sendMessage("§cA máquina "+nome+" não foi encontrada no banco de dados.");
					
				}
				}else {
					p.sendMessage("§cUse: /maquina give <nome> <quantidade>.");
				}
					}
			}
	    }
	
		return false;
	}

}
