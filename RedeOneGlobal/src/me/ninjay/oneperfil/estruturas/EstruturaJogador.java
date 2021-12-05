package me.ninjay.oneperfil.estruturas;

import java.text.NumberFormat;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.oneperfil.main.Main;
import me.ninjay.oneperfil.rankspoo.manager.RankUPAPI;
import net.eduard.api.lib.modules.VaultAPI;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;

public class EstruturaJogador {
	
	public static void perfil(Player p, Inventory inv) {
		SimpleClans sc = SimpleClans.getInstance();
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String dinheiro = formatter.format(VaultAPI.getEconomy().getBalance(p));
		if(sc.getClanManager().getClanPlayer(p) == null) {
			ItemStack perfil = Mine.newHead("§6["+p.getName()+"]", p.getName(), 1,"§6Clan: §e[Nenhum]","§6Coins: §e["+dinheiro.replace(",", ".")+"]","§6Rank: §e["+RankUPAPI.getManager().getRank(p).getPrefix()+"]"," ","§6KDR: §e["+StatsAPI.getKdr(p, Main.kdr)+"]","§6Abates: §e["+StatsAPI.getKills(p, Main.kdr)+"]","§6Mortes: §e["+StatsAPI.getMortes(p, Main.kdr)+"]"," ","§6Blocos Minerados: §e["+BlocosAPI.getBlocos(p, Main.blocos)+"]","§6Horas Online: §e["+DataAPI.getTempoOnline(p, Main.data)+"]"," ","§6Eventos Vitórias (Total): §e["+EventosAPI.getTotal(p, Main.wins)+"]","§6Gladiator Vitórias: §e["+EventosAPI.getWinsGlad(p, Main.wins)+"]","§6Todos Contra Todos Vitórias: §e["+EventosAPI.getWinsTcT(p, Main.wins)+"]","§6Clan x Clan Vitórias: §e["+EventosAPI.getWinsCxC(p, Main.wins)+"]","§6Mobs Vs Player Vitórias: §e["+EventosAPI.getWinsMvP(p, Main.wins)+"]","§6Último Login: §e["+DataAPI.getUltimoLogin(p, Main.data)+"]");
		    inv.setItem(Mine.getPosition(2, 5), perfil);
		    p.openInventory(inv);
		}
		if(sc.getClanManager().getClanPlayer(p) != null) {
		ItemStack perfil2 = Mine.newHead("§6["+p.getName()+"]", p.getName(), 1,"§6Clan: §e["+sc.getClanManager().getClanPlayer(p).getTag().toUpperCase()+"]","§6Coins: §e["+dinheiro.replace(",", ".")+"]","§6Rank: §e["+RankUPAPI.getManager().getRank(p).getPrefix()+"]"," ","§6KDR: §e["+StatsAPI.getKdr(p, Main.kdr)+"]","§6Abates: §e["+StatsAPI.getKills(p, Main.kdr)+"]","§6Mortes: §e["+StatsAPI.getMortes(p, Main.kdr)+"]"," ","§6Blocos Minerados: §e["+BlocosAPI.getBlocos(p, Main.blocos)+"]","§6Horas Online: §e["+DataAPI.getTempoOnline(p, Main.data)+"]"," ","§6Eventos Vitórias (Total): §e["+EventosAPI.getTotal(p, Main.wins)+"]","§6Gladiator Vitórias: §e["+EventosAPI.getWinsGlad(p, Main.wins)+"]","§6Todos Contra Todos Vitórias: §e["+EventosAPI.getWinsTcT(p, Main.wins)+"]","§6Clan x Clan Vitórias: §e["+EventosAPI.getWinsCxC(p, Main.wins)+"]","§6Mobs Vs Player Vitórias: §e["+EventosAPI.getWinsMvP(p, Main.wins)+"]","§6Último Login: §e["+DataAPI.getUltimoLogin(p, Main.data)+"]");
	    inv.setItem(Mine.getPosition(2, 5), perfil2);
	    p.openInventory(inv);
	}
	}
	public static void perfilOther(Player p,Player j, Inventory inv) {
		SimpleClans sc = SimpleClans.getInstance();
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String dinheiro = formatter.format(VaultAPI.getEconomy().getBalance(p));
		if(sc.getClanManager().getClanPlayer(p) == null) {
			ItemStack perfil = Mine.newHead("§6["+p.getName()+"]", p.getName(), 1,"§6Clan: §e[Nenhum]","§6Coins: §e["+dinheiro.replace(",", ".")+"]","§6Rank: §e["+RankUPAPI.getManager().getRank(p).getPrefix()+"]"," ","§6KDR: §e["+StatsAPI.getKdr(p, Main.kdr)+"]","§6Abates: §e["+StatsAPI.getKills(p, Main.kdr)+"]","§6Mortes: §e["+StatsAPI.getMortes(p, Main.kdr)+"]"," ","§6Blocos Minerados: §e["+BlocosAPI.getBlocos(p, Main.blocos)+"]","§6Horas Online: §e["+DataAPI.getTempoOnline(p, Main.data)+"]"," ","§6Eventos Vitórias (Total): §e["+EventosAPI.getTotal(p, Main.wins)+"]","§6Gladiator Vitórias: §e["+EventosAPI.getWinsGlad(p, Main.wins)+"]","§6Todos Contra Todos Vitórias: §e["+EventosAPI.getWinsTcT(p, Main.wins)+"]","§6Clan x Clan Vitórias: §e["+EventosAPI.getWinsCxC(p, Main.wins)+"]","§6Mobs Vs Player Vitórias: §e["+EventosAPI.getWinsMvP(p, Main.wins)+"]","§6Último Login: §e["+DataAPI.getUltimoLogin(p, Main.data)+"]");
		    inv.setItem(Mine.getPosition(2, 5), perfil);
		    j.openInventory(inv);
		}
		if(sc.getClanManager().getClanPlayer(p) != null) {
		ItemStack perfil2 = Mine.newHead("§6["+p.getName()+"]", p.getName(), 1,"§6Clan: §e["+sc.getClanManager().getClanPlayer(p).getTag().toUpperCase()+"]","§6Coins: §e["+dinheiro.replace(",", ".")+"]","§6Rank: §e["+RankUPAPI.getManager().getRank(p).getPrefix()+"]"," ","§6KDR: §e["+StatsAPI.getKdr(p, Main.kdr)+"]","§6Abates: §e["+StatsAPI.getKills(p, Main.kdr)+"]","§6Mortes: §e["+StatsAPI.getMortes(p, Main.kdr)+"]"," ","§6Blocos Minerados: §e["+BlocosAPI.getBlocos(p, Main.blocos)+"]","§6Horas Online: §e["+DataAPI.getTempoOnline(p, Main.data)+"]"," ","§6Eventos Vitórias (Total): §e["+EventosAPI.getTotal(p, Main.wins)+"]","§6Gladiator Vitórias: §e["+EventosAPI.getWinsGlad(p, Main.wins)+"]","§6Todos Contra Todos Vitórias: §e["+EventosAPI.getWinsTcT(p, Main.wins)+"]","§6Clan x Clan Vitórias: §e["+EventosAPI.getWinsCxC(p, Main.wins)+"]","§6Mobs Vs Player Vitórias: §e["+EventosAPI.getWinsMvP(p, Main.wins)+"]","§6Último Login: §e["+DataAPI.getUltimoLogin(p, Main.data)+"]");
	    inv.setItem(Mine.getPosition(2, 5), perfil2);
	    j.openInventory(inv);
	}

}
}
