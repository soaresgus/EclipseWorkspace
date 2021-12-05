package me.ninjay.aurealobby;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

import me.ninjay.ninjaapi.utils.Mine;

public class EventosEntrar implements Listener {

	@EventHandler
	public void entrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		ItemStack bus = new ItemStack(Material.COMPASS);
		ItemMeta busm = bus.getItemMeta();
		busm.setDisplayName("§eServidores");
		busm.setLore(Arrays.asList(" ", "§e§lBússola de navegação",
				" §7Utilize essa bússola para entrar em nossos servidores"));
		bus.setItemMeta(busm);

		ItemStack sem = new ItemStack(Material.INK_SACK, 1, (short) 1);
		ItemMeta semm = sem.getItemMeta();
		semm.setDisplayName("§cNenhum gadget selecionado");
		semm.setLore(Arrays.asList(" ", "§cPara selecionar um gadget clique no item §eGadgets"));
		sem.setItemMeta(semm);

		ItemStack menu = new ItemStack(Material.NAME_TAG);
		ItemMeta menum = menu.getItemMeta();
		menum.setDisplayName("§eGadgets");
		menum.setLore(Arrays.asList(" ", "§7Utilize para se divertir dentro do lobby"));
		menu.setItemMeta(menum);

		Mine.setTabList(p,
				" \n§6§lREDE AUREA\n§f  jogar.rede-aurea.com\n \n§fJogadores online: §e"
						+ Bukkit.getOnlinePlayers().size() + "\n ",
				"\n §fSite: §eredeaurea.com\n§fFórum: §eEm breve\n§fTwitter: §e@RedeAurea\n ");

		SimplesScore.setScore(p);
		e.setJoinMessage(null);
		p.removePotionEffect(PotionEffectType.SPEED);

		p.getInventory().clear();
		p.teleport(Main.config.getLocation("spawn"));

		p.updateInventory();
		p.getInventory().setItem(4, bus);
		p.getInventory().setItem(2, sem);
		p.getInventory().setItem(6, menu);
		p.setFoodLevel(999999999);
		Main.permission.playerAdd(p, "anti.drop");

		p.setMaxHealth(20);
		if (p.hasPermission("galaxy.tag") || p.hasPermission("meteor.tag") || p.hasPermission("moon.tag")) {
			Bukkit.broadcastMessage("§e[VIP] " + p.getName() + " §6entrou no lobby");
		
			return;

		}
		if (p.hasPermission("master.tag") || p.hasPermission("gerente.tag") || p.hasPermission("admin.tag")
				|| p.hasPermission("moderador.tag") || p.hasPermission("ajudante.tag")
				|| p.hasPermission("construtor.tag") || p.hasPermission("youtuber.tag") || p.hasPermission("galaxy.tag")
				|| p.hasPermission("meteor.tag") || p.hasPermission("moon.tag") || p.hasPermission("membro.tag")) {
			return;
		}
		if (!p.hasPermission("master.tag") || !p.hasPermission("gerente.tag") || !p.hasPermission("admin.tag")
				|| !p.hasPermission("moderador.tag") || !p.hasPermission("ajudante.tag")
				|| !p.hasPermission("construtor.tag") || !p.hasPermission("youtuber.tag")
				|| !p.hasPermission("galaxy.tag") || !p.hasPermission("meteor.tag") || !p.hasPermission("moon.tag")
				|| !p.hasPermission("membro.tag")) {
			Main.permission.playerRemove(p, "membro.tag");
			Main.permission.playerAdd(p, "membro.tag");
			Main.permission.playerRemove(p, "moon.tag");
			Main.permission.playerRemove(p, "meteor.tag");
			Main.permission.playerRemove(p, "galaxy.tag");
			Main.permission.playerRemove(p, "youtuber.tag");
			Main.permission.playerRemove(p, "construtor.tag");
			Main.permission.playerRemove(p, "ajudante.tag");
			Main.permission.playerRemove(p, "moderador.tag");
			Main.permission.playerRemove(p, "admin.tag");
			Main.permission.playerRemove(p, "gerente.tag");
			Main.permission.playerRemove(p, "master.tag");

		}
	}
}
