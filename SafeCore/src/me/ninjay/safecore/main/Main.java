package me.ninjay.safecore.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.safecore.comandos.cargos.ComandoCargos;
import me.ninjay.safecore.comandos.chat.ComandoAviso;
import me.ninjay.safecore.comandos.chat.ComandoClearChat;
import me.ninjay.safecore.comandos.chat.ComandoGlobal;
import me.ninjay.safecore.comandos.chat.ComandoLocal;
import me.ninjay.safecore.comandos.chat.ComandoR;
import me.ninjay.safecore.comandos.chat.ComandoTell;
import me.ninjay.safecore.comandos.chat.ComandoToggleGlobal;
import me.ninjay.safecore.comandos.kits.ComandoKit;
import me.ninjay.safecore.comandos.lag.ComandoLag;
import me.ninjay.safecore.comandos.lag.ComandoPing;
import me.ninjay.safecore.comandos.lag.ComandoSetSpawn;
import me.ninjay.safecore.comandos.lag.ComandoSpawn;
import me.ninjay.safecore.comandos.lag.ComandoVip;
import me.ninjay.safecore.comandos.spawners.ComandoSetarMob;
import me.ninjay.safecore.comandos.tempo.ComandoTempoOnline;
import me.ninjay.safecore.estruturas.kits.Kits;
import me.ninjay.safecore.estruturas.kits.KitsAPI;
import me.ninjay.safecore.estruturas.kits.KitsManager;
import me.ninjay.safecore.estruturas.skills.ComandoSkills;
import me.ninjay.safecore.estruturas.skills.EventosSkills;
import me.ninjay.safecore.estruturas.skills.EventosSkillsHab;
import me.ninjay.safecore.estruturas.skills.EventosSkillsUp;
import me.ninjay.safecore.estruturas.skills.SkillsAPI;
import me.ninjay.safecore.estruturas.skills.comandos.ComandoAcrobacia;
import me.ninjay.safecore.estruturas.skills.comandos.ComandoEscavacao;
import me.ninjay.safecore.estruturas.skills.comandos.ComandoEspadas;
import me.ninjay.safecore.estruturas.skills.comandos.ComandoFeiticeiro;
import me.ninjay.safecore.estruturas.skills.comandos.ComandoMachado;
import me.ninjay.safecore.estruturas.skills.comandos.ComandoMineracao;
import me.ninjay.safecore.estruturas.tags.Tags;
import me.ninjay.safecore.estruturas.tags.TagsAPI;
import me.ninjay.safecore.estruturas.tags.TagsManager;
import me.ninjay.safecore.eventos.EventosGeral;
import me.ninjay.safecore.utils.BukkitConfig;
import me.ninjay.safecore.utils.Mine;
import me.ninjay.utils.utils.StorageAPI;

public class Main extends JavaPlugin {

	public static BukkitConfig config;
	public static Main instance;
	
	@Override
	public void onEnable() {

		instance = this;

		getCommand("g").setExecutor(new ComandoGlobal());
		getCommand("l").setExecutor(new ComandoLocal());
		getCommand("clearchat").setExecutor(new ComandoClearChat());
		getCommand("toggleglobal").setExecutor(new ComandoToggleGlobal());
		getCommand("aviso").setExecutor(new ComandoAviso());
		getCommand("tell").setExecutor(new ComandoTell());
		getCommand("r").setExecutor(new ComandoR());
		getCommand("ping").setExecutor(new ComandoPing());
		getCommand("lag").setExecutor(new ComandoLag());
		getCommand("cargo").setExecutor(new ComandoCargos());
		getCommand("kit").setExecutor(new ComandoKit());
		getCommand("tempoonline").setExecutor(new ComandoTempoOnline());
		getCommand("skills").setExecutor(new ComandoSkills());
		getCommand("spawn").setExecutor(new ComandoSpawn());
		getCommand("vip").setExecutor(new ComandoVip());
		getCommand("setspawn").setExecutor(new ComandoSetSpawn());
		getCommand("setarmob").setExecutor(new ComandoSetarMob());
		
		getCommand("espadas").setExecutor(new ComandoEspadas());
		getCommand("machado").setExecutor(new ComandoMachado());
		getCommand("mineracao").setExecutor(new ComandoMineracao());
		getCommand("escavacao").setExecutor(new ComandoEscavacao());
		getCommand("acrobacia").setExecutor(new ComandoAcrobacia());
		getCommand("feiticeiro").setExecutor(new ComandoFeiticeiro());

		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		Bukkit.getPluginManager().registerEvents(new ComandoLocal(), this);
		Bukkit.getPluginManager().registerEvents(new ComandoLag(), this);
		Bukkit.getPluginManager().registerEvents(new ComandoKit(), this);
		Bukkit.getPluginManager().registerEvents(new EventosSkills(), this);
		Bukkit.getPluginManager().registerEvents(new EventosSkillsUp(), this);
		Bukkit.getPluginManager().registerEvents(new EventosSkillsHab(), this);
		Bukkit.getPluginManager().registerEvents(new ComandoSetarMob(), this);

		Mine.console("§6[SafeCore] §2Core iniciada com sucesso!");

		StorageAPI.register(Tags.class);
		StorageAPI.register(TagsManager.class);

		StorageAPI.register(Kits.class);
		StorageAPI.register(KitsManager.class);

		KitsAPI.reload();
		TagsAPI.reload();

		config = new BukkitConfig("config.yml", this);
		config.saveDefaultConfig();
		config.saveConfig();
		
		SkillsAPI.skills.saveDefaultConfig();
		
		ItemStack cajado = Mine.newItem(Material.BLAZE_ROD, "§bCajado de feiticeiro", 1, 0, " "," §7Clique com o direito para acessar o menu.");	
		
		ShapedRecipe cajadoCraft = new ShapedRecipe(cajado);
		 
		cajadoCraft.shape("@#@","$&%","@*@");
		 
		cajadoCraft.setIngredient('@', Material.ENDER_PEARL);
		cajadoCraft.setIngredient('#', Material.WOOL);
		cajadoCraft.setIngredient('$', Material.SLIME_BALL);
		cajadoCraft.setIngredient('%', Material.MAGMA_CREAM);
		cajadoCraft.setIngredient('&', Material.SPIDER_EYE);
		cajadoCraft.setIngredient('*', Material.FEATHER);
		 
		getServer().addRecipe(cajadoCraft);
		
		for(Player p : Bukkit.getOnlinePlayers()) {
		ComandoLocal.rep.put(p, "null");
		ComandoGlobal.rep.put(p, "null");
		}
	}
	public static Main getInstance() {
		return instance;
	}

}
