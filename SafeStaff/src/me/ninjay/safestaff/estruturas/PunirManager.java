package me.ninjay.safestaff.estruturas;

import java.util.ArrayList;

import me.ninjay.utils.utils.Storable;

public class PunirManager implements Storable{
	
	public Punir getPunirPorNomeFormal(String nome) {
		for(Punir punir : punirs) {
			if(punir.getNome().equalsIgnoreCase(nome)) {
				return punir;
			}
		}
		return null;
		
	}
	
	public Punir getPunirPorNome(String nome) {
		for(Punir punir : punirs) {
			if(punir.getName().equalsIgnoreCase(nome)) {
				return punir;
			}
		}
		return null;
	}
	
	
	public ArrayList<Punir> getPunirs() {
		return punirs;
	}

	public void setPunirs(ArrayList<Punir> punirs) {
		this.punirs = punirs;
	}

	private ArrayList<Punir> punirs = new ArrayList<>();

}
