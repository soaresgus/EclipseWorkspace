package me.ninjay.safedrops.estruturas;

import java.util.ArrayList;

import org.bukkit.entity.EntityType;

import me.ninjay.utils.utils.Storable;

public class DropsManager implements Storable{
	
	public Drops getMobPorTipo(EntityType tipo) {
		for(Drops drop : drops) {
			if(drop.getMob() == tipo) {
				return drop;
			}
		}
		return null;
		
	}
	
	public ArrayList<Drops> getDrops() {
		return drops;
	}

	public void setDrops(ArrayList<Drops> drops) {
		this.drops = drops;
	}

	private ArrayList<Drops> drops = new ArrayList<Drops>();

}
