package me.ninjay.saferankup.estruturas;

import org.bukkit.inventory.ItemStack;

import me.ninjay.utils.utils.Storable;

public class Rank implements Storable{
	
	private String name;
	private Integer id;
	private ItemStack iconRanks;
	private ItemStack icon;
	private Integer fileiraRanks;
	private Integer slotRanks;
	private Double valor;
	private Integer fileirasInvRanks;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ItemStack getIconRanks() {
		return iconRanks;
	}
	public void setIconRanks(ItemStack iconRanks) {
		this.iconRanks = iconRanks;
	}
	
	public Integer getFileiraRanks() {
		return fileiraRanks;
	}
	public void setFileiraRanks(Integer fileiraRanks) {
		this.fileiraRanks = fileiraRanks;
	}
	public Integer getSlotRanks() {
		return slotRanks;
	}
	public void setSlotRanks(Integer slotRanks) {
		this.slotRanks = slotRanks;
	}
	public ItemStack getIcon() {
		return icon;
	}
	public void setIcon(ItemStack icon) {
		this.icon = icon;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getFileirasInvRanks() {
		return fileirasInvRanks;
	}
	public void setFileirasInvRanks(Integer fileirasInvRanks) {
		this.fileirasInvRanks = fileirasInvRanks;
	}

}
