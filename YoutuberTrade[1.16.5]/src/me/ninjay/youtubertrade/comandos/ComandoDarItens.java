package me.ninjay.youtubertrade.comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;

import me.ninjay.youtubertrade.estruturas.ItensAPI;
import me.ninjay.youtubertrade.estruturas.NPC;
import me.ninjay.youtubertrade.utils.Mine;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			//Merchant merchant = Bukkit.createMerchant("Teste");
			
			//ArrayList<MerchantRecipe> recipes = new ArrayList<>();
			//MerchantRecipe recipe = new MerchantRecipe(Mine.newItem(Material.GRASS_BLOCK, null), 999999);
			//recipe.addIngredient(new ItemStack(Material.DIRT, 2));
			//recipes.add(recipe);
			
			//merchant.setRecipes(recipes);
			
			//p.openMerchant(merchant, true);
			
			//Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 0, 0);
			
			//NPC npc = new NPC(loc, "Minguado", "ewogICJ0aW1lc3RhbXAiIDogMTYyNTc1ODE1ODM3MywKICAicHJvZmlsZUlkIiA6ICJlMTZmODNhOTkyZjc0NzVmYmJjY2RhMTdiMTdlNWY1NyIsCiAgInByb2ZpbGVOYW1lIiA6ICJNaW5ndWFkbyIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS82ZjQzMmU4YTE1ODZiYjViNjNlMzg0ZDM3MGZiMDc2NjY0Mzk2NWM0MTQwOGFiNGIyOTBmOWY1OWI4MmU1ZmE4IiwKICAgICAgIm1ldGFkYXRhIiA6IHsKICAgICAgICAibW9kZWwiIDogInNsaW0iCiAgICAgIH0KICAgIH0KICB9Cn0=", "uP8vbwWYk6KGB9DGqUKMBo7uyVBILerPgUoqoWIvtQurGGTCIlgWN6jLzirYRllYdMr6yX96XigXlV6/5YK3z6zRQ5nZH0kTAy3FJK6ZxO7lJ5hKztWtoEBjRhhZsvtfjBT8Al9H1ucHhg7E7fQP1unpQVfea2ShraQnxX1uKhK06IT06/5KDpd3pWBdXK6Hkplp6/3IH0gpTFjN4KrjflOpp/ogTW1uijsY5awrtDz4yfc4fsRhimMu41IETlEIAne6o0x+hABHq6TOU+fDgGN2BTg6Uxhqv1BwNaPHuf8ojMiF9cWkq735o4Jur6/O6Bvph2RDoxDD/j1kz2aIMRyF3cr1hJfXJaGocfgtog+r9mSapCaqCiLN0m5MBnCa51avCkEG6MYpMJ4BC8LIk0lhczS4AaBRv0o/14Nz6D4MhrSANtkcDqXPKamQla2m0DC89otq99XGzHOyajatBVmegvZ0jyztfcp+RGKdnm0Lw5TIGkb16Ls0XPexFrEVaK78GQGOhO5uhO56USVFqc4PTlLAMuCC1+78TTKvFtzRDk/5xrdXLdbzOC9cPb6Fv3EsaQBQm3/vYKPpPYP4jrJyCHQO9ZFjaxaPEeGYI98odx8JWRedaeV6GSfV97hKlShpLrZxRT6gQNhja6No8jOh0U7OyL0QSldKb98PQ1Q=");
			//npc.remove(p);
			
			p.getInventory().addItem(ItensAPI.caixa());
			p.getInventory().addItem(ItensAPI.cash(1));
			p.getInventory().addItem(ItensAPI.geleia());
			p.getInventory().addItem(ItensAPI.mato());
		}
		return false;
	}

}
