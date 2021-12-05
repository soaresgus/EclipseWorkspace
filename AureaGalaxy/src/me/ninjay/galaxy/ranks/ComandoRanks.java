package me.ninjay.galaxy.ranks;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ComandoRanks implements CommandExecutor, Listener {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		if (cmd.getName().equalsIgnoreCase("ranks")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("§6§lApenas Players !");
			} else {
				Player p = (Player) sender;
				if (p.hasPermission("ranks.use")) {
					Inventory ranks = Bukkit.createInventory(null, 9 * 4, "Ranks");
					ItemStack inf = new ItemStack(Material.WOOL, 1, (short) 14);
					ItemMeta infm = inf.getItemMeta();
					infm.setDisplayName("§c§lRanks Infernais");
					infm.setLore(Arrays.asList("§7Veja os ranks da classificação §c§lInfernal"));
					inf.setItemMeta(infm);

					ItemStack ter = new ItemStack(Material.WOOL, 1, (short) 13);
					ItemMeta term = ter.getItemMeta();
					term.setDisplayName("§a§lRanks Terráqueos");
					term.setLore(Arrays.asList("§7Veja os ranks da classificação §a§lTerráqueo"));
					ter.setItemMeta(term);

					ItemStack ang = new ItemStack(Material.WOOL, 1, (short) 3);
					ItemMeta angm = ang.getItemMeta();
					angm.setDisplayName("§b§lRanks Angelicais");
					angm.setLore(Arrays.asList("§7Veja os ranks da classificação §b§lAngelical"));
					ang.setItemMeta(angm);

					ItemStack esp = new ItemStack(Material.WOOL, 1, (short) 8);
					ItemMeta espm = esp.getItemMeta();
					espm.setDisplayName("§5§lRanks Espaciais");
					espm.setLore(Arrays.asList("§7Veja os ranks da classificação §5§lEspacial"));
					esp.setItemMeta(espm);

					ItemStack sair = new ItemStack(Material.ARROW);
					ItemMeta sairm = sair.getItemMeta();
					sairm.setDisplayName("§aFechar menu");
					sair.setItemMeta(sairm);

					ranks.setItem(10, inf);
					ranks.setItem(12, ter);
					ranks.setItem(14, ang);
					ranks.setItem(16, esp);
					ranks.setItem(31, sair);
					p.openInventory(ranks);
				}
			}
		}
		return false;
	}

	
	@EventHandler
	public void clicarinf(InventoryClickEvent e) {
		if(e.getWhoClicked() instanceof Player) {
			
		
		Player p = (Player) e.getWhoClicked();

		ItemStack inf = new ItemStack(Material.WOOL, 1, (short) 14);
		ItemMeta infm = inf.getItemMeta();
		infm.setDisplayName("§c§lRanks Infernais");
		infm.setLore(Arrays.asList("§7Veja os ranks da classificação §c§lInfernal"));
		inf.setItemMeta(infm);
		Inventory infmen = Bukkit.createInventory(null, 9 * 6, "Ranks Infernais");
		
		//rank começo
		
		ItemStack esc3 = new ItemStack(Material.WOOL, 1, (short) 7);
		ItemMeta esc3m = esc3.getItemMeta();
		esc3m.setDisplayName("§c§lEscravo III");
		esc3.setItemMeta(esc3m);
		
		ItemStack esc2 = new ItemStack(Material.WOOL, 1, (short) 7);
		ItemMeta esc2m = esc2.getItemMeta();
		esc2m.setDisplayName("§c§lEscravo II");
		esc2.setItemMeta(esc2m);
		
		ItemStack esc1 = new ItemStack(Material.WOOL, 1, (short) 7);
		ItemMeta esc1m = esc1.getItemMeta();
		esc1m.setDisplayName("§c§lEscravo I");
		esc1.setItemMeta(esc1m);
		
		//rank final
		
		//rank começo
		
		ItemStack mal3 = new ItemStack(Material.WOOL, 1, (short) 8);
		ItemMeta mal3m = mal3.getItemMeta();
		mal3m.setDisplayName("§c§lMaldito III");
		mal3.setItemMeta(mal3m);
		
		ItemStack mal2 = new ItemStack(Material.WOOL, 1, (short) 8);
		ItemMeta mal2m = mal2.getItemMeta();
		mal2m.setDisplayName("§c§lMaldito II");
		mal2.setItemMeta(mal2m);
		
		ItemStack mal1 = new ItemStack(Material.WOOL, 1, (short) 8);
		ItemMeta mal1m = mal1.getItemMeta();
		mal1m.setDisplayName("§c§lMaldito I");
		mal1.setItemMeta(mal1m);
		
		//rank final
		
	//rank começo
		
		ItemStack as3 = new ItemStack(Material.WOOL, 1, (short) 10);
		ItemMeta as3m = as3.getItemMeta();
		as3m.setDisplayName("§c§lAssistente III");
		as3.setItemMeta(as3m);
		
		ItemStack as2 = new ItemStack(Material.WOOL, 1, (short) 10);
		ItemMeta as2m = as2.getItemMeta();
		as2m.setDisplayName("§c§lAssistente II");
		as2.setItemMeta(as2m);
		
		ItemStack as1 = new ItemStack(Material.WOOL, 1, (short) 10);
		ItemMeta as1m = as1.getItemMeta();
		as1m.setDisplayName("§c§lAssistente I");
		as1.setItemMeta(as1m);
		
		//rank final
		
	//rank começo
		
		ItemStack cei3 = new ItemStack(Material.WOOL, 1, (short) 11);
		ItemMeta cei3m = cei3.getItemMeta();
		cei3m.setDisplayName("§c§lCeifador III");
		cei3.setItemMeta(cei3m);
		
		ItemStack cei2 = new ItemStack(Material.WOOL, 1, (short) 11);
		ItemMeta cei2m = cei2.getItemMeta();
		cei2m.setDisplayName("§c§lCeifador II");
		cei2.setItemMeta(cei2m);
		
		ItemStack cei1 = new ItemStack(Material.WOOL, 1, (short) 11);
		ItemMeta cei1m = cei1.getItemMeta();
		cei1m.setDisplayName("§c§lCeifador I");
		cei1.setItemMeta(cei1m);
		
		//rank final
		
	//rank começo
		
		ItemStack dem3 = new ItemStack(Material.WOOL, 1, (short) 14);
		ItemMeta dem3m = dem3.getItemMeta();
		dem3m.setDisplayName("§c§lDemônio III");
		dem3.setItemMeta(dem3m);
		
		ItemStack dem2 = new ItemStack(Material.WOOL, 1, (short) 14);
		ItemMeta dem2m = dem2.getItemMeta();
		dem2m.setDisplayName("§c§lDemônio II");
		dem2.setItemMeta(dem2m);
		
		ItemStack dem1 = new ItemStack(Material.WOOL, 1, (short) 14);
		ItemMeta dem1m = dem1.getItemMeta();
		dem1m.setDisplayName("§c§lDemônio I");
		dem1.setItemMeta(dem1m);
		
		//rank final
		
		ItemStack sair = new ItemStack(Material.ARROW);
		ItemMeta sairm = sair.getItemMeta();
		sairm.setDisplayName("§aFechar menu");
		sair.setItemMeta(sairm);

		if (e.getInventory().getTitle().equals("Ranks")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(inf)) {
				
                infmen.setItem(11, esc3);
                infmen.setItem(20, esc2);
                infmen.setItem(29, esc1);
                
                infmen.setItem(12, mal3);
                infmen.setItem(21, mal2);
                infmen.setItem(30, mal1);
                
                infmen.setItem(13, as3);
                infmen.setItem(22, as2);
                infmen.setItem(31, as1);
                
                infmen.setItem(14, cei3);
                infmen.setItem(23, cei2);
                infmen.setItem(32, cei1);
                
                infmen.setItem(15, dem3);
                infmen.setItem(24, dem2);
                infmen.setItem(33, dem1);
                
                infmen.setItem(49, sair);
                
				p.openInventory(infmen);
				
				return;
			}
			}
		}
		}
		
	

		@EventHandler
		public void clicarv2(InventoryClickEvent e) {
			if(e.getWhoClicked() instanceof Player) {
			Player p = (Player) e.getWhoClicked();

			ItemStack sair = new ItemStack(Material.ARROW);
			ItemMeta sairm = sair.getItemMeta();
			sairm.setDisplayName("§aFechar menu");
			sair.setItemMeta(sairm);

			if (e.getInventory().getTitle().equals("Ranks")) {
				if (e.getCurrentItem().isSimilar(sair)) {
					
				
					
				p.getOpenInventory().close();
				return;
		
			}
			}
			}
		}

