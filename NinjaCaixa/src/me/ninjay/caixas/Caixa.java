package me.ninjay.caixas;

import java.util.ArrayList;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.storage.Storable;

public class Caixa implements Storable{

	private ItemStack icone;
	private String name;
	private ArrayList<ItemStack> premios = new ArrayList<>();
    
	public ArrayList<ItemStack> getPremios() {
		return premios;
	}

	public void setPremios(ArrayList<ItemStack> premios) {
		this.premios = premios;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemStack getIcone() {
		return icone;
	}

	public void setIcone(ItemStack icone) {
		this.icone = icone;
	}


	
}
