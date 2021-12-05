package me.ninjay.megataymaquinas.estruturas;

import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.storage.Storable;

public class Refinaria implements Storable{
	
	private String nome;
	private ItemStack icone;
	private ItemStack combustivel;
	private ItemStack essencia;
	private Integer numero;
	private Integer price;
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
	public ItemStack getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(ItemStack combustivel) {
		this.combustivel = combustivel;
	}
	public ItemStack getEssencia() {
		return essencia;
	}
	public void setEssencia(ItemStack essencia) {
		this.essencia = essencia;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	

}
