package me.ninjay.kustcaixas.estruturas;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

import me.ninjay.utils.utils.Storable;

public class CaixaManager implements Storable{
	
	public Caixa getCaixaByName(String name) {
		for(Caixa caixa : caixas) {
			if(caixa.getName().equalsIgnoreCase(name)) {
				return caixa;
			}
		}
		return null;
	}
	
	public Caixa getCaixaByIcone(ItemStack icone) {
		for(Caixa caixa : caixas) {
			if(caixa.getIcone().isSimilar(icone)) {
				return caixa;
			}
		}
		return null;
	}
	
	public Caixa getCaixaByIcone1(ItemStack icone) {
		for(Caixa caixa : caixas) {
			if(caixa.getIconeLoja1().isSimilar(icone)) {
				return caixa;
			}
		}
		return null;
	}
	
	public Caixa getCaixaByIcone5(ItemStack icone) {
		for(Caixa caixa : caixas) {
			if(caixa.getIconeLoja5().isSimilar(icone)) {
				return caixa;
			}
		}
		return null;
	}
	
	public Caixa getCaixaByIcone10(ItemStack icone) {
		for(Caixa caixa : caixas) {
			if(caixa.getIconeLoja10().isSimilar(icone)) {
				return caixa;
			}
		}
		return null;
	}
	
	public Caixa getCaixaByIcone25(ItemStack icone) {
		for(Caixa caixa : caixas) {
			if(caixa.getIconeLoja25().isSimilar(icone)) {
				return caixa;
			}
		}
		return null;
	}
	
	private ArrayList<Caixa> caixas = new ArrayList<>();

	public ArrayList<Caixa> getCaixas() {
		return caixas;
	}

	public void setCaixas(ArrayList<Caixa> caixas) {
		this.caixas = caixas;
	}

}
