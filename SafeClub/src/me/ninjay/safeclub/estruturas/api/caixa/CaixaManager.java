package me.ninjay.safeclub.estruturas.api.caixa;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.safeclub.main.Main;
import me.ninjay.safeclub.utils.Mine;
import me.ninjay.safeclub.utils.Storable;


public class CaixaManager implements Storable{
	
	public Caixa getCaixa(String nome) {
		for(Caixa caixa : caixas) {
			if(caixa.getNome().equalsIgnoreCase(nome)) {
				return caixa;
			}
		}
		return null;
	}
	
	public Caixa getCaixaInt(int number) {
		for(Caixa caixa : caixas) {
			if(caixa.getNumber() == number) {
				return caixa;
			}
		}
		return null;
	}
	
	public Caixa getCaixaIcone(Player p) {
		for(Caixa caixa: caixas) {
			if(caixa.getIcone().isSimilar(p.getItemInHand())) {
				return caixa;
			}
		}
		return null;
	}
	
	public Caixa getCaixaInv(Player p) {
		for(Caixa caixa : caixas) {
			if(caixa.getIcone().isSimilar(p.getItemOnCursor())) {
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
	
	public void abrir(Player p, Caixa caixa) {
		Inventory inv = Mine.newInventory("Caixa Misteriosa", 9*3);
		new BukkitRunnable() {
			int i = 30;
			@Override
			public void run() {
				i--;
				for(int d = 0; d < 27; d++) {
					inv.setItem(d, Mine.newItem(Material.STAINED_GLASS_PANE, "§eCaixa Misteriosa", 1, Mine.getRandomInt(1, 14), ""));
				}
				inv.setItem(Mine.getPosition(2, 5), Mine.getRandomItem(caixa.getItens()));
				if(i == 0) {
					cancel();
					ItemStack item = inv.getItem(Mine.getPosition(2, 5));
					p.getInventory().addItem(item);
				}
			}
		}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 5, 5);
		p.openInventory(inv);
	}
	

}
