package com.b_homes.objetos;

import org.bukkit.Location;

public class Home {

	private String jogador;
	private Location loc;
	private String nome;
	public Home(String jogador, Location loc, String nome) {
		this.jogador = jogador;
		this.loc = loc;
		this.nome = nome;
	}
	public String getJogador() {
		return jogador;
	}
	public void setJogador(String jogador) {
		this.jogador = jogador;
	}
	public Location getLoc() {
		return loc;
	}
	public void setLoc(Location loc) {
		this.loc = loc;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
