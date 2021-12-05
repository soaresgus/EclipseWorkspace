package me.ninjay.oneperfil.almas.estruturas;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.oneperfil.main.Main;
import net.eduard.api.lib.BukkitConfig;

public class EstruturaAdmin {
	public static void almasAdmSet(Player p, Player jogador, Long quantidade, BukkitConfig config) {
		if (quantidade == 0) {
			p.sendMessage("§6Você setou a quantidade de almas de §e" + jogador.getName() + " §6para §e0§6.");
			jogador.sendMessage("§6Sua quantidade de almas foi setada para §e0 §6por §e" + p.getName() + "§6.");
			AlmasAPI.setAlmas(jogador, config, (long) 0);
			return;
		}
		if (quantidade == 1) {
			p.sendMessage("§6Você setou a quantidade de alma de §e" + jogador.getName() + " §6para §e1§6.");
			jogador.sendMessage("§6Sua quantidade de alma foi setada para §e1 §6por §e" + p.getName() + "§6.");
			AlmasAPI.setAlmas(jogador, config, (long) 1);
			return;
		}
		if (quantidade >= 2) {
			p.sendMessage(
					"§6Você setou a quantidade de almas de §e" + jogador.getName() + " §6para §e" + quantidade + "§6.");
			jogador.sendMessage(
					"§6Sua quantidade de alma foi setada para §e" + quantidade + " §6por §e" + p.getName() + "§6.");
			AlmasAPI.setAlmas(jogador, config, (long) quantidade);
			return;
		}
	}

	public static void almasAdmAdd(Player p, Player jogador, Long quantidade, BukkitConfig config) {
		if (quantidade == 0) {
			p.sendMessage("§6Você adicionou 0 almas para §e" + jogador.getName() + "§6.");
			jogador.sendMessage("§6Sua quantidade de almas foi adicionada §e0 §6por §e" + p.getName() + "§6.");
			AlmasAPI.addAlmas(jogador, config, (long) AlmasAPI.getAlmas(p, Main.almas)+0);
			return;
		}
		if (quantidade == 1) {
			p.sendMessage("§6Você adicionou 1 alma para §e" + jogador.getName() + "§6.");
			jogador.sendMessage("§6Sua quantidade de alma foi adicionada §e1 §6por §e" + p.getName() + "§6.");
			AlmasAPI.setAlmas(jogador, config, (long) AlmasAPI.getAlmas(p, Main.almas)+1);
			return;
		}
		if (quantidade >= 2) {
			p.sendMessage("§6Você adicionou " + quantidade + " almas para §e" + jogador.getName() + "§6.");
			jogador.sendMessage(
					"§6Sua quantidade de almas foi adicionada §e" + quantidade + " §6por §e" + p.getName() + "§6.");
			AlmasAPI.setAlmas(jogador, config, (long) AlmasAPI.getAlmas(p, Main.almas)+quantidade);
			return;
		}
	}

	public static void almasAdmRemove(Player p, Player jogador, Long quantidade, BukkitConfig config) {
		if (quantidade > AlmasAPI.getAlmas(jogador, config)) {
			p.sendMessage(
					"§cQuantidade inválida. Tente um valor menor ou igual a " + AlmasAPI.getAlmas(jogador, config)+".");
			return;
		}
		if (quantidade == 1) {
			p.sendMessage("§6Você removeu §e1 §6alma de §e" + jogador.getName() + "§6.");
			jogador.sendMessage("§e" + p.getName() + " §6removeu §e1 §6alma do seu saldo.");
			AlmasAPI.removeAlmas(jogador, config, (long) 1);
			return;
		}
		if (quantidade == 0) {
			p.sendMessage("§6Você removeu §e0 §6almas de §e" + jogador.getName() + "§6.");
			jogador.sendMessage("§e" + p.getName() + " §6removeu §e0 §6almas do seu saldo.");
			AlmasAPI.removeAlmas(jogador, config, (long) 0);
			return;
		}
		if (quantidade <= AlmasAPI.getAlmas(jogador, config)) {
			p.sendMessage("§6Você removeu §e"+quantidade+" §6almas de §e"+jogador.getName()+"§6.");
			jogador.sendMessage("§e"+p.getName()+" §6removeu §e"+quantidade+" §6do seu saldo.");
			AlmasAPI.removeAlmas(jogador, config, (long) quantidade);
		}
	}
	public static void almasHelp(Player p) {
		p.sendMessage("§6§lAlmas - Comandos\n \n§6/almas §eVeja o seu saldo de almas.\n§6/almas saldo <nick> §eVeja o saldo de almas de outro jogador.\n§6/almas mercado §eCompre itens com suas almas.\n§6/almas set <nick> <quantidade> §eSete a quantidade de almas do jogador.\n§6/almas add <nick> <quantidade> §eAdicione uma quantidade de almas para o jogador.\n§6/almas remove <nick> <quantidade> §eRemove uma quantidade de almas de um jogador.\n§6/almas setmercado §eSpawne o NPC de mercado de almas.\n§6/almas setmercadospawn §eSete o spawn do local no qual ira ficar o NPC.\n§6/almas matarnpc §eMate o NPC do mercado de almas. ");
	}
	public static void setMercadoNPC(Player p) {
		Villager mercado = p.getWorld().spawn(p.getLocation(), Villager.class);
		mercado.setAdult();
		mercado.setProfession(Profession.BUTCHER);
		mercado.setCustomName("§eMercado de Almas");
		mercado.setCustomNameVisible(true);
		Mine.disableAI(mercado);
		p.sendMessage("§6Mercado de Almas [NPC] setado.");
	}
	public static void setMercadoSpawn(Player p, BukkitConfig config) {
		p.sendMessage("§6Mercado de Almas [SPAWN] setado.");
		config.set("almas_spawn", p.getLocation());
		config.saveConfig();
	}
    public static void matarNPC(Player p) {
    	p.sendMessage("§6Você recebeu uma varinha, hite com ela no NPC para mata-lo.");
    	ItemStack vara = Mine.newItem(Material.CARROT_STICK, "§eMatar NPC",1,0," ","§e§lMatar NPC","§e Hite o NPC com a varinha para mata-lo.");
    	ItemMeta varam = vara.getItemMeta();
    	varam.addEnchant(Enchantment.DURABILITY, 5, false);
    	vara.setItemMeta(varam);
    	p.getInventory().addItem(vara);
    }

}
