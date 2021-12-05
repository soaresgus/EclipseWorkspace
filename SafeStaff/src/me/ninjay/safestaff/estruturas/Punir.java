package me.ninjay.safestaff.estruturas;

import me.ninjay.utils.utils.Storable;

public class Punir implements Storable{
	
	private String nome;
	private String name;
	private String desc;
	private String perm;
	private Long tempo1;
	private Long tempo2;
	private Long tempo3;
	private Long tempo4;
	private Long tempo5;
	private String grupo;
	private boolean aviso;
	private boolean ban1;
	private boolean ban2;
	private boolean ban3;
	private boolean ban4;
	private boolean ban5;
	
	
	public Long getTempo1() {
		return tempo1;
	}
	public void setTempo1(Long tempo1) {
		this.tempo1 = tempo1;
	}
	public Long getTempo2() {
		return tempo2;
	}
	public void setTempo2(Long tempo2) {
		this.tempo2 = tempo2;
	}
	public Long getTempo3() {
		return tempo3;
	}
	public void setTempo3(Long tempo3) {
		this.tempo3 = tempo3;
	}
	public Long getTempo4() {
		return tempo4;
	}
	public void setTempo4(Long tempo4) {
		this.tempo4 = tempo4;
	}
	public Long getTempo5() {
		return tempo5;
	}
	public void setTempo5(Long tempo5) {
		this.tempo5 = tempo5;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public boolean isAviso() {
		return aviso;
	}
	public void setAviso(boolean aviso) {
		this.aviso = aviso;
	}
	public boolean isBan1() {
		return ban1;
	}
	public void setBan1(boolean ban1) {
		this.ban1 = ban1;
	}
	public boolean isBan2() {
		return ban2;
	}
	public void setBan2(boolean ban2) {
		this.ban2 = ban2;
	}
	public boolean isBan3() {
		return ban3;
	}
	public void setBan3(boolean ban3) {
		this.ban3 = ban3;
	}
	public boolean isBan4() {
		return ban4;
	}
	public void setBan4(boolean ban4) {
		this.ban4 = ban4;
	}
	public boolean isBan5() {
		return ban5;
	}
	public void setBan5(boolean ban5) {
		this.ban5 = ban5;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPerm() {
		return perm;
	}
	public void setPerm(String perm) {
		this.perm = perm;
	}
	

}
