package me.ninjay.soulthmaquinas.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.soulthmaquinas.estruturas.Maquina;
import me.ninjay.soulthmaquinas.estruturas.MaquinaAPI;

public class ComandoDarMaquina implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length <= 2) {
				if(p.hasPermission("maquina.admin")) {
				p.sendMessage("§cUtilize /darmaquina <jogador> <maquina> <quantidade>");
				return true;
			}
			}
			Player j = Bukkit.getPlayer(args[0]);
			if (j == null) {
				p.sendMessage("§cJogador offline.");
				return true;
			}
			String nome = args[1];
			Maquina maquina = MaquinaAPI.manager.getmaquina(nome);
			if (maquina == null) {
				p.sendMessage("§cA máquina " + nome + " não foi encontrada no banco de dados.");
			return true;
			}
			String quantia = args[2];
			int quantidade = Mine.toInt(quantia);
			if (quantidade <= 0) {
				p.sendMessage("§cQuantia inválida. Tente um número maior do que 0.");
				return true;

			}
			ItemStack item = maquina.getIcone().clone();
			item.setAmount(quantidade);
			p.sendMessage("§eVocê entregou "+quantidade+" máquina(s) "+nome+" para "+j.getName());
			j.sendMessage("§eVocê recebeu "+quantidade+" máquina(s) "+nome+" de "+p.getName());
			j.getInventory().addItem(item);
		}
		return false;
	}

}
