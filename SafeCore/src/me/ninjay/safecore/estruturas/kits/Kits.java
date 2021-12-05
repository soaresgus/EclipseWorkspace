package me.ninjay.safecore.estruturas.kits;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

import me.ninjay.utils.utils.Storable;

public class Kits implements Storable {

	private String name;
	private int id;
	private ArrayList<ItemStack> itens;
	private ItemStack icone;
	private Long cooldown;
	private int SlotIcone;
	private String perm;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPerm() {
		return perm;
	}

	public void setPerm(String perm) {
		this.perm = perm;
	}

	public int getSlotIcone() {
		return SlotIcone;
	}

	public void setSlotIcone(int slotIcone) {
		SlotIcone = slotIcone;
	}

	public Long getCooldown() {
		return cooldown;
	}

	public void setCooldown(Long cooldown) {
		this.cooldown = cooldown;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
