package me.ninjay.ninjarankup.comandos;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjarankup.estruturas.rank.Rank;
import me.ninjay.ninjarankup.estruturas.rank.RankAPI;
import me.ninjay.ninjarankup.estruturas.rank.RankControler;
import me.ninjay.ninjarankup.main.Main;
import me.ninjay.ninjarankup.utils.Mine;

public class ComandoRankAdmin implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.hasPermission("rank.admin")) {
				if(args.length <= 2) {
					p.sendMessage("§cUtilize: /rankadmin [player] [aumentar/diminuir] [quantidade].");
					return true;
				}
				
				Player j = Bukkit.getPlayer(args[0]);
				if(j != null) {
					Integer qnt = Mine.toInt(args[2]);
					if(args[1].equalsIgnoreCase("aumentar")) {
						if(StringUtils.isNumeric(args[2])) {
							if(qnt > 0) {
								if(Main.playerRank.getInt(p.getUniqueId().toString()) >= RankAPI.manager.getRanks().size()) {
									p.sendMessage("§a"+j.getName()+" já está no último rank.");
								}
								Integer rankFinal = (Main.playerRank.getInt(p.getUniqueId().toString()))+(qnt);
								
								if(rankFinal <= RankAPI.manager.getRanks().size()) {
									for(int i = 1; i <= qnt; i++) {
										RankControler.upar(p);
									}
									Rank rank = RankAPI.manager.getRankById(rankFinal);
									
									p.sendMessage("§aRank de "+j.getName()+" aumentado para "+rank.getNome()+".");
								}else {
									Integer maior = (RankAPI.manager.getRanks().size())-(Main.playerRank.getInt(p.getUniqueId().toString()));
									for(int i = 1; i <= maior; i++) {
										RankControler.upar(p);
									}
									Rank rank = RankAPI.manager.getRankById(maior);
									
									p.sendMessage("§aRank de "+j.getName()+" aumentado para "+rank.getNome()+".");
								}
								
							}else {
								p.sendMessage("§cDigite um número maior que 0.");
							}
						}else {
							p.sendMessage("§cApenas números.");
						}
					}
					if(args[1].equalsIgnoreCase("diminuir")) {
						if(StringUtils.isNumeric(args[2])) {
							if(qnt > 0) {
								Integer rankSave = (Main.playerRank.getInt(p.getUniqueId().toString()))-(qnt);
								if(rankSave > 0) {
									Main.playerRank.set(p.getUniqueId().toString(), rankSave);
									Main.playerRank.saveConfig();
									
									Rank rank = RankAPI.manager.getRankById(rankSave);
									
									p.sendMessage("§aRank de "+j.getName()+" reduzido para "+rank.getNome()+".");
									
								}else {
									Main.playerRank.set(p.getUniqueId().toString(), 1);
									Main.playerRank.saveConfig();
									
									Rank rank = RankAPI.manager.getRankById(1);
									
									p.sendMessage("§aRank de "+j.getName()+" reduzido para "+rank.getNome()+".");
								}
							}
						}else {
							p.sendMessage("§cApenas números.");
						}
					}
				}else {
					p.sendMessage("§cJogador offline.");
				}
			}
			
		}
		return false;
	}

}
