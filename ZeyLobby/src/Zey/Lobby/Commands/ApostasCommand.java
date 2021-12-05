package Zey.Lobby.Commands;

import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;

import Zey.Lobby.Config.ConfigManager;
import Zey.Lobby.Main.Main;

public class ApostasCommand extends ConfigManager implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(String.valueOf(Main.prefix) + " §7» §cApenas jogadores podem usar isso.");
            return true;
        }
        final Player p = (Player)sender;
        if (!cmd.getName().equalsIgnoreCase("spawnapostas")) {
            return false;
        }
        if (p.hasPermission("zey.lobby.spawnapostasvillager")) {
            spawnarVillager(p.getLocation());
            return true;
        }
        return false;
    }
    
    @SuppressWarnings("deprecation")
	public static void spawnarVillager(final Location local) {
        final Villager v = (Villager)Bukkit.getServer().getWorld(local.getWorld().getName()).spawnEntity(local, EntityType.VILLAGER);
        v.setCanPickupItems(false);
        v.setAdult();
        v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 9999999, 255));
        v.setHealth(20);
        v.setCustomName("§c§l✽ CASSINO ✽");
        v.setProfession(Villager.Profession.LIBRARIAN);
    }
}
