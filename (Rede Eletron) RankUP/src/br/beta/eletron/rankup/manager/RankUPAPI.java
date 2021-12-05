package br.beta.eletron.rankup.manager;

import br.beta.eletron.rankup.Main;
import br.beta.eletron.rankup.api.ConfigAPI;
import br.beta.eletron.rankup.api.StorageAPI;

public class RankUPAPI {
	private static RankUPManager manager;

	public RankUPAPI() {
	}

	private static ConfigAPI config = new ConfigAPI("rank.yml", Main.instance);

	public static void reload() {
		if (config.contains("ranks")) {
			manager = (RankUPManager) config.get("ranks");
			StorageAPI.updateReferences();
		} else {
			manager = new RankUPManager();
			RankUP rank = new RankUP();
			rank.setLevel(0);
			rank.setNome("teste");
			rank.setPrefix("teste");
			rank.setPreco(1);
			RankUP rank1 = new RankUP();
			rank1.setLevel(1);
			rank1.setNome("teste1");
			rank1.setPrefix("teste1");
			rank1.setPreco(2);
			manager.getRanks().add(rank);
			manager.getRanks().add(rank1);
			save();
		}
	}

	public static RankUPManager getManager() {
		return manager;
	}

	public static void setManager(RankUPManager manager) {
		RankUPAPI.manager = manager;
	}

	public static ConfigAPI getConfig() {
		return config;
	}

	public static void setConfig(ConfigAPI config) {
		RankUPAPI.config = config;
	}

	public static void save() {
		config.set("ranks", manager);
		config.saveConfig();
	}

}
