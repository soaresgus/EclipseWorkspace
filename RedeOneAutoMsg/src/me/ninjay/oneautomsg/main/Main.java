package me.ninjay.oneautomsg.main;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;



public class Main extends JavaPlugin{
	
String[] mensagens = {"§6Fique informado dos horários dos nossos eventos.\n \n§6Entre no link abaixo e saiba mais.\n \n§e➤ https://bit.ly/2EXGYqY\n ", "§6Siga-nos no §etwitter §6para ficar sabendo de todas as novidades do servidor.\n \n§e➤ @ServidoresOne\n ","§6Entre já em nosso servidor de §ediscord §6e saiba tudo que irá acontecer no servidor.\n \n§e➤ https://discord.gg/daUk5CW\n ","§6Sempre existe vagas para novos membros na equipe, caso deseje se aplicar entre em nosso §ediscord §6ou chame-nos no §etwitter§6.\n \n§e➤ @ServidoresOne\n§e➤ https://discord.gg/daUk5CW\n ","§6Para adquirir vips e cash entre em nosso §esite§6.\n \n§e➤ rede-one.com\n " };
	@Override
	public void onEnable() {
		new BukkitRunnable() {
			
			@Override
			public void run() {
		        Bukkit.broadcastMessage(Arrays.asList(mensagens).get(new Random().nextInt(mensagens.length)));
			}
		}.runTaskTimer(this, 0, 20 * 60);
	}

}
