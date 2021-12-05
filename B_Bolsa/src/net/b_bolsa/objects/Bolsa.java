package net.b_bolsa.objects;

public class Bolsa {

	private int porcentagem;
	private long time;
	
	public Bolsa(int porcentagem, long time) {
		this.porcentagem = porcentagem;
		this.setTime(time);
	}

	public int getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(int porcentagem) {
		this.porcentagem = porcentagem;
	}

	public boolean estaBaixa() {
		boolean a = getPorcentagem() < 50 ? true : false;
		return a;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	public long dif() {
		if(System.currentTimeMillis() < this.time) {
			return (this.time - System.currentTimeMillis());
		}
		return 0;
	}

}
