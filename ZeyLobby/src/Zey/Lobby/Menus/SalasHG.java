package Zey.Lobby.Menus;

import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import Zey.Lobby.Main.Main;

import org.bukkit.command.*;
import org.bukkit.event.inventory.*;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.*;
import org.bukkit.event.*;

public class SalasHG implements Listener, CommandExecutor
{
	public static void Menu(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 27, "§7» §7Salas HG");
        
        final ItemStack Vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
        final ItemMeta VidroMeta = Vidro.getItemMeta();
        VidroMeta.setDisplayName("§6§lZey§f§lNetwork");
        Vidro.setItemMeta(VidroMeta);
        inv.setItem(0, Vidro);
        inv.setItem(1, Vidro);
        inv.setItem(2, Vidro);
        inv.setItem(3, Vidro);
        inv.setItem(4, Vidro);
        inv.setItem(5, Vidro);
        inv.setItem(6, Vidro);
        inv.setItem(7, Vidro);
        inv.setItem(8, Vidro);
        inv.setItem(9, Vidro);
        inv.setItem(17, Vidro);
        inv.setItem(18, Vidro);
        inv.setItem(19, Vidro);
        inv.setItem(20, Vidro);
        inv.setItem(21, Vidro);
        inv.setItem(22, Vidro);
        inv.setItem(23, Vidro);
        inv.setItem(24, Vidro);
        inv.setItem(25, Vidro);
        inv.setItem(26, Vidro);
        
        final ItemStack Sala_1 = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta Sala_1Meta = Sala_1.getItemMeta();
        Sala_1Meta.setDisplayName("§bZeyHG - Sala 1");
        final ArrayList<String> Sala_1Desc = new ArrayList<String>();
        Sala_1Desc.add("§c§lOFFLINE");
        Sala_1Meta.setLore((List<String>)Sala_1Desc);
        Sala_1.setItemMeta(Sala_1Meta);
        inv.setItem(10, Sala_1);
        
        final ItemStack Sala_2 = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta Sala_2Meta = Sala_2.getItemMeta();
        Sala_2Meta.setDisplayName("§bZeyHG - Sala 2");
        final ArrayList<String> Sala_2Desc = new ArrayList<String>();
        Sala_2Desc.add("§c§lOFFLINE");
        Sala_2Meta.setLore((List<String>)Sala_2Desc);
        Sala_2.setItemMeta(Sala_2Meta);
        inv.setItem(11, Sala_2);
        
        final ItemStack Sala_3 = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta Sala_3Meta = Sala_3.getItemMeta();
        Sala_3Meta.setDisplayName("§bZeyHG - Sala 3");
        final ArrayList<String> Sala_3Desc = new ArrayList<String>();
        Sala_3Desc.add("§c§lOFFLINE");
        Sala_3Meta.setLore((List<String>)Sala_3Desc);
        Sala_3.setItemMeta(Sala_3Meta);
        inv.setItem(12, Sala_3);
        
        final ItemStack Sala_4 = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta Sala_4Meta = Sala_4.getItemMeta();
        Sala_4Meta.setDisplayName("§bZeyHG - Sala 4");
        final ArrayList<String> Sala_4Desc = new ArrayList<String>();
        Sala_4Desc.add("§c§lOFFLINE");
        Sala_4Meta.setLore((List<String>)Sala_4Desc);
        Sala_4.setItemMeta(Sala_4Meta);
        inv.setItem(13, Sala_4);
        
        final ItemStack Sala_5 = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta Sala_5Meta = Sala_5.getItemMeta();
        Sala_5Meta.setDisplayName("§bZeyHG - Sala 5");
        final ArrayList<String> Sala_5Desc = new ArrayList<String>();
        Sala_5Desc.add("§c§lOFFLINE");
        Sala_5Meta.setLore((List<String>)Sala_5Desc);
        Sala_5.setItemMeta(Sala_5Meta);
        inv.setItem(14, Sala_5);
        
        final ItemStack Sala_6 = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta Sala_6Meta = Sala_6.getItemMeta();
        Sala_6Meta.setDisplayName("§bZeyHG - Sala 6");
        final ArrayList<String> Sala_6Desc = new ArrayList<String>();
        Sala_6Desc.add("§c§lOFFLINE");
        Sala_6Meta.setLore((List<String>)Sala_6Desc);
        Sala_6.setItemMeta(Sala_6Meta);
        inv.setItem(15, Sala_6);
        
        final ItemStack Sala_7 = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta Sala_7Meta = Sala_7.getItemMeta();
        Sala_7Meta.setDisplayName("§bZeyHG - Sala 7");
        final ArrayList<String> Sala_7Desc = new ArrayList<String>();
        Sala_7Desc.add("§c§lOFFLINE");
        Sala_7Meta.setLore((List<String>)Sala_7Desc);
        Sala_7.setItemMeta(Sala_7Meta);
        inv.setItem(16, Sala_7);
        
        p.openInventory(inv);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("warps")) {
            final Player p = (Player)sender;
            Menu(p);
        }
        return false;
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayerCLickInventry(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§7» §7Salas HG") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eZeyLobby")) {
                e.setCancelled(true);
                p.closeInventory();
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê já está conectado ao servidor lobby.");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eZeyPvP")) {
                e.setCancelled(true);
                p.closeInventory();
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê está conectado ao servidor (ZeyPvP), aguarde.");
                p.performCommand("server ZeyPvP");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eZeyHG")) {
                e.setCancelled(true);
                p.closeInventory();
                SalasHG.Menu(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lWARPS")) {
                e.setCancelled(true);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lLOJA")) {
                e.setCancelled(true);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
            }
        }
    }
    
    public static void ir(final Player p, final String string) {
    }
}
