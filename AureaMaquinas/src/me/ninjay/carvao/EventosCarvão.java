package me.ninjay.carvao;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import org.bukkit.event.block.BlockPlaceEvent;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EventosCarv�o implements Listener{
	
	public void colocar(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		
		
		ItemStack car = new ItemStack(Material.COAL_BLOCK);
        ItemMeta carm = car.getItemMeta();
        carm.setDisplayName("�eMaquina de carv�o");
        carm.setLore(Arrays.asList("�7Material que est� sendo gerado: �eCarv�o", "�7Tipo de combust�vel: �eCombust�vel B�sico","�7Valor do combust�vel: �e1000$"));
        carm.addEnchant(Enchantment.DURABILITY, 1, false);
        car.setItemMeta(carm);
					
    
        	
        }
        
		}
	
 

