package me.ninjay.circles_testes.estruturas;

import me.ninjay.circles_testes.main.Main;
import me.ninjay.circles_testes.utils.BukkitConfig;

public class TagsAPI {

	public static TagsManager manager;

	public static BukkitConfig config = new BukkitConfig("tags.yml", Main.getPlugin(Main.class));

	public static void reload() {
		config.reloadConfig();
		if (config.contains("tags")) {
			manager = (TagsManager) config.get("tags");
		} else {
			manager = new TagsManager();

			Tags tag1 = new Tags();

			tag1.setId(1);
			tag1.setName("vip");
			tag1.setPerm("tag.nome");
			manager.getTags().add(tag1);
			save();
		}
	}

	public static void save() {
		config.set("tags", manager);
		config.saveConfig();
	}

}
