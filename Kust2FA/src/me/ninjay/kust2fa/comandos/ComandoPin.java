package me.ninjay.kust2fa.comandos;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.kust2fa.eventos.EventosGeral;
import me.ninjay.kust2fa.main.Main;
import me.ninjay.kust2fa.utils.Mine;

public class ComandoPin implements CommandExecutor{
	
	public static void main(String[] args) {
		
		if(args.length == 8) {
			int a = Mine.toInt(args[0]);
			int b = Mine.toInt(args[1]);
			int c = Mine.toInt(args[2]);
			int d = Mine.toInt(args[3]);
			int e = Mine.toInt(args[4]);
			int f = Mine.toInt(args[5]);
			if(StringUtils.isNumeric(args[0])) {
				a=Mine.toInt(args[0]);
			}else if(args[0].equalsIgnoreCase("a")) {
				a=10;
			}else if(args[0].equalsIgnoreCase("b")) {
				a=11;
			}else if(args[0].equalsIgnoreCase("c")) {
				a=12;
			}else if(args[0].equalsIgnoreCase("d")) {
				a=13;
			}else if(args[0].equalsIgnoreCase("e")) {
				a=14;
			}else if(args[0].equalsIgnoreCase("f")) {
				a=15;
			}
			
			if(StringUtils.isNumeric(args[1])) {
				b=Mine.toInt(args[1]);
			}else if(args[1].equalsIgnoreCase("a")) {
				b=10;
			}else if(args[1].equalsIgnoreCase("b")) {
				b=11;
			}else if(args[1].equalsIgnoreCase("c")) {
				b=12;
			}else if(args[1].equalsIgnoreCase("d")) {
				b=13;
			}else if(args[1].equalsIgnoreCase("e")) {
				b=14;
			}else if(args[1].equalsIgnoreCase("f")) {
				b=15;
			}
			
			if(StringUtils.isNumeric(args[2])) {
				c=Mine.toInt(args[2]);
			}else if(args[2].equalsIgnoreCase("a")) {
				c=10;
			}else if(args[2].equalsIgnoreCase("b")) {
				c=11;
			}else if(args[2].equalsIgnoreCase("c")) {
				c=12;
			}else if(args[2].equalsIgnoreCase("d")) {
				c=13;
			}else if(args[2].equalsIgnoreCase("e")) {
				c=14;
			}else if(args[2].equalsIgnoreCase("f")) {
				c=15;
			}
			
			if(StringUtils.isNumeric(args[3])) {
				d=Mine.toInt(args[3]);
			}else if(args[3].equalsIgnoreCase("a")) {
				d=10;
			}else if(args[3].equalsIgnoreCase("b")) {
				d=11;
			}else if(args[3].equalsIgnoreCase("c")) {
				d=12;
			}else if(args[3].equalsIgnoreCase("d")) {
				d=13;
			}else if(args[3].equalsIgnoreCase("e")) {
				d=14;
			}else if(args[3].equalsIgnoreCase("f")) {
				d=15;
			}
			
			if(StringUtils.isNumeric(args[4])) {
				e=Mine.toInt(args[4]);
			}else if(args[4].equalsIgnoreCase("a")) {
				e=10;
			}else if(args[4].equalsIgnoreCase("b")) {
				e=11;
			}else if(args[4].equalsIgnoreCase("c")) {
				e=12;
			}else if(args[4].equalsIgnoreCase("d")) {
				e=13;
			}else if(args[4].equalsIgnoreCase("e")) {
				e=14;
			}else if(args[4].equalsIgnoreCase("f")) {
				e=15;
			}
			
			if(StringUtils.isNumeric(args[5])) {
				f=Mine.toInt(args[5]);
			}else if(args[5].equalsIgnoreCase("a")) {
				f=10;
			}else if(args[5].equalsIgnoreCase("b")) {
				f=11;
			}else if(args[5].equalsIgnoreCase("c")) {
				f=12;
			}else if(args[5].equalsIgnoreCase("d")) {
				f=13;
			}else if(args[5].equalsIgnoreCase("e")) {
				f=14;
			}else if(args[5].equalsIgnoreCase("f")) {
				f=15;
			}

			System.out.println((a*16+b)+" | "+(c*16+d)+" | "+(e*16+f));
			
		}
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
		if(p.hasPermission("pin.staff")) {
			if(args.length == 0) {
				p.sendMessage("§cUtilize: /pin [chave]!");
				return true;
			}
			
		if(EventosGeral.auth.get(p) == false) {
			for(int i = 1; i <= Main.config.getInt("staff"); i++) {
				if(Main.config.contains(p.getName())) {
					if(args[0].equals(Main.config.getString(Main.config.getInt(p.getName())+"_chave"))) {
						EventosGeral.auth.put(p, true);
					}
				}else {
					p.sendMessage("§cSeu nick não está inserido na configuração");
				}
			}
		}else {
			p.sendMessage("§cVocê já está autentificado!");
		}
		}
		}else {
		if(args.length > 0) {
			if(args[0].equalsIgnoreCase("gerar")) {
				Main.config.reloadConfig();
				sender.sendMessage("§aChaves geradas!");
				ArrayList<String> simbols = new ArrayList<>();
				ArrayList<String> letras = new ArrayList<>();
				
				simbols.add("!");
				simbols.add("@");
				simbols.add("#");
				simbols.add("$");
				simbols.add("%");
				simbols.add("¨");
				simbols.add("&");
				simbols.add("*");
				simbols.add("(");
				simbols.add(")");
				simbols.add("_");
				simbols.add("-");
				simbols.add("=");
				simbols.add("+");
				simbols.add("[");
				simbols.add("]");
				simbols.add("^");
				simbols.add("~");
				simbols.add("{");
				simbols.add("}");
				simbols.add("/");
				simbols.add("|");
				
				letras.add("a");
				letras.add("b");
				letras.add("c");
				letras.add("d");
				letras.add("e");
				letras.add("f");
				letras.add("g");
				letras.add("h");
				letras.add("i");
				letras.add("j");
				letras.add("k");
				letras.add("l");
				letras.add("m");
				letras.add("n");
				letras.add("o");
				letras.add("p");
				letras.add("q");
				letras.add("r");
				letras.add("s");
				letras.add("t");
				letras.add("u");
				letras.add("v");
				letras.add("w");
				letras.add("x");
				letras.add("y");
				letras.add("z");
				
				
				for(int i = 1; i <= Main.config.getInt("staff"); i++) {
					String chave = Mine.toString(Mine.getRandomInt(1, 300)+Mine.getRandom(simbols)+Mine.getRandom(letras)+Mine.getRandom(simbols)+Mine.getRandom(letras)+Mine.getRandom(simbols)+Mine.getRandom(letras)+Mine.getRandom(simbols)+Mine.getRandom(letras)+Mine.getRandom(letras)+Mine.getRandom(letras)+Mine.getRandom(simbols)+Mine.getRandom(simbols)+Mine.getRandom(letras)+Mine.getRandom(simbols)+Mine.getRandom(letras)+Mine.getRandom(simbols)+Mine.getRandom(letras)+Mine.getRandom(simbols)+Mine.getRandom(letras)+Mine.getRandom(letras)+Mine.getRandom(letras)+Mine.getRandomInt(1, 300)+Mine.getRandom(simbols)+Mine.getRandom(simbols));
					Main.config.set(i+"_chave", chave);
					Main.config.saveConfig();
				}
				
			}
		}
		}
		return false;
	}

}
