package me.ninjay.lojahacks.eventos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.lojahacks.estruturas.ItensAPI;
import me.ninjay.lojahacks.main.Main;
import me.ninjay.lojahacks.utils.Mine;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class EventosGeral implements Listener{
	
	public static HashMap<Player, Integer> diamante = new HashMap<>(); 
	private static Inventory menu = Bukkit.createInventory(null, InventoryType.SHULKER_BOX, "Mercado de Hack");
	public static HashMap<Player, String> hack = new HashMap<>();
	public static boolean usando = false;
	public static ArrayList<Player> fanta = new ArrayList<>();
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(hack.get(p) != null) {
			if(hack.get(p).contains("deus")) {
				if(usando == true) {
				for(int x = (int)-1.5; x <= 1.5; x++) {
					for(int y = (int)-1.5; y <= 1.5; y++) {
						for(int z = (int)-1.5; z <= 1.5; z++) {
							p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).breakNaturally();
						}
					}
				}
				}
			}
		}
		
		if(e.getBlock().getType() == Material.RED_CONCRETE) {
			e.setDropItems(false);
			e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), ItensAPI.estagio1);
		}
		if(e.getBlock().getType() == Material.BLUE_CONCRETE) {
			e.setDropItems(false);
			e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), ItensAPI.estagio2);
		}
		if(e.getBlock().getType() == Material.YELLOW_CONCRETE) {
			e.setDropItems(false);
			e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), ItensAPI.estagio3);
		}
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlock().getType() == Material.YELLOW_CONCRETE) {
			e.getBlock().getWorld().strikeLightningEffect(e.getBlock().getLocation());
			for(int i = 1; i <= 50; i++) {
				p.spawnParticle(Particle.FLAME, e.getBlock().getLocation(), 50, 0.1, 0.1, 0.1);
			}
			p.playSound(p.getLocation(), Sound.ENTITY_PHANTOM_BITE, 1F, 1F);
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(hack.get(p) != null) {
			if(hack.get(p).contains("duplicador")) {
				if(usando == true) {
				if(p.getInventory().getItemInMainHand() != null) {
					p.getInventory().addItem(p.getInventory().getItemInMainHand());
					p.getWorld().dropItem(p.getLocation(), p.getInventory().getItemInMainHand());
					p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
				}
				}
			}
			if(hack.get(p).contains("fantasma")) {
				if(usando == true) {
					if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
					if(!fanta.contains(p)) {
						fanta.add(p);
						p.playSound(p.getLocation(), Sound.ENTITY_PHANTOM_DEATH, 1F, 1F);
						p.setGameMode(GameMode.SPECTATOR);
					}else {
						fanta.remove(p);
						p.setGameMode(GameMode.SURVIVAL);
					}
				}
				}
			}
			if(hack.get(p).contains("deus")) {
				if(usando == true) {
					if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
						p.getWorld().strikeLightning(p.getTargetBlock(null, 1000).getLocation());
					}
				}
			}
		}
		
		if(e.getClickedBlock() != null) {
			if(e.getClickedBlock().getType() == Material.YELLOW_CONCRETE) {
				if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					p.playSound(p.getLocation(), Sound.BLOCK_GLASS_BREAK, 1F, 1F);
					
					ItemStack a = Mine.newItem(Material.PINK_STAINED_GLASS_PANE, "§bInsira os diamantes", 1, 0, " ", " §7Quantidade: §b0 Diamantes");
					ItemStack b = Mine.newItem(Material.RED_STAINED_GLASS_PANE, "§4§lMORTE SUBITA", 1, 0, " ", " §fMate tudo e todos!", " ", "§7Valor: §b1 Diamante", "§7Tempo: §a60 segundos", " ", "§7Clique para ativar");
					ItemStack c = Mine.newItem(Material.ORANGE_STAINED_GLASS_PANE, "§6§lDUPLICADOR", 1, 0, " ", " §fDuplique qualquer item"," §fque estiver em sua mão!", " ", "§7Valor: §b2 Diamantes", "§7Tempo: §a45 segundos", " ", "§7Clique para ativar");
					ItemStack d = Mine.newItem(Material.PURPLE_STAINED_GLASS_PANE, "§5§lX-RAY", 1, 0, " ", " §fAtive o modo que tudo vê!", " ", "§7Valor: §b4 Diamantes", "§7Tempo: §a2 minutos", " ", "§7Clique para ativar");
					ItemStack ee = Mine.newItem(Material.LIME_STAINED_GLASS_PANE, "§a§lMODO FANTASMA", 1, 0, " ", " §fVire invulnerável e translúcido!", " ", "§7Valor: §b5 Diamantes", "§7Tempo: §a3 minutos", " ", "§7Clique para ativar");
					ItemStack f = Mine.newItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE, "§b§lMODO DEUS", 1, 0, " ", " §fReiniciando... Reiniciando... Reiniciando...", " ", "§7Valor: §b32 Diamantes", "§7Tempo: §a5 minutos", " ", "§7Clique para ativar");
					
					if(diamante.get(p) == null || diamante.get(p) <= 0) {
						menu.setItem(Mine.getPosition(2, 2), a);
					}else if(diamante.get(p) >= 1){
						ItemStack aa = Mine.newItem(Material.PINK_STAINED_GLASS_PANE, "§bInsira os diamantes", 1, 0, " ", " §7Quantidade: §b"+diamante.get(p)+" Diamantes");
						menu.setItem(Mine.getPosition(2, 2), aa);
					}
					menu.setItem(Mine.getPosition(2, 4), b);
					menu.setItem(Mine.getPosition(2, 5), c);
					menu.setItem(Mine.getPosition(2, 6), d);
					menu.setItem(Mine.getPosition(2, 7), ee);
					menu.setItem(Mine.getPosition(2, 8), f);
					
					p.openInventory(menu);
				}
			}
		}
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getView().getTitle().contains("Mercado")) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().getItemMeta().getDisplayName() == null) {
						if(e.getCurrentItem().getType() == Material.DIAMOND) {
							e.setCancelled(false);
						}
					}
				}
			}
		}
		
		if(e.getView().getTitle().contains("Mercado")) {
		if(e.getCurrentItem() != null) {
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().hasDisplayName() == false) {
				e.setCancelled(false);
			}
			if(e.getCurrentItem().getType() == Material.PINK_STAINED_GLASS_PANE) {
			if(p.getItemOnCursor() != null) {
				if(p.getItemOnCursor().getType() == Material.DIAMOND) {
					if(diamante.get(p) == null) {
					diamante.put(p, (p.getItemOnCursor().getAmount()));
					}else {
						diamante.put(p, diamante.get(p)+(p.getItemOnCursor().getAmount()));
					}
					p.sendMessage("§aAdicionado "+p.getItemOnCursor().getAmount()+" diamantes no mercado.");
					p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
					new BukkitRunnable() {
						
						@Override
						public void run() {
							p.getItemOnCursor().setType(Material.AIR);
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1);
					new BukkitRunnable() {
						
						@Override
						public void run() {
							p.getOpenInventory().close();
						}
					}.runTaskLater(Main.getPlugin(Main.class), 3);
				}
			}
		}
			if(e.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
			if(diamante.get(p) != null) {
				if(diamante.get(p) >= 1) {
					if(usando == false) {
					usando = true;
					diamante.put(p, diamante.get(p)-1);
					hack.put(p, "morte");
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1F, 1F);
					p.sendMessage(" \n§4§lHACK - MORTE SÚBITA\n \n §4Morte súbita ativada por 60 segundos! Cuidado!!!\n ");
					new BukkitRunnable() {
						int i = 60;
						@Override
						public void run() {
							i--;
							p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aVocê perderá seu hack em "+i+" segundos!"));
							if(usando == false) {
								cancel();
							}
							if(i <= 0) {
								cancel();
								p.sendMessage(" \n§4§lHACK - MORTE SÚBITA\n \n §4Morte súbita encerrada.\n ");
								usando = false;
								hack.remove(p, "morte");
							}
						}
					}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}else {
						p.sendMessage("§cVocê já está com um hack ativado.");
					}
			}else {
				p.sendMessage("§cVocê não possui diamantes suficiente.");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
			}
			}else {
				p.sendMessage("§cVocê não possui diamantes suficiente.");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
			}
			}
			
			if(e.getCurrentItem().getType() == Material.ORANGE_STAINED_GLASS_PANE) {
			if(diamante.get(p) != null) {
				if(diamante.get(p) >= 2) {
					if(usando == false) {
					usando = true;
					diamante.put(p, diamante.get(p)-2);
					hack.put(p, "duplicador");
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BANJO, 1F, 1F);
					p.sendMessage(" \n§6§lHACK - DUPLICADOR\n \n §6Duplicador - Status: ATIVO! Tempo restante: 45 segundos...\n ");
					new BukkitRunnable() {
						int i = 45;
						@Override
						public void run() {
							i--;
							p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aVocê perderá seu hack em "+i+" segundos!"));
							if(usando == false) {
								cancel();
							}
							if(i <= 0) {
								cancel();
								p.sendMessage(" \n§6§lHACK - DUPLICADOR\n \n §6Duplicador encerrado.\n ");
								usando = false;
								hack.remove(p, "duplicador");
							}
						}
					}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}else {
						p.sendMessage("§cVocê já está com um hack ativado.");
					}
			}else {
				p.sendMessage("§cVocê não possui diamantes suficiente.");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
			}
			}else {
				p.sendMessage("§cVocê não possui diamantes suficiente.");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
			}
			}
			if(e.getCurrentItem().getType() == Material.PURPLE_STAINED_GLASS_PANE) {
			if(diamante.get(p) != null) {
				if(diamante.get(p) >= 4) {
					if(usando == false) {
					usando = true;
					diamante.put(p, diamante.get(p)-4);
					hack.put(p, "xray");
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.ENTITY_BAT_DEATH, 1F, 1F);
					p.sendMessage(" \n§5§lHACK - XRAY\n \n §5Atenção... Atenção... Atenção...\n ");
					new BukkitRunnable() {
						int i = 120;
						@Override
						public void run() {
							i--;
							p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aVocê perderá seu hack em "+i+" segundos!"));
							if(usando == false) {
								cancel();
							}
							if(i <= 0) {
								cancel();
								p.sendMessage(" \n§5§lHACK - XRAY\n \n §5Xray encerrado.\n ");
								usando = false;
								hack.remove(p, "xray");
							}
						}
					}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					new BukkitRunnable() {
						
						@Override
						public void run() {
							for(Location location : sphere(p.getLocation(), 10, false)){
								if(location.getBlock().getType() == Material.STONE) {
							    location.getBlock().setType(Material.GLASS);
								}
							}
							if(usando == false) {
								cancel();
							}
						}
					}.runTaskTimer(Main.getPlugin(Main.class), 0L, 40L);
					
					}else {
						p.sendMessage("§cVocê já está com um hack ativado.");
					}
			}else {
				p.sendMessage("§cVocê não possui diamantes suficiente.");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
			}
			}else {
				p.sendMessage("§cVocê não possui diamantes suficiente.");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
			}
			}
			if(e.getCurrentItem().getType() == Material.LIME_STAINED_GLASS_PANE) {
			if(diamante.get(p) != null) {
				if(diamante.get(p) >= 5) {
					if(usando == false) {
					usando = true;
					diamante.put(p, diamante.get(p)-5);
					hack.put(p, "fantasma");
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.ENTITY_PHANTOM_DEATH, 1F, 1F);
					p.sendMessage(" \n§a§lHACK - FANTASMA\n \n §aModo fantasma ativado! Tempo restante: 3 minutos...\n ");
					new BukkitRunnable() {
						int i = 60*3;
						@Override
						public void run() {
							i--;
							p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aVocê perderá seu hack em "+i+" segundos!"));
							if(usando == false) {
								cancel();
							}
							if(i <= 0) {
								cancel();
								p.sendMessage(" \n§a§lHACK - FANTASMA\n \n §aFantasma encerrado.\n ");
								usando = false;
								hack.remove(p, "fantasma");
							}
						}
					}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}else {
						p.sendMessage("§cVocê já está com um hack ativado.");
					}
			}else {
				p.sendMessage("§cVocê não possui diamantes suficiente.");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
			}
			}else {
				p.sendMessage("§cVocê não possui diamantes suficiente.");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
			}
			}
			if(e.getCurrentItem().getType() == Material.LIGHT_BLUE_STAINED_GLASS_PANE) {
			if(diamante.get(p) != null) {
				if(diamante.get(p) >= 32) {
					if(usando == false) {
					usando = true;
					diamante.put(p, diamante.get(p)-32);
					hack.put(p, "deus");
					p.getOpenInventory().close();
					p.playSound(p.getLocation(), Sound.ITEM_TOTEM_USE, 1F, 1F);
					p.sendMessage(" \n§b§lHACK - DEUS\n \n §bPane no sistema, Error404\n ");
					p.setAllowFlight(true);
					p.setFlying(true);
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (60*5)*20, 4));
					p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (60*5)*20, 999));
					p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, (60*5)*20, 4));
					new BukkitRunnable() {
						int i = 60*5;
						@Override
						public void run() {
							i--;
							p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aVocê perderá seu hack em "+i+" segundos!"));
							if(usando == false) {
								cancel();
								if(p.getGameMode() == GameMode.SURVIVAL) {
									p.setAllowFlight(false);
									p.setFlying(false);
								}
							}
							if(i <= 0) {
								cancel();
								if(p.getGameMode() == GameMode.SURVIVAL) {
									p.setAllowFlight(false);
									p.setFlying(false);
								}
								p.sendMessage(" \n§b§lHACK - DEUS\n \n §bModo Deus encerrado.\n ");
								usando = false;
								hack.remove(p, "deus");
							}
						}
					}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					new BukkitRunnable() {
						ArrayList<String> text = new ArrayList<>();
						String a = "§b3.14159265359.NaN";
						String b = "§bError301";
						String c = "§bError404";
						String d = "§bReiniciando...";
						String e = "§bPane no sistema,";
						String f = "§b§k3.14159265359.NaN";
						String h = "§bErro inesperado";
						@Override
						public void run() {
							text.clear();
							text.add(a);
							text.add(b);
							text.add(c);
							text.add(d);
							text.add(e);
							text.add(f);
							text.add(h);
							Bukkit.broadcastMessage(Mine.getRandom(text));
							if(usando == false) {
								cancel();
							}
						}
					}.runTaskTimer(Main.getPlugin(Main.class), 0L, 40L);
					}else {
						p.sendMessage("§cVocê já está com um hack ativado.");
					}
			}else {
				p.sendMessage("§cVocê não possui diamantes suficiente.");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
			}
			}else {
				p.sendMessage("§cVocê não possui diamantes suficiente.");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
			}
			}
		}
	}
}

	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		
		if(e.getDamager() != null) {
			if(e.getDamager().getType() == EntityType.PLAYER) {
				Player p = (Player) e.getDamager();
				
				if(e.getEntity() != null) {
					if(e.getEntity() instanceof LivingEntity) {
						LivingEntity l = (LivingEntity) e.getEntity();
					if(hack.get(p) != null) {
						if(hack.get(p).contains("morte") || hack.get(p).contains("deus")) {
							if(usando == true) {
								l.damage(l.getMaxHealth());
							}
						}
					}
					}
				}
			}
		}
	}
	
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(hack.get(p) != null) {
			if(hack.get(p).contains("morte")) {
				if(usando == true) {
				Particle.DustOptions dust = new Particle.DustOptions(Color.RED, 2);
				p.spawnParticle(Particle.REDSTONE, p.getLocation(), 3, 0.1, 0.1, 0.1, dust);
				p.spawnParticle(Particle.REDSTONE, p.getLocation().add(0, 1, 0), 3, 0.1, 0.1, 0.1, dust);
				p.spawnParticle(Particle.REDSTONE, p.getLocation().add(0, 2, 0), 3, 0.1, 0.1, 0.1, dust);
				}
			}
		}
	}

	private Set<Location> makeHollow(Set<Location> blocks, boolean sphere){
        Set<Location> edge = new HashSet<Location>();
        if(!sphere){
            for(Location l : blocks){
                World w = l.getWorld();
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
                World w = l.getWorld();
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
        World world = location.getWorld();
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
