package Zey.Lobby.APIs;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class BungeeServerConnect extends JavaPlugin{
	@Override
	public void onEnable() {
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		// TODO Auto-generated method stub
		if(sender instanceof Player){
			if(args.length == 0){
				return false;
			}
			
			Player p = (Player)sender;
			
			ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(b);
            try {
                out.writeUTF("Connect");
                out.writeUTF(args[0]);
            } catch (IOException ex) {
                // Impossible
            }
			
			p.sendPluginMessage(this, "BungeeCord", b.toByteArray());
			return true;
		}
		
		return false;
	}
}
