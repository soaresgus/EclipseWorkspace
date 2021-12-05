package me.ninjay.soulthmaquinas.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.soulthmaquinas.estruturas.Maquina;
import me.ninjay.soulthmaquinas.estruturas.MaquinaAPI;
import me.ninjay.soulthmaquinas.main.Main;
import net.eduard.api.lib.modules.VaultAPI;

public class ComandoMaquina implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length <= 2) {
				p.sendMessage("§cUtilize /maquina comprar <maquina> <quantia>");
				return true;
			}
			String sub = args[0];
			String nome = args[1];
			Maquina maquina = MaquinaAPI.manager.getmaquina(nome);
			String quantia = args[2];
			int quantidade = Mine.toInt(quantia);

			if (sub.equalsIgnoreCase("comprar")) {
				if (maquina == null) {
					p.sendMessage("§cA máquina " + nome + " não foi encontrada no banco de dados.");
					return true;
				}
			}
			if (sub.equalsIgnoreCase("comprar")) {
				if (quantidade <= 0) {
					p.sendMessage("§cQuantia inválida. Tente um número maior do que 0.");
					return true;
				}
			}
			if (sub.equalsIgnoreCase("comprar")) {
				if (!Main.maquinasquantia.contains(maquina.getNome() + "_maquina_" + p.getName())) {
					if (VaultAPI.getEconomy().has(p, maquina.getValor() * quantidade)) {
						ItemStack item = maquina.getIcone().clone();
						p.sendMessage("§eVocê comprou sua primeira máquina !");
						p.getInventory().addItem(item);
						Main.maquinasquantia.set(maquina.getNome() + "_maquina_" + p.getName(),
								Main.maquinasquantia.getDouble(maquina.getNome() + "_maquina_" + p.getName())
										+ 1 * quantidade);
						Main.drop.set(maquina.getNome() + "_drop_" + p.getName(),
								Main.drop.getDouble(maquina.getNome() + "_drop_" + p.getName()) + 64 * quantidade);
						Main.maquinasquantia.saveConfig();
						Main.drop.saveConfig();
						VaultAPI.getEconomy().withdrawPlayer(p, maquina.getValor() * quantidade);
						return true;
					} else {
						p.sendMessage("§cVocê não tem money suficiente.");
					}
				}
			}
			if (sub.equalsIgnoreCase("comprar")) {
				if (Main.maquinasquantia.contains(maquina.getNome() + "_maquina_" + p.getName())) {
					if (VaultAPI.getEconomy().has(p, maquina.getValor() * quantidade)) {
						p.sendMessage("§eVocê uma máquina !");
						Main.maquinasquantia.set(maquina.getNome() + "_maquina_" + p.getName(),
								Main.maquinasquantia.getDouble(maquina.getNome() + "_maquina_" + p.getName())
										+ 1 * quantidade);
						Main.drop.set(maquina.getNome() + "_drop_" + p.getName(),
								Main.drop.getDouble(maquina.getNome() + "_drop_" + p.getName()) + 64 * quantidade);
						Main.maquinasquantia.saveConfig();
						Main.drop.saveConfig();
						VaultAPI.getEconomy().withdrawPlayer(p, maquina.getValor() * quantidade);
						return true;
					} else {
						p.sendMessage("§cVocê não tem money suficiente.");
					}
				}
			}
		}

		return false;
	}

}