@EventHandler
public void clicarsairinf(InventoryClickEvent e) {
	if(e.getWhoClicked() instanceof Player) {
	Player p = (Player) e.getWhoClicked();

	ItemStack sair = new ItemStack(Material.ARROW);
	ItemMeta sairm = sair.getItemMeta();
	sairm.setDisplayName("§aFechar menu");
	sair.setItemMeta(sairm);

	if (e.getInventory().getTitle().equals("Ranks Infernais")) {
		e.setCancelled(true);
		if (e.getCurrentItem().isSimilar(sair)) {
			
		
			
		p.getOpenInventory().close();
		return;
		}
	}
	}
}

@EventHandler
public void clicarter(InventoryClickEvent e) {
	if(e.getWhoClicked() instanceof Player) {
		
	
	Player p = (Player) e.getWhoClicked();

	ItemStack ter = new ItemStack(Material.WOOL, 1, (short) 13);
	ItemMeta term = ter.getItemMeta();
	term.setDisplayName("§a§lRanks Terráqueos");
	term.setLore(Arrays.asList("§7Veja os ranks da classificação §a§lTerráqueo"));
	ter.setItemMeta(term);
	Inventory infmen = Bukkit.createInventory(null, 9 * 6, "Ranks Terráqueos");
	
	//rank começo
	
	ItemStack esc3 = new ItemStack(Material.WOOL, 1, (short) 7);
	ItemMeta esc3m = esc3.getItemMeta();
	esc3m.setDisplayName("§a§lMendigo III");
	esc3.setItemMeta(esc3m);
	
	ItemStack esc2 = new ItemStack(Material.WOOL, 1, (short) 7);
	ItemMeta esc2m = esc2.getItemMeta();
	esc2m.setDisplayName("§a§lMendigo II");
	esc2.setItemMeta(esc2m);
	
	ItemStack esc1 = new ItemStack(Material.WOOL, 1, (short) 7);
	ItemMeta esc1m = esc1.getItemMeta();
	esc1m.setDisplayName("§a§lMendigo I");
	esc1.setItemMeta(esc1m);
	
	//rank final
	
	//rank começo
	
	ItemStack mal3 = new ItemStack(Material.WOOL, 1, (short) 8);
	ItemMeta mal3m = mal3.getItemMeta();
	mal3m.setDisplayName("§a§lTrabalhador III");
	mal3.setItemMeta(mal3m);
	
	ItemStack mal2 = new ItemStack(Material.WOOL, 1, (short) 8);
	ItemMeta mal2m = mal2.getItemMeta();
	mal2m.setDisplayName("§a§lTrabalhador II");
	mal2.setItemMeta(mal2m);
	
	ItemStack mal1 = new ItemStack(Material.WOOL, 1, (short) 8);
	ItemMeta mal1m = mal1.getItemMeta();
	mal1m.setDisplayName("§a§lTrabalhador I");
	mal1.setItemMeta(mal1m);
	
	//rank final
	
//rank começo
	
	ItemStack as3 = new ItemStack(Material.WOOL, 1, (short) 10);
	ItemMeta as3m = as3.getItemMeta();
	as3m.setDisplayName("§a§lEmpresário III");
	as3.setItemMeta(as3m);
	
	ItemStack as2 = new ItemStack(Material.WOOL, 1, (short) 10);
	ItemMeta as2m = as2.getItemMeta();
	as2m.setDisplayName("§a§lEmpresário II");
	as2.setItemMeta(as2m);
	
	ItemStack as1 = new ItemStack(Material.WOOL, 1, (short) 10);
	ItemMeta as1m = as1.getItemMeta();
	as1m.setDisplayName("§a§lEmpresário I");
	as1.setItemMeta(as1m);
	
	//rank final
	
//rank começo
	
	ItemStack cei3 = new ItemStack(Material.WOOL, 1, (short) 11);
	ItemMeta cei3m = cei3.getItemMeta();
	cei3m.setDisplayName("§a§lGovernador III");
	cei3.setItemMeta(cei3m);
	
	ItemStack cei2 = new ItemStack(Material.WOOL, 1, (short) 11);
	ItemMeta cei2m = cei2.getItemMeta();
	cei2m.setDisplayName("§a§lGovernador II");
	cei2.setItemMeta(cei2m);
	
	ItemStack cei1 = new ItemStack(Material.WOOL, 1, (short) 11);
	ItemMeta cei1m = cei1.getItemMeta();
	cei1m.setDisplayName("§a§lGovernador I");
	cei1.setItemMeta(cei1m);
	
	//rank final
	
//rank começo
	
	ItemStack dem3 = new ItemStack(Material.WOOL, 1, (short) 14);
	ItemMeta dem3m = dem3.getItemMeta();
	dem3m.setDisplayName("§a§lPresidente III");
	dem3.setItemMeta(dem3m);
	
	ItemStack dem2 = new ItemStack(Material.WOOL, 1, (short) 14);
	ItemMeta dem2m = dem2.getItemMeta();
	dem2m.setDisplayName("§a§lPresidente II");
	dem2.setItemMeta(dem2m);
	
	ItemStack dem1 = new ItemStack(Material.WOOL, 1, (short) 14);
	ItemMeta dem1m = dem1.getItemMeta();
	dem1m.setDisplayName("§a§lPresidente I");
	dem1.setItemMeta(dem1m);
	
	//rank final
	
	ItemStack sair = new ItemStack(Material.ARROW);
	ItemMeta sairm = sair.getItemMeta();
	sairm.setDisplayName("§aFechar menu");
	sair.setItemMeta(sairm);

	if (e.getInventory().getTitle().equals("Ranks")) {
		e.setCancelled(true);
		if (e.getCurrentItem().isSimilar(ter)) {
			
            infmen.setItem(11, esc3);
            infmen.setItem(20, esc2);
            infmen.setItem(29, esc1);
            
            infmen.setItem(12, mal3);
            infmen.setItem(21, mal2);
            infmen.setItem(30, mal1);
            
            infmen.setItem(13, as3);
            infmen.setItem(22, as2);
            infmen.setItem(31, as1);
            
            infmen.setItem(14, cei3);
            infmen.setItem(23, cei2);
            infmen.setItem(32, cei1);
            
            infmen.setItem(15, dem3);
            infmen.setItem(24, dem2);
            infmen.setItem(33, dem1);
            
            infmen.setItem(49, sair);
            
			p.openInventory(infmen);
			
			return;
		}
		}
	}
	}
	



