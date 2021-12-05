package me.ninjay.oneperfil.ranks;

import org.bukkit.entity.Player;


public class RankAPI {
	
	public static RankUp rankAPIGetRank(Player p) {
		if(RankUpManager.rankplayer.get(p) == null) {
		}
         return RankUpManager.rankplayer.get(p);		 
	}
	
	

}
