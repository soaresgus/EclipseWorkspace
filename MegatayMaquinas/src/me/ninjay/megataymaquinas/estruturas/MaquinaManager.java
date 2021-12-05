package me.ninjay.megataymaquinas.estruturas;

import java.util.ArrayList;
import java.util.Map;

import org.bukkit.Material;

import net.eduard.api.lib.storage.Storable;

public class MaquinaManager implements Storable{
	
	public Maquina getMaquinaPorNome(String nome) {
		for(Maquina maquina : maquinas) {
			if(maquina.getNome().equalsIgnoreCase(nome)) {
				return maquina;
			}
		}
		return null;
	}
	
	public Maquina getMaquinaPorTipo(Material type) {
		for(Maquina maquina : maquinas) {
			if(maquina.getIcone().getType() == type) {
				return maquina;
			}
		}
		return null;
	}
	
	public Maquina getMaquinaPorNomeDoItem(String nome) {
		for(Maquina maquina : maquinas) {
			if(maquina.getIcone().getItemMeta().getDisplayName().equalsIgnoreCase(nome)) {
				return maquina;
			}
		}
		return null;
	}
	
	public Maquina getMaquinaPorNomeDoItem2(String nome) {
		for(Maquina maquina : maquinas) {
			if(maquina.getIcone().getItemMeta().getDisplayName().contains(nome)) {
				return maquina;
			}
		}
		return null;
	}
	
	private ArrayList<Maquina> maquinas = new ArrayList<Maquina>();
	
	
	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
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
