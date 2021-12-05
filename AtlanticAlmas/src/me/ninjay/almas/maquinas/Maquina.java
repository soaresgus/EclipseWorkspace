package me.ninjay.almas.maquinas;


import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.storage.Storable;

public class Maquina implements Storable{
	
	private ItemStack icone;
	private String name;
	private ItemStack drop;
	private String valor;
	private String dono;
	private Double almas;
	public void setIcone(ItemStack icone) { //
		this.icone = icone;
	}
	public String getName() { //
		return name;
	}
	public void setName(String name) { //
		this.name = name;
	}
	
	public ItemStack getIcone() {
		return icone;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDono() {
		return dono;
	}
	public void setDono(String dono) {
		this.dono = dono;
	}
	public ItemStack getDrop() {
		return drop;
	}
	public void setDrop(ItemStack drop) {
		this.drop = drop;
	}
	public Double getAlmas() {
		return almas;
	}
	public void setAlmas(Double almas) {
		this.almas = almas;
	}


	}
	
		

