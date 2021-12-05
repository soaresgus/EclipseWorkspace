package me.ninjay.ninjahomes.estruturas;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import me.ninjay.ninjahomes.main.Main;
import me.ninjay.ninjahomes.utils.Mine;

public class HomesAPI {
	
	public static Integer getInt(Player p) {
		return Main.homeconf.getInt(p.getName()+".homes.quantidade");
	}
	
	public static void addInt(Player p) {
		Main.homeconf.set(p.getName()+".homes.quantidade", getInt(p)+1);
		Main.homeconf.saveConfig();
	}
	
	public static void removeInt(Player p) {
		Main.homeconf.set(p.getName()+".homes.quantidade", getInt(p)-1);
		Main.homeconf.saveConfig();
	}
	
	public static Integer getLimiteDefault() {
		return Main.config.getInt("LimiteMembro");
	}
	
	public static Integer getLimiteVip() {
		return Main.config.getInt("LimiteVip");
	}
	
	public static Integer getTempoDefault() {
		return Main.config.getInt("TempoMembro");
	}
	
	public static Integer getTempoVip() {
		return Main.config.getInt("TempoVip");
	}
	
	public static void setarHome(Player p, String nome) {
		p.sendMessage("§eHome §a§l"+nome+" §esetada com sucesso.");
		Main.homeconf.set(p.getName()+".homes."+nome, p.getLocation());
		Main.listar.set(p.getName()+".homes."+nome, false);
		addInt(p);
		Main.homeconf.saveConfig();
		Main.listar.saveConfig();
	}
	
	public static void setarPublica(Player p, String nome) {
		p.sendMessage("§eHome §a§l"+nome+" §efoi definida como pública.");
		Main.listar.set(p.getName()+".homes."+nome, true);
		Main.listar.saveConfig();
	}
	
	public static void setarParticular(Player p, String nome) {
		p.sendMessage("§eHome §a§l"+nome+" §efoi definida como particular.");
		Main.listar.set(p.getName()+".homes."+nome, false);
		Main.listar.saveConfig();
	}
	
	public static void setarFirstHome(Player p) {
		Location local = new Location(Mine.getWorld("world"), Mine.getRandomDouble(1000.0, 10000.0), Mine.getRandomDouble(30.0, 50.0), Mine.getRandomDouble(1000.0, 10000.0));
		Main.homeconf.set(p.getName()+".homes.default", local);
		Main.listar.set(p.getName()+".homes.default", false);
		addInt(p);
		Main.homeconf.saveConfig();
		Main.listar.saveConfig();
	}
	
	public static void removerHome(Player p, String nome) {
		p.sendMessage("§eHome §a§l"+nome+" §eexcluída com sucesso.");
		Main.homeconf.remove(p.getName()+".homes."+nome);
		Main.listar.remove(p.getName()+".homes."+nome);
		removeInt(p);
		Main.homeconf.saveConfig();
		Main.listar.saveConfig();
	}
	
	public static void tpHome(Player p, String nome) {
		p.sendMessage("§eTeleportado para a home §a§l"+nome+"§e.");
		p.teleport(getHome(p, nome));
	}
	
	public static Location getHome(Player p, String nome) {
		return Main.homeconf.getLocation(p.getName()+".homes."+nome);
	}
}
