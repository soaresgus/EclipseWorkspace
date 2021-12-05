package net.b_bolsa.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.b_bolsa.Main;

public class BolsaCommand implements CommandExecutor {

	public static String getTempo(long time) {
		long variacao = time;
		long varsegundos = variacao / 1000 % 60;
		long varminutos = variacao / 60000 % 60;
		long varhoras = variacao / 3600000 % 24;
		long vardias = variacao / 86400000 % 30;

		String segundos = String.valueOf(varsegundos).replaceAll("-", "");
		String minutos = String.valueOf(varminutos).replaceAll("-", "");
		String horas = String.valueOf(varhoras).replaceAll("-", "");
		String dias = String.valueOf(vardias).replaceAll("-", "");
		if (dias.equals("0") && horas.equals("0") && minutos.equals("0")) {
			return segundos + "s";
		}
		if (dias.equals("0") && horas.equals("0")) {
			return minutos + "m " + segundos + "s";
		}
		if (dias.equals("0")) {
			return horas + "h " + minutos + "m " + segundos + "s";
		}
		return dias + "d " + horas + "h " + minutos + "m " + segundos + "s";
	}

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String lb, String[] args) {
		if (s instanceof Player) {
			Player p = (Player) s;
			String estado = Main.getInstance().b.estaBaixa() ? "§cbaixa" : "§aalta";
			if (cmd.getName().equalsIgnoreCase("bolsa")) {
				if (Main.getInstance().b.getTime() >= System.currentTimeMillis()) {
					p.sendMessage(" ");
					p.sendMessage("§7Bolsa de valores: §f" + Main.getInstance().b.getPorcentagem() + "§7%");
					p.sendMessage("§7Se encontra em " + estado + "§7.");
					p.sendMessage("§7Atualiza em §faguardando atualizar§7.");
					p.sendMessage(" ");
					return true;
				}
				p.sendMessage(" ");
				p.sendMessage("§7Bolsa de valores: §f" + Main.getInstance().b.getPorcentagem() + "§7%");
				p.sendMessage("§7Se encontra em " + estado + "§7.");
				p.sendMessage("§7Atualiza em §f" + getTempo(Main.getInstance().b.dif()) + "§7.");
				p.sendMessage(" ");
			}
		}
		return true;
	}

}
