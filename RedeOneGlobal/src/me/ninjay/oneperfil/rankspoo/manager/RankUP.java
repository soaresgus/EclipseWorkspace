package me.ninjay.oneperfil.rankspoo.manager;

import java.util.Map;


import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.storage.Storable;
import net.eduard.api.lib.storage.StorageAttributes;

@StorageAttributes(indentificate = true)
public class RankUP implements Storable {

	private String nome;
	private String prefix;
	private double preco;
	private int level;
	private ItemStack icone;
	private Long blocos;
	private Long horas;
	private Long almas;
	private Long eventos;
	private String grupo;
	
	@Override
	public Object restore(Map<String, Object> map) {
		return null;
	}

	@Override
	public void store(Map<String, Object> map, Object object) {

	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Long getEventos() {
		return eventos;
	}

	public void setEventos(Long eventos) {
		this.eventos = eventos;
	}

	public Long getAlmas() {
		return almas;
	}

	public void setAlmas(Long almas) {
		this.almas = almas;
	}

	public Long getHoras() {
		return horas;
	}

	public void setHoras(Long horas) {
		this.horas = horas;
	}

	public Long getBlocos() {
		return blocos;
	}

	public void setBlocos(Long blocos) {
		this.blocos = blocos;
	}

	public ItemStack getIcone() {
		return icone;
	}

	public void setIcone(ItemStack icone) {
		this.icone = icone;
	}

}
