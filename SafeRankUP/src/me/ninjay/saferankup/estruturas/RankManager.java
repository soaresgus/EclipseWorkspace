package me.ninjay.saferankup.estruturas;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

import me.ninjay.utils.utils.Storable;

public class RankManager implements Storable{
	
	public Rank getRankPorId(Integer id) {
		for(Rank rank : ranks) {
			if(rank.getId() == id) {
				return rank;
			}
		}
		return null;
		
	}
	
	public Rank getRankPorName(String name) {
		for(Rank rank : ranks) {
			if(rank.getName().equals(name)) {
				return rank;
			}
		}
		return null;
		
	}
	
	public Rank getRankPorIcone(ItemStack icon) {
		for(Rank rank : ranks) {
			if(rank.getIconRanks().isSimilar(icon)) {
				return rank;
			}
		}
		return null;
		
	}
	
	private ArrayList<Rank> ranks = new ArrayList<>();

	public ArrayList<Rank> getRanks() {
		return ranks;
	}

	public void setRanks(ArrayList<Rank> ranks) {
		this.ranks = ranks;
	}

}
