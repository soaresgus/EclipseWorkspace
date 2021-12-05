package me.ninjay.loginsoulth.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.ninjay.ninjaapi.utils.Mine;

public class ComandoRegister implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage("§cUtilize /register <senha>");
				Mine.sendActionBar(p, "§cUtilize /register <senha>");
				return true;
			}
			if(!ComandoLogin.lista.contains(p)) {
				p.sendMessage("§cVocê já está registrado.");
				Mine.sendActionBar(p, "§cVocê já está registrado.");
			}else {
				if(Main.senhas.contains(p.getName())) {
					p.sendMessage("§cVocê já está registrado. Utilize /login <senha>.");
					Mine.sendActionBar(p, "§cVocê já está registrado. Utilize /login <senha>.");
				}else {
			Main.senhas.set(p.getName(), args[0]);
			Main.senhas.saveConfig();
			p.sendMessage("§fBem Vindo ao §b§lRede Soulth\n \n§a→ §fPara mudar sua senha: §6/trocarsenha.\n§a→ §fCompre nossos vip's, em nossa loja: §6loja.soulthnetwork.com\n§a→ §fEntre em nosso grupo do 'Discord': §6/discord");
			Mine.sendActionBar(p, "§a§lREGISTRADO §acom sucesso !");
			ComandoLogin.lista.remove(p);
			if (ComandoLogin.ativado == true) {
				Inventory dois = Mine.newInventory("Clique no(a) Craft", 9 * 3);
				EstruturaGlobal.abrir2(p, dois);
				ComandoLogin.ativado = false;
				return true;

			}
			if (ComandoLogin.ativado == false) {
				Inventory um = Mine.newInventory("Clique no(a) Diamante", 9 * 3);
				EstruturaGlobal.abrir(p, um);
				ComandoLogin.ativado = true;
				return true;
			}
		}
			}
		}
		return false;
	}

}
