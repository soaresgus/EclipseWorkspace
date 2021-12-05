package me.ninjay.random.comandos.bolao;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.random.main.Main;
import net.eduard.api.lib.modules.VaultAPI;

public class ComandoBolao implements CommandExecutor{

	HashMap<String, Double> valor = new HashMap<>();
	ArrayList<Player> participante = new ArrayList<>();
	ArrayList<Player> participacao = new ArrayList<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String a, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				if(participacao.contains(p)) {
					p.sendMessage("§eVocê já está participando do bolão !");
					return true;
				}
			}
			if(args.length == 0) {
				if(VaultAPI.getEconomy().getBalance(p) < valor.get("Valor")) {
					p.sendMessage("§eVocê não tem dinheiro suficiente.");
					return true;
				}
			}
			if(args.length == 0) {
				VaultAPI.getEconomy().withdrawPlayer(p, valor.get("Valor"));
				participante.add(p);
				participacao.add(p);
				p.sendMessage("§eVocê começou a participar do bolão !");
				return true;
			}
		
			if(!p.hasPermission("bolao.iniciar")) {
				
				return true;
			}
			if(p.hasPermission("bolao.iniciar")) {
				if(args[0].equalsIgnoreCase("valor")) {
					if(args.length == 1) {
						p.sendMessage("§eUtilize /bolao valor <valor>");
					}else {
					String lop = args[1];
					Double lopi = Mine.toDouble(lop);
					valor.put("Valor", lopi);
					p.sendMessage("§eValor do bolão definido para "+lopi);
					VaultAPI.getPermission().playerAdd(p, "bolaocom.valor");
					return true;
				}
					
				}
			}
			if(p.hasPermission("bolao.iniciar")) {
				if(args[0].equalsIgnoreCase("iniciar")) {
					if(!p.hasPermission("bolaocom.valor")) {
						p.sendMessage("§eDefina um valor para o bolão primeiro !");
						return true;
					}
				}
			}
			if(p.hasPermission("bolao.iniciar")) {
				if(args[0].equalsIgnoreCase("iniciar")) {
					if(p.hasPermission("bolao.ocorrendo")) {
						p.sendMessage("§eAguarde outro bolão acabar para iniciar outro.");
						return true;
					}
				}
			}
			if(p.hasPermission("bolao.iniciar")) {
				if(!p.hasPermission("bolao.ocorrendo")) {
				if(args[0].equalsIgnoreCase("iniciar")) {
					if(args.length == 0) {
						p.sendMessage("§eUtilize /bolao iniciar");
					}else {
					Bukkit.broadcastMessage("§eBolão iniciado!\n \nValor: " +valor.get("Valor")+"\n \nTempo restante: 30 segundos\n \nBoa sorte a todos !");
					Mine.sendTitle("§e§lBOLÃO", "§fIniciado por "+p.getName(), 5, 120, 5);
					VaultAPI.getPermission().playerRemove(p, "bolaocom.valor");
					new BukkitRunnable() {
                    int s = 30;						
						@Override
						public void run() {
							s--;
							if(s== 20) { 
								Bukkit.broadcastMessage("§eBolão iniciado!\n \nValor: " +valor.get("Valor")+"\n \nTempo restante: 20 segundos\n \nBoa sorte a todos !");
								Mine.sendTitle("§e§lBOLÃO", "§fFalta 20 segundos para finalizar", 5, 100, 5);
							}
							if(s== 10) {
								Bukkit.broadcastMessage("§eBolão iniciado!\n \nValor: " +valor.get("Valor")+"\n \nTempo restante: 10 segundos\n \nBoa sorte a todos !");
								Mine.sendTitle("§e§lBOLÃO", "§fFalta 10 segundos para finalizar", 5, 100, 5);
							}
							
							if(s == 0) {
								cancel();
								Mine.sendTitle("§e§lBOLÃO", "§f"+Mine.getRandomPlayer(participante).getName()+" ganhou o bolão !", 5, 120, 5);
							    for(Player todos : Bukkit.getOnlinePlayers()) {
							    	VaultAPI.getPermission().playerRemove(p, "bolao.ocorrendo");
								participacao.remove(todos);
								participante.remove(todos);
								VaultAPI.getEconomy().depositPlayer(p, valor.get("Valor"));
							}
							}
							}
					
					}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
					return true;
				}
					
				}
			}
		}
		return false;
	}
		return false;
	} 			
}
			

	