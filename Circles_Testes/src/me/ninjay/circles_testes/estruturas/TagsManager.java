package me.ninjay.circles_testes.estruturas;

import java.util.ArrayList;

import me.ninjay.circles_testes.utils.Storable;


public class TagsManager implements Storable {

	public Tags getTagPorPerm(String perm) {
		for (Tags tag : tags) {
			if (tag.getPerm().equals(perm)) {
				return tag;
			}
		}
		return null;

	}

	public Tags getTagPorNome(String nome) {
		for (Tags tag : tags) {
			if (tag.getName().equalsIgnoreCase(nome)) {
				return tag;
			}
		}
		return null;
	}

	private ArrayList<Tags> tags = new ArrayList<Tags>();

	public ArrayList<Tags> getTags() {
		return tags;
	}

	public void setTags(ArrayList<Tags> tags) {
		this.tags = tags;
	}

}
