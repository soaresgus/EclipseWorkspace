package me.ninjay.mineriocustom.estruturas;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.ninjay.mineriocustom.utils.Storable;

public class Minerio implements Storable{
	
	private Material tipo;
	private Material drop;
	private Integer min;
	private Integer max;
	private ArrayList<Material> picareta;
	
	public Material getTipo() {
		return tipo;
	}
	public void setTipo(Material tipo) {
		this.tipo = tipo;
	}
	public Material getDrop() {
		return drop;
	}
	public void setDrop(Material drop) {
		this.drop = drop;
	}
	public Integer getMin() {
		return min;
	}
	public void setMin(Integer min) {
		this.min = min;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	public ArrayList<Material> getPicareta() {
		return picareta;
	}
	public void setPicareta(ArrayList<Material> picareta) {
		this.picareta = picareta;
	}
	
	
	

}
