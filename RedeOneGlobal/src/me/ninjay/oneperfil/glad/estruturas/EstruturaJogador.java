package me.ninjay.oneperfil.glad.estruturas;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.oneperfil.main.Main;
import net.eduard.api.lib.modules.VaultAPI;

public class EstruturaJogador {

	public static void entrar(Player p) {
		p.sendMessage(
				"§6Você entrou no evento Gladiator.\n \nLute contra todos junto com seu clan para ganhar o evento e no fim o ultimo clan que sobreviver ganha o evento !");
		Main.dentro3.add(p);
		p.teleport(Main.glad.getLocation("spawn_glad"));
		VaultAPI.getPermission().playerAdd(p, "glad.jogando");
		VaultAPI.getPermission().playerAdd(p, "glad.pvp");
	}

	public static void ajudajog(Player p) {
		p.sendMessage("§6§lGladiator Comandos\n \n§6/gladiator entrar §eEntre no evento.");
	}

	public static void inicio(Player p) {
		Main.tempo3 = EstruturaTempo3.JOGO3;

	}

	public static void morrer(Player p) {
		p.sendMessage("§eVocê morreu :(");
		new BukkitRunnable() {

			@Override
			public void run() {
				p.teleport(Main.glad.getLocation("morte_glad"));
			}
		}.runTaskLater(Main.getPlugin(Main.class), 2);
	}

}
	