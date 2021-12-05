package me.ninjay.aureaup.estruturas;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.aureaup.main.Main;
import me.ninjay.aureaup.utils.BukkitConfig;
import me.ninjay.aureaup.utils.Mine;

public class ClassesAPI implements Listener {

	public static BukkitConfig config = Main.classes;
	private static ArrayList<Player> comeco = new ArrayList<>();
	private static Inventory menu = Bukkit.createInventory(null, InventoryType.HOPPER, "Escolha sua classe");
	public static ItemStack c1 = Mine.newItem(Material.DOUBLE_PLANT, "§eFinanceiro", 1, 0, " ", " §fCaracterísticas:",
			"  §7◆ Gera bitcoins 2x mais rápido", "  §7◆ Desbloqueia a categoria 'Finanças' na árvore de habilidades",
			"  §7◆ Seu limite de depósito no banco aumenta +1kk");
	public static ItemStack c2 = Mine.newItem(Material.ANVIL, "§eMecânico", 1, 0, " ", " §fCaracterísticas:",
			"  §7◆ Recebe o dobro de peças minerando",
			"  §7◆ Desbloqueia a categoria 'Mecânica' na árvore de habilidades", "  §7◆ Reparos serão 2x mais rápidos");
	public static ItemStack c3 = Mine.newItem(Material.MAGMA_CREAM, "§eHacker", 1, 0, " ", " §fCaracterísticas:",
			"  §7◆ Recebe o dobro de bitcoins", "  §7◆ Desbloqueia a categoria 'Hackeamento' na árvore de habilidades",
			"  §7◆ Poderá hackear caixas eletrônicos");