@EventHandler
public void clicarsairter(InventoryClickEvent e) {
if(e.getWhoClicked() instanceof Player) {
Player p = (Player) e.getWhoClicked();

ItemStack sair = new ItemStack(Material.ARROW);
ItemMeta sairm = sair.getItemMeta();
sairm.setDisplayName("§aFechar menu");
sair.setItemMeta(sairm);

if (e.getInventory().getTitle().equals("Ranks Terráqueos")) {
	e.setCancelled(true);
	if (e.getCurrentItem().isSimilar(sair)) {
		
	
		
	p.getOpenInventory().close();
	return;
	}
}
}
}

@EventHandler
public void clicarang(InventoryClickEvent e) {
	if(e.getWhoClicked() instanceof Player) {
		
	
	Player p = (Player) e.getWhoClicked();

	ItemStack ang = new ItemStack(Material.WOOL, 1, (short) 3);
	ItemMeta angm = ang.getItemMeta();
	angm.setDisplayName("§b§lRanks Angelicais");
	angm.setLore(Arrays.asList("§7Veja os ranks da classificação §b§lAngelical"));
	ang.setItemMeta(angm);
	Inventory infmen = Bukkit.createInventory(null, 9 * 6, "Ranks Angelicais");
	
	//rank começo
	
	ItemStack esc3 = new ItemStack(Material.WOOL, 1, (short) 7);
	ItemMeta esc3m = esc3.getItemMeta();
	esc3m.setDisplayName("§b§lServo III");
	esc3.setItemMeta(esc3m);
	
	ItemStack esc2 = new ItemStack(Material.WOOL, 1, (short) 7);
	ItemMeta esc2m = esc2.getItemMeta();
	esc2m.setDisplayName("§b§lServo II");
	esc2.setItemMeta(esc2m);
	
	ItemStack esc1 = new ItemStack(Material.WOOL, 1, (short) 7);
	ItemMeta esc1m = esc1.getItemMeta();
	esc1m.setDisplayName("§b§lServo I");
	esc1.setItemMeta(esc1m);
	
	//rank final
	
	//rank começo
	
	ItemStack mal3 = new ItemStack(Material.WOOL, 1, (short) 8);
	ItemMeta mal3m = mal3.getItemMeta();
	mal3m.setDisplayName("§b§lArcanjo III");
	mal3.setItemMeta(mal3m);
	
	ItemStack mal2 = new ItemStack(Material.WOOL, 1, (short) 8);
	ItemMeta mal2m = mal2.getItemMeta();
	mal2m.setDisplayName("§b§lArcanjo II");
	mal2.setItemMeta(mal2m);
	
	ItemStack mal1 = new ItemStack(Material.WOOL, 1, (short) 8);
	ItemMeta mal1m = mal1.getItemMeta();
	mal1m.setDisplayName("§b§lArcanjo I");
	mal1.setItemMeta(mal1m);
	
	//rank final
	
//rank começo
	
	ItemStack as3 = new ItemStack(Material.WOOL, 1, (short) 10);
	ItemMeta as3m = as3.getItemMeta();
	as3m.setDisplayName("§b§lPrincipado III");
	as3.setItemMeta(as3m);
	
	ItemStack as2 = new ItemStack(Material.WOOL, 1, (short) 10);
	ItemMeta as2m = as2.getItemMeta();
	as2m.setDisplayName("§b§lPrincipado II");
	as2.setItemMeta(as2m);
	
	ItemStack as1 = new ItemStack(Material.WOOL, 1, (short) 10);
	ItemMeta as1m = as1.getItemMeta();
	as1m.setDisplayName("§b§lPrincipado I");
	as1.setItemMeta(as1m);
	
	//rank final
	
//rank começo
	
	ItemStack cei3 = new ItemStack(Material.WOOL, 1, (short) 11);
	ItemMeta cei3m = cei3.getItemMeta();
	cei3m.setDisplayName("§b§lAnjo III");
	cei3.setItemMeta(cei3m);
	
	ItemStack cei2 = new ItemStack(Material.WOOL, 1, (short) 11);
	ItemMeta cei2m = cei2.getItemMeta();
	cei2m.setDisplayName("§b§lAnjo II");
	cei2.setItemMeta(cei2m);
	
	ItemStack cei1 = new ItemStack(Material.WOOL, 1, (short) 11);
	ItemMeta cei1m = cei1.getItemMeta();
	cei1m.setDisplayName("§b§lAnjo I");
	cei1.setItemMeta(cei1m);
	
	//rank final
	
//rank começo
	
	ItemStack dem3 = new ItemStack(Material.WOOL, 1, (short) 14);
	ItemMeta dem3m = dem3.getItemMeta();
	dem3m.setDisplayName("§b§lDeus III");
	dem3.setItemMeta(dem3m);
	
	ItemStack dem2 = new ItemStack(Material.WOOL, 1, (short) 14);
	ItemMeta dem2m = dem2.getItemMeta();
	dem2m.setDisplayName("§b§lDeus II");
	dem2.setItemMeta(dem2m);
	
	ItemStack dem1 = new ItemStack(Material.WOOL, 1, (short) 14);
	ItemMeta dem1m = dem1.getItemMeta();
	dem1m.setDisplayName("§b§lDeus I");
	dem1.setItemMeta(dem1m);
	
	//rank final
	
	ItemStack sair = new ItemStack(Material.ARROW);
	ItemMeta sairm = sair.getItemMeta();
	sairm.setDisplayName("§aFechar menu");
	sair.setItemMeta(sairm);

	if (e.getInventory().getTitle().equals("Ranks")) {
		e.setCancelled(true);
		if (e.getCurrentItem().isSimilar(ang)) {
			
            infmen.setItem(11, esc3);
            infmen.setItem(20, esc2);
            infmen.setItem(29, esc1);
            
            infmen.setItem(12, mal3);
            infmen.setItem(21, mal2);
            infmen.setItem(30, mal1);
            
            infmen.setItem(13, as3);
            infmen.setItem(22, as2);
            infmen.setItem(31, as1);
            
            infmen.setItem(14, cei3);
            infmen.setItem(23, cei2);
            infmen.setItem(32, cei1);
            
            infmen.setItem(15, dem3);
            infmen.setItem(24, dem2);
            infmen.setItem(33, dem1);
            
            infmen.setItem(49, sair);
            
			p.openInventory(infmen);
			
			return;
		}
		}
	}
	}
	



