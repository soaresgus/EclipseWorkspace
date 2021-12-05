package me.ninjay.safeclub.estruturas.api.caixa;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.ninjay.safeclub.utils.Mine;

public class ComandoDarCaixa implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("caixa.admin")) {
				if(args.length <= 2) {
					p.sendMessage("§cUtilize /darcaixa <Player> <Número> <Quantidade>");
					return true;
				}else {
					Player j = Bukkit.getPlayer(args[0]);
					if(j == null) {
						p.sendMessage("§cJogador Offline");
						return true;
					}
					int n = Mine.toInt(args[1]);
					Caixa caixa = CaixaAPI.manager.getCaixaInt(n);
					int qnt = Mine.toInt(args[2]);
					if(caixa == null) {
						p.sendMessage("§cA caixa de número "+n+" não foi encontrada no banco de dados.");
						return true;
					}
					ItemStack item = caixa.getIcone().clone();
					item.setAmount(qnt);
					j.getInventory().addItem(item);
					j.sendMessage("§eVocê recebeu "+qnt+" caixa(s) misteriosa(s) !");
					
				}
			}
		}
		return false;
	}

}
