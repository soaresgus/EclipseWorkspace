package me.ninjay.safecore.utils;

public interface ServerMessageHandler {

	public void onMessage(String server, String tag, String line);

}
