package me.ninjay.safeclub.estruturas.api.recompensa;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.safeclub.estruturas.api.caixa.CaixaAPI;
import me.ninjay.safeclub.utils.BukkitConfig;
import me.ninjay.safeclub.utils.Mine;

public class RecompensaAPI{
	
	public static ItemStack caixa = Mine.newItem(Material.STORAGE_MINECART, "§eClique aqui para coletar");
	
	public static void coletar(Player p, BukkitConfig config) {
		if(config.contains("Cooldown."+p.getName())) {
			long tempo = config.getLong("Cooldown."+p.getName());
			long resultado = Mine.getCooldown(tempo, 86400);
			if(Mine.inCooldown(tempo, 86400)) {
				p.sendMessage("§cAguarde "+Mine.formatTime(resultado)+" para pegar sua recompensa novamente.");
				p.getOpenInventory().close();
				return;
			}
		}
		//p.sendmessage("vc entrou no cooldown");
		p.getOpenInventory().close();
		config.set("Cooldown."+p.getName(), System.currentTimeMillis());
		config.saveConfig();
		p.getInventory().addItem(CaixaAPI.manager.getCaixaInt(1).getIcone()); 
	}
	
	public static void avisar(Player p, BukkitConfig config) {
		if(!config.contains("Cooldown."+p.getName())) {
			Mine.sendTitle(p, "§e§lRecompensa", "§eLeia o chat para mais informações.", 20, 100, 20);
			p.sendMessage("\n \n§e§lRecompensa Diária\n \n§eVocê possui uma recompensa diaria\npronta para ser coletada.\nUtilize §6/recompensa §epara coletar.\n ");
		}else {
			return;
		}
	}

	public static void abrir(Player p, BukkitConfig config) {
		Inventory inv = Mine.newInventory("Recompensa Diaria", 9*3);
		inv.setItem(Mine.getPosition(2, 5), caixa);
		p.openInventory(inv);
	}
}
