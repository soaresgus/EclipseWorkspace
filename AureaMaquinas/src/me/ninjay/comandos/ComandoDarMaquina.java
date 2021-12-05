package me.ninjay.comandos;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ComandoDarMaquina implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("givemaquina")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("�6�lApenas Players");

			} else {
				Player p = (Player) sender;
				if (!p.hasPermission("givemaquina.use")) {
					p.sendMessage("�6�lSem permiss�o");
					return true;
				}
				if(args.length == 0) {
					p.sendMessage("�6�lUtilize /givemaquina <jogador> <carv�o/ferro/ouro>");
					return true;
				}               
				if(args.length == 1) {
					p.sendMessage("�6�lUtilize /givemaquina <jogador> <carv�o/ferro/ouro>");
					return true;
				}
			
				Player p2 = Bukkit.getPlayer(args[0]);
				if(p2 == null) {
					p.sendMessage("�6�lJogador offline.");
					return true;
				}
			
				
				if (p.hasPermission("givemaquina.use") && args[1].equalsIgnoreCase("carv�o")) {
					ItemStack car = new ItemStack(Material.COAL_BLOCK);
	                ItemMeta carm = car.getItemMeta();
	                carm.setDisplayName("�eMaquina de carv�o");
	                carm.setLore(Arrays.asList("�7Material que est� sendo gerado: �eCarv�o", "�7Tipo de combust�vel: �eCombust�vel B�sico","�7Valor do combust�vel: �e1000$"));
	                carm.addEnchant(Enchantment.DURABILITY, 1, false);
	                car.setItemMeta(carm);
	                p2.getInventory().addItem(car);
	                p2.sendMessage("�6�lVoc� recebeu uma m�quina de carv�o de "+p.getName());
	                p.sendMessage("�6�lVoc� entregou uma m�quina de carv�o para "+p2.getName());
	                return true;
                
	             
}
				if(p.hasPermission("givemaquina.use") && !args[1].equalsIgnoreCase("carv�o") || !args[1].equalsIgnoreCase("ferro") || !args[1].equalsIgnoreCase("ouro")) {
					p.sendMessage("�6�lA m�quina "+args[1]+" n�o foi localizada em nosso banco de dados.");
					return true;
			}
				if (p.hasPermission("givemaquina.use") && args[1].equalsIgnoreCase("ferro")) {
					ItemStack fer = new ItemStack(Material.IRON_BLOCK);
	                ItemMeta ferm = fer.getItemMeta();
	                ferm.setDisplayName("�eMaquina de ferro");
	                ferm.setLore(Arrays.asList("�7Material que est� sendo gerado: �eFerro", "�7Tipo de combust�vel: �eCombust�vel M�dio","�7Valor do combust�vel: �e1000$"));
	                ferm.addEnchant(Enchantment.DURABILITY, 1, false);
	                fer.setItemMeta(ferm);
	                p2.getInventory().addItem(fer);
	                p2.sendMessage("�6�lVoc� recebeu uma m�quina de ferro de "+p.getName());
	                p.sendMessage("�6�lVoc� entregou uma m�quina de ferro para "+p2.getName());
	                return true;
			
		}
				if (p.hasPermission("givemaquina.use") && args[1].equalsIgnoreCase("our")) {
					ItemStack our = new ItemStack(Material.GOLD_BLOCK);
	                ItemMeta ourm = our.getItemMeta();
	                ourm.setDisplayName("�eMaquina de ouro");
	                ourm.setLore(Arrays.asList("�7Material que est� sendo gerado: �eOuro", "�7Tipo de combust�vel: �eCombust�vel Avan�ado","�7Valor do combust�vel: �e1000$"));
	                ourm.addEnchant(Enchantment.DURABILITY, 1, false);
	                our.setItemMeta(ourm);
	                p2.getInventory().addItem(our);
	                p2.sendMessage("�6�lVoc� recebeu uma m�quina de ouro de "+p.getName());
	                p.sendMessage("�6�lVoc� entregou uma m�quina de ouro para "+p2.getName());
	                return true;
	}
	
}
}
		return false;
}
}




