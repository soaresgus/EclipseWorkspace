package me.ninjay.safeclub.estruturas.api.eventos;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

import me.ninjay.safeclub.main.Main;
import me.ninjay.safeclub.utils.BukkitConfig;


public class EventoAPI {

	public static BukkitConfig config = new BukkitConfig("eventos.yml", Main.getPlugin(Main.class));
	public static EventoManager manager;

	public static void reload() {
		config.reloadConfig();
		if (config.contains("eventos")) {
			manager = (EventoManager) config.get("eventos");
		} else {
			manager = new EventoManager();
			Evento glad = new Evento();

			ArrayList<ItemStack> itens = new ArrayList<>();

			glad.setNome("Gladiator");
			glad.setNumber(1);
			glad.setPre(null);
			glad.setJogo(null);
			glad.setMorte(null);
			glad.setSpawn(null);
			glad.setItens(itens);
			glad.setValor(0);
			glad.setComando("gladiator");
			glad.setComoJogar("§6você joga e cabo krai");
			glad.setInv(30);
			glad.setTpAll(false);
			
			manager.getEventos().add(glad);
			save();
		}
	}

	public static void save() {
		config.set("eventos", manager);
		config.saveConfig();
	}

}
