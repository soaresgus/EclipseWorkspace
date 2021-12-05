package me.ninjay.curso.caixa;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.curso.main.Main;
import net.eduard.api.lib.Mine;
import net.eduard.api.lib.storage.Storable;

public class CaixaManager implements Storable{
    public Caixa getcaixa(String nome) {
    	for(Caixa caixa : caixas) {
    		if(caixa.getName().equalsIgnoreCase(nome)) {
    			return caixa;
    			
    			
    		}
    	}
		return null;
    }
	private ArrayList<Caixa> caixas = new ArrayList<>();

	public ArrayList<Caixa> getCaixas() {
		return caixas;
	}

	public void setCaixas(ArrayList<Caixa> caixas) {
		this.caixas = caixas;
	}
	
		public void abrir(Player p,Caixa caixa) {
			Inventory menu = Bukkit.createInventory(null, 9 * 3, "Caixa Básica");
			ArrayList<ItemStack> list = caixa.getPremios();

			ItemStack seu = Mine.newItem(Material.IRON_FENCE, "§eSeu item");
			
			
		
			new BukkitRunnable() {
				int id = 30;

				@Override
				public void run() {
					id--;
					
					for (int d = 0; d < 27; d++) {
						ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
						ItemMeta vidrom = vidro.getItemMeta();
						vidrom.setDisplayName("§eCaixa Básica");
						vidro.setDurability((short) Mine.getRandomInt(1, 15));
						vidro.setItemMeta(vidrom);
						menu.setItem(d, vidro);
					}
					menu.setItem(Mine.getPosition(2, 5), Mine.getRandomItem(list));
					menu.setItem(Mine.getPosition(3, 5), seu);
					menu.setItem(Mine.getPosition(1, 5), seu);
					
					if (id == 0) {
						cancel();
						ItemStack item = menu.getItem(Mine.getPosition(2, 5));
						p.getInventory().addItem(item);
					}

				}
			}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 5, 5);
			p.openInventory(menu);
		}
	}

	

