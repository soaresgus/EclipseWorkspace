package me.ninjay.kustgerenciador.comandos;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.creeperevents.oggehej.obsidianbreaker.ObsidianBreaker;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import me.ninjay.kustgerenciador.main.Main;
import me.ninjay.kustgerenciador.utils.Mine;

public class ComandoGerenciar implements CommandExecutor, Listener{
	
	public static HashMap<Player, String> save = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(p.hasPermission("gerenciar.admin")) {
				if(args.length == 0) {
					p.sendMessage("§cUse: /gerenciar <mundo>.");
					return true;
				}
				
				String mundon = args[0];
				
				Inventory menu = Mine.newInventory("Gerenciador de mundos", 9*3);
				
				ItemStack todos = Mine.newHead("§eTodos os mundos", "Earth", 1, " ", " §7Gerencie todos os mundos.");
				
			
				if(Bukkit.getWorld(mundon) != null) {
					World mundo = Bukkit.getWorld(mundon);
					ItemStack atual = Mine.newHead("§eMundo "+mundo.getName(), "ElMarcosFTW", 1, " ", " §7Gerencie o mundo "+mundo.getName()+".");
					save.remove(p);
					save.put(p, mundo.getName());
					menu.setItem(Mine.getPosition(2, 3), todos);
					menu.setItem(Mine.getPosition(2, 7), atual);
					
					p.openInventory(menu);
					
				}else {
					p.sendMessage("§cO mundo "+mundon+" não foi encontrado.");
				}
			}
			
		}
		return false;
	}
	
    public ItemStack getSkull(String url) {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        if(url.isEmpty())return head;
       
       
        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e1) {
            e1.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }
	
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equalsIgnoreCase("Gerenciador de mundos")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eMundo "+save.get(p))) {
						Inventory menu = Mine.newInventory(save.get(p), 9*5);
						ItemStack globaldes = Mine.newHead("§eDesativar global", "Lime", 1);
						ItemStack globalativ = Mine.newHead("§eAtivar global", "MHF_Redstone", 1);
						ItemStack cleardropsdes = Mine.newHead("§eDesativar limpar drops", "Lime", 1);
						ItemStack cleardropsativ = Mine.newHead("§eAtivar limpar drops", "MHF_Redstone", 1);
						ItemStack mobsdes = Mine.newHead("§eDesativar spawn de mobs", "Lime", 1);
						ItemStack mobsativ = Mine.newHead("§eAtivar spawn de mobs", "MHF_Redstone", 1);
						ItemStack limparmobs = Mine.newHead("§eLimpar mobs", "Spe", 1);
						ItemStack redstonedes = Mine.newHead("§eDesativar redstone", "Lime", 1);
						ItemStack redstoneativ = Mine.newHead("§eAtivar redstone", "MHF_Redstone", 1);
						ItemStack explodes = Mine.newHead("§eDesativar explosão", "Lime", 1);
						ItemStack exploativ = Mine.newHead("§eAtivar explosão", "MHF_Redstone", 1);
						ItemStack carregar = Mine.newHead("§eCarregar mundo", "Earth", 1);
						ItemStack limpardrops = Mine.newHead("§eLimpar drops", "Spe", 1);
					if(Main.config.getBoolean(save.get(p)+".global") == false) {
						menu.setItem(Mine.getPosition(2, 3), globalativ);
					}else {
						menu.setItem(Mine.getPosition(2, 3), globaldes);
					}
					if(Main.config.getBoolean(save.get(p)+".cleardrops") == false) {
						menu.setItem(Mine.getPosition(2, 4), cleardropsativ);
					}else {
						menu.setItem(Mine.getPosition(2, 4), cleardropsdes);
					}
					if(Main.config.getBoolean(save.get(p)+".mobs") == false) {
						menu.setItem(Mine.getPosition(2, 5), mobsativ);
					}else {
						menu.setItem(Mine.getPosition(2, 5), mobsdes);
					}
					if(Main.config.getBoolean(save.get(p)+".redstone") == false) {
						menu.setItem(Mine.getPosition(2, 6), redstoneativ);
					}else {
						menu.setItem(Mine.getPosition(2, 6), redstonedes);
					}
					if(Main.config.getBoolean(save.get(p)+".explosao") == false) {
						menu.setItem(Mine.getPosition(2, 7), exploativ);
					}else {
						menu.setItem(Mine.getPosition(2, 7), explodes);
					}
					
					menu.setItem(Mine.getPosition(4, 3), limpardrops);
					menu.setItem(Mine.getPosition(4, 5), limparmobs);
					menu.setItem(Mine.getPosition(4, 7), carregar);
					
					p.openInventory(menu);
					}

					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eTodos os mundos")) {
						Inventory menu = Mine.newInventory("Todos os mundos", 9*5);
						ItemStack globaldes = Mine.newHead("§eDesativar global", "Lime", 1);
						ItemStack globalativ = Mine.newHead("§eAtivar global", "MHF_Redstone", 1);
						ItemStack cleardropsdes = Mine.newHead("§eDesativar limpar drops", "Lime", 1);
						ItemStack cleardropsativ = Mine.newHead("§eAtivar limpar drops", "MHF_Redstone", 1);
						ItemStack mobsdes = Mine.newHead("§eDesativar spawn de mobs", "Lime", 1);
						ItemStack mobsativ = Mine.newHead("§eAtivar spawn de mobs", "MHF_Redstone", 1);
						ItemStack limparmobs = Mine.newHead("§eLimpar mobs", "Spe", 1);
						ItemStack redstonedes = Mine.newHead("§eDesativar redstone", "Lime", 1);
						ItemStack redstoneativ = Mine.newHead("§eAtivar redstone", "MHF_Redstone", 1);
						ItemStack explodes = Mine.newHead("§eDesativar explosão", "Lime", 1);
						ItemStack exploativ = Mine.newHead("§eAtivar explosão", "MHF_Redstone", 1);
						ItemStack carregar = Mine.newHead("§eCarregar mundo", "Earth", 1);
						ItemStack limpardrops = Mine.newHead("§eLimpar drops", "Spe", 1);
				
				for(World worlds : Bukkit.getWorlds()) {
					if(Main.config.getBoolean(worlds.getName()+".global") == false) {
						menu.setItem(Mine.getPosition(2, 3), globalativ);
					}else {
						menu.setItem(Mine.getPosition(2, 3), globaldes);
					}
					if(Main.config.getBoolean(worlds.getName()+".cleardrops") == false) {
						menu.setItem(Mine.getPosition(2, 4), cleardropsativ);
					}else {
						menu.setItem(Mine.getPosition(2, 4), cleardropsdes);
					}
					if(Main.config.getBoolean(worlds.getName()+".mobs") == false) {
						menu.setItem(Mine.getPosition(2, 5), mobsativ);
					}else {
						menu.setItem(Mine.getPosition(2, 5), mobsdes);
					}
					if(Main.config.getBoolean(worlds.getName()+".redstone") == false) {
						menu.setItem(Mine.getPosition(2, 6), redstoneativ);
					}else {
						menu.setItem(Mine.getPosition(2, 6), redstonedes);
					}
					if(Main.config.getBoolean(worlds.getName()+".explosao") == false) {
						menu.setItem(Mine.getPosition(2, 7), exploativ);
					}else {
						menu.setItem(Mine.getPosition(2, 7), explodes);
					}
				}
					
					menu.setItem(Mine.getPosition(4, 3), limpardrops);
					menu.setItem(Mine.getPosition(4, 5), limparmobs);
					menu.setItem(Mine.getPosition(4, 7), carregar);
					
					p.openInventory(menu);
					}

				}
			}
		}
		if(e.getInventory().getTitle().equalsIgnoreCase(save.get(p))) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eAtivar global")) {
						Main.config.set(save.get(p)+".global", true);
						Main.config.saveConfig();
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDesativar global")) {
						Main.config.set(save.get(p)+".global", false);
						Main.config.saveConfig();
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eAtivar limpar drops")) {
						Main.config.set(save.get(p)+".cleardrops", true);
						Main.config.saveConfig();
						startDrops(Main.getPlugin(Main.class));
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDesativar limpar drops")) {
						Main.config.set(save.get(p)+".cleardrops", false);
						Main.config.saveConfig();
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eAtivar spawn de mobs")) {
						Main.config.set(save.get(p)+".mobs", true);
						Main.config.saveConfig();
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDesativar spawn de mobs")) {
						Main.config.set(save.get(p)+".mobs", false);
						Main.config.saveConfig();
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eAtivar redstone")) {
						Main.config.set(save.get(p)+".redstone", true);
						Main.config.saveConfig();
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDesativar redstone")) {
						Main.config.set(save.get(p)+".redstone", false);
						Main.config.saveConfig();
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eAtivar explosão")) {
						Main.config.set(save.get(p)+".explosao", true);
						Main.config.saveConfig();
						ObsidianBreaker.getInstance().getConfig().set("ExplosionSources.PRIMED_TNT", 2);
						ObsidianBreaker.getInstance().getConfig().set("ExplosionSources.CREEPER", 1);
						ObsidianBreaker.getInstance().saveConfig();
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDesativar explosão")) {
						Main.config.set(save.get(p)+".explosao", false);
						Main.config.saveConfig();
						ObsidianBreaker.getInstance().getConfig().set("ExplosionSources.PRIMED_TNT", 0);
						ObsidianBreaker.getInstance().getConfig().set("ExplosionSources.CREEPER", 0);
						ObsidianBreaker.getInstance().saveConfig();
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eLimpar drops")) {
						for(Entity drops : Bukkit.getWorld(save.get(p)).getEntitiesByClass(Item.class)) {
							drops.remove();
						}
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eLimpar mobs")) {
						for(Entity monster : Bukkit.getWorld(save.get(p)).getEntitiesByClass(Monster.class)) {
							monster.remove();
						}
						for(Entity animal : Bukkit.getWorld(save.get(p)).getEntitiesByClass(Animals.class)) {
							animal.remove();
						}
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eCarregar mundo")) {
						Bukkit.createWorld(new WorldCreator(save.get(p)));
						p.getOpenInventory().close();
					}
				}
			}
		}
		if(e.getInventory().getTitle().equalsIgnoreCase("Todos os mundos")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta() != null) {
				for(World worlds : Bukkit.getWorlds()) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eAtivar global")) {
						Main.config.set(worlds.getName()+".global", true);
						Main.config.saveConfig();
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDesativar global")) {
						Main.config.set(worlds.getName()+".global", false);
						Main.config.saveConfig();
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eAtivar limpar drops")) {
						Main.config.set(worlds.getName()+".cleardrops", true);
						Main.config.saveConfig();
						startDrops(Main.getPlugin(Main.class));
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDesativar limpar drops")) {
						Main.config.set(worlds.getName()+".cleardrops", false);
						Main.config.saveConfig();
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eAtivar spawn de mobs")) {
						Main.config.set(worlds.getName()+".mobs", true);
						Main.config.saveConfig();
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDesativar spawn de mobs")) {
						Main.config.set(worlds.getName()+".mobs", false);
						Main.config.saveConfig();
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eAtivar redstone")) {
						Main.config.set(worlds.getName()+".redstone", true);
						Main.config.saveConfig();
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDesativar redstone")) {
						Main.config.set(worlds.getName()+".redstone", false);
						Main.config.saveConfig();
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eAtivar explosão")) {
						Main.config.set(worlds.getName()+".explosao", true);
						Main.config.saveConfig();
						ObsidianBreaker.getInstance().getConfig().set("ExplosionSources.PRIMED_TNT", 2);
						ObsidianBreaker.getInstance().getConfig().set("ExplosionSources.CREEPER", 1);
						ObsidianBreaker.getInstance().saveConfig();
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eDesativar explosão")) {
						Main.config.set(worlds.getName()+".explosao", false);
						Main.config.saveConfig();
						ObsidianBreaker.getInstance().getConfig().set("ExplosionSources.PRIMED_TNT", 0);
						ObsidianBreaker.getInstance().getConfig().set("ExplosionSources.CREEPER", 0);
						ObsidianBreaker.getInstance().saveConfig();
						p.getOpenInventory().close();
					}
				}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eLimpar drops")) {
						for(World worlds : Bukkit.getWorlds()) {
							for(Entity drops : worlds.getEntitiesByClass(Item.class)) {
								drops.remove();
							}
						}
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eLimpar mobs")) {
						for(World worlds : Bukkit.getWorlds()) {
							for(Entity monster : worlds.getEntitiesByClass(Monster.class)) {
								monster.remove();
							}
							for(Entity animal : worlds.getEntitiesByClass(Animals.class)) {
								animal.remove();
							}
						}
						p.getOpenInventory().close();
					}
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eCarregar mundo")) {
						for(World worlds : Bukkit.getWorlds()) {
							Bukkit.createWorld(new WorldCreator(worlds.getName()));
						}
						p.getOpenInventory().close();
					}
				}
			}
		}
	}

	private static HashMap<String, Integer> saveint = new HashMap<>();
	
	public static void startDrops(JavaPlugin main) {
			if(Main.config.getBoolean("world.cleardrops") == true) {
				if(!saveint.containsKey("i")) {
					saveint.put("i", Main.config.getInt("clearDrops"));
				}
			}
		new BukkitRunnable() {
			int i = saveint.get("i");
			@Override
			public void run() {
					if(Main.config.getBoolean("world.cleardrops") == true) {
						i--;
						saveint.put("i", i);
					}else {
						cancel();
					}
						if(saveint.get("i") == 10) {
							Bukkit.broadcastMessage(" \n§c§l[!] §cOs drops serão limpos em 10 segundos!\n ");
						}
						if(saveint.get("i") <= 0) {
						for(World worlds : Bukkit.getWorlds()) {
							for(Item itens : worlds.getEntitiesByClass(Item.class)) {
								itens.remove();
							}
						}
							Bukkit.broadcastMessage(" \n§c§l[!] §cOs drops foram limpos!\n ");
							i = Main.config.getInt("clearDrops");
							saveint.put("i", Main.config.getInt("clearDrops"));
				}
			}
		}.runTaskTimerAsynchronously(main, 20, 20);
	}
	
	@EventHandler
	public void aoGlobal(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		
			if(e.getMessage().startsWith("/g ")) {
				if(Main.config.getBoolean(p.getWorld().getName()+".global") == false) {
				e.setCancelled(true);
				p.sendMessage("§cO chat global está desativado nesse mundo.");
			}
		}
	}
	
	@EventHandler
	public void onSpawn(EntitySpawnEvent e) {
		for(World worlds : Bukkit.getWorlds()) {
			if(Main.config.getBoolean(worlds.getName()+".mobs") == false) {
			if(e.getEntity().getLocation().getWorld().getName().equals(worlds.getName())) {
				if(e.getEntityType() != EntityType.PLAYER) {
					if(e.getEntityType() != EntityType.DROPPED_ITEM) {
						if(e.getEntityType() != EntityType.ARMOR_STAND) {
					e.setCancelled(true);
						}
					}
				}
			}
			}
		}
	}
	
	@EventHandler
	public void aoRedstone(BlockRedstoneEvent e) {
		for(World worlds : Bukkit.getWorlds()) {
			if(Main.config.getBoolean(worlds.getName()+".redstone") == false) {
				if(e.getBlock().getLocation().getWorld().getName().equalsIgnoreCase(worlds.getName())) {
				e.setNewCurrent(0);
				}
			}
		}
	}
	
	@EventHandler
	public void aoExplodir(EntityExplodeEvent e){
		for(World worlds : Bukkit.getWorlds()) {
			if(Main.config.getBoolean(worlds.getName()+".explosao") == false) {
				if(e.getEntity().getLocation().getWorld().getName().equalsIgnoreCase(worlds.getName())) {
					e.blockList().clear();
				}
			}
		}
	}
	
}
