package me.ninjay.oneperfil.tct.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.oneperfil.main.Main;
import me.ninjay.oneperfil.tct.estruturas.EstruturaAdmin;
import me.ninjay.oneperfil.tct.estruturas.EstruturaJogador;
import me.ninjay.oneperfil.tct.estruturas.EstruturaTempo2;
import net.eduard.api.lib.modules.VaultAPI;

public class ComandoTcT implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			boolean isEmpty = true;
			for (ItemStack item : p.getInventory().getContents()) {
				if (item != null) {
					isEmpty = false;
					break;
				}

			}
			if (args.length == 0) {
				p.sendMessage("§cComando não encontrado. Utilze /tct ajuda.");
				return true;
			}
			String sub = args[0];

			if (sub.equalsIgnoreCase("ajuda")) {
				if (!p.hasPermission("tct.admin")) {
					EstruturaJogador.ajudajog(p);
					return true;
				}
			}
			if (sub.equalsIgnoreCase("ajuda")) {
				if (p.hasPermission("tct.admin")) {
					EstruturaAdmin.ajudastf(p);
					return true;
				}
			}
			if(sub.equalsIgnoreCase("entrar")) {
				if (Main.tempo2 == EstruturaTempo2.PRE2) {
					if(isEmpty) {
					EstruturaJogador.entrar(p);
					//setar os itens em krl não esquece
					return true;
					
				}
		 }
			}
			if(sub.equalsIgnoreCase("entrar")) {
				if(!isEmpty) {
					p.sendMessage("§cVocê precisa estar com o invetário vazio para entrar.");
					return true;
			}
			}
			if (sub.equalsIgnoreCase("entrar")) {
				if (Main.tempo2 == null) {
					p.sendMessage("§cO evento TcT não está ocorrendo no momento.");
					return true;
				}

				if (sub.equalsIgnoreCase("entrar")) {
					if (Main.fora2.contains(p)) {
						p.sendMessage("§cVocê já morreu, tente novamente na próxima vez.");
						return true;
					}
					if (sub.equalsIgnoreCase("entrar")) {
						if (Main.tempo2 == EstruturaTempo2.JOGO2) {
							p.sendMessage("§cO evento TcT já iniciou.");
							return true;
						}
					}
				}
			}
			
		
			if (sub.equalsIgnoreCase("setspawn")) {
				if (p.hasPermission("tct.admin")) {
					EstruturaAdmin.setspawn(p);

				} else {
					return true;
				}

			}

			if (sub.equalsIgnoreCase("setjogo")) {
				if (p.hasPermission("tct.admin")) {
					EstruturaAdmin.setjogo(p);
				} else {
					return true;
				}

			}
			if (sub.equalsIgnoreCase("setmorte")) {
				if (p.hasPermission("tct.admin")) {
					EstruturaAdmin.setmorte(p);
				} else {
					return true;
				}

			}
			if (sub.equalsIgnoreCase("setganhador")) {
				if (p.hasPermission("tct.admin")) {
					if (Main.tempo2 == EstruturaTempo2.JOGO2) {

						if (args.length == 1) {
							p.sendMessage("§cUtilize /tct setganhador <nick>");
						} else {

							Player j = Bukkit.getPlayer(args[1]);
							if (j == null) {
								p.sendMessage("§cJogador offline.");
							} else {
								if (j != null) {
									Bukkit.broadcastMessage(
											"§6§lEvento - Todos Contra Todos\n \n§6O vencedor do evento foi [§f"
													+ j.getName() + "§6] !");
									Main.wins.set(j.getName()+"_tct", Main.wins.getLong(j.getName()+"_tct")+1);
									Main.wins.saveConfig();
									Main.tempo2 = null;
									j.teleport(Main.tct.getLocation("morte_tct"));
									for (Player todos : Bukkit.getOnlinePlayers()) {
										Main.dentro2.remove(todos);
										Main.fora2.remove(todos);
										VaultAPI.getPermission().playerRemove(todos, "tct.jogando");
									}
								}
							}
						}
					}
				}
			}
			if (sub.equalsIgnoreCase("iniciar")) {
				if (p.hasPermission("tct.admin")) {
					if (Main.tct.contains("spawn_tct")) {
						if (Main.tempo2 == null) {
							EstruturaAdmin.iniciar(p);
							new BukkitRunnable() {
								int i = 180;

								@Override
								public void run() {
									i--;
									if (i == 0) {
										cancel();
										Main.tempo2 = EstruturaTempo2.JOGO2;
										Bukkit.broadcastMessage(
												"§6§lEvento - Todos Contra Todos\n \n§6O evento foi fechado e iniciado.\n ");
										for (Player todos : Bukkit.getOnlinePlayers()) {
											if (todos.hasPermission("tct.jogando")) {
												EstruturaJogador.inicio(todos);
											}
										
											
										}
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
						}
					}
				}
			}
		}

		return false;
	}

}
