package me.ninjay.safecash.utils;

public interface ServerMessageHandler {
	
	public void onMessage(String server,String tag, String line);
	

}