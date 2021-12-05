package me.ninjay.safecore.estruturas.skills;

import org.bukkit.entity.Player;

import me.ninjay.safecore.main.Main;
import me.ninjay.safecore.utils.BukkitConfig;
import me.ninjay.safecore.utils.Mine;

public class SkillsAPI {

	public static BukkitConfig skills = new BukkitConfig("skills.yml", Main.getInstance());
	public static BukkitConfig playerSkills = new BukkitConfig("playerSkills.yml", Main.getInstance());

	public static void addons(Player p, String skill, String name, int xp) {
		Mine.sendActionBar(p, "§a+"+xp+"XP "+name+" [Nível: "+getNvl(p, skill)+"] ["+getXp(p, skill)+"/"+getXpNec(p, skill)+"]");
	}
	
	public static void setXpNec(Player p, int xp, String skill) { 
		getConfig().set(getSkillName(p, skill)+".xpnec", xp);
		getConfig().saveConfig();
	}
	
	public static int getXpNec(Player p, String skill) {
		return getConfig().getInt(getSkillName(p, skill)+".xpnec");
	}
	
	public static void addXpNec(Player p, String skill, int xp) {
		getConfig().set(getSkillName(p, skill)+".xpnec", getXpNec(p, skill)+xp);
		getConfig().saveConfig();
	}
	
	public static void addXp(Player p, int xp, String skill) {
		getConfig().set(getSkillName(p, skill) + ".xp", getXp(p, skill) + xp);
		getConfig().saveConfig();
	}

	public static int getXp(Player p, String skill) {
		return getConfig().getInt(getSkillName(p, skill) + ".xp");
	}

	public static void setNvl(Player p, String skill, int n) {
		getConfig().set(getSkillName(p, skill) + ".nvl", n);
		getConfig().saveConfig();
	}

	public static int getNvl(Player p, String skill) {
		return getConfig().getInt(getSkillName(p, skill) + ".nvl");
	}

	public static void addNvl(Player p, String skill, int n) {
		getConfig().set(getSkillName(p, skill) + ".nvl", getNvl(p, skill) + n);
		getConfig().saveConfig();
	}

	public static int getNvlTotal(Player p) {
		return getConfig().getInt(p.getName() + ".total");
	}

	public static void addNvlTotal(Player p, int xp) {
		getConfig().set(p.getName() + ".total", getNvlTotal(p) + xp);
		getConfig().saveConfig();
	}

	public static void setNvlTotal(Player p, int xp) {
		getConfig().set(p.getName() + ".total", xp);
		getConfig().saveConfig();
	}

	public static void removeNvlTotal(Player p, int xp) {
		getConfig().set(p.getName() + ".total", getNvlTotal(p) - xp);
		getConfig().saveConfig();
	}

	public static void setXp(Player p, int xp, String skill) {
		getConfig().set(getSkillName(p, skill) + ".xp", xp);
		getConfig().saveConfig();
	}

	public static void removeXp(Player p, int xp, String skill) {
		getConfig().set(getSkillName(p, skill) + ".xp", getXp(p, skill) - xp);
		getConfig().saveConfig();
	}

	public static String getSkillName(Player p, String name) {
		return p.getName() + "." + name;
	}

	public static BukkitConfig getConfig() {
		return playerSkills;
	}

}
