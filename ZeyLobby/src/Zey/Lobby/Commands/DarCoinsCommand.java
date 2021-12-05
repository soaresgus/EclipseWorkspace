package Zey.Lobby.Commands;

import org.bukkit.event.*;

import Zey.Lobby.Config.ZeyCoins;
import Zey.Lobby.Main.Main;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class DarCoinsCommand implements CommandExecutor, Listener
{
    public static boolean isNumeric(final String str) {
        try {
            Integer.parseInt(str);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("darcoins")) {
            if (!p.hasPermission("zey.lobby.darcoins")) {
                p.sendMessage("§cVocê não tem permissão para isso.");
            }
            else {
                if (args.length == 0) {
                    sender.sendMessage(String.valueOf(Main.prefix) + " §7» §cErrado, utilize a sintaxe correta: /darcoins [jogador(a)] [quantidade]");
                    return true;
                }
                final Player target = Bukkit.getPlayerExact(args[0]);
                if (target == null || !(target instanceof Player)) {
                    sender.sendMessage(String.valueOf(Main.prefix) + " §7» §cEste jogador(a) está offline ou não existe.");
                    return true;
                }
                if (isNumeric(args[1])) {
                    final int coins = Integer.parseInt(args[1]);
                    ZeyCoins.addMoney(target, coins);
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §aVocê deu ao jogador(a): §f" + target.getName() + "§a " + coins + " ZeyCoins");
                    target.sendMessage(String.valueOf(Main.prefix) + " §7» §aVocê recebeu do jogador(a): §f" + p.getName() + "§a " + coins + " ZeyCoins");
                }
            }
        }
        return false;
    }
}
