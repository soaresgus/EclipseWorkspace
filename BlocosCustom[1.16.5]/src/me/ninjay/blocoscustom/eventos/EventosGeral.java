package me.ninjay.blocoscustom.eventos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;
import com.sk89q.worldedit.world.World;

import me.ninjay.blocoscustom.main.Main;
import me.ninjay.blocoscustom.utils.Mine;
import me.ninjay.blocoscustom.utils.Schematic;
import net.md_5.bungee.api.ChatColor;

public class EventosGeral implements Listener{
	
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
	
	public static boolean usando = false;
	
	public static void animation(Player p, Block b, String nome, ItemStack a, ItemStack bb, ItemStack c, ItemStack d, ItemStack e, ItemStack f, ItemStack g, ItemStack h, ItemStack ii, ItemStack j, ItemStack finall) {
		
	if(usando == false) {
		usando = true;
		
		p.playSound(b.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F, 1F);
		
		ArmorStand armor = p.getWorld().spawn(b.getLocation().add(0.5, -0.2, 0.5), ArmorStand.class);
		armor.setCanPickupItems(false);
		armor.setInvisible(true);
		armor.setSilent(true);
		armor.setPersistent(true);
		armor.setInvulnerable(true);
		armor.setCollidable(false);
		armor.setCustomName("§e§lSorteando...");
		armor.setCustomNameVisible(true);
		armor.setGravity(false);
		armor.setHelmet(a);
		
		new BukkitRunnable() {
			int i = 10;
			@Override
			public void run() {
				i--;
			if(i >= 1) {
				p.getWorld().playSound(b.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1F, 1F);
			}	
			
				if(i == 9) {
					armor.setHelmet(bb);
				}
				
				if(i == 8) {
					armor.setHelmet(c);
				}
				
				if(i == 7) {
					armor.setHelmet(d);
				}
				
				if(i == 6) {
					armor.setHelmet(e);
				}
				
				if(i == 5) {
					armor.setHelmet(f);
				}
				
				if(i == 4) {
					armor.setHelmet(g);
				}
				
				if(i == 3) {
					armor.setHelmet(h);
				}
				
				if(i == 2) {
					armor.setHelmet(ii);
				}
				
				if(i == 1) {
					armor.setHelmet(j);
				}
				
				if(i == 0) {
					b.getWorld().playSound(b.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
					b.getWorld().spawnParticle(Particle.CLOUD, b.getLocation().add(0.5, 0, 0.5), 200, 0.1, 0.1, 0.1);
					armor.setCustomName(nome);
					armor.setHelmet(finall);
				}
				
				if(i <= -5) {
					cancel();
					b.setType(Material.AIR);
					armor.remove();
					usando=false;
				}
				
				
			}
		}.runTaskTimer(Main.getPlugin(Main.class), 8, 8);
		
	}else {
		p.sendMessage("§cAguarde para utilizar outro bloco!");
	}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		
	if(e.getEntity() != null) {
		if(e.getEntity().getType() == EntityType.ARMOR_STAND) {
			e.setCancelled(true);
		}
	}
	}
	
	@EventHandler
	public void onInteractArmor(PlayerInteractAtEntityEvent e) {
		
		if(e.getRightClicked() != null) {
			if(e.getRightClicked().getType() == EntityType.ARMOR_STAND) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlock().getType().toString().contains("CONCRETE")) {
			e.setCancelled(true);
		}
		if(e.getBlock().getType() == Material.ARMOR_STAND) {
			e.setCancelled(true);
		}
	}

	private static ArrayList<String> rterra = new ArrayList<>();
	private static ArrayList<String> rpedra = new ArrayList<>();
	private static ArrayList<String> rareia = new ArrayList<>();
	private static ArrayList<String> robsidian = new ArrayList<>();
	private static ArrayList<String> rnether = new ArrayList<>();
	private static ArrayList<String> rtnt = new ArrayList<>();
	private static ArrayList<String> rfeno = new ArrayList<>();
	private static ArrayList<String> rpao = new ArrayList<>();
	private static ArrayList<String> rmaca = new ArrayList<>();
	private static ArrayList<String> rcenoura = new ArrayList<>();
	private static ArrayList<String> rlava = new ArrayList<>();
	private static ArrayList<String> ragua = new ArrayList<>();
	private static ArrayList<String> respada = new ArrayList<>();
	private static ArrayList<String> rarco = new ArrayList<>();
	private static ArrayList<String> rcarvao = new ArrayList<>();
	private static ArrayList<String> rferro = new ArrayList<>();
	private static ArrayList<String> rouro = new ArrayList<>();
	private static ArrayList<String> rdiamante = new ArrayList<>();
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlock().getType() == Material.WHITE_CONCRETE) {
			if(usando == true) {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para usar outro bloco!");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				return;
			}
			
			ArrayList<String> random = new ArrayList<>();
			
			random.clear();
		if(!rterra.contains("§aBloco de Terra")) {
			random.add("§aBloco de Terra");
		}
		if(!rterra.contains("§aEquipamentos de madeira")) {
			random.add("§aEquipamentos de madeira");
		}
		if(!rterra.contains("§aBlocos de grama")) {
			random.add("§aBlocos de grama");
		}
		if(!rterra.contains("§aFlores variadas")) {
			random.add("§aFlores variadas");
		}
		if(!rterra.contains("§aEstrutura de terra")) {
			random.add("§aEstrutura de terra");
		}
			
			String rand = Mine.getRandom(random);
			
			animation(p, e.getBlock(), rand, getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5Nzg0M2ZkM2E2ODUyOGEyODY3NDE2OWI5YjgzMWMxNjU4ZmIxZDg2YTcyMTgyNmRjZWQ1MDM0MmUzMjVmMiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRkNjdhM2I0ZmJiNjcxZDg0NWE5Yzg0MmU5ZTg2MDM4YWNlZTE3Yjk1ZTZjYWNiMmIwMmNiOWMifX19"));
			rterra.add(rand);
			if(rterra.size() >= 5) {
				rterra.clear();
			}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(rand.equals("§aBloco de Terra")) {
						e.getBlock().setType(Material.DIRT);
					}
					
					if(rand.equals("§aEquipamentos de madeira")) {
						ItemStack espada = Mine.newItem(Material.WOODEN_SWORD, null);
						Mine.addEnchant(espada, Enchantment.DAMAGE_ALL, 3);
						Mine.addEnchant(espada, Enchantment.DURABILITY, 2);
						ItemStack pic = Mine.newItem(Material.WOODEN_PICKAXE, null);
						Mine.addEnchant(pic, Enchantment.DIG_SPEED, 3);
						Mine.addEnchant(pic, Enchantment.DURABILITY, 2);
						ItemStack axe = Mine.newItem(Material.WOODEN_AXE, null);
						Mine.addEnchant(axe, Enchantment.DIG_SPEED, 3);
						Mine.addEnchant(axe, Enchantment.LOOT_BONUS_BLOCKS, 1);
						Mine.addEnchant(axe, Enchantment.DURABILITY, 2);
						
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), espada).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), pic).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), axe).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
					}
					if(rand.equals("§aBlocos de grama")) {
						ItemStack a = new ItemStack(Material.GRASS_BLOCK, 32);
						ItemStack b = new ItemStack(Material.DIRT, 32);
						ItemStack c = new ItemStack(Material.COARSE_DIRT, 32);
						ItemStack d = new ItemStack(Material.PODZOL, 32);
						ItemStack ee = new ItemStack(Material.GRASS_PATH, 32);
						
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), a).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), b).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), c).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), d).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), ee).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
					}
					
					if(rand.equals("§aFlores variadas")) {
						ItemStack a = new ItemStack(Material.POPPY, 32);
						ItemStack b = new ItemStack(Material.DANDELION, 32);
						ItemStack c = new ItemStack(Material.OXEYE_DAISY, 32);
						ItemStack d = new ItemStack(Material.CORNFLOWER, 32);
						ItemStack ee = new ItemStack(Material.ALLIUM, 32);
						
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), a).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), b).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), c).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), d).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), ee).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
					}
					
					if(rand.equals("§aEstrutura de terra")) {
						File file = new File("plugins/WorldEdit/schematics/terra.schem");
					       com.sk89q.worldedit.world.World adaptedWorld = BukkitAdapter.adapt(p.getWorld());

					        ClipboardFormat format = ClipboardFormats.findByFile(file);

					        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

					            Clipboard clipboard = reader.read();

					            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld,
					                    -1)) {

					                Operation operation = new ClipboardHolder(clipboard).createPaste(editSession)
					                        .to(BlockVector3.at(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ())).ignoreAirBlocks(false).build();

					                try {
					                    Operations.complete(operation);
					                    editSession.flushSession();

					                } catch (WorldEditException e) {
					                    e.printStackTrace();
					                }
					            }


					        } catch (FileNotFoundException e) {
					            e.printStackTrace();
					            return;
					        } catch (IOException e) {
					            e.printStackTrace();
					            return;
					        }
					}
				}
			}.runTaskLater(Main.getPlugin(Main.class), 30*4L);

		}
		
		if(e.getBlock().getType() == Material.ORANGE_CONCRETE) {
			if(usando == true) {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para usar outro bloco!");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				return;
			}
			
			ArrayList<String> random = new ArrayList<>();
			
			random.clear();
			if(!rpedra.contains("§aUma pedra")) {
				random.add("§aUma pedra");
			}
			if(!rpedra.contains("§aEquipamentos de pedra")) {
				random.add("§aEquipamentos de pedra");
			}
			if(!rpedra.contains("§aBuraco no void")) {
				random.add("§aBuraco no void");
			}
			if(!rpedra.contains("§aEsfera de pedra")) {
				random.add("§aEsfera de pedra");
			}
				
				String rand = Mine.getRandom(random);
				
				animation(p, e.getBlock(), rand, getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5Nzg0M2ZkM2E2ODUyOGEyODY3NDE2OWI5YjgzMWMxNjU4ZmIxZDg2YTcyMTgyNmRjZWQ1MDM0MmUzMjVmMiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRkNjdhM2I0ZmJiNjcxZDg0NWE5Yzg0MmU5ZTg2MDM4YWNlZTE3Yjk1ZTZjYWNiMmIwMmNiOWMifX19"));
				rpedra.add(rand);
				if(rpedra.size() >= 4) {
					rpedra.clear();
				}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(rand.equals("§aUma pedra")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.COBBLESTONE));
					}
					
					if(rand.equals("§aEquipamentos de pedra")) {
						ItemStack espada = Mine.newItem(Material.STONE_SWORD, null);
						Mine.addEnchant(espada, Enchantment.DAMAGE_ALL, 4);
						Mine.addEnchant(espada, Enchantment.DURABILITY, 3);
						ItemStack pic = Mine.newItem(Material.STONE_PICKAXE, null);
						Mine.addEnchant(pic, Enchantment.DIG_SPEED, 4);
						Mine.addEnchant(pic, Enchantment.DURABILITY, 3);
						ItemStack axe = Mine.newItem(Material.STONE_AXE, null);
						Mine.addEnchant(axe, Enchantment.DIG_SPEED, 4);
						Mine.addEnchant(axe, Enchantment.LOOT_BONUS_BLOCKS, 2);
						Mine.addEnchant(axe, Enchantment.DURABILITY, 3);
						
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), espada).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), pic).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), axe).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
					}
					if(rand.equals("§aBuraco no void")) {
						for(int y = 0; y <= e.getBlock().getLocation().getBlockY(); y++) {
							p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, -y, 0)).breakNaturally();
						}
					}
					
					if(rand.equals("§aEsfera de pedra")) {
						for(Location loc : sphere(p.getLocation(), 10, true)) {
							loc.getBlock().setType(Material.COBBLESTONE);
						}
					}
					
				}
			}.runTaskLater(Main.getPlugin(Main.class), 30*4L);

		}
		
		if(e.getBlock().getType() == Material.MAGENTA_CONCRETE) {
			if(usando == true) {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para usar outro bloco!");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				return;
			}
			
			ArrayList<String> random = new ArrayList<>();
			
			random.clear();
		if(!rareia.contains("§aUma areia")) {
			random.add("§aUma areia");
		}
		if(!rareia.contains("§aBaú de ouro")) {
			random.add("§aBaú de ouro");
		}
		if(!rareia.contains("§aVários cactos")) {
			random.add("§aVários cactos");
		}
		if(!rareia.contains("§aAreia = Ferro")) {
			random.add("§aAreia = Ferro");
		}
		if(!rareia.contains("§aEstrutura de areia")) {
			random.add("§aEstrutura de areia");
		}
			
			String rand = Mine.getRandom(random);
			
			animation(p, e.getBlock(), rand, getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5Nzg0M2ZkM2E2ODUyOGEyODY3NDE2OWI5YjgzMWMxNjU4ZmIxZDg2YTcyMTgyNmRjZWQ1MDM0MmUzMjVmMiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRkNjdhM2I0ZmJiNjcxZDg0NWE5Yzg0MmU5ZTg2MDM4YWNlZTE3Yjk1ZTZjYWNiMmIwMmNiOWMifX19"));
			rareia.add(rand);
			if(rareia.size() >= 5) {
				rareia.clear();
			}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(rand.equals("§aUma areia")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.SAND));
					}
					
					if(rand.equals("§aBaú de ouro")) {
						ItemStack espada = Mine.newItem(Material.GOLDEN_SWORD, null);
						Mine.addEnchant(espada, Enchantment.DAMAGE_ALL, 4);
						Mine.addEnchant(espada, Enchantment.DURABILITY, 3);
						ItemStack pic = Mine.newItem(Material.GOLDEN_PICKAXE, null);
						Mine.addEnchant(pic, Enchantment.DIG_SPEED, 4);
						Mine.addEnchant(pic, Enchantment.DURABILITY, 3);
						ItemStack axe = Mine.newItem(Material.GOLDEN_AXE, null);
						Mine.addEnchant(axe, Enchantment.DIG_SPEED, 4);
						Mine.addEnchant(axe, Enchantment.LOOT_BONUS_BLOCKS, 2);
						Mine.addEnchant(axe, Enchantment.DURABILITY, 3);
						ItemStack capa = Mine.newItem(Material.GOLDEN_HELMET, null);
						Mine.addEnchant(capa, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
						Mine.addEnchant(capa, Enchantment.DURABILITY, 3);
						ItemStack peito = Mine.newItem(Material.GOLDEN_CHESTPLATE, null);
						Mine.addEnchant(peito, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
						Mine.addEnchant(peito, Enchantment.DURABILITY, 3);
						ItemStack calca = Mine.newItem(Material.GOLDEN_LEGGINGS, null);
						Mine.addEnchant(calca, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
						Mine.addEnchant(calca, Enchantment.DURABILITY, 3);
						ItemStack bota = Mine.newItem(Material.GOLDEN_BOOTS, null);
						Mine.addEnchant(bota, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
						Mine.addEnchant(bota, Enchantment.PROTECTION_FALL, 2);
						Mine.addEnchant(bota, Enchantment.DURABILITY, 3);
						
						e.getBlock().setType(Material.CHEST);
						Chest chest = (Chest) e.getBlock().getState();
						chest.setCustomName("§6Baú de Ouro");
						chest.update(true);
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.GOLD_INGOT));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.GOLD_INGOT));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.GOLD_INGOT));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.GOLD_INGOT));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.GOLD_INGOT));
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.GOLD_BLOCK));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.GOLD_BLOCK));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.GOLD_BLOCK));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.GOLD_BLOCK));
				
						chest.getBlockInventory().setItem(Mine.getPosition(1, 1), axe);
						chest.getBlockInventory().setItem(Mine.getPosition(1, 7), espada);
						chest.getBlockInventory().setItem(Mine.getPosition(1, 9), calca);
						chest.getBlockInventory().setItem(Mine.getPosition(2, 4), pic);
						chest.getBlockInventory().setItem(Mine.getPosition(2, 6), peito);
						chest.getBlockInventory().setItem(Mine.getPosition(3, 2), capa);
						chest.getBlockInventory().setItem(Mine.getPosition(3, 9), bota);
						
					}
					if(rand.equals("§aVários cactos")) {
						for(int y = 0; y <= 6; y++) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), new ItemStack(Material.CACTUS, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						}
					}
					
					if(rand.equals("§aAreia = Ferro")) {
						for(int x = (int)-15; x <= 15; x++) {
							for(int y = (int)-15; y <= 15; y++) {
								for(int z = (int)-15; z <= 15; z++) {
									if(p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).getType() == Material.SAND) {
										p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).setType(Material.IRON_ORE);
									}
								}
							}
						}
					}
					if(rand.equals("§aEstrutura de areia")) {
						File file = new File("plugins/WorldEdit/schematics/areia.schem");
					       com.sk89q.worldedit.world.World adaptedWorld = BukkitAdapter.adapt(p.getWorld());

					        ClipboardFormat format = ClipboardFormats.findByFile(file);

					        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

					            Clipboard clipboard = reader.read();

					            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld,
					                    -1)) {

					                Operation operation = new ClipboardHolder(clipboard).createPaste(editSession)
					                        .to(BlockVector3.at(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ())).ignoreAirBlocks(false).build();

					                try {
					                    Operations.complete(operation);
					                    editSession.flushSession();

					                } catch (WorldEditException e) {
					                    e.printStackTrace();
					                }
					            }


					        } catch (FileNotFoundException e) {
					            e.printStackTrace();
					            return;
					        } catch (IOException e) {
					            e.printStackTrace();
					            return;
					        }
					}
					
				}
			}.runTaskLater(Main.getPlugin(Main.class), 30*4L);

		}
		
		if(e.getBlock().getType() == Material.LIGHT_BLUE_CONCRETE) {
			if(usando == true) {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para usar outro bloco!");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				return;
			}
			
			ArrayList<String> random = new ArrayList<>();
			
			ArrayList<String> repetido = new ArrayList<>();
			
			random.clear();
			if(!robsidian.contains("§aUma obsidian")) {
				random.add("§aUma obsidian");
			}
			if(!robsidian.contains("§aPortal do nether")) {
				random.add("§aPortal do nether");
			}
			if(!robsidian.contains("§aEquipamentos de netherite")) {
				random.add("§aEquipamentos de netherite");
			}
			if(!robsidian.contains("§aLava em sua cabeça")) {
				random.add("§aLava em sua cabeça");
			}
			if(!robsidian.contains("§aBaú de sucata")) {
				random.add("§aBaú de sucata");
			}
				
				String rand = Mine.getRandom(random);
				
				animation(p, e.getBlock(), rand, getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5Nzg0M2ZkM2E2ODUyOGEyODY3NDE2OWI5YjgzMWMxNjU4ZmIxZDg2YTcyMTgyNmRjZWQ1MDM0MmUzMjVmMiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRkNjdhM2I0ZmJiNjcxZDg0NWE5Yzg0MmU5ZTg2MDM4YWNlZTE3Yjk1ZTZjYWNiMmIwMmNiOWMifX19"));
				robsidian.add(rand);
				if(robsidian.size() >= 5) {
					robsidian.clear();
				}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(rand.equals("§aUma obsidian")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.OBSIDIAN));
					}
					
					if(rand.equals("§aPortal do nether")) {
						File file = new File("plugins/WorldEdit/schematics/portal.schem");
					       com.sk89q.worldedit.world.World adaptedWorld = BukkitAdapter.adapt(p.getWorld());

					        ClipboardFormat format = ClipboardFormats.findByFile(file);

					        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

					            Clipboard clipboard = reader.read();

					            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld,
					                    -1)) {

					                Operation operation = new ClipboardHolder(clipboard).createPaste(editSession)
					                        .to(BlockVector3.at(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ())).ignoreAirBlocks(false).build();

					                try {
					                    Operations.complete(operation);
					                    editSession.flushSession();

					                } catch (WorldEditException e) {
					                    e.printStackTrace();
					                }
					            }


					        } catch (FileNotFoundException e) {
					            e.printStackTrace();
					            return;
					        } catch (IOException e) {
					            e.printStackTrace();
					            return;
					        }
					}
					
					if(rand.equals("§aEquipamentos de netherite")) {
						ItemStack espada = Mine.newItem(Material.NETHERITE_SWORD, null);
						Mine.addEnchant(espada, Enchantment.DAMAGE_ALL, 5);
						Mine.addEnchant(espada, Enchantment.DURABILITY, 5);
						ItemStack pic = Mine.newItem(Material.NETHERITE_PICKAXE, null);
						Mine.addEnchant(pic, Enchantment.DIG_SPEED, 5);
						Mine.addEnchant(pic, Enchantment.DURABILITY, 5);
						ItemStack axe = Mine.newItem(Material.NETHERITE_AXE, null);
						Mine.addEnchant(axe, Enchantment.DIG_SPEED, 5);
						Mine.addEnchant(axe, Enchantment.LOOT_BONUS_BLOCKS, 3);
						Mine.addEnchant(axe, Enchantment.DURABILITY, 5);
						
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), espada).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), pic).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), axe).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
					}
					if(rand.equals("§aLava em sua cabeça")) {
						for(int x = (int)-1.5; x <= 1.5; x++) {
							for(int z = (int)-1.5; z <= 1.5; z++) {
								p.getWorld().getBlockAt(p.getLocation().add(x, 5, z)).setType(Material.LAVA);
							}
						}
					}
					
					if(rand.equals("§aBaú de sucata")) {
						e.getBlock().setType(Material.CHEST);
						Chest chest = (Chest) e.getBlock().getState();
						chest.setCustomName("Baú de sucata");
						chest.update(true);
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.STRING));
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.TORCH));
				
						chest.getBlockInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.BUCKET));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.COBBLESTONE));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.FLINT));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.GRAVEL));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.BRICK));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.COBBLESTONE));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.FEATHER));
					}
					
				}
			}.runTaskLater(Main.getPlugin(Main.class), 30*4L);

		}
		
		if(e.getBlock().getType() == Material.YELLOW_CONCRETE) {
			if(usando == true) {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para usar outro bloco!");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				return;
			}
			
			ArrayList<String> random = new ArrayList<>();
			
			ArrayList<String> repetido = new ArrayList<>();
			

			random.clear();
			if(!rnether.contains("§aUma netherack")) {
				random.add("§aUma netherack");
			}
			if(!rnether.contains("§aVários quartzos")) {
				random.add("§aVários quartzos");
			}
			if(!rnether.contains("§aCabeças de wither")) {
				random.add("§aCabeças de wither");
			}
			if(!rnether.contains("§aEstrelas do nether")) {
				random.add("§aEstrelas do nether");
			}
			if(!rnether.contains("§aBaú de sucata")) {
				random.add("§aBaú de sucata");
			}
				
				String rand = Mine.getRandom(random);
				
				animation(p, e.getBlock(), rand, getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5Nzg0M2ZkM2E2ODUyOGEyODY3NDE2OWI5YjgzMWMxNjU4ZmIxZDg2YTcyMTgyNmRjZWQ1MDM0MmUzMjVmMiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRkNjdhM2I0ZmJiNjcxZDg0NWE5Yzg0MmU5ZTg2MDM4YWNlZTE3Yjk1ZTZjYWNiMmIwMmNiOWMifX19"));
				rnether.add(rand);
				if(rnether.size() >= 5) {
					rnether.clear();
				}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(rand.equals("§aUma netherack")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.NETHERRACK));
					}
					
					if(rand.equals("§aVários quartzos")) {
						for(int y = 0; y <= 3; y++) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), new ItemStack(Material.QUARTZ_BLOCK, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), new ItemStack(Material.QUARTZ, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						}
					}
					
					if(rand.equals("§aCabeças de wither")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), new ItemStack(Material.WITHER_SKELETON_SKULL, 16)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
					}
					if(rand.equals("§aEstrelas do nether")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), new ItemStack(Material.NETHER_STAR, 16)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
					}
					
					if(rand.equals("§aBaú de sucata")) {
						e.getBlock().setType(Material.CHEST);
						Chest chest = (Chest) e.getBlock().getState();
						chest.setCustomName("Baú de sucata");
						chest.update(true);
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.STRING));
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.TORCH));
				
						chest.getBlockInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.BUCKET));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.COBBLESTONE));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.FLINT));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.GRAVEL));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.BRICK));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.COBBLESTONE));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.FEATHER));
					}
					
				}
			}.runTaskLater(Main.getPlugin(Main.class), 30*4L);

		}
		
		if(e.getBlock().getType() == Material.LIME_CONCRETE) {
			if(usando == true) {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para usar outro bloco!");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				return;
			}
			
			ArrayList<String> random = new ArrayList<>();
			
			ArrayList<String> repetido = new ArrayList<>();
			

			random.clear();
			if(!rtnt.contains("§aUma TnT")) {
				random.add("§aUma TnT");
			}
			if(!rtnt.contains("§aArmadura anti-explosão")) {
				random.add("§aArmadura anti-explosão");
			}
			if(!rtnt.contains("§aExplosão!!!")) {
				random.add("§aExplosão!!!");
			}
			if(!rtnt.contains("§aEscudos")) {
				random.add("§aEscudos");
			}
			if(!rtnt.contains("§aBaú de sucata")) {
				random.add("§aBaú de sucata");
			}
				
				String rand = Mine.getRandom(random);
				
				animation(p, e.getBlock(), rand, getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5Nzg0M2ZkM2E2ODUyOGEyODY3NDE2OWI5YjgzMWMxNjU4ZmIxZDg2YTcyMTgyNmRjZWQ1MDM0MmUzMjVmMiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRkNjdhM2I0ZmJiNjcxZDg0NWE5Yzg0MmU5ZTg2MDM4YWNlZTE3Yjk1ZTZjYWNiMmIwMmNiOWMifX19"));
				rtnt.add(rand);
				if(rtnt.size() >= 5) {
					rtnt.clear();
				}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(rand.equals("§aUma TnT")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.TNT));
					}
					
					if(rand.equals("§aArmadura anti-explosão")) {
						ItemStack capa = Mine.newItem(Material.DIAMOND_HELMET, null);
						Mine.addEnchant(capa, Enchantment.PROTECTION_EXPLOSIONS, 3);
						ItemStack peito = Mine.newItem(Material.DIAMOND_CHESTPLATE, null);
						Mine.addEnchant(peito, Enchantment.PROTECTION_EXPLOSIONS, 3);
						ItemStack calca = Mine.newItem(Material.DIAMOND_LEGGINGS, null);
						Mine.addEnchant(calca, Enchantment.PROTECTION_EXPLOSIONS, 3);
						ItemStack bota = Mine.newItem(Material.DIAMOND_BOOTS, null);
						Mine.addEnchant(bota, Enchantment.PROTECTION_EXPLOSIONS, 3);
						
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), capa).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), peito).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), calca).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), bota).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
					}
					
					if(rand.equals("§aExplosão!!!")) {
						p.getWorld().createExplosion(e.getBlock().getLocation(), 10F);
					}
					if(rand.equals("§aEscudos")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), new ItemStack(Material.SHIELD, 16)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
					}
					
					if(rand.equals("§aBaú de sucata")) {
						e.getBlock().setType(Material.CHEST);
						Chest chest = (Chest) e.getBlock().getState();
						chest.setCustomName("Baú de sucata");
						chest.update(true);
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.STRING));
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.TORCH));
				
						chest.getBlockInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.BUCKET));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.COBBLESTONE));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.FLINT));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.GRAVEL));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.BRICK));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.COBBLESTONE));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.FEATHER));
					}
					
				}
			}.runTaskLater(Main.getPlugin(Main.class), 30*4L);

		}
		
		if(e.getBlock().getType() == Material.PINK_CONCRETE) {
			if(usando == true) {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para usar outro bloco!");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				return;
			}
			
			ArrayList<String> random = new ArrayList<>();
			
			ArrayList<String> repetido = new ArrayList<>();

			random.clear();
			if(!rfeno.contains("§aUm feno")) {
				random.add("§aUm feno");
			}
			if(!rfeno.contains("§aVárias esmeraldas")) {
				random.add("§aVárias esmeraldas");
			}
			if(!rfeno.contains("§aUma teia")) {
				random.add("§aUma teia");
			}
			if(!rfeno.contains("§aEsfera de feno")) {
				random.add("§aEsfera de feno");
			}
			if(!rfeno.contains("§aBaú de sucata")) {
				random.add("§aBaú de sucata");
			}
				
				String rand = Mine.getRandom(random);
				
				animation(p, e.getBlock(), rand, getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5Nzg0M2ZkM2E2ODUyOGEyODY3NDE2OWI5YjgzMWMxNjU4ZmIxZDg2YTcyMTgyNmRjZWQ1MDM0MmUzMjVmMiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRkNjdhM2I0ZmJiNjcxZDg0NWE5Yzg0MmU5ZTg2MDM4YWNlZTE3Yjk1ZTZjYWNiMmIwMmNiOWMifX19"));
				rfeno.add(rand);
				if(rfeno.size() >= 5) {
					rfeno.clear();
				}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(rand.equals("§aUm feno")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.HAY_BLOCK));
					}
					
					if(rand.equals("§aVárias esmeraldas")) {
						for(int y = 0; y <= 6; y++) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), new ItemStack(Material.EMERALD, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						}
					}
					
					if(rand.equals("§aUma teia")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.COBWEB));
					}
					if(rand.equals("§aEsfera de feno")) {
						for(Location loc : sphere(p.getLocation(), 10, true)) {
							loc.getBlock().setType(Material.HAY_BLOCK);
						}
					}
					
					if(rand.equals("§aBaú de sucata")) {
						e.getBlock().setType(Material.CHEST);
						Chest chest = (Chest) e.getBlock().getState();
						chest.setCustomName("Baú de sucata");
						chest.update(true);
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.STRING));
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.TORCH));
				
						chest.getBlockInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.BUCKET));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.COBBLESTONE));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.FLINT));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.GRAVEL));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.BRICK));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.COBBLESTONE));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.FEATHER));
					}
					
				}
			}.runTaskLater(Main.getPlugin(Main.class), 30*4L);

		}
		
		if(e.getBlock().getType() == Material.GRAY_CONCRETE) {
			if(usando == true) {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para usar outro bloco!");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				return;
			}
			
			ArrayList<String> random = new ArrayList<>();
			
			ArrayList<String> repetido = new ArrayList<>();
			






			
			random.clear();
			if(!rpao.contains("§aUm pão")) {
				random.add("§aUm pão");
			}
			if(!rpao.contains("§aBuraco no void")) {
				random.add("§aBuraco no void");
			}
			if(!rpao.contains("§aVárias flores")) {
				random.add("§aVárias flores");
			}
			if(!rpao.contains("§aVários baldes de leite")) {
				random.add("§aVários baldes de leite");
			}
			if(!rpao.contains("§aUma teia")) {
				random.add("§aUma teia");
			}
				
				String rand = Mine.getRandom(random);
				
				animation(p, e.getBlock(), rand, getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5Nzg0M2ZkM2E2ODUyOGEyODY3NDE2OWI5YjgzMWMxNjU4ZmIxZDg2YTcyMTgyNmRjZWQ1MDM0MmUzMjVmMiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRkNjdhM2I0ZmJiNjcxZDg0NWE5Yzg0MmU5ZTg2MDM4YWNlZTE3Yjk1ZTZjYWNiMmIwMmNiOWMifX19"));
				rpao.add(rand);
				if(rpao.size() >= 5) {
					rpao.clear();
				}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(rand.equals("§aUm pão")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.BREAD));
					}
					
					if(rand.equals("§aBuraco no void")) {
						for(int y = 0; y <= e.getBlock().getLocation().getBlockY(); y++) {
							p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, -y, 0)).breakNaturally();
						}
					}
					
					if(rand.equals("§aVárias flores")) {
						for(int y = 0; y <= 3; y++) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), new ItemStack(Material.DANDELION, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), new ItemStack(Material.POPPY, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), new ItemStack(Material.OXEYE_DAISY, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), new ItemStack(Material.CORNFLOWER, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						}
					}
					if(rand.equals("§aVários baldes de leite")) {
						for(int y = 0; y <= 30; y++) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), new ItemStack(Material.MILK_BUCKET)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						}
					}
					
					if(rand.equals("§aUma teia")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.COBWEB));
					}
					
				}
			}.runTaskLater(Main.getPlugin(Main.class), 30*4L);

		}
		
		if(e.getBlock().getType() == Material.LIGHT_GRAY_CONCRETE) {
			if(usando == true) {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para usar outro bloco!");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				return;
			}
			
			ArrayList<String> random = new ArrayList<>();
			
			ArrayList<String> repetido = new ArrayList<>();
			






			
			random.clear();
			if(!rmaca.contains("§aUma maçã dourada")) {
				random.add("§aUma maçã dourada");
			}
			if(!rmaca.contains("§aBaú especial")) {
				random.add("§aBaú especial");
			}
			if(!rmaca.contains("§aArmadura de ouro")) {
				random.add("§aArmadura de ouro");
			}
			if(!rmaca.contains("§aEspada de ouro")) {
				random.add("§aEspada de ouro");
			}
			if(!rmaca.contains("§aCriador de tudo")) {
				random.add("§aCriador de tudo");
			}
				
				String rand = Mine.getRandom(random);
				
				animation(p, e.getBlock(), rand, getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5Nzg0M2ZkM2E2ODUyOGEyODY3NDE2OWI5YjgzMWMxNjU4ZmIxZDg2YTcyMTgyNmRjZWQ1MDM0MmUzMjVmMiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRkNjdhM2I0ZmJiNjcxZDg0NWE5Yzg0MmU5ZTg2MDM4YWNlZTE3Yjk1ZTZjYWNiMmIwMmNiOWMifX19"));
				rmaca.add(rand);
				if(rmaca.size() >= 5) {
					rmaca.clear();
				}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(rand.equals("§aUma maçã dourada")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.GOLDEN_APPLE));
					}
					
					if(rand.equals("§aBaú especial")) {
						e.getBlock().setType(Material.CHEST);
						Chest chest = (Chest) e.getBlock().getState();
						chest.setCustomName("Baú especial");
						chest.update(true);
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.BLAZE_ROD));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.BLAZE_ROD));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.BLAZE_ROD));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.BLAZE_ROD));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
				
						chest.getBlockInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.BLAZE_ROD));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.BLAZE_ROD));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.BLAZE_ROD));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.BLAZE_ROD));
					}
					
					if(rand.equals("§aArmadura de ouro")) {
						ItemStack capa = Mine.newItem(Material.GOLDEN_HELMET, null);
						ItemStack peito = Mine.newItem(Material.GOLDEN_CHESTPLATE, null);
						ItemStack calca = Mine.newItem(Material.GOLDEN_LEGGINGS, null);
						ItemStack bota = Mine.newItem(Material.GOLDEN_BOOTS, null);
						
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), capa).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), peito).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), calca).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), bota).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
					}
					if(rand.equals("§aEspada de ouro")) {
						ItemStack espada = Mine.newItem(Material.GOLDEN_SWORD, null);
						Mine.addEnchant(espada, Enchantment.KNOCKBACK, 5);
						
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), espada).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
					}
					
					if(rand.equals("§aCriador de tudo")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), Mine.newHead("§eCriador de tudo", "Notch", 1, "  §7Cabeça de Notch."));
					}
					
				}
			}.runTaskLater(Main.getPlugin(Main.class), 30*4L);
		}
		
		if(e.getBlock().getType() == Material.CYAN_CONCRETE) {
			if(usando == true) {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para usar outro bloco!");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				return;
			}
			
			ArrayList<String> random = new ArrayList<>();
			
			ArrayList<String> repetido = new ArrayList<>();
			






			
			random.clear();
			if(!rcenoura.contains("§aUma cenoura")) {
				random.add("§aUma cenoura");
			}
			if(!rcenoura.contains("§aVárias cenouras")) {
				random.add("§aVárias cenouras");
			}
			if(!rcenoura.contains("§aVários ossos")) {
				random.add("§aVários ossos");
			}
			if(!rcenoura.contains("§aUma maçã dourada")) {
				random.add("§aUma maçã dourada");

			}
			if(!rcenoura.contains("§aBaú de selas")) {
				random.add("§aBaú de selas");
			}
				
				String rand = Mine.getRandom(random);
				
				animation(p, e.getBlock(), rand, getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5Nzg0M2ZkM2E2ODUyOGEyODY3NDE2OWI5YjgzMWMxNjU4ZmIxZDg2YTcyMTgyNmRjZWQ1MDM0MmUzMjVmMiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRkNjdhM2I0ZmJiNjcxZDg0NWE5Yzg0MmU5ZTg2MDM4YWNlZTE3Yjk1ZTZjYWNiMmIwMmNiOWMifX19"));
				rcenoura.add(rand);
				if(rcenoura.size() >= 5) {
					rcenoura.clear();
				}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(rand.equals("§aUma cenoura")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.CARROT));
					}
					
					if(rand.equals("§aVárias cenouras")) {
						for(int y = 0; y <= 6; y++) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), new ItemStack(Material.CARROT, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						}
					}
					
					if(rand.equals("§aVários ossos")) {
						for(int y = 0; y <= 6; y++) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), new ItemStack(Material.BONE, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						}
					}
					if(rand.equals("§aUma maçã dourada")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.GOLDEN_APPLE));
					}
					
					if(rand.equals("§aBaú de selas")) {
						e.getBlock().setType(Material.CHEST);
						Chest chest = (Chest) e.getBlock().getState();
						chest.setCustomName("Baú de selas");
						chest.update(true);
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.SADDLE));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.SADDLE));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.SADDLE));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.SADDLE));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.SADDLE));
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.SADDLE));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.SADDLE));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.SADDLE));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.SADDLE));
				
						chest.getBlockInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.SADDLE));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.SADDLE));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.SADDLE));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.SADDLE));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.SADDLE));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.SADDLE));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.SADDLE));
					}
					
				}
			}.runTaskLater(Main.getPlugin(Main.class), 30*4L);
		}
		
		if(e.getBlock().getType() == Material.PURPLE_CONCRETE) {
			if(usando == true) {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para usar outro bloco!");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				return;
			}
			
			ArrayList<String> random = new ArrayList<>();
			
			ArrayList<String> repetido = new ArrayList<>();
			






			
			random.clear();
			if(!rlava.contains("§aUm balde de lava")) {
				random.add("§aUm balde de lava");
			}
			if(!rlava.contains("§aLava em sua cabeça")) {
				random.add("§aLava em sua cabeça");
			}
			if(!rlava.contains("§aEspada de diamante")) {
				random.add("§aEspada de diamante");
			}
			if(!rlava.contains("§aEstrutura de lava")) {
				random.add("§aEstrutura de lava");
			}
			if(!rlava.contains("§aBaú de obsidians")) {
				random.add("§aBaú de obsidians");
			}
				
				String rand = Mine.getRandom(random);
				
				animation(p, e.getBlock(), rand, getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5Nzg0M2ZkM2E2ODUyOGEyODY3NDE2OWI5YjgzMWMxNjU4ZmIxZDg2YTcyMTgyNmRjZWQ1MDM0MmUzMjVmMiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRkNjdhM2I0ZmJiNjcxZDg0NWE5Yzg0MmU5ZTg2MDM4YWNlZTE3Yjk1ZTZjYWNiMmIwMmNiOWMifX19"));
				rlava.add(rand);
				if(rlava.size() >= 5) {
					rlava.clear();
				}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(rand.equals("§aUm balde de lava")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.LAVA_BUCKET));
					}
					
					if(rand.equals("§aLava em sua cabeça")) {
						for(int x = (int)-1.5; x <= 1.5; x++) {
							for(int z = (int)-1.5; z <= 1.5; z++) {
								p.getWorld().getBlockAt(p.getLocation().add(x, 5, z)).setType(Material.LAVA);
							}
						}
					}
					
					if(rand.equals("§aEspada de diamante")) {
						ItemStack espada = Mine.newItem(Material.DIAMOND_SWORD, null);
						Mine.addEnchant(espada, Enchantment.DAMAGE_ALL, 5);
						espada.setDurability((short)1551);
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), espada).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
					}
					if(rand.equals("§aEstrutura de lava")) {
						File file = new File("plugins/WorldEdit/schematics/lava.schem");
					       com.sk89q.worldedit.world.World adaptedWorld = BukkitAdapter.adapt(p.getWorld());

					        ClipboardFormat format = ClipboardFormats.findByFile(file);

					        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

					            Clipboard clipboard = reader.read();

					            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld,
					                    -1)) {

					                Operation operation = new ClipboardHolder(clipboard).createPaste(editSession)
					                        .to(BlockVector3.at(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ())).ignoreAirBlocks(false).build();

					                try {
					                    Operations.complete(operation);
					                    editSession.flushSession();

					                } catch (WorldEditException e) {
					                    e.printStackTrace();
					                }
					            }


					        } catch (FileNotFoundException e) {
					            e.printStackTrace();
					            return;
					        } catch (IOException e) {
					            e.printStackTrace();
					            return;
					        }
					}
					
					if(rand.equals("§aBaú de obsidians")) {
						e.getBlock().setType(Material.CHEST);
						Chest chest = (Chest) e.getBlock().getState();
						chest.setCustomName("Baú de obisidians");
						chest.update(true);
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.OBSIDIAN, 3));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.OBSIDIAN, 8));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.OBSIDIAN, 2));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.OBSIDIAN));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.OBSIDIAN, 5));
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.OBSIDIAN, 10));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.OBSIDIAN, 7));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.OBSIDIAN));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.OBSIDIAN, 3));
				
						chest.getBlockInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.OBSIDIAN, 2));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.OBSIDIAN, 8));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.OBSIDIAN));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.OBSIDIAN));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.OBSIDIAN, 5));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.OBSIDIAN));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.OBSIDIAN));
					}
					
				}
			}.runTaskLater(Main.getPlugin(Main.class), 30*4L);
		}
		
		if(e.getBlock().getType() == Material.BLUE_CONCRETE) {
			if(usando == true) {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para usar outro bloco!");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				return;
			}
			
			ArrayList<String> random = new ArrayList<>();
			
			ArrayList<String> repetido = new ArrayList<>();
			






			
			random.clear();
			if(!ragua.contains("§aUm balde de água")) {
				random.add("§aUm balde de água");
			}
			if(!ragua.contains("§aÁgua em sua cabeça")) {
				random.add("§aÁgua em sua cabeça");
			}
			if(!ragua.contains("§aBuraco no void")) {
				random.add("§aBuraco no void");
			}
			if(!ragua.contains("§aEstrutura de água")) {
				random.add("§aEstrutura de água");
			}
			if(!ragua.contains("§aUma pedra")) {
				random.add("§aUma pedra");
			}
				
				String rand = Mine.getRandom(random);
				
				animation(p, e.getBlock(), rand, getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5Nzg0M2ZkM2E2ODUyOGEyODY3NDE2OWI5YjgzMWMxNjU4ZmIxZDg2YTcyMTgyNmRjZWQ1MDM0MmUzMjVmMiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRkNjdhM2I0ZmJiNjcxZDg0NWE5Yzg0MmU5ZTg2MDM4YWNlZTE3Yjk1ZTZjYWNiMmIwMmNiOWMifX19"));
				ragua.add(rand);
				if(ragua.size() >= 5) {
					ragua.clear();
				}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(rand.equals("§aUm balde de água")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.WATER_BUCKET));
					}
					
					if(rand.equals("§aÁgua em sua cabeça")) {
						for(int x = (int)-1.5; x <= 1.5; x++) {
							for(int z = (int)-1.5; z <= 1.5; z++) {
								p.getWorld().getBlockAt(p.getLocation().add(x, 5, z)).setType(Material.WATER);
							}
						}
					}
					
					if(rand.equals("§aBuraco no void")) {
						for(int y = 0; y <= e.getBlock().getLocation().getBlockY(); y++) {
							p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, -y, 0)).breakNaturally();
						}
					}
					if(rand.equals("§aEstrutura de água")) {
						File file = new File("plugins/WorldEdit/schematics/agua.schem");
					       com.sk89q.worldedit.world.World adaptedWorld = BukkitAdapter.adapt(p.getWorld());

					        ClipboardFormat format = ClipboardFormats.findByFile(file);

					        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

					            Clipboard clipboard = reader.read();

					            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld,
					                    -1)) {

					                Operation operation = new ClipboardHolder(clipboard).createPaste(editSession)
					                        .to(BlockVector3.at(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ())).ignoreAirBlocks(false).build();

					                try {
					                    Operations.complete(operation);
					                    editSession.flushSession();

					                } catch (WorldEditException e) {
					                    e.printStackTrace();
					                }
					            }


					        } catch (FileNotFoundException e) {
					            e.printStackTrace();
					            return;
					        } catch (IOException e) {
					            e.printStackTrace();
					            return;
					        }
					}
					
					if(rand.equals("§aUma pedra")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.COBBLESTONE));
					}
					
				}
			}.runTaskLater(Main.getPlugin(Main.class), 30*4L);
		}
		
		if(e.getBlock().getType() == Material.BROWN_CONCRETE) {
			if(usando == true) {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para usar outro bloco!");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				return;
			}
			
			ArrayList<String> random = new ArrayList<>();
			
			ArrayList<String> repetido = new ArrayList<>();
			






			
			random.clear();
			if(!respada.contains("§aEspada de madeira")) {
				random.add("§aEspada de madeira");
			}
			if(!respada.contains("§aEspada poderosa")) {
				random.add("§aEspada poderosa");
			}
			if(!respada.contains("§aEspadas de diamante")) {
				random.add("§aEspadas de diamante");
			}
			if(!respada.contains("§aUm stick")) {
				random.add("§aUm stick");
			}
			if(!respada.contains("§aBaú de sucata")) {
				random.add("§aBaú de sucata");
			}
				
				String rand = Mine.getRandom(random);
				
				animation(p, e.getBlock(), rand, getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5Nzg0M2ZkM2E2ODUyOGEyODY3NDE2OWI5YjgzMWMxNjU4ZmIxZDg2YTcyMTgyNmRjZWQ1MDM0MmUzMjVmMiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRkNjdhM2I0ZmJiNjcxZDg0NWE5Yzg0MmU5ZTg2MDM4YWNlZTE3Yjk1ZTZjYWNiMmIwMmNiOWMifX19"));
				respada.add(rand);
				if(respada.size() >= 5) {
					respada.clear();
				}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(rand.equals("§aEspada de madeira")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.WOODEN_SWORD));
					}
					
					if(rand.equals("§aEspada poderosa")) {
						ItemStack espada = Mine.newItem(Material.DIAMOND_SWORD, null);
						Mine.addEnchant(espada, Enchantment.DAMAGE_ALL, 5);
						espada.setDurability((short)1551);
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), espada).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
					}
					
					if(rand.equals("§aEspadas de diamante")) {
						for(int y = 1; y <= 2; y++) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), new ItemStack(Material.DIAMOND_SWORD)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						}
					}
					if(rand.equals("§aUm stick")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.STICK));
					}
					
					if(rand.equals("§aBaú de sucata")) {
						e.getBlock().setType(Material.CHEST);
						Chest chest = (Chest) e.getBlock().getState();
						chest.setCustomName("Baú de sucata");
						chest.update(true);
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.STRING));
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.TORCH));
				
						chest.getBlockInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.BUCKET));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.COBBLESTONE));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.FLINT));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.GRAVEL));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.BRICK));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.COBBLESTONE));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.FEATHER));
					}
					
				}
			}.runTaskLater(Main.getPlugin(Main.class), 30*4L);
		}
		
		if(e.getBlock().getType() == Material.GREEN_CONCRETE) {
			if(usando == true) {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para usar outro bloco!");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				return;
			}
			
			ArrayList<String> random = new ArrayList<>();
			
			ArrayList<String> repetido = new ArrayList<>();
			






			
			random.clear();
			if(!rarco.contains("§aUm arco")) {
				random.add("§aUm arco");
			}
			if(!rarco.contains("§aVários arcos")) {
				random.add("§aVários arcos");
			}
			if(!rarco.contains("§aBuraco no void")) {
				random.add("§aBuraco no void");
			}
			if(!rarco.contains("§aVárias flechas")) {
				random.add("§aVárias flechas");
			}
			if(!rarco.contains("§aBaú de sucata")) {
				random.add("§aBaú de sucata");
			}
				
				String rand = Mine.getRandom(random);
				
				animation(p, e.getBlock(), rand, getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5Nzg0M2ZkM2E2ODUyOGEyODY3NDE2OWI5YjgzMWMxNjU4ZmIxZDg2YTcyMTgyNmRjZWQ1MDM0MmUzMjVmMiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRkNjdhM2I0ZmJiNjcxZDg0NWE5Yzg0MmU5ZTg2MDM4YWNlZTE3Yjk1ZTZjYWNiMmIwMmNiOWMifX19"));
				rarco.add(rand);
				if(rarco.size() >= 5) {
					rarco.clear();
				}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(rand.equals("§aUm arco")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.BOW));
					}
					
					if(rand.equals("§aVários arcos")) {
						ItemStack bow = Mine.newItem(Material.BOW, null);
						Mine.addEnchant(bow, Enchantment.ARROW_DAMAGE, 5);
						for(int y = 1; y <= 8; y++) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), bow).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						}
					}
					
					if(rand.equals("§aBuraco no void")) {
						for(int y = 0; y <= e.getBlock().getLocation().getBlockY(); y++) {
							p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, -y, 0)).breakNaturally();
						}
					}
					if(rand.equals("§aVárias flechas")) {
						for(int y = 1; y <= 8; y++) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), new ItemStack(Material.ARROW, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						}
					}
					
					if(rand.equals("§aBaú de sucata")) {
						e.getBlock().setType(Material.CHEST);
						Chest chest = (Chest) e.getBlock().getState();
						chest.setCustomName("Baú de sucata");
						chest.update(true);
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.STRING));
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.TORCH));
				
						chest.getBlockInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.BUCKET));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.COBBLESTONE));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.FLINT));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.GRAVEL));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.BRICK));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.COBBLESTONE));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.FEATHER));
					}
					
				}
			}.runTaskLater(Main.getPlugin(Main.class), 30*4L);
		}
		
		if(e.getBlock().getType() == Material.RED_CONCRETE) {
			if(usando == true) {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para usar outro bloco!");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				return;
			}
			
			ArrayList<String> random = new ArrayList<>();
			
			ArrayList<String> repetido = new ArrayList<>();
			





			

			random.clear();
			if(!rcarvao.contains("§aUm carvão")) {
				random.add("§aUm carvão");
			}
			if(!rcarvao.contains("§aUma teia")) {
				random.add("§aUma teia");
			}
			if(!rcarvao.contains("§aBuraco no void")) {
				random.add("§aBuraco no void");
			}
			if(!rcarvao.contains("§aBaú especial")) {
				random.add("§aBaú especial");
			}
			if(!rcarvao.contains("§aBaú de sucata")) {
				random.add("§aBaú de sucata");
			}
				
				String rand = Mine.getRandom(random);
				
				animation(p, e.getBlock(), rand, getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5Nzg0M2ZkM2E2ODUyOGEyODY3NDE2OWI5YjgzMWMxNjU4ZmIxZDg2YTcyMTgyNmRjZWQ1MDM0MmUzMjVmMiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRkNjdhM2I0ZmJiNjcxZDg0NWE5Yzg0MmU5ZTg2MDM4YWNlZTE3Yjk1ZTZjYWNiMmIwMmNiOWMifX19"));
				rcarvao.add(rand);
				if(rcarvao.size() >= 5) {
					rcarvao.clear();
				}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(rand.equals("§aUm carvão")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.COAL));
					}
					
					if(rand.equals("§aUma teia")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.COBWEB));
					}
					
					if(rand.equals("§aBuraco no void")) {
						for(int y = 0; y <= e.getBlock().getLocation().getBlockY(); y++) {
							p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, -y, 0)).breakNaturally();
						}
					}
					if(rand.equals("§aBaú especial")) {
						e.getBlock().setType(Material.CHEST);
						Chest chest = (Chest) e.getBlock().getState();
						chest.setCustomName("Baú especial");
						chest.update(true);
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.DIAMOND));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.IRON_INGOT));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.COAL));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.DIAMOND));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.IRON_INGOT));
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.COAL));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.DIAMOND));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.IRON_INGOT));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.COAL));
				
						chest.getBlockInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.DIAMOND));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.IRON_INGOT));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.COAL));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.DIAMOND));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.IRON_INGOT));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.COAL));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.DIAMOND));
					}
					
					if(rand.equals("§aBaú de sucata")) {
						e.getBlock().setType(Material.CHEST);
						Chest chest = (Chest) e.getBlock().getState();
						chest.setCustomName("Baú de sucata");
						chest.update(true);
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.STRING));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.STRING));
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.TORCH));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.TORCH));
				
						chest.getBlockInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.BUCKET));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.COBBLESTONE));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.FLINT));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.GRAVEL));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.BRICK));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.COBBLESTONE));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.FEATHER));
					}
					
				}
			}.runTaskLater(Main.getPlugin(Main.class), 30*4L);
		}
		
		if(e.getBlock().getType() == Material.BLACK_CONCRETE) {
			if(usando == true) {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para usar outro bloco!");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				return;
			}
			
			ArrayList<String> random = new ArrayList<>();
			
			ArrayList<String> repetido = new ArrayList<>();
			






			
			random.clear();
			if(!rferro.contains("§aUm ferro")) {
				random.add("§aUm ferro");
			}
			if(!rferro.contains("§aEquipamentos de ferro")) {
				random.add("§aEquipamentos de ferro");
			}
			if(!rferro.contains("§aUma teia")) {
				random.add("§aUma teia");
			}
			if(!rferro.contains("§aBaú de enderpearl")) {
				random.add("§aBaú de enderpearl");
			}
			if(!rferro.contains("§aEstrutura de ferro")) {
				random.add("§aEstrutura de ferro");
			}
				
				String rand = Mine.getRandom(random);
				
				animation(p, e.getBlock(), rand, getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5Nzg0M2ZkM2E2ODUyOGEyODY3NDE2OWI5YjgzMWMxNjU4ZmIxZDg2YTcyMTgyNmRjZWQ1MDM0MmUzMjVmMiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRkNjdhM2I0ZmJiNjcxZDg0NWE5Yzg0MmU5ZTg2MDM4YWNlZTE3Yjk1ZTZjYWNiMmIwMmNiOWMifX19"));
				rferro.add(rand);
				if(rferro.size() >= 5) {
					rferro.clear();
				}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(rand.equals("§aUm ferro")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.IRON_INGOT));
					}
					
					if(rand.equals("§aEquipamentos de ferro")) {
						ItemStack espada = Mine.newItem(Material.IRON_SWORD, null);
						Mine.addEnchant(espada, Enchantment.DAMAGE_ALL, 4);
						Mine.addEnchant(espada, Enchantment.DURABILITY, 3);
						ItemStack pic = Mine.newItem(Material.IRON_PICKAXE, null);
						Mine.addEnchant(pic, Enchantment.DIG_SPEED, 4);
						Mine.addEnchant(pic, Enchantment.DURABILITY, 3);
						ItemStack axe = Mine.newItem(Material.IRON_AXE, null);
						Mine.addEnchant(axe, Enchantment.DIG_SPEED, 4);
						Mine.addEnchant(axe, Enchantment.LOOT_BONUS_BLOCKS, 2);
						Mine.addEnchant(axe, Enchantment.DURABILITY, 3);
						ItemStack capa = Mine.newItem(Material.IRON_HELMET, null);
						Mine.addEnchant(capa, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
						Mine.addEnchant(capa, Enchantment.DURABILITY, 3);
						ItemStack peito = Mine.newItem(Material.IRON_CHESTPLATE, null);
						Mine.addEnchant(peito, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
						Mine.addEnchant(peito, Enchantment.DURABILITY, 3);
						ItemStack calca = Mine.newItem(Material.IRON_LEGGINGS, null);
						Mine.addEnchant(calca, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
						Mine.addEnchant(calca, Enchantment.DURABILITY, 3);
						ItemStack bota = Mine.newItem(Material.IRON_BOOTS, null);
						Mine.addEnchant(bota, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
						Mine.addEnchant(bota, Enchantment.PROTECTION_FALL, 2);
						Mine.addEnchant(bota, Enchantment.DURABILITY, 3);
						
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), espada).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), pic).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), axe).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), capa).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), peito).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), calca).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), bota).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
					}
					
					if(rand.equals("§aUma teia")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.COBWEB));
					}
					if(rand.equals("§aBaú de enderpearl")) {
						e.getBlock().setType(Material.CHEST);
						Chest chest = (Chest) e.getBlock().getState();
						chest.setCustomName("Baú de enderpearl");
						chest.update(true);
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.ENDER_PEARL, 3));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.ENDER_PEARL, 8));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.ENDER_PEARL, 2));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.ENDER_PEARL));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.ENDER_PEARL, 5));
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.ENDER_PEARL, 10));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.ENDER_PEARL, 7));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.ENDER_PEARL));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.ENDER_PEARL, 3));
				
						chest.getBlockInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.ENDER_PEARL, 2));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.ENDER_PEARL, 8));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.ENDER_PEARL));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.ENDER_PEARL));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.ENDER_PEARL, 5));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.ENDER_PEARL));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.ENDER_PEARL));
					}
					
					if(rand.equals("§aEstrutura de ferro")) {
						File file = new File("plugins/WorldEdit/schematics/ferro.schem");
					       com.sk89q.worldedit.world.World adaptedWorld = BukkitAdapter.adapt(p.getWorld());

					        ClipboardFormat format = ClipboardFormats.findByFile(file);

					        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

					            Clipboard clipboard = reader.read();

					            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld,
					                    -1)) {

					                Operation operation = new ClipboardHolder(clipboard).createPaste(editSession)
					                        .to(BlockVector3.at(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ())).ignoreAirBlocks(false).build();

					                try {
					                    Operations.complete(operation);
					                    editSession.flushSession();

					                } catch (WorldEditException e) {
					                    e.printStackTrace();
					                }
					            }


					        } catch (FileNotFoundException e) {
					            e.printStackTrace();
					            return;
					        } catch (IOException e) {
					            e.printStackTrace();
					            return;
					        }
					}
					
				}
			}.runTaskLater(Main.getPlugin(Main.class), 30*4L);
		}
		
		if(e.getBlock().getType() == Material.WHITE_CONCRETE_POWDER) {
			if(usando == true) {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para usar outro bloco!");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				return;
			}
			
			ArrayList<String> random = new ArrayList<>();
			
			ArrayList<String> repetido = new ArrayList<>();
			






			
		    random.clear();
			if(!rouro.contains("§aUm ouro")) {
				random.add("§aUm ouro");
			}
			if(!rouro.contains("§aEquipamentos de ouro")) {
				random.add("§aEquipamentos de ouro");
			}
			if(!rouro.contains("§aBuraco no void")) {
				random.add("§aBuraco no void");
			}
			if(!rouro.contains("§aBaú especial")) {
				random.add("§aBaú especial");
			}
			if(!rouro.contains("§aEstrutura de ouro")) {
				 random.add("§aEstrutura de ouro");
			}
				
				String rand = Mine.getRandom(random);
				
				animation(p, e.getBlock(), rand, getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5Nzg0M2ZkM2E2ODUyOGEyODY3NDE2OWI5YjgzMWMxNjU4ZmIxZDg2YTcyMTgyNmRjZWQ1MDM0MmUzMjVmMiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRkNjdhM2I0ZmJiNjcxZDg0NWE5Yzg0MmU5ZTg2MDM4YWNlZTE3Yjk1ZTZjYWNiMmIwMmNiOWMifX19"));
				rouro.add(rand);
				if(rouro.size() >= 5) {
					rouro.clear();
				}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(rand.equals("§aUm ouro")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.GOLD_INGOT));
					}
					
					if(rand.equals("§aEquipamentos de ouro")) {
						ItemStack espada = Mine.newItem(Material.GOLDEN_SWORD, null);
						Mine.addEnchant(espada, Enchantment.DAMAGE_ALL, 4);
						Mine.addEnchant(espada, Enchantment.DURABILITY, 3);
						ItemStack pic = Mine.newItem(Material.GOLDEN_PICKAXE, null);
						Mine.addEnchant(pic, Enchantment.DIG_SPEED, 4);
						Mine.addEnchant(pic, Enchantment.DURABILITY, 3);
						ItemStack axe = Mine.newItem(Material.GOLDEN_AXE, null);
						Mine.addEnchant(axe, Enchantment.DIG_SPEED, 4);
						Mine.addEnchant(axe, Enchantment.LOOT_BONUS_BLOCKS, 2);
						Mine.addEnchant(axe, Enchantment.DURABILITY, 3);
						ItemStack capa = Mine.newItem(Material.GOLDEN_HELMET, null);
						Mine.addEnchant(capa, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
						Mine.addEnchant(capa, Enchantment.DURABILITY, 3);
						ItemStack peito = Mine.newItem(Material.GOLDEN_CHESTPLATE, null);
						Mine.addEnchant(peito, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
						Mine.addEnchant(peito, Enchantment.DURABILITY, 3);
						ItemStack calca = Mine.newItem(Material.GOLDEN_LEGGINGS, null);
						Mine.addEnchant(calca, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
						Mine.addEnchant(calca, Enchantment.DURABILITY, 3);
						ItemStack bota = Mine.newItem(Material.GOLDEN_BOOTS, null);
						Mine.addEnchant(bota, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
						Mine.addEnchant(bota, Enchantment.PROTECTION_FALL, 2);
						Mine.addEnchant(bota, Enchantment.DURABILITY, 3);
						
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), espada).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), pic).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), axe).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), capa).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), peito).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), calca).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), bota).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
					}
					
					if(rand.equals("§aBuraco no void")) {
						for(int y = 0; y <= e.getBlock().getLocation().getBlockY(); y++) {
							p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, -y, 0)).breakNaturally();
						}
					}
					if(rand.equals("§aBaú especial")) {
						e.getBlock().setType(Material.CHEST);
						Chest chest = (Chest) e.getBlock().getState();
						chest.setCustomName("Baú especial");
						chest.update(true);
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.GOLDEN_APPLE));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.BLAZE_ROD));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.GOLDEN_APPLE));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.BLAZE_ROD));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.GOLDEN_APPLE));
						
						chest.getBlockInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.BLAZE_ROD));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.GOLDEN_APPLE));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.BLAZE_ROD));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.GOLDEN_APPLE));
				
						chest.getBlockInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.BLAZE_ROD));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.GOLDEN_APPLE));
						chest.getBlockInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.BLAZE_ROD));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.GOLDEN_APPLE));
						chest.getBlockInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.BLAZE_ROD));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.GOLDEN_APPLE));
						chest.getBlockInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.BLAZE_ROD));
					}
					
					if(rand.equals("§aEstrutura de ouro")) {
						File file = new File("plugins/WorldEdit/schematics/nether.schem");
					       com.sk89q.worldedit.world.World adaptedWorld = BukkitAdapter.adapt(p.getWorld());

					        ClipboardFormat format = ClipboardFormats.findByFile(file);

					        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

					            Clipboard clipboard = reader.read();

					            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld,
					                    -1)) {

					                Operation operation = new ClipboardHolder(clipboard).createPaste(editSession)
					                        .to(BlockVector3.at(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ())).ignoreAirBlocks(false).build();

					                try {
					                    Operations.complete(operation);
					                    editSession.flushSession();

					                } catch (WorldEditException e) {
					                    e.printStackTrace();
					                }
					            }


					        } catch (FileNotFoundException e) {
					            e.printStackTrace();
					            return;
					        } catch (IOException e) {
					            e.printStackTrace();
					            return;
					        }
					}
					
				}
			}.runTaskLater(Main.getPlugin(Main.class), 30*4L);
		}
		
		if(e.getBlock().getType() == Material.ORANGE_CONCRETE_POWDER) {
			if(usando == true) {
				e.setCancelled(true);
				p.sendMessage("§cAguarde para usar outro bloco!");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				return;
			}
			
			ArrayList<String> random = new ArrayList<>();
			
			ArrayList<String> repetido = new ArrayList<>();
			






			
		    random.clear();
			if(!rdiamante.contains("§aUm diamante")) {
				random.add("§aUm diamante");
			}
			if(!rdiamante.contains("§aEquipamentos de diamante")) {
				random.add("§aEquipamentos de diamante");
			}
			if(!rdiamante.contains("§aBuraco no void")) {
				random.add("§aBuraco no void");
			}
			if(!rdiamante.contains("§aLava em sua cabeça")) {
				random.add("§aLava em sua cabeça");
			}
			if(!rdiamante.contains("§aEstrutura de diamante")) {
				 random.add("§aEstrutura de diamante");
			}
				
				String rand = Mine.getRandom(random);
				
				animation(p, e.getBlock(), rand, getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5Nzg0M2ZkM2E2ODUyOGEyODY3NDE2OWI5YjgzMWMxNjU4ZmIxZDg2YTcyMTgyNmRjZWQ1MDM0MmUzMjVmMiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc5ZmFkNDIwZDJjOTcyMDUxYzljMDRkNGYyNmE4ZDBkMGE5YTNiZWMyOGQ4MGIxZjY4YmQ1ZGQ4Y2ZhZTBjZiJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="), getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRkNjdhM2I0ZmJiNjcxZDg0NWE5Yzg0MmU5ZTg2MDM4YWNlZTE3Yjk1ZTZjYWNiMmIwMmNiOWMifX19"));
				rdiamante.add(rand);
				if(rdiamante.size() >= 5) {
					rdiamante.clear();
				}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(rand.equals("§aUm diamante")) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.DIAMOND));
					}
					
					if(rand.equals("§aEquipamentos de diamante")) {
						ItemStack espada = Mine.newItem(Material.DIAMOND_SWORD, null);
						Mine.addEnchant(espada, Enchantment.DAMAGE_ALL, 4);
						Mine.addEnchant(espada, Enchantment.DURABILITY, 3);
						ItemStack pic = Mine.newItem(Material.DIAMOND_PICKAXE, null);
						Mine.addEnchant(pic, Enchantment.DIG_SPEED, 4);
						Mine.addEnchant(pic, Enchantment.DURABILITY, 3);
						ItemStack axe = Mine.newItem(Material.DIAMOND_AXE, null);
						Mine.addEnchant(axe, Enchantment.DIG_SPEED, 4);
						Mine.addEnchant(axe, Enchantment.LOOT_BONUS_BLOCKS, 2);
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
						Mine.addEnchant(bota, Enchantment.PROTECTION_FALL, 2);
						Mine.addEnchant(bota, Enchantment.DURABILITY, 3);
						
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), espada).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), pic).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), axe).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), capa).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), peito).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), calca).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.5, 0), bota).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
					}
					
					if(rand.equals("§aBuraco no void")) {
						for(int y = 0; y <= e.getBlock().getLocation().getBlockY(); y++) {
							p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, -y, 0)).breakNaturally();
						}
					}
					if(rand.equals("§aLava em sua cabeça")) {
						for(int x = (int)-1.5; x <= 1.5; x++) {
							for(int z = (int)-1.5; z <= 1.5; z++) {
								p.getWorld().getBlockAt(p.getLocation().add(x, 5, z)).setType(Material.LAVA);
							}
						}
					}
					
					if(rand.equals("§aEstrutura de diamante")) {
						File file = new File("plugins/WorldEdit/schematics/diamante.schem");
					       com.sk89q.worldedit.world.World adaptedWorld = BukkitAdapter.adapt(p.getWorld());

					        ClipboardFormat format = ClipboardFormats.findByFile(file);

					        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

					            Clipboard clipboard = reader.read();

					            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld,
					                    -1)) {

					                Operation operation = new ClipboardHolder(clipboard).createPaste(editSession)
					                        .to(BlockVector3.at(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ())).ignoreAirBlocks(false).build();

					                try {
					                    Operations.complete(operation);
					                    editSession.flushSession();

					                } catch (WorldEditException e) {
					                    e.printStackTrace();
					                }
					            }


					        } catch (FileNotFoundException e) {
					            e.printStackTrace();
					            return;
					        } catch (IOException e) {
					            e.printStackTrace();
					            return;
					        }
					}
					
				}
			}.runTaskLater(Main.getPlugin(Main.class), 30*4L);
		}
	}
	
	private Set<Location> makeHollow(Set<Location> blocks, boolean sphere){
        Set<Location> edge = new HashSet<Location>();
        if(!sphere){
            for(Location l : blocks){
                org.bukkit.World w = l.getWorld();
                int X = l.getBlockX();
                int Y = l.getBlockY();
                int Z = l.getBlockZ();
                Location front = new Location(w, X + 1, Y, Z);
                Location back = new Location(w, X - 1, Y, Z);
                Location left = new Location(w, X, Y, Z + 1);
                Location right = new Location(w, X, Y, Z - 1);
                if(!(blocks.contains(front) && blocks.contains(back) && blocks.contains(left) && blocks.contains(right))){
                    edge.add(l);
                }
            }
            return edge;
        } else {
            for(Location l : blocks){
                org.bukkit.World w = l.getWorld();
                int X = l.getBlockX();
                int Y = l.getBlockY();
                int Z = l.getBlockZ();
                Location front = new Location(w, X + 1, Y, Z);
                Location back = new Location(w, X - 1, Y, Z);
                Location left = new Location(w, X, Y, Z + 1);
                Location right = new Location(w, X, Y, Z - 1);
                Location top = new Location(w, X, Y + 1, Z);
                Location bottom = new Location(w, X, Y - 1, Z);
                if(!(blocks.contains(front) && blocks.contains(back) && blocks.contains(left) && blocks.contains(right) && blocks.contains(top) && blocks.contains(bottom))){
                    edge.add(l);
                }
            }
            return edge;
        }
    }
	
	public Set<Location> sphere(Location location, int radius, boolean hollow){
        Set<Location> blocks = new HashSet<Location>();
        org.bukkit.World world = location.getWorld();
        int X = location.getBlockX();
        int Y = location.getBlockY();
        int Z = location.getBlockZ();
        int radiusSquared = radius * radius;
 
        if(hollow){
            for (int x = X - radius; x <= X + radius; x++) {
                for (int y = Y - radius; y <= Y + radius; y++) {
                    for (int z = Z - radius; z <= Z + radius; z++) {
                        if ((X - x) * (X - x) + (Y - y) * (Y - y) + (Z - z) * (Z - z) <= radiusSquared) {
                            Location block = new Location(world, x, y, z);
                            blocks.add(block);
                        }
                    }
                }
            }
            return makeHollow(blocks, true);
        } else {
            for (int x = X - radius; x <= X + radius; x++) {
                for (int y = Y - radius; y <= Y + radius; y++) {
                    for (int z = Z - radius; z <= Z + radius; z++) {
                        if ((X - x) * (X - x) + (Y - y) * (Y - y) + (Z - z) * (Z - z) <= radiusSquared) {
                            Location block = new Location(world, x, y, z);
                            blocks.add(block);
                        }
                    }
                }
            }
            return blocks;
        }
    }
	
}


