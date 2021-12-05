package me.ninjay.onecaixas.estruturas;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.onecaixas.main.Main;
import me.ninjay.utils.utils.Mine;
import me.ninjay.utils.utils.Storable;



public class CaixaManager implements Storable {


	public Caixa getCaixa(String nome) {
		for (Caixa caixa : caixas) {
			if (caixa.getNome().equalsIgnoreCase(nome)) {
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
		Inventory menu = Mine.newInventory("§0Abrindo...", 9 * 3);
		ArrayList<ItemRandom> caixona = caixa.getPrize();
		for (int d = 0; d < 27; d++) {
			ItemStack vidro = Mine.newItem(Material.STAINED_GLASS_PANE, "§eCaixa Misteriosa");
			vidro.setDurability((short) Mine.getRandomInt(1, 15));
			menu.setItem(d, vidro);
		}
		new BukkitRunnable() {
			int a = 30;

			@Override
			public void run() {
				a--;
				if (a == 30) {
					ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
					SkullMeta meta = (SkullMeta) skull.getItemMeta();
					meta.setOwner("Tom25W");
					meta.setDisplayName("§eSorteando...");
					skull.setItemMeta(meta);
                    menu.setItem(Mine.getPosition(2, 3), skull);
				}
				if (a == 25) {
					ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
					SkullMeta meta = (SkullMeta) skull.getItemMeta();
					meta.setOwner("Tom25W");
					skull.setItemMeta(meta);
					meta.setDisplayName("§eSorteando...");
                    menu.setItem(Mine.getPosition(2, 3), skull);
                    menu.setItem(Mine.getPosition(2, 4), skull);
				}
				if (a == 20) {
					ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
					SkullMeta meta = (SkullMeta) skull.getItemMeta();
					meta.setOwner("Tom25W");
					skull.setItemMeta(meta);
					meta.setDisplayName("§eSorteando...");
                    menu.setItem(Mine.getPosition(2, 3), skull);
                    menu.setItem(Mine.getPosition(2, 4), skull);
                    menu.setItem(Mine.getPosition(2, 5), skull);
				}
				if (a == 15) {
					ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
					SkullMeta meta = (SkullMeta) skull.getItemMeta();
					meta.setOwner("Tom25W");
					skull.setItemMeta(meta);
					meta.setDisplayName("§eSorteando...");
                    menu.setItem(Mine.getPosition(2, 3), skull);
                    menu.setItem(Mine.getPosition(2, 4), skull);
                    menu.setItem(Mine.getPosition(2, 5), skull);
                    menu.setItem(Mine.getPosition(2, 6), skull);
                    }
				if (a == 10) {
					ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
					SkullMeta meta = (SkullMeta) skull.getItemMeta();
					meta.setOwner("Tom25W");
					skull.setItemMeta(meta);
					meta.setDisplayName("§eSorteando...");
                    menu.setItem(Mine.getPosition(2, 3), skull);
                    menu.setItem(Mine.getPosition(2, 4), skull);
                    menu.setItem(Mine.getPosition(2, 5), skull);
                    menu.setItem(Mine.getPosition(2, 6), skull);
                    menu.setItem(Mine.getPosition(2, 7), skull);
				}
				if(a == 0) {
					cancel();
					p.getOpenInventory().close();
					if(Mine.getRandom(caixona).create().getType() == Material.AIR) {
						p.getInventory().addItem(caixona.get(17).getItem());
					}else {
						p.getInventory().addItem(Mine.getRandom(caixona).create());
					}
						
				}
				
			}
		}.runTaskTimer(Main.getPlugin(Main.class), 5, 5);
		p.openInventory(menu);
	}
}
