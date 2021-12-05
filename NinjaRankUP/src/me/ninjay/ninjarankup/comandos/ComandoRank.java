package me.ninjay.ninjarankup.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjarankup.estruturas.rank.Rank;
import me.ninjay.ninjarankup.estruturas.rank.RankAPI;
import me.ninjay.ninjarankup.estruturas.ranklist.RankListControler;
import me.ninjay.ninjarankup.main.Main;

public class ComandoRank implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			Rank rank = RankAPI.manager.getRankById(Main.playerRank.getInt(p.getUniqueId().toString()));
		if(Main.config.getString("playerRank") != null) {
			if(rank != null) {
			p.sendMessage(Main.config.getString("playerRank").replace("%nick%", p.getName()).replace("%atual%", rank.getNome()).replace("%linha%", "\n").replace("\n", "\n").replace("&", "§"));
			}
			}else {
			p.sendMessage("§aSeu rank: §e"+rank.getNome());
		}
		}
		return false;
	}

}
