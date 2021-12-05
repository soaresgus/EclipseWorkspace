 package me.ninjay.safecore.estruturas.skills.comandos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.safecore.estruturas.skills.EventosSkillsHab;
import me.ninjay.safecore.utils.Mine;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class ComandoFeiticeiro implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			String displayedMessage = "§f§lCLIQUE AQUI §7para ver a receita do cajado.";
			String command = "/feiticeiro craft";

			BaseComponent[] components = TextComponent.fromLegacyText(displayedMessage);
			ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.RUN_COMMAND,command);

			for (BaseComponent component : components) {
			    component.setClickEvent(clickEvent);
			}

			if(args.length <= 0) {
			p.sendMessage("§a§l              Habilidades - Feiticeiro              ");
			p.sendMessage(" ");
			p.sendMessage("§8Como evoluir?");
			p.sendMessage(" ");
			p.sendMessage("  §7A cada poção bebida uma quantia de XP é aplicada.");
			p.sendMessage(" ");
			p.sendMessage("§8Especial - Nível 50");
			p.sendMessage(" ");
			p.sendMessage("  §7Desbloqueada a habilidade de cansaço\n  └Quando ativada deixe seus inimigos lentos.");
			p.sendMessage(" ");
			p.sendMessage("§8Especial - Nível 100");
			p.sendMessage(" ");
			p.sendMessage("  §7Desbloqueada a habilidade de rastro de fumaça\n  └Quando ativada, ao andar emita um rastro de fumaça.");
			p.sendMessage(" ");
			p.sendMessage("§8Cajado de feiticeiro");
			p.sendMessage(" ");
			p.sendMessage("  §7O cajado é um item craftavel que é responsável por emitir as habilidades.");
			p.sendMessage(" ");
			p.spigot().sendMessage(components);
			p.sendMessage(" ");
			}else {
			if(args[0].equalsIgnoreCase("give")) {
				if(p.isOp() == true) {
					p.sendMessage("§aCajado setado.");
					ItemStack cajado = Mine.newItem(Material.BLAZE_ROD, "§bCajado de feiticeiro", 1, 0, " ",
							" §7Clique com o direito para acessar o menu.");
					p.getInventory().addItem(cajado);
				}else {
					p.sendMessage("§cSem permissão.");
				}
			}
			if(args[0].equalsIgnoreCase("craft")) {
				Inventory menu = Bukkit.createInventory(null, InventoryType.DISPENSER, "Receita");
				ItemStack ender = new ItemStack(Material.ENDER_PEARL);
				ItemStack la = new ItemStack(Material.WOOL);
				ItemStack slime = new ItemStack(Material.SLIME_BALL);
				ItemStack olho = new ItemStack(Material.SPIDER_EYE);
				ItemStack magma = new ItemStack(Material.MAGMA_CREAM);
				ItemStack pena = new ItemStack(Material.FEATHER);
				
				menu.setItem(0, ender);
				menu.setItem(1, la);
				menu.setItem(2, ender);
				menu.setItem(3, slime);
				menu.setItem(4, olho);
				menu.setItem(5, magma);
				menu.setItem(6, ender);
				menu.setItem(7, pena);
				menu.setItem(8, ender);
				
				p.openInventory(menu);
			}
			}
		}
		return false;
	}

}
