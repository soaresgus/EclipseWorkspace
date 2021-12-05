package me.ninjay.dropsmob.estruturas;

import java.util.Map;

import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import me.ninjay.utils.utils.Storable;



public class Drops implements Storable{
	
	private EntityType mob;
	private ItemStack drop;
	private Integer normal;
	private Integer lot1;
	private Integer lot2;
	private Integer lot3;
	private Integer lot4;
	private Integer lot5;
	private Integer lot6;
	private Integer lot7;
	private Integer lot8;
	private Integer lot9;
	private Integer lot10;
	
	public Integer getLot4() {
		return lot4;
	}

	public void setLot4(Integer lot4) {
		this.lot4 = lot4;
	}

	public Integer getLot5() {
		return lot5;
	}

	public void setLot5(Integer lot5) {
		this.lot5 = lot5;
	}

	public Integer getLot6() {
		return lot6;
	}

	public void setLot6(Integer lot6) {
		this.lot6 = lot6;
	}

	public Integer getLot7() {
		return lot7;
	}

	public void setLot7(Integer lot7) {
		this.lot7 = lot7;
	}

	public Integer getLot8() {
		return lot8;
	}

	public void setLot8(Integer lot8) {
		this.lot8 = lot8;
	}

	public Integer getLot9() {
		return lot9;
	}

	public void setLot9(Integer lot9) {
		this.lot9 = lot9;
	}

	public Integer getLot10() {
		return lot10;
	}

	public void setLot10(Integer lot10) {
		this.lot10 = lot10;
	}

	@Override
	public Object restore(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void store(Map<String, Object> map, Object object) {
		// TODO Auto-generated method stub

	}
	
	public ItemStack getDrop() {
		return drop;
	}
	public void setDrop(ItemStack drop) {
		this.drop = drop;
	}

	public Integer getLot1() {
		return lot1;
	}
	public void setLot1(Integer lot1) {
		this.lot1 = lot1;
	}
	public Integer getLot2() {
		return lot2;
	}
	public void setLot2(Integer lot2) {
		this.lot2 = lot2;
	}
	public Integer getLot3() {
		return lot3;
	}
	public void setLot3(Integer lot3) {
		this.lot3 = lot3;
	}
	public EntityType getMob() {
		return mob;
	}
	public void setMob(EntityType mob) {
		this.mob = mob;
	}

	public Integer getNormal() {
		return normal;
	}

	public void setNormal(Integer normal) {
		this.normal = normal;
	}
	
	
	

}
