package me.ninjay.poo.estruturas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.ninjaapi.utils.Mine;

public class CaixaRodante extends BukkitRunnable {
	private int holoAmount = 8;
	private int animationRadios=7;
	private List<Location> posicoes = new ArrayList<>();
	private Map<Integer, ArmorStand> stands = new HashMap<>();
	private ArrayList<ItemStack> itens = new ArrayList<>();
	private int contagem;
	private Player player;

	public CaixaRodante(Player player) {
		this.posicoes.addAll(getCircle(player.getLocation().add(0, 2, 0), animationRadios, holoAmount));
		int id = 0;
		for (Location posicao : posicoes) {

			ArmorStand holo = Mine.newHologram(posicao, " ");
			holo.setSmall(true);
			holo.setHelmet(Mine.getRandomItem(itens));
			stands.put(id, holo);

			id++;
		}
	}

	public int getHoloAmount() {
		return holoAmount;
	}

	public void setHoloAmount(int holoAmount) {
		this.holoAmount = holoAmount;
	}

	public int getAnimationRadios() {
		return animationRadios;
	}

	public void setAnimationRadios(int animationRadios) {
		this.animationRadios = animationRadios;
	}

	public ArrayList<ItemStack> getItens() {
		return itens;
	}

	public void setItens(ArrayList<ItemStack> itens) {
		this.itens = itens;
	}

	@Override
	public void run() {
		contagem++;
		mover();
	}

	private void mover() {
		for (int x= 0;x<holoAmount;x++) {
			ArmorStand holoanterior = stands.get(x-1);
			ArmorStand holoatual = stands.get(x);
			holoanterior.setHelmet(holoatual.getHelmet());
		}
		ArmorStand ultimoholo = stands.get(holoAmount-1);
		ultimoholo.setHelmet(Mine.getRandomItem(itens));
		if (contagem==30) {
			ItemStack premio = ultimoholo.getHelmet();
			
			player.getInventory().addItem(premio);
			cancel();
			
		}
	}

	public List<Location> getPosicoes() {
		return posicoes;
	}

	public void setPosicoes(List<Location> posicoes) {
		this.posicoes = posicoes;
	}

	public static ArrayList<Location> getCircle(Location center, double radius, int amount) {
		World world = center.getWorld();
		double increment = (2 * Math.PI) / amount;
		ArrayList<Location> locations = new ArrayList<Location>();
		for (int i = 0; i < amount; i++) {
			double angle = i * increment;
			double x = center.getX() + (radius * Math.cos(angle));
			double z = center.getZ() + (radius * Math.sin(angle));
			locations.add(new Location(world, x, center.getY(), z));
		}
		return locations;
	}
	public static ArrayList<Location> getCircle2(Location center, double radius, int amount) {
		World world = center.getWorld();
		double increment = (2 * Math.PI) / amount;
		ArrayList<Location> locations = new ArrayList<Location>();
		for (int i = 0; i < amount; i++) {
			double angle = i * increment;
			double z = center.getZ() + (radius * Math.cos(angle));
			double y = center.getY() + (radius * Math.sin(angle));
			locations.add(new Location(world, center.getX(), y, z));
		}
	
		return locations;
	}
	public  static List<Location> getCircleBlocks(Location loc, double radius, double height, boolean hollow,
            boolean sphere) {
        ArrayList<Location> circleblocks = new ArrayList<Location>();
        double cx = loc.getBlockX();
        double cy = loc.getBlockY();
        double cz = loc.getBlockZ();

        for (double y = (sphere ? cy - radius : cy); y < (sphere ? cy + radius : cy + height + 1); y++) {
            for (double x = cx - radius; x <= cx + radius; x++) {
                for (double z = cz - radius; z <= cz + radius; z++) {
                    double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z) + (sphere ? (cy - y) * (cy - y) : 0);

                    if (dist < radius * radius && !(hollow && dist < (radius - 1) * (radius - 1))) {
                        Location l = new Location(loc.getWorld(), x, y, z);
                        circleblocks.add(l);
                    }
                }
            }
        }

        return circleblocks;
    }
	public static ArrayList<Location> getCircle3(Location center, double radius, int amount) {
		World world = center.getWorld();
		double increment = (2 * Math.PI) / amount;
		ArrayList<Location> locations = new ArrayList<Location>();
		for (int i = 0; i < amount; i++) {
			double angle = i * increment;
			double x = center.getX() + (radius * Math.cos(angle));
			double y = center.getY() + (radius * Math.sin(angle));
			locations.add(new Location(world, x, y, center.getZ()));
		}
		return locations;
	}

	public Map<Integer, ArmorStand> getStands() {
		return stands;
	}

	public void setStands(Map<Integer, ArmorStand> stands) {
		this.stands = stands;
	}

	public int getContagem() {
		return contagem;
	}

	public void setContagem(int contagem) {
		this.contagem = contagem;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
