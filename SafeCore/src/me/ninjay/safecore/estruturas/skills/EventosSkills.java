package me.ninjay.safecore.estruturas.skills;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.safecore.comandos.chat.ComandoLocal;
import me.ninjay.safecore.main.Main;
import me.ninjay.safecore.utils.Mine;

public class EventosSkills implements Listener {

	private static ArrayList<Player> dn = new ArrayList<>();
	private static HashMap<Player, String> ps = new HashMap<>();

	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equalsIgnoreCase("Escolha uma categoria")
				|| e.getInventory().getTitle().contains("Habilidades")) {
			e.setCancelled(true);
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Suas")) {
					// sword
					// axe
					// mining
					// excavation
					// acrobatic
					// wizard

					Inventory menu = Mine.newInventory("Habilidades de " + p.getName(), 9 * 3);
					ItemStack voltar = Mine.newItem(Material.ARROW, "§aVoltar");
					ItemStack head = Mine.newHead("§6§lHabilidades de " + p.getName(), p.getName(), 1, " ",
							" §7Nível total: " + SkillsAPI.getNvlTotal(p), " ");
					ItemStack sword = Mine.newItem(Material.DIAMOND_SWORD, "§6§lEspadas", 1, 0, " ",
							" §7Nível: " + SkillsAPI.getNvl(p, "sword"), " ", "§8[/espadas]");
					ItemStack axe = Mine.newItem(Material.DIAMOND_AXE, "§6§lMachado", 1, 0, " ",
							" §7Nível: " + SkillsAPI.getNvl(p, "axe"), " ", "§8[/machado]");
					ItemStack mining = Mine.newItem(Material.DIAMOND_PICKAXE, "§6§lMineração", 1, 0, " ",
							" §7Nível: " + SkillsAPI.getNvl(p, "mining"), " ", "§8[/mineracao]");
					ItemStack excavation = Mine.newItem(Material.DIAMOND_SPADE, "§6§lEscavação", 1, 0, " ",
							" §7Nível: " + SkillsAPI.getNvl(p, "excavation"), " ", "§8[/escavacao]");
					ItemStack acrobatic = Mine.newItem(Material.DIAMOND_BOOTS, "§6§lAcrobacia", 1, 0, " ",
							" §7Nível: " + SkillsAPI.getNvl(p, "acrobatic"), " ", "§8[/acrobacia]", " ");
					ItemStack wizard = Mine.newItem(Material.BLAZE_ROD, "§6§lFeiticeiro", 1, 0, " ",
							" §7Nível: " + SkillsAPI.getNvl(p, "wizard"), " ", "§8[/feiticeiro]", " ");

					for (int i = 0; i < 9 * 3; i++) {
						menu.setItem(i, Mine.newItem(Material.STAINED_GLASS_PANE, " ", 1, 0));
					}

					menu.setItem(Mine.getPosition(2, 5), head);
					menu.setItem(Mine.getPosition(2, 2), sword);
					menu.setItem(Mine.getPosition(2, 3), axe);
					menu.setItem(Mine.getPosition(2, 4), mining);
					menu.setItem(Mine.getPosition(2, 6), excavation);
					menu.setItem(Mine.getPosition(2, 7), acrobatic);
					menu.setItem(Mine.getPosition(2, 8), wizard);
					menu.setItem(Mine.getPosition(3, 9), voltar);

					p.openInventory(menu);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("outros jogadores")) {
					p.getOpenInventory().close();
					ComandoLocal.localoff.add(p);
					dn.add(p);
					p.sendMessage(
							"§a§lDigite o nick do jogador.\n \n§7caso queira cancelar digite 'cancelar' no chat.");
				}
				ItemStack voltar = Mine.newItem(Material.ARROW, "§aVoltar");
				if (e.getCurrentItem().isSimilar(voltar)) {
					p.getOpenInventory().close();
					p.chat("/skills");
				}
			}
		}
	}

	@EventHandler
	public void aoFalar(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();

		if (dn.contains(p)) {
			if (e.getMessage().equalsIgnoreCase("cancelar")) {
				p.sendMessage("§cAção cancelada.");
				ComandoLocal.localoff.remove(p);
				dn.remove(p);
				return;
			}
			ps.put(p, e.getMessage());
			if (SkillsAPI.getConfig().contains(ps.get(p))) {
				Inventory menu = Mine.newInventory("Habilidades de " + ps.get(p), 9 * 3);
				ItemStack voltar = Mine.newItem(Material.ARROW, "§aVoltar");
				ItemStack head = Mine.newHead("§6§lHabilidades de " + ps.get(p), ps.get(p), 1, " ",
						" §7Nível total: " + SkillsAPI.getNvlTotal(Bukkit.getPlayer(ps.get(p))), " ");
				ItemStack sword = Mine.newItem(Material.DIAMOND_SWORD, "§6§lEspadas", 1, 0, " ",
						" §7Nível: " + SkillsAPI.getNvl(Bukkit.getPlayer(ps.get(p)), "sword"), " ", "§8[/espadas]");
				ItemStack axe = Mine.newItem(Material.DIAMOND_AXE, "§6§lMachado", 1, 0, " ",
						" §7Nível: " + SkillsAPI.getNvl(Bukkit.getPlayer(ps.get(p)), "axe"), " ", "§8[/machado]");
				ItemStack mining = Mine.newItem(Material.DIAMOND_PICKAXE, "§6§lMineração", 1, 0, " ",
						" §7Nível: " + SkillsAPI.getNvl(Bukkit.getPlayer(ps.get(p)), "mining"), " ", "§8[/mineracao]");
				ItemStack excavation = Mine.newItem(Material.DIAMOND_SPADE, "§6§lEscavação", 1, 0, " ",
						" §7Nível: " + SkillsAPI.getNvl(Bukkit.getPlayer(ps.get(p)), "excavation"), " ",
						"§8[/escavacao]");
				ItemStack acrobatic = Mine.newItem(Material.DIAMOND_BOOTS, "§6§lAcrobacia", 1, 0, " ",
						" §7Nível: " + SkillsAPI.getNvl(Bukkit.getPlayer(ps.get(p)), "acrobatic"), " ",
						"§8[/acrobacia]", " ");
				ItemStack wizard = Mine.newItem(Material.BLAZE_ROD, "§6§lFeiticeiro", 1, 0, " ",
						" §7Nível: " + SkillsAPI.getNvl(Bukkit.getPlayer(ps.get(p)), "wizard"), " ", "§8[/feiticeiro]",
						" ");

				for (int i = 0; i < 9 * 3; i++) {
					menu.setItem(i, Mine.newItem(Material.STAINED_GLASS_PANE, " ", 1, 0));
				}
				menu.setItem(Mine.getPosition(2, 5), head);
				menu.setItem(Mine.getPosition(2, 2), sword);
				menu.setItem(Mine.getPosition(2, 3), axe);
				menu.setItem(Mine.getPosition(2, 4), mining);
				menu.setItem(Mine.getPosition(2, 6), excavation);
				menu.setItem(Mine.getPosition(2, 7), acrobatic);
				menu.setItem(Mine.getPosition(2, 8), wizard);
				menu.setItem(Mine.getPosition(3, 9), voltar);

				p.openInventory(menu);
				p.sendMessage("§aConsultando habilidades de " + ps.get(p) + "...");
				dn.remove(p);
				ComandoLocal.localoff.remove(p);
			} else {
				p.sendMessage("§cJogador não encontrado no banco de dados.");
				dn.remove(p);
				ComandoLocal.localoff.remove(p);
			}
		}
	}

	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		SkillsAPI.addNvl(p, "sword", 0);
		SkillsAPI.addNvl(p, "axe", 0);
		SkillsAPI.addNvl(p, "mining", 0);
		SkillsAPI.addNvl(p, "excavation", 0);
		SkillsAPI.addNvl(p, "acrobatic", 0);
		SkillsAPI.addNvl(p, "wizard", 0);

		SkillsAPI.addXp(p, 0, "sword");
		SkillsAPI.addXp(p, 0, "axe");
		SkillsAPI.addXp(p, 0, "mining");
		SkillsAPI.addXp(p, 0, "excavation");
		SkillsAPI.addXp(p, 0, "acrobatic");
		SkillsAPI.addXp(p, 0, "wizard");

		SkillsAPI.addNvlTotal(p, 0);
		
		if(SkillsAPI.getNvl(p, "sword") == 0) {
			SkillsAPI.setXpNec(p, SkillsAPI.skills.getInt("sword.XpInicial"), "sword");
		}
		if(SkillsAPI.getNvl(p, "axe") == 0) {
			SkillsAPI.setXpNec(p, SkillsAPI.skills.getInt("axe.XpInicial"), "axe");
		}
		if(SkillsAPI.getNvl(p, "mining") == 0) {
			SkillsAPI.setXpNec(p, SkillsAPI.skills.getInt("mining.XpInicial"), "mining");
		}
		if(SkillsAPI.getNvl(p, "excavation") == 0) {
			SkillsAPI.setXpNec(p, SkillsAPI.skills.getInt("excavation.XpInicial"), "excavation");
		}
		if(SkillsAPI.getNvl(p, "acrobatic") == 0) {
			SkillsAPI.setXpNec(p, SkillsAPI.skills.getInt("acrobatic.XpInicial"), "acrobatic");
		}
		if(SkillsAPI.getNvl(p, "wizard") == 0) {
			SkillsAPI.setXpNec(p, SkillsAPI.skills.getInt("wizard.XpInicial"), "wizard");
		}
	}

}
