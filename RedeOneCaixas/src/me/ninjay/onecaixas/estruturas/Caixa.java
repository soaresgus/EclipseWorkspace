package me.ninjay.onecaixas.estruturas;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

import me.ninjay.utils.utils.Storable;


public class Caixa implements Storable{
	
	private String nome;
	private ItemStack icone;
	private ArrayList<ItemRandom> prize;
	private int valor;
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
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public ArrayList<ItemRandom> getPrize() {
		return prize;
	}
	public void setPrize(ArrayList<ItemRandom> prize) {
		this.prize = prize;
	}
	

}
