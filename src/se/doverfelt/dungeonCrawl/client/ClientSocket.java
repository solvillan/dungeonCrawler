package se.doverfelt.dungeonCrawl.client;

//Remember: Link to guide!
//http://edn.embarcadero.com/article/31995

import java.net.*;
import java.io.*;

import org.newdawn.slick.util.Log;

public class ClientSocket {
	
	public ClientSocket(String host) {
		
		int port = 1998;
		
	    Log.info("Client socket initialized");
	    
	    try {
	    	InetAddress address = InetAddress.getByName(host);
	    	
	    	Socket connection = new Socket(address, port);
	    	
	    	BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
	    	
	    	OutputStreamWriter osw = new OutputStreamWriter(bos);
	    	
	    } catch
		
	}
	
}
