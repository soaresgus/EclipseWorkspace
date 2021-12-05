package br.beta.eletron.rankup.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.beta.eletron.rankup.manager.RankUP;
import br.beta.eletron.rankup.manager.RankUPAPI;
import me.ninjay.ninjaapi.utils.Mine;

public class RankUPCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
				Double money = br.beta.eletron.rankup.api.VaultAPI.getEconomy().getBalance(player);
				RankUP rank = RankUPAPI.getManager().getRank(player);
				if (money >= rank.getPreco()) {
					br.beta.eletron.rankup.api.VaultAPI.getEconomy().withdrawPlayer(player, rank.getPreco());
					RankUP nexthrank = RankUPAPI.getManager().getRank(rank.getLevel() + 1);
					if (nexthrank != null) {
						RankUPAPI.getManager().getPlayers().put(player.getUniqueId(), nexthrank);
						Mine.sendActionBar("§fO jogador §b" + player.getName() + " §facabou de upar para "
								+ nexthrank.getPrefix());
						RankUPAPI.getManager().registrar(nexthrank);
					} else {
						player.sendMessage("§cVocê já está no último rank");
					}
				} else {
					player.sendMessage("§cVocê não tem saldo suficiente.");
				}

			}
		return false;
	}

}