@EventHandler
public void clicarsairang(InventoryClickEvent e) {
if(e.getWhoClicked() instanceof Player) {
Player p = (Player) e.getWhoClicked();

ItemStack sair = new ItemStack(Material.ARROW);
ItemMeta sairm = sair.getItemMeta();
sairm.setDisplayName("§aFechar menu");
sair.setItemMeta(sairm);

if (e.getInventory().getTitle().equals("Ranks Angelicais")) {
	e.setCancelled(true);
	if (e.getCurrentItem().isSimilar(sair)) {
		
	
		
	p.getOpenInventory().close();
	return;
	}
}
}
}


@EventHandler
public void clicaresp(InventoryClickEvent e) {
	if(e.getWhoClicked() instanceof Player) {
		
	
	Player p = (Player) e.getWhoClicked();

	ItemStack esp = new ItemStack(Material.WOOL, 1, (short) 8);
	ItemMeta espm = esp.getItemMeta();
	espm.setDisplayName("§5§lRanks Espaciais");
	espm.setLore(Arrays.asList("§7Veja os ranks da classificação §5§lEspacial"));
	esp.setItemMeta(espm);
	Inventory infmen = Bukkit.createInventory(null, 9 * 6, "Ranks Espaciais");
	
	//rank começo
	
	ItemStack esc3 = new ItemStack(Material.WOOL, 1, (short) 7);
	ItemMeta esc3m = esc3.getItemMeta();
	esc3m.setDisplayName("§5§lPesquisador III");
	esc3.setItemMeta(esc3m);
	
	ItemStack esc2 = new ItemStack(Material.WOOL, 1, (short) 7);
	ItemMeta esc2m = esc2.getItemMeta();
	esc2m.setDisplayName("§5§lPesquisador II");
	esc2.setItemMeta(esc2m);
	
	ItemStack esc1 = new ItemStack(Material.WOOL, 1, (short) 7);
	ItemMeta esc1m = esc1.getItemMeta();
	esc1m.setDisplayName("§5§lPesquisador I");
	esc1.setItemMeta(esc1m);
	
	//rank final
	
	//rank começo
	
	ItemStack mal3 = new ItemStack(Material.WOOL, 1, (short) 8);
	ItemMeta mal3m = mal3.getItemMeta();
	mal3m.setDisplayName("§5§lControlador III");
	mal3.setItemMeta(mal3m);
	
	ItemStack mal2 = new ItemStack(Material.WOOL, 1, (short) 8);
	ItemMeta mal2m = mal2.getItemMeta();
	mal2m.setDisplayName("§5§lControlador II");
	mal2.setItemMeta(mal2m);
	
	ItemStack mal1 = new ItemStack(Material.WOOL, 1, (short) 8);
	ItemMeta mal1m = mal1.getItemMeta();
	mal1m.setDisplayName("§5§lControlador I");
	mal1.setItemMeta(mal1m);
	
	//rank final
	
//rank começo
	
	ItemStack as3 = new ItemStack(Material.WOOL, 1, (short) 10);
	ItemMeta as3m = as3.getItemMeta();
	as3m.setDisplayName("§5§lComissário III");
	as3.setItemMeta(as3m);
	
	ItemStack as2 = new ItemStack(Material.WOOL, 1, (short) 10);
	ItemMeta as2m = as2.getItemMeta();
	as2m.setDisplayName("§5§lComissário II");
	as2.setItemMeta(as2m);
	
	ItemStack as1 = new ItemStack(Material.WOOL, 1, (short) 10);
	ItemMeta as1m = as1.getItemMeta();
	as1m.setDisplayName("§5§lComissário I");
	as1.setItemMeta(as1m);
	
	//rank final
	
//rank começo
	
	ItemStack cei3 = new ItemStack(Material.WOOL, 1, (short) 11);
	ItemMeta cei3m = cei3.getItemMeta();
	cei3m.setDisplayName("§5§lAstronauta III");
	cei3.setItemMeta(cei3m);
	
	ItemStack cei2 = new ItemStack(Material.WOOL, 1, (short) 11);
	ItemMeta cei2m = cei2.getItemMeta();
	cei2m.setDisplayName("§5§lAstronauta II");
	cei2.setItemMeta(cei2m);
	
	ItemStack cei1 = new ItemStack(Material.WOOL, 1, (short) 11);
	ItemMeta cei1m = cei1.getItemMeta();
	cei1m.setDisplayName("§5§lAstronauta I");
	cei1.setItemMeta(cei1m);
	
	//rank final
	
//rank começo
	
	ItemStack dem3 = new ItemStack(Material.WOOL, 1, (short) 14);
	ItemMeta dem3m = dem3.getItemMeta();
	dem3m.setDisplayName("§5§lComandante III");
	dem3.setItemMeta(dem3m);
	
	ItemStack dem2 = new ItemStack(Material.WOOL, 1, (short) 14);
	ItemMeta dem2m = dem2.getItemMeta();
	dem2m.setDisplayName("§5§lComandante II");
	dem2.setItemMeta(dem2m);
	
	ItemStack dem1 = new ItemStack(Material.WOOL, 1, (short) 14);
	ItemMeta dem1m = dem1.getItemMeta();
	dem1m.setDisplayName("§5§lComandante I");
	dem1.setItemMeta(dem1m);
	
	//rank final
	
	ItemStack sair = new ItemStack(Material.ARROW);
	ItemMeta sairm = sair.getItemMeta();
	sairm.setDisplayName("§aFechar menu");
	sair.setItemMeta(sairm);

	if (e.getInventory().getTitle().equals("Ranks")) {
		e.setCancelled(true);
		if (e.getCurrentItem().isSimilar(esp)) {
			
            infmen.setItem(11, esc3);
            infmen.setItem(20, esc2);
            infmen.setItem(29, esc1);
            
            infmen.setItem(12, mal3);
            infmen.setItem(21, mal2);
            infmen.setItem(30, mal1);
            
            infmen.setItem(13, as3);
            infmen.setItem(22, as2);
            infmen.setItem(31, as1);
            
            infmen.setItem(14, cei3);
            infmen.setItem(23, cei2);
            infmen.setItem(32, cei1);
            
            infmen.setItem(15, dem3);
            infmen.setItem(24, dem2);
            infmen.setItem(33, dem1);
            
            infmen.setItem(49, sair);
            
			p.openInventory(infmen);
			
			return;
		}
		}
	}
	}
	



@EventHandler
public void clicarsairesp(InventoryClickEvent e) {
if(e.getWhoClicked() instanceof Player) {
Player p = (Player) e.getWhoClicked();

ItemStack sair = new ItemStack(Material.ARROW);
ItemMeta sairm = sair.getItemMeta();
sairm.setDisplayName("§aFechar menu");
sair.setItemMeta(sairm);

if (e.getInventory().getTitle().equals("Ranks Espaciais")) {
	e.setCancelled(true);
	if (e.getCurrentItem().isSimilar(sair)) {
		
	
		
	p.getOpenInventory().close();
	return;
	}
}
}
}
}


			
			
			
			
	

