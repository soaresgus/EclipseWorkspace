package me.ninjay.onelogin.comandos;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.onelogin.main.Main;
import net.eduard.api.lib.BukkitConfig;

public class ComandoLogar implements CommandExecutor {

	public static BukkitConfig config = new BukkitConfig("senhas.yml", Main.getPlugin(Main.class));
	public static BukkitConfig captcha = new BukkitConfig("captcha.yml", Main.getPlugin(Main.class));
	public static BukkitConfig tentativas = new BukkitConfig("tentativas.yml",Main.getPlugin(Main.class));
	public static ArrayList<Player> logado = new ArrayList<>();
	public static ArrayList<Player> logou = new ArrayList<>();
	
	public static void captcha(Player p) {
		new BukkitRunnable() {

			@Override
			public void run() {
				for (int d = 0; d < 100; d++) {
					p.sendMessage(" ");
				}
				p.sendMessage("§aAgora para continuar confirme o §a§lCAPTCHA§a.\n \n§aDigite no seu chat o número §a§l"
						+ captcha.getInt(p.getName()) + "§a para confirmar o captcha.\n ");
			}
		}.runTaskLater(Main.getPlugin(Main.class), 3);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage("§cUtilize /login <senha>.");
				return true;
			}
			if(!config.contains(p.getName())) {
				p.sendMessage("§cVocê não está registrado, utilize /register <senha>.");
				return true;
			}
			if (!logado.contains(p)) {
				if (args[0].equals(config.getString(p.getName()))) {
					p.sendMessage("§aAutentificado com §a§lsucesso§a.");
					logou.add(p);
					captcha(p);
				}
				if(!args[0].equals(config.getString(p.getName()))) {
					p.sendMessage("§cSua senha está incorreta, tente novamente.");
					tentativas.set(p.getName(), tentativas.getInt(p.getName())+1);
					tentativas.saveConfig();
				}
				if(tentativas.getInt(p.getName()) == 3) {
					p.kickPlayer("§6§lREDE ONE\n \n     §cVocê excedeu o número de tentativas.\n ");
				}
			} else {
				p.sendMessage("§cVocê já está logado.");
			}
		}
		return false;
	}

}
