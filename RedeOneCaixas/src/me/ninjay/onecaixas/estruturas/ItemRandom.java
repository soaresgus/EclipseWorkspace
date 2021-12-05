package me.ninjay.onecaixas.estruturas;

import java.util.Map;

import org.bukkit.inventory.ItemStack;

import me.ninjay.utils.utils.Mine;
import me.ninjay.utils.utils.Storable;


public class ItemRandom implements Storable {

	private int minAmount = 1;

	private int maxAmount = 1;

	private double chance = 1.0;

	private ItemStack item;

	public ItemRandom() {
	}

	public ItemRandom(ItemStack item, int min, int max) {
		this(item, min, max, 1);
	}

	public ItemRandom(ItemStack item, int min) {
		this(item, min, min);
	}

	public ItemRandom(ItemStack item, int min, int max, double chance) {
		setMinAmount(min);
		setMaxAmount(max);
		setChance(chance);
		setItem(item);
	}

	public ItemStack create() {
		ItemStack clone = item.clone();
		int amount = Mine.getRandomInt(getMinAmount(), getMaxAmount());
		if (Mine.getChance(chance)) {
			clone.setAmount(amount);
			return clone;
		}
		return Mine.getRandomItem(CaixaAPI.premio);

	}

	public double getChance() {

		return chance;
	}

	public int getMaxAmount() {

		return maxAmount;
	}

	public int getMinAmount() {

		return minAmount;
	}

	public ItemStack getItem() {

		return this.item;
	}

	public void setItem(ItemStack item) {

		this.item = item;
	}

	public void setChance(double chance) {

		this.chance = chance;
	}

	public void setMaxAmount(int maxAmount) {

		this.maxAmount = maxAmount;
	}

	public void setMinAmount(int minAmount) {

		this.minAmount = minAmount;

	}

	@Override
	public Object restore(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void store(Map<String, Object> map, Object object) {
		// TODO Auto-generated method stub

	}

}