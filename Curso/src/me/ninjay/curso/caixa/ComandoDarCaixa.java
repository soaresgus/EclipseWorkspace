package me.ninjay.curso.caixa;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.Mine;


public class ComandoDarCaixa implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (args.length < 3) {
				p.sendMessage("§cUtilize /caixagive <jogador> <tipo> <quantidade>");
				return true;
			}
			Player jogador = Bukkit.getPlayer(args[0]);
			if (jogador == null) {
				p.sendMessage("§aJogador offline");
				return true;
			}

			String nome = args[1];
			Caixa caixa = CaixaAPI.manager.getcaixa(nome);
			if (caixa == null) {
				p.sendMessage("§aA caixa " + nome + " não existe no sistema.");
				return true;
			}
			String quantia = args[2];
			int quantidade = Mine.toInt(quantia);

			if (quantidade <= 0) {
				p.sendMessage("§aQuantia invalida");
				return true;
			}
			ItemStack item = caixa.getIcone().clone();
			item.setAmount(quantidade);

			p.sendMessage("§aVocê entregou " + quantidade + " caixa básica para " + jogador.getName());
			jogador.sendMessage("§aVocê recebeu " + quantidade + " caixa básica de " + p.getName());
			jogador.getInventory().addItem(item);

		}
		return false;
	}
}
