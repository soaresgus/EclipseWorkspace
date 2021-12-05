package me.ninjay.juntarminerios.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.ninjay.juntarminerios.estruturas.ItensAPI;
import me.ninjay.juntarminerios.utils.Mine;


public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			Inventory menu = Mine.newInventory("Pegue os itens", 9*6);
			
			menu.addItem(ItensAPI.feurob);
			menu.addItem(ItensAPI.feuroi);
			menu.addItem(ItensAPI.diamourob);
			menu.addItem(ItensAPI.diamouroi);
			menu.addItem(ItensAPI.esmeldimab);
			menu.addItem(ItensAPI.esmeldimai);
			menu.addItem(ItensAPI.netheraldab);
			menu.addItem(ItensAPI.netheraldai);
			
			menu.addItem(ItensAPI.feuropa());
			menu.addItem(ItensAPI.feuropicareta());
			menu.addItem(ItensAPI.feuroespada());
			menu.addItem(ItensAPI.feuromachado());
			menu.addItem(ItensAPI.feurocapacete());
			menu.addItem(ItensAPI.feuropeitoral());
			menu.addItem(ItensAPI.feurocalca());
			menu.addItem(ItensAPI.feurobotas());
			
			menu.addItem(ItensAPI.diamouropa());
			menu.addItem(ItensAPI.diamouropicareta());
			menu.addItem(ItensAPI.diamouroespada());
			menu.addItem(ItensAPI.diamouromachado());
			menu.addItem(ItensAPI.diamourocapacete());
			menu.addItem(ItensAPI.diamouropeitoral());
			menu.addItem(ItensAPI.diamourocalca());
			menu.addItem(ItensAPI.diamourobotas());
			
			menu.addItem(ItensAPI.esmeldimapa());
			menu.addItem(ItensAPI.esmeldimapicareta());
			menu.addItem(ItensAPI.esmeldimaespada());
			menu.addItem(ItensAPI.esmeldimamachado());
			menu.addItem(ItensAPI.esmeldimacapacete());
			menu.addItem(ItensAPI.esmeldimapeitoral());
			menu.addItem(ItensAPI.esmeldimacalca());
			menu.addItem(ItensAPI.esmeldimabotas());
			
			menu.addItem(ItensAPI.netheraldapa());
			menu.addItem(ItensAPI.netheraldapicareta());
			menu.addItem(ItensAPI.netheraldaespada());
			menu.addItem(ItensAPI.netheraldamachado());
			menu.addItem(ItensAPI.netheraldacapacete());
			menu.addItem(ItensAPI.netheraldapeitoral());
			menu.addItem(ItensAPI.netheraldacalca());
			menu.addItem(ItensAPI.netheraldabotas());
			
			p.openInventory(menu);
		}
		return false;
	}

}
