package me.ninjay.kustkits.estruturas;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

import me.ninjay.utils.utils.Storable;

public class KitManager implements Storable{
	
	public Kit getKitPorName(String name) {
		for(Kit kit : kits) {
			if(kit.getName().equalsIgnoreCase(name)) {
				return kit;
			}
		}
		return null;
	}
	
	public Kit getKitPorIcone(ItemStack icone) {
		for(Kit kit : kits) {
			if(kit.getIcone().isSimilar(icone)) {
				return kit;
			}
		}
		return null;
	}

	
	public ArrayList<Kit> kits = new ArrayList<>();


	public ArrayList<Kit> getKits() {
		return kits;
	}


	public void setKits(ArrayList<Kit> kits) {
		this.kits = kits;
	}
}