	public static void aoEntrar(Player p) {
		int i = config.getInt(p.getName() + ".join");

		if (i == 0) {
			config.set(p.getName() + ".join", 1);
			config.saveConfig();

			menu.setItem(1, c1);
			menu.setItem(2, c2);
			menu.setItem(3, c3);

			comeco.add(p);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999, 200, false, false));
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 200, false, false));

			new BukkitRunnable() {
				int i = 120;

				@Override
				public void run() {
					i--;
					if (i == 119) {
						p.getWorld().playSound(p.getLocation(), Sound.SHOOT_ARROW, 1F, 1F);
						p.sendMessage("§a\n Parece que você é novo por aqui, então seja bem vindo!\n ");
					}
					if (i == 115) {
						p.getWorld().playSound(p.getLocation(), Sound.SHOOT_ARROW, 1F, 1F);
						p.sendMessage("§a\n No mundo Aurea você irá passar por muitas aventuras...\n ");
					}
					if (i == 110) {
						p.getWorld().playSound(p.getLocation(), Sound.SHOOT_ARROW, 1F, 1F);
						p.sendMessage(
								"§a\n mas antes de iniciar sua aventura será necessário escolher uma classe...\n ");
					}
					if (i == 105) {
						p.getWorld().playSound(p.getLocation(), Sound.SHOOT_ARROW, 1F, 1F);
						p.sendMessage("§a\n cada classe possui seus detalhes e características únicas...\n ");
					}
					if (i == 100) {
						p.getWorld().playSound(p.getLocation(), Sound.SHOOT_ARROW, 1F, 1F);
						p.sendMessage(
								"§a\n leia atentamente as características de cada uma para fazer a sua melhor escolha...\n ");
					}
					if (i == 95) {
						p.getWorld().playSound(p.getLocation(), Sound.SHOOT_ARROW, 1F, 1F);
						p.sendMessage("§a\n e se caso após escolher sua classe você tiver alguma dúvida...\n ");
					}
					if (i == 90) {
						p.getWorld().playSound(p.getLocation(), Sound.SHOOT_ARROW, 1F, 1F);
						p.sendMessage(
								"§a\n digite /ajuda, lá você irá poder ver tutorias, tirar dúvidas com o Guia ou até mesmo com um membro da equipe...\n ");
					}
					if (i == 85) {
						p.getWorld().playSound(p.getLocation(), Sound.SHOOT_ARROW, 1F, 1F);
						p.sendMessage(
								"§a\n então por enquanto é isso, desejo uma boa sorte e um bom jogo em sua jornada !\n ");
						i = 5;
					}
					if (i == 0) {
						cancel();
						p.getWorld().playSound(p.getLocation(), Sound.CHEST_OPEN, 1F, 1F);
						p.openInventory(menu);
					}
				}
			}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
		} else {
			return;
		}
	}

	@EventHandler
	public static void aoFechar(InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer();
		if (comeco.contains(p)) {
			new BukkitRunnable() {

				@Override
				public void run() {
					if (e.getInventory().getTitle().equals("Escolha sua classe") || e.getInventory().getTitle().equals("Certeza ?")) {
						p.openInventory(menu);
						p.sendMessage("§cEscolha uma classe antes de fechar o inventário.");
					} else {
						return;
					}
				}
			}.runTaskLater(Main.getPlugin(Main.class), 1);
		}

	}

	@EventHandler
	public static void aoComando(PlayerCommandPreprocessEvent e) {
		if (comeco.contains(e.getPlayer())) {
			e.setCancelled(true);
			e.getPlayer().sendMessage("§cComandos desabilitados no tutorial inicial.");
		}
	}

	@EventHandler
	public static void aoFalar(AsyncPlayerChatEvent e) {
		if (comeco.contains(e.getPlayer())) {
			e.setCancelled(true);
			e.getPlayer().sendMessage("§cCanais de texto desabilitados no tutorial inicial.");
		}
	}

	@EventHandler
	public static void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
	 
		Inventory conf = Mine.newInventory("Certeza ?", 9*3);
		ItemStack s = Mine.newItem(Material.STAINED_GLASS_PANE, "§aSim, eu tenho certeza.", 1, 5);
		ItemStack n = Mine.newItem(Material.STAINED_GLASS_PANE, "§cNão, eu quero trocar.", 1, 14);
		
		if(e.getInventory().getTitle().equals("Escolha sua classe")) {
			if(e.getCurrentItem().isSimilar(c1) || e.getCurrentItem().isSimilar(c2) || e.getCurrentItem().isSimilar(c3)) {
				if(e.getCurrentItem() != null) {
			    e.setCancelled(true);
				conf.setItem(Mine.getPosition(2, 3), s);
				conf.setItem(Mine.getPosition(2, 7), n);
				conf.setItem(Mine.getPosition(2, 5), e.getCurrentItem());
				
				comeco.remove(p);
				p.getOpenInventory().close();
				comeco.add(p);
				p.openInventory(conf);
				
				
			}
			}
		}
		if(e.getInventory().getTitle().equals("Certeza ?")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(n)) {
				comeco.remove(p);
				p.getOpenInventory().close();
				comeco.add(p);
				p.openInventory(menu);
				return;
			}
			if(e.getInventory().contains(c1)) {
				if(e.getCurrentItem().isSimilar(s)) {
					comeco.remove(p);
					p.getOpenInventory().close();
					Mine.sendTitle("§a§lFinanceiro", "§aClasse selecionada com sucesso.", 5, 50, 5);
				    config.set(p.getName()+".classe", "financeiro");
				    config.saveConfig();
				    p.removePotionEffect(PotionEffectType.JUMP);
				    p.removePotionEffect(PotionEffectType.SLOW);
				}
			}
			if(e.getInventory().contains(c2)) {
				if(e.getCurrentItem().isSimilar(s)) {
					comeco.remove(p);
					p.getOpenInventory().close();
					Mine.sendTitle("§a§lMecânico", "§aClasse selecionada com sucesso.", 5, 50, 5);
					config.set(p.getName()+".classe", "mecanico");
				    config.saveConfig();
				    p.removePotionEffect(PotionEffectType.JUMP);
				    p.removePotionEffect(PotionEffectType.SLOW);
				}
			}
			if(e.getInventory().contains(c3)) {
				if(e.getCurrentItem().isSimilar(s)) {
					comeco.remove(p);
					p.getOpenInventory().close();
					Mine.sendTitle("§a§lHacker", "§aClasse selecionada com sucesso.", 5, 50, 5);
					config.set(p.getName()+".classe", "hacker");
				    config.saveConfig();
				    p.removePotionEffect(PotionEffectType.JUMP);
				    p.removePotionEffect(PotionEffectType.SLOW);
				}
			}
		}
	}

}
