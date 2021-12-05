package me.ninjay.czeventos.estruturas;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.ninjay.czeventos.main.Main;
import me.ninjay.czeventos.utils.VaultAPI;

public class GlobalAPI {
	
	public static ArrayList<Player> BolaoParticipando = new ArrayList<>();
	public static boolean BolaoAcontecendo = false;
	
	//MENSAGENS
	
	public static String getAvisoBolao() {
		return Main.global.getString("AvisoBolao").replace("&", "§");
	}
	
	public static String getAvisoLoteria() {
		return Main.global.getString("AvisoLoteria").replace("&", "§");
	}
	
	public static String getErroBolao() {
		return Main.global.getString("ErroBolao").replace("&", "§");
	}
	
	public static String getErroLoteria() {
		return Main.global.getString("ErroLoteria").replace("&", "§");
	}
	
	public static String getSemPerm() {
		return Main.global.getString("SemPerm").replace("&", "§");
	}
	
	public static String getNomeNPC() {
		return Main.global.getString("NomeNpc").replace("&", "§");
	}
	
	public static String getNomeTicketRandom() {
		return Main.global.getString("NomeTicketRandom").replace("&", "§");
	}
	
	public static String getNomeTicket() {
		return Main.global.getString("NomeTicket").replace("&", "§");
	}
	
	public static String getNomeQuanto() {
		return Main.global.getString("NomeQuanto").replace("&", "§");
	}
	
	public static String getEntrouBolao() {
		return Main.global.getString("EntrouBolao").replace("&", "§");
	}
	
	public static String getEntrouLoteria() {
		return Main.global.getString("EntrouLoteria").replace("&", "§");
	}
	
	public static String getSemDinheiroParticipar() {
		return Main.global.getString("DinheiroParticipar").replace("&", "§");
	}
	
	public static String getSemDinheiroComprar() {
		return Main.global.getString("DinheiroComprar").replace("&", "§");
	}
	
	public static String getNaoOcorrendo() {
		return Main.global.getString("NaoOcorrendo").replace("&", "§");
	}
	
	public static String getAdminOcorrendo() {
		return Main.global.getString("AdminOcorrendo").replace("&", "§");
	}
	
	public static String getFimBolao() {
		return Main.global.getString("FimBolao").replace("&", "§");
	}
	
	public static String getFimLoteria() {
		return Main.global.getString("FimLoteria").replace("&", "§");
	}
	
	//MENSAGENS
	
	//BOLÃO
	
	public static Long getBolaoValorInicial() {
		return Main.bolao.getLong("ValorInicial");
	}
	
	public static Long getBolaoValorFinal() {
		return Main.bolao.getLong("ValorFinal");
	}
	
	public static Long getBolaoTempo() {
		return Main.bolao.getLong("Tempo");
	}
	
	public static String getBolaoGanhador() {
		return Main.bolao.getString("Ganhador");
	}
	
	public static void iniciarBolao(Player p, Long valor, Long minutos) {
		if(BolaoAcontecendo == false) {
		Bukkit.broadcastMessage(getAvisoBolao().replace("BvalorinicialB", ""+valor).replace("BtempoB", ""+minutos).replace("BvalorfinalB", ""+getBolaoValorFinal()));
	    Main.bolao.set("ValorInicial", valor);
	    Main.bolao.saveConfig();
	    Main.bolao.set("Tempo", minutos*60);
	    Main.bolao.saveConfig();
	    BolaoAcontecendo = true;
	}else {
		p.sendMessage(getAdminOcorrendo());
	}
	}
	
	public static void entrarBolao(Player p) {
		if(BolaoAcontecendo == true) {
		if(VaultAPI.getEconomy().has(p, getBolaoValorInicial())) {
		p.sendMessage(getEntrouBolao().replace("BvalorinicialB", ""+getBolaoValorInicial()).replace("BtempoB", ""+getBolaoTempo()).replace("BvalorfinalB", ""+getBolaoValorFinal()));
	    VaultAPI.getEconomy().withdrawPlayer(p, getBolaoValorInicial());
	    BolaoParticipando.add(p);
	    return;
		}else {
			p.sendMessage(getSemDinheiroParticipar().replace("BvalorinicialB", ""+getBolaoValorInicial()).replace("BtempoB", ""+getBolaoTempo()).replace("BvalorfinalB", ""+getBolaoValorFinal()));
		    return;
		}
		}else {
			p.sendMessage(getNaoOcorrendo().replace("BvalorinicialB", ""+getBolaoValorInicial()).replace("BtempoB", ""+getBolaoTempo()).replace("BvalorfinalB", ""+getBolaoValorFinal()));
		    return;
		}
	}
	
	public static void acabarBolao() {
		Bukkit.broadcastMessage(getFimBolao().replace("BvalorinicialB", ""+getBolaoValorInicial()).replace("BtempoB", ""+getBolaoTempo()).replace("BvalorfinalB", ""+getBolaoValorFinal()).replace("BganhadorB", ""+getBolaoGanhador()));
	    
	}
	
	//BOLÃO
	

}
