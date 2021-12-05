package me.ninjay.rankup112.estruturas;

import java.util.ArrayList;

import me.ninjay.rankup112.utils.Storable;


public class RanksManager implements Storable{
	
	public Ranks getRankByName(String name) {
		for(Ranks rank : ranks) {
			if(rank.getNome().equals(name)) {
				return rank;
			}
		}
		return null;
	}
	
	private ArrayList<Ranks> ranks = new ArrayList<>();

	public ArrayList<Ranks> getRanks() {
		return ranks;
	}

	public void setRanks(ArrayList<Ranks> ranks) {
		this.ranks = ranks;
	}

}
