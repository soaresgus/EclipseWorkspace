package me.ninjay.kustspawners.estruturas;

import java.util.ArrayList;

import org.bukkit.entity.EntityType;

import me.ninjay.utils.utils.Storable;

public class DropsManager implements Storable{
	
	public Drops getEntity(EntityType entity) {
		for(Drops drop : drops) {
			if(drop.getMob() == entity) {
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
