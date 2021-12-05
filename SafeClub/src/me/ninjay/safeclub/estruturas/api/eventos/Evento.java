package me.ninjay.safeclub.estruturas.api.eventos;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import me.ninjay.safeclub.utils.Storable;

public class Evento implements Storable{
	
	private String nome;
	private int number;
	private Location pre;
	private Location jogo;
	private Location morte;
	private Location spawn;
	private ArrayList<ItemStack> itens;
	private int valor;
	private String comando;
	private String comoJogar;
	private int inv;
	private boolean tpAll;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Location getPre() {
		return pre;
	}
	public void setPre(Location pre) {
		this.pre = pre;
	}
	public Location getJogo() {
		return jogo;
	}
	public void setJogo(Location jogo) {
		this.jogo = jogo;
	}
	public Location getMorte() {
		return morte;
	}
	public void setMorte(Location morte) {
		this.morte = morte;
	}
	public ArrayList<ItemStack> getItens() {
		return itens;
	}
	public void setItens(ArrayList<ItemStack> itens) {
		this.itens = itens;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getComando() {
		return comando;
	}
	public void setComando(String comando) {
		this.comando = comando;
	}
	public String getComoJogar() {
		return comoJogar;
	}
	public void setComoJogar(String comoJogar) {
		this.comoJogar = comoJogar;
	}
	public int getInv() {
		return inv;
	}
	public void setInv(int inv) {
		this.inv = inv;
	}
	public Location getSpawn() {
		return spawn;
	}
	public void setSpawn(Location spawn) {
		this.spawn = spawn;
	}
	public boolean isTpAll() {
		return tpAll;
	}
	public void setTpAll(boolean tpAll) {
		this.tpAll = tpAll;
	}

}
