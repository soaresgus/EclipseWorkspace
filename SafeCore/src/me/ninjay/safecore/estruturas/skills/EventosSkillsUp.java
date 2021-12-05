package me.ninjay.safecore.estruturas.skills;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import me.ninjay.safecore.utils.Mine;
import me.ninjay.safemina.main.Main;

public class EventosSkillsUp implements Listener{
	
	@EventHandler
	public void espadas(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Player) {
			if(e.getDamager() instanceof Player) {
				Player p = (Player) e.getDamager();
				if(p.getItemInHand().getType() == Material.DIAMOND_SWORD || p.getItemInHand().getType() == Material.IRON_SWORD || p.getItemInHand().getType() == Material.GOLD_SWORD || p.getItemInHand().getType() == Material.STONE_SWORD || p.getItemInHand().getType() == Material.WOOD_SWORD) {
					if(p.getItemInHand() != null) {
						if(SkillsAPI.getNvl(p, "sword") < SkillsAPI.skills.getInt("sword.NvlMax")) {
				SkillsAPI.addXp(p, SkillsAPI.skills.getInt("sword.XpPlayer"), "sword");
				SkillsAPI.addons(p, "sword", "Espadas", SkillsAPI.skills.getInt("sword.XpPlayer"));
			}else {
				Mine.sendActionBar(p, "§aEspadas [Nível: "+SkillsAPI.skills.getInt("sword.NvlMax")+"] [Você atingiu o nível máximo]");
			}
					}
			}
				if(SkillsAPI.getNvl(p, "sword") == SkillsAPI.skills.getInt("sword.NvlMed")-1 && SkillsAPI.getXp(p, "sword") >= SkillsAPI.getXpNec(p, "sword")-SkillsAPI.skills.getInt("XpAumentadoCadaUp")) {
					p.sendMessage("\n§aVocê upou nível §a§l"+SkillsAPI.skills.getInt("sword.NvlMed")+" §ade espadas e desbloqueou habilidades.\n \n§aPara mais informações utilize §a§l'/espadas'§a.\n ");
					Bukkit.broadcastMessage("§b§l"+p.getName()+" §bupou nível "+SkillsAPI.skills.getInt("sword.NvlMed")+" de espadas!");
					p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
				}
				if(SkillsAPI.getNvl(p, "sword") == SkillsAPI.skills.getInt("sword.NvlMax")-1 && SkillsAPI.getXp(p, "sword") >= SkillsAPI.getXpNec(p, "sword")-SkillsAPI.skills.getInt("XpAumentadoCadaUp")) {
					p.sendMessage("\n§aVocê upou nível §a§l"+SkillsAPI.skills.getInt("sword.NvlMax")+" §ade espadas e desbloqueou habilidades.\n \n§aPara mais informações utilize §a§l'/espadas'§a.\n ");
					Bukkit.broadcastMessage("§b§l"+p.getName()+" §bupou nível "+SkillsAPI.skills.getInt("sword.NvlMax")+" de espadas!");
					p.playSound(p.getLocation(), Sound.ENDERDRAGON_DEATH, 1, 1);
				}
				if(SkillsAPI.getXp(p, "sword") > SkillsAPI.getXpNec(p, "sword")) {
					if(SkillsAPI.getNvl(p, "sword") < SkillsAPI.skills.getInt("sword.NvlMax")) {
					p.sendMessage("\n §eNível de espadas aumentado (+1).\n ");
					p.getWorld().playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
					SkillsAPI.addNvl(p, "sword", 1);
					SkillsAPI.addXpNec(p, "sword", SkillsAPI.skills.getInt("XpAumentadoCadaUp"));
					SkillsAPI.setXp(p, 0, "sword");			
					SkillsAPI.addNvlTotal(p, 1);
					}else {
						Mine.sendActionBar(p, "§aEspadas [Nível: "+SkillsAPI.skills.getInt("sword.NvlMax")+"] [Você atingiu o nível máximo]");
						return;
					}
				}
			}
		}
	}
	
	@EventHandler
	public void machado(EntityDamageByEntityEvent e) {
		
		if(e.getEntity() instanceof Player) {
			if(e.getDamager() instanceof Player) {
				Player p = (Player) e.getDamager();
				if(p.getItemInHand().getType() == Material.DIAMOND_AXE || p.getItemInHand().getType() == Material.IRON_AXE || p.getItemInHand().getType() == Material.GOLD_AXE || p.getItemInHand().getType() == Material.STONE_AXE || p.getItemInHand().getType() == Material.WOOD_AXE) {
					if(p.getItemInHand() != null) {
						if(SkillsAPI.getNvl(p, "axe") < SkillsAPI.skills.getInt("axe.NvlMax")) {
				SkillsAPI.addXp(p, SkillsAPI.skills.getInt("axe.XpPlayer"), "axe");
				SkillsAPI.addons(p, "axe", "Machado", SkillsAPI.skills.getInt("axe.XpPlayer"));
			}else {
				Mine.sendActionBar(p, "§aMachado [Nível: "+SkillsAPI.skills.getInt("axe.NvlMax")+"] [Você atingiu o nível máximo]");
			}
					}
			}
				if(SkillsAPI.getNvl(p, "axe") == SkillsAPI.skills.getInt("axe.NvlMed")-1 && SkillsAPI.getXp(p, "axe") >= SkillsAPI.getXpNec(p, "axe")-SkillsAPI.skills.getInt("XpAumentadoCadaUp")) {
					p.sendMessage("\n§aVocê upou nível §a§l"+SkillsAPI.skills.getInt("axe.NvlMed")+" §ade machado e desbloqueou habilidades.\n \n§aPara mais informações utilize §a§l'/machado'§a.\n ");
					Bukkit.broadcastMessage("§b§l"+p.getName()+" §bupou nível "+SkillsAPI.skills.getInt("axe.NvlMed")+" de machado!");
					p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
				}
				if(SkillsAPI.getNvl(p, "axe") == SkillsAPI.skills.getInt("axe.NvlMax")-1 && SkillsAPI.getXp(p, "axe") >= SkillsAPI.getXpNec(p, "axe")-SkillsAPI.skills.getInt("XpAumentadoCadaUp")) {
					p.sendMessage("\n§aVocê upou nível §a§l"+SkillsAPI.skills.getInt("axe.NvlMax")+" §ade machado e desbloqueou habilidades.\n \n§aPara mais informações utilize §a§l'/machado'§a.\n ");
					Bukkit.broadcastMessage("§b§l"+p.getName()+" §bupou nível "+SkillsAPI.skills.getInt("axe.NvlMax")+" de machado!");
					p.playSound(p.getLocation(), Sound.ENDERDRAGON_DEATH, 1, 1);
				}
				if(SkillsAPI.getXp(p, "axe") > SkillsAPI.getXpNec(p, "axe")) {
					if(SkillsAPI.getNvl(p, "axe") < SkillsAPI.skills.getInt("axe.NvlMax")) {
					p.sendMessage("\n §eNível de machado aumentado (+1).\n ");
					p.getWorld().playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
					SkillsAPI.addNvl(p, "axe", 1);
					SkillsAPI.addXpNec(p, "axe", SkillsAPI.skills.getInt("XpAumentadoCadaUp"));
					SkillsAPI.setXp(p, 0, "axe");			
					SkillsAPI.addNvlTotal(p, 1);
					}else {
						Mine.sendActionBar(p, "§aMachado [Nível: "+SkillsAPI.skills.getInt("axe.NvlMax")+"] [Você atingiu o nível máximo]");
						return;
					}
				}
			}
		}
	}
	
	@EventHandler
	public void mineracao(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(p.getWorld().getName().equals(Main.config.getString("MundoMina"))) {
		if(p.getItemInHand().getType() == Material.DIAMOND_PICKAXE || p.getItemInHand().getType() == Material.IRON_PICKAXE || p.getItemInHand().getType() == Material.GOLD_PICKAXE || p.getItemInHand().getType() == Material.STONE_PICKAXE || p.getItemInHand().getType() == Material.WOOD_PICKAXE) {
			if(p.getItemInHand() != null) {
				if(e.getBlock().getType() == Material.STONE) {
					if(SkillsAPI.getNvl(p, "mining") < SkillsAPI.skills.getInt("mining.NvlMax")) {
						SkillsAPI.addXp(p, SkillsAPI.skills.getInt("mining.XpPedra"), "mining");
						SkillsAPI.addons(p, "mining", "Mineração", SkillsAPI.skills.getInt("mining.XpPedra"));
					}else {
						Mine.sendActionBar(p, "§aMineração [Nível: "+SkillsAPI.skills.getInt("mining.NvlMax")+"] [Você atingiu o nível máximo]");
					}
							}
					}
						if(SkillsAPI.getNvl(p, "mining") == SkillsAPI.skills.getInt("mining.NvlMed")-1 && SkillsAPI.getXp(p, "mining") >= SkillsAPI.getXpNec(p, "mining")-SkillsAPI.skills.getInt("XpAumentadoCadaUp")) {
							p.sendMessage("\n§aVocê upou nível §a§l"+SkillsAPI.skills.getInt("mining.NvlMed")+" §ade mineração e desbloqueou habilidades.\n \n§aPara mais informações utilize §a§l'/mineração'§a.\n ");
							Bukkit.broadcastMessage("§b§l"+p.getName()+" §bupou nível "+SkillsAPI.skills.getInt("mining.NvlMed")+" de mineração!");
							p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
						}
						if(SkillsAPI.getNvl(p, "mining") == SkillsAPI.skills.getInt("mining.NvlMax")-1 && SkillsAPI.getXp(p, "mining") >= SkillsAPI.getXpNec(p, "mining")-SkillsAPI.skills.getInt("XpAumentadoCadaUp")) {
							p.sendMessage("\n§aVocê upou nível §a§l"+SkillsAPI.skills.getInt("mining.NvlMax")+" §ade mineração e desbloqueou habilidades.\n \n§aPara mais informações utilize §a§l'/mineração'§a.\n ");
							Bukkit.broadcastMessage("§b§l"+p.getName()+" §bupou nível "+SkillsAPI.skills.getInt("mining.NvlMax")+" de mineração!");
							p.playSound(p.getLocation(), Sound.ENDERDRAGON_DEATH, 1, 1);
						}
						if(SkillsAPI.getXp(p, "mining") > SkillsAPI.getXpNec(p, "mining")) {
							if(SkillsAPI.getNvl(p, "mining") < SkillsAPI.skills.getInt("mining.NvlMax")) {
							p.sendMessage("\n §eNível de mineração aumentado (+1).\n ");
							p.getWorld().playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
							SkillsAPI.addNvl(p, "mining", 1);
							SkillsAPI.addXpNec(p, "mining", SkillsAPI.skills.getInt("XpAumentadoCadaUp"));
							SkillsAPI.setXp(p, 0, "mining");			
							SkillsAPI.addNvlTotal(p, 1);
							}else {
								Mine.sendActionBar(p, "§aMineração [Nível: "+SkillsAPI.skills.getInt("mining.NvlMax")+"] [Você atingiu o nível máximo]");
								return;
							}
						}
					}
		}
				}
	
	@EventHandler
	public void escavacao(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(p.getWorld().getName().equals(Main.config.getString("MundoEscavar"))) {
		if(p.getItemInHand().getType() == Material.DIAMOND_SPADE || p.getItemInHand().getType() == Material.IRON_SPADE || p.getItemInHand().getType() == Material.GOLD_SPADE || p.getItemInHand().getType() == Material.STONE_SPADE || p.getItemInHand().getType() == Material.WOOD_SPADE) {
			if(p.getItemInHand() != null) {
				if(e.getBlock().getType() == Material.DIRT || e.getBlock().getType() == Material.GRASS) {
					if(SkillsAPI.getNvl(p, "excavation") < SkillsAPI.skills.getInt("excavation.NvlMax")) {
						SkillsAPI.addXp(p, SkillsAPI.skills.getInt("excavation.XpTerra"), "excavation");
						SkillsAPI.addons(p, "excavation", "Escavação", SkillsAPI.skills.getInt("excavation.XpTerra"));
					}else {
						Mine.sendActionBar(p, "§aEscavação [Nível: "+SkillsAPI.skills.getInt("excavation.NvlMax")+"] [Você atingiu o nível máximo]");
					}
							}
				if(e.getBlock().getType() == Material.SAND) {
					if(SkillsAPI.getNvl(p, "excavation") < SkillsAPI.skills.getInt("excavation.NvlMax")) {
						SkillsAPI.addXp(p, SkillsAPI.skills.getInt("excavation.XpAreia"), "excavation");
						SkillsAPI.addons(p, "excavation", "Escavação", SkillsAPI.skills.getInt("excavation.XpAreia"));
					}else {
						Mine.sendActionBar(p, "§aEscavação [Nível: "+SkillsAPI.skills.getInt("excavation.NvlMax")+"] [Você atingiu o nível máximo]");
					}
							}
				if(e.getBlock().getType() == Material.GRAVEL) {
					if(SkillsAPI.getNvl(p, "excavation") < SkillsAPI.skills.getInt("excavation.NvlMax")) {
						SkillsAPI.addXp(p, SkillsAPI.skills.getInt("excavation.XpGravel"), "excavation");
						SkillsAPI.addons(p, "excavation", "Escavação", SkillsAPI.skills.getInt("excavation.XpGravel"));
					}else {
						Mine.sendActionBar(p, "§aEscavação [Nível: "+SkillsAPI.skills.getInt("excavation.NvlMax")+"] [Você atingiu o nível máximo]");
					}
							}
					}
			if(SkillsAPI.getNvl(p, "excavation") == SkillsAPI.skills.getInt("excavation.NvlMed")-1 && SkillsAPI.getXp(p, "excavation") >= SkillsAPI.getXpNec(p, "excavation")-SkillsAPI.skills.getInt("XpAumentadoCadaUp")) {
				p.sendMessage("\n§aVocê upou nível §a§l"+SkillsAPI.skills.getInt("excavation.NvlMed")+" §ade escavação e desbloqueou habilidades.\n \n§aPara mais informações utilize §a§l'/escavação'§a.\n ");
				Bukkit.broadcastMessage("§b§l"+p.getName()+" §bupou nível "+SkillsAPI.skills.getInt("excavation.NvlMed")+" de escavação!");
				p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
			}
			if(SkillsAPI.getNvl(p, "excavation") == SkillsAPI.skills.getInt("excavation.NvlMax")-1 && SkillsAPI.getXp(p, "excavation") >= SkillsAPI.getXpNec(p, "excavation")-SkillsAPI.skills.getInt("XpAumentadoCadaUp")) {
				p.sendMessage("\n§aVocê upou nível §a§l"+SkillsAPI.skills.getInt("excavation.NvlMax")+" §ade escavação e desbloqueou habilidades.\n \n§aPara mais informações utilize §a§l'/escavação'§a.\n ");
				Bukkit.broadcastMessage("§b§l"+p.getName()+" §bupou nível "+SkillsAPI.skills.getInt("excavation.NvlMax")+" de escavação!");
				p.playSound(p.getLocation(), Sound.ENDERDRAGON_DEATH, 1, 1);
			}
			if(SkillsAPI.getXp(p, "excavation") > SkillsAPI.getXpNec(p, "excavation")) {
				if(SkillsAPI.getNvl(p, "excavation") < SkillsAPI.skills.getInt("excavation.NvlMax")) {
				p.sendMessage("\n §eNível de escavação aumentado (+1).\n ");
				p.getWorld().playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				SkillsAPI.addNvl(p, "excavation", 1);
				SkillsAPI.addXpNec(p, "excavation", SkillsAPI.skills.getInt("XpAumentadoCadaUp"));
				SkillsAPI.setXp(p, 0, "excavation");			
				SkillsAPI.addNvlTotal(p, 1);
				}else {
					Mine.sendActionBar(p, "§aEscavação [Nível: "+SkillsAPI.skills.getInt("excavation.NvlMax")+"] [Você atingiu o nível máximo]");
					return;
				}
			}
					}
				}
	}
	
	@EventHandler
	public void acrobacia(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			 if(e.getCause() == DamageCause.FALL) {
				 Player p = (Player) e.getEntity();
				 int blocos = Mine.toInt(p.getFallDistance()+1);
				 if(p.getInventory().getBoots() == null) {
				 if(blocos <= 5) {
					 //p.sendMessage("distancia pequena");
					 if(SkillsAPI.getNvl(p, "acrobatic") < SkillsAPI.skills.getInt("acrobatic.NvlMax")) {
							SkillsAPI.addXp(p, SkillsAPI.skills.getInt("acrobatic.XpAlturaBaixa"), "acrobatic");
							SkillsAPI.addons(p, "acrobatic", "Acrobacia", SkillsAPI.skills.getInt("acrobatic.XpAlturaBaixa"));
						}else {
							Mine.sendActionBar(p, "§aAcrobacia [Nível: "+SkillsAPI.skills.getInt("acrobatic.NvlMax")+"] [Você atingiu o nível máximo]");
						}
				 }
				 if(blocos <= 10 && blocos >= 6) {
					 //p.sendMessage("distancia media");
					 if(SkillsAPI.getNvl(p, "acrobatic") < SkillsAPI.skills.getInt("acrobatic.NvlMax")) {
							SkillsAPI.addXp(p, SkillsAPI.skills.getInt("acrobatic.XpAlturaMedia"), "acrobatic");
							SkillsAPI.addons(p, "acrobatic", "Acrobacia", SkillsAPI.skills.getInt("acrobatic.XpAlturaMedia"));
						}else {
							Mine.sendActionBar(p, "§aAcrobacia [Nível: "+SkillsAPI.skills.getInt("acrobatic.NvlMax")+"] [Você atingiu o nível máximo]");
						}
				 }
				 if(blocos <= 15 && blocos >= 9) {
					 //p.sendMessage("distancia alta");
					 if(SkillsAPI.getNvl(p, "acrobatic") < SkillsAPI.skills.getInt("acrobatic.NvlMax")) {
							SkillsAPI.addXp(p, SkillsAPI.skills.getInt("acrobatic.XpAlturaAlta"), "acrobatic");
							SkillsAPI.addons(p, "acrobatic", "Acrobacia", SkillsAPI.skills.getInt("acrobatic.XpAlturaAlta"));
						}else {
							Mine.sendActionBar(p, "§aAcrobacia [Nível: "+SkillsAPI.skills.getInt("acrobatic.NvlMax")+"] [Você atingiu o nível máximo]");
						}
				 }
				 
				 if(blocos >= 16) {
					return;
				 }
				 }else {
				 if(p.getInventory().getBoots().getEnchantmentLevel(Enchantment.PROTECTION_FALL) == 4) {
				 if(blocos <= 5) {
					 //p.sendMessage("distancia pequena");
					 if(SkillsAPI.getNvl(p, "acrobatic") < SkillsAPI.skills.getInt("acrobatic.NvlMax")) {
							SkillsAPI.addXp(p, SkillsAPI.skills.getInt("acrobatic.XpAlturaBaixa")+SkillsAPI.skills.getInt("acrobatic.XpComPesoPena"), "acrobatic");
							SkillsAPI.addons(p, "acrobatic", "Acrobacia", SkillsAPI.skills.getInt("acrobatic.XpAlturaBaixa")+SkillsAPI.skills.getInt("acrobatic.XpComPesoPena"));
						}else {
							Mine.sendActionBar(p, "§aAcrobacia [Nível: "+SkillsAPI.skills.getInt("acrobatic.NvlMax")+"] [Você atingiu o nível máximo]");
						}
				 }
				 if(blocos <= 10 && blocos >= 6) {
					 //p.sendMessage("distancia media");
					 if(SkillsAPI.getNvl(p, "acrobatic") < SkillsAPI.skills.getInt("acrobatic.NvlMax")) {
							SkillsAPI.addXp(p, SkillsAPI.skills.getInt("acrobatic.XpAlturaMedia")+SkillsAPI.skills.getInt("acrobatic.XpComPesoPena"), "acrobatic");
							SkillsAPI.addons(p, "acrobatic", "Acrobacia", SkillsAPI.skills.getInt("acrobatic.XpAlturaMedia")+SkillsAPI.skills.getInt("acrobatic.XpComPesoPena"));
						}else {
							Mine.sendActionBar(p, "§aAcrobacia [Nível: "+SkillsAPI.skills.getInt("acrobatic.NvlMax")+"] [Você atingiu o nível máximo]");
						}
				 }
				 if(blocos <= 15 && blocos >= 9) {
					 //p.sendMessage("distancia alta");
					 if(SkillsAPI.getNvl(p, "acrobatic") < SkillsAPI.skills.getInt("acrobatic.NvlMax")) {
							SkillsAPI.addXp(p, SkillsAPI.skills.getInt("acrobatic.XpAlturaAlta")+SkillsAPI.skills.getInt("acrobatic.XpComPesoPena"), "acrobatic");
							SkillsAPI.addons(p, "acrobatic", "Acrobacia", SkillsAPI.skills.getInt("acrobatic.XpAlturaAlta")+SkillsAPI.skills.getInt("acrobatic.XpComPesoPena"));
						}else {
							Mine.sendActionBar(p, "§aAcrobacia [Nível: "+SkillsAPI.skills.getInt("acrobatic.NvlMax")+"] [Você atingiu o nível máximo]");
						}
				 }
				 if(blocos >= 16) {
						return;
					 }
				 if(SkillsAPI.getNvl(p, "acrobatic") == SkillsAPI.skills.getInt("acrobatic.NvlMed")-1 && SkillsAPI.getXp(p, "acrobatic") >= SkillsAPI.getXpNec(p, "acrobatic")-SkillsAPI.skills.getInt("XpAumentadoCadaUp")) {
						p.sendMessage("\n§aVocê upou nível §a§l"+SkillsAPI.skills.getInt("acrobatic.NvlMed")+" §ade acrobacia e desbloqueou habilidades.\n \n§aPara mais informações utilize §a§l'/acrobacia'§a.\n ");
						Bukkit.broadcastMessage("§b§l"+p.getName()+" §bupou nível "+SkillsAPI.skills.getInt("acrobatic.NvlMed")+" de acrobacia!");
						p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
					}
					if(SkillsAPI.getNvl(p, "acrobatic") == SkillsAPI.skills.getInt("acrobatic.NvlMax")-1 && SkillsAPI.getXp(p, "acrobatic") >= SkillsAPI.getXpNec(p, "acrobatic")-SkillsAPI.skills.getInt("XpAumentadoCadaUp")) {
						p.sendMessage("\n§aVocê upou nível §a§l"+SkillsAPI.skills.getInt("acrobatic.NvlMax")+" §ade acrobacia e desbloqueou habilidades.\n \n§aPara mais informações utilize §a§l'/acrobacia'§a.\n ");
						Bukkit.broadcastMessage("§b§l"+p.getName()+" §bupou nível "+SkillsAPI.skills.getInt("acrobatic.NvlMax")+" de acrobacia!");
						p.playSound(p.getLocation(), Sound.ENDERDRAGON_DEATH, 1, 1);
					}
					if(SkillsAPI.getXp(p, "acrobatic") > SkillsAPI.getXpNec(p, "acrobatic")) {
						if(SkillsAPI.getNvl(p, "acrobatic") < SkillsAPI.skills.getInt("acrobatic.NvlMax")) {
						p.sendMessage("\n §eNível de acrobacia aumentado (+1).\n ");
						p.getWorld().playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
						SkillsAPI.addNvl(p, "acrobatic", 1);
						SkillsAPI.addXpNec(p, "acrobatic", SkillsAPI.skills.getInt("XpAumentadoCadaUp"));
						SkillsAPI.setXp(p, 0, "acrobatic");			
						SkillsAPI.addNvlTotal(p, 1);
						}else {
							Mine.sendActionBar(p, "§aAcrobacia [Nível: "+SkillsAPI.skills.getInt("acrobatic.NvlMax")+"] [Você atingiu o nível máximo]");
							return;
						}
					}
				 }
				 }
				  }
		}else {
			return;
		}
	}
	
	@EventHandler
	public void feiticeiro(PlayerItemConsumeEvent e) {
		Player p = e.getPlayer();
		
		if(!(e.getItem().getDurability() == 0 || e.getItem().getDurability() == 16 || e.getItem().getDurability() == 8192)) {
		if(e.getItem().getType() == Material.POTION) {
			if(SkillsAPI.getNvl(p, "wizard") < SkillsAPI.skills.getInt("wizard.NvlMax")) {
				SkillsAPI.addXp(p, SkillsAPI.skills.getInt("wizard.XpPot"), "wizard");
				SkillsAPI.addons(p, "wizard", "Feiticeiro", SkillsAPI.skills.getInt("wizard.XpPot"));
			}else {
				Mine.sendActionBar(p, "§aFeiticeiro [Nível: "+SkillsAPI.skills.getInt("wizard.NvlMax")+"] [Você atingiu o nível máximo]");
			}
					}
				if(SkillsAPI.getNvl(p, "wizard") == SkillsAPI.skills.getInt("wizard.NvlMed")-1 && SkillsAPI.getXp(p, "wizard") >= SkillsAPI.getXpNec(p, "wizard")-SkillsAPI.skills.getInt("XpAumentadoCadaUp")) {
					p.sendMessage("\n§aVocê upou nível §a§l"+SkillsAPI.skills.getInt("wizard.NvlMed")+" §ade feiticeiro e desbloqueou habilidades.\n \n§aPara mais informações utilize §a§l'/feiticeiro'§a.\n ");
					Bukkit.broadcastMessage("§b§l"+p.getName()+" §bupou nível "+SkillsAPI.skills.getInt("wizard.NvlMed")+" de feiticeiro!");
					p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
				}
				if(SkillsAPI.getNvl(p, "wizard") == SkillsAPI.skills.getInt("wizard.NvlMax")-1 && SkillsAPI.getXp(p, "wizard") >= SkillsAPI.getXpNec(p, "wizard")-SkillsAPI.skills.getInt("XpAumentadoCadaUp")) {
					p.sendMessage("\n§aVocê upou nível §a§l"+SkillsAPI.skills.getInt("wizard.NvlMax")+" §ade feiticeiro e desbloqueou habilidades.\n \n§aPara mais informações utilize §a§l'/feiticeiro'§a.\n ");
					Bukkit.broadcastMessage("§b§l"+p.getName()+" §bupou nível "+SkillsAPI.skills.getInt("wizard.NvlMax")+" de feiticeiro!");
					p.playSound(p.getLocation(), Sound.ENDERDRAGON_DEATH, 1, 1);
				}
				if(SkillsAPI.getXp(p, "wizard") > SkillsAPI.getXpNec(p, "wizard")) {
					if(SkillsAPI.getNvl(p, "wizard") < SkillsAPI.skills.getInt("wizard.NvlMax")) {
					p.sendMessage("\n §eNível de feiticeiro aumentado (+1).\n ");
					p.getWorld().playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
					SkillsAPI.addNvl(p, "wizard", 1);
					SkillsAPI.addXpNec(p, "wizard", SkillsAPI.skills.getInt("XpAumentadoCadaUp"));
					SkillsAPI.setXp(p, 0, "wizard");			
					SkillsAPI.addNvlTotal(p, 1);
					}else {
						Mine.sendActionBar(p, "§aFeiticeiro [Nível: "+SkillsAPI.skills.getInt("wizard.NvlMax")+"] [Você atingiu o nível máximo]");
						return;
					}
				}
		}else {
			return;
		}
	}
}
