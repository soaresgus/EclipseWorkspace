package me.ninjay.aureaup.estruturas;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.aureaup.main.Main;
import me.ninjay.aureaup.utils.BukkitConfig;


public class LoginAPI implements Listener{

	public static ArrayList<Player> logando = new ArrayList<>();
	public static ArrayList<Player> logado = new ArrayList<>();

	public static void entrar(Player p, BukkitConfig config) {
		if (config.contains(p.getName())) {
			p.sendMessage("§cUtilize: /login <senha>");
			logando.add(p);
			new BukkitRunnable() {
				int i = 60;

				@Override
				public void run() {
					i--;

					if (i == 59) {
						if (logando.contains(p)) {
							p.sendMessage("§cUtilize: /login <senha>");
						} else {

							return;
						}
					}
					if (i == 50) {
						if (logando.contains(p)) {
							p.sendMessage("§cUtilize: /login <senha>");
						} else {

							return;
						}
					}
					if (i == 40) {

						if (logando.contains(p)) {
							p.sendMessage("§cUtilize: /login <senha>");
						} else {

							return;
						}
					}
					if (i == 30) {
						if (logando.contains(p)) {
							p.sendMessage("§cUtilize: /login <senha>");
						} else {

							return;
						}
					}
					if (i == 20) {
						if (logando.contains(p)) {
							p.sendMessage("§cUtilize: /login <senha>");
						} else {

							return;
						}
					}
					if (i == 10) {
						if (logando.contains(p)) {
							p.sendMessage("§cUtilize: /login <senha>");
						} else {

							return;
						}
					}
					if (i == 0) {
						cancel();
						if (logando.contains(p)) {
							p.kickPlayer("§c§lAurea\n§c      Você atingiu o tempo limite para logar.");
						} else {

							return;
						}
					}
				}
			}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
		}
		if (!config.contains(p.getName())) {
			p.sendMessage("§cUtilize: /register <senha>");
			logando.add(p);
			
			new BukkitRunnable() {
				int i = 60;

				@Override
				public void run() {
					i--;

					if (i == 59) {
						if (logando.contains(p)) {
							p.sendMessage("§cUtilize: /register <senha>");
						} else {

							return;
						}
					}
					if (i == 50) {
						if (logando.contains(p)) {
							p.sendMessage("§cUtilize: /register <senha>");
						} else {

							return;
						}
					}
					if (i == 40) {
						if (logando.contains(p)) {
							p.sendMessage("§cUtilize: /register <senha>");
						} else {

							return;
						}
					}
					if (i == 30) {
						if (logando.contains(p)) {
							p.sendMessage("§cUtilize: /register <senha>");
						} else {

							return;
						}
					}
					if (i == 20) {
						if (logando.contains(p)) {
							p.sendMessage("§cUtilize: /register <senha>");
						} else {

							return;
						}
					}
					if (i == 10) {
						if (logando.contains(p)) {
							p.sendMessage("§cUtilize: /register <senha>");
						} else {

							return;
						}
					}
					if (i == 0) {
						cancel();
						if (logando.contains(p)) {
							p.kickPlayer("§c§lAurea\n§c      Você atingiu o tempo limite para logar.");
						} else {

							return;
						}
					}
				}
			}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
		}
	}

	public static void registrar(Player p, String senha, BukkitConfig config) {
		if (logado.contains(p)) {
			p.sendMessage("§cVocê já está logado.");
			return;
		}
		if (config.contains(p.getName())) {
			p.sendMessage("§cVocê já está registrado, utilize: /login <senha>");
			return;
		}
		if (!config.contains(p.getName())) {
			if (logando.contains(p)) {
				p.sendMessage("§aRegistrado com sucesso !");

				logando.remove(p);
				logado.add(p);
				config.set(p.getName(), senha);
				config.saveConfig();
			}
		}
	}

	public static void logar(Player p, String senha, BukkitConfig config) {
		if (logado.contains(p)) {
			p.sendMessage("§cVocê já está logado.");
			return;
		}
		if (!config.contains(p.getName())) {
			p.sendMessage("§cVocê não está registrado, utilize: /register <senha>");
			return;
		}
		if (config.contains(p.getName())) {
			if (logando.contains(p)) {
				if (senha.equals(config.getString(p.getName()))) {
					p.sendMessage("§aLogado com sucesso !");
					logando.remove(p);

					logado.add(p);
					return;
				} else {
					p.sendMessage("§cSua senha está errada, tente novamente.");
					return;
				}
			}
		}

	}

	public static void sair(Player p) {
		logando.remove(p);
		logado.remove(p);
	}

	public static void trocarSenha(Player p, String senha, BukkitConfig config) {
		if (logando.contains(p)) {
			p.sendMessage("§cLogue primeiro para poder trocar sua senha.");
			return;
		}
		if (logado.contains(p)) {
			p.sendMessage("§aSenha trocada com sucesso !");
			config.set(p.getName(), senha);
			config.saveConfig();
		}
	}
	
	public static boolean hasLogando(Player p) {
		return logando.contains(p);
	}
	
	@EventHandler
	public static void aoFalar(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		if(hasLogando(p) == true) {
			e.setCancelled(true);
			p.sendMessage("§cLogue para poder falar.");
		}
	}
	
	@EventHandler
	public static void aoComando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		
		if(hasLogando(p) == true) {
			if(e.getMessage().contains("/register") || e.getMessage().contains("/login") || e.getMessage().contains("/trocarsenha") || e.getMessage().contains("/logar") || e.getMessage().contains("/registrar") || e.getMessage().contains("/changeepassword")) {
				e.setCancelled(false);
			}else {
				e.setCancelled(true);
				p.sendMessage("§cLogue para poder usar comandos.");
			}
		}
		
	}
	
	@EventHandler
	public static void aoMovimento(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(hasLogando(p) == true) {
			e.setCancelled(true);
		}
	}
	


}
