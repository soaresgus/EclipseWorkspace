package net.b_vender;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Main instance;

	@Override
	public void onEnable() {
		instance = this;

	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (command.getName().equalsIgnoreCase("vender")) {
				int amount = 0;
				double valor = 0;
				for (int i = 0; i < p.getInventory().getSize(); i++) {
					ItemStack is = p.getInventory().getItem(i);
					for (Itens itens : Itens.values()) {
						if (p.getInventory().contains(itens.getMaterial())) {
							if (is != null && is.getType() == itens.getMaterial()) {
								amount += is.getAmount();
								valor += (itens.getValor() * is.getAmount()) / 2304;
								p.getInventory().removeItem(is);
							}
						}
					}
				}
				if (amount == 0) {
					p.sendMessage("§cVocê não tem itens no inventário a serem vendidos.");
					return true;
				}
				p.sendMessage("§aVocê acabou de vender §f" + amount + " §aitens por §f" + valor + "§a.");
			}
		}
		return true;
	}

}
