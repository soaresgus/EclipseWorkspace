package me.ninjay.megataymaquinas.estruturas;

import java.util.ArrayList;

import org.bukkit.Material;

import net.eduard.api.lib.storage.Storable;

public class RefinariaManager implements Storable{
	
	public Refinaria getRefinariaPorNome(String nome) {
		for(Refinaria refinaria : refinarias) {
			if(refinaria.getNome().equalsIgnoreCase(nome)) {
				return refinaria;
			}
		}
		return null;
	}
	
	public Refinaria getRefinariaPorTipo(Material type) {
		for(Refinaria refinaria : refinarias) {
			if(refinaria.getIcone().getType() == type) {
				return refinaria;
			}
		}
		return null;
	}
	
	public Refinaria getRefinariaPorNomeDoItem(String nome) {
		for(Refinaria refinaria : refinarias) {
			if(refinaria.getIcone().getItemMeta().getDisplayName().equalsIgnoreCase(nome)) {
				return refinaria;
			}
		}
		return null;
	}
	public Refinaria getRefinariaPorNumero(Integer i) {
		for(Refinaria refinaria : refinarias) {
			if(refinaria.getNumero() == i) {
				return refinaria;
			}
		}
		return null;
	}
	public Refinaria getCombustivelPorNomeDoItem(String nome) {
		for(Refinaria refinaria : refinarias) {
			if(refinaria.getCombustivel().getItemMeta().getDisplayName().equalsIgnoreCase(nome)) {
				return refinaria;
			}
		}
		return null;
	}
	
	public Refinaria getEssenciaPorNomeDoItem(String nome) {
		for(Refinaria refinaria : refinarias) {
			if(refinaria.getEssencia().getItemMeta().getDisplayName().equalsIgnoreCase(nome)) {
				return refinaria;
			}
		}
		return null;
	}
	
	private ArrayList<Refinaria> refinarias = new ArrayList<>();

	public ArrayList<Refinaria> getRefinarias() {
		return refinarias;
	}

	public void setRefinarias(ArrayList<Refinaria> refinarias) {
		this.refinarias = refinarias;
	}

}
