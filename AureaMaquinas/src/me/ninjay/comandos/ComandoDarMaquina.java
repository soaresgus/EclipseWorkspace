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
				sender.sendMessage("§6§lApenas Players");

			} else {
				Player p = (Player) sender;
				if (!p.hasPermission("givemaquina.use")) {
					p.sendMessage("§6§lSem permissão");
					return true;
				}
				if(args.length == 0) {
					p.sendMessage("§6§lUtilize /givemaquina <jogador> <carvão/ferro/ouro>");
					return true;
				}               
				if(args.length == 1) {
					p.sendMessage("§6§lUtilize /givemaquina <jogador> <carvão/ferro/ouro>");
					return true;
				}
			
				Player p2 = Bukkit.getPlayer(args[0]);
				if(p2 == null) {
					p.sendMessage("§6§lJogador offline.");
					return true;
				}
			
				
				if (p.hasPermission("givemaquina.use") && args[1].equalsIgnoreCase("carvão")) {
					ItemStack car = new ItemStack(Material.COAL_BLOCK);
	                ItemMeta carm = car.getItemMeta();
	                carm.setDisplayName("§eMaquina de carvão");
	                carm.setLore(Arrays.asList("§7Material que está sendo gerado: §eCarvão", "§7Tipo de combustível: §eCombustível Básico","§7Valor do combustível: §e1000$"));
	                carm.addEnchant(Enchantment.DURABILITY, 1, false);
	                car.setItemMeta(carm);
	                p2.getInventory().addItem(car);
	                p2.sendMessage("§6§lVocê recebeu uma máquina de carvão de "+p.getName());
	                p.sendMessage("§6§lVocê entregou uma máquina de carvão para "+p2.getName());
	                return true;
                
	             
}
				if(p.hasPermission("givemaquina.use") && !args[1].equalsIgnoreCase("carvão") || !args[1].equalsIgnoreCase("ferro") || !args[1].equalsIgnoreCase("ouro")) {
					p.sendMessage("§6§lA máquina "+args[1]+" não foi localizada em nosso banco de dados.");
					return true;
			}
				if (p.hasPermission("givemaquina.use") && args[1].equalsIgnoreCase("ferro")) {
					ItemStack fer = new ItemStack(Material.IRON_BLOCK);
	                ItemMeta ferm = fer.getItemMeta();
	                ferm.setDisplayName("§eMaquina de ferro");
	                ferm.setLore(Arrays.asList("§7Material que está sendo gerado: §eFerro", "§7Tipo de combustível: §eCombustível Médio","§7Valor do combustível: §e1000$"));
	                ferm.addEnchant(Enchantment.DURABILITY, 1, false);
	                fer.setItemMeta(ferm);
	                p2.getInventory().addItem(fer);
	                p2.sendMessage("§6§lVocê recebeu uma máquina de ferro de "+p.getName());
	                p.sendMessage("§6§lVocê entregou uma máquina de ferro para "+p2.getName());
	                return true;
			
		}
				if (p.hasPermission("givemaquina.use") && args[1].equalsIgnoreCase("our")) {
					ItemStack our = new ItemStack(Material.GOLD_BLOCK);
	                ItemMeta ourm = our.getItemMeta();
	                ourm.setDisplayName("§eMaquina de ouro");
	                ourm.setLore(Arrays.asList("§7Material que está sendo gerado: §eOuro", "§7Tipo de combustível: §eCombustível Avançado","§7Valor do combustível: §e1000$"));
	                ourm.addEnchant(Enchantment.DURABILITY, 1, false);
	                our.setItemMeta(ourm);
	                p2.getInventory().addItem(our);
	                p2.sendMessage("§6§lVocê recebeu uma máquina de ouro de "+p.getName());
	                p.sendMessage("§6§lVocê entregou uma máquina de ouro para "+p2.getName());
	                return true;
	}
	
}
}
		return false;
}
}




