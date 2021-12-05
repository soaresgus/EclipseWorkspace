package me.ninjay.kustcash.estruturas;

import me.ninjay.kustcash.main.Main;
import me.ninjay.kustcash.utils.Mine;

public class CashAPI {
	
	//Main.sql.update("INSERT INTO `youtuber` (`NICK`, `DATA`, `NOME`, `LINK`, `ID`) VALUES ('"+p.getName()+"', '08/04/2021', 'teste', 'youtube.com/c/luizh222', NULL)");
	
	public static int getCash(String player) {
		return Mine.toInt(Main.sql.getString("cash", "CASH", "NICK='"+player+"'"));
	}
	
	public static void addCash(String player, int qntd) {
		int i = Main.sql.getInt("cash", "CASH", "NICK='"+player+"'")+qntd;
		int i2 = (Main.sql.getInt("cash", "CASH", "NICK='"+player+"'")+qntd)+1;
		
		if(Main.sql.getInt("cash", "CASH", "NICK='"+player+"'") == -1) {
			Main.sql.update("INSERT INTO `cash` (`NICK`, `CASH`) VALUES ('"+player+"', '"+i2+"')");
		}else {
			Main.sql.update("UPDATE `cash` SET `CASH` = "+i+" WHERE `NICK` = '"+player+"'");
		}
	}
	
	public static void removeCash(String player, int qntd) {
		int i = Main.sql.getInt("cash", "CASH", "NICK='"+player+"'")-qntd;
		
		if(Main.sql.contains("cash", "NICK='"+player+"'")) {
			if(Main.sql.getInt("cash", "CASH", "NICK='"+player+"'") >= qntd) {
				Main.sql.update("UPDATE `cash` SET `CASH` = "+i+" WHERE `NICK` = '"+player+"'");
			}
		}
	}
	
	public static boolean hasCash(String player, int qntd) {
		return getCash(player) >= qntd;
	}
	
}
