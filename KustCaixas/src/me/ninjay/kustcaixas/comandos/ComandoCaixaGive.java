package me.ninjay.kustcaixas.comandos;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.ninjay.kustcaixas.estruturas.Caixa;
import me.ninjay.kustcaixas.estruturas.CaixaAPI;
import me.ninjay.utils.utils.Mine;

public class ComandoCaixaGive implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(p.hasPermission("caixa.admin")) {
				if(args.length <= 2) {
					p.sendMessage("§cUse: /caixagive <nome> <quantidade> <nick>.");
					return true;
				}
				
				Caixa caixa = CaixaAPI.manager.getCaixaByName(args[0]);
				Player j = Bukkit.getPlayer(args[2]);
				
			if(j != null) {
				if(caixa != null) {
					if(StringUtils.isNumeric(args[1])) {
						ItemStack icone = caixa.getIcone();
						icone.setAmount(Mine.toInt(args[1]));
						
						j.getInventory().addItem(icone);
						p.sendMessage("§aCaixa "+caixa.getName()+" entregue para "+j.getName());
					}else {
						p.sendMessage("§cApenas números.");
					}
				}else {
					p.sendMessage("§cCaixa não encontrada.");
				}
			}else {
				p.sendMessage("§cJogador offline.");
			}
			}
			
		}else {
				if(args.length <= 2) {
					sender.sendMessage("§cUse: /caixagive <nome> <quantidade> <nick>.");
					return true;
				}
				
				Caixa caixa = CaixaAPI.manager.getCaixaByName(args[0]);
				Player j = Bukkit.getPlayer(args[2]);
				
			if(j != null) {
				if(caixa != null) {
					if(StringUtils.isNumeric(args[1])) {
						ItemStack icone = caixa.getIcone();
						icone.setAmount(Mine.toInt(args[1]));
						
						j.getInventory().addItem(icone);
						sender.sendMessage("§aCaixa "+caixa.getName()+" entregue para "+j.getName());
					}else {
						sender.sendMessage("§cApenas números.");
					}
				}else {
					sender.sendMessage("§cCaixa não encontrada.");
				}
			}else {
				sender.sendMessage("§cJogador offline.");
			}
		}
		return false;
	}

}
