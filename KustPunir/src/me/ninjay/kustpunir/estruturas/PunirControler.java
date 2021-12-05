package me.ninjay.kustpunir.estruturas;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.kustlogs.estruturas.LogsAPI;
import me.ninjay.kustpunir.main.Main;
import me.ninjay.kustpunir.utils.BukkitConfig;
import me.ninjay.kustpunir.utils.Mine;
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
					if(!punido.hasPermission("punir.bypass")) {
					if(args.length == 1) {
						if(!punido.getName().equalsIgnoreCase(p.getName())) {
					p.sendMessage(" ");
					
					for(Punir punir : PunirAPI.manager.getPunirs()) {
						TextComponent motivo = new TextComponent("  §f◯ "+punir.getNome());
				        motivo.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(" \n  §7Cargo: §f"+punir.getGrupo().toUpperCase()+" \n  §7"+punir.getDesc()+"\n ").create()));
				        motivo.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir "+punido.getName()+" "+punir.getName()+" <prova>"));
				        p.spigot().sendMessage(motivo);
					}
					
					 p.sendMessage(" \n§eSelecione uma punição para punir o jogador "+punido.getName()+".");
				}else {
					p.sendMessage("§cVocê não pode punir você mesmo.");
				}
					}
					if(args.length == 2) {
						p.sendMessage("§cVocê precisa anexar uma prova a sua punição!");
						return true;
					}
					
					if(args.length != 1) {
						if(args[2].contains("/")) {
							Punir punir = PunirAPI.manager.getPunirPorNome(args[1]);
							if(punir != null) {
							if(p.hasPermission(punir.getPerm())) {
							if(!delay.contains(punido)) {
							if(punir.isAviso() == true) {
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".avisado") == false) {
								p.sendMessage("§aJogador avisado! Caso ele cometa novamente basta punir novamente.");
								LogsAPI.register(p.getName(), punido.getName()+" foi avisado por "+p.getName()+" / Prova: "+args[2]+" / Motivo: "+punir.getNome(), me.ninjay.kustlogs.main.Main.staffGeral);
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
 									PunirControler.config.remove(punido.getName()+".status");
 									PunirControler.config.remove(punido.getName()+".punido");
 									PunirControler.config.remove(punido.getName()+".tempo");
 									PunirControler.config.remove(punido.getName()+".ativo");
 									PunirControler.config.saveConfig();
 									punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo1()*3600)));
 									LogsAPI.register(p.getName(), punido.getName()+" foi punido por "+p.getName()+" / Prova: "+args[2]+" / Motivo: "+punir.getNome(), me.ninjay.kustlogs.main.Main.staffGeral);
 									config.set(punido.getName()+"."+punir.getName()+".prova", args[2]);
									config.saveConfig();
									delay.add(punido);
									TimerAPI.timer(Mine.toInt(punir.getTempo1()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo", punido);
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
											config.set(punido.getName()+".ativo", punir.getName());
											config.saveConfig();
										}
									}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
									if(punir.isBan1() == false) {
										config.set(punido.getName()+".status", "mutado");
										config.saveConfig();
									}else {
										config.set(punido.getName()+".status", "banido");
										config.saveConfig();
										punido.kickPlayer("       §c§lKUST NETWORK\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo1()*3600)));
									}
								}
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban1") == true) {
									if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban2") == false) {
										PunirControler.config.remove(punido.getName()+".status");
	 									PunirControler.config.remove(punido.getName()+".punido");
	 									PunirControler.config.remove(punido.getName()+".tempo");
	 									PunirControler.config.remove(punido.getName()+".ativo");
	 									PunirControler.config.saveConfig();
										punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo2()*3600)));
										LogsAPI.register(p.getName(), punido.getName()+" foi punido por "+p.getName()+" / Prova: "+args[2]+" / Motivo: "+punir.getNome(), me.ninjay.kustlogs.main.Main.staffGeral);
										p.sendMessage("§aJogador punido!");
										config.set(punido.getName()+"."+punir.getName()+".prova", args[2]);
										config.saveConfig();
										delay.add(punido);
										TimerAPI.timer(Mine.toInt(punir.getTempo2()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo", punido);
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
												config.set(punido.getName()+".ativo", punir.getName());
												config.saveConfig();
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
										if(punir.isBan2() == false) {
											config.set(punido.getName()+".status", "mutado");
											config.saveConfig();
										}else {
											config.set(punido.getName()+".status", "banido");
											config.saveConfig();
											punido.kickPlayer("       §c§lKUST NETWORK\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo2()*3600)));
										}
									}
								}
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban2") == true) {
									if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban3") == false) {
										PunirControler.config.remove(punido.getName()+".status");
	 									PunirControler.config.remove(punido.getName()+".punido");
	 									PunirControler.config.remove(punido.getName()+".tempo");
	 									PunirControler.config.remove(punido.getName()+".ativo");
	 									PunirControler.config.saveConfig();
										punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo3()*3600)));
										LogsAPI.register(p.getName(), punido.getName()+" foi punido por "+p.getName()+" / Prova: "+args[2]+" / Motivo: "+punir.getNome(), me.ninjay.kustlogs.main.Main.staffGeral);
										p.sendMessage("§aJogador punido!");
										config.set(punido.getName()+"."+punir.getName()+".prova", args[2]);
										config.saveConfig();
										delay.add(punido);
										TimerAPI.timer(Mine.toInt(punir.getTempo3()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo", punido);
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
												config.set(punido.getName()+".ativo", punir.getName());
												config.saveConfig();
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
										if(punir.isBan3() == false) {
											config.set(punido.getName()+".status", "mutado");
											config.saveConfig();
										}else {
											config.set(punido.getName()+".status", "banido");
											config.saveConfig();
											punido.kickPlayer("       §c§lKUST NETWORK\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo3()*3600)));
										}
									}
								}
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban3") == true) {
									if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban4") == false) {
										PunirControler.config.remove(punido.getName()+".status");
	 									PunirControler.config.remove(punido.getName()+".punido");
	 									PunirControler.config.remove(punido.getName()+".tempo");
	 									PunirControler.config.remove(punido.getName()+".ativo");
	 									PunirControler.config.saveConfig();
										punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo4()*3600)));
										LogsAPI.register(p.getName(), punido.getName()+" foi punido por "+p.getName()+" / Prova: "+args[2]+" / Motivo: "+punir.getNome(), me.ninjay.kustlogs.main.Main.staffGeral);
										p.sendMessage("§aJogador punido!");
										config.set(punido.getName()+"."+punir.getName()+".prova", args[2]);
										config.saveConfig();
										delay.add(punido);
										TimerAPI.timer(Mine.toInt(punir.getTempo4()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo", punido);
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
												config.set(punido.getName()+".ativo", punir.getName());
												config.saveConfig();

											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
										if(punir.isBan4() == false) {
											config.set(punido.getName()+".status", "mutado");
											config.saveConfig();
										}else {
											config.set(punido.getName()+".status", "banido");
											config.saveConfig();
											punido.kickPlayer("       §c§lKUST NETWORK\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo4()*3600)));
										}
									}
								}
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban4") == true) {
									if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban5") == false) {
										PunirControler.config.remove(punido.getName()+".status");
	 									PunirControler.config.remove(punido.getName()+".punido");
	 									PunirControler.config.remove(punido.getName()+".tempo");
	 									PunirControler.config.remove(punido.getName()+".ativo");
	 									PunirControler.config.saveConfig();
										punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo5()*3600)));
										LogsAPI.register(p.getName(), punido.getName()+" foi punido por "+p.getName()+" / Prova: "+args[2]+" / Motivo: "+punir.getNome(), me.ninjay.kustlogs.main.Main.staffGeral);
										p.sendMessage("§aJogador punido!");
										config.set(punido.getName()+"."+punir.getName()+".prova", args[2]);
										config.saveConfig();
										delay.add(punido);
										TimerAPI.timer(Mine.toInt(punir.getTempo5()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo", punido);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												delay.remove(punido);
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 60*20);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												config.set(punido.getName()+".punido", true);
												config.saveConfig();
												config.set(punido.getName()+".ativo", punir.getName());
												config.saveConfig();
											}
										}.runTaskLater(Main.getPlugin(Main.class), 5);
										if(punir.isBan5() == false) {
											config.set(punido.getName()+".status", "mutado");
											config.saveConfig();
										}else {
											config.set(punido.getName()+".status", "banido");
											config.saveConfig();
											punido.kickPlayer("       §c§lKUST NETWORK\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo5()*3600)));
										}
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
									PunirControler.config.remove(punido.getName()+".status");
 									PunirControler.config.remove(punido.getName()+".punido");
 									PunirControler.config.remove(punido.getName()+".tempo");
 									PunirControler.config.remove(punido.getName()+".ativo");
 									PunirControler.config.saveConfig();
									punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo1()*3600)));
									LogsAPI.register(p.getName(), punido.getName()+" foi punido por "+p.getName()+" / Prova: "+args[2]+" / Motivo: "+punir.getNome(), me.ninjay.kustlogs.main.Main.staffGeral);
									p.sendMessage("§aJogador punido!");
									config.set(punido.getName()+"."+punir.getName()+".prova", args[2]);
									config.saveConfig();
									delay.add(punido);
									TimerAPI.timer(Mine.toInt(punir.getTempo1()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo", punido);
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
											config.set(punido.getName()+".ativo", punir.getName());
											config.saveConfig();
										}
									}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
									if(punir.isBan1() == false) {
										config.set(punido.getName()+".status", "mutado");
										config.saveConfig();
									}else {
										config.set(punido.getName()+".status", "banido");
										config.saveConfig();
										punido.kickPlayer("       §c§lKUST NETWORK\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo1()*3600)));
									}
								}
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban1") == true) {
									if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban2") == false) {
										PunirControler.config.remove(punido.getName()+".status");
	 									PunirControler.config.remove(punido.getName()+".punido");
	 									PunirControler.config.remove(punido.getName()+".tempo");
	 									PunirControler.config.remove(punido.getName()+".ativo");
	 									PunirControler.config.saveConfig();
										punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo2()*3600)));
										LogsAPI.register(p.getName(), punido.getName()+" foi punido por "+p.getName()+" / Prova: "+args[2]+" / Motivo: "+punir.getNome(), me.ninjay.kustlogs.main.Main.staffGeral);
										p.sendMessage("§aJogador punido!");
										config.set(punido.getName()+"."+punir.getName()+".prova", args[2]);
										config.saveConfig();
										delay.add(punido);
										TimerAPI.timer(Mine.toInt(punir.getTempo2()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo", punido);
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
												config.set(punido.getName()+".ativo", punir.getName());
												config.saveConfig();
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
										if(punir.isBan2() == false) {
											config.set(punido.getName()+".status", "mutado");
											config.saveConfig();
										}else {
											config.set(punido.getName()+".status", "banido");
											config.saveConfig();
											punido.kickPlayer("       §c§lKUST NETWORK\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo2()*3600)));
										}
									}
								}
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban2") == true) {
									if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban3") == false) {
										PunirControler.config.remove(punido.getName()+".status");
	 									PunirControler.config.remove(punido.getName()+".punido");
	 									PunirControler.config.remove(punido.getName()+".tempo");
	 									PunirControler.config.remove(punido.getName()+".ativo");
	 									PunirControler.config.saveConfig();
										punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo3()*3600)));
										LogsAPI.register(p.getName(), punido.getName()+" foi punido por "+p.getName()+" / Prova: "+args[2]+" / Motivo: "+punir.getNome(), me.ninjay.kustlogs.main.Main.staffGeral);
										p.sendMessage("§aJogador punido!");
										config.set(punido.getName()+"."+punir.getName()+".prova", args[2]);
										config.saveConfig();
										TimerAPI.timer(Mine.toInt(punir.getTempo3()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo", punido);
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
												config.set(punido.getName()+".ativo", punir.getName());
												config.saveConfig();
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
										if(punir.isBan3() == false) {
											config.set(punido.getName()+".status", "mutado");
											config.saveConfig();
										}else {
											config.set(punido.getName()+".status", "banido");
											config.saveConfig();
											punido.kickPlayer("       §c§lKUST NETWORK\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo3()*3600)));
										}
									}
								}
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban3") == true) {
									if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban4") == false) {
										PunirControler.config.remove(punido.getName()+".status");
	 									PunirControler.config.remove(punido.getName()+".punido");
	 									PunirControler.config.remove(punido.getName()+".tempo");
	 									PunirControler.config.remove(punido.getName()+".ativo");
	 									PunirControler.config.saveConfig();
										punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo4()*3600)));
										LogsAPI.register(p.getName(), punido.getName()+" foi punido por "+p.getName()+" / Prova: "+args[2]+" / Motivo: "+punir.getNome(), me.ninjay.kustlogs.main.Main.staffGeral);
										p.sendMessage("§aJogador punido!");
										config.set(punido.getName()+"."+punir.getName()+".prova", args[2]);
										config.saveConfig();
										delay.add(punido);
										TimerAPI.timer(Mine.toInt(punir.getTempo4()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo", punido);
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
												config.set(punido.getName()+".ativo", punir.getName());
												config.saveConfig();
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3);
										if(punir.isBan4() == false) {
											config.set(punido.getName()+".status", "mutado");
											config.saveConfig();
										}else {
											config.set(punido.getName()+".status", "banido");
											config.saveConfig();
											punido.kickPlayer("       §c§lKUST NETWORK\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo4()*3600)));
										}
									}
								}
								if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban4") == true) {
									if(config.getBoolean(punido.getName()+"."+punir.getName()+".ban5") == false) {
										PunirControler.config.remove(punido.getName()+".status");
	 									PunirControler.config.remove(punido.getName()+".punido");
	 									PunirControler.config.remove(punido.getName()+".tempo");
	 									PunirControler.config.remove(punido.getName()+".ativo");
	 									PunirControler.config.saveConfig();
										punido.sendMessage(" \n§cVocê foi punido por um membro da equipe!\nMotivo: "+punir.getNome()+"\nSua punição irá acabar em: "+formatarTempoDHMS(Mine.toInt(punir.getTempo5()*3600)));
										LogsAPI.register(p.getName(), punido.getName()+" foi punido por "+p.getName()+" / Prova: "+args[2]+" / Motivo: "+punir.getNome(), me.ninjay.kustlogs.main.Main.staffGeral);
										p.sendMessage("§aJogador punido!");
										config.set(punido.getName()+"."+punir.getName()+".prova", args[2]);
										config.saveConfig();
										delay.add(punido);
										TimerAPI.timer(Mine.toInt(punir.getTempo5()*3600), config, Main.getPlugin(Main.class), punido.getName()+".tempo", punido);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												delay.remove(punido);
											}
										}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 60*20);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												config.set(punido.getName()+".punido", true);
												config.saveConfig();
												config.set(punido.getName()+".ativo", punir.getName());
												config.saveConfig();
											}
										}.runTaskLater(Main.getPlugin(Main.class), 5);
										if(punir.isBan5() == false) {
											config.set(punido.getName()+".status", "mutado");
											config.saveConfig();
										}else {
											config.set(punido.getName()+".status", "banido");
											config.saveConfig();
											punido.kickPlayer("       §c§lKUST NETWORK\n       §cVocê foi banido por um membro da equipe\n       Motivo: "+punir.getNome()+"\n       Sua punição irá encerrar em "+formatarTempoDHMS(Mine.toInt(punir.getTempo5()*3600)));
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
				}else {
					p.sendMessage("§cEsse jogador não pode ser punido (punir.bypass).");
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
				p.sendMessage(" \n§cVocê está mutado! Aguarde sua punição encerrar.\nProva: "+config.getString(p.getName()+"."+config.getString(p.getName()+".ativo")+".prova")+"\nTempo: "+formatarTempoDHMS(PunirControler.config.getInt(p.getName()+".tempo"))+"\n ");
				
			}
			}
		}
	}
	
	@EventHandler
	public void aoEntrar(PlayerLoginEvent e) {
		Player p = e.getPlayer();
	
		if(config.contains(p.getName()+".status")) {
		if(config.getString(p.getName()+".status").equalsIgnoreCase("banido")) {
			new BukkitRunnable() {
				
				@Override
				public void run() {
					p.kickPlayer("     §c§lKUST NETWORK\n          §cVocê foi banido por um membro da equipe!\n       Aguarde sua punição encerrar.\n       Prova: "+config.getString(p.getName()+"."+config.getString(p.getName()+".ativo")+".prova")+"\n       Tempo: "+formatarTempoDHMS(PunirControler.config.getInt(p.getName()+".tempo")));
				}
			}.runTaskLater(Main.getPlugin(Main.class), 3);
		}else {
			return;
		}
		}
		
	}
}
