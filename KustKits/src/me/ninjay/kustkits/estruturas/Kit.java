package me.ninjay.kustkits.estruturas;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

import me.ninjay.utils.utils.Storable;


public class Kit implements Storable{
	
	private String name;
	private String nome;
	private ArrayList<ItemStack> itens;
	private ItemStack icone;
	private boolean iniciante;
	private int cooldown;
	private Integer slot;
	private Integer id;
	private boolean vip;
	private String perm;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<ItemStack> getItens() {
		return itens;
	}
	public void setItens(ArrayList<ItemStack> itens) {
		this.itens = itens;
	}
	public ItemStack getIcone() {
		return icone;
	}
	public void setIcone(ItemStack icone) {
		this.icone = icone;
	}
	public boolean isIniciante() {
		return iniciante;
	}
	public void setIniciante(boolean iniciante) {
		this.iniciante = iniciante;
	}
	public Integer getSlot() {
		return slot;
	}
	public void setSlot(Integer slot) {
		this.slot = slot;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isVip() {
		return vip;
	}
	public void setVip(boolean vip) {
		this.vip = vip;
	}
	public String getPerm() {
		return perm;
	}
	public void setPerm(String perm) {
		this.perm = perm;
	}
	public int getCooldown() {
		return cooldown;
	}
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	

	
	
	
}
