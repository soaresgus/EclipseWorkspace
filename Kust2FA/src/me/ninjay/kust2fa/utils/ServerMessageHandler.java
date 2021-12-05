package me.ninjay.kust2fa.utils;

public interface ServerMessageHandler {
	
	public void onMessage(String server,String tag, String line);
	

}
