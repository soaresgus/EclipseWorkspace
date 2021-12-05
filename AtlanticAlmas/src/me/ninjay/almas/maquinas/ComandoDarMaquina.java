package me.ninjay.almas.maquinas;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;

public class ComandoDarMaquina implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length < 3 && p.hasPermission("maquina.admin")) {
				p.sendMessage("§e§l/darmaquina <jogador> <tipo> <quantidade>");
				return true;
			}
			Player jogador = Bukkit.getPlayer(args[0]);
			if(jogador == null) {
				p.sendMessage("§e§lJogador offline");
				return true;
			}
			String nome = args[1];
			Maquina maquina = MaquinaAPI.manager.getmaquina(nome);
			if(maquina == null) {
				p.sendMessage("§e§lA máquina "+nome+" não foi localizada no banco de dados.");
				return true;
			}
			String quantidade = args[2];
			int quantia = Mine.toInt(quantidade);
			if(quantia <= 0 ) {
				p.sendMessage("§e§lQuantidade de máquinas inválida.");
				return true;
			}
			ItemStack item = maquina.getIcone().clone();
			item.setAmount(quantia);
			
			p.sendMessage("§e§lVocê entregou "+quantia+" máquina "+nome+" para "+jogador.getName());
			jogador.sendMessage("§e§lVocê recebeu "+quantia+" máquina "+nome+" de "+p.getName());
			jogador.getInventory().addItem(item);
			
		}
		return false;
	}

}
