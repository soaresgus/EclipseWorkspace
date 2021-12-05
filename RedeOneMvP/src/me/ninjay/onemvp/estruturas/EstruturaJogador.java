package me.ninjay.onemvp.estruturas;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.onemvp.main.Main;
import net.eduard.api.lib.BukkitConfig;
import net.eduard.api.lib.modules.VaultAPI;

public class EstruturaJogador {

	public static void ajudajog(Player p) {
		p.sendMessage("§e§lMvP Comandos\n \n§e§l/mvp entrar §eEntre no evento.");
	}

	public static void entrar(Player p) {
		BukkitConfig mvp = Main.mvp;
		VaultAPI.getPermission().playerAdd(p, "mvp.jogando");
		VaultAPI.getPermission().playerAdd(p, "mvp.pvp");
		p.teleport(mvp.getLocation("spawn_mvp"));
		
		p.sendMessage(
				"§eVocê entrou no evento MvP.\n \nLute contra mobs para ganhar coins e no fim mate o gigante. Quem conseguir matar o gigante ganha o evento !");
	}

	public static void inicio(Player p) {
		BukkitConfig mvp = Main.mvp;
		Main.tempo = EstruturaTempo.JOGO;
		p.teleport(mvp.getLocation("jogo_mvp"));

	}

	public static void morrer(Player p) {
		p.sendMessage("§eVocê morreu :(");
		BukkitConfig mvp = Main.mvp;
		new BukkitRunnable() {

			@Override
			public void run() {
				p.teleport(mvp.getLocation("morte_mvp"));
			}
		}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 2);
	}

}
