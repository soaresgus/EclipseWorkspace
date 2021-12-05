package Zey.Lobby.Commands;

import Zey.Lobby.Main.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.player.*;
import org.bukkit.event.*;

public class ChatCommand implements CommandExecutor, Listener
{
    public static boolean c;
    
    static {
        ChatCommand.c = false;
    }
    
    public ChatCommand(final Main main) {
    }
    
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        final Player p = (Player)Sender;
        if (Cmd.getName().equalsIgnoreCase("chat")) {
            if (!p.hasPermission("zey.lobby.chatonoff")) {
                p.sendMessage("�cVoc� n�o tem permiss�o para isso.");
                return true;
            }
            if (Args.length == 0) {
                p.sendMessage(String.valueOf(Main.prefix) + " �7� �cErrado, utilize a sintaxe correta: /chat [Ligar|Desligar]");
                return true;
            }
            if (Args[0].equalsIgnoreCase("desligar")) {
                ChatCommand.c = true;
                Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " �7� �7O chat do servidor foi �c�lDESLIGADO�7.");
            }
            if (Args[0].equalsIgnoreCase("ligar")) {
                ChatCommand.c = false;
                Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " �7� �7O chat do servidor foi �a�lLIGADO�7.");
            }
        }
        return false;
    }
    
    @EventHandler
    public void naoFalarNoChatQuandoTiverOFF(final AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (!p.hasPermission("zey.lobby.falarchat") && ChatCommand.c) {
            e.setCancelled(true);
            p.sendMessage(String.valueOf(Main.prefix) + " �7� �cVoc� n�o tem permiss�o para falar com o chat desativado.");
        }
    }
}
