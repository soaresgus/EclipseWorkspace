package me.ninjay.ninjaapi.bukkit.EventoAPI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.ninjaapi.main.Main;
import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.ninjaapi.utils.Storable;

public class EventoManager implements Storable {
	public static EventoTempo tempo;
	public static ArrayList<Player> morte = new ArrayList<>();
	public static ArrayList<Player> jogando = new ArrayList<>();
	public static boolean ocorrendo = false;
	
	public Evento getevento(String nome) {
		for (Evento evento : eventos) {
			if (evento.getNome().equalsIgnoreCase(nome)) {
				return evento;
			}
		}
		return null;

	}

	public Evento geteventoint(int number) {
		for (Evento evento : eventos) {
			if (evento.getNumber() == number) {
				return evento;
			}
		}
		return null;

	}

	public Evento geteventocomando(String comando) {
		for (Evento evento : eventos) {
			if (evento.getComando().equalsIgnoreCase(comando)) {
				return evento;
			}
		}
		return null;
	}

	private ArrayList<Evento> eventos = new ArrayList<>();

	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}

	public static void iniciar(Player p, Evento evento) {
		if (ocorrendo == true) {
			p.sendMessage("§cJá existe um evento ocorrendo, aguarde.");
			return;
		} else {
			tempo = EventoTempo.PRE;
			ocorrendo = true;
			new BukkitRunnable() {
				int i = 180;

				@Override
				public void run() {
					i--;
					if (i == 179) {
						Mine.sendTitle("§e§lEvento", "§eLeia o chat para mais informações.", 5, 100, 5);
						Bukkit.broadcastMessage(
								"§e§lEvento - " + evento.getNome().toUpperCase() + "\n \n§eTempo para iniciar: §6" + i
										+ " segundos\n \n§ePara entrar utilize §6/" + evento.getComando() + "\n ");
					}
					if (i == 150) {
						Mine.sendTitle("§e§lEvento", "§eLeia o chat para mais informações.", 5, 100, 5);
						Bukkit.broadcastMessage(
								"§e§lEvento - " + evento.getNome().toUpperCase() + "\n \n§eTempo para iniciar: §6" + i
										+ " segundos\n \n§ePara entrar utilize §6/" + evento.getComando() + "\n ");
					}
					if (i == 120) {
						Mine.sendTitle("§e§lEvento", "§eLeia o chat para mais informações.", 5, 100, 5);
						Bukkit.broadcastMessage(
								"§e§lEvento - " + evento.getNome().toUpperCase() + "\n \n§eTempo para iniciar: §6" + i
										+ " segundos\n \n§ePara entrar utilize §6/" + evento.getComando() + "\n ");
					}
					if (i == 90) {
						Mine.sendTitle("§e§lEvento", "§eLeia o chat para mais informações.", 5, 100, 5);
						Bukkit.broadcastMessage(
								"§e§lEvento - " + evento.getNome().toUpperCase() + "\n \n§eTempo para iniciar: §6" + i
										+ " segundos\n \n§ePara entrar utilize §6/" + evento.getComando() + "\n ");
					}
					if (i == 60) {
						Mine.sendTitle("§e§lEvento", "§eLeia o chat para mais informações.", 5, 100, 5);
						Bukkit.broadcastMessage(
								"§e§lEvento - " + evento.getNome().toUpperCase() + "\n \n§eTempo para iniciar: §6" + i
										+ " segundos\n \n§ePara entrar utilize §6/" + evento.getComando() + "\n ");
					}
					if (i == 30) {
						Mine.sendTitle("§e§lEvento", "§eLeia o chat para mais informações.", 5, 100, 5);
						Bukkit.broadcastMessage(
								"§e§lEvento - " + evento.getNome().toUpperCase() + "\n \n§eTempo para iniciar: §6" + i
										+ " segundos\n \n§ePara entrar utilize §6/" + evento.getComando() + "\n ");
					}
					if (i == 10) {
						Mine.sendTitle("§e§lEvento", "§eLeia o chat para mais informações.", 5, 100, 5);
						Bukkit.broadcastMessage(
								"§e§lEvento - " + evento.getNome().toUpperCase() + "\n \n§eTempo para iniciar: §6" + i
										+ " segundos\n \n§ePara entrar utilize §6/" + evento.getComando() + "\n ");
					}
					if (i == 0) {
						cancel();
						tempo = EventoTempo.JOGO;
						Mine.sendTitle("§e§lEvento", "§eLeia o chat para mais informações.", 5, 100, 5);
						Bukkit.broadcastMessage("§e§lEvento - " + evento.getNome().toUpperCase()
								+ "\n \n§eEvento fechado e iniciado.\n ");
						jogo(evento);
					}

				}
			}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);

		}
	}

	public static void entrar(Player p, Evento evento) {
		if (ocorrendo == false) {
			p.sendMessage("§cO evento não está ocorrendo.");
		}
		if (jogando.contains(p)) {
			p.sendMessage("§cVocê já está no evento.");
			return;
		}
		if (morte.contains(p)) {
			p.sendMessage("§cVocê já morreu, mais sorte na próxima vez.");
			return;
		}
		if (tempo == EventoTempo.JOGO) {
			p.sendMessage("§cO jogo já iniciou.");
			return;
		}
		if (tempo == EventoTempo.PRE) {
			if (!morte.contains(p)) {
				if (!jogando.contains(p)) {
					if (ocorrendo == true) {
						p.sendMessage("§eVocê entrou no evento !\n \n" + evento.getComoJogar() + "\n ");
						p.teleport(Main.locais.getLocation("pre"));
						jogando.add(p);
						for (Player todos : Bukkit.getOnlinePlayers()) {
							if (jogando.contains(todos)) {
								todos.getWorld().setPVP(false);
							}
						}
					}
				}
			}
		}
	}

	public static void jogo(Evento evento) {
		for (Player todos : Bukkit.getOnlinePlayers()) {
			if (jogando.contains(todos)) {
				if(evento.isTpAll() == true) {
					todos.teleport(Main.locais.getLocation("jogo"));
				}else {
				todos.getWorld().setPVP(false);
				todos.sendMessage("\n \n§e§lInvencibilidade\n \n§eInvencibilidade encerrando em " + evento.getInv()
						+ " segundos.\n ");
				new BukkitRunnable() {
					int i = evento.getInv();

					@Override
					public void run() {
						i--;
						if (i == 0) {
							cancel();
							todos.sendMessage("\n \n§e§lInvencibilidade \n \n§eInvencibilidade encerrada !\n ");
							todos.getWorld().setPVP(true);
						}
					}
				}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
			}
		}
		}
	}

	public static void morrer(Player p) {
		if (!jogando.contains(p)) {
			return;
		} else if (jogando.contains(p)) {
			p.sendMessage("§cVocê morreu no evento, mais sorte da próxima vez.");
			morte.add(p);
			jogando.remove(p);
			new BukkitRunnable() {
				
				@Override
				public void run() {
					p.teleport(Main.locais.getLocation("morte"));
				}
			}.runTaskLater(Main.getPlugin(Main.class), 2);
			
			
		}
	}

	public static void ganhar(Player p, String tag, String clan, Player ganhador) {
		if(ocorrendo == false) {
			p.sendMessage("§cO evento não está ocorrendo.");
		}else {
		ocorrendo = false;
		tempo = EventoTempo.PRE;
		Bukkit.broadcastMessage("§e§lEvento\n \n§eEvento encerrado.\n \n§eGanhador: §6" + ganhador.getName()
				+ " do clan [" + tag + "] " + clan + "\n ");
		for (Player todos : Bukkit.getOnlinePlayers()) {
			if (jogando.contains(todos)) {
				todos.teleport(Main.locais.getLocation("spawn"));
				
			}

		}
		}
		for (Player todos : Bukkit.getOnlinePlayers()) {
			jogando.remove(todos);
			morte.remove(todos);
		}
	}

	public static void setPre(Player p) {
		Main.locais.set("pre", p.getLocation());
		Main.locais.saveConfig();
	}

	public static void setJogo(Player p) {
		Main.locais.set("jogo", p.getLocation());
		Main.locais.saveConfig();
	}

	public static void setMorte(Player p) {
		Main.locais.set("morte", p.getLocation());
		Main.locais.saveConfig();
	}

	public static void setSpawn(Player p) {
		Main.locais.set("spawn", p.getLocation());
		Main.locais.saveConfig();
	}

}
