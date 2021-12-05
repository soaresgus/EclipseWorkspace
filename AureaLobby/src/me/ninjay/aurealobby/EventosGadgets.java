package me.ninjay.aurealobby;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EventosGadgets implements Listener {

	@EventHandler
	public void clicar(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		ItemStack menu = new ItemStack(Material.NAME_TAG);
		ItemMeta menum = menu.getItemMeta();
		menum.setDisplayName("§eGadgets");
		menum.setLore(Arrays.asList(" ", "§7Utilize para se divertir dentro do lobby"));
		menu.setItemMeta(menum);

		if (!p.getItemInHand().isSimilar(menu)) {
			return;
		}
		if (p.getItemInHand().isSimilar(menu) && p.hasPermission("membro.tag")) {
			e.setCancelled(true);
			p.sendMessage(
					"§eApenas jogadores vips podem utilizar os gadgets.\n \nAdquira seu vip em nossa loja:\n§bhttps://loja.redeaurea.com");
			return;
		}
		if (p.getItemInHand().isSimilar(menu) && p.hasPermission("master.tag") || p.hasPermission("gerente.tag")
				|| p.hasPermission("admin.tag") || p.hasPermission("moderador.tag") || p.hasPermission("ajudante.tag")
				|| p.hasPermission("construtor.tag") || p.hasPermission("youtuber.tag") || p.hasPermission("galaxy.tag")
				|| p.hasPermission("meteor.tag") || p.hasPermission("moon.tag")) {
			e.setCancelled(true);
			Inventory gad = Bukkit.createInventory(null, 9 * 4, "Gadgets");

			ItemStack fly = new ItemStack(Material.FEATHER);
			ItemMeta flym = fly.getItemMeta();
			flym.setDisplayName("§eFly");
			flym.setLore(Arrays.asList(" ", "§7Seja livre e voe pelo lobby !"));
			fly.setItemMeta(flym);

			ItemStack mac = new ItemStack(Material.IRON_AXE);
			ItemMeta macm = mac.getItemMeta();
			macm.setDisplayName("§eMachado de thor");
			macm.setLore(Arrays.asList(" ", "§7Vire o thor e solte raios pelo mapa !"));
			mac.setItemMeta(macm);

			ItemStack pvp = new ItemStack(Material.DIAMOND_CHESTPLATE);
			ItemMeta pvpm = pvp.getItemMeta();
			pvpm.setDisplayName("§eArena PvP");
			pvpm.setLore(Arrays.asList(" ", "§7Lute enquanto o servidor não abre !"));
			pvp.setItemMeta(pvpm);

			ItemStack sair = new ItemStack(Material.ARROW);
			ItemMeta sairm = sair.getItemMeta();
			sairm.setDisplayName("§aFechar menu");
			sair.setItemMeta(sairm);

			gad.setItem(10, fly);
			gad.setItem(13, mac);
			gad.setItem(16, pvp);
			gad.setItem(31, sair);
			p.openInventory(gad);
			return;
		}

	}

	@EventHandler
	public void aoClicarNoSair(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		ItemStack sair = new ItemStack(Material.ARROW);
		ItemMeta sairm = sair.getItemMeta();
		sairm.setDisplayName("§aFechar menu");
		sair.setItemMeta(sairm);

		if (e.getInventory().getTitle().equals("Gadgets")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(sair)) {
				p.getOpenInventory().close();
				return;
			}
		}
	}

	@EventHandler
	public void aoClicarNoFlyNoGui(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		ItemStack fly = new ItemStack(Material.FEATHER);
		ItemMeta flym = fly.getItemMeta();
		flym.setDisplayName("§eFly");
		flym.setLore(Arrays.asList(" ", "§7Seja livre e voe pelo lobby !"));
		fly.setItemMeta(flym);

		ItemStack sem = new ItemStack(Material.INK_SACK, 1, (short) 1);
		ItemMeta semm = sem.getItemMeta();
		semm.setDisplayName("§cNenhum gadget selecionado");
		semm.setLore(Arrays.asList(" ", "§cPara selecionar um gadget clique no item §eGadgets"));
		sem.setItemMeta(semm);

		ItemStack mac = new ItemStack(Material.IRON_AXE);
		ItemMeta macm = mac.getItemMeta();
		macm.setDisplayName("§eMachado de thor");
		macm.setLore(Arrays.asList(" ", "§7Vire o thor e solte raios pelo mapa !"));
		mac.setItemMeta(macm);

		ItemStack pis = new ItemStack(Material.GOLD_HOE);
		ItemMeta pism = pis.getItemMeta();
		pism.setDisplayName("§ePistolinha");
		pism.setLore(Arrays.asList(" ", "§7Seja um pistoleiro dentro do jogo !"));
		pis.setItemMeta(pism);

		if (e.getInventory().getTitle().equals("Gadgets")) {
			if (e.getCurrentItem().isSimilar(fly)) {
				p.getInventory().remove(sem);
				p.getInventory().remove(mac);
				p.getInventory().remove(pis);
				p.getInventory().remove(fly);
				p.getOpenInventory().close();
				p.getInventory().setItem(2, fly);
				return;

			}
		}

	}

	@EventHandler
	public void aoClicarNoFlyForaDaGui(PlayerInteractEvent e) {
		Player p = (Player) e.getPlayer();

		ItemStack fly = new ItemStack(Material.FEATHER);
		ItemMeta flym = fly.getItemMeta();
		flym.setDisplayName("§eFly");
		flym.setLore(Arrays.asList(" ", "§7Seja livre e voe pelo lobby !"));
		fly.setItemMeta(flym);

		if (!p.getItemInHand().isSimilar(fly)) {
			return;
		}
		if (p.getItemInHand().isSimilar(fly) && !p.hasPermission("fly.on")) {
			p.sendMessage("§aFly ativado !\n \nPara desativar clique no item novamente.");
			p.setAllowFlight(true);
			Main.permission.playerAdd(p, "fly.on");
			return;
		}
		if (p.getItemInHand().isSimilar(fly) && p.hasPermission("fly.on")) {
			p.chat("/flyoff");
			return;
		}

	}

	@EventHandler
	public void aoClicarNoThorNaGui(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		ItemStack fly = new ItemStack(Material.FEATHER);
		ItemMeta flym = fly.getItemMeta();
		flym.setDisplayName("§eFly");
		flym.setLore(Arrays.asList(" ", "§7Seja livre e voe pelo lobby !"));
		fly.setItemMeta(flym);

		ItemStack sem = new ItemStack(Material.INK_SACK, 1, (short) 1);
		ItemMeta semm = sem.getItemMeta();
		semm.setDisplayName("§cNenhum gadget selecionado");
		semm.setLore(Arrays.asList(" ", "§cPara selecionar um gadget clique no item §eGadgets"));
		sem.setItemMeta(semm);

		ItemStack mac = new ItemStack(Material.IRON_AXE);
		ItemMeta macm = mac.getItemMeta();
		macm.setDisplayName("§eMachado de thor");
		macm.setLore(Arrays.asList(" ", "§7Vire o thor e solte raios pelo mapa !"));
		mac.setItemMeta(macm);

		ItemStack pis = new ItemStack(Material.GOLD_HOE);
		ItemMeta pism = pis.getItemMeta();
		pism.setDisplayName("§ePistolinha");
		pism.setLore(Arrays.asList(" ", "§7Seja um pistoleiro dentro do jogo !"));
		pis.setItemMeta(pism);

		if (e.getInventory().getTitle().equals("Gadgets")) {
			if (e.getCurrentItem().isSimilar(mac)) {
				p.getInventory().remove(sem);
				p.getInventory().remove(mac);
				p.getInventory().remove(pis);
				p.getInventory().remove(fly);
				p.getOpenInventory().close();
				p.getInventory().setItem(2, mac);
				return;

			}
		}

	}

	@EventHandler
	public void aoClicarNoThorForaDaGui(PlayerInteractEvent e) {
		Player p = (Player) e.getPlayer();
        
		ItemStack mac = new ItemStack(Material.IRON_AXE);
		ItemMeta macm = mac.getItemMeta();
		macm.setDisplayName("§eMachado de thor");
		macm.setLore(Arrays.asList(" ", "§7Vire o thor e solte raios pelo mapa !"));
		mac.setItemMeta(macm);
		
		if(p.getItemInHand().isSimilar(mac)) {
			p.chat("/thor");
		}
		
	}
	@EventHandler
	public void aoClicarNoPvPDentroDaGui(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		ItemStack pvp = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta pvpm = pvp.getItemMeta();
		pvpm.setDisplayName("§eArena PvP");
		pvpm.setLore(Arrays.asList(" ", "§7Lute enquanto o servidor não abre !"));
		pvp.setItemMeta(pvpm);
		
		if(e.getInventory().getTitle().equals("Gadgets")) {
			if(e.getCurrentItem().isSimilar(pvp)) {
				p.chat("/pvp");
				p.getOpenInventory().close();
				
			}
		}
		
	
}
}