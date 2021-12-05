package me.ninjay.kustspawners.estruturas;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import me.ninjay.utils.utils.Storable;

public class Drops implements Storable{
	
	private String name;
	private EntityType mob;
	private Material drop1;
	private Material drop2;
	private double chance1;
	private double chance2;
	private int lot0Drop1;
	private int lot1Drop1;
	private int lot2Drop1;
	private int lot3Drop1;
	private int lot0Drop2;
	private int lot1Drop2;
	private int lot2Drop2;
	private int lot3Drop2;
			
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EntityType getMob() {
		return mob;
	}
	public void setMob(EntityType mob) {
		this.mob = mob;
	}
	public double getChance1() {
		return chance1;
	}
	public void setChance1(double chance1) {
		this.chance1 = chance1;
	}
	public double getChance2() {
		return chance2;
	}
	public void setChance2(double chance2) {
		this.chance2 = chance2;
	}
	public int getLot0Drop1() {
		return lot0Drop1;
	}
	public void setLot0Drop1(int lot0Drop1) {
		this.lot0Drop1 = lot0Drop1;
	}
	public int getLot1Drop1() {
		return lot1Drop1;
	}
	public void setLot1Drop1(int lot1Drop1) {
		this.lot1Drop1 = lot1Drop1;
	}
	public int getLot2Drop1() {
		return lot2Drop1;
	}
	public void setLot2Drop1(int lot2Drop1) {
		this.lot2Drop1 = lot2Drop1;
	}
	public int getLot3Drop1() {
		return lot3Drop1;
	}
	public void setLot3Drop1(int lot3Drop1) {
		this.lot3Drop1 = lot3Drop1;
	}
	public int getLot0Drop2() {
		return lot0Drop2;
	}
	public void setLot0Drop2(int lot0Drop2) {
		this.lot0Drop2 = lot0Drop2;
	}
	public int getLot1Drop2() {
		return lot1Drop2;
	}
	public void setLot1Drop2(int lot1Drop2) {
		this.lot1Drop2 = lot1Drop2;
	}
	public int getLot2Drop2() {
		return lot2Drop2;
	}
	public void setLot2Drop2(int lot2Drop2) {
		this.lot2Drop2 = lot2Drop2;
	}
	public int getLot3Drop2() {
		return lot3Drop2;
	}
	public void setLot3Drop2(int lot3Drop2) {
		this.lot3Drop2 = lot3Drop2;
	}
	public Material getDrop1() {
		return drop1;
	}
	public void setDrop1(Material drop1) {
		this.drop1 = drop1;
	}
	public Material getDrop2() {
		return drop2;
	}
	public void setDrop2(Material drop2) {
		this.drop2 = drop2;
	}

}
