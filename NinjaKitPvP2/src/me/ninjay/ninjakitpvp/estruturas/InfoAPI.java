package me.ninjay.ninjakitpvp.estruturas;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.ninjay.ninjakitpvp.main.Main;
import me.ninjay.ninjakitpvp.utils.Mine;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.HoverEvent.Action;

public class InfoAPI implements Listener {

	public static void enviar(Player p) {
		TextComponent ip = new TextComponent(" §fIP: §a§lPASSE O MOUSE");
		BaseComponent[] ips = new ComponentBuilder("§7" + Mine.getIp(p)).create();
		HoverEvent iph = new HoverEvent(Action.SHOW_TEXT, ips);
		ip.setHoverEvent(iph);

		TextComponent senha = new TextComponent(" §fSenha: §a§lPASSE O MOUSE");
		BaseComponent[] senhas = new ComponentBuilder("§7Não registrado.").create();
		HoverEvent senhah = new HoverEvent(Action.SHOW_TEXT, senhas);
		senha.setHoverEvent(senhah);
		p.sendMessage("§aInformações\n §fStatus: §7Online\n §fNick: §7" + p.getName() + "\n §fKills: §7" + getKills(p)
				+ "\n §fMortes: §7" + getMortes(p) + "\n §fCoins: §7" + CoinsAPI.get(p, Main.cash)
				+ "\n §fServidor: §7kitpvp-1");
		p.spigot().sendMessage(ip);
		p.spigot().sendMessage(senha);
		p.sendMessage(" ");
	}

	public static int getKills(Player p) {
		return Main.info.getInt(p.getName() + "Kills");
	}

	public static void addKill(Player p) {
		Main.info.add(p.getName() + "Kills", Main.info.getInt(p.getName()+"Kills")+1);
		Main.info.saveConfig();
	}

	public static int getMortes(Player p) {
		return Main.info.getInt(p.getName() + "Mortes");
	}

	public static void addMorte(Player p) {
		Main.info.add(p.getName() + "Mortes", Main.info.getInt(p.getName()+"Mortes")+1);
		Main.info.saveConfig();
	}

	
}
