package me.ninjay.ninjarankup.estruturas.rank;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjarankup.utils.Storable;

public class RankManager implements Storable{
	
	public Rank getRankById(Integer id) {
		for(Rank ranks : ranks) {
			if(ranks.getId() == id) {
				return ranks;
			}
		}
		return null;
	}
	
	public Rank getRankByIcone(ItemStack icone) {
		for(Rank ranks : ranks) {
			if(ranks.getIcone().isSimilar(icone)) {
				return ranks;
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
