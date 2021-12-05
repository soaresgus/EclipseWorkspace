package me.ninjay.safestaff.estruturas;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.safestaff.main.Main;
import me.ninjay.safestaff.utils.BukkitConfig;
import me.ninjay.safestaff.utils.Mine;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class PunirControler implements CommandExecutor, Listener{
	
	public static BukkitConfig config = new BukkitConfig("punidos.yml", Main.getPlugin(Main.class));
	
	public static String formatarTempoDHMS(int tempo) {
		 return String.format("%02d dias %02d horas %02d minutos %02d segundos", tempo / 86400, (tempo % 86400) / 3600, (tempo % 3600) / 60, tempo % 60);
	}
	
	public static ArrayList<Player> delay = new ArrayList<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(!p.hasPermission("punir.admin")) {
				p.sendMessage("§cSem permissão.");
			}
			if(p.hasPermission("punir.admin")) {
				if(args.length == 0) {
					p.sendMessage("§cUse: /punir <nick> <motivo> <prova>.");
					return true;
				}
				Player punido = Bukkit.getPlayer(args[0]);
				if(punido == null) {
					p.sendMessage("§cJogador offline.");
				}
				if(punido != null) {
					if(args.length == 1) {
					p.sendMessage(" ");
					
					for(Punir punir : PunirAPI.manager.getPunirs()) {
						TextComponent motivo = new TextComponent("  §f◯ "+punir.getNome());
				        motivo.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(" \n  §7Cargo: §f"+punir.getGrupo().toUpperCase()+" \n  §7"+punir.getDesc()+"\n ").create()));
				        motivo.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir "+punido.getName()+" "+punir.getName()+" <prova>"));
				        p.spigot().sendMessage(motivo);
					}
					
					 p.sendMessage(" \n§eSelecione uma punição para punir o jogador "+p.getName()+".");
				}
					if(args.length == 2) {
						p.sendMessage("§cVocê precisa anexar uma prova a sua punição!");
						return true;
					}
					
					if(args.length != 1) {
						if(args[2].contains(".com")) {
							Punir punir = PunirAPI.manager.getPunirPorNome(args[1]);
							if(punir != null) {
							if(p.hasPermission(punir.getPerm())) {
							if(!delay.contains(punido)) {
							if(punir.isAviso() == true) {
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".avisado") == false) {
								p.sendMessage("§aJogador avisado! Caso ele cometa novamente basta punir novamente.");
								punido.sendMessage(" \n§cVocê foi avisado por um membro da equipe!\nMotivo: "+punir.getNome()+"\nCaso cometer novamente você será punido!\n ");
								config.set(punido.getName()+"."+punir.getName()+".avisado", true);
								config.saveConfig();
								delay.add(punido);
								new BukkitRunnable() {
									
									@Override
									public void run() {
										delay.remove(punido);
									}
								}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 60*20);
								}else {
							if(config.getBoolean(punido.getName()+".punido") == false) {
 								if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban1") == false) {
									punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo1()*3600)));
									config.set(punido.getName()+".prova", args[2]);
									config.saveConfig();
									delay.add(punido);
									TimerAPI.timer(Mine.toInt(punir.getTempo1()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo");
									p.sendMessage("§aJogador punido!");
									new BukkitRunnable() {
										
										@Override
										public void run() {
											delay.remove(punido);
										}
									}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 60*20);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											config.set(punido.getName()+"."+punir.getName()+".ban1", true);
											config.saveConfig();
											config.set(punido.getName()+".punido", true);
											config.saveConfig();
										}
									}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
									if(punir.isBan1() == false) {
										config.set(punido.getName()+".status", "mutado");
										config.saveConfig();
									}else {
										config.set(punido.getName()+".status", "banido");
										config.saveConfig();
										punido.kickPlayer("       §c§lSAFE CLUB\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo1()*3600)));
									}
								}
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban1") == true) {
									if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban2") == false) {
										punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo2()*3600)));
										p.sendMessage("§aJogador punido!");
										config.set(punido.getName()+".prova", args[2]);
										config.saveConfig();
										delay.add(punido);
										TimerAPI.timer(Mine.toInt(punir.getTempo2()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo");
										new BukkitRunnable() {
											
											@Override
											public void run() {
												delay.remove(punido);
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 60*20);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												config.set(punido.getName()+"."+punir.getName()+".ban2", true);
												config.saveConfig();
												config.set(punido.getName()+".punido", true);
												config.saveConfig();
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
										if(punir.isBan2() == false) {
											config.set(punido.getName()+".status", "mutado");
											config.saveConfig();
										}else {
											config.set(punido.getName()+".status", "banido");
											config.saveConfig();
											punido.kickPlayer("       §c§lSAFE CLUB\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo2()*3600)));
										}
									}
								}
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban2") == true) {
									if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban3") == false) {
										punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo3()*3600)));
										p.sendMessage("§aJogador punido!");
										config.set(punido.getName()+".prova", args[2]);
										config.saveConfig();
										delay.add(punido);
										TimerAPI.timer(Mine.toInt(punir.getTempo3()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo");
										new BukkitRunnable() {
											
											@Override
											public void run() {
												delay.remove(punido);
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 60*20);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												config.set(punido.getName()+"."+punir.getName()+".ban3", true);
												config.saveConfig();
												config.set(punido.getName()+".punido", true);
												config.saveConfig();
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
										if(punir.isBan3() == false) {
											config.set(punido.getName()+".status", "mutado");
											config.saveConfig();
										}else {
											config.set(punido.getName()+".status", "banido");
											config.saveConfig();
											punido.kickPlayer("       §c§lSAFE CLUB\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo3()*3600)));
										}
									}
								}
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban3") == true) {
									if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban4") == false) {
										punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo4()*3600)));
										p.sendMessage("§aJogador punido!");
										config.set(punido.getName()+".prova", args[2]);
										config.saveConfig();
										delay.add(punido);
										TimerAPI.timer(Mine.toInt(punir.getTempo4()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo");
										new BukkitRunnable() {
											
											@Override
											public void run() {
												delay.remove(punido);
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 60*20);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												config.set(punido.getName()+"."+punir.getName()+".ban4", true);
												config.saveConfig();
												config.set(punido.getName()+".punido", true);
												config.saveConfig();

											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
										if(punir.isBan4() == false) {
											config.set(punido.getName()+".status", "mutado");
											config.saveConfig();
										}else {
											config.set(punido.getName()+".status", "banido");
											config.saveConfig();
											punido.kickPlayer("       §c§lSAFE CLUB\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo4()*3600)));
										}
									}
								}
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban4") == true) {
									if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban5") == false) {
										delay.add(punido);
										config.set(punido.getName()+".prova", args[2]);
										config.saveConfig();
										TimerAPI.timer(Mine.toInt(punir.getTempo5()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo");
										new BukkitRunnable() {
											
											@Override
											public void run() {
												delay.remove(punido);
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 60*20);
										if(punir.isBan5() == false) {
											config.set(punido.getName()+".status", "mutado");
											config.saveConfig();
										}else {
											config.set(punido.getName()+".status", "banido");
											config.saveConfig();
											punido.kickPlayer("       §c§lSAFE CLUB\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo5()*3600)));
										}
										punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo5()*3600)));
										p.sendMessage("§aJogador punido!");
										config.set(punido.getName()+".punido", true);
										config.saveConfig();
									}
								}
							}else {
								p.sendMessage("§cEsse jogador já está punido, aguarde sua punição acabar!");
							}
								}
							}
							if(punir.isAviso() == false) {
								if(config.getBoolean(punido.getName()+".punido") == false) {
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban1") == false) {
									punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo1()*3600)));
									p.sendMessage("§aJogador punido!");
									config.set(punido.getName()+".prova", args[2]);
									config.saveConfig();
									delay.add(punido);
									TimerAPI.timer(Mine.toInt(punir.getTempo1()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo");
									new BukkitRunnable() {
										
										@Override
										public void run() {
											delay.remove(punido);
										}
									}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 60*20);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											config.set(punido.getName()+"."+punir.getName()+".ban1", true);
											config.saveConfig();
											config.set(punido.getName()+".punido", true);
											config.saveConfig();
										}
									}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
									if(punir.isBan1() == false) {
										config.set(punido.getName()+".status", "mutado");
										config.saveConfig();
									}else {
										config.set(punido.getName()+".status", "banido");
										config.saveConfig();
										punido.kickPlayer("       §c§lSAFE CLUB\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo1()*3600)));
									}
								}
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban1") == true) {
									if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban2") == false) {
										punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo2()*3600)));
										p.sendMessage("§aJogador punido!");
										config.set(punido.getName()+".prova", args[2]);
										config.saveConfig();
										delay.add(punido);
										TimerAPI.timer(Mine.toInt(punir.getTempo2()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo");
										new BukkitRunnable() {
											
											@Override
											public void run() {
												delay.remove(punido);
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 60*20);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												config.set(punido.getName()+"."+punir.getName()+".ban2", true);
												config.saveConfig();
												config.set(punido.getName()+".punido", true);
												config.saveConfig();
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
										if(punir.isBan2() == false) {
											config.set(punido.getName()+".status", "mutado");
											config.saveConfig();
										}else {
											config.set(punido.getName()+".status", "banido");
											config.saveConfig();
											punido.kickPlayer("       §c§lSAFE CLUB\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo2()*3600)));
										}
									}
								}
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban2") == true) {
									if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban3") == false) {
										punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo3()*3600)));
										p.sendMessage("§aJogador punido!");
										config.set(punido.getName()+".prova", args[2]);
										config.saveConfig();
										TimerAPI.timer(Mine.toInt(punir.getTempo3()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo");
										delay.add(punido);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												delay.remove(punido);
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 60*20);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												config.set(punido.getName()+"."+punir.getName()+".ban3", true);
												config.saveConfig();
												config.set(punido.getName()+".punido", true);
												config.saveConfig();
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
										if(punir.isBan3() == false) {
											config.set(punido.getName()+".status", "mutado");
											config.saveConfig();
										}else {
											config.set(punido.getName()+".status", "banido");
											config.saveConfig();
											punido.kickPlayer("       §c§lSAFE CLUB\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo3()*3600)));
										}
									}
								}
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban3") == true) {
									if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban4") == false) {
										punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo4()*3600)));
										p.sendMessage("§aJogador punido!");
										config.set(punido.getName()+".prova", args[2]);
										config.saveConfig();
										delay.add(punido);
										TimerAPI.timer(Mine.toInt(punir.getTempo4()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo");
										new BukkitRunnable() {
											
											@Override
											public void run() {
												delay.remove(punido);
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 60*20);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												config.set(punido.getName()+"."+punir.getName()+".ban4", true);
												config.saveConfig();
												config.set(punido.getName()+".punido", true);
												config.saveConfig();
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
										if(punir.isBan4() == false) {
											config.set(punido.getName()+".status", "mutado");
											config.saveConfig();
										}else {
											config.set(punido.getName()+".status", "banido");
											config.saveConfig();
											punido.kickPlayer("       §c§lSAFE CLUB\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo4()*3600)));
										}
									}
								}
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban4") == true) {
									if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban5") == false) {
										punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo5()*3600)));
										p.sendMessage("§aJogador punido!");
										config.set(punido.getName()+".prova", args[2]);
										config.saveConfig();
										config.set(punido.getName()+".punido", true);
										config.saveConfig();
										delay.add(punido);
										TimerAPI.timer(Mine.toInt(punir.getTempo5()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo");
										new BukkitRunnable() {
											
											@Override
											public void run() {
												delay.remove(punido);
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 60*20);
										if(punir.isBan5() == false) {
											config.set(punido.getName()+".status", "mutado");
											config.saveConfig();
										}else {
											config.set(punido.getName()+".status", "banido");
											config.saveConfig();
											punido.kickPlayer("       §c§lSAFE CLUB\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo5()*3600)));
										}
									}
								}
								}else {
									p.sendMessage("§cEsse jogador já está punido, aguarde sua punição acabar!");
								}
							}
						}else {
							p.sendMessage("§cEsse jogador foi punido recentemente, aguarde para punir novamente.");
						}
						}else {
							p.sendMessage("§cVocê não possui o cargo para essa punição!");
						}
					}else {
						p.sendMessage("§cMotivo não encontrado.");
					}
				}else {
					p.sendMessage("§cVocê precisa anexar uma prova a sua punição!");
				}
					}
				}
			}
		}
		return false;
	}

	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		
			if(e.getMessage().contains("/g") || e.getMessage().contains("/l") || e.getMessage().contains("/tell") || e.getMessage().contains("/r")) {
			if(config.contains(p.getName()+".status")) {
				if(config.getString(p.getName()+".status").equalsIgnoreCase("mutado")) {
				e.setCancelled(true);
				p.sendMessage(" \n§cVocê está mutado! Aguarde sua punição encerrar. Prova: "+config.getString(p.getName()+".prova")+"\n ");
			}
			}
		}
	}
	
	@EventHandler
	public void aoEntrar(PlayerLoginEvent e) {
		Player p = e.getPlayer();
	
		if(config.contains(p.getName())) {
		if(config.getString(p.getName()+".status").equalsIgnoreCase("banido")) {
			new BukkitRunnable() {
				
				@Override
				public void run() {
					p.kickPlayer("     §c§lSAFE CLUB\n          §cVocê foi banido por um membro da equipe!\n       Aguarde sua punição encerrar.\n       Prova: "+config.getString(p.getName()+".prova"));
				}
			}.runTaskLater(Main.getPlugin(Main.class), 3);
		}else {
			return;
		}
		}
		
	}
	
}
