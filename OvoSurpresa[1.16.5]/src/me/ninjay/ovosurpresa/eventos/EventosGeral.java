package me.ninjay.ovosurpresa.eventos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.block.data.type.Bed;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

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

import me.ninjay.ovosurpresa.comandos.ComandoDarItens;
import me.ninjay.ovosurpresa.main.Main;
import me.ninjay.ovosurpresa.utils.Mine;

public class EventosGeral implements Listener{
	
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
	
	public static ArrayList<Integer> drops = new ArrayList<>();
	
	public static void animacao(Player p, Location loc, Integer anm) {
		
		if(anm == 1) {
			new BukkitRunnable() {
				int i = 10;
				@Override
				public void run() {
					i--;
					p.playSound(p.getLocation(), Sound.ENTITY_CAT_AMBIENT, 1F, 1F);
					p.spawnParticle(Particle.FIREWORKS_SPARK, loc, 200, 0.1, 0.1, 0.1);
					if(i <= -2) {
						cancel();
						p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
						
					}
				}
			}.runTaskTimer(Main.getPlugin(Main.class), 10, 10);
		}
		
		if(anm == 2) {
			new BukkitRunnable() {
				int i = 5;
				@Override
				public void run() {
					i--;
					p.playSound(loc, Sound.ENTITY_ENDER_DRAGON_GROWL, 1F, 1F);
					p.spawnParticle(Particle.CLOUD, loc, 1000, 0.1, 0.1, 0.1);
					p.getWorld().strikeLightningEffect(loc);
					if(i <= -1) {
						cancel();
						p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
					}
				}
			}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
		}
		
		if(anm == 3) {
			new BukkitRunnable() {
				int i = 10;
				@Override
				public void run() {
					i--;
					Particle.DustOptions dust = new Particle.DustOptions(Color.GREEN, 2);
					Particle.DustOptions dust2 = new Particle.DustOptions(Color.RED, 2);
					Particle.DustOptions dust3 = new Particle.DustOptions(Color.AQUA, 2);
					Particle.DustOptions dust4 = new Particle.DustOptions(Color.YELLOW, 2);
					Particle.DustOptions dust5 = new Particle.DustOptions(Color.FUCHSIA, 2);
					
					if(i == 9) {
						p.spawnParticle(Particle.REDSTONE, loc, 200, 2, 2, 2, 2, dust);
						p.playSound(loc, Sound.ENTITY_ZOMBIE_AMBIENT, 1F, 1F);
					}
					
					if(i == 7) {
						p.spawnParticle(Particle.REDSTONE, loc, 200, 2, 2, 2, 2, dust2);
						p.playSound(loc, Sound.ENTITY_ZOMBIE_AMBIENT, 1F, 1F);
					}
					
					if(i == 5) {
						p.spawnParticle(Particle.REDSTONE, loc, 200, 2, 2, 2, 2, dust3);
						p.playSound(loc, Sound.ENTITY_ZOMBIE_AMBIENT, 1F, 1F);
					}
					
					if(i == 3) {
						p.spawnParticle(Particle.REDSTONE, loc, 200, 2, 2, 2, 2, dust4);
						p.playSound(loc, Sound.ENTITY_ZOMBIE_AMBIENT, 1F, 1F);
					}
					
					if(i == 1) {
						p.spawnParticle(Particle.REDSTONE, loc, 200, 2, 2, 2, 2, dust2);
						p.playSound(loc, Sound.ENTITY_ZOMBIE_AMBIENT, 1F, 1F);
					}
					
					if(i <= -2) {
						cancel();
						p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
					}
				}
			}.runTaskTimer(Main.getPlugin(Main.class), 10, 10);
		}
		
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		
		if(e.getItemDrop().getItemStack().isSimilar(ComandoDarItens.ovo)) {
			new BukkitRunnable() {
				
				@Override
				public void run() {
					e.getItemDrop().getWorld().playSound(e.getItemDrop().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1F, 1F);
					e.getItemDrop().remove();
					animacao(p, e.getItemDrop().getLocation(), Mine.getRandomInt(1, 3));
					new BukkitRunnable() {
						int i = 6;
						@Override
						public void run() {
							i--;
							if(i <= 0) {
								cancel();
								if(!drops.contains(1)) {
									drops.add(1);
									for(int i = 0; i <= 10; i++) {
										e.getItemDrop().getWorld().spawn(e.getItemDrop().getLocation().add(Mine.getRandomDouble(-2, 2), 0, Mine.getRandomDouble(-2, 2)), Rabbit.class);
									}
									for(int i = 0; i <= 10; i++) {
										p.getWorld().getBlockAt(e.getItemDrop().getLocation().add(Mine.getRandomDouble(-2, 2), 0, Mine.getRandomDouble(-2, 2))).setType(Material.POPPY);
									}
									for(int i = 0; i <= 10; i++) {
										p.getWorld().getBlockAt(e.getItemDrop().getLocation().add(Mine.getRandomDouble(-2, 2), 0, Mine.getRandomDouble(-2, 2))).setType(Material.DANDELION);
									}
									for(int i = 0; i <= 10; i++) {
										p.getWorld().getBlockAt(e.getItemDrop().getLocation().add(Mine.getRandomDouble(-2, 2), 0, Mine.getRandomDouble(-2, 2))).setType(Material.OXEYE_DAISY);
									}
								}else if(!drops.contains(2)){
									drops.add(2);
									
									File file = new File("plugins/WorldEdit/schematics/mel.schem");
								       com.sk89q.worldedit.world.World adaptedWorld = BukkitAdapter.adapt(p.getWorld());

								        ClipboardFormat format = ClipboardFormats.findByFile(file);

								        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

								            Clipboard clipboard = reader.read();

								            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld,
								                    -1)) {

								                Operation operation = new ClipboardHolder(clipboard).createPaste(editSession)
								                        .to(BlockVector3.at(e.getItemDrop().getLocation().getX(), e.getItemDrop().getLocation().getY()+1, e.getItemDrop().getLocation().getZ())).ignoreAirBlocks(false).build();

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
								}else if(!drops.contains(3)) {
									drops.add(3);
									for(int y = 0; y <= e.getItemDrop().getLocation().getBlockY(); y++) {
										p.getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, -y, 0)).breakNaturally();
									}
								}else if(!drops.contains(4)) {
									drops.add(4);
									File file = new File("plugins/WorldEdit/schematics/dima.schem");
								       com.sk89q.worldedit.world.World adaptedWorld = BukkitAdapter.adapt(p.getWorld());

								        ClipboardFormat format = ClipboardFormats.findByFile(file);

								        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

								            Clipboard clipboard = reader.read();

								            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld,
								                    -1)) {

								                Operation operation = new ClipboardHolder(clipboard).createPaste(editSession)
								                        .to(BlockVector3.at(e.getItemDrop().getLocation().getX(), e.getItemDrop().getLocation().getY()+1, e.getItemDrop().getLocation().getZ())).ignoreAirBlocks(false).build();

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
								}else if(!drops.contains(5)) {
									drops.add(5);
									for(int i = 0; i <= 10; i++) {
										e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									}
									
									for(int i = 0; i <= 10; i++) {
										ItemStack m = Mine.newItem(Material.POTION, "§fPoção de Força II", 1, 0);
										PotionMeta mm = (PotionMeta) m.getItemMeta();
										mm.setBasePotionData(new PotionData(PotionType.STRENGTH, false, true));
										m.setItemMeta(mm);
										e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), m).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									}
								}else if(!drops.contains(6)) {
									drops.add(6);
									for(Location loc : sphere(p.getLocation(), 10, true)) {
										loc.getBlock().setType(Material.COBBLESTONE);
									}
								}else if(!drops.contains(7)) {
									drops.add(7);
									
									for(int i = 0; i <= 20; i++) {
										e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), ComandoDarItens.ovo).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									}
								}else if(!drops.contains(8)) {
									drops.add(8);
									ItemStack espada = Mine.newItem(Material.NETHERITE_SWORD, null);
									Mine.addEnchant(espada, Enchantment.DAMAGE_ALL, 3);
									Mine.addEnchant(espada, Enchantment.DURABILITY, 2);
									ItemStack pic = Mine.newItem(Material.NETHERITE_PICKAXE, null);
									Mine.addEnchant(pic, Enchantment.DIG_SPEED, 3);
									Mine.addEnchant(pic, Enchantment.DURABILITY, 2);
									ItemStack axe = Mine.newItem(Material.NETHERITE_AXE, null);
									Mine.addEnchant(axe, Enchantment.DIG_SPEED, 3);
									Mine.addEnchant(axe, Enchantment.LOOT_BONUS_BLOCKS, 1);
									Mine.addEnchant(axe, Enchantment.DURABILITY, 2);
									ItemStack pa = Mine.newItem(Material.NETHERITE_SHOVEL, null);
									Mine.addEnchant(pa, Enchantment.DIG_SPEED, 3);
									Mine.addEnchant(pa, Enchantment.DURABILITY, 2);
									ItemStack enx = Mine.newItem(Material.NETHERITE_HOE, null);
									Mine.addEnchant(enx, Enchantment.DIG_SPEED, 3);
									Mine.addEnchant(enx, Enchantment.DURABILITY, 2);
									
									e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), espada).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), pic).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), axe).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), pa).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), enx).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									
								}else if(!drops.contains(9)) {
									drops.add(9);
									File file = new File("plugins/WorldEdit/schematics/terra.schem");
								       com.sk89q.worldedit.world.World adaptedWorld = BukkitAdapter.adapt(p.getWorld());

								        ClipboardFormat format = ClipboardFormats.findByFile(file);

								        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

								            Clipboard clipboard = reader.read();

								            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld,
								                    -1)) {

								                Operation operation = new ClipboardHolder(clipboard).createPaste(editSession)
								                        .to(BlockVector3.at(e.getItemDrop().getLocation().getX(), e.getItemDrop().getLocation().getY()+1, e.getItemDrop().getLocation().getZ())).ignoreAirBlocks(false).build();

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
									
								}else if(!drops.contains(10)) {
									drops.add(10);
									for(int i = 0; i <= 10; i++) {
										e.getItemDrop().getWorld().spawn(e.getItemDrop().getLocation().add(Mine.getRandomDouble(-2, 2), 0, Mine.getRandomDouble(-2, 2)), Villager.class);
									}
									for(int i = 0; i <= 10; i++) {
										e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), new ItemStack(Material.EMERALD_BLOCK, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									}
									
								}else if(!drops.contains(11)) {
									drops.add(11);
									
									for(int x = (int)-1.5; x <= 1.5; x++) {
										for(int z = (int)-1.5; z <= 1.5; z++) {
											p.getWorld().getBlockAt(p.getLocation().add(x, 5, z)).setType(Material.LAVA);
										}
									}
								}else if(!drops.contains(12)) {
									drops.add(12);
									for(int i = 0; i <= 10; i++) {
										e.getItemDrop().getWorld().spawn(e.getItemDrop().getLocation().add(Mine.getRandomDouble(-2, 2), 0, Mine.getRandomDouble(-2, 2)), Creeper.class);
									}
								}else if(!drops.contains(13)) {
									drops.add(13);
									
									File file = new File("plugins/WorldEdit/schematics/ferro.schem");
								       com.sk89q.worldedit.world.World adaptedWorld = BukkitAdapter.adapt(p.getWorld());

								        ClipboardFormat format = ClipboardFormats.findByFile(file);

								        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

								            Clipboard clipboard = reader.read();

								            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld,
								                    -1)) {

								                Operation operation = new ClipboardHolder(clipboard).createPaste(editSession)
								                        .to(BlockVector3.at(e.getItemDrop().getLocation().getX(), e.getItemDrop().getLocation().getY()+1, e.getItemDrop().getLocation().getZ())).ignoreAirBlocks(false).build();

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
									
								}else if(!drops.contains(14)) {
									drops.add(14);
									
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation()).setType(Material.CHEST);
									Chest chest = (Chest) p.getWorld().getBlockAt(e.getItemDrop().getLocation()).getState();
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
									
								}else if(!drops.contains(15)) {
									drops.add(15);
									ItemStack espada = Mine.newItem(Material.DIAMOND_SWORD, null);
									Mine.addEnchant(espada, Enchantment.KNOCKBACK, 5);
									espada.setDurability((short)1551);
									e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), espada).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
								}else if(!drops.contains(16)) {
									drops.add(16);
									
									File file = new File("plugins/WorldEdit/schematics/ouro.schem");
								       com.sk89q.worldedit.world.World adaptedWorld = BukkitAdapter.adapt(p.getWorld());

								        ClipboardFormat format = ClipboardFormats.findByFile(file);

								        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

								            Clipboard clipboard = reader.read();

								            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld,
								                    -1)) {

								                Operation operation = new ClipboardHolder(clipboard).createPaste(editSession)
								                        .to(BlockVector3.at(e.getItemDrop().getLocation().getX(), e.getItemDrop().getLocation().getY()+1, e.getItemDrop().getLocation().getZ())).ignoreAirBlocks(false).build();

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
									
								}else if(!drops.contains(17)) {
									drops.add(17);
									
									for(int i = 0; i <= 20; i++) {
										p.getWorld().getBlockAt(e.getItemDrop().getLocation().add(Mine.getRandomDouble(-2, 2), Mine.getRandomDouble(0, 5), Mine.getRandomDouble(-2, 2))).setType(Material.CAKE);
									}
									
								}else if(!drops.contains(18)) {
									drops.add(18);
									
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
									
									e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), espada).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), pic).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), axe).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), capa).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), peito).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), calca).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), bota).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									
								}else if(!drops.contains(19)) {
									drops.add(19);
									
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation()).setType(Material.OAK_WOOD);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 1, 0)).setType(Material.OAK_WOOD);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 2, 0)).setType(Material.OAK_WOOD);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 3, 0)).setType(Material.OAK_WOOD);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 4, 0)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 4, 1)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 4, -1)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(1, 4, 0)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(-1, 4, 0)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(-1, 3, 0)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(1, 3, 0)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 3, 1)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 3, -1)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(-1, 2, 0)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(1, 2, 0)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 2, 1)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 2, -1)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(1, 3, 1)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(1, 2, 1)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(1, 3, -1)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(1, 2, -1)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(-1, 3, -1)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(-1, 2, -1)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(-1, 3, 1)).setType(Material.DIAMOND_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(-1, 2, 1)).setType(Material.DIAMOND_BLOCK);
									
								}else if(!drops.contains(20)) {
									drops.add(20);
									
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation()).setType(Material.OAK_WOOD);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 1, 0)).setType(Material.OAK_WOOD);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 2, 0)).setType(Material.OAK_WOOD);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 3, 0)).setType(Material.OAK_WOOD);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 4, 0)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 4, 1)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 4, -1)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(1, 4, 0)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(-1, 4, 0)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(-1, 3, 0)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(1, 3, 0)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 3, 1)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 3, -1)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(-1, 2, 0)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(1, 2, 0)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 2, 1)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(0, 2, -1)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(1, 3, 1)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(1, 2, 1)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(1, 3, -1)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(1, 2, -1)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(-1, 3, -1)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(-1, 2, -1)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(-1, 3, 1)).setType(Material.GOLD_BLOCK);
									e.getItemDrop().getWorld().getBlockAt(e.getItemDrop().getLocation().add(-1, 2, 1)).setType(Material.GOLD_BLOCK);
								}else if(!drops.contains(21)) {
									drops.add(21);
									for(int i = 0; i <= 10; i++) {
										e.getItemDrop().getWorld().spawn(e.getItemDrop().getLocation().add(Mine.getRandomDouble(-2, 2), 0, Mine.getRandomDouble(-2, 2)), Enderman.class);
									}
								}else if(!drops.contains(22)) {
									drops.add(22);
									
									File file = new File("plugins/WorldEdit/schematics/agua.schem");
								       com.sk89q.worldedit.world.World adaptedWorld = BukkitAdapter.adapt(p.getWorld());

								        ClipboardFormat format = ClipboardFormats.findByFile(file);

								        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

								            Clipboard clipboard = reader.read();

								            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld,
								                    -1)) {

								                Operation operation = new ClipboardHolder(clipboard).createPaste(editSession)
								                        .to(BlockVector3.at(e.getItemDrop().getLocation().getX(), e.getItemDrop().getLocation().getY()+1, e.getItemDrop().getLocation().getZ())).ignoreAirBlocks(false).build();

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
									
								}else if(!drops.contains(23)) {
									drops.add(23);
									
									for(int i = 0; i <= 20; i++) {
										e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), Mine.newItem(Material.PAPER, "§aDinheiro", 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									}
								}else if(!drops.contains(24)) {
									drops.add(24);
									
									File file = new File("plugins/WorldEdit/schematics/lava.schem");
								       com.sk89q.worldedit.world.World adaptedWorld = BukkitAdapter.adapt(p.getWorld());

								        ClipboardFormat format = ClipboardFormats.findByFile(file);

								        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

								            Clipboard clipboard = reader.read();

								            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld,
								                    -1)) {

								                Operation operation = new ClipboardHolder(clipboard).createPaste(editSession)
								                        .to(BlockVector3.at(e.getItemDrop().getLocation().getX(), e.getItemDrop().getLocation().getY()+1, e.getItemDrop().getLocation().getZ())).ignoreAirBlocks(false).build();

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
								}else if(!drops.contains(25)) {
									drops.add(25);
									
									for(int i = 0; i <= 20; i++) {
										e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), new ItemStack(Material.TOTEM_OF_UNDYING)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									}
								}else if(!drops.contains(26)) {
									drops.add(26);
									
									File file = new File("plugins/WorldEdit/schematics/dimabloco.schem");
								       com.sk89q.worldedit.world.World adaptedWorld = BukkitAdapter.adapt(p.getWorld());

								        ClipboardFormat format = ClipboardFormats.findByFile(file);

								        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

								            Clipboard clipboard = reader.read();

								            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld,
								                    -1)) {

								                Operation operation = new ClipboardHolder(clipboard).createPaste(editSession)
								                        .to(BlockVector3.at(e.getItemDrop().getLocation().getX(), e.getItemDrop().getLocation().getY()+1, e.getItemDrop().getLocation().getZ())).ignoreAirBlocks(false).build();

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
								}else if(!drops.contains(27)) {
									drops.add(27);
									
									for(int i = 0; i <= 10; i++) {
										e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), new ItemStack(Material.IRON_INGOT, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									}
									
									for(int i = 0; i <= 10; i++) {
										e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), new ItemStack(Material.GOLD_INGOT, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									}
									
									for(int i = 0; i <= 10; i++) {
										e.getItemDrop().getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.5, 0), new ItemStack(Material.NETHERITE_INGOT, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
									}
								}else if(!drops.contains(28)) {
									drops.add(28);
									
									File file = new File("plugins/WorldEdit/schematics/areia.schem");
								       com.sk89q.worldedit.world.World adaptedWorld = BukkitAdapter.adapt(p.getWorld());

								        ClipboardFormat format = ClipboardFormats.findByFile(file);

								        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

								            Clipboard clipboard = reader.read();

								            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld,
								                    -1)) {

								                Operation operation = new ClipboardHolder(clipboard).createPaste(editSession)
								                        .to(BlockVector3.at(e.getItemDrop().getLocation().getX(), e.getItemDrop().getLocation().getY()+1, e.getItemDrop().getLocation().getZ())).ignoreAirBlocks(false).build();

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
								}else if(!drops.contains(29)) {
									drops.add(29);
									
									for(int i = 0; i <= 10; i++) {
									Block bloco = p.getWorld().getBlockAt(e.getItemDrop().getLocation().add(Mine.getRandomDouble(-2, 2), 0, Mine.getRandomDouble(-2, 2)));
									setBed(bloco, BlockFace.NORTH, Material.LIGHT_BLUE_BED);
									}
								}else if(!drops.contains(30)) {
									drops.add(30);
									
									for(Location loc : sphere(p.getLocation(), 3, false)) {
										loc.getBlock().setType(Material.ICE);
									}
									
									drops.clear();
								}
							}
						}
					}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
				}
			}.runTaskLater(Main.getPlugin(Main.class), 20);
		}
	}
	
	public void setBed(Block start, BlockFace facing, Material material) {
	    for (Bed.Part part : Bed.Part.values()) {
	       final Bed bedData = (Bed) Bukkit.createBlockData(material, (data) -> {
	           ((Bed) data).setPart(part);
	           ((Bed) data).setFacing(facing);
	        });
	        start.setBlockData(bedData);
	        start = start.getRelative(facing.getOppositeFace());
	    }
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		
		if(e.getBlock().getType() == Material.ORANGE_CONCRETE) {
			e.setCancelled(true);
		}
	}

}
