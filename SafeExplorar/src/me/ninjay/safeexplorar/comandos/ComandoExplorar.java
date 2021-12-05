package me.ninjay.safeexplorar.comandos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.safeexplorar.main.Main;

public class ComandoExplorar implements CommandExecutor, Listener{
	
	private static ArrayList<Player> stay = new ArrayList<>();
	public static HashMap<Block, Material> bloco = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			Location loc = new Location(Bukkit.getWorld(Main.config.getString("mundo")), Main.config.getDouble("x"), Main.config.getDouble("y"), Main.config.getDouble("z"));
			
			if(!stay.contains(p)) {
			p.sendMessage("              §6§lMundo de exploração             \n §e* §7Mundo com objetivo de coletar recursos\n §e* §7Não é possível construir nesse mundo\n §e* §7PvP desativado nesse mundo\n ");
			stay.add(p);
			p.teleport(loc);
			}else {
				p.sendMessage("§cVocê já está explorando.");
			}
		}
		return false;
	}
	
	@EventHandler
	public void dano(EntityDamageEvent e) {
		Player p = (Player) e.getEntity();
			if(stay.contains(p)) {
				e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		if(stay.contains(e.getPlayer())) {
			if(!e.getMessage().contains("/spawn")) {
			e.setCancelled(true);
			e.getPlayer().sendMessage("§cComando bloqueados nesse mundo, para sair digite /spawn.");
		}else {
			stay.remove(e.getPlayer());
		}
		}
	}
	
	
	@EventHandler
	public void aoSair(PlayerQuitEvent e) {
		if(stay.contains(e.getPlayer())) {
			stay.remove(e.getPlayer());
		}
	}
	
	@EventHandler
	public void aoColocar(BlockPlaceEvent e) {
		if(stay.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		if(stay.contains(e.getPlayer())) {
			bloco.put(e.getBlock(), e.getBlock().getType());
			new BukkitRunnable() {
				int i = Main.config.getInt("resetTime");
				@Override
				public void run() {
					i--;
					e.getPlayer().sendMessage(""+i);
					if(i <= 0) {
						cancel();
						e.getBlock().setType(bloco.get(e.getBlock()));
						i = Main.config.getInt("resetTime");
					}
				}
			}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
		}
	}
}
