package me.ninjay.comerciante.estruturas;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

import me.ninjay.utils.utils.Storable;


public class ItensManager implements Storable{
	
	public Itens getItemPorId(Integer id) {
		for(Itens item : itens) {
			if(item.getId() == id) {
				return item;
			}
		}
		return null;
		
	}
	
	public Itens getItemPorIcone(ItemStack icone) {
		for(Itens item : itens) {
			if(item.getItem().isSimilar(icone)) {
				return item;
			}
		}
		return null;
	}
	
	public Itens getItemPorNomeIcone(String nome) {
		for(Itens item : itens) {
			if(item.getItem().getItemMeta().getDisplayName().equals(nome)) {
				return item;
			}
		}
		return null;
	}
	
	private ArrayList<Itens> itens = new ArrayList<>();

	public ArrayList<Itens> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Itens> itens) {
		this.itens = itens;
	}

}
