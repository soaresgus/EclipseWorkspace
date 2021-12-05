package me.ninjay.random.eventos.encantar;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.random.main.Main;

public class EventosEncantar implements Listener{
	
	public static void pegarnormal(Player p) {
		if(Main.xp.getDouble(p.getName()) >= 2000) {
			p.getWorld().playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
			Double atual = Main.xp.getDouble(p.getName());
			Main.xp.set(p.getName(), atual-2000);
			Main.xp.saveConfig();
			
			ItemStack livro = Mine.newItem(Material.BOOK, "§eLivro Normal");
			
            p.getInventory().addItem(livro);			
		}
	}
	public static void livroganhar(Player p ) {
		ItemStack livrop4 = Mine.newItem(Material.ENCHANTED_BOOK, "§eLivro Normal", 1, 1, "§7Protection IV", " ", "§fChance de sucesso: §768%","§fEncanta: §7Armaduras", " ","§eComo utilizar?","§fBasta clicar com este livro em cima do item","§fque você deseja aplicar o encantamento.");
		ItemStack livroe4 = Mine.newItem(Material.ENCHANTED_BOOK, "§eLivro Normal", 1, 1, "§7Efficiency IV", " ", "§fChance de sucesso: §732%","§fEncanta: §7Ferramentas", " ","§eComo utilizar?","§fBasta clicar com este livro em cima do item","§fque você deseja aplicar o encantamento.");
		ItemStack livroc5 = Mine.newItem(Material.ENCHANTED_BOOK, "§eLivro Normal", 1, 1, "§7Passos Congelantes V", " ", "§fChance de sucesso: §799%","§fEncanta: §7Botas", " ","§eComo utilizar?","§fBasta clicar com este livro em cima do item","§fque você deseja aplicar o encantamento.");		
		
		ItemStack livro = Mine.newItem(Material.BOOK, "§eLivro Normal", 1);
		
		ArrayList<ItemStack> lista = new ArrayList<>();
		lista.add(livroe4);
		lista.add(livrop4);
		lista.add(livroc5);
		p.getInventory().removeItem(livro);
		p.getInventory().addItem(Mine.getRandomItem(lista));
		
	}
	
	@EventHandler
	public void aoClicarNoInventario(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		 ItemStack livro2 = Mine.newItem(Material.BOOK, "§eLivro de encantamentos", 1, 0, "§7Tipo: §fNormal"," ","§7Clique com o §fbotão direito ","§7para ver os encantamentos básicos."," ","§fCusto: §a2.000 XP");
		
		if(e.getInventory().getTitle().equals("Feiticeiro")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(livro2)) {
				pegarnormal(p);
			}else {
				return;
			}
		}
	}
	@EventHandler
	public void aoClicarNoLivro(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		ItemStack livro = Mine.newItem(Material.BOOK, "§eLivro Normal");
		if(p.getItemInHand().isSimilar(livro)) {
			livroganhar(p);
			return;
		}
	}
   	 

}
