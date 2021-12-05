package me.ninjay.youtubertrade.eventos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import me.ninjay.youtubertrade.estruturas.ItensAPI;
import me.ninjay.youtubertrade.estruturas.NPC;
import me.ninjay.youtubertrade.main.Main;
import me.ninjay.youtubertrade.utils.Mine;
import net.citizensnpcs.Citizens;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.npc.CitizensNPC;
import net.citizensnpcs.npc.CitizensNPCRegistry;

public class EventosGeral implements Listener{
	
	private static ArrayList<String> repetido = new ArrayList<>();
	
	public ItemStack getCustomSkull(String url) {

        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        if (url.isEmpty()) return head;

        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        profile.getProperties().put("textures", new Property("textures", url));

        try {
            Method mtd = skullMeta.getClass().getDeclaredMethod("setProfile", GameProfile.class);
            mtd.setAccessible(true);
            mtd.invoke(skullMeta, profile);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
            ((Throwable) ex).printStackTrace();
        }

        head.setItemMeta(skullMeta);
        return head;
    }
	
	public static void spawnNpc(Player p, Block b, String nick, String p1, String p2) {
		Location loc = new Location(b.getWorld(), b.getLocation().getX(), b.getLocation().getY(), b.getLocation().getZ(), 0, 0);
		
		Creeper armor = p.getWorld().spawn(b.getLocation().add(0.5, 0, 0.5), Creeper.class);
		armor.setCanPickupItems(false);
		armor.setPersistent(true);
		armor.setRemoveWhenFarAway(false);
		armor.setInvisible(true);
		armor.setSilent(true);
		armor.setPersistent(true);
		armor.setInvulnerable(true);
		armor.setCollidable(false);
		armor.setAI(false);
		armor.setCustomName(nick);
		armor.setCustomNameVisible(false);
		armor.setGravity(false);
		
		NPC npc = new NPC(loc.add(0.5, 0, 0.5), nick, p1, p2);
		npc.show(p);
	}
	
	public static boolean usando = false;
	
