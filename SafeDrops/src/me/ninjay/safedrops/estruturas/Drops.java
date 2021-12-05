package me.ninjay.safedrops.estruturas;

import java.util.ArrayList;

import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import me.ninjay.utils.utils.Storable;

public class Drops implements Storable{

	private EntityType mob;
	private ArrayList<ItemStack> drops;
	private Integer looting;
	private Integer amount;
	private Integer dropbonus;
	private ItemStack itembonus;
	private Double chanceItemBonus;
	
	public EntityType getMob() {
		return mob;
	}
	public void setMob(EntityType mob) {
		this.mob = mob;
	}
	public ArrayList<ItemStack> getDrops() {
		return drops;
	}
	public void setDrops(ArrayList<ItemStack> drops) {
		this.drops = drops;
	}
	public Integer getLooting() {
		return looting;
	}
	public void setLooting(Integer looting) {
		this.looting = looting;
	}
	public Integer getDropbonus() {
		return dropbonus;
	}
	public void setDropbonus(Integer dropbonus) {
		this.dropbonus = dropbonus;
	}
	public ItemStack getItembonus() {
		return itembonus;
	}
	public void setItembonus(ItemStack itembonus) {
		this.itembonus = itembonus;
	}
	public Double getChanceItemBonus() {
		return chanceItemBonus;
	}
	public void setChanceItemBonus(Double chanceItemBonus) {
		this.chanceItemBonus = chanceItemBonus;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
