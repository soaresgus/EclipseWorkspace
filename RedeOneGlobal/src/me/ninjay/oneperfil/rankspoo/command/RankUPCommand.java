package me.ninjay.oneperfil.rankspoo.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.oneperfil.almas.estruturas.AlmasAPI;
import me.ninjay.oneperfil.estruturas.BlocosAPI;
import me.ninjay.oneperfil.estruturas.DataAPI;
import me.ninjay.oneperfil.estruturas.EventosAPI;
import me.ninjay.oneperfil.main.Main;
import me.ninjay.oneperfil.rankspoo.manager.RankUP;
import me.ninjay.oneperfil.rankspoo.manager.RankUPAPI;
import net.eduard.api.lib.modules.VaultAPI;

public class RankUPCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Double money = VaultAPI.getEconomy().getBalance(player);
			RankUP rank = RankUPAPI.getManager().getRank(player);
			Long blocos = BlocosAPI.getBlocos(player, Main.blocos);
			Long horas = DataAPI.getTempoOnline(player, Main.data);
			Long almas = AlmasAPI.getAlmas(player, Main.almas);
			Long eventos = EventosAPI.getTotal(player, Main.wins);
			if (money >= rank.getPreco()) {
				if (blocos >= rank.getBlocos()) {
					if (horas >= rank.getHoras()) {
						if (almas >= rank.getAlmas()) {
							if (eventos >= rank.getEventos()) {
								VaultAPI.getEconomy().withdrawPlayer(player, rank.getPreco());
								BlocosAPI.removeBlocos(player, Main.blocos, rank.getBlocos());
								AlmasAPI.removeAlmas(player, Main.almas, rank.getAlmas());
								RankUP nexthrank = RankUPAPI.getManager().getRank(rank.getLevel() + 1);
								if (nexthrank != null) {
									RankUPAPI.getManager().getPlayers().put(player.getUniqueId(), nexthrank);
									Mine.sendActionBar("§6O jogador §e" + player.getName() + " §6upou para o §e"
											+ nexthrank.getPrefix());
									Bukkit.broadcastMessage("§6§lONE Ranks\n \n§6O jogador §e" + player.getName()
											+ " §6upou para o §e" + nexthrank.getPrefix() + "\n ");
								    VaultAPI.getPermission().playerAddGroup(player, nexthrank.getGrupo());
								    VaultAPI.getPermission().playerRemoveGroup(player, rank.getGrupo());
								}

							}else {
								player.sendMessage("§cVocê não possui os requisitos suficiente. Utilize /ranks para ver os requisitos.");
							}

						}else {
							player.sendMessage("§cVocê não possui os requisitos suficiente. Utilize /ranks para ver os requisitos.");
						}
					}else {
						player.sendMessage("§cVocê não possui os requisitos suficiente. Utilize /ranks para ver os requisitos.");
					}
				}else {
					player.sendMessage("§cVocê não possui os requisitos suficiente. Utilize /ranks para ver os requisitos.");
				}
			}else {
				player.sendMessage("§cVocê não possui os requisitos suficiente. Utilize /ranks para ver os requisitos.");
			}

		}
		return false;
	}

}
