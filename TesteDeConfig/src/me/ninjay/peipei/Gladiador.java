package me.ninjay.peipei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import me.ninjay.ninjaapi.utils.Mine;
import net.sacredlabyrinth.phaed.simpleclans.Clan;
import net.sacredlabyrinth.phaed.simpleclans.ClanPlayer;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;

public class Gladiador {

    private static Map<Clan, List<ClanPlayer>> jogadores; // MAP IMPORTANTE [N�O SEI PQ EXATAMENTE]
    private static int limite;
    private static boolean iniciado;
    private static boolean avisado;
    private static SimpleClans simpleClans;
    private static BukkitTask avisarTask;
    private static Location spawn;
    private static Location saida;
    private static int premio;
    private static Economy economy;

    static {
        jogadores = new HashMap<>();
        limite = 20;
        iniciado = false;
        avisado = false;
        simpleClans = Main2.getSimpleClans();
        premio = 30000;
        economy = Main2.getEconomy();
    }

    public static void entrar(Player p) {
        if (!avisado || iniciado) {
            p.sendMessage("§cVocê não pode entrar no Evento Gladiador agora!");
            return;
        }

        ClanPlayer cp = simpleClans.getClanManager().getClanPlayer(p); //PEGA O CLA DO PLAYER
        if (cp == null) {
        	
            p.sendMessage("§cVocê deve estar em um Clan para participar!");
            return;
        }

        List<ClanPlayer> jogadoresDoClan = jogadores.get(cp.getClan()); // PEGA OS JOGADORES DO CLAN
        if (jogadoresDoClan == null) jogadoresDoClan = new ArrayList<>();
            
        if (jogadoresDoClan.contains(cp)) {
        	p.sendMessage("§cVocê já está no Evento Gladiador");
        	return;
        }

        if (jogadoresDoClan.size() >= limite) {
            p.sendMessage("§cSeu clan já esta lotado para ir ao Evento Gladiador!");
            return;
        }

        jogadoresDoClan.add(cp);

        jogadores.put(cp.getClan(), jogadoresDoClan);
        p.sendMessage("§aVoce entrou no Evento Gladiador!");
        p.teleport(spawn);
    }

    public static void sair(Player p) {
        if (!avisado) {
        	p.sendMessage("§cO Evento Gladiador não foi iniciado");
            return;
        }
        
        if (iniciado) {
        	p.sendMessage("§cO Evento Gladiador já começou!");
        }

        ClanPlayer cp = simpleClans.getClanManager().getClanPlayer(p);
        if (cp == null) {
            p.sendMessage("§cVocê não tem um Clan");
            return;
        }

        List<ClanPlayer> jogadoresDoClan = jogadores.get(cp.getClan());
        if (jogadoresDoClan == null) {
            p.sendMessage("§cSeu Clan não está participando do Evento Gladiador!");
            return;
        }

        if (!jogadoresDoClan.contains(cp)) {
        	p.sendMessage("§cVocê não está no Evento Gladiador");
        	return;
        }
        
        jogadoresDoClan.remove(cp);
        jogadores.put(cp.getClan(), jogadoresDoClan);

        sendMessageToAll(
                "§c======================================",
                "",
                "§cO Jogador §f" + p.getName() + "§c(§f" + cp.getClan().getTag() + "§c) foi eliminado do Evento Gladiador",
                "",
                "§c======================================"
        );
        p.sendMessage(new String[] {
                "§c======================================",
                "",
                "§cO Jogador §f" + p.getName() + "§c(§f" + cp.getClan().getTag() + "§c) foi eliminado do Evento Gladiador",
                "",
                "§c======================================"
        });

        if (jogadoresDoClan.size() == 0) {
        	if (iniciado) {
	            sendMessageToAll(
	                    "§c=================================",
	                    "",
	                    "§cO Clan §f" + cp.getClan().getName() + "§c foi eliminado!",
	                    "",
	                    "§c================================="
	            );
	            
	            p.sendMessage(new String[] {
	                    "§c=================================",
	                    "",
	                    "§cO Clan §f" + cp.getClan().getName() + "§c foi eliminado!",
	                    "",
	                    "§c================================="
	            });
        	}

            jogadores.remove(cp.getClan());

        	if (jogadores.size() <= 1) {
        	    terminar(jogadores.keySet().iterator().next());
            }
        }

        p.teleport(saida);
        p.sendMessage("§cVoce saiu do Evento Gladiador");
    }

    private static void terminar(Clan clan) {
    	if (clan == null) {
    		Bukkit.broadcastMessage("§a=============================");
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage("§aO Evento Gladiador terminou!");
            Bukkit.broadcastMessage("§aNão houve nenhum ganhador!");
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage("§a=============================");
    		return;
    	}
        List<ClanPlayer> jogadores = Gladiador.jogadores.get(clan);
        float coins = premio / jogadores.size();

        Bukkit.broadcastMessage("§a=============================");
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage("§aO Evento Gladiador terminou!");
        Bukkit.broadcastMessage("§aO Clan vencedor foi:  §f" + clan.getName());
        Bukkit.broadcastMessage("§aCada membro do clan ganhou §f" + String.format("%.1f", coins) + "§a coins");
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage("§a=============================");

        for (ClanPlayer clanPlayer : jogadores) {
            clanPlayer.toPlayer().teleport(saida);
            economy.depositPlayer(clanPlayer.toPlayer(), coins);
        }
        
        Main main = Main2.getMain();
        
        main.getConfig().set("Ultimo-Ganhador", clan.getName());
        main.saveConfig();
    }

