package me.ninjay.poo.comandos;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.Skull;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.poo.main.Main;
import net.eduard.api.lib.BukkitConfig;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.PacketPlayOutBlockAction;

public class ComandoProbabilidade implements CommandExecutor, Listener {

	public static BukkitConfig config = new BukkitConfig("config.yml", Main.getPlugin(Main.class));

	@SuppressWarnings("deprecation")
	public void changeChestState(Location loc, boolean open) {
		byte dataByte = (open) ? (byte) 1 : 1;

		for (Player p : Bukkit.getOnlinePlayers()) {

			p.playNote(loc, (byte) 1, dataByte);
			BlockPosition position = new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());

			PacketPlayOutBlockAction blockActionPacket = new PacketPlayOutBlockAction(position,
					net.minecraft.server.v1_8_R3.Block.getById(loc.getBlock().getTypeId()), (byte) 1, dataByte);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(blockActionPacket);
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
			SkullMeta meta = (SkullMeta) skull.getItemMeta();
			meta.setOwner("Tom25W");
			skull.setItemMeta(meta);

			ArmorStand a = p.getWorld().spawn(p.getLocation(), ArmorStand.class);
			a.setHelmet(skull);
			a.setVisible(false);
			a.setCustomName("Opa");
			a.setCustomNameVisible(true);
			a.setGravity(false);
			for( ArmorStand b : p.getWorld().getEntitiesByClass(ArmorStand.class)) {
				if(b.getName().equals("Opa")) {
					b.remove();
				}
			}
            }
		return false;
	}
}