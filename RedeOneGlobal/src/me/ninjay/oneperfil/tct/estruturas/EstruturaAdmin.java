package me.ninjay.oneperfil.tct.estruturas;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.ninjay.oneperfil.main.Main;


public class EstruturaAdmin {

	public static void ajudastf(Player p) {
		p.sendMessage(
				"§6§lTcT Comandos\n \n§6/tct entrar §eEntre no evento.\n§6/tct iniciar §eInicie o evento.\n§6/tct setspawn §eSeta o spawn do evento.\n§6/tct setjogo §eSeta o local onde irá ocorrer o evento.\n§6/tct setmorte §eSeta o local no qual o jogador irá nascer se morrer no evento.\n§6/tct setganhador <nick> §eSeta o vencedor do evento.\n ");
	}

	public static void iniciar(Player p) {
		Main.tempo2 = EstruturaTempo2.PRE2;
		Bukkit.broadcastMessage(
				"§6§lEvento - Todos Contra Todos\n \n§6Iniciando em: 3 minutos\n \n§6Lute contra todos, o ultimo a sobreviver ganha o evento !\n \n§6Para entrar utilize §e§l/tct entrar.");
	}

	public static void setspawn(Player p) {
		p.sendMessage("§6Local de spawn do evento setado.");
		Main.tct.set("spawn_tct", p.getLocation());
		Main.tct.saveConfig();
	}

	public static void setjogo(Player p) {
		p.sendMessage("§6Local de jogo do evento setado.");
		Main.tct.set("jogo_tct", p.getLocation());
		Main.tct.saveConfig();

	}

	public static void setmorte(Player p) {
		p.sendMessage("§6Local de morte do evento setado.");
		Main.tct.set("morte_tct", p.getLocation());
		Main.tct.saveConfig();
	}

}
