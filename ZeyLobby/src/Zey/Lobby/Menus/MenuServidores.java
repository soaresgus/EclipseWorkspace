package Zey.Lobby.Menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Zey.Lobby.Main.Main;

public class MenuServidores implements Listener, CommandExecutor
{
	public static void Menu(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 27, "§7» §7Servidores");
        
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
        inv.setItem(10, Vidro);
        inv.setItem(12, Vidro);
        inv.setItem(14, Vidro);
        inv.setItem(16, Vidro);
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
        
        final ItemStack ZeyLobby = new ItemStack(Material.REDSTONE_LAMP_OFF, 1, (short)1);
        final ItemMeta ZeyLobbyMeta = ZeyLobby.getItemMeta();
        ZeyLobbyMeta.setDisplayName("§eZeyLobby");
        ZeyLobby.setItemMeta(ZeyLobbyMeta);
        inv.setItem(11, ZeyLobby);

        final ItemStack ZeyPvP = new ItemStack(Material.STONE_SWORD, 1, (short)0);
        final ItemMeta ZeyPvPMeta = ZeyPvP.getItemMeta();
        ZeyPvPMeta.setDisplayName("§eZeyPvP");
        ZeyPvP.setItemMeta(ZeyPvPMeta);
        inv.setItem(13, ZeyPvP);
        
        final ItemStack ZeyHG = new ItemStack(Material.MUSHROOM_SOUP, 1, (short)0);
        final ItemMeta ZeyHGMeta = ZeyHG.getItemMeta();
        ZeyHGMeta.setDisplayName("§eZeyHG");
        ZeyHG.setItemMeta(ZeyHGMeta);
        inv.setItem(15, ZeyHG);
        
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
        if (e.getInventory().getTitle().equalsIgnoreCase("§7» §7Servidores") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
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
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cAguarde, estamos conectando você ao Servidor (ZeyPvP), aguarde.");
                p.performCommand("server ZeyPvP");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eZeyHG")) {
                e.setCancelled(true);
                p.closeInventory();
                 SalasHG.Menu(p);
                //p.sendMessage(String.valueOf(Main.prefix) + " §7» §cDesculpe, porem no momento não temos nenhum servidor de HardcoreGames disponível.");
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
