package me.ninjay.onevender.estruturas;

import org.bukkit.Material;

public enum Itens {
	ITEM1(Material.ROTTEN_FLESH, 1),ITEM2(Material.BONE, 1),ITEM3(Material.BLAZE_ROD, 1),ITEM4(Material.IRON_INGOT, 1),ITEM5(Material.MELON, 1),ITEM6(Material.MELON_BLOCK, 1),ITEM7(Material.NETHER_STALK, 1),ITEM8(Material.SLIME_BALL, 1),ITEM11(Material.DIAMOND, 1),ITEM12(Material.DIAMOND_BLOCK, 1),ITEM13(Material.LAPIS_ORE, 1),ITEM14(Material.LAPIS_BLOCK, 1);

	private Material material;
	private double valor;

	private Itens(Material material, double valor) {
		this.material = material;
		this.valor = valor;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}


