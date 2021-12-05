package me.ninjay.antiabuso.comandos;


import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.antiabuso.main.Main;
import me.ninjay.antiabuso.utils.Mine;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;

public class ComandoModReq implements CommandExecutor, Listener{
	
	public static ArrayList<String> nick = new ArrayList<>();
	public static HashMap<String, Integer> dado = new HashMap<>();
	public static Integer i;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(dado.get(p.getName()) == 0) {
			p.sendMessage("§aSua solicitação foi enviada, aguarde um staff ir até você.");
			i = 30;
			nick.add(p.getName());
			new BukkitRunnable() {
				@Override
				public void run() {
					i--;
					if(i == 0) {
						dado.put(p.getName(), 0);
						cancel();
						nick.remove(p.getName());
					}
				}
			}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
			}else {
				p.sendMessage("§cAguarde "+Mine.formatarTempoHMS(i)+" para solicitar um staff.");
				}
			for(Player all : Bukkit.getOnlinePlayers()) {
				if(all.hasPermission("modreq.perm")) {
					if(dado.get(p.getName()) == 0) {
					dado.put(p.getName(), 1);
					TextComponent texto = new TextComponent("§aClique §a§lAQUI §apara se teleportar.");
					ClickEvent evento = new ClickEvent(Action.SUGGEST_COMMAND, "/teleportar "+p.getName());
					texto.setClickEvent(evento);
					all.sendMessage("§aO jogador §a§l"+p.getName()+" §asolicitou um staff.\n ");
					all.spigot().sendMessage(texto);
					return true;
				}
				}
			}
		}
		return false;
	}
	
}