	public static void animation(Player p, Block b, ItemStack yt, String nickFinal, String nome) {
		
	if(usando == false) {
		usando = true;
		
		p.playSound(b.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
		
		ArmorStand armor = p.getWorld().spawn(b.getLocation().add(0.5, -0.3, 0.5), ArmorStand.class);
		armor.setCanPickupItems(false);
		armor.setInvisible(true);
		armor.setSilent(true);
		armor.setPersistent(true);
		armor.setInvulnerable(true);
		armor.setCollidable(false);
		armor.setCustomName("§aGerando §cYouTuber");
		armor.setCustomNameVisible(true);
		armor.setGravity(false);
		armor.setHelmet(yt);
		
		new BukkitRunnable() {
			int i = 10;
			@Override
			public void run() {
				i--;
				
				if(i >= 1) {
				p.getWorld().playSound(b.getLocation(), Sound.ENTITY_CAT_AMBIENT, 1F, 1F);
				b.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, b.getLocation().add(0.5, 0.5, 0.5), 300, 0.1, 0.1, 0.1);
				}
				
				if(i == 0) {
					b.getWorld().playSound(b.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, 1F, 1F);
					b.getWorld().spawnParticle(Particle.FLAME, b.getLocation().add(0.5, 0.5, 0.5), 300, 0.1, 0.1, 0.1);
					armor.setCustomName(nome);
					armor.setHelmet(Mine.newHead(nickFinal, nickFinal, 1));
				}
				
				if(i <= -7) {
					cancel();
					b.setType(Material.AIR);
					armor.remove();
					usando=false;
				}
				
				
			}
		}.runTaskTimer(Main.getPlugin(Main.class), 10, 10);
		
	}else {
		p.sendMessage("§cAguarde para utilizar outra caixa!");
	}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		
		if(e.getBlock().getType() == Material.ORANGE_CONCRETE || e.getBlock().getType() == Material.SLIME_BLOCK) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void aoColocar(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlock().getType() == Material.GRASS) {
			new BukkitRunnable() {
				int i = 20;
				@Override
				public void run() {
					i--;
					if(i <= 0) {
						cancel();
					}
					
					if(i <= 20 && i >= 11) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.POPPY));
						e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
					}
					
					if(i <= 10 && i >= 1) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.BLAZE_ROD));
						e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
					}
					
				}
			}.runTaskTimer(Main.getPlugin(Main.class), 10, 10);
		}
		
		if(e.getBlock().getType() == Material.SLIME_BLOCK) {
			new BukkitRunnable() {
				int i = 10;
				@Override
				public void run() {
					i--;
					
					if(i >= 1) {
						p.getWorld().playSound(e.getBlock().getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
					}
					
					if(i <= 9 && i >= 7) {
						Particle.DustOptions dust = new Particle.DustOptions(Color.RED, 2);
						for(int i = 1; i <= 5; i++) {
							e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, e.getBlock().getLocation().add(Mine.getRandomDouble(-3, 3), Mine.getRandomDouble(0, 3), Mine.getRandomDouble(-3, 3)), 10, 0.1, 0.1, 0.1, dust);
						}
					}
					
					if(i == 7) {
						Sheep ovelha = p.getWorld().spawn(e.getBlock().getLocation().add(0.5, 1, 0.5), Sheep.class);
						ovelha.setCustomName("§6Gelado");
						ovelha.setColor(DyeColor.RED);
						ovelha.setCustomNameVisible(true);
						p.getWorld().playSound(e.getBlock().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
					}
					
					if(i <= 6 && i >= 3) { 
						Particle.DustOptions dust = new Particle.DustOptions(Color.YELLOW, 2);
						for(int i = 1; i <= 5; i++) {
							e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, e.getBlock().getLocation().add(Mine.getRandomDouble(-3, 3), Mine.getRandomDouble(0, 3), Mine.getRandomDouble(-3, 3)), 10, 0.1, 0.1, 0.1, dust);
						}
					}
					
					if(i == 3) {
						Pig pig = p.getWorld().spawn(e.getBlock().getLocation().add(0.5, 1, 0.5), Pig.class);
						pig.setCustomName("§cGelatina");
						pig.setCustomNameVisible(true);
						p.getWorld().playSound(e.getBlock().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
					}
					
					if(i <= 3 && i >= 1) {
						Particle.DustOptions dust = new Particle.DustOptions(Color.RED, 2);
						for(int i = 1; i <= 5; i++) {
							e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, e.getBlock().getLocation().add(Mine.getRandomDouble(-3, 3), Mine.getRandomDouble(0, 3), Mine.getRandomDouble(-3, 3)), 10, 0.1, 0.1, 0.1, dust);
						}
					}
					
					if(i == 1) {
						Chicken galinha = p.getWorld().spawn(e.getBlock().getLocation().add(0.5, 1, 0.5), Chicken.class);
						galinha.setCustomName("§6Gelonga");
						galinha.setCustomNameVisible(true);
						p.getWorld().playSound(e.getBlock().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
					}
					
					if(i <= 0) {
						cancel();
						e.getBlock().setType(Material.AIR);
					}
				}
			}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
		}
		
		if(e.getBlock().getType() == Material.ORANGE_CONCRETE) {
			if(usando == false) {
				ArrayList<String> nicks = new ArrayList<>();
				HashMap<String, String> p1 = new HashMap<>();
				HashMap<String, String> p2 = new HashMap<>();
				
				if(repetido.size() >= 10) {
					repetido.clear();
				}
				
				nicks.clear();
			if(!repetido.contains("Jazzghost")) {
				nicks.add("Jazzghost");
			}
			if(!repetido.contains("felipe_neto_")) {
				nicks.add("felipe_neto_");
			}
			if(!repetido.contains("Viniccius13")) {
				nicks.add("Viniccius13");
			}
			if(!repetido.contains("DaviGamer_HD")) {
				nicks.add("DaviGamer_HD");
			}
			if(!repetido.contains("ForeverPlayerG")) {
				nicks.add("ForeverPlayerG");
			}
			if(!repetido.contains("rezendeevil")) {
				nicks.add("rezendeevil");
			}
			if(!repetido.contains("pactw")) {
				nicks.add("pactw");
			}
			if(!repetido.contains("mikethelink")) {
				nicks.add("mikethelink");
			}
			if(!repetido.contains("GeleiaPlays")) {
				nicks.add("GeleiaPlays");
			}
			if(!repetido.contains("Dream")) {
				nicks.add("Dream");
			}
				
				p1.clear();
				p2.clear();
				
				p1.put("Jazzghost", "ewogICJ0aW1lc3RhbXAiIDogMTU5ODU3OTgwNDE1NywKICAicHJvZmlsZUlkIiA6ICIwOWZkMjUyZGE2ZWU0YmY5YmZhZjM5NjY3ZGRjYjk2MCIsCiAgInByb2ZpbGVOYW1lIiA6ICJKYXp6Z2hvc3QiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjk0NTJmZmU2ZjJiODcwMjM5YThhZDg2ZWE4MDk5OTA3MzhiZGFmYWU3OWE5NThlY2EwODVlOTA2Njc5ZmFiYSIKICAgIH0KICB9Cn0=");
				p2.put("Jazzghost", "JOg5twV5GhSTjDdr2xL+CwavO6TZviPUi+bDbdfEjpOPu3rO26lNIimD53aMA8b5clZQRmyvzOHh8JhpFLDF/OqJeCmRk3qgWyD9BdUEI0p2zFNnzcnLEfqAHxxbkAHqrsR9uZ0O1LSeCoYb9akO8peHAo/91wnZ29+ZzbwfcY0QXs+77A2f/HrAO+ZTxnVkZ0rA1ZjoEyksHt1nFpcMHOE7X620J4nQQz2HlDSSSjfoCKLh0KHmwa40N0KRSA09YtwA+yoURQPmEyDmRfebqumJhG8qzgJrKpglK9762JQOFfNOyb2U0wypfLFC7X0xENi+5qBpYP4RtkAuQ9kDwh0hstci9QCqzjIGJHk/1j76b41E+Oz6WO/q8fVZ5iNYDQIWX3t/++5nluK5ib5YROQDVPCRE4T725D2Lvh9z0Xj8sJk+zyX/AZJmOKg68bclZ+cD0Y58g5ZpNayAvSh1Z9qVww3Y6NQLk3Qb6Po5WO+5JiCtRmmNKPAremHoBMLXvs+Np1d8cIoolckn3mM0cJLQsBVpm6ndXiyjr9Ebxm2rsCFmF9Vr5gg9o/M7OpkaVxb7pWSwrQCp3yrKpwysaGJUvN6PF+ZH3MJpC1RlKZ8cGYqiympbETAAE3eve2kG/mf12PlqtZxdJasm1WBUH99/eBApGtQ3Xz2saSOVKI=");
				
				p1.put("felipe_neto_", "ewogICJ0aW1lc3RhbXAiIDogMTYyNTc2NTc0Nzc1NywKICAicHJvZmlsZUlkIiA6ICJiNTc5NWY1ZTVjNjQ0MmVkODc4NTZlYzhmYjE0NzVhNiIsCiAgInByb2ZpbGVOYW1lIiA6ICJmZWxpcGVfbmV0b18iLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWE0MWVkMjdlYTUzODllMWI1YmJjZWJhNWRjNTVhNGRiMDllZjllYTJlMjQxODY5OWM5YzViMGQyYzQ0ZmNhMCIKICAgIH0KICB9Cn0=");
				p2.put("felipe_neto_", "IN20x4i5LASdS+APnixN3JrEdfMXrYC81xWgEtYesKMatwhZMg18LGCOdZNfk8ulm8fqF4EozTS+TkByBx1mIkH1K7TKJr3FCjLeFVELXNS+ZRPJrBKrTOP3KB18nt6h7PI42mSwQmmQ9GvN4O987ANgWOsBsyeeW0ig3dmtAnnK/kolVYusfTGb7yjkssUEZ3M1ksjQ95OYMdidW8ibKFoowtEf+O8FAcdAU18RwAWdOlv+IA8bBImJ/RGE6quOTgMOwdhvVgPjYPFtx0d+ITL+B9skJuMDGpqglXOH61e4UnuFrDU+ak1OEI49YkyQZ1D2NTDMMZwqD2Kw7EEHAlZBJ/thP6eooJ8vvcq8t9DLpC0jO4EVploD5lfLQGqDdXWO02HmjEtUIYE+q6FuAAn2w+taNdP1A6+N8RR8RVVW/OzvqowZZCbZfY1dCl2T5ra6SDuzr5VIm9d4GLpkgUZa/AHrwrF1rxia5MwzYfYgGEGLiX/iCulKkfPfAO71kzhgukWHcTZv3Ect+akLRy5/mh1OhbGvcGfVM87Plk11l5XL5xX5tuOMgt9Ug0O7EyZkxQ/jtLqOVS0hZY1DHkTYDfhEy2SxcDSbnIvyiVOlLsPBc7ThiuldRYVcpO5Zk5M2NwbfAC4ewdBsB10lacR6JsuFBe6hie/N1ENjYTY=");
				
				p1.put("Viniccius13", "ewogICJ0aW1lc3RhbXAiIDogMTU5ODg0OTc5MzA2MSwKICAicHJvZmlsZUlkIiA6ICIwZDdmMTBkZmM1MDk0ODNlYTFkNDZmMTUwY2UwNDljZSIsCiAgInByb2ZpbGVOYW1lIiA6ICJ2aW5pY2NpdXMxMyIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS84NDhiYTgyYmQ2MTNmODU4YTMwNzAyZjUwMDUwZjcxY2NhODFjMGI4MTA5NjdiNjRjNTRkNDEzNjgwYTIxOTYiCiAgICB9CiAgfQp9");
				p2.put("Viniccius13", "IVk5Pviixnpb0zsA/jPUcQ3jhwK4BoPjRP0Ms+31eybXRGtFgYcU/i4sWfENi9BWSXaK7siEClamdUv9z+o20z1hMX3dibiNJyRALYGQecuje8yL9gUtiL/hPpoQZ+uTUrjSUCL+0ZIjgZlxMh13Eixuyppl2Rkx/ZMxcWLrvISYPZ2Dqgg0EcLKAFzqaFipxHpYo3FcbiXsVacW57cq3R9l8gtdRO0Vcw4lorYz3By+E4fm4a2C95HMhMh/fiQ37A8sQQxhxYqwHnFfSHBIIrN7hrjfUmzDee8UrYCPmMK0thN90ThZWbLaRyClE5/RYGiKeWfI00j9p+ljVmNfqAjIvI/K29j71Kd5lPZ47EZPijSYGLOu599+kcJO6pPVBazWJM2RzNdQ68JwGRVd08xHr+qfvzOjkusUQBtC3a28vzpfsRoE2hnvNN3VBfnPVR+q+L9D65tojEl3arWNgIaAfZ1G068tYUAfvyMOyP7v/WNS32HC9xChF3yqhm8wcvjDOSCmmDh02+kGRSgTNTrYhVAPrB8HhIkLY5O6AExo0BtQyJscTcfLat1uLafobufpRZLrR0DFZ1a1deBaVFNdBT0qkOXF5+O/RHoETGXpiHCoKGe7PhkaTK6eVDzrbET7C/6Yaqf8AU5vu3yy5CfQrJNNZbxawP1TWAji3+A=");
				
				p1.put("DaviGamer_HD", "ewogICJ0aW1lc3RhbXAiIDogMTYyNTc2NTk4MzA2NSwKICAicHJvZmlsZUlkIiA6ICIyYzAwMDBhMWQ2MGE0NjFiOTU0MDc5NzQ0ZDBmYmY5ZSIsCiAgInByb2ZpbGVOYW1lIiA6ICJEYXZpR2FtZXJfSEQiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkZDcyNGU3NDNiNTRjZDE0ZDIwYzE0NzBiMzA4OTIyNjRlYzIxYmYzYjg4YjY1NjJmNTJlNTgwNjhkNmE1YSIKICAgIH0KICB9Cn0=");
				p2.put("DaviGamer_HD", "I72EiCEpv2U80e6R0jrramUjSwxWDcc3AGOwTmk5n39PtcLSMRjJXdHvYHhGFpyu9NnfuKTs0lRVd1U+K09va4ael523Qm5bOvlHNKFaL7ioBhnY0uIx303KGY7eeF5hBrAh9JrzkoGBM+6JOXHvAhJq5lGxqz//W2nsHTSz9ZtmFKbLWFC8Ho8t8/bLZZWov8T+NjHKxS4uSCNAbhWPcEe7IGmxZ/h+Jc3ZnqyDhK6pSJicmsKXdr6ougQU4ehwf1D7q36r803boi+23lBSfCgrpE8aEIDazH72XuLyT7nLLnslOF1ETbMAFEJ9oXHsSIpeEOUaARqkBT6uqF1xAvQrYzwHJdihcKiYstTGrTrZ9qqIi4rAu3aY45twMsJ2Yp0TzPtqMPxyCCLrF3MnAvWlPLFaC5WT+2yWiXTyZsMu0BLf2iegOeB6HnmddvsVAauhrhPCVi52Dgp7AmDus2oeOJ4hCbGusV2G2TsTv4gjCL9tLEzJ3iEOX6/P7YUg3MuXi7roY5HSoLCJJcUQw0gl420OjjXEHLaXawhcyEPSywVmo73zw4zIuyHXFfyx6GInCyG/XWgwu8UPIM0FUMuFetkr+l7j6YR3GNyYFi8kCXEjWT5vLSogs/UEN0cBO5WwNPjralz2RVfpjp7Q1JOFoiO3ufK7wkas96w7/GU=");
				
				p1.put("ForeverPlayerG", "ewogICJ0aW1lc3RhbXAiIDogMTU5MTgxNjQ3NTY2MywKICAicHJvZmlsZUlkIiA6ICJiMGQ0YjI4YmMxZDc0ODg5YWYwZTg2NjFjZWU5NmFhYiIsCiAgInByb2ZpbGVOYW1lIiA6ICJNaW5lU2tpbl9vcmciLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWViNDc4OGI3MjUyMmU4NzJhOTFmYTA1NTk3NzljMzFhMmZiZTkyYTM1Mjk1NzMyNmUzYWE1ZjQwMTZhZjRmMCIKICAgIH0KICB9Cn0=");
				p2.put("ForeverPlayerG", "a1pVNkxdBnMYBt16AT5ZF7wDGnm4uqNK0nOZb8m8uf/C3sGtcU/T1LRcSt6AgE0tD5w7ZG7UVqeohL8vb+dBB8puRzDby1F36ooTnaAqrqFKse1MsuhWk9whCg9ICzjmC05cXC3pJqp7VZfahew64HKttnkhLPu3pk0k6t6MlrE5usA1j03SCTnPKd2yTM7mQx8Axm/hAL6Bybnm2uiDA1Zg1yNPRnx8cX0raiZUdmdEFznc+2m5/wdqKlqlvOa2S19vCkx1oaHeG/vdE188YoCcJM7k7s/d2/44qGXfoqKUDnc7peVGx2eLiKIgSJSIZ62ntGngJ1kUQ8cR8tzDbIiw6MhiZOHboOpPck8k78bnkWCbSTroGeMmm0Fuj/9hcHAtWFraCcBDNYjDEI1KbNH9geM/DTAHQPT5SkeL7L9pNpPc1vUYuiec4NsV4weDC9OC6V8EQZX9iLadKE3z631txcKjo4GTPBqAIhil9VT3JBMOto0Oe9N56JAzqpQefl++c59PQ08Ncfkc6sZA7g4cVaHY742ir3iA9SKXL5LioKsTuRLgjpE1b5uvyuakuh5YhUT38Ia3p0km/0oWQwU/IzzNbccqRLcYcXRqCMnsAmdQQTVrjtKoc0uLIYhrIOvZruZRl39If1OwQAak0bGP/Bi8ojgiV+ZuhRZ6PTE=");
				
				p1.put("rezendeevil", "ewogICJ0aW1lc3RhbXAiIDogMTYwNDczMjQ1MTUwNCwKICAicHJvZmlsZUlkIiA6ICI4MmM2MDZjNWM2NTI0Yjc5OGI5MWExMmQzYTYxNjk3NyIsCiAgInByb2ZpbGVOYW1lIiA6ICJOb3ROb3RvcmlvdXNOZW1vIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzNhM2IyMjYwMjJlMzMxOWY5OTNiYzlkN2YzYWM1ODhlZThhZDc5NGQ0MmYwYzIzNzhmMjVhNzQ4YWY4NDgzMDMiCiAgICB9CiAgfQp9");
				p2.put("rezendeevil", "XgmQ9zxWv7QCNXPThuW9xuGt499mlBQ0GcI852E8py9rmIoXMkQ9qw4nHFZnBmO7c9g/ATdQfoOVamPgACWx8wcIV/COOgSgaRvzdRV/0jU6PcpPxwlnPUWevyMxqk3Jqd9QkaiLX0DXwaZQWryaxN+r5EhXemKGBJGhkM4hG6KyMmGs4haz0pk5jdYT1Wb/nuzhHJEi3r+N2EVQ2Kukye0PS54ruW8PttjV6DNUruot8DBKnKifpd9x2gBD1aT2sOKGJOIxNYTx5AXRiTMfc+/J/AwIPUQNNYiGf+vOAhAnUJd2rx2WkVXvxV4CcHIHFjPVT8kjTM+s3a2UmJhgsX2BzfQV4xWT/1ksKMn+2kmHhR5O7qA7SF691VjXLGZCTMxdcC5u9ouTRJhT8HfguAx/sOj9PATNuJCpvx0/5h3fnr1kYOchxR26d6I1DtGhegdGl/vlL1kx1XZrSuQRk4wKqU5OhHOxRnyx5ir/YFKNS1RxKkz2qpj1zVj1t5NyYvbiCodQOXDP0NafGslHWAdST+hAt0dsmJ8ppYRhiUlCumMprYsX4gYmmQopX3p4+mzdJmp2wtv1M87tfd1iKclWC0UQKNu3pXI/XxiLroTjEFpvRp32526259uDjQ6KRtrAqQ2DMcyIztnoz9iUeBsh37u/rGvvqz3PW+I9srQ=");
				
				p1.put("pactw", "ewogICJ0aW1lc3RhbXAiIDogMTYyNTc2NjM1MTI1MCwKICAicHJvZmlsZUlkIiA6ICIzNWVkNGU0ZjY0MTM0ZjA5ODU1MjU4MTRkZWY2NjBlYyIsCiAgInByb2ZpbGVOYW1lIiA6ICJwYWN0dyIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8yYmVmNTIyODQwOWE5MTczNDJlOTkyYjUxOWU5M2MxNzYwNGNhMzgxZWQ3ODM4ZTE2N2ZhMjM0ZTNiMDZhYjRlIgogICAgfQogIH0KfQ==");
				p2.put("pactw", "A/w4gaChzAhbxGlxEpWiqEelawBnz60WkqUm59lRJlHjzdlJXS1E3rmp3RTInx2e0lFHquluXy/23jPGZuKVN5phv/odJ4xuOCQ12gCLaZjeKFvletHNSWXPlnRdKVMp803SxyzxIlt9RDpWQg9vTb3PkoTBdZgeqrJGRHhhpV7OzgwO1c1hi/nOqP0PgdzdhtaiiSMWkhf8/kgJqiIuxD8mS1IeZ5zNrv4PY5N92jvoi9rHi+dvrJ2zSGnU1MgcLRdQQFP8DlWBKmmA8Mj5Yn15jFUYv1axacPK4sJn8+6Hx3mMegDhqOdWTvCRFJXjRkGy4WdUXMeCR81M1kvAn0FFRFxxgVtmDMo9m0fMppgPpjU1cQNRie8WbHtVdZb0d1inSA2QMyFP47oXSXdTHY1mGsfkQS4PU2UQEPeaDMMMQQSW+kJwBL5YLFiFOI9R0A3TTdkMhtJsziw9gN134mJ1pbBRmWIAmlytLBPD+sTXW4ONAWYaerK2DmRcMdNHaIw9nI/VvyzFrdNuSpGxvyr9MrJ1TMj9e7ymVznMcGGtSvKL0OGA6iIsZ7h0ZnObU7wz9hT1MvOpqOHVyranoCtHGBN5z1n30NNcK8rp0nbaFxCuT+1BOhqQmqdjpv3ymyD04Dh5UBR+2GmCkl7AY3dPkOe1EnrZHGtyaTlRJvw=");
				
				p1.put("mikethelink", "ewogICJ0aW1lc3RhbXAiIDogMTYyNTc2NjM4NTk0NSwKICAicHJvZmlsZUlkIiA6ICI1NTdkNTJmNWYxYTc0NDQ2OTExNTIxYzUyODMyZTJjMiIsCiAgInByb2ZpbGVOYW1lIiA6ICJtaWtldGhlbGluayIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS82NzAwYzdiNzE1MzAzNDIxNGNhNzY5Mjg2ZTQwYjc3ODU0YjIxMWEzNzIxZDkyODk5NmJhNmMzYTg3ZTdiZDdmIgogICAgfQogIH0KfQ==");
				p2.put("mikethelink", "fe0rvU9N252gOIvE9/8WWOf48Qsmt4sS/RSPRYDjojITi+xOsZiboXmoT8Tmp5Y4VoDD5Xcsjyy7CtNKi7/VADek+RIBQWP9lnANQmHvh8qXfZYhhfccPpOfWPZ3NOWObqkuvf1d8wveUK/TKptbAJFF8NpVgO64hqg2PTLFMjwGfO8BD1Gvbtc2fYiuvjnjZExfaDGSLDupDoG2c4KgXWcA0NsL/OrgFefETkE/ivAywKxWec7imfWQ9/9bGkbXRubCepQSxlGdBjiJgLxP40Vjfmx/Cmrikxyu5SFU7KZlqsQtHyX/TLiYsQhsh+5D+Te5nVhO02coxYp2mMuDk4OFrhxSvf3bQFaaQ0pj/3QS8Boiyo3qI9G9brkRCYZUEiyEmshZ6QlaXZ6xozhUmmLzRTclrAF7inlKSKF79Rx+c0I8hZPr0+iVTuybB+v3gpKg2ump7Hm4E1e1q5hBi/wVoG8z5UANxpYW+pbkccY7b08/IukD7gnrpAaFjg11FG1pSAoWPQID0VLj73DwyKVIUT03o6K/xlTRZLRR4tlBE5aiPD13CJG+Yh4EOKh7YPqY0SNFqWQOBH2zrS4FNwxud279w6PijvGDsn4/yv9Yzl+jz8qW/FrXRswq856VnLypN8BJehWZnN3grMjyDIqVn8naTXbecWcPxaKmW/w=");
				
				p1.put("GeleiaPlays", "ewogICJ0aW1lc3RhbXAiIDogMTU5MTk2ODk0MDgyMSwKICAicHJvZmlsZUlkIiA6ICI3NTE0NDQ4MTkxZTY0NTQ2OGM5NzM5YTZlMzk1N2JlYiIsCiAgInByb2ZpbGVOYW1lIiA6ICJUaGFua3NNb2phbmciLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2E1YzI4M2FhOGQyNWVmZjdmZmI4NjhiZTAwZmFiMTM5MDFmZTIyMTFhYTc1YjZjNzMxYjNlZGRjYWY1ZGZjIgogICAgfQogIH0KfQ==");
				p2.put("GeleiaPlays", "xgTp+W9r/nrQcfT3Uq4XHiRC3lmAcGHgyvrEIU4uWTV58s5TictMd5F/mod8J3Y+3u1Refrm4lta7D22+Jp7j1KJzHRf+lhwyDdALtKoIq3ctVR0XUdU2A4M392ymD1yt9oObbwvSLLx0xY/LIlom8luqwWi+eGDVCwlPmdj+w8jq+txggV1hR5PunlteExPV2PjXwy3CTkwptSJQO2XjNOBNdMJ+Jy2gUGrDctF6Sj77bj4ivfAbQQaXUTV+xLk6o+ASJe+wTuOrVpL1m68vxnCGnM+3OSqBTGpreG/9eHF/A8/TvIqdEEgdyVy7M1JIqKS+VUAXy3lsnwySlgeywvbenVw0D6Px/IuO1hTr+IlISg+2W61bXq+43Eu9ku5lddiyndh+sO9COdCaykqhl5CMxIEVcYeIfjyslLyHloYpM+vk53A2chY2BN2i87UF9MkeXySwAc2dJBFFLUUApEUi9U6wC2+MKRY7SylKtFdK7Vks+fxwJbGvGN4qjT7kyxtZXypJLPay81STNEq323krhm/RLueAEB3AN8/wS1muDZOThbEWvONaM7i5cHU3i40MFGX/ctFcQIz3gQtC6gybvcFX/gX++HkT3KhCh8Qqe+ZWEqaiLVw6ScwO7H4lv423B+fUBw1Vb+ze/AHUSQYxa5EJOiIPSH3gCLKvWk=");
				
				p1.put("Dream", "ewogICJ0aW1lc3RhbXAiIDogMTYyMTcxNjg3NjUzOCwKICAicHJvZmlsZUlkIiA6ICJkMGI4MjE1OThmMTE0NzI1ODBmNmNiZTliOGUxYmU3MCIsCiAgInByb2ZpbGVOYW1lIiA6ICJqYmFydHl5IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2NhOTNmNmZjNDA0ODhmMTg3N2NkYTk0YTgzMGI1NGU5ZjZmNTRhYjU4YTU0NTNiYWQ1Yzk0NzcyNmRkMWY0NzMiLAogICAgICAibWV0YWRhdGEiIDogewogICAgICAgICJtb2RlbCIgOiAic2xpbSIKICAgICAgfQogICAgfQogIH0KfQ==");
				p2.put("Dream", "f6h0Z5TFb6PWiGCUQ0nQdbLQmRUtkYP/R1ZMcVI1FxYUlDk69BQSQKekG5pRjeWFA/5TIiCmd4GMoAE5fmqVhulFJ2J2MsoFO00SNNwGEYJDX1+sxbAhNYMQ52SfHef7eOfTVAb2Ty2Ru6XvrVcvzEXYL1L93H66Cv4QTd+I+UVs8RN0dCrImAej93+iq/ckCf1z7egTY7mEipkjGpHd+RYE7KyEjd4C35jV35m4cCiGFaYqnSzWexKvvNxz1VgIuXesMxl3R3n0AXDe7wLnousGIXnkcuHGc75ZjsiML+HL60sIBn0H02Go1pGYuU/ilv8DOg7LJimFA49Pugkv9KK9YLejF2fi8PqHqYN3G4RdGxwNCLMu+Kj7ZiePTcbI33LnsmNL7Eh6/oE06R0JbvKYWQ78sqPpzMhc0V5ohtCLK7iDP2PjGJ914QEdJwT02XRMKoPrDV0LcYoj6UqRm/SGLF5zAeiFzHxanaIRYgYsT1ELfriyuPXRU6RCRvUnDle3cpqfkxYYvkHXvJvbKx657Y7AxlChpcq+YTIzNMEWMjPbUKuK93TbcXqVoO0gB+St4VQFnQpNnKcJlklKSqDkEpPO1s3pTomUbv3D0ZBcsMkMAt/CZFVevoqaPTjxx63J6vXkt62yiHlMBeFAWI+e7hWmvBuAZnYYXPxB0Uo=");
				
				String random = Mine.getRandom(nicks);
				
				animation(p, e.getBlock(), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmI3Njg4ZGE0NjU4NmI4NTlhMWNkZTQwY2FlMWNkYmMxNWFiZTM1NjE1YzRiYzUyOTZmYWQwOTM5NDEwNWQwIn19fQ=="), random, "§e§l"+random);
				new BukkitRunnable() {
					
					@Override
					public void run() {
						repetido.add(random);
						p.sendMessage("§e"+random+" joined the game");
						spawnNpc(p, e.getBlock(), random, p1.get(random), p2.get(random));
					}
				}.runTaskLater(Main.getPlugin(Main.class), 29*6L);
			}else {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para utilizar outra caixa!");
			}
		}
	}

	
	@EventHandler
	public void aoMatar(EntityDeathEvent e) {
		
		if(e.getEntity() != null) {
			if(e.getEntity().getCustomName() != null) {
				if(e.getEntity().getCustomName().contains("Gelado") || e.getEntity().getCustomName().contains("Gelatina") || e.getEntity().getCustomName().contains("Gelonga")) {
					for(int i = 1; i <= 20; i++) {
						e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), new ItemStack(Material.GOLD_INGOT));
					}
				}
			}
			if(e.getEntityType() == EntityType.ZOMBIE || e.getEntityType() == EntityType.SKELETON || e.getEntityType() == EntityType.CREEPER || e.getEntityType() == EntityType.SPIDER || e.getEntityType() == EntityType.ENDERMAN) {
				if(Mine.getChance(0.50)) {
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.cash(1));
				}
			}
		}
	}
	
	@EventHandler
	public void onClick(PlayerInteractAtEntityEvent e) {
		Player p = e.getPlayer();

	if(e.getHand() == EquipmentSlot.HAND) {
		if(e.getRightClicked() != null) {
			if(e.getRightClicked().getCustomName().contains("Jazzghost")) {
				p.sendMessage("§f<Jazzghost> bão?...");
				
				ItemStack espada = Mine.newItem(Material.GOLDEN_SWORD, null);
				Mine.addEnchant(espada, Enchantment.DAMAGE_ALL, 3);
				Mine.addEnchant(espada, Enchantment.DURABILITY, 3);
				ItemStack capa = Mine.newItem(Material.GOLDEN_HELMET, null);
				Mine.addEnchant(capa, Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				Mine.addEnchant(capa, Enchantment.DURABILITY, 3);
				ItemStack peito = Mine.newItem(Material.GOLDEN_CHESTPLATE, null);
				Mine.addEnchant(peito, Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				Mine.addEnchant(peito, Enchantment.DURABILITY, 3);
				ItemStack calca = Mine.newItem(Material.GOLDEN_LEGGINGS, null);
				Mine.addEnchant(calca, Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				Mine.addEnchant(calca, Enchantment.DURABILITY, 3);
				ItemStack bota = Mine.newItem(Material.GOLDEN_BOOTS, null);
				Mine.addEnchant(bota, Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				Mine.addEnchant(bota, Enchantment.DURABILITY, 3);
				
				Merchant merchant = Bukkit.createMerchant("Jazzghost");
				ArrayList<MerchantRecipe> recipes = new ArrayList<>();
				MerchantRecipe a = new MerchantRecipe(espada, 999999);
				a.addIngredient(ItensAPI.cash(5));
				recipes.add(a);
				MerchantRecipe b = new MerchantRecipe(capa, 999999);
				b.addIngredient(ItensAPI.cash(2));
				recipes.add(b);
				MerchantRecipe c = new MerchantRecipe(peito, 999999);
				c.addIngredient(ItensAPI.cash(2));
				recipes.add(c);
				MerchantRecipe d = new MerchantRecipe(calca, 999999);
				d.addIngredient(ItensAPI.cash(2));
				recipes.add(d);
				MerchantRecipe ee = new MerchantRecipe(bota, 999999);
				ee.addIngredient(ItensAPI.cash(2));
				recipes.add(ee);
				MerchantRecipe f = new MerchantRecipe(new ItemStack(Material.PAPER, 2), 999999);
				f.addIngredient(new ItemStack(Material.ROTTEN_FLESH, 5));
				recipes.add(f);
				MerchantRecipe g = new MerchantRecipe(new ItemStack(Material.GOLDEN_APPLE, 6), 999999);
				g.addIngredient(ItensAPI.cash(5));
				recipes.add(g);
				
				
				merchant.setRecipes(recipes);
				
				p.openMerchant(merchant, true);
			}
			if(e.getRightClicked().getCustomName().contains("felipe_neto_")) {
				p.sendMessage("§f<felipe_neto_> Alguém viu o espirro?...");
				
				Merchant merchant = Bukkit.createMerchant("Felipe Neto");
				ArrayList<MerchantRecipe> recipes = new ArrayList<>();
				MerchantRecipe a = new MerchantRecipe(new ItemStack(Material.BOOKSHELF, 1), 999999);
				a.addIngredient(ItensAPI.cash(3));
				recipes.add(a);
				MerchantRecipe b = new MerchantRecipe(new ItemStack(Material.YELLOW_BED, 1), 999999);
				b.addIngredient(ItensAPI.cash(3));
				recipes.add(b);
				MerchantRecipe c = new MerchantRecipe(new ItemStack(Material.PAPER, 2), 999999);
				c.addIngredient(new ItemStack(Material.GOLD_ORE, 3));
				recipes.add(c);
				MerchantRecipe d = new MerchantRecipe(new ItemStack(Material.IRON_PICKAXE, 1), 999999);
				d.addIngredient(ItensAPI.cash(1));
				recipes.add(d);
				MerchantRecipe ee = new MerchantRecipe(new ItemStack(Material.WATER_BUCKET, 1), 999999);
				ee.addIngredient(ItensAPI.cash(3));
				recipes.add(ee);
				MerchantRecipe f = new MerchantRecipe(new ItemStack(Material.LAVA_BUCKET, 1), 999999);
				f.addIngredient(ItensAPI.cash(3));
				recipes.add(f);
				MerchantRecipe g = new MerchantRecipe(new ItemStack(Material.PAPER, 5), 999999);
				g.addIngredient(new ItemStack(Material.BONE, 2));
				recipes.add(g);
				MerchantRecipe h = new MerchantRecipe(new ItemStack(Material.DIAMOND_ORE, 1), 999999);
				h.addIngredient(ItensAPI.cash(11));
				recipes.add(h);
				
				
				merchant.setRecipes(recipes);
				
				p.openMerchant(merchant, true);
			}
			
			if(e.getRightClicked().getCustomName().contains("Viniccius13")) {
				p.sendMessage("§f<Viniccius13> Você por acaso não fez trocas com o 14, né?");
				
				Merchant merchant = Bukkit.createMerchant("Viniccius13");
				ArrayList<MerchantRecipe> recipes = new ArrayList<>();
				MerchantRecipe a = new MerchantRecipe(new ItemStack(Material.REDSTONE, 3), 999999);
				a.addIngredient(ItensAPI.cash(36));
				recipes.add(a);
				MerchantRecipe b = new MerchantRecipe(ItensAPI.cash(5), 999999);
				b.addIngredient(new ItemStack(Material.REDSTONE, 3));
				recipes.add(b);
				MerchantRecipe c = new MerchantRecipe(new ItemStack(Material.STICKY_PISTON, 1), 999999);
				c.addIngredient(ItensAPI.cash(13));
				recipes.add(c);
				MerchantRecipe d = new MerchantRecipe(new ItemStack(Material.PISTON, 1), 999999);
				d.addIngredient(ItensAPI.cash(5));
				recipes.add(d);
				MerchantRecipe ee = new MerchantRecipe(new ItemStack(Material.REPEATER, 1), 999999);
				ee.addIngredient(ItensAPI.cash(5));
				recipes.add(ee);
				MerchantRecipe f = new MerchantRecipe(new ItemStack(Material.COMPARATOR, 1), 999999);
				f.addIngredient(ItensAPI.cash(5));
				recipes.add(f);
				MerchantRecipe g = new MerchantRecipe(new ItemStack(Material.REDSTONE_TORCH, 1), 999999);
				g.addIngredient(ItensAPI.cash(13));
				recipes.add(g);
				MerchantRecipe h = new MerchantRecipe(new ItemStack(Material.TARGET, 1), 999999);
				h.addIngredient(ItensAPI.cash(13));
				recipes.add(h);
				MerchantRecipe i = new MerchantRecipe(new ItemStack(Material.DISPENSER, 1), 999999);
				i.addIngredient(ItensAPI.cash(5));
				recipes.add(i);
				
				
				merchant.setRecipes(recipes);
				
				p.openMerchant(merchant, true);
			}
			
			if(e.getRightClicked().getCustomName().contains("DaviGamer_HD")) {
				p.sendMessage("§f<DaviGamer_HD> @-@");
				
				Merchant merchant = Bukkit.createMerchant("Davi Gamer");
				ArrayList<MerchantRecipe> recipes = new ArrayList<>();
				
				ItemStack la = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0);
				EnchantmentStorageMeta lam = (EnchantmentStorageMeta) la.getItemMeta();
				lam.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
				la.setItemMeta(lam);
				
				ItemStack lb = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0);
				EnchantmentStorageMeta lbm = (EnchantmentStorageMeta) lb.getItemMeta();
				lbm.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, false);
				lb.setItemMeta(lbm);
				
				ItemStack lc = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0);
				EnchantmentStorageMeta lcm = (EnchantmentStorageMeta) lc.getItemMeta();
				lcm.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, false);
				lc.setItemMeta(lcm);
				
				ItemStack ld = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0);
				EnchantmentStorageMeta ldm = (EnchantmentStorageMeta) ld.getItemMeta();
				ldm.addEnchant(Enchantment.DURABILITY, 3, false);
				ld.setItemMeta(ldm);
				
				ItemStack le = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0);
				EnchantmentStorageMeta lem = (EnchantmentStorageMeta) le.getItemMeta();
				lem.addEnchant(Enchantment.DIG_SPEED, 5, false);
				le.setItemMeta(lem);
				
				MerchantRecipe a = new MerchantRecipe(la, 999999);
				a.addIngredient(ItensAPI.cash(8));
				recipes.add(a);
				MerchantRecipe b = new MerchantRecipe(ItensAPI.cash(2), 999999);
				b.addIngredient(new ItemStack(Material.SPIDER_EYE, 3));
				recipes.add(b);
				MerchantRecipe c = new MerchantRecipe(lb, 999999);
				c.addIngredient(ItensAPI.cash(5));
				recipes.add(c);
				MerchantRecipe d = new MerchantRecipe(lc, 999999);
				d.addIngredient(ItensAPI.cash(5));
				recipes.add(d);
				MerchantRecipe ee = new MerchantRecipe(ld, 999999);
				ee.addIngredient(ItensAPI.cash(5));
				recipes.add(ee);
				MerchantRecipe f = new MerchantRecipe(le, 999999);
				f.addIngredient(ItensAPI.cash(2));
				recipes.add(f);
				MerchantRecipe g = new MerchantRecipe(new ItemStack(Material.BLAZE_ROD, 1), 999999);
				g.addIngredient(ItensAPI.cash(2));
				recipes.add(g);
				MerchantRecipe h = new MerchantRecipe(new ItemStack(Material.BOOK, 1), 999999);
				h.addIngredient(ItensAPI.cash(10));
				recipes.add(h);
				//MerchantRecipe i = new MerchantRecipe(new ItemStack(Material.DISPENSER, 1), 999999);
				//i.addIngredient(ItensAPI.cash(5));
				//recipes.add(i);
				
				
				merchant.setRecipes(recipes);
				
				p.openMerchant(merchant, true);
			}
			
			if(e.getRightClicked().getCustomName().contains("ForeverPlayerG")) {
				p.sendMessage("§f<ForeverPlayerG> me arruma um matinhooooooo @-@");
				
				Merchant merchant = Bukkit.createMerchant("Forever");
				ArrayList<MerchantRecipe> recipes = new ArrayList<>();
				MerchantRecipe a = new MerchantRecipe(ItensAPI.mato(), 999999);
				a.addIngredient(ItensAPI.cash(3));
				recipes.add(a);
				MerchantRecipe b = new MerchantRecipe(ItensAPI.cash(5), 999999);
				b.addIngredient(new ItemStack(Material.SUGAR_CANE, 16));
				recipes.add(b);
				MerchantRecipe c = new MerchantRecipe(new ItemStack(Material.DEAD_BUSH, 1), 999999);
				c.addIngredient(ItensAPI.cash(1));
				recipes.add(c);
				MerchantRecipe d = new MerchantRecipe(new ItemStack(Material.RED_MUSHROOM, 1), 999999);
				d.addIngredient(ItensAPI.cash(5));
				recipes.add(d);
				MerchantRecipe ee = new MerchantRecipe(new ItemStack(Material.DANDELION, 1), 999999);
				ee.addIngredient(ItensAPI.cash(1));
				recipes.add(ee);
				MerchantRecipe f = new MerchantRecipe(new ItemStack(Material.BROWN_MUSHROOM, 1), 999999);
				f.addIngredient(ItensAPI.cash(5));
				recipes.add(f);
				MerchantRecipe g = new MerchantRecipe(new ItemStack(Material.OAK_SAPLING, 1), 999999);
				g.addIngredient(ItensAPI.cash(5));
				recipes.add(g);
				//MerchantRecipe h = new MerchantRecipe(new ItemStack(Material.TARGET, 1), 999999);
				//h.addIngredient(ItensAPI.cash(13));
				//recipes.add(h);
				//MerchantRecipe i = new MerchantRecipe(new ItemStack(Material.DISPENSER, 1), 999999);
				//i.addIngredient(ItensAPI.cash(5));
				//recipes.add(i);
				
				
				merchant.setRecipes(recipes);
				
				p.openMerchant(merchant, true);
			}
			if(e.getRightClicked().getCustomName().contains("rezendeevil")) {
				p.sendMessage("§f<rezendeevil> saudades do SrPuppy...");
				
				ItemStack espada = Mine.newItem(Material.DIAMOND_SWORD, null);
				Mine.addEnchant(espada, Enchantment.DAMAGE_ALL, 5);
				Mine.addEnchant(espada, Enchantment.DURABILITY, 3);
				ItemStack pic = Mine.newItem(Material.DIAMOND_PICKAXE, null);
				Mine.addEnchant(pic, Enchantment.DIG_SPEED, 5);
				Mine.addEnchant(pic, Enchantment.LOOT_BONUS_BLOCKS, 3);
				Mine.addEnchant(pic, Enchantment.DURABILITY, 3);
				ItemStack axe = Mine.newItem(Material.DIAMOND_AXE, null);
				Mine.addEnchant(axe, Enchantment.DIG_SPEED, 5);
				Mine.addEnchant(axe, Enchantment.LOOT_BONUS_BLOCKS, 3);
				Mine.addEnchant(axe, Enchantment.DURABILITY, 3);
				ItemStack capa = Mine.newItem(Material.DIAMOND_HELMET, null);
				Mine.addEnchant(capa, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				Mine.addEnchant(capa, Enchantment.DURABILITY, 3);
				ItemStack peito = Mine.newItem(Material.DIAMOND_CHESTPLATE, null);
				Mine.addEnchant(peito, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				Mine.addEnchant(peito, Enchantment.DURABILITY, 3);
				ItemStack calca = Mine.newItem(Material.DIAMOND_LEGGINGS, null);
				Mine.addEnchant(calca, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				Mine.addEnchant(calca, Enchantment.DURABILITY, 3);
				ItemStack bota = Mine.newItem(Material.DIAMOND_BOOTS, null);
				Mine.addEnchant(bota, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				Mine.addEnchant(bota, Enchantment.DURABILITY, 3);
				
				Merchant merchant = Bukkit.createMerchant("rezendeevil");
				ArrayList<MerchantRecipe> recipes = new ArrayList<>();
				MerchantRecipe a = new MerchantRecipe(espada, 999999);
				a.addIngredient(ItensAPI.cash(12));
				recipes.add(a);
				MerchantRecipe b = new MerchantRecipe(capa, 999999);
				b.addIngredient(ItensAPI.cash(12));
				recipes.add(b);
				MerchantRecipe c = new MerchantRecipe(peito, 999999);
				c.addIngredient(ItensAPI.cash(15));
				recipes.add(c);
				MerchantRecipe d = new MerchantRecipe(calca, 999999);
				d.addIngredient(ItensAPI.cash(12));
				recipes.add(d);
				MerchantRecipe ee = new MerchantRecipe(bota, 999999);
				ee.addIngredient(ItensAPI.cash(10));
				recipes.add(ee);
				MerchantRecipe f = new MerchantRecipe(pic, 999999);
				f.addIngredient(ItensAPI.cash(15));
				recipes.add(f);
				MerchantRecipe g = new MerchantRecipe(axe, 999999);
				g.addIngredient(ItensAPI.cash(15));
				recipes.add(g);
				
				
				merchant.setRecipes(recipes);
				
				p.openMerchant(merchant, true);
			}
			
			if(e.getRightClicked().getCustomName().contains("pactw")) {
				p.sendMessage("§f<pactw> cê ta bão moço?");
				
				Merchant merchant = Bukkit.createMerchant("pactw");
				ArrayList<MerchantRecipe> recipes = new ArrayList<>();
				MerchantRecipe a = new MerchantRecipe(new ItemStack(Material.FISHING_ROD, 1), 999999);
				a.addIngredient(ItensAPI.cash(2));
				recipes.add(a);
				MerchantRecipe b = new MerchantRecipe(ItensAPI.cash(20), 999999);
				b.addIngredient(new ItemStack(Material.NAME_TAG, 1));
				recipes.add(b);
				MerchantRecipe c = new MerchantRecipe(new ItemStack(Material.ORANGE_TULIP, 1), 999999);
				c.addIngredient(ItensAPI.cash(1));
				recipes.add(c);
				MerchantRecipe d = new MerchantRecipe(new ItemStack(Material.SADDLE, 1), 999999);
				d.addIngredient(ItensAPI.cash(1));
				recipes.add(d);
				MerchantRecipe ee = new MerchantRecipe(new ItemStack(Material.TROPICAL_FISH, 1), 999999);
				ee.addIngredient(ItensAPI.cash(1));
				recipes.add(ee);
				MerchantRecipe f = new MerchantRecipe(new ItemStack(Material.PUFFERFISH_BUCKET, 1), 999999);
				f.addIngredient(ItensAPI.cash(3));
				recipes.add(f);
				MerchantRecipe g = new MerchantRecipe(new ItemStack(Material.TROPICAL_FISH_BUCKET, 1), 999999);
				g.addIngredient(ItensAPI.cash(3));
				recipes.add(g);
			//	MerchantRecipe h = new MerchantRecipe(new ItemStack(Material.TARGET, 1), 999999);
			//	h.addIngredient(ItensAPI.cash(13));
			//	recipes.add(h);
			//	MerchantRecipe i = new MerchantRecipe(new ItemStack(Material.DISPENSER, 1), 999999);
			//	i.addIngredient(ItensAPI.cash(5));
			//	recipes.add(i);
				
				
				merchant.setRecipes(recipes);
				
				p.openMerchant(merchant, true);
			}
			
			if(e.getRightClicked().getCustomName().contains("mikethelink")) {
				p.sendMessage("§f<mikethelink> é o homem aranha, não um sutiã!");
				
				Merchant merchant = Bukkit.createMerchant("mikethelink");
				ArrayList<MerchantRecipe> recipes = new ArrayList<>();
				MerchantRecipe a = new MerchantRecipe(new ItemStack(Material.ENDER_PEARL, 2), 999999);
				a.addIngredient(ItensAPI.cash(7));
				recipes.add(a);
				MerchantRecipe b = new MerchantRecipe(ItensAPI.cash(2), 999999);
				b.addIngredient(new ItemStack(Material.STRING, 16));
				recipes.add(b);
				MerchantRecipe c = new MerchantRecipe(new ItemStack(Material.VINE, 1), 999999);
				c.addIngredient(ItensAPI.cash(1));
				recipes.add(c);
				MerchantRecipe d = new MerchantRecipe(new ItemStack(Material.STRING, 2), 999999);
				d.addIngredient(ItensAPI.cash(1));
				recipes.add(d);
				MerchantRecipe ee = new MerchantRecipe(new ItemStack(Material.LAPIS_LAZULI, 2), 999999);
				ee.addIngredient(ItensAPI.cash(2));
				recipes.add(ee);
				
				ItemStack bow = Mine.newItem(Material.BOW, null);
				Mine.addEnchant(bow, Enchantment.ARROW_DAMAGE, 5);
				Mine.addEnchant(bow, Enchantment.ARROW_KNOCKBACK, 2);
				Mine.addEnchant(bow, Enchantment.ARROW_INFINITE, 1);
				
				MerchantRecipe f = new MerchantRecipe(bow, 999999);
				f.addIngredient(ItensAPI.cash(4));
				recipes.add(f);
			//	MerchantRecipe g = new MerchantRecipe(new ItemStack(Material.TROPICAL_FISH_BUCKET, 1), 999999);
			//	g.addIngredient(ItensAPI.cash(3));
			//	recipes.add(g);
			//	MerchantRecipe h = new MerchantRecipe(new ItemStack(Material.TARGET, 1), 999999);
			//	h.addIngredient(ItensAPI.cash(13));
			//	recipes.add(h);
			//	MerchantRecipe i = new MerchantRecipe(new ItemStack(Material.DISPENSER, 1), 999999);
			//	i.addIngredient(ItensAPI.cash(5));
			//	recipes.add(i);
				
				
				merchant.setRecipes(recipes);
				
				p.openMerchant(merchant, true);
			}
			
			if(e.getRightClicked().getCustomName().contains("GeleiaPlays")) {
				p.sendMessage("§f<GeleiaPlays> Então você quer alguém para zerar o minecraft?");
				
				Merchant merchant = Bukkit.createMerchant("Geleia");
				ArrayList<MerchantRecipe> recipes = new ArrayList<>();
				MerchantRecipe a = new MerchantRecipe(new ItemStack(Material.APPLE, 1), 999999);
				a.addIngredient(ItensAPI.cash(1));
				recipes.add(a);
				MerchantRecipe b = new MerchantRecipe(ItensAPI.cash(6), 999999);
				b.addIngredient(new ItemStack(Material.BLAZE_ROD, 1));
				recipes.add(b);
				MerchantRecipe c = new MerchantRecipe(new ItemStack(Material.COOKED_BEEF, 1), 999999);
				c.addIngredient(ItensAPI.cash(2));
				recipes.add(c);
				MerchantRecipe d = new MerchantRecipe(new ItemStack(Material.PORKCHOP, 1), 999999);
				d.addIngredient(ItensAPI.cash(1));
				recipes.add(d);
				MerchantRecipe ee = new MerchantRecipe(new ItemStack(Material.COOKED_PORKCHOP, 1), 999999);
				ee.addIngredient(ItensAPI.cash(2));
				recipes.add(ee);
				MerchantRecipe f = new MerchantRecipe(new ItemStack(Material.MELON_SLICE, 1), 999999);
				f.addIngredient(ItensAPI.cash(1));
				recipes.add(f);
				MerchantRecipe g = new MerchantRecipe(ItensAPI.geleia(), 999999);
				g.addIngredient(ItensAPI.cash(20));
				recipes.add(g);
				MerchantRecipe h = new MerchantRecipe(new ItemStack(Material.CARROT, 1), 999999);
				h.addIngredient(ItensAPI.cash(1));
				recipes.add(h);
				//MerchantRecipe i = new MerchantRecipe(new ItemStack(Material.DISPENSER, 1), 999999);
				//i.addIngredient(ItensAPI.cash(5));
				//recipes.add(i);
				
				
				merchant.setRecipes(recipes);
				
				p.openMerchant(merchant, true);
			}
			
			if(e.getRightClicked().getCustomName().contains("Dream")) {
				p.sendMessage("§f<Dream> wtf, i don't speak portugues bro");
				
				Merchant merchant = Bukkit.createMerchant("Dream");
				ArrayList<MerchantRecipe> recipes = new ArrayList<>();
				MerchantRecipe a = new MerchantRecipe(new ItemStack(Material.OBSIDIAN, 1), 999999);
				a.addIngredient(ItensAPI.cash(6));
				recipes.add(a);
				MerchantRecipe b = new MerchantRecipe(ItensAPI.cash(5), 999999);
				b.addIngredient(new ItemStack(Material.GOLD_INGOT, 1));
				recipes.add(b);
				MerchantRecipe c = new MerchantRecipe(new ItemStack(Material.ENDER_EYE, 1), 999999);
				c.addIngredient(ItensAPI.cash(6));
				recipes.add(c);
				MerchantRecipe d = new MerchantRecipe(new ItemStack(Material.LIME_BED, 1), 999999);
				d.addIngredient(ItensAPI.cash(8));
				recipes.add(d);
				MerchantRecipe ee = new MerchantRecipe(new ItemStack(Material.TOTEM_OF_UNDYING, 1), 999999);
				ee.addIngredient(ItensAPI.cash(12));
				recipes.add(ee);
				
				ItemStack m = Mine.newItem(Material.POTION, null, 1, 0);
				PotionMeta mm = (PotionMeta) m.getItemMeta();
				mm.setBasePotionData(new PotionData(PotionType.STRENGTH, false, true));
				m.setItemMeta(mm);
				
				ItemStack k = Mine.newItem(Material.POTION, null, 1, 0);
				PotionMeta km = (PotionMeta) k.getItemMeta();
				km.setBasePotionData(new PotionData(PotionType.SPEED, false, true));
				k.setItemMeta(km);
				
				MerchantRecipe f = new MerchantRecipe(m, 999999);
				f.addIngredient(ItensAPI.cash(8));
				recipes.add(f);
				MerchantRecipe g = new MerchantRecipe(k,  999999);
				g.addIngredient(ItensAPI.cash(8));
				recipes.add(g);
				MerchantRecipe h = new MerchantRecipe(new ItemStack(Material.NETHERITE_SWORD, 1), 999999);
				h.addIngredient(ItensAPI.cash(25));
				recipes.add(h);
				MerchantRecipe i = new MerchantRecipe(new ItemStack(Material.NETHERITE_CHESTPLATE, 1), 999999);
				i.addIngredient(ItensAPI.cash(19));
				recipes.add(i);
				
				
				merchant.setRecipes(recipes);
				
				p.openMerchant(merchant, true);
			}
		}
	}
	}
	
}
