package me.ninjay.kustmina.comandos;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.kustmina.estruturas.CaptchaAPI;
import me.ninjay.kustmina.main.Main;
import me.ninjay.kustmina.utils.Mine;

public class ComandoMina implements CommandExecutor, Listener{
	
	public static ItemStack membro = Mine.newItem(Material.COBBLESTONE, "§eMina Comum", 1, 0, " "," §7● PvP e dano ativo", " §7● Mineração pública", " §7● Lucro menor", " §7● Resetada de tempos em tempos");
	public static ItemStack vip = Mine.newItem(Material.DIAMOND_BLOCK, "§bMina VIP", 1, 0, " "," §a● Sem PvP e dano desativado", " §a● Mineração privada", " §a● Lucro maior", " §a● Sempre resetada");

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			Inventory menu = Mine.newInventory("Escolha uma mina", 9*3);
			
			menu.setItem(Mine.getPosition(2, 3), membro);
			menu.setItem(Mine.getPosition(2, 7), vip);
			
			p.openInventory(menu);
		}
		return false;
	}

	
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equalsIgnoreCase("Escolha uma mina")) {
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta() != null) {
				if(e.getCurrentItem() != null) {
					if(e.getCurrentItem().isSimilar(membro)) {
						p.getOpenInventory().close();
						if(!p.hasPermission("mina.vip")) {
							Location loc = new Location(Main.config.getLocation("membro").getWorld(), Mine.getRandomDouble(Main.config.getLocation("membro").getX(), Main.config.getLocation("membro").getX()+50), Main.config.getLocation("membro").getY(), Mine.getRandomDouble(Main.config.getLocation("membro").getZ(), Main.config.getLocation("membro").getZ()+50));
							p.sendMessage(" \n§eVocê será teleportado em 3 segundos...\nJogadores Vips não precisam esperar.\n ");
							new BukkitRunnable() {
								int i = 4;
								@Override
								public void run() {
									i--;
									Mine.sendTitle(p, "§e§l"+i, "§eVips não precisam esperar...", 5, 20, 5);
									if(i <= 0) {
										cancel();
										p.teleport(loc);
										CaptchaAPI.start(p, Main.config.getLocation("membro").getWorld().getName(), Main.getPlugin(Main.class));
										p.sendMessage(ChatColor.YELLOW+"§e§l              Mundo de mineração              \n \n §e● PvP e dano ativo\n §e● Mineração pública\n §e● Lucro menor\n §e● Resetada de tempos em tempos\n \n§e§lVips possuem acesso à mineração privada.");
										i=4;
									}
								}
							}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);
						}else {
							Location loc = new Location(Main.config.getLocation("membro").getWorld(), Mine.getRandomDouble(Main.config.getLocation("membro").getX(), Main.config.getLocation("membro").getX()+50), Main.config.getLocation("membro").getY(), Mine.getRandomDouble(Main.config.getLocation("membro").getZ(), Main.config.getLocation("membro").getZ()+50));
							p.sendMessage("§aTeleportado!");
							p.sendMessage(ChatColor.YELLOW+"§e§l              Mundo de mineração              \n \n §e● PvP e dano ativo\n §e● Mineração pública\n §e● Lucro menor\n §e● Resetada de tempos em tempos\n \n§e§lVips possuem acesso à mineração privada.");
							p.teleport(loc);
							CaptchaAPI.start(p, Main.config.getLocation("membro").getWorld().getName(), Main.getPlugin(Main.class));
						}
					}
					if(e.getCurrentItem().isSimilar(vip)) {
						p.getOpenInventory().close();
						p.chat("/minavip");
					}
				}
			}
		}
	}
	
	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(p.getWorld().getName().equalsIgnoreCase(Main.config.getLocation("membro").getWorld().getName())) {
			if(e.getBlock().getType() == Material.STONE) {
				if(Mine.isFull(p.getInventory())) {
					p.sendMessage("§cSeu inventário está cheio!");
				}
			if(!CaptchaAPI.save.containsKey(p)) {
				if(p.getLocation().getY() <= 30) {
					if(!p.getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
						if(Mine.getChance(Main.config.getDouble("coal.chance"))) {
							ItemStack coal = new ItemStack(Material.COAL, 1);
							p.getInventory().addItem(coal);
							return;
					}
				}
					if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
						if(Mine.getChance(Main.config.getDouble("coal.chance"))) {
							ItemStack coal = new ItemStack(Material.COAL, Mine.getRandomInt(1, Main.config.getInt("coal.fortune1")));
							p.getInventory().addItem(coal);
							return;
					}
				}
					if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 2) {
						if(Mine.getChance(Main.config.getDouble("coal.chance"))) {
							ItemStack coal = new ItemStack(Material.COAL, Mine.getRandomInt(Main.config.getInt("coal.fortune1"), Main.config.getInt("coal.fortune2")));
							p.getInventory().addItem(coal);
							return;
					}
				}	
					if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 3) {
						if(Mine.getChance(Main.config.getDouble("coal.chance"))) {
							ItemStack coal = new ItemStack(Material.COAL, Mine.getRandomInt(Main.config.getInt("coal.fortune2"), Main.config.getInt("coal.fortune3")));
							p.getInventory().addItem(coal);
							return;
					}
				}
					
			}
				if(p.getLocation().getY() <= 30) {
					if(Mine.getChance(Main.config.getDouble("iron.chance"))) {
						ItemStack iron = new ItemStack(Material.IRON_ORE, 1);
						p.getInventory().addItem(iron);
						return;
					}
				}
				if(p.getLocation().getY() <= 15) {
					if(!p.getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
						if(Mine.getChance(Main.config.getDouble("lapiz.chance"))) {
							ItemStack lapiz = Mine.newItem(Material.INK_SACK, null, 1, 4);
							p.getInventory().addItem(lapiz);
							return;
					}
						if(Mine.getChance(Main.config.getDouble("redstone.chance"))) {
							ItemStack red = new ItemStack(Material.REDSTONE, 1);
							p.getInventory().addItem(red);
							return;
					}
						if(Mine.getChance(Main.config.getDouble("diamond.chance"))) {
							ItemStack dia = new ItemStack(Material.DIAMOND, 1);
							p.getInventory().addItem(dia);
							return;
					}
				}
					if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
						if(Mine.getChance(Main.config.getDouble("lapiz.chance"))) {
							ItemStack lapiz = Mine.newItem(Material.INK_SACK, null, Mine.getRandomInt(1, Main.config.getInt("lapiz.fortune1")), 4);
							p.getInventory().addItem(lapiz);
							return;
					}
						if(Mine.getChance(Main.config.getDouble("redstone.chance"))) {
							ItemStack red = new ItemStack(Material.REDSTONE, Mine.getRandomInt(1, Main.config.getInt("redstone.fortune1")));
							p.getInventory().addItem(red);
							return;
					}
						if(Mine.getChance(Main.config.getDouble("diamond.chance"))) {
							ItemStack dia = new ItemStack(Material.DIAMOND, Mine.getRandomInt(1, Main.config.getInt("diamond.fortune1")));
							p.getInventory().addItem(dia);
							return;
					}
				}
					if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 2) {
						if(Mine.getChance(Main.config.getDouble("lapiz.chance"))) {
							ItemStack lapiz = Mine.newItem(Material.INK_SACK, null, Mine.getRandomInt(Main.config.getInt("lapiz.fortune1"), Main.config.getInt("lapiz.fortune2")), 4);
							p.getInventory().addItem(lapiz);
							return;
					}
						if(Mine.getChance(Main.config.getDouble("redstone.chance"))) {
							ItemStack red = new ItemStack(Material.REDSTONE, Mine.getRandomInt(Main.config.getInt("redstone.fortune1"), Main.config.getInt("redstone.fortune2")));
							p.getInventory().addItem(red);
							return;
					}
						if(Mine.getChance(Main.config.getDouble("diamond.chance"))) {
							ItemStack dia = new ItemStack(Material.DIAMOND, Mine.getRandomInt(Main.config.getInt("diamond.fortune1"), Main.config.getInt("diamond.fortune2")));
							p.getInventory().addItem(dia);
							return;
					}
				}	
					if(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 3) {
						if(Mine.getChance(Main.config.getDouble("lapiz.chance"))) {
							ItemStack lapiz = Mine.newItem(Material.INK_SACK, null, Mine.getRandomInt(Main.config.getInt("lapiz.fortune2"), Main.config.getInt("lapiz.fortune3")), 4);
							p.getInventory().addItem(lapiz);
							return;
					}
						if(Mine.getChance(Main.config.getDouble("redstone.chance"))) {
							ItemStack red = new ItemStack(Material.REDSTONE, Mine.getRandomInt(Main.config.getInt("redstone.fortune2"), Main.config.getInt("redstone.fortune3")));
							p.getInventory().addItem(red);
							return;
					}
						if(Mine.getChance(Main.config.getDouble("diamond.chance"))) {
							ItemStack dia = new ItemStack(Material.DIAMOND, Mine.getRandomInt(Main.config.getInt("diamond.fortune2"), Main.config.getInt("diamond.fortune3")));
							p.getInventory().addItem(dia);
							return;
					}
				}
					if(Mine.getChance(Main.config.getDouble("gold.chance"))) {
						ItemStack gold = new ItemStack(Material.GOLD_ORE, 1);
						p.getInventory().addItem(gold);
						return;
					}
				}
			}
			}
		}
	}
	
	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		if(e.getPlayer().getWorld().getName().equalsIgnoreCase(Main.config.getLocation("membro").getWorld().getName())) {
			if(e.getMessage().contains("/spawn") || e.getMessage().contains("/vip") || e.getMessage().contains("/lobyy") || e.getMessage().contains("/c") || e.getMessage().contains("/a") || e.getMessage().contains("/f") || e.getMessage().contains("/g") || e.getMessage().contains("/kit")) {
				e.setCancelled(false);
				}else {
					e.setCancelled(true);
					e.getPlayer().sendMessage("§cVocê não pode utilizar comandos aqui, saia utilizando o /spawn.");
				}
			}
	}
}
