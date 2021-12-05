package me.ninjay.safecore.estruturas.skills;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import me.ninjay.safecore.main.Main;
import me.ninjay.safecore.utils.Mine;

public class EventosSkillsHab implements Listener {

	private static ArrayList<Player> iu = new ArrayList<>();
	private static ArrayList<Player> sc = new ArrayList<>();
	private static ArrayList<Player> mac = new ArrayList<>();
	private static ArrayList<Player> mtc = new ArrayList<>();
	private static ArrayList<Player> canc = new ArrayList<>();
	private static ArrayList<Player> cegc = new ArrayList<>();
	
	private static Integer ie = SkillsAPI.skills.getInt("sword.SangramentoCooldown");
	private static Integer i2 = SkillsAPI.skills.getInt("sword.SangramentoCooldown");
	private static Integer ci = SkillsAPI.skills.getInt("sword.ContraAtaqueCooldown");
	private static Integer ai = SkillsAPI.skills.getInt("axe.KnockCooldown");
	private static Integer ri = SkillsAPI.skills.getInt("axe.RaioCooldown");
	private static Integer wcani = SkillsAPI.skills.getInt("wizard.CanseiraCooldown");
	private static Integer wsmni = SkillsAPI.skills.getInt("wizard.FlashbangCooldown");
	
	public static ItemStack cegueira = Mine.newItem("§bRastro de fumaça", Material.FLINT, 1, 0," "," §7Vire uma fumaça e confunda seus inimigos.");
	public static ItemStack cancaco = Mine.newItem("§bCansaço", Material.ANVIL, 1,0, " ", " §7Canse todos os seus inimigos.");

	@EventHandler
	public void EspadasSangramento(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action ac = e.getAction();

		if (!iu.contains(p)) {
			if (!sc.contains(p)) {
				if (p.getItemInHand().getType() == Material.DIAMOND_SWORD
						|| p.getItemInHand().getType() == Material.IRON_SWORD
						|| p.getItemInHand().getType() == Material.GOLD_SWORD
						|| p.getItemInHand().getType() == Material.STONE_SWORD
						|| p.getItemInHand().getType() == Material.WOOD_SWORD) {
				if (ac == Action.RIGHT_CLICK_AIR || ac == Action.RIGHT_CLICK_BLOCK) {
					if (p.getItemInHand() != null) {
							if (SkillsAPI.getNvl(p, "sword") >= SkillsAPI.skills.getInt("sword.NvlMed")) {
								p.sendMessage("§aVocê ativou o sangramento e possui "
										+ SkillsAPI.skills.getInt("sword.TempoUsoSangramento")
										+ " segundos para utilizar.");
								iu.add(p);
								if (!sc.contains(p)) {
									new BukkitRunnable() {
										int i = SkillsAPI.skills.getInt("sword.TempoUsoSangramento");

										@Override
										public void run() {
											if (!(ie <= 2)) {
												i--;
												if (i <= 0) {
													cancel();
													p.sendMessage("§cTempo de uso encerrado, cooldown iniciado..");
													iu.remove(p);
													sc.add(p);
													new BukkitRunnable() {
														@Override
														public void run() {
															i2--;
															if (i2 <= 0) {
																cancel();
																p.sendMessage("§aSangramento recarregado!");
																sc.remove(p);
															}
														}
													}.runTaskTimerAsynchronously(Main.instance, 20, 20);

												}
											} else {
												cancel();
											}
										}
									}.runTaskTimerAsynchronously(Main.instance, 20, 20);
								} else {
									return;
								}
							} else {
								p.sendMessage("§cVocê não possui nível suficiente para utilizar o sangramento.");
							}
						}
					}else {
						return;
					}
				}
			} else if (ac == Action.RIGHT_CLICK_AIR || ac == Action.RIGHT_CLICK_BLOCK) {
				if (p.getItemInHand().getType() == Material.DIAMOND_SWORD
						|| p.getItemInHand().getType() == Material.IRON_SWORD
						|| p.getItemInHand().getType() == Material.GOLD_SWORD
						|| p.getItemInHand().getType() == Material.STONE_SWORD
						|| p.getItemInHand().getType() == Material.WOOD_SWORD) {
				p.sendMessage("§cAguarde " + Mine.formatarTempoMS(i2) + " para utilizar o sangramento.");
			}
			}
		} else if (ac == Action.RIGHT_CLICK_AIR || ac == Action.RIGHT_CLICK_BLOCK) {
			if (p.getItemInHand().getType() == Material.DIAMOND_SWORD
					|| p.getItemInHand().getType() == Material.IRON_SWORD
					|| p.getItemInHand().getType() == Material.GOLD_SWORD
					|| p.getItemInHand().getType() == Material.STONE_SWORD
					|| p.getItemInHand().getType() == Material.WOOD_SWORD) {
			p.sendMessage("§cVocê já está usando o sangramento.");
		}
		}
		
	}

