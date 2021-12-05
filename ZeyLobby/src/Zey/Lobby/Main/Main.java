package Zey.Lobby.Main;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Zey.Lobby.Cassino.ApostasListener;
import Zey.Lobby.Commands.ApostasCommand;
import Zey.Lobby.Commands.BuildCommand;
import Zey.Lobby.Commands.CcCommand;
import Zey.Lobby.Commands.ChatCommand;
import Zey.Lobby.Commands.DarCoinsCommand;
import Zey.Lobby.Commands.FlyCommand;
import Zey.Lobby.Commands.GmCommand;
import Zey.Lobby.Commands.PingCommand;
import Zey.Lobby.Commands.SetGroupCommand;
import Zey.Lobby.Commands.SetVipCommand;
import Zey.Lobby.Commands.TagCommand;
import Zey.Lobby.Config.MyConfigManager;
import Zey.Lobby.Config.ZeyCoins;
import Zey.Lobby.Eventos.AbrirMenus;
import Zey.Lobby.Eventos.AntFlood;
import Zey.Lobby.Eventos.ChatEvent;
import Zey.Lobby.Eventos.Entrar;
import Zey.Lobby.Eventos.Geral;
import Zey.Lobby.Menus.MenuServidores;
import Zey.Lobby.Menus.SalasHG;
import Zey.Lobby.Utils.TabPersonalizado;
import Zey.Scoreboard.PlayerListener;
import Zey.Scoreboard.SManager;

@SuppressWarnings("all")
public class Main extends JavaPlugin
{

public static MyConfigManager manager;
public static ArrayList<String> score = new ArrayList();


public static String prefix;
public static Plugin plugin;
public static String motd;
public static String motd2;
public static Main instance;
public static Main getInstace() {
	return instance;
}

public static Main getPlugin() {
    return (Main)JavaPlugin.getProvidingPlugin((Class<?>)Main.class);
}
public static Plugin Plugin()
{
  return plugin;
}

  public void onEnable()
  {
	  Bukkit.getMessenger().registerOutgoingPluginChannel((Plugin)this, "BungeeCord");
	  instance = this;
	  instance = this;
      SManager.onEnable();
      this.getServer().getPluginManager().registerEvents((Listener)new PlayerListener(), (Plugin)this);
      
      try {
          saveDefaultConfig();
        }
        catch (Exception localException) {
        }
      
      prefix = ("&6&lZey&f&lNetwork").replace("&", "§");
      motd = ("&6&lZey&f&lNetwork §7(1.7, 1.8) \n§e§lRede de servidores, Lobby - 1.").replace("&", "§");
      motd2 = ("&6&lZey&f&lNetwork §7(1.7, 1.8) \n§c§lEstamos em manutenção.").replace("&", "§");
      
    ConsoleCommandSender e = Bukkit.getConsoleSender();
    e.sendMessage("§a§m------------------------------");
    e.sendMessage("§a- ZeyLobby Iniciado Com Sucesso!  -");
    e.sendMessage("§a§m------------------------------");
    
    manager = new MyConfigManager(this);
    ZeyCoins.loadMoneyManager();
    Eventos();
    Comandos();
  }
  
  public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
      if (!(sender instanceof Player)) {
          return false;
      }
      if (args.length == 0) {
          return false;
      }
      final Player p = (Player)sender;
      final ByteArrayOutputStream b = new ByteArrayOutputStream();
      final DataOutputStream out = new DataOutputStream(b);
      try {
          out.writeUTF("Connect");
          out.writeUTF(args[0]);
      }
      catch (IOException ex) {}
      p.sendPluginMessage((Plugin)this, "BungeeCord", b.toByteArray());
      return true;
  }

  public void onDisable()
  {
    ConsoleCommandSender e = Bukkit.getConsoleSender();
    e.sendMessage("§c§m------------------------------");
    e.sendMessage("§c- ZeyLobby Desativado Com Sucesso! -");
    e.sendMessage("§c§m------------------------------");
  }

  public void Eventos()
  {
    PluginManager Eventos = Bukkit.getPluginManager();
    Eventos.registerEvents(new GmCommand(this), this);
    Eventos.registerEvents(new DarCoinsCommand(), this);
    Eventos.registerEvents(new BuildCommand(), this);
    Eventos.registerEvents(new ChatCommand(this), this);
    Eventos.registerEvents(new CcCommand(this), this);
    Eventos.registerEvents(new PingCommand(), this);
    Eventos.registerEvents(new TabPersonalizado(this), this);
    Eventos.registerEvents(new Geral(), this);
    Eventos.registerEvents(new ChatEvent(), this);
    Eventos.registerEvents(new Entrar(), this);
    Eventos.registerEvents(new MenuServidores(), this);
    Eventos.registerEvents(new SalasHG(), this);
    Eventos.registerEvents(new AbrirMenus(), this);
    Eventos.registerEvents(new ApostasListener(), this);
    Eventos.registerEvents(new AntFlood(this), this);
  }

  void Comandos()
  {
	  getCommand("gm").setExecutor(new GmCommand(this));
	  getCommand("build").setExecutor(new BuildCommand());
	  getCommand("darcoins").setExecutor(new DarCoinsCommand());
	  getCommand("chat").setExecutor(new ChatCommand(this));
	  getCommand("cc").setExecutor(new CcCommand(this));
	  getCommand("ping").setExecutor(new PingCommand());
	  getCommand("tag").setExecutor(new TagCommand());
	  getCommand("spawnapostas").setExecutor(new ApostasCommand());
      getCommand("fly").setExecutor(new FlyCommand());
      getCommand("setgroup").setExecutor(new SetGroupCommand());
      getCommand("setvip").setExecutor(new SetVipCommand());
  }
}
