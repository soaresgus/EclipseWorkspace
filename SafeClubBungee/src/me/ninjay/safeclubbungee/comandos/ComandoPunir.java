package me.ninjay.safeclubbungee.comandos;

import java.util.concurrent.TimeUnit;

import me.ninjay.safeclubbungee.main.BungeeMain;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ComandoPunir extends Command {

	public ComandoPunir() {
		super("punir");
	}

	public static Long toLong(Object object) {

		if (object == null) {
			return 0L;
		}
		if (object instanceof Long) {
			return (Long) object;
		}
		if (object instanceof Number) {
			Number number = (Number) object;
			return number.longValue();
		}
		try {
			return Long.valueOf(object.toString());
		} catch (Exception e) {
			return 0L;
		}
	}

	public static long getCooldown(long before, long seconds) {

		long now = System.currentTimeMillis();
		long cooldown = seconds * 1000;

		// +5 - 19 + 15

		return +cooldown - now + before;

	}

	public static boolean inCooldown(long before, long seconds) {

		long now = System.currentTimeMillis();
		long cooldown = seconds * 1000;
		return now <= (cooldown + before);

	}

	public static String formatTime(long time) {
		if (time == 0L) {
			return "never";
		}
		long day = TimeUnit.MILLISECONDS.toDays(time);
		long hours = TimeUnit.MILLISECONDS.toHours(time) - day * 24L;
		long minutes = TimeUnit.MILLISECONDS.toMinutes(time) - TimeUnit.MILLISECONDS.toHours(time) * 60L;
		long seconds = TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MILLISECONDS.toMinutes(time) * 60L;
		StringBuilder sb = new StringBuilder();
		if (day > 0L) {
			sb.append(day).append(" ").append(day == 1L ? "dia" : "dias").append(" ");
		}
		if (hours > 0L) {
			sb.append(hours).append(" ").append(hours == 1L ? "hora" : "horas").append(" ");
		}
		if (minutes > 0L) {
			sb.append(minutes).append(" ").append(minutes == 1L ? "minuto" : "minutos").append(" ");
		}
		if (seconds > 0L) {
			sb.append(seconds).append(" ").append(seconds == 1L ? "segundo" : "segundos");
		}
		String diff = sb.toString();
		return diff.isEmpty() ? "agora" : diff;
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (sender instanceof ProxiedPlayer) {
			if (args.length == 0) {
				p.sendMessage(new TextComponent("§cUtilize: /punir <jogador>"));
				return;
			} else {
				ProxiedPlayer j = (ProxiedPlayer) BungeeCord.getInstance().getPlayer(args[0]);

				if (j == null) {
					p.sendMessage(new TextComponent("§cJogador offline."));
				} else {
					TextComponent mute = new TextComponent("§f* Mute");
					ClickEvent mc = new ClickEvent(Action.SUGGEST_COMMAND, "/punir " + args[0] + " mute <motivo>");
					mute.setClickEvent(mc);

					TextComponent mutet = new TextComponent("§f* Mute Temporário");
					ClickEvent mtc = new ClickEvent(Action.SUGGEST_COMMAND,
							"/punir " + args[0] + " tempmute <minutos> <motivo>");
					mutet.setClickEvent(mtc);

					TextComponent ban = new TextComponent("§f* Ban");
					ClickEvent bc = new ClickEvent(Action.SUGGEST_COMMAND, "/punir " + args[0] + " ban <motivo>");
					ban.setClickEvent(bc);

					TextComponent bant = new TextComponent("§f* Ban Temporário");
					ClickEvent bantc = new ClickEvent(Action.SUGGEST_COMMAND,
							"/punir " + args[0] + " tempban <minutos> <motivo>");
					bant.setClickEvent(bantc);

					TextComponent kick = new TextComponent("§f* Kick");
					ClickEvent kickc = new ClickEvent(Action.SUGGEST_COMMAND, "/punir " + args[0] + " kick <motivo>");
					kick.setClickEvent(kickc);

					p.sendMessage(new TextComponent(" "));
					p.sendMessage(mute);
					p.sendMessage(mutet);
					p.sendMessage(ban);
					p.sendMessage(bant);
					p.sendMessage(kick);
					p.sendMessage(new TextComponent(" "));
					p.sendMessage(new TextComponent("§eEscolha uma opção para punir " + args[0]));

				}
			}
		}
		if (args.length == 1) {
			return;
		} else {
			if (args[1].equalsIgnoreCase("mute")) {
				ProxiedPlayer j = BungeeCord.getInstance().getPlayer(args[0]);

				if (j == null) {
					p.sendMessage(new TextComponent("§cJogador offline."));
					return;
				}
				if (BungeeMain.pperm.contains(j.getName() + ".tipo")) {
					for (int i = 0; i < 100; i++) {
						p.sendMessage(new TextComponent(" "));
					}
					p.sendMessage(new TextComponent("§cEste jogador já foi punido."));
					return;
				}
				if (BungeeMain.temp.contains(j.getName() + ".tipo")) {
					for (int i = 0; i < 100; i++) {
						p.sendMessage(new TextComponent(" "));
					}
					p.sendMessage(new TextComponent("§cEste jogador já foi punido."));
					return;
				}
				String message = "";
				for (int i = 2; i < args.length; i++) {
					message = message + " " + args[i];

				}
				for (int i = 0; i < 100; i++) {
					p.sendMessage(new TextComponent(" "));
				}
				p.sendMessage(new TextComponent("§a" + j.getName() + " foi mutado com sucesso."));
				j.sendMessage(new TextComponent("§c§lSafe Club\n \n§cVocê foi mutado !\n \n§cAutor: " + p.getName()
						+ "\n§cTempo: Permanente\n§cMotivo:" + message + "\n "));
				BungeeMain.pperm.set(j.getName() + ".tipo", "Mute");
				BungeeMain.pperm.set(j.getName() + ".tempo", "Permanente");
				BungeeMain.pperm.set(j.getName() + ".motivo", message);
				BungeeMain.pperm.set(j.getName() + ".autor", p.getName());
				BungeeMain.pperm.saveConfig();

			}

		}

		if (args.length == 1) {
			return;
		} else {
			if (args[1].equalsIgnoreCase("tempmute")) {
				ProxiedPlayer j = BungeeCord.getInstance().getPlayer(args[0]);

				if (j == null) {
					p.sendMessage(new TextComponent("§cJogador offline."));
					return;
				}
				if (BungeeMain.pperm.contains(j.getName() + ".tipo")) {
					for (int i = 0; i < 100; i++) {
						p.sendMessage(new TextComponent(" "));
					}
					p.sendMessage(new TextComponent("§cEste jogador já foi punido."));
					return;
				}
				if (BungeeMain.temp.contains(j.getName() + ".tipo")) {
					for (int i = 0; i < 100; i++) {
						p.sendMessage(new TextComponent(" "));
					}
					p.sendMessage(new TextComponent("§cEste jogador já foi punido."));
					return;
				}

				String message = "";
				for (int i = 3; i < args.length; i++) {
					message = message + " " + args[i];

				}
				for (int i = 0; i < 100; i++) {
					p.sendMessage(new TextComponent(" "));
				}
				long tempo = toLong(args[2]);
				p.sendMessage(new TextComponent("§a" + j.getName() + " foi mutado com sucesso."));
				j.sendMessage(new TextComponent("§c§lSafe Club\n \n§cVocê foi mutado !\n \n§cAutor: " + p.getName()
						+ "\n§cTempo: " + tempo + " minutos\n§cMotivo:" + message + "\n "));
				
				BungeeMain.temp.set(j.getName() + ".tipo", "Temp Mute");
				BungeeMain.temp.set(j.getName() + ".tempo", tempo*60);
				BungeeMain.temp.set(j.getName() + ".motivo", message);
				BungeeMain.temp.set(j.getName() + ".autor", p.getName());
				BungeeMain.temp.saveConfig();
							
				}
		
			}

		}

	}

