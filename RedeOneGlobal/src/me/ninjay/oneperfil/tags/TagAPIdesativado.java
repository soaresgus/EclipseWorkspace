package me.ninjay.oneperfil.tags;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;


public class TagAPIdesativado {
	
	public static final Map<Player, Tagsdesativado> TAGS = new HashMap<>();
	public static void set(Player player,String prefix) {
		setTag(player, prefix, "");
	}
	public static void setTag(Player player,String prefix,String suffix) {
		setTag(player, new Tagsdesativado(prefix, suffix));
	}
	public static void setTag(Player player,Tagsdesativado tag) {
		TAGS.put(player, tag);
	}
	public static Tagsdesativado getTag(Player player) {
		Tagsdesativado tag = null;
		if((tag =TAGS.get(player)) == null) {
			tag = new Tagsdesativado("TESTE","MARAVILINDO");
			setTag(player, tag);
		}
		return tag;
	}
	
	private static boolean active = true;
	
	public static void update() {
		if(isActive()) {
		for(Player p:Bukkit.getOnlinePlayers()) {
			if(p.getScoreboard() == null) {
				p.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
			}else {
				update(p.getScoreboard());
			}
		}
        update(Bukkit.getScoreboardManager().getMainScoreboard());		
		
	}
	}
		
	@SuppressWarnings("deprecation")
	public static void update(Scoreboard scoreboard) {
		if(isActive()) {
			for(Entry<Player, Tagsdesativado> map : TAGS.entrySet()) {
				Player p = map.getKey();
				Tagsdesativado tag = map.getValue();
				Team team = null;
				if((team = scoreboard.getTeam(p.getName())) ==null) {
					team = scoreboard.registerNewTeam(p.getName());
					
				}
				if(!team.hasPlayer(p)) {
					
					team.addPlayer(p);		
				}
					
			
				team.setPrefix(tag.getPrefix());
				team.setSuffix(tag.getSuffix());
				
			}
		}
	}
	public static boolean isActive() {
		return active;
	}
	public static void setActive(boolean active) {
		TagAPIdesativado.active = active;
	}
	static {
		Plugin plugin = Bukkit.getPluginManager().getPlugins()[0];
		new BukkitRunnable() {
			
			@Override
			public void run() {
		update();
				
			}
		}.runTaskTimer(plugin, 20, 20);
	}

}
