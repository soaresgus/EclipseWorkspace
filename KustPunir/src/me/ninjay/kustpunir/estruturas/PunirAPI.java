package me.ninjay.kustpunir.estruturas;

import me.ninjay.kustpunir.main.Main;
import me.ninjay.utils.utils.BukkitConfig;

public class PunirAPI {

	public static PunirManager manager;
	
	private static BukkitConfig config = new BukkitConfig("punir.yml", Main.getPlugin(Main.class));
	
	public static void reload() {
		config.reloadConfig();
		if(config.contains("punirs")) {
			manager = (PunirManager) config.get("punirs");
		}else {
			manager = new PunirManager();
			
			Punir punir1 = new Punir();
			
			punir1.setAviso(true);
			punir1.setPerm("ajudante.ban");
			punir1.setBan1(false);
			punir1.setBan2(false);
			punir1.setBan3(true);
			punir1.setBan4(true);
			punir1.setBan5(true);
			punir1.setDesc("Tudo relacionado ao chat, spam, flood, caps-lock, brigas.");
			punir1.setGrupo("ajudante");
			punir1.setName("conflito_no_chat");
			punir1.setNome("Conflitos no chat");
			punir1.setTempo1(5L);
			punir1.setTempo2(24L);
			punir1.setTempo3(24L);
			punir1.setTempo4(24*7L);
			punir1.setTempo5(24*15L);
			
			manager.getPunirs().add(punir1);
			save();
		}
	}
	
	public static void save() {
		config.set("punirs", manager);
		config.saveConfig();
	}
}
