package net.b_tell;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	public static Main instance;

	@Override
	public void onEnable() {
		instance = this;
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}

	public String getMensagem(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < args.length; i++) {
			sb.append(args[i] + " ");
		}
		return sb.toString();
	}
	public HashMap<String, Boolean> tell = new HashMap<>();
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (command.getName().equalsIgnoreCase("tell")) {
				if (args.length == 0) {
					p.sendMessage("§cUse /tell <jogador> <mensagem>.");
					return true;
				}
				if (args.length == 1) {
					Player alvo = Bukkit.getPlayer(args[0]);
					if (alvo == null) {
						p.sendMessage("§cEste jogador se encontra offline!");
						return true;
					}
					if(tell.get(alvo.getName())) {
						p.sendMessage("§cEste jogador está com o recebimento de mensagens desabilitado.");
						return true;
					}
					if(p.getName().equals(alvo.getName())) {
						p.sendMessage("§cEste jogador é você.");
						return true;
					}
					p.sendMessage("§cUse /tell <jogador> <mensagem>.");
					return true;
				}
				if (args.length == 2) {
					Player alvo = Bukkit.getPlayer(args[0]);
					if (alvo == null) {
						p.sendMessage("§cEste jogador se encontra offline!");
						return true;
					}
					if(tell.get(alvo.getName())) {
						p.sendMessage("§cEste jogador está com o recebimento de mensagens desabilitado.");
						return true;
					}
					if(p.getName().equals(alvo.getName())) {
						p.sendMessage("§cEste jogador é você.");
						return true;
					}
					String mensagem = getMensagem(args);
					p.sendMessage("§7Para " + alvo.getName() + ": §f" + mensagem);
					alvo.sendMessage("§7De " + p.getName() + ": §f" + mensagem);
					return true;
				}
				return true;
			}
			if (command.getName().equalsIgnoreCase("telltoggle")) {
				if(tell.get(p.getName())) {
					tell.put(p.getName(), false);
					p.sendMessage("§aTell ativado com sucesso.");
				}else {
					tell.put(p.getName(), true);
					p.sendMessage("§cTell desativado com sucesso.");
				}
			}
		}
		return true;
	}
	
	@EventHandler
	public void join(PlayerJoinEvent e) {
		if(!tell.containsKey(e.getPlayer().getName())) {
			tell.put(e.getPlayer().getName(), true);
		}
	}
	
}