	@EventHandler
	public void SangramentoUsar(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			if (e.getDamager() instanceof Player) {

				Player p = (Player) e.getDamager();

				if (p.getItemInHand().getType() == Material.DIAMOND_SWORD
						|| p.getItemInHand().getType() == Material.IRON_SWORD
						|| p.getItemInHand().getType() == Material.GOLD_SWORD
						|| p.getItemInHand().getType() == Material.STONE_SWORD
						|| p.getItemInHand().getType() == Material.WOOD_SWORD) {
					if (p.getItemInHand() != null) {
						if (iu.contains(p)) {
							p.sendMessage("§aSangramento aplicado em " + e.getEntity().getName());
							iu.remove(p);
							e.getEntity().sendMessage("§aVocê recebeu sangramento de " + p.getName());
							new BukkitRunnable() {
								int i = 40;
								Player ep = Bukkit.getPlayer(e.getEntity().getName());

								@Override
								public void run() {
									i--;
									if (i == 39) {
										ep.damage(4.0);
										ep.sendMessage("§4Você está sangrando.");
										ep.getWorld().playSound(ep.getLocation(), Sound.CAT_HIT, 1L, 1L);
										ep.getWorld().spigot().playEffect(ep.getLocation(), Effect.TILE_BREAK, 152, 0,
												0.5F, 1, 0.5F, 0.002F, 100, 500);
									}
									if (i == 20) {
										ep.damage(4.0);
										ep.sendMessage("§4Você está sangrando.");
										ep.getWorld().playSound(ep.getLocation(), Sound.CAT_HIT, 1L, 1L);
										ep.getWorld().spigot().playEffect(ep.getLocation(), Effect.TILE_BREAK, 152, 0,
												0.5F, 1, 0.5F, 0.002F, 100, 500);
									}
									if (i == 10) {
										ep.damage(4.0);
										ep.sendMessage("§4Você está sangrando.");
										ep.getWorld().playSound(ep.getLocation(), Sound.CAT_HIT, 1L, 1L);
										ep.getWorld().spigot().playEffect(ep.getLocation(), Effect.TILE_BREAK, 152, 0,
												0.5F, 1, 0.5F, 0.002F, 100, 500);
									}
									if (i == 1) {
										ep.damage(4.0);
										ep.sendMessage("§4Você está sangrando.");
										ep.getWorld().playSound(ep.getLocation(), Sound.CAT_HIT, 1L, 1L);
										ep.getWorld().spigot().playEffect(ep.getLocation(), Effect.TILE_BREAK, 152, 0,
												0.5F, 1, 0.5F, 0.002F, 100, 500);
									}
									if (i <= 0) {
										cancel();
										ep.sendMessage("§4Sangramento finalizado.");
									}
								}
							}.runTaskTimerAsynchronously(Main.getInstance(), 20, 20);
							sc.add(p);
							new BukkitRunnable() {
								@Override
								public void run() {
									ie--;
									if (ie <= 0) {
										cancel();
										p.sendMessage("§aSangramento recarregado!");
										sc.remove(p);
									}
								}
							}.runTaskTimerAsynchronously(Main.instance, 20, 20);
						}
					}
				}else {
					return;
				}
			}
		}
	}

	@EventHandler
	public void EspadasContraAtaque(EntityDamageByEntityEvent e) {

		if (e.getEntity() instanceof Player) {
			if (e.getDamager() instanceof Player) {

				Player p = (Player) e.getEntity();

				ArrayList<Player> cac = new ArrayList<>();

				if (p.getItemInHand().getType() == Material.DIAMOND_SWORD
						|| p.getItemInHand().getType() == Material.IRON_SWORD
						|| p.getItemInHand().getType() == Material.GOLD_SWORD
						|| p.getItemInHand().getType() == Material.STONE_SWORD
						|| p.getItemInHand().getType() == Material.WOOD_SWORD) {
					if (p.getItemInHand() != null) {
						if (SkillsAPI.getNvl(p, "sword") >= SkillsAPI.skills.getInt("sword.NvlMax")) {
							if (p.isSneaking() == true) {
								if (!(cac.contains(p))) {
									cac.add(p);
									new BukkitRunnable() {

										@Override
										public void run() {
											ci--;
											if (ci <= 0) {
												cancel();
												p.sendMessage("§aContra Ataque recarregado.");
												cac.remove(p);
											}
										}
									}.runTaskTimerAsynchronously(Main.instance, 20, 20);
									p.sendMessage("Contra Ataque aplicado em " + e.getDamager().getName());
									e.getDamager().sendMessage("Contra Ataque recebido de " + e.getEntity().getName());
									e.getDamager().getWorld().playSound(e.getDamager().getLocation(),
											Sound.ENDERDRAGON_HIT, 1F, 1F);
									Bukkit.getPlayer(e.getDamager().getName()).damage(4.0);
								} else {
									p.sendMessage("§cAguarde " + Mine.formatarTempoHMS(ci)
											+ " para utilizar o contra ataque.");
								}
							} else {
								return;
							}
						} else {
							p.sendMessage("§cVocê não possui o nível suficiente para utilizar o contra ataque.");
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void MachadoAfastamento(PlayerInteractEvent e) {

		Player p = e.getPlayer();
		Action ac = e.getAction();

		if (ac == Action.RIGHT_CLICK_BLOCK) {
			if (p.getItemInHand() != null) {
				if (p.getItemInHand().getType() == Material.DIAMOND_AXE
						|| p.getItemInHand().getType() == Material.IRON_AXE
						|| p.getItemInHand().getType() == Material.GOLD_AXE
						|| p.getItemInHand().getType() == Material.STONE_AXE
						|| p.getItemInHand().getType() == Material.WOOD_AXE) {
					if (SkillsAPI.getNvl(p, "axe") >= SkillsAPI.skills.getInt("axe.NvlMed")) {
						if (!mac.contains(p)) {
							mac.add(p);
							p.sendMessage("§aVocê utilizou a impulsão.");
							p.getWorld().playSound(p.getLocation(), Sound.ANVIL_LAND, 1F, 1F);
							for (Entity prox : p.getNearbyEntities(5.0, 5.0, 5.0)) {
								prox.setVelocity(new Vector(prox.getVelocity().getX(), 1, p.getVelocity().getZ()));
							}
							int id = p.getLocation().getBlock().getRelative(BlockFace.DOWN).getTypeId();
							int data = p.getLocation().getBlock().getRelative(BlockFace.DOWN).getData();
							if (id != 0) {
								p.getWorld().spigot().playEffect(p.getLocation(), Effect.TILE_BREAK, id, data, 2.5F,
										0.5F, 2.5F, 0.002F, 1000, 500);
							} else {
								p.getWorld().spigot().playEffect(p.getLocation(), Effect.TILE_BREAK, 4, 0, 2.5F, 0.5F,
										2.5F, 0.002F, 1000, 500);
							}
							new BukkitRunnable() {
								@Override
								public void run() {
									ai--;
									if (ai <= 0) {
										cancel();
										p.sendMessage("§aImpulsão recarregada.");
										mac.remove(p);
										ai = SkillsAPI.skills.getInt("axe.KnockCooldown");
									}
								}
							}.runTaskTimerAsynchronously(Main.instance, 20, 20);
						} else {
							p.sendMessage("§cAguarde " + Mine.formatarTempoHMS(ai) + " para utilizar a impulsão.");
							return;
						}
					} else {
						p.sendMessage("§cVocê não possui o nível suficiente para utilizar a impulsão.");
					}

				}
			}
		}
	}

	@EventHandler
	public void MachadoTrovao(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();

		if (p.getItemInHand() != null) {
			if (p.getItemInHand().getType() == Material.DIAMOND_AXE || p.getItemInHand().getType() == Material.IRON_AXE
					|| p.getItemInHand().getType() == Material.GOLD_AXE
					|| p.getItemInHand().getType() == Material.STONE_AXE
					|| p.getItemInHand().getType() == Material.WOOD_AXE) {
				if (SkillsAPI.getNvl(p, "axe") >= SkillsAPI.skills.getInt("axe.NvlMax")) {
					if (!mtc.contains(p)) {
						mtc.add(p);
						p.sendMessage("§aVocê utilizou o trovão.");
						p.getWorld().strikeLightningEffect(e.getRightClicked().getLocation());
						if (e.getRightClicked() instanceof Player) {
							Bukkit.getPlayer(e.getRightClicked().getName()).damage(4.0);
						}
						new BukkitRunnable() {
							@Override
							public void run() {
								ri--;
								if (ri <= 0) {
									cancel();
									p.sendMessage("§aTrovão recarregado.");
									ri = SkillsAPI.skills.getInt("axe.RaioCooldown");
									mtc.remove(p);
								}
							}
						}.runTaskTimerAsynchronously(Main.instance, 20, 20);
					} else {
						p.sendMessage("§cAguarde " + Mine.formatarTempoHMS(ri) + " para utilizar o trovão.");
					}
				} else {
					p.sendMessage("§cVocê não possui o nível suficiente para utilizar o trovão.");
				}
			}
		}
	}

	@EventHandler
	public void AcrobaciaRolamento(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			if (e.getCause() == DamageCause.FALL) {
				Player p = (Player) e.getEntity();
				if (SkillsAPI.getNvl(p, "acrobatic") >= SkillsAPI.skills.getInt("acrobatic.NvlMed")) {
					if (Mine.getChance(SkillsAPI.skills.getDouble("acrobatic.Rolamento50"))) {
						p.sendMessage("§aVocê foi salvo pelo rolamento.");
						p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*3, 4));
					}
				}
				if (SkillsAPI.getNvl(p, "acrobatic") >= SkillsAPI.skills.getInt("acrobatic.NvlMax")) {
					if (Mine.getChance(SkillsAPI.skills.getDouble("acrobatic.Rolamento100"))) {
						p.sendMessage("§aVocê foi salvo pelo rolamento.");
						p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*3, 4));
					}
				}
			}
		}
	}

	@EventHandler
	public void FeiticeitoGeral(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action ac = e.getAction();

		ItemStack cajado = Mine.newItem(Material.BLAZE_ROD, "§bCajado de feiticeiro", 1, 0, " ",
				" §7Clique com o direito para acessar o menu.");

		if (p.getItemInHand() != null) {
			if (p.getItemInHand().isSimilar(cajado)) {
				if (ac == Action.RIGHT_CLICK_AIR) {
					Inventory menu = Mine.newInventory("Escolha um feitiço", 9 * 3);

					menu.setItem(Mine.getPosition(2, 3), cancaco);
					menu.setItem(Mine.getPosition(2, 7), cegueira);

					// p.getWorld().spigot().playEffect(p.getLocation(), Effect.LARGE_SMOKE, 0, 0,
					// 2.5F, 2.5F, 2.5F, 0.002F, 500, 500);
					p.openInventory(menu);
				}
			}
		}
	}

	@EventHandler
	public void FeiticeiroHab(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equalsIgnoreCase("escolha um feitiço") || e.getInventory().getTitle().equalsIgnoreCase("Receita")) {
			e.setCancelled(true);
			if (e.getCurrentItem() != null) {
				if(e.getCurrentItem().isSimilar(cancaco)) {
					if (e.getCurrentItem() != null) {
					if (SkillsAPI.getNvl(p, "wizard") >= SkillsAPI.skills.getInt("wizard.NvlMed")) {
						if (!canc.contains(p)) {
							canc.add(p);
							p.getOpenInventory().close();
							p.sendMessage("§aCansaço aplicado!");
							p.getWorld().playSound(p.getLocation(), Sound.BAT_IDLE, 1F, 1F);
							p.getWorld().spigot().playEffect(p.getLocation(), Effect.FIREWORKS_SPARK, 1, 0, 2.5F, 0.50F, 2.5F, 0.002F, 500, 500);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									wcani--;
									if(wcani <= 0) {
										cancel();
										wcani=SkillsAPI.skills.getInt("wizard.CanseiraCooldown");
										canc.remove(p);
										p.sendMessage("§aCansaço recarregado!");
									}
								}
							}.runTaskTimerAsynchronously(Main.instance, 20, 20);
							for(Entity prox : p.getNearbyEntities(5.0, 5.0, 5.0)) {
								if(prox instanceof Player) {
									Bukkit.getPlayer(prox.getName()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*5, 2));
								}
							}
						}else if(canc.contains(p)){
							p.getOpenInventory().close();
							p.sendMessage("§cAguarde "+Mine.formatarTempoHMS(wcani)+" para utilizar o cansaço.");
							return;
						}
					}else {
						p.sendMessage("§cVocê não possui o nível suficiente.");
					}
				}
				}
				if(e.getCurrentItem().isSimilar(cegueira)) {
					if (SkillsAPI.getNvl(p, "wizard") >= SkillsAPI.skills.getInt("wizard.NvlMax")) {
						if(!cegc.contains(p)) {
							cegc.add(p);
							p.getOpenInventory().close();
							p.sendMessage("§aRastro de fumaça ativado!");
							new BukkitRunnable() {
								int i = 10;
								@Override
								public void run() {
									i--;
									p.getWorld().spigot().playEffect(p.getLocation(), Effect.EXTINGUISH, 1, 0, 0, 0, 0, 0.002F, 3000, 500);
									p.getWorld().spigot().playEffect(p.getLocation(), Effect.LARGE_SMOKE, 0, 0, 2.5F, 2.5F, 2.5F, 0.002F, 500, 500);
									if(i <= 0) {
										cancel();
										i=10;
									}
								}
							}.runTaskTimerAsynchronously(Main.instance, 5, 5);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									wsmni--;
									if(wsmni <= 0) {
										cancel();
										wsmni=SkillsAPI.skills.getInt("wizard.FlashbangCooldown");
										cegc.remove(p);
										p.sendMessage("§aRastro de fumaça recarregado!");
									}
								}
							}.runTaskTimerAsynchronously(Main.instance, 20, 20);
						}else if(cegc.contains(p)) {
							p.sendMessage("§cAguarde "+Mine.formatarTempoHMS(wsmni)+" para utilizar o rastro de fumaça.");
						}
					}else {
						p.sendMessage("§cVocê não possui o nível suficiente.");
					}
				}
			}
		}
	}
}