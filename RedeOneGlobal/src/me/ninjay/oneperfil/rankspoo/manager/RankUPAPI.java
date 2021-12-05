package me.ninjay.oneperfil.rankspoo.manager;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.oneperfil.main.Main;
import net.eduard.api.lib.BukkitConfig;
import net.eduard.api.lib.storage.StorageAPI;

public class RankUPAPI {
	private static RankUPManager manager;

	public RankUPAPI() {
	}

	private static BukkitConfig config = new BukkitConfig("rank.yml", Main.getPlugin(Main.class));

	public static void reload() {
		if (config.contains("ranks")) {
			manager = (RankUPManager) config.get("ranks");
			StorageAPI.updateReferences();
		} else {
			manager = new RankUPManager();
			RankUP zero = new RankUP();
			RankUP um = new RankUP();
			RankUP dois = new RankUP();
			RankUP tres = new RankUP();
			RankUP quatro = new RankUP();
			RankUP cinco = new RankUP();
			RankUP seis = new RankUP();
			RankUP sete = new RankUP();
			RankUP oito = new RankUP();
			RankUP nove = new RankUP();
			RankUP dez = new RankUP();
			
			zero.setNome("Rank [0]");
			um.setNome("Rank [1]");
			dois.setNome("Rank [2]");
			tres.setNome("Rank [3]");
			quatro.setNome("Rank [4]");
			cinco.setNome("Rank [5]");
			seis.setNome("Rank [6]");
			sete.setNome("Rank [7]");
			oito.setNome("Rank [8]");
			nove.setNome("Rank [9]");
			dez.setNome("Rank [10]");
			
			ItemStack umi = Mine.newItem("§6Rank [1]", Material.COAL, 1, 0, "§6Requisitos: §e[10.000 Blocos]");
			ItemStack doisi = Mine.newItem("§6Rank [2]", Material.COAL_ORE, 1, 0, "§6Requisitos: §e[300.000 Coins]");
			ItemStack tresi = Mine.newItem("§6Rank [3]", Material.COAL_BLOCK, 1, 0, "§6Requisitos: §e[12 Horas online]");
			ItemStack quatroi = Mine.newItem("§6Rank [4]", Material.IRON_INGOT, 1, 0, "§6Requisitos: §e[150 Almas]");
			ItemStack cincoi = Mine.newItem("§6Rank [5]", Material.IRON_ORE, 1, 0, "§6Requisitos: §e[20 Horas online]");
			ItemStack seisi = Mine.newItem("§6Rank [6]", Material.IRON_BLOCK, 1, 0, "§6Requisitos: §e[250 Almas]");
			ItemStack setei = Mine.newItem("§6Rank [7]", Material.GOLD_INGOT, 1, 0, "§6Requisitos: §e[1.000.000 Coins]");
			ItemStack oitoi = Mine.newItem("§6Rank [8]", Material.GOLD_ORE, 1, 0, "§6Requisitos: §e[50 Horas online]");
			ItemStack novei = Mine.newItem("§6Rank [9]", Material.GOLD_BLOCK, 1, 0, "§6Requisitos: §e[500 Almas]");
			ItemStack dezi = Mine.newItem("§6Rank [10]", Material.DIAMOND, 1, 0,
					"§6Requisitos: §e[Ter 5 vitórias totais em eventos]");
			
			um.setIcone(umi);
			dois.setIcone(doisi);
			tres.setIcone(tresi);
			quatro.setIcone(quatroi);
			cinco.setIcone(cincoi);
			seis.setIcone(seisi);
			sete.setIcone(setei);
			oito.setIcone(oitoi);
			nove.setIcone(novei);
			dez.setIcone(dezi);
			
			zero.setAlmas((long)0); 
			zero.setPreco((double)0);
			zero.setEventos((long)0);
			zero.setHoras((long)0);
			zero.setBlocos((long)10000);
			
			um.setAlmas((long)0); 
			um.setPreco((double)300000);
			um.setEventos((long)0);
			um.setHoras((long)0);
			um.setBlocos((long)0);
			
			dois.setAlmas((long)0); 
			dois.setPreco((double)0);
			dois.setEventos((long)0);
			dois.setHoras((long)12);
			dois.setBlocos((long)0);
			
			tres.setAlmas((long)150); 
			tres.setPreco((double)0);
			tres.setEventos((long)0);
			tres.setHoras((long)0);
			tres.setBlocos((long)0);
			
			quatro.setAlmas((long)0); 
			quatro.setPreco((double)0);
			quatro.setEventos((long)0);
			quatro.setHoras((long)20);
			quatro.setBlocos((long)0);
			
			cinco.setAlmas((long)240); 
			cinco.setPreco((double)0);
			cinco.setEventos((long)0);
			cinco.setHoras((long)0);
			cinco.setBlocos((long)0);
			
			seis.setAlmas((long)0); 
			seis.setPreco((double)1000000);
			seis.setEventos((long)0);
			seis.setHoras((long)0);
			seis.setBlocos((long)0);
			
			sete.setAlmas((long)0); 
			sete.setPreco((double)0);
		    sete.setEventos((long)0);
			sete.setHoras((long)50);
			sete.setBlocos((long)0);
			
			oito.setAlmas((long)500); 
			oito.setPreco((double)0);
			oito.setEventos((long)0);
			oito.setHoras((long)0);
			oito.setBlocos((long)0);
			
			nove.setAlmas((long)0); 
			nove.setPreco((double)0);
			nove.setEventos((long)5);
			nove.setHoras((long)0);
			nove.setBlocos((long)0);
			
			dez.setAlmas((long)0); 
			dez.setPreco((double)0);
			dez.setEventos((long)0);
			dez.setHoras((long)0);
			dez.setBlocos((long)0);
			
			zero.setLevel(0);
			um.setLevel(1);
		    dois.setLevel(2);
			tres.setLevel(3);
			quatro.setLevel(4);
			cinco.setLevel(5);
			seis.setLevel(6);
			sete.setLevel(7);
			oito.setLevel(8);
			nove.setLevel(9);
			dez.setLevel(10);
			
			zero.setPrefix("Rank [0]");
			um.setPrefix("Rank [1]");
			dois.setPrefix("Rank [2]");
			tres.setPrefix("Rank [3]");
			quatro.setPrefix("Rank [4]");
			cinco.setPrefix("Rank [5]");
			seis.setPrefix("Rank [6]");
			sete.setPrefix("Rank [7]");
			oito.setPrefix("Rank [8]");
			nove.setPrefix("Rank [9]");
			dez.setPrefix("Rank [10]");
			
			zero.setGrupo("0");
			um.setGrupo("1");
			dois.setGrupo("2");
			tres.setGrupo("3");
			quatro.setGrupo("4");
			cinco.setGrupo("5");
			seis.setGrupo("6");
			sete.setGrupo("7");
			oito.setGrupo("8");
			nove.setGrupo("9");
			dez.setGrupo("10");
			
			manager.getRanks().add(zero);
			manager.getRanks().add(um);
			manager.getRanks().add(dois);
			manager.getRanks().add(tres);
			manager.getRanks().add(quatro);
			manager.getRanks().add(cinco);
			manager.getRanks().add(seis);
			manager.getRanks().add(sete);
			manager.getRanks().add(oito);
			manager.getRanks().add(nove);
			manager.getRanks().add(dez);
			save();
		}
	}

	public static RankUPManager getManager() {
		return manager;
	}

	public static void setManager(RankUPManager manager) {
		RankUPAPI.manager = manager;
	}

	public static BukkitConfig getConfig() {
		return config;
	}

	public static void setConfig(BukkitConfig config) {
		RankUPAPI.config = config;
	}

	public static void save() {
		config.set("ranks", manager);
		config.saveConfig();
	}

}
