package me.ninjay.kustcaixas.estruturas;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import io.netty.util.internal.ReflectionUtil;
import me.ninjay.kustcaixas.main.Main;
import me.ninjay.kustcaixas.utils.Mine;
import me.ninjay.kustlogs.estruturas.LogsAPI;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.md_5.bungee.api.chat.HoverEvent.Action;

public class CaixaControler implements Listener{
	
	private static HashMap<Player, Integer> save = new HashMap<>();
	
	public String convertItemStackToJsonRegular(ItemStack itemStack) {
	    // First we convert the item stack into an NMS itemstack
		net.minecraft.server.v1_8_R3.ItemStack nmsItemStack = CraftItemStack.asNMSCopy(itemStack);
	    NBTTagCompound compound = new NBTTagCompound();
	    compound = nmsItemStack.save(compound);

	    return compound.toString();
	}
	
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		if(e.getInventory().getTitle().equalsIgnoreCase("Abrindo caixa...")) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void aoInteragir(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		Caixa caixa = CaixaAPI.manager.getCaixaByIcone(p.getItemInHand());
		
		if(p.getItemInHand() != null) {
			if(caixa != null) {
				if(Mine.getEmptySlotsAmount(p.getInventory()) >= 18) {
				Mine.remove(p.getInventory(), caixa.getIcone(), 1);
				Inventory menu = Mine.newInventory("Abrindo caixa...", 9*3);
			new BukkitRunnable() {
				int timer = 30;
				@Override
				public void run() {
				timer--;
				p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
				for (int d = 0; d < 27; d++) {
					ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
					ItemMeta vidrom = vidro.getItemMeta();
					vidrom.setDisplayName("§eCaixa Misteriosa");
					vidro.setDurability((short) Mine.getRandomInt(1, 15));
					vidro.setItemMeta(vidrom);
					menu.setItem(d, vidro);
				}
				
				for(int i = 1; i <= Main.config.getInt("ItensTotal"); i++) {
					if(Main.itens.getString("Itens."+i+".caixa").equalsIgnoreCase(caixa.getName())) {
					ItemStack item = Mine.newItem(Main.itens.getInt("Itens."+i+".id"), Main.itens.getString("Itens."+i+".nome").replace("&", "§"), Main.itens.getInt("Itens."+i+".amount"), Main.itens.getInt("Itens."+i+".data"));
					for(int ie = 0; ie <= 51; ie++) {
					if(Main.itens.contains("Itens.Enchants."+i+"."+ie)) {
						if(Main.itens.getInt("Itens.Enchants."+i+"."+ie) > 0) {
							Mine.addEnchant(item, Enchantment.getById(ie), Main.itens.getInt("Itens.Enchants."+i+"."+ie));
						}
					}
				}
				if(Main.itens.getString("Itens."+i+".caixa").equalsIgnoreCase(caixa.getName())) {
					if(Mine.getChance(Main.itens.getDouble("Itens."+i+".chance")) == true) {
						menu.setItem(Mine.getPosition(2, 5), item);
					}
				}
					
					if(Mine.getChance(Main.itens.getDouble("Itens."+i+".chance")) == false) {
						int ir = Mine.getRandomInt(1, Main.config.getInt("ItensTotal"));
					if(Main.itens.getString("Itens."+ir+".caixa").equalsIgnoreCase(caixa.getName())) {
						ItemStack item2 = Mine.newItem(Main.itens.getInt("Itens."+ir+".id"), Main.itens.getString("Itens."+ir+".nome").replace("&", "§"), Main.itens.getInt("Itens."+ir+".amount"), Main.itens.getInt("Itens."+ir+".data"));
						for(int ie = 0; ie <= 51; ie++) {
						if(Main.itens.contains("Itens.Enchants."+ir+"."+ie)) {
							if(Main.itens.getInt("Itens.Enchants."+ir+"."+ie) > 0) {
								Mine.addEnchant(item2, Enchantment.getById(ie), Main.itens.getInt("Itens.Enchants."+ir+"."+ie));
							}
						}
					}
						menu.setItem(Mine.getPosition(2, 5), item2);
					}
					}
					}
			}
				
				if(timer <= 0) {
					cancel();
					ItemStack premio = menu.getItem(Mine.getPosition(2, 5));
					for(int i = 1; i <= Main.config.getInt("ItensTotal"); i++) { 
						if(Main.itens.getInt("Itens."+i+".id") == premio.getTypeId()) {
							if(Main.itens.getInt("Itens."+i+".amount") == premio.getAmount()) {
								if(Main.itens.getString("Itens."+i+".caixa").equalsIgnoreCase(caixa.getName())) {
									if(Main.itens.getInt("Itens.Enchants."+i+".0") == premio.getEnchantmentLevel(Enchantment.getById(0)) && Main.itens.getInt("Itens.Enchants."+i+".2") == premio.getEnchantmentLevel(Enchantment.getById(2)) && Main.itens.getInt("Itens.Enchants."+i+".8") == premio.getEnchantmentLevel(Enchantment.getById(8)) && Main.itens.getInt("Itens.Enchants."+i+".16") == premio.getEnchantmentLevel(Enchantment.getById(16)) && Main.itens.getInt("Itens.Enchants."+i+".20") == premio.getEnchantmentLevel(Enchantment.getById(20)) && Main.itens.getInt("Itens.Enchants."+i+".21") == premio.getEnchantmentLevel(Enchantment.getById(21)) && Main.itens.getInt("Itens.Enchants."+i+".32") == premio.getEnchantmentLevel(Enchantment.getById(32)) && Main.itens.getInt("Itens.Enchants."+i+".33") == premio.getEnchantmentLevel(Enchantment.getById(33)) && Main.itens.getInt("Itens.Enchants."+i+".35") == premio.getEnchantmentLevel(Enchantment.getById(35)) && Main.itens.getInt("Itens.Enchants."+i+".48") == premio.getEnchantmentLevel(Enchantment.getById(48)) && Main.itens.getInt("Itens.Enchants."+i+".49") == premio.getEnchantmentLevel(Enchantment.getById(49)) && Main.itens.getInt("Itens.Enchants."+i+".50") == premio.getEnchantmentLevel(Enchantment.getById(50)) && Main.itens.getInt("Itens.Enchants."+i+".51") == premio.getEnchantmentLevel(Enchantment.getById(51)) && Main.itens.getInt("Itens.Enchants."+i+".34") == premio.getEnchantmentLevel(Enchantment.getById(34))) {
										if(Main.itens.getString("Itens."+i+".comando") == null) {
											save.remove(p);
											save.put(p, i);
											p.getInventory().addItem(premio);
											LogsAPI.register(p.getName(), p.getName()+" ganhou "+premio.getType()+" de nome "+premio.getItemMeta().getDisplayName()+" na caixa "+caixa.getName(), me.ninjay.kustlogs.main.Main.playerGeral);
										}else {
											save.remove(p);
											save.put(p, i);
											p.getServer().dispatchCommand(p.getServer().getConsoleSender(), Main.itens.getString("Itens."+i+".comando").replace("$player", p.getName()).replace("$amount", Mine.toString(premio.getAmount())));
											LogsAPI.register(p.getName(), p.getName()+" ganhou "+premio.getType()+" de nome "+premio.getItemMeta().getDisplayName()+" na caixa "+caixa.getName(), me.ninjay.kustlogs.main.Main.playerGeral);
										}
										}
								}
							}
						}
					}
					if(Main.config.getBoolean("Raridade."+Main.itens.getInt("Itens."+save.get(p)+".raridade")+".ativo") == true) {
						if(Main.config.getBoolean("Raridade."+Main.itens.getInt("Itens."+save.get(p)+".raridade")+".growl") == false) {
						for(Player todos : Bukkit.getOnlinePlayers()) {
							TextComponent texto = new TextComponent(TextComponent.fromLegacyText(Main.config.getString("Raridade."+Main.itens.getInt("Itens."+save.get(p)+".raridade")+".msg").replace("&", "§").replace("$player", p.getName()).replace("$nome", caixa.getNome())));
							texto.setHoverEvent(new HoverEvent(Action.SHOW_ITEM, new ComponentBuilder(convertItemStackToJsonRegular(premio)).create()));
							todos.spigot().sendMessage(texto);
						}
						}else {
							for(Player todos : Bukkit.getOnlinePlayers()) {
								todos.playSound(todos.getLocation(), Sound.ENDERDRAGON_GROWL, 1F, 1F);
								TextComponent texto = new TextComponent(TextComponent.fromLegacyText(Main.config.getString("Raridade."+Main.itens.getInt("Itens."+save.get(p)+".raridade")+".msg").replace("&", "§").replace("$player", p.getName()).replace("$nome", caixa.getNome())));
								texto.setHoverEvent(new HoverEvent(Action.SHOW_ITEM, new ComponentBuilder(convertItemStackToJsonRegular(premio)).create()));
								todos.spigot().sendMessage(texto);
							}
						}
					}
					
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					new BukkitRunnable() {
						
						@Override
						public void run() {
							p.getOpenInventory().close();
						}
					}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 3*20);
				}
				}
			}.runTaskTimer(Main.getPlugin(Main.class), 5, 5);
				p.openInventory(menu);
				//for(int i = 1; i <= Main.config.getInt("ItensTotal"); i++) {
				//	ItemStack item = Mine.newItem(Main.itens.getInt("Itens."+i+".id"), Main.itens.getString("Itens."+i+".nome").replace("&", "§"), Main.itens.getInt("Itens."+i+".amount"), Main.itens.getInt("Itens."+i+".data"));
				//	for(int ie = 0; ie <= 51; ie++) {
				//	if(Main.itens.contains("Itens.Enchants."+i+"."+ie)) {
					//	if(Main.itens.getInt("Itens.Enchants."+i+"."+ie) > 0) {
						//	Mine.addEnchant(item, Enchantment.getById(ie), Main.itens.getInt("Itens.Enchants."+i+"."+ie));
						//}
					//}
				//}
				//}
			}else {
				p.sendMessage("§cEsvazie seu inventário para abrir.");
			}
		}
		}
	}
}
