package me.ninjay.megavender.eventos;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.megavender.comandos.ComandoDrops;
import me.ninjay.megavender.main.Main;
import me.ninjay.megavender.utils.Mine;

public class EventosDrops implements Listener {

	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Drops")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
			if (e.getCurrentItem().isSimilar(ComandoDrops.vender)) {
				new BukkitRunnable() {
					@Override
					public void run() {
						p.getOpenInventory().close();
						p.chat("/vender");
					}
				}.runTaskLater(Main.getPlugin(Main.class), 1);
				
			} else {
				e.setCancelled(true);
				return;
			}
		}else {
			e.setCancelled(true);
			return;
		}
		}
	}

	public static void adicionarPegar(Player p, ItemStack item, Material material, String c, int in) {
		int i = Mine.toInt(Main.pdrops.get(p.getName() + "." + c));
		int d = Mine.toInt(Main.pdrops.get(p.getName() + "Total"));
		if(item.getType() == material) {
			if (d >= Main.global.getInt("LimiteDeDrops") - in) {
				p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
				return;
			} else {
				if(item.getType() == material) {
					Main.pdrops.set(p.getName() + "." + c, i + in);
					Main.pdrops.saveConfig();
					Main.pdrops.set(p.getName() + "Total", d + in);
					Main.pdrops.saveConfig();

			}
			}
		}
		}
	
	
	public static void adicionarQuebrar(Player p, Block b, Material material, String c, int in) {
		int i = Mine.toInt(Main.pdrops.get(p.getName() + "." + c));
		int d = Mine.toInt(Main.pdrops.get(p.getName() + "Total"));
		if (b.getType() == material) {
			if (d >= Main.global.getInt("LimiteDeDrops") - in) {
				p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
				return;
			} else {
				if (b.getType() == material) {
					Main.pdrops.set(p.getName() + "." + c, i + in);
					Main.pdrops.saveConfig();
					Main.pdrops.set(p.getName() + "Total", d + in);
					Main.pdrops.saveConfig();
                    b.setType(Material.AIR);
				}
			}
		}
	}
	
	public static void adicionarMover(Player p, Material material, String c) {
		int i = Mine.toInt(Main.pdrops.get(p.getName() + "." + c));
		int d = Mine.toInt(Main.pdrops.get(p.getName() + "Total"));
      ItemStack i0 = p.getInventory().getItem(0);
      ItemStack i1 = p.getInventory().getItem(1);	 	
      ItemStack i2 = p.getInventory().getItem(2);
      ItemStack i3 = p.getInventory().getItem(3);
      ItemStack i4 = p.getInventory().getItem(4);
      ItemStack i5 = p.getInventory().getItem(5);
      ItemStack i6 = p.getInventory().getItem(6);
      ItemStack i7 = p.getInventory().getItem(7);
      ItemStack i8 = p.getInventory().getItem(8);
      ItemStack i9 = p.getInventory().getItem(9);
      ItemStack i10 = p.getInventory().getItem(10);
      ItemStack i11 = p.getInventory().getItem(11);
      ItemStack i12 = p.getInventory().getItem(12);
      ItemStack i13 = p.getInventory().getItem(13);
      ItemStack i14 = p.getInventory().getItem(14);
      ItemStack i15 = p.getInventory().getItem(15);
      ItemStack i16 = p.getInventory().getItem(16);
      ItemStack i17 = p.getInventory().getItem(17);
      ItemStack i18 = p.getInventory().getItem(18);
      ItemStack i19 = p.getInventory().getItem(19);
      ItemStack i20 = p.getInventory().getItem(20);
      ItemStack i21 = p.getInventory().getItem(21);
      ItemStack i22 = p.getInventory().getItem(22);
      ItemStack i23 = p.getInventory().getItem(23);
      ItemStack i24 = p.getInventory().getItem(24);
      ItemStack i25 = p.getInventory().getItem(25);
      ItemStack i26 = p.getInventory().getItem(26);
      ItemStack i27 = p.getInventory().getItem(27);
      ItemStack i28 = p.getInventory().getItem(28);
      ItemStack i29 = p.getInventory().getItem(29);
      ItemStack i30 = p.getInventory().getItem(30);
      ItemStack i31 = p.getInventory().getItem(31);
      ItemStack i32 = p.getInventory().getItem(32);
      ItemStack i33 = p.getInventory().getItem(33);
      ItemStack i34 = p.getInventory().getItem(34);
      ItemStack i35 = p.getInventory().getItem(35);
      if(i0 != null) {
  	if (i0.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i0.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i0.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i0.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i0.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i0, i0.getAmount());
				return;
			}
		}
	}
		}
  	if(i1 != null) {
  	if (i1.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i1.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i1.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i1.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i1.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i1, i1.getAmount());
				return;
		}
	}
  	}
		}
  	if(i2 != null) {
  	if (i2.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i2.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i2.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i2.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i2.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i2, i2.getAmount());
				return;
		}
		}
	}
		}
  	if(i3 != null) {
  	if (i3.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i3.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i3.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i3.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i3.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i3, i3.getAmount());
				return;
		}
	}
		}}
  	if(i4 != null) {
  	if (i4.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i4.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i4.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i4.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i4.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i4, i4.getAmount());
				return;
		}
	}
  	}
		}
  	if(i5 != null) {
  	if (i5.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i5.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i5.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i5.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i5.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i5, i5.getAmount());
				return;
		}
	}}
		}
  	if(i6 != null) {
  	if (i6.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i6.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i6.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i6.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i6.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i6, i6.getAmount());
				return;
		}
	}
		}}
  	if(i7 != null) {
  	if (i7.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i7.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i7.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i7.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i7.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i7, i7.getAmount());
				return;
		}}
	}
		}
  	if(i8 != null) {
  	if (i8.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i8.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i8.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i8.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i8.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i8, i8.getAmount());
				return;
		}
	}}
		}
  	if(i9 != null) {
  	if (i9.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i9.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i9.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i9.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i9.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i9, i9.getAmount());
				return;
		}
	}}
		}
  	if(i10 != null) {
  	if (i10.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i10.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i10.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i10.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i10.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i10, i10.getAmount());
				return;
		}}
	}
		}
  	if(i11 != null) {
  	if (i11.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i11.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i11.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i11.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i11.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i11, i11.getAmount());
				return;
		}
	}
		}}
  	if(i12 != null) {
  	if (i12.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i12.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i12.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i12.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i12.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i12, i12.getAmount());
				return;
		}
	}}
		}
  	if(i13 != null) {
  	if (i13.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i13.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i13.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i13.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i13.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i13, i13.getAmount());
				return;
		}}
	}
		}
  	if(i14 != null) {
  	if (i14.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i14.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i14.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i14.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i14.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i14, i14.getAmount());
				return;
		}
	}
		}}
  	if(i15 != null) {
  	if (i15.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i15.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i15.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i15.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i15.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i15, i15.getAmount());
				return;
		}}
	}
		}
  	if(i16 != null) {
  	if (i16.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i16.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i16.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i16.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i16.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i16, i16.getAmount());
				return;
		}}
	}
		}
  	if(i17 != null) {
  	if (i17.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i17.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i17.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i17.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i17.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i17, i17.getAmount());
				return;
		}}
	}
		}
  	if(i18 != null) {
  	if (i18.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i18.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i18.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i18.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i18.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i18, i18.getAmount());
				return;
		}
	}
		}}
  	if(i19 != null) {
  	if (i19.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i19.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i19.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i19.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i19.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i19, i19.getAmount());
				return;
		}}
	}
		}
  	if(i20 != null) {
  	if (i20.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i20.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i20.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i20.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i20.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i20, i20.getAmount());
				return;
		}
	}}
		}
  	if(i21 != null) {
  	if (i21.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i21.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i21.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i21.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i21.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i21, i21.getAmount());
				return;
		}}
	}
		}
  	if(i22 != null) {
  	if (i22.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i22.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i22.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i22.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i22.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i22, i22.getAmount());
				return;
		}}
	}
		}
  	if(i23 != null) {
  	if (i23.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i23.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i23.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i23.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i23.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i23, i23.getAmount());
				return;
		}}
	}
		}
  	if(i24 != null) {
  	if (i24.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i24.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i24.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i24.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i24.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i24, i24.getAmount());
				return;
		}}
	}
		}
  	if(i25 != null) {
  	if (i25.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i25.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i25.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i25.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i25.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i25, i25.getAmount());
				return;
		}
	}}
		}
  	if(i26 != null) {
  	if (i26.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i26.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i26.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i26.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i26.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i26, i26.getAmount());
				return;
		}}
	}
		}
  	if(i27 != null) {
  	if (i27.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i27.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i27.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i27.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i27.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i27, i27.getAmount());
				return;
		}}
	}
		}
  	if(i28 != null) {
  	if (i28.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i28.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i28.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i28.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i28.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i28, i28.getAmount());
				return;
		}
	}}
		}
  	if(i29 != null) {
  	if (i29.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i29.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i29.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i29.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i29.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i29, i29.getAmount());
				return;
		}}
	}
		}
  	if(i30 != null) {
  	if (i30.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i30.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i30.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i30.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i30.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i30, i30.getAmount());
				return;
		}
	}}
		}
  	if(i31 != null) {
  	if (i31.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i31.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i31.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i31.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i31.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i31, i31.getAmount());
				return;
		}}
	}
		}
  	if(i32 != null) {
  	if (i32.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i32.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i32.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i32.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i32.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i32, i32.getAmount());
				return;
		}
	}}
		}
  	if(i33 != null) {
  	if (i33.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i33.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i33.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i33.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i33.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i33, i33.getAmount());
				return;
		}
		}
	}
		}
  	if(i34 != null) {
  	if (i34.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i34.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i34.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i34.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i34.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i34, i34.getAmount());
				return;
		}
	}}
		}
  	if(i35 != null) {
  	if (i35.getType() == material) {
		if (d >= Main.global.getInt("LimiteDeDrops") - i35.getAmount()) {
			p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
			return;
		} else {
			if (i35.getType() == material) {
				Main.pdrops.set(p.getName() + "." + c, i + i35.getAmount());
				Main.pdrops.set(p.getName() + "Total", d + i35.getAmount());
				Main.pdrops.saveConfig();
				Mine.remove(p.getInventory(), i35, i35.getAmount());
				return;
		}
	}
		}}
  	
	}
	
	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		adicionarQuebrar(p, b, Material.LAPIS_BLOCK, "lapisb", 1);
		adicionarQuebrar(p, b, Material.LAPIS_ORE, "lapism", 30);
		adicionarQuebrar(p, b, Material.REDSTONE_BLOCK, "redstoneb", 1);
		adicionarQuebrar(p, b, Material.REDSTONE, "redstonem", 30);
		adicionarQuebrar(p, b, Material.COAL_BLOCK, "carvaob", 1);
		adicionarQuebrar(p, b, Material.COAL, "carvaom", 30);
		adicionarQuebrar(p, b, Material.DIAMOND_BLOCK, "diamanteb", 1);
		adicionarQuebrar(p, b, Material.DIAMOND, "diamantem", 30);
		adicionarQuebrar(p, b, Material.EMERALD_BLOCK, "esmeraldab", 1);
		adicionarQuebrar(p, b, Material.EMERALD, "esmeraldam", 30);
		
	}
	
	@EventHandler
	public void aoPegar(PlayerPickupItemEvent e) {
		Player p = e.getPlayer();
		ItemStack item = e.getItem().getItemStack();
		int in = item.getAmount();
		
		adicionarPegar(p, item, Material.LAPIS_BLOCK, "lapisb", in);
		adicionarPegar(p, item, Material.REDSTONE_BLOCK, "redstoneb", in);
		adicionarPegar(p, item, Material.REDSTONE, "redstonem", in);
		adicionarPegar(p, item, Material.COAL_BLOCK, "carvaob", in);
		adicionarPegar(p, item, Material.COAL, "carvaom", in);
		adicionarPegar(p, item, Material.DIAMOND_BLOCK, "diamanteb", in);
		adicionarPegar(p, item, Material.DIAMOND, "diamantem", in);
		adicionarPegar(p, item, Material.EMERALD_BLOCK, "esmeraldab", in);
		adicionarPegar(p, item, Material.EMERALD, "esmeraldam", in);
		adicionarPegar(p, item, Material.IRON_INGOT, "ferro", in); //
		adicionarPegar(p, item, Material.MAGMA_CREAM, "magma", in);
		adicionarPegar(p, item, Material.BLAZE_ROD, "blaze", in);
		adicionarPegar(p, item, Material.SULPHUR, "polvora", in);
		adicionarPegar(p, item, Material.STRING, "linha", in);
		adicionarPegar(p, item, Material.WHEAT, "trigo", in);
		adicionarPegar(p, item, Material.COCOA, "cacau", in);
		adicionarPegar(p, item, Material.MELON, "melancia", in);
		adicionarPegar(p, item, Material.PUMPKIN, "abobora", in);
		adicionarPegar(p, item, Material.SUGAR_CANE, "cana", in);
		adicionarPegar(p, item, Material.NETHER_STALK, "fungo", in);
		int i = Mine.toInt(Main.pdrops.get(p.getName() + "." + "lapism"));
		int d = Mine.toInt(Main.pdrops.get(p.getName() + "Total"));
		ItemStack lapiz = Mine.newItem(Material.INK_SACK, null, 1, 4);
		if(item.getType() == lapiz.getType()) {
			if (d >= Main.global.getInt("LimiteDeDrops") - in) {
				p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
				return;
			} else {
				if(item.getType() == lapiz.getType()) {
					Main.pdrops.set(p.getName() + "." + "lapism", i + in);
					Main.pdrops.saveConfig();
					Main.pdrops.set(p.getName() + "Total", d + in);
					Main.pdrops.saveConfig();

			}
			}
		}
		new BukkitRunnable() {
			
			@Override
			public void run() {
				Mine.remove(p.getInventory(), item, in);
				p.updateInventory();
			}
		}.runTaskLater(Main.getPlugin(Main.class), 2);
		
	}
	
	@EventHandler
	public void aoClicarMover(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equals("Drops")) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().isSimilar(ComandoDrops.mover)) {
					p.getOpenInventory().close();
				    adicionarMover(p,  Material.LAPIS_BLOCK, "lapisb");
					adicionarMover(p,  Material.REDSTONE_BLOCK, "redstoneb");
					adicionarMover(p,  Material.REDSTONE, "redstonem");
					adicionarMover(p,  Material.COAL_BLOCK, "carvaob");
					adicionarMover(p,  Material.COAL, "carvaom");
					adicionarMover(p,  Material.DIAMOND_BLOCK, "diamanteb");
					adicionarMover(p,  Material.DIAMOND, "diamantem");
					adicionarMover(p,  Material.EMERALD_BLOCK, "esmeraldab");
					adicionarMover(p,  Material.EMERALD, "esmeraldam");
					adicionarMover(p,  Material.IRON_INGOT, "ferro"); //
					adicionarMover(p,  Material.MAGMA_CREAM, "magma");
					adicionarMover(p,  Material.BLAZE_ROD, "blaze");
					adicionarMover(p,  Material.SULPHUR, "polvora");
					adicionarMover(p,  Material.STRING, "linha");
					adicionarMover(p,  Material.WHEAT, "trigo");
					adicionarMover(p,  Material.COCOA, "cacau");
					adicionarMover(p,  Material.MELON, "melancia");
					adicionarMover(p,  Material.PUMPKIN, "abobora");
					adicionarMover(p,  Material.SUGAR_CANE, "cana");
					adicionarMover(p,  Material.NETHER_STALK, "fungo");
					int i = Mine.toInt(Main.pdrops.get(p.getName() + "." + "lapism"));
					int d = Mine.toInt(Main.pdrops.get(p.getName() + "Total"));
					ItemStack lapiz = Mine.newItem(Material.INK_SACK, null, 1, 4);
				    ItemStack i0 = p.getInventory().getItem(0);
				      ItemStack i1 = p.getInventory().getItem(1);	 	
				      ItemStack i2 = p.getInventory().getItem(2);
				      ItemStack i3 = p.getInventory().getItem(3);
				      ItemStack i4 = p.getInventory().getItem(4);
				      ItemStack i5 = p.getInventory().getItem(5);
				      ItemStack i6 = p.getInventory().getItem(6);
				      ItemStack i7 = p.getInventory().getItem(7);
				      ItemStack i8 = p.getInventory().getItem(8);
				      ItemStack i9 = p.getInventory().getItem(9);
				      ItemStack i10 = p.getInventory().getItem(10);
				      ItemStack i11 = p.getInventory().getItem(11);
				      ItemStack i12 = p.getInventory().getItem(12);
				      ItemStack i13 = p.getInventory().getItem(13);
				      ItemStack i14 = p.getInventory().getItem(14);
				      ItemStack i15 = p.getInventory().getItem(15);
				      ItemStack i16 = p.getInventory().getItem(16);
				      ItemStack i17 = p.getInventory().getItem(17);
				      ItemStack i18 = p.getInventory().getItem(18);
				      ItemStack i19 = p.getInventory().getItem(19);
				      ItemStack i20 = p.getInventory().getItem(20);
				      ItemStack i21 = p.getInventory().getItem(21);
				      ItemStack i22 = p.getInventory().getItem(22);
				      ItemStack i23 = p.getInventory().getItem(23);
				      ItemStack i24 = p.getInventory().getItem(24);
				      ItemStack i25 = p.getInventory().getItem(25);
				      ItemStack i26 = p.getInventory().getItem(26);
				      ItemStack i27 = p.getInventory().getItem(27);
				      ItemStack i28 = p.getInventory().getItem(28);
				      ItemStack i29 = p.getInventory().getItem(29);
				      ItemStack i30 = p.getInventory().getItem(30);
				      ItemStack i31 = p.getInventory().getItem(31);
				      ItemStack i32 = p.getInventory().getItem(32);
				      ItemStack i33 = p.getInventory().getItem(33);
				      ItemStack i34 = p.getInventory().getItem(34);
				      ItemStack i35 = p.getInventory().getItem(35);
				      if(i0 != null) {
				      if (i0.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i0.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i0.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i0.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i0.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i0, i0.getAmount());
									return;
							}
						}}
							}
				      if(i1 != null) {
					  	if (i1.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i1.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i1.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i1.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i1.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i1, i1.getAmount());
									return;
							}}
						}
							}
				      if(i2 != null) {
					  	if (i2.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i2.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i2.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i2.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i2.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i2, i2.getAmount());
									return;
							}
						}}
							}
				      if(i3 != null) {
					  	if (i3.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i3.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i3.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i3.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i3.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i3, i3.getAmount());
									return;
							}
						}}
							}
				      if(i4 != null) {
					  	if (i4.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i4.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i4.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i4.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i4.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i4, i4.getAmount());
									return;
							}
						}
							}}
				      if(i5 != null) {
					  	if (i5.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i5.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i5.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i5.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i5.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i5, i5.getAmount());
									return;
							}
						}}
							}
				      if(i6 != null) {
					  	if (i6.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i6.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i6.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i6.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i6.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i6, i6.getAmount());
									return;
							}}
						}
							}
				      if(i7 != null) {
					  	if (i7.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i7.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i7.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i7.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i7.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i7, i7.getAmount());
									return;
							}}
						}
							}
				      if(i8 != null) {
					  	if (i8.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i8.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i8.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i8.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i8.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i8, i8.getAmount());
									return;
							}
						}}
							}
				      if(i9 != null) {
					  	if (i9.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i9.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i9.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i9.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i9.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i9, i9.getAmount());
									return;
							}
						}}
							}
				      if(i10 != null) {
					  	if (i10.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i10.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i10.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i10.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i10.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i10, i10.getAmount());
									return;
							}
						}
							}}
				      if(i11 != null) {
					  	if (i11.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i11.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i11.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i11.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i11.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i11, i11.getAmount());
									return;
							}}
						}
							}
				      if(i12 != null) {
					  	if (i12.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i12.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i12.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i12.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i12.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i12, i12.getAmount());
									return;
							}
						}}
							}
				      if(i13 != null) {
					  	if (i13.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i13.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i13.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i13.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i13.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i13, i13.getAmount());
									return;
							}
						}}
							}
				      if(i14 != null) {
					  	if (i14.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i14.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i14.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i14.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i14.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i14, i14.getAmount());
									return;
							}
						}}
							}
				      if(i15 != null) {
					  	if (i15.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i15.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i15.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i15.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i15.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i15, i15.getAmount());
									return;
							}}
						}
							}
				      if(i16 != null) {
					  	if (i16.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i16.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i16.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i16.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i16.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i16, i16.getAmount());
									return;
							}
						}
							}}
				      if(i17 != null) {
					  	if (i17.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i17.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i17.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i17.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i17.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i17, i17.getAmount());
									return;
							}}
						}
							}
				      if(i18 != null) {
					  	if (i18.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i18.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i18.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i18.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i18.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i18, i18.getAmount());
									return;
							}
						}}
							}
				      if(i19 != null) {
					  	if (i19.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i19.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i19.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i19.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i19.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i19, i19.getAmount());
									return;
							}
						}}
							}
				      if(i20 != null) {
					  	if (i20.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i20.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i20.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i20.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i20.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i20, i20.getAmount());
									return;
							}
						}}
							}
				      if(i21 != null) {
					  	if (i21.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i21.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i21.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i21.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i21.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i21, i21.getAmount());
									return;
							}}
						}
							}
				      if(i22 != null) {
					  	if (i22.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i22.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i22.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i22.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i22.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i22, i22.getAmount());
									return;
							}
						}}
							}
				      if(i23 != null) {
					  	if (i23.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i23.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i23.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i23.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i23.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i23, i23.getAmount());
									return;
							}}
						}
							}
				      if(i24 != null) {
					  	if (i24.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i24.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i24.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i24.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i24.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i24, i24.getAmount());
									return;
							}
						}}
							}
				      if(i25 != null) {
					  	if (i25.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i25.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i25.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i25.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i25.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i25, i25.getAmount());
									return;
							}}
						}
							}
				      if(i26 != null) {
					  	if (i26.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i26.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i26.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i26.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i26.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i26, i26.getAmount());
									return;
							}
						}}
							}
				      if(i27 != null) {
					  	if (i27.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i27.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i27.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i27.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i27.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i27, i27.getAmount());
									return;
							}
						}
							}}
				      if(i28 != null) {
					  	if (i28.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i28.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i28.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i28.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i28.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i28, i28.getAmount());
									return;
							}}
						}
							}
				      if(i29 != null) {
					  	if (i29.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i29.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i29.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i29.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i29.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i29, i29.getAmount());
									return;
							}
						}}
							}
				      if(i30 != null) {
					  	if (i30.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i30.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i30.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i30.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i30.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i30, i30.getAmount());
									return;
							}
						}
							}}
				      if(i31 != null) {
					  	if (i31.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i31.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i31.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i31.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i31.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i31, i31.getAmount());
									return;
							}
						}
							}}
				      if(i32 != null) {
					  	if (i32.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i32.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i32.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i32.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i32.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i32, i32.getAmount());
									return;
							}
						}}
							}
				      if(i33 != null) {
					  	if (i33.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i33.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i33.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i33.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i33.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i33, i33.getAmount());
									return;
							}
						}
							}}
				      if(i34 != null) {
					  	if (i34.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i34.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i34.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i34.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i34.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i34, i34.getAmount());
									return;
							}
						}}
							}
				      if(i35 != null) {
					  	if (i35.getType() == lapiz.getType()) {
							if (d >= Main.global.getInt("LimiteDeDrops") - i35.getAmount()) {
								p.sendMessage("§cSeu /drops está lotado ! Venda os itens para liberar espaço.");
								return;
							} else {
								if (i35.getType() == lapiz.getType()) {
									Main.pdrops.set(p.getName() + "." + "lapism", i + i35.getAmount());
									Main.pdrops.set(p.getName() + "Total", d + i35.getAmount());
									Main.pdrops.saveConfig();
									Mine.remove(p.getInventory(), i35, i35.getAmount());
									return;
							}
							}
						}
							}
					
		}
				}
			}
		}
}	