    public static boolean estaNoGladiador(Player p) {
        for (List<ClanPlayer> clanPlayers : jogadores.values()) {
            for (ClanPlayer clanPlayer : clanPlayers) {
                if (p.getName().equals(clanPlayer.toPlayer().getName())) return true;
            }
        }

        return false;
    }
    
//    public static void removerJogador(Player p) {
//    	for (List<ClanPlayer> clanPlayers : jogadores.values()) {
//            for (int i = 0; i < clanPlayers.size(); i++) {
//            	if (p.getName().equals(clanPlayers.get(i).toPlayer().getName())) {
//            		clanPlayers.remove(i);
//                }
//            }
//        }
//    }

    private static void sendMessageToAll(String... msg) {
        for (List<ClanPlayer> clanPlayers : jogadores.values()) {
            for (ClanPlayer clanPlayer : clanPlayers) {
                Player p = clanPlayer.toPlayer();
                p.sendMessage(msg);
            }
        }

        Bukkit.getConsoleSender().sendMessage(msg);
    }

    public static void iniciar(Player p) {
        if (!p.hasPermission(Comandos.PERMISSION)) {
            p.sendMessage("§cVocê não tem pemissao para fazer isso!");
            return;
        }

        if (avisado || iniciado) {
            p.sendMessage("§cO Evento Gladiador já foi iniciado/avisado");
            return;
        }

        if (spawn == null || saida == null) {
        	p.sendMessage("§cO Spawn ou a Saida não foram configuradas");
        	return;
        }
        
        avisado = true;
        avisarTask = new BukkitRunnable() {
            int avisos = /* TODO: 10 */ 2;
            @Override
            public void run() {
                if (avisos > 0) {
                    Bukkit.broadcastMessage("§a========================");
                    Bukkit.broadcastMessage("");
                    Bukkit.broadcastMessage("§aO Evento Gladiador foi iniciado!");
                    Bukkit.broadcastMessage("§aDigite §f/gladiador entrar§a para entrar no gladiador!");
                    Bukkit.broadcastMessage("§aPara este evento você precisa estar em um clan!");
                    Bukkit.broadcastMessage("");
                    Bukkit.broadcastMessage("§a========================");
                    
                    avisos--;
                    return;
                }

                cancel();
                if (jogadores.size() < /* TODO: 2 */ 1) {
                    cancelar(
                            "§c========================",
                            "",
                            "§cO Evento Gladiador foi cancelado por Falta de Clan",
                            "",
                            "§c========================"
                    );
                    return;
                }

                sendMessageToAll(
                		"§a========================",
                		"",
                		"§aO Evento Gladiador iniciou!",
                		"§aO Dano foi §4§lLIBERADO§a!",
                		"",
                		"§a========================"
                );
                iniciado = true;
            }
        }.runTaskTimer(Main.getMain(), 0, 20L * /* TODO: 30 */ 5);
    }

    private static void cancelar(String... msg) {
        for (String str : msg) Bukkit.broadcastMessage(str);

        avisarTask.cancel();
        avisado = false;
        iniciado = false;
        for (List<ClanPlayer> clanPlayers : jogadores.values()) {
            for (ClanPlayer clanPlayer : clanPlayers) {
            	clanPlayer.toPlayer().teleport(saida);
            }
        }
    }

    public static void cancelar(Player p) {
        if (!p.hasPermission(Comandos.PERMISSION)) {
            p.sendMessage("§cVocê não tem pemissao para fazer isso!");
            return;
        }

        if (!avisado && !iniciado) {
            p.sendMessage("§cVocê não pode cancelar o que não foi iniciado!");
            return;
        }

        Bukkit.broadcastMessage("§c========================");
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage("§cO Evento Gladiador foi cancelado por um Staff");
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage("§c========================");

        avisarTask.cancel();
        avisado = false;
        iniciado = false;
        for (List<ClanPlayer> clanPlayers : jogadores.values()) {
            for (ClanPlayer clanPlayer : clanPlayers) {
            	clanPlayer.toPlayer().teleport(saida);
            }
        }
    }
    
    public static void setupLocation() {
    	Main main = Main.getMain();
    	
    	Gladiador.spawn = (Location) main.getConfig().get("Locations.Spawn");
    	Gladiador.saida = (Location) main.getConfig().get("Locations.Saida");
    }
    
    public static void setSpawn(Player p) {
    	if (!p.hasPermission(Comandos.PERMISSION)) {
            p.sendMessage("§cVocê não tem pemissao para fazer isso!");
            return;
        }
    	
    	Gladiador.spawn = p.getLocation();
    	p.sendMessage("§aVocê alterou a localização do Spawn do Evento Gladiador");
    }
    
    public static void setSaida(Player p) {
    	if (!p.hasPermission(Comandos.PERMISSION)) {
            p.sendMessage("§cVocê não tem pemissao para fazer isso!");
            return;
        }
    	
    	Gladiador.saida = p.getLocation();
    	p.sendMessage("§aVocê alterou a localização da Saida do Evento Gladiador");
    }
    
    public static void saveLocations() {
    	Main main = Main.getMain();
    	
    	main.getConfig().set("Locations.Spawn", Gladiador.spawn);
    	main.getConfig().set("Locations.Saida", Gladiador.saida);
    	
    	main.saveConfig();
    }

}
