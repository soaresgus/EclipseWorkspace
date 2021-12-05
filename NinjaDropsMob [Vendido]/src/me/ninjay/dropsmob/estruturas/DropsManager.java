package me.ninjay.dropsmob.estruturas;

import java.util.ArrayList;

import org.bukkit.entity.EntityType;

import me.ninjay.utils.utils.Storable;

public class DropsManager implements Storable{
	
	public Drops getMobPorEntity(EntityType entity) {
		for(Drops drop : drops) {
			if(drop.getMob() == entity) {
				return drop;
			}
		}
		return null;
	}
	
	private ArrayList<Drops> drops = new ArrayList<Drops>();

	public ArrayList<Drops> getDrops() {
		return drops;
	}

	public void setDrops(ArrayList<Drops> drops) {
		this.drops = drops;
	}

}
