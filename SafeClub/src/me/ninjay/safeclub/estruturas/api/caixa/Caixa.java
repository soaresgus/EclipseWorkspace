package me.ninjay.safeclub.estruturas.api.caixa;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

import me.ninjay.safeclub.utils.Storable;


public class Caixa implements Storable{
	
	private ItemStack icone;
	private String nome;
	private int number;
	private ArrayList<ItemStack> itens;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public ArrayList<ItemStack> getItens() {
		return itens;
	}
	public void setItens(ArrayList<ItemStack> itens) {
		this.itens = itens;
	}

}
