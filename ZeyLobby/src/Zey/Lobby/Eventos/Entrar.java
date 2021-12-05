package Zey.Lobby.Eventos;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Zey.Lobby.APIs.TheTitle;
import Zey.Lobby.Main.Main;

public class Entrar implements Listener
{
    @EventHandler
    public void Join(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        TheTitle.sendTitle(p, Main.prefix);
        TheTitle.sendSubTitle(p, "§fSeja Bem Vindo, §f" + p.getName() + ".");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§c               " + Main.prefix + "§c        ");
        p.sendMessage("§f§m------------------------------");
        p.sendMessage("§eOlá, " + p.getName() + " Sejá bem vindo, a rede de servidores");
        p.sendMessage(Main.prefix + " §eFique a vontade, e divirta-se conosco.");
        p.sendMessage("§cLembre-se, estamos em BETA, caso encontre algum bug, report há um staffer.");
        p.sendMessage("§eE, muito obrigado, pela sua presença em nossos servidores.");
        p.sendMessage("§f§m-------------------------------");
        p.teleport(p.getWorld().getSpawnLocation());
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 10.0f, 0.0f);
        p.getInventory().setHelmet((ItemStack)null);
        p.getInventory().setChestplate((ItemStack)null);
        p.getInventory().setLeggings((ItemStack)null);
        p.getInventory().setBoots((ItemStack)null);
        e.setJoinMessage((String)null);
        
        p.getInventory().clear();
        
        p.setGameMode(GameMode.SURVIVAL);
        
        setitem(p, Material.COMPASS, "§eServidores", 4, Enchantment.DAMAGE_ALL, 0, false);
    }
    
    @EventHandler
    public void Morte(final PlayerRespawnEvent e) {
        final Player p = e.getPlayer();
        p.getInventory().setHelmet((ItemStack)null);
        p.getInventory().setChestplate((ItemStack)null);
        p.getInventory().setLeggings((ItemStack)null);
        p.getInventory().setBoots((ItemStack)null);
        
        p.getInventory().clear();
        
        setitem(p, Material.COMPASS, "§eServidores", 4, Enchantment.DAMAGE_ALL, 0, false);
    }
    
    public static void setitem(final Player p, final Material mat, final String nome, final int lugar, final Enchantment enchant, final int level, final boolean trueorfalse) {
        final ItemStack item = new ItemStack(mat);
        final ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(nome);
        itemmeta.addEnchant(enchant, level, trueorfalse);
        item.setItemMeta(itemmeta);
        p.getInventory().setItem(lugar, item);
    }
    
    @SuppressWarnings("unused")
	@EventHandler
    public void onSair(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        e.setQuitMessage((String)null);
    }
}
