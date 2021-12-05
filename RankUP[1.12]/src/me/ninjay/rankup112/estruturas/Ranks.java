package me.ninjay.rankup112.estruturas;

import org.bukkit.inventory.ItemStack;

import me.ninjay.rankup112.utils.Storable;


public class Ranks implements Storable{
	
	private String nome;
	private ItemStack icon;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ItemStack getIcon() {
		return icon;
	}
	public void setIcon(ItemStack icon) {
		this.icon = icon;
	}
	
	

}
