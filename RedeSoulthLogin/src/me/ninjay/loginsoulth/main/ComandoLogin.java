package me.ninjay.loginsoulth.main;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;

import me.ninjay.ninjaapi.utils.Mine;

public class ComandoLogin implements CommandExecutor, Listener{
	public static ArrayList<Player> lista = new ArrayList<>();
	 public static boolean ativado;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage("§cUtilize /login <senha>");
				Mine.sendActionBar(p, "§cUtilize /login <senha>");
				return true;
			}
			if(!Main.senhas.contains(p.getName())) {
				p.sendMessage("§cVocê não está registrado, utilize /register <senha>.");
				Mine.sendActionBar(p, "§cVocê não está registrado. Utilize /register <senha>.");
				return true;
			}else if 
			(!args[0].contains(Main.senhas.getString(p.getName()))) {
				p.sendMessage("§cSenha errada, tente novamente.");
				Mine.sendActionBar(p, "§cSenha errada, tente novamente.");
				return true;
			}else if
			(!lista.contains(p)) {
				p.sendMessage("§cVocê já esta logado.");
				Mine.sendActionBar(p, "§cVocê já está logado.");
			}else if
			(args[0].contains(Main.senhas.getString(p.getName()))) {
				p.sendMessage("§fBem Vindo ao §b§lRede Soulth\n \n§a→ §fPara mudar sua senha: §6/trocarsenha.\n§a→ §fCompre nossos vip's, em nossa loja: §6loja.soulthnetwork.com\n§a→ §fEntre em nosso grupo do 'Discord': §6/discord");
				Mine.sendActionBar(p, "§a§lLOGADO §acom sucesso.");
				lista.remove(p);
				if (ComandoLogin.ativado == true) {
					Inventory dois = Mine.newInventory("Clique no(a) Craft", 9 * 3);
					EstruturaGlobal.abrir2(p, dois);
					ativado = false;
					return true;

				}
				if (ComandoLogin.ativado == false) {
					Inventory um = Mine.newInventory("Clique no(a) Diamante", 9 * 3);
					EstruturaGlobal.abrir(p, um);
					ativado = true;
					return true;
				}
			}
			
		}
		return false;
	}
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		lista.add(p);
		Mine.sendActionBar(p, "§a§lYEAH, §fPara jogar use §6/login (Senha).");
		Mine.sendTitle(p, "§2§lREDE SOULTH", "§fUse /login para jogar", 5, 200, 5);
		p.sendMessage("§a§lYEAH, §fPara jogar use §6/login (Senha).");
		p.teleport(Main.locais.getLocation("spawn_login"));
		
		
	}
	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if(lista.contains(p)) {
			if(e.getMessage().contains("/login")) {
				e.setCancelled(false);
				return;
				}
			if(e.getMessage().contains("/register")) {
				e.setCancelled(false);
				return;
		}else {
			e.setCancelled(true);
		}
			
		}
		
	}
	@EventHandler
	public void aoFalar(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(lista.contains(p)) {
			e.setCancelled(true);
		}else {
			e.setCancelled(false);
		}
	}
    @EventHandler
    public void aoAndar(PlayerMoveEvent e) {
    	Player p = e.getPlayer();
    	if(lista.contains(p)) {
    		e.setCancelled(true);
    	}else {
    		e.setCancelled(false);
    	}
    }
}
