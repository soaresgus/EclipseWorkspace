package me.ninjay.oneperfil.ranks;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.storage.Storable;

public class RankUp implements Storable{
	
	private String nome;
	private ItemStack icone;
	private Long blocos;
	private Double coins;
	private Long horas;
	private Long almas;
	private Long eventos;
	private Inventory menu;
	private String grupo;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ItemStack getIcone() {
		return icone;
	}
	public void setIcone(ItemStack icone) {
		this.icone = icone;
	}
	public Long getBlocos() {
		return blocos;
	}
	public void setBlocos(Long blocos) {
		this.blocos = blocos;
	}
	public Double getCoins() {
		return coins;
	}
	public void setCoins(Double coins) {
		this.coins = coins;
	}
	public Long getHoras() {
		return horas;
	}
	public void setHoras(Long horas) {
		this.horas = horas;
	}
	public Long getAlmas() {
		return almas;
	}
	public void setAlmas(Long almas) {
		this.almas = almas;
	}
	public Long getEventos() {
		return eventos;
	}
	public void setEventos(Long eventos) {
		this.eventos = eventos;
	}
	public Inventory getMenu() {
		return menu;
	}
	public void setMenu(Inventory menu) {
		this.menu = menu;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

}
