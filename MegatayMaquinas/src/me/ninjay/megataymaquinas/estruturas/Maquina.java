package me.ninjay.megataymaquinas.estruturas;

import java.util.Map;

import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.storage.Storable;


public class Maquina implements Storable{
	
	private String nome;
	private ItemStack icone;
	private ItemStack drop;
	private Integer price;
	
	@Override
	public Object restore(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void store(Map<String, Object> map, Object object) {
		// TODO Auto-generated method stub

	}

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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
