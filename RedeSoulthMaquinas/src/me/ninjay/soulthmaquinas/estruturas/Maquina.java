package me.ninjay.soulthmaquinas.estruturas;

import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.storage.Storable;

public class Maquina implements Storable{
	
	private String nome;
	private ItemStack icone;
	private ItemStack drop;
	private Double valor;
	private Double valordrop;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ItemStack getIcone() {
		return icone;
	}
	public void setIcone(ItemStack icone) {
		this.icone = icone;
	}
	public ItemStack getDrop() {
		return drop;
	}
	public void setDrop(ItemStack drop) {
		this.drop = drop;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Double getValordrop() {
		return valordrop;
	}
	public void setValordrop(Double valordrop) {
		this.valordrop = valordrop;
	}
	
}
