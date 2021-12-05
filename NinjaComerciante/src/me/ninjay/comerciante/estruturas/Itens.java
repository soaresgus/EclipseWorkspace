package me.ninjay.comerciante.estruturas;

import org.bukkit.inventory.ItemStack;

import me.ninjay.utils.utils.Storable;


public class Itens implements Storable{
	
	private Integer id;
	private Boolean ativado;
	private ItemStack item;
	private ItemStack icone;
	private Integer quantia;
	private Double valor;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ItemStack getItem() {
		return item;
	}
	public void setItem(ItemStack item) {
		this.item = item;
	}
	public Integer getQuantia() {
		return quantia;
	}
	public void setQuantia(Integer quantia) {
		this.quantia = quantia;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Boolean getAtivado() {
		return ativado;
	}
	public void setAtivado(Boolean ativado) {
		this.ativado = ativado;
	}
	public ItemStack getIcone() {
		return icone;
	}
	public void setIcone(ItemStack icone) {
		this.icone = icone;
	}
	

}
