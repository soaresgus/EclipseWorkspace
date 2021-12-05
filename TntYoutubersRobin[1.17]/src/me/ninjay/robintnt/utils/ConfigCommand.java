
package me.ninjay.robintnt.utils;


public class ConfigCommand extends CommandManager {

	public ConfigCommand() {
		super("config");
		
		register(new ConfigSaveCommand());
		register(new ConfigReloadCommand());
		register(new ConfigHelpCommand());
	}

}
