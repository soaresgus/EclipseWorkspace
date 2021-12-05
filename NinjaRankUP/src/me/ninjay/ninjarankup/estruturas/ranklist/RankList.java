package me.ninjay.ninjarankup.estruturas.ranklist;

import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjarankup.utils.Storable;

public class RankList implements Storable{
	
	public ItemStack icone;
	public Integer pagina;
	public Integer slot;
	
	public ItemStack getIcone() {
		return icone;
	}
	public void setIcone(ItemStack icone) {
		this.icone = icone;
	}
	public Integer getPagina() {
		return pagina;
	}
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}
	public Integer getSlot() {
		return slot;
	}
	public void setSlot(Integer slot) {
		this.slot = slot;
	}

}
