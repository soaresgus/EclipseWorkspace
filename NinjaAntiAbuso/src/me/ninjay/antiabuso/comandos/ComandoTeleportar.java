package me.ninjay.antiabuso.comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.ninjay.antiabuso.utils.Mine;

public class ComandoTeleportar implements CommandExecutor{
	
	public static ArrayList<Player> espectando = new ArrayList<>();
	public static ItemStack sair = Mine.newItem(Material.REDSTONE_TORCH_ON, "§eSair do espectador");
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage("§cDigite um nick para se teleportar.");
				return true;
			}
			if(ComandoModReq.nick.contains(args[0])) {
				p.sendMessage("§aTeleportado até "+args[0]);
				p.teleport(Bukkit.getPlayer(args[0]));
				ComandoModReq.nick.remove(args[0]);
			}else {
				p.sendMessage("§cO jogador não solicitou um staff.");
			}
		}
		return false;
	}
	

}
