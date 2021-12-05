package me.ninjay.circles_geradores.eventos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.material.Stairs;

import com.massivecraft.factions.entity.BoardColl;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.FactionColl;
import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.massivecore.ps.PS;

import me.ninjay.circles_geradores.estruturas.ItensAPI;
import me.ninjay.circles_geradores.main.Main;

public class EventosGeral implements Listener{
	
	public void setStairs(Block block, Material material, BlockFace face, boolean flipped) {
        if (block == null)
            return;
       
        BlockState state = block.getState();
       
        Stairs stairs = (Stairs) state.getData();
        stairs.setFacingDirection(face);
        stairs.setInverted(flipped);
       
        state.setData(stairs);
        state.update(false, false);
    }
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		MPlayer mp = MPlayer.get(p);
		Faction fac = mp.getFaction();
		PS ps = PS.valueOf(e.getBlock().getLocation());
		Faction facloc = BoardColl.get().getFactionAt(ps);
		Faction zonalivre = FactionColl.get().getNone();
		
		if(e.getItemInHand().isSimilar(ItensAPI.gerador())) {
			if(facloc != zonalivre) {
			if(b.getWorld().getBlockAt(b.getLocation().add(1, 0 ,1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 0 ,1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 0 ,1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 0 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 0 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 0 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 0 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 0 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 0 ,2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 0 ,2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 0 ,2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 0 , 1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 0 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 0 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 0 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 0 , 1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 0 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 0 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 0 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 0 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 0 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 0 , 2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 0 , 2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 0 , 1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 0 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 0 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 1 ,1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 1 ,1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 1 ,1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 1 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 1 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 1 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 1 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 1 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 1 ,2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 1 ,2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 1 ,2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 1 , 1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 1 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 1 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 1 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 1 , 1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 1 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 1 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 1 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 1 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 1 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 1 , 2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 1 , 2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 1 , 1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 1 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 1 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 2 ,1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 2 ,1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 2 ,1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 2 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 2 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 2 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 2 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 2 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 2 ,2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 2 ,2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 2 ,2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 2 , 1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 2 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 2 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 2 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 2 , 1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 2 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 2 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 2 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 2 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 2 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 2 , 2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 2 , 2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 2 , 1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 2 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 2 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 3 ,1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 3 ,1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 3 ,1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 3 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 3 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 3 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 3 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 3 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 3 ,2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 3 ,2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 3 ,2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 3 , 1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 3 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 3 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 3 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 3 , 1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 3 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 3 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 3 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 3 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 3 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 3 , 2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 3 , 2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 3 , 1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 3 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 3 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 4 ,1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 4 ,1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 4 ,1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 4 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 4 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 4 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 4 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 4 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 4 ,2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 4 ,2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 4 ,2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 4 , 1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 4 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 4 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 4 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 4 , 1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 4 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 4 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 4 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 4 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 4 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 4 , 2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 4 , 2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 4 , 1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 4 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 4 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 5 ,1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 5 ,1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 5 ,1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 5 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 5 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 5 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 5 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 5 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 5 ,2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 5 ,2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 5 ,2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 5 , 1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 5 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 5 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 5 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 5 , 1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 5 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 5 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(1, 5 , -2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 5 , -1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(2, 5 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(0, 5 , 2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-1, 5 , 2)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 5 , 1)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 5 , 0)).isEmpty() && b.getWorld().getBlockAt(b.getLocation().add(-2, 5 , -1)).isEmpty()) {
				p.playSound(p.getLocation(), Sound.ANVIL_USE, 1F, 1F);
				
				b.setType(Material.WOOL);
				b.setData((byte)3);
				
				b.getWorld().getBlockAt(b.getLocation().add(1, 0 , 1)).setType(Material.SMOOTH_STAIRS);
				b.getWorld().getBlockAt(b.getLocation().add(0, 0 , 1)).setType(Material.SMOOTH_STAIRS);
				b.getWorld().getBlockAt(b.getLocation().add(-1, 0 , 1)).setType(Material.SMOOTH_STAIRS);
				b.getWorld().getBlockAt(b.getLocation().add(-1, 0 , 0)).setType(Material.SMOOTH_STAIRS);
				b.getWorld().getBlockAt(b.getLocation().add(-1, 0 , -1)).setType(Material.SMOOTH_STAIRS);
				b.getWorld().getBlockAt(b.getLocation().add(0, 0 , -1)).setType(Material.SMOOTH_STAIRS);
				b.getWorld().getBlockAt(b.getLocation().add(1, 0 , -1)).setType(Material.SMOOTH_STAIRS);
				b.getWorld().getBlockAt(b.getLocation().add(1, 0 , 0)).setType(Material.SMOOTH_STAIRS);
				
				setStairs(b.getWorld().getBlockAt(b.getLocation().add(-1, 0 , 0)), Material.SMOOTH_STAIRS, BlockFace.EAST, false);
				setStairs(b.getWorld().getBlockAt(b.getLocation().add(-1, 0 , -1)), Material.SMOOTH_STAIRS, BlockFace.SOUTH, false);
				setStairs(b.getWorld().getBlockAt(b.getLocation().add(0, 0 , -1)), Material.SMOOTH_STAIRS, BlockFace.SOUTH, false);
				setStairs(b.getWorld().getBlockAt(b.getLocation().add(1, 0 , -1)), Material.SMOOTH_STAIRS, BlockFace.WEST, false);
				setStairs(b.getWorld().getBlockAt(b.getLocation().add(1, 0 , 0)), Material.SMOOTH_STAIRS, BlockFace.WEST, false);
				
				for(int x = -1; x <= 1; x++) { 
					for(int y = 0; y <= 5; y++) { 
						for(int z = -1; z <= 1; z++) { 
							List<Location> locs = (List<Location>) Main.getPlugin(Main.class).getConfig().get(fac.getId()+".geradores");
							
							locs.add(new Location(e.getBlock().getWorld(), x, y, z));
						}
					}
				}
				
			}else {
				p.sendMessage("§cO local não possui espaço suficiente!");
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1F, 1F);
			}
			}else {
				p.sendMessage("§cVocê só pode colocar em terras de sua facção!");
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1F, 1F);
			}
		}
	}
}
