package me.ninjay.ninjarankup.estruturas.rank;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjarankup.utils.Storable;

public class Rank implements Storable{
	
	private String nome;
	private String tag;
	private Integer id;
	private String perm;
	private String grupo;
	private ArrayList<String> comando;
	private ArrayList<ItemStack> itens;
	private double valor;
	private ItemStack icone;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ItemStack getIcone() {
		return icone;
	}
	public void setIcone(ItemStack icone) {
		this.icone = icone;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getPerm() {
		return perm;
	}
	public void setPerm(String perm) {
		this.perm = perm;
	}
	public ArrayList<String> getComando() {
		return comando;
	}
	public void setComando(ArrayList<String> comando) {
		this.comando = comando;
	}
	public ArrayList<ItemStack> getItens() {
		return itens;
	}
	public void setItens(ArrayList<ItemStack> itens) {
		this.itens = itens;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
}
