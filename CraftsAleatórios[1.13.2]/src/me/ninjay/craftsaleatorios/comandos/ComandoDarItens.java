package me.ninjay.craftsaleatorios.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.craftsaleatorios.estruturas.ItensAPI;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ItensAPI.escudo);
			p.getInventory().addItem(ItensAPI.macadiamante);
			p.getInventory().addItem(ItensAPI.picfim);
			p.getInventory().addItem(ItensAPI.piceme);
			p.getInventory().addItem(ItensAPI.espadaeme);
			p.getInventory().addItem(ItensAPI.espadaceno);
			p.getInventory().addItem(ItensAPI.espadapao);
			p.getInventory().addItem(ItensAPI.capamadeira);
			p.getInventory().addItem(ItensAPI.peitomadeira);
			p.getInventory().addItem(ItensAPI.calcamadeira);
			p.getInventory().addItem(ItensAPI.botamadeira);
			p.getInventory().addItem(ItensAPI.capaforna);
			p.getInventory().addItem(ItensAPI.peitoforna);
			p.getInventory().addItem(ItensAPI.calcaforna);
			p.getInventory().addItem(ItensAPI.botaforna);
			p.getInventory().addItem(ItensAPI.capamaca);
			p.getInventory().addItem(ItensAPI.peitomaca);
			p.getInventory().addItem(ItensAPI.calcamaca);
			p.getInventory().addItem(ItensAPI.botamaca);
			p.getInventory().addItem(ItensAPI.capaobsi);
			p.getInventory().addItem(ItensAPI.peitoobsi);
			p.getInventory().addItem(ItensAPI.calcaobsi);
			p.getInventory().addItem(ItensAPI.botaobsi);
			p.getInventory().addItem(ItensAPI.capamagma);
			p.getInventory().addItem(ItensAPI.peitomagma);
			p.getInventory().addItem(ItensAPI.calcamagma);
			p.getInventory().addItem(ItensAPI.botamagma);
			p.getInventory().addItem(ItensAPI.capadisp);
			p.getInventory().addItem(ItensAPI.espadaquartz());
			p.getInventory().addItem(ItensAPI.machacarne);
			p.getInventory().addItem(ItensAPI.perolavidro);
			p.getInventory().addItem(ItensAPI.baudima);
			p.getInventory().addItem(ItensAPI.picastick());
			p.getInventory().addItem(ItensAPI.cercared);
			p.getInventory().addItem(ItensAPI.tocha);
			
		}
		return false;
	}

}
