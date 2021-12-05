package net.b_vender;


public enum Itens {

	ITEM1(Material.APPLE, 100), ITEM2(Material.ANVIL, 560);

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
