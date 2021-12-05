package me.ninjay.one1v1.estruturas;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.ninjay.one1v1.comandos.Comando1v1;
import me.ninjay.one1v1.main.Main;

public class EstruturaJogador {
	public static boolean arena1;
	public static boolean arena2;

	public static void ajuda(Player p) {
		p.sendMessage(
				"§6§l1v1 - Comandos\n \n§6/x1 desafiar <nick> §eDesafie algum jogador.\n§6/x1 aceitar §eAceite o convite de um duelo.\n§6/x1 negar §eNegue o convite de um duelo.\n§6/x1 cancelar §eCancele um pedido de duelo§6.\n§6/x1 ajuda §eVeja os comandos.\n ");
	}

	public static void duelar(Player enviou, Player recebeu) {
		if (arena1 == true) {
			if (arena2 == true) {
				enviou.sendMessage("§cAs duas arenas já estão em uso, aguarde para enviar um convite.");

				return;
			}
		} else {
			enviou.sendMessage("§6Convite de duelo enviado para §e" + recebeu.getName()
					+ "§6. Para cancelar utilize §e/x1 cancelar§6.\n ");
			Bukkit.broadcastMessage("§6§lDuelo - Convite\n \n§6Participantes: §e" + enviou.getName() + " §6x §e"
					+ recebeu.getName() + "§6.\n ");
			recebeu.sendMessage("§6Você recebeu um convite de duelo de §e" + enviou.getName()
					+ "§6.\n \n§6Para aceitar o convite utilize §e/x1 aceitar.\n§6Para negar utilize §e/x1 negar§6.\n ");
			Comando1v1.jogando.add(recebeu);
			Comando1v1.jogando.add(enviou);
			Main.arenas.set(recebeu.getName() + "_desafiante", enviou.getName());
			Main.arenas.saveConfig();
		}
	}

	public static void aceitar(Player aceito) {
	}

}
