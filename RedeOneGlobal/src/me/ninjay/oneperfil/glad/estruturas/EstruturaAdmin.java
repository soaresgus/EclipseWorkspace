package me.ninjay.oneperfil.glad.estruturas;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.ninjay.oneperfil.main.Main;

public class EstruturaAdmin {

	public static void ajudastf(Player p) {
		p.sendMessage(
				"§6§lGladiator Comandos\n \n§6/gladiator entrar §eEntre no evento.\n§6/gladiator iniciar §eInicie o evento.\n§6/gladiator setspawn §eSeta o spawn do evento.\n§6/gladiator setjogo §eSeta o local onde irá ocorrer o evento.\n§6/gladiator setmorte §eSeta o local no qual o jogador irá nascer se morrer no evento.\n§6/gladiator setganhador <tag> <clan> <líder>§eSeta o vencedor do evento.\n§6/gladiator removeplayer <nick> §eRemova algum jogador do evento.\n§6/gladiator cancelar §eCancela o evento inteiro sem dar um ganhador.\n ");
	}

	public static void iniciar(Player p) {
		Main.tempo3 = EstruturaTempo3.PRE3;
		Bukkit.broadcastMessage(
				"§6§lEvento - Gladiator\n \n§6Iniciando em: 3 minutos\n \n§6Lute contra todos junto com seu clan, e o ultimo clan a sobreviver ganha o evento !\n \n§6Para entrar utilize §e§l/gladiator entrar.");
	}

	public static void setspawn(Player p) {
		p.sendMessage("§6Local de spawn do evento setado.");
		Main.glad.set("spawn_glad", p.getLocation());
		Main.glad.saveConfig();
	}

	public static void setjogo(Player p) {
		p.sendMessage("§6Local de jogo do evento setado.");
		Main.glad.set("jogo_glad", p.getLocation());
		Main.glad.saveConfig();

	}

	public static void setmorte(Player p) {
		p.sendMessage("§6Local de morte do evento setado.");
		Main.glad.set("morte_glad", p.getLocation());
		Main.glad.saveConfig();
	}

}

	