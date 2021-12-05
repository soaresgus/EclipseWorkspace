package me.ninjay.oneperfil.tagsv2;

import net.eduard.api.lib.storage.Storable;
import net.eduard.api.lib.storage.StorageAttributes;

@StorageAttributes (indentificate = true)
public class Tags implements Storable {
    
	private String nome;
	private String cargo;
	private String prefix;
	private String suffix;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

}
