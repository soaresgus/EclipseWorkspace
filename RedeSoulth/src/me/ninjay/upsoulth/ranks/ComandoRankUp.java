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
			
			Inventory omega3i = Mine.newInventory("�mega III", 9*3);
			Inventory omega2i = Mine.newInventory("�mega II", 9*3);
			Inventory omega1i = Mine.newInventory("�mega I", 9*3);
			
			ItemStack cold3 = Mine.newItem("�eCold III", Material.STAINED_CLAY, 1, 13, "�fValor: �a$12.5K","�fBlocos: 30.000");
			ItemStack cold2 = Mine.newItem("�eCold II", Material.STAINED_CLAY, 1, 13, "�fValor: �a$21.87K","�fBlocos: 35.000");
			ItemStack cold1 = Mine.newItem("�eCold I", Material.STAINED_CLAY, 1, 13, "�fValor: �a$38.28K","�fBlocos: 40.000");
			
			ItemStack dark3 = Mine.newItem("�eDark III", Material.STAINED_CLAY, 1, 11, "�fValor: �a$66.99K","�fBlocos: 45.000");
			ItemStack dark2 = Mine.newItem("�eDark II", Material.STAINED_CLAY, 1, 11, "�fValor: �a$117.21K","�fBlocos: 50.000");
			ItemStack dark1 = Mine.newItem("�eDark I", Material.STAINED_CLAY, 1, 11, "�fValor: �a$215.11K","�fBlocos: 55.000");
			
			ItemStack flight3 = Mine.newItem("�eFlight III", Material.STAINED_CLAY, 1, 14, "�fValor: �a$359K","�fBlocos: 60.000");
			ItemStack flight2 = Mine.newItem("�eFlight II", Material.STAINED_CLAY, 1, 14, "�fValor: �a$628.21K","�fBlocos: 65.000");
			ItemStack flight1 = Mine.newItem("�eFlight I", Material.STAINED_CLAY, 1, 14, "�fValor: �a$1.199M","�fBlocos: 70.000");
			
			ItemStack souls3 = Mine.newItem("�eSouls III", Material.STAINED_CLAY, 1, 9, "�fValor: �a$1.924M","�fBlocos: 75.000");
			ItemStack souls2 = Mine.newItem("�eSouls II", Material.STAINED_CLAY, 1, 9, "�fValor: �a$3.367M","�fBlocos: 80.000");
			ItemStack souls1 = Mine.newItem("�eSouls I", Material.STAINED_CLAY, 1, 9, "�fValor: �a$5.892M","�fBlocos: 85.000");
			
			ItemStack killer3 = Mine.newItem("�eKiller III", Material.STAINED_CLAY, 1, 2, "�fValor: �a$11.311M","�fBlocos: 90.000");
			ItemStack killer2 = Mine.newItem("�eKiller II", Material.STAINED_CLAY, 1, 2, "�fValor: �a$18.141M","�fBlocos: 95.000");
			ItemStack killer1 = Mine.newItem("�eKiller I", Material.STAINED_CLAY, 1, 2, "�fValor: �a$31.571M","�fBlocos: 100.000");
			
			ItemStack demo3 = Mine.newItem("�eDemo III", Material.STAINED_CLAY, 1, 15, "�fValor: �a$46.891M","�fBlocos: 105.000");
			ItemStack demo2 = Mine.newItem("�eDemo II", Material.STAINED_CLAY, 1, 15, "�fValor: �a$71.384M","�fBlocos: 110.000");
			ItemStack demo1 = Mine.newItem("�eDemo I", Material.STAINED_CLAY, 1, 15, "�fValor: �a$129.289M","�fBlocos: 115.000");
			
			ItemStack dingy3 = Mine.newItem("�eDingy III", Material.STAINED_CLAY, 1, 5, "�fValor: �a$194.284M","�fBlocos: 120.000");
			ItemStack dingy2 = Mine.newItem("�eDingy II", Material.STAINED_CLAY, 1, 5, "�fValor: �a$285.393M","�fBlocos: 125.000");
			ItemStack dingy1 = Mine.newItem("�eDingy I", Material.STAINED_CLAY, 1, 5, "�fValor: �a$495.948M","�fBlocos: 130.000");
			
			ItemStack omega3 = Mine.newItem("�e�mega III", Material.STAINED_CLAY, 1, 4, "�fValor: �a$658.958M","�fBlocos: 135.000");
			ItemStack omega2 = Mine.newItem("�e�mega II", Material.STAINED_CLAY, 1, 4, "�fValor: �a$893.838M","�fBlocos: 140.000");
			ItemStack omega1 = Mine.newItem("�e�mega I", Material.STAINED_CLAY, 1, 4, "�fValor: �a$1.383B","�fBlocos: 145.000");
			
			ItemStack confirmar = Mine.newItem(Material.WOOL, "�aConfirmar", 1, 5);
			ItemStack negar = Mine.newItem(Material.WOOL, "�cCancelar", 1, 14);
			
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
