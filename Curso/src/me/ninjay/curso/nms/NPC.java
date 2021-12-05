package me.ninjay.curso.nms;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo.EnumPlayerInfoAction;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.minecraft.server.v1_8_R3.PlayerInteractManager;
import net.minecraft.server.v1_8_R3.WorldServer;

public class NPC {

	private Location location;
	private String name;
	private String texture;
	private String signature;
	private GameProfile profile;
	private EntityPlayer player;
	
	public NPC(Location location, String name, String textura, String signature) {
		super();
		this.location = location;
		this.name = name;
		this.texture = textura;
		this.signature = signature;
		spawnnpc();
	}

	public void spawnnpc() {
		MinecraftServer server = ((CraftServer)Bukkit.getServer()).getServer();
		WorldServer mundo = ((CraftWorld)location.getWorld()).getHandle();
		this.profile = new GameProfile(UUID.randomUUID(), ChatColor.translateAlternateColorCodes('&', this.name));
		this.profile.getProperties().put("textures", new Property("textures", texture, signature));
		this.player = new EntityPlayer(server, mundo, profile, new PlayerInteractManager(mundo));
		this.player.setLocation(location.getX(), location.getY(), location.getZ(), location.getPitch(), location.getYaw());
		
		
	}
	public void show(Player p) {
		PlayerConnection connection = ((CraftPlayer) p.getPlayer()).getHandle().playerConnection;
        connection.sendPacket(new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.ADD_PLAYER, player));
        connection.sendPacket(new PacketPlayOutNamedEntitySpawn(player));
	}
	public void remove(Player p2) {
		PlayerConnection connection2 = ((CraftPlayer) p2.getPlayer()).getHandle().playerConnection;
        connection2.sendPacket(new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.REMOVE_PLAYER, player));
        connection2.sendPacket(new PacketPlayOutEntityDestroy());
        
	}
}
