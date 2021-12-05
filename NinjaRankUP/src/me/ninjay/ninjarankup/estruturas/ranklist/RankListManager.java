package me.ninjay.ninjarankup.estruturas.ranklist;

import java.util.ArrayList;

import me.ninjay.ninjarankup.utils.Storable;

public class RankListManager implements Storable{
	
	private ArrayList<RankList> rankList = new ArrayList<>();

	public ArrayList<RankList> getRankList() {
		return rankList;
	}

	public void setRankList(ArrayList<RankList> rankList) {
		this.rankList = rankList;
	}

}
