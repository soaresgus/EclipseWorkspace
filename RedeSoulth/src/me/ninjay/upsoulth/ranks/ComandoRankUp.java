package me.ninjay.upsoulth.ranks;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;

public class ComandoRankUp implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String a, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			Inventory cold3i = Mine.newInventory("Cold III", 9*3);
			Inventory cold2i = Mine.newInventory("Cold II", 9*3);
			Inventory cold1i = Mine.newInventory("Cold I", 9*3);
			
			Inventory dark3i = Mine.newInventory("Dark III", 9*3);
			Inventory dark2i = Mine.newInventory("Dark II", 9*3);
			Inventory dark1i = Mine.newInventory("Dark I", 9*3);
			
			Inventory flight3i = Mine.newInventory("Flight III", 9*3);
			Inventory flight2i = Mine.newInventory("Flight II", 9*3);
			Inventory flight1i = Mine.newInventory("Flight I", 9*3);
			
			Inventory souls3i = Mine.newInventory("Souls III", 9*3);
			Inventory souls2i = Mine.newInventory("Souls II", 9*3);
			Inventory souls1i = Mine.newInventory("Souls I", 9*3);
			
			Inventory killer3i = Mine.newInventory("Killer III", 9*3);
			Inventory killer2i = Mine.newInventory("Killer II", 9*3);
			Inventory killer1i = Mine.newInventory("Killer I", 9*3);
			
			Inventory demo3i = Mine.newInventory("Demo III", 9*3);
			Inventory demo2i = Mine.newInventory("Demo II", 9*3);
			Inventory demo1i = Mine.newInventory("Demo I", 9*3);
			
			Inventory dingy3i = Mine.newInventory("Dingy III", 9*3);
			Inventory dingy2i = Mine.newInventory("Dingy II", 9*3);
			Inventory dingy1i = Mine.newInventory("Dingy I", 9*3);
			
			Inventory omega3i = Mine.newInventory("‘mega III", 9*3);
			Inventory omega2i = Mine.newInventory("‘mega II", 9*3);
			Inventory omega1i = Mine.newInventory("‘mega I", 9*3);
			
			ItemStack cold3 = Mine.newItem("ßeCold III", Material.STAINED_CLAY, 1, 13, "ßfValor: ßa$12.5K","ßfBlocos: 30.000");
			ItemStack cold2 = Mine.newItem("ßeCold II", Material.STAINED_CLAY, 1, 13, "ßfValor: ßa$21.87K","ßfBlocos: 35.000");
			ItemStack cold1 = Mine.newItem("ßeCold I", Material.STAINED_CLAY, 1, 13, "ßfValor: ßa$38.28K","ßfBlocos: 40.000");
			
			ItemStack dark3 = Mine.newItem("ßeDark III", Material.STAINED_CLAY, 1, 11, "ßfValor: ßa$66.99K","ßfBlocos: 45.000");
			ItemStack dark2 = Mine.newItem("ßeDark II", Material.STAINED_CLAY, 1, 11, "ßfValor: ßa$117.21K","ßfBlocos: 50.000");
			ItemStack dark1 = Mine.newItem("ßeDark I", Material.STAINED_CLAY, 1, 11, "ßfValor: ßa$215.11K","ßfBlocos: 55.000");
			
			ItemStack flight3 = Mine.newItem("ßeFlight III", Material.STAINED_CLAY, 1, 14, "ßfValor: ßa$359K","ßfBlocos: 60.000");
			ItemStack flight2 = Mine.newItem("ßeFlight II", Material.STAINED_CLAY, 1, 14, "ßfValor: ßa$628.21K","ßfBlocos: 65.000");
			ItemStack flight1 = Mine.newItem("ßeFlight I", Material.STAINED_CLAY, 1, 14, "ßfValor: ßa$1.199M","ßfBlocos: 70.000");
			
			ItemStack souls3 = Mine.newItem("ßeSouls III", Material.STAINED_CLAY, 1, 9, "ßfValor: ßa$1.924M","ßfBlocos: 75.000");
			ItemStack souls2 = Mine.newItem("ßeSouls II", Material.STAINED_CLAY, 1, 9, "ßfValor: ßa$3.367M","ßfBlocos: 80.000");
			ItemStack souls1 = Mine.newItem("ßeSouls I", Material.STAINED_CLAY, 1, 9, "ßfValor: ßa$5.892M","ßfBlocos: 85.000");
			
			ItemStack killer3 = Mine.newItem("ßeKiller III", Material.STAINED_CLAY, 1, 2, "ßfValor: ßa$11.311M","ßfBlocos: 90.000");
			ItemStack killer2 = Mine.newItem("ßeKiller II", Material.STAINED_CLAY, 1, 2, "ßfValor: ßa$18.141M","ßfBlocos: 95.000");
			ItemStack killer1 = Mine.newItem("ßeKiller I", Material.STAINED_CLAY, 1, 2, "ßfValor: ßa$31.571M","ßfBlocos: 100.000");
			
			ItemStack demo3 = Mine.newItem("ßeDemo III", Material.STAINED_CLAY, 1, 15, "ßfValor: ßa$46.891M","ßfBlocos: 105.000");
			ItemStack demo2 = Mine.newItem("ßeDemo II", Material.STAINED_CLAY, 1, 15, "ßfValor: ßa$71.384M","ßfBlocos: 110.000");
			ItemStack demo1 = Mine.newItem("ßeDemo I", Material.STAINED_CLAY, 1, 15, "ßfValor: ßa$129.289M","ßfBlocos: 115.000");
			
			ItemStack dingy3 = Mine.newItem("ßeDingy III", Material.STAINED_CLAY, 1, 5, "ßfValor: ßa$194.284M","ßfBlocos: 120.000");
			ItemStack dingy2 = Mine.newItem("ßeDingy II", Material.STAINED_CLAY, 1, 5, "ßfValor: ßa$285.393M","ßfBlocos: 125.000");
			ItemStack dingy1 = Mine.newItem("ßeDingy I", Material.STAINED_CLAY, 1, 5, "ßfValor: ßa$495.948M","ßfBlocos: 130.000");
			
			ItemStack omega3 = Mine.newItem("ße‘mega III", Material.STAINED_CLAY, 1, 4, "ßfValor: ßa$658.958M","ßfBlocos: 135.000");
			ItemStack omega2 = Mine.newItem("ße‘mega II", Material.STAINED_CLAY, 1, 4, "ßfValor: ßa$893.838M","ßfBlocos: 140.000");
			ItemStack omega1 = Mine.newItem("ße‘mega I", Material.STAINED_CLAY, 1, 4, "ßfValor: ßa$1.383B","ßfBlocos: 145.000");
			
			ItemStack confirmar = Mine.newItem(Material.WOOL, "ßaConfirmar", 1, 5);
			ItemStack negar = Mine.newItem(Material.WOOL, "ßcCancelar", 1, 14);
			
			cold3i.setItem(Mine.getPosition(2, 3), confirmar);
			cold3i.setItem(Mine.getPosition(2, 5), cold3);
			cold3i.setItem(Mine.getPosition(2, 7), negar);
			
			cold2i.setItem(Mine.getPosition(2, 3), confirmar);
			cold2i.setItem(Mine.getPosition(2, 5), cold2);
			cold2i.setItem(Mine.getPosition(2, 7), negar);
			
			cold1i.setItem(Mine.getPosition(2, 3), confirmar);
			cold1i.setItem(Mine.getPosition(2, 5), cold1);
			cold1i.setItem(Mine.getPosition(2, 7), negar);
			
			dark3i.setItem(Mine.getPosition(2, 3), confirmar);
			dark3i.setItem(Mine.getPosition(2, 5), dark3);
			dark3i.setItem(Mine.getPosition(2, 7), negar);
			
			dark2i.setItem(Mine.getPosition(2, 3), confirmar);
			dark2i.setItem(Mine.getPosition(2, 5), dark2);
			dark2i.setItem(Mine.getPosition(2, 7), negar);
			
			dark1i.setItem(Mine.getPosition(2, 3), confirmar);
			dark1i.setItem(Mine.getPosition(2, 5), dark1);
			dark1i.setItem(Mine.getPosition(2, 7), negar);
			
			flight3i.setItem(Mine.getPosition(2, 3), confirmar);
			flight3i.setItem(Mine.getPosition(2, 5), flight3);
			flight3i.setItem(Mine.getPosition(2, 7), negar);
			
			flight2i.setItem(Mine.getPosition(2, 3), confirmar);
			flight2i.setItem(Mine.getPosition(2, 5), flight2);
			flight2i.setItem(Mine.getPosition(2, 7), negar);
			
			flight1i.setItem(Mine.getPosition(2, 3), confirmar);
			flight1i.setItem(Mine.getPosition(2, 5), flight1);
			flight1i.setItem(Mine.getPosition(2, 7), negar);
			
			souls3i.setItem(Mine.getPosition(2, 3), confirmar);
			souls3i.setItem(Mine.getPosition(2, 5), souls3);
			souls3i.setItem(Mine.getPosition(2, 7), negar);
			
			souls2i.setItem(Mine.getPosition(2, 3), confirmar);
			souls2i.setItem(Mine.getPosition(2, 5), souls2);
			souls2i.setItem(Mine.getPosition(2, 7), negar);
			
			souls1i.setItem(Mine.getPosition(2, 3), confirmar);
			souls1i.setItem(Mine.getPosition(2, 5), souls1);
			souls1i.setItem(Mine.getPosition(2, 7), negar);
			
			killer3i.setItem(Mine.getPosition(2, 3), confirmar);
			killer3i.setItem(Mine.getPosition(2, 5), killer3);
			killer3i.setItem(Mine.getPosition(2, 7), negar);
			
			killer2i.setItem(Mine.getPosition(2, 3), confirmar);
			killer2i.setItem(Mine.getPosition(2, 5), killer2);
			killer2i.setItem(Mine.getPosition(2, 7), negar);
			
			killer1i.setItem(Mine.getPosition(2, 3), confirmar);
			killer1i.setItem(Mine.getPosition(2, 5), killer1);
			killer1i.setItem(Mine.getPosition(2, 7), negar);
			
			demo3i.setItem(Mine.getPosition(2, 3), confirmar);
			demo3i.setItem(Mine.getPosition(2, 5), demo3);
			demo3i.setItem(Mine.getPosition(2, 7), negar);
			
			demo2i.setItem(Mine.getPosition(2, 3), confirmar);
			demo2i.setItem(Mine.getPosition(2, 5), demo2);
			demo2i.setItem(Mine.getPosition(2, 7), negar);
			
			demo1i.setItem(Mine.getPosition(2, 3), confirmar);
			demo1i.setItem(Mine.getPosition(2, 5), demo1);
			demo1i.setItem(Mine.getPosition(2, 7), negar);
			
			dingy3i.setItem(Mine.getPosition(2, 3), confirmar);
			dingy3i.setItem(Mine.getPosition(2, 5), dingy3);
			dingy3i.setItem(Mine.getPosition(2, 7), negar);
			
			dingy2i.setItem(Mine.getPosition(2, 3), confirmar);
			dingy2i.setItem(Mine.getPosition(2, 5), dingy2);
			dingy2i.setItem(Mine.getPosition(2, 7), negar);
			
			dingy1i.setItem(Mine.getPosition(2, 3), confirmar);
			dingy1i.setItem(Mine.getPosition(2, 5), dingy1);
			dingy1i.setItem(Mine.getPosition(2, 7), negar);
			
			omega3i.setItem(Mine.getPosition(2, 3), confirmar);
			omega3i.setItem(Mine.getPosition(2, 5), omega3);
			omega3i.setItem(Mine.getPosition(2, 7), negar);
			
			omega2i.setItem(Mine.getPosition(2, 3), confirmar);
			omega2i.setItem(Mine.getPosition(2, 5), omega2);
			omega2i.setItem(Mine.getPosition(2, 7), negar);
			
			omega1i.setItem(Mine.getPosition(2, 3), confirmar);
			omega1i.setItem(Mine.getPosition(2, 5), omega1);
			omega1i.setItem(Mine.getPosition(2, 7), negar);
			
			if(!p.hasPermission("cold3.rank")) {
				p.openInventory(cold3i);
				return true;
			}
			if(p.hasPermission("cold2.rank")) {
				p.openInventory(cold2i);
				return true;
			}
			if(p.hasPermission("cold1.rank")) {
				p.openInventory(cold1i);
				return true;
			}
			if(p.hasPermission("dark3.rank")) {
				p.openInventory(dark3i);
				return true;
			}
			if(p.hasPermission("dark2.rank")) {
				p.openInventory(dark2i);
				return true;
			}
			if(p.hasPermission("dark1.rank")) {
				p.openInventory(dark1i);
				return true;
			}
			if(p.hasPermission("flight3.rank")) {
				p.openInventory(flight3i);
				return true;
			}
			if(p.hasPermission("flight2.rank")) {
				p.openInventory(flight2i);
				return true;
			}
			if(p.hasPermission("flight1.rank")) {
				p.openInventory(flight1i);
				return true;
			}
			if(p.hasPermission("souls3.rank")) {
				p.openInventory(souls3i);
				return true;
			}
			if(p.hasPermission("souls2.rank")) {
				p.openInventory(souls2i);
				return true;
			}
			if(p.hasPermission("souls1.rank")) {
				p.openInventory(souls1i);
				return true;
			}
			if(p.hasPermission("killer3.rank")) {
				p.openInventory(killer3i);
				return true;
			}
			if(p.hasPermission("killer2.rank")) {
				p.openInventory(killer2i);
				return true;
			}
			if(p.hasPermission("killer1.rank")) {
				p.openInventory(killer1i);
				return true;
			}
			if(p.hasPermission("demo3.rank")) {
				p.openInventory(demo3i);
				return true;
			}
			if(p.hasPermission("demo2.rank")) {
				p.openInventory(demo2i);
				return true;
			}
			if(p.hasPermission("demo1.rank")) {
				p.openInventory(demo1i);
				return true;
			}
			if(p.hasPermission("dingy3.rank")) {
				p.openInventory(dingy3i);
				return true;
			}
			if(p.hasPermission("dingy2.rank")) {
				p.openInventory(dingy2i);
				return true;
			}
			if(p.hasPermission("dingy1.rank")) {
				p.openInventory(dingy1i);
				return true;
			}
			if(p.hasPermission("omega3.rank")) {
				p.openInventory(omega3i);
				return true;
			}
			if(p.hasPermission("omega2.rank")) {
				p.openInventory(omega2i);
				return true;
			}
			if(p.hasPermission("omega1.rank")) {
				p.openInventory(omega1i);
				return true;
			}
			
			
			
			
		}
		return false;
	}

}
