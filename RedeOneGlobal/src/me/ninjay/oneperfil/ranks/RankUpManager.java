package me.ninjay.oneperfil.ranks;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.oneperfil.almas.estruturas.AlmasAPI;
import me.ninjay.oneperfil.estruturas.BlocosAPI;
import me.ninjay.oneperfil.main.Main;
import net.eduard.api.lib.modules.VaultAPI;
import net.eduard.api.lib.storage.Storable;

public class RankUpManager implements Storable{
	
	public RankUp getrankporlong(String nome) {
		for(RankUp rank : ranks) {
			if(rank.getMenu().getTitle().equals(nome)) {
				return rank;
			}
		}
		return null;
		
	}
	private ArrayList<RankUp> ranks = new ArrayList<>();
	public static HashMap<Player, RankUp> rankplayer = new HashMap<>();
	
	public ArrayList<RankUp> getRanks() {
		return ranks;
	}
	public void setRanks(ArrayList<RankUp> ranks) {
		this.ranks = ranks;
	}
	public static void abrir(Player p, RankUp rank) {
		Inventory inv = Mine.newInventory(rank.getNome(), 9*3);
		rank.setMenu(inv);
		inv.setItem(Mine.getPosition(2, 5), rank.getIcone());
		
		ItemStack confirmar = Mine.newItem(Material.STAINED_CLAY, "§aConfirmar",1,5);
		ItemStack cancelar = Mine.newItem(Material.STAINED_CLAY, "§cCancelar",1,14);
		
		inv.setItem(Mine.getPosition(2, 3), confirmar);
		inv.setItem(Mine.getPosition(2, 7), cancelar);
		p.openInventory(rank.getMenu());
	}
	public static void confirmar(Player p, RankUp rank) {
		p.getOpenInventory().close();
	    BlocosAPI.removeBlocos(p, Main.blocos, rank.getBlocos());
	    VaultAPI.getEconomy().withdrawPlayer(p, rank.getCoins());
	    AlmasAPI.removeAlmas(p, Main.almas, rank.getAlmas());
	    rankplayer.put(p, rank);
	}
	public static void negar(Player p, RankUp rank) {
		p.getOpenInventory().close();
		p.sendMessage("§cOperação cancelada.");
	}
	 

}
