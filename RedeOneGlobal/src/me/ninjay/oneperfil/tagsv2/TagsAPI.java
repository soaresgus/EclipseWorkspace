package me.ninjay.oneperfil.tagsv2;

import me.ninjay.oneperfil.main.Main;
import net.eduard.api.lib.BukkitConfig;

public class TagsAPI {

	public static BukkitConfig config = new BukkitConfig("tags.yml", Main.getPlugin(Main.class));
	public static TagsManager manager;

	public static void reload() {
		config.reloadConfig();
		if (config.contains("tags")) {
			manager = (TagsManager) config.get("tags");
		} else {
			manager = new TagsManager();
			Tags diretor = new Tags();
			Tags gerente = new Tags();
			Tags admin = new Tags();
			Tags dev = new Tags();
			Tags mod = new Tags();
			Tags builder = new Tags();
			Tags ajd = new Tags();
			Tags yt = new Tags();
			Tags titan = new Tags();
			Tags gladiador = new Tags();
			Tags guerreiro = new Tags();

			diretor.setNome("diretor");
			diretor.setCargo("diretor");
			diretor.setPrefix("§6[Diretor] ");

			gerente.setNome("gerente");
			gerente.setCargo("gerente");
			gerente.setPrefix("§4[Gerente] ");

			admin.setNome("admin");
			admin.setCargo("admin");
			admin.setPrefix("§c[Admin] ");

			dev.setNome("dev");
			dev.setCargo("programador");
			dev.setPrefix("§9[Dev] ");

			mod.setNome("moderador");
			mod.setCargo("Moderador");
			mod.setPrefix("§2[Moderador] ");

			builder.setNome("builder");
			builder.setCargo("builder");
			builder.setPrefix("§d[Builder] ");

			ajd.setNome("ajudante");
			ajd.setCargo("ajudante");
			ajd.setPrefix("§e[Ajudante] ");

			yt.setNome("youtuber");
			yt.setCargo("youtuber");
			yt.setPrefix("§c[YT] ");

			titan.setNome("titan");
			titan.setPrefix("§4[Titan] ");

			gladiador.setNome("gladiador");
			gladiador.setPrefix("§5[Gladiador] ");

			guerreiro.setNome("guerreiro");
			guerreiro.setPrefix("§3[Guerreiro] ");
			
			manager.getCargos().add(diretor.getCargo());
			manager.getCargos().add(gerente.getCargo());
			manager.getCargos().add(admin.getCargo());
			manager.getCargos().add(dev.getCargo());
			manager.getCargos().add(mod.getCargo());
			manager.getCargos().add(builder.getCargo());
			manager.getCargos().add(ajd.getCargo());
			manager.getCargos().add(yt.getCargo());
			manager.getCargos().add(titan.getCargo());
			manager.getCargos().add(gladiador.getCargo());
			manager.getCargos().add(guerreiro.getCargo());
			
			manager.getTags().add(diretor);
			manager.getTags().add(gerente);
			manager.getTags().add(admin);
			manager.getTags().add(dev);
			manager.getTags().add(mod);
			manager.getTags().add(builder);
			manager.getTags().add(ajd);
			manager.getTags().add(yt);
			manager.getTags().add(titan);
			manager.getTags().add(gladiador);
			manager.getTags().add(guerreiro);
			save();
		}
	}

	public static void save() {
		config.set("tags", manager);
		config.saveConfig();
	}

}
