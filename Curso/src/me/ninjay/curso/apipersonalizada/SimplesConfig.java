package me.ninjay.curso.apipersonalizada;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SimplesConfig {
     private String nome;
     private File arquivo;
     private YamlConfiguration config;
     private JavaPlugin plugin;
     
     public SimplesConfig(String nome, JavaPlugin plugin) { 
    	 setNome(nome);
    	 setPlugin(plugin);
    	 arquivo = new File(plugin.getDataFolder(), nome);
    	 config = YamlConfiguration.loadConfiguration(arquivo);
    	 
    	 
     }
     public void saveConfig() {
    	 try {
			config.save(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	 
     }
     public void reload() {
    	 config = YamlConfiguration.loadConfiguration(arquivo);
    	 
     }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public File getArquivo() {
		return arquivo;
	}

	public void setArquivo(File arquivo) {
		this.arquivo = arquivo;
	}

	public YamlConfiguration getConfig() {
		return config;
	}

	public void setConfig(YamlConfiguration config) {
		this.config = config;
	}

	public JavaPlugin getPlugin() {
		return plugin;
	}

	public void setPlugin(JavaPlugin plugin) {
		this.plugin = plugin;
	}
     
}
