package me.ninjay.kustcaixas.estruturas;

import org.bukkit.inventory.ItemStack;

import me.ninjay.utils.utils.Storable;

public class Caixa implements Storable{
	
	private String name;
	private String nome;
	private ItemStack icone;
	private ItemStack iconeLoja1;
	private ItemStack iconeLoja5;
	private ItemStack iconeLoja10;
	private ItemStack iconeLoja25;
	private Integer slotLoja;
	private Integer preco1;
	private Integer preco5;
	private Integer preco10;
	private Integer preco25;
	
	
	
	public ItemStack getIconeLoja1() {
		return iconeLoja1;
	}
	public void setIconeLoja1(ItemStack iconeLoja1) {
		this.iconeLoja1 = iconeLoja1;
	}
	public ItemStack getIconeLoja5() {
		return iconeLoja5;
	}
	public void setIconeLoja5(ItemStack iconeLoja5) {
		this.iconeLoja5 = iconeLoja5;
	}
	public ItemStack getIconeLoja10() {
		return iconeLoja10;
	}
	public void setIconeLoja10(ItemStack iconeLoja10) {
		this.iconeLoja10 = iconeLoja10;
	}
	public ItemStack getIconeLoja25() {
		return iconeLoja25;
	}
	public void setIconeLoja25(ItemStack iconeLoja25) {
		this.iconeLoja25 = iconeLoja25;
	}
	public Integer getSlotLoja() {
		return slotLoja;
	}
	public void setSlotLoja(Integer slotLoja) {
		this.slotLoja = slotLoja;
	}
	public Integer getPreco1() {
		return preco1;
	}
	public void setPreco1(Integer preco1) {
		this.preco1 = preco1;
	}
	public Integer getPreco5() {
		return preco5;
	}
	public void setPreco5(Integer preco5) {
		this.preco5 = preco5;
	}
	public Integer getPreco10() {
		return preco10;
	}
	public void setPreco10(Integer preco10) {
		this.preco10 = preco10;
	}
	public Integer getPreco25() {
		return preco25;
	}
	public void setPreco25(Integer preco25) {
		this.preco25 = preco25;
	}
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
	public ItemStack getIcone() {
		return icone;
	}
	public void setIcone(ItemStack icone) {
		this.icone = icone;
	}

}
