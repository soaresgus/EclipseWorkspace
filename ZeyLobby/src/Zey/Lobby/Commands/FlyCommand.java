package Zey.Lobby.Commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import Zey.Lobby.Main.Main;

import org.bukkit.*;

public class FlyCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (!(s instanceof Player)) {
            return false;
        }
        final Player p = (Player)s;
        if (!p.hasPermission("zey.lobby.fly")) {
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê precisa ser §e[SUPREMO] §cou superior, para voar.");
            return true;
        }
        if (args.length == 0) {
            if (p.getAllowFlight()) {
                p.setAllowFlight(false);
                p.setFlying(false);
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Modo fly §c§lDESABILITADO §7para o jogador(a): §f" + p.getName());
                return true;
            }
            p.setAllowFlight(true);
            p.setFlying(true);
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Modo fly §a§lHABILITADO §7para o jogador(a): §f" + p.getName());
            return true;
        }
        else {
            if (args.length != 1) {
                s.sendMessage(String.valueOf(Main.prefix) + " §7» §cErrado, utilize a sintaxe correta: /fly [Jogador(a)]");
                return true;
            }
            if (!p.hasPermission("zey.lobby.fly.others")) {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê precisa ser §a[FRIEND] §cou superior, para permitir um jogador(a) voar.");
                return true;
            }
            final Player t = Bukkit.getPlayerExact(args[0]);
            if (t == null) {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cEste jogador(a) está offline ou não existe.");
                return true;
            }
            if (t.getAllowFlight()) {
                t.setAllowFlight(false);
                t.setFlying(false);
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você §c§lDESABILITOU §7o modo fly para o jogador(a): §f" + t.getName());
                t.sendMessage(String.valueOf(Main.prefix) + " §7» §7Modo fly §c§lDESABILITADO §7pelo jogador(a): §f" + p.getName());
                return true;
            }
            t.setAllowFlight(true);
            t.setFlying(true);
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você §a§lHABILITOU §7o modo fly para o jogador(a): §f" + t.getName());
            t.sendMessage(String.valueOf(Main.prefix) + " §7» §7Modo fly §a§lHABILITADO §7pelo jogador(a): §f" + p.getName());
            return true;
        }
    }
}
