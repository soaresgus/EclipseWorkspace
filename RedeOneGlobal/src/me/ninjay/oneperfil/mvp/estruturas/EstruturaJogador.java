package me.ninjay.oneperfil.mvp.estruturas;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.oneperfil.main.Main;
import net.eduard.api.lib.BukkitConfig;
import net.eduard.api.lib.modules.VaultAPI;

public class EstruturaJogador {

	public static void ajudajog(Player p) {
		p.sendMessage("§6§lMvP Comandos\n \n§6/mvp entrar §eEntre no evento.");
	}

	public static void entrar(Player p) {
		BukkitConfig mvp = Main.mvp;
		VaultAPI.getPermission().playerAdd(p, "mvp.jogando");
		VaultAPI.getPermission().playerAdd(p, "mvp.pvp");
		p.teleport(mvp.getLocation("spawn_mvp"));
		
		p.sendMessage(
				"§6Você entrou no evento MvP.\n \nLute contra mobs para ganhar coins e no fim mate o gigante. Quem conseguir matar o gigante ganha o evento !");
	}

	public static void inicio(Player p) {
		BukkitConfig mvp = Main.mvp;
		Main.tempo = EstruturaTempo.JOGO;
		p.teleport(mvp.getLocation("jogo_mvp"));

	}

	public static void morrer(Player p) {
		p.sendMessage("§6Você morreu :(");
		BukkitConfig mvp = Main.mvp;
		new BukkitRunnable() {

			@Override
			public void run() {
				p.teleport(mvp.getLocation("morte_mvp"));
			}
		}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 2);
	}

}
