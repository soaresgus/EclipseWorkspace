package me.ninjay.curso.caixa;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.storage.Storable;

public class Caixa implements Storable{
	
	private ItemStack icone;
	private String name;
	private ArrayList<ItemStack> premios;
	public ItemStack getIcone() {
		return icone;
	}
	public void setIcone(ItemStack icone) {
		this.icone = icone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<ItemStack> getPremios() {
		return premios;
	}
	public void setPremios(ArrayList<ItemStack> premios) {
		this.premios = premios;
	}

}
