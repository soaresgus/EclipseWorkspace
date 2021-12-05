package me.ninjay.oneperfil.ranks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.oneperfil.main.Main;
import net.eduard.api.lib.BukkitConfig;

public class RankUpAPI {

	public static BukkitConfig config = new BukkitConfig("ranks.yml", Main.getPlugin(Main.class));
	public static RankUpManager manager;
	
	public static void reload() {
		config.reloadConfig();
		if(config.contains("ranks")) {
			manager = (RankUpManager) config.get("ranks");
		}else {
			manager = new RankUpManager();
			
			RankUp um = new RankUp();
			RankUp dois = new RankUp();
			RankUp tres = new RankUp();
			RankUp quatro = new RankUp();
			RankUp cinco = new RankUp();
			RankUp seis = new RankUp();
			RankUp sete = new RankUp();
			RankUp oito = new RankUp();
			RankUp nove = new RankUp();
			RankUp dez = new RankUp();
			
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
			
			um.setAlmas((long)0); 
			um.setCoins((double)0);
			um.setEventos((long)0);
			um.setHoras((long)0);
			um.setBlocos((long)10000);
			
			dois.setAlmas((long)0); 
			dois.setCoins((double)300000);
			dois.setEventos((long)0);
			dois.setHoras((long)0);
			dois.setBlocos((long)0);
			
			tres.setAlmas((long)0); 
			tres.setCoins((double)0);
			tres.setEventos((long)0);
			tres.setHoras((long)12);
			tres.setBlocos((long)0);
			
			quatro.setAlmas((long)150); 
			quatro.setCoins((double)0);
			quatro.setEventos((long)0);
			quatro.setHoras((long)0);
			quatro.setBlocos((long)0);
			
			cinco.setAlmas((long)0); 
			cinco.setCoins((double)0);
			cinco.setEventos((long)0);
			cinco.setHoras((long)20);
			cinco.setBlocos((long)0);
			
			seis.setAlmas((long)250); 
			seis.setCoins((double)0);
			seis.setEventos((long)0);
			seis.setHoras((long)0);
			seis.setBlocos((long)0);
			
			sete.setAlmas((long)0); 
			sete.setCoins((double)1000000);
		    sete.setEventos((long)0);
			sete.setHoras((long)0);
			sete.setBlocos((long)0);
			
			oito.setAlmas((long)0); 
			oito.setCoins((double)0);
			oito.setEventos((long)0);
			oito.setHoras((long)50);
			oito.setBlocos((long)0);
			
			nove.setAlmas((long)500); 
			nove.setCoins((double)0);
			nove.setEventos((long)0);
			nove.setHoras((long)0);
			nove.setBlocos((long)0);
			
			dez.setAlmas((long)0); 
			dez.setCoins((double)0);
			dez.setEventos((long)5);
			dez.setHoras((long)0);
			dez.setBlocos((long)0);
			
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
	public static void save() {
		config.set("ranks", manager);
		config.saveConfig();
	}

}

	