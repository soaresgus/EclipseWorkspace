package me.ninjay.ossosmobs.estruturas;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import me.ninjay.ossosmobs.main.Main;
import me.ninjay.ossosmobs.utils.Mine;

public class ItensAPI {
	
	public static ItemStack raiox = Mine.newItem(Material.RED_CONCRETE, "§dScanner de Raio-X", 1, 0);
	public static ItemStack patela = Mine.newItem(Material.BONE, "§fPatela", 1, 0);
	public static ItemStack tibia = Mine.newItem(Material.BONE, "§fTibia", 1, 0);
	public static ItemStack fibula = Mine.newItem(Material.BONE, "§fFibula", 1, 0);
	public static ItemStack femur = Mine.newItem(Material.BONE, "§fFemur", 1, 0);
	public static ItemStack tarso = Mine.newItem(Material.BONE, "§fTarso", 1, 0);
	public static ItemStack umero = Mine.newItem(Material.BONE, "§fUmero", 1, 0);
	public static ItemStack escapula = Mine.newItem(Material.BONE, "§fEscapula", 1, 0);
	public static ItemStack coluna = Mine.newItem(Material.BONE, "§fColuna vertebral", 1, 0);
	public static ItemStack costela = Mine.newItem(Material.BONE, "§fCostela", 1, 0);
	public static ItemStack clavicula = Mine.newItem(Material.BONE, "§fClavicula", 1, 0);
	public static ItemStack ossoq = Mine.newItem(Material.BONE, "§fOsso quebrado", 1, 0);
	public static ItemStack ossozumbi = Mine.newItem(Material.BONE, "§2Osso de zumbi", 1, 0);
	public static ItemStack ossocreeper = Mine.newItem(Material.BONE, "§2Osso de creeper", 1, 0);
	public static ItemStack ossoaranha = Mine.newItem(Material.BONE, "§4Osso de aranha", 1, 0);
	public static ItemStack ossoesqueleto = Mine.newItem(Material.BONE, "§7Osso de esqueleto", 1, 0);
	public static ItemStack ossowither = Mine.newItem(Material.BONE, "§8Osso de esqueleto wither", 1, 0);
	public static ItemStack ossovillager = Mine.newItem(Material.BONE, "§6Osso de villager", 1, 0);
	public static ItemStack ossoovelha = Mine.newItem(Material.BONE, "§6Osso de ovelha", 1, 0);
	public static ItemStack ossogalinha = Mine.newItem(Material.BONE, "§6Osso de galinha", 1, 0);
	public static ItemStack ossovaca = Mine.newItem(Material.BONE, "§7Osso de vaca", 1, 0);
	public static ItemStack ossoporco = Mine.newItem(Material.BONE, "§cOsso de porco", 1, 0);

	public static void customCraft() {
		ShapedRecipe rrr = new ShapedRecipe(raiox);
		
		rrr.shape("$$$", "@#@", "@@@");
		
		rrr.setIngredient('@', Material.WHITE_STAINED_GLASS);
		rrr.setIngredient('#', Material.REDSTONE);
		rrr.setIngredient('$', Material.IRON_INGOT);
		Main.getPlugin(Main.class).getServer().addRecipe(rrr);
	}
	
}
