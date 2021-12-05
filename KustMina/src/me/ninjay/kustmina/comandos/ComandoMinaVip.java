package me.ninjay.kustmina.comandos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.kustmina.estruturas.CaptchaAPI;
import me.ninjay.kustmina.main.Main;
import me.ninjay.kustmina.utils.Mine;
import me.ninjay.kustmina.utils.VaultAPI;


public class ComandoMinaVip implements CommandExecutor, Listener{
	
	public static HashMap<Player, ItemStack> pic = new HashMap<>();
	public static HashMap<Player, Location> loch = new HashMap<>();
	
	public static void createMina(Location loc, Material type) {
		loc.clone().add(0, -2, 0).getBlock().setType(type, true);
		loc.clone().add(0, -2, +1).getBlock().setType(type, true);
		loc.clone().add(0, -2, +2).getBlock().setType(type, true);
		loc.clone().add(0, -2, +3).getBlock().setType(type, true);
		loc.clone().add(0, -2, +4).getBlock().setType(type, true);

		loc.clone().add(0, -2, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -2, 0).getBlock().setType(type, true);
		loc.clone().add(+2, -2, 0).getBlock().setType(type, true);
		loc.clone().add(+3, -2, 0).getBlock().setType(type, true);
		loc.clone().add(+4, -2, 0).getBlock().setType(type, true);

		loc.clone().add(0, -2, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -2, +1).getBlock().setType(type, true);
		loc.clone().add(+2, -2, +1).getBlock().setType(type, true);
		loc.clone().add(+3, -2, +1).getBlock().setType(type, true);
		loc.clone().add(+4, -2, +1).getBlock().setType(type, true);

		loc.clone().add(0, -2, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -2, +2).getBlock().setType(type, true);
		loc.clone().add(+2, -2, +2).getBlock().setType(type, true);
		loc.clone().add(+3, -2, +2).getBlock().setType(type, true);
		loc.clone().add(+4, -2, +2).getBlock().setType(type, true);

		loc.clone().add(0, -2, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -2, +3).getBlock().setType(type, true);
		loc.clone().add(+2, -2, +3).getBlock().setType(type, true);
		loc.clone().add(+3, -2, +3).getBlock().setType(type, true);
		loc.clone().add(+4, -2, +3).getBlock().setType(type, true);

		loc.clone().add(0, -2, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -2, +4).getBlock().setType(type, true);
		loc.clone().add(+2, -2, +4).getBlock().setType(type, true);
		loc.clone().add(+3, -2, +4).getBlock().setType(type, true);
		loc.clone().add(+4, -2, +4).getBlock().setType(type, true);

		//

		loc.clone().add(0, -3, 0).getBlock().setType(type, true);
		loc.clone().add(0, -3, +1).getBlock().setType(type, true);
		loc.clone().add(0, -3, +2).getBlock().setType(type, true);
		loc.clone().add(0, -3, +3).getBlock().setType(type, true);
		loc.clone().add(0, -3, +4).getBlock().setType(type, true);

		loc.clone().add(0, -3, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -3, 0).getBlock().setType(type, true);
		loc.clone().add(+2, -3, 0).getBlock().setType(type, true);
		loc.clone().add(+3, -3, 0).getBlock().setType(type, true);
		loc.clone().add(+4, -3, 0).getBlock().setType(type, true);

		loc.clone().add(0, -3, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -3, +1).getBlock().setType(type, true);
		loc.clone().add(+2, -3, +1).getBlock().setType(type, true);
		loc.clone().add(+3, -3, +1).getBlock().setType(type, true);
		loc.clone().add(+4, -3, +1).getBlock().setType(type, true);

		loc.clone().add(0, -3, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -3, +2).getBlock().setType(type, true);
		loc.clone().add(+2, -3, +2).getBlock().setType(type, true);
		loc.clone().add(+3, -3, +2).getBlock().setType(type, true);
		loc.clone().add(+4, -3, +2).getBlock().setType(type, true);

		loc.clone().add(0, -3, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -3, +3).getBlock().setType(type, true);
		loc.clone().add(+2, -3, +3).getBlock().setType(type, true);
		loc.clone().add(+3, -3, +3).getBlock().setType(type, true);
		loc.clone().add(+4, -3, +3).getBlock().setType(type, true);

		loc.clone().add(0, -3, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -3, +4).getBlock().setType(type, true);
		loc.clone().add(+2, -3, +4).getBlock().setType(type, true);
		loc.clone().add(+3, -3, +4).getBlock().setType(type, true);
		loc.clone().add(+4, -3, +4).getBlock().setType(type, true);

		//

		loc.clone().add(0, -4, 0).getBlock().setType(type, true);
		loc.clone().add(0, -4, +1).getBlock().setType(type, true);
		loc.clone().add(0, -4, +2).getBlock().setType(type, true);
		loc.clone().add(0, -4, +3).getBlock().setType(type, true);
		loc.clone().add(0, -4, +4).getBlock().setType(type, true);

		loc.clone().add(0, -4, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -4, 0).getBlock().setType(type, true);
		loc.clone().add(+2, -4, 0).getBlock().setType(type, true);
		loc.clone().add(+3, -4, 0).getBlock().setType(type, true);
		loc.clone().add(+4, -4, 0).getBlock().setType(type, true);

		loc.clone().add(0, -4, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -4, +1).getBlock().setType(type, true);
		loc.clone().add(+2, -4, +1).getBlock().setType(type, true);
		loc.clone().add(+3, -4, +1).getBlock().setType(type, true);
		loc.clone().add(+4, -4, +1).getBlock().setType(type, true);

		loc.clone().add(0, -4, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -4, +2).getBlock().setType(type, true);
		loc.clone().add(+2, -4, +2).getBlock().setType(type, true);
		loc.clone().add(+3, -4, +2).getBlock().setType(type, true);
		loc.clone().add(+4, -4, +2).getBlock().setType(type, true);

		loc.clone().add(0, -4, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -4, +3).getBlock().setType(type, true);
		loc.clone().add(+2, -4, +3).getBlock().setType(type, true);
		loc.clone().add(+3, -4, +3).getBlock().setType(type, true);
		loc.clone().add(+4, -4, +3).getBlock().setType(type, true);

		loc.clone().add(0, -4, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -4, +4).getBlock().setType(type, true);
		loc.clone().add(+2, -4, +4).getBlock().setType(type, true);
		loc.clone().add(+3, -4, +4).getBlock().setType(type, true);
		loc.clone().add(+4, -4, +4).getBlock().setType(type, true);

		//

		loc.clone().add(0, -5, 0).getBlock().setType(type, true);
		loc.clone().add(0, -5, +1).getBlock().setType(type, true);
		loc.clone().add(0, -5, +2).getBlock().setType(type, true);
		loc.clone().add(0, -5, +3).getBlock().setType(type, true);
		loc.clone().add(0, -5, +4).getBlock().setType(type, true);

		loc.clone().add(0, -5, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -5, 0).getBlock().setType(type, true);
		loc.clone().add(+2, -5, 0).getBlock().setType(type, true);
		loc.clone().add(+3, -5, 0).getBlock().setType(type, true);
		loc.clone().add(+4, -5, 0).getBlock().setType(type, true);

		loc.clone().add(0, -5, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -5, +1).getBlock().setType(type, true);
		loc.clone().add(+2, -5, +1).getBlock().setType(type, true);
		loc.clone().add(+3, -5, +1).getBlock().setType(type, true);
		loc.clone().add(+4, -5, +1).getBlock().setType(type, true);

		loc.clone().add(0, -5, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -5, +2).getBlock().setType(type, true);
		loc.clone().add(+2, -5, +2).getBlock().setType(type, true);
		loc.clone().add(+3, -5, +2).getBlock().setType(type, true);
		loc.clone().add(+4, -5, +2).getBlock().setType(type, true);

		loc.clone().add(0, -5, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -5, +3).getBlock().setType(type, true);
		loc.clone().add(+2, -5, +3).getBlock().setType(type, true);
		loc.clone().add(+3, -5, +3).getBlock().setType(type, true);
		loc.clone().add(+4, -5, +3).getBlock().setType(type, true);

		loc.clone().add(0, -5, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -5, +4).getBlock().setType(type, true);
		loc.clone().add(+2, -5, +4).getBlock().setType(type, true);
		loc.clone().add(+3, -5, +4).getBlock().setType(type, true);
		loc.clone().add(+4, -5, +4).getBlock().setType(type, true);

		//

		loc.clone().add(0, -6, 0).getBlock().setType(type, true);
		loc.clone().add(0, -6, +1).getBlock().setType(type, true);
		loc.clone().add(0, -6, +2).getBlock().setType(type, true);
		loc.clone().add(0, -6, +3).getBlock().setType(type, true);
		loc.clone().add(0, -6, +4).getBlock().setType(type, true);

		loc.clone().add(0, -6, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -6, 0).getBlock().setType(type, true);
		loc.clone().add(+2, -6, 0).getBlock().setType(type, true);
		loc.clone().add(+3, -6, 0).getBlock().setType(type, true);
		loc.clone().add(+4, -6, 0).getBlock().setType(type, true);

		loc.clone().add(0, -6, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -6, +1).getBlock().setType(type, true);
		loc.clone().add(+2, -6, +1).getBlock().setType(type, true);
		loc.clone().add(+3, -6, +1).getBlock().setType(type, true);
		loc.clone().add(+4, -6, +1).getBlock().setType(type, true);

		loc.clone().add(0, -6, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -6, +2).getBlock().setType(type, true);
		loc.clone().add(+2, -6, +2).getBlock().setType(type, true);
		loc.clone().add(+3, -6, +2).getBlock().setType(type, true);
		loc.clone().add(+4, -6, +2).getBlock().setType(type, true);

		loc.clone().add(0, -6, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -6, +3).getBlock().setType(type, true);
		loc.clone().add(+2, -6, +3).getBlock().setType(type, true);
		loc.clone().add(+3, -6, +3).getBlock().setType(type, true);
		loc.clone().add(+4, -6, +3).getBlock().setType(type, true);

		loc.clone().add(0, -6, 0).getBlock().setType(type, true);
		loc.clone().add(+1, -6, +4).getBlock().setType(type, true);
		loc.clone().add(+2, -6, +4).getBlock().setType(type, true);
		loc.clone().add(+3, -6, +4).getBlock().setType(type, true);
		loc.clone().add(+4, -6, +4).getBlock().setType(type, true);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.hasPermission("mina.vip")) {
			Inventory menu = Mine.newInventory("Definir picareta", 9*3);
			ItemStack sem = Mine.newHead("§e§lDefinir picareta", "ElMarcosFTW", 1, " ", " §7Clique com sua picareta na mão.");
			ItemStack nem = Mine.newItem(Material.STAINED_GLASS_PANE, "§cNenhuma picareta definida", 1, 14);
			ItemStack tp = Mine.newHead("§eTeleportar para a mina", "acissejxd", 1);
			
			if(!pic.containsKey(p)) {
				menu.setItem(Mine.getPosition(2, 3), sem);
				menu.setItem(Mine.getPosition(2, 7), nem);
				menu.setItem(Mine.getPosition(2, 5), tp);
				p.openInventory(menu);
			}
			if(pic.containsKey(p)) {
				menu.setItem(Mine.getPosition(2, 3), sem);
				ItemStack pici = pic.get(p);
				pici.setAmount(1);
				menu.setItem(Mine.getPosition(2, 7), pici);
				menu.setItem(Mine.getPosition(2, 5), tp);
				p.openInventory(menu);
			}
		}else {
			p.sendMessage("§eVocê não possuí permissão, esse é um recurso §e§lVIP.");
		}
		}
		return false;
	}
	
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equalsIgnoreCase("Definir picareta")) {
			e.setCancelled(true);
		if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§e§lDefinir picareta")) {
						if(p.getItemInHand() != null) {
							if(p.getItemInHand().getType() == Material.DIAMOND_PICKAXE || p.getItemInHand().getType() == Material.IRON_PICKAXE || p.getItemInHand().getType() == Material.GOLD_PICKAXE || p.getItemInHand().getType() == Material.STONE_PICKAXE || p.getItemInHand().getType() == Material.WOOD_PICKAXE) {
								p.getOpenInventory().close();
								p.sendMessage("§aPicareta definida.");
								pic.remove(p);
								pic.put(p, p.getItemInHand());
								pic.get(p).setAmount(1);
							}else {
								p.getOpenInventory().close();
								p.sendMessage("§cVocê precisa estar segurando uma picareta na mão.");
							}
						}else {
							p.sendMessage("§cVocê precisa estar segurando uma picareta na mão.");
						}
					}else {
						e.setCancelled(true);
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eTeleportar para a mina")) {
						boolean isEmpty = true;
						for (ItemStack item : p.getInventory().getContents()) {
							if (item != null) {
								isEmpty = false;
								break;
							}
						}
						if(isEmpty) {
							if(pic.containsKey(p)) {
								Double x = Mine.getRandomDouble(-4500, 4500);
								Double y = Mine.getRandomDouble(20, 230);
								Double z = Mine.getRandomDouble(-4500, 4500);
								Location loc = new Location(Bukkit.getWorld(Main.config.getString("vip")), x, y, z);
								Location loc2 = new Location(Bukkit.getWorld(Main.config.getString("vip")), x+2.5, y+2.5, z+2.5);
								
								createMina(loc, Material.STONE);
								p.teleport(loc2);
								loch.put(p, loc);
								p.sendMessage(ChatColor.YELLOW+"§e§l              Mundo de mineração VIP              \n \n §e● PvP e dano desativado\n §e● Mineração privada\n §e● Lucro maior\n §e● Sempre resetada\n §e● Apenas os minério de diamante e ouro irão para seu inventário.\n ");
								Mine.sendTitle(p, "§a§lMineração VIP", "§aMineração gerada com sucesso", 5, 50, 5);
								p.getInventory().setItem(Mine.getPosition(1, 1), pic.get(p));
								CaptchaAPI.start(p, Main.config.getString("vip"), Main.getPlugin(Main.class));
							}else {
								p.getOpenInventory().close();
								p.sendMessage("§cVocê precisa definir sua picareta para se teleportar.");
							}
						}else {
							p.getOpenInventory().close();
							p.sendMessage("§cVocê precisa esvaziar o inventário para se teleportar.");
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void aoDano(EntityDamageEvent e) {
		if(e.getEntity().getWorld().getName().equalsIgnoreCase(Main.config.getString("vip"))) {
			e.setCancelled(true);
		}
	}
	
//	@EventHandler
//	public void aoSair(PlayerTeleportEvent e) {
//		Player p = e.getPlayer();
//		
//		if(p.getWorld().getName().equalsIgnoreCase(Main.config.getString("vip"))) {
//			if(loch.containsKey(p)) {
//			p.getLocation().getWorld().createExplosion(loch.get(p), 60F);
//			loch.remove(p);
//			p.getInventory().remove(Material.DIAMOND_PICKAXE);
//			p.getInventory().remove(Material.IRON_PICKAXE);
//			p.getInventory().remove(Material.GOLD_PICKAXE);
//			p.getInventory().remove(Material.STONE_PICKAXE);
//			p.getInventory().remove(Material.WOOD_PICKAXE);
//			}
//		}
//	}
	
	@EventHandler
	public void aoVoid(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(p.getWorld().getName().equalsIgnoreCase(Main.config.getString("vip"))) {
			if(p.getLocation().getY() <= -1) {
				p.chat("/spawn");
				loch.remove(p);
				p.getInventory().remove(Material.DIAMOND_PICKAXE);
				p.getInventory().remove(Material.IRON_PICKAXE);
				p.getInventory().remove(Material.GOLD_PICKAXE);
				p.getInventory().remove(Material.STONE_PICKAXE);
				p.getInventory().remove(Material.WOOD_PICKAXE);
			}
		}
	}
	
	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
	if(e.getPlayer().getWorld().getName().equalsIgnoreCase(Main.config.getString("vip"))) {
		if(e.getMessage().contains("/spawn") || e.getMessage().contains("/vip") || e.getMessage().contains("/lobby")) {
			e.setCancelled(false);
			if(loch.containsKey(p)) {
			p.getLocation().getWorld().createExplosion(loch.get(p), 60F);
			loch.remove(p);
			p.getInventory().remove(Material.DIAMOND_PICKAXE);
			p.getInventory().remove(Material.IRON_PICKAXE);
			p.getInventory().remove(Material.GOLD_PICKAXE);
			p.getInventory().remove(Material.STONE_PICKAXE);
			p.getInventory().remove(Material.WOOD_PICKAXE);
			}
			}
		if(e.getMessage().contains("/c") || e.getMessage().contains("/a") || e.getMessage().contains("/g") || e.getMessage().contains("/f") || e.getMessage().contains("/spawn") || e.getMessage().contains("/vip") || e.getMessage().contains("/lobby")) {
			e.setCancelled(false);
		}else {
			e.setCancelled(true);
			e.getPlayer().sendMessage("§cVocê não pode utilizar comandos aqui, saia utilizando o /spawn.");
		}
		}
	}
	
	@EventHandler
	public void aoDisconnect(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		if(p.getWorld().getName().equalsIgnoreCase(Main.config.getString("vip"))) {
			if(loch.containsKey(p)) {
			p.getLocation().getWorld().createExplosion(loch.get(p), 60F);
			loch.remove(p);
			p.getInventory().remove(Material.DIAMOND_PICKAXE);
			p.getInventory().remove(Material.IRON_PICKAXE);
			p.getInventory().remove(Material.GOLD_PICKAXE);
			p.getInventory().remove(Material.STONE_PICKAXE);
			p.getInventory().remove(Material.WOOD_PICKAXE);
			}
		}
	}
	
	@EventHandler
	public void aoDropar(PlayerDropItemEvent e) {
		if(e.getPlayer().getWorld().getName().equalsIgnoreCase(Main.config.getString("vip"))) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void aoColocar(BlockPlaceEvent e) {
		if(e.getPlayer().getWorld().getName().equalsIgnoreCase(Main.config.getString("vip"))) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
	if(!CaptchaAPI.save.containsKey(p)) {
		if(p.getWorld().getName().equalsIgnoreCase(Main.config.getString("vip"))) {
			if(e.getBlock().getType() == Material.STONE) {
				e.setCancelled(true);
				e.getBlock().setType(Material.AIR);
				if(Mine.isFull(p.getInventory())) {
					p.sendMessage("§cSeu inventário está cheio!");
				}
				
				if(Mine.getChance(Main.config.getDouble("gold.chancevip"))) {
					ItemStack gold = new ItemStack(Material.GOLD_INGOT, 1);
					p.getInventory().addItem(gold);
					return;
				}
				
				if(Mine.getChance(Main.config.getDouble("iron.chancevip"))) {
					Mine.sendTitle(p, " ", "§a§l+"+Main.config.getDouble("iron.valorvip"), 5, 20, 5);
					VaultAPI.getEconomy().depositPlayer(p.getName(), Main.config.getDouble("iron.valorvip"));
					return;
				}
				
					if(!p.getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
						if(Mine.getChance(Main.config.getDouble("coal.chancevip"))) {
							Mine.sendTitle(p, " ", "§a§l+"+Main.config.getDouble("coal.valorvip"), 5, 20, 5);
							VaultAPI.getEconomy().depositPlayer(p.getName(), Main.config.getDouble("coal.valorvip"));
							return;
					}
						if(Mine.getChance(Main.config.getDouble("diamond.chancevip"))) {
							ItemStack dia = new ItemStack(Material.DIAMOND, 1);
							p.getInventory().addItem(dia);
							return;
					}
						

				}
					if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
						if(Mine.getChance(Main.config.getDouble("coal.chancevip"))) {
							Mine.sendTitle(p, " ", "§a§l+"+Main.config.getDouble("coal.valorvip"), 5, 20, 5);
							VaultAPI.getEconomy().depositPlayer(p.getName(), Main.config.getDouble("coal.valorvip")*Mine.getRandomDouble(1, Main.config.getDouble("coal.fortune1")));
							return;
					}
						if(Mine.getChance(Main.config.getDouble("diamond.chancevip"))) {
							ItemStack dia = new ItemStack(Material.DIAMOND, Mine.getRandomInt(1, Main.config.getInt("diamond.fortune1")));
							p.getInventory().addItem(dia);
							return;
					}
				}
					if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 2) {
						if(Mine.getChance(Main.config.getDouble("coal.chancevip"))) {
							Mine.sendTitle(p, " ", "§a§l+"+Main.config.getDouble("coal.valorvip"), 5, 20, 5);
							VaultAPI.getEconomy().depositPlayer(p.getName(), Main.config.getDouble("coal.valorvip")*Mine.getRandomDouble(Main.config.getDouble("coal.fortune1"), Main.config.getDouble("coal.fortune2")));
							return;
					}
						if(Mine.getChance(Main.config.getDouble("diamond.chancevip"))) {
							ItemStack dia = new ItemStack(Material.DIAMOND, Mine.getRandomInt(Main.config.getInt("diamond.fortune1"), Main.config.getInt("diamond.fortune2")));
							p.getInventory().addItem(dia);
							return;
					}
				}	
					if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 3) {
						if(Mine.getChance(Main.config.getDouble("coal.chancevip"))) {
							Mine.sendTitle(p, " ", "§a§l+"+Main.config.getDouble("coal.valorvip"), 5, 20, 5);
							VaultAPI.getEconomy().depositPlayer(p.getName(), Main.config.getDouble("coal.valorvip")*Mine.getRandomDouble(Main.config.getDouble("coal.fortune2"), Main.config.getDouble("coal.fortune3")));
							return;
					}
						if(Mine.getChance(Main.config.getDouble("diamond.chancevip"))) {
							ItemStack dia = new ItemStack(Material.DIAMOND, Mine.getRandomInt(Main.config.getInt("diamond.fortune2"), Main.config.getInt("diamond.fortune3")));
							p.getInventory().addItem(dia);
							return;
					}
				}
					
			}
					if(!p.getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
						if(Mine.getChance(Main.config.getDouble("lapiz.chancevip"))) {
							Mine.sendTitle(p, " ", "§a§l+"+Main.config.getDouble("lapiz.valorvip"), 5, 20, 5);
							VaultAPI.getEconomy().depositPlayer(p.getName(), Main.config.getDouble("lapiz.valorvip"));
							return;
					}
						if(Mine.getChance(Main.config.getDouble("redstone.chancevip"))) {
							Mine.sendTitle(p, " ", "§a§l+"+Main.config.getDouble("redstone.valorvip"), 5, 20, 5);
							VaultAPI.getEconomy().depositPlayer(p.getName(), Main.config.getDouble("redstone.valorvip"));
							return;
					}
				}
					if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
						if(Mine.getChance(Main.config.getDouble("lapiz.chancevip"))) {
							Mine.sendTitle(p, " ", "§a§l+"+Main.config.getDouble("lapiz.valorvip"), 5, 20, 5);
							VaultAPI.getEconomy().depositPlayer(p.getName(), Main.config.getDouble("lapiz.valorvip")*Mine.getRandomDouble(1, Main.config.getDouble("lapiz.fortune2")));
							return;
					}
						if(Mine.getChance(Main.config.getDouble("redstone.chancevip"))) {
							Mine.sendTitle(p, " ", "§a§l+"+Main.config.getDouble("redstone.valorvip"), 5, 20, 5);
							VaultAPI.getEconomy().depositPlayer(p.getName(), Main.config.getDouble("redstone.valorvip")*Mine.getRandomDouble(1, Main.config.getDouble("redstone.fortune2")));
							return;
					}
				}
					if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 2) {
						if(Mine.getChance(Main.config.getDouble("lapiz.chancevip"))) {
							Mine.sendTitle(p, " ", "§a§l+"+Main.config.getDouble("lapiz.valorvip"), 5, 20, 5);
							VaultAPI.getEconomy().depositPlayer(p.getName(), Main.config.getDouble("lapiz.valorvip")*Mine.getRandomDouble(Main.config.getDouble("lapiz.fortune1"), Main.config.getDouble("lapiz.fortune2")));
							return;
					}
						if(Mine.getChance(Main.config.getDouble("redstone.chancevip"))) {
							Mine.sendTitle(p, " ", "§a§l+"+Main.config.getDouble("redstone.valorvip"), 5, 20, 5);
							VaultAPI.getEconomy().depositPlayer(p.getName(), Main.config.getDouble("redstone.valorvip")*Mine.getRandomDouble(Main.config.getDouble("redstone.fortune1"), Main.config.getDouble("redstone.fortune2")));
							return;
					}
				}	
					if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 3) {
						if(Mine.getChance(Main.config.getDouble("lapiz.chancevip"))) {
							Mine.sendTitle(p, " ", "§a§l+"+Main.config.getDouble("lapiz.valorvip"), 5, 20, 5);
							VaultAPI.getEconomy().depositPlayer(p.getName(), Main.config.getDouble("lapiz.valorvip")*Mine.getRandomDouble(Main.config.getDouble("lapiz.fortune2"), Main.config.getDouble("lapiz.fortune3")));
							return;
					}
						if(Mine.getChance(Main.config.getDouble("redstone.chancevip"))) {
							Mine.sendTitle(p, " ", "§a§l+"+Main.config.getDouble("redstone.valorvip"), 5, 20, 5);
							VaultAPI.getEconomy().depositPlayer(p.getName(), Main.config.getDouble("redstone.valorvip")*Mine.getRandomDouble(Main.config.getDouble("redstone.fortune2"), Main.config.getDouble("redstone.fortune3")));
							return;
					}
				}
			}
		}else {
			e.setCancelled(true);
		}
	}
	}
