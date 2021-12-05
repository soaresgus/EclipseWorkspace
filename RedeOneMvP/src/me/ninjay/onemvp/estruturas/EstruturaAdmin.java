package me.ninjay.onemvp.estruturas;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.ninjay.onemvp.main.Main;

public class EstruturaAdmin {
	
	public static void ajudastf(Player p ) {
		p.sendMessage("�e�lMvP Comandos\n \n�e�l/mvp entrar �eEntre no evento.\n \n�e�l/mvp iniciar �eInicie o evento.\n \n�e�l/mvp setspawn �eSeta o spawn do evento.\n \n�e�l/mvp setjogo �eSeta o local onde ir� ocorrer o evento.\n \n�e�l/mvp setmorte �eSeta o local no qual o jogador ir� nascer se morrer no evento.\n \n�e�l/mvp setmob<1/2/3> �eSeta os locais aonde ir� spawnar os mobs.");
	}
    
	public static void iniciar(Player p) {
		Main.tempo = EstruturaTempo.PRE;
		Bukkit.broadcastMessage("�e�lEvento - Mobs Vs Players\n \n�eIniciando em: 3 minutos\n \n�eInfo: Mate mobs para ganhar coins e no fim mate o gigante para ganhar o evento.\n \n�ePara entrar utilize /mvp entrar.");
		
	}
	public static void setspawn(Player p) {
		p.sendMessage("�eSpawn do evento setado !");
		Main.mvp.set("spawn_mvp", p.getLocation());
		Main.mvp.saveConfig();
	}
	
	public static void setjogo(Player p ) {
		p.sendMessage("�eLocal de jogo do evento setado !");
		Main.mvp.set("jogo_mvp", p.getLocation());
		Main.mvp.saveConfig();
	}
	
	public static void setmorte(Player p) {
		p.sendMessage("�eLocal de morte de evento setado !");
		Main.mvp.set("morte_mvp", p.getLocation());
		Main.mvp.saveConfig();
	}
	
	public static void setmob1(Player p) {
		p.sendMessage("�eLocal de mob 1 do evento setado !");
		Main.mvp.set("mob1_mvp", p.getLocation());
		Main.mvp.saveConfig();
	}
	
	public static void setmob2(Player p) {
		p.sendMessage("�eLocal de mob 2 do evento setado !");
		Main.mvp.set("mob2_mvp", p.getLocation());
		Main.mvp.saveConfig();
	}
	
	public static void setmob3(Player p) {
		p.sendMessage("�eLocal de mob 3 do evento setado !");
		Main.mvp.set("mob3_mvp", p.getLocation());
		Main.mvp.saveConfig();
	}
	
	
}
