package me.ninjay.safecore.estruturas.kits;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

import me.ninjay.utils.utils.Storable;

public class KitsManager implements Storable {

	public Kits getKitPorNome(String nome) {
		for (Kits kit : kits) {
			if (kit.getName().equals(nome)) {
				return kit;
			}
		}
		return null;
	}

	public Kits getKitPorId(Integer id) {
		for (Kits kit : kits) {
			if (kit.getId() == id) {
				return kit;
			}
		}
		return null;
	}

	public Kits getKitPorIcone(ItemStack item) {
		for (Kits kit : kits) {
			if (kit.getIcone().isSimilar(item)) {
				return kit;
			}
		}
		return null;
	}

	private ArrayList<Kits> kits = new ArrayList<Kits>();

	public ArrayList<Kits> getKits() {
		return kits;
	}

	public void setKits(ArrayList<Kits> kits) {
		this.kits = kits;
	}

}
