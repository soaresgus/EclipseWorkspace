package me.ninjay.mineriocustom.estruturas;

import java.util.ArrayList;

import org.bukkit.Material;

import me.ninjay.mineriocustom.utils.Storable;

public class MinerioManager implements Storable{
	
	public Minerio getMinerioByType(Material type) {
		for(Minerio minerio : minerios) {
			if(minerio.getTipo() == type) {
				return minerio;
			}
		}
		
		return null;
	}
	
	public ArrayList<Minerio> getMinerios() {
		return minerios;
	}

	public void setMinerios(ArrayList<Minerio> minerios) {
		this.minerios = minerios;
	}

	private ArrayList<Minerio> minerios = new ArrayList<Minerio>();

}
