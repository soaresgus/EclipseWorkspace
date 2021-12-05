package net.b_bolsa;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.b_bolsa.commands.BolsaCommand;
import net.b_bolsa.objects.Bolsa;
import net.b_bolsa.objects.Files;

public class Main extends JavaPlugin {

	public static Main instance;

	public static Main getInstance() {
		return instance;
	}

	public Files file = new Files(this, "configuracao.yml");
	
	int minutes = 0;
	public Bolsa b = new Bolsa(0, 0);
	
	@Override
	public void onEnable() {
		instance = this;
		long time1 = System.currentTimeMillis();
		file.saveDefaultConfig();
		b.setPorcentagem(new Random().nextInt(100));
		minutes = file.getInt("Update.Minutos");
		b.setTime(System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(minutes, TimeUnit.MINUTES));
		getCommand("bolsa").setExecutor(new BolsaCommand());
		long time2 = System.currentTimeMillis();
		long dif = (time2 - time1);
		Bukkit.getConsoleSender().sendMessage("Bolsa - Plugin habilitado corretamente em " + dif + " ms.");
		new BukkitRunnable() {
			
			@Override
			public void run() {
				b.setPorcentagem(new Random().nextInt(100));
				b.setTime(System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(minutes, TimeUnit.MINUTES));
				Bukkit.getOnlinePlayers().forEach(a -> {
					String estado = b.estaBaixa() ? "§cbaixa" : "§aalta";
					a.sendMessage(" ");
					a.sendMessage("§7A bolsa de valores foi atualizada!");
					a.sendMessage(" ");
					a.sendMessage("§7Sua porcentagem agora é de: §f" + b.getPorcentagem() + "§7%");
					a.sendMessage("§7Se encontra em " + estado + "§7.");
					a.sendMessage(" ");
				});
			}
		}.runTaskTimer(Main.getInstance(), 0L, 20L * 60L * minutes);
		
	}

}
