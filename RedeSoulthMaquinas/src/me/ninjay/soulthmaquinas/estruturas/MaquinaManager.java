package me.ninjay.soulthmaquinas.estruturas;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.soulthmaquinas.main.Main;
import net.eduard.api.lib.storage.Storable;

public class MaquinaManager implements Storable{
	
	public Maquina getmaquina(String nome) {
		for(Maquina maquina : maquinas) {
			if(maquina.getNome().equalsIgnoreCase(nome)) {
				return maquina;
			}
		}
		return null;
	}
	private ArrayList<Maquina> maquinas = new ArrayList<>();
	
	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}
	
	public void abrir(Player p, Maquina maquina) {
	    Inventory inv = Mine.newInventory("Maquina", 9*3);
	    ItemStack maq = maquina.getIcone();
	    ItemStack drop = maquina.getDrop();
	    ItemStack qnt = Mine.newItem(Material.PAPER, "§eQuantidades", 1, 0, " ","§fQuantidade de máquinas: "+Main.maquinasquantia.getDouble(maquina.getNome()+"_maquina_"+p.getName()),"§fQuantidade de drops: "+Main.drop.getDouble(maquina.getNome()+"_drop_"+p.getName()));
	    ItemStack vidro = Mine.newItem("§eMáquina", Material.STAINED_GLASS_PANE, 7);
	    
	    for(int d = 0; d < 27; d++) {
	    	inv.setItem(d, vidro);
	    }
	    inv.setItem(Mine.getPosition(2, 2), maq);
	    inv.setItem(Mine.getPosition(2, 8), drop);
	    inv.setItem(Mine.getPosition(2, 5), qnt);
	    p.openInventory(inv);
	}
     
}
