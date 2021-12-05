package me.ninjay.bungee;


import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ComandoPing extends Command{

	public ComandoPing() {
		super("ping");
	}
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer) sender;
			int ping = p.getPing();
			p.sendMessage("§aSeu Ping: "+ping);
		}
	}

}
