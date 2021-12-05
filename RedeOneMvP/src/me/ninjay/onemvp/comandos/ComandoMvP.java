package me.ninjay.onemvp.comandos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.onemvp.estruturas.EstruturaAdmin;
import me.ninjay.onemvp.estruturas.EstruturaJogador;
import me.ninjay.onemvp.estruturas.EstruturaTempo;
import me.ninjay.onemvp.main.Main;

public class ComandoMvP implements CommandExecutor {

	@Override

	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage("§cComando não encontrado. Utilize /mvp ajuda.");
				return true;
			}
			String sub = args[0];
			if (sub.equalsIgnoreCase("ajuda")) {

				if (!p.hasPermission("mvp.admin")) {
					EstruturaJogador.ajudajog(p);
					return true;
				}
			}
			if (sub.equalsIgnoreCase("ajuda")) {
				if (p.hasPermission("mvp.admin")) {
					EstruturaAdmin.ajudastf(p);
					return true;
				}
			}
			if (sub.equalsIgnoreCase("entrar")) {
				if (Main.tempo == null) {
					p.sendMessage("§cO evento MvP não está acontecendo no momento.");
					return true;
				} else {
					if (Main.tempo == EstruturaTempo.PRE) {
						EstruturaJogador.entrar(p);
						Main.dentro.add(p);
						for(Player todos : Bukkit.getOnlinePlayers()) {
							if(todos.hasPermission("mvp.pvp")) {
								todos.getWorld().setPVP(false);
							}
									
						}
						return true;
					}
					if (Main.fora.contains(p)) {
						p.sendMessage("§cVocê já morreu, tente novamente na próxima vez.");
						return true;
					}
					if (Main.tempo == EstruturaTempo.JOGO) {
						p.sendMessage("§cO evento MvP já iniciou.");
						return true;
					}

					if (!p.hasPermission("mvp.admin")) {
						return true;
					}

				}

			}
			if (sub.equalsIgnoreCase("iniciar")) {
				if (p.hasPermission("mvp.admin")) {
					if (Main.mvp.contains("spawn_mvp")) {
						if (Main.tempo == null) {
							EstruturaAdmin.iniciar(p);
							new BukkitRunnable() {
								int i = 540;

								@Override
								public void run() {
									i--;
									if (i == 360) {
										Bukkit.broadcastMessage(
												"§e§lEvento - Mobs Vs Players\n \n§eO evento foi fechado e iniciado.\n ");
										Main.tempo = EstruturaTempo.JOGO;
										for (Player todos : Bukkit.getOnlinePlayers()) {
											if (todos.hasPermission("mvp.jogando")) {
												EstruturaJogador.inicio(todos);
											}
										}
									}

									if (i == 355) {
										for (int b = 0; b < 15; b++) {
											Wolf wolf = p.getWorld().spawn(Main.mvp.getLocation("mob1_mvp"),
													Wolf.class);
											wolf.setAngry(true);
											wolf.setMaxHealth(50.0);
											wolf.setHealth(50.0);
											wolf.setCustomName("§eLobo [25 ❤] Lvl. 15");
											wolf.setCustomNameVisible(true);
											wolf.setCanPickupItems(false);
										}
									}
									
									if (i == 180) {

										for (int r = 0; r < 20; r++) {
											Skeleton ske = p.getWorld().spawn(Main.mvp.getLocation("mob2_mvp"),
													Skeleton.class);
											ske.setMaxHealth(50.0);
											ske.setHealth(50.0);
											ske.setCustomName("§eEsqueleto [25 ❤] Lvl. 8");
											ske.setCustomNameVisible(true);
											ske.setSkeletonType(SkeletonType.NORMAL);
											ske.setFireTicks(0);
											ske.getEquipment().setHelmet(Mine.newItem(Material.SKULL, "."));
											ske.getEquipment().setItemInHand(Mine.newItem(Material.DIAMOND_SWORD, "."));
											ske.getEquipment().setHelmet(Mine.newItem(".", Material.SKULL, 1));
											ske.setCanPickupItems(false);
										}
									}
									

									if (i == 0) {
										cancel();

										Giant gi = p.getWorld().spawn(Main.mvp.getLocation("mob3_mvp"), Giant.class);
										gi.setMaxHealth(500.0);
										gi.setHealth(500.0);
										gi.setCustomName("§eGigante [250 ❤] Lvl. 372");
										gi.setCustomNameVisible(true);
										gi.getEquipment().setHelmet(Mine.newItem(".", Material.SKULL, 2));
										gi.setCanPickupItems(false);

									}
									
								
									

								}
								
							}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
						}
					}
				}

				if (sub.equalsIgnoreCase("iniciar")) {

					{
						if (Main.tempo == EstruturaTempo.PRE) {
							p.sendMessage("§cJá está acontecendo um evento mvp. Aguarde para iniciar outro.");
							return true;
						}
					}
					if (sub.equalsIgnoreCase("iniciar")) {
						if (!Main.mvp.contains("spawn_mvp")) {
							p.sendMessage("§cPrimeiro sete o spawn do evento. Utilize /mvp setspawn.");
							return true;
						}
					}
					if (sub.equalsIgnoreCase("setspawn")) {
						if (p.hasPermission("mvp.admin")) {
							EstruturaAdmin.setspawn(p);

						} else {
							return true;
						}
						if (sub.equalsIgnoreCase("setjogo")) {
							if (p.hasPermission("mvp.admin")) {
								EstruturaAdmin.setjogo(p);
							} else {
								return true;
							}
							if (sub.equalsIgnoreCase("setmorte")) {
								if (p.hasPermission("mvp.admin")) {
									EstruturaAdmin.setmorte(p);

								} else {
									return true;
								}
								if (sub.equalsIgnoreCase("setmob1")) {
									if (p.hasPermission("mvp.admin")) {
										EstruturaAdmin.setmob1(p);
									} else {
										return true;
									}
									if (sub.equalsIgnoreCase("setmob2")) {
										if (p.hasPermission("mvp.admin")) {

											EstruturaAdmin.setmob2(p);
										} else {
											return true;
										}
										if (sub.equalsIgnoreCase("setmob3")) {
											if (p.hasPermission("mvp.admin")) {
												EstruturaAdmin.setmob3(p);

											} else {
												return true;
											}
										}
									}
									if (sub.equalsIgnoreCase("iniciar")) {
										if (!p.hasPermission("mvp.admin")) {
											return true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}
