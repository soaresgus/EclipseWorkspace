package Zey.Lobby.Commands;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;
import Zey.Lobby.Main.*;
import org.bukkit.*;

public class PingCommand implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command command, final String c, final String[] args) {
        if (sender instanceof Player) {
            final Player p = (Player)sender;
            final int ping = ((CraftPlayer)p).getHandle().ping;
            if (c.equalsIgnoreCase("ping")) {
                if (args.length == 0) {
                    p.sendMessage(String.valueOf(Main.prefix) + " �7� �7Seu ping atual � de �a�l" + ping + " �7ms");
                }
                else if (p.getServer().getPlayer(args[0]) != null) {
                    final String player2 = args[0];
                    final Player target = Bukkit.getServer().getPlayer(args[0]);
                    final int ping2 = ((CraftPlayer)target).getHandle().ping;
                    p.sendMessage(String.valueOf(Main.prefix) + " �7� �7O jogador(a) " + player2 + " �7est� com o ping atual de: �a�l" + ping2 + " �7ms");
                }
                else {
                    p.sendMessage(String.valueOf(Main.prefix) + " �7� �cEste jogador(a) est� offline ou n�o existe.");
                }
            }
        }
        return false;
    }
}
