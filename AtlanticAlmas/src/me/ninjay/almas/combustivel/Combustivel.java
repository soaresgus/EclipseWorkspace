package me.ninjay.almas.combustivel;

import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.storage.Storable;

public class Combustivel implements Storable{
	
	private ItemStack icone;
	private String nome;
	private Double bloco; 
	
	public ItemStack getIcone() {
		return icone;
	}
	public void setIcone(ItemStack icone) {
		this.icone = icone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getBloco() {
		return bloco;
	}
	public void setBloco(Double bloco) {
		this.bloco = bloco;
	}
	

}
