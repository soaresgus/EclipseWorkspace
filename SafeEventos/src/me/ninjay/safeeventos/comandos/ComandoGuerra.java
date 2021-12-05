package me.ninjay.safeeventos.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.massivecraft.factions.entity.MPlayer;

import me.ninjay.safeeventos.estruturas.BPManager;
import me.ninjay.safeeventos.utils.BukkitConfig;
import me.ninjay.safeeventos.utils.Mine;

public class ComandoGuerra implements CommandExecutor {

	public static BukkitConfig config = BPManager.config;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			if (config.getBoolean("guerra.ocorrendo") == true) {
				MPlayer mp = MPlayer.get(p);
				if (config.getString("guerra.faccoes").contains(mp.getFactionTag())) {
					if (config.getBoolean("guerra.aberta") == true) {
						for(int i = 1; i <= config.getInt("guerra.facs")/2; i++) {
								if(config.getString("guerra.duelos."+i+".fac1").equals(mp.getFactionTag()) || config.getString("guerra.duelos."+i+".fac2").equals(mp.getFactionTag())) {
									p.sendMessage("§aTeleportado.");
									p.teleport(config.getLocation("guerra.arenas."+i));
									Mine.sendTitle(p, "§a"+config.getString("guerra.duelos."+i+".fac1")+" §fx §a"+config.getString("guerra.duelos."+i+".fac2"),"§fDuelo será iniciado em breve.", 20, 100, 20);
						}
						}
					}else{
						p.sendMessage("§cA guerra não está aberta.");
					}
				}else {
					p.sendMessage("§cSua facção não está classificada.");
				}
			}else {
				p.sendMessage("§cA guerra não está ocorrendo.");
			}
		}
		return false;
	}

}
