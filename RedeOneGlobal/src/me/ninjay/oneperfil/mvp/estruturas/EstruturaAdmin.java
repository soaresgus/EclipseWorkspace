package me.ninjay.oneperfil.mvp.estruturas;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.ninjay.oneperfil.main.Main;


public class EstruturaAdmin {
	
	public static void ajudastf(Player p ) {
		p.sendMessage("§6§lMvP Comandos\n \n§6/mvp entrar §eEntre no evento.\n§6/mvp iniciar §eInicie o evento.\n§6/mvp setspawn §eSeta o spawn do evento.\n§6/mvp setjogo §eSeta o local onde irá ocorrer o evento.\n§6/mvp setmorte §eSeta o local no qual o jogador irá nascer se morrer no evento.\n§6/mvp setmob<1/2/3> §eSeta os locais onde nasce os mobs.\n§6/mvp setganhador <nick>\n ");
	}
    
	public static void iniciar(Player p) {
		Main.tempo = EstruturaTempo.PRE;
		Bukkit.broadcastMessage("§6§lEvento - Mobs Vs Players\n \n§6Iniciando em: 3 minutos\n \n§6Info: Mate mobs para ganhar coins e no fim mate o gigante para ganhar o evento.\n \n§6Para entrar utilize §e/mvp entrar.");
		
	}
	public static void setspawn(Player p) {
		p.sendMessage("§6Spawn do evento setado !");
		Main.mvp.set("spawn_mvp", p.getLocation());
		Main.mvp.saveConfig();
	}
	
	public static void setjogo(Player p ) {
		p.sendMessage("§6Local de jogo do evento setado !");
		Main.mvp.set("jogo_mvp", p.getLocation());
		Main.mvp.saveConfig();
	}
	
	public static void setmorte(Player p) {
		p.sendMessage("§6Local de morte de evento setado !");
		Main.mvp.set("morte_mvp", p.getLocation());
		Main.mvp.saveConfig();
	}
	
	public static void setmob1(Player p) {
		p.sendMessage("§6Local de mob 1 do evento setado !");
		Main.mvp.set("mob1_mvp", p.getLocation());
		Main.mvp.saveConfig();
	}
	
	public static void setmob2(Player p) {
		p.sendMessage("§6Local de mob 2 do evento setado !");
		Main.mvp.set("mob2_mvp", p.getLocation());
		Main.mvp.saveConfig();
	}
	
	public static void setmob3(Player p) {
		p.sendMessage("§6Local de mob 3 do evento setado !");
		Main.mvp.set("mob3_mvp", p.getLocation());
		Main.mvp.saveConfig();
	}
	
	
}
