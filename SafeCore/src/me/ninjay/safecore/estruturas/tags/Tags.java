package me.ninjay.safecore.estruturas.tags;

import me.ninjay.utils.utils.Storable;

public class Tags implements Storable {

	private Integer id;
	private String name;
	private String perm;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPerm() {
		return perm;
	}

	public void setPerm(String perm) {
		this.perm = perm;
	}

}
