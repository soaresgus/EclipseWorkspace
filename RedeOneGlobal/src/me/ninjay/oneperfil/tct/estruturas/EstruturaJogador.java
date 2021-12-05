package me.ninjay.oneperfil.tct.estruturas;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.oneperfil.main.Main;
import net.eduard.api.lib.modules.VaultAPI;

public class EstruturaJogador {

	public static void entrar(Player p) {
		p.sendMessage(
				"§6Você entrou no evento TcT.\n \nLute contra todos para ganhar o evento e no fim o ultimo que sobreviver ganha o evento !");
		Main.dentro2.add(p);
		p.teleport(Main.tct.getLocation("spawn_tct"));
		VaultAPI.getPermission().playerAdd(p, "tct.jogando");
	}

	public static void ajudajog(Player p) {
		p.sendMessage("§6§lTcT Comandos\n \n§6/tct entrar §eEntre no evento.");
	}

	public static void inicio(Player p) {
		Main.tempo2 = EstruturaTempo2.JOGO2;
		p.getInventory().addItem(Mine.newItem(Material.STONE, "§6sla véi"));
		p.teleport(Main.tct.getLocation("jogo_tct"));

	}

	public static void morrer(Player p) {
		p.sendMessage("§6Você morreu :(");
		new BukkitRunnable() {

			@Override
			public void run() {
				p.teleport(Main.tct.getLocation("morte_tct"));
			}
		}.runTaskLater(Main.getPlugin(Main.class), 2);
	}

}