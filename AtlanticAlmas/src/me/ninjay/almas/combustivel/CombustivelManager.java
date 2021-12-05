package me.ninjay.almas.combustivel;

import java.util.ArrayList;


import net.eduard.api.lib.storage.Storable;

public class CombustivelManager implements Storable{
	
	public Combustivel getcombustivel(String nomec) {
		for(Combustivel combustivel : combustiveis) {
			if(combustivel.getNome().equalsIgnoreCase(nomec)) {
				return combustivel;
			}
		}
		return null;
		
	}
	private ArrayList<Combustivel> combustiveis = new ArrayList<>();
	public ArrayList<Combustivel> getCombustiveis() {
		return combustiveis;
	}
	public void setCombustiveis(ArrayList<Combustivel> combustiveis) {
		this.combustiveis = combustiveis;
	}

	
}
